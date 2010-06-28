/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS.impl;

import TCS.Alternative;
import TCS.AndExp;
import TCS.AsPArg;
import TCS.Associativity;
import TCS.AtomExp;
import TCS.AutoCreateKind;
import TCS.AutoCreatePArg;
import TCS.Block;
import TCS.BlockArg;
import TCS.BooleanPropertyExp;
import TCS.ClassPattern;
import TCS.ClassTemplate;
import TCS.ConcreteSyntax;
import TCS.ConditionalElement;
import TCS.CreateAsPArg;
import TCS.CreateInPArg;
import TCS.CustomSeparator;
import TCS.EndNLBArg;
import TCS.EndOfLineRule;
import TCS.EnumLiteralMapping;
import TCS.EnumLiteralVal;
import TCS.EnumerationTemplate;
import TCS.EqualsExp;
import TCS.Expression;
import TCS.ForcedLowerPArg;
import TCS.FunctionCall;
import TCS.FunctionTemplate;
import TCS.HexadecimalMapping;
import TCS.ImportContextPArg;
import TCS.IndentIncrBArg;
import TCS.IntegerVal;
import TCS.IsDefinedExp;
import TCS.Keyword;
import TCS.Literal;
import TCS.LiteralRef;
import TCS.LocatedElement;
import TCS.LookInPArg;
import TCS.Mapping;
import TCS.ModePArg;
import TCS.MultiLineRule;
import TCS.NamedElement;
import TCS.NbNLBArg;
import TCS.NegativeIntegerVal;
import TCS.OCLQueryPArg;
import TCS.OctalMapping;
import TCS.OneExp;
import TCS.Operator;
import TCS.OperatorList;
import TCS.OperatorTemplate;
import TCS.OrPattern;
import TCS.PrimitiveTemplate;
import TCS.Priority;
import TCS.Property;
import TCS.PropertyArg;
import TCS.PropertyInit;
import TCS.PropertyVal;
import TCS.QualifiedNamedElement;
import TCS.RefersToKeyPArg;
import TCS.RefersToPArg;
import TCS.Rule;
import TCS.RulePattern;
import TCS.SeparatorPArg;
import TCS.Sequence;
import TCS.SequenceElement;
import TCS.SimpleMapping;
import TCS.SimplePattern;
import TCS.SpaceKind;
import TCS.StartNLBArg;
import TCS.StartNbNLBArg;
import TCS.StringPattern;
import TCS.StringVal;
import TCS.Symbol;
import TCS.TCSFactory;
import TCS.TCSPackage;
import TCS.Template;
import TCS.TemplateModifiers;
import TCS.Token;
import TCS.Value;
import TCS.WildcardMapping;
import TCS.Word;
import TCS.WordRule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

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
	private EClass propertyInitEClass = null;

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
	private EClass enumLiteralValEClass = null;

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
	private EClass oclQueryPArgEClass = null;

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
	 * @see TCS.TCSPackage#eNS_URI
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

		// Create package meta-data objects
		theTCSPackage.createPackageContents();

		// Initialize created meta-data
		theTCSPackage.initializePackageContents();

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
	public EClass getLocatedElement() {
		return locatedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocatedElement_Location() {
		return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocatedElement_CommentsBefore() {
		return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLocatedElement_CommentsAfter() {
		return (EAttribute)locatedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcreteSyntax() {
		return concreteSyntaxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax_K() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Templates() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Keywords() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Symbols() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_OperatorLists() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConcreteSyntax_Tokens() {
		return (EReference)concreteSyntaxEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcreteSyntax_Lexer() {
		return (EAttribute)concreteSyntaxEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplate() {
		return templateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplate_ConcreteSyntax() {
		return (EReference)templateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplate_Disambiguate() {
		return (EAttribute)templateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplate_DisambiguateV3() {
		return (EAttribute)templateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionTemplate() {
		return functionTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionTemplate_FunctionName() {
		return (EAttribute)functionTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionTemplate_FunctionSequence() {
		return (EReference)functionTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassTemplate() {
		return classTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassTemplate_TemplateSequence() {
		return (EReference)classTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_Modifiers() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_IsAbstract() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_IsDeep() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassTemplate_PrefixSequence() {
		return (EReference)classTemplateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_IsOperatored() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassTemplate_OperatorList() {
		return (EReference)classTemplateEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_IsMain() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_IsMulti() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_IsContext() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_IsAddToContext() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_IsNonPrimary() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassTemplate_Mode() {
		return (EAttribute)classTemplateEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTemplate() {
		return primitiveTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTemplate_TemplateName() {
		return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTemplate_IsDefault() {
		return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTemplate_TokenName() {
		return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTemplate_Value() {
		return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTemplate_Serializer() {
		return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTemplate_OrKeyword() {
		return (EAttribute)primitiveTemplateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorTemplate() {
		return operatorTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorTemplate_Operators() {
		return (EReference)operatorTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatorTemplate_Source() {
		return (EAttribute)operatorTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatorTemplate_StoreOpTo() {
		return (EAttribute)operatorTemplateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatorTemplate_StoreRightTo() {
		return (EAttribute)operatorTemplateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorTemplate_OtSequence() {
		return (EReference)operatorTemplateEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatorTemplate_IsContext() {
		return (EAttribute)operatorTemplateEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationTemplate() {
		return enumerationTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationTemplate_Automatic() {
		return (EAttribute)enumerationTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationTemplate_Mappings() {
		return (EReference)enumerationTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiteralMapping() {
		return enumLiteralMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumLiteralMapping_Literal() {
		return (EReference)enumLiteralMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumLiteralMapping_Element() {
		return (EReference)enumLiteralMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLiteral_Operators() {
		return (EReference)literalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLiteral_LiteralRefs() {
		return (EReference)literalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLiteral_Value() {
		return (EAttribute)literalEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSymbol() {
		return symbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSymbol_Spaces() {
		return (EAttribute)symbolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKeyword() {
		return keywordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatorList() {
		return operatorListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperatorList_Name() {
		return (EAttribute)operatorListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatorList_Priorities() {
		return (EReference)operatorListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPriority() {
		return priorityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPriority_List() {
		return (EReference)priorityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriority_Value() {
		return (EAttribute)priorityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPriority_Associativity() {
		return (EAttribute)priorityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPriority_Operators() {
		return (EReference)priorityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperator() {
		return operatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_IsPostfix() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperator_Arity() {
		return (EAttribute)operatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_Literal() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_Priority() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperator_Templates() {
		return (EReference)operatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequence() {
		return sequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_Elements() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_TemplateContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_PrefixContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_FunctionContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_BlockContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_ThenContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_ElseContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_SeparatorContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_OtContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequence_AlternativeContainer() {
		return (EReference)sequenceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceElement() {
		return sequenceElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceElement_ElementSequence() {
		return (EReference)sequenceElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteralRef() {
		return literalRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLiteralRef_ReferredLiteral() {
		return (EReference)literalRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProperty_PropertyArgs() {
		return (EReference)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCustomSeparator() {
		return customSeparatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCustomSeparator_Name() {
		return (EAttribute)customSeparatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlock() {
		return blockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_BlockSequence() {
		return (EReference)blockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_BlockArgs() {
		return (EReference)blockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
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
	public EClass getPropertyInit() {
		return propertyInitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyInit_Name() {
		return (EAttribute)propertyInitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyInit_Value() {
		return (EReference)propertyInitEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getRefersToKeyPArg_Value() {
		return (EAttribute)refersToKeyPArgEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getAsPArg_Value() {
		return (EAttribute)asPArgEClass.getEStructuralFeatures().get(0);
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
	public EClass getEnumLiteralVal() {
		return enumLiteralValEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumLiteralVal_Name() {
		return (EAttribute)enumLiteralValEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getPropertyVal_PropertyName() {
		return (EAttribute)propertyValEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getMultiLineRule_DropStart() {
		return (EAttribute)multiLineRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiLineRule_End() {
		return (EReference)multiLineRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiLineRule_DropEnd() {
		return (EAttribute)multiLineRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiLineRule_Esc() {
		return (EReference)multiLineRuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiLineRule_EscMappings() {
		return (EReference)multiLineRuleEClass.getEStructuralFeatures().get(5);
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
	public EClass getOCLQueryPArg() {
		return oclQueryPArgEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOCLQueryPArg_Query() {
		return (EAttribute)oclQueryPArgEClass.getEStructuralFeatures().get(0);
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

		templateEClass = createEClass(TEMPLATE);
		createEReference(templateEClass, TEMPLATE__CONCRETE_SYNTAX);
		createEAttribute(templateEClass, TEMPLATE__DISAMBIGUATE);
		createEAttribute(templateEClass, TEMPLATE__DISAMBIGUATE_V3);

		functionTemplateEClass = createEClass(FUNCTION_TEMPLATE);
		createEAttribute(functionTemplateEClass, FUNCTION_TEMPLATE__FUNCTION_NAME);
		createEReference(functionTemplateEClass, FUNCTION_TEMPLATE__FUNCTION_SEQUENCE);

		classTemplateEClass = createEClass(CLASS_TEMPLATE);
		createEReference(classTemplateEClass, CLASS_TEMPLATE__TEMPLATE_SEQUENCE);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__MODIFIERS);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_ABSTRACT);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_DEEP);
		createEReference(classTemplateEClass, CLASS_TEMPLATE__PREFIX_SEQUENCE);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_OPERATORED);
		createEReference(classTemplateEClass, CLASS_TEMPLATE__OPERATOR_LIST);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_MAIN);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_MULTI);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_CONTEXT);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_ADD_TO_CONTEXT);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__IS_NON_PRIMARY);
		createEAttribute(classTemplateEClass, CLASS_TEMPLATE__MODE);

		primitiveTemplateEClass = createEClass(PRIMITIVE_TEMPLATE);
		createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__TEMPLATE_NAME);
		createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__IS_DEFAULT);
		createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__TOKEN_NAME);
		createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__VALUE);
		createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__SERIALIZER);
		createEAttribute(primitiveTemplateEClass, PRIMITIVE_TEMPLATE__OR_KEYWORD);

		operatorTemplateEClass = createEClass(OPERATOR_TEMPLATE);
		createEReference(operatorTemplateEClass, OPERATOR_TEMPLATE__OPERATORS);
		createEAttribute(operatorTemplateEClass, OPERATOR_TEMPLATE__SOURCE);
		createEAttribute(operatorTemplateEClass, OPERATOR_TEMPLATE__STORE_OP_TO);
		createEAttribute(operatorTemplateEClass, OPERATOR_TEMPLATE__STORE_RIGHT_TO);
		createEReference(operatorTemplateEClass, OPERATOR_TEMPLATE__OT_SEQUENCE);
		createEAttribute(operatorTemplateEClass, OPERATOR_TEMPLATE__IS_CONTEXT);

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
		createEAttribute(operatorEClass, OPERATOR__IS_POSTFIX);
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
		createEReference(sequenceEClass, SEQUENCE__ALTERNATIVE_CONTAINER);

		sequenceElementEClass = createEClass(SEQUENCE_ELEMENT);
		createEReference(sequenceElementEClass, SEQUENCE_ELEMENT__ELEMENT_SEQUENCE);

		literalRefEClass = createEClass(LITERAL_REF);
		createEReference(literalRefEClass, LITERAL_REF__REFERRED_LITERAL);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEReference(propertyEClass, PROPERTY__PROPERTY_ARGS);

		customSeparatorEClass = createEClass(CUSTOM_SEPARATOR);
		createEAttribute(customSeparatorEClass, CUSTOM_SEPARATOR__NAME);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__BLOCK_SEQUENCE);
		createEReference(blockEClass, BLOCK__BLOCK_ARGS);

		conditionalElementEClass = createEClass(CONDITIONAL_ELEMENT);
		createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__CONDITION);
		createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__THEN_SEQUENCE);
		createEReference(conditionalElementEClass, CONDITIONAL_ELEMENT__ELSE_SEQUENCE);

		propertyInitEClass = createEClass(PROPERTY_INIT);
		createEAttribute(propertyInitEClass, PROPERTY_INIT__NAME);
		createEReference(propertyInitEClass, PROPERTY_INIT__VALUE);

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
		createEAttribute(refersToKeyPArgEClass, REFERS_TO_KEY_PARG__VALUE);

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

		equalsExpEClass = createEClass(EQUALS_EXP);
		createEReference(equalsExpEClass, EQUALS_EXP__VALUE);

		booleanPropertyExpEClass = createEClass(BOOLEAN_PROPERTY_EXP);

		isDefinedExpEClass = createEClass(IS_DEFINED_EXP);

		oneExpEClass = createEClass(ONE_EXP);

		valueEClass = createEClass(VALUE);

		stringValEClass = createEClass(STRING_VAL);
		createEAttribute(stringValEClass, STRING_VAL__SYMBOL);

		integerValEClass = createEClass(INTEGER_VAL);
		createEAttribute(integerValEClass, INTEGER_VAL__SYMBOL);

		negativeIntegerValEClass = createEClass(NEGATIVE_INTEGER_VAL);
		createEAttribute(negativeIntegerValEClass, NEGATIVE_INTEGER_VAL__SYMBOL);

		enumLiteralValEClass = createEClass(ENUM_LITERAL_VAL);
		createEAttribute(enumLiteralValEClass, ENUM_LITERAL_VAL__NAME);

		propertyValEClass = createEClass(PROPERTY_VAL);
		createEAttribute(propertyValEClass, PROPERTY_VAL__PROPERTY_NAME);

		tokenEClass = createEClass(TOKEN);
		createEReference(tokenEClass, TOKEN__PATTERN);

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
		createEAttribute(multiLineRuleEClass, MULTI_LINE_RULE__DROP_START);
		createEReference(multiLineRuleEClass, MULTI_LINE_RULE__END);
		createEAttribute(multiLineRuleEClass, MULTI_LINE_RULE__DROP_END);
		createEReference(multiLineRuleEClass, MULTI_LINE_RULE__ESC);
		createEReference(multiLineRuleEClass, MULTI_LINE_RULE__ESC_MAPPINGS);

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

		oclQueryPArgEClass = createEClass(OCL_QUERY_PARG);
		createEAttribute(oclQueryPArgEClass, OCL_QUERY_PARG__QUERY);

		// Create enums
		templateModifiersEEnum = createEEnum(TEMPLATE_MODIFIERS);
		spaceKindEEnum = createEEnum(SPACE_KIND);
		associativityEEnum = createEEnum(ASSOCIATIVITY);
		autoCreateKindEEnum = createEEnum(AUTO_CREATE_KIND);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		namedElementEClass.getESuperTypes().add(this.getLocatedElement());
		concreteSyntaxEClass.getESuperTypes().add(this.getNamedElement());
		templateEClass.getESuperTypes().add(this.getQualifiedNamedElement());
		functionTemplateEClass.getESuperTypes().add(this.getTemplate());
		classTemplateEClass.getESuperTypes().add(this.getTemplate());
		primitiveTemplateEClass.getESuperTypes().add(this.getTemplate());
		operatorTemplateEClass.getESuperTypes().add(this.getTemplate());
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
		propertyInitEClass.getESuperTypes().add(this.getSequenceElement());
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
		stringValEClass.getESuperTypes().add(this.getValue());
		integerValEClass.getESuperTypes().add(this.getValue());
		negativeIntegerValEClass.getESuperTypes().add(this.getValue());
		enumLiteralValEClass.getESuperTypes().add(this.getValue());
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

		// Initialize classes and features; add operations and parameters
		initEClass(locatedElementEClass, LocatedElement.class, "LocatedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLocatedElement_Location(), ecorePackage.getEString(), "location", null, 0, 1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getLocatedElement_CommentsBefore(), ecorePackage.getEString(), "commentsBefore", null, 0, -1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLocatedElement_CommentsAfter(), ecorePackage.getEString(), "commentsAfter", null, 0, -1, LocatedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(concreteSyntaxEClass, ConcreteSyntax.class, "ConcreteSyntax", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcreteSyntax_K(), ecorePackage.getEInt(), "k", null, 0, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConcreteSyntax_Templates(), this.getTemplate(), this.getTemplate_ConcreteSyntax(), "templates", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Keywords(), this.getKeyword(), null, "keywords", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Symbols(), this.getSymbol(), null, "symbols", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_OperatorLists(), this.getOperatorList(), null, "operatorLists", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConcreteSyntax_Tokens(), this.getToken(), null, "tokens", null, 0, -1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConcreteSyntax_Lexer(), ecorePackage.getEString(), "lexer", null, 1, 1, ConcreteSyntax.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(templateEClass, Template.class, "Template", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplate_ConcreteSyntax(), this.getConcreteSyntax(), this.getConcreteSyntax_Templates(), "concreteSyntax", null, 1, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTemplate_Disambiguate(), ecorePackage.getEString(), "disambiguate", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTemplate_DisambiguateV3(), ecorePackage.getEString(), "disambiguateV3", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(functionTemplateEClass, FunctionTemplate.class, "FunctionTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionTemplate_FunctionName(), ecorePackage.getEString(), "functionName", null, 1, 1, FunctionTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFunctionTemplate_FunctionSequence(), this.getSequence(), this.getSequence_FunctionContainer(), "functionSequence", null, 1, 1, FunctionTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(classTemplateEClass, ClassTemplate.class, "ClassTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassTemplate_TemplateSequence(), this.getSequence(), this.getSequence_TemplateContainer(), "templateSequence", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_Modifiers(), this.getTemplateModifiers(), "modifiers", null, 0, -1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_IsDeep(), ecorePackage.getEBoolean(), "isDeep", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassTemplate_PrefixSequence(), this.getSequence(), this.getSequence_PrefixContainer(), "prefixSequence", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_IsOperatored(), ecorePackage.getEBoolean(), "isOperatored", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassTemplate_OperatorList(), this.getOperatorList(), null, "operatorList", null, 0, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_IsMain(), ecorePackage.getEBoolean(), "isMain", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_IsMulti(), ecorePackage.getEBoolean(), "isMulti", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_IsContext(), ecorePackage.getEBoolean(), "isContext", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_IsAddToContext(), ecorePackage.getEBoolean(), "isAddToContext", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_IsNonPrimary(), ecorePackage.getEBoolean(), "isNonPrimary", null, 1, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getClassTemplate_Mode(), ecorePackage.getEString(), "mode", null, 0, 1, ClassTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(primitiveTemplateEClass, PrimitiveTemplate.class, "PrimitiveTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveTemplate_TemplateName(), ecorePackage.getEString(), "templateName", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPrimitiveTemplate_IsDefault(), ecorePackage.getEBoolean(), "isDefault", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPrimitiveTemplate_TokenName(), ecorePackage.getEString(), "tokenName", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPrimitiveTemplate_Value(), ecorePackage.getEString(), "value", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPrimitiveTemplate_Serializer(), ecorePackage.getEString(), "serializer", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPrimitiveTemplate_OrKeyword(), ecorePackage.getEBoolean(), "orKeyword", null, 1, 1, PrimitiveTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(operatorTemplateEClass, OperatorTemplate.class, "OperatorTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatorTemplate_Operators(), this.getOperator(), this.getOperator_Templates(), "operators", null, 0, -1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOperatorTemplate_Source(), ecorePackage.getEString(), "source", null, 1, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOperatorTemplate_StoreOpTo(), ecorePackage.getEString(), "storeOpTo", null, 0, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOperatorTemplate_StoreRightTo(), ecorePackage.getEString(), "storeRightTo", null, 0, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperatorTemplate_OtSequence(), this.getSequence(), this.getSequence_OtContainer(), "otSequence", null, 0, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOperatorTemplate_IsContext(), ecorePackage.getEBoolean(), "isContext", null, 1, 1, OperatorTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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
		initEAttribute(getPriority_Value(), ecorePackage.getEInt(), "value", null, 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPriority_Associativity(), this.getAssociativity(), "associativity", null, 1, 1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPriority_Operators(), this.getOperator(), this.getOperator_Priority(), "operators", null, 0, -1, Priority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(operatorEClass, Operator.class, "Operator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperator_IsPostfix(), ecorePackage.getEBoolean(), "isPostfix", null, 1, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOperator_Arity(), ecorePackage.getEInt(), "arity", null, 1, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperator_Literal(), this.getLiteral(), this.getLiteral_Operators(), "literal", null, 0, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperator_Priority(), this.getPriority(), this.getPriority_Operators(), "priority", null, 1, 1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOperator_Templates(), this.getOperatorTemplate(), this.getOperatorTemplate_Operators(), "templates", null, 0, -1, Operator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequence_Elements(), this.getSequenceElement(), this.getSequenceElement_ElementSequence(), "elements", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequence_TemplateContainer(), this.getClassTemplate(), this.getClassTemplate_TemplateSequence(), "templateContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequence_PrefixContainer(), this.getClassTemplate(), this.getClassTemplate_PrefixSequence(), "prefixContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequence_FunctionContainer(), this.getFunctionTemplate(), this.getFunctionTemplate_FunctionSequence(), "functionContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequence_BlockContainer(), this.getBlock(), this.getBlock_BlockSequence(), "blockContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequence_ThenContainer(), this.getConditionalElement(), this.getConditionalElement_ThenSequence(), "thenContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequence_ElseContainer(), this.getConditionalElement(), this.getConditionalElement_ElseSequence(), "elseContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequence_SeparatorContainer(), this.getSeparatorPArg(), this.getSeparatorPArg_SeparatorSequence(), "separatorContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequence_OtContainer(), this.getOperatorTemplate(), this.getOperatorTemplate_OtSequence(), "otContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSequence_AlternativeContainer(), this.getAlternative(), this.getAlternative_Sequences(), "alternativeContainer", null, 0, 1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sequenceElementEClass, SequenceElement.class, "SequenceElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSequenceElement_ElementSequence(), this.getSequence(), this.getSequence_Elements(), "elementSequence", null, 0, 1, SequenceElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(literalRefEClass, LiteralRef.class, "LiteralRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLiteralRef_ReferredLiteral(), this.getLiteral(), this.getLiteral_LiteralRefs(), "referredLiteral", null, 1, 1, LiteralRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProperty_PropertyArgs(), this.getPropertyArg(), this.getPropertyArg_Property(), "propertyArgs", null, 0, -1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customSeparatorEClass, CustomSeparator.class, "CustomSeparator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomSeparator_Name(), ecorePackage.getEString(), "name", null, 1, 1, CustomSeparator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_BlockSequence(), this.getSequence(), this.getSequence_BlockContainer(), "blockSequence", null, 1, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBlock_BlockArgs(), this.getBlockArg(), this.getBlockArg_Block(), "blockArgs", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionalElementEClass, ConditionalElement.class, "ConditionalElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionalElement_Condition(), this.getExpression(), this.getExpression_ConditionalElement(), "condition", null, 1, 1, ConditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConditionalElement_ThenSequence(), this.getSequence(), this.getSequence_ThenContainer(), "thenSequence", null, 1, 1, ConditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConditionalElement_ElseSequence(), this.getSequence(), this.getSequence_ElseContainer(), "elseSequence", null, 1, 1, ConditionalElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyInitEClass, PropertyInit.class, "PropertyInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyInit_Name(), ecorePackage.getEString(), "name", null, 1, 1, PropertyInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPropertyInit_Value(), this.getValue(), null, "value", null, 1, 1, PropertyInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(alternativeEClass, Alternative.class, "Alternative", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlternative_Sequences(), this.getSequence(), this.getSequence_AlternativeContainer(), "sequences", null, 2, -1, Alternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAlternative_IsMulti(), ecorePackage.getEBoolean(), "isMulti", null, 1, 1, Alternative.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionCall_CalledFunction(), this.getFunctionTemplate(), null, "calledFunction", null, 1, 1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyArgEClass, PropertyArg.class, "PropertyArg", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyArg_Property(), this.getProperty(), this.getProperty_PropertyArgs(), "property", null, 1, 1, PropertyArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(refersToPArgEClass, RefersToPArg.class, "RefersToPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRefersToPArg_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, 1, RefersToPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(lookInPArgEClass, LookInPArg.class, "LookInPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLookInPArg_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, -1, LookInPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createInPArgEClass, CreateInPArg.class, "CreateInPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateInPArg_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, -1, CreateInPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(refersToKeyPArgEClass, RefersToKeyPArg.class, "RefersToKeyPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRefersToKeyPArg_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, RefersToKeyPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(separatorPArgEClass, SeparatorPArg.class, "SeparatorPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSeparatorPArg_SeparatorSequence(), this.getSequence(), this.getSequence_SeparatorContainer(), "separatorSequence", null, 1, 1, SeparatorPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(autoCreatePArgEClass, AutoCreatePArg.class, "AutoCreatePArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutoCreatePArg_Value(), this.getAutoCreateKind(), "value", null, 1, 1, AutoCreatePArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(importContextPArgEClass, ImportContextPArg.class, "ImportContextPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forcedLowerPArgEClass, ForcedLowerPArg.class, "ForcedLowerPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForcedLowerPArg_Value(), ecorePackage.getEInt(), "value", null, 1, 1, ForcedLowerPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(createAsPArgEClass, CreateAsPArg.class, "CreateAsPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCreateAsPArg_Name(), ecorePackage.getEString(), "name", null, 1, 1, CreateAsPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(asPArgEClass, AsPArg.class, "AsPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAsPArg_Value(), ecorePackage.getEString(), "value", null, 1, 1, AsPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(modePArgEClass, ModePArg.class, "ModePArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModePArg_Mode(), ecorePackage.getEString(), "mode", null, 1, 1, ModePArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockArgEClass, BlockArg.class, "BlockArg", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockArg_Block(), this.getBlock(), this.getBlock_BlockArgs(), "block", null, 1, 1, BlockArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(nbNLBArgEClass, NbNLBArg.class, "NbNLBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNbNLBArg_Value(), ecorePackage.getEInt(), "value", null, 1, 1, NbNLBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(indentIncrBArgEClass, IndentIncrBArg.class, "IndentIncrBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndentIncrBArg_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IndentIncrBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(startNLBArgEClass, StartNLBArg.class, "StartNLBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartNLBArg_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, StartNLBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(startNbNLBArgEClass, StartNbNLBArg.class, "StartNbNLBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartNbNLBArg_Value(), ecorePackage.getEInt(), "value", null, 1, 1, StartNbNLBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(endNLBArgEClass, EndNLBArg.class, "EndNLBArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEndNLBArg_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, EndNLBArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpression_ConditionalElement(), this.getConditionalElement(), this.getConditionalElement_Condition(), "conditionalElement", null, 1, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(andExpEClass, AndExp.class, "AndExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAndExp_Expressions(), this.getAtomExp(), this.getAtomExp_AndExp(), "expressions", null, 0, -1, AndExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomExpEClass, AtomExp.class, "AtomExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAtomExp_AndExp(), this.getAndExp(), this.getAndExp_Expressions(), "andExp", null, 1, 1, AtomExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getAtomExp_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, 1, AtomExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(equalsExpEClass, EqualsExp.class, "EqualsExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEqualsExp_Value(), this.getValue(), null, "value", null, 1, 1, EqualsExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(booleanPropertyExpEClass, BooleanPropertyExp.class, "BooleanPropertyExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(isDefinedExpEClass, IsDefinedExp.class, "IsDefinedExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oneExpEClass, OneExp.class, "OneExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringValEClass, StringVal.class, "StringVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringVal_Symbol(), ecorePackage.getEString(), "symbol", null, 1, 1, StringVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(integerValEClass, IntegerVal.class, "IntegerVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerVal_Symbol(), ecorePackage.getEInt(), "symbol", null, 1, 1, IntegerVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(negativeIntegerValEClass, NegativeIntegerVal.class, "NegativeIntegerVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNegativeIntegerVal_Symbol(), ecorePackage.getEInt(), "symbol", null, 1, 1, NegativeIntegerVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(enumLiteralValEClass, EnumLiteralVal.class, "EnumLiteralVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumLiteralVal_Name(), ecorePackage.getEString(), "name", null, 1, 1, EnumLiteralVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(propertyValEClass, PropertyVal.class, "PropertyVal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyVal_PropertyName(), ecorePackage.getEString(), "propertyName", null, 1, -1, PropertyVal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(tokenEClass, Token.class, "Token", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToken_Pattern(), this.getOrPattern(), null, "pattern", null, 1, 1, Token.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

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
		initEAttribute(getEndOfLineRule_DropStart(), ecorePackage.getEBoolean(), "dropStart", null, 1, 1, EndOfLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(multiLineRuleEClass, MultiLineRule.class, "MultiLineRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiLineRule_Start(), this.getStringPattern(), null, "start", null, 1, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultiLineRule_DropStart(), ecorePackage.getEBoolean(), "dropStart", null, 1, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiLineRule_End(), this.getStringPattern(), null, "end", null, 1, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMultiLineRule_DropEnd(), ecorePackage.getEBoolean(), "dropEnd", null, 1, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiLineRule_Esc(), this.getStringPattern(), null, "esc", null, 0, 1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMultiLineRule_EscMappings(), this.getMapping(), null, "escMappings", null, 0, -1, MultiLineRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mappingEClass, Mapping.class, "Mapping", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simpleMappingEClass, SimpleMapping.class, "SimpleMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleMapping_Key(), ecorePackage.getEString(), "key", null, 1, 1, SimpleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSimpleMapping_Value(), ecorePackage.getEString(), "value", null, 1, 1, SimpleMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(wildcardMappingEClass, WildcardMapping.class, "WildcardMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(octalMappingEClass, OctalMapping.class, "OctalMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hexadecimalMappingEClass, HexadecimalMapping.class, "HexadecimalMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringPatternEClass, StringPattern.class, "StringPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classPatternEClass, ClassPattern.class, "ClassPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(qualifiedNamedElementEClass, QualifiedNamedElement.class, "QualifiedNamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualifiedNamedElement_Names(), ecorePackage.getEString(), "names", null, 1, -1, QualifiedNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getQualifiedNamedElement_MetaReference(), theEcorePackage.getEClass(), null, "metaReference", null, 0, 1, QualifiedNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclQueryPArgEClass, OCLQueryPArg.class, "OCLQueryPArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOCLQueryPArg_Query(), ecorePackage.getEString(), "query", null, 0, 1, OCLQueryPArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		// Create resource
		createResource(eNS_URI);
	}

} //TCSPackageImpl
