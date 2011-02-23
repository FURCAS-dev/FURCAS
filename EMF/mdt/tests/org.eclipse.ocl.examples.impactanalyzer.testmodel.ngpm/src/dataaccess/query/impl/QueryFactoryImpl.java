/**
 * <copyright>
 * </copyright>
 *
 * $Id: QueryFactoryImpl.java,v 1.1 2011/02/07 17:20:41 auhl Exp $
 */
package dataaccess.query.impl;

import dataaccess.query.*;

import org.eclipse.emf.ecore.EClass;
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
public class QueryFactoryImpl extends EFactoryImpl implements QueryFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static QueryFactory init() {
        try {
            QueryFactory theQueryFactory = (QueryFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/dataaccess/query.ecore"); 
            if (theQueryFactory != null) {
                return theQueryFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new QueryFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QueryFactoryImpl() {
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
            case QueryPackage.SELECTION: return createSelection();
            case QueryPackage.OQL_QUERY: return createOqlQuery();
            case QueryPackage.FROM_CLAUSE: return createFromClause();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Selection createSelection() {
        SelectionImpl selection = new SelectionImpl();
        return selection;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OqlQuery createOqlQuery() {
        OqlQueryImpl oqlQuery = new OqlQueryImpl();
        return oqlQuery;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public FromClause createFromClause() {
        FromClauseImpl fromClause = new FromClauseImpl();
        return fromClause;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public QueryPackage getQueryPackage() {
        return (QueryPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static QueryPackage getPackage() {
        return QueryPackage.eINSTANCE;
    }

} //QueryFactoryImpl
