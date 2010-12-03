/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.textblockdefinition;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Format Policy</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.textblockdefinition.TextblockdefinitionPackage#getFormatPolicy()
 * @model
 * @generated
 */
public enum FormatPolicy implements Enumerator {
        /**
	 * The '<em><b>KEEP ALWAYS</b></em>' literal object.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #KEEP_ALWAYS_VALUE
	 * @generated
	 * @ordered
	 */
        KEEP_ALWAYS(0, "KEEP_ALWAYS", "KEEP_ALWAYS"),

        /**
	 * The '<em><b>KEEP NEVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #KEEP_NEVER_VALUE
	 * @generated
	 * @ordered
	 */
        KEEP_NEVER(0, "KEEP_NEVER", "KEEP_NEVER"),

        /**
	 * The '<em><b>KEEP BEFORE</b></em>' literal object.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #KEEP_BEFORE_VALUE
	 * @generated
	 * @ordered
	 */
        KEEP_BEFORE(0, "KEEP_BEFORE", "KEEP_BEFORE"),

        /**
	 * The '<em><b>KEEP AFTER</b></em>' literal object.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @see #KEEP_AFTER_VALUE
	 * @generated
	 * @ordered
	 */
        KEEP_AFTER(0, "KEEP_AFTER", "KEEP_AFTER");

        /**
	 * The '<em><b>KEEP ALWAYS</b></em>' literal value.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>KEEP ALWAYS</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @see #KEEP_ALWAYS
	 * @model
	 * @generated
	 * @ordered
	 */
        public static final int KEEP_ALWAYS_VALUE = 0;

        /**
	 * The '<em><b>KEEP NEVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>KEEP NEVER</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @see #KEEP_NEVER
	 * @model
	 * @generated
	 * @ordered
	 */
        public static final int KEEP_NEVER_VALUE = 0;

        /**
	 * The '<em><b>KEEP BEFORE</b></em>' literal value.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>KEEP BEFORE</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @see #KEEP_BEFORE
	 * @model
	 * @generated
	 * @ordered
	 */
        public static final int KEEP_BEFORE_VALUE = 0;

        /**
	 * The '<em><b>KEEP AFTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>KEEP AFTER</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
	 * @see #KEEP_AFTER
	 * @model
	 * @generated
	 * @ordered
	 */
        public static final int KEEP_AFTER_VALUE = 0;

        /**
	 * An array of all the '<em><b>Format Policy</b></em>' enumerators.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        private static final FormatPolicy[] VALUES_ARRAY =
                new FormatPolicy[] {
			KEEP_ALWAYS,
			KEEP_NEVER,
			KEEP_BEFORE,
			KEEP_AFTER,
		};

        /**
	 * A public read-only list of all the '<em><b>Format Policy</b></em>' enumerators.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static final List<FormatPolicy> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

        /**
	 * Returns the '<em><b>Format Policy</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static FormatPolicy get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FormatPolicy result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

        /**
	 * Returns the '<em><b>Format Policy</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static FormatPolicy getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FormatPolicy result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

        /**
	 * Returns the '<em><b>Format Policy</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
	 * @generated
	 */
        public static FormatPolicy get(int value) {
		switch (value) {
			case KEEP_ALWAYS_VALUE: return KEEP_ALWAYS;
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
        private FormatPolicy(int value, String name, String literal) {
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
        
} //FormatPolicy
