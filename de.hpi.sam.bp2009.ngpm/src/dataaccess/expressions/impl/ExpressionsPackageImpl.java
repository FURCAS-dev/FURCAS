/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dataaccess.expressions.impl;

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

import dataaccess.expressions.AsList;
import dataaccess.expressions.AssociationEndNavigationExpression;
import dataaccess.expressions.Conditional;
import dataaccess.expressions.ConditionalExpression;
import dataaccess.expressions.ContentEquals;
import dataaccess.expressions.Equals;
import dataaccess.expressions.Expression;
import dataaccess.expressions.ExpressionWithArgument;
import dataaccess.expressions.ExpressionsFactory;
import dataaccess.expressions.ExpressionsPackage;
import dataaccess.expressions.FunctionCallExpression;
import dataaccess.expressions.Head;
import dataaccess.expressions.Map;
import dataaccess.expressions.MethodCallExpression;
import dataaccess.expressions.NavigationStep;
import dataaccess.expressions.ObjectBasedExpression;
import dataaccess.expressions.ObjectCount;
import dataaccess.expressions.ObjectCreationExpression;
import dataaccess.expressions.Replace;
import dataaccess.expressions.SignatureCallExpression;
import dataaccess.expressions.Tail;
import dataaccess.expressions.Ternary;
import dataaccess.expressions.This;
import dataaccess.expressions.VariableExpression;
import dataaccess.expressions.WithArgument;

import dataaccess.expressions.collectionexpressions.CollectionexpressionsPackage;

import dataaccess.expressions.collectionexpressions.impl.CollectionexpressionsPackageImpl;

import dataaccess.expressions.fp.FpPackage;

import dataaccess.expressions.fp.impl.FpPackageImpl;

import dataaccess.expressions.literals.LiteralsPackage;

import dataaccess.expressions.literals.impl.LiteralsPackageImpl;

