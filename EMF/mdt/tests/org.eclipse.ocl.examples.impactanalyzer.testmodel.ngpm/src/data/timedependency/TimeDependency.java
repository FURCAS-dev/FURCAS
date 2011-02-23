/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeDependency.java,v 1.1 2011/02/07 17:18:47 auhl Exp $
 */
package data.timedependency;

import data.classes.Association;
import data.classes.SapClass;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Captures the specification for how to deal in detail with the time-dependent nature of the annotated structural feature.
 * 
 * Time dependence of a class means that the existence of an instance of that class is timie dependent. A time-dependent association means that the existence of each link of that association is time dependent.
 * 
 * Read operations on time-dependent classes and associations (such as queries and navigation) can optionally specify a point in time or a timespan. If no time or timespan is specified, the current time is assumed.
 * 
 * Write/update operations by default will use the current time as the point in time, or an open time interval starting at the current time (in case of a timespan feature). Any open previous timespan by default will be closed at the current time by an update.
 * 
 * Read and update operations of time-dependent features can optionally be equipped with a time/timespan telling the temporal validity of the values updated or the values to be read.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link data.timedependency.TimeDependency#getRecordCutoffInMilliseconds <em>Record Cutoff In Milliseconds</em>}</li>
 *   <li>{@link data.timedependency.TimeDependency#isCanChangePast <em>Can Change Past</em>}</li>
 *   <li>{@link data.timedependency.TimeDependency#isTimespan <em>Timespan</em>}</li>
 *   <li>{@link data.timedependency.TimeDependency#getTheClass <em>The Class</em>}</li>
 *   <li>{@link data.timedependency.TimeDependency#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see data.timedependency.TimedependencyPackage#getTimeDependency()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL RecordCutoffGreaterOrEqualZero='self.recordCutoffInMilliseconds >= 0'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='RecordCutoffGreaterOrEqualZero'"
 * @generated
 */
public interface TimeDependency extends EObject {
	/**
     * Returns the value of the '<em><b>Record Cutoff In Milliseconds</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The number of milliseconds for which to keep historic versions of this feature. Only values greater or equal to zero are permitted. 0 means that no historic versions are kept at all.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Record Cutoff In Milliseconds</em>' attribute.
     * @see #setRecordCutoffInMilliseconds(int)
     * @see data.timedependency.TimedependencyPackage#getTimeDependency_RecordCutoffInMilliseconds()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	int getRecordCutoffInMilliseconds();

	/**
     * Sets the value of the '{@link data.timedependency.TimeDependency#getRecordCutoffInMilliseconds <em>Record Cutoff In Milliseconds</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Record Cutoff In Milliseconds</em>' attribute.
     * @see #getRecordCutoffInMilliseconds()
     * @generated
     */
	void setRecordCutoffInMilliseconds(int value);

	/**
     * Returns the value of the '<em><b>Can Change Past</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * If true, it is permissible to change values of the time-dependent feature for previous times.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Can Change Past</em>' attribute.
     * @see #setCanChangePast(boolean)
     * @see data.timedependency.TimedependencyPackage#getTimeDependency_CanChangePast()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isCanChangePast();

	/**
     * Sets the value of the '{@link data.timedependency.TimeDependency#isCanChangePast <em>Can Change Past</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Can Change Past</em>' attribute.
     * @see #isCanChangePast()
     * @generated
     */
	void setCanChangePast(boolean value);

	/**
     * Returns the value of the '<em><b>Timespan</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * If true, data is valid over a given timespan, not only a single point in time. When writing data, the validity period is to be specified as a timespan rather than a point in time.
     * 
     * If false, data samples are valid only at a single point in time, such as from an RFID reader or a temperature sensor. Access APIs would have to allow for conveniently finding the "nearest" match for a given point in time.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Timespan</em>' attribute.
     * @see #setTimespan(boolean)
     * @see data.timedependency.TimedependencyPackage#getTimeDependency_Timespan()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	boolean isTimespan();

	/**
     * Sets the value of the '{@link data.timedependency.TimeDependency#isTimespan <em>Timespan</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timespan</em>' attribute.
     * @see #isTimespan()
     * @generated
     */
	void setTimespan(boolean value);

	/**
     * Returns the value of the '<em><b>The Class</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.SapClass#getTimeDependency <em>Time Dependency</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>The Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>The Class</em>' container reference.
     * @see #setTheClass(SapClass)
     * @see data.timedependency.TimedependencyPackage#getTimeDependency_TheClass()
     * @see data.classes.SapClass#getTimeDependency
     * @model opposite="timeDependency"
     * @generated
     */
	SapClass getTheClass();

	/**
     * Sets the value of the '{@link data.timedependency.TimeDependency#getTheClass <em>The Class</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>The Class</em>' container reference.
     * @see #getTheClass()
     * @generated
     */
	void setTheClass(SapClass value);

	/**
     * Returns the value of the '<em><b>Association</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link data.classes.Association#getTimeDependency <em>Time Dependency</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Association</em>' container reference.
     * @see #setAssociation(Association)
     * @see data.timedependency.TimedependencyPackage#getTimeDependency_Association()
     * @see data.classes.Association#getTimeDependency
     * @model opposite="timeDependency"
     * @generated
     */
	Association getAssociation();

	/**
     * Sets the value of the '{@link data.timedependency.TimeDependency#getAssociation <em>Association</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Association</em>' container reference.
     * @see #getAssociation()
     * @generated
     */
	void setAssociation(Association value);

} // TimeDependency
