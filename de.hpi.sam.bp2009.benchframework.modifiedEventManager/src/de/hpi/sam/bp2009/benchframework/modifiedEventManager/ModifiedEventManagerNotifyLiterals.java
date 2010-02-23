/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.benchframework.modifiedEventManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>modified Event Manager Notify Literals</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hpi.sam.bp2009.benchframework.modifiedEventManager.ModifiedEventManagerPackage#getModifiedEventManagerNotifyLiterals()
 * @model
 * @generated
 */
public enum ModifiedEventManagerNotifyLiterals implements Enumerator {
	/**
	 * The '<em><b>START SUBSCRIPTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_SUBSCRIPTION_VALUE
	 * @generated
	 * @ordered
	 */
	START_SUBSCRIPTION(0, "START_SUBSCRIPTION", "START_SUBSCRIPTION"),

	/**
	 * The '<em><b>END SUBSCRIPTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_SUBSCRIPTION_VALUE
	 * @generated
	 * @ordered
	 */
	END_SUBSCRIPTION(1, "END_SUBSCRIPTION", "END_SUBSCRIPTION"),

	/**
	 * The '<em><b>START EMF EVENT HANDLING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_EMF_EVENT_HANDLING_VALUE
	 * @generated
	 * @ordered
	 */
	START_EMF_EVENT_HANDLING(2, "START_EMF_EVENT_HANDLING", "START_EMF_EVENT_HANDLING"),

	/**
	 * The '<em><b>END EMF EVENT HANDLING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_EMF_EVENT_HANDLING_VALUE
	 * @generated
	 * @ordered
	 */
	END_EMF_EVENT_HANDLING(3, "END_EMF_EVENT_HANDLING", "END_EMF_EVENT_HANDLING"),

	/**
	 * The '<em><b>START APPLICATION NOTIFICATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #START_APPLICATION_NOTIFICATION_VALUE
	 * @generated
	 * @ordered
	 */
	START_APPLICATION_NOTIFICATION(4, "START_APPLICATION_NOTIFICATION", "START_APPLICATION_NOTIFICATION"),

	/**
	 * The '<em><b>END APPLICATION NOTIFICATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #END_APPLICATION_NOTIFICATION_VALUE
	 * @generated
	 * @ordered
	 */
	END_APPLICATION_NOTIFICATION(5, "END_APPLICATION_NOTIFICATION", "END_APPLICATION_NOTIFICATION");

	/**
	 * The '<em><b>START SUBSCRIPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START SUBSCRIPTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_SUBSCRIPTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_SUBSCRIPTION_VALUE = 0;

	/**
	 * The '<em><b>END SUBSCRIPTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END SUBSCRIPTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END_SUBSCRIPTION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int END_SUBSCRIPTION_VALUE = 1;

	/**
	 * The '<em><b>START EMF EVENT HANDLING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START EMF EVENT HANDLING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_EMF_EVENT_HANDLING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_EMF_EVENT_HANDLING_VALUE = 2;

	/**
	 * The '<em><b>END EMF EVENT HANDLING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END EMF EVENT HANDLING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END_EMF_EVENT_HANDLING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int END_EMF_EVENT_HANDLING_VALUE = 3;

	/**
	 * The '<em><b>START APPLICATION NOTIFICATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>START APPLICATION NOTIFICATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #START_APPLICATION_NOTIFICATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int START_APPLICATION_NOTIFICATION_VALUE = 4;

	/**
	 * The '<em><b>END APPLICATION NOTIFICATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>END APPLICATION NOTIFICATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #END_APPLICATION_NOTIFICATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int END_APPLICATION_NOTIFICATION_VALUE = 5;

	/**
	 * An array of all the '<em><b>Notify Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ModifiedEventManagerNotifyLiterals[] VALUES_ARRAY =
		new ModifiedEventManagerNotifyLiterals[] {
			START_SUBSCRIPTION,
			END_SUBSCRIPTION,
			START_EMF_EVENT_HANDLING,
			END_EMF_EVENT_HANDLING,
			START_APPLICATION_NOTIFICATION,
			END_APPLICATION_NOTIFICATION,
		};

	/**
	 * A public read-only list of all the '<em><b>Notify Literals</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ModifiedEventManagerNotifyLiterals> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Notify Literals</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifiedEventManagerNotifyLiterals get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ModifiedEventManagerNotifyLiterals result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Notify Literals</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifiedEventManagerNotifyLiterals getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ModifiedEventManagerNotifyLiterals result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Notify Literals</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModifiedEventManagerNotifyLiterals get(int value) {
		switch (value) {
			case START_SUBSCRIPTION_VALUE: return START_SUBSCRIPTION;
			case END_SUBSCRIPTION_VALUE: return END_SUBSCRIPTION;
			case START_EMF_EVENT_HANDLING_VALUE: return START_EMF_EVENT_HANDLING;
			case END_EMF_EVENT_HANDLING_VALUE: return END_EMF_EVENT_HANDLING;
			case START_APPLICATION_NOTIFICATION_VALUE: return START_APPLICATION_NOTIFICATION;
			case END_APPLICATION_NOTIFICATION_VALUE: return END_APPLICATION_NOTIFICATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ModifiedEventManagerNotifyLiterals(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //modifiedEventManagerNotifyLiterals
