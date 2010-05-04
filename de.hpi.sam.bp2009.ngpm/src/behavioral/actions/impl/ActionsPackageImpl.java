/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package behavioral.actions.impl;

import abapmapping.AbapmappingPackage;

import abapmapping.abapdictionary.AbapdictionaryPackage;

import abapmapping.abapdictionary.impl.AbapdictionaryPackageImpl;

import abapmapping.impl.AbapmappingPackageImpl;

import ap_runtime_constraints.Ap_runtime_constraintsPackage;

import ap_runtime_constraints.impl.Ap_runtime_constraintsPackageImpl;

import behavioral.actions.ActionsFactory;
import behavioral.actions.ActionsPackage;
import behavioral.actions.AddLink;
import behavioral.actions.Assignment;
import behavioral.actions.Block;
import behavioral.actions.ConditionalStatement;
import behavioral.actions.Constant;
import behavioral.actions.ExpressionStatement;
import behavioral.actions.Foreach;
import behavioral.actions.IfElse;
import behavioral.actions.Iterator;
import behavioral.actions.LinkManipulationStatement;
import behavioral.actions.NamedValueDeclaration;
import behavioral.actions.NamedValueWithOptionalInitExpression;
import behavioral.actions.QueryInvocation;
import behavioral.actions.RemoveLink;
import behavioral.actions.Return;
import behavioral.actions.SingleBlockStatement;
import behavioral.actions.Sort;
import behavioral.actions.Statement;
import behavioral.actions.StatementWithArgument;
import behavioral.actions.StatementWithNestedBlocks;
import behavioral.actions.Variable;
import behavioral.actions.WhileLoop;

