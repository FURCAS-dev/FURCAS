/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.status_and_action_old.impl;

import behavioral.status_and_action_old.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class Status_and_action_oldFactoryImpl extends EFactoryImpl implements Status_and_action_oldFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static Status_and_action_oldFactory init() {
        try {
            Status_and_action_oldFactory theStatus_and_action_oldFactory = (Status_and_action_oldFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/status_and_action_old.ecore"); 
            if (theStatus_and_action_oldFactory != null) {
                return theStatus_and_action_oldFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new Status_and_action_oldFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Status_and_action_oldFactoryImpl() {
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
            case Status_and_action_oldPackage.SAM_ACTION: return createSAMAction();
            case Status_and_action_oldPackage.SAM_STATUS_VARIABLE: return createSAMStatusVariable();
            case Status_and_action_oldPackage.SAM_DERIVATOR: return createSAMDerivator();
            case Status_and_action_oldPackage.SAM_STATUS_VALUE: return createSAMStatusValue();
            case Status_and_action_oldPackage.SAM_STATUS_SCHEMA: return createSAMStatusSchema();
            case Status_and_action_oldPackage.SAM_OPERATOR: return createSAMOperator();
            case Status_and_action_oldPackage.SAM_SCHEMA_VARIABLE: return createSAMSchemaVariable();
            case Status_and_action_oldPackage.SAM_SCHEMA_VALUE: return createSAMSchemaValue();
            case Status_and_action_oldPackage.SAM_SCHEMA_ACTION: return createSAMSchemaAction();
            case Status_and_action_oldPackage.SAM_SCHEMA_DERIVATOR: return createSAMSchemaDerivator();
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
            case Status_and_action_oldPackage.SAM_OPERATOR_KIND_ENUM:
                return createSAMOperatorKindEnumFromString(eDataType, initialValue);
            case Status_and_action_oldPackage.SAM_DERIVATOR_KIND_ENUM:
                return createSAMDerivatorKindEnumFromString(eDataType, initialValue);
            case Status_and_action_oldPackage.PRECONDITION_KIND_ENUM:
                return createPreconditionKindEnumFromString(eDataType, initialValue);
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
            case Status_and_action_oldPackage.SAM_OPERATOR_KIND_ENUM:
                return convertSAMOperatorKindEnumToString(eDataType, instanceValue);
            case Status_and_action_oldPackage.SAM_DERIVATOR_KIND_ENUM:
                return convertSAMDerivatorKindEnumToString(eDataType, instanceValue);
            case Status_and_action_oldPackage.PRECONDITION_KIND_ENUM:
                return convertPreconditionKindEnumToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMAction createSAMAction() {
        SAMActionImpl samAction = new SAMActionImpl();
        return samAction;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusVariable createSAMStatusVariable() {
        SAMStatusVariableImpl samStatusVariable = new SAMStatusVariableImpl();
        return samStatusVariable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMDerivator createSAMDerivator() {
        SAMDerivatorImpl samDerivator = new SAMDerivatorImpl();
        return samDerivator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusValue createSAMStatusValue() {
        SAMStatusValueImpl samStatusValue = new SAMStatusValueImpl();
        return samStatusValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMStatusSchema createSAMStatusSchema() {
        SAMStatusSchemaImpl samStatusSchema = new SAMStatusSchemaImpl();
        return samStatusSchema;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMOperator createSAMOperator() {
        SAMOperatorImpl samOperator = new SAMOperatorImpl();
        return samOperator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMSchemaVariable createSAMSchemaVariable() {
        SAMSchemaVariableImpl samSchemaVariable = new SAMSchemaVariableImpl();
        return samSchemaVariable;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMSchemaValue createSAMSchemaValue() {
        SAMSchemaValueImpl samSchemaValue = new SAMSchemaValueImpl();
        return samSchemaValue;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMSchemaAction createSAMSchemaAction() {
        SAMSchemaActionImpl samSchemaAction = new SAMSchemaActionImpl();
        return samSchemaAction;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMSchemaDerivator createSAMSchemaDerivator() {
        SAMSchemaDerivatorImpl samSchemaDerivator = new SAMSchemaDerivatorImpl();
        return samSchemaDerivator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMOperatorKindEnum createSAMOperatorKindEnumFromString(EDataType eDataType, String initialValue) {
        SAMOperatorKindEnum result = SAMOperatorKindEnum.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertSAMOperatorKindEnumToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public SAMDerivatorKindEnum createSAMDerivatorKindEnumFromString(EDataType eDataType, String initialValue) {
        SAMDerivatorKindEnum result = SAMDerivatorKindEnum.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertSAMDerivatorKindEnumToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public PreconditionKindEnum createPreconditionKindEnumFromString(EDataType eDataType, String initialValue) {
        PreconditionKindEnum result = PreconditionKindEnum.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertPreconditionKindEnumToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Status_and_action_oldPackage getStatus_and_action_oldPackage() {
        return (Status_and_action_oldPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static Status_and_action_oldPackage getPackage() {
        return Status_and_action_oldPackage.eINSTANCE;
    }

} //Status_and_action_oldFactoryImpl
