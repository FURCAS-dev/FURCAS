/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package TCS.util;

import TCS.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see TCS.TCSPackage
 * @generated
 */
public class TCSAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TCSPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TCSAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TCSPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCSSwitch<Adapter> modelSwitch =
		new TCSSwitch<Adapter>() {
			@Override
			public Adapter caseLocatedElement(LocatedElement object) {
				return createLocatedElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseConcreteSyntax(ConcreteSyntax object) {
				return createConcreteSyntaxAdapter();
			}
			@Override
			public Adapter caseTemplate(Template object) {
				return createTemplateAdapter();
			}
			@Override
			public Adapter caseFunctionTemplate(FunctionTemplate object) {
				return createFunctionTemplateAdapter();
			}
			@Override
			public Adapter caseClassTemplate(ClassTemplate object) {
				return createClassTemplateAdapter();
			}
			@Override
			public Adapter casePrimitiveTemplate(PrimitiveTemplate object) {
				return createPrimitiveTemplateAdapter();
			}
			@Override
			public Adapter caseOperatorTemplate(OperatorTemplate object) {
				return createOperatorTemplateAdapter();
			}
			@Override
			public Adapter caseEnumerationTemplate(EnumerationTemplate object) {
				return createEnumerationTemplateAdapter();
			}
			@Override
			public Adapter caseEnumLiteralMapping(EnumLiteralMapping object) {
				return createEnumLiteralMappingAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseSymbol(Symbol object) {
				return createSymbolAdapter();
			}
			@Override
			public Adapter caseKeyword(Keyword object) {
				return createKeywordAdapter();
			}
			@Override
			public Adapter caseOperatorList(OperatorList object) {
				return createOperatorListAdapter();
			}
			@Override
			public Adapter casePriority(Priority object) {
				return createPriorityAdapter();
			}
			@Override
			public Adapter caseOperator(Operator object) {
				return createOperatorAdapter();
			}
			@Override
			public Adapter caseSequence(Sequence object) {
				return createSequenceAdapter();
			}
			@Override
			public Adapter caseSequenceElement(SequenceElement object) {
				return createSequenceElementAdapter();
			}
			@Override
			public Adapter caseLiteralRef(LiteralRef object) {
				return createLiteralRefAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseCustomSeparator(CustomSeparator object) {
				return createCustomSeparatorAdapter();
			}
			@Override
			public Adapter caseBlock(Block object) {
				return createBlockAdapter();
			}
			@Override
			public Adapter caseConditionalElement(ConditionalElement object) {
				return createConditionalElementAdapter();
			}
			@Override
			public Adapter casePropertyInit(PropertyInit object) {
				return createPropertyInitAdapter();
			}
			@Override
			public Adapter caseAlternative(Alternative object) {
				return createAlternativeAdapter();
			}
			@Override
			public Adapter caseFunctionCall(FunctionCall object) {
				return createFunctionCallAdapter();
			}
			@Override
			public Adapter casePropertyArg(PropertyArg object) {
				return createPropertyArgAdapter();
			}
			@Override
			public Adapter caseRefersToPArg(RefersToPArg object) {
				return createRefersToPArgAdapter();
			}
			@Override
			public Adapter caseLookInPArg(LookInPArg object) {
				return createLookInPArgAdapter();
			}
			@Override
			public Adapter caseCreateInPArg(CreateInPArg object) {
				return createCreateInPArgAdapter();
			}
			@Override
			public Adapter caseRefersToKeyPArg(RefersToKeyPArg object) {
				return createRefersToKeyPArgAdapter();
			}
			@Override
			public Adapter caseSeparatorPArg(SeparatorPArg object) {
				return createSeparatorPArgAdapter();
			}
			@Override
			public Adapter caseAutoCreatePArg(AutoCreatePArg object) {
				return createAutoCreatePArgAdapter();
			}
			@Override
			public Adapter caseImportContextPArg(ImportContextPArg object) {
				return createImportContextPArgAdapter();
			}
			@Override
			public Adapter caseForcedLowerPArg(ForcedLowerPArg object) {
				return createForcedLowerPArgAdapter();
			}
			@Override
			public Adapter caseCreateAsPArg(CreateAsPArg object) {
				return createCreateAsPArgAdapter();
			}
			@Override
			public Adapter caseAsPArg(AsPArg object) {
				return createAsPArgAdapter();
			}
			@Override
			public Adapter caseModePArg(ModePArg object) {
				return createModePArgAdapter();
			}
			@Override
			public Adapter caseBlockArg(BlockArg object) {
				return createBlockArgAdapter();
			}
			@Override
			public Adapter caseNbNLBArg(NbNLBArg object) {
				return createNbNLBArgAdapter();
			}
			@Override
			public Adapter caseIndentIncrBArg(IndentIncrBArg object) {
				return createIndentIncrBArgAdapter();
			}
			@Override
			public Adapter caseStartNLBArg(StartNLBArg object) {
				return createStartNLBArgAdapter();
			}
			@Override
			public Adapter caseStartNbNLBArg(StartNbNLBArg object) {
				return createStartNbNLBArgAdapter();
			}
			@Override
			public Adapter caseEndNLBArg(EndNLBArg object) {
				return createEndNLBArgAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseAndExp(AndExp object) {
				return createAndExpAdapter();
			}
			@Override
			public Adapter caseAtomExp(AtomExp object) {
				return createAtomExpAdapter();
			}
			@Override
			public Adapter caseEqualsExp(EqualsExp object) {
				return createEqualsExpAdapter();
			}
			@Override
			public Adapter caseBooleanPropertyExp(BooleanPropertyExp object) {
				return createBooleanPropertyExpAdapter();
			}
			@Override
			public Adapter caseIsDefinedExp(IsDefinedExp object) {
				return createIsDefinedExpAdapter();
			}
			@Override
			public Adapter caseOneExp(OneExp object) {
				return createOneExpAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@Override
			public Adapter caseStringVal(StringVal object) {
				return createStringValAdapter();
			}
			@Override
			public Adapter caseIntegerVal(IntegerVal object) {
				return createIntegerValAdapter();
			}
			@Override
			public Adapter caseNegativeIntegerVal(NegativeIntegerVal object) {
				return createNegativeIntegerValAdapter();
			}
			@Override
			public Adapter caseEnumLiteralVal(EnumLiteralVal object) {
				return createEnumLiteralValAdapter();
			}
			@Override
			public Adapter casePropertyVal(PropertyVal object) {
				return createPropertyValAdapter();
			}
			@Override
			public Adapter caseToken(Token object) {
				return createTokenAdapter();
			}
			@Override
			public Adapter caseOrPattern(OrPattern object) {
				return createOrPatternAdapter();
			}
			@Override
			public Adapter caseSimplePattern(SimplePattern object) {
				return createSimplePatternAdapter();
			}
			@Override
			public Adapter caseRulePattern(RulePattern object) {
				return createRulePatternAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseWordRule(WordRule object) {
				return createWordRuleAdapter();
			}
			@Override
			public Adapter caseWord(Word object) {
				return createWordAdapter();
			}
			@Override
			public Adapter caseEndOfLineRule(EndOfLineRule object) {
				return createEndOfLineRuleAdapter();
			}
			@Override
			public Adapter caseMultiLineRule(MultiLineRule object) {
				return createMultiLineRuleAdapter();
			}
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseSimpleMapping(SimpleMapping object) {
				return createSimpleMappingAdapter();
			}
			@Override
			public Adapter caseWildcardMapping(WildcardMapping object) {
				return createWildcardMappingAdapter();
			}
			@Override
			public Adapter caseOctalMapping(OctalMapping object) {
				return createOctalMappingAdapter();
			}
			@Override
			public Adapter caseHexadecimalMapping(HexadecimalMapping object) {
				return createHexadecimalMappingAdapter();
			}
			@Override
			public Adapter caseStringPattern(StringPattern object) {
				return createStringPatternAdapter();
			}
			@Override
			public Adapter caseClassPattern(ClassPattern object) {
				return createClassPatternAdapter();
			}
			@Override
			public Adapter caseQualifiedNamedElement(QualifiedNamedElement object) {
				return createQualifiedNamedElementAdapter();
			}
			@Override
			public Adapter caseOCLQueryPArg(OCLQueryPArg object) {
				return createOCLQueryPArgAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link TCS.LocatedElement <em>Located Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.LocatedElement
	 * @generated
	 */
	public Adapter createLocatedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.ConcreteSyntax <em>Concrete Syntax</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.ConcreteSyntax
	 * @generated
	 */
	public Adapter createConcreteSyntaxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Template
	 * @generated
	 */
	public Adapter createTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.FunctionTemplate <em>Function Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.FunctionTemplate
	 * @generated
	 */
	public Adapter createFunctionTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.ClassTemplate <em>Class Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.ClassTemplate
	 * @generated
	 */
	public Adapter createClassTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.PrimitiveTemplate <em>Primitive Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.PrimitiveTemplate
	 * @generated
	 */
	public Adapter createPrimitiveTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.OperatorTemplate <em>Operator Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.OperatorTemplate
	 * @generated
	 */
	public Adapter createOperatorTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.EnumerationTemplate <em>Enumeration Template</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.EnumerationTemplate
	 * @generated
	 */
	public Adapter createEnumerationTemplateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.EnumLiteralMapping <em>Enum Literal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.EnumLiteralMapping
	 * @generated
	 */
	public Adapter createEnumLiteralMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Symbol <em>Symbol</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Symbol
	 * @generated
	 */
	public Adapter createSymbolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Keyword <em>Keyword</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Keyword
	 * @generated
	 */
	public Adapter createKeywordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.OperatorList <em>Operator List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.OperatorList
	 * @generated
	 */
	public Adapter createOperatorListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Priority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Priority
	 * @generated
	 */
	public Adapter createPriorityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Operator
	 * @generated
	 */
	public Adapter createOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Sequence
	 * @generated
	 */
	public Adapter createSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.SequenceElement <em>Sequence Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.SequenceElement
	 * @generated
	 */
	public Adapter createSequenceElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.LiteralRef <em>Literal Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.LiteralRef
	 * @generated
	 */
	public Adapter createLiteralRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.CustomSeparator <em>Custom Separator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.CustomSeparator
	 * @generated
	 */
	public Adapter createCustomSeparatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Block
	 * @generated
	 */
	public Adapter createBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.ConditionalElement <em>Conditional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.ConditionalElement
	 * @generated
	 */
	public Adapter createConditionalElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.PropertyInit <em>Property Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.PropertyInit
	 * @generated
	 */
	public Adapter createPropertyInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Alternative <em>Alternative</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Alternative
	 * @generated
	 */
	public Adapter createAlternativeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.FunctionCall
	 * @generated
	 */
	public Adapter createFunctionCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.PropertyArg <em>Property Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.PropertyArg
	 * @generated
	 */
	public Adapter createPropertyArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.RefersToPArg <em>Refers To PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.RefersToPArg
	 * @generated
	 */
	public Adapter createRefersToPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.LookInPArg <em>Look In PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.LookInPArg
	 * @generated
	 */
	public Adapter createLookInPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.CreateInPArg <em>Create In PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.CreateInPArg
	 * @generated
	 */
	public Adapter createCreateInPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.RefersToKeyPArg <em>Refers To Key PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.RefersToKeyPArg
	 * @generated
	 */
	public Adapter createRefersToKeyPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.SeparatorPArg <em>Separator PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.SeparatorPArg
	 * @generated
	 */
	public Adapter createSeparatorPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.AutoCreatePArg <em>Auto Create PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.AutoCreatePArg
	 * @generated
	 */
	public Adapter createAutoCreatePArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.ImportContextPArg <em>Import Context PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.ImportContextPArg
	 * @generated
	 */
	public Adapter createImportContextPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.ForcedLowerPArg <em>Forced Lower PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.ForcedLowerPArg
	 * @generated
	 */
	public Adapter createForcedLowerPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.CreateAsPArg <em>Create As PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.CreateAsPArg
	 * @generated
	 */
	public Adapter createCreateAsPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.AsPArg <em>As PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.AsPArg
	 * @generated
	 */
	public Adapter createAsPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.ModePArg <em>Mode PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.ModePArg
	 * @generated
	 */
	public Adapter createModePArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.BlockArg <em>Block Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.BlockArg
	 * @generated
	 */
	public Adapter createBlockArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.NbNLBArg <em>Nb NLB Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.NbNLBArg
	 * @generated
	 */
	public Adapter createNbNLBArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.IndentIncrBArg <em>Indent Incr BArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.IndentIncrBArg
	 * @generated
	 */
	public Adapter createIndentIncrBArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.StartNLBArg <em>Start NLB Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.StartNLBArg
	 * @generated
	 */
	public Adapter createStartNLBArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.StartNbNLBArg <em>Start Nb NLB Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.StartNbNLBArg
	 * @generated
	 */
	public Adapter createStartNbNLBArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.EndNLBArg <em>End NLB Arg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.EndNLBArg
	 * @generated
	 */
	public Adapter createEndNLBArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.AndExp <em>And Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.AndExp
	 * @generated
	 */
	public Adapter createAndExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.AtomExp <em>Atom Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.AtomExp
	 * @generated
	 */
	public Adapter createAtomExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.EqualsExp <em>Equals Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.EqualsExp
	 * @generated
	 */
	public Adapter createEqualsExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.BooleanPropertyExp <em>Boolean Property Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.BooleanPropertyExp
	 * @generated
	 */
	public Adapter createBooleanPropertyExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.IsDefinedExp <em>Is Defined Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.IsDefinedExp
	 * @generated
	 */
	public Adapter createIsDefinedExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.OneExp <em>One Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.OneExp
	 * @generated
	 */
	public Adapter createOneExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.StringVal <em>String Val</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.StringVal
	 * @generated
	 */
	public Adapter createStringValAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.IntegerVal <em>Integer Val</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.IntegerVal
	 * @generated
	 */
	public Adapter createIntegerValAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.NegativeIntegerVal <em>Negative Integer Val</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.NegativeIntegerVal
	 * @generated
	 */
	public Adapter createNegativeIntegerValAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.EnumLiteralVal <em>Enum Literal Val</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.EnumLiteralVal
	 * @generated
	 */
	public Adapter createEnumLiteralValAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.PropertyVal <em>Property Val</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.PropertyVal
	 * @generated
	 */
	public Adapter createPropertyValAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Token <em>Token</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Token
	 * @generated
	 */
	public Adapter createTokenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.OrPattern <em>Or Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.OrPattern
	 * @generated
	 */
	public Adapter createOrPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.SimplePattern <em>Simple Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.SimplePattern
	 * @generated
	 */
	public Adapter createSimplePatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.RulePattern <em>Rule Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.RulePattern
	 * @generated
	 */
	public Adapter createRulePatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.WordRule <em>Word Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.WordRule
	 * @generated
	 */
	public Adapter createWordRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Word <em>Word</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Word
	 * @generated
	 */
	public Adapter createWordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.EndOfLineRule <em>End Of Line Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.EndOfLineRule
	 * @generated
	 */
	public Adapter createEndOfLineRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.MultiLineRule <em>Multi Line Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.MultiLineRule
	 * @generated
	 */
	public Adapter createMultiLineRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.SimpleMapping <em>Simple Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.SimpleMapping
	 * @generated
	 */
	public Adapter createSimpleMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.WildcardMapping <em>Wildcard Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.WildcardMapping
	 * @generated
	 */
	public Adapter createWildcardMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.OctalMapping <em>Octal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.OctalMapping
	 * @generated
	 */
	public Adapter createOctalMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.HexadecimalMapping <em>Hexadecimal Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.HexadecimalMapping
	 * @generated
	 */
	public Adapter createHexadecimalMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.StringPattern <em>String Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.StringPattern
	 * @generated
	 */
	public Adapter createStringPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.ClassPattern <em>Class Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.ClassPattern
	 * @generated
	 */
	public Adapter createClassPatternAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.QualifiedNamedElement <em>Qualified Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.QualifiedNamedElement
	 * @generated
	 */
	public Adapter createQualifiedNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link TCS.OCLQueryPArg <em>OCL Query PArg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see TCS.OCLQueryPArg
	 * @generated
	 */
	public Adapter createOCLQueryPArgAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TCSAdapterFactory
