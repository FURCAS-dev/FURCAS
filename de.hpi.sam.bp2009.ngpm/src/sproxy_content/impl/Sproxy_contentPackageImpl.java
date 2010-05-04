/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.impl;

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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

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

import runtime.testwithroles.TestwithrolesPackage;

import runtime.testwithroles.impl.TestwithrolesPackageImpl;

import sproxy_content.Action;
import sproxy_content.Aggregation;
import sproxy_content.Association;
import sproxy_content.AssociationProperties;
import sproxy_content.Attribute;
import sproxy_content.BONode;
import sproxy_content.Cardinality;
import sproxy_content.DataType;
import sproxy_content.Element;
import sproxy_content.Field;
import sproxy_content.FieldProperties;
import sproxy_content.InboundProcessAgent;
import sproxy_content.LanguageDependentText;
import sproxy_content.NodeProperties;
import sproxy_content.Operation;
import sproxy_content.OperationProperties;
import sproxy_content.OutboundProcessAgent;
import sproxy_content.Population;
import sproxy_content.ProcessAgent;
import sproxy_content.Query;
import sproxy_content.ServiceInterface;
import sproxy_content.ServiceInterfaceOperation;
import sproxy_content.Sproxy_contentFactory;
import sproxy_content.Sproxy_contentPackage;
import sproxy_content.StatusAndActionSchema;
import sproxy_content.StatusDerivator;

