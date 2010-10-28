/**
 * 
 */
package com.sap.furcas.test.parsing.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.antlr.Tool;
import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.GrammarGenerationException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sun.tools.javac.Main;

/**
 *
 */
public class ParserGenerationTestHelper {

    private static final String DEFAULT_GENERATIONDIR_SOURCEROOT = "./scenariotestTemp";
    private static final String DEFAULT_PACKAGE = "generated2";
    private static final String DEFAULT_GENERATIONDIR = DEFAULT_GENERATIONDIR_SOURCEROOT + "/" + DEFAULT_PACKAGE + "/";
    private static final String DEFAULT_TCSPATH = "./scenarioTestResource";

    private final String generationSourceRoot;
    private String generationDirectory;
    private String generationPackage;
    private String tcsPath;
    private boolean ignoreExistCheck = false;

    private static ParserGenerationTestHelper defaultInstance = new ParserGenerationTestHelper();

    /*
     * Default constructor, generates files in
     * GENERATIONDIR_SOURCEROOT/generated
     */
    private ParserGenerationTestHelper() {
	generationSourceRoot = DEFAULT_GENERATIONDIR_SOURCEROOT;
	generationDirectory = DEFAULT_GENERATIONDIR;
	generationPackage = DEFAULT_PACKAGE;
	tcsPath = DEFAULT_TCSPATH;
    }

    public ParserGenerationTestHelper(String tcsPath, String generationSourceRoot, String generationPath,
	    String generationPackage, boolean ignoreExistCheck) {

	this.generationSourceRoot = generationSourceRoot;
	this.generationPackage = generationPackage;
	this.generationDirectory = generationPath + "/";
	this.tcsPath = tcsPath;
	this.ignoreExistCheck = ignoreExistCheck;
    }

