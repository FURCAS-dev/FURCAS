/**
 * 
 */
package com.sap.furcas.runtime.parser.incremental;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.List;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.ide.parserfactory.AbstractParserFactory;
import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;
import com.sap.furcas.runtime.parser.antlr3.ITokenFactory;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import com.sap.ide.cts.parser.incremental.antlr.ANTLRParserFactory;
import com.sun.tools.javac.Main;

/**
 *
 */
public class ParserGenerationTestHelper {

	private static final String DEFAULT_GENERATIONDIR_SOURCEROOT = "./scenariotestTemp";
	private static final String DEFAULT_PACKAGE = "generated2";
	private static final String DEFAULT_GENERATIONDIR = DEFAULT_GENERATIONDIR_SOURCEROOT
			+ "/" + DEFAULT_PACKAGE + "/";

	private final String generationSourceRoot;
	private String generationDirectory;
	private String generationPackage;

	private static ParserGenerationTestHelper defaultInstance = new ParserGenerationTestHelper();

	/*
	 * Default constructor, generates files in
	 * GENERATIONDIR_SOURCEROOT/generated
	 */
	private ParserGenerationTestHelper() {
		generationSourceRoot = DEFAULT_GENERATIONDIR_SOURCEROOT;
		generationDirectory = DEFAULT_GENERATIONDIR;
		generationPackage = DEFAULT_PACKAGE;
	}

	public ParserGenerationTestHelper(String sourceRoot,
			List<String> packagePath, boolean ignoreExistCheck) {
		if (sourceRoot == null || packagePath == null) {
			throw new IllegalArgumentException(sourceRoot + ", " + packagePath);
		}

		generationSourceRoot = sourceRoot;

		if (packagePath.size() > 0) {
			generationPackage = packagePath.get(0);
			for (int i = 1; i < packagePath.size(); i++) {
				generationPackage += '.' + packagePath.get(i);
			}
		} else {
			generationPackage = "";
		}

		generationDirectory = generationSourceRoot + '/';
		if (packagePath.size() > 0) {
			for (String packagePathPart : packagePath) {
				generationDirectory += packagePathPart + '/';
			}
		}
	}

	public void generateParserFactoryClasses(String languageName,
			String completeMetamodelPackageName) {
		String lexerClassName = languageName + "Lexer";
		String parserClassName = languageName + "Parser";

		// also generate matching ParserFactory
		try {
			File parserFactoryFile = new File(generationDirectory
					+ languageName + "ParserFactory.java");
			if (!parserFactoryFile.exists()) {
				try {
					parserFactoryFile.getParentFile().mkdirs();
					parserFactoryFile.createNewFile();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			PrintStream out = new PrintStream(new FileOutputStream(
					parserFactoryFile));

			out.println("package " + generationPackage + ";");

			out.println("import " + generationPackage + "." + lexerClassName
					+ ";");
			out.println("import " + generationPackage + "." + parserClassName
					+ ";");

			out.println("import com.sap.furcas.ide.parserfactory.AbstractParserFactory;");
			out.println("import org.eclipse.emf.ecore.resource.ResourceSet;");
			out.println("import org.eclipse.emf.ecore.EPackage;");

			out.println("public class " + languageName
					+ "ParserFactory extends AbstractParserFactory<"
					+ parserClassName + ", " + lexerClassName + "> { ");

			out.println("	private static final String CLASS_LANGUAGE_ID = \""
					+ languageName + "\"; ");

			out.println("	@Override");
			out.println("    public String[] getHiddenChannelTokenNames() {");
			out.println("	return new String[] { \"WS\", \"NL\", \"COMMENT\" };");
			out.println("    }");

			out.println("	@Override ");
			out.println("	public Class<" + lexerClassName
					+ "> getLexerClass() { ");
			out.println("		return " + lexerClassName + ".class;");
			out.println("	} ");

			out.println("	@Override ");
			out.println("	public Class<" + parserClassName
					+ "> getParserClass() { ");
			out.println("		return " + parserClassName + ".class;");
			out.println("	} ");

			out.println("	@Override ");
			out.println("	public String getLanguageId() { ");
			out.println("		return CLASS_LANGUAGE_ID;");
			out.println("	}");

			out.println("	@Override");
			out.println("	public EPackage"
					+ " getMetamodelPackage(ResourceSet connection) {");
			out.println("	    EPackage pck = EPackage.Registry.INSTANCE.getEPackage(\"" + completeMetamodelPackageName + "\");");
			out.println("		return pck;");
			out.println("	} ");

			out.println("}");

			out.flush();

		} catch (FileNotFoundException e) {
			System.out.println("error generating ParserFactory for language: "
					+ languageName);
			e.printStackTrace();
		}

	}

	public int compileParserFactory(String languageName,
			String metamodelProjectName) {
		// compile generated Java

		int success = Main.compile(new String[] {
				generationDirectory + languageName + "ParserFactory.java",
				"-cp",
				generationSourceRoot + File.separator + ".." + File.separator + File.pathSeparator +
				generationSourceRoot + File.pathSeparator + "../"
						+ metamodelProjectName + "/bin" + File.pathSeparator
						+ getSourceRoot(AbstractParserFactory.class)
						+ File.pathSeparator + getSourceRoot(ResourceSet.class)
						+ File.pathSeparator + getSourceRoot(Notifier.class)
						+ File.pathSeparator
						+ getSourceRoot(ANTLRParserFactory.class)
						+ File.pathSeparator
						+ getSourceRoot(ITokenFactory.class)
						+ File.pathSeparator
						+ getSourceRoot(RuleNameFinder.class)
						+ File.pathSeparator
						+ getSourceRoot(IModelElementProxy.class)
						+ File.pathSeparator + getSourceRoot(Lexer.class) });

		return success;
	}

	public String getSourceRoot(Class<?> c) {
		try {
			String classContainerPath = URLDecoder.decode(c.getProtectionDomain()
					.getCodeSource().getLocation().getPath(), "UTF-8");
			if(!classContainerPath.endsWith(".jar")) {
				classContainerPath += "bin/";
			}
					
			return new File(classContainerPath) 
					.getCanonicalPath();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public Class<AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>> getParserFactoryClass(
			String languageName) {
		// try loading compiled classes
		File genDir = new File(generationDirectory);
		try {
			Class<?> parserFactoryClass = Class.forName(generationPackage + "."
					+ languageName + "ParserFactory");

			return (Class<AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>>) parserFactoryClass;

		} catch (ClassNotFoundException cnfe) { // catching from Class.forName
			throw new RuntimeException(
					"Can't find generated classes at runtime in "
							+ genDir.getAbsolutePath()
							+ ", check you meant language " + languageName
							+ " or maybe do an Eclipse refresh on project.",
					cnfe);
		}
	}

	/**
	 * @return the defaultInstance
	 */
	public static ParserGenerationTestHelper getDefault() {
		return defaultInstance;
	}

}
