/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalyticsFactoryImpl.java,v 1.1 2011/02/07 16:53:52 auhl Exp $
 */
package dataaccess.analytics.impl;

import dataaccess.analytics.*;

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
public class AnalyticsFactoryImpl extends EFactoryImpl implements AnalyticsFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AnalyticsFactory init() {
        try {
            AnalyticsFactory theAnalyticsFactory = (AnalyticsFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/dataaccess/analytics.ecore"); 
            if (theAnalyticsFactory != null) {
                return theAnalyticsFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new AnalyticsFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AnalyticsFactoryImpl() {
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
            case AnalyticsPackage.DIMENSION: return createDimension();
            case AnalyticsPackage.CELL_SET: return createCellSet();
            case AnalyticsPackage.DIMENSION_EXPRESSION: return createDimensionExpression();
            case AnalyticsPackage.GROUP_BY: return createGroupBy();
            case AnalyticsPackage.DIMENSION_DEFINITION: return createDimensionDefinition();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Dimension createDimension() {
        DimensionImpl dimension = new DimensionImpl();
        return dimension;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public CellSet createCellSet() {
        CellSetImpl cellSet = new CellSetImpl();
        return cellSet;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DimensionExpression createDimensionExpression() {
        DimensionExpressionImpl dimensionExpression = new DimensionExpressionImpl();
        return dimensionExpression;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GroupBy createGroupBy() {
        GroupByImpl groupBy = new GroupByImpl();
        return groupBy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DimensionDefinition createDimensionDefinition() {
        DimensionDefinitionImpl dimensionDefinition = new DimensionDefinitionImpl();
        return dimensionDefinition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AnalyticsPackage getAnalyticsPackage() {
        return (AnalyticsPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static AnalyticsPackage getPackage() {
        return AnalyticsPackage.eINSTANCE;
    }

} //AnalyticsFactoryImpl
