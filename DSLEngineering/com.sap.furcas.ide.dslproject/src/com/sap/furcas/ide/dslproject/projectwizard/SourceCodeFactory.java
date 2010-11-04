package com.sap.furcas.ide.dslproject.projectwizard;

/**
 * 
 * Encapsulates all methods providing source code needed in the process 
 * of creating a new DSL with the {@link TCSProjectsWizard}.
 * All information needed for the generic source code generation is retrieved
 * from the associated {@link ProjectInfo}.
 * 
 * @author C5126086 Martin Kuester
 *
 */
public class SourceCodeFactory {

	protected static String createEditorCode(ProjectInfo pi) {
		String ret = "";
		String capLangName = ProjectCreator.capitalizeFirstChar(pi.getLanguageName());
		
		ret += "package " + pi.getBasePackage() + ".editor; \n\n"
				+ "import textblocks.TextBlock; \n\n"
				+ "import " + pi.getBasePackage() + ".parser." + capLangName
						+ "ParserFactory; \n"
				+ "import com.sap.ide.cts.editor.AbstractGrammarBasedEditor; \n"
				+ "import com.sap.ide.cts.parser.errorhandling.SemanticParserException; \n"
				+ "import com.sap.tc.moin.repository.Connection; \n\n"
				
				+ "public class " + capLangName + 
						"Editor extends AbstractGrammarBasedEditor { \n\n"
				+ "\tpublic " + capLangName + "Editor() { \n"
				+ "\t\tsuper(new " + capLangName +
						"ParserFactory(), new " + capLangName +
						"Mapper()); \n"
				+ "\t} \n\n"
				
				+ "\t@Override \n"
				+ "\tpublic TextBlock parse(TextBlock rootBlock) throws SemanticParserException { \n"
				+ "\t\tConnection connection = getWorkingConnection();\n"
				+ "\t\tinitializeNewParser(connection);\n"
				+ "\t\tTextBlock newRoot =  super.parse(rootBlock); \n"
				+ "\t\treturn newRoot; \n"
				+ "\t} \n\n"
				
				+ "}";

		return ret;
	}	
	
	protected static String createMapperCode(ProjectInfo pi) {
		String ret = "";
		String capLangName = ProjectCreator.capitalizeFirstChar(pi.getLanguageName());
		
		ret += "package " + pi.getBasePackage() + ".editor; \n\n"
		
				+ "import generated." + capLangName + "Lexer; \n\n"
				+ "import org.antlr.runtime.Token; \n"
				+ "import org.eclipse.jface.text.TextAttribute; \n"
				+ "import org.eclipse.swt.SWT; \n"
				+ "import org.eclipse.swt.graphics.Color; \n"
				+ "import org.eclipse.swt.graphics.RGB; \n\n"
				
				+ "import com.sap.ide.cts.editor.ITokenMapper; \n\n"
				
				+ "public class " + capLangName + 
						"Mapper implements ITokenMapper { \n\n"
				+ "\tpublic Object mapColor(Token t) { \n"
				+ "\t\tswitch (t.getType()) { \n"
				+ "\t\t\tdefault: \n"
				+ "\t\t\t\treturn new TextAttribute(new Color(null, new RGB(200, 0, 180)), null, SWT.BOLD); \n"
				+ "\t\t} \n"
				+ "\t} \n"
				+ "} \n"
				
				;

		return ret;
	}
	
	
	
	protected static String createActivator(ProjectInfo pi)  {
		String ret = "";
		ret += "package " + pi.getBasePackage() + ".editor; \n\n"
			+ "import org.eclipse.ui.plugin.AbstractUIPlugin; \n"
			+ "import org.osgi.framework.BundleContext; \n\n"
			+ "public class Activator extends AbstractUIPlugin { \n\n" 
			+ "\t// The plug-in ID \n"
			+ "\tpublic static final String PLUGIN_ID = \"" + pi.getBasePackage() + "\"; \n\n"
			+ "\t// The shared instance \n" 
			+ "\tprivate static Activator plugin; \n\n"
			+ "\tpublic Activator() {} \n\n"
			+ "\tpublic void start(BundleContext context) throws Exception {\n"
			+ "\t\tsuper.start(context);\n"
			+ "\t\tplugin = this;\n"
			+ "\t} \n\n"
			+ "\tpublic void stop(BundleContext context) throws Exception {\n"
			+ "\t\tplugin = null; \n"
			+ "\t\tsuper.stop(context); \n"
			+ "\t} \n\n"
			+ "\tpublic static Activator getDefault() { \n\n"
			+ "\n\nreturn plugin;\n"
			+ "\t}\n\n"
			
			+ "}"
			;

		return ret ;
	}
	
	
	protected static String createPluginXML(ProjectInfo pi) {
		String capLangName = ProjectCreator.capitalizeFirstChar(pi.getLanguageName());
		
		String editorName = pi.getBasePackage() + ".editor." + capLangName + "Editor";
		String ret = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" 
			+ "<?eclipse version=\"3.4\"?> \n"
			+ "<plugin> \n"
			+ "\t<extension point=\"org.eclipse.ui.editors\"> \n"
			+ "\t\t<editor \n"
			+ "\t\t\tclass=\"" 
					 + editorName +
					"\"\n"
			+ "\t\t\textensions=\"act\" \n"
//			+ "\t\t\ticon=\"resources/icons/change_view_action.gif\" \n"
            + "\t\t\tid=\"" 
            		+ editorName +
            		"\" \n" 
            + "\t\t\tname=\"" +
            		capLangName + " Editor" +
             		"\"> \n"
            + "\t\t</editor> \n"
            + "\t</extension> \n \n"
            +	" <extension point=\"com.sap.tc.moin.incubation.contentprovider.Content\">  \n" 
            +	"   <ContentDefinition>  \n" 
            +	"		<Path   \n" 
            +	"			Value=\"mappings\"  \n" 
            + 	" 			Versioned=\"true\">  \n" 
            +	"		</Path>  \n" 
            + 	"	</ContentDefinition>  \n" 
            +	" </extension> \n" 
            +	"</plugin> \n";
		return ret;
	}
	
