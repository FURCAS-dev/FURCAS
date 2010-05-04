/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package runtime.testwithroles.impl;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import primitivetypes.PrimitivetypesPackage;

import primitivetypes.impl.PrimitivetypesPackageImpl;

import reflect.ReflectPackage;

import reflect.impl.ReflectPackageImpl;

import reflection.ReflectionPackage;

import reflection.impl.ReflectionPackageImpl;

import runtime.configuration2.Configuration2Package;

import runtime.configuration2.impl.Configuration2PackageImpl;

import runtime.enumerations.EnumerationsPackage;

import runtime.enumerations.impl.EnumerationsPackageImpl;

import runtime.testwithpolymorphicassociations.TestwithpolymorphicassociationsPackage;

import runtime.testwithpolymorphicassociations.impl.TestwithpolymorphicassociationsPackageImpl;

import runtime.testwithroles.Address;
import runtime.testwithroles.BankAccount;
import runtime.testwithroles.BusinessPartner;
import runtime.testwithroles.Customer;
import runtime.testwithroles.Employee;
import runtime.testwithroles.Employer;
import runtime.testwithroles.SalesOrder;
import runtime.testwithroles.Supplier;
import runtime.testwithroles.TestwithrolesFactory;
import runtime.testwithroles.TestwithrolesPackage;
import runtime.testwithroles.WorkAgreement;

import sproxy_content.Sproxy_contentPackage;

