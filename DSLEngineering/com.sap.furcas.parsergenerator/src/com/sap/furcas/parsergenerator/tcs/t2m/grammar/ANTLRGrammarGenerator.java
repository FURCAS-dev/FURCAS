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
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntaxImport;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ImportDeclaration;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.TemplateImport;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.parsergenerator.TCSSyntaxContainerBean;
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
 * orchestrates the creation of grammar elements. This class is a facade to several
 * helper classes dealing with specific syntax elements and their mappings to ANTRL3 grammar rules.
 * For elements of a TCS Syntax definition model (of a DSL Syntax), this Mapper
 * helps writing the ANTLR3 grammar for each template type.
 * 
 * @author C5107456
 */
public class ANTLRGrammarGenerator {

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
    private final ArrayList<Template> importedTemplates = new ArrayList<Template>();

    private Map<Object, TextLocation> locationMap;

    private SemanticErrorBucket errorBucket;

    private InjectorActionsHandler<?> actionsHandler;

    private static Logger log = Logger.getLogger(ANTLRGrammarGenerator.class
            .getName());

    private final List<String> imported_lexer_collection = new ArrayList<String>();

    private List<Token> imported_tokens = new ArrayList<Token>();

    private final List<Symbol> imported_symbols = new ArrayList<Symbol>();

    private final List<Template> templateProductionRuleToGrammar = new ArrayList<Template>();

    private final List<Template> imported_templates = new ArrayList<Template>();

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
                        // TODO for nested Imports
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
                importedTemplates, null, resolutionHelper);
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
        this.propertyHandler = new PropertyTypeHandler<T>(handlerConfig);
        this.conElHandler = new ConditionalElementHandler<T>(handlerConfig);
		this.classTempHandler = new ClassTemplateHandler<T>(operatorHandler,
				handlerConfig);
        this.enumTempHandler = new EnumerationTemplateHandler<T>(handlerConfig);
        
        this.actionsHandler = new InjectorActionsHandler<T>(handlerConfig);

        // factory depending on rulebody producing handlers
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
            ANTLR3GrammarWriter writer2, 
            IMetaModelLookup<?> metaLookup,
            TCSSyntaxContainerBean syntaxbean,
            SyntaxDefinitionValidation validationRules,
            Class<? extends ObservableInjectingParser> parserSuperClass )
          throws MetaModelLookupException {
        boolean importsNotnull = false;
        ConcreteSyntax syntax = syntaxbean.getSyntax();
        Collection<Template> templates = new ArrayList<Template>();
        templates.addAll(syntax.getTemplates());

        List<String> qualifiedNamesOfSyntaxTemplates = new ArrayList<String>();
        for (Template syntaxTemplate : templates) {
                if (syntaxTemplate.getMetaReference() != null) {
                        qualifiedNamesOfSyntaxTemplates.add(syntaxTemplate
                                        .getMetaReference().getName());
                } else {
                        log.warning("The metareference of the template " + syntaxTemplate + "is null");
                }
                
        }
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

                        // TODO what to to when the template of an imported
                        // concreteSyntax already exists in the main syntax
                        for (Template templates_imported : imported_syntax
                                        .getTemplates()) {
                                if ((qualifiedNamesOfSyntaxTemplates
                                                .contains(templates_imported.getMetaReference()
                                                                .getName()))
                                                || (imported_templates.contains(templates_imported))) {
                                        log.warning("the template " + templates_imported
                                                        + " allready exists in the main syntax.. ");
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
        // FIXME: currently no id is defined / generated // EcoreUtil.getID(syntax)
        writer.setSyntaxUUID(syntax.getName());

        String lexerString = syntax.getLexer();
        if (lexerString == null) {
            lexerString = DEFAULT_LEXER;
        } else {
            // To stay compatible with TCS for a while, transform TCS special tokens
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
                    log.warning("the lexer of the  imported syntax and the lexer of the main syntax have to be equal.. ");
                } else {
                    log.info("the lexer of the imported syntax is the same as the lexer of the main syntax");
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
        	//leave empty which means that synpreds have to be added manually
        	writer.setGrammarOptions(null);
        } else {
            writer.setGrammarOptions("k = " + syntax.getK() + ";");
        }

     // TODO what to to when the template of an imported
        // concreteSyntax allready exists in the main syntax

        for (Template template1 : imported_templates) {
                if (qualifiedNamesOfSyntaxTemplates.contains(template1
                                .getMetaReference().getName())
                                || templates.contains(template1)) {
                        log.warning("the template " + template1
                                        + " already exists in the main syntax.. ");
                } else {
                        // templates are the template of the main syntax
                        templates.add(template1);
                }
        }

        if (syntaxbean.getImportedTemplates().size() > 0) {
                for (Template template : syntaxbean.getImportedTemplates()) {
                        // TODO what to do if the template already exists
                        if (qualifiedNamesOfSyntaxTemplates.contains(template
                                        .getMetaReference().getName())) {
                                log.warning("the template "
                                                + template
                                                + " of the imported templates already exists in the main syntax..");
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

        // Operator Lists are dealt with from operatored Class templates, or
        // else they aren't usable anyways
        // List<OperatorList> operators = syntax.getOperatorLists();
        // for (Iterator<OperatorList> iterator = operators.iterator();
        // iterator.hasNext();) {
        // OperatorList operatorList = (OperatorList) iterator.next();
        // mapper.addElementMappingRuleToGrammar( operatorList);
        // }
        
        Collection<Token> tokens = new ArrayList<Token>(syntax.getTokens());
        Collection<Token> tokenList = new ArrayList<Token>();
        Collection<String> tokenListName = new ArrayList<String>();
        Collection<Symbol> symbols = new ArrayList<Symbol>(syntax.getSymbols());
        Collection<Symbol> symbolList = new ArrayList<Symbol>();
        Collection<String> symbolListValues = new ArrayList<String>();
        
        if (importsNotnull) {
                // TODO what to do with the tokens of the concrete syntax of the
                // imported template(TemplateImport)
                for (Token token : imported_tokens) {
                        for (Token existing : tokens) {
                                if (existing.getName().equalsIgnoreCase(token.getName())) {
                                        log.warning("this token already exists in the main mapping : "
                                                        + existing);
                                } else {
                                        tokenListName.add(token.getName());
                                        if (!tokenListName.contains(token.getName()))
                                        tokenList.add(token);
                                }
                        }
                }
                tokens.addAll(tokenList);
                
                // TODO what to do with the symbols of the concrete syntax of the
                // imported template(TemplateImport)
                for (Symbol symbol : imported_symbols) {
                        for (Symbol existingSymbol : symbols) {
                                if (existingSymbol.getValue().equalsIgnoreCase(symbol.getValue())) {
                                        log.warning("this symbol already exists in the main mapping : "
                                                        + symbol);
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
        
        // To beautify grammar, also add token rules for all keywords that aren't symbols
        
        GenerationReport report = new GenerationReport(locationMap, errorBucket, syntax.getName(), syntax);
        
        return report;
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
        } else  if (template instanceof PrimitiveTemplate) {
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
