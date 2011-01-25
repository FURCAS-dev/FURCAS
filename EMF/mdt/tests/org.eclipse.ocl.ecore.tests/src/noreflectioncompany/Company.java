/**
 * <copyright>
 * </copyright>
 *
 * $Id: Company.java,v 1.1 2010/08/24 16:16:55 ewillink Exp $
 */
package noreflectioncompany;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link noreflectioncompany.Company#getName <em>Name</em>}</li>
 *   <li>{@link noreflectioncompany.Company#getEmployees <em>Employees</em>}</li>
 *   <li>{@link noreflectioncompany.Company#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see noreflectioncompany.NoreflectioncompanyPackage#getCompany()
 * @model
 * @generated
 */
public interface Company extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see noreflectioncompany.NoreflectioncompanyPackage#getCompany_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link noreflectioncompany.Company#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Employees</b></em>' containment reference list.
	 * The list contents are of type {@link noreflectioncompany.Employee}.
	 * It is bidirectional and its opposite is '{@link noreflectioncompany.Employee#getCompany <em>Company</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employees</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employees</em>' containment reference list.
	 * @see noreflectioncompany.NoreflectioncompanyPackage#getCompany_Employees()
	 * @see noreflectioncompany.Employee#getCompany
	 * @model opposite="company" containment="true"
	 * @generated
	 */
	EList<Employee> getEmployees();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The literals are from the enumeration {@link noreflectioncompany.CompanySizeKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see noreflectioncompany.CompanySizeKind
	 * @see noreflectioncompany.NoreflectioncompanyPackage#getCompany_Size()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL derivation='let table : Set(Tuple(range : Sequence(Integer), size : CompanySizeKind)) =\r    Set{Tuple{range=Sequence{0..49}, size=CompanySizeKind::small},\r         Tuple{range=Sequence{50..999}, size=CompanySizeKind::medium},\r         Tuple{range=Sequence{1000..1000000}, size=CompanySizeKind::large}} in\rtable->any(range->includes(employees->size())).size'"
	 * @generated
	 */
	CompanySizeKind getSize();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL body='true'"
	 * @generated
	 */
	boolean dummyInvariant(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Company
