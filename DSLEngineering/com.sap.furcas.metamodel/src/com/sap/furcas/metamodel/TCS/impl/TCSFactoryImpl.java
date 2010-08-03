/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS.impl;

import com.sap.furcas.metamodel.TCS.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TCSFactoryImpl extends EFactoryImpl implements TCSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TCSFactory init() {
		try {
			TCSFactory theTCSFactory = (TCSFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.furcas.org/TCS"); 
			if (theTCSFactory != null) {
				return theTCSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TCSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TCSPackage.CONCRETE_SYNTAX: return createConcreteSyntax();
			case TCSPackage.FUNCTION_TEMPLATE: return createFunctionTemplate();
			case TCSPackage.CLASS_TEMPLATE: return createClassTemplate();
			case TCSPackage.PRIMITIVE_TEMPLATE: return createPrimitiveTemplate();
			case TCSPackage.OPERATOR_TEMPLATE: return createOperatorTemplate();
			case TCSPackage.ENUMERATION_TEMPLATE: return createEnumerationTemplate();
			case TCSPackage.ENUM_LITERAL_MAPPING: return createEnumLiteralMapping();
			case TCSPackage.SYMBOL: return createSymbol();
			case TCSPackage.KEYWORD: return createKeyword();
			case TCSPackage.OPERATOR_LIST: return createOperatorList();
			case TCSPackage.PRIORITY: return createPriority();
			case TCSPackage.OPERATOR: return createOperator();
			case TCSPackage.SEQUENCE: return createSequence();
			case TCSPackage.LITERAL_REF: return createLiteralRef();
			case TCSPackage.PROPERTY: return createProperty();
			case TCSPackage.CUSTOM_SEPARATOR: return createCustomSeparator();
			case TCSPackage.BLOCK: return createBlock();
			case TCSPackage.CONDITIONAL_ELEMENT: return createConditionalElement();
			case TCSPackage.PRIMITIVE_PROPERTY_INIT: return createPrimitivePropertyInit();
			case TCSPackage.ALTERNATIVE: return createAlternative();
			case TCSPackage.FUNCTION_CALL: return createFunctionCall();
			case TCSPackage.REFERS_TO_PARG: return createRefersToPArg();
			case TCSPackage.LOOK_IN_PARG: return createLookInPArg();
			case TCSPackage.CREATE_IN_PARG: return createCreateInPArg();
			case TCSPackage.REFERS_TO_KEY_PARG: return createRefersToKeyPArg();
			case TCSPackage.SEPARATOR_PARG: return createSeparatorPArg();
			case TCSPackage.AUTO_CREATE_PARG: return createAutoCreatePArg();
			case TCSPackage.IMPORT_CONTEXT_PARG: return createImportContextPArg();
			case TCSPackage.FORCED_LOWER_PARG: return createForcedLowerPArg();
			case TCSPackage.CREATE_AS_PARG: return createCreateAsPArg();
			case TCSPackage.AS_PARG: return createAsPArg();
			case TCSPackage.MODE_PARG: return createModePArg();
			case TCSPackage.NB_NLB_ARG: return createNbNLBArg();
			case TCSPackage.INDENT_INCR_BARG: return createIndentIncrBArg();
			case TCSPackage.START_NLB_ARG: return createStartNLBArg();
			case TCSPackage.START_NB_NLB_ARG: return createStartNbNLBArg();
			case TCSPackage.END_NLB_ARG: return createEndNLBArg();
			case TCSPackage.AND_EXP: return createAndExp();
			case TCSPackage.EQUALS_EXP: return createEqualsExp();
			case TCSPackage.BOOLEAN_PROPERTY_EXP: return createBooleanPropertyExp();
			case TCSPackage.IS_DEFINED_EXP: return createIsDefinedExp();
			case TCSPackage.ONE_EXP: return createOneExp();
			case TCSPackage.PROPERTY_VAL: return createPropertyVal();
			case TCSPackage.TOKEN: return createToken();
			case TCSPackage.OR_PATTERN: return createOrPattern();
			case TCSPackage.RULE_PATTERN: return createRulePattern();
			case TCSPackage.WORD_RULE: return createWordRule();
			case TCSPackage.WORD: return createWord();
			case TCSPackage.END_OF_LINE_RULE: return createEndOfLineRule();
			case TCSPackage.MULTI_LINE_RULE: return createMultiLineRule();
			case TCSPackage.SIMPLE_MAPPING: return createSimpleMapping();
			case TCSPackage.WILDCARD_MAPPING: return createWildcardMapping();
			case TCSPackage.OCTAL_MAPPING: return createOctalMapping();
			case TCSPackage.HEXADECIMAL_MAPPING: return createHexadecimalMapping();
			case TCSPackage.STRING_PATTERN: return createStringPattern();
			case TCSPackage.CLASS_PATTERN: return createClassPattern();
			case TCSPackage.QUALIFIED_NAMED_ELEMENT: return createQualifiedNamedElement();
			case TCSPackage.FORCED_UPPER_PARG: return createForcedUpperPArg();
			case TCSPackage.INJECTOR_ACTIONS_BLOCK: return createInjectorActionsBlock();
			case TCSPackage.QUERY_PARG: return createQueryPArg();
			case TCSPackage.FILTER_PARG: return createFilterPArg();
			case TCSPackage.PROPERTY_REFERENCE: return createPropertyReference();
			case TCSPackage.CONTEXT_TEMPLATE: return createContextTemplate();
			case TCSPackage.CONTEXT_TAGS: return createContextTags();
			case TCSPackage.OCL_PROPERTY_INIT: return createOclPropertyInit();
			case TCSPackage.SCOPE_ARG: return createScopeArg();
			case TCSPackage.INVERT_PARG: return createInvertPArg();
			case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT: return createForeachPredicatePropertyInit();
			case TCSPackage.PREDICATE_SEMANTIC: return createPredicateSemantic();
			case TCSPackage.SEQUENCE_IN_ALTERNATIVE: return createSequenceInAlternative();
			case TCSPackage.ECLASS0: return createEClass0();
			case TCSPackage.PARTIAL_PARG: return createPartialPArg();
			case TCSPackage.DISAMBIGUATE_PARG: return createDisambiguatePArg();
			case TCSPackage.INSTANCE_OF_EXP: return createInstanceOfExp();
			case TCSPackage.ENUM_LITERAL_VAL: return createEnumLiteralVal();
			case TCSPackage.STRING_VAL: return createStringVal();
			case TCSPackage.INTEGER_VAL: return createIntegerVal();
			case TCSPackage.NEGATIVE_INTEGER_VAL: return createNegativeIntegerVal();
			case TCSPackage.LOOKUP_PROPERTY_INIT: return createLookupPropertyInit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case TCSPackage.TEMPLATE_MODIFIERS:
				return createTemplateModifiersFromString(eDataType, initialValue);
			case TCSPackage.SPACE_KIND:
				return createSpaceKindFromString(eDataType, initialValue);
			case TCSPackage.ASSOCIATIVITY:
				return createAssociativityFromString(eDataType, initialValue);
			case TCSPackage.AUTO_CREATE_KIND:
				return createAutoCreateKindFromString(eDataType, initialValue);
			case TCSPackage.SCOPE_KIND:
				return createScopeKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case TCSPackage.TEMPLATE_MODIFIERS:
				return convertTemplateModifiersToString(eDataType, instanceValue);
			case TCSPackage.SPACE_KIND:
				return convertSpaceKindToString(eDataType, instanceValue);
			case TCSPackage.ASSOCIATIVITY:
				return convertAssociativityToString(eDataType, instanceValue);
			case TCSPackage.AUTO_CREATE_KIND:
				return convertAutoCreateKindToString(eDataType, instanceValue);
			case TCSPackage.SCOPE_KIND:
				return convertScopeKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConcreteSyntax createConcreteSyntax() {
		ConcreteSyntaxImpl concreteSyntax = new ConcreteSyntaxImpl();
		return concreteSyntax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionTemplate createFunctionTemplate() {
		FunctionTemplateImpl functionTemplate = new FunctionTemplateImpl();
		return functionTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassTemplate createClassTemplate() {
		ClassTemplateImpl classTemplate = new ClassTemplateImpl();
		return classTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTemplate createPrimitiveTemplate() {
		PrimitiveTemplateImpl primitiveTemplate = new PrimitiveTemplateImpl();
		return primitiveTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorTemplate createOperatorTemplate() {
		OperatorTemplateImpl operatorTemplate = new OperatorTemplateImpl();
		return operatorTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationTemplate createEnumerationTemplate() {
		EnumerationTemplateImpl enumerationTemplate = new EnumerationTemplateImpl();
		return enumerationTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralMapping createEnumLiteralMapping() {
		EnumLiteralMappingImpl enumLiteralMapping = new EnumLiteralMappingImpl();
		return enumLiteralMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Symbol createSymbol() {
		SymbolImpl symbol = new SymbolImpl();
		return symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Keyword createKeyword() {
		KeywordImpl keyword = new KeywordImpl();
		return keyword;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorList createOperatorList() {
		OperatorListImpl operatorList = new OperatorListImpl();
		return operatorList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority createPriority() {
		PriorityImpl priority = new PriorityImpl();
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperator() {
		OperatorImpl operator = new OperatorImpl();
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiteralRef createLiteralRef() {
		LiteralRefImpl literalRef = new LiteralRefImpl();
		return literalRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomSeparator createCustomSeparator() {
		CustomSeparatorImpl customSeparator = new CustomSeparatorImpl();
		return customSeparator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionalElement createConditionalElement() {
		ConditionalElementImpl conditionalElement = new ConditionalElementImpl();
		return conditionalElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitivePropertyInit createPrimitivePropertyInit() {
		PrimitivePropertyInitImpl primitivePropertyInit = new PrimitivePropertyInitImpl();
		return primitivePropertyInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alternative createAlternative() {
		AlternativeImpl alternative = new AlternativeImpl();
		return alternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCall createFunctionCall() {
		FunctionCallImpl functionCall = new FunctionCallImpl();
		return functionCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefersToPArg createRefersToPArg() {
		RefersToPArgImpl refersToPArg = new RefersToPArgImpl();
		return refersToPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookInPArg createLookInPArg() {
		LookInPArgImpl lookInPArg = new LookInPArgImpl();
		return lookInPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateInPArg createCreateInPArg() {
		CreateInPArgImpl createInPArg = new CreateInPArgImpl();
		return createInPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RefersToKeyPArg createRefersToKeyPArg() {
		RefersToKeyPArgImpl refersToKeyPArg = new RefersToKeyPArgImpl();
		return refersToKeyPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeparatorPArg createSeparatorPArg() {
		SeparatorPArgImpl separatorPArg = new SeparatorPArgImpl();
		return separatorPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoCreatePArg createAutoCreatePArg() {
		AutoCreatePArgImpl autoCreatePArg = new AutoCreatePArgImpl();
		return autoCreatePArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportContextPArg createImportContextPArg() {
		ImportContextPArgImpl importContextPArg = new ImportContextPArgImpl();
		return importContextPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcedLowerPArg createForcedLowerPArg() {
		ForcedLowerPArgImpl forcedLowerPArg = new ForcedLowerPArgImpl();
		return forcedLowerPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateAsPArg createCreateAsPArg() {
		CreateAsPArgImpl createAsPArg = new CreateAsPArgImpl();
		return createAsPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsPArg createAsPArg() {
		AsPArgImpl asPArg = new AsPArgImpl();
		return asPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModePArg createModePArg() {
		ModePArgImpl modePArg = new ModePArgImpl();
		return modePArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NbNLBArg createNbNLBArg() {
		NbNLBArgImpl nbNLBArg = new NbNLBArgImpl();
		return nbNLBArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndentIncrBArg createIndentIncrBArg() {
		IndentIncrBArgImpl indentIncrBArg = new IndentIncrBArgImpl();
		return indentIncrBArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartNLBArg createStartNLBArg() {
		StartNLBArgImpl startNLBArg = new StartNLBArgImpl();
		return startNLBArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartNbNLBArg createStartNbNLBArg() {
		StartNbNLBArgImpl startNbNLBArg = new StartNbNLBArgImpl();
		return startNbNLBArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndNLBArg createEndNLBArg() {
		EndNLBArgImpl endNLBArg = new EndNLBArgImpl();
		return endNLBArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndExp createAndExp() {
		AndExpImpl andExp = new AndExpImpl();
		return andExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualsExp createEqualsExp() {
		EqualsExpImpl equalsExp = new EqualsExpImpl();
		return equalsExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanPropertyExp createBooleanPropertyExp() {
		BooleanPropertyExpImpl booleanPropertyExp = new BooleanPropertyExpImpl();
		return booleanPropertyExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IsDefinedExp createIsDefinedExp() {
		IsDefinedExpImpl isDefinedExp = new IsDefinedExpImpl();
		return isDefinedExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OneExp createOneExp() {
		OneExpImpl oneExp = new OneExpImpl();
		return oneExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringVal createStringVal() {
		StringValImpl stringVal = new StringValImpl();
		return stringVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerVal createIntegerVal() {
		IntegerValImpl integerVal = new IntegerValImpl();
		return integerVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegativeIntegerVal createNegativeIntegerVal() {
		NegativeIntegerValImpl negativeIntegerVal = new NegativeIntegerValImpl();
		return negativeIntegerVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LookupPropertyInit createLookupPropertyInit() {
		LookupPropertyInitImpl lookupPropertyInit = new LookupPropertyInitImpl();
		return lookupPropertyInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralVal createEnumLiteralVal() {
		EnumLiteralValImpl enumLiteralVal = new EnumLiteralValImpl();
		return enumLiteralVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyVal createPropertyVal() {
		PropertyValImpl propertyVal = new PropertyValImpl();
		return propertyVal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Token createToken() {
		TokenImpl token = new TokenImpl();
		return token;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrPattern createOrPattern() {
		OrPatternImpl orPattern = new OrPatternImpl();
		return orPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulePattern createRulePattern() {
		RulePatternImpl rulePattern = new RulePatternImpl();
		return rulePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WordRule createWordRule() {
		WordRuleImpl wordRule = new WordRuleImpl();
		return wordRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Word createWord() {
		WordImpl word = new WordImpl();
		return word;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndOfLineRule createEndOfLineRule() {
		EndOfLineRuleImpl endOfLineRule = new EndOfLineRuleImpl();
		return endOfLineRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiLineRule createMultiLineRule() {
		MultiLineRuleImpl multiLineRule = new MultiLineRuleImpl();
		return multiLineRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleMapping createSimpleMapping() {
		SimpleMappingImpl simpleMapping = new SimpleMappingImpl();
		return simpleMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WildcardMapping createWildcardMapping() {
		WildcardMappingImpl wildcardMapping = new WildcardMappingImpl();
		return wildcardMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OctalMapping createOctalMapping() {
		OctalMappingImpl octalMapping = new OctalMappingImpl();
		return octalMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HexadecimalMapping createHexadecimalMapping() {
		HexadecimalMappingImpl hexadecimalMapping = new HexadecimalMappingImpl();
		return hexadecimalMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringPattern createStringPattern() {
		StringPatternImpl stringPattern = new StringPatternImpl();
		return stringPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPattern createClassPattern() {
		ClassPatternImpl classPattern = new ClassPatternImpl();
		return classPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualifiedNamedElement createQualifiedNamedElement() {
		QualifiedNamedElementImpl qualifiedNamedElement = new QualifiedNamedElementImpl();
		return qualifiedNamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForcedUpperPArg createForcedUpperPArg() {
		ForcedUpperPArgImpl forcedUpperPArg = new ForcedUpperPArgImpl();
		return forcedUpperPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InjectorActionsBlock createInjectorActionsBlock() {
		InjectorActionsBlockImpl injectorActionsBlock = new InjectorActionsBlockImpl();
		return injectorActionsBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryPArg createQueryPArg() {
		QueryPArgImpl queryPArg = new QueryPArgImpl();
		return queryPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilterPArg createFilterPArg() {
		FilterPArgImpl filterPArg = new FilterPArgImpl();
		return filterPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyReference createPropertyReference() {
		PropertyReferenceImpl propertyReference = new PropertyReferenceImpl();
		return propertyReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextTemplate createContextTemplate() {
		ContextTemplateImpl contextTemplate = new ContextTemplateImpl();
		return contextTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextTags createContextTags() {
		ContextTagsImpl contextTags = new ContextTagsImpl();
		return contextTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclPropertyInit createOclPropertyInit() {
		OclPropertyInitImpl oclPropertyInit = new OclPropertyInitImpl();
		return oclPropertyInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeArg createScopeArg() {
		ScopeArgImpl scopeArg = new ScopeArgImpl();
		return scopeArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvertPArg createInvertPArg() {
		InvertPArgImpl invertPArg = new InvertPArgImpl();
		return invertPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForeachPredicatePropertyInit createForeachPredicatePropertyInit() {
		ForeachPredicatePropertyInitImpl foreachPredicatePropertyInit = new ForeachPredicatePropertyInitImpl();
		return foreachPredicatePropertyInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredicateSemantic createPredicateSemantic() {
		PredicateSemanticImpl predicateSemantic = new PredicateSemanticImpl();
		return predicateSemantic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceInAlternative createSequenceInAlternative() {
		SequenceInAlternativeImpl sequenceInAlternative = new SequenceInAlternativeImpl();
		return sequenceInAlternative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass0 createEClass0() {
		EClass0Impl eClass0 = new EClass0Impl();
		return eClass0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartialPArg createPartialPArg() {
		PartialPArgImpl partialPArg = new PartialPArgImpl();
		return partialPArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisambiguatePArg createDisambiguatePArg() {
		DisambiguatePArgImpl disambiguatePArg = new DisambiguatePArgImpl();
		return disambiguatePArg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceOfExp createInstanceOfExp() {
		InstanceOfExpImpl instanceOfExp = new InstanceOfExpImpl();
		return instanceOfExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateModifiers createTemplateModifiersFromString(EDataType eDataType, String initialValue) {
		TemplateModifiers result = TemplateModifiers.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTemplateModifiersToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpaceKind createSpaceKindFromString(EDataType eDataType, String initialValue) {
		SpaceKind result = SpaceKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSpaceKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Associativity createAssociativityFromString(EDataType eDataType, String initialValue) {
		Associativity result = Associativity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssociativityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoCreateKind createAutoCreateKindFromString(EDataType eDataType, String initialValue) {
		AutoCreateKind result = AutoCreateKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAutoCreateKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeKind createScopeKindFromString(EDataType eDataType, String initialValue) {
		ScopeKind result = ScopeKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScopeKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCSPackage getTCSPackage() {
		return (TCSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TCSPackage getPackage() {
		return TCSPackage.eINSTANCE;
	}

} //TCSFactoryImpl
