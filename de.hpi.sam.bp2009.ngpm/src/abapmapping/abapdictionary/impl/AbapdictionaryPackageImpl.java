/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.abapdictionary.impl;

import abapmapping.AbapmappingPackage;

import abapmapping.abapdictionary.AbapPrimtiveType;
import abapmapping.abapdictionary.AbapStructureField;
import abapmapping.abapdictionary.AbapStructureType;
import abapmapping.abapdictionary.AbapType;
import abapmapping.abapdictionary.AbapdictionaryFactory;
import abapmapping.abapdictionary.AbapdictionaryPackage;
import abapmapping.abapdictionary.Code;
import abapmapping.abapdictionary.CodeValue;
import abapmapping.abapdictionary.DataElement;
import abapmapping.abapdictionary.UnstructuredAbapType;
import abapmapping.abapdictionary.XsdType;

import abapmapping.abapdictionary.util.AbapdictionaryValidator;

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
public class AbapdictionaryPackageImpl extends EPackageImpl implements AbapdictionaryPackage {
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass xsdTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass unstructuredAbapTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass codeValueEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass codeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass dataElementEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass abapTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass abapStructureTypeEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass abapStructureFieldEClass = null;

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	private EClass abapPrimtiveTypeEClass = null;

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
     * @see abapmapping.abapdictionary.AbapdictionaryPackage#eNS_URI
     * @see #init()
     * @generated
     */
	private AbapdictionaryPackageImpl() {
        super(eNS_URI, AbapdictionaryFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link AbapdictionaryPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
	public static AbapdictionaryPackage init() {
        if (isInited) return (AbapdictionaryPackage)EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI);

        // Obtain or create and register package
        AbapdictionaryPackageImpl theAbapdictionaryPackage = (AbapdictionaryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AbapdictionaryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AbapdictionaryPackageImpl());

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
        persistence.actions.impl.ActionsPackageImpl theActionsPackage_1 = (persistence.actions.impl.ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) instanceof persistence.actions.impl.ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) : persistence.actions.ActionsPackage.eINSTANCE);
        persistence.expressions.impl.ExpressionsPackageImpl theExpressionsPackage_1 = (persistence.expressions.impl.ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) instanceof persistence.expressions.impl.ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) : persistence.expressions.ExpressionsPackage.eINSTANCE);

        // Create package meta-data objects
        theAbapdictionaryPackage.createPackageContents();
        theBpdmPackage.createPackageContents();
        theBusinesstasksPackage.createPackageContents();
        theActionsPackage.createPackageContents();
        theRulesPackage.createPackageContents();
        theEventsPackage.createPackageContents();
        theTransactionsPackage.createPackageContents();
        theStatus_and_action_oldPackage.createPackageContents();
        theDesignPackage.createPackageContents();
        theAssemblyPackage.createPackageContents();
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
        theActionsPackage_1.createPackageContents();
        theExpressionsPackage_1.createPackageContents();

        // Initialize created meta-data
        theAbapdictionaryPackage.initializePackageContents();
        theBpdmPackage.initializePackageContents();
        theBusinesstasksPackage.initializePackageContents();
        theActionsPackage.initializePackageContents();
        theRulesPackage.initializePackageContents();
        theEventsPackage.initializePackageContents();
        theTransactionsPackage.initializePackageContents();
        theStatus_and_action_oldPackage.initializePackageContents();
        theDesignPackage.initializePackageContents();
        theAssemblyPackage.initializePackageContents();
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
        theActionsPackage_1.initializePackageContents();
        theExpressionsPackage_1.initializePackageContents();

        // Register package validator
        EValidator.Registry.INSTANCE.put
            (theAbapdictionaryPackage, 
             new EValidator.Descriptor() {
                 public EValidator getEValidator() {
                     return AbapdictionaryValidator.INSTANCE;
                 }
             });

        // Mark meta-data to indicate it can't be changed
        theAbapdictionaryPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(AbapdictionaryPackage.eNS_URI, theAbapdictionaryPackage);
        return theAbapdictionaryPackage;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getXsdType() {
        return xsdTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getXsdType_XsdType() {
        return (EAttribute)xsdTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getXsdType_Length() {
        return (EAttribute)xsdTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getXsdType_Pattern() {
        return (EAttribute)xsdTypeEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getXsdType_TotalDigits() {
        return (EAttribute)xsdTypeEClass.getEStructuralFeatures().get(3);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getXsdType_FractionDigits() {
        return (EAttribute)xsdTypeEClass.getEStructuralFeatures().get(4);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getUnstructuredAbapType() {
        return unstructuredAbapTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCodeValue() {
        return codeValueEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCodeValue_Value() {
        return (EAttribute)codeValueEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCodeValue_Description() {
        return (EReference)codeValueEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCodeValue_Type() {
        return (EReference)codeValueEClass.getEStructuralFeatures().get(2);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getCode() {
        return codeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getCode_Extensible() {
        return (EAttribute)codeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getCode_Values() {
        return (EReference)codeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getDataElement() {
        return dataElementEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getDataElement_AbapType() {
        return (EReference)dataElementEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAbapType() {
        return abapTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAbapType_Name() {
        return (EAttribute)abapTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAbapType_XsdRepresentation() {
        return (EReference)abapTypeEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAbapStructureType() {
        return abapStructureTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAbapStructureType_Fields() {
        return (EReference)abapStructureTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAbapStructureField() {
        return abapStructureFieldEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAbapStructureField_Name() {
        return (EAttribute)abapStructureFieldEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EReference getAbapStructureField_Type() {
        return (EReference)abapStructureFieldEClass.getEStructuralFeatures().get(1);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EClass getAbapPrimtiveType() {
        return abapPrimtiveTypeEClass;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EAttribute getAbapPrimtiveType_Length() {
        return (EAttribute)abapPrimtiveTypeEClass.getEStructuralFeatures().get(0);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapdictionaryFactory getAbapdictionaryFactory() {
        return (AbapdictionaryFactory)getEFactoryInstance();
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
        xsdTypeEClass = createEClass(XSD_TYPE);
        createEAttribute(xsdTypeEClass, XSD_TYPE__XSD_TYPE);
        createEAttribute(xsdTypeEClass, XSD_TYPE__LENGTH);
        createEAttribute(xsdTypeEClass, XSD_TYPE__PATTERN);
        createEAttribute(xsdTypeEClass, XSD_TYPE__TOTAL_DIGITS);
        createEAttribute(xsdTypeEClass, XSD_TYPE__FRACTION_DIGITS);

        unstructuredAbapTypeEClass = createEClass(UNSTRUCTURED_ABAP_TYPE);

        codeValueEClass = createEClass(CODE_VALUE);
        createEAttribute(codeValueEClass, CODE_VALUE__VALUE);
        createEReference(codeValueEClass, CODE_VALUE__DESCRIPTION);
        createEReference(codeValueEClass, CODE_VALUE__TYPE);

        codeEClass = createEClass(CODE);
        createEAttribute(codeEClass, CODE__EXTENSIBLE);
        createEReference(codeEClass, CODE__VALUES);

        dataElementEClass = createEClass(DATA_ELEMENT);
        createEReference(dataElementEClass, DATA_ELEMENT__ABAP_TYPE);

        abapTypeEClass = createEClass(ABAP_TYPE);
        createEAttribute(abapTypeEClass, ABAP_TYPE__NAME);
        createEReference(abapTypeEClass, ABAP_TYPE__XSD_REPRESENTATION);

        abapStructureTypeEClass = createEClass(ABAP_STRUCTURE_TYPE);
        createEReference(abapStructureTypeEClass, ABAP_STRUCTURE_TYPE__FIELDS);

        abapStructureFieldEClass = createEClass(ABAP_STRUCTURE_FIELD);
        createEAttribute(abapStructureFieldEClass, ABAP_STRUCTURE_FIELD__NAME);
        createEReference(abapStructureFieldEClass, ABAP_STRUCTURE_FIELD__TYPE);

        abapPrimtiveTypeEClass = createEClass(ABAP_PRIMTIVE_TYPE);
        createEAttribute(abapPrimtiveTypeEClass, ABAP_PRIMTIVE_TYPE__LENGTH);
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
        LocalizationPackage theLocalizationPackage = (LocalizationPackage)EPackage.Registry.INSTANCE.getEPackage(LocalizationPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        unstructuredAbapTypeEClass.getESuperTypes().add(this.getAbapType());
        codeEClass.getESuperTypes().add(this.getDataElement());
        dataElementEClass.getESuperTypes().add(this.getUnstructuredAbapType());
        abapStructureTypeEClass.getESuperTypes().add(this.getAbapType());
        abapPrimtiveTypeEClass.getESuperTypes().add(this.getUnstructuredAbapType());

        // Initialize classes and features; add operations and parameters
        initEClass(xsdTypeEClass, XsdType.class, "XsdType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getXsdType_XsdType(), theEcorePackage.getEString(), "xsdType", null, 1, 1, XsdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getXsdType_Length(), theEcorePackage.getEInt(), "length", null, 1, 1, XsdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getXsdType_Pattern(), theEcorePackage.getEString(), "pattern", null, 1, 1, XsdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getXsdType_TotalDigits(), theEcorePackage.getEInt(), "totalDigits", null, 1, 1, XsdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getXsdType_FractionDigits(), theEcorePackage.getEInt(), "fractionDigits", null, 1, 1, XsdType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(unstructuredAbapTypeEClass, UnstructuredAbapType.class, "UnstructuredAbapType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(codeValueEClass, CodeValue.class, "CodeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCodeValue_Value(), theEcorePackage.getEString(), "value", null, 1, 1, CodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getCodeValue_Description(), theLocalizationPackage.getTranslatableText(), null, "description", null, 1, 1, CodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getCodeValue_Type(), this.getAbapPrimtiveType(), null, "type", null, 1, 1, CodeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(codeEClass, Code.class, "Code", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getCode_Extensible(), theEcorePackage.getEBoolean(), "extensible", null, 1, 1, Code.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getCode_Values(), this.getCodeValue(), null, "values", null, 0, -1, Code.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(dataElementEClass, DataElement.class, "DataElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDataElement_AbapType(), this.getAbapPrimtiveType(), null, "abapType", null, 1, 1, DataElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abapTypeEClass, AbapType.class, "AbapType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAbapType_Name(), theEcorePackage.getEString(), "name", null, 1, 1, AbapType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAbapType_XsdRepresentation(), this.getXsdType(), null, "xsdRepresentation", null, 1, 1, AbapType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abapStructureTypeEClass, AbapStructureType.class, "AbapStructureType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAbapStructureType_Fields(), this.getAbapStructureField(), null, "fields", null, 0, -1, AbapStructureType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abapStructureFieldEClass, AbapStructureField.class, "AbapStructureField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAbapStructureField_Name(), theEcorePackage.getEString(), "name", null, 1, 1, AbapStructureField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAbapStructureField_Type(), this.getAbapType(), null, "type", null, 1, 1, AbapStructureField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(abapPrimtiveTypeEClass, AbapPrimtiveType.class, "AbapPrimtiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAbapPrimtiveType_Length(), theEcorePackage.getEInt(), "length", null, 1, 1, AbapPrimtiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Create annotations
        // http://www.eclipse.org/emf/2002/Ecore
        createEcoreAnnotations();
        // http://de.hpi.sam.bp2009.OCL
        createDeAnnotations();
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
          (codeEClass, 
           source, 
           new String[] {
             "constraints", "TypeOfValuesEqualsAbapType"
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
          (codeEClass, 
           source, 
           new String[] {
             "TypeOfValuesEqualsAbapType", "self.values->forAll(cv:CodeValue |\r\n      cv.type = self.abapType)"
           });	
    }

} //AbapdictionaryPackageImpl
