/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.classes.impl;

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

import behavioral.status_and_action_old.Status_and_action_oldPackage;

import behavioral.status_and_action_old.impl.Status_and_action_oldPackageImpl;

import behavioral.transactions.TransactionsPackage;

import behavioral.transactions.impl.TransactionsPackageImpl;

import configuration.businessconfiguration.BusinessconfigurationPackage;

import configuration.businessconfiguration.experimental.ExperimentalPackage;

import configuration.businessconfiguration.experimental.impl.ExperimentalPackageImpl;

import configuration.businessconfiguration.impl.BusinessconfigurationPackageImpl;

import configuration.context_drivers.Context_driversPackage;

import configuration.context_drivers.impl.Context_driversPackageImpl;

import data.classes.ActualObjectParameter;
import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.AssociationEndSignatureImplementation;
import data.classes.ClassTypeDefinition;
import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.Context;
import data.classes.ConverterBetweenParametrizations;
import data.classes.Delegation;
import data.classes.ExtentModifyingAssociationEndSignatureImplementation;
import data.classes.FunctionSignature;
import data.classes.FunctionSignatureImplementation;
import data.classes.FunctionSignatureTypeDefinition;
import data.classes.InScope;
import data.classes.LinkAddition;
import data.classes.LinkManipulationAtPosition;
import data.classes.LinkRemoval;
import data.classes.LinkSetting;
import data.classes.LinkTraversal;
import data.classes.MethodSignature;
import data.classes.Multiplicity;
import data.classes.NamedValue;
import data.classes.NativeImpl;
import data.classes.NestedTypeDefinition;
import data.classes.Parameter;
import data.classes.PlatformSpecificImplementation;
import data.classes.SapClass;
import data.classes.Signature;
import data.classes.SignatureImplementation;
import data.classes.SignatureOwner;
import data.classes.TypeAdapter;
import data.classes.TypeDefinition;
import data.classes.TypedElement;