import sproxy_content.util.Sproxy_contentValidator;

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
public class Sproxy_contentPackageImpl extends EPackageImpl implements Sproxy_contentPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass boEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass boNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dataTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceInterfaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass serviceInterfaceOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass processAgentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outboundProcessAgentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inboundProcessAgentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statusAndActionSchemaEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass doEClass = null;

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
  private EClass operationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statusDerivatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass populationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass aggregationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nodePropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fieldPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fieldEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass languageDependentTextEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum cardinalityEEnum = null;

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
   * @see sproxy_content.Sproxy_contentPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private Sproxy_contentPackageImpl()
  {
    super(eNS_URI, Sproxy_contentFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link Sproxy_contentPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static Sproxy_contentPackage init()
  {
    if (isInited) return (Sproxy_contentPackage)EPackage.Registry.INSTANCE.getEPackage(Sproxy_contentPackage.eNS_URI);

    // Obtain or create and register package
    Sproxy_contentPackageImpl theSproxy_contentPackage = (Sproxy_contentPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Sproxy_contentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Sproxy_contentPackageImpl());

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
    TestwithrolesPackageImpl theTestwithrolesPackage = (TestwithrolesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TestwithrolesPackage.eNS_URI) instanceof TestwithrolesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TestwithrolesPackage.eNS_URI) : TestwithrolesPackage.eINSTANCE);
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
    AbapmappingPackageImpl theAbapmappingPackage = (AbapmappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) instanceof AbapmappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) : AbapmappingPackage.eINSTANCE);
    AbapdictionaryPackageImpl theAbapdictionaryPackage = (AbapdictionaryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) instanceof AbapdictionaryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) : AbapdictionaryPackage.eINSTANCE);
    persistence.actions.impl.ActionsPackageImpl theActionsPackage_1 = (persistence.actions.impl.ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) instanceof persistence.actions.impl.ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) : persistence.actions.ActionsPackage.eINSTANCE);
    persistence.expressions.impl.ExpressionsPackageImpl theExpressionsPackage_1 = (persistence.expressions.impl.ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) instanceof persistence.expressions.impl.ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) : persistence.expressions.ExpressionsPackage.eINSTANCE);

    // Create package meta-data objects
    theSproxy_contentPackage.createPackageContents();
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
    theTestwithrolesPackage.createPackageContents();
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
    theAbapmappingPackage.createPackageContents();
    theAbapdictionaryPackage.createPackageContents();
    theActionsPackage_1.createPackageContents();
    theExpressionsPackage_1.createPackageContents();

    // Initialize created meta-data
    theSproxy_contentPackage.initializePackageContents();
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
    theTestwithrolesPackage.initializePackageContents();
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
    theAbapmappingPackage.initializePackageContents();
    theAbapdictionaryPackage.initializePackageContents();
    theActionsPackage_1.initializePackageContents();
    theExpressionsPackage_1.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put
      (theSproxy_contentPackage, 
       new EValidator.Descriptor()
       {
         public EValidator getEValidator()
         {
           return Sproxy_contentValidator.INSTANCE;
         }
       });

    // Mark meta-data to indicate it can't be changed
    theSproxy_contentPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(Sproxy_contentPackage.eNS_URI, theSproxy_contentPackage);
    return theSproxy_contentPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBO()
  {
    return boEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBO_RootNode()
  {
    return (EReference)boEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBO_StatusDerivators()
  {
    return (EReference)boEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBO_Template()
  {
    return (EReference)boEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBO_Projections()
  {
    return (EReference)boEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBONode()
  {
    return boNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_NodeDataType()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_Bo()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_Actions()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_StatusAndActionSchemas()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_Association()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_OutboundAssociations()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_Queries()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_Properties()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBONode_FieldProperties()
  {
    return (EReference)boNodeEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDataType()
  {
    return dataTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataType_Elements()
  {
    return (EReference)dataTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataType_Attributes()
  {
    return (EReference)dataTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDataType_AbapType()
  {
    return (EReference)dataTypeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQuery()
  {
    return queryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAction()
  {
    return actionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAction_Cardinality()
  {
    return (EAttribute)actionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceInterface()
  {
    return serviceInterfaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServiceInterface_Operations()
  {
    return (EReference)serviceInterfaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getServiceInterfaceOperation()
  {
    return serviceInterfaceOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServiceInterfaceOperation_RequestMessageType()
  {
    return (EReference)serviceInterfaceOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServiceInterfaceOperation_ResponseMessageType()
  {
    return (EReference)serviceInterfaceOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getServiceInterfaceOperation_FaultMessageType()
  {
    return (EReference)serviceInterfaceOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getProcessAgent()
  {
    return processAgentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutboundProcessAgent()
  {
    return outboundProcessAgentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutboundProcessAgent_OutboundServiceInterface()
  {
    return (EReference)outboundProcessAgentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInboundProcessAgent()
  {
    return inboundProcessAgentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInboundProcessAgent_InboundServiceInterfaces()
  {
    return (EReference)inboundProcessAgentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatusAndActionSchema()
  {
    return statusAndActionSchemaEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatusAndActionSchema_StatusVariables()
  {
    return (EReference)statusAndActionSchemaEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElement()
  {
    return elementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElement_Type()
  {
    return (EReference)elementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_StatusAttribute()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAttribute_AbapType()
  {
    return (EReference)attributeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDO()
  {
    return doEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociation()
  {
    return associationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociation_Composite()
  {
    return (EReference)associationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociation_TargetNode()
  {
    return (EReference)associationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociation_Owner()
  {
    return (EReference)associationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociation_Properties()
  {
    return (EReference)associationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperation()
  {
    return operationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_ParameterType()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_Properties()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatusDerivator()
  {
    return statusDerivatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatusDerivator_Source()
  {
    return (EReference)statusDerivatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatusDerivator_Target()
  {
    return (EReference)statusDerivatorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPopulation()
  {
    return populationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAggregation()
  {
    return aggregationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationProperties()
  {
    return associationPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationProperties_Enabled()
  {
    return (EReference)associationPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationProperties_EnabledFinal()
  {
    return (EReference)associationPropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationProperties_CreateEnabled()
  {
    return (EReference)associationPropertiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationProperties_CreateEnabledFinal()
  {
    return (EReference)associationPropertiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNodeProperties()
  {
    return nodePropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_Enabled()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_EnabledFinal()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_CreateEnabled()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_CreateEnabledFinal()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_UpdateEnabled()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_UpdateEnabledFinal()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_DeleteEnabled()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_DeleteEnabledFinal()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_TransientKey()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNodeProperties_TransientKeyFinal()
  {
    return (EReference)nodePropertiesEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationProperties()
  {
    return operationPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationProperties_Enabled()
  {
    return (EReference)operationPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationProperties_EnabledFinal()
  {
    return (EReference)operationPropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFieldProperties()
  {
    return fieldPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldProperties_Enabled()
  {
    return (EReference)fieldPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldProperties_EnabledFinal()
  {
    return (EReference)fieldPropertiesEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldProperties_Readonly()
  {
    return (EReference)fieldPropertiesEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldProperties_ReadonlyFinal()
  {
    return (EReference)fieldPropertiesEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldProperties_Mandatory()
  {
    return (EReference)fieldPropertiesEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldProperties_MandatoryFinal()
  {
    return (EReference)fieldPropertiesEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFieldProperties_Field()
  {
    return (EReference)fieldPropertiesEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getField()
  {
    return fieldEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getField_Properties()
  {
    return (EReference)fieldEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLanguageDependentText()
  {
    return languageDependentTextEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getCardinality()
  {
    return cardinalityEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sproxy_contentFactory getSproxy_contentFactory()
  {
    return (Sproxy_contentFactory)getEFactoryInstance();
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
    boEClass = createEClass(BO);
    createEReference(boEClass, BO__ROOT_NODE);
    createEReference(boEClass, BO__STATUS_DERIVATORS);
    createEReference(boEClass, BO__TEMPLATE);
    createEReference(boEClass, BO__PROJECTIONS);

    boNodeEClass = createEClass(BO_NODE);
    createEReference(boNodeEClass, BO_NODE__NODE_DATA_TYPE);
    createEReference(boNodeEClass, BO_NODE__BO);
    createEReference(boNodeEClass, BO_NODE__ACTIONS);
    createEReference(boNodeEClass, BO_NODE__STATUS_AND_ACTION_SCHEMAS);
    createEReference(boNodeEClass, BO_NODE__ASSOCIATION);
    createEReference(boNodeEClass, BO_NODE__OUTBOUND_ASSOCIATIONS);
    createEReference(boNodeEClass, BO_NODE__QUERIES);
    createEReference(boNodeEClass, BO_NODE__PROPERTIES);
    createEReference(boNodeEClass, BO_NODE__FIELD_PROPERTIES);

    dataTypeEClass = createEClass(DATA_TYPE);
    createEReference(dataTypeEClass, DATA_TYPE__ELEMENTS);
    createEReference(dataTypeEClass, DATA_TYPE__ATTRIBUTES);
    createEReference(dataTypeEClass, DATA_TYPE__ABAP_TYPE);

    queryEClass = createEClass(QUERY);

    actionEClass = createEClass(ACTION);
    createEAttribute(actionEClass, ACTION__CARDINALITY);

    serviceInterfaceEClass = createEClass(SERVICE_INTERFACE);
    createEReference(serviceInterfaceEClass, SERVICE_INTERFACE__OPERATIONS);

    serviceInterfaceOperationEClass = createEClass(SERVICE_INTERFACE_OPERATION);
    createEReference(serviceInterfaceOperationEClass, SERVICE_INTERFACE_OPERATION__REQUEST_MESSAGE_TYPE);
    createEReference(serviceInterfaceOperationEClass, SERVICE_INTERFACE_OPERATION__RESPONSE_MESSAGE_TYPE);
    createEReference(serviceInterfaceOperationEClass, SERVICE_INTERFACE_OPERATION__FAULT_MESSAGE_TYPE);

    processAgentEClass = createEClass(PROCESS_AGENT);

    outboundProcessAgentEClass = createEClass(OUTBOUND_PROCESS_AGENT);
    createEReference(outboundProcessAgentEClass, OUTBOUND_PROCESS_AGENT__OUTBOUND_SERVICE_INTERFACE);

    inboundProcessAgentEClass = createEClass(INBOUND_PROCESS_AGENT);
    createEReference(inboundProcessAgentEClass, INBOUND_PROCESS_AGENT__INBOUND_SERVICE_INTERFACES);

    statusAndActionSchemaEClass = createEClass(STATUS_AND_ACTION_SCHEMA);
    createEReference(statusAndActionSchemaEClass, STATUS_AND_ACTION_SCHEMA__STATUS_VARIABLES);

    elementEClass = createEClass(ELEMENT);
    createEReference(elementEClass, ELEMENT__TYPE);

    attributeEClass = createEClass(ATTRIBUTE);
    createEReference(attributeEClass, ATTRIBUTE__STATUS_ATTRIBUTE);
    createEReference(attributeEClass, ATTRIBUTE__ABAP_TYPE);

    doEClass = createEClass(DO);

    associationEClass = createEClass(ASSOCIATION);
    createEReference(associationEClass, ASSOCIATION__COMPOSITE);
    createEReference(associationEClass, ASSOCIATION__TARGET_NODE);
    createEReference(associationEClass, ASSOCIATION__OWNER);
    createEReference(associationEClass, ASSOCIATION__PROPERTIES);

    operationEClass = createEClass(OPERATION);
    createEReference(operationEClass, OPERATION__PARAMETER_TYPE);
    createEReference(operationEClass, OPERATION__PROPERTIES);

    statusDerivatorEClass = createEClass(STATUS_DERIVATOR);
    createEReference(statusDerivatorEClass, STATUS_DERIVATOR__SOURCE);
    createEReference(statusDerivatorEClass, STATUS_DERIVATOR__TARGET);

    populationEClass = createEClass(POPULATION);

    aggregationEClass = createEClass(AGGREGATION);

    associationPropertiesEClass = createEClass(ASSOCIATION_PROPERTIES);
    createEReference(associationPropertiesEClass, ASSOCIATION_PROPERTIES__ENABLED);
    createEReference(associationPropertiesEClass, ASSOCIATION_PROPERTIES__ENABLED_FINAL);
    createEReference(associationPropertiesEClass, ASSOCIATION_PROPERTIES__CREATE_ENABLED);
    createEReference(associationPropertiesEClass, ASSOCIATION_PROPERTIES__CREATE_ENABLED_FINAL);

    nodePropertiesEClass = createEClass(NODE_PROPERTIES);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__ENABLED);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__ENABLED_FINAL);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__CREATE_ENABLED);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__CREATE_ENABLED_FINAL);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__UPDATE_ENABLED);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__UPDATE_ENABLED_FINAL);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__DELETE_ENABLED);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__DELETE_ENABLED_FINAL);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__TRANSIENT_KEY);
    createEReference(nodePropertiesEClass, NODE_PROPERTIES__TRANSIENT_KEY_FINAL);

    operationPropertiesEClass = createEClass(OPERATION_PROPERTIES);
    createEReference(operationPropertiesEClass, OPERATION_PROPERTIES__ENABLED);
    createEReference(operationPropertiesEClass, OPERATION_PROPERTIES__ENABLED_FINAL);

    fieldPropertiesEClass = createEClass(FIELD_PROPERTIES);
    createEReference(fieldPropertiesEClass, FIELD_PROPERTIES__ENABLED);
    createEReference(fieldPropertiesEClass, FIELD_PROPERTIES__ENABLED_FINAL);
    createEReference(fieldPropertiesEClass, FIELD_PROPERTIES__READONLY);
    createEReference(fieldPropertiesEClass, FIELD_PROPERTIES__READONLY_FINAL);
    createEReference(fieldPropertiesEClass, FIELD_PROPERTIES__MANDATORY);
    createEReference(fieldPropertiesEClass, FIELD_PROPERTIES__MANDATORY_FINAL);
    createEReference(fieldPropertiesEClass, FIELD_PROPERTIES__FIELD);

    fieldEClass = createEClass(FIELD);
    createEReference(fieldEClass, FIELD__PROPERTIES);

    languageDependentTextEClass = createEClass(LANGUAGE_DEPENDENT_TEXT);

    // Create enums
    cardinalityEEnum = createEEnum(CARDINALITY);
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

    // Obtain other dependent packages
    ModelmanagementPackage theModelmanagementPackage = (ModelmanagementPackage)EPackage.Registry.INSTANCE.getEPackage(ModelmanagementPackage.eNS_URI);
    AbapdictionaryPackage theAbapdictionaryPackage = (AbapdictionaryPackage)EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI);
    runtime.primitivetypes.PrimitivetypesPackage thePrimitivetypesPackage_1 = (runtime.primitivetypes.PrimitivetypesPackage)EPackage.Registry.INSTANCE.getEPackage(runtime.primitivetypes.PrimitivetypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    boEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    boNodeEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    dataTypeEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    queryEClass.getESuperTypes().add(this.getOperation());
    actionEClass.getESuperTypes().add(this.getOperation());
    serviceInterfaceEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    serviceInterfaceOperationEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    processAgentEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    outboundProcessAgentEClass.getESuperTypes().add(this.getProcessAgent());
    inboundProcessAgentEClass.getESuperTypes().add(this.getProcessAgent());
    statusAndActionSchemaEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    elementEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    elementEClass.getESuperTypes().add(this.getField());
    attributeEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    attributeEClass.getESuperTypes().add(this.getField());
    doEClass.getESuperTypes().add(this.getBO());
    doEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    operationEClass.getESuperTypes().add(theModelmanagementPackage.getNamedElement());
    populationEClass.getESuperTypes().add(this.getStatusDerivator());
    aggregationEClass.getESuperTypes().add(this.getStatusDerivator());

    // Initialize classes and features; add operations and parameters
    initEClass(boEClass, sproxy_content.BO.class, "BO", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBO_RootNode(), this.getBONode(), this.getBONode_Bo(), "rootNode", null, 1, 1, sproxy_content.BO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBO_StatusDerivators(), this.getStatusDerivator(), null, "statusDerivators", null, 0, -1, sproxy_content.BO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBO_Template(), this.getBO(), this.getBO_Projections(), "template", null, 0, 1, sproxy_content.BO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBO_Projections(), this.getBO(), this.getBO_Template(), "projections", null, 0, -1, sproxy_content.BO.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(boNodeEClass, BONode.class, "BONode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBONode_NodeDataType(), this.getDataType(), null, "nodeDataType", null, 1, 1, BONode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBONode_Bo(), this.getBO(), this.getBO_RootNode(), "bo", null, 0, 1, BONode.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBONode_Actions(), this.getAction(), null, "actions", null, 0, -1, BONode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBONode_StatusAndActionSchemas(), this.getStatusAndActionSchema(), null, "statusAndActionSchemas", null, 0, -1, BONode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBONode_Association(), this.getAssociation(), this.getAssociation_TargetNode(), "association", null, 0, -1, BONode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBONode_OutboundAssociations(), this.getAssociation(), this.getAssociation_Owner(), "outboundAssociations", null, 0, -1, BONode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBONode_Queries(), this.getQuery(), null, "queries", null, 0, -1, BONode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBONode_Properties(), this.getNodeProperties(), null, "properties", null, 1, 1, BONode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBONode_FieldProperties(), this.getFieldProperties(), null, "fieldProperties", null, 0, -1, BONode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDataType_Elements(), this.getElement(), null, "elements", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataType_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDataType_AbapType(), theAbapdictionaryPackage.getAbapType(), null, "abapType", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(queryEClass, Query.class, "Query", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAction_Cardinality(), this.getCardinality(), "cardinality", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(serviceInterfaceEClass, ServiceInterface.class, "ServiceInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getServiceInterface_Operations(), this.getServiceInterfaceOperation(), null, "operations", null, 0, -1, ServiceInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(serviceInterfaceOperationEClass, ServiceInterfaceOperation.class, "ServiceInterfaceOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getServiceInterfaceOperation_RequestMessageType(), this.getDataType(), null, "requestMessageType", null, 1, 1, ServiceInterfaceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getServiceInterfaceOperation_ResponseMessageType(), this.getDataType(), null, "responseMessageType", null, 1, 1, ServiceInterfaceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getServiceInterfaceOperation_FaultMessageType(), this.getDataType(), null, "faultMessageType", null, 0, 1, ServiceInterfaceOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(processAgentEClass, ProcessAgent.class, "ProcessAgent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(outboundProcessAgentEClass, OutboundProcessAgent.class, "OutboundProcessAgent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutboundProcessAgent_OutboundServiceInterface(), this.getServiceInterface(), null, "outboundServiceInterface", null, 1, 1, OutboundProcessAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inboundProcessAgentEClass, InboundProcessAgent.class, "InboundProcessAgent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInboundProcessAgent_InboundServiceInterfaces(), this.getServiceInterface(), null, "inboundServiceInterfaces", null, 1, -1, InboundProcessAgent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statusAndActionSchemaEClass, StatusAndActionSchema.class, "StatusAndActionSchema", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatusAndActionSchema_StatusVariables(), this.getAttribute(), null, "statusVariables", null, 0, -1, StatusAndActionSchema.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElement_Type(), this.getDataType(), null, "type", null, 1, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAttribute_StatusAttribute(), thePrimitivetypesPackage_1.getBoolean(), null, "statusAttribute", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAttribute_AbapType(), theAbapdictionaryPackage.getUnstructuredAbapType(), null, "abapType", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(doEClass, sproxy_content.DO.class, "DO", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssociation_Composite(), thePrimitivetypesPackage_1.getBoolean(), null, "composite", null, 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociation_TargetNode(), this.getBONode(), this.getBONode_Association(), "targetNode", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociation_Owner(), this.getBONode(), this.getBONode_OutboundAssociations(), "owner", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociation_Properties(), this.getAssociationProperties(), null, "properties", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperation_ParameterType(), this.getDataType(), null, "parameterType", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_Properties(), this.getOperationProperties(), null, "properties", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statusDerivatorEClass, StatusDerivator.class, "StatusDerivator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatusDerivator_Source(), this.getAttribute(), null, "source", null, 1, 1, StatusDerivator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStatusDerivator_Target(), this.getAttribute(), null, "target", null, 1, 1, StatusDerivator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(populationEClass, Population.class, "Population", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(aggregationEClass, Aggregation.class, "Aggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(associationPropertiesEClass, AssociationProperties.class, "AssociationProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssociationProperties_Enabled(), thePrimitivetypesPackage_1.getBoolean(), null, "enabled", null, 0, 1, AssociationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociationProperties_EnabledFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "enabledFinal", null, 0, 1, AssociationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociationProperties_CreateEnabled(), thePrimitivetypesPackage_1.getBoolean(), null, "createEnabled", null, 0, 1, AssociationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssociationProperties_CreateEnabledFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "createEnabledFinal", null, 0, 1, AssociationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nodePropertiesEClass, NodeProperties.class, "NodeProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNodeProperties_Enabled(), thePrimitivetypesPackage_1.getBoolean(), null, "enabled", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_EnabledFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "enabledFinal", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_CreateEnabled(), thePrimitivetypesPackage_1.getBoolean(), null, "createEnabled", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_CreateEnabledFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "createEnabledFinal", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_UpdateEnabled(), thePrimitivetypesPackage_1.getBoolean(), null, "updateEnabled", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_UpdateEnabledFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "updateEnabledFinal", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_DeleteEnabled(), thePrimitivetypesPackage_1.getBoolean(), null, "deleteEnabled", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_DeleteEnabledFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "deleteEnabledFinal", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_TransientKey(), thePrimitivetypesPackage_1.getBoolean(), null, "transientKey", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNodeProperties_TransientKeyFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "transientKeyFinal", null, 0, 1, NodeProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationPropertiesEClass, OperationProperties.class, "OperationProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperationProperties_Enabled(), thePrimitivetypesPackage_1.getBoolean(), null, "enabled", null, 0, 1, OperationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationProperties_EnabledFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "enabledFinal", null, 0, 1, OperationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fieldPropertiesEClass, FieldProperties.class, "FieldProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFieldProperties_Enabled(), thePrimitivetypesPackage_1.getBoolean(), null, "enabled", null, 0, 1, FieldProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldProperties_EnabledFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "enabledFinal", null, 0, 1, FieldProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldProperties_Readonly(), thePrimitivetypesPackage_1.getBoolean(), null, "readonly", null, 0, 1, FieldProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldProperties_ReadonlyFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "readonlyFinal", null, 0, 1, FieldProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldProperties_Mandatory(), thePrimitivetypesPackage_1.getBoolean(), null, "mandatory", null, 0, 1, FieldProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldProperties_MandatoryFinal(), thePrimitivetypesPackage_1.getBoolean(), null, "mandatoryFinal", null, 0, 1, FieldProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFieldProperties_Field(), this.getField(), this.getField_Properties(), "field", null, 1, 1, FieldProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fieldEClass, Field.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getField_Properties(), this.getFieldProperties(), this.getFieldProperties_Field(), "properties", null, 0, -1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(languageDependentTextEClass, LanguageDependentText.class, "LanguageDependentText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Initialize enums and add enum literals
    initEEnum(cardinalityEEnum, Cardinality.class, "Cardinality");
    addEEnumLiteral(cardinalityEEnum, Cardinality.ZERO);
    addEEnumLiteral(cardinalityEEnum, Cardinality.ONE);
    addEEnumLiteral(cardinalityEEnum, Cardinality.TWO);
    addEEnumLiteral(cardinalityEEnum, Cardinality.MANY);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
    // http://schema.omg.org/spec/MOF/2.0/emof.xml
    createEmofAnnotations();
    // http://de.hpi.sam.bp2009.OCL
    createDeAnnotations();
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
    addAnnotation
      (boNodeEClass, 
       source, 
       new String[] 
       {
       "constraints", "EitherRootOrChild"
       });																			
    addAnnotation
      (statusAndActionSchemaEClass, 
       source, 
       new String[] 
       {
       "constraints", "CanOnlyUseStatusAttributes"
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
      (getBO_StatusDerivators(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });					
    addAnnotation
      (getBONode_NodeDataType(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBONode_Actions(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBONode_StatusAndActionSchemas(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBONode_Queries(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBONode_Properties(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getBONode_FieldProperties(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });			
    addAnnotation
      (getDataType_Elements(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getDataType_Attributes(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getDataType_AbapType(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getServiceInterface_Operations(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getServiceInterfaceOperation_RequestMessageType(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getServiceInterfaceOperation_ResponseMessageType(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getServiceInterfaceOperation_FaultMessageType(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getOutboundProcessAgent_OutboundServiceInterface(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getInboundProcessAgent_InboundServiceInterfaces(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });				
    addAnnotation
      (getStatusAndActionSchema_StatusVariables(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });			
    addAnnotation
      (getElement_Type(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });			
    addAnnotation
      (getAttribute_AbapType(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });			
    addAnnotation
      (getAssociation_Properties(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getOperation_ParameterType(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getOperation_Properties(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getStatusDerivator_Source(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getStatusDerivator_Target(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });
  }

  /**
   * Initializes the annotations for <b>http://de.hpi.sam.bp2009.OCL</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createDeAnnotations()
  {
    String source = "http://de.hpi.sam.bp2009.OCL";						
    addAnnotation
      (boNodeEClass, 
       source, 
       new String[] 
       {
       "EitherRootOrChild", "self.bo->isEmpty() implies self.association->exists(a:Association | a.composite)"
       });																			
    addAnnotation
      (statusAndActionSchemaEClass, 
       source, 
       new String[] 
       {
       "CanOnlyUseStatusAttributes", "self.statusVariables->forAll(a:Attribute | a.statusAttribute)"
       });												
  }

} //Sproxy_contentPackageImpl