import dataaccess.expressions.util.ExpressionsValidator;

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
public class ExpressionsPackageImpl extends EPackageImpl implements ExpressionsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodCallExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectBasedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectCreationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionCallExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass withArgumentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thisEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equalsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass associationEndNavigationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass signatureCallExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass objectCountEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass replaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass navigationStepEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass headEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tailEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ternaryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contentEqualsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionWithArgumentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass mapEClass = null;

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
   * @see dataaccess.expressions.ExpressionsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ExpressionsPackageImpl()
  {
    super(eNS_URI, ExpressionsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ExpressionsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ExpressionsPackage init()
  {
    if (isInited) return (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

    // Obtain or create and register package
    ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpressionsPackageImpl());

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
    Sproxy_contentPackageImpl theSproxy_contentPackage = (Sproxy_contentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Sproxy_contentPackage.eNS_URI) instanceof Sproxy_contentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Sproxy_contentPackage.eNS_URI) : Sproxy_contentPackage.eINSTANCE);
    AbapmappingPackageImpl theAbapmappingPackage = (AbapmappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) instanceof AbapmappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) : AbapmappingPackage.eINSTANCE);
    AbapdictionaryPackageImpl theAbapdictionaryPackage = (AbapdictionaryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) instanceof AbapdictionaryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) : AbapdictionaryPackage.eINSTANCE);
    persistence.actions.impl.ActionsPackageImpl theActionsPackage_1 = (persistence.actions.impl.ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) instanceof persistence.actions.impl.ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) : persistence.actions.ActionsPackage.eINSTANCE);
    persistence.expressions.impl.ExpressionsPackageImpl theExpressionsPackage_1 = (persistence.expressions.impl.ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) instanceof persistence.expressions.impl.ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) : persistence.expressions.ExpressionsPackage.eINSTANCE);

    // Create package meta-data objects
    theExpressionsPackage.createPackageContents();
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
    theSproxy_contentPackage.createPackageContents();
    theAbapmappingPackage.createPackageContents();
    theAbapdictionaryPackage.createPackageContents();
    theActionsPackage_1.createPackageContents();
    theExpressionsPackage_1.createPackageContents();

    // Initialize created meta-data
    theExpressionsPackage.initializePackageContents();
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
    theSproxy_contentPackage.initializePackageContents();
    theAbapmappingPackage.initializePackageContents();
    theAbapdictionaryPackage.initializePackageContents();
    theActionsPackage_1.initializePackageContents();
    theExpressionsPackage_1.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put
      (theExpressionsPackage, 
       new EValidator.Descriptor()
       {
         public EValidator getEValidator()
         {
           return ExpressionsValidator.INSTANCE;
         }
       });

    // Mark meta-data to indicate it can't be changed
    theExpressionsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ExpressionsPackage.eNS_URI, theExpressionsPackage);
    return theExpressionsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_InIterator()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_FromClause()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpression_Template()
  {
    return (EReference)expressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableExpression()
  {
    return variableExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableExpression_Variable()
  {
    return (EReference)variableExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodCallExpression()
  {
    return methodCallExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMethodCallExpression_Asynchronous()
  {
    return (EAttribute)methodCallExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodCallExpression_MethodSignature()
  {
    return (EReference)methodCallExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodCallExpression_CreationExpression()
  {
    return (EReference)methodCallExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectBasedExpression()
  {
    return objectBasedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectBasedExpression_Object()
  {
    return (EReference)objectBasedExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectCreationExpression()
  {
    return objectCreationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectCreationExpression_ClassToInstantiate()
  {
    return (EReference)objectCreationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getObjectCreationExpression_Initializers()
  {
    return (EReference)objectCreationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionCallExpression()
  {
    return functionCallExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFunctionCallExpression_CalledBlock()
  {
    return (EReference)functionCallExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWithArgument()
  {
    return withArgumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWithArgument_Argument()
  {
    return (EReference)withArgumentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThis()
  {
    return thisEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEquals()
  {
    return equalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEquals_Left()
  {
    return (EReference)equalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEquals_Right()
  {
    return (EReference)equalsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssociationEndNavigationExpression()
  {
    return associationEndNavigationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssociationEndNavigationExpression_ToEnd()
  {
    return (EReference)associationEndNavigationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSignatureCallExpression()
  {
    return signatureCallExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSignatureCallExpression_Parameters()
  {
    return (EReference)signatureCallExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getObjectCount()
  {
    return objectCountEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReplace()
  {
    return replaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReplace_Steps()
  {
    return (EReference)replaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReplace_With()
  {
    return (EReference)replaceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNavigationStep()
  {
    return navigationStepEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNavigationStep_Replace()
  {
    return (EReference)navigationStepEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNavigationStep_To()
  {
    return (EReference)navigationStepEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNavigationStep_FilterFunction()
  {
    return (EReference)navigationStepEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHead()
  {
    return headEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTail()
  {
    return tailEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsList()
  {
    return asListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditional()
  {
    return conditionalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditional_Condition()
  {
    return (EReference)conditionalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTernary()
  {
    return ternaryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTernary_FalseExpr()
  {
    return (EReference)ternaryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTernary_TrueExpr()
  {
    return (EReference)ternaryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContentEquals()
  {
    return contentEqualsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionWithArgument()
  {
    return expressionWithArgumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpression()
  {
    return conditionalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMap()
  {
    return mapEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionsFactory getExpressionsFactory()
  {
    return (ExpressionsFactory)getEFactoryInstance();
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
    expressionEClass = createEClass(EXPRESSION);
    createEReference(expressionEClass, EXPRESSION__IN_ITERATOR);
    createEReference(expressionEClass, EXPRESSION__FROM_CLAUSE);
    createEReference(expressionEClass, EXPRESSION__TEMPLATE);

    variableExpressionEClass = createEClass(VARIABLE_EXPRESSION);
    createEReference(variableExpressionEClass, VARIABLE_EXPRESSION__VARIABLE);

    methodCallExpressionEClass = createEClass(METHOD_CALL_EXPRESSION);
    createEAttribute(methodCallExpressionEClass, METHOD_CALL_EXPRESSION__ASYNCHRONOUS);
    createEReference(methodCallExpressionEClass, METHOD_CALL_EXPRESSION__METHOD_SIGNATURE);
    createEReference(methodCallExpressionEClass, METHOD_CALL_EXPRESSION__CREATION_EXPRESSION);

    objectBasedExpressionEClass = createEClass(OBJECT_BASED_EXPRESSION);
    createEReference(objectBasedExpressionEClass, OBJECT_BASED_EXPRESSION__OBJECT);

    objectCreationExpressionEClass = createEClass(OBJECT_CREATION_EXPRESSION);
    createEReference(objectCreationExpressionEClass, OBJECT_CREATION_EXPRESSION__CLASS_TO_INSTANTIATE);
    createEReference(objectCreationExpressionEClass, OBJECT_CREATION_EXPRESSION__INITIALIZERS);

    functionCallExpressionEClass = createEClass(FUNCTION_CALL_EXPRESSION);
    createEReference(functionCallExpressionEClass, FUNCTION_CALL_EXPRESSION__CALLED_BLOCK);

    withArgumentEClass = createEClass(WITH_ARGUMENT);
    createEReference(withArgumentEClass, WITH_ARGUMENT__ARGUMENT);

    thisEClass = createEClass(THIS);

    equalsEClass = createEClass(EQUALS);
    createEReference(equalsEClass, EQUALS__LEFT);
    createEReference(equalsEClass, EQUALS__RIGHT);

    associationEndNavigationExpressionEClass = createEClass(ASSOCIATION_END_NAVIGATION_EXPRESSION);
    createEReference(associationEndNavigationExpressionEClass, ASSOCIATION_END_NAVIGATION_EXPRESSION__TO_END);

    signatureCallExpressionEClass = createEClass(SIGNATURE_CALL_EXPRESSION);
    createEReference(signatureCallExpressionEClass, SIGNATURE_CALL_EXPRESSION__PARAMETERS);

    objectCountEClass = createEClass(OBJECT_COUNT);

    replaceEClass = createEClass(REPLACE);
    createEReference(replaceEClass, REPLACE__STEPS);
    createEReference(replaceEClass, REPLACE__WITH);

    navigationStepEClass = createEClass(NAVIGATION_STEP);
    createEReference(navigationStepEClass, NAVIGATION_STEP__REPLACE);
    createEReference(navigationStepEClass, NAVIGATION_STEP__TO);
    createEReference(navigationStepEClass, NAVIGATION_STEP__FILTER_FUNCTION);

    headEClass = createEClass(HEAD);

    tailEClass = createEClass(TAIL);

    asListEClass = createEClass(AS_LIST);

    conditionalEClass = createEClass(CONDITIONAL);
    createEReference(conditionalEClass, CONDITIONAL__CONDITION);

    ternaryEClass = createEClass(TERNARY);
    createEReference(ternaryEClass, TERNARY__FALSE_EXPR);
    createEReference(ternaryEClass, TERNARY__TRUE_EXPR);

    contentEqualsEClass = createEClass(CONTENT_EQUALS);

    expressionWithArgumentEClass = createEClass(EXPRESSION_WITH_ARGUMENT);

    conditionalExpressionEClass = createEClass(CONDITIONAL_EXPRESSION);

    mapEClass = createEClass(MAP);
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
    LiteralsPackage theLiteralsPackage = (LiteralsPackage)EPackage.Registry.INSTANCE.getEPackage(LiteralsPackage.eNS_URI);
    CollectionexpressionsPackage theCollectionexpressionsPackage = (CollectionexpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(CollectionexpressionsPackage.eNS_URI);
    FpPackage theFpPackage = (FpPackage)EPackage.Registry.INSTANCE.getEPackage(FpPackage.eNS_URI);
    ClassesPackage theClassesPackage = (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);
    QueryPackage theQueryPackage = (QueryPackage)EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI);
    TemplatesPackage theTemplatesPackage = (TemplatesPackage)EPackage.Registry.INSTANCE.getEPackage(TemplatesPackage.eNS_URI);
    PrimitivetypesPackage thePrimitivetypesPackage = (PrimitivetypesPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI);
    ActionsPackage theActionsPackage = (ActionsPackage)EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI);

    // Add subpackages
    getESubpackages().add(theLiteralsPackage);
    getESubpackages().add(theCollectionexpressionsPackage);
    getESubpackages().add(theFpPackage);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    expressionEClass.getESuperTypes().add(theClassesPackage.getTypedElement());
    expressionEClass.getESuperTypes().add(theClassesPackage.getInScope());
    variableExpressionEClass.getESuperTypes().add(this.getExpression());
    methodCallExpressionEClass.getESuperTypes().add(this.getObjectBasedExpression());
    methodCallExpressionEClass.getESuperTypes().add(this.getSignatureCallExpression());
    objectBasedExpressionEClass.getESuperTypes().add(this.getExpression());
    objectCreationExpressionEClass.getESuperTypes().add(this.getExpression());
    functionCallExpressionEClass.getESuperTypes().add(this.getSignatureCallExpression());
    thisEClass.getESuperTypes().add(this.getExpression());
    equalsEClass.getESuperTypes().add(this.getExpression());
    associationEndNavigationExpressionEClass.getESuperTypes().add(this.getObjectBasedExpression());
    signatureCallExpressionEClass.getESuperTypes().add(this.getExpression());
    objectCountEClass.getESuperTypes().add(this.getObjectBasedExpression());
    replaceEClass.getESuperTypes().add(this.getObjectBasedExpression());
    headEClass.getESuperTypes().add(this.getObjectBasedExpression());
    tailEClass.getESuperTypes().add(this.getObjectBasedExpression());
    asListEClass.getESuperTypes().add(this.getObjectBasedExpression());
    ternaryEClass.getESuperTypes().add(this.getConditionalExpression());
    ternaryEClass.getESuperTypes().add(this.getExpression());
    contentEqualsEClass.getESuperTypes().add(this.getEquals());
    expressionWithArgumentEClass.getESuperTypes().add(this.getExpression());
    expressionWithArgumentEClass.getESuperTypes().add(this.getWithArgument());
    conditionalExpressionEClass.getESuperTypes().add(this.getExpression());
    conditionalExpressionEClass.getESuperTypes().add(this.getConditional());
    mapEClass.getESuperTypes().add(this.getExpressionWithArgument());
    mapEClass.getESuperTypes().add(this.getObjectBasedExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpression_InIterator(), theCollectionexpressionsPackage.getIterate(), theCollectionexpressionsPackage.getIterate_IteratorExpression(), "inIterator", null, 0, 1, Expression.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_FromClause(), theQueryPackage.getFromClause(), theQueryPackage.getFromClause_FromExpression(), "fromClause", null, 0, 1, Expression.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpression_Template(), theTemplatesPackage.getStringTemplate(), theTemplatesPackage.getStringTemplate_Expressions(), "template", null, 0, 1, Expression.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(expressionEClass, thePrimitivetypesPackage.getBoolean(), "isSideEffectFree", 0, 1, IS_UNIQUE, IS_ORDERED);

    EOperation op = addEOperation(expressionEClass, thePrimitivetypesPackage.getBoolean(), "evaluatesToEqualAs", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getExpression(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(expressionEClass, theActionsPackage.getIterator(), "getUsedAliases", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(expressionEClass, theClassesPackage.getNamedValue(), "getNamedValuesInScope", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(expressionEClass, this.getExpression(), "getOwningExpression", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(expressionEClass, theClassesPackage.getSapClass(), "getOwningClass", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(variableExpressionEClass, VariableExpression.class, "VariableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableExpression_Variable(), theClassesPackage.getNamedValue(), null, "variable", null, 1, 1, VariableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodCallExpressionEClass, MethodCallExpression.class, "MethodCallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMethodCallExpression_Asynchronous(), thePrimitivetypesPackage.getBoolean(), "asynchronous", null, 0, 1, MethodCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodCallExpression_MethodSignature(), theClassesPackage.getMethodSignature(), null, "methodSignature", null, 1, 1, MethodCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodCallExpression_CreationExpression(), this.getObjectCreationExpression(), this.getObjectCreationExpression_Initializers(), "creationExpression", null, 0, 1, MethodCallExpression.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectBasedExpressionEClass, ObjectBasedExpression.class, "ObjectBasedExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectBasedExpression_Object(), this.getExpression(), null, "object", null, 1, 1, ObjectBasedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(objectCreationExpressionEClass, ObjectCreationExpression.class, "ObjectCreationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getObjectCreationExpression_ClassToInstantiate(), theClassesPackage.getSapClass(), null, "classToInstantiate", null, 1, 1, ObjectCreationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getObjectCreationExpression_Initializers(), this.getMethodCallExpression(), this.getMethodCallExpression_CreationExpression(), "initializers", null, 0, -1, ObjectCreationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionCallExpressionEClass, FunctionCallExpression.class, "FunctionCallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFunctionCallExpression_CalledBlock(), this.getExpression(), null, "calledBlock", null, 1, 1, FunctionCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(withArgumentEClass, WithArgument.class, "WithArgument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWithArgument_Argument(), this.getExpression(), null, "argument", null, 0, 1, WithArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thisEClass, This.class, "This", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(equalsEClass, Equals.class, "Equals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEquals_Left(), this.getExpression(), null, "left", null, 1, 1, Equals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEquals_Right(), this.getExpression(), null, "right", null, 1, 1, Equals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(associationEndNavigationExpressionEClass, AssociationEndNavigationExpression.class, "AssociationEndNavigationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssociationEndNavigationExpression_ToEnd(), theClassesPackage.getAssociationEnd(), null, "toEnd", null, 1, 1, AssociationEndNavigationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(signatureCallExpressionEClass, SignatureCallExpression.class, "SignatureCallExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSignatureCallExpression_Parameters(), this.getExpression(), null, "parameters", null, 0, -1, SignatureCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(signatureCallExpressionEClass, theClassesPackage.getSignature(), "getSignature", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(signatureCallExpressionEClass, theClassesPackage.getMultiplicity(), "getMultiplicityOfCallTarget", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(objectCountEClass, ObjectCount.class, "ObjectCount", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(replaceEClass, Replace.class, "Replace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReplace_Steps(), this.getNavigationStep(), this.getNavigationStep_Replace(), "steps", null, 1, -1, Replace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReplace_With(), this.getExpression(), null, "with", null, 1, 1, Replace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(navigationStepEClass, NavigationStep.class, "NavigationStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNavigationStep_Replace(), this.getReplace(), this.getReplace_Steps(), "replace", null, 1, 1, NavigationStep.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNavigationStep_To(), theClassesPackage.getAssociationEnd(), null, "to", null, 1, 1, NavigationStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNavigationStep_FilterFunction(), this.getExpression(), null, "filterFunction", null, 0, 1, NavigationStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(headEClass, Head.class, "Head", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(tailEClass, Tail.class, "Tail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(asListEClass, AsList.class, "AsList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(conditionalEClass, Conditional.class, "Conditional", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditional_Condition(), this.getExpression(), null, "condition", null, 1, 1, Conditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ternaryEClass, Ternary.class, "Ternary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTernary_FalseExpr(), this.getExpression(), null, "falseExpr", null, 1, 1, Ternary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTernary_TrueExpr(), this.getExpression(), null, "trueExpr", null, 1, 1, Ternary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contentEqualsEClass, ContentEquals.class, "ContentEquals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(expressionWithArgumentEClass, ExpressionWithArgument.class, "ExpressionWithArgument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(conditionalExpressionEClass, ConditionalExpression.class, "ConditionalExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(mapEClass, Map.class, "Map", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
      (expressionEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (expressionEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (expressionEClass.getEOperations().get(2), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (expressionEClass.getEOperations().get(3), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });			
    addAnnotation
      (expressionEClass.getEOperations().get(4), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (expressionEClass.getEOperations().get(5), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (variableExpressionEClass, 
       source, 
       new String[] 
       {
       "constraints", "VariableExpressionType"
       });					
    addAnnotation
      (methodCallExpressionEClass, 
       source, 
       new String[] 
       {
       "constraints", "ObjectMustSupportOperation OutputMultiplicities"
       });							
    addAnnotation
      (objectCreationExpressionEClass, 
       source, 
       new String[] 
       {
       "constraints", "CannotInstantiateAbstractClass ExpressionType HasToOwnTypeDefinition CannotInstantiateValueClass NoDuplicateInitializers"
       });					
    addAnnotation
      (functionCallExpressionEClass, 
       source, 
       new String[] 
       {
       "constraints", "ResultType CalledBlockMustBeFunction"
       });							
    addAnnotation
      (equalsEClass, 
       source, 
       new String[] 
       {
       "constraints", "ConformaceOneWayOrAnother"
       });						
    addAnnotation
      (associationEndNavigationExpressionEClass, 
       source, 
       new String[] 
       {
       "constraints", "ObjectTypeMustMatch ResultType EndMustBeNavigable"
       });				
    addAnnotation
      (signatureCallExpressionEClass, 
       source, 
       new String[] 
       {
       "constraints", "ParametersTypesMustMatchSignatureParametersTypes CallTypeMustMatchSignatureOutput"
       });			
    addAnnotation
      (signatureCallExpressionEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (signatureCallExpressionEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });					
    addAnnotation
      (objectCountEClass, 
       source, 
       new String[] 
       {
       "constraints", "TypeIsNumber MultiplicityIsOne"
       });				
    addAnnotation
      (replaceEClass, 
       source, 
       new String[] 
       {
       "constraints", "SourceObjectIsOfValueType WithTypeConformsToLastStepsType"
       });				
    addAnnotation
      (navigationStepEClass, 
       source, 
       new String[] 
       {
       "constraints", "FromEndAttachesToOutputOfPreviousStep FilterFunctionExpressionHasFunctionType FromEndMustBeEqualityRelevant"
       });					
    addAnnotation
      (headEClass, 
       source, 
       new String[] 
       {
       "constraints", "IsOrdered"
       });			
    addAnnotation
      (tailEClass, 
       source, 
       new String[] 
       {
       "constraints", "IsOrdered"
       });				
    addAnnotation
      (conditionalEClass, 
       source, 
       new String[] 
       {
       "constraints", "ConditionMustBeBoolean"
       });				
    addAnnotation
      (ternaryEClass, 
       source, 
       new String[] 
       {
       "constraints", "TrueAndFalseExprsConformToResultType"
       });						
    addAnnotation
      (contentEqualsEClass, 
       source, 
       new String[] 
       {
       "constraints", "ContentEqualsOnlyForEntities"
       });				
    addAnnotation
      (mapEClass, 
       source, 
       new String[] 
       {
       "constraints", "ObjectTypeMustConformToFunctionArgument ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput MapFunctionMustBeSideEffectFree"
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
      (expressionEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "body", "let parametersAndSignatureAreSideEffectFree:Boolean =    self.oclIsKindOf(SignatureCallExpression) implies      (self.oclAsType(SignatureCallExpression).parameters->forAll(p|p.isSideEffectFree())       and self.oclAsType(SignatureCallExpression).getSignature().sideEffectFree)  in  if self.oclIsKindOf(ObjectBasedExpression) then    self.oclAsType(ObjectBasedExpression).object.isSideEffectFree() and    if self.oclIsKindOf(SignatureCallExpression) then      parametersAndSignatureAreSideEffectFree    else      if self.oclIsKindOf(Replace) then        self.oclAsType(Replace).with.isSideEffectFree()      else        if self.oclIsKindOf(ExpressionWithArgument) and self.oclAsType(ExpressionWithArgument).argument->notEmpty() then          self.oclAsType(ExpressionWithArgument).argument.isSideEffectFree()        else          true        endif      endif    endif  else if self.oclIsKindOf(FunctionCallExpression) then    parametersAndSignatureAreSideEffectFree and self.oclAsType(FunctionCallExpression).calledBlock.isSideEffectFree()  else if self.oclIsKindOf(Equals) then    self.oclAsType(Equals).left.isSideEffectFree() and self.oclAsType(Equals).right.isSideEffectFree()  else if self.oclIsKindOf(ObjectCreationExpression) then    self.oclAsType(ObjectCreationExpression).classToInstantiate.valueType  else if self.oclIsKindOf(DimensionExpression) then    self.oclAsType(DimensionExpression).dimension.ownerSignature.sideEffectFree  else if self.oclIsKindOf(Ternary) then    self.oclAsType(Ternary).condition.isSideEffectFree() and    self.oclAsType(Ternary).trueExpr.isSideEffectFree() and    self.oclAsType(Ternary).falseExpr.isSideEffectFree()  else if self.oclIsKindOf(CollectionExpression) then    self.oclAsType(CollectionExpression).source.isSideEffectFree() and    if self.oclIsKindOf(Iterate) then      (self.oclAsType(Iterate).accumulator.initExpression->notEmpty() implies         self.oclAsType(Iterate).accumulator.initExpression.isSideEffectFree()) and      self.oclAsType(Iterate).iteratorExpression.isSideEffectFree()    else      true    endif  else if self.oclIsKindOf(ObjectLiteral) then    self.oclAsType(ObjectLiteral).propertyValues.value->forAll(v|v.isSideEffectFree())  else if self.oclIsKindOf(All) or self.oclIsKindOf(Replace) or self.oclIsKindOf(This) or self.oclIsKindOf(VariableExpression) or  self.oclIsKindOf(Literal) or self.oclIsKindOf(AnonymousFunctionExpr) then    true  else if self.oclIsKindOf(Selection) then    self.oclAsType(Selection).object.isSideEffectFree()  else    false  endif  endif  endif  endif  endif  endif  endif  endif  endif  endif"
       });				
    addAnnotation
      (expressionEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "body", "if self=e then    true  else  if self.oclIsKindOf(NumberLiteral) and e.oclIsKindOf(NumberLiteral) then    self.oclAsType(NumberLiteral).literal=e.oclAsType(NumberLiteral).literal  else    if self.oclIsKindOf(StringLiteral) and e.oclIsKindOf(StringLiteral) then      self.oclAsType(StringLiteral).literal=e.oclAsType(StringLiteral).literal    else      if self.oclIsKindOf(ObjectLiteral) and e.oclIsKindOf(ObjectLiteral) then        self.oclAsType(ObjectLiteral).isEqualTo(e.oclAsType(ObjectLiteral))      else        if self.oclIsKindOf(VariableExpression) and e.oclIsKindOf(VariableExpression) then          self.oclAsType(VariableExpression).variable = e.oclAsType(VariableExpression).variable        else          false        endif      endif    endif  endif  endif"
       });				
    addAnnotation
      (expressionEClass.getEOperations().get(2), 
       source, 
       new String[] 
       {
       "body", "if self.oclIsKindOf(VariableExpression) then    if self.oclAsType(VariableExpression).variable.oclIsKindOf(Iterator) then      self.oclAsType(VariableExpression).variable.oclAsType(Iterator)->select(i | i.fromClause->notEmpty())->asSet()    else      Set{}    endif  else    if self.oclIsKindOf(Replace) then      self.oclAsType(Replace).object.getUsedAliases()->union(      self.oclAsType(Replace).steps.filterFunction.getUsedAliases()->flatten()->asSet())->union(      self.oclAsType(Replace).with.getUsedAliases())    else      if self.oclIsKindOf(Selection) then        self.oclAsType(Selection).object.getUsedAliases()->union(        self.oclAsType(Selection).selectionExpr.getUsedAliases())      else        if self.oclIsKindOf(ObjectBasedExpression) then          let objectAliases = self.oclAsType(ObjectBasedExpression).object.getUsedAliases() in          if self.oclIsKindOf(MethodCallExpression) then            objectAliases->union(self.oclAsType(MethodCallExpression).parameters.getUsedAliases()->flatten()->asSet())          else            objectAliases          endif        else          if self.oclIsKindOf(Equals) then            self.oclAsType(Equals).left.getUsedAliases()->union(self.oclAsType(Equals).right.getUsedAliases())          else            if self.oclIsKindOf(FunctionCallExpression) then              self.oclAsType(FunctionCallExpression).calledBlock.getUsedAliases()->union(                           self.oclAsType(FunctionCallExpression).parameters.getUsedAliases()->flatten()->asSet())            else              if self.oclIsKindOf(Ternary) then                let sat = self.oclAsType(Ternary) in                sat.condition.getUsedAliases()->union(sat.trueExpr.getUsedAliases())->union(sat.falseExpr.getUsedAliases())             else                 if self.oclIsKindOf(CollectionExpressionWithArgument) then                  self.oclAsType(CollectionExpressionWithArgument).argument.getUsedAliases()->union(                  self.oclAsType(CollectionExpressionWithArgument).source.getUsedAliases())                else                  if self.oclIsKindOf(Iterate) then                    self.oclAsType(Iterate).iteratorExpression.getUsedAliases()->union(                    self.oclAsType(Iterate).accumulator.initExpression.getUsedAliases())->union(                    self.oclAsType(Iterate).source.getUsedAliases())                  else                    if self.oclIsKindOf(OqlQuery) then                      self.oclAsType(OqlQuery).fromClauses.fromExpression.getUsedAliases()->flatten()->asSet()->union(                      self.oclAsType(OqlQuery).condition.getUsedAliases())                    else                      Set{}                    endif                  endif                endif              endif            endif          endif        endif      endif    endif  endif"
       });				
    addAnnotation
      (expressionEClass.getEOperations().get(3), 
       source, 
       new String[] 
       {
       "body", "self.addNamedValuesWithNewNames(  -- First, collect those NamedValues defined immediately for this expression:  -- an iterate\'s body expression sees the iterators and the accumulator  let accumulator:Set(NamedValue)=self.inIterator.accumulator->asSet() in  let iterators:Set(NamedValue)=self.inIterator.iterators->asSet() in  -- an OQL \"from\" clause sees all aliases left of it  let oqlAliases:Set(NamedValue)=(if self.fromClause->notEmpty() then    let fromClauses = self.fromClause.fromClauseOfOqlQuery.fromClauses in    let fcIndex = fromClauses->indexOf(self.fromClause) in      Sequence{1..-1+fcIndex}->collect(i | fromClauses->at(i).alias)->asSet()  else    Set{}  endif)->union(  -- an OQL \"where\" clause sees all aliases defined by any of the OQL expression\'s \"from\" entries  self.conditionOfOqlQuery.fromClauses.alias->asSet()) in  -- a Selection defines an implicit iterator for its filter expression  let selectionIterator:Set(NamedValue)=self.selection.iterator->asSet() in  -- a GroupBy\'s mapExpression sees all dimension iterators and the groupedFacts iterator  let groupByMapExpressionIterators:Set(NamedValue)=self.mapExpressionOfGroupBy.groupedFacts->asSet()->union(                                                    self.mapExpressionOfGroupBy.dimensions.iterator->asSet()) in  -- a GroupBy\'s dimension expression sees the facts iterator  let groupByDimensionFactIterator:Set(NamedValue)=self.dimension.groupBy.fact->asSet() in  accumulator->union(iterators)->union(oqlAliases)->union(selectionIterator)->union(groupByMapExpressionIterators)->  union(groupByDimensionFactIterator),  -- Then, add those defined by owning structures such as owning statements or owning expressions  -- an expression that is used by an ExpressionStatement or as condition in a Conditional sees all named values that the statement sees  if self.actualObjectParameter.owningClassTypeDefinition->notEmpty() then    self.actualObjectParameter.owningClassTypeDefinition.getNamedValuesInScope()  else    if self.initExpressionFor.namedValueDeclaration->notEmpty() then      self.initExpressionFor.namedValueDeclaration.getNamedValuesInScope()    else      if self.expressionStatement->notEmpty() then        self.expressionStatement.getNamedValuesInScope()      else        if self.conditional->notEmpty() then          if self.conditional.oclIsKindOf(ConditionalStatement) then            self.conditional.oclAsType(ConditionalStatement).getNamedValuesInScope()          else            self.conditional.oclAsType(ConditionalExpression).getNamedValuesInScope()          endif        else          if self.argumentOf->notEmpty() and self.argumentOf.oclIsKindOf(StatementWithArgument) then            self.argumentOf.oclAsType(StatementWithArgument).getNamedValuesInScope()          else            -- add all variables in scope for owning expressions            let oe = self.getOwningExpression() in              if oe->isEmpty() then                Set{}              else                oe.getNamedValuesInScope()              endif          endif        endif      endif    endif  endif  )"
       });			
    addAnnotation
      (expressionEClass.getEOperations().get(4), 
       source, 
       new String[] 
       {
       "body", "let objectBasedExpressions:Set(Expression)=self.objectBasedExpression->asSet() in  let argumentsOf:Set(Expression)=self.argumentOf->select(ao | ao.oclIsKindOf(Expression)).oclAsType(ExpressionWithArgument)->asSet() in  let equals:Set(Expression)=Set{}->union(self.leftOfEquals->asSet())->union(self.rightOfEquals->asSet()) in  let blocksOfFunctionCallExpression:Set(Expression)=self.blockOfFunctionCallExpression->asSet() in  let signatureCalls:Set(Expression)=self.usedAsArgumentInSignatureCall->asSet() in  let creationExpression:Set(Expression)=if self.oclIsKindOf(MethodCallExpression) then    self.oclAsType(MethodCallExpression).creationExpression->asSet()  else    Set{}  endif in  let ternary:Set(Expression)=self.trueOfTernary->asSet()->union(self.falseOfTernary->asSet()) in  let conditional:Set(Expression)=if self.conditional->notEmpty() and self.conditional.oclIsKindOf(ConditionalExpression) then    self.conditional.oclAsType(ConditionalExpression)->asSet()  else    Set{}  endif in  let replace:Set(Expression)=self.withOfReplace->asSet()->union(self.navigationStep.replace->asSet()) in  let oqlQuery:Set(Expression)=self.conditionOfOqlQuery->asSet()->union(self.fromClause.fromClauseOfOqlQuery->asSet()) in  let selection:Set(Expression)=self.selection->asSet() in  let objectLiteral:Set(Expression)=self.valueInit.objectLiteral->asSet() in  let iterator:Set(Expression)=self.inIterator->asSet() in  let collectionExpression:Set(Expression)=self.collectionExpression->asSet() in  let all:Set(Expression)=self.all->asSet() in  let valueInitInObjectLiteral:Set(Expression)=self.valueInit.objectLiteral->asSet() in  let dimensionExpression:Set(Expression)=self.cellSetOfDimensionExpression->asSet()->union(                                                                   self.factsOfDimensionExpression->asSet()) in  let groupByExpression:Set(Expression)=self.dimension.groupBy->asSet()->union(                                                                   self.mapExpressionOfGroupBy->asSet()) in  objectBasedExpressions->union(argumentsOf)->union(equals)->union(blocksOfFunctionCallExpression)->union(  signatureCalls)->union(creationExpression)->union(ternary)->union(conditional)->union(replace)->union(  oqlQuery)->union(selection)->union(objectLiteral)->union(iterator)->union(collectionExpression)->union(  all)->union(valueInitInObjectLiteral)->union(dimensionExpression)->union(groupByExpression)->any(true)"
       });				
    addAnnotation
      (expressionEClass.getEOperations().get(5), 
       source, 
       new String[] 
       {
       "body", "let oe = self.getOwningExpression() in  if oe->notEmpty() then    oe.getOwningClass()  else    if self.expressionStatement->notEmpty() then      self.expressionStatement.getOwningClass()    else      if self.conditional->notEmpty() and self.conditional.oclIsKindOf(Statement) then        self.conditional.oclAsType(ConditionalStatement).getOwningClass()      else        if self.argumentOf->notEmpty() and self.argumentOf.oclIsKindOf(StatementWithArgument) then          self.argumentOf.oclAsType(StatementWithArgument).getOwningClass()        else          if self.initExpressionFor.namedValueDeclaration->notEmpty() then            self.initExpressionFor.namedValueDeclaration.getOwningClass()          else            null          endif        endif      endif    endif  endif"
       });				
    addAnnotation
      (variableExpressionEClass, 
       source, 
       new String[] 
       {
       "VariableExpressionType", "self.getType().conformsTo(self.variable.getType())"
       });					
    addAnnotation
      (methodCallExpressionEClass, 
       source, 
       new String[] 
       {
       "ObjectMustSupportOperation", "self.object.getType().getInnermost().oclIsKindOf(ClassTypeDefinition) and\r\n  self.object.getType().getInnermost().oclAsType(ClassTypeDefinition).clazz.conformsTo(self.methodSignature.owner.oclAsType(SapClass))",
       "OutputMultiplicities", "(self.object.getType().isMany() implies (self.getType().isMany() and not self.getType().unique)) and\r\n  (self.object.getType().lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))"
       });							
    addAnnotation
      (objectCreationExpressionEClass, 
       source, 
       new String[] 
       {
       "CannotInstantiateAbstractClass", "not self.classToInstantiate.isAbstract()",
       "ExpressionType", "self.getType().oclIsKindOf(ClassTypeDefinition) and\r\n  self.getType().oclAsType(ClassTypeDefinition).clazz = self.classToInstantiate and\r\n  self.getType().lowerMultiplicity = 1 and\r\n  self.getType().upperMultiplicity = 1",
       "HasToOwnTypeDefinition", "self.ownedTypeDefinition->notEmpty()",
       "CannotInstantiateValueClass", "not self.classToInstantiate.valueType",
       "NoDuplicateInitializers", "self.initializers->forAll( a, b | a <> b implies a.methodSignature <> b.methodSignature )"
       });					
    addAnnotation
      (functionCallExpressionEClass, 
       source, 
       new String[] 
       {
       "ResultType", "let fstd:FunctionSignatureTypeDefinition = self.calledBlock.getType().getInnermost().oclAsType(FunctionSignatureTypeDefinition) in\r\n\r\n  if fstd.isMany() then\r\n    -- calling multiple functions; test is somewhat fuzzy because it doesn\'t test condormance of nesting structure exactly\r\n    self.getType().isMany() and not self.getType().unique and\r\n    fstd.signature.output.getInnermost().conformsTo(self.getType().getInnermost()) and\r\n    (fstd.lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))\r\n  else\r\n    -- calling a single function\r\n    fstd.signature.output.conformsTo(self.getType()) and \r\n    (fstd.lowerMultiplicity = 0 implies (self.getType()->isEmpty() or self.getType().lowerMultiplicity = 0))\r\n  endif",
       "CalledBlockMustBeFunction", "self.calledBlock.getType().getInnermost().oclIsKindOf(FunctionSignatureTypeDefinition)"
       });							
    addAnnotation
      (equalsEClass, 
       source, 
       new String[] 
       {
       "ConformaceOneWayOrAnother", "self.left.getType().conformsTo(self.right.getType()) or\r\n  self.right.getType().conformsTo(self.left.getType())"
       });						
    addAnnotation
      (associationEndNavigationExpressionEClass, 
       source, 
       new String[] 
       {
       "ObjectTypeMustMatch", "self.object.getType().conformsToIgnoringMultiplicity(self.toEnd.otherEnd().type)",
       "ResultType", "self.getType() = self.toEnd.type",
       "EndMustBeNavigable", "self.toEnd.navigable"
       });				
    addAnnotation
      (signatureCallExpressionEClass, 
       source, 
       new String[] 
       {
       "ParametersTypesMustMatchSignatureParametersTypes", "let numberOfMandatoryParameters =\r\n    self.getSignature().input->select(p|p.defaultValue->isEmpty())->size()\r\n  in\r\n  self.parameters->size() >= numberOfMandatoryParameters and\r\n  self.parameters->size() <= self.getSignature().input->size() and\r\n  self.parameters->forAll(parameter |\r\n    parameter.getType().conformsTo(self.getSignature().input->at(self.parameters->indexOf(parameter)).getType()) )",
       "CallTypeMustMatchSignatureOutput", "if self.getSignature().output.oclIsUndefined() then\r\n        self.getType().oclIsUndefined()\r\n    else \r\n        if self.getMultiplicityOfCallTarget().isMany() and self.getSignature().output.isMany() then\r\n            let ntd = self.getType().oclAsType(NestedTypeDefinition) in\r\n                self.getType().oclIsKindOf(NestedTypeDefinition) and \r\n                ntd.unique = false and\r\n                ntd.ordered = self.getMultiplicityOfCallTarget().ordered and\r\n                ntd.lowerMultiplicity = self.getMultiplicityOfCallTarget().lowerMultiplicity and\r\n                ntd.upperMultiplicity = self.getMultiplicityOfCallTarget().upperMultiplicity and\r\n                self.getSignature().output.conformsTo(ntd.type)\r\n        else\r\n            let target = self.getMultiplicityOfCallTarget() in let output = self.getSignature().output in \r\n                ( output.isMany() implies self.getType().unique = output.unique ) and\r\n                ( ( output.isMany() or target.isMany() ) implies ( self.getType().ordered = (output.ordered or target.ordered) ) ) and\r\n                ( self.getType().lowerMultiplicity = (output.lowerMultiplicity * target.lowerMultiplicity)) and\r\n                ( self.getType().upperMultiplicity = (if output.isMany() or target.isMany() then \r\n                                                        -1 \r\n                                                    else \r\n                                                        output.upperMultiplicity * target.upperMultiplicity \r\n                                                    endif)) and\r\n                self.getType().conformsToIgnoringMultiplicity(output)\r\n        endif\r\n    endif"
       });			
    addAnnotation
      (signatureCallExpressionEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "body", "if self.oclIsKindOf(FunctionCallExpression) then    self.oclAsType(FunctionCallExpression).calledBlock.getType().getInnermost().oclAsType(FunctionSignatureTypeDefinition).signature  else    self.oclAsType(MethodCallExpression).methodSignature  endif"
       });				
    addAnnotation
      (signatureCallExpressionEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "body", "if self.oclIsKindOf(FunctionCallExpression) then      self.oclAsType(FunctionCallExpression).calledBlock.getType()  else      self.oclAsType(MethodCallExpression).object.getType()  endif"
       });					
    addAnnotation
      (objectCountEClass, 
       source, 
       new String[] 
       {
       "TypeIsNumber", "self.getType().oclIsKindOf(ClassTypeDefinition) and\r\n  self.getType().oclAsType(ClassTypeDefinition).clazz.name = \'Number\'",
       "MultiplicityIsOne", "self.getType().upperMultiplicity = 1 and\r\n  self.getType().lowerMultiplicity = 1"
       });				
    addAnnotation
      (replaceEClass, 
       source, 
       new String[] 
       {
       "SourceObjectIsOfValueType", "self.object.getType().oclIsKindOf(ClassTypeDefinition) and\r\n  self.object.getType().oclAsType(ClassTypeDefinition).clazz.valueType",
       "WithTypeConformsToLastStepsType", "self.with.getType().conformsTo(self.steps->at(self.steps->size()).to.type)"
       });				
    addAnnotation
      (navigationStepEClass, 
       source, 
       new String[] 
       {
       "FromEndAttachesToOutputOfPreviousStep", "let i = self.replace.steps->indexOf(self) in\r\n  let t = if i=1 then self.replace.object.getType().oclAsType(ClassTypeDefinition) else self.replace.steps->at(-1 + i).to.type endif in\r\n\r\n  self.to.otherEnd().type.clazz.conformsTo(t.clazz)",
       "FilterFunctionExpressionHasFunctionType", "self.filterFunction->notEmpty() implies self.filterFunction.getType().oclIsKindOf(FunctionSignatureTypeDefinition)",
       "FromEndMustBeEqualityRelevant", "to.otherEnd().contributesToEquality"
       });					
    addAnnotation
      (headEClass, 
       source, 
       new String[] 
       {
       "IsOrdered", "self.object.getType().ordered"
       });			
    addAnnotation
      (tailEClass, 
       source, 
       new String[] 
       {
       "IsOrdered", "self.object.getType().ordered"
       });				
    addAnnotation
      (conditionalEClass, 
       source, 
       new String[] 
       {
       "ConditionMustBeBoolean", "self.condition.getType().upperMultiplicity = 1 and\r\n  self.condition.getType().oclIsKindOf(ClassTypeDefinition) and\r\n  self.condition.getType().oclAsType(ClassTypeDefinition).clazz.name = \'Boolean\'"
       });				
    addAnnotation
      (ternaryEClass, 
       source, 
       new String[] 
       {
       "TrueAndFalseExprsConformToResultType", "self.trueExpr.getType().conformsTo(self.getType()) or\r\n  self.falseExpr.getType().conformsTo(self.getType())"
       });						
    addAnnotation
      (contentEqualsEClass, 
       source, 
       new String[] 
       {
       "ContentEqualsOnlyForEntities", "self.left.getType().getInnermost().oclIsKindOf(ClassTypeDefinition) and\r\n  self.right.getType().getInnermost().oclIsKindOf(ClassTypeDefinition) and\r\n  not self.left.getType().getInnermost().oclAsType(ClassTypeDefinition).clazz.valueType and\r\n  not self.right.getType().getInnermost().oclAsType(ClassTypeDefinition).clazz.valueType"
       });				
    addAnnotation
      (mapEClass, 
       source, 
       new String[] 
       {
       "ObjectTypeMustConformToFunctionArgument", "let fstd = self.argument.getType() in\r\n  let sig = fstd.oclAsType(FunctionSignatureTypeDefinition).signature in\r\n  let t = self.object.getType() in\r\n  let argT = sig.input->at(1).getType() in\r\n  -- if multiplicities match including multiplicities, that\'s ok\r\n  t.conformsTo(argT) or\r\n  -- otherwise, pick single multiplicity from object and try again\r\n  t.conformsToIgnoringMultiplicity(argT) or\r\n  (t.oclIsKindOf(NestedTypeDefinition) and t.oclAsType(NestedTypeDefinition).type.conformsTo(argT))",
       "ArgumentMustBeSingleArgumentFunctionWithNonVoidOutput", "let fstd = self.argument.getType() in\r\n  fstd.oclIsKindOf(FunctionSignatureTypeDefinition) and\r\n  (let sig = fstd.oclAsType(FunctionSignatureTypeDefinition).signature in\r\n  (sig.output->notEmpty() and\r\n  sig.input->size() = 1))",
       "MapFunctionMustBeSideEffectFree", "self.argument.getType().oclAsType(FunctionSignatureTypeDefinition).signature.sideEffectFree"
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
      (getVariableExpression_Variable(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });						
    addAnnotation
      (getMethodCallExpression_MethodSignature(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });			
    addAnnotation
      (getObjectBasedExpression_Object(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "objectBasedExpression"
       });				
    addAnnotation
      (getObjectCreationExpression_ClassToInstantiate(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });					
    addAnnotation
      (getFunctionCallExpression_CalledBlock(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "blockOfFunctionCallExpression"
       });		
    addAnnotation
      (getWithArgument_Argument(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "argumentOf"
       });						
    addAnnotation
      (getEquals_Left(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "leftOfEquals"
       });		
    addAnnotation
      (getEquals_Right(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "rightOfEquals"
       });					
    addAnnotation
      (getAssociationEndNavigationExpression_ToEnd(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });									
    addAnnotation
      (getSignatureCallExpression_Parameters(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "usedAsArgumentInSignatureCall"
       });								
    addAnnotation
      (getReplace_With(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "withOfReplace"
       });				
    addAnnotation
      (getNavigationStep_To(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getNavigationStep_FilterFunction(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "navigationStep"
       });									
    addAnnotation
      (getConditional_Condition(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "conditional"
       });				
    addAnnotation
      (getTernary_FalseExpr(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "falseOfTernary"
       });		
    addAnnotation
      (getTernary_TrueExpr(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "trueOfTernary"
       });						
  }

} //ExpressionsPackageImpl
