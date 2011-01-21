/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-10-14 14:21:35 +0200 (Mi, 14 Okt 2009) $
 * @version $Revision: 8347 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntaxImport;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ImportDeclaration;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.RequiredInterfaceTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Configuration;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.InterfaceconfigurationFactory;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.impl.InterfaceconfigurationPackageImpl;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBeanWithConfig;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.rules.SymbolProductionRule;
import com.sap.furcas.parsergenerator.tcs.t2m.validation.SyntaxDefinitionValidation;
import com.sap.furcas.parsergenerator.util.LexerStringMemberExtractor;
import com.sap.furcas.parsergenerator.util.LexerStringMemberExtractor.InvalidLexerStringException;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.parser.TextLocation;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 * orchestrates the creation of grammar elements. This class is a facade to
 * several helper classes dealing with specific syntax elements and their
 * mappings to ANTRL3 grammar rules. For elements of a TCS Syntax definition
 * model (of a DSL Syntax), this Mapper helps writing the ANTLR3 grammar for
 * each template type.
 * 
 * @author C5107456
 */
public class ANTLRGrammarGenerator implements ImportedTemplatesReceiver {

	/** The writer. */
	private ANTLR3GrammarWriter writer;

	// elements protected to make unit testing a bit easier
	/** The alternative handler. */
	private AlternativeHandler alternativeHandler;

	/** The block handler. */
	private BlockTypeHandler blockHandler;

	/** The con el handler. */
	private ConditionalElementHandler<?> conElHandler;

	/** The property handler. */
	private PropertyTypeHandler<?> propertyHandler;

	/** The token handler. */
	private TokenHandler tokenHandler;

	/** The prim temp handler. */
	private PrimitiveTemplateHandler primTempHandler;

	/** The function temp handler. */
	private FunctionTemplateHandler<?> funcTempHandler;

	/** The class temp handler. */
	private ClassTemplateHandler<?> classTempHandler;

	/**
     * 
     */
	private EnumerationTemplateHandler<?> enumTempHandler;

	private InterfaceSpecification interfaceSpecification;

	/** The operator template handler. */
	private OperatorTemplateHandler<?> operatorTemplateHandler;

	/** The rule body factory. */
	private RuleBodyBufferFactory ruleBodyFactory;

	/** The operator handler. */
	private OperatorHandler operatorHandler;

	/** The syntax lookup. */
	private SyntaxLookup syntaxLookup;

	/** The syntax. */
	private ConcreteSyntax syntax;

	/** the list of imported syntaxes */
	private final ArrayList<ConcreteSyntax> importedSyntaxes = new ArrayList<ConcreteSyntax>();

	/** the list of imported templates */
	private final Collection<Template> importedTemplates = new HashSet<Template>();

	private Map<Object, TextLocation> locationMap;

	private SemanticErrorBucket errorBucket;

	private InjectorActionsHandler<?> actionsHandler;

	/**
	 * the list of lexers of the imported syntaxes
	 */
	private final List<String> imported_lexer_collection = new ArrayList<String>();

	/**
	 * the list of tokens of the imported syntaxes
	 */
	private Collection<Token> imported_tokens = new HashSet<Token>();

	/**
	 * the list of symbols of the imported syntaxes and templates
	 */
	private final Collection<Symbol> imported_symbols = new HashSet<Symbol>();

	private final List<Template> templateProductionRuleToGrammar = new ArrayList<Template>();

	/**
	 * the list of imported Templates
	 */
	private final Collection<Template> imported_templates = new HashSet<Template>();

	private HashSet<Template> transitiveTemplates = new HashSet<Template>();

	private HashSet<RequiredInterfaceTemplate> requiredInterfaceTemplates = new HashSet<RequiredInterfaceTemplate>();

	private HashSet<Template> requiredTemplates = new HashSet<Template>();

	private HashSet<Binding> bindings = new HashSet<Binding>();

	/**
	 * this is used to get all the transitively imported templates to avoid
	 * duplicate generation of grammar rules for transitively imported templates
	 */
	private HashSet<Template> allTransitiveTemplate = new HashSet<Template>();
	
