/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package sproxy_content;

import modelmanagement.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status And Action Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link sproxy_content.StatusAndActionSchema#getStatusVariables <em>Status Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see sproxy_content.Sproxy_contentPackage#getStatusAndActionSchema()
 * @model annotation="http://de.hpi.sam.bp2009.OCL CanOnlyUseStatusAttributes='self.statusVariables->forAll(a:Attribute | a.statusAttribute)'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='CanOnlyUseStatusAttributes'"
 * @generated
 */
public interface StatusAndActionSchema extends NamedElement
{
  /**
   * Returns the value of the '<em><b>Status Variables</b></em>' reference list.
   * The list contents are of type {@link sproxy_content.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Status Variables</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Status Variables</em>' reference list.
   * @see sproxy_content.Sproxy_contentPackage#getStatusAndActionSchema_StatusVariables()
   * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml Property.oppositeRoleName=''"
   * @generated
   */
  EList<Attribute> getStatusVariables();

} // StatusAndActionSchema
