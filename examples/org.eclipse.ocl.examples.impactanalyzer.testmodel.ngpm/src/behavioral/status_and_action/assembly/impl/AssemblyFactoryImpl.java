/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssemblyFactoryImpl.java,v 1.1 2011/02/07 16:43:33 auhl Exp $
 */
package behavioral.status_and_action.assembly.impl;

import behavioral.status_and_action.assembly.*;

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
public class AssemblyFactoryImpl extends EFactoryImpl implements AssemblyFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static AssemblyFactory init() {
        try {
            AssemblyFactory theAssemblyFactory = (AssemblyFactory)EPackage.Registry.INSTANCE.getEFactory("http://eclipse.org/ocl/examples/impactanalyzer/testmodel/ngpm/behavioral/status_and_action/assembly.ecore"); 
            if (theAssemblyFactory != null) {
                return theAssemblyFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new AssemblyFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssemblyFactoryImpl() {
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
            case AssemblyPackage.STATUS_SCHEMA: return createStatusSchema();
            case AssemblyPackage.OPERATOR: return createOperator();
            case AssemblyPackage.ACTION_PROXY: return createActionProxy();
            case AssemblyPackage.STATUS_VALUE_PROXY: return createStatusValueProxy();
            case AssemblyPackage.TRANSITION: return createTransition();
            case AssemblyPackage.SYNCHRONISER: return createSynchroniser();
            case AssemblyPackage.PRECONDITION: return createPrecondition();
            case AssemblyPackage.STATUS_VARIABLE_PROXY: return createStatusVariableProxy();
            case AssemblyPackage.AND_OPERATOR: return createAndOperator();
            case AssemblyPackage.OR_OPERATOR: return createOrOperator();
            case AssemblyPackage.REQUIRED_STRATEGY: return createRequiredStrategy();
            case AssemblyPackage.NEUTRAL_STRATEGY: return createNeutralStrategy();
            case AssemblyPackage.ENABLING_STRATEGY: return createEnablingStrategy();
            case AssemblyPackage.INHIBITING_STRATEGY: return createInhibitingStrategy();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatusSchema createStatusSchema() {
        StatusSchemaImpl statusSchema = new StatusSchemaImpl();
        return statusSchema;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Operator createOperator() {
        OperatorImpl operator = new OperatorImpl();
        return operator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ActionProxy createActionProxy() {
        ActionProxyImpl actionProxy = new ActionProxyImpl();
        return actionProxy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatusValueProxy createStatusValueProxy() {
        StatusValueProxyImpl statusValueProxy = new StatusValueProxyImpl();
        return statusValueProxy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Transition createTransition() {
        TransitionImpl transition = new TransitionImpl();
        return transition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Synchroniser createSynchroniser() {
        SynchroniserImpl synchroniser = new SynchroniserImpl();
        return synchroniser;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Precondition createPrecondition() {
        PreconditionImpl precondition = new PreconditionImpl();
        return precondition;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public StatusVariableProxy createStatusVariableProxy() {
        StatusVariableProxyImpl statusVariableProxy = new StatusVariableProxyImpl();
        return statusVariableProxy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AndOperator createAndOperator() {
        AndOperatorImpl andOperator = new AndOperatorImpl();
        return andOperator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public OrOperator createOrOperator() {
        OrOperatorImpl orOperator = new OrOperatorImpl();
        return orOperator;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public RequiredStrategy createRequiredStrategy() {
        RequiredStrategyImpl requiredStrategy = new RequiredStrategyImpl();
        return requiredStrategy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NeutralStrategy createNeutralStrategy() {
        NeutralStrategyImpl neutralStrategy = new NeutralStrategyImpl();
        return neutralStrategy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EnablingStrategy createEnablingStrategy() {
        EnablingStrategyImpl enablingStrategy = new EnablingStrategyImpl();
        return enablingStrategy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public InhibitingStrategy createInhibitingStrategy() {
        InhibitingStrategyImpl inhibitingStrategy = new InhibitingStrategyImpl();
        return inhibitingStrategy;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AssemblyPackage getAssemblyPackage() {
        return (AssemblyPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static AssemblyPackage getPackage() {
        return AssemblyPackage.eINSTANCE;
    }

} //AssemblyFactoryImpl
