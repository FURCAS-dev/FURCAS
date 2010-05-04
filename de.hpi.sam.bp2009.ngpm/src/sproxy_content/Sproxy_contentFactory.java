/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see sproxy_content.Sproxy_contentPackage
 * @generated
 */
public interface Sproxy_contentFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Sproxy_contentFactory eINSTANCE = sproxy_content.impl.Sproxy_contentFactoryImpl.init();

  /**
   * Returns a new object of class '<em>BO</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>BO</em>'.
   * @generated
   */
  BO createBO();

  /**
   * Returns a new object of class '<em>BO Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>BO Node</em>'.
   * @generated
   */
  BONode createBONode();

  /**
   * Returns a new object of class '<em>Data Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type</em>'.
   * @generated
   */
  DataType createDataType();

  /**
   * Returns a new object of class '<em>Query</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Query</em>'.
   * @generated
   */
  Query createQuery();

  /**
   * Returns a new object of class '<em>Action</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Action</em>'.
   * @generated
   */
  Action createAction();

  /**
   * Returns a new object of class '<em>Service Interface</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Interface</em>'.
   * @generated
   */
  ServiceInterface createServiceInterface();

  /**
   * Returns a new object of class '<em>Service Interface Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Service Interface Operation</em>'.
   * @generated
   */
  ServiceInterfaceOperation createServiceInterfaceOperation();

  /**
   * Returns a new object of class '<em>Process Agent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Process Agent</em>'.
   * @generated
   */
  ProcessAgent createProcessAgent();

  /**
   * Returns a new object of class '<em>Outbound Process Agent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Outbound Process Agent</em>'.
   * @generated
   */
  OutboundProcessAgent createOutboundProcessAgent();

  /**
   * Returns a new object of class '<em>Inbound Process Agent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inbound Process Agent</em>'.
   * @generated
   */
  InboundProcessAgent createInboundProcessAgent();

  /**
   * Returns a new object of class '<em>Status And Action Schema</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Status And Action Schema</em>'.
   * @generated
   */
  StatusAndActionSchema createStatusAndActionSchema();

  /**
   * Returns a new object of class '<em>Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Element</em>'.
   * @generated
   */
  Element createElement();

  /**
   * Returns a new object of class '<em>Attribute</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Attribute</em>'.
   * @generated
   */
  Attribute createAttribute();

  /**
   * Returns a new object of class '<em>DO</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>DO</em>'.
   * @generated
   */
  DO createDO();

  /**
   * Returns a new object of class '<em>Association</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association</em>'.
   * @generated
   */
  Association createAssociation();

  /**
   * Returns a new object of class '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation</em>'.
   * @generated
   */
  Operation createOperation();

  /**
   * Returns a new object of class '<em>Status Derivator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Status Derivator</em>'.
   * @generated
   */
  StatusDerivator createStatusDerivator();

  /**
   * Returns a new object of class '<em>Population</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Population</em>'.
   * @generated
   */
  Population createPopulation();

  /**
   * Returns a new object of class '<em>Aggregation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Aggregation</em>'.
   * @generated
   */
  Aggregation createAggregation();

  /**
   * Returns a new object of class '<em>Association Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Association Properties</em>'.
   * @generated
   */
  AssociationProperties createAssociationProperties();

  /**
   * Returns a new object of class '<em>Node Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Node Properties</em>'.
   * @generated
   */
  NodeProperties createNodeProperties();

  /**
   * Returns a new object of class '<em>Operation Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Properties</em>'.
   * @generated
   */
  OperationProperties createOperationProperties();

  /**
   * Returns a new object of class '<em>Field Properties</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field Properties</em>'.
   * @generated
   */
  FieldProperties createFieldProperties();

  /**
   * Returns a new object of class '<em>Field</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field</em>'.
   * @generated
   */
  Field createField();

  /**
   * Returns a new object of class '<em>Language Dependent Text</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Language Dependent Text</em>'.
   * @generated
   */
  LanguageDependentText createLanguageDependentText();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Sproxy_contentPackage getSproxy_contentPackage();

} //Sproxy_contentFactory
