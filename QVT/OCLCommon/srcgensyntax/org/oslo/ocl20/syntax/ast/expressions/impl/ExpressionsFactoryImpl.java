/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.oslo.ocl20.syntax.ast.expressions.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionsFactory init() {
		try {
			ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory("urn:ast.expressions.ecore"); 
			if (theExpressionsFactory != null) {
				return theExpressionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExpressionsPackage.AND_EXP_AS: return createAndExpAS();
			case ExpressionsPackage.ARROW_SELECTION_EXP_AS: return createArrowSelectionExpAS();
			case ExpressionsPackage.ASSOCIATION_CALL_EXP_AS: return createAssociationCallExpAS();
			case ExpressionsPackage.BOOLEAN_LITERAL_EXP_AS: return createBooleanLiteralExpAS();
			case ExpressionsPackage.COLLECTION_ITEM_AS: return createCollectionItemAS();
			case ExpressionsPackage.COLLECTION_LITERAL_EXP_AS: return createCollectionLiteralExpAS();
			case ExpressionsPackage.COLLECTION_RANGE_AS: return createCollectionRangeAS();
			case ExpressionsPackage.DOT_SELECTION_EXP_AS: return createDotSelectionExpAS();
			case ExpressionsPackage.ENUM_LITERAL_EXP_AS: return createEnumLiteralExpAS();
			case ExpressionsPackage.IF_EXP_AS: return createIfExpAS();
			case ExpressionsPackage.IMPLIES_EXP_AS: return createImpliesExpAS();
			case ExpressionsPackage.INTEGER_LITERAL_EXP_AS: return createIntegerLiteralExpAS();
			case ExpressionsPackage.ITERATE_EXP_AS: return createIterateExpAS();
			case ExpressionsPackage.ITERATOR_EXP_AS: return createIteratorExpAS();
			case ExpressionsPackage.LET_EXP_AS: return createLetExpAS();
			case ExpressionsPackage.NOT_EXP_AS: return createNotExpAS();
			case ExpressionsPackage.OCL_EXPRESSION_AS: return createOclExpressionAS();
			case ExpressionsPackage.OCL_MESSAGE_ARG_AS: return createOclMessageArgAS();
			case ExpressionsPackage.OCL_MESSAGE_EXP_AS: return createOclMessageExpAS();
			case ExpressionsPackage.OPERATION_CALL_EXP_AS: return createOperationCallExpAS();
			case ExpressionsPackage.OR_EXP_AS: return createOrExpAS();
			case ExpressionsPackage.PATH_NAME_EXP_AS: return createPathNameExpAS();
			case ExpressionsPackage.REAL_LITERAL_EXP_AS: return createRealLiteralExpAS();
			case ExpressionsPackage.STRING_LITERAL_EXP_AS: return createStringLiteralExpAS();
			case ExpressionsPackage.TUPLE_LITERAL_EXP_AS: return createTupleLiteralExpAS();
			case ExpressionsPackage.XOR_EXP_AS: return createXorExpAS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.COLLECTION_KIND_AS:
				return createCollectionKindASFromString(eDataType, initialValue);
			case ExpressionsPackage.OCL_MESSAGE_KIND_AS:
				return createOclMessageKindASFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionsPackage.COLLECTION_KIND_AS:
				return convertCollectionKindASToString(eDataType, instanceValue);
			case ExpressionsPackage.OCL_MESSAGE_KIND_AS:
				return convertOclMessageKindASToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndExpAS createAndExpAS() {
		AndExpASImpl andExpAS = new AndExpASImpl();
		return andExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrowSelectionExpAS createArrowSelectionExpAS() {
		ArrowSelectionExpASImpl arrowSelectionExpAS = new ArrowSelectionExpASImpl();
		return arrowSelectionExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationCallExpAS createAssociationCallExpAS() {
		AssociationCallExpASImpl associationCallExpAS = new AssociationCallExpASImpl();
		return associationCallExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExpAS createBooleanLiteralExpAS() {
		BooleanLiteralExpASImpl booleanLiteralExpAS = new BooleanLiteralExpASImpl();
		return booleanLiteralExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionItemAS createCollectionItemAS() {
		CollectionItemASImpl collectionItemAS = new CollectionItemASImpl();
		return collectionItemAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralExpAS createCollectionLiteralExpAS() {
		CollectionLiteralExpASImpl collectionLiteralExpAS = new CollectionLiteralExpASImpl();
		return collectionLiteralExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionRangeAS createCollectionRangeAS() {
		CollectionRangeASImpl collectionRangeAS = new CollectionRangeASImpl();
		return collectionRangeAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DotSelectionExpAS createDotSelectionExpAS() {
		DotSelectionExpASImpl dotSelectionExpAS = new DotSelectionExpASImpl();
		return dotSelectionExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralExpAS createEnumLiteralExpAS() {
		EnumLiteralExpASImpl enumLiteralExpAS = new EnumLiteralExpASImpl();
		return enumLiteralExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpAS createIfExpAS() {
		IfExpASImpl ifExpAS = new IfExpASImpl();
		return ifExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpliesExpAS createImpliesExpAS() {
		ImpliesExpASImpl impliesExpAS = new ImpliesExpASImpl();
		return impliesExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteralExpAS createIntegerLiteralExpAS() {
		IntegerLiteralExpASImpl integerLiteralExpAS = new IntegerLiteralExpASImpl();
		return integerLiteralExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterateExpAS createIterateExpAS() {
		IterateExpASImpl iterateExpAS = new IterateExpASImpl();
		return iterateExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorExpAS createIteratorExpAS() {
		IteratorExpASImpl iteratorExpAS = new IteratorExpASImpl();
		return iteratorExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpAS createLetExpAS() {
		LetExpASImpl letExpAS = new LetExpASImpl();
		return letExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotExpAS createNotExpAS() {
		NotExpASImpl notExpAS = new NotExpASImpl();
		return notExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpressionAS createOclExpressionAS() {
		OclExpressionASImpl oclExpressionAS = new OclExpressionASImpl();
		return oclExpressionAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclMessageArgAS createOclMessageArgAS() {
		OclMessageArgASImpl oclMessageArgAS = new OclMessageArgASImpl();
		return oclMessageArgAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclMessageExpAS createOclMessageExpAS() {
		OclMessageExpASImpl oclMessageExpAS = new OclMessageExpASImpl();
		return oclMessageExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExpAS createOperationCallExpAS() {
		OperationCallExpASImpl operationCallExpAS = new OperationCallExpASImpl();
		return operationCallExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrExpAS createOrExpAS() {
		OrExpASImpl orExpAS = new OrExpASImpl();
		return orExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathNameExpAS createPathNameExpAS() {
		PathNameExpASImpl pathNameExpAS = new PathNameExpASImpl();
		return pathNameExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealLiteralExpAS createRealLiteralExpAS() {
		RealLiteralExpASImpl realLiteralExpAS = new RealLiteralExpASImpl();
		return realLiteralExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpAS createStringLiteralExpAS() {
		StringLiteralExpASImpl stringLiteralExpAS = new StringLiteralExpASImpl();
		return stringLiteralExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralExpAS createTupleLiteralExpAS() {
		TupleLiteralExpASImpl tupleLiteralExpAS = new TupleLiteralExpASImpl();
		return tupleLiteralExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XorExpAS createXorExpAS() {
		XorExpASImpl xorExpAS = new XorExpASImpl();
		return xorExpAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionKindAS createCollectionKindASFromString(EDataType eDataType, String initialValue) {
		CollectionKindAS result = CollectionKindAS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCollectionKindASToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclMessageKindAS createOclMessageKindASFromString(EDataType eDataType, String initialValue) {
		OclMessageKindAS result = OclMessageKindAS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOclMessageKindASToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsPackage getExpressionsPackage() {
		return (ExpressionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ExpressionsPackage getPackage() {
		return ExpressionsPackage.eINSTANCE;
	}

} //ExpressionsFactoryImpl
