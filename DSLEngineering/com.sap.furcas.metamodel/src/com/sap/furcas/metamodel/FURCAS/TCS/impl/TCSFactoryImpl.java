/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import com.sap.furcas.metamodel.FURCAS.TCS.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.BooleanPropertyExp;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTags;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.CustomSeparator;
import com.sap.furcas.metamodel.FURCAS.TCS.DisambiguatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.EndOfLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralVal;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.EqualsExp;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.HexadecimalMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.ImportContextPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp;
import com.sap.furcas.metamodel.FURCAS.TCS.IntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.IsDefinedExp;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.OclPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.OctalMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.OneExp;
import com.sap.furcas.metamodel.FURCAS.TCS.Operator;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorList;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OrPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.PartialPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Priority;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyVal;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToKeyPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RulePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SimpleMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.StringVal;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.metamodel.FURCAS.TCS.WildcardMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.Word;
import com.sap.furcas.metamodel.FURCAS.TCS.WordRule;

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
            case TCSPackage.LOOKUP_SCOPE_PARG: return createLookupScopePArg();
            case TCSPackage.REFERENCE_BY_PARG: return createReferenceByPArg();
            case TCSPackage.PREFIX_PARG: return createPrefixPArg();
            case TCSPackage.POSTFIX_PARG: return createPostfixPArg();
            case TCSPackage.PROPERTY_REFERENCE: return createPropertyReference();
            case TCSPackage.CONTEXT_TEMPLATE: return createContextTemplate();
            case TCSPackage.CONTEXT_TAGS: return createContextTags();
            case TCSPackage.OCL_PROPERTY_INIT: return createOclPropertyInit();
            case TCSPackage.SCOPE_ARG: return createScopeArg();
            case TCSPackage.FOREACH_PREDICATE_PROPERTY_INIT: return createForeachPredicatePropertyInit();
            case TCSPackage.PREDICATE_SEMANTIC: return createPredicateSemantic();
            case TCSPackage.SEQUENCE_IN_ALTERNATIVE: return createSequenceInAlternative();
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
        @Override
        public ConcreteSyntax createConcreteSyntax() {
        ConcreteSyntaxImpl concreteSyntax = new ConcreteSyntaxImpl();
        return concreteSyntax;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public FunctionTemplate createFunctionTemplate() {
        FunctionTemplateImpl functionTemplate = new FunctionTemplateImpl();
        return functionTemplate;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ClassTemplate createClassTemplate() {
        ClassTemplateImpl classTemplate = new ClassTemplateImpl();
        return classTemplate;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public PrimitiveTemplate createPrimitiveTemplate() {
        PrimitiveTemplateImpl primitiveTemplate = new PrimitiveTemplateImpl();
        return primitiveTemplate;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public OperatorTemplate createOperatorTemplate() {
        OperatorTemplateImpl operatorTemplate = new OperatorTemplateImpl();
        return operatorTemplate;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public EnumerationTemplate createEnumerationTemplate() {
        EnumerationTemplateImpl enumerationTemplate = new EnumerationTemplateImpl();
        return enumerationTemplate;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public EnumLiteralMapping createEnumLiteralMapping() {
        EnumLiteralMappingImpl enumLiteralMapping = new EnumLiteralMappingImpl();
        return enumLiteralMapping;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Symbol createSymbol() {
        SymbolImpl symbol = new SymbolImpl();
        return symbol;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Keyword createKeyword() {
        KeywordImpl keyword = new KeywordImpl();
        return keyword;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public OperatorList createOperatorList() {
        OperatorListImpl operatorList = new OperatorListImpl();
        return operatorList;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Priority createPriority() {
        PriorityImpl priority = new PriorityImpl();
        return priority;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Operator createOperator() {
        OperatorImpl operator = new OperatorImpl();
        return operator;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Sequence createSequence() {
        SequenceImpl sequence = new SequenceImpl();
        return sequence;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public LiteralRef createLiteralRef() {
        LiteralRefImpl literalRef = new LiteralRefImpl();
        return literalRef;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Property createProperty() {
        PropertyImpl property = new PropertyImpl();
        return property;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public CustomSeparator createCustomSeparator() {
        CustomSeparatorImpl customSeparator = new CustomSeparatorImpl();
        return customSeparator;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Block createBlock() {
        BlockImpl block = new BlockImpl();
        return block;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ConditionalElement createConditionalElement() {
        ConditionalElementImpl conditionalElement = new ConditionalElementImpl();
        return conditionalElement;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public PrimitivePropertyInit createPrimitivePropertyInit() {
        PrimitivePropertyInitImpl primitivePropertyInit = new PrimitivePropertyInitImpl();
        return primitivePropertyInit;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Alternative createAlternative() {
        AlternativeImpl alternative = new AlternativeImpl();
        return alternative;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public FunctionCall createFunctionCall() {
        FunctionCallImpl functionCall = new FunctionCallImpl();
        return functionCall;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public RefersToPArg createRefersToPArg() {
        RefersToPArgImpl refersToPArg = new RefersToPArgImpl();
        return refersToPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public LookInPArg createLookInPArg() {
        LookInPArgImpl lookInPArg = new LookInPArgImpl();
        return lookInPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public CreateInPArg createCreateInPArg() {
        CreateInPArgImpl createInPArg = new CreateInPArgImpl();
        return createInPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public RefersToKeyPArg createRefersToKeyPArg() {
        RefersToKeyPArgImpl refersToKeyPArg = new RefersToKeyPArgImpl();
        return refersToKeyPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public SeparatorPArg createSeparatorPArg() {
        SeparatorPArgImpl separatorPArg = new SeparatorPArgImpl();
        return separatorPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public AutoCreatePArg createAutoCreatePArg() {
        AutoCreatePArgImpl autoCreatePArg = new AutoCreatePArgImpl();
        return autoCreatePArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ImportContextPArg createImportContextPArg() {
        ImportContextPArgImpl importContextPArg = new ImportContextPArgImpl();
        return importContextPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ForcedLowerPArg createForcedLowerPArg() {
        ForcedLowerPArgImpl forcedLowerPArg = new ForcedLowerPArgImpl();
        return forcedLowerPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public CreateAsPArg createCreateAsPArg() {
        CreateAsPArgImpl createAsPArg = new CreateAsPArgImpl();
        return createAsPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public AsPArg createAsPArg() {
        AsPArgImpl asPArg = new AsPArgImpl();
        return asPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ModePArg createModePArg() {
        ModePArgImpl modePArg = new ModePArgImpl();
        return modePArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NbNLBArg createNbNLBArg() {
        NbNLBArgImpl nbNLBArg = new NbNLBArgImpl();
        return nbNLBArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public IndentIncrBArg createIndentIncrBArg() {
        IndentIncrBArgImpl indentIncrBArg = new IndentIncrBArgImpl();
        return indentIncrBArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public StartNLBArg createStartNLBArg() {
        StartNLBArgImpl startNLBArg = new StartNLBArgImpl();
        return startNLBArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public StartNbNLBArg createStartNbNLBArg() {
        StartNbNLBArgImpl startNbNLBArg = new StartNbNLBArgImpl();
        return startNbNLBArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public EndNLBArg createEndNLBArg() {
        EndNLBArgImpl endNLBArg = new EndNLBArgImpl();
        return endNLBArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public AndExp createAndExp() {
        AndExpImpl andExp = new AndExpImpl();
        return andExp;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public EqualsExp createEqualsExp() {
        EqualsExpImpl equalsExp = new EqualsExpImpl();
        return equalsExp;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public BooleanPropertyExp createBooleanPropertyExp() {
        BooleanPropertyExpImpl booleanPropertyExp = new BooleanPropertyExpImpl();
        return booleanPropertyExp;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public IsDefinedExp createIsDefinedExp() {
        IsDefinedExpImpl isDefinedExp = new IsDefinedExpImpl();
        return isDefinedExp;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public OneExp createOneExp() {
        OneExpImpl oneExp = new OneExpImpl();
        return oneExp;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public PropertyVal createPropertyVal() {
        PropertyValImpl propertyVal = new PropertyValImpl();
        return propertyVal;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Token createToken() {
        TokenImpl token = new TokenImpl();
        return token;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public OrPattern createOrPattern() {
        OrPatternImpl orPattern = new OrPatternImpl();
        return orPattern;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public RulePattern createRulePattern() {
        RulePatternImpl rulePattern = new RulePatternImpl();
        return rulePattern;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public WordRule createWordRule() {
        WordRuleImpl wordRule = new WordRuleImpl();
        return wordRule;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public Word createWord() {
        WordImpl word = new WordImpl();
        return word;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public EndOfLineRule createEndOfLineRule() {
        EndOfLineRuleImpl endOfLineRule = new EndOfLineRuleImpl();
        return endOfLineRule;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public MultiLineRule createMultiLineRule() {
        MultiLineRuleImpl multiLineRule = new MultiLineRuleImpl();
        return multiLineRule;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public SimpleMapping createSimpleMapping() {
        SimpleMappingImpl simpleMapping = new SimpleMappingImpl();
        return simpleMapping;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public WildcardMapping createWildcardMapping() {
        WildcardMappingImpl wildcardMapping = new WildcardMappingImpl();
        return wildcardMapping;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public OctalMapping createOctalMapping() {
        OctalMappingImpl octalMapping = new OctalMappingImpl();
        return octalMapping;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public HexadecimalMapping createHexadecimalMapping() {
        HexadecimalMappingImpl hexadecimalMapping = new HexadecimalMappingImpl();
        return hexadecimalMapping;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public StringPattern createStringPattern() {
        StringPatternImpl stringPattern = new StringPatternImpl();
        return stringPattern;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ClassPattern createClassPattern() {
        ClassPatternImpl classPattern = new ClassPatternImpl();
        return classPattern;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public QualifiedNamedElement createQualifiedNamedElement() {
        QualifiedNamedElementImpl qualifiedNamedElement = new QualifiedNamedElementImpl();
        return qualifiedNamedElement;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ForcedUpperPArg createForcedUpperPArg() {
        ForcedUpperPArgImpl forcedUpperPArg = new ForcedUpperPArgImpl();
        return forcedUpperPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public InjectorActionsBlock createInjectorActionsBlock() {
        InjectorActionsBlockImpl injectorActionsBlock = new InjectorActionsBlockImpl();
        return injectorActionsBlock;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public LookupScopePArg createLookupScopePArg() {
        LookupScopePArgImpl lookupScopePArg = new LookupScopePArgImpl();
        return lookupScopePArg;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ReferenceByPArg createReferenceByPArg() {
        ReferenceByPArgImpl referenceByPArg = new ReferenceByPArgImpl();
        return referenceByPArg;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PrefixPArg createPrefixPArg() {
        PrefixPArgImpl prefixPArg = new PrefixPArgImpl();
        return prefixPArg;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PostfixPArg createPostfixPArg() {
        PostfixPArgImpl postfixPArg = new PostfixPArgImpl();
        return postfixPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public PropertyReference createPropertyReference() {
        PropertyReferenceImpl propertyReference = new PropertyReferenceImpl();
        return propertyReference;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ContextTemplate createContextTemplate() {
        ContextTemplateImpl contextTemplate = new ContextTemplateImpl();
        return contextTemplate;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ContextTags createContextTags() {
        ContextTagsImpl contextTags = new ContextTagsImpl();
        return contextTags;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public OclPropertyInit createOclPropertyInit() {
        OclPropertyInitImpl oclPropertyInit = new OclPropertyInitImpl();
        return oclPropertyInit;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ScopeArg createScopeArg() {
        ScopeArgImpl scopeArg = new ScopeArgImpl();
        return scopeArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public ForeachPredicatePropertyInit createForeachPredicatePropertyInit() {
        ForeachPredicatePropertyInitImpl foreachPredicatePropertyInit = new ForeachPredicatePropertyInitImpl();
        return foreachPredicatePropertyInit;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public PredicateSemantic createPredicateSemantic() {
        PredicateSemanticImpl predicateSemantic = new PredicateSemanticImpl();
        return predicateSemantic;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public SequenceInAlternative createSequenceInAlternative() {
        SequenceInAlternativeImpl sequenceInAlternative = new SequenceInAlternativeImpl();
        return sequenceInAlternative;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public PartialPArg createPartialPArg() {
        PartialPArgImpl partialPArg = new PartialPArgImpl();
        return partialPArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public DisambiguatePArg createDisambiguatePArg() {
        DisambiguatePArgImpl disambiguatePArg = new DisambiguatePArgImpl();
        return disambiguatePArg;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public InstanceOfExp createInstanceOfExp() {
        InstanceOfExpImpl instanceOfExp = new InstanceOfExpImpl();
        return instanceOfExp;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public EnumLiteralVal createEnumLiteralVal() {
        EnumLiteralValImpl enumLiteralVal = new EnumLiteralValImpl();
        return enumLiteralVal;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public StringVal createStringVal() {
        StringValImpl stringVal = new StringValImpl();
        return stringVal;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public IntegerVal createIntegerVal() {
        IntegerValImpl integerVal = new IntegerValImpl();
        return integerVal;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public NegativeIntegerVal createNegativeIntegerVal() {
        NegativeIntegerValImpl negativeIntegerVal = new NegativeIntegerValImpl();
        return negativeIntegerVal;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
        public LookupPropertyInit createLookupPropertyInit() {
        LookupPropertyInitImpl lookupPropertyInit = new LookupPropertyInitImpl();
        return lookupPropertyInit;
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
        @Override
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