    public ParserGenerationTestHelper(String soureRoot, List<String> packagePath, boolean ignoreExistCheck) {
	if (soureRoot == null || packagePath == null) {
	    throw new IllegalArgumentException(soureRoot + ", " + packagePath);
	}
	this.ignoreExistCheck = ignoreExistCheck;

	generationSourceRoot = soureRoot;

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

    public File getGrammarFile(String language) {
	return new File(generationDirectory + language + ".g");
    }

    public File getGenerationDir() {
	return new File(generationDirectory);
    }

    public void generateParserClasses(String languageName) {

	if (!ignoreExistCheck) {
	    boolean found = false;
	    // check classes don't exist
	    try {
		String lexerClassName = languageName + "Lexer";
		String parserClassName = languageName + "Parser";

		Class.forName(generationPackage + "." + lexerClassName);
		Class.forName(generationPackage + "." + parserClassName);
		found = true;
	    } catch (ClassNotFoundException e) {
		// thats fine
	    }

	    if (found) {
		System.out.println("Not generating parser and lexer classes for language " + languageName
			+ " as parser and jexer already exist on the classpath in package " + generationPackage);
		return;
	    }
	}

	// Execute ANTRL3 to generate Java from Grammar
	String[] args = new String[1];
	args[0] = generationDirectory + languageName + ".g";
	// args[1] = "-o";
	// args[2] = "ANTLR_Test.classpath";
	Tool antlr = new Tool(args);
	antlr.process();
    }

    public void generateParserFactoryClasses(String languageName, String completeMetamodelPackageName) {
	String lexerClassName = languageName + "Lexer";
	String parserClassName = languageName + "Parser";

	// also generate matching ParserFactory
	try {
	    PrintStream out = new PrintStream(new FileOutputStream(new File(generationDirectory + languageName
		    + "ParserFactory.java")));

	    out.println("package " + generationPackage + ";");

	    out.println("import " + generationPackage + "." + lexerClassName + ";");
	    out.println("import " + generationPackage + "." + parserClassName + ";");

	    out.println("import com.sap.ide.cts.moin.parserfactory.AbstractParserFactory;");
	    out.println("import com.sap.tc.moin.repository.Connection;");
	    out.println("import com.sap.tc.moin.repository.mmi.reflect.RefPackage;");

	    out.println("public class " + languageName + "ParserFactory extends AbstractParserFactory<" + parserClassName + ", "
		    + lexerClassName + "> { ");

	    out.println("	private static final String CLASS_LANGUAGE_ID = \"" + languageName + "\"; ");

	    out.println("	@Override");
	    out.println("    public Integer[] getOmittedTokensForFormatting() {");
	    out.println("	return new Integer[]{" + parserClassName + ".WS, " + parserClassName + ".NL};");
	    out.println("    }");
	    out.println("	@Override");
	    out.println("    public String[] getHiddenChannelTokenNames() {");
	    out.println("	return new String[] { \"WS\", \"NL\", \"COMMENT\" };");
	    out.println("    }");

	    out.println("	@Override ");
	    out.println("	public Class<" + lexerClassName + "> getLexerClass() { ");
	    out.println("		return " + lexerClassName + ".class;");
	    out.println("	} ");

	    out.println("	@Override ");
	    out.println("	public Class<" + parserClassName + "> getParserClass() { ");
	    out.println("		return " + parserClassName + ".class;");
	    out.println("	} ");

	    out.println("	@Override ");
	    out.println("	public String getLanguageId() { ");
	    out.println("		return CLASS_LANGUAGE_ID;");
	    out.println("	}");

	    out.println("	@Override");
	    out.println("	public " + completeMetamodelPackageName + " getMetamodelPackage(Connection connection) {");
	    out.println("	    " + completeMetamodelPackageName + " pck = connection.getPackage(" + completeMetamodelPackageName
		    + ".PACKAGE_DESCRIPTOR);");
	    out.println("		return pck;");
	    out.println("	} ");

	    out.println("}");

	    out.flush();

	} catch (FileNotFoundException e) {
	    System.out.println("error generating ParserFactory for language: " + languageName);
	    e.printStackTrace();
	}

    }

    public int compileParser(String languageName) {
	// compile generated Java
	int success = Main.compile(new String[] {
		generationDirectory + languageName + "Lexer.java",
		generationDirectory + languageName + "Parser.java",
		"-cp",
		System.getProperty("antlr.lib.dir") + File.pathSeparator + "../com.sap.furcas.runtime.parser/bin"
			+ File.pathSeparator + "../com.sap.furcas.runtime.common/bin" + File.pathSeparator
			+ "../com.sap.furcas.parsergenerator.emf/bin" });

	return success;
    }

//    public int compileParserFactory(String languageName, String metamodelProjectName) {
//	// compile generated Java
//
//	int success = Main.compile(new String[] {
//		generationDirectory + languageName + "ParserFactory.java",
//		"-cp",
//		generationSourceRoot + File.pathSeparator + "../" + metamodelProjectName + "/bin" + File.pathSeparator
//			+ getSourceRoot(AbstractParserFactory.class) + File.pathSeparator + getSourceRoot(ResourceSet.class)
//			+ File.pathSeparator + getSourceRoot(ANTLRParserFactory.class) + File.pathSeparator
//			+ getSourceRoot(ITokenFactory.class) + File.pathSeparator + getSourceRoot(RuleNameFinder.class)
//			+ File.pathSeparator + getSourceRoot(IModelElementProxy.class) + File.pathSeparator
//			+ getSourceRoot(Lexer.class) });
//
//	return success;
//    }

    public String getSourceRoot(Class<?> c) {
	try {
	    return new File(URLDecoder.decode(c.getProtectionDomain().getCodeSource().getLocation().getPath(), "UTF-8"))
		    .getCanonicalPath();
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
    }

    public ModelParsingResult parseStream(String languageName, InputStream in, IModelAdapter modelAdapter) throws IOException,
	    UnknownProductionRuleException, InvalidParserImplementationException {

	ParserFacade facade = getFacade(languageName);

	ModelParsingResult result = facade.parseProductionRule(in, modelAdapter, /*
										  * use
										  * main
										  * rule
										  */null, null, null);
	return result;
    }

    public ParserFacade getFacade(String languageName) throws InvalidParserImplementationException {
	// try loading compiled classes
	File genDir = new File(generationDirectory);
	try {
	    @SuppressWarnings("unchecked")
	    Class<? extends Lexer> lexerclass = (Class<? extends Lexer>) Class.forName(generationPackage + "." + languageName + "Lexer");
	    @SuppressWarnings("unchecked")
	    Class<? extends ObservableInjectingParser> parserclass = (Class<? extends ObservableInjectingParser>) Class.forName(generationPackage + "." + languageName + "Parser");

	    ParserFacade facade = new ParserFacade(parserclass, lexerclass);
	    return facade;

	} catch (ClassNotFoundException cnfe) { // catching from Class.forName
	    throw new RuntimeException("Can't find generated classes at runtime in " + genDir.getAbsolutePath()
		    + ", check you meant language " + languageName + " or maybe do an Eclipse refresh on project.", cnfe);
	}

    }

//    public Class<AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>> getParserFactoryClass(
//	    String languageName) {
//	// try loading compiled classes
//	File genDir = new File(generationDirectory);
//	try {
//	    Class<?> parserFactoryClass = Class.forName(generationPackage + "." + languageName + "ParserFactory");
//
//	    return (Class<AbstractParserFactory<? extends ObservableInjectingParser, ? extends Lexer>>) parserFactoryClass;
//
//	} catch (ClassNotFoundException cnfe) { // catching from Class.forName
//	    throw new RuntimeException("Can't find generated classes at runtime in " + genDir.getAbsolutePath()
//		    + ", check you meant language " + languageName + " or maybe do an Eclipse refresh on project.", cnfe);
//	}
//    }

    public final void generateParserGrammar(String language, IMetaModelLookup<?> lookup, ResourceSet connection,
	    Set<URI> partitions) throws FileNotFoundException, ModelAdapterException, GrammarGenerationException, IOException {

	File grammarFile = getGrammarFile(language);

	File syntaxDefFile = new File(tcsPath + "/" + language + ".tcs");

	Collection<String> warnings = GrammarWritingHelper.writeGrammarIfChanged(lookup, syntaxDefFile, grammarFile, "::",
		generationPackage, connection, partitions);
	for (String string : warnings) {
	    System.out.println(string);
	}

    }

    /**
     * @return the defaultInstance
     */
    public static ParserGenerationTestHelper getDefault() {
	return defaultInstance;
    }

}
