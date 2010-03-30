/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.queryEvaluator.impl;

import de.hpi.sam.bp2009.benchframework.queryEvaluator.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.ocl.ecore.OCL.Query;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QueryEvaluatorFactoryImpl extends EFactoryImpl implements QueryEvaluatorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QueryEvaluatorFactory init() {
		try {
			QueryEvaluatorFactory theQueryEvaluatorFactory = (QueryEvaluatorFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.hpi.sam.bp2009.benchframework.queryEvaluator"); 
			if (theQueryEvaluatorFactory != null) {
				return theQueryEvaluatorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QueryEvaluatorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryEvaluatorFactoryImpl() {
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
			case QueryEvaluatorPackage.EMBED_QE_OPERATOR: return createEmbedQEOperator();
			case QueryEvaluatorPackage.QUERY_EVALUATOR: return createQueryEvaluator();
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
			case QueryEvaluatorPackage.QUERY_EVALUATOR_NOTIFY_LITERALS:
				return createQueryEvaluatorNotifyLiteralsFromString(eDataType, initialValue);
			case QueryEvaluatorPackage.QUERY:
				return createQueryFromString(eDataType, initialValue);
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
			case QueryEvaluatorPackage.QUERY_EVALUATOR_NOTIFY_LITERALS:
				return convertQueryEvaluatorNotifyLiteralsToString(eDataType, instanceValue);
			case QueryEvaluatorPackage.QUERY:
				return convertQueryToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmbedQEOperator createEmbedQEOperator() {
		EmbedQEOperatorImpl embedQEOperator = new EmbedQEOperatorImpl();
		return embedQEOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryEvaluator createQueryEvaluator() {
		QueryEvaluatorImpl queryEvaluator = new QueryEvaluatorImpl();
		return queryEvaluator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryEvaluatorNotifyLiterals createQueryEvaluatorNotifyLiteralsFromString(EDataType eDataType, String initialValue) {
		QueryEvaluatorNotifyLiterals result = QueryEvaluatorNotifyLiterals.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQueryEvaluatorNotifyLiteralsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQueryFromString(EDataType eDataType, String initialValue) {
		return (Query)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertQueryToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryEvaluatorPackage getQueryEvaluatorPackage() {
		return (QueryEvaluatorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QueryEvaluatorPackage getPackage() {
		return QueryEvaluatorPackage.eINSTANCE;
	}

} //QueryEvaluatorFactoryImpl