	protected static String createdPropertiesCode(ProjectInfo pi) {
		String props = 
			"core.project.name=" + pi.getProjectName() + "\n"
			+ "grammar=./"+ProjectCreator.ORIGINAL_FILE_LOCATION_ROOT+"/" + pi.getBasePath() +'/'+ pi.getTCSFileName() + "\n"
			+ "debug.grammar=true\n"
			+ "language.name=" + pi.getLanguageName() + "\n"
			+ "language.nsURI=" + pi.getNsURI() + "\n"
			+ "language.fileextension=" + pi.getFileExtension() + "\n"
			+ "basepath=" + pi.getBasePath() + "\n"
			+ "moinMetaWrapperPlugin=replaceMeInGenerateProperties\r\n" 
			+ "moinMetaPackageFullQualified=replaceMeInGenerateProperties"+ "\n";
		return props;
	}
	
	protected static String createSampleTCS(ProjectInfo pi) {
		// creates contents for a sample TCS file  
		String templateString = 
			//                "--Before you start, please select this project, properties, go to DSL Mon Metamodel, and refer to a Metamodel!\r\n" +
			//                "\r\n" +
			"--specify your DSL grammar rules here ...\r\n\r\n" +
			"syntax " + pi.getLanguageName() + " {\r\n" + 
			"\r\n" + 
			"  -- place templates here (at least one main template)\r\n" +
			"  primitiveTemplate identifier for String default using NAME:\r\n" + 
			"    value = \"%token%\";\r\n" + 
			"        \r\n" + 
			"  primitiveTemplate integerSymbol for Integer default using INT:\r\n" + 
			"        value = \"Integer.valueOf(%token%)\";\r\n" +
			"\r\n" +
			"  template ReplaceMe main \r\n" + 
			"  :\r\n" + 
			"  ;\r\n" +
			" \r\n" +
			"  -- place keywords here (optional, seldom used)\r\n" + 
			"\r\n" + 
			"  -- place symbols here (optional)\r\n" + 
			"\r\n" + 
			"  -- place operatorLists here (optional)\r\n" + 
			"\r\n" + 
			"  -- place tokens here (optional, except for COMMENT)\r\n" + 
			"\r\n" + 
			"  token COMMENT : endOfLine(start = \"--\");\r\n" + 
			"\r\n" + 
			"  -- place lexer here (optional)\r\n" + 
			"\r\n" + 
			"}\r\n" + 
			"  ";
		return templateString;
	}
	