import sproxy_content.impl.Sproxy_contentPackageImpl;

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
public class TestwithrolesPackageImpl extends EPackageImpl implements TestwithrolesPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass businessPartnerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass salesOrderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bankAccountEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass workAgreementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass addressEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass employeeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass customerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass supplierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass employerEClass = null;

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
   * @see runtime.testwithroles.TestwithrolesPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TestwithrolesPackageImpl()
  {
    super(eNS_URI, TestwithrolesFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TestwithrolesPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TestwithrolesPackage init()
  {
    if (isInited) return (TestwithrolesPackage)EPackage.Registry.INSTANCE.getEPackage(TestwithrolesPackage.eNS_URI);

    // Obtain or create and register package
    TestwithrolesPackageImpl theTestwithrolesPackage = (TestwithrolesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TestwithrolesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TestwithrolesPackageImpl());

    isInited = true;

    // Obtain or create and register interdependencies
    ReflectionPackageImpl theReflectionPackage = (ReflectionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReflectionPackage.eNS_URI) instanceof ReflectionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReflectionPackage.eNS_URI) : ReflectionPackage.eINSTANCE);
    PrimitivetypesPackageImpl thePrimitivetypesPackage = (PrimitivetypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI) instanceof PrimitivetypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI) : PrimitivetypesPackage.eINSTANCE);
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
    runtime.primitivetypes.impl.PrimitivetypesPackageImpl thePrimitivetypesPackage_1 = (runtime.primitivetypes.impl.PrimitivetypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(runtime.primitivetypes.PrimitivetypesPackage.eNS_URI) instanceof runtime.primitivetypes.impl.PrimitivetypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(runtime.primitivetypes.PrimitivetypesPackage.eNS_URI) : runtime.primitivetypes.PrimitivetypesPackage.eINSTANCE);
    EnumerationsPackageImpl theEnumerationsPackage = (EnumerationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EnumerationsPackage.eNS_URI) instanceof EnumerationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EnumerationsPackage.eNS_URI) : EnumerationsPackage.eINSTANCE);
    TestwithpolymorphicassociationsPackageImpl theTestwithpolymorphicassociationsPackage = (TestwithpolymorphicassociationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestwithpolymorphicassociationsPackage.eNS_URI) instanceof TestwithpolymorphicassociationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestwithpolymorphicassociationsPackage.eNS_URI) : TestwithpolymorphicassociationsPackage.eINSTANCE);
    Configuration2PackageImpl theConfiguration2Package = (Configuration2PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Configuration2Package.eNS_URI) instanceof Configuration2PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Configuration2Package.eNS_URI) : Configuration2Package.eINSTANCE);
    Data_bindingPackageImpl theData_bindingPackage = (Data_bindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Data_bindingPackage.eNS_URI) instanceof Data_bindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Data_bindingPackage.eNS_URI) : Data_bindingPackage.eINSTANCE);
    TemplatesPackageImpl theTemplatesPackage = (TemplatesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) instanceof TemplatesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI) : TemplatesPackage.eINSTANCE);
    BusinessconfigurationPackageImpl theBusinessconfigurationPackage = (BusinessconfigurationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BusinessconfigurationPackage.eNS_URI) instanceof BusinessconfigurationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BusinessconfigurationPackage.eNS_URI) : BusinessconfigurationPackage.eINSTANCE);
    ExperimentalPackageImpl theExperimentalPackage = (ExperimentalPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExperimentalPackage.eNS_URI) instanceof ExperimentalPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExperimentalPackage.eNS_URI) : ExperimentalPackage.eINSTANCE);
    Context_driversPackageImpl theContext_driversPackage = (Context_driversPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Context_driversPackage.eNS_URI) instanceof Context_driversPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Context_driversPackage.eNS_URI) : Context_driversPackage.eINSTANCE);
    ProcessintegrationPackageImpl theProcessintegrationPackage = (ProcessintegrationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProcessintegrationPackage.eNS_URI) instanceof ProcessintegrationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProcessintegrationPackage.eNS_URI) : ProcessintegrationPackage.eINSTANCE);
    XsdPackageImpl theXsdPackage = (XsdPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(XsdPackage.eNS_URI) instanceof XsdPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(XsdPackage.eNS_URI) : XsdPackage.eINSTANCE);
    BindingPackageImpl theBindingPackage = (BindingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) instanceof BindingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BindingPackage.eNS_URI) : BindingPackage.eINSTANCE);
    LocalizationPackageImpl theLocalizationPackage = (LocalizationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LocalizationPackage.eNS_URI) instanceof LocalizationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LocalizationPackage.eNS_URI) : LocalizationPackage.eINSTANCE);
    ReflectPackageImpl theReflectPackage = (ReflectPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReflectPackage.eNS_URI) instanceof ReflectPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReflectPackage.eNS_URI) : ReflectPackage.eINSTANCE);
    Ap_runtime_constraintsPackageImpl theAp_runtime_constraintsPackage = (Ap_runtime_constraintsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Ap_runtime_constraintsPackage.eNS_URI) instanceof Ap_runtime_constraintsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Ap_runtime_constraintsPackage.eNS_URI) : Ap_runtime_constraintsPackage.eINSTANCE);
    Sproxy_contentPackageImpl theSproxy_contentPackage = (Sproxy_contentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Sproxy_contentPackage.eNS_URI) instanceof Sproxy_contentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Sproxy_contentPackage.eNS_URI) : Sproxy_contentPackage.eINSTANCE);
    AbapmappingPackageImpl theAbapmappingPackage = (AbapmappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) instanceof AbapmappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) : AbapmappingPackage.eINSTANCE);
    AbapdictionaryPackageImpl theAbapdictionaryPackage = (AbapdictionaryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) instanceof AbapdictionaryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) : AbapdictionaryPackage.eINSTANCE);
    persistence.actions.impl.ActionsPackageImpl theActionsPackage_1 = (persistence.actions.impl.ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) instanceof persistence.actions.impl.ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) : persistence.actions.ActionsPackage.eINSTANCE);
    persistence.expressions.impl.ExpressionsPackageImpl theExpressionsPackage_1 = (persistence.expressions.impl.ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) instanceof persistence.expressions.impl.ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) : persistence.expressions.ExpressionsPackage.eINSTANCE);

    // Create package meta-data objects
    theTestwithrolesPackage.createPackageContents();
    theReflectionPackage.createPackageContents();
    thePrimitivetypesPackage.createPackageContents();
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
    thePrimitivetypesPackage_1.createPackageContents();
    theEnumerationsPackage.createPackageContents();
    theTestwithpolymorphicassociationsPackage.createPackageContents();
    theConfiguration2Package.createPackageContents();
    theData_bindingPackage.createPackageContents();
    theTemplatesPackage.createPackageContents();
    theBusinessconfigurationPackage.createPackageContents();
    theExperimentalPackage.createPackageContents();
    theContext_driversPackage.createPackageContents();
    theProcessintegrationPackage.createPackageContents();
    theXsdPackage.createPackageContents();
    theBindingPackage.createPackageContents();
    theLocalizationPackage.createPackageContents();
    theReflectPackage.createPackageContents();
    theAp_runtime_constraintsPackage.createPackageContents();
    theSproxy_contentPackage.createPackageContents();
    theAbapmappingPackage.createPackageContents();
    theAbapdictionaryPackage.createPackageContents();
    theActionsPackage_1.createPackageContents();
    theExpressionsPackage_1.createPackageContents();

    // Initialize created meta-data
    theTestwithrolesPackage.initializePackageContents();
    theReflectionPackage.initializePackageContents();
    thePrimitivetypesPackage.initializePackageContents();
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
    thePrimitivetypesPackage_1.initializePackageContents();
    theEnumerationsPackage.initializePackageContents();
    theTestwithpolymorphicassociationsPackage.initializePackageContents();
    theConfiguration2Package.initializePackageContents();
    theData_bindingPackage.initializePackageContents();
    theTemplatesPackage.initializePackageContents();
    theBusinessconfigurationPackage.initializePackageContents();
    theExperimentalPackage.initializePackageContents();
    theContext_driversPackage.initializePackageContents();
    theProcessintegrationPackage.initializePackageContents();
    theXsdPackage.initializePackageContents();
    theBindingPackage.initializePackageContents();
    theLocalizationPackage.initializePackageContents();
    theReflectPackage.initializePackageContents();
    theAp_runtime_constraintsPackage.initializePackageContents();
    theSproxy_contentPackage.initializePackageContents();
    theAbapmappingPackage.initializePackageContents();
    theAbapdictionaryPackage.initializePackageContents();
    theActionsPackage_1.initializePackageContents();
    theExpressionsPackage_1.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTestwithrolesPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TestwithrolesPackage.eNS_URI, theTestwithrolesPackage);
    return theTestwithrolesPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBusinessPartner()
  {
    return businessPartnerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBusinessPartner_StreetAddress()
  {
    return (EReference)businessPartnerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBusinessPartner_BankAccount()
  {
    return (EReference)businessPartnerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBusinessPartner_Supplier()
  {
    return (EReference)businessPartnerEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBusinessPartner_Customer()
  {
    return (EReference)businessPartnerEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBusinessPartner_Employee()
  {
    return (EReference)businessPartnerEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBusinessPartner_Employer()
  {
    return (EReference)businessPartnerEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSalesOrder()
  {
    return salesOrderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSalesOrder_Buyer()
  {
    return (EReference)salesOrderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSalesOrder_Seller()
  {
    return (EReference)salesOrderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBankAccount()
  {
    return bankAccountEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWorkAgreement()
  {
    return workAgreementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkAgreement_Employer()
  {
    return (EReference)workAgreementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkAgreement_Employee()
  {
    return (EReference)workAgreementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAddress()
  {
    return addressEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmployee()
  {
    return employeeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCustomer()
  {
    return customerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCustomer_SalesOrder()
  {
    return (EReference)customerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSupplier()
  {
    return supplierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSupplier_SalesOrder()
  {
    return (EReference)supplierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEmployer()
  {
    return employerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestwithrolesFactory getTestwithrolesFactory()
  {
    return (TestwithrolesFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    businessPartnerEClass = createEClass(BUSINESS_PARTNER);
    createEReference(businessPartnerEClass, BUSINESS_PARTNER__STREET_ADDRESS);
    createEReference(businessPartnerEClass, BUSINESS_PARTNER__BANK_ACCOUNT);
    createEReference(businessPartnerEClass, BUSINESS_PARTNER__SUPPLIER);
    createEReference(businessPartnerEClass, BUSINESS_PARTNER__CUSTOMER);
    createEReference(businessPartnerEClass, BUSINESS_PARTNER__EMPLOYEE);
    createEReference(businessPartnerEClass, BUSINESS_PARTNER__EMPLOYER);

    salesOrderEClass = createEClass(SALES_ORDER);
    createEReference(salesOrderEClass, SALES_ORDER__BUYER);
    createEReference(salesOrderEClass, SALES_ORDER__SELLER);

    bankAccountEClass = createEClass(BANK_ACCOUNT);

    workAgreementEClass = createEClass(WORK_AGREEMENT);
    createEReference(workAgreementEClass, WORK_AGREEMENT__EMPLOYER);
    createEReference(workAgreementEClass, WORK_AGREEMENT__EMPLOYEE);

    addressEClass = createEClass(ADDRESS);

    employeeEClass = createEClass(EMPLOYEE);

    customerEClass = createEClass(CUSTOMER);
    createEReference(customerEClass, CUSTOMER__SALES_ORDER);

    supplierEClass = createEClass(SUPPLIER);
    createEReference(supplierEClass, SUPPLIER__SALES_ORDER);

    employerEClass = createEClass(EMPLOYER);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(businessPartnerEClass, BusinessPartner.class, "BusinessPartner", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBusinessPartner_StreetAddress(), this.getAddress(), null, "streetAddress", null, 0, 1, BusinessPartner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBusinessPartner_BankAccount(), this.getBankAccount(), null, "BankAccount", null, 0, 1, BusinessPartner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBusinessPartner_Supplier(), this.getSupplier(), null, "Supplier", null, 0, -1, BusinessPartner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBusinessPartner_Customer(), this.getCustomer(), null, "Customer", null, 0, -1, BusinessPartner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBusinessPartner_Employee(), this.getEmployee(), null, "Employee", null, 0, -1, BusinessPartner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBusinessPartner_Employer(), this.getEmployer(), null, "Employer", null, 0, -1, BusinessPartner.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(salesOrderEClass, SalesOrder.class, "SalesOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSalesOrder_Buyer(), this.getCustomer(), this.getCustomer_SalesOrder(), "buyer", null, 1, 1, SalesOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSalesOrder_Seller(), this.getSupplier(), this.getSupplier_SalesOrder(), "seller", null, 1, 1, SalesOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bankAccountEClass, BankAccount.class, "BankAccount", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(workAgreementEClass, WorkAgreement.class, "WorkAgreement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWorkAgreement_Employer(), this.getEmployer(), null, "employer", null, 1, 1, WorkAgreement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWorkAgreement_Employee(), this.getEmployee(), null, "employee", null, 1, 1, WorkAgreement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(addressEClass, Address.class, "Address", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(employeeEClass, Employee.class, "Employee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(customerEClass, Customer.class, "Customer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCustomer_SalesOrder(), this.getSalesOrder(), this.getSalesOrder_Buyer(), "SalesOrder", null, 0, -1, Customer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(supplierEClass, Supplier.class, "Supplier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSupplier_SalesOrder(), this.getSalesOrder(), this.getSalesOrder_Seller(), "SalesOrder", null, 0, -1, Supplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(employerEClass, Employer.class, "Employer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
    // http://schema.omg.org/spec/MOF/2.0/emof.xml
    createEmofAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createEcoreAnnotations()
  {
    String source = "http://www.eclipse.org/emf/2002/Ecore";		
    addAnnotation
      (this, 
       source, 
       new String[] 
       {
       "invocationDelegates", "http://de.hpi.sam.bp2009.OCL",
       "validationDelegates", "http://de.hpi.sam.bp2009.OCL"
       });								
  }

  /**
   * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createEmofAnnotations()
  {
    String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml";			
    addAnnotation
      (getBusinessPartner_StreetAddress(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBusinessPartner_BankAccount(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBusinessPartner_Supplier(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBusinessPartner_Customer(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBusinessPartner_Employee(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBusinessPartner_Employer(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getWorkAgreement_Employer(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getWorkAgreement_Employee(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });
  }

} //TestwithrolesPackageImpl