	/**
	 * Creates an ANTLR3 grammar for the given syntax and uses the writer to
	 * write it as a String.
	 * 
	 * @param grammarWriter
	 * @param lookup
	 * @param bean
	 * @param qualifiedNamesSeparator
	 */
	private <T> void init(ANTLR3GrammarWriter grammarWriter,
			IMetaModelLookup<T> metaLookup, TCSSyntaxContainerBean syntaxbean) {
		interfaceSpecification = new InterfaceSpecification();
		// collects all errors that happen during grammar generation
		errorBucket = new SemanticErrorBucket();
		MetaModelElementResolutionHelper<T> resolutionHelper = new MetaModelElementResolutionHelper<T>(
				metaLookup);
		this.writer = grammarWriter;
		this.syntax = syntaxbean.getSyntax();
			
		if (syntax.getImports() != null && syntax.getImports().size() > 0) {
			for (ImportDeclaration importDeclaration : syntax.getImports()) {
				if (importDeclaration instanceof ConcreteSyntaxImport) {
					if (importDeclaration.isIsPartImport()) {
						importedSyntaxes.add(importDeclaration
								.getConcreteSyntax());
					} else {
						// TODO for nested Imports or binded imports recursive
						// (isPartial)
					}
				} else if (importDeclaration instanceof TemplateImport) {
					importedTemplates.add(((TemplateImport) importDeclaration)
							.getTemplate());
				}
			}
		}

		syntaxbean.setImportedTemplates(importedTemplates);
		syntaxbean.setImportedConcreteSyntaxes(importedSyntaxes);

		// null is given here as keyword list, this will be build in
		// SyntaxLookup
		this.syntaxLookup = new SyntaxLookup(syntax, importedSyntaxes,
				importedTemplates, syntaxbean.getKeywords(), resolutionHelper);
		TemplateNamingHelper<T> namingHelper = new TemplateNamingHelper<T>(
				resolutionHelper);
		this.locationMap = syntaxbean.getElementToLocationMap();

		SyntaxElementHandlerConfigurationBean<T> handlerConfig = new SyntaxElementHandlerConfigurationBean<T>(
				writer, operatorHandler, metaLookup, syntaxLookup,
				namingHelper, errorBucket, resolutionHelper);

		// rule producing handlers
		this.tokenHandler = new TokenHandler(handlerConfig);
		this.operatorTemplateHandler = new OperatorTemplateHandler<T>(
				handlerConfig);
		this.operatorHandler = new OperatorHandler(handlerConfig);
		this.primTempHandler = new PrimitiveTemplateHandler(handlerConfig);
		this.funcTempHandler = new FunctionTemplateHandler<T>(handlerConfig);

		// ruleBody producing Handlers
		this.alternativeHandler = new AlternativeHandler();
		this.blockHandler = new BlockTypeHandler();
		this.propertyHandler = new PropertyTypeHandler<T>(handlerConfig, this);
		this.conElHandler = new ConditionalElementHandler<T>(handlerConfig);
		this.classTempHandler = new ClassTemplateHandler<T>(operatorHandler,
				handlerConfig, this);
		this.enumTempHandler = new EnumerationTemplateHandler<T>(handlerConfig);

		this.actionsHandler = new InjectorActionsHandler<T>(handlerConfig);

		// factory depending on rule body producing handlers
		this.ruleBodyFactory = new RuleBodyBufferFactory(alternativeHandler,
				blockHandler, conElHandler, syntaxLookup, propertyHandler,
				namingHelper, actionsHandler, errorBucket);
	}
	
