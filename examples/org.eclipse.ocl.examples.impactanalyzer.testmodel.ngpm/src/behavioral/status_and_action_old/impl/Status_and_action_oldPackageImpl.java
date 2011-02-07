/**
 * <copyright>
 * </copyright>
 *
 * $Id: Status_and_action_oldPackageImpl.java,v 1.1 2011/02/07 16:47:38 auhl Exp $
 */
package behavioral.status_and_action_old.impl;

import abapmapping.AbapmappingPackage;

import abapmapping.abapdictionary.AbapdictionaryPackage;

import abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl;

import abapmapping.impl.AbapmappingPackageImpl;

import ap_runtime_constraints.Ap_runtime_constraintsPackage;

import ap_runtime_constraints.impl.Ap_runtime_constraintsPackageImpl;

import behavioral.actions.ActionsPackage;

import behavioral.actions.impl.ActionsPackageImpl;

import behavioral.bpdm.BpdmPackage;

import behavioral.bpdm.impl.BpdmPackageImpl;

import behavioral.businesstasks.BusinesstasksPackage;

import behavioral.businesstasks.impl.BusinesstasksPackageImpl;

import behavioral.events.EventsPackage;

import behavioral.events.impl.EventsPackageImpl;

import behavioral.rules.RulesPackage;

import behavioral.rules.impl.RulesPackageImpl;

import behavioral.status_and_action.assembly.AssemblyPackage;

import behavioral.status_and_action.assembly.impl.AssemblyPackageImpl;

import behavioral.status_and_action.design.DesignPackage;

import behavioral.status_and_action.design.impl.DesignPackageImpl;

import behavioral.status_and_action_old.PreconditionKindEnum;
import behavioral.status_and_action_old.SAMAction;
import behavioral.status_and_action_old.SAMDerivator;
import behavioral.status_and_action_old.SAMDerivatorKindEnum;
import behavioral.status_and_action_old.SAMOperator;
import behavioral.status_and_action_old.SAMOperatorKindEnum;
import behavioral.status_and_action_old.SAMSchemaAction;
import behavioral.status_and_action_old.SAMSchemaDerivator;
import behavioral.status_and_action_old.SAMSchemaValue;
import behavioral.status_and_action_old.SAMSchemaVariable;
import behavioral.status_and_action_old.SAMStatusSchema;
import behavioral.status_and_action_old.SAMStatusValue;
import behavioral.status_and_action_old.SAMStatusVariable;
import behavioral.status_and_action_old.Status_and_action_oldFactory;
import behavioral.status_and_action_old.Status_and_action_oldPackage;

import behavioral.transactions.TransactionsPackage;

import behavioral.transactions.impl.TransactionsPackageImpl;

import configuration.businessconfiguration.BusinessconfigurationPackage;

import configuration.businessconfiguration.experimental.ExperimentalPackage;

import configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl;

import configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl;

import configuration.context_drivers.Context_driversPackage;

import configuration.context_drivers.impl.Context_driversPackageImpl;

import data.classes.ClassesPackage;

import data.classes.impl.ClassesPackageImpl;

import data.constraints.ConstraintsPackage;

import data.constraints.impl.ConstraintsPackageImpl;

import data.documents.DocumentsPackage;

import data.documents.impl.DocumentsPackageImpl;

import data.generics.GenericsPackage;

import data.generics.impl.GenericsPackageImpl;

import data.quantitystructure.QuantitystructurePackage;

import data.quantitystructure.impl.QuantitystructurePackageImpl;

import data.timedependency.TimedependencyPackage;

import data.timedependency.impl.TimedependencyPackageImpl;

import data.tuples.TuplesPackage;

import data.tuples.impl.TuplesPackageImpl;

import dataaccess.analytics.AnalyticsPackage;

import dataaccess.analytics.impl.AnalyticsPackageImpl;

import dataaccess.expressions.ExpressionsPackage;

import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;

import dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl;

import dataaccess.expressions.fp.FpPackage;

import dataaccess.expressions.fp.impl.FpPackageImpl;

import dataaccess.expressions.impl.ExpressionsPackageImpl;

import dataaccess.expressions.literals.LiteralsPackage;

import dataaccess.expressions.literals.impl.LiteralsPackageImpl;

import dataaccess.query.QueryPackage;

import dataaccess.query.impl.QueryPackageImpl;

import integration.binding.BindingPackage;

import integration.binding.impl.BindingPackageImpl;

import integration.processintegration.ProcessintegrationPackage;

import integration.processintegration.impl.ProcessintegrationPackageImpl;

import integration.xsd.XsdPackage;

import integration.xsd.impl.XsdPackageImpl;

import localization.LocalizationPackage;

import localization.impl.LocalizationPackageImpl;

import modelmanagement.ModelmanagementPackage;

import modelmanagement.deploymentunits.DeploymentunitsPackage;

import modelmanagement.deploymentunits.impl.DeploymentunitsPackageImpl;

import modelmanagement.impl.ModelmanagementPackageImpl;

import modelmanagement.processcomponents.ProcesscomponentsPackage;

import modelmanagement.processcomponents.impl.ProcesscomponentsPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import ui.data_binding.Data_bindingPackage;

