/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.FURCAS.TCS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Auto Create Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getAutoCreateKind()
 * @model
 * @generated
 */
public enum AutoCreateKind implements Enumerator {
        /**
         * The '<em><b>Always</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #ALWAYS_VALUE
         * @generated
         * @ordered
         */
        ALWAYS(1, "always", "always"),

        /**
         * The '<em><b>Ifmissing</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #IFMISSING_VALUE
         * @generated
         * @ordered
         */
        IFMISSING(2, "ifmissing", "ifmissing"),

        /**
         * The '<em><b>Never</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #NEVER_VALUE
         * @generated
         * @ordered
         */
        NEVER(3, "never", "never");

        /**
         * The '<em><b>Always</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Always</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #ALWAYS
         * @model name="always"
         * @generated
         * @ordered
         */
        public static final int ALWAYS_VALUE = 1;

        /**
         * The '<em><b>Ifmissing</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Ifmissing</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #IFMISSING
         * @model name="ifmissing"
         * @generated
         * @ordered
         */
        public static final int IFMISSING_VALUE = 2;

        /**
         * The '<em><b>Never</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Never</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #NEVER
         * @model name="never"
         * @generated
         * @ordered
         */
        public static final int NEVER_VALUE = 3;

        /**
         * An array of all the '<em><b>Auto Create Kind</b></em>' enumerators.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private static final AutoCreateKind[] VALUES_ARRAY =
                new AutoCreateKind[] {
                        ALWAYS,
                        IFMISSING,
                        NEVER,
                };

        /**
         * A public read-only list of all the '<em><b>Auto Create Kind</b></em>' enumerators.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static final List<AutoCreateKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

        /**
         * Returns the '<em><b>Auto Create Kind</b></em>' literal with the specified literal value.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static AutoCreateKind get(String literal) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        AutoCreateKind result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal)) {
                                return result;
                        }
                }
                return null;
        }

        /**
         * Returns the '<em><b>Auto Create Kind</b></em>' literal with the specified name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static AutoCreateKind getByName(String name) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        AutoCreateKind result = VALUES_ARRAY[i];
                        if (result.getName().equals(name)) {
                                return result;
                        }
                }
                return null;
        }

        /**
         * Returns the '<em><b>Auto Create Kind</b></em>' literal with the specified integer value.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static AutoCreateKind get(int value) {
                switch (value) {
                        case ALWAYS_VALUE: return ALWAYS;
                        case IFMISSING_VALUE: return IFMISSING;
                        case NEVER_VALUE: return NEVER;
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
        private AutoCreateKind(int value, String name, String literal) {
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
        
} //AutoCreateKind