	/**
	 * Creates an ANTLR3 grammar for the given syntax and uses the writer to
	 * write it as a String.
	 * 
	 * @param grammarWriter
	 * @param lookup
	 * @param syntaxbean the bean with the configuration defined by an interface
	 * @param qualifiedNamesSeparator
	 */
	private <T> void init(ANTLR3GrammarWriter grammarWriter,
			IMetaModelLookup<T> metaLookup, TCSSyntaxContainerBeanWithConfig syntaxbean) {
		interfaceSpecification = new InterfaceSpecification();
		// collects all errors that happen during grammar generation
		errorBucket = new SemanticErrorBucket();
		HashSet<Template> resultTemplates = new HashSet<Template>();

		MetaModelElementResolutionHelper<T> resolutionHelper = new MetaModelElementResolutionHelper<T>(
				metaLookup);
		this.writer = grammarWriter;
		this.syntax = syntaxbean.getSyntax();
		if (syntax.getRequiredTemplates() != null && !syntax.getRequiredTemplates().isEmpty()) {
			requiredInterfaceTemplates.addAll(syntax.getRequiredTemplates());
			//TODO how to get the configuration elements from the tcs data 
			Configuration configuration = syntaxbean.getConfiguration();
			if (configuration != null) {
				if (configuration.getBindings() != null && !configuration.getBindings().isEmpty()) {
					//to get a list of templates from the bindings
					resultTemplates = interfaceSpecification.getTemplatesFromBinding(configuration.getBindings(), requiredInterfaceTemplates);
					if (resultTemplates != null && !resultTemplates.isEmpty()) {
						//the templates get from the bindings will be later add as imported templates
						requiredTemplates.addAll(resultTemplates); 
						
					}
				}
			}else {
				errorBucket.addWarning("they are no Configuration defined for an interface by this syntax ", syntax);
			}
		}
		
		if (syntax.getImports() != null && syntax.getImports().size() > 0) {
			for (ImportDeclaration importDeclaration : syntax.getImports()) {
				if (importDeclaration instanceof ConcreteSyntaxImport) {
					if (importDeclaration.isIsPartImport()) {
						importedSyntaxes.add(importDeclaration
								.getConcreteSyntax());
					} else {
						// TODO for nested Imports or binded imports recursive
						// (isPartial)
					}
				} else if (importDeclaration instanceof TemplateImport) {
					importedTemplates.add(((TemplateImport) importDeclaration)
							.getTemplate());
					//add the list of  templates specified by the Interface definition 
					importedTemplates.addAll(resultTemplates);
				}
			}
		}
		
		//add the templates got from the interface specification like imported templates
		importedTemplates.addAll(requiredTemplates);
		syntaxbean.setImportedTemplates(importedTemplates);
		syntaxbean.setImportedConcreteSyntaxes(importedSyntaxes);

		// null is given here as keyword list, this will be build in
		// SyntaxLookup
		this.syntaxLookup = new SyntaxLookup(syntax, importedSyntaxes,
				importedTemplates, syntaxbean.getKeywords(), resolutionHelper);
		TemplateNamingHelper<T> namingHelper = new TemplateNamingHelper<T>(
				resolutionHelper);
		this.locationMap = syntaxbean.getElementToLocationMap();

		SyntaxElementHandlerConfigurationBean<T> handlerConfig = new SyntaxElementHandlerConfigurationBean<T>(
				writer, operatorHandler, metaLookup, syntaxLookup,
				namingHelper, errorBucket, resolutionHelper);

		// rule producing handlers
		this.tokenHandler = new TokenHandler(handlerConfig);
		this.operatorTemplateHandler = new OperatorTemplateHandler<T>(
				handlerConfig);
		this.operatorHandler = new OperatorHandler(handlerConfig);
		this.primTempHandler = new PrimitiveTemplateHandler(handlerConfig);
		this.funcTempHandler = new FunctionTemplateHandler<T>(handlerConfig);

		// ruleBody producing Handlers
		this.alternativeHandler = new AlternativeHandler();
		this.blockHandler = new BlockTypeHandler();
		this.propertyHandler = new PropertyTypeHandler<T>(handlerConfig, this);
		this.conElHandler = new ConditionalElementHandler<T>(handlerConfig);
		this.classTempHandler = new ClassTemplateHandler<T>(operatorHandler,
				handlerConfig, this);
		this.enumTempHandler = new EnumerationTemplateHandler<T>(handlerConfig);

		this.actionsHandler = new InjectorActionsHandler<T>(handlerConfig);

		// factory depending on rule body producing handlers
		this.ruleBodyFactory = new RuleBodyBufferFactory(alternativeHandler,
				blockHandler, conElHandler, syntaxLookup, propertyHandler,
				namingHelper, actionsHandler, errorBucket);
	}