import data.classes.util.ClassesValidator;

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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
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
public class ClassesPackageImpl extends EPackageImpl implements ClassesPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass associationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass signatureEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass associationEndEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass sapClassEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass delegationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typedElementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass contextEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass multiplicityEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass signatureImplementationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass linkTraversalEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass linkAdditionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass linkRemovalEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass associationEndSignatureImplementationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass classTypeDefinitionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typeDefinitionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass nestedTypeDefinitionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass functionSignatureTypeDefinitionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass methodSignatureEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass functionSignatureEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass linkSettingEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass typeAdapterEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass parameterEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass namedValueEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass platformSpecificImplementationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass nativeImplEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass signatureOwnerEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass extentModifyingAssociationEndSignatureImplementationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass functionSignatureImplementationEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass actualObjectParameterEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass converterBetweenParametrizationsEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass linkManipulationAtPositionEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass inScopeEClass = null;

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
     * @see data.classes.ClassesPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private ClassesPackageImpl() {
        super(eNS_URI, ClassesFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link ClassesPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static ClassesPackage init() {
        if (isInited) return (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);

        // Obtain or create and register package
        ClassesPackageImpl theClassesPackage = (ClassesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ClassesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ClassesPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        EcorePackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        BpdmPackageImpl theBpdmPackage = (BpdmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BpdmPackage.eNS_URI) instanceof BpdmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BpdmPackage.eNS_URI) : BpdmPackage.eINSTANCE);
        BusinesstasksPackageImpl theBusinesstasksPackage = (BusinesstasksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BusinesstasksPackage.eNS_URI) instanceof BusinesstasksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BusinesstasksPackage.eNS_URI) : BusinesstasksPackage.eINSTANCE);
        ActionsPackageImpl theActionsPackage = (ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI) instanceof ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI) : ActionsPackage.eINSTANCE);
        RulesPackageImpl theRulesPackage = (RulesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI) instanceof RulesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RulesPackage.eNS_URI) : RulesPackage.eINSTANCE);
        EventsPackageImpl theEventsPackage = (EventsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) instanceof EventsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI) : EventsPackage.eINSTANCE);
        TransactionsPackageImpl theTransactionsPackage = (TransactionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TransactionsPackage.eNS_URI) instanceof TransactionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TransactionsPackage.eNS_URI) : TransactionsPackage.eINSTANCE);
        Status_and_action_oldPackageImpl theStatus_and_action_oldPackage = (Status_and_action_oldPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Status_and_action_oldPackage.eNS_URI) instanceof Status_and_action_oldPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Status_and_action_oldPackage.eNS_URI) : Status_and_action_oldPackage.eINSTANCE);
        DesignPackageImpl theDesignPackage = (DesignPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DesignPackage.eNS_URI) instanceof DesignPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DesignPackage.eNS_URI) : DesignPackage.eINSTANCE);
        AssemblyPackageImpl theAssemblyPackage = (AssemblyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) instanceof AssemblyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) : AssemblyPackage.eINSTANCE);
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
        ModelmanagementPackageImpl theModelmanagementPackage = (ModelmanagementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelmanagementPackage.eNS_URI) instanceof ModelmanagementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelmanagementPackage.eNS_URI) : ModelmanagementPackage.eINSTANCE);
        ProcesscomponentsPackageImpl theProcesscomponentsPackage = (ProcesscomponentsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcesscomponentsPackage.eNS_URI) instanceof ProcesscomponentsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcesscomponentsPackage.eNS_URI) : ProcesscomponentsPackage.eINSTANCE);
        DeploymentunitsPackageImpl theDeploymentunitsPackage = (DeploymentunitsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeploymentunitsPackage.eNS_URI) instanceof DeploymentunitsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeploymentunitsPackage.eNS_URI) : DeploymentunitsPackage.eINSTANCE);
        Data_bindingPackageImpl theData_bindingPackage = (Data_bindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Data_bindingPackage.eNS_URI) instanceof Data_bindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Data_bindingPackage.eNS_URI) : Data_bindingPackage.eINSTANCE);
        TemplatesPackageImpl theTemplatesPackage = (TemplatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) instanceof TemplatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) : TemplatesPackage.eINSTANCE);
        BusinessconfigurationPackageImpl theBusinessconfigurationPackage = (BusinessconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BusinessconfigurationPackage.eNS_URI) instanceof BusinessconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BusinessconfigurationPackage.eNS_URI) : BusinessconfigurationPackage.eINSTANCE);
        ExperimentalPackageImpl theExperimentalPackage = (ExperimentalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentalPackage.eNS_URI) instanceof ExperimentalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentalPackage.eNS_URI) : ExperimentalPackage.eINSTANCE);
        Context_driversPackageImpl theContext_driversPackage = (Context_driversPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Context_driversPackage.eNS_URI) instanceof Context_driversPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Context_driversPackage.eNS_URI) : Context_driversPackage.eINSTANCE);
        ProcessintegrationPackageImpl theProcessintegrationPackage = (ProcessintegrationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcessintegrationPackage.eNS_URI) instanceof ProcessintegrationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcessintegrationPackage.eNS_URI) : ProcessintegrationPackage.eINSTANCE);
        XsdPackageImpl theXsdPackage = (XsdPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XsdPackage.eNS_URI) instanceof XsdPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XsdPackage.eNS_URI) : XsdPackage.eINSTANCE);
        BindingPackageImpl theBindingPackage = (BindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
        LocalizationPackageImpl theLocalizationPackage = (LocalizationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LocalizationPackage.eNS_URI) instanceof LocalizationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LocalizationPackage.eNS_URI) : LocalizationPackage.eINSTANCE);
        Ap_runtime_constraintsPackageImpl theAp_runtime_constraintsPackage = (Ap_runtime_constraintsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ap_runtime_constraintsPackage.eNS_URI) instanceof Ap_runtime_constraintsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ap_runtime_constraintsPackage.eNS_URI) : Ap_runtime_constraintsPackage.eINSTANCE);
        AbapmappingPackageImpl theAbapmappingPackage = (AbapmappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) instanceof AbapmappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) : AbapmappingPackage.eINSTANCE);
        AbapdictionaryPackageImpl theAbapdictionaryPackage = (AbapdictionaryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) instanceof AbapdictionaryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) : AbapdictionaryPackage.eINSTANCE);
        persistence.actions.impl.ActionsPackageImpl theActionsPackage_1 = (persistence.actions.impl.ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) instanceof persistence.actions.impl.ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) : persistence.actions.ActionsPackage.eINSTANCE);
        persistence.expressions.impl.ExpressionsPackageImpl theExpressionsPackage_1 = (persistence.expressions.impl.ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) instanceof persistence.expressions.impl.ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) : persistence.expressions.ExpressionsPackage.eINSTANCE);

        // Create package meta-data objects
        theClassesPackage.createPackageContents();
        theBpdmPackage.createPackageContents();
        theBusinesstasksPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theRulesPackage.createPackageContents();
        theEventsPackage.createPackageContents();
        theTransactionsPackage.createPackageContents();
        theStatus_and_action_oldPackage.createPackageContents();
        theDesignPackage.createPackageContents();
        theAssemblyPackage.createPackageContents();
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
        theModelmanagementPackage.createPackageContents();
        theProcesscomponentsPackage.createPackageContents();
        theDeploymentunitsPackage.createPackageContents();
        theData_bindingPackage.createPackageContents();
        theTemplatesPackage.createPackageContents();
        theBusinessconfigurationPackage.createPackageContents();
        theExperimentalPackage.createPackageContents();
        theContext_driversPackage.createPackageContents();
        theProcessintegrationPackage.createPackageContents();
        theXsdPackage.createPackageContents();
        theBindingPackage.createPackageContents();
        theLocalizationPackage.createPackageContents();
        theAp_runtime_constraintsPackage.createPackageContents();
        theAbapmappingPackage.createPackageContents();
        theAbapdictionaryPackage.createPackageContents();
        theActionsPackage_1.createPackageContents();
        theExpressionsPackage_1.createPackageContents();

        // Initialize created meta-data
        theClassesPackage.initializePackageContents();
        theBpdmPackage.initializePackageContents();
        theBusinesstasksPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theRulesPackage.initializePackageContents();
        theEventsPackage.initializePackageContents();
        theTransactionsPackage.initializePackageContents();
        theStatus_and_action_oldPackage.initializePackageContents();
        theDesignPackage.initializePackageContents();
        theAssemblyPackage.initializePackageContents();
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
        theModelmanagementPackage.initializePackageContents();
        theProcesscomponentsPackage.initializePackageContents();
        theDeploymentunitsPackage.initializePackageContents();
        theData_bindingPackage.initializePackageContents();
        theTemplatesPackage.initializePackageContents();
        theBusinessconfigurationPackage.initializePackageContents();
        theExperimentalPackage.initializePackageContents();
        theContext_driversPackage.initializePackageContents();
        theProcessintegrationPackage.initializePackageContents();
        theXsdPackage.initializePackageContents();
        theBindingPackage.initializePackageContents();
        theLocalizationPackage.initializePackageContents();
        theAp_runtime_constraintsPackage.initializePackageContents();
        theAbapmappingPackage.initializePackageContents();
        theAbapdictionaryPackage.initializePackageContents();
        theActionsPackage_1.initializePackageContents();
        theExpressionsPackage_1.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put
            (theClassesPackage, 
             new EValidator.Descriptor() {
                 public EValidator getEValidator() {
                     return ClassesValidator.INSTANCE;
                 }
             });

        // Mark meta-data to indicate it can't be changed
        theClassesPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ClassesPackage.eNS_URI, theClassesPackage);
        return theClassesPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAssociation() {
        return associationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociation_Ends() {
        return (EReference)associationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociation_Package_() {
        return (EReference)associationEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociation_TimeDependency() {
        return (EReference)associationEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociation_AbapAnnotation() {
        return (EReference)associationEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSignature() {
        return signatureEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSignature_SideEffectFree() {
        return (EAttribute)signatureEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignature_Faults() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignature_Output() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignature_OwnedTypeDefinitions() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignature_Input() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignature_TypeDefinition() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignature_Preconditions() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignature_Postconditions() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignature_AbapAnnotation() {
        return (EReference)signatureEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAssociationEnd() {
        return associationEndEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAssociationEnd_Navigable() {
        return (EAttribute)associationEndEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAssociationEnd_Composite() {
        return (EAttribute)associationEndEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAssociationEnd_ContributesToEquality() {
        return (EAttribute)associationEndEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociationEnd_Association() {
        return (EReference)associationEndEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociationEnd_Delegation() {
        return (EReference)associationEndEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociationEnd_SignatureImplementations() {
        return (EReference)associationEndEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociationEnd_Type() {
        return (EReference)associationEndEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociationEnd_AbapAnnotation() {
        return (EReference)associationEndEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSapClass() {
        return sapClassEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_Subscription() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_SamActions() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_SamStatusVariables() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_SamDerivators() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_SamStatusSchema() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_BehaviouralModel() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(5);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getSapClass_ValueType() {
        return (EAttribute)sapClassEClass.getEStructuralFeatures().get(6);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_SignaturesWithFault() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(7);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_ElementsOfType() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(8);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_Package_() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(9);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_AdaptedBy() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(10);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_Adapters() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(11);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_FormalObjectParameters() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(12);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_ConverterBetweenParametrizations() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(13);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_Constraints() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(14);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_TimeDependency() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(15);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_Parameterization() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(16);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSapClass_AbapAnnotation() {
        return (EReference)sapClassEClass.getEStructuralFeatures().get(17);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDelegation() {
        return delegationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getDelegation_AllFeatures() {
        return (EAttribute)delegationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDelegation_From() {
        return (EReference)delegationEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypedElement() {
        return typedElementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypedElement_OwnedTypeDefinition() {
        return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getContext() {
        return contextEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getContext_For_() {
        return (EReference)contextEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getContext_Constraints() {
        return (EReference)contextEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getContext_Condition() {
        return (EReference)contextEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMultiplicity() {
        return multiplicityEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMultiplicity_LowerMultiplicity() {
        return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMultiplicity_UpperMultiplicity() {
        return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMultiplicity_Ordered() {
        return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getMultiplicity_Unique() {
        return (EAttribute)multiplicityEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSignatureImplementation() {
        return signatureImplementationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignatureImplementation_Implements_() {
        return (EReference)signatureImplementationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLinkTraversal() {
        return linkTraversalEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLinkAddition() {
        return linkAdditionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLinkRemoval() {
        return linkRemovalEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAssociationEndSignatureImplementation() {
        return associationEndSignatureImplementationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAssociationEndSignatureImplementation_End() {
        return (EReference)associationEndSignatureImplementationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getClassTypeDefinition() {
        return classTypeDefinitionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getClassTypeDefinition_Clazz() {
        return (EReference)classTypeDefinitionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getClassTypeDefinition_AssociationEnd() {
        return (EReference)classTypeDefinitionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getClassTypeDefinition_ObjectParameters() {
        return (EReference)classTypeDefinitionEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getClassTypeDefinition_OwnedObjectParameters() {
        return (EReference)classTypeDefinitionEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypeDefinition() {
        return typeDefinitionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeDefinition_SignaturesWithOutput() {
        return (EReference)typeDefinitionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeDefinition_OwnerTypedElement() {
        return (EReference)typeDefinitionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeDefinition_OwnerSignature() {
        return (EReference)typeDefinitionEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNestedTypeDefinition() {
        return nestedTypeDefinitionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getNestedTypeDefinition_Op() {
        return (EAttribute)nestedTypeDefinitionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNestedTypeDefinition_Type() {
        return (EReference)nestedTypeDefinitionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNestedTypeDefinition_OwnedTypeDefinition() {
        return (EReference)nestedTypeDefinitionEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFunctionSignatureTypeDefinition() {
        return functionSignatureTypeDefinitionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFunctionSignatureTypeDefinition_Signature() {
        return (EReference)functionSignatureTypeDefinitionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFunctionSignatureTypeDefinition_OwnedSignature() {
        return (EReference)functionSignatureTypeDefinitionEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getMethodSignature() {
        return methodSignatureEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMethodSignature_Producer() {
        return (EReference)methodSignatureEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMethodSignature_Implementation() {
        return (EReference)methodSignatureEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMethodSignature_Owner() {
        return (EReference)methodSignatureEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getMethodSignature_Converter() {
        return (EReference)methodSignatureEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFunctionSignature() {
        return functionSignatureEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFunctionSignature_Implementation() {
        return (EReference)functionSignatureEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFunctionSignature_Dimension() {
        return (EReference)functionSignatureEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFunctionSignature_CellSetForValueFunction() {
        return (EReference)functionSignatureEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFunctionSignature_CellSetForAggregationFunction() {
        return (EReference)functionSignatureEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLinkSetting() {
        return linkSettingEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getTypeAdapter() {
        return typeAdapterEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeAdapter_To() {
        return (EReference)typeAdapterEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getTypeAdapter_Adapted() {
        return (EReference)typeAdapterEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getParameter() {
        return parameterEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getParameter_OwnerSignature() {
        return (EReference)parameterEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
     * @generated
     */
  public EReference getParameter_ParameterOfClass()
  {
        return (EReference)parameterEClass.getEStructuralFeatures().get(1);
    }

  /**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getParameter_DefaultValue() {
        return (EReference)parameterEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNamedValue() {
        return namedValueEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNamedValue_Owner() {
        return (EReference)namedValueEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getPlatformSpecificImplementation() {
        return platformSpecificImplementationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPlatformSpecificImplementation_TargetPlatform() {
        return (EAttribute)platformSpecificImplementationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getPlatformSpecificImplementation_Implementation() {
        return (EAttribute)platformSpecificImplementationEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getNativeImpl() {
        return nativeImplEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getNativeImpl_PlatformSpecificImplementaiton() {
        return (EReference)nativeImplEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getSignatureOwner() {
        return signatureOwnerEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getSignatureOwner_OwnedSignatures() {
        return (EReference)signatureOwnerEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getExtentModifyingAssociationEndSignatureImplementation() {
        return extentModifyingAssociationEndSignatureImplementationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getFunctionSignatureImplementation() {
        return functionSignatureImplementationEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getFunctionSignatureImplementation_FunctionSignature() {
        return (EReference)functionSignatureImplementationEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getActualObjectParameter() {
        return actualObjectParameterEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getActualObjectParameter_FormalObjectParameter() {
        return (EReference)actualObjectParameterEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getActualObjectParameter_ClassTypeDefinitions() {
        return (EReference)actualObjectParameterEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getActualObjectParameter_Value() {
        return (EReference)actualObjectParameterEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getActualObjectParameter_OwningClassTypeDefinition() {
        return (EReference)actualObjectParameterEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getConverterBetweenParametrizations() {
        return converterBetweenParametrizationsEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterBetweenParametrizations_Clazz() {
        return (EReference)converterBetweenParametrizationsEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getConverterBetweenParametrizations_ConversionMethod() {
        return (EReference)converterBetweenParametrizationsEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getLinkManipulationAtPosition() {
        return linkManipulationAtPositionEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getLinkManipulationAtPosition_At() {
        return (EAttribute)linkManipulationAtPositionEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getInScope() {
        return inScopeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public ClassesFactory getClassesFactory() {
        return (ClassesFactory)getEFactoryInstance();
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
        associationEClass = createEClass(ASSOCIATION);
        createEReference(associationEClass, ASSOCIATION__ENDS);
        createEReference(associationEClass, ASSOCIATION__PACKAGE_);
        createEReference(associationEClass, ASSOCIATION__TIME_DEPENDENCY);
        createEReference(associationEClass, ASSOCIATION__ABAP_ANNOTATION);

        signatureEClass = createEClass(SIGNATURE);
        createEAttribute(signatureEClass, SIGNATURE__SIDE_EFFECT_FREE);
        createEReference(signatureEClass, SIGNATURE__FAULTS);
        createEReference(signatureEClass, SIGNATURE__OUTPUT);
        createEReference(signatureEClass, SIGNATURE__OWNED_TYPE_DEFINITIONS);
        createEReference(signatureEClass, SIGNATURE__INPUT);
        createEReference(signatureEClass, SIGNATURE__TYPE_DEFINITION);
        createEReference(signatureEClass, SIGNATURE__PRECONDITIONS);
        createEReference(signatureEClass, SIGNATURE__POSTCONDITIONS);
        createEReference(signatureEClass, SIGNATURE__ABAP_ANNOTATION);

        associationEndEClass = createEClass(ASSOCIATION_END);
        createEAttribute(associationEndEClass, ASSOCIATION_END__NAVIGABLE);
        createEAttribute(associationEndEClass, ASSOCIATION_END__COMPOSITE);
        createEAttribute(associationEndEClass, ASSOCIATION_END__CONTRIBUTES_TO_EQUALITY);
        createEReference(associationEndEClass, ASSOCIATION_END__ASSOCIATION);
        createEReference(associationEndEClass, ASSOCIATION_END__DELEGATION);
        createEReference(associationEndEClass, ASSOCIATION_END__SIGNATURE_IMPLEMENTATIONS);
        createEReference(associationEndEClass, ASSOCIATION_END__TYPE);
        createEReference(associationEndEClass, ASSOCIATION_END__ABAP_ANNOTATION);

        sapClassEClass = createEClass(SAP_CLASS);
        createEReference(sapClassEClass, SAP_CLASS__SUBSCRIPTION);
        createEReference(sapClassEClass, SAP_CLASS__SAM_ACTIONS);
        createEReference(sapClassEClass, SAP_CLASS__SAM_STATUS_VARIABLES);
        createEReference(sapClassEClass, SAP_CLASS__SAM_DERIVATORS);
        createEReference(sapClassEClass, SAP_CLASS__SAM_STATUS_SCHEMA);
        createEReference(sapClassEClass, SAP_CLASS__BEHAVIOURAL_MODEL);
        createEAttribute(sapClassEClass, SAP_CLASS__VALUE_TYPE);
        createEReference(sapClassEClass, SAP_CLASS__SIGNATURES_WITH_FAULT);
        createEReference(sapClassEClass, SAP_CLASS__ELEMENTS_OF_TYPE);
        createEReference(sapClassEClass, SAP_CLASS__PACKAGE_);
        createEReference(sapClassEClass, SAP_CLASS__ADAPTED_BY);
        createEReference(sapClassEClass, SAP_CLASS__ADAPTERS);
        createEReference(sapClassEClass, SAP_CLASS__FORMAL_OBJECT_PARAMETERS);
        createEReference(sapClassEClass, SAP_CLASS__CONVERTER_BETWEEN_PARAMETRIZATIONS);
        createEReference(sapClassEClass, SAP_CLASS__CONSTRAINTS);
        createEReference(sapClassEClass, SAP_CLASS__TIME_DEPENDENCY);
        createEReference(sapClassEClass, SAP_CLASS__PARAMETERIZATION);
        createEReference(sapClassEClass, SAP_CLASS__ABAP_ANNOTATION);

        delegationEClass = createEClass(DELEGATION);
        createEAttribute(delegationEClass, DELEGATION__ALL_FEATURES);
        createEReference(delegationEClass, DELEGATION__FROM);

        typedElementEClass = createEClass(TYPED_ELEMENT);
        createEReference(typedElementEClass, TYPED_ELEMENT__OWNED_TYPE_DEFINITION);

        contextEClass = createEClass(CONTEXT);
        createEReference(contextEClass, CONTEXT__FOR_);
        createEReference(contextEClass, CONTEXT__CONSTRAINTS);
        createEReference(contextEClass, CONTEXT__CONDITION);

        multiplicityEClass = createEClass(MULTIPLICITY);
        createEAttribute(multiplicityEClass, MULTIPLICITY__LOWER_MULTIPLICITY);
        createEAttribute(multiplicityEClass, MULTIPLICITY__UPPER_MULTIPLICITY);
        createEAttribute(multiplicityEClass, MULTIPLICITY__ORDERED);
        createEAttribute(multiplicityEClass, MULTIPLICITY__UNIQUE);

        signatureImplementationEClass = createEClass(SIGNATURE_IMPLEMENTATION);
        createEReference(signatureImplementationEClass, SIGNATURE_IMPLEMENTATION__IMPLEMENTS_);

        linkTraversalEClass = createEClass(LINK_TRAVERSAL);

        linkAdditionEClass = createEClass(LINK_ADDITION);

        linkRemovalEClass = createEClass(LINK_REMOVAL);

        associationEndSignatureImplementationEClass = createEClass(ASSOCIATION_END_SIGNATURE_IMPLEMENTATION);
        createEReference(associationEndSignatureImplementationEClass, ASSOCIATION_END_SIGNATURE_IMPLEMENTATION__END);

        classTypeDefinitionEClass = createEClass(CLASS_TYPE_DEFINITION);
        createEReference(classTypeDefinitionEClass, CLASS_TYPE_DEFINITION__CLAZZ);
        createEReference(classTypeDefinitionEClass, CLASS_TYPE_DEFINITION__ASSOCIATION_END);
        createEReference(classTypeDefinitionEClass, CLASS_TYPE_DEFINITION__OBJECT_PARAMETERS);
        createEReference(classTypeDefinitionEClass, CLASS_TYPE_DEFINITION__OWNED_OBJECT_PARAMETERS);

        typeDefinitionEClass = createEClass(TYPE_DEFINITION);
        createEReference(typeDefinitionEClass, TYPE_DEFINITION__SIGNATURES_WITH_OUTPUT);
        createEReference(typeDefinitionEClass, TYPE_DEFINITION__OWNER_TYPED_ELEMENT);
        createEReference(typeDefinitionEClass, TYPE_DEFINITION__OWNER_SIGNATURE);

        nestedTypeDefinitionEClass = createEClass(NESTED_TYPE_DEFINITION);
        createEAttribute(nestedTypeDefinitionEClass, NESTED_TYPE_DEFINITION__OP);
        createEReference(nestedTypeDefinitionEClass, NESTED_TYPE_DEFINITION__TYPE);
        createEReference(nestedTypeDefinitionEClass, NESTED_TYPE_DEFINITION__OWNED_TYPE_DEFINITION);

        functionSignatureTypeDefinitionEClass = createEClass(FUNCTION_SIGNATURE_TYPE_DEFINITION);
        createEReference(functionSignatureTypeDefinitionEClass, FUNCTION_SIGNATURE_TYPE_DEFINITION__SIGNATURE);
        createEReference(functionSignatureTypeDefinitionEClass, FUNCTION_SIGNATURE_TYPE_DEFINITION__OWNED_SIGNATURE);

        methodSignatureEClass = createEClass(METHOD_SIGNATURE);
        createEReference(methodSignatureEClass, METHOD_SIGNATURE__PRODUCER);
        createEReference(methodSignatureEClass, METHOD_SIGNATURE__IMPLEMENTATION);
        createEReference(methodSignatureEClass, METHOD_SIGNATURE__OWNER);
        createEReference(methodSignatureEClass, METHOD_SIGNATURE__CONVERTER);

        functionSignatureEClass = createEClass(FUNCTION_SIGNATURE);
        createEReference(functionSignatureEClass, FUNCTION_SIGNATURE__IMPLEMENTATION);
        createEReference(functionSignatureEClass, FUNCTION_SIGNATURE__DIMENSION);
        createEReference(functionSignatureEClass, FUNCTION_SIGNATURE__CELL_SET_FOR_VALUE_FUNCTION);
        createEReference(functionSignatureEClass, FUNCTION_SIGNATURE__CELL_SET_FOR_AGGREGATION_FUNCTION);

        linkSettingEClass = createEClass(LINK_SETTING);

        typeAdapterEClass = createEClass(TYPE_ADAPTER);
        createEReference(typeAdapterEClass, TYPE_ADAPTER__TO);
        createEReference(typeAdapterEClass, TYPE_ADAPTER__ADAPTED);

        parameterEClass = createEClass(PARAMETER);
        createEReference(parameterEClass, PARAMETER__OWNER_SIGNATURE);
        createEReference(parameterEClass, PARAMETER__PARAMETER_OF_CLASS);
        createEReference(parameterEClass, PARAMETER__DEFAULT_VALUE);

        namedValueEClass = createEClass(NAMED_VALUE);
        createEReference(namedValueEClass, NAMED_VALUE__OWNER);

        platformSpecificImplementationEClass = createEClass(PLATFORM_SPECIFIC_IMPLEMENTATION);
        createEAttribute(platformSpecificImplementationEClass, PLATFORM_SPECIFIC_IMPLEMENTATION__TARGET_PLATFORM);
        createEAttribute(platformSpecificImplementationEClass, PLATFORM_SPECIFIC_IMPLEMENTATION__IMPLEMENTATION);

        nativeImplEClass = createEClass(NATIVE_IMPL);
        createEReference(nativeImplEClass, NATIVE_IMPL__PLATFORM_SPECIFIC_IMPLEMENTAITON);

        signatureOwnerEClass = createEClass(SIGNATURE_OWNER);
        createEReference(signatureOwnerEClass, SIGNATURE_OWNER__OWNED_SIGNATURES);

        extentModifyingAssociationEndSignatureImplementationEClass = createEClass(EXTENT_MODIFYING_ASSOCIATION_END_SIGNATURE_IMPLEMENTATION);

        functionSignatureImplementationEClass = createEClass(FUNCTION_SIGNATURE_IMPLEMENTATION);
        createEReference(functionSignatureImplementationEClass, FUNCTION_SIGNATURE_IMPLEMENTATION__FUNCTION_SIGNATURE);

        actualObjectParameterEClass = createEClass(ACTUAL_OBJECT_PARAMETER);
        createEReference(actualObjectParameterEClass, ACTUAL_OBJECT_PARAMETER__FORMAL_OBJECT_PARAMETER);
        createEReference(actualObjectParameterEClass, ACTUAL_OBJECT_PARAMETER__CLASS_TYPE_DEFINITIONS);
        createEReference(actualObjectParameterEClass, ACTUAL_OBJECT_PARAMETER__VALUE);
        createEReference(actualObjectParameterEClass, ACTUAL_OBJECT_PARAMETER__OWNING_CLASS_TYPE_DEFINITION);

        converterBetweenParametrizationsEClass = createEClass(CONVERTER_BETWEEN_PARAMETRIZATIONS);
        createEReference(converterBetweenParametrizationsEClass, CONVERTER_BETWEEN_PARAMETRIZATIONS__CLAZZ);
        createEReference(converterBetweenParametrizationsEClass, CONVERTER_BETWEEN_PARAMETRIZATIONS__CONVERSION_METHOD);

        linkManipulationAtPositionEClass = createEClass(LINK_MANIPULATION_AT_POSITION);
        createEAttribute(linkManipulationAtPositionEClass, LINK_MANIPULATION_AT_POSITION__AT);

        inScopeEClass = createEClass(IN_SCOPE);
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
        ModelmanagementPackage theModelmanagementPackage = (ModelmanagementPackage)EPackage.Registry.INSTANCE.getEPackage(ModelmanagementPackage.eNS_URI);
        TimedependencyPackage theTimedependencyPackage = (TimedependencyPackage)EPackage.Registry.INSTANCE.getEPackage(TimedependencyPackage.eNS_URI);
        AbapmappingPackage theAbapmappingPackage = (AbapmappingPackage)EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
        ConstraintsPackage theConstraintsPackage = (ConstraintsPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI);
        EventsPackage theEventsPackage = (EventsPackage)EPackage.Registry.INSTANCE.getEPackage(EventsPackage.eNS_URI);
        Status_and_action_oldPackage theStatus_and_action_oldPackage = (Status_and_action_oldPackage)EPackage.Registry.INSTANCE.getEPackage(Status_and_action_oldPackage.eNS_URI);
        AssemblyPackage theAssemblyPackage = (AssemblyPackage)EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI);
        GenericsPackage theGenericsPackage = (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);
        ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
        AnalyticsPackage theAnalyticsPackage = (AnalyticsPackage)EPackage.Registry.INSTANCE.getEPackage(AnalyticsPackage.eNS_URI);
        FpPackage theFpPackage = (FpPackage)EPackage.Registry.INSTANCE.getEPackage(FpPackage.eNS_URI);
        ActionsPackage theActionsPackage = (ActionsPackage)EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        associationEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
        associationEndEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
        sapClassEClass.getESuperTypes().add(this.getSignatureOwner());
        sapClassEClass.getESuperTypes().add(theEventsPackage.getEventProducer());
        contextEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
        linkTraversalEClass.getESuperTypes().add(this.getAssociationEndSignatureImplementation());
        linkAdditionEClass.getESuperTypes().add(this.getLinkManipulationAtPosition());
        linkRemovalEClass.getESuperTypes().add(this.getLinkManipulationAtPosition());
        associationEndSignatureImplementationEClass.getESuperTypes().add(this.getSignatureImplementation());
        classTypeDefinitionEClass.getESuperTypes().add(this.getTypeDefinition());
        typeDefinitionEClass.getESuperTypes().add(this.getMultiplicity());
        nestedTypeDefinitionEClass.getESuperTypes().add(this.getTypeDefinition());
        functionSignatureTypeDefinitionEClass.getESuperTypes().add(this.getTypeDefinition());
        methodSignatureEClass.getESuperTypes().add(this.getSignature());
        methodSignatureEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
        functionSignatureEClass.getESuperTypes().add(this.getSignature());
        linkSettingEClass.getESuperTypes().add(this.getExtentModifyingAssociationEndSignatureImplementation());
        typeAdapterEClass.getESuperTypes().add(this.getSignatureOwner());
        parameterEClass.getESuperTypes().add(this.getNamedValue());
        namedValueEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
        namedValueEClass.getESuperTypes().add(this.getTypedElement());
        nativeImplEClass.getESuperTypes().add(this.getSignatureImplementation());
        signatureOwnerEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
        extentModifyingAssociationEndSignatureImplementationEClass.getESuperTypes().add(this.getAssociationEndSignatureImplementation());
        functionSignatureImplementationEClass.getESuperTypes().add(this.getSignatureImplementation());
        linkManipulationAtPositionEClass.getESuperTypes().add(this.getExtentModifyingAssociationEndSignatureImplementation());

        // Initialize classes and features; add operations and parameters
        initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAssociation_Ends(), this.getAssociationEnd(), this.getAssociationEnd_Association(), "ends", null, 2, 2, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAssociation_Package_(), theModelmanagementPackage.getPackage(), theModelmanagementPackage.getPackage_Associations(), "package_", null, 1, 1, Association.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAssociation_TimeDependency(), theTimedependencyPackage.getTimeDependency(), theTimedependencyPackage.getTimeDependency_Association(), "timeDependency", null, 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAssociation_AbapAnnotation(), theAbapmappingPackage.getAbapAssociationImplementationAnnotation(), null, "abapAnnotation", null, 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(signatureEClass, Signature.class, "Signature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getSignature_SideEffectFree(), theEcorePackage.getEBoolean(), "sideEffectFree", null, 1, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSignature_Faults(), this.getSapClass(), this.getSapClass_SignaturesWithFault(), "faults", null, 0, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSignature_Output(), this.getTypeDefinition(), this.getTypeDefinition_SignaturesWithOutput(), "output", null, 0, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSignature_OwnedTypeDefinitions(), this.getTypeDefinition(), this.getTypeDefinition_OwnerSignature(), "ownedTypeDefinitions", null, 0, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSignature_Input(), this.getParameter(), this.getParameter_OwnerSignature(), "input", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSignature_TypeDefinition(), this.getFunctionSignatureTypeDefinition(), this.getFunctionSignatureTypeDefinition_Signature(), "typeDefinition", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSignature_Preconditions(), theConstraintsPackage.getConstraint(), null, "preconditions", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSignature_Postconditions(), theConstraintsPackage.getConstraint(), null, "postconditions", null, 0, -1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSignature_AbapAnnotation(), theAbapmappingPackage.getAbapSignatureImplementationAnnotation(), null, "abapAnnotation", null, 0, 1, Signature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = addEOperation(signatureEClass, theEcorePackage.getEBoolean(), "conformsTo", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSignature(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(signatureEClass, theEcorePackage.getEBoolean(), "conformsToExcluding", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSignature(), "s", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingConforming", 0, -1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingTo", 0, -1, !IS_UNIQUE, IS_ORDERED);

        addEOperation(signatureEClass, this.getNamedValue(), "getNamedValuesInScope", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(signatureEClass, this.getSapClass(), "getOwningClass", 0, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(associationEndEClass, AssociationEnd.class, "AssociationEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAssociationEnd_Navigable(), theEcorePackage.getEBoolean(), "navigable", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getAssociationEnd_Composite(), theEcorePackage.getEBoolean(), "composite", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getAssociationEnd_ContributesToEquality(), theEcorePackage.getEBoolean(), "contributesToEquality", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAssociationEnd_Association(), this.getAssociation(), this.getAssociation_Ends(), "association", null, 1, 1, AssociationEnd.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAssociationEnd_Delegation(), this.getDelegation(), this.getDelegation_From(), "delegation", null, 0, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAssociationEnd_SignatureImplementations(), this.getAssociationEndSignatureImplementation(), this.getAssociationEndSignatureImplementation_End(), "signatureImplementations", null, 0, -1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAssociationEnd_Type(), this.getClassTypeDefinition(), this.getClassTypeDefinition_AssociationEnd(), "type", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getAssociationEnd_AbapAnnotation(), theAbapmappingPackage.getAbapAssociationEndImplementationAnnotation(), null, "abapAnnotation", null, 0, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(associationEndEClass, this.getAssociationEnd(), "otherEnd", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(sapClassEClass, SapClass.class, "SapClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSapClass_Subscription(), theEventsPackage.getSubscription(), theEventsPackage.getSubscription_SubscribingClass(), "subscription", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_SamActions(), theStatus_and_action_oldPackage.getSAMAction(), theStatus_and_action_oldPackage.getSAMAction_BusinessObjectNode(), "samActions", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_SamStatusVariables(), theStatus_and_action_oldPackage.getSAMStatusVariable(), theStatus_and_action_oldPackage.getSAMStatusVariable_BusinessObjectNode(), "samStatusVariables", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_SamDerivators(), theStatus_and_action_oldPackage.getSAMDerivator(), theStatus_and_action_oldPackage.getSAMDerivator_BusinessObject(), "samDerivators", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_SamStatusSchema(), theStatus_and_action_oldPackage.getSAMStatusSchema(), theStatus_and_action_oldPackage.getSAMStatusSchema_BusinessObjectNode(), "samStatusSchema", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_BehaviouralModel(), theAssemblyPackage.getStatusSchema(), theAssemblyPackage.getStatusSchema_Node(), "behaviouralModel", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getSapClass_ValueType(), theEcorePackage.getEBoolean(), "valueType", null, 1, 1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSapClass_SignaturesWithFault(), this.getSignature(), this.getSignature_Faults(), "signaturesWithFault", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_ElementsOfType(), this.getClassTypeDefinition(), this.getClassTypeDefinition_Clazz(), "elementsOfType", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_Package_(), theModelmanagementPackage.getPackage(), theModelmanagementPackage.getPackage_Classes(), "package_", null, 0, 1, SapClass.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_AdaptedBy(), this.getTypeAdapter(), this.getTypeAdapter_To(), "adaptedBy", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_Adapters(), this.getTypeAdapter(), this.getTypeAdapter_Adapted(), "adapters", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_FormalObjectParameters(), this.getParameter(), this.getParameter_ParameterOfClass(), "formalObjectParameters", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_ConverterBetweenParametrizations(), this.getConverterBetweenParametrizations(), this.getConverterBetweenParametrizations_Clazz(), "converterBetweenParametrizations", null, 0, 1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_Constraints(), theConstraintsPackage.getConstraint(), theConstraintsPackage.getConstraint_ConstrainedType(), "constraints", null, 0, -1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_TimeDependency(), theTimedependencyPackage.getTimeDependency(), theTimedependencyPackage.getTimeDependency_TheClass(), "timeDependency", null, 0, 1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_Parameterization(), theGenericsPackage.getClassParameterization(), theGenericsPackage.getClassParameterization_OwningClassDefinition(), "parameterization", null, 0, 1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getSapClass_AbapAnnotation(), theAbapmappingPackage.getAbapClassImplementationAnnotation(), null, "abapAnnotation", null, 0, 1, SapClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(sapClassEClass, theEcorePackage.getEBoolean(), "isAbstract", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, theEcorePackage.getEBoolean(), "isParameterizedClassDefinition", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(sapClassEClass, theEcorePackage.getEBoolean(), "conformsTo", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "type", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getMethodSignature(), "allSignatures", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getSapClass(), "delegatesTo", 0, -1, IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(sapClassEClass, theEcorePackage.getEBoolean(), "conformsToExcluding", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "type", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingConforming", 0, -1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingTo", 0, -1, !IS_UNIQUE, IS_ORDERED);

        addEOperation(sapClassEClass, this.getMethodSignature(), "signaturesWithDelegation", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getMethodSignature(), "delegatedSignatures", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getMethodSignature(), "adaptedSignatures", 0, -1, IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(sapClassEClass, this.getMethodSignature(), "adaptedSignaturesExcluding", 0, -1, IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excluding", 0, -1, IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(sapClassEClass, this.getMethodSignature(), "allSignaturesExcluding", 0, -1, IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excluding", 0, -1, IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(sapClassEClass, this.getMethodSignature(), "signaturesWithDelegationExcluding", 0, -1, IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excluding", 0, -1, IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(sapClassEClass, this.getMethodSignature(), "delegatedSignaturesExcluding", 0, -1, IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excluding", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getSapClass(), "getConformingClasses", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getAssociationEnd(), "getAssociationEnds", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getAssociationEnd(), "getEqualityRelevantAssociationEnds", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getSapClass(), "getConformsToClasses", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getAssociationEnd(), "getConformsToAssociationEnds", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getAssociationEnd(), "getConformsToCompositeParentAssociationEnds", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(sapClassEClass, this.getAssociationEnd(), "getConformsToCompositeChildAssociationEnds", 0, -1, IS_UNIQUE, !IS_ORDERED);

        initEClass(delegationEClass, Delegation.class, "Delegation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDelegation_AllFeatures(), theEcorePackage.getEBoolean(), "allFeatures", null, 1, 1, Delegation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getDelegation_From(), this.getAssociationEnd(), this.getAssociationEnd_Delegation(), "from", null, 1, 1, Delegation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTypedElement_OwnedTypeDefinition(), this.getTypeDefinition(), this.getTypeDefinition_OwnerTypedElement(), "ownedTypeDefinition", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = addEOperation(typedElementEClass, theEcorePackage.getEBoolean(), "conformsTo", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getTypedElement(), "typedElement", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        addEOperation(typedElementEClass, this.getTypeDefinition(), "getType", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getContext_For_(), this.getSapClass(), null, "for_", null, 1, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContext_Constraints(), theConstraintsPackage.getConstraint(), theConstraintsPackage.getConstraint_TheContext(), "constraints", null, 0, -1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getContext_Condition(), theExpressionsPackage.getExpression(), null, "condition", null, 1, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(multiplicityEClass, Multiplicity.class, "Multiplicity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getMultiplicity_LowerMultiplicity(), theEcorePackage.getEInt(), "lowerMultiplicity", null, 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getMultiplicity_UpperMultiplicity(), theEcorePackage.getEInt(), "upperMultiplicity", null, 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getMultiplicity_Ordered(), theEcorePackage.getEBoolean(), "ordered", null, 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getMultiplicity_Unique(), theEcorePackage.getEBoolean(), "unique", null, 1, 1, Multiplicity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        addEOperation(multiplicityEClass, theEcorePackage.getEBoolean(), "isMany", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(signatureImplementationEClass, SignatureImplementation.class, "SignatureImplementation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSignatureImplementation_Implements_(), this.getMethodSignature(), this.getMethodSignature_Implementation(), "implements_", null, 0, 1, SignatureImplementation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(signatureImplementationEClass, this.getSignature(), "getImplementedSignature", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(linkTraversalEClass, LinkTraversal.class, "LinkTraversal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(linkAdditionEClass, LinkAddition.class, "LinkAddition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(linkRemovalEClass, LinkRemoval.class, "LinkRemoval", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(associationEndSignatureImplementationEClass, AssociationEndSignatureImplementation.class, "AssociationEndSignatureImplementation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAssociationEndSignatureImplementation_End(), this.getAssociationEnd(), this.getAssociationEnd_SignatureImplementations(), "end", null, 1, 1, AssociationEndSignatureImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(classTypeDefinitionEClass, ClassTypeDefinition.class, "ClassTypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getClassTypeDefinition_Clazz(), this.getSapClass(), this.getSapClass_ElementsOfType(), "clazz", null, 1, 1, ClassTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getClassTypeDefinition_AssociationEnd(), this.getAssociationEnd(), this.getAssociationEnd_Type(), "associationEnd", null, 0, 1, ClassTypeDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getClassTypeDefinition_ObjectParameters(), this.getActualObjectParameter(), this.getActualObjectParameter_ClassTypeDefinitions(), "objectParameters", null, 0, -1, ClassTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getClassTypeDefinition_OwnedObjectParameters(), this.getActualObjectParameter(), this.getActualObjectParameter_OwningClassTypeDefinition(), "ownedObjectParameters", null, 0, -1, ClassTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = addEOperation(classTypeDefinitionEClass, theEcorePackage.getEBoolean(), "objectParametersConformTo", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getClassTypeDefinition(), "ctd", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        addEOperation(classTypeDefinitionEClass, theExpressionsPackage.getExpression(), "effectiveObjectParameters", 0, -1, !IS_UNIQUE, IS_ORDERED);

        initEClass(typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTypeDefinition_SignaturesWithOutput(), this.getSignature(), this.getSignature_Output(), "signaturesWithOutput", null, 0, -1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTypeDefinition_OwnerTypedElement(), this.getTypedElement(), this.getTypedElement_OwnedTypeDefinition(), "ownerTypedElement", null, 0, 1, TypeDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTypeDefinition_OwnerSignature(), this.getSignature(), this.getSignature_OwnedTypeDefinitions(), "ownerSignature", null, 0, 1, TypeDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = addEOperation(typeDefinitionEClass, theEcorePackage.getEBoolean(), "conformsTo", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getTypeDefinition(), "typeDef", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(typeDefinitionEClass, theEcorePackage.getEBoolean(), "conformsToExcluding", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getTypeDefinition(), "td", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingConforming", 0, -1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingTo", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = addEOperation(typeDefinitionEClass, theEcorePackage.getEBoolean(), "multiplicityConformsTo", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getTypeDefinition(), "td", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(typeDefinitionEClass, theEcorePackage.getEBoolean(), "conformsToIgnoringMultiplicityExcluding", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getTypeDefinition(), "td", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingConforming", 0, -1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingTo", 0, -1, !IS_UNIQUE, IS_ORDERED);

        op = addEOperation(typeDefinitionEClass, theEcorePackage.getEBoolean(), "conformsToIgnoringMultiplicity", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getTypeDefinition(), "typeDef", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        addEOperation(typeDefinitionEClass, this.getTypedElement(), "getTypeUsage", 0, -1, IS_UNIQUE, !IS_ORDERED);

        addEOperation(typeDefinitionEClass, this.getTypeDefinition(), "getInnermost", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        addEOperation(typeDefinitionEClass, theEcorePackage.getEInt(), "getNestingLevel", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        addEOperation(typeDefinitionEClass, this.getNamedValue(), "getNamedValuesInScope", 0, -1, IS_UNIQUE, !IS_ORDERED);

        initEClass(nestedTypeDefinitionEClass, NestedTypeDefinition.class, "NestedTypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getNestedTypeDefinition_Op(), theEcorePackage.getEString(), "op", null, 0, 1, NestedTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getNestedTypeDefinition_Type(), this.getTypeDefinition(), null, "type", null, 1, 1, NestedTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNestedTypeDefinition_OwnedTypeDefinition(), this.getTypeDefinition(), null, "ownedTypeDefinition", null, 0, 1, NestedTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(functionSignatureTypeDefinitionEClass, FunctionSignatureTypeDefinition.class, "FunctionSignatureTypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionSignatureTypeDefinition_Signature(), this.getSignature(), this.getSignature_TypeDefinition(), "signature", null, 1, 1, FunctionSignatureTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionSignatureTypeDefinition_OwnedSignature(), this.getSignature(), null, "ownedSignature", null, 0, 1, FunctionSignatureTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(methodSignatureEClass, MethodSignature.class, "MethodSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getMethodSignature_Producer(), theEventsPackage.getEventProducer(), theEventsPackage.getEventProducer_NotificationSignatures(), "producer", null, 0, 1, MethodSignature.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMethodSignature_Implementation(), this.getSignatureImplementation(), this.getSignatureImplementation_Implements_(), "implementation", null, 0, 1, MethodSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMethodSignature_Owner(), this.getSignatureOwner(), this.getSignatureOwner_OwnedSignatures(), "owner", null, 0, 1, MethodSignature.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getMethodSignature_Converter(), this.getConverterBetweenParametrizations(), this.getConverterBetweenParametrizations_ConversionMethod(), "converter", null, 0, 1, MethodSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(methodSignatureEClass, theEcorePackage.getEBoolean(), "isAbstract", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(functionSignatureEClass, FunctionSignature.class, "FunctionSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionSignature_Implementation(), this.getFunctionSignatureImplementation(), this.getFunctionSignatureImplementation_FunctionSignature(), "implementation", null, 0, 1, FunctionSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionSignature_Dimension(), theAnalyticsPackage.getDimension(), theAnalyticsPackage.getDimension_CharacteristicFunction(), "dimension", null, 0, 1, FunctionSignature.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionSignature_CellSetForValueFunction(), theAnalyticsPackage.getCellSet(), theAnalyticsPackage.getCellSet_ValueFunction(), "cellSetForValueFunction", null, 0, 1, FunctionSignature.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getFunctionSignature_CellSetForAggregationFunction(), theAnalyticsPackage.getCellSet(), theAnalyticsPackage.getCellSet_AggregationFunction(), "cellSetForAggregationFunction", null, 0, 1, FunctionSignature.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(functionSignatureEClass, theEcorePackage.getEBoolean(), "isAbstract", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        addEOperation(functionSignatureEClass, theFpPackage.getAnonymousFunctionExpr(), "getImplementedAnonymousFunctionExpression", 0, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(linkSettingEClass, LinkSetting.class, "LinkSetting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(typeAdapterEClass, TypeAdapter.class, "TypeAdapter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getTypeAdapter_To(), this.getSapClass(), this.getSapClass_AdaptedBy(), "to", null, 1, 1, TypeAdapter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getTypeAdapter_Adapted(), this.getSapClass(), this.getSapClass_Adapters(), "adapted", null, 1, 1, TypeAdapter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = addEOperation(typeAdapterEClass, theEcorePackage.getEBoolean(), "conformsTo", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "type", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(typeAdapterEClass, theEcorePackage.getEBoolean(), "conformsToExcluding", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "type", 1, 1, !IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingConforming", 0, -1, !IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excludingTo", 0, -1, !IS_UNIQUE, IS_ORDERED);

        addEOperation(typeAdapterEClass, this.getMethodSignature(), "allSignatures", 0, -1, IS_UNIQUE, !IS_ORDERED);

        op = addEOperation(typeAdapterEClass, this.getMethodSignature(), "allSignaturesExcluding", 0, -1, IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getSapClass(), "excluding", 0, -1, IS_UNIQUE, !IS_ORDERED);

        initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getParameter_OwnerSignature(), this.getSignature(), this.getSignature_Input(), "ownerSignature", null, 0, 1, Parameter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getParameter_ParameterOfClass(), this.getSapClass(), this.getSapClass_FormalObjectParameters(), "parameterOfClass", null, 0, 1, Parameter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getParameter_DefaultValue(), theExpressionsPackage.getExpression(), null, "defaultValue", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(namedValueEClass, NamedValue.class, "NamedValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNamedValue_Owner(), theActionsPackage.getBlock(), theActionsPackage.getBlock_Variables(), "owner", null, 0, 1, NamedValue.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(namedValueEClass, this.getNamedValue(), "getNamedValuesInScope", 0, -1, IS_UNIQUE, !IS_ORDERED);

        initEClass(platformSpecificImplementationEClass, PlatformSpecificImplementation.class, "PlatformSpecificImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getPlatformSpecificImplementation_TargetPlatform(), theEcorePackage.getEString(), "targetPlatform", null, 1, 1, PlatformSpecificImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPlatformSpecificImplementation_Implementation(), theEcorePackage.getEString(), "implementation", null, 1, 1, PlatformSpecificImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(nativeImplEClass, NativeImpl.class, "NativeImpl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNativeImpl_PlatformSpecificImplementaiton(), this.getPlatformSpecificImplementation(), null, "platformSpecificImplementaiton", null, 0, -1, NativeImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(signatureOwnerEClass, SignatureOwner.class, "SignatureOwner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSignatureOwner_OwnedSignatures(), this.getMethodSignature(), this.getMethodSignature_Owner(), "ownedSignatures", null, 0, -1, SignatureOwner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(extentModifyingAssociationEndSignatureImplementationEClass, ExtentModifyingAssociationEndSignatureImplementation.class, "ExtentModifyingAssociationEndSignatureImplementation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(functionSignatureImplementationEClass, FunctionSignatureImplementation.class, "FunctionSignatureImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getFunctionSignatureImplementation_FunctionSignature(), this.getFunctionSignature(), this.getFunctionSignature_Implementation(), "functionSignature", null, 0, 1, FunctionSignatureImplementation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        addEOperation(functionSignatureImplementationEClass, theEcorePackage.getEBoolean(), "isSideEffectFree", 1, 1, !IS_UNIQUE, !IS_ORDERED);

        initEClass(actualObjectParameterEClass, ActualObjectParameter.class, "ActualObjectParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getActualObjectParameter_FormalObjectParameter(), this.getParameter(), null, "formalObjectParameter", null, 1, 1, ActualObjectParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getActualObjectParameter_ClassTypeDefinitions(), this.getClassTypeDefinition(), this.getClassTypeDefinition_ObjectParameters(), "classTypeDefinitions", null, 0, -1, ActualObjectParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getActualObjectParameter_Value(), theExpressionsPackage.getExpression(), theExpressionsPackage.getExpression_ActualObjectParameter(), "value", null, 1, 1, ActualObjectParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getActualObjectParameter_OwningClassTypeDefinition(), this.getClassTypeDefinition(), this.getClassTypeDefinition_OwnedObjectParameters(), "owningClassTypeDefinition", null, 1, 1, ActualObjectParameter.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(converterBetweenParametrizationsEClass, ConverterBetweenParametrizations.class, "ConverterBetweenParametrizations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getConverterBetweenParametrizations_Clazz(), this.getSapClass(), this.getSapClass_ConverterBetweenParametrizations(), "clazz", null, 1, 1, ConverterBetweenParametrizations.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getConverterBetweenParametrizations_ConversionMethod(), this.getMethodSignature(), this.getMethodSignature_Converter(), "conversionMethod", null, 1, 1, ConverterBetweenParametrizations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(linkManipulationAtPositionEClass, LinkManipulationAtPosition.class, "LinkManipulationAtPosition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getLinkManipulationAtPosition_At(), theEcorePackage.getEInt(), "at", null, 0, 1, LinkManipulationAtPosition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(inScopeEClass, InScope.class, "InScope", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = addEOperation(inScopeEClass, this.getNamedValue(), "addNamedValuesWithNewNames", 0, -1, IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getNamedValue(), "inner", 0, -1, IS_UNIQUE, !IS_ORDERED);
        addEParameter(op, this.getNamedValue(), "outer", 0, -1, IS_UNIQUE, !IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
        // http://de.hpi.sam.bp2009.OCL
        createDeAnnotations();
        // http://schema.omg.org/spec/MOF/2.0/emof.xml
        createEmofAnnotations();
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
             "invocationDelegates", "http://de.hpi.sam.bp2009.OCL",
             "validationDelegates", "http://de.hpi.sam.bp2009.OCL"
           });				
        addAnnotation
          (associationEClass, 
           source, 
           new String[] {
             "constraints", "UniquenessOnBothEndsMustBeTheSame AtMostOneCompositeEnd AtLeastOneNavigableEnd AtMostOneEqualityContributionForTwoValueClasses AtMostOneOrderedEnd"
           });				
        addAnnotation
          (signatureEClass, 
           source, 
           new String[] {
             "constraints", "OnlyTrailingOptionalParameters"
           });			
        addAnnotation
          (signatureEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (signatureEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (signatureEClass.getEOperations().get(2), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (signatureEClass.getEOperations().get(3), 
           source, 
           new String[] {
             "constraints", "body"
           });						
        addAnnotation
          (associationEndEClass, 
           source, 
           new String[] {
             "constraints", "ExposingClassesEqualOppositeEndsType NoCompositionWithValueClass EqualityContributionsMustBeExposedAndNavigable EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds"
           });			
        addAnnotation
          (associationEndEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });						
        addAnnotation
          (sapClassEClass, 
           source, 
           new String[] {
             "constraints", "OnlyValueClassesCanHaveObjectParameters OnlyObjectParameterizedClassesCanHaveConverter OnlyTrailingOptionalParameters NoRecursionForObjectParameters"
           });			
        addAnnotation
          (sapClassEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (sapClassEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (sapClassEClass.getEOperations().get(2), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(3), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(4), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(5), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(6), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(7), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(8), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(9), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(10), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(11), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(12), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(13), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (sapClassEClass.getEOperations().get(14), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(15), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(16), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(17), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(18), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(19), 
           source, 
           new String[] {
             "constraints", "body"
           });						
        addAnnotation
          (delegationEClass, 
           source, 
           new String[] {
             "constraints", "ToEndMustHaveMultiplicityOfOne"
           });			
        addAnnotation
          (typedElementEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (typedElementEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "constraints", "body"
           });					
        addAnnotation
          (contextEClass, 
           source, 
           new String[] {
             "constraints", "ConditionMustBeBoolean ConstraintForRightClass"
           });			
        addAnnotation
          (multiplicityEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });						
        addAnnotation
          (signatureImplementationEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });					
        addAnnotation
          (linkTraversalEClass, 
           source, 
           new String[] {
             "constraints", "OutputTypeMatchEndType MustBeNavigable"
           });				
        addAnnotation
          (linkAdditionEClass, 
           source, 
           new String[] {
             "constraints", "AdditionInputTypeMatchEndType"
           });				
        addAnnotation
          (linkRemovalEClass, 
           source, 
           new String[] {
             "constraints", "RemovalTypeMatchEndType"
           });			
        addAnnotation
          (associationEndSignatureImplementationEClass, 
           source, 
           new String[] {
             "constraints", "OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt"
           });			
        addAnnotation
          (classTypeDefinitionEClass, 
           source, 
           new String[] {
             "constraints", "ActualObjectsParametersMatchSignature"
           });			
        addAnnotation
          (classTypeDefinitionEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (classTypeDefinitionEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(2), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(3), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(4), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(5), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(6), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(7), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(8), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (nestedTypeDefinitionEClass, 
           source, 
           new String[] {
             "constraints", "NestedIsAlwaysMany"
           });						
        addAnnotation
          (methodSignatureEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (functionSignatureEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });			
        addAnnotation
          (functionSignatureEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (linkSettingEClass, 
           source, 
           new String[] {
             "constraints", "InputTypeMatchEndType"
           });			
        addAnnotation
          (typeAdapterEClass, 
           source, 
           new String[] {
             "constraints", "AllSignatureConforms SignaturesCannotBeAbstract IsFullAdaptationToTo ValuesToValues_EntitiesToEntities"
           });			
        addAnnotation
          (typeAdapterEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (typeAdapterEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (typeAdapterEClass.getEOperations().get(2), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (typeAdapterEClass.getEOperations().get(3), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (parameterEClass, 
           source, 
           new String[] {
             "constraints", "DefaultValueType"
           });				
        addAnnotation
          (namedValueEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (extentModifyingAssociationEndSignatureImplementationEClass, 
           source, 
           new String[] {
             "constraints", "MustNotModifyExtentIfEqualityRelevantForValueClass MustNotImplementSideEffectFreeOperation"
           });			
        addAnnotation
          (functionSignatureImplementationEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });				
        addAnnotation
          (converterBetweenParametrizationsEClass, 
           source, 
           new String[] {
             "constraints", "MustHaveConcreteMethod FormalObjectParametersConformToMethodParameters"
           });				
        addAnnotation
          (inScopeEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "constraints", "body"
           });	
    }

	/**
     * Initializes the annotations for <b>http://de.hpi.sam.bp2009.OCL</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createDeAnnotations() {
        String source = "http://de.hpi.sam.bp2009.OCL";				
        addAnnotation
          (associationEClass, 
           source, 
           new String[] {
             "UniquenessOnBothEndsMustBeTheSame", "self.ends->forAll( e1, e2 : AssociationEnd |\r\n              e1 <> e2 implies e1.type.unique = e2.type.unique)",
             "AtMostOneCompositeEnd", "self.ends->select(composite)->size() < 2",
             "AtLeastOneNavigableEnd", "self.ends->select(ae:AssociationEnd | ae.navigable)->notEmpty()",
             "AtMostOneEqualityContributionForTwoValueClasses", "self.ends->select(contributesToEquality and type.clazz.valueType)->size() < 2",
             "AtMostOneOrderedEnd", "self.ends->select(ae|ae.type.ordered)->size() < 2"
           });				
        addAnnotation
          (signatureEClass, 
           source, 
           new String[] {
             "OnlyTrailingOptionalParameters", "self.input->forAll(p | p.defaultValue->notEmpty() implies Sequence{(self.input->indexOf(p)+1)..self.input->size()}->forAll(\r\n    i | self.input->at(i).defaultValue->notEmpty()))"
           });			
        addAnnotation
          (signatureEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "if self = s then\n    true\n  else\n    self.conformsToExcluding(s, Sequence{}, Sequence{})\n  endif"
           });			
        addAnnotation
          (signatureEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "body", "if s = self then\n    true\n  else\n    let nameConforms:Boolean = self.oclIsKindOf(MethodSignature) and s.oclIsKindOf(MethodSignature) \n       implies s.oclAsType(MethodSignature).name = self.oclAsType(MethodSignature).name in\n    nameConforms and\n    (s.sideEffectFree implies self.sideEffectFree) and\n    s.input->size() = self.input->size() and\n    Sequence{1..self.input->size()}->\n      forAll(i | s.input->at(i).getType().conformsToExcluding(self.input->at(i).getType(), excludingConforming, excludingTo)) and\n    s.output->size() = self.output->size() and\n    Sequence{1..self.output->size()}->\n      forAll(i | self.output->asSequence()->at(i).conformsToExcluding(s.output->asSequence()->at(i), excludingConforming, excludingTo))\n  endif"
           });				
        addAnnotation
          (signatureEClass.getEOperations().get(2), 
           source, 
           new String[] {
             "body", "self.getOwningClass().formalObjectParameters->asSet()"
           });				
        addAnnotation
          (signatureEClass.getEOperations().get(3), 
           source, 
           new String[] {
             "body", "if self.oclIsKindOf(MethodSignature) then\n    let owner:SignatureOwner = self.oclAsType(MethodSignature).owner in\n    if owner.oclIsKindOf(SapClass) then\n      owner.oclAsType(SapClass)\n    else\n      null    -- e.g., TypeAdapter\n    endif\n  else\n    self.oclAsType(FunctionSignature).getImplementedAnonymousFunctionExpression().getOwningClass()\n  endif"
           });						
        addAnnotation
          (associationEndEClass, 
           source, 
           new String[] {
             "ExposingClassesEqualOppositeEndsType", "self.signatureImplementations.implements_.owner->forAll(c:SignatureOwner | c = self.otherEnd().type.clazz)",
             "NoCompositionWithValueClass", "self.composite implies self.association.ends.type->forAll(ctd:ClassTypeDefinition | not ctd.clazz.valueType)",
             "EqualityContributionsMustBeExposedAndNavigable", "self.contributesToEquality implies (self.otherEnd().signatureImplementations->notEmpty() and self.otherEnd().navigable)",
             "EqualityContributingEndOnValueMustHaveUnlimitedUpperBounds", "(self.type.clazz.valueType and self.contributesToEquality and\r\n   self.type.clazz.getAssociationEnds()->exists(ae |\r\n     ae <> self and ae.contributesToEquality)) implies\r\n  self.type.isMany()"
           });			
        addAnnotation
          (associationEndEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "association.ends->select(ae|ae <> self)->first()"
           });						
        addAnnotation
          (sapClassEClass, 
           source, 
           new String[] {
             "OnlyValueClassesCanHaveObjectParameters", "self.formalObjectParameters->notEmpty() implies self.valueType",
             "OnlyObjectParameterizedClassesCanHaveConverter", "self.converterBetweenParametrizations->notEmpty() implies self.formalObjectParameters->notEmpty()",
             "OnlyTrailingOptionalParameters", "self.formalObjectParameters->forAll(p | p.defaultValue->notEmpty() implies Sequence{(self.formalObjectParameters->indexOf(p)+1)..self.formalObjectParameters->size()}->forAll(\r\n    i | self.formalObjectParameters->at(i).defaultValue->notEmpty()))",
             "NoRecursionForObjectParameters", "true  --  TODO implement this"
           });			
        addAnnotation
          (sapClassEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "not (self.allSignatures()->forAll(s:MethodSignature | not s.isAbstract()))"
           });			
        addAnnotation
          (sapClassEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "body", "self.parameterization->notEmpty()"
           });			
        addAnnotation
          (sapClassEClass.getEOperations().get(2), 
           source, 
           new String[] {
             "body", "if self.oclIsUndefined() then\n    false\n  else\n    self.conformsToExcluding(type, Sequence{}, Sequence{})\n  endif"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(3), 
           source, 
           new String[] {
             "body", "self.allSignaturesExcluding(Set{})"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(4), 
           source, 
           new String[] {
             "body", "if self.oclIsKindOf(data::generics::ParameterizedClassInstantiation) then\n    self.oclAsType(data::generics::ParameterizedClassInstantiation).parameterizedClass.delegatesTo()\n  else\n    if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n      self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->collect(c:SapClass | c.delegatesTo())->flatten()->asSet()\n    else\n      -- TODO improve OCL impact analysis algorithm so that this doesn\'t kill performance:\n      -- Set{}  -- use this for good performance\n      self.getAssociationEnds().otherEnd()->select(delegation->notEmpty()).type.clazz->reject(c|c=self)->asSet()    -- currently bad performance\n    endif\n  endif"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(5), 
           source, 
           new String[] {
             "body", "if oclIsUndefined() then\n    false\n  else\n  if self = type then\n   true\n  else\n    if Sequence{1..excludingConforming->size()}->exists(i|\n        excludingConforming->asSequence()->at(i) = self and excludingTo->asSequence()->at(i) = type) then\n     true\n  else\n    self.adapters->exists(a|a.to.conformsToExcluding(type, excludingConforming->including(self), excludingTo->including(type))) or\n    (if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n        if self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->notEmpty() then\n            self.oclAsType(data::generics::FormalTypeParameter).typeConstraint.conformsToExcluding(type, excludingConforming->including(self), excludingTo->including(type))\n        else\n            false\n        endif\n    else\n        false\n    endif)\n  endif\n  endif\nendif"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(6), 
           source, 
           new String[] {
             "body", "self.signaturesWithDelegationExcluding(Set{})"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(7), 
           source, 
           new String[] {
             "body", "self.delegatesTo().signaturesWithDelegation()->flatten()->asSet()"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(8), 
           source, 
           new String[] {
             "body", "self.adaptedSignaturesExcluding(Set{})"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(9), 
           source, 
           new String[] {
             "body", "if excluding->count(self)=0 then\n    if self.oclIsKindOf(data::generics::ParameterizedClassInstantiation) then\n      self.oclAsType(data::generics::ParameterizedClassInstantiation).parameterizedClass.adaptedSignaturesExcluding(excluding->including(self))\n    else\n      if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n        self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->collect(c:SapClass | c.adaptedSignaturesExcluding(excluding->including(self)))->flatten()->asSet()\n      else\n        self.adapters.allSignaturesExcluding(excluding->including(self))\n          ->select(s | not self.ownedSignatures->exists(os | os.conformsTo(s)))\n          ->flatten()->asSet()\n      endif\n    endif\n  else\n    Set{}\n  endif"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(10), 
           source, 
           new String[] {
             "body", "if excluding->count(self)=0 then\n    if self.oclIsKindOf(data::generics::ParameterizedClassInstantiation) then\n      self.oclAsType(data::generics::ParameterizedClassInstantiation).parameterizedClass.allSignaturesExcluding(excluding->including(self))\n    else\n      if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n        self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->collect(c:SapClass | c.allSignaturesExcluding(excluding->including(self)))->flatten()->asSet()\n      else\n        self.signaturesWithDelegationExcluding(excluding)->union(self.adaptedSignaturesExcluding(excluding))\n      endif\n    endif\n  else\n    Set{}    \n  endif"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(11), 
           source, 
           new String[] {
             "body", "if excluding->count(self)=0 then \n    if self.oclIsKindOf(data::generics::ParameterizedClassInstantiation) then\n      self.oclAsType(data::generics::ParameterizedClassInstantiation).parameterizedClass.signaturesWithDelegationExcluding(excluding->including(self))\n    else\n      if self.oclIsKindOf(data::generics::FormalTypeParameter) then\n        self.oclAsType(data::generics::FormalTypeParameter).typeConstraint->collect(c:SapClass | c.signaturesWithDelegationExcluding(excluding->including(self)))->flatten()->asSet()\n      else\n        self.ownedSignatures->union(self.delegatesTo().signaturesWithDelegationExcluding(excluding->including(self)))->flatten()->asSet()\n      endif\n    endif\nelse\n  Set{}\nendif"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(12), 
           source, 
           new String[] {
             "body", "if excluding->count(self)=0 then\n  self.delegatesTo().signaturesWithDelegationExcluding(excluding->including(self))->flatten()->asSet()\nelse\n  Set{}\nendif"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(13), 
           source, 
           new String[] {
             "body", "self.adaptedBy.adapted.getConformingClasses()->including(self)->asSet()"
           });			
        addAnnotation
          (sapClassEClass.getEOperations().get(14), 
           source, 
           new String[] {
             "body", "self.elementsOfType->collect(associationEnd->asSet())->asSet()"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(15), 
           source, 
           new String[] {
             "body", "self.getAssociationEnds()->select(ae|ae.contributesToEquality)"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(16), 
           source, 
           new String[] {
             "body", "self.adapters.to.getConformsToClasses()->including(self)->asSet()"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(17), 
           source, 
           new String[] {
             "body", "self.getConformsToClasses().getAssociationEnds()->asSet()"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(18), 
           source, 
           new String[] {
             "body", "self.getConformsToClasses().getAssociationEnds()->select(ae|ae.composite)->asSet()"
           });				
        addAnnotation
          (sapClassEClass.getEOperations().get(19), 
           source, 
           new String[] {
             "body", "self.getConformsToClasses().getAssociationEnds()->select(ae|ae.otherEnd().composite)->asSet()"
           });						
        addAnnotation
          (delegationEClass, 
           source, 
           new String[] {
             "ToEndMustHaveMultiplicityOfOne", "self.from.otherEnd().type.lowerMultiplicity = 1 and\r\n  self.from.otherEnd().type.upperMultiplicity = 1"
           });			
        addAnnotation
          (typedElementEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "self = typedElement or\n  self.getType().conformsTo(typedElement.getType())"
           });				
        addAnnotation
          (typedElementEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "body", "if self.ownedTypeDefinition->notEmpty() then\n    self.ownedTypeDefinition\n  else\n    if self.oclIsKindOf(behavioral::actions::Variable) then\n      self.oclAsType(behavioral::actions::Variable).initExpression.getType()\n    else if self.oclIsKindOf(behavioral::actions::Constant) then\n      if self.oclAsType(behavioral::actions::Constant).initExpression->notEmpty() then\n        self.oclAsType(behavioral::actions::Constant).initExpression.getType()\n      else\n         if self.oclAsType(behavioral::actions::Constant)._iterate->notEmpty() then\n           self.oclAsType(behavioral::actions::Constant)._iterate.iteratorExpression.getType()\n         else\n           null\n         endif\n      endif\n    else if self.oclIsKindOf(behavioral::actions::Iterator) then\n      if self.oclAsType(behavioral::actions::Iterator).boundToFor->notEmpty() then\n        if self.oclAsType(behavioral::actions::Iterator).boundToFor.collection.getType().oclIsKindOf(data::classes::NestedTypeDefinition) then\n          -- if the selection\'s object has a nested type definition, un-nest by one level\n          self.oclAsType(behavioral::actions::Iterator).boundToFor.collection.getType().oclAsType(data::classes::NestedTypeDefinition).type\n        else\n          -- the tool should infer a better match; this as a better default than \"null\"\n          self.oclAsType(behavioral::actions::Iterator).boundToFor.collection.getType()\n        endif\n      else\n        let selection:Set(dataaccess::expressions::Expression)=self.oclAsType(behavioral::actions::Iterator).selection.object->asSet() in\n        let groupby:Set(dataaccess::expressions::Expression)=self.oclAsType(behavioral::actions::Iterator).factOfGroupBy.object->asSet() in\n        let iterateexp:Set(dataaccess::expressions::Expression)=self.oclAsType(behavioral::actions::Iterator)._iterate.source->asSet() in\n        let iteratesource:Set(dataaccess::expressions::Expression)=selection->union(groupby)->union(iterateexp) in\n        if iteratesource->notEmpty() then\n          if iteratesource->any(true).getType().oclIsKindOf(data::classes::NestedTypeDefinition) then\n            -- if the Selection\'s/GroupBy\'s object has a nested type definition, un-nest by one level\n            iteratesource->any(true).getType().oclAsType(data::classes::NestedTypeDefinition).type\n          else\n            -- In this case the tool should create a cloned tpye definition with multiplicities set to 1;\n            -- Just in case the tool doesn\'t do this and for the case where the object has upper\n            -- multiplicity 1, use the object\'s type as the default for the \"self\" iterator\n            iteratesource->any(true).getType()\n          endif\n        else\n          if self.oclAsType(behavioral::actions::Iterator).groupedFactsOfGroupBy->notEmpty() then\n            -- the groups of a group-by expression can re-used the facts type\n            self.oclAsType(behavioral::actions::Iterator).factOfGroupBy.object.getType()\n          else\n            if self.oclAsType(behavioral::actions::Iterator).dimension->notEmpty() then\n              -- the DimensionDefinition\'s expression defines the dimension iterator\'s type\n              self.oclAsType(behavioral::actions::Iterator).dimension.expression.getType()\n            else\n              -- Then we have no idea how to infer the Iterator\'s type\n              null\n            endif\n          endif\n        endif\n      endif\n    else if self.oclIsKindOf(dataaccess::expressions::collectionexpressions::Including) or self.oclIsKindOf(dataaccess::expressions::collectionexpressions::Excluding) then\n      self.oclAsType(dataaccess::expressions::collectionexpressions::CollectionExpression).source.getType()\n    else if self.oclIsKindOf(dataaccess::expressions::collectionexpressions::Iterate) then\n      self.oclAsType(dataaccess::expressions::collectionexpressions::Iterate).iteratorExpression.getType()\n    else if self.oclIsKindOf(Parameter) then\n      if self.oclAsType(Parameter).defaultValue->notEmpty() then\n        self.oclAsType(Parameter).defaultValue.getType()\n      else\n        if self.oclAsType(Parameter).ownerSignature.oclIsKindOf(MethodSignature) and\n        self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation->notEmpty() and\n        self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation.oclIsKindOf(AssociationEndSignatureImplementation) then\n  \tlet impl:AssociationEndSignatureImplementation = self.oclAsType(Parameter).ownerSignature.oclAsType(MethodSignature).implementation.oclAsType(AssociationEndSignatureImplementation) in\n            impl.end.type\n        else\n          if self.oclAsType(Parameter).ownerSignature.oclIsKindOf(FunctionSignature) then\n            if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).dimension->notEmpty() then\n              self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).dimension.cellSet.factsType\n            else\n              if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForValueFunction->notEmpty() then\n                self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForValueFunction.factsType\n              else\n                if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction->notEmpty() then\n                  if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.valueFunction->notEmpty() then\n                    self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.valueFunction.output\n                  else\n                    self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).cellSetForAggregationFunction.factsType\n                  endif\n                else\n                  if self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclIsKindOf(dataaccess::analytics::CellSet) then\n                    let pos:Integer = self.oclAsType(Parameter).ownerSignature.input->indexOf(self.oclAsType(Parameter)) in\n                    if pos = 1 then\n                      self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclAsType(dataaccess::analytics::CellSet).factsType\n                    else\n                      self.oclAsType(Parameter).ownerSignature.oclAsType(FunctionSignature).implementation.oclAsType(dataaccess::analytics::CellSet).\n                          dimensions->at(-1+pos).characteristicFunction.output\n                    endif\n                  else\n                    null\n                  endif\n                endif\n              endif\n            endif\n          else\n            null\n          endif\n        endif\n      endif\n    else if self.oclIsKindOf(dataaccess::analytics::DimensionExpression) then\n      -- TODO Here, the multiplicity would have to be forced to 0..*\n      self.oclAsType(dataaccess::analytics::DimensionExpression).dimensionParameter.getType()\n    else if self.oclIsKindOf(dataaccess::expressions::VariableExpression) then\n      self.oclAsType(dataaccess::expressions::VariableExpression).variable.getType()\n    else if self.oclIsKindOf(dataaccess::expressions::SignatureCallExpression) then\n      self.oclAsType(dataaccess::expressions::SignatureCallExpression).getSignature().output\n    else if self.oclIsKindOf(dataaccess::expressions::AssociationEndNavigationExpression) then\n      self.oclAsType(dataaccess::expressions::AssociationEndNavigationExpression).toEnd.type\n    else if self.oclIsKindOf(dataaccess::expressions::Replace) then\n      self.oclAsType(dataaccess::expressions::Replace).object.getType()\n    else if self.oclIsKindOf(dataaccess::expressions::Ternary) then\n      -- Find the \"least\" TypeDefinition to which both, trueExpr.getType() and falseExpr.getType() conform.\n      -- We determine the more general of the two types; we cannot synthesize a new TypeDefinition in OCL.\n      -- Doing so would have to be done by explicit typing, setting the ownedTypeDefinition explicitly\n      if self.oclAsType(dataaccess::expressions::Ternary).trueExpr.getType().conformsTo(self.oclAsType(dataaccess::expressions::Ternary).falseExpr.getType()) then\n        self.oclAsType(dataaccess::expressions::Ternary).falseExpr.getType()\n      else\n        self.oclAsType(dataaccess::expressions::Ternary).trueExpr.getType()\n      endif\n    else if self.oclIsKindOf(dataaccess::query::Selection) then\n      self.oclAsType(dataaccess::query::Selection).object.getType()\n    else\n      null\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n    endif\n  endif"
           });					
        addAnnotation
          (contextEClass, 
           source, 
           new String[] {
             "ConditionMustBeBoolean", "self.condition.getType().upperMultiplicity = 1 and\r\n  self.condition.getType().oclIsKindOf(ClassTypeDefinition) and\r\n  self.condition.getType().oclAsType(ClassTypeDefinition).clazz.name = \'Boolean\'",
             "ConstraintForRightClass", "self.constraints->forAll(c | c.constrainedType = self.for_)"
           });			
        addAnnotation
          (multiplicityEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "self.upperMultiplicity > 1 or self.upperMultiplicity = -1"
           });						
        addAnnotation
          (signatureImplementationEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "if self.oclIsKindOf(FunctionSignatureImplementation) then\n    if self.oclAsType(FunctionSignatureImplementation).functionSignature->notEmpty() then\n      self.oclAsType(FunctionSignatureImplementation).functionSignature\n    else\n      self.implements_\n    endif\n  else\n    self.implements_\n  endif"
           });					
        addAnnotation
          (linkTraversalEClass, 
           source, 
           new String[] {
             "OutputTypeMatchEndType", "self.implements_.input->isEmpty() and\r\n  self.implements_.output.oclIsKindOf(ClassTypeDefinition) and \r\n  self.implements_.output.oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz",
             "MustBeNavigable", "self.end.navigable"
           });				
        addAnnotation
          (linkAdditionEClass, 
           source, 
           new String[] {
             "AdditionInputTypeMatchEndType", "self.implements_.output->isEmpty() and\r\n  self.implements_.input->size() = 1 and \r\n  self.implements_.input->at(1).getType().oclIsKindOf(ClassTypeDefinition) and \r\n  self.implements_.input->at(1).getType().oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz"
           });				
        addAnnotation
          (linkRemovalEClass, 
           source, 
           new String[] {
             "RemovalTypeMatchEndType", "self.implements_.output->isEmpty() and\r\n  self.implements_.input->size() = 1 and \r\n  self.implements_.input->at(1).getType().oclIsKindOf(ClassTypeDefinition) and \r\n  self.implements_.input->at(1).getType().oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz"
           });			
        addAnnotation
          (associationEndSignatureImplementationEClass, 
           source, 
           new String[] {
             "OnlyOnOtherEndsClassOrClassConformingToItOrAdapterAdaptingToIt", "(self.implements_.owner.oclIsKindOf(SapClass) and\r\n    self.implements_.owner.oclAsType(SapClass).conformsTo(self.end.otherEnd().type.clazz))\r\n  or   (self.implements_.owner.oclIsKindOf(TypeAdapter) and\r\n    self.implements_.owner.oclAsType(TypeAdapter).adapted.conformsTo(self.end.otherEnd().type.clazz))"
           });			
        addAnnotation
          (classTypeDefinitionEClass, 
           source, 
           new String[] {
             "ActualObjectsParametersMatchSignature", "let numberOfMandatoryParameters:Integer =\r\n    self.clazz.formalObjectParameters->select(p|p.defaultValue->isEmpty())->size()\r\n  in\r\n  self.objectParameters->size() >= numberOfMandatoryParameters and\r\n  self.objectParameters->size() <= self.clazz.formalObjectParameters->size() and\r\n  Sequence{1..self.objectParameters->size()}->forAll(i:Integer|\r\n    self.objectParameters->at(i).formalObjectParameter =\r\n    self.clazz.formalObjectParameters->at(i))"
           });			
        addAnnotation
          (classTypeDefinitionEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "if self.effectiveObjectParameters()->size()  = ctd.effectiveObjectParameters()->size() then\n    self.clazz.converterBetweenParametrizations->notEmpty() or\n    Sequence{1..self.effectiveObjectParameters()->size()}->forAll(i |\n      self.effectiveObjectParameters()->at(i).evaluatesToEqualAs(ctd.effectiveObjectParameters()->at(i)))\n  else\n    false\n  endif"
           });			
        addAnnotation
          (classTypeDefinitionEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "body", "self.objectParameters.value->flatten()->asSequence()->union(\n     Sequence{(self.objectParameters->size()+1)..(self.clazz.formalObjectParameters->size())}->collect(i | \n             self.clazz.formalObjectParameters->at(i).defaultValue->flatten()->asSequence()))->flatten()->asSequence()"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "if self.oclIsUndefined() then\n    false\n  else if self = typeDef then\n    true\n  else\n    self.conformsToExcluding(typeDef, Sequence{}, Sequence{})\n  endif\n  endif"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "body", "if oclIsUndefined() then\n    false\n  else\n  if self = td then\n    true\n  else\n   self.multiplicityConformsTo(td) and\n   self.conformsToIgnoringMultiplicityExcluding(td, excludingConforming, excludingTo)\n  endif\n endif"
           });				
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(2), 
           source, 
           new String[] {
             "body", "-- check for multiplicity conformance\n    -- multiplicity of td must include multiplicity of td\n    td.lowerMultiplicity <= self.lowerMultiplicity\n    and\n    (\n        td.upperMultiplicity = -1\n        or \n        ( td.upperMultiplicity >= self.upperMultiplicity and self.upperMultiplicity <> -1 ) \n    ) \n    \n    -- check for conformance of orderedness and uniqueness\n    -- orderedness/uniqueness of td must be same or more relaxed than self\'s\n    and\n    (\n       not self.isMany()\n        or\n        ( ( self.ordered = td.ordered ) and ( self.unique = td.unique ) )\n        or\n        ( self.ordered and self.unique )\n        or\n        ( not ( td.ordered or td.unique ) )\n    )"
           });				
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(3), 
           source, 
           new String[] {
             "body", "if self = td then\n    true\n  else\n   if self.oclIsKindOf(ClassTypeDefinition) then\n    td.oclIsKindOf(ClassTypeDefinition) and\n    self.oclAsType(ClassTypeDefinition).clazz.conformsToExcluding(\n                td.oclAsType(ClassTypeDefinition).clazz, excludingConforming, excludingTo) and\n    self.oclAsType(ClassTypeDefinition).objectParametersConformTo(td.oclAsType(ClassTypeDefinition))\n  else\n    if self.oclIsKindOf(FunctionSignatureTypeDefinition) then\n      td.oclIsKindOf(FunctionSignatureTypeDefinition) and\n      self.oclAsType(FunctionSignatureTypeDefinition).signature.conformsToExcluding(\n           td.oclAsType(FunctionSignatureTypeDefinition).signature, excludingConforming, excludingTo)\n    else\n      td.oclIsKindOf(NestedTypeDefinition) and\n      self.oclAsType(NestedTypeDefinition).type.conformsToExcluding(\n          td.oclAsType(NestedTypeDefinition).type, excludingConforming, excludingTo)\n    endif\n  endif\n endif"
           });				
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(4), 
           source, 
           new String[] {
             "body", "if self = typeDef then\n   true\n  else\n    self.conformsToIgnoringMultiplicityExcluding(typeDef, Sequence{}, Sequence{})\n  endif"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(5), 
           source, 
           new String[] {
             "body", "TypedElement.allInstances()->select(te | te.getType() = self)"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(6), 
           source, 
           new String[] {
             "body", "if self.oclIsKindOf(NestedTypeDefinition) then\n    self.oclAsType(NestedTypeDefinition).type.getInnermost()\n  else\n    self\n  endif"
           });				
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(7), 
           source, 
           new String[] {
             "body", "if self.oclIsKindOf(NestedTypeDefinition) then\n    self.oclAsType(NestedTypeDefinition).type.getNestingLevel() + 1\n  else\n    0\n  endif"
           });			
        addAnnotation
          (typeDefinitionEClass.getEOperations().get(8), 
           source, 
           new String[] {
             "body", "-- find owner of type definition and collect the named values in scope for the owner\n  (let ownerSig:Signature = self.ownerSignature in\n  if ownerSig->notEmpty() and ownerSig.oclIsKindOf(Signature) then\n    ownerSig.oclAsType(Signature).getNamedValuesInScope()\n  else\n    Set{}   -- some boundary case such as TupleElement or ValueSet not currently supported\n  endif)->union(\n\n  if self.ownerTypedElement->notEmpty() then\n    if self.ownerTypedElement.oclIsKindOf(dataaccess::expressions::Expression) then\n      self.ownerTypedElement.oclAsType(dataaccess::expressions::Expression).getNamedValuesInScope()\n    else\n      if self.ownerTypedElement.oclIsKindOf(NamedValue) then\n        self.ownerTypedElement.oclAsType(NamedValue).getNamedValuesInScope()\n      else\n        Set{}   -- some boundary case such as TupleElement or ValueSet not currently supported\n      endif\n    endif\n  else\n    Set{}\n  endif)"
           });				
        addAnnotation
          (nestedTypeDefinitionEClass, 
           source, 
           new String[] {
             "NestedIsAlwaysMany", "self.isMany()"
           });						
        addAnnotation
          (methodSignatureEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "self.implementation->isEmpty()"
           });				
        addAnnotation
          (functionSignatureEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "self.implementation->isEmpty()"
           });			
        addAnnotation
          (functionSignatureEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "body", "let candidates:Sequence(dataaccess::expressions::fp::AnonymousFunctionExpr) =\n         self.typeDefinition.ownerTypedElement.oclAsType(dataaccess::expressions::fp::AnonymousFunctionExpr)->asSequence() in\n  if candidates->isEmpty() then\n    null\n  else\n    candidates->at(1)\n  endif"
           });				
        addAnnotation
          (linkSettingEClass, 
           source, 
           new String[] {
             "InputTypeMatchEndType", "self.implements_.output->isEmpty() and\r\n  self.implements_.input->size() = 1 and \r\n  self.implements_.input->at(1).getType().oclIsKindOf(ClassTypeDefinition) and \r\n  self.implements_.input->at(1).getType().oclAsType(ClassTypeDefinition).clazz = self.end.type.clazz"
           });			
        addAnnotation
          (typeAdapterEClass, 
           source, 
           new String[] {
             "AllSignatureConforms", "self.ownedSignatures->forAll(selfSig:MethodSignature |\r\n    self.to.signaturesWithDelegation()->exists(toSig:MethodSignature |\r\n       selfSig.conformsTo(toSig)))",
             "SignaturesCannotBeAbstract", "self.ownedSignatures->forAll(selfSig:MethodSignature | not selfSig.isAbstract())",
             "IsFullAdaptationToTo", "self.to.signaturesWithDelegation()->forAll(toSig|\r\n    self.adapted.signaturesWithDelegation()->exists(adaptedSig|\r\n      adaptedSig.conformsTo(toSig))\r\n    or self.ownedSignatures->exists(ownedSig|\r\n      ownedSig.conformsTo(toSig)))",
             "ValuesToValues_EntitiesToEntities", "self.adapted.valueType = self.to.valueType"
           });			
        addAnnotation
          (typeAdapterEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "type.signaturesWithDelegation()->forAll(typeSig:MethodSignature |\n    self.allSignatures()->exists(selfSig:MethodSignature |\n       selfSig.conformsToExcluding(typeSig, Sequence{self.to}, Sequence{type})))"
           });				
        addAnnotation
          (typeAdapterEClass.getEOperations().get(1), 
           source, 
           new String[] {
             "body", "Sequence{1..excludingConforming->size()}->exists(i|\n  excludingConforming->asSequence()->at(i) = self.to and excludingTo->asSequence()->at(i) = type) or\n  type.signaturesWithDelegation()->forAll(typeSig:MethodSignature |\n         self.allSignatures()->exists(selfSig:MethodSignature |\n            selfSig.conformsToExcluding(typeSig,\n                    excludingConforming->asSequence()->append(self.to),\n                    excludingTo->asSequence()->append(type))))"
           });				
        addAnnotation
          (typeAdapterEClass.getEOperations().get(2), 
           source, 
           new String[] {
             "body", "self.allSignaturesExcluding(Set{})"
           });				
        addAnnotation
          (typeAdapterEClass.getEOperations().get(3), 
           source, 
           new String[] {
             "body", "self.to.allSignaturesExcluding(excluding)->select(s |\n    not self.ownedSignatures->exists(os | os.conformsTo(s)))->union(\n  self.ownedSignatures)"
           });				
        addAnnotation
          (parameterEClass, 
           source, 
           new String[] {
             "DefaultValueType", "self.defaultValue->notEmpty() implies self.defaultValue.getType().conformsTo(self.getType())"
           });				
        addAnnotation
          (namedValueEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "self.owner.getNamedValuesInScope()->union(\n    if self.oclIsKindOf(Parameter) then\n      self.oclAsType(Parameter).ownerSignature.getNamedValuesInScope()\n    else\n      if self.oclIsKindOf(behavioral::actions::Iterator) then\n        self.oclAsType(behavioral::actions::Iterator).boundToFor.getNamedValuesInScope()->asSet()->union(\n        self.oclAsType(behavioral::actions::Iterator)._iterate.getNamedValuesInScope()->asSet())\n      else\n        if self.oclIsKindOf(behavioral::actions::Constant) then\n          self.oclAsType(behavioral::actions::Constant)._iterate.getNamedValuesInScope()\n        else\n          Set{}    -- TODO further cases?\n        endif\n      endif\n    endif\n    )"
           });				
        addAnnotation
          (extentModifyingAssociationEndSignatureImplementationEClass, 
           source, 
           new String[] {
             "MustNotModifyExtentIfEqualityRelevantForValueClass", "end.association.ends->forAll(ae:AssociationEnd |\r\n    ae.contributesToEquality implies not ae.type.clazz.valueType)",
             "MustNotImplementSideEffectFreeOperation", "not self.implements_.sideEffectFree"
           });			
        addAnnotation
          (functionSignatureImplementationEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "if self.oclIsKindOf(behavioral::actions::Block) then\n    self.oclAsType(behavioral::actions::Block).localIsSideEffectFree()\n  else\n    if self.oclIsKindOf(dataaccess::analytics::CellSet) then\n      self.oclAsType(dataaccess::analytics::CellSet).localIsSideEffectFree()\n    else\n      false\n    endif\n  endif"
           });				
        addAnnotation
          (converterBetweenParametrizationsEClass, 
           source, 
           new String[] {
             "MustHaveConcreteMethod", "not self.conversionMethod.isAbstract()",
             "FormalObjectParametersConformToMethodParameters", "self.conversionMethod.input->size() = self.clazz.formalObjectParameters->size() and\r\n  Sequence{1..self.conversionMethod.input->size()}->forAll(i |\r\n    self.clazz.formalObjectParameters->at(i).conformsTo(self.conversionMethod.input->at(i)))"
           });				
        addAnnotation
          (inScopeEClass.getEOperations().get(0), 
           source, 
           new String[] {
             "body", "inner->union(outer->select(o | not inner->exists(i | i.name = o.name))->asSet())"
           });		
    }

	/**
     * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml</b>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected void createEmofAnnotations() {
        String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml";																				
        addAnnotation
          (getSignature_Preconditions(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "preconditionForSignature"
           });		
        addAnnotation
          (getSignature_Postconditions(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "postconditionForSignature"
           });																																																																																																																																				
        addAnnotation
          (getNestedTypeDefinition_OwnedTypeDefinition(), 
           source, 
           new String[] {
             "Property.oppositeRoleName", "owningNestedTypeDefinition"
           });																																										
    }

} //ClassesPackageImpl
