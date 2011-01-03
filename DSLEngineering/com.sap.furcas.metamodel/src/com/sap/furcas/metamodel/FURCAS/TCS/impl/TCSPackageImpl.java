/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.ecore.EcorePackage;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.AndExp;
import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Associativity;
import com.sap.furcas.metamodel.FURCAS.TCS.AtomExp;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.BlockArg;
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
import com.sap.furcas.metamodel.FURCAS.TCS.Expression;
import com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.HexadecimalMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.ImportContextPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.InstanceOfExp;
import com.sap.furcas.metamodel.FURCAS.TCS.IntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.InvertPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.IsDefinedExp;
import com.sap.furcas.metamodel.FURCAS.TCS.Keyword;
import com.sap.furcas.metamodel.FURCAS.TCS.Literal;
import com.sap.furcas.metamodel.FURCAS.TCS.LiteralRef;
import com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.Mapping;
import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.MultiLineRule;
import com.sap.furcas.metamodel.FURCAS.TCS.NamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.NegativeIntegerVal;
import com.sap.furcas.metamodel.FURCAS.TCS.OclPArg;
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
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyVal;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToKeyPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Rule;
import com.sap.furcas.metamodel.FURCAS.TCS.RulePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.ScopeArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ScopeKind;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SimpleMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.SimplePattern;
import com.sap.furcas.metamodel.FURCAS.TCS.SpaceKind;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StringPattern;
import com.sap.furcas.metamodel.FURCAS.TCS.StringVal;
import com.sap.furcas.metamodel.FURCAS.TCS.Symbol;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSFactory;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.TCS.TemplateModifiers;
import com.sap.furcas.metamodel.FURCAS.TCS.Token;
import com.sap.furcas.metamodel.FURCAS.TCS.Value;
import com.sap.furcas.metamodel.FURCAS.TCS.WildcardMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.Word;
import com.sap.furcas.metamodel.FURCAS.TCS.WordRule;
import com.sap.furcas.metamodel.FURCAS.TCS.*;
import com.sap.furcas.metamodel.FURCAS.impl.FURCASPackageImpl;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage;
import com.sap.furcas.metamodel.FURCAS.textblockdefinition.impl.TextblockdefinitionPackageImpl;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage;
import com.sap.furcas.metamodel.FURCAS.textblocks.impl.TextblocksPackageImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TCSPackageImpl extends EPackageImpl implements TCSPackage {
        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass locatedElementEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass namedElementEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass concreteSyntaxEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass templateEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass functionTemplateEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass classTemplateEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass primitiveTemplateEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass operatorTemplateEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass enumerationTemplateEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass enumLiteralMappingEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass literalEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass symbolEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass keywordEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass operatorListEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass priorityEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass operatorEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass sequenceEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass sequenceElementEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass literalRefEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass propertyEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass customSeparatorEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass blockEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass conditionalElementEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass primitivePropertyInitEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass alternativeEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass functionCallEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass propertyArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass refersToPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass lookInPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass createInPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass refersToKeyPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass separatorPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass autoCreatePArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass importContextPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass forcedLowerPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass createAsPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass asPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass modePArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass blockArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass nbNLBArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass indentIncrBArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass startNLBArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass startNbNLBArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass endNLBArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass expressionEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass andExpEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass atomExpEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass equalsExpEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass booleanPropertyExpEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass isDefinedExpEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass oneExpEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass valueEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass propertyValEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass tokenEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass orPatternEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass simplePatternEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass rulePatternEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass ruleEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass wordRuleEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass wordEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass endOfLineRuleEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass multiLineRuleEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass mappingEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass simpleMappingEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass wildcardMappingEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass octalMappingEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass hexadecimalMappingEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass stringPatternEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass classPatternEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass qualifiedNamedElementEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass forcedUpperPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass injectorActionsBlockEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass queryPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass queryByIdentifierPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass filterPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass oclPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass propertyReferenceEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass contextTemplateEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass contextTagsEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass injectorActionEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass propertyInitEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass oclPropertyInitEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass scopeArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass foreachPredicatePropertyInitEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass predicateSemanticEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass sequenceInAlternativeEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass partialPArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass disambiguatePArgEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass instanceOfExpEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass enumLiteralValEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass stringValEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass integerValEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass negativeIntegerValEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EClass lookupPropertyInitEClass = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EEnum templateModifiersEEnum = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EEnum spaceKindEEnum = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EEnum associativityEEnum = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EEnum autoCreateKindEEnum = null;

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private EEnum scopeKindEEnum = null;

        /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#eNS_URI
     * @see #init()
     * @generated
     */
        private TCSPackageImpl() {
        super(eNS_URI, TCSFactory.eINSTANCE);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private static boolean isInited = false;

        /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link TCSPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
        public static TCSPackage init() {
        if (isInited) return (TCSPackage)EPackage.Registry.INSTANCE.getEPackage(TCSPackage.eNS_URI);

        // Obtain or create and register package
        TCSPackageImpl theTCSPackage = (TCSPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TCSPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TCSPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        FURCASPackageImpl theFURCASPackage = (FURCASPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FURCASPackage.eNS_URI) instanceof FURCASPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FURCASPackage.eNS_URI) : FURCASPackage.eINSTANCE);
        TextblocksPackageImpl theTextblocksPackage = (TextblocksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) instanceof TextblocksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblocksPackage.eNS_URI) : TextblocksPackage.eINSTANCE);
        TextblockdefinitionPackageImpl theTextblockdefinitionPackage = (TextblockdefinitionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI) instanceof TextblockdefinitionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI) : TextblockdefinitionPackage.eINSTANCE);

        // Create package meta-data objects
        theTCSPackage.createPackageContents();
        theFURCASPackage.createPackageContents();
        theTextblocksPackage.createPackageContents();
        theTextblockdefinitionPackage.createPackageContents();

        // Initialize created meta-data
        theTCSPackage.initializePackageContents();
        theFURCASPackage.initializePackageContents();
        theTextblocksPackage.initializePackageContents();
        theTextblockdefinitionPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theTCSPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(TCSPackage.eNS_URI, theTCSPackage);
        return theTCSPackage;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getLocatedElement() {
        return locatedElementEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getLocatedElement_Location() {
        return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getLocatedElement_CommentsBefore() {
        return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getLocatedElement_CommentsAfter() {
        return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getNamedElement() {
        return namedElementEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getNamedElement_Name() {
        return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getConcreteSyntax() {
        return concreteSyntaxEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getConcreteSyntax_K() {
        return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getConcreteSyntax_Templates() {
        return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getConcreteSyntax_Keywords() {
        return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getConcreteSyntax_Symbols() {
        return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getConcreteSyntax_OperatorLists() {
        return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(4);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getConcreteSyntax_Tokens() {
        return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(5);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getConcreteSyntax_Lexer() {
        return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(6);
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConcreteSyntax_Uuid() {
        return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(7);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getTemplate() {
        return templateEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getTemplate_ConcreteSyntax() {
        return (EReference)templateEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getTemplate_Disambiguate() {
        return (EAttribute)templateEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getTemplate_DisambiguateV3() {
        return (EAttribute)templateEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getTemplate_SemDisambiguate() {
        return (EAttribute)templateEClass.getEStructuralFeatures().get(3);
    }

								/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTemplate_TextBlockDefinition() {
        return (EReference)templateEClass.getEStructuralFeatures().get(4);
    }

								/**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getFunctionTemplate() {
        return functionTemplateEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getFunctionTemplate_FunctionName() {
        return (EAttribute)functionTemplateEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getFunctionTemplate_FunctionSequence() {
        return (EReference)functionTemplateEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getClassTemplate() {
        return classTemplateEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getClassTemplate_Modifiers() {
        return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getClassTemplate_IsAbstract() {
        return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getClassTemplate_IsDeep() {
        return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getClassTemplate_IsOperatored() {
        return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getClassTemplate_OperatorList() {
        return (EReference)classTemplateEClass.getEStructuralFeatures().get(4);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getClassTemplate_IsMain() {
        return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(5);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getClassTemplate_IsMulti() {
        return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(6);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getClassTemplate_IsNonPrimary() {
        return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(7);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getClassTemplate_Mode() {
        return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(8);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getPrimitiveTemplate() {
        return primitiveTemplateEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getPrimitiveTemplate_TemplateName() {
        return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPrimitiveTemplate_Default() {
        return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getPrimitiveTemplate_TokenName() {
        return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getPrimitiveTemplate_Value() {
        return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getPrimitiveTemplate_Serializer() {
        return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(4);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getPrimitiveTemplate_OrKeyword() {
        return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(5);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getOperatorTemplate() {
        return operatorTemplateEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getOperatorTemplate_Operators() {
        return (EReference)operatorTemplateEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getOperatorTemplate_Source() {
        return (EAttribute)operatorTemplateEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getOperatorTemplate_StoreOpTo() {
        return (EAttribute)operatorTemplateEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getOperatorTemplate_StoreRightTo() {
        return (EAttribute)operatorTemplateEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getOperatorTemplate_StoreOperatorTo() {
        return (EReference)operatorTemplateEClass.getEStructuralFeatures().get(4);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getOperatorTemplate_StoreLeftSideTo() {
        return (EReference)operatorTemplateEClass.getEStructuralFeatures().get(5);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getOperatorTemplate_StoreRightSideTo() {
        return (EReference)operatorTemplateEClass.getEStructuralFeatures().get(6);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getEnumerationTemplate() {
        return enumerationTemplateEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getEnumerationTemplate_Automatic() {
        return (EAttribute)enumerationTemplateEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getEnumerationTemplate_Mappings() {
        return (EReference)enumerationTemplateEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getEnumLiteralMapping() {
        return enumLiteralMappingEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getEnumLiteralMapping_Literal() {
        return (EReference)enumLiteralMappingEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getEnumLiteralMapping_Element() {
        return (EReference)enumLiteralMappingEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getLiteral() {
        return literalEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getLiteral_Operators() {
        return (EReference)literalEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getLiteral_LiteralRefs() {
        return (EReference)literalEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getLiteral_Value() {
        return (EAttribute)literalEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getSymbol() {
        return symbolEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getSymbol_Spaces() {
        return (EAttribute)symbolEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getKeyword() {
        return keywordEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getOperatorList() {
        return operatorListEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getOperatorList_Name() {
        return (EAttribute)operatorListEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getOperatorList_Priorities() {
        return (EReference)operatorListEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getPriority() {
        return priorityEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getPriority_List() {
        return (EReference)priorityEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getPriority_Value() {
        return (EAttribute)priorityEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getPriority_Associativity() {
        return (EAttribute)priorityEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getPriority_Operators() {
        return (EReference)priorityEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getOperator() {
        return operatorEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getOperator_Postfix() {
        return (EAttribute)operatorEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getOperator_Arity() {
        return (EAttribute)operatorEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getOperator_Literal() {
        return (EReference)operatorEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getOperator_Priority() {
        return (EReference)operatorEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getOperator_Templates() {
        return (EReference)operatorEClass.getEStructuralFeatures().get(4);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getSequence() {
        return sequenceEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_Elements() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_TemplateContainer() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_PrefixContainer() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_FunctionContainer() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_BlockContainer() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(4);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_ThenContainer() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(5);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_ElseContainer() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(6);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_SeparatorContainer() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(7);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequence_OtContainer() {
        return (EReference)sequenceEClass.getEStructuralFeatures().get(8);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getSequenceElement() {
        return sequenceElementEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequenceElement_ElementSequence() {
        return (EReference)sequenceElementEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getSequenceElement_ParentTemplate() {
        return (EReference)sequenceElementEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getLiteralRef() {
        return literalRefEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getLiteralRef_ReferredLiteral() {
        return (EReference)literalRefEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getProperty() {
        return propertyEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getProperty_PropertyArgs() {
        return (EReference)propertyEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getProperty_PropertyReference() {
        return (EReference)propertyEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getCustomSeparator() {
        return customSeparatorEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EAttribute getCustomSeparator_Name() {
        return (EAttribute)customSeparatorEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getBlock() {
        return blockEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getBlock_BlockSequence() {
        return (EReference)blockEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EReference getBlock_BlockArgs() {
        return (EReference)blockEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        @Override
	public EClass getConditionalElement() {
        return conditionalElementEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getConditionalElement_Condition() {
        return (EReference)conditionalElementEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getConditionalElement_ThenSequence() {
        return (EReference)conditionalElementEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getConditionalElement_ElseSequence() {
        return (EReference)conditionalElementEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getPrimitivePropertyInit() {
        return primitivePropertyInitEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getAlternative() {
        return alternativeEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getAlternative_Sequences() {
        return (EReference)alternativeEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getAlternative_IsMulti() {
        return (EAttribute)alternativeEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getFunctionCall() {
        return functionCallEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getFunctionCall_CalledFunction() {
        return (EReference)functionCallEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getPropertyArg() {
        return propertyArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getPropertyArg_Property() {
        return (EReference)propertyArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getRefersToPArg() {
        return refersToPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getRefersToPArg_PropertyName() {
        return (EAttribute)refersToPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getLookInPArg() {
        return lookInPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getLookInPArg_PropertyName() {
        return (EAttribute)lookInPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getCreateInPArg() {
        return createInPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getCreateInPArg_PropertyName() {
        return (EAttribute)createInPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getRefersToKeyPArg() {
        return refersToKeyPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getSeparatorPArg() {
        return separatorPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getSeparatorPArg_SeparatorSequence() {
        return (EReference)separatorPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getAutoCreatePArg() {
        return autoCreatePArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getAutoCreatePArg_Value() {
        return (EAttribute)autoCreatePArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getImportContextPArg() {
        return importContextPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getForcedLowerPArg() {
        return forcedLowerPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getForcedLowerPArg_Value() {
        return (EAttribute)forcedLowerPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getCreateAsPArg() {
        return createAsPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getCreateAsPArg_Name() {
        return (EAttribute)createAsPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getAsPArg() {
        return asPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getAsPArg_Template() {
        return (EReference)asPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getAsPArg_Value() {
        return (EAttribute)asPArgEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getModePArg() {
        return modePArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getModePArg_Mode() {
        return (EAttribute)modePArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getBlockArg() {
        return blockArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getBlockArg_Block() {
        return (EReference)blockArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getNbNLBArg() {
        return nbNLBArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNbNLBArg_Value() {
        return (EAttribute)nbNLBArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getIndentIncrBArg() {
        return indentIncrBArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getIndentIncrBArg_Value() {
        return (EAttribute)indentIncrBArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getStartNLBArg() {
        return startNLBArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStartNLBArg_Value() {
        return (EAttribute)startNLBArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getStartNbNLBArg() {
        return startNbNLBArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStartNbNLBArg_Value() {
        return (EAttribute)startNbNLBArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getEndNLBArg() {
        return endNLBArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getEndNLBArg_Value() {
        return (EAttribute)endNLBArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getExpression() {
        return expressionEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getExpression_ConditionalElement() {
        return (EReference)expressionEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getAndExp() {
        return andExpEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getAndExp_Expressions() {
        return (EReference)andExpEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getAtomExp() {
        return atomExpEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getAtomExp_AndExp() {
        return (EReference)atomExpEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getAtomExp_PropertyName() {
        return (EAttribute)atomExpEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getAtomExp_PropertyReference() {
        return (EReference)atomExpEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getEqualsExp() {
        return equalsExpEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getEqualsExp_Value() {
        return (EReference)equalsExpEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getBooleanPropertyExp() {
        return booleanPropertyExpEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getIsDefinedExp() {
        return isDefinedExpEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getOneExp() {
        return oneExpEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getValue() {
        return valueEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getValue_Name() {
        return (EAttribute)valueEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getPropertyVal() {
        return propertyValEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getToken() {
        return tokenEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getToken_Pattern() {
        return (EReference)tokenEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getToken_Omitted() {
        return (EAttribute)tokenEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getOrPattern() {
        return orPatternEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getOrPattern_SimplePatterns() {
        return (EReference)orPatternEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getSimplePattern() {
        return simplePatternEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getRulePattern() {
        return rulePatternEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getRulePattern_Rule() {
        return (EReference)rulePatternEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getRule() {
        return ruleEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getWordRule() {
        return wordRuleEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getWordRule_Start() {
        return (EReference)wordRuleEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getWordRule_Part() {
        return (EReference)wordRuleEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getWordRule_End() {
        return (EReference)wordRuleEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getWordRule_Words() {
        return (EReference)wordRuleEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getWord() {
        return wordEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getWord_Token() {
        return (EAttribute)wordEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getEndOfLineRule() {
        return endOfLineRuleEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getEndOfLineRule_Start() {
        return (EReference)endOfLineRuleEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getEndOfLineRule_DropStart() {
        return (EAttribute)endOfLineRuleEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getMultiLineRule() {
        return multiLineRuleEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getMultiLineRule_Start() {
        return (EReference)multiLineRuleEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getMultiLineRule_End() {
        return (EReference)multiLineRuleEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getMultiLineRule_Esc() {
        return (EReference)multiLineRuleEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getMultiLineRule_EscMappings() {
        return (EReference)multiLineRuleEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getMultiLineRule_DropStart() {
        return (EAttribute)multiLineRuleEClass.getEStructuralFeatures().get(4);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getMultiLineRule_DropEnd() {
        return (EAttribute)multiLineRuleEClass.getEStructuralFeatures().get(5);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getMapping() {
        return mappingEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getSimpleMapping() {
        return simpleMappingEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleMapping_Key() {
        return (EAttribute)simpleMappingEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSimpleMapping_Value() {
        return (EAttribute)simpleMappingEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getWildcardMapping() {
        return wildcardMappingEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getOctalMapping() {
        return octalMappingEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getHexadecimalMapping() {
        return hexadecimalMappingEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getStringPattern() {
        return stringPatternEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getClassPattern() {
        return classPatternEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getQualifiedNamedElement() {
        return qualifiedNamedElementEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getQualifiedNamedElement_Names() {
        return (EAttribute)qualifiedNamedElementEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getQualifiedNamedElement_MetaReference() {
        return (EReference)qualifiedNamedElementEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getForcedUpperPArg() {
        return forcedUpperPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getForcedUpperPArg_Value() {
        return (EAttribute)forcedUpperPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getInjectorActionsBlock() {
        return injectorActionsBlockEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getInjectorActionsBlock_PropertyInits() {
        return (EReference)injectorActionsBlockEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getInjectorActionsBlock_InjectorActions() {
        return (EReference)injectorActionsBlockEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getQueryPArg() {
        return queryPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryPArg_Query() {
        return (EAttribute)queryPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getQueryByIdentifierPArg() {
        return queryByIdentifierPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryByIdentifierPArg_Query() {
        return (EAttribute)queryByIdentifierPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getQueryByIdentifierPArg_Feature() {
        return (EAttribute)queryByIdentifierPArgEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getFilterPArg() {
        return filterPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getFilterPArg_Filter() {
        return (EAttribute)filterPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getFilterPArg_Invert() {
        return (EAttribute)filterPArgEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getOclPArg() {
        return oclPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getOclPArg_QueryExpression() {
        return (EReference)oclPArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getOclPArg_Query() {
        return (EAttribute)oclPArgEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getPropertyReference() {
        return propertyReferenceEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getPropertyReference_Strucfeature() {
        return (EReference)propertyReferenceEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getPropertyReference_Name() {
        return (EAttribute)propertyReferenceEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getContextTemplate() {
        return contextTemplateEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getContextTemplate_IsContext() {
        return (EAttribute)contextTemplateEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getContextTemplate_IsAddToContext() {
        return (EAttribute)contextTemplateEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getContextTemplate_IsReferenceOnly() {
        return (EAttribute)contextTemplateEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getContextTemplate_ContextTags() {
        return (EReference)contextTemplateEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getContextTemplate_Scope() {
        return (EReference)contextTemplateEClass.getEStructuralFeatures().get(4);
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getContextTemplate_TemplateSequence() {
        return (EReference)contextTemplateEClass.getEStructuralFeatures().get(5);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getContextTags() {
        return contextTagsEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getContextTags_Tags() {
        return (EAttribute)contextTagsEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getInjectorAction() {
        return injectorActionEClass;
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInjectorAction_InjectorActionsBlock() {
        return (EReference)injectorActionEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getPropertyInit() {
        return propertyInitEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getPropertyInit_PropertyReference() {
        return (EReference)propertyInitEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getPropertyInit_Value() {
        return (EAttribute)propertyInitEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPropertyInit_Default() {
        return (EAttribute)propertyInitEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getOclPropertyInit() {
        return oclPropertyInitEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getOclPropertyInit_OclExpression() {
        return (EReference)oclPropertyInitEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getScopeArg() {
        return scopeArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getScopeArg_Scope() {
        return (EAttribute)scopeArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getForeachPredicatePropertyInit() {
        return foreachPredicatePropertyInitEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getForeachPredicatePropertyInit_PredicateSemantic() {
        return (EReference)foreachPredicatePropertyInitEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getForeachPredicatePropertyInit_Mode() {
        return (EAttribute)foreachPredicatePropertyInitEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getPredicateSemantic() {
        return predicateSemanticEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getPredicateSemantic_As() {
        return (EReference)predicateSemanticEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getPredicateSemantic_When() {
        return (EReference)predicateSemanticEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getPredicateSemantic_Mode() {
        return (EAttribute)predicateSemanticEClass.getEStructuralFeatures().get(2);
    }

        /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPredicateSemantic_ForeachParent() {
        return (EReference)predicateSemanticEClass.getEStructuralFeatures().get(3);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getSequenceInAlternative() {
        return sequenceInAlternativeEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EReference getSequenceInAlternative_AlternativeContainer() {
        return (EReference)sequenceInAlternativeEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getSequenceInAlternative_Disambiguate() {
        return (EAttribute)sequenceInAlternativeEClass.getEStructuralFeatures().get(1);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getPartialPArg() {
        return partialPArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getDisambiguatePArg() {
        return disambiguatePArgEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getDisambiguatePArg_Disambiguation() {
        return (EAttribute)disambiguatePArgEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getInstanceOfExp() {
        return instanceOfExpEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getInstanceOfExp_Supertype() {
        return (EAttribute)instanceOfExpEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getEnumLiteralVal() {
        return enumLiteralValEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getStringVal() {
        return stringValEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getStringVal_Symbol() {
        return (EAttribute)stringValEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getIntegerVal() {
        return integerValEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getIntegerVal_Symbol() {
        return (EAttribute)integerValEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getNegativeIntegerVal() {
        return negativeIntegerValEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EAttribute getNegativeIntegerVal_Symbol() {
        return (EAttribute)negativeIntegerValEClass.getEStructuralFeatures().get(0);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EClass getLookupPropertyInit() {
        return lookupPropertyInitEClass;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EEnum getTemplateModifiers() {
        return templateModifiersEEnum;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EEnum getSpaceKind() {
        return spaceKindEEnum;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EEnum getAssociativity() {
        return associativityEEnum;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EEnum getAutoCreateKind() {
        return autoCreateKindEEnum;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public EEnum getScopeKind() {
        return scopeKindEEnum;
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public TCSFactory getTCSFactory() {
        return (TCSFactory)getEFactoryInstance();
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private boolean isCreated = false;

        /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        locatedElementEClass = createEClass(LOCATED_ELEMENT);
        createEAttribute(locatedElementEClass, LOCATED_ELEMENT__LOCATION);
        createEAttribute(locatedElementEClass, LOCATED_ELEMENT__COMMENTS_BEFORE);
        createEAttribute(locatedElementEClass, LOCATED_ELEMENT__COMMENTS_AFTER);

        namedElementEClass = createEClass(NAMED_ELEMENT);
        createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

        concreteSyntaxEClass = createEClass(CONCRETE_SYNTAX);
        createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__K);
        createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__TEMPLATES);
        createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__KEYWORDS);
        createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__SYMBOLS);
        createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__OPERATOR_LISTS);
        createEReference(concreteSyntaxEClass, CONCRETE_SYNTAX__TOKENS);
        createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__LEXER);
        createEAttribute(concreteSyntaxEClass, CONCRETE_SYNTAX__UUID);

        templateEClass = createEClass(TEMPLATE);
        createEReference(templateEClass, TEMPLATE__CONCRETE_SYNTAX);
        createEAttribute(templateEClass, TEMPLATE__DISAMBIGUATE);
        createEAttribute(templateEClass, TEMPLATE__DISAMBIGUATE_V3);
        createEAttribute(templateEClass, TEMPLATE__SEM_DISAMBIGUATE);
        createEReference(templateEClass, TEMPLATE__TEXT_BLOCK_DEFINITION);

        functionTemplateEClass = createEClass(FUNCTION_TEMPLATE);
        createEAttribute(functionTemplateEClass, FUNCTION_TEMPLATE__FUNCTION_NAME);
        createEReference(functionTemplateEClass, FUNCTION_TEMPLATE__FUNCTION_SEQUENCE);

        classTemplateEClass = createEClass(CLASS_TEMPLATE);
        createEAttribute(classTemplateEClass, CLASS_TEMPLATE__MODIFIERS);
        createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_ABSTRACT);
        createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_DEEP);
        createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_OPERATORED);
        createEReference(classTemplateEClass, CLASS_TEMPLATE__OPERATOR_LIST);
        createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_MAIN);
        createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_MULTI);
        createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_NON_PRIMARY);
        createEAttribute(classTemplateEClass, CLASS_TEMPLATE__MODE);

        primitiveTemplateEClass = createEClass(PRIMITIVE_TEMPLATE);
        createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__TEMPLATE_NAME);
        createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__DEFAULT);
        createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__TOKEN_NAME);
        createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__VALUE);
        createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__SERIALIZER);
        createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__OR_KEYWORD);

        operatorTemplateEClass = createEClass(OPERATOR_TEMPLATE);
        createEReference(operatorTemplateEClass, OPERATOR_TEMPLATE__OPERATORS);
        createEAttribute(operatorTemplateEClass, OPERATOR_TEMPLATE__SOURCE);
        createEAttribute(operatorTemplateEClass, OPERATOR_TEMPLATE__STORE_OP_TO);
        createEAttribute(operatorTemplateEClass, OPERATOR_TEMPLATE__STORE_RIGHT_TO);
        createEReference(operatorTemplateEClass, OPERATOR_TEMPLATE__STORE_OPERATOR_TO);
        createEReference(operatorTemplateEClass, OPERATOR_TEMPLATE__STORE_LEFT_SIDE_TO);
        createEReference(operatorTemplateEClass, OPERATOR_TEMPLATE__STORE_RIGHT_SIDE_TO);

        enumerationTemplateEClass = createEClass(ENUMERATION_TEMPLATE);
        createEAttribute(enumerationTemplateEClass, ENUMERATION_TEMPLATE__AUTOMATIC);
        createEReference(enumerationTemplateEClass, ENUMERATION_TEMPLATE__MAPPINGS);

        enumLiteralMappingEClass = createEClass(ENUM_LITERAL_MAPPING);
        createEReference(enumLiteralMappingEClass, ENUM_LITERAL_MAPPING__LITERAL);
        createEReference(enumLiteralMappingEClass, ENUM_LITERAL_MAPPING__ELEMENT);

        literalEClass = createEClass(LITERAL);
        createEReference(literalEClass, LITERAL__OPERATORS);
        createEReference(literalEClass, LITERAL__LITERAL_REFS);
        createEAttribute(literalEClass, LITERAL__VALUE);

        symbolEClass = createEClass(SYMBOL);
        createEAttribute(symbolEClass, SYMBOL__SPACES);

        keywordEClass = createEClass(KEYWORD);

        operatorListEClass = createEClass(OPERATOR_LIST);
        createEAttribute(operatorListEClass, OPERATOR_LIST__NAME);
        createEReference(operatorListEClass, OPERATOR_LIST__PRIORITIES);

        priorityEClass = createEClass(PRIORITY);
        createEReference(priorityEClass, PRIORITY__LIST);
        createEAttribute(priorityEClass, PRIORITY__VALUE);
        createEAttribute(priorityEClass, PRIORITY__ASSOCIATIVITY);
        createEReference(priorityEClass, PRIORITY__OPERATORS);

        operatorEClass = createEClass(OPERATOR);
        createEAttribute(operatorEClass, OPERATOR__POSTFIX);
        createEAttribute(operatorEClass, OPERATOR__ARITY);
        createEReference(operatorEClass, OPERATOR__LITERAL);
        createEReference(operatorEClass, OPERATOR__PRIORITY);
        createEReference(operatorEClass, OPERATOR__TEMPLATES);

        sequenceEClass = createEClass(SEQUENCE);
        createEReference(sequenceEClass, SEQUENCE__ELEMENTS);
        createEReference(sequenceEClass, SEQUENCE__TEMPLATE_CONTAINER);
        createEReference(sequenceEClass, SEQUENCE__PREFIX_CONTAINER);
        createEReference(sequenceEClass, SEQUENCE__FUNCTION_CONTAINER);
        createEReference(sequenceEClass, SEQUENCE__BLOCK_CONTAINER);
        createEReference(sequenceEClass, SEQUENCE__THEN_CONTAINER);
        createEReference(sequenceEClass, SEQUENCE__ELSE_CONTAINER);
        createEReference(sequenceEClass, SEQUENCE__SEPARATOR_CONTAINER);
        createEReference(sequenceEClass, SEQUENCE__OT_CONTAINER);

        sequenceElementEClass = createEClass(SEQUENCE_ELEMENT);
        createEReference(sequenceElementEClass, SEQUENCE_ELEMENT__ELEMENT_SEQUENCE);
        createEReference(sequenceElementEClass, SEQUENCE_ELEMENT__PARENT_TEMPLATE);

        literalRefEClass = createEClass(LITERAL_REF);
        createEReference(literalRefEClass, LITERAL_REF__REFERRED_LITERAL);

        propertyEClass = createEClass(PROPERTY);
        createEReference(propertyEClass, PROPERTY__PROPERTY_ARGS);
        createEReference(propertyEClass, PROPERTY__PROPERTY_REFERENCE);

        customSeparatorEClass = createEClass(CUSTOM_SEPARATOR);
        createEAttribute(customSeparatorEClass, CUSTOM_SEPARATOR__NAME);

        blockEClass = createEClass(BLOCK);
        createEReference(blockEClass, BLOCK__BLOCK_SEQUENCE);
        createEReference(blockEClass, BLOCK__BLOCK_ARGS);

        conditionalElementEClass = createEClass(CONDITIONAL_ELEMENT);
        createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__CONDITION);
        createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__THEN_SEQUENCE);
        createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__ELSE_SEQUENCE);

        primitivePropertyInitEClass = createEClass(PRIMITIVE_PROPERTY_INIT);

        alternativeEClass = createEClass(ALTERNATIVE);
        createEReference(alternativeEClass, ALTERNATIVE__SEQUENCES);
        createEAttribute(alternativeEClass, ALTERNATIVE__IS_MULTI);

        functionCallEClass = createEClass(FUNCTION_CALL);
        createEReference(functionCallEClass, FUNCTION_CALL__CALLED_FUNCTION);

        propertyArgEClass = createEClass(PROPERTY_ARG);
        createEReference(propertyArgEClass, PROPERTY_ARG__PROPERTY);

        refersToPArgEClass = createEClass(REFERS_TO_PARG);
        createEAttribute(refersToPArgEClass, REFERS_TO_PARG__PROPERTY_NAME);

        lookInPArgEClass = createEClass(LOOK_IN_PARG);
        createEAttribute(lookInPArgEClass, LOOK_IN_PARG__PROPERTY_NAME);

        createInPArgEClass = createEClass(CREATE_IN_PARG);
        createEAttribute(createInPArgEClass, CREATE_IN_PARG__PROPERTY_NAME);

        refersToKeyPArgEClass = createEClass(REFERS_TO_KEY_PARG);

        separatorPArgEClass = createEClass(SEPARATOR_PARG);
        createEReference(separatorPArgEClass, SEPARATOR_PARG__SEPARATOR_SEQUENCE);

        autoCreatePArgEClass = createEClass(AUTO_CREATE_PARG);
        createEAttribute(autoCreatePArgEClass, AUTO_CREATE_PARG__VALUE);

        importContextPArgEClass = createEClass(IMPORT_CONTEXT_PARG);

        forcedLowerPArgEClass = createEClass(FORCED_LOWER_PARG);
        createEAttribute(forcedLowerPArgEClass, FORCED_LOWER_PARG__VALUE);

        createAsPArgEClass = createEClass(CREATE_AS_PARG);
        createEAttribute(createAsPArgEClass, CREATE_AS_PARG__NAME);

        asPArgEClass = createEClass(AS_PARG);
        createEReference(asPArgEClass, AS_PARG__TEMPLATE);
        createEAttribute(asPArgEClass, AS_PARG__VALUE);

        modePArgEClass = createEClass(MODE_PARG);
        createEAttribute(modePArgEClass, MODE_PARG__MODE);

        blockArgEClass = createEClass(BLOCK_ARG);
        createEReference(blockArgEClass, BLOCK_ARG__BLOCK);

        nbNLBArgEClass = createEClass(NB_NLB_ARG);
        createEAttribute(nbNLBArgEClass, NB_NLB_ARG__VALUE);

        indentIncrBArgEClass = createEClass(INDENT_INCR_BARG);
        createEAttribute(indentIncrBArgEClass, INDENT_INCR_BARG__VALUE);

        startNLBArgEClass = createEClass(START_NLB_ARG);
        createEAttribute(startNLBArgEClass, START_NLB_ARG__VALUE);

        startNbNLBArgEClass = createEClass(START_NB_NLB_ARG);
        createEAttribute(startNbNLBArgEClass, START_NB_NLB_ARG__VALUE);

        endNLBArgEClass = createEClass(END_NLB_ARG);
        createEAttribute(endNLBArgEClass, END_NLB_ARG__VALUE);

        expressionEClass = createEClass(EXPRESSION);
        createEReference(expressionEClass, EXPRESSION__CONDITIONAL_ELEMENT);

        andExpEClass = createEClass(AND_EXP);
        createEReference(andExpEClass, AND_EXP__EXPRESSIONS);

        atomExpEClass = createEClass(ATOM_EXP);
        createEReference(atomExpEClass, ATOM_EXP__AND_EXP);
        createEAttribute(atomExpEClass, ATOM_EXP__PROPERTY_NAME);
        createEReference(atomExpEClass, ATOM_EXP__PROPERTY_REFERENCE);

        equalsExpEClass = createEClass(EQUALS_EXP);
        createEReference(equalsExpEClass, EQUALS_EXP__VALUE);

        booleanPropertyExpEClass = createEClass(BOOLEAN_PROPERTY_EXP);

        isDefinedExpEClass = createEClass(IS_DEFINED_EXP);

        oneExpEClass = createEClass(ONE_EXP);

        valueEClass = createEClass(VALUE);
        createEAttribute(valueEClass, VALUE__NAME);

        propertyValEClass = createEClass(PROPERTY_VAL);

        tokenEClass = createEClass(TOKEN);
        createEReference(tokenEClass, TOKEN__PATTERN);
        createEAttribute(tokenEClass, TOKEN__OMITTED);

        orPatternEClass = createEClass(OR_PATTERN);
        createEReference(orPatternEClass, OR_PATTERN__SIMPLE_PATTERNS);

        simplePatternEClass = createEClass(SIMPLE_PATTERN);

        rulePatternEClass = createEClass(RULE_PATTERN);
        createEReference(rulePatternEClass, RULE_PATTERN__RULE);

        ruleEClass = createEClass(RULE);

        wordRuleEClass = createEClass(WORD_RULE);
        createEReference(wordRuleEClass, WORD_RULE__START);
        createEReference(wordRuleEClass, WORD_RULE__PART);
        createEReference(wordRuleEClass, WORD_RULE__END);
        createEReference(wordRuleEClass, WORD_RULE__WORDS);

        wordEClass = createEClass(WORD);
        createEAttribute(wordEClass, WORD__TOKEN);

        endOfLineRuleEClass = createEClass(END_OF_LINE_RULE);
        createEReference(endOfLineRuleEClass, END_OF_LINE_RULE__START);
        createEAttribute(endOfLineRuleEClass, END_OF_LINE_RULE__DROP_START);

        multiLineRuleEClass = createEClass(MULTI_LINE_RULE);
        createEReference(multiLineRuleEClass, MULTI_LINE_RULE__START);
        createEReference(multiLineRuleEClass, MULTI_LINE_RULE__END);
        createEReference(multiLineRuleEClass, MULTI_LINE_RULE__ESC);
        createEReference(multiLineRuleEClass, MULTI_LINE_RULE__ESC_MAPPINGS);
        createEAttribute(multiLineRuleEClass, MULTI_LINE_RULE__DROP_START);
        createEAttribute(multiLineRuleEClass, MULTI_LINE_RULE__DROP_END);

        mappingEClass = createEClass(MAPPING);

        simpleMappingEClass = createEClass(SIMPLE_MAPPING);
        createEAttribute(simpleMappingEClass, SIMPLE_MAPPING__KEY);
        createEAttribute(simpleMappingEClass, SIMPLE_MAPPING__VALUE);

        wildcardMappingEClass = createEClass(WILDCARD_MAPPING);

        octalMappingEClass = createEClass(OCTAL_MAPPING);

        hexadecimalMappingEClass = createEClass(HEXADECIMAL_MAPPING);

        stringPatternEClass = createEClass(STRING_PATTERN);

        classPatternEClass = createEClass(CLASS_PATTERN);

        qualifiedNamedElementEClass = createEClass(QUALIFIED_NAMED_ELEMENT);
        createEAttribute(qualifiedNamedElementEClass, QUALIFIED_NAMED_ELEMENT__NAMES);
        createEReference(qualifiedNamedElementEClass, QUALIFIED_NAMED_ELEMENT__META_REFERENCE);

        forcedUpperPArgEClass = createEClass(FORCED_UPPER_PARG);
        createEAttribute(forcedUpperPArgEClass, FORCED_UPPER_PARG__VALUE);

        injectorActionsBlockEClass = createEClass(INJECTOR_ACTIONS_BLOCK);
        createEReference(injectorActionsBlockEClass, INJECTOR_ACTIONS_BLOCK__PROPERTY_INITS);
        createEReference(injectorActionsBlockEClass, INJECTOR_ACTIONS_BLOCK__INJECTOR_ACTIONS);

        queryPArgEClass = createEClass(QUERY_PARG);
        createEAttribute(queryPArgEClass, QUERY_PARG__QUERY);

        queryByIdentifierPArgEClass = createEClass(QUERY_BY_IDENTIFIER_PARG);
        createEAttribute(queryByIdentifierPArgEClass, QUERY_BY_IDENTIFIER_PARG__QUERY);
        createEAttribute(queryByIdentifierPArgEClass, QUERY_BY_IDENTIFIER_PARG__FEATURE);

        filterPArgEClass = createEClass(FILTER_PARG);
        createEAttribute(filterPArgEClass, FILTER_PARG__FILTER);
        createEAttribute(filterPArgEClass, FILTER_PARG__INVERT);

        oclPArgEClass = createEClass(OCL_PARG);
        createEReference(oclPArgEClass, OCL_PARG__QUERY_EXPRESSION);
        createEAttribute(oclPArgEClass, OCL_PARG__QUERY);

        propertyReferenceEClass = createEClass(PROPERTY_REFERENCE);
        createEReference(propertyReferenceEClass, PROPERTY_REFERENCE__STRUCFEATURE);
        createEAttribute(propertyReferenceEClass, PROPERTY_REFERENCE__NAME);

        contextTemplateEClass = createEClass(CONTEXT_TEMPLATE);
        createEAttribute(contextTemplateEClass, CONTEXT_TEMPLATE__IS_CONTEXT);
        createEAttribute(contextTemplateEClass, CONTEXT_TEMPLATE__IS_ADD_TO_CONTEXT);
        createEAttribute(contextTemplateEClass, CONTEXT_TEMPLATE__IS_REFERENCE_ONLY);
        createEReference(contextTemplateEClass, CONTEXT_TEMPLATE__CONTEXT_TAGS);
        createEReference(contextTemplateEClass, CONTEXT_TEMPLATE__SCOPE);
        createEReference(contextTemplateEClass, CONTEXT_TEMPLATE__TEMPLATE_SEQUENCE);

        contextTagsEClass = createEClass(CONTEXT_TAGS);
        createEAttribute(contextTagsEClass, CONTEXT_TAGS__TAGS);

        injectorActionEClass = createEClass(INJECTOR_ACTION);
        createEReference(injectorActionEClass, INJECTOR_ACTION__INJECTOR_ACTIONS_BLOCK);

        propertyInitEClass = createEClass(PROPERTY_INIT);
        createEReference(propertyInitEClass, PROPERTY_INIT__PROPERTY_REFERENCE);
        createEAttribute(propertyInitEClass, PROPERTY_INIT__VALUE);
        createEAttribute(propertyInitEClass, PROPERTY_INIT__DEFAULT);

        oclPropertyInitEClass = createEClass(OCL_PROPERTY_INIT);
        createEReference(oclPropertyInitEClass, OCL_PROPERTY_INIT__OCL_EXPRESSION);

        scopeArgEClass = createEClass(SCOPE_ARG);
        createEAttribute(scopeArgEClass, SCOPE_ARG__SCOPE);

        foreachPredicatePropertyInitEClass = createEClass(FOREACH_PREDICATE_PROPERTY_INIT);
        createEReference(foreachPredicatePropertyInitEClass, FOREACH_PREDICATE_PROPERTY_INIT__PREDICATE_SEMANTIC);
        createEAttribute(foreachPredicatePropertyInitEClass, FOREACH_PREDICATE_PROPERTY_INIT__MODE);

        predicateSemanticEClass = createEClass(PREDICATE_SEMANTIC);
        createEReference(predicateSemanticEClass, PREDICATE_SEMANTIC__AS);
        createEReference(predicateSemanticEClass, PREDICATE_SEMANTIC__WHEN);
        createEAttribute(predicateSemanticEClass, PREDICATE_SEMANTIC__MODE);
        createEReference(predicateSemanticEClass, PREDICATE_SEMANTIC__FOREACH_PARENT);

        sequenceInAlternativeEClass = createEClass(SEQUENCE_IN_ALTERNATIVE);
        createEReference(sequenceInAlternativeEClass, SEQUENCE_IN_ALTERNATIVE__ALTERNATIVE_CONTAINER);
        createEAttribute(sequenceInAlternativeEClass, SEQUENCE_IN_ALTERNATIVE__DISAMBIGUATE);

        partialPArgEClass = createEClass(PARTIAL_PARG);

        disambiguatePArgEClass = createEClass(DISAMBIGUATE_PARG);
        createEAttribute(disambiguatePArgEClass, DISAMBIGUATE_PARG__DISAMBIGUATION);

        instanceOfExpEClass = createEClass(INSTANCE_OF_EXP);
        createEAttribute(instanceOfExpEClass, INSTANCE_OF_EXP__SUPERTYPE);

        enumLiteralValEClass = createEClass(ENUM_LITERAL_VAL);

        stringValEClass = createEClass(STRING_VAL);
        createEAttribute(stringValEClass, STRING_VAL__SYMBOL);

        integerValEClass = createEClass(INTEGER_VAL);
        createEAttribute(integerValEClass, INTEGER_VAL__SYMBOL);

        negativeIntegerValEClass = createEClass(NEGATIVE_INTEGER_VAL);
        createEAttribute(negativeIntegerValEClass, NEGATIVE_INTEGER_VAL__SYMBOL);

        lookupPropertyInitEClass = createEClass(LOOKUP_PROPERTY_INIT);

        // Create enums
        templateModifiersEEnum = createEEnum(TEMPLATE_MODIFIERS);
        spaceKindEEnum = createEEnum(SPACE_KIND);
        associativityEEnum = createEEnum(ASSOCIATIVITY);
        autoCreateKindEEnum = createEEnum(AUTO_CREATE_KIND);
        scopeKindEEnum = createEEnum(SCOPE_KIND);
    }

        /**
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private boolean isInitialized = false;

        /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        org.eclipse.emf.ecore.EcorePackage theEcorePackage_1 = (org.eclipse.emf.ecore.EcorePackage)EPackage.Registry.INSTANCE.getEPackage(org.eclipse.emf.ecore.EcorePackage.eNS_URI);
        TextblockdefinitionPackage theTextblockdefinitionPackage = (TextblockdefinitionPackage)EPackage.Registry.INSTANCE.getEPackage(TextblockdefinitionPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        namedElementEClass.getESuperTypes().add(this.getLocatedElement());
        concreteSyntaxEClass.getESuperTypes().add(this.getNamedElement());
        templateEClass.getESuperTypes().add(this.getQualifiedNamedElement());
        functionTemplateEClass.getESuperTypes().add(this.getTemplate());
        classTemplateEClass.getESuperTypes().add(this.getContextTemplate());
        primitiveTemplateEClass.getESuperTypes().add(this.getTemplate());
        operatorTemplateEClass.getESuperTypes().add(this.getContextTemplate());
        enumerationTemplateEClass.getESuperTypes().add(this.getTemplate());
        enumLiteralMappingEClass.getESuperTypes().add(this.getLocatedElement());
        literalEClass.getESuperTypes().add(this.getNamedElement());
        symbolEClass.getESuperTypes().add(this.getLiteral());
        keywordEClass.getESuperTypes().add(this.getLiteral());
        operatorListEClass.getESuperTypes().add(this.getLocatedElement());
        priorityEClass.getESuperTypes().add(this.getLocatedElement());
        operatorEClass.getESuperTypes().add(this.getNamedElement());
        sequenceEClass.getESuperTypes().add(this.getLocatedElement());
        sequenceElementEClass.getESuperTypes().add(this.getLocatedElement());
        literalRefEClass.getESuperTypes().add(this.getSequenceElement());
        propertyEClass.getESuperTypes().add(this.getSequenceElement());
        customSeparatorEClass.getESuperTypes().add(this.getSequenceElement());
        blockEClass.getESuperTypes().add(this.getSequenceElement());
        conditionalElementEClass.getESuperTypes().add(this.getSequenceElement());
        primitivePropertyInitEClass.getESuperTypes().add(this.getPropertyInit());
        alternativeEClass.getESuperTypes().add(this.getSequenceElement());
        functionCallEClass.getESuperTypes().add(this.getSequenceElement());
        propertyArgEClass.getESuperTypes().add(this.getLocatedElement());
        refersToPArgEClass.getESuperTypes().add(this.getPropertyArg());
        lookInPArgEClass.getESuperTypes().add(this.getPropertyArg());
        createInPArgEClass.getESuperTypes().add(this.getPropertyArg());
        refersToKeyPArgEClass.getESuperTypes().add(this.getPropertyArg());
        separatorPArgEClass.getESuperTypes().add(this.getPropertyArg());
        autoCreatePArgEClass.getESuperTypes().add(this.getPropertyArg());
        importContextPArgEClass.getESuperTypes().add(this.getPropertyArg());
        forcedLowerPArgEClass.getESuperTypes().add(this.getPropertyArg());
        createAsPArgEClass.getESuperTypes().add(this.getPropertyArg());
        asPArgEClass.getESuperTypes().add(this.getPropertyArg());
        modePArgEClass.getESuperTypes().add(this.getPropertyArg());
        blockArgEClass.getESuperTypes().add(this.getLocatedElement());
        nbNLBArgEClass.getESuperTypes().add(this.getBlockArg());
        indentIncrBArgEClass.getESuperTypes().add(this.getBlockArg());
        startNLBArgEClass.getESuperTypes().add(this.getBlockArg());
        startNbNLBArgEClass.getESuperTypes().add(this.getBlockArg());
        endNLBArgEClass.getESuperTypes().add(this.getBlockArg());
        expressionEClass.getESuperTypes().add(this.getLocatedElement());
        andExpEClass.getESuperTypes().add(this.getExpression());
        atomExpEClass.getESuperTypes().add(this.getLocatedElement());
        equalsExpEClass.getESuperTypes().add(this.getAtomExp());
        booleanPropertyExpEClass.getESuperTypes().add(this.getAtomExp());
        isDefinedExpEClass.getESuperTypes().add(this.getAtomExp());
        oneExpEClass.getESuperTypes().add(this.getAtomExp());
        valueEClass.getESuperTypes().add(this.getLocatedElement());
        propertyValEClass.getESuperTypes().add(this.getValue());
        tokenEClass.getESuperTypes().add(this.getNamedElement());
        orPatternEClass.getESuperTypes().add(this.getLocatedElement());
        simplePatternEClass.getESuperTypes().add(this.getNamedElement());
        rulePatternEClass.getESuperTypes().add(this.getSimplePattern());
        ruleEClass.getESuperTypes().add(this.getLocatedElement());
        wordRuleEClass.getESuperTypes().add(this.getRule());
        wordEClass.getESuperTypes().add(this.getNamedElement());
        endOfLineRuleEClass.getESuperTypes().add(this.getRule());
        multiLineRuleEClass.getESuperTypes().add(this.getRule());
        mappingEClass.getESuperTypes().add(this.getLocatedElement());
        simpleMappingEClass.getESuperTypes().add(this.getMapping());
        wildcardMappingEClass.getESuperTypes().add(this.getMapping());
        octalMappingEClass.getESuperTypes().add(this.getMapping());
        hexadecimalMappingEClass.getESuperTypes().add(this.getMapping());
        stringPatternEClass.getESuperTypes().add(this.getSimplePattern());
        classPatternEClass.getESuperTypes().add(this.getSimplePattern());
        qualifiedNamedElementEClass.getESuperTypes().add(this.getLocatedElement());
        forcedUpperPArgEClass.getESuperTypes().add(this.getPropertyArg());
        injectorActionsBlockEClass.getESuperTypes().add(this.getSequenceElement());
        queryPArgEClass.getESuperTypes().add(this.getPropertyArg());
        queryByIdentifierPArgEClass.getESuperTypes().add(this.getPropertyArg());
        filterPArgEClass.getESuperTypes().add(this.getPropertyArg());
        oclPArgEClass.getESuperTypes().add(this.getPropertyArg());
        contextTemplateEClass.getESuperTypes().add(this.getTemplate());
        propertyInitEClass.getESuperTypes().add(this.getInjectorAction());
        oclPropertyInitEClass.getESuperTypes().add(this.getPropertyInit());
        foreachPredicatePropertyInitEClass.getESuperTypes().add(this.getPropertyInit());
        sequenceInAlternativeEClass.getESuperTypes().add(this.getSequence());
        partialPArgEClass.getESuperTypes().add(this.getPropertyArg());
        disambiguatePArgEClass.getESuperTypes().add(this.getPropertyArg());
        instanceOfExpEClass.getESuperTypes().add(this.getAtomExp());
        enumLiteralValEClass.getESuperTypes().add(this.getValue());
        stringValEClass.getESuperTypes().add(this.getValue());
        integerValEClass.getESuperTypes().add(this.getValue());
        negativeIntegerValEClass.getESuperTypes().add(this.getValue());
        lookupPropertyInitEClass.getESuperTypes().add(this.getPropertyInit());

        // Initialize classes and features; add operations and parameters
        initEClass(locatedElementEClass, LocatedElement.class, "LocatedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLocatedElement_Location(), ecorePackage.getEString(), "location", null, 0, 1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getLocatedElement_CommentsBefore(), ecorePackage.getEString(), "commentsBefore", null, 0, -1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLocatedElement_CommentsAfter(), ecorePackage.getEString(), "commentsAfter", null, 0, -1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(concreteSyntaxEClass, ConcreteSyntax.class, "ConcreteSyntax", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getConcreteSyntax_K(), theEcorePackage_1.getEIntegerObject(), "k", null, 0, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getConcreteSyntax_Templates(), this.getTemplate(), this.getTemplate_ConcreteSyntax(), "templates", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConcreteSyntax_Keywords(), this.getKeyword(), null, "keywords", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConcreteSyntax_Symbols(), this.getSymbol(), null, "symbols", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConcreteSyntax_OperatorLists(), this.getOperatorList(), null, "operatorLists", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConcreteSyntax_Tokens(), this.getToken(), null, "tokens", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getConcreteSyntax_Lexer(), ecorePackage.getEString(), "lexer", null, 1, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getConcreteSyntax_Uuid(), ecorePackage.getEString(), "uuid", null, 0, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(templateEClass, Template.class, "Template", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTemplate_ConcreteSyntax(), this.getConcreteSyntax(), this.getConcreteSyntax_Templates(), "concreteSyntax", null, 1, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getTemplate_Disambiguate(), ecorePackage.getEString(), "disambiguate", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getTemplate_DisambiguateV3(), ecorePackage.getEString(), "disambiguateV3", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getTemplate_SemDisambiguate(), ecorePackage.getEString(), "semDisambiguate", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTemplate_TextBlockDefinition(), theTextblockdefinitionPackage.getTextBlockDefinition(), theTextblockdefinitionPackage.getTextBlockDefinition_ParseRule(), "textBlockDefinition", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(functionTemplateEClass, FunctionTemplate.class, "FunctionTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFunctionTemplate_FunctionName(), ecorePackage.getEString(), "functionName", null, 1, 1, FunctionTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getFunctionTemplate_FunctionSequence(), this.getSequence(), this.getSequence_FunctionContainer(), "functionSequence", null, 1, 1, FunctionTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(classTemplateEClass, ClassTemplate.class, "ClassTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getClassTemplate_Modifiers(), this.getTemplateModifiers(), "modifiers", null, 0, -1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getClassTemplate_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getClassTemplate_IsDeep(), ecorePackage.getEBoolean(), "isDeep", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getClassTemplate_IsOperatored(), ecorePackage.getEBoolean(), "isOperatored", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getClassTemplate_OperatorList(), this.getOperatorList(), null, "operatorList", null, 0, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getClassTemplate_IsMain(), ecorePackage.getEBoolean(), "isMain", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getClassTemplate_IsMulti(), ecorePackage.getEBoolean(), "isMulti", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getClassTemplate_IsNonPrimary(), ecorePackage.getEBoolean(), "isNonPrimary", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getClassTemplate_Mode(), ecorePackage.getEString(), "mode", null, 0, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(primitiveTemplateEClass, PrimitiveTemplate.class, "PrimitiveTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPrimitiveTemplate_TemplateName(), ecorePackage.getEString(), "templateName", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPrimitiveTemplate_Default(), ecorePackage.getEBoolean(), "default", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPrimitiveTemplate_TokenName(), ecorePackage.getEString(), "tokenName", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPrimitiveTemplate_Value(), ecorePackage.getEString(), "value", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPrimitiveTemplate_Serializer(), ecorePackage.getEString(), "serializer", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPrimitiveTemplate_OrKeyword(), ecorePackage.getEBoolean(), "orKeyword", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(operatorTemplateEClass, OperatorTemplate.class, "OperatorTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperatorTemplate_Operators(), this.getOperator(), this.getOperator_Templates(), "operators", null, 0, -1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getOperatorTemplate_Source(), ecorePackage.getEString(), "source", null, 1, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getOperatorTemplate_StoreOpTo(), ecorePackage.getEString(), "storeOpTo", null, 0, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getOperatorTemplate_StoreRightTo(), ecorePackage.getEString(), "storeRightTo", null, 0, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getOperatorTemplate_StoreOperatorTo(), this.getPropertyReference(), null, "storeOperatorTo", null, 0, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperatorTemplate_StoreLeftSideTo(), this.getPropertyReference(), null, "storeLeftSideTo", null, 0, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperatorTemplate_StoreRightSideTo(), this.getPropertyReference(), null, "storeRightSideTo", null, 0, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enumerationTemplateEClass, EnumerationTemplate.class, "EnumerationTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEnumerationTemplate_Automatic(), ecorePackage.getEBoolean(), "automatic", null, 1, 1, EnumerationTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getEnumerationTemplate_Mappings(), this.getEnumLiteralMapping(), null, "mappings", null, 0, -1, EnumerationTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enumLiteralMappingEClass, EnumLiteralMapping.class, "EnumLiteralMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEnumLiteralMapping_Literal(), this.getEnumLiteralVal(), null, "literal", null, 1, 1, EnumLiteralMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getEnumLiteralMapping_Element(), this.getSequenceElement(), null, "element", null, 0, 1, EnumLiteralMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLiteral_Operators(), this.getOperator(), this.getOperator_Literal(), "operators", null, 0, -1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getLiteral_LiteralRefs(), this.getLiteralRef(), this.getLiteralRef_ReferredLiteral(), "literalRefs", null, 0, -1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getLiteral_Value(), ecorePackage.getEString(), "value", null, 1, 1, Literal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(symbolEClass, Symbol.class, "Symbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSymbol_Spaces(), this.getSpaceKind(), "spaces", null, 0, -1, Symbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(keywordEClass, Keyword.class, "Keyword", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(operatorListEClass, OperatorList.class, "OperatorList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperatorList_Name(), ecorePackage.getEString(), "name", null, 0, 1, OperatorList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getOperatorList_Priorities(), this.getPriority(), this.getPriority_List(), "priorities", null, 0, -1, OperatorList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(priorityEClass, Priority.class, "Priority", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPriority_List(), this.getOperatorList(), this.getOperatorList_Priorities(), "list", null, 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPriority_Value(), ecorePackage.getEIntegerObject(), "value", null, 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPriority_Associativity(), this.getAssociativity(), "associativity", null, 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getPriority_Operators(), this.getOperator(), this.getOperator_Priority(), "operators", null, 0, -1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getOperator_Postfix(), ecorePackage.getEBoolean(), "postfix", null, 1, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getOperator_Arity(), ecorePackage.getEIntegerObject(), "arity", null, 1, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getOperator_Literal(), this.getLiteral(), this.getLiteral_Operators(), "literal", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getOperator_Priority(), this.getPriority(), this.getPriority_Operators(), "priority", null, 1, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getOperator_Templates(), this.getOperatorTemplate(), this.getOperatorTemplate_Operators(), "templates", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSequence_Elements(), this.getSequenceElement(), this.getSequenceElement_ElementSequence(), "elements", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSequence_TemplateContainer(), this.getClassTemplate(), null, "templateContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSequence_PrefixContainer(), this.getClassTemplate(), null, "prefixContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSequence_FunctionContainer(), this.getFunctionTemplate(), this.getFunctionTemplate_FunctionSequence(), "functionContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSequence_BlockContainer(), this.getBlock(), this.getBlock_BlockSequence(), "blockContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSequence_ThenContainer(), this.getConditionalElement(), this.getConditionalElement_ThenSequence(), "thenContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSequence_ElseContainer(), this.getConditionalElement(), this.getConditionalElement_ElseSequence(), "elseContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSequence_SeparatorContainer(), this.getSeparatorPArg(), this.getSeparatorPArg_SeparatorSequence(), "separatorContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSequence_OtContainer(), this.getOperatorTemplate(), null, "otContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(sequenceElementEClass, SequenceElement.class, "SequenceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSequenceElement_ElementSequence(), this.getSequence(), this.getSequence_Elements(), "elementSequence", null, 0, 1, SequenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSequenceElement_ParentTemplate(), this.getTemplate(), null, "parentTemplate", null, 0, 1, SequenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(literalRefEClass, LiteralRef.class, "LiteralRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLiteralRef_ReferredLiteral(), this.getLiteral(), this.getLiteral_LiteralRefs(), "referredLiteral", null, 1, 1, LiteralRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getProperty_PropertyArgs(), this.getPropertyArg(), this.getPropertyArg_Property(), "propertyArgs", null, 0, -1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getProperty_PropertyReference(), this.getPropertyReference(), null, "propertyReference", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(customSeparatorEClass, CustomSeparator.class, "CustomSeparator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCustomSeparator_Name(), ecorePackage.getEString(), "name", null, 1, 1, CustomSeparator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBlock_BlockSequence(), this.getSequence(), this.getSequence_BlockContainer(), "blockSequence", null, 1, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getBlock_BlockArgs(), this.getBlockArg(), this.getBlockArg_Block(), "blockArgs", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(conditionalElementEClass, ConditionalElement.class, "ConditionalElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConditionalElement_Condition(), this.getExpression(), this.getExpression_ConditionalElement(), "condition", null, 1, 1, ConditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getConditionalElement_ThenSequence(), this.getSequence(), this.getSequence_ThenContainer(), "thenSequence", null, 1, 1, ConditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getConditionalElement_ElseSequence(), this.getSequence(), this.getSequence_ElseContainer(), "elseSequence", null, 1, 1, ConditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(primitivePropertyInitEClass, PrimitivePropertyInit.class, "PrimitivePropertyInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(alternativeEClass, Alternative.class, "Alternative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAlternative_Sequences(), this.getSequenceInAlternative(), this.getSequenceInAlternative_AlternativeContainer(), "sequences", null, 2, -1, Alternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAlternative_IsMulti(), ecorePackage.getEBoolean(), "isMulti", null, 1, 1, Alternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionCall_CalledFunction(), this.getFunctionTemplate(), null, "calledFunction", null, 1, 1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(propertyArgEClass, PropertyArg.class, "PropertyArg", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPropertyArg_Property(), this.getProperty(), this.getProperty_PropertyArgs(), "property", null, 1, 1, PropertyArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(refersToPArgEClass, RefersToPArg.class, "RefersToPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getRefersToPArg_PropertyName(), theEcorePackage_1.getEString(), "propertyName", null, 1, 1, RefersToPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(lookInPArgEClass, LookInPArg.class, "LookInPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLookInPArg_PropertyName(), theEcorePackage_1.getEString(), "propertyName", null, 0, -1, LookInPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(createInPArgEClass, CreateInPArg.class, "CreateInPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCreateInPArg_PropertyName(), theEcorePackage_1.getEString(), "propertyName", null, 0, -1, CreateInPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(refersToKeyPArgEClass, RefersToKeyPArg.class, "RefersToKeyPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(separatorPArgEClass, SeparatorPArg.class, "SeparatorPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSeparatorPArg_SeparatorSequence(), this.getSequence(), this.getSequence_SeparatorContainer(), "separatorSequence", null, 1, 1, SeparatorPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(autoCreatePArgEClass, AutoCreatePArg.class, "AutoCreatePArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAutoCreatePArg_Value(), this.getAutoCreateKind(), "value", null, 1, 1, AutoCreatePArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(importContextPArgEClass, ImportContextPArg.class, "ImportContextPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(forcedLowerPArgEClass, ForcedLowerPArg.class, "ForcedLowerPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getForcedLowerPArg_Value(), ecorePackage.getEIntegerObject(), "value", "0", 1, 1, ForcedLowerPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(createAsPArgEClass, CreateAsPArg.class, "CreateAsPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCreateAsPArg_Name(), theEcorePackage_1.getEString(), "name", null, 0, -1, CreateAsPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(asPArgEClass, AsPArg.class, "AsPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAsPArg_Template(), this.getTemplate(), null, "template", null, 1, 1, AsPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAsPArg_Value(), theEcorePackage_1.getEString(), "value", null, 1, 1, AsPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(modePArgEClass, ModePArg.class, "ModePArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getModePArg_Mode(), theEcorePackage_1.getEString(), "mode", null, 1, 1, ModePArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(blockArgEClass, BlockArg.class, "BlockArg", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getBlockArg_Block(), this.getBlock(), this.getBlock_BlockArgs(), "block", null, 1, 1, BlockArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(nbNLBArgEClass, NbNLBArg.class, "NbNLBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNbNLBArg_Value(), ecorePackage.getEIntegerObject(), "value", null, 0, 1, NbNLBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(indentIncrBArgEClass, IndentIncrBArg.class, "IndentIncrBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIndentIncrBArg_Value(), ecorePackage.getEIntegerObject(), "value", null, 0, 1, IndentIncrBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(startNLBArgEClass, StartNLBArg.class, "StartNLBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStartNLBArg_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, StartNLBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(startNbNLBArgEClass, StartNbNLBArg.class, "StartNbNLBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStartNbNLBArg_Value(), ecorePackage.getEIntegerObject(), "value", null, 0, 1, StartNbNLBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(endNLBArgEClass, EndNLBArg.class, "EndNLBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEndNLBArg_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, EndNLBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getExpression_ConditionalElement(), this.getConditionalElement(), this.getConditionalElement_Condition(), "conditionalElement", null, 1, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(andExpEClass, AndExp.class, "AndExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAndExp_Expressions(), this.getAtomExp(), this.getAtomExp_AndExp(), "expressions", null, 0, -1, AndExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(atomExpEClass, AtomExp.class, "AtomExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAtomExp_AndExp(), this.getAndExp(), this.getAndExp_Expressions(), "andExp", null, 1, 1, AtomExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getAtomExp_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, 1, AtomExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAtomExp_PropertyReference(), this.getPropertyReference(), null, "propertyReference", null, 0, 1, AtomExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(equalsExpEClass, EqualsExp.class, "EqualsExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEqualsExp_Value(), this.getValue(), null, "value", null, 1, 1, EqualsExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(booleanPropertyExpEClass, BooleanPropertyExp.class, "BooleanPropertyExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(isDefinedExpEClass, IsDefinedExp.class, "IsDefinedExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(oneExpEClass, OneExp.class, "OneExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getValue_Name(), theEcorePackage_1.getEString(), "name", null, 1, 1, Value.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyValEClass, PropertyVal.class, "PropertyVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(tokenEClass, Token.class, "Token", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getToken_Pattern(), this.getOrPattern(), null, "pattern", null, 1, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getToken_Omitted(), theEcorePackage_1.getEBoolean(), "omitted", null, 0, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(orPatternEClass, OrPattern.class, "OrPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOrPattern_SimplePatterns(), this.getSimplePattern(), null, "simplePatterns", null, 1, -1, OrPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(simplePatternEClass, SimplePattern.class, "SimplePattern", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(rulePatternEClass, RulePattern.class, "RulePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getRulePattern_Rule(), this.getRule(), null, "rule", null, 1, 1, RulePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(ruleEClass, Rule.class, "Rule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(wordRuleEClass, WordRule.class, "WordRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWordRule_Start(), this.getOrPattern(), null, "start", null, 1, 1, WordRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getWordRule_Part(), this.getOrPattern(), null, "part", null, 1, 1, WordRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getWordRule_End(), this.getOrPattern(), null, "end", null, 0, 1, WordRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getWordRule_Words(), this.getWord(), null, "words", null, 0, -1, WordRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(wordEClass, Word.class, "Word", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWord_Token(), ecorePackage.getEString(), "token", null, 1, 1, Word.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(endOfLineRuleEClass, EndOfLineRule.class, "EndOfLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getEndOfLineRule_Start(), this.getStringPattern(), null, "start", null, 1, 1, EndOfLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getEndOfLineRule_DropStart(), theEcorePackage_1.getEBoolean(), "dropStart", null, 0, 1, EndOfLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(multiLineRuleEClass, MultiLineRule.class, "MultiLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMultiLineRule_Start(), this.getStringPattern(), null, "start", null, 1, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getMultiLineRule_End(), this.getStringPattern(), null, "end", null, 1, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getMultiLineRule_Esc(), this.getStringPattern(), null, "esc", null, 0, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getMultiLineRule_EscMappings(), this.getMapping(), null, "escMappings", null, 0, -1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getMultiLineRule_DropStart(), theEcorePackage_1.getEBoolean(), "dropStart", null, 0, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getMultiLineRule_DropEnd(), theEcorePackage_1.getEBoolean(), "dropEnd", null, 0, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(mappingEClass, Mapping.class, "Mapping", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(simpleMappingEClass, SimpleMapping.class, "SimpleMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSimpleMapping_Key(), ecorePackage.getEString(), "key", null, 0, 1, SimpleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSimpleMapping_Value(), ecorePackage.getEString(), "value", null, 0, 1, SimpleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(wildcardMappingEClass, WildcardMapping.class, "WildcardMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(octalMappingEClass, OctalMapping.class, "OctalMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(hexadecimalMappingEClass, HexadecimalMapping.class, "HexadecimalMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(stringPatternEClass, StringPattern.class, "StringPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(classPatternEClass, ClassPattern.class, "ClassPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(qualifiedNamedElementEClass, QualifiedNamedElement.class, "QualifiedNamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQualifiedNamedElement_Names(), ecorePackage.getEString(), "names", null, 1, -1, QualifiedNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getQualifiedNamedElement_MetaReference(), ecorePackage.getEClassifier(), null, "metaReference", null, 0, 1, QualifiedNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(forcedUpperPArgEClass, ForcedUpperPArg.class, "ForcedUpperPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getForcedUpperPArg_Value(), ecorePackage.getEIntegerObject(), "value", "0", 1, 1, ForcedUpperPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(injectorActionsBlockEClass, InjectorActionsBlock.class, "InjectorActionsBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInjectorActionsBlock_PropertyInits(), this.getInjectorAction(), null, "propertyInits", null, 0, -1, InjectorActionsBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getInjectorActionsBlock_InjectorActions(), this.getInjectorAction(), this.getInjectorAction_InjectorActionsBlock(), "injectorActions", null, 0, -1, InjectorActionsBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(queryPArgEClass, QueryPArg.class, "QueryPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQueryPArg_Query(), ecorePackage.getEString(), "query", null, 1, 1, QueryPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(queryByIdentifierPArgEClass, QueryByIdentifierPArg.class, "QueryByIdentifierPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getQueryByIdentifierPArg_Query(), ecorePackage.getEString(), "query", null, 0, 1, QueryByIdentifierPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getQueryByIdentifierPArg_Feature(), ecorePackage.getEString(), "feature", null, 0, 1, QueryByIdentifierPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(filterPArgEClass, FilterPArg.class, "FilterPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getFilterPArg_Filter(), theEcorePackage_1.getEString(), "filter", null, 1, 1, FilterPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getFilterPArg_Invert(), theEcorePackage_1.getEString(), "invert", null, 1, 1, FilterPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(oclPArgEClass, OclPArg.class, "OclPArg", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOclPArg_QueryExpression(), theEcorePackage.getOCLExpression(), null, "queryExpression", null, 0, 1, OclPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getOclPArg_Query(), ecorePackage.getEString(), "query", null, 1, 1, OclPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyReferenceEClass, PropertyReference.class, "PropertyReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPropertyReference_Strucfeature(), theEcorePackage_1.getEStructuralFeature(), null, "strucfeature", null, 0, 1, PropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPropertyReference_Name(), ecorePackage.getEString(), "name", null, 1, 1, PropertyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(contextTemplateEClass, ContextTemplate.class, "ContextTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getContextTemplate_IsContext(), ecorePackage.getEBoolean(), "isContext", null, 1, 1, ContextTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getContextTemplate_IsAddToContext(), ecorePackage.getEBoolean(), "isAddToContext", null, 1, 1, ContextTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getContextTemplate_IsReferenceOnly(), ecorePackage.getEBoolean(), "isReferenceOnly", null, 1, 1, ContextTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContextTemplate_ContextTags(), this.getContextTags(), null, "contextTags", null, 0, 1, ContextTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContextTemplate_Scope(), this.getScopeArg(), null, "scope", null, 0, 1, ContextTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContextTemplate_TemplateSequence(), this.getSequence(), null, "templateSequence", null, 1, 1, ContextTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(contextTagsEClass, ContextTags.class, "ContextTags", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getContextTags_Tags(), ecorePackage.getEString(), "tags", null, 0, -1, ContextTags.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(injectorActionEClass, InjectorAction.class, "InjectorAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getInjectorAction_InjectorActionsBlock(), this.getInjectorActionsBlock(), this.getInjectorActionsBlock_InjectorActions(), "injectorActionsBlock", null, 0, 1, InjectorAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(propertyInitEClass, PropertyInit.class, "PropertyInit", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPropertyInit_PropertyReference(), this.getPropertyReference(), null, "propertyReference", null, 0, 1, PropertyInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPropertyInit_Value(), theEcorePackage_1.getEString(), "value", null, 0, 1, PropertyInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPropertyInit_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, PropertyInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(oclPropertyInitEClass, OclPropertyInit.class, "OclPropertyInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOclPropertyInit_OclExpression(), theEcorePackage.getOCLExpression(), null, "oclExpression", null, 0, 1, OclPropertyInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(scopeArgEClass, ScopeArg.class, "ScopeArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getScopeArg_Scope(), this.getScopeKind(), "scope", null, 1, 1, ScopeArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(foreachPredicatePropertyInitEClass, ForeachPredicatePropertyInit.class, "ForeachPredicatePropertyInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getForeachPredicatePropertyInit_PredicateSemantic(), this.getPredicateSemantic(), this.getPredicateSemantic_ForeachParent(), "predicateSemantic", null, 0, -1, ForeachPredicatePropertyInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getForeachPredicatePropertyInit_Mode(), theEcorePackage_1.getEString(), "mode", null, 0, 1, ForeachPredicatePropertyInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(predicateSemanticEClass, PredicateSemantic.class, "PredicateSemantic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPredicateSemantic_As(), this.getTemplate(), null, "as", null, 0, 1, PredicateSemantic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPredicateSemantic_When(), theEcorePackage.getOCLExpression(), null, "when", null, 0, 1, PredicateSemantic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPredicateSemantic_Mode(), theEcorePackage_1.getEString(), "mode", null, 0, 1, PredicateSemantic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPredicateSemantic_ForeachParent(), this.getForeachPredicatePropertyInit(), this.getForeachPredicatePropertyInit_PredicateSemantic(), "foreachParent", null, 1, 1, PredicateSemantic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(sequenceInAlternativeEClass, SequenceInAlternative.class, "SequenceInAlternative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSequenceInAlternative_AlternativeContainer(), this.getAlternative(), this.getAlternative_Sequences(), "alternativeContainer", null, 0, 1, SequenceInAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getSequenceInAlternative_Disambiguate(), ecorePackage.getEString(), "disambiguate", null, 0, 1, SequenceInAlternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(partialPArgEClass, PartialPArg.class, "PartialPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(disambiguatePArgEClass, DisambiguatePArg.class, "DisambiguatePArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDisambiguatePArg_Disambiguation(), theEcorePackage_1.getEString(), "disambiguation", null, 0, 1, DisambiguatePArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(instanceOfExpEClass, InstanceOfExp.class, "InstanceOfExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getInstanceOfExp_Supertype(), theEcorePackage_1.getEString(), "supertype", null, 0, -1, InstanceOfExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(enumLiteralValEClass, EnumLiteralVal.class, "EnumLiteralVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(stringValEClass, StringVal.class, "StringVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getStringVal_Symbol(), theEcorePackage_1.getEString(), "symbol", null, 0, 1, StringVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(integerValEClass, IntegerVal.class, "IntegerVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIntegerVal_Symbol(), ecorePackage.getEIntegerObject(), "symbol", null, 0, 1, IntegerVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(negativeIntegerValEClass, NegativeIntegerVal.class, "NegativeIntegerVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNegativeIntegerVal_Symbol(), theEcorePackage_1.getEIntegerObject(), "symbol", null, 0, 1, NegativeIntegerVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(lookupPropertyInitEClass, LookupPropertyInit.class, "LookupPropertyInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        initEEnum(templateModifiersEEnum, TemplateModifiers.class, "TemplateModifiers");
        addEEnumLiteral(templateModifiersEEnum, TemplateModifiers.ABSTRACT);
        addEEnumLiteral(templateModifiersEEnum, TemplateModifiers.OPERATORED);
        addEEnumLiteral(templateModifiersEEnum, TemplateModifiers.MAIN);
        addEEnumLiteral(templateModifiersEEnum, TemplateModifiers.CONTEXT);
        addEEnumLiteral(templateModifiersEEnum, TemplateModifiers.ADD_TO_CONTEXT);

        initEEnum(spaceKindEEnum, SpaceKind.class, "SpaceKind");
        addEEnumLiteral(spaceKindEEnum, SpaceKind.LEFT_SPACE);
        addEEnumLiteral(spaceKindEEnum, SpaceKind.LEFT_NONE);
        addEEnumLiteral(spaceKindEEnum, SpaceKind.RIGHT_SPACE);
        addEEnumLiteral(spaceKindEEnum, SpaceKind.RIGHT_NONE);

        initEEnum(associativityEEnum, Associativity.class, "Associativity");
        addEEnumLiteral(associativityEEnum, Associativity.LEFT);
        addEEnumLiteral(associativityEEnum, Associativity.RIGHT);

        initEEnum(autoCreateKindEEnum, AutoCreateKind.class, "AutoCreateKind");
        addEEnumLiteral(autoCreateKindEEnum, AutoCreateKind.ALWAYS);
        addEEnumLiteral(autoCreateKindEEnum, AutoCreateKind.IFMISSING);
        addEEnumLiteral(autoCreateKindEEnum, AutoCreateKind.NEVER);

        initEEnum(scopeKindEEnum, ScopeKind.class, "ScopeKind");
        addEEnumLiteral(scopeKindEEnum, ScopeKind.INSTANCE_COMPLETE);
        addEEnumLiteral(scopeKindEEnum, ScopeKind.DOWNWARDS_CONTAINMENT_COMPLETE);
        addEEnumLiteral(scopeKindEEnum, ScopeKind.UPWARDS_CONTAINMENT_COMPLETE);
        addEEnumLiteral(scopeKindEEnum, ScopeKind.CONTAINMENT_COMPLETE);
        addEEnumLiteral(scopeKindEEnum, ScopeKind.PARTIAL);

        // Create annotations
        // http://schema.omg.org/spec/MOF/2.0/emof.xml
        createEmofAnnotations();
    }

        /**
     * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createEmofAnnotations() {
        String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml";			
        addAnnotation
          (getQualifiedNamedElement_MetaReference(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "furcasTemplates"
           });		
        addAnnotation
          (getPropertyReference_Strucfeature(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "furcasPropertyReference"
           });
    }

} //TCSPackageImpl