	/**
	 * traverses the syntax definition elements and creates grammar elements by
	 * delegating creation actions to Handlers. The result is stored in the
	 * grammar Writer that was passed in the constructor, call writer.getOuput
	 * to write get the ANTLR stream.
	 * 
	 * @return
	 * @throws MetaModelLookupException
	 * 
	 * @throws SyntaxParsingException
	 *             the syntax parsing exception
	 * @throws MetaModelLookupException
	 *             the meta model lookup exception
	 */
	public synchronized GenerationReport generateGrammar(
			ANTLR3GrammarWriter writer2, IMetaModelLookup<?> metaLookup,
			TCSSyntaxContainerBean syntaxbean,
			SyntaxDefinitionValidation validationRules,
			Class<? extends ObservableInjectingParser> parserSuperClass)
			throws MetaModelLookupException {
		boolean importsNotnull = false;
		ConcreteSyntax syntax = syntaxbean.getSyntax();
		Collection<Template> templates = new ArrayList<Template>();
		templates.addAll(syntax.getTemplates());

		init(writer2, metaLookup, syntaxbean);
		errorBucket.clear();

		if (validationRules != null) {
			validationRules.validateSyntax(syntax, metaLookup, errorBucket);
		}
		// TODO validation of the imported templates

		if (syntaxbean.getImportedConcreteSyntaxes().size() > 0) {
			for (ConcreteSyntax imported_syntax : syntaxbean
					.getImportedConcreteSyntaxes()) {
				imported_lexer_collection.add(imported_syntax.getLexer());
				imported_symbols.addAll(imported_syntax.getSymbols());
				imported_tokens = imported_syntax.getTokens();

				for (Template templates_imported : imported_syntax
						.getTemplates()) {
					if (templates.contains(templates_imported)) {
						errorBucket
								.addWarning(
										"the template already exists in the main syntax.. ",
										templates_imported);
					} else {
						imported_templates.add(templates_imported);
					}
				}
				if (importsNotnull) {
					validationRules.validateSyntax(imported_syntax, metaLookup,
							errorBucket);
				}
				importsNotnull = true;
			}
		}

		// TODO: Do not generate on validation errors?

		writer.setGrammarName(syntax.getName());
		// FIXME: currently no id is defined / generated //
		// EcoreUtil.getID(syntax)
		writer.setSyntaxUUID(syntax.getName());

		String lexerString = syntax.getLexer();
		if (lexerString == null) {
			lexerString = DEFAULT_LEXER;
		} else {
			// To stay compatible with TCS for a while, transform TCS special
			// tokens
			// as in TCS2ANTLR.ATL line 558 ff
			lexerString = lexerString.replaceAll("%protected", "fragment");
			lexerString = lexerString.replaceAll("%options", "//");
			lexerString = lexerString.replaceAll("%v3", "");
			lexerString = lexerString.replaceAll("%v2.*", "");

			try {
				LexerStringMemberExtractor extractor = new LexerStringMemberExtractor(
						lexerString);
				lexerString = extractor.getCutLexerString();

				List<String> memberParts = extractor.getContentParts();
				if (memberParts != null && memberParts.size() > 0) {
					writer.addLexerMembers(memberParts);
				}
			} catch (InvalidLexerStringException e) {
				errorBucket.addError(e.getMessage(), syntax);
			}
		}
		// the lexer´s value of the main syntax have to be the same as the value
		// of the imported syntax
		if (importsNotnull) {
			for (String imported_lexer : imported_lexer_collection) {
				if (!imported_lexer.equalsIgnoreCase(lexerString)) {
					errorBucket
							.addWarning(
									"the lexer of the  imported syntax and the lexer of the main syntax have to be equal.. ",
									imported_lexer);
				} else {
					errorBucket
							.addWarning(
									"the lexer of the imported syntax is the same as the lexer of the main syntax",
									imported_lexer);
				}
			}
		}

		writer.setFixedString(lexerString);

		if (parserSuperClass != null) {
			writer.setParserSuperClass(parserSuperClass);
		}

		if (syntax.getK() == null) { // if lookahead is 0, we need backtracking
										// for ambiguous situations
			writer.setGrammarOptions("backtrack = true;");
		} else if (syntax.getK() == 0) {
			// leave empty which means that synpreds have to be added manually
			writer.setGrammarOptions(null);
		} else {
			writer.setGrammarOptions("k = " + syntax.getK() + ";");
		}

		for (Template template1 : imported_templates) {

			if (templates.contains(template1)) {
				errorBucket.addWarning(
						"the template already exists in the main syntax.. ",
						template1);
			} else {
				// templates are the template of the main syntax
				templates.add(template1);
			}
		}

		if (syntaxbean.getImportedTemplates().size() > 0) {
			for (Template template : syntaxbean.getImportedTemplates()) {
				if (templates.contains(template)) {
					errorBucket
							.addWarning(
									"the template of the imported templates already exists in the main syntax..",
									template);
				} else {
					templates.add(template);
				}
			}

		}
		for (Template temp : templates) {
			try {
				this.addTemplateProductionRuleToGrammar(temp);
			} catch (SyntaxElementException e) {
				errorBucket.addException(e);
			}

		}

		// to generate the production rules for transitive imported templates
		if (transitiveTemplates.size() > 0) {
			addTransitivTemplateProductionRuleToGrammar();
		}

		// Operator Lists are dealt with from operatored Class templates, or
		// else they aren't usable anyways
		// List<OperatorList> operators = syntax.getOperatorLists();
		// for (Iterator<OperatorList> iterator = operators.iterator();
		// iterator.hasNext();) {
		// OperatorList operatorList = (OperatorList) iterator.next();
		// mapper.addElementMappingRuleToGrammar( operatorList);
		// }

		Collection<Token> tokens = new HashSet<Token>(syntax.getTokens());
		Collection<Symbol> symbols = new HashSet<Symbol>(syntax.getSymbols());
		Collection<Symbol> symbolList = new HashSet<Symbol>();
		Collection<String> symbolListValues = new ArrayList<String>();

		if (importsNotnull) {
			// TODO what to do with the tokens of the concrete syntax of the
			// imported template(TemplateImport)
			for (Token token : imported_tokens) {
				if (tokens.contains(token)) {
					errorBucket.addWarning(
							"this token already exists in the main mapping ",
							token);
				} else {
					tokens.add(token);

				}

			}

			// TODO what to do with the symbols of the concrete syntax of the
			// imported template(TemplateImport)
			for (Symbol symbol : imported_symbols) {
				for (Symbol existingSymbol : symbols) {
					if (existingSymbol.getValue().equalsIgnoreCase(
							symbol.getValue())) {
						errorBucket
								.addWarning(
										"this symbol already exists in the main mapping ",
										symbol);
					} else {
						symbolListValues.add(symbol.getValue());
						if (!symbolListValues.contains(symbol.getValue()))
							symbolList.add(symbol);
					}
				}
			}
			symbols.addAll(symbolList);
		}

		for (Token token : tokens) {
			this.addTokenProductionRuleToGrammar(token);
		}

		for (Symbol symbol : symbols) {
			this.addSymbolProductionRuleToGrammar(symbol);
		}

		// To beautify grammar, also add token rules for all keywords that
		// aren't symbols

		GenerationReport report = new GenerationReport(locationMap,
				errorBucket, syntax.getName(), syntax);

		return report;
	}

	
	/**
	 * traverses the syntax definition elements and creates grammar elements by
	 * delegating creation actions to Handlers. The result is stored in the
	 * grammar Writer that was passed in the constructor, call writer.getOuput
	 * to write get the ANTLR stream.
	 * the class TCSSyntaxContainerBeanWithConfig is used instead of TCSSyntaxContainerBean
	 * 
	 * @return
	 * @throws MetaModelLookupException
	 * 
	 * @throws SyntaxParsingException
	 *             the syntax parsing exception
	 * @throws MetaModelLookupException
	 *             the meta model lookup exception
	 */
	public synchronized GenerationReport generateGrammar(
			ANTLR3GrammarWriter writer2, IMetaModelLookup<?> metaLookup,
			TCSSyntaxContainerBeanWithConfig syntaxbean,
			SyntaxDefinitionValidation validationRules,
			Class<? extends ObservableInjectingParser> parserSuperClass)
			throws MetaModelLookupException {
		boolean importsNotnull = false;
		ConcreteSyntax syntax = syntaxbean.getSyntax();
		Collection<Template> templates = new ArrayList<Template>();
		templates.addAll(syntax.getTemplates());

		init(writer2, metaLookup, syntaxbean);
		errorBucket.clear();

		if (validationRules != null) {
			validationRules.validateSyntax(syntax, metaLookup, errorBucket);
		}
		// TODO validation of the imported templates

		if (syntaxbean.getImportedConcreteSyntaxes().size() > 0) {
			for (ConcreteSyntax imported_syntax : syntaxbean
					.getImportedConcreteSyntaxes()) {
				imported_lexer_collection.add(imported_syntax.getLexer());
				imported_symbols.addAll(imported_syntax.getSymbols());
				imported_tokens = imported_syntax.getTokens();

				for (Template templates_imported : imported_syntax
						.getTemplates()) {
					if (templates.contains(templates_imported)) {
						errorBucket
								.addWarning(
										"the template already exists in the main syntax.. ",
										templates_imported);
					} else {
						imported_templates.add(templates_imported);
					}
				}
				if (importsNotnull) {
					validationRules.validateSyntax(imported_syntax, metaLookup,
							errorBucket);
				}
				importsNotnull = true;
			}
		}

		// TODO: Do not generate on validation errors?

		writer.setGrammarName(syntax.getName());
		// FIXME: currently no id is defined / generated //
		// EcoreUtil.getID(syntax)
		writer.setSyntaxUUID(syntax.getName());

		String lexerString = syntax.getLexer();
		if (lexerString == null) {
			lexerString = DEFAULT_LEXER;
		} else {
			// To stay compatible with TCS for a while, transform TCS special
			// tokens
			// as in TCS2ANTLR.ATL line 558 ff
			lexerString = lexerString.replaceAll("%protected", "fragment");
			lexerString = lexerString.replaceAll("%options", "//");
			lexerString = lexerString.replaceAll("%v3", "");
			lexerString = lexerString.replaceAll("%v2.*", "");

			try {
				LexerStringMemberExtractor extractor = new LexerStringMemberExtractor(
						lexerString);
				lexerString = extractor.getCutLexerString();

				List<String> memberParts = extractor.getContentParts();
				if (memberParts != null && memberParts.size() > 0) {
					writer.addLexerMembers(memberParts);
				}
			} catch (InvalidLexerStringException e) {
				errorBucket.addError(e.getMessage(), syntax);
			}
		}
		// the lexer´s value of the main syntax have to be the same as the value
		// of the imported syntax
		if (importsNotnull) {
			for (String imported_lexer : imported_lexer_collection) {
				if (!imported_lexer.equalsIgnoreCase(lexerString)) {
					errorBucket
							.addWarning(
									"the lexer of the  imported syntax and the lexer of the main syntax have to be equal.. ",
									imported_lexer);
				} else {
					errorBucket
							.addWarning(
									"the lexer of the imported syntax is the same as the lexer of the main syntax",
									imported_lexer);
				}
			}
		}

		writer.setFixedString(lexerString);

		if (parserSuperClass != null) {
			writer.setParserSuperClass(parserSuperClass);
		}

		if (syntax.getK() == null) { // if lookahead is 0, we need backtracking
										// for ambiguous situations
			writer.setGrammarOptions("backtrack = true;");
		} else if (syntax.getK() == 0) {
			// leave empty which means that synpreds have to be added manually
			writer.setGrammarOptions(null);
		} else {
			writer.setGrammarOptions("k = " + syntax.getK() + ";");
		}

		for (Template template1 : imported_templates) {

			if (templates.contains(template1)) {
				errorBucket.addWarning(
						"the template already exists in the main syntax.. ",
						template1);
			} else {
				// templates are the template of the main syntax
				templates.add(template1);
			}
		}

		if (syntaxbean.getImportedTemplates().size() > 0) {
			for (Template template : syntaxbean.getImportedTemplates()) {
				if (templates.contains(template)) {
					errorBucket
							.addWarning(
									"the template of the imported templates already exists in the main syntax..",
									template);
				} else {
					templates.add(template);
				}
			}

		}
		for (Template temp : templates) {
			try {
				this.addTemplateProductionRuleToGrammar(temp);
			} catch (SyntaxElementException e) {
				errorBucket.addException(e);
			}

		}

		// to generate the production rules for transitive imported templates
		if (transitiveTemplates.size() > 0) {
			addTransitivTemplateProductionRuleToGrammar();
		}

		// Operator Lists are dealt with from operatored Class templates, or
		// else they aren't usable anyways
		// List<OperatorList> operators = syntax.getOperatorLists();
		// for (Iterator<OperatorList> iterator = operators.iterator();
		// iterator.hasNext();) {
		// OperatorList operatorList = (OperatorList) iterator.next();
		// mapper.addElementMappingRuleToGrammar( operatorList);
		// }

		Collection<Token> tokens = new HashSet<Token>(syntax.getTokens());
		Collection<Symbol> symbols = new HashSet<Symbol>(syntax.getSymbols());
		Collection<Symbol> symbolList = new HashSet<Symbol>();
		Collection<String> symbolListValues = new ArrayList<String>();

		if (importsNotnull) {
			// TODO what to do with the tokens of the concrete syntax of the
			// imported template(TemplateImport)
			for (Token token : imported_tokens) {
				if (tokens.contains(token)) {
					errorBucket.addWarning(
							"this token already exists in the main mapping ",
							token);
				} else {
					tokens.add(token);

				}

			}

			// TODO what to do with the symbols of the concrete syntax of the
			// imported template(TemplateImport)
			for (Symbol symbol : imported_symbols) {
				for (Symbol existingSymbol : symbols) {
					if (existingSymbol.getValue().equalsIgnoreCase(
							symbol.getValue())) {
						errorBucket
								.addWarning(
										"this symbol already exists in the main mapping ",
										symbol);
					} else {
						symbolListValues.add(symbol.getValue());
						if (!symbolListValues.contains(symbol.getValue()))
							symbolList.add(symbol);
					}
				}
			}
			symbols.addAll(symbolList);
		}

		for (Token token : tokens) {
			this.addTokenProductionRuleToGrammar(token);
		}

		for (Symbol symbol : symbols) {
			this.addSymbolProductionRuleToGrammar(symbol);
		}

		// To beautify grammar, also add token rules for all keywords that
		// aren't symbols

		GenerationReport report = new GenerationReport(locationMap,
				errorBucket, syntax.getName(), syntax);

		return report;
	}

	
	private void addTransitivTemplateProductionRuleToGrammar()
			throws MetaModelLookupException {
		HashSet<Template> transitiveTemplatesCopy = new HashSet<Template>();
		HashSet<Template> transitiveTemplatesCopy1 = new HashSet<Template>();
		transitiveTemplatesCopy.addAll(transitiveTemplates);
		for (Template transitiveTemplate : transitiveTemplatesCopy) {
			// to avoid duplicate generation of grammar rules for transitively
			// imported templates
			if (allTransitiveTemplate.size() > 0) {
				if (!allTransitiveTemplate.contains(transitiveTemplate)) {
					try {
						this.addTemplateProductionRuleToGrammar(transitiveTemplate);
						allTransitiveTemplate.add(transitiveTemplate);
						transitiveTemplates.remove(transitiveTemplate);
					} catch (SyntaxElementException e) {
						errorBucket.addException(e);
					}
				}
			} else {
				try {
					this.addTemplateProductionRuleToGrammar(transitiveTemplate);
					allTransitiveTemplate.add(transitiveTemplate);
					transitiveTemplates.remove(transitiveTemplate);
				} catch (SyntaxElementException e) {
					errorBucket.addException(e);
				}
			}

			transitiveTemplatesCopy1 = transitiveTemplates;
			if (transitiveTemplatesCopy1.size() > 0) {
				addTransitivTemplateProductionRuleToGrammar();
			}

		}
	}

