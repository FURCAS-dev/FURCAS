/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import sproxy_content.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see sproxy_content.Sproxy_contentPackage
 * @generated
 */
public class Sproxy_contentValidator extends EObjectValidator
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final Sproxy_contentValidator INSTANCE = new Sproxy_contentValidator();

  /**
   * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.common.util.Diagnostic#getSource()
   * @see org.eclipse.emf.common.util.Diagnostic#getCode()
   * @generated
   */
  public static final String DIAGNOSTIC_SOURCE = "sproxy_content";

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

  /**
   * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sproxy_contentValidator()
  {
    super();
  }

  /**
   * Returns the package of this validator switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EPackage getEPackage()
  {
    return Sproxy_contentPackage.eINSTANCE;
  }

  /**
   * Calls <code>validateXXX</code> for the corresponding classifier of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    switch (classifierID)
    {
      case Sproxy_contentPackage.BO:
        return validateBO((BO)value, diagnostics, context);
      case Sproxy_contentPackage.BO_NODE:
        return validateBONode((BONode)value, diagnostics, context);
      case Sproxy_contentPackage.DATA_TYPE:
        return validateDataType((DataType)value, diagnostics, context);
      case Sproxy_contentPackage.QUERY:
        return validateQuery((Query)value, diagnostics, context);
      case Sproxy_contentPackage.ACTION:
        return validateAction((Action)value, diagnostics, context);
      case Sproxy_contentPackage.SERVICE_INTERFACE:
        return validateServiceInterface((ServiceInterface)value, diagnostics, context);
      case Sproxy_contentPackage.SERVICE_INTERFACE_OPERATION:
        return validateServiceInterfaceOperation((ServiceInterfaceOperation)value, diagnostics, context);
      case Sproxy_contentPackage.PROCESS_AGENT:
        return validateProcessAgent((ProcessAgent)value, diagnostics, context);
      case Sproxy_contentPackage.OUTBOUND_PROCESS_AGENT:
        return validateOutboundProcessAgent((OutboundProcessAgent)value, diagnostics, context);
      case Sproxy_contentPackage.INBOUND_PROCESS_AGENT:
        return validateInboundProcessAgent((InboundProcessAgent)value, diagnostics, context);
      case Sproxy_contentPackage.STATUS_AND_ACTION_SCHEMA:
        return validateStatusAndActionSchema((StatusAndActionSchema)value, diagnostics, context);
      case Sproxy_contentPackage.ELEMENT:
        return validateElement((Element)value, diagnostics, context);
      case Sproxy_contentPackage.ATTRIBUTE:
        return validateAttribute((Attribute)value, diagnostics, context);
      case Sproxy_contentPackage.DO:
        return validateDO((DO)value, diagnostics, context);
      case Sproxy_contentPackage.ASSOCIATION:
        return validateAssociation((Association)value, diagnostics, context);
      case Sproxy_contentPackage.OPERATION:
        return validateOperation((Operation)value, diagnostics, context);
      case Sproxy_contentPackage.STATUS_DERIVATOR:
        return validateStatusDerivator((StatusDerivator)value, diagnostics, context);
      case Sproxy_contentPackage.POPULATION:
        return validatePopulation((Population)value, diagnostics, context);
      case Sproxy_contentPackage.AGGREGATION:
        return validateAggregation((Aggregation)value, diagnostics, context);
      case Sproxy_contentPackage.ASSOCIATION_PROPERTIES:
        return validateAssociationProperties((AssociationProperties)value, diagnostics, context);
      case Sproxy_contentPackage.NODE_PROPERTIES:
        return validateNodeProperties((NodeProperties)value, diagnostics, context);
      case Sproxy_contentPackage.OPERATION_PROPERTIES:
        return validateOperationProperties((OperationProperties)value, diagnostics, context);
      case Sproxy_contentPackage.FIELD_PROPERTIES:
        return validateFieldProperties((FieldProperties)value, diagnostics, context);
      case Sproxy_contentPackage.FIELD:
        return validateField((Field)value, diagnostics, context);
      case Sproxy_contentPackage.LANGUAGE_DEPENDENT_TEXT:
        return validateLanguageDependentText((LanguageDependentText)value, diagnostics, context);
      case Sproxy_contentPackage.CARDINALITY:
        return validateCardinality((Cardinality)value, diagnostics, context);
      default:
        return true;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateBO(BO bo, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(bo, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateBONode(BONode boNode, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    if (!validate_NoCircularContainment(boNode, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(boNode, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(boNode, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(boNode, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(boNode, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(boNode, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(boNode, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(boNode, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(boNode, diagnostics, context);
    if (result || diagnostics != null) result &= validateBONode_EitherRootOrChild(boNode, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the EitherRootOrChild constraint of '<em>BO Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String BO_NODE__EITHER_ROOT_OR_CHILD__EEXPRESSION = "self.bo->isEmpty() implies self.association->exists(a:Association | a.composite)";

  /**
   * Validates the EitherRootOrChild constraint of '<em>BO Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateBONode_EitherRootOrChild(BONode boNode, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return
      validate
        (Sproxy_contentPackage.Literals.BO_NODE,
         boNode,
         diagnostics,
         context,
         "http://de.hpi.sam.bp2009.OCL",
         "EitherRootOrChild",
         BO_NODE__EITHER_ROOT_OR_CHILD__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateDataType(DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(dataType, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateQuery(Query query, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(query, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAction(Action action, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(action, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateServiceInterface(ServiceInterface serviceInterface, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(serviceInterface, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateServiceInterfaceOperation(ServiceInterfaceOperation serviceInterfaceOperation, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(serviceInterfaceOperation, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateProcessAgent(ProcessAgent processAgent, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(processAgent, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateOutboundProcessAgent(OutboundProcessAgent outboundProcessAgent, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(outboundProcessAgent, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateInboundProcessAgent(InboundProcessAgent inboundProcessAgent, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(inboundProcessAgent, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStatusAndActionSchema(StatusAndActionSchema statusAndActionSchema, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    if (!validate_NoCircularContainment(statusAndActionSchema, diagnostics, context)) return false;
    boolean result = validate_EveryMultiplicityConforms(statusAndActionSchema, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryDataValueConforms(statusAndActionSchema, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(statusAndActionSchema, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(statusAndActionSchema, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryProxyResolves(statusAndActionSchema, diagnostics, context);
    if (result || diagnostics != null) result &= validate_UniqueID(statusAndActionSchema, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryKeyUnique(statusAndActionSchema, diagnostics, context);
    if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(statusAndActionSchema, diagnostics, context);
    if (result || diagnostics != null) result &= validateStatusAndActionSchema_CanOnlyUseStatusAttributes(statusAndActionSchema, diagnostics, context);
    return result;
  }

  /**
   * The cached validation expression for the CanOnlyUseStatusAttributes constraint of '<em>Status And Action Schema</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static final String STATUS_AND_ACTION_SCHEMA__CAN_ONLY_USE_STATUS_ATTRIBUTES__EEXPRESSION = "self.statusVariables->forAll(a:Attribute | a.statusAttribute)";

  /**
   * Validates the CanOnlyUseStatusAttributes constraint of '<em>Status And Action Schema</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStatusAndActionSchema_CanOnlyUseStatusAttributes(StatusAndActionSchema statusAndActionSchema, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return
      validate
        (Sproxy_contentPackage.Literals.STATUS_AND_ACTION_SCHEMA,
         statusAndActionSchema,
         diagnostics,
         context,
         "http://de.hpi.sam.bp2009.OCL",
         "CanOnlyUseStatusAttributes",
         STATUS_AND_ACTION_SCHEMA__CAN_ONLY_USE_STATUS_ATTRIBUTES__EEXPRESSION,
         Diagnostic.ERROR,
         DIAGNOSTIC_SOURCE,
         0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(element, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(attribute, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateDO(DO do_, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(do_, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAssociation(Association association, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(association, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateOperation(Operation operation, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(operation, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateStatusDerivator(StatusDerivator statusDerivator, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(statusDerivator, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validatePopulation(Population population, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(population, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAggregation(Aggregation aggregation, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(aggregation, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateAssociationProperties(AssociationProperties associationProperties, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(associationProperties, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateNodeProperties(NodeProperties nodeProperties, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(nodeProperties, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateOperationProperties(OperationProperties operationProperties, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(operationProperties, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateFieldProperties(FieldProperties fieldProperties, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(fieldProperties, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateField(Field field, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(field, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateLanguageDependentText(LanguageDependentText languageDependentText, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return validate_EveryDefaultConstraint(languageDependentText, diagnostics, context);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean validateCardinality(Cardinality cardinality, DiagnosticChain diagnostics, Map<Object, Object> context)
  {
    return true;
  }

  /**
   * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    // TODO
    // Specialize this to return a resource locator for messages specific to this validator.
    // Ensure that you remove @generated or mark it @generated NOT
    return super.getResourceLocator();
  }

} //Sproxy_contentValidator
