/**
 * <copyright>
 * </copyright>
 *
 * $Id: DesignFactoryImpl.java,v 1.1 2011/02/07 16:48:24 auhl Exp $
 */
package behavioral.status_and_action.design.impl;

import behavioral.status_and_action.design.*;

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
public class DesignFactoryImpl extends EFactoryImpl implements DesignFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static DesignFactory init() {
        try {
            DesignFactory theDesignFactory = (DesignFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/status_and_action/design.ecore"); 
            if (theDesignFactory != null) {
                return theDesignFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new DesignFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DesignFactoryImpl() {
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
            case DesignPackage.BUSINESS_OBJECT: return createBusinessObject();
            case DesignPackage.BUSINESS_OBJECT_NODE: return createBusinessObjectNode();
            case DesignPackage.STATUS_VARIABLE: return createStatusVariable();
            case DesignPackage.STATUS_VALUE: return createStatusValue();
            case DesignPackage.ACTION: return createAction();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessObject createBusinessObject() {
        BusinessObjectImpl businessObject = new BusinessObjectImpl();
        return businessObject;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessObjectNode createBusinessObjectNode() {
        BusinessObjectNodeImpl businessObjectNode = new BusinessObjectNodeImpl();
        return businessObjectNode;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatusVariable createStatusVariable() {
        StatusVariableImpl statusVariable = new StatusVariableImpl();
        return statusVariable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatusValue createStatusValue() {
        StatusValueImpl statusValue = new StatusValueImpl();
        return statusValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Action createAction() {
        ActionImpl action = new ActionImpl();
        return action;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public DesignPackage getDesignPackage() {
        return (DesignPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static DesignPackage getPackage() {
        return DesignPackage.eINSTANCE;
    }

} //DesignFactoryImpl