	@Override
	/*
	 * to add all transitive imported template to the imported templates
	 */
	public void addAdditionallyImportedTemplate(Template importedTemplate) {
		if (!importedTemplates.contains(importedTemplate)
				&& !syntax.getTemplates().contains(importedTemplate)) {
			// we have a transitively imported template which we also need to
			// generate code for
			if (allTransitiveTemplate.size() > 0) {
				if (!allTransitiveTemplate.contains(importedTemplate)) {
					transitiveTemplates.add(importedTemplate);
				}
			} else {
				transitiveTemplates.add(importedTemplate);
			}
		}
	}

	/**
	 * Adds the token production rule to grammar.
	 * 
	 * @param token
	 *            the token
	 */
	private void addTokenProductionRuleToGrammar(Token token) {
		tokenHandler.addToken(token);
	}

	/**
	 * Adds the symbol production rule to grammar.
	 * 
	 * @param symbol
	 *            the symbol
	 */
	private void addSymbolProductionRuleToGrammar(Symbol symbol) {
		writer.addRule(new SymbolProductionRule(symbol.getName().toUpperCase(),
				symbol.getValue()));
	}

	/**
	 * Chooses right helper for the given template. This method can be
	 * recursively be called by helpers.
	 * 
	 * @param template
	 *            the template
	 * @throws
	 * @throws MetaModelLookupException
	 * 
	 * @throws SyntaxParsingException
	 *             the syntax parsing exception
	 * @throws MetaModelLookupException
	 *             the meta model lookup exception
	 * @throws SyntaxElementException
	 */
	private void addTemplateProductionRuleToGrammar(Template template)
			throws MetaModelLookupException, SyntaxElementException {
		templateProductionRuleToGrammar.add(template);
		if (template instanceof ClassTemplate) {
			ClassTemplate primTemp = (ClassTemplate) template;
			classTempHandler.addTemplate(primTemp, ruleBodyFactory, syntax
					.getTemplates().contains(primTemp));
		} else if (template instanceof PrimitiveTemplate) {
			PrimitiveTemplate primTemp = (PrimitiveTemplate) template;
			primTempHandler.addTemplate(primTemp);
		} else if (template instanceof OperatorTemplate) {
			OperatorTemplate primTemp = (OperatorTemplate) template;
			operatorTemplateHandler.addTemplate(primTemp, ruleBodyFactory);
		} else if (template instanceof EnumerationTemplate) {
			EnumerationTemplate primTemp = (EnumerationTemplate) template;
			enumTempHandler.addTemplate(primTemp, ruleBodyFactory);
		} else if (template instanceof FunctionTemplate) {
			FunctionTemplate funcTemp = (FunctionTemplate) template;
			funcTempHandler.addTemplate(funcTemp, ruleBodyFactory);
		} else {
			// should never happen, unless TCS metamodel changed
			throw new RuntimeException(template.getClass()
					+ " unknown implementation of Template");
		}
	}