	protected static String createParserFactory(ProjectInfo pi)  {
		String ret = "";
		String capLangName = ProjectCreator.capitalizeFirstChar(pi.getLanguageName());
		
		ret += "package " + pi.getBasePackage() + ".parser; \n\n"
			
			+ "import generated." + capLangName + "Lexer; \n"
			+ "import generated." + capLangName + "Parser; \n\n"
			
			+ "import java.util.Collection; \n\n"
			
			+ "import ngpm.NgpmPackage; \n\n"

			+ "import org.antlr.runtime.CharStream; \n"
			+ "import org.antlr.runtime.CommonTokenStream; \n"
			+ "import org.antlr.runtime.Token; \n"
			+ "import org.antlr.runtime.TokenStream; \n\n"

			+ "import com.sap.ide.cts.parser.incremental.antlr.ANTLRParserFactory; \n"
			+ "import com.sap.mi.textual.grammar.InjectionOptionsBean; \n"
			+ "import com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken; \n"
			+ "import com.sap.mi.textual.grammar.antlr3.ITokenFactory; \n"
			+ "import com.sap.mi.textual.grammar.impl.ModelInjector; \n"
			+ "import com.sap.mi.textual.parsing.textblocks.ITextBlocksTokenStream; \n"
			+ "import com.sap.mi.textual.parsing.textblocks.TcsUtil; \n"
			+ "import com.sap.mi.textual.parsing.textblocks.TextBlocksAwareModelAdapter; \n"
			+ "import com.sap.mi.textual.parsing.textblocks.observer.ParserTextBlocksHandler; \n"
			+ "import com.sap.tc.moin.repository.CRI; \n"
			+ "import com.sap.tc.moin.repository.Connection; \n"
			+ "import com.sap.tc.moin.repository.PRI; \n"
			+ "import com.sap.tc.moin.repository.Partitionable; \n"
			+ "import com.sap.tc.moin.textual.moinadapter.adapter.MOINModelAdapter; \n\n"
			
			+ "public class " + capLangName + "ParserFactory " +
					"extends ANTLRParserFactory<" + capLangName + "Parser, " + capLangName + "Lexer> { \n\n" 
			+ "\tprivate static final String CLASS_LANGUAGE_ID = \"" + capLangName + "\"; \n\n"

			+ "\t@Override \n"
			+ "\tpublic " + capLangName + "Parser createParser(TokenStream input, Connection connection) { \n"
			+ "\t\treturn createParser(input, connection, null);\n"
			+ "\t} \n\n"
			
			+ "\t@Override \n"
			+ "\tpublic " + capLangName + "Parser createParser(TokenStream input, Connection connection, Collection<PRI> scope) { \n"
			+ "\t\t" + capLangName + "Parser parser = new " + capLangName + "Parser(input); \n"
			+ "\t\tif(input instanceof CommonTokenStream) { \n"
			+ "\t\t\t((CommonTokenStream) input).setTokenTypeChannel(" + capLangName + "Parser.WS, Token.HIDDEN_CHANNEL); \n"
			+ "\t\t\t((CommonTokenStream) input).setTokenTypeChannel(" + capLangName + "Parser.NL, Token.HIDDEN_CHANNEL); \n"
			+ "\t\t\t((CommonTokenStream) input).setTokenTypeChannel(" + capLangName + "Parser.COMMENT, Token.HIDDEN_CHANNEL); \n"
			+ "\t\t} \n"
			
			+ "\t\tNgpmPackage ngpmPackage = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR); \n"
			+ "\t\tTextBlocksAwareModelAdapter ma = new TextBlocksAwareModelAdapter(new MOINModelAdapter(ngpmPackage, connection, scope)); \n"
			+ "\t\tModelInjector mi = new ModelInjector(parser.getTokenNames()); \n"
			+ "\t\tInjectionOptionsBean injectionOptionsBean = new InjectionOptionsBean(); \n"
			+ "\t\tinjectionOptionsBean.setLocationsPropertyNameInModel(false, null); \n"
			+ "\t\tmi.setOptions(injectionOptionsBean); \n"
			+ "\t\tmi.setModelAdapter(ma); \n"
			+ "\t\tparser.setInjector(mi); \n"
			+ "\t\tif (input instanceof ITextBlocksTokenStream) { \n"
			+ "\t\t\tma.setTextBlocksStream((ITextBlocksTokenStream) input); \n"
			+ "\t\t\tparser.setObserver(new ParserTextBlocksHandler( \n"
			+ "\t\t\t\t(ITextBlocksTokenStream) input, \n"
			+ "\t\t\t\tconnection, \n"
			+ "\t\t\t\tgetMetamodelCri(connection), \n"
			+ "\t\t\t\tTcsUtil.getSyntaxePartitions(connection, getLanguageId()))); \n"
			+ "\t\t} \n"
			+ "\t\treturn parser;\n"
			+ "\t} \n\n"		

			+ "\t@Override \n"
			+ "\tpublic " + capLangName + "Lexer createLexer(CharStream input) { \n"
			+ "\t\treturn new " + capLangName + "Lexer(input);\n"
			+ "\t} \n\n"
			
			+ "\t@Override \n"
			+ "\tpublic " + capLangName + "Lexer createLexer(CharStream input, ITokenFactory<? \n" +
					"\t\t\textends ANTLR3LocationToken> factory) { \n"
			+ "\t" + capLangName + "Lexer lex = new " + capLangName + "Lexer(input);\n"
			+ "\t\tlex.tokenFactory = factory;\n"
			+ "\t\treturn lex;\n"
			+ "\t} \n\n"
			
			+ "\t@Override \n"
			+ "\tpublic Class<" + capLangName + "Lexer> getLexerClass() { \n"
			+ "\t\treturn " + capLangName + "Lexer.class;\n"
			+ "\t} \n\n"
			
			+ "\t@Override \n"
			+ "\tpublic Class<" + capLangName + "Parser> getParserClass() { \n"
			+ "\t\treturn " + capLangName + "Parser.class;\n"
			+ "\t} \n\n"

			+ "\t@Override \n"
			+ "\tpublic CRI getMetamodelCri(Connection connection) { \n"
			+ "\t\tNgpmPackage ngpmPackage = connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR);\n"
			+ "\t\treturn ((Partitionable)ngpmPackage.refMetaObject()).get___Mri().getCri();\n"
			+ "\t} \n\n"
			
			+ "\t@Override \n"
			+ "\tpublic String getLanguageId() { \n"
			+ "\t\treturn CLASS_LANGUAGE_ID;\n"
			+ "\t} \n\n"
			
			+ "}"
			;

		return ret ;
	}
}