import behavioral.actions.util.ActionsValidator;

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
public class ActionsPackageImpl extends EPackageImpl implements ActionsPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass blockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifElseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileLoopEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass foreachEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass returnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass addLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass removeLinkEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass linkManipulationStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sortEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass queryInvocationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass iteratorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedValueDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementWithNestedBlocksEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singleBlockStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementWithArgumentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedValueWithOptionalInitExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalStatementEClass = null;

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
   * @see behavioral.actions.ActionsPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ActionsPackageImpl()
  {
    super(eNS_URI, ActionsFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ActionsPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ActionsPackage init()
  {
    if (isInited) return (ActionsPackage)EPackage.Registry.INSTANCE.getEPackage(ActionsPackage.eNS_URI);

    // Obtain or create and register package
    ActionsPackageImpl theActionsPackage = (ActionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActionsPackageImpl());

    isInited = true;

    // Obtain or create and register interdependencies
    ReflectionPackageImpl theReflectionPackage = (ReflectionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReflectionPackage.eNS_URI) instanceof ReflectionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReflectionPackage.eNS_URI) : ReflectionPackage.eINSTANCE);
    PrimitivetypesPackageImpl thePrimitivetypesPackage = (PrimitivetypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI) instanceof PrimitivetypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI) : PrimitivetypesPackage.eINSTANCE);
    BpdmPackageImpl theBpdmPackage = (BpdmPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BpdmPackage.eNS_URI) instanceof BpdmPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BpdmPackage.eNS_URI) : BpdmPackage.eINSTANCE);
    BusinesstasksPackageImpl theBusinesstasksPackage = (BusinesstasksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BusinesstasksPackage.eNS_URI) instanceof BusinesstasksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BusinesstasksPackage.eNS_URI) : BusinesstasksPackage.eINSTANCE);
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
    Sproxy_contentPackageImpl theSproxy_contentPackage = (Sproxy_contentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Sproxy_contentPackage.eNS_URI) instanceof Sproxy_contentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Sproxy_contentPackage.eNS_URI) : Sproxy_contentPackage.eINSTANCE);
    AbapmappingPackageImpl theAbapmappingPackage = (AbapmappingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) instanceof AbapmappingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapmappingPackage.eNS_URI) : AbapmappingPackage.eINSTANCE);
    AbapdictionaryPackageImpl theAbapdictionaryPackage = (AbapdictionaryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) instanceof AbapdictionaryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AbapdictionaryPackage.eNS_URI) : AbapdictionaryPackage.eINSTANCE);
    persistence.actions.impl.ActionsPackageImpl theActionsPackage_1 = (persistence.actions.impl.ActionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) instanceof persistence.actions.impl.ActionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.actions.ActionsPackage.eNS_URI) : persistence.actions.ActionsPackage.eINSTANCE);
    persistence.expressions.impl.ExpressionsPackageImpl theExpressionsPackage_1 = (persistence.expressions.impl.ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) instanceof persistence.expressions.impl.ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(persistence.expressions.ExpressionsPackage.eNS_URI) : persistence.expressions.ExpressionsPackage.eINSTANCE);

    // Create package meta-data objects
    theActionsPackage.createPackageContents();
    theReflectionPackage.createPackageContents();
    thePrimitivetypesPackage.createPackageContents();
    theBpdmPackage.createPackageContents();
    theBusinesstasksPackage.createPackageContents();
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
    theSproxy_contentPackage.createPackageContents();
    theAbapmappingPackage.createPackageContents();
    theAbapdictionaryPackage.createPackageContents();
    theActionsPackage_1.createPackageContents();
    theExpressionsPackage_1.createPackageContents();

    // Initialize created meta-data
    theActionsPackage.initializePackageContents();
    theReflectionPackage.initializePackageContents();
    thePrimitivetypesPackage.initializePackageContents();
    theBpdmPackage.initializePackageContents();
    theBusinesstasksPackage.initializePackageContents();
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
    theSproxy_contentPackage.initializePackageContents();
    theAbapmappingPackage.initializePackageContents();
    theAbapdictionaryPackage.initializePackageContents();
    theActionsPackage_1.initializePackageContents();
    theExpressionsPackage_1.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put
      (theActionsPackage, 
       new EValidator.Descriptor()
       {
         public EValidator getEValidator()
         {
           return ActionsValidator.INSTANCE;
         }
       });

    // Mark meta-data to indicate it can't be changed
    theActionsPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ActionsPackage.eNS_URI, theActionsPackage);
    return theActionsPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignment()
  {
    return assignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignment_AssignTo()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatement_Block()
  {
    return (EReference)statementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBlock()
  {
    return blockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlock_Statements()
  {
    return (EReference)blockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlock_Variables()
  {
    return (EReference)blockEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBlock_OwningStatement()
  {
    return (EReference)blockEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfElse()
  {
    return ifElseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhileLoop()
  {
    return whileLoopEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForeach()
  {
    return foreachEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForeach_Parallel()
  {
    return (EAttribute)foreachEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeach_Collection()
  {
    return (EReference)foreachEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForeach_ForVariable()
  {
    return (EReference)foreachEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReturn()
  {
    return returnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAddLink()
  {
    return addLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRemoveLink()
  {
    return removeLinkEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLinkManipulationStatement()
  {
    return linkManipulationStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLinkManipulationStatement_At()
  {
    return (EAttribute)linkManipulationStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkManipulationStatement_Association()
  {
    return (EReference)linkManipulationStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLinkManipulationStatement_Objects()
  {
    return (EReference)linkManipulationStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionStatement()
  {
    return expressionStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionStatement_Expression()
  {
    return (EReference)expressionStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSort()
  {
    return sortEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getQueryInvocation()
  {
    return queryInvocationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstant()
  {
    return constantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstant_Iterate()
  {
    return (EReference)constantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariable_Assignments()
  {
    return (EReference)variableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIterator()
  {
    return iteratorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterator_BoundToFor()
  {
    return (EReference)iteratorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterator_Iterate()
  {
    return (EReference)iteratorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterator_Selection()
  {
    return (EReference)iteratorEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIterator_FromClause()
  {
    return (EReference)iteratorEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedValueDeclaration()
  {
    return namedValueDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedValueDeclaration_NamedValue()
  {
    return (EReference)namedValueDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatementWithNestedBlocks()
  {
    return statementWithNestedBlocksEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatementWithNestedBlocks_NestedBlocks()
  {
    return (EReference)statementWithNestedBlocksEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingleBlockStatement()
  {
    return singleBlockStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatementWithArgument()
  {
    return statementWithArgumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedValueWithOptionalInitExpression()
  {
    return namedValueWithOptionalInitExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedValueWithOptionalInitExpression_InitExpression()
  {
    return (EReference)namedValueWithOptionalInitExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalStatement()
  {
    return conditionalStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionsFactory getActionsFactory()
  {
    return (ActionsFactory)getEFactoryInstance();
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
    assignmentEClass = createEClass(ASSIGNMENT);
    createEReference(assignmentEClass, ASSIGNMENT__ASSIGN_TO);

    statementEClass = createEClass(STATEMENT);
    createEReference(statementEClass, STATEMENT__BLOCK);

    blockEClass = createEClass(BLOCK);
    createEReference(blockEClass, BLOCK__STATEMENTS);
    createEReference(blockEClass, BLOCK__VARIABLES);
    createEReference(blockEClass, BLOCK__OWNING_STATEMENT);

    ifElseEClass = createEClass(IF_ELSE);

    whileLoopEClass = createEClass(WHILE_LOOP);

    foreachEClass = createEClass(FOREACH);
    createEAttribute(foreachEClass, FOREACH__PARALLEL);
    createEReference(foreachEClass, FOREACH__COLLECTION);
    createEReference(foreachEClass, FOREACH__FOR_VARIABLE);

    returnEClass = createEClass(RETURN);

    addLinkEClass = createEClass(ADD_LINK);

    removeLinkEClass = createEClass(REMOVE_LINK);

    linkManipulationStatementEClass = createEClass(LINK_MANIPULATION_STATEMENT);
    createEAttribute(linkManipulationStatementEClass, LINK_MANIPULATION_STATEMENT__AT);
    createEReference(linkManipulationStatementEClass, LINK_MANIPULATION_STATEMENT__ASSOCIATION);
    createEReference(linkManipulationStatementEClass, LINK_MANIPULATION_STATEMENT__OBJECTS);

    expressionStatementEClass = createEClass(EXPRESSION_STATEMENT);
    createEReference(expressionStatementEClass, EXPRESSION_STATEMENT__EXPRESSION);

    sortEClass = createEClass(SORT);

    queryInvocationEClass = createEClass(QUERY_INVOCATION);

    constantEClass = createEClass(CONSTANT);
    createEReference(constantEClass, CONSTANT__ITERATE);

    variableEClass = createEClass(VARIABLE);
    createEReference(variableEClass, VARIABLE__ASSIGNMENTS);

    iteratorEClass = createEClass(ITERATOR);
    createEReference(iteratorEClass, ITERATOR__BOUND_TO_FOR);
    createEReference(iteratorEClass, ITERATOR__ITERATE);
    createEReference(iteratorEClass, ITERATOR__SELECTION);
    createEReference(iteratorEClass, ITERATOR__FROM_CLAUSE);

    namedValueDeclarationEClass = createEClass(NAMED_VALUE_DECLARATION);
    createEReference(namedValueDeclarationEClass, NAMED_VALUE_DECLARATION__NAMED_VALUE);

    statementWithNestedBlocksEClass = createEClass(STATEMENT_WITH_NESTED_BLOCKS);
    createEReference(statementWithNestedBlocksEClass, STATEMENT_WITH_NESTED_BLOCKS__NESTED_BLOCKS);

    singleBlockStatementEClass = createEClass(SINGLE_BLOCK_STATEMENT);

    statementWithArgumentEClass = createEClass(STATEMENT_WITH_ARGUMENT);

    namedValueWithOptionalInitExpressionEClass = createEClass(NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION);
    createEReference(namedValueWithOptionalInitExpressionEClass, NAMED_VALUE_WITH_OPTIONAL_INIT_EXPRESSION__INIT_EXPRESSION);

    conditionalStatementEClass = createEClass(CONDITIONAL_STATEMENT);
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
    ClassesPackage theClassesPackage = (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);
    PrimitivetypesPackage thePrimitivetypesPackage = (PrimitivetypesPackage)EPackage.Registry.INSTANCE.getEPackage(PrimitivetypesPackage.eNS_URI);
    ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
    CollectionexpressionsPackage theCollectionexpressionsPackage = (CollectionexpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(CollectionexpressionsPackage.eNS_URI);
    QueryPackage theQueryPackage = (QueryPackage)EPackage.Registry.INSTANCE.getEPackage(QueryPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    assignmentEClass.getESuperTypes().add(this.getStatementWithArgument());
    statementEClass.getESuperTypes().add(theClassesPackage.getInScope());
    blockEClass.getESuperTypes().add(theClassesPackage.getFunctionSignatureImplementation());
    blockEClass.getESuperTypes().add(theClassesPackage.getInScope());
    ifElseEClass.getESuperTypes().add(this.getConditionalStatement());
    ifElseEClass.getESuperTypes().add(this.getStatementWithNestedBlocks());
    whileLoopEClass.getESuperTypes().add(this.getConditionalStatement());
    whileLoopEClass.getESuperTypes().add(this.getSingleBlockStatement());
    foreachEClass.getESuperTypes().add(this.getSingleBlockStatement());
    returnEClass.getESuperTypes().add(this.getStatementWithArgument());
    addLinkEClass.getESuperTypes().add(this.getLinkManipulationStatement());
    removeLinkEClass.getESuperTypes().add(this.getLinkManipulationStatement());
    linkManipulationStatementEClass.getESuperTypes().add(this.getStatement());
    expressionStatementEClass.getESuperTypes().add(this.getStatement());
    constantEClass.getESuperTypes().add(this.getNamedValueWithOptionalInitExpression());
    variableEClass.getESuperTypes().add(this.getNamedValueWithOptionalInitExpression());
    iteratorEClass.getESuperTypes().add(theClassesPackage.getNamedValue());
    namedValueDeclarationEClass.getESuperTypes().add(this.getStatement());
    statementWithNestedBlocksEClass.getESuperTypes().add(this.getStatement());
    singleBlockStatementEClass.getESuperTypes().add(this.getStatementWithNestedBlocks());
    statementWithArgumentEClass.getESuperTypes().add(this.getStatement());
    statementWithArgumentEClass.getESuperTypes().add(theExpressionsPackage.getWithArgument());
    namedValueWithOptionalInitExpressionEClass.getESuperTypes().add(theClassesPackage.getNamedValue());
    conditionalStatementEClass.getESuperTypes().add(theExpressionsPackage.getConditional());
    conditionalStatementEClass.getESuperTypes().add(this.getStatement());

    // Initialize classes and features; add operations and parameters
    initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignment_AssignTo(), this.getVariable(), this.getVariable_Assignments(), "assignTo", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatement_Block(), this.getBlock(), this.getBlock_Statements(), "block", null, 1, 1, Statement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(statementEClass, this.getBlock(), "getOutermostBlock", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(statementEClass, thePrimitivetypesPackage.getBoolean(), "isSideEffectFree", 0, 1, IS_UNIQUE, IS_ORDERED);

    EOperation op = addEOperation(statementEClass, thePrimitivetypesPackage.getBoolean(), "isSideEffectFreeForBlock", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getBlock(), "block", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(statementEClass, theClassesPackage.getNamedValue(), "getNamedValuesInScope", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(statementEClass, theClassesPackage.getSapClass(), "getOwningClass", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlock_Statements(), this.getStatement(), this.getStatement_Block(), "statements", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBlock_Variables(), theClassesPackage.getNamedValue(), theClassesPackage.getNamedValue_Owner(), "variables", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBlock_OwningStatement(), this.getStatementWithNestedBlocks(), this.getStatementWithNestedBlocks_NestedBlocks(), "owningStatement", null, 0, 1, Block.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(blockEClass, this.getBlock(), "getOutermostBlock", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(blockEClass, thePrimitivetypesPackage.getBoolean(), "localIsSideEffectFree", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(blockEClass, theClassesPackage.getNamedValue(), "getNamedValuesInScope", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(blockEClass, theClassesPackage.getSapClass(), "getOwningClass", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(ifElseEClass, IfElse.class, "IfElse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    addEOperation(ifElseEClass, this.getBlock(), "getIfBlock", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(ifElseEClass, this.getBlock(), "getElseBlock", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(whileLoopEClass, WhileLoop.class, "WhileLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    addEOperation(whileLoopEClass, this.getBlock(), "getLoopBody", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(foreachEClass, Foreach.class, "Foreach", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getForeach_Parallel(), thePrimitivetypesPackage.getBoolean(), "parallel", null, 0, 1, Foreach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeach_Collection(), theExpressionsPackage.getExpression(), null, "collection", null, 1, 1, Foreach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForeach_ForVariable(), this.getIterator(), this.getIterator_BoundToFor(), "forVariable", null, 1, 1, Foreach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(returnEClass, Return.class, "Return", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(addLinkEClass, AddLink.class, "AddLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(removeLinkEClass, RemoveLink.class, "RemoveLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(linkManipulationStatementEClass, LinkManipulationStatement.class, "LinkManipulationStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLinkManipulationStatement_At(), thePrimitivetypesPackage.getInteger(), "at", null, 0, 1, LinkManipulationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinkManipulationStatement_Association(), theClassesPackage.getAssociation(), null, "association", null, 1, 1, LinkManipulationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLinkManipulationStatement_Objects(), theExpressionsPackage.getExpression(), null, "objects", null, 2, 2, LinkManipulationStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionStatementEClass, ExpressionStatement.class, "ExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressionStatement_Expression(), theExpressionsPackage.getExpression(), null, "expression", null, 1, 1, ExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sortEClass, Sort.class, "Sort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(queryInvocationEClass, QueryInvocation.class, "QueryInvocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstant_Iterate(), theCollectionexpressionsPackage.getIterate(), theCollectionexpressionsPackage.getIterate_Accumulator(), "iterate", null, 0, 1, Constant.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariable_Assignments(), this.getAssignment(), this.getAssignment_AssignTo(), "assignments", null, 0, -1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    addEOperation(variableEClass, null, "getCommonTypeOfAssignments", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(iteratorEClass, Iterator.class, "Iterator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIterator_BoundToFor(), this.getForeach(), this.getForeach_ForVariable(), "boundToFor", null, 0, 1, Iterator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterator_Iterate(), theCollectionexpressionsPackage.getIterate(), theCollectionexpressionsPackage.getIterate_Iterators(), "iterate", null, 0, 1, Iterator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterator_Selection(), theQueryPackage.getSelection(), theQueryPackage.getSelection_Iterator(), "selection", null, 0, 1, Iterator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIterator_FromClause(), theQueryPackage.getFromClause(), theQueryPackage.getFromClause_Alias(), "fromClause", null, 0, 1, Iterator.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedValueDeclarationEClass, NamedValueDeclaration.class, "NamedValueDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNamedValueDeclaration_NamedValue(), this.getNamedValueWithOptionalInitExpression(), null, "namedValue", null, 1, 1, NamedValueDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementWithNestedBlocksEClass, StatementWithNestedBlocks.class, "StatementWithNestedBlocks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatementWithNestedBlocks_NestedBlocks(), this.getBlock(), this.getBlock_OwningStatement(), "nestedBlocks", null, 1, 2, StatementWithNestedBlocks.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singleBlockStatementEClass, SingleBlockStatement.class, "SingleBlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(statementWithArgumentEClass, StatementWithArgument.class, "StatementWithArgument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(namedValueWithOptionalInitExpressionEClass, NamedValueWithOptionalInitExpression.class, "NamedValueWithOptionalInitExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNamedValueWithOptionalInitExpression_InitExpression(), theExpressionsPackage.getExpression(), null, "initExpression", null, 0, 1, NamedValueWithOptionalInitExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalStatementEClass, ConditionalStatement.class, "ConditionalStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
      (assignmentEClass, 
       source, 
       new String[] 
       {
       "constraints", "AssignmentCompatibility MustHaveArgument"
       });			
    addAnnotation
      (statementEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });			
    addAnnotation
      (statementEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (statementEClass.getEOperations().get(2), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (statementEClass.getEOperations().get(3), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });			
    addAnnotation
      (statementEClass.getEOperations().get(4), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (blockEClass, 
       source, 
       new String[] 
       {
       "constraints", "DoesNotOwnIterators IsSideEffectFreeIfImplementsSideEffectFreeSignature DistinctNamedValueNames"
       });			
    addAnnotation
      (blockEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (blockEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });			
    addAnnotation
      (blockEClass.getEOperations().get(2), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (blockEClass.getEOperations().get(3), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });			
    addAnnotation
      (ifElseEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });			
    addAnnotation
      (ifElseEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });			
    addAnnotation
      (whileLoopEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "constraints", "body"
       });				
    addAnnotation
      (foreachEClass, 
       source, 
       new String[] 
       {
       "constraints", "VariableOwnedByRightBlock"
       });					
    addAnnotation
      (returnEClass, 
       source, 
       new String[] 
       {
       "constraints", "ReturnMustBeLastInBlock ReturnTypeMustMatch"
       });					
    addAnnotation
      (linkManipulationStatementEClass, 
       source, 
       new String[] 
       {
       "constraints", "ObjectsMustConformToEndTypes BlockMustNotImplementSideEffectFreeSignature NoValueMustBeModified"
       });								
    addAnnotation
      (constantEClass, 
       source, 
       new String[] 
       {
       "constraints", "InitExpressionTypeMustMatchVariableType"
       });				
    addAnnotation
      (variableEClass, 
       source, 
       new String[] 
       {
       "constraints", "InitExpressionTypeMustMatchVariableType"
       });						
    addAnnotation
      (singleBlockStatementEClass, 
       source, 
       new String[] 
       {
       "constraints", "OwnsExactlyOneBlock"
       });			
    addAnnotation
      (namedValueWithOptionalInitExpressionEClass, 
       source, 
       new String[] 
       {
       "constraints", "AssignmentCompatibility"
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
      (assignmentEClass, 
       source, 
       new String[] 
       {
       "AssignmentCompatibility", "self.argument.getType().conformsTo(self.assignTo.getType())",
       "MustHaveArgument", "self.argument->notEmpty()"
       });			
    addAnnotation
      (statementEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "body", "self.block.getOutermostBlock()"
       });			
    addAnnotation
      (statementEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "body", "not self.oclIsKindOf(AddLink) and  not self.oclIsKindOf(RemoveLink) and  not self.oclIsKindOf(Assignment) and  (self.oclIsKindOf(IfElse) implies self.oclAsType(IfElse).condition.isSideEffectFree()) and  (self.oclIsKindOf(WhileLoop) implies self.oclAsType(WhileLoop).condition.isSideEffectFree()) and  (self.oclIsKindOf(ExpressionStatement) implies self.oclAsType(ExpressionStatement).expression.isSideEffectFree()) and  (self.oclIsKindOf(StatementWithArgument) implies (self.oclAsType(StatementWithArgument).argument->notEmpty() implies self.oclAsType(StatementWithArgument).argument.isSideEffectFree())) and  (self.oclIsKindOf(StatementWithNestedBlocks) implies self.oclAsType(StatementWithNestedBlocks).nestedBlocks->forAll(b|b.isSideEffectFree()))"
       });				
    addAnnotation
      (statementEClass.getEOperations().get(2), 
       source, 
       new String[] 
       {
       "body", "not self.oclIsKindOf(AddLink) and  not self.oclIsKindOf(RemoveLink) and  (self.oclIsKindOf(Assignment) implies self.oclAsType(Assignment).assignTo.owner <> block) and  (self.oclIsKindOf(IfElse) implies self.oclAsType(IfElse).condition.isSideEffectFree()) and  (self.oclIsKindOf(WhileLoop) implies self.oclAsType(WhileLoop).condition.isSideEffectFree()) and  (self.oclIsKindOf(ExpressionStatement) implies self.oclAsType(ExpressionStatement).expression.isSideEffectFree()) and  (self.oclIsKindOf(StatementWithArgument) implies (self.oclAsType(StatementWithArgument).argument->notEmpty() implies self.oclAsType(StatementWithArgument).argument.isSideEffectFree())) and  (self.oclIsKindOf(StatementWithNestedBlocks) implies self.oclAsType(StatementWithNestedBlocks).nestedBlocks->forAll(b|b.isSideEffectFree()))"
       });				
    addAnnotation
      (statementEClass.getEOperations().get(3), 
       source, 
       new String[] 
       {
       "body", "-- collect all NamedValue declarations introduced by statements in this statement\'s owning block, prior to this statement.  let pos = self.block.statements->indexOf(self) in  if pos > 1 then    self.addNamedValuesWithNewNames(    if self.block.statements->at(-1+pos).oclIsKindOf(NamedValueDeclaration) then      self.block.statements->at(-1+pos).oclAsType(NamedValueDeclaration).namedValue->asSet()    else      Set{}    endif,    self.block.statements->at(-1+pos).getNamedValuesInScope())  else    -- first statement in block; consider block itself    self.block.getNamedValuesInScope()  endif"
       });			
    addAnnotation
      (statementEClass.getEOperations().get(4), 
       source, 
       new String[] 
       {
       "body", "self.block.getOwningClass()"
       });				
    addAnnotation
      (blockEClass, 
       source, 
       new String[] 
       {
       "DoesNotOwnIterators", "self.variables->select(i|i.oclIsKindOf(Iterator))->isEmpty()",
       "IsSideEffectFreeIfImplementsSideEffectFreeSignature", "self.implements_->notEmpty() implies\r\n    (self.implements_.sideEffectFree implies self.isSideEffectFree())",
       "DistinctNamedValueNames", "self.variables->forAll( i, j | i <> j implies i.name <> j.name )"
       });			
    addAnnotation
      (blockEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "body", "if self.owningStatement->notEmpty() then    self.owningStatement.block.getOutermostBlock()  else    self  endif"
       });				
    addAnnotation
      (blockEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "body", "self.statements->forAll(s|s.isSideEffectFreeForBlock(self))"
       });			
    addAnnotation
      (blockEClass.getEOperations().get(2), 
       source, 
       new String[] 
       {
       "body", "self.addNamedValuesWithNewNames(  -- Handle Foreach  let s:Set(NamedValue)=Set{} in  s->union(if owningStatement.oclIsKindOf(Foreach) then    owningStatement.oclAsType(Foreach).forVariable->asSet()  else    Set{}  endif)->union(  -- add parameters for those blocks that are used as a signature implementation  functionSignature.input->asSet()  )->union(  implements_.input->asSet()  ),  -- then ascend the block composition hierarchy and add all NamedValues defined in parent blocks before the occurrence of the statement with the nested block  if owningStatement->notEmpty() then    owningStatement.getNamedValuesInScope()  else    -- add formal object parameters from owning class    let oc = self.getOwningClass() in    if oc->notEmpty() then      oc.formalObjectParameters->asSet()    else      Set{}    endif  endif)"
       });				
    addAnnotation
      (blockEClass.getEOperations().get(3), 
       source, 
       new String[] 
       {
       "body", "let outermost = self.getOutermostBlock() in  let implementedSignature = outermost.getImplementedSignature() in  if implementedSignature->notEmpty() then    implementedSignature.getOwningClass()  else    null  endif"
       });			
    addAnnotation
      (ifElseEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "body", "self.nestedBlocks->at(1)"
       });			
    addAnnotation
      (ifElseEClass.getEOperations().get(1), 
       source, 
       new String[] 
       {
       "body", "if self.nestedBlocks->size() > 1 then    self.nestedBlocks->at(2)  else    null  endif"
       });			
    addAnnotation
      (whileLoopEClass.getEOperations().get(0), 
       source, 
       new String[] 
       {
       "body", "self.nestedBlocks->at(1)"
       });				
    addAnnotation
      (foreachEClass, 
       source, 
       new String[] 
       {
       "VariableOwnedByRightBlock", "self.forVariable.owner = self.nestedBlocks->at(1)"
       });					
    addAnnotation
      (returnEClass, 
       source, 
       new String[] 
       {
       "ReturnMustBeLastInBlock", "self = self.block.statements->last()",
       "ReturnTypeMustMatch", "self.argument.getType().conformsTo(self.getOutermostBlock().getImplementedSignature().output)"
       });					
    addAnnotation
      (linkManipulationStatementEClass, 
       source, 
       new String[] 
       {
       "ObjectsMustConformToEndTypes", "Sequence{1..self.objects->size()}->forAll(i:Integer |\r\n    objects->at(i).getType().conformsTo(association.ends->at(i).type))",
       "BlockMustNotImplementSideEffectFreeSignature", "self.block.getImplementedSignature()->notEmpty() implies\r\n  not self.block.getImplementedSignature().sideEffectFree",
       "NoValueMustBeModified", "self.association.ends->forAll(ae:AssociationEnd |\r\n    ae.type.clazz.valueType implies not ae.contributesToEquality)"
       });								
    addAnnotation
      (constantEClass, 
       source, 
       new String[] 
       {
       "InitExpressionTypeMustMatchVariableType", "self.initExpression->notEmpty() implies self.initExpression.getType().conformsTo(self.getType())"
       });				
    addAnnotation
      (variableEClass, 
       source, 
       new String[] 
       {
       "InitExpressionTypeMustMatchVariableType", "self.initExpression->notEmpty() implies self.initExpression.getType().conformsTo(self.getType())"
       });						
    addAnnotation
      (singleBlockStatementEClass, 
       source, 
       new String[] 
       {
       "OwnsExactlyOneBlock", "self.nestedBlocks->size() = 1"
       });			
    addAnnotation
      (namedValueWithOptionalInitExpressionEClass, 
       source, 
       new String[] 
       {
       "AssignmentCompatibility", "self.initExpression->forAll(ie | ie.getType().conformsTo(self.getType()))"
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
      (getForeach_Collection(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });										
    addAnnotation
      (getLinkManipulationStatement_Association(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getLinkManipulationStatement_Objects(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", ""
       });		
    addAnnotation
      (getExpressionStatement_Expression(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "expressionStatement"
       });									
    addAnnotation
      (getNamedValueDeclaration_NamedValue(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "namedValueDeclaration"
       });							
    addAnnotation
      (getNamedValueWithOptionalInitExpression_InitExpression(), 
       source, 
       new String[] 
       {
       "Property.oppositeRoleName", "initExpressionFor"
       });
  }

} //ActionsPackageImpl
