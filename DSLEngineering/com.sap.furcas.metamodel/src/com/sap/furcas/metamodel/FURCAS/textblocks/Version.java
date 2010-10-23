/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblocks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Version</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.textblocks.TextblocksPackage#getVersion()
 * @model
 * @generated
 */
public enum Version implements Enumerator {
        /**
     * The '<em><b>REFERENCE</b></em>' literal object.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #REFERENCE_VALUE
     * @generated
     * @ordered
     */
        REFERENCE(0, "REFERENCE", "REFERENCE"),

        /**
     * The '<em><b>PREVIOUS</b></em>' literal object.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #PREVIOUS_VALUE
     * @generated
     * @ordered
     */
        PREVIOUS(1, "PREVIOUS", "PREVIOUS"),

        /**
     * The '<em><b>CURRENT</b></em>' literal object.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #CURRENT_VALUE
     * @generated
     * @ordered
     */
        CURRENT(2, "CURRENT", "CURRENT");

        /**
     * The '<em><b>REFERENCE</b></em>' literal value.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>REFERENCE</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @see #REFERENCE
     * @model
     * @generated
     * @ordered
     */
        public static final int REFERENCE_VALUE = 0;

        /**
     * The '<em><b>PREVIOUS</b></em>' literal value.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>PREVIOUS</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @see #PREVIOUS
     * @model
     * @generated
     * @ordered
     */
        public static final int PREVIOUS_VALUE = 1;

        /**
     * The '<em><b>CURRENT</b></em>' literal value.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>CURRENT</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @see #CURRENT
     * @model
     * @generated
     * @ordered
     */
        public static final int CURRENT_VALUE = 2;

        /**
     * An array of all the '<em><b>Version</b></em>' enumerators.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private static final Version[] VALUES_ARRAY =
                new Version[] {
            REFERENCE,
            PREVIOUS,
            CURRENT,
        };

        /**
     * A public read-only list of all the '<em><b>Version</b></em>' enumerators.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static final List<Version> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

        /**
     * Returns the '<em><b>Version</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static Version get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Version result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

        /**
     * Returns the '<em><b>Version</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static Version getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            Version result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

        /**
     * Returns the '<em><b>Version</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static Version get(int value) {
        switch (value) {
            case REFERENCE_VALUE: return REFERENCE;
            case PREVIOUS_VALUE: return PREVIOUS;
            case CURRENT_VALUE: return CURRENT;
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
        private Version(int value, String name, String literal) {
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
        
} //Version
