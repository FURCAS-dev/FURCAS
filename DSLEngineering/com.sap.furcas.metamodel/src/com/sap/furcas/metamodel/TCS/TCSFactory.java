/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.TCS.TCSPackage
 * @generated
 */
public interface TCSFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TCSFactory eINSTANCE = com.sap.furcas.metamodel.TCS.impl.TCSFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Concrete Syntax</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Syntax</em>'.
	 * @generated
	 */
	ConcreteSyntax createConcreteSyntax();

	/**
	 * Returns a new object of class '<em>Function Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Template</em>'.
	 * @generated
	 */
	FunctionTemplate createFunctionTemplate();

	/**
	 * Returns a new object of class '<em>Class Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Template</em>'.
	 * @generated
	 */
	ClassTemplate createClassTemplate();

	/**
	 * Returns a new object of class '<em>Primitive Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Template</em>'.
	 * @generated
	 */
	PrimitiveTemplate createPrimitiveTemplate();

	/**
	 * Returns a new object of class '<em>Operator Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator Template</em>'.
	 * @generated
	 */
	OperatorTemplate createOperatorTemplate();

	/**
	 * Returns a new object of class '<em>Enumeration Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Template</em>'.
	 * @generated
	 */
	EnumerationTemplate createEnumerationTemplate();

	/**
	 * Returns a new object of class '<em>Enum Literal Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Mapping</em>'.
	 * @generated
	 */
	EnumLiteralMapping createEnumLiteralMapping();

	/**
	 * Returns a new object of class '<em>Symbol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Symbol</em>'.
	 * @generated
	 */
	Symbol createSymbol();

	/**
	 * Returns a new object of class '<em>Keyword</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Keyword</em>'.
	 * @generated
	 */
	Keyword createKeyword();

	/**
	 * Returns a new object of class '<em>Operator List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator List</em>'.
	 * @generated
	 */
	OperatorList createOperatorList();

	/**
	 * Returns a new object of class '<em>Priority</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Priority</em>'.
	 * @generated
	 */
	Priority createPriority();

	/**
	 * Returns a new object of class '<em>Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operator</em>'.
	 * @generated
	 */
	Operator createOperator();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>Literal Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal Ref</em>'.
	 * @generated
	 */
	LiteralRef createLiteralRef();

	/**
	 * Returns a new object of class '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property</em>'.
	 * @generated
	 */
	Property createProperty();

	/**
	 * Returns a new object of class '<em>Custom Separator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Custom Separator</em>'.
	 * @generated
	 */
	CustomSeparator createCustomSeparator();

	/**
	 * Returns a new object of class '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block</em>'.
	 * @generated
	 */
	Block createBlock();

	/**
	 * Returns a new object of class '<em>Conditional Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Conditional Element</em>'.
	 * @generated
	 */
	ConditionalElement createConditionalElement();

	/**
	 * Returns a new object of class '<em>Primitive Property Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Property Init</em>'.
	 * @generated
	 */
	PrimitivePropertyInit createPrimitivePropertyInit();

	/**
	 * Returns a new object of class '<em>Alternative</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alternative</em>'.
	 * @generated
	 */
	Alternative createAlternative();

	/**
	 * Returns a new object of class '<em>Function Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Call</em>'.
	 * @generated
	 */
	FunctionCall createFunctionCall();

	/**
	 * Returns a new object of class '<em>Refers To PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Refers To PArg</em>'.
	 * @generated
	 */
	RefersToPArg createRefersToPArg();

	/**
	 * Returns a new object of class '<em>Look In PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Look In PArg</em>'.
	 * @generated
	 */
	LookInPArg createLookInPArg();

	/**
	 * Returns a new object of class '<em>Create In PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create In PArg</em>'.
	 * @generated
	 */
	CreateInPArg createCreateInPArg();

	/**
	 * Returns a new object of class '<em>Refers To Key PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Refers To Key PArg</em>'.
	 * @generated
	 */
	RefersToKeyPArg createRefersToKeyPArg();

	/**
	 * Returns a new object of class '<em>Separator PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Separator PArg</em>'.
	 * @generated
	 */
	SeparatorPArg createSeparatorPArg();

	/**
	 * Returns a new object of class '<em>Auto Create PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Auto Create PArg</em>'.
	 * @generated
	 */
	AutoCreatePArg createAutoCreatePArg();

	/**
	 * Returns a new object of class '<em>Import Context PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Context PArg</em>'.
	 * @generated
	 */
	ImportContextPArg createImportContextPArg();

	/**
	 * Returns a new object of class '<em>Forced Lower PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forced Lower PArg</em>'.
	 * @generated
	 */
	ForcedLowerPArg createForcedLowerPArg();

	/**
	 * Returns a new object of class '<em>Create As PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Create As PArg</em>'.
	 * @generated
	 */
	CreateAsPArg createCreateAsPArg();

	/**
	 * Returns a new object of class '<em>As PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>As PArg</em>'.
	 * @generated
	 */
	AsPArg createAsPArg();

	/**
	 * Returns a new object of class '<em>Mode PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mode PArg</em>'.
	 * @generated
	 */
	ModePArg createModePArg();

	/**
	 * Returns a new object of class '<em>Nb NLB Arg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nb NLB Arg</em>'.
	 * @generated
	 */
	NbNLBArg createNbNLBArg();

	/**
	 * Returns a new object of class '<em>Indent Incr BArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Indent Incr BArg</em>'.
	 * @generated
	 */
	IndentIncrBArg createIndentIncrBArg();

	/**
	 * Returns a new object of class '<em>Start NLB Arg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start NLB Arg</em>'.
	 * @generated
	 */
	StartNLBArg createStartNLBArg();

	/**
	 * Returns a new object of class '<em>Start Nb NLB Arg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Nb NLB Arg</em>'.
	 * @generated
	 */
	StartNbNLBArg createStartNbNLBArg();

	/**
	 * Returns a new object of class '<em>End NLB Arg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End NLB Arg</em>'.
	 * @generated
	 */
	EndNLBArg createEndNLBArg();

	/**
	 * Returns a new object of class '<em>And Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And Exp</em>'.
	 * @generated
	 */
	AndExp createAndExp();

	/**
	 * Returns a new object of class '<em>Equals Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equals Exp</em>'.
	 * @generated
	 */
	EqualsExp createEqualsExp();

	/**
	 * Returns a new object of class '<em>Boolean Property Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Property Exp</em>'.
	 * @generated
	 */
	BooleanPropertyExp createBooleanPropertyExp();

	/**
	 * Returns a new object of class '<em>Is Defined Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Is Defined Exp</em>'.
	 * @generated
	 */
	IsDefinedExp createIsDefinedExp();

	/**
	 * Returns a new object of class '<em>One Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>One Exp</em>'.
	 * @generated
	 */
	OneExp createOneExp();

	/**
	 * Returns a new object of class '<em>String Val</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Val</em>'.
	 * @generated
	 */
	StringVal createStringVal();

	/**
	 * Returns a new object of class '<em>Integer Val</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Val</em>'.
	 * @generated
	 */
	IntegerVal createIntegerVal();

	/**
	 * Returns a new object of class '<em>Negative Integer Val</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Negative Integer Val</em>'.
	 * @generated
	 */
	NegativeIntegerVal createNegativeIntegerVal();

	/**
	 * Returns a new object of class '<em>Lookup Property Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Lookup Property Init</em>'.
	 * @generated
	 */
	LookupPropertyInit createLookupPropertyInit();

	/**
	 * Returns a new object of class '<em>Enum Literal Val</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Val</em>'.
	 * @generated
	 */
	EnumLiteralVal createEnumLiteralVal();

	/**
	 * Returns a new object of class '<em>Property Val</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Val</em>'.
	 * @generated
	 */
	PropertyVal createPropertyVal();

	/**
	 * Returns a new object of class '<em>Token</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Token</em>'.
	 * @generated
	 */
	Token createToken();

	/**
	 * Returns a new object of class '<em>Or Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or Pattern</em>'.
	 * @generated
	 */
	OrPattern createOrPattern();

	/**
	 * Returns a new object of class '<em>Rule Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Pattern</em>'.
	 * @generated
	 */
	RulePattern createRulePattern();

	/**
	 * Returns a new object of class '<em>Word Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Word Rule</em>'.
	 * @generated
	 */
	WordRule createWordRule();

	/**
	 * Returns a new object of class '<em>Word</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Word</em>'.
	 * @generated
	 */
	Word createWord();

	/**
	 * Returns a new object of class '<em>End Of Line Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Of Line Rule</em>'.
	 * @generated
	 */
	EndOfLineRule createEndOfLineRule();

	/**
	 * Returns a new object of class '<em>Multi Line Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Line Rule</em>'.
	 * @generated
	 */
	MultiLineRule createMultiLineRule();

	/**
	 * Returns a new object of class '<em>Simple Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Mapping</em>'.
	 * @generated
	 */
	SimpleMapping createSimpleMapping();

	/**
	 * Returns a new object of class '<em>Wildcard Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wildcard Mapping</em>'.
	 * @generated
	 */
	WildcardMapping createWildcardMapping();

	/**
	 * Returns a new object of class '<em>Octal Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Octal Mapping</em>'.
	 * @generated
	 */
	OctalMapping createOctalMapping();

	/**
	 * Returns a new object of class '<em>Hexadecimal Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hexadecimal Mapping</em>'.
	 * @generated
	 */
	HexadecimalMapping createHexadecimalMapping();

	/**
	 * Returns a new object of class '<em>String Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Pattern</em>'.
	 * @generated
	 */
	StringPattern createStringPattern();

	/**
	 * Returns a new object of class '<em>Class Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Pattern</em>'.
	 * @generated
	 */
	ClassPattern createClassPattern();

	/**
	 * Returns a new object of class '<em>Qualified Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Named Element</em>'.
	 * @generated
	 */
	QualifiedNamedElement createQualifiedNamedElement();

	/**
	 * Returns a new object of class '<em>Forced Upper PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forced Upper PArg</em>'.
	 * @generated
	 */
	ForcedUpperPArg createForcedUpperPArg();

	/**
	 * Returns a new object of class '<em>Injector Actions Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Injector Actions Block</em>'.
	 * @generated
	 */
	InjectorActionsBlock createInjectorActionsBlock();

	/**
	 * Returns a new object of class '<em>Query PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Query PArg</em>'.
	 * @generated
	 */
	QueryPArg createQueryPArg();

	/**
	 * Returns a new object of class '<em>Filter PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filter PArg</em>'.
	 * @generated
	 */
	FilterPArg createFilterPArg();

	/**
	 * Returns a new object of class '<em>Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Reference</em>'.
	 * @generated
	 */
	PropertyReference createPropertyReference();

	/**
	 * Returns a new object of class '<em>Context Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context Template</em>'.
	 * @generated
	 */
	ContextTemplate createContextTemplate();

	/**
	 * Returns a new object of class '<em>Context Tags</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context Tags</em>'.
	 * @generated
	 */
	ContextTags createContextTags();

	/**
	 * Returns a new object of class '<em>Ocl Property Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ocl Property Init</em>'.
	 * @generated
	 */
	OclPropertyInit createOclPropertyInit();

	/**
	 * Returns a new object of class '<em>Scope Arg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scope Arg</em>'.
	 * @generated
	 */
	ScopeArg createScopeArg();

	/**
	 * Returns a new object of class '<em>Invert PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invert PArg</em>'.
	 * @generated
	 */
	InvertPArg createInvertPArg();

	/**
	 * Returns a new object of class '<em>Foreach Predicate Property Init</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Foreach Predicate Property Init</em>'.
	 * @generated
	 */
	ForeachPredicatePropertyInit createForeachPredicatePropertyInit();

	/**
	 * Returns a new object of class '<em>Predicate Semantic</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate Semantic</em>'.
	 * @generated
	 */
	PredicateSemantic createPredicateSemantic();

	/**
	 * Returns a new object of class '<em>Sequence In Alternative</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence In Alternative</em>'.
	 * @generated
	 */
	SequenceInAlternative createSequenceInAlternative();

	/**
	 * Returns a new object of class '<em>EClass0</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EClass0</em>'.
	 * @generated
	 */
	EClass0 createEClass0();

	/**
	 * Returns a new object of class '<em>Partial PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Partial PArg</em>'.
	 * @generated
	 */
	PartialPArg createPartialPArg();

	/**
	 * Returns a new object of class '<em>Disambiguate PArg</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Disambiguate PArg</em>'.
	 * @generated
	 */
	DisambiguatePArg createDisambiguatePArg();

	/**
	 * Returns a new object of class '<em>Instance Of Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Of Exp</em>'.
	 * @generated
	 */
	InstanceOfExp createInstanceOfExp();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TCSPackage getTCSPackage();

} //TCSFactory