import ui.data_binding.impl.Data_bindingPackageImpl;

import ui.templates.TemplatesPackage;

import ui.templates.impl.TemplatesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Status_and_action_oldPackageImpl extends EPackageImpl implements Status_and_action_oldPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samActionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samStatusVariableEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samDerivatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samStatusValueEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samStatusSchemaEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samOperatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samSchemaVariableEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samSchemaValueEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samSchemaActionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass samSchemaDerivatorEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum samOperatorKindEnumEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum samDerivatorKindEnumEEnum = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EEnum preconditionKindEnumEEnum = null;

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
     * @see behavioral.status_and_action_old.Status_and_action_oldPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private Status_and_action_oldPackageImpl() {
        super(eNS_URI, Status_and_action_oldFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link Status_and_action_oldPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static Status_and_action_oldPackage init() {
        if (isInited) return (Status_and_action_oldPackage)EPackage.Registry.INSTANCE.getEPackage(Status_and_action_oldPackage.eNS_URI);

        // Obtain or create and register package
        Status_and_action_oldPackageImpl theStatus_and_action_oldPackage = (Status_and_action_oldPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Status_and_action_oldPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Status_and_action_oldPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        AbapmappingPackageImpl theAbapmappingPackage = (AbapmappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) instanceof AbapmappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) : AbapmappingPackage.eINSTANCE);
        AbapdictionaryPackageImpl theAbapdictionaryPackage = (AbapdictionaryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) instanceof AbapdictionaryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) : AbapdictionaryPackage.eINSTANCE);
        Ap_runtime_constraintsPackageImpl theAp_runtime_constraintsPackage = (Ap_runtime_constraintsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ap_runtime_constraintsPackage.eNS_URI) instanceof Ap_runtime_constraintsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ap_runtime_constraintsPackage.eNS_URI) : Ap_runtime_constraintsPackage.eINSTANCE);
        BpdmPackageImpl theBpdmPackage = (BpdmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BpdmPackage.eNS_URI) instanceof BpdmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BpdmPackage.eNS_URI) : BpdmPackage.eINSTANCE);
        BusinesstasksPackageImpl theBusinesstasksPackage = (BusinesstasksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BusinesstasksPackage.eNS_URI) instanceof BusinesstasksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BusinesstasksPackage.eNS_URI) : BusinesstasksPackage.eINSTANCE);
        ActionsPackageImpl theActionsPackage = (ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI) instanceof ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI) : ActionsPackage.eINSTANCE);
        RulesPackageImpl theRulesPackage = (RulesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI) instanceof RulesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI) : RulesPackage.eINSTANCE);
        EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
        TransactionsPackageImpl theTransactionsPackage = (TransactionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TransactionsPackage.eNS_URI) instanceof TransactionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TransactionsPackage.eNS_URI) : TransactionsPackage.eINSTANCE);
        DesignPackageImpl theDesignPackage = (DesignPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DesignPackage.eNS_URI) instanceof DesignPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DesignPackage.eNS_URI) : DesignPackage.eINSTANCE);
        AssemblyPackageImpl theAssemblyPackage = (AssemblyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) instanceof AssemblyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) : AssemblyPackage.eINSTANCE);
        BusinessconfigurationPackageImpl theBusinessconfigurationPackage = (BusinessconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BusinessconfigurationPackage.eNS_URI) instanceof BusinessconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BusinessconfigurationPackage.eNS_URI) : BusinessconfigurationPackage.eINSTANCE);
        ExperimentalPackageImpl theExperimentalPackage = (ExperimentalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentalPackage.eNS_URI) instanceof ExperimentalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentalPackage.eNS_URI) : ExperimentalPackage.eINSTANCE);
        Context_driversPackageImpl theContext_driversPackage = (Context_driversPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Context_driversPackage.eNS_URI) instanceof Context_driversPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Context_driversPackage.eNS_URI) : Context_driversPackage.eINSTANCE);
        ClassesPackageImpl theClassesPackage = (ClassesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI) : ClassesPackage.eINSTANCE);
        ConstraintsPackageImpl theConstraintsPackage = (ConstraintsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI) instanceof ConstraintsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI) : ConstraintsPackage.eINSTANCE);
        QuantitystructurePackageImpl theQuantitystructurePackage = (QuantitystructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QuantitystructurePackage.eNS_URI) instanceof QuantitystructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QuantitystructurePackage.eNS_URI) : QuantitystructurePackage.eINSTANCE);
        TimedependencyPackageImpl theTimedependencyPackage = (TimedependencyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TimedependencyPackage.eNS_URI) instanceof TimedependencyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TimedependencyPackage.eNS_URI) : TimedependencyPackage.eINSTANCE);
        DocumentsPackageImpl theDocumentsPackage = (DocumentsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DocumentsPackage.eNS_URI) instanceof DocumentsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DocumentsPackage.eNS_URI) : DocumentsPackage.eINSTANCE);
        GenericsPackageImpl theGenericsPackage = (GenericsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) instanceof GenericsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) : GenericsPackage.eINSTANCE);
        TuplesPackageImpl theTuplesPackage = (TuplesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TuplesPackage.eNS_URI) instanceof TuplesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TuplesPackage.eNS_URI) : TuplesPackage.eINSTANCE);
        ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
        LiteralsPackageImpl theLiteralsPackage = (LiteralsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LiteralsPackage.eNS_URI) instanceof LiteralsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LiteralsPackage.eNS_URI) : LiteralsPackage.eINSTANCE);
        CollectionexpressionsPackageImpl theCollectionexpressionsPackage = (CollectionexpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CollectionexpressionsPackage.eNS_URI) instanceof CollectionexpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CollectionexpressionsPackage.eNS_URI) : CollectionexpressionsPackage.eINSTANCE);
        FpPackageImpl theFpPackage = (FpPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(FpPackage.eNS_URI) instanceof FpPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(FpPackage.eNS_URI) : FpPackage.eINSTANCE);
        QueryPackageImpl theQueryPackage = (QueryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) instanceof QueryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI) : QueryPackage.eINSTANCE);
        AnalyticsPackageImpl theAnalyticsPackage = (AnalyticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnalyticsPackage.eNS_URI) instanceof AnalyticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnalyticsPackage.eNS_URI) : AnalyticsPackage.eINSTANCE);
        ProcessintegrationPackageImpl theProcessintegrationPackage = (ProcessintegrationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcessintegrationPackage.eNS_URI) instanceof ProcessintegrationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcessintegrationPackage.eNS_URI) : ProcessintegrationPackage.eINSTANCE);
        XsdPackageImpl theXsdPackage = (XsdPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XsdPackage.eNS_URI) instanceof XsdPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XsdPackage.eNS_URI) : XsdPackage.eINSTANCE);
        BindingPackageImpl theBindingPackage = (BindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
        LocalizationPackageImpl theLocalizationPackage = (LocalizationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LocalizationPackage.eNS_URI) instanceof LocalizationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LocalizationPackage.eNS_URI) : LocalizationPackage.eINSTANCE);
        ModelmanagementPackageImpl theModelmanagementPackage = (ModelmanagementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelmanagementPackage.eNS_URI) instanceof ModelmanagementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelmanagementPackage.eNS_URI) : ModelmanagementPackage.eINSTANCE);
        ProcesscomponentsPackageImpl theProcesscomponentsPackage = (ProcesscomponentsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcesscomponentsPackage.eNS_URI) instanceof ProcesscomponentsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcesscomponentsPackage.eNS_URI) : ProcesscomponentsPackage.eINSTANCE);
        DeploymentunitsPackageImpl theDeploymentunitsPackage = (DeploymentunitsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeploymentunitsPackage.eNS_URI) instanceof DeploymentunitsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeploymentunitsPackage.eNS_URI) : DeploymentunitsPackage.eINSTANCE);
        persistence.actions.impl.ActionsPackageImpl theActionsPackage_1 = (persistence.actions.impl.ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) instanceof persistence.actions.impl.ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) : persistence.actions.ActionsPackage.eINSTANCE);
        persistence.expressions.impl.ExpressionsPackageImpl theExpressionsPackage_1 = (persistence.expressions.impl.ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) instanceof persistence.expressions.impl.ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) : persistence.expressions.ExpressionsPackage.eINSTANCE);
        Data_bindingPackageImpl theData_bindingPackage = (Data_bindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Data_bindingPackage.eNS_URI) instanceof Data_bindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Data_bindingPackage.eNS_URI) : Data_bindingPackage.eINSTANCE);
        TemplatesPackageImpl theTemplatesPackage = (TemplatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) instanceof TemplatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) : TemplatesPackage.eINSTANCE);

        // Create package meta-data objects
        theStatus_and_action_oldPackage.createPackageContents();
        theAbapmappingPackage.createPackageContents();
        theAbapdictionaryPackage.createPackageContents();
        theAp_runtime_constraintsPackage.createPackageContents();
        theBpdmPackage.createPackageContents();
        theBusinesstasksPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theRulesPackage.createPackageContents();
        theEventsPackage.createPackageContents();
        theTransactionsPackage.createPackageContents();
        theDesignPackage.createPackageContents();
        theAssemblyPackage.createPackageContents();
        theBusinessconfigurationPackage.createPackageContents();
        theExperimentalPackage.createPackageContents();
        theContext_driversPackage.createPackageContents();
        theClassesPackage.createPackageContents();
        theConstraintsPackage.createPackageContents();
        theQuantitystructurePackage.createPackageContents();
        theTimedependencyPackage.createPackageContents();
        theDocumentsPackage.createPackageContents();
        theGenericsPackage.createPackageContents();
        theTuplesPackage.createPackageContents();
        theExpressionsPackage.createPackageContents();
        theLiteralsPackage.createPackageContents();
        theCollectionexpressionsPackage.createPackageContents();
        theFpPackage.createPackageContents();
        theQueryPackage.createPackageContents();
        theAnalyticsPackage.createPackageContents();
        theProcessintegrationPackage.createPackageContents();
        theXsdPackage.createPackageContents();
        theBindingPackage.createPackageContents();
        theLocalizationPackage.createPackageContents();
        theModelmanagementPackage.createPackageContents();
        theProcesscomponentsPackage.createPackageContents();
        theDeploymentunitsPackage.createPackageContents();
        theActionsPackage_1.createPackageContents();
        theExpressionsPackage_1.createPackageContents();
        theData_bindingPackage.createPackageContents();
        theTemplatesPackage.createPackageContents();

        // Initialize created meta-data
        theStatus_and_action_oldPackage.initializePackageContents();
        theAbapmappingPackage.initializePackageContents();
        theAbapdictionaryPackage.initializePackageContents();
        theAp_runtime_constraintsPackage.initializePackageContents();
        theBpdmPackage.initializePackageContents();
        theBusinesstasksPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theRulesPackage.initializePackageContents();
        theEventsPackage.initializePackageContents();
        theTransactionsPackage.initializePackageContents();
        theDesignPackage.initializePackageContents();
        theAssemblyPackage.initializePackageContents();
        theBusinessconfigurationPackage.initializePackageContents();
        theExperimentalPackage.initializePackageContents();
        theContext_driversPackage.initializePackageContents();
        theClassesPackage.initializePackageContents();
        theConstraintsPackage.initializePackageContents();
        theQuantitystructurePackage.initializePackageContents();
        theTimedependencyPackage.initializePackageContents();
        theDocumentsPackage.initializePackageContents();
        theGenericsPackage.initializePackageContents();
        theTuplesPackage.initializePackageContents();
        theExpressionsPackage.initializePackageContents();
        theLiteralsPackage.initializePackageContents();
        theCollectionexpressionsPackage.initializePackageContents();
        theFpPackage.initializePackageContents();
        theQueryPackage.initializePackageContents();
        theAnalyticsPackage.initializePackageContents();
        theProcessintegrationPackage.initializePackageContents();
        theXsdPackage.initializePackageContents();
        theBindingPackage.initializePackageContents();
        theLocalizationPackage.initializePackageContents();
        theModelmanagementPackage.initializePackageContents();
        theProcesscomponentsPackage.initializePackageContents();
        theDeploymentunitsPackage.initializePackageContents();
        theActionsPackage_1.initializePackageContents();
        theExpressionsPackage_1.initializePackageContents();
        theData_bindingPackage.initializePackageContents();
        theTemplatesPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theStatus_and_action_oldPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(Status_and_action_oldPackage.eNS_URI, theStatus_and_action_oldPackage);
        return theStatus_and_action_oldPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMAction() {
        return samActionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMAction_Name() {
        return (EAttribute)samActionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMAction_IsAgentAction() {
        return (EAttribute)samActionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMAction_BusinessObjectNode() {
        return (EReference)samActionEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMAction_SamSchemaActions() {
        return (EReference)samActionEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMStatusVariable() {
        return samStatusVariableEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMStatusVariable_Name() {
        return (EAttribute)samStatusVariableEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMStatusVariable_IsAgentVariable() {
        return (EAttribute)samStatusVariableEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusVariable_BusinessObjectNode() {
        return (EReference)samStatusVariableEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusVariable_SamStatusValues() {
        return (EReference)samStatusVariableEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusVariable_SamSchemaVariables() {
        return (EReference)samStatusVariableEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMDerivator() {
        return samDerivatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMDerivator_Kind() {
        return (EAttribute)samDerivatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMDerivator_BusinessObject() {
        return (EReference)samDerivatorEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMDerivator_SamSchemaDerivators() {
        return (EReference)samDerivatorEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMStatusValue() {
        return samStatusValueEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMStatusValue_Name() {
        return (EAttribute)samStatusValueEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusValue_SamStatusVariable() {
        return (EReference)samStatusValueEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMStatusSchema() {
        return samStatusSchemaEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMStatusSchema_Name() {
        return (EAttribute)samStatusSchemaEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusSchema_BusinessObjectNode() {
        return (EReference)samStatusSchemaEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusSchema_SamOperators() {
        return (EReference)samStatusSchemaEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusSchema_SamSchemaVariables() {
        return (EReference)samStatusSchemaEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusSchema_SamSchemaActions() {
        return (EReference)samStatusSchemaEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMStatusSchema_SamSchemaDerivators() {
        return (EReference)samStatusSchemaEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMOperator() {
        return samOperatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMOperator_Kind() {
        return (EAttribute)samOperatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMOperator_SamStatusSchema() {
        return (EReference)samOperatorEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMOperator_SamSchemaValues() {
        return (EReference)samOperatorEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMOperator_SamSourceOperators() {
        return (EReference)samOperatorEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMOperator_SamTargetOperators() {
        return (EReference)samOperatorEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMOperator_SamSchemaActions() {
        return (EReference)samOperatorEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMSchemaVariable() {
        return samSchemaVariableEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMSchemaVariable_HasStateGuard() {
        return (EAttribute)samSchemaVariableEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaVariable_SamStatusSchema() {
        return (EReference)samSchemaVariableEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaVariable_SamSchemaValues() {
        return (EReference)samSchemaVariableEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaVariable_SamSchemaValue() {
        return (EReference)samSchemaVariableEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaVariable_SamTargetSchemaDerivators() {
        return (EReference)samSchemaVariableEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaVariable_SamSourceSchemaDerivators() {
        return (EReference)samSchemaVariableEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMSchemaValue() {
        return samSchemaValueEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMSchemaValue_IsInitial() {
        return (EAttribute)samSchemaValueEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSAMSchemaValue_IsInhibiting() {
        return (EAttribute)samSchemaValueEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaValue_SamSchemaVariable() {
        return (EReference)samSchemaValueEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaValue_SamSourceSchemaActions() {
        return (EReference)samSchemaValueEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaValue_SamSourceSchemaValues() {
        return (EReference)samSchemaValueEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaValue_SamTargetSchemaValues() {
        return (EReference)samSchemaValueEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaValue_SamOperators() {
        return (EReference)samSchemaValueEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaValue_SamSchemaActions() {
        return (EReference)samSchemaValueEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMSchemaAction() {
        return samSchemaActionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaAction_SamStatusSchema() {
        return (EReference)samSchemaActionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaAction_SamAction() {
        return (EReference)samSchemaActionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaAction_SamTargetSchemaValues() {
        return (EReference)samSchemaActionEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaAction_SamSchemaValues() {
        return (EReference)samSchemaActionEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaAction_SamSchemaOperators() {
        return (EReference)samSchemaActionEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSAMSchemaDerivator() {
        return samSchemaDerivatorEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaDerivator_SamDerivator() {
        return (EReference)samSchemaDerivatorEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaDerivator_SamStatusSchema() {
        return (EReference)samSchemaDerivatorEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaDerivator_SamSourceSchemaVariables() {
        return (EReference)samSchemaDerivatorEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSAMSchemaDerivator_SamTargetSchemaVariable() {
        return (EReference)samSchemaDerivatorEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getSAMOperatorKindEnum() {
        return samOperatorKindEnumEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getSAMDerivatorKindEnum() {
        return samDerivatorKindEnumEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EEnum getPreconditionKindEnum() {
        return preconditionKindEnumEEnum;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Status_and_action_oldFactory getStatus_and_action_oldFactory() {
        return (Status_and_action_oldFactory)getEFactoryInstance();
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
        samActionEClass = createEClass(SAM_ACTION);
        createEAttribute(samActionEClass, SAM_ACTION__NAME);
        createEAttribute(samActionEClass, SAM_ACTION__IS_AGENT_ACTION);
        createEReference(samActionEClass, SAM_ACTION__BUSINESS_OBJECT_NODE);
        createEReference(samActionEClass, SAM_ACTION__SAM_SCHEMA_ACTIONS);

        samStatusVariableEClass = createEClass(SAM_STATUS_VARIABLE);
        createEAttribute(samStatusVariableEClass, SAM_STATUS_VARIABLE__NAME);
        createEAttribute(samStatusVariableEClass, SAM_STATUS_VARIABLE__IS_AGENT_VARIABLE);
        createEReference(samStatusVariableEClass, SAM_STATUS_VARIABLE__BUSINESS_OBJECT_NODE);
        createEReference(samStatusVariableEClass, SAM_STATUS_VARIABLE__SAM_STATUS_VALUES);
        createEReference(samStatusVariableEClass, SAM_STATUS_VARIABLE__SAM_SCHEMA_VARIABLES);

        samDerivatorEClass = createEClass(SAM_DERIVATOR);
        createEAttribute(samDerivatorEClass, SAM_DERIVATOR__KIND);
        createEReference(samDerivatorEClass, SAM_DERIVATOR__BUSINESS_OBJECT);
        createEReference(samDerivatorEClass, SAM_DERIVATOR__SAM_SCHEMA_DERIVATORS);

        samStatusValueEClass = createEClass(SAM_STATUS_VALUE);
        createEAttribute(samStatusValueEClass, SAM_STATUS_VALUE__NAME);
        createEReference(samStatusValueEClass, SAM_STATUS_VALUE__SAM_STATUS_VARIABLE);

        samStatusSchemaEClass = createEClass(SAM_STATUS_SCHEMA);
        createEAttribute(samStatusSchemaEClass, SAM_STATUS_SCHEMA__NAME);
        createEReference(samStatusSchemaEClass, SAM_STATUS_SCHEMA__BUSINESS_OBJECT_NODE);
        createEReference(samStatusSchemaEClass, SAM_STATUS_SCHEMA__SAM_OPERATORS);
        createEReference(samStatusSchemaEClass, SAM_STATUS_SCHEMA__SAM_SCHEMA_VARIABLES);
        createEReference(samStatusSchemaEClass, SAM_STATUS_SCHEMA__SAM_SCHEMA_ACTIONS);
        createEReference(samStatusSchemaEClass, SAM_STATUS_SCHEMA__SAM_SCHEMA_DERIVATORS);

        samOperatorEClass = createEClass(SAM_OPERATOR);
        createEAttribute(samOperatorEClass, SAM_OPERATOR__KIND);
        createEReference(samOperatorEClass, SAM_OPERATOR__SAM_STATUS_SCHEMA);
        createEReference(samOperatorEClass, SAM_OPERATOR__SAM_SCHEMA_VALUES);
        createEReference(samOperatorEClass, SAM_OPERATOR__SAM_SOURCE_OPERATORS);
        createEReference(samOperatorEClass, SAM_OPERATOR__SAM_TARGET_OPERATORS);
        createEReference(samOperatorEClass, SAM_OPERATOR__SAM_SCHEMA_ACTIONS);

        samSchemaVariableEClass = createEClass(SAM_SCHEMA_VARIABLE);
        createEAttribute(samSchemaVariableEClass, SAM_SCHEMA_VARIABLE__HAS_STATE_GUARD);
        createEReference(samSchemaVariableEClass, SAM_SCHEMA_VARIABLE__SAM_STATUS_SCHEMA);
        createEReference(samSchemaVariableEClass, SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUES);
        createEReference(samSchemaVariableEClass, SAM_SCHEMA_VARIABLE__SAM_SCHEMA_VALUE);
        createEReference(samSchemaVariableEClass, SAM_SCHEMA_VARIABLE__SAM_TARGET_SCHEMA_DERIVATORS);
        createEReference(samSchemaVariableEClass, SAM_SCHEMA_VARIABLE__SAM_SOURCE_SCHEMA_DERIVATORS);

        samSchemaValueEClass = createEClass(SAM_SCHEMA_VALUE);
        createEAttribute(samSchemaValueEClass, SAM_SCHEMA_VALUE__IS_INITIAL);
        createEAttribute(samSchemaValueEClass, SAM_SCHEMA_VALUE__IS_INHIBITING);
        createEReference(samSchemaValueEClass, SAM_SCHEMA_VALUE__SAM_SCHEMA_VARIABLE);
        createEReference(samSchemaValueEClass, SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_ACTIONS);
        createEReference(samSchemaValueEClass, SAM_SCHEMA_VALUE__SAM_SOURCE_SCHEMA_VALUES);
        createEReference(samSchemaValueEClass, SAM_SCHEMA_VALUE__SAM_TARGET_SCHEMA_VALUES);
        createEReference(samSchemaValueEClass, SAM_SCHEMA_VALUE__SAM_OPERATORS);
        createEReference(samSchemaValueEClass, SAM_SCHEMA_VALUE__SAM_SCHEMA_ACTIONS);

        samSchemaActionEClass = createEClass(SAM_SCHEMA_ACTION);
        createEReference(samSchemaActionEClass, SAM_SCHEMA_ACTION__SAM_STATUS_SCHEMA);
        createEReference(samSchemaActionEClass, SAM_SCHEMA_ACTION__SAM_ACTION);
        createEReference(samSchemaActionEClass, SAM_SCHEMA_ACTION__SAM_TARGET_SCHEMA_VALUES);
        createEReference(samSchemaActionEClass, SAM_SCHEMA_ACTION__SAM_SCHEMA_VALUES);
        createEReference(samSchemaActionEClass, SAM_SCHEMA_ACTION__SAM_SCHEMA_OPERATORS);

        samSchemaDerivatorEClass = createEClass(SAM_SCHEMA_DERIVATOR);
        createEReference(samSchemaDerivatorEClass, SAM_SCHEMA_DERIVATOR__SAM_DERIVATOR);
        createEReference(samSchemaDerivatorEClass, SAM_SCHEMA_DERIVATOR__SAM_STATUS_SCHEMA);
        createEReference(samSchemaDerivatorEClass, SAM_SCHEMA_DERIVATOR__SAM_SOURCE_SCHEMA_VARIABLES);
        createEReference(samSchemaDerivatorEClass, SAM_SCHEMA_DERIVATOR__SAM_TARGET_SCHEMA_VARIABLE);

        // Create enums
        samOperatorKindEnumEEnum = createEEnum(SAM_OPERATOR_KIND_ENUM);
        samDerivatorKindEnumEEnum = createEEnum(SAM_DERIVATOR_KIND_ENUM);
        preconditionKindEnumEEnum = createEEnum(PRECONDITION_KIND_ENUM);
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
        ClassesPackage theClassesPackage = (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(samActionEClass, SAMAction.class, "SAMAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSAMAction_Name(), theEcorePackage.getEString(), "name", null, 1, 1, SAMAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getSAMAction_IsAgentAction(), theEcorePackage.getEBoolean(), "isAgentAction", null, 1, 1, SAMAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSAMAction_BusinessObjectNode(), theClassesPackage.getSapClass(), theClassesPackage.getSapClass_SamActions(), "businessObjectNode", null, 1, 1, SAMAction.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMAction_SamSchemaActions(), this.getSAMSchemaAction(), this.getSAMSchemaAction_SamAction(), "samSchemaActions", null, 0, -1, SAMAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samStatusVariableEClass, SAMStatusVariable.class, "SAMStatusVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSAMStatusVariable_Name(), theEcorePackage.getEString(), "name", null, 1, 1, SAMStatusVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getSAMStatusVariable_IsAgentVariable(), theEcorePackage.getEBoolean(), "isAgentVariable", null, 1, 1, SAMStatusVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSAMStatusVariable_BusinessObjectNode(), theClassesPackage.getSapClass(), theClassesPackage.getSapClass_SamStatusVariables(), "businessObjectNode", null, 1, 1, SAMStatusVariable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMStatusVariable_SamStatusValues(), this.getSAMStatusValue(), this.getSAMStatusValue_SamStatusVariable(), "samStatusValues", null, 0, -1, SAMStatusVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMStatusVariable_SamSchemaVariables(), this.getSAMSchemaVariable(), this.getSAMSchemaVariable_SamSchemaValue(), "samSchemaVariables", null, 0, -1, SAMStatusVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samDerivatorEClass, SAMDerivator.class, "SAMDerivator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSAMDerivator_Kind(), this.getSAMDerivatorKindEnum(), "kind", null, 1, 1, SAMDerivator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSAMDerivator_BusinessObject(), theClassesPackage.getSapClass(), theClassesPackage.getSapClass_SamDerivators(), "businessObject", null, 1, 1, SAMDerivator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMDerivator_SamSchemaDerivators(), this.getSAMSchemaDerivator(), this.getSAMSchemaDerivator_SamDerivator(), "samSchemaDerivators", null, 0, -1, SAMDerivator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samStatusValueEClass, SAMStatusValue.class, "SAMStatusValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSAMStatusValue_Name(), theEcorePackage.getEString(), "name", null, 1, 1, SAMStatusValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSAMStatusValue_SamStatusVariable(), this.getSAMStatusVariable(), this.getSAMStatusVariable_SamStatusValues(), "samStatusVariable", null, 1, 1, SAMStatusValue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samStatusSchemaEClass, SAMStatusSchema.class, "SAMStatusSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSAMStatusSchema_Name(), theEcorePackage.getEString(), "name", null, 1, 1, SAMStatusSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSAMStatusSchema_BusinessObjectNode(), theClassesPackage.getSapClass(), theClassesPackage.getSapClass_SamStatusSchema(), "businessObjectNode", null, 1, 1, SAMStatusSchema.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMStatusSchema_SamOperators(), this.getSAMOperator(), this.getSAMOperator_SamStatusSchema(), "samOperators", null, 0, -1, SAMStatusSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMStatusSchema_SamSchemaVariables(), this.getSAMSchemaVariable(), this.getSAMSchemaVariable_SamStatusSchema(), "samSchemaVariables", null, 0, -1, SAMStatusSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMStatusSchema_SamSchemaActions(), this.getSAMSchemaAction(), this.getSAMSchemaAction_SamStatusSchema(), "samSchemaActions", null, 0, -1, SAMStatusSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMStatusSchema_SamSchemaDerivators(), this.getSAMSchemaDerivator(), this.getSAMSchemaDerivator_SamStatusSchema(), "samSchemaDerivators", null, 0, -1, SAMStatusSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samOperatorEClass, SAMOperator.class, "SAMOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSAMOperator_Kind(), this.getSAMOperatorKindEnum(), "kind", null, 1, 1, SAMOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSAMOperator_SamStatusSchema(), this.getSAMStatusSchema(), this.getSAMStatusSchema_SamOperators(), "samStatusSchema", null, 1, 1, SAMOperator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMOperator_SamSchemaValues(), this.getSAMSchemaValue(), this.getSAMSchemaValue_SamOperators(), "samSchemaValues", null, 0, -1, SAMOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMOperator_SamSourceOperators(), this.getSAMOperator(), this.getSAMOperator_SamTargetOperators(), "samSourceOperators", null, 0, -1, SAMOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMOperator_SamTargetOperators(), this.getSAMOperator(), this.getSAMOperator_SamSourceOperators(), "samTargetOperators", null, 0, -1, SAMOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMOperator_SamSchemaActions(), this.getSAMSchemaAction(), this.getSAMSchemaAction_SamSchemaOperators(), "samSchemaActions", null, 0, -1, SAMOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samSchemaVariableEClass, SAMSchemaVariable.class, "SAMSchemaVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSAMSchemaVariable_HasStateGuard(), theEcorePackage.getEBoolean(), "hasStateGuard", null, 1, 1, SAMSchemaVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSAMSchemaVariable_SamStatusSchema(), this.getSAMStatusSchema(), this.getSAMStatusSchema_SamSchemaVariables(), "samStatusSchema", null, 1, 1, SAMSchemaVariable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaVariable_SamSchemaValues(), this.getSAMSchemaValue(), this.getSAMSchemaValue_SamSchemaVariable(), "samSchemaValues", null, 0, -1, SAMSchemaVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaVariable_SamSchemaValue(), this.getSAMStatusVariable(), this.getSAMStatusVariable_SamSchemaVariables(), "samSchemaValue", null, 1, 1, SAMSchemaVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaVariable_SamTargetSchemaDerivators(), this.getSAMSchemaDerivator(), this.getSAMSchemaDerivator_SamSourceSchemaVariables(), "samTargetSchemaDerivators", null, 0, -1, SAMSchemaVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaVariable_SamSourceSchemaDerivators(), this.getSAMSchemaDerivator(), this.getSAMSchemaDerivator_SamTargetSchemaVariable(), "samSourceSchemaDerivators", null, 0, -1, SAMSchemaVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samSchemaValueEClass, SAMSchemaValue.class, "SAMSchemaValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSAMSchemaValue_IsInitial(), theEcorePackage.getEBoolean(), "isInitial", null, 1, 1, SAMSchemaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getSAMSchemaValue_IsInhibiting(), theEcorePackage.getEBoolean(), "isInhibiting", null, 1, 1, SAMSchemaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSAMSchemaValue_SamSchemaVariable(), this.getSAMSchemaVariable(), this.getSAMSchemaVariable_SamSchemaValues(), "samSchemaVariable", null, 1, 1, SAMSchemaValue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaValue_SamSourceSchemaActions(), this.getSAMSchemaAction(), this.getSAMSchemaAction_SamTargetSchemaValues(), "samSourceSchemaActions", null, 0, -1, SAMSchemaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaValue_SamSourceSchemaValues(), this.getSAMSchemaValue(), this.getSAMSchemaValue_SamTargetSchemaValues(), "samSourceSchemaValues", null, 0, -1, SAMSchemaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaValue_SamTargetSchemaValues(), this.getSAMSchemaValue(), this.getSAMSchemaValue_SamSourceSchemaValues(), "samTargetSchemaValues", null, 0, -1, SAMSchemaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaValue_SamOperators(), this.getSAMOperator(), this.getSAMOperator_SamSchemaValues(), "samOperators", null, 0, -1, SAMSchemaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaValue_SamSchemaActions(), this.getSAMSchemaAction(), this.getSAMSchemaAction_SamSchemaValues(), "samSchemaActions", null, 0, -1, SAMSchemaValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samSchemaActionEClass, SAMSchemaAction.class, "SAMSchemaAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSAMSchemaAction_SamStatusSchema(), this.getSAMStatusSchema(), this.getSAMStatusSchema_SamSchemaActions(), "samStatusSchema", null, 1, 1, SAMSchemaAction.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaAction_SamAction(), this.getSAMAction(), this.getSAMAction_SamSchemaActions(), "samAction", null, 1, 1, SAMSchemaAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaAction_SamTargetSchemaValues(), this.getSAMSchemaValue(), this.getSAMSchemaValue_SamSourceSchemaActions(), "samTargetSchemaValues", null, 0, -1, SAMSchemaAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaAction_SamSchemaValues(), this.getSAMSchemaValue(), this.getSAMSchemaValue_SamSchemaActions(), "samSchemaValues", null, 0, -1, SAMSchemaAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaAction_SamSchemaOperators(), this.getSAMOperator(), this.getSAMOperator_SamSchemaActions(), "samSchemaOperators", null, 0, -1, SAMSchemaAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(samSchemaDerivatorEClass, SAMSchemaDerivator.class, "SAMSchemaDerivator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSAMSchemaDerivator_SamDerivator(), this.getSAMDerivator(), this.getSAMDerivator_SamSchemaDerivators(), "samDerivator", null, 1, 1, SAMSchemaDerivator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaDerivator_SamStatusSchema(), this.getSAMStatusSchema(), this.getSAMStatusSchema_SamSchemaDerivators(), "samStatusSchema", null, 1, 1, SAMSchemaDerivator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaDerivator_SamSourceSchemaVariables(), this.getSAMSchemaVariable(), this.getSAMSchemaVariable_SamTargetSchemaDerivators(), "samSourceSchemaVariables", null, 0, -1, SAMSchemaDerivator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSAMSchemaDerivator_SamTargetSchemaVariable(), this.getSAMSchemaVariable(), this.getSAMSchemaVariable_SamSourceSchemaDerivators(), "samTargetSchemaVariable", null, 0, -1, SAMSchemaDerivator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(samOperatorKindEnumEEnum, SAMOperatorKindEnum.class, "SAMOperatorKindEnum");
        addEEnumLiteral(samOperatorKindEnumEEnum, SAMOperatorKindEnum.OR);
        addEEnumLiteral(samOperatorKindEnumEEnum, SAMOperatorKindEnum.AND);

        initEEnum(samDerivatorKindEnumEEnum, SAMDerivatorKindEnum.class, "SAMDerivatorKindEnum");
        addEEnumLiteral(samDerivatorKindEnumEEnum, SAMDerivatorKindEnum.POPULATION);
        addEEnumLiteral(samDerivatorKindEnumEEnum, SAMDerivatorKindEnum.AGGREGATION);
        addEEnumLiteral(samDerivatorKindEnumEEnum, SAMDerivatorKindEnum.OVERALL);

        initEEnum(preconditionKindEnumEEnum, PreconditionKindEnum.class, "PreconditionKindEnum");
        addEEnumLiteral(preconditionKindEnumEEnum, PreconditionKindEnum.ENABLE);
        addEEnumLiteral(preconditionKindEnumEEnum, PreconditionKindEnum.REQUIRED);
        addEEnumLiteral(preconditionKindEnumEEnum, PreconditionKindEnum.INHIBIT);
        addEEnumLiteral(preconditionKindEnumEEnum, PreconditionKindEnum.NEUTEAL);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
    }

	/**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createEcoreAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/Ecore";		
        addAnnotation
          (this, 
           source, 
           new String[] {
             "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
             "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
             "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
           });	
    }

} //Status_and_action_oldPackageImpl
