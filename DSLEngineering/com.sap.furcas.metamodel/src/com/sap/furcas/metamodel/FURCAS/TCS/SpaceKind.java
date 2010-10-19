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
 * A representation of the literals of the enumeration '<em><b>Space Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getSpaceKind()
 * @model
 * @generated
 */
public enum SpaceKind implements Enumerator {
        /**
         * The '<em><b>Left Space</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #LEFT_SPACE_VALUE
         * @generated
         * @ordered
         */
        LEFT_SPACE(1, "leftSpace", "leftSpace"),

        /**
         * The '<em><b>Left None</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #LEFT_NONE_VALUE
         * @generated
         * @ordered
         */
        LEFT_NONE(2, "leftNone", "leftNone"),

        /**
         * The '<em><b>Right Space</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #RIGHT_SPACE_VALUE
         * @generated
         * @ordered
         */
        RIGHT_SPACE(3, "rightSpace", "rightSpace"),

        /**
         * The '<em><b>Right None</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #RIGHT_NONE_VALUE
         * @generated
         * @ordered
         */
        RIGHT_NONE(4, "rightNone", "rightNone");

        /**
         * The '<em><b>Left Space</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Left Space</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #LEFT_SPACE
         * @model name="leftSpace"
         * @generated
         * @ordered
         */
        public static final int LEFT_SPACE_VALUE = 1;

        /**
         * The '<em><b>Left None</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Left None</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #LEFT_NONE
         * @model name="leftNone"
         * @generated
         * @ordered
         */
        public static final int LEFT_NONE_VALUE = 2;

        /**
         * The '<em><b>Right Space</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Right Space</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #RIGHT_SPACE
         * @model name="rightSpace"
         * @generated
         * @ordered
         */
        public static final int RIGHT_SPACE_VALUE = 3;

        /**
         * The '<em><b>Right None</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Right None</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #RIGHT_NONE
         * @model name="rightNone"
         * @generated
         * @ordered
         */
        public static final int RIGHT_NONE_VALUE = 4;

        /**
         * An array of all the '<em><b>Space Kind</b></em>' enumerators.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private static final SpaceKind[] VALUES_ARRAY =
                new SpaceKind[] {
                        LEFT_SPACE,
                        LEFT_NONE,
                        RIGHT_SPACE,
                        RIGHT_NONE,
                };

        /**
         * A public read-only list of all the '<em><b>Space Kind</b></em>' enumerators.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static final List<SpaceKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

        /**
         * Returns the '<em><b>Space Kind</b></em>' literal with the specified literal value.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static SpaceKind get(String literal) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        SpaceKind result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal)) {
                                return result;
                        }
                }
                return null;
        }

        /**
         * Returns the '<em><b>Space Kind</b></em>' literal with the specified name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static SpaceKind getByName(String name) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        SpaceKind result = VALUES_ARRAY[i];
                        if (result.getName().equals(name)) {
                                return result;
                        }
                }
                return null;
        }

        /**
         * Returns the '<em><b>Space Kind</b></em>' literal with the specified integer value.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static SpaceKind get(int value) {
                switch (value) {
                        case LEFT_SPACE_VALUE: return LEFT_SPACE;
                        case LEFT_NONE_VALUE: return LEFT_NONE;
                        case RIGHT_SPACE_VALUE: return RIGHT_SPACE;
                        case RIGHT_NONE_VALUE: return RIGHT_NONE;
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
        private SpaceKind(int value, String name, String literal) {
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
        
} //SpaceKind