	protected static final String DEFAULT_LEXER = "NL\r\n"
			+ "    :   (   \'\\r\' \'\\n\'\r\n"
			+ "        |   \'\\n\' \'\\r\'   //Improbable\r\n"
			+ "        |   \'\\r\'\r\n"
			+ "        |   \'\\n\'\r\n"
			+ "        )\r\n"
			+ "    {newline();$channel=HIDDEN;}\r\n"
			+ "    ;\r\n"
			+ "\r\n"
			+ "WS\r\n"
			+ "    :   (   \' \'\r\n"
			+ "        |   \'\\t\'\r\n"
			+ "        )\r\n"
			+ "        {$channel=HIDDEN;}"
			+ "    ;\r\n"
			+ "\r\n"
			+ "fragment\r\n"
			+ "DIGIT\r\n"
			+ "    :   \'0\'..\'9\'\r\n"
			+ "    ;\r\n"
			+ "\r\n"
			+ "fragment\r\n"
			+ "ALPHA\r\n"
			+ "    :   \'a\'..\'z\'\r\n"
			+ "    |   \'A\'..\'Z\'\r\n"
			+ "    |   \'_\'\r\n"
			+ "    //For Unicode compatibility (from 0000 to 00ff)\r\n"
			+ "    |   \'\\u00C0\' .. \'\\u00D6\'\r\n"
			+ "    |   \'\\u00D8\' .. \'\\u00F6\'\r\n"
			+ "    |   \'\\u00F8\' .. \'\\u00FF\'\r\n"
			+ "    ;\r\n"
			+ "\r\n"
			+ "fragment\r\n"
			+ "SNAME\r\n"
			+ "    :   (ALPHA) (ALPHA | DIGIT)*\r\n"
			+ ";\r\n"
			+ "\r\n"
			+ "NAME\r\n"
			+ "    :   (\r\n"
			+ "            SNAME\r\n"
			+ "        |   \'\"\'!\r\n"
			+ "            (   ESC\r\n"
			+ "            |   \'\\n\' {newline();}\r\n"
			+ "            |   ~(\'\\\\\'|\'\\\"\'|\'\\n\')\r\n"
			+ "            )*\r\n"
			+ "            \'\"\'!\r\n"
			+ "            \r\n"
			+ "        )\r\n"
			+ "    ;\r\n"
			+ "\r\n"
			+ "INT\r\n"
			+ "    :   (DIGIT)+\r\n"
			+ "    ;\r\n"
			+ "\r\n"
			+ "    FLOAT   :   DIGIT+ ((\'.\' DIGIT)=>\'.\' DIGIT+)?   ;   // cannot accept DIGIT \'.\' because it would conflict with Navigation\r\n"
			+ "\r\n" + "fragment\r\n" + "ESC\r\n" + "    :   \'\\\\\'!\r\n"
			+ "        (   \'n\' \r\n" + "        |   \'r\' \r\n"
			+ "        |   \'t\' \r\n" + "        |   \'b\' \r\n"
			+ "        |   \'f\' \r\n" + "        |   \'\"\' \r\n"
			+ "        |   \'\\\'\' \r\n" + "        |   \'\\\\\' \r\n"
			+ "        |   (\r\n" + "                (\'0\'..\'3\')\r\n"
			+ "                (\r\n"
			+ "                :   (\'0\'..\'7\')\r\n"
			+ "                    (\r\n"
			+ "                    :   \'0\'..\'7\'\r\n"
			+ "                    )?\r\n" + "                )?\r\n"
			+ "            |   (\'4\'..\'7\')\r\n" + "                (\r\n"
			+ "                :   (\'0\'..\'7\')\r\n"
			+ "                )?\r\n" + "            )\r\n"
			+ "                {\r\n" + "                }\r\n"
			+ "        )\r\n" + "    ;\r\n" + "\r\n" + "STRING\r\n"
			+ "    :   \'\\\'\'!\r\n" + "        (   ESC\r\n"
			+ "        |   \'\\n\' {newline();}\r\n"
			+ "        |   ~(\'\\\\\'|\'\\\'\'|\'\\n\')\r\n" + "        )*\r\n"
			+ "        \'\\\'\'!\r\n" + "       \r\n" + "    ;";

}
