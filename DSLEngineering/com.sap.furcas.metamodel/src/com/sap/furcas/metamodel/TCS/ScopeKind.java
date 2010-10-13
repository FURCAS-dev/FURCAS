/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.furcas.metamodel.TCS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Scope Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.TCS.TCSPackage#getScopeKind()
 * @model
 * @generated
 */
public enum ScopeKind implements Enumerator {
        /**
         * The '<em><b>Instance Complete</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #INSTANCE_COMPLETE_VALUE
         * @generated
         * @ordered
         */
        INSTANCE_COMPLETE(0, "instanceComplete", "instanceComplete"),

        /**
         * The '<em><b>Downwards Containment Complete</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #DOWNWARDS_CONTAINMENT_COMPLETE_VALUE
         * @generated
         * @ordered
         */
        DOWNWARDS_CONTAINMENT_COMPLETE(1, "DownwardsContainmentComplete", "DownwardsContainmentComplete"),

        /**
         * The '<em><b>Upwards Containment Complete</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #UPWARDS_CONTAINMENT_COMPLETE_VALUE
         * @generated
         * @ordered
         */
        UPWARDS_CONTAINMENT_COMPLETE(2, "UpwardsContainmentComplete", "UpwardsContainmentComplete"),

        /**
         * The '<em><b>Containment Complete</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #CONTAINMENT_COMPLETE_VALUE
         * @generated
         * @ordered
         */
        CONTAINMENT_COMPLETE(3, "ContainmentComplete", "ContainmentComplete"),

        /**
         * The '<em><b>Partial</b></em>' literal object.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see #PARTIAL_VALUE
         * @generated
         * @ordered
         */
        PARTIAL(4, "Partial", "Partial");

        /**
         * The '<em><b>Instance Complete</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Instance Complete</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #INSTANCE_COMPLETE
         * @model name="instanceComplete"
         * @generated
         * @ordered
         */
        public static final int INSTANCE_COMPLETE_VALUE = 0;

        /**
         * The '<em><b>Downwards Containment Complete</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Downwards Containment Complete</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #DOWNWARDS_CONTAINMENT_COMPLETE
         * @model name="DownwardsContainmentComplete"
         * @generated
         * @ordered
         */
        public static final int DOWNWARDS_CONTAINMENT_COMPLETE_VALUE = 1;

        /**
         * The '<em><b>Upwards Containment Complete</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Upwards Containment Complete</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #UPWARDS_CONTAINMENT_COMPLETE
         * @model name="UpwardsContainmentComplete"
         * @generated
         * @ordered
         */
        public static final int UPWARDS_CONTAINMENT_COMPLETE_VALUE = 2;

        /**
         * The '<em><b>Containment Complete</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Containment Complete</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #CONTAINMENT_COMPLETE
         * @model name="ContainmentComplete"
         * @generated
         * @ordered
         */
        public static final int CONTAINMENT_COMPLETE_VALUE = 3;

        /**
         * The '<em><b>Partial</b></em>' literal value.
         * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Partial</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
         * @see #PARTIAL
         * @model name="Partial"
         * @generated
         * @ordered
         */
        public static final int PARTIAL_VALUE = 4;

        /**
         * An array of all the '<em><b>Scope Kind</b></em>' enumerators.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        private static final ScopeKind[] VALUES_ARRAY =
                new ScopeKind[] {
                        INSTANCE_COMPLETE,
                        DOWNWARDS_CONTAINMENT_COMPLETE,
                        UPWARDS_CONTAINMENT_COMPLETE,
                        CONTAINMENT_COMPLETE,
                        PARTIAL,
                };

        /**
         * A public read-only list of all the '<em><b>Scope Kind</b></em>' enumerators.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static final List<ScopeKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

        /**
         * Returns the '<em><b>Scope Kind</b></em>' literal with the specified literal value.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static ScopeKind get(String literal) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        ScopeKind result = VALUES_ARRAY[i];
                        if (result.toString().equals(literal)) {
                                return result;
                        }
                }
                return null;
        }

        /**
         * Returns the '<em><b>Scope Kind</b></em>' literal with the specified name.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static ScopeKind getByName(String name) {
                for (int i = 0; i < VALUES_ARRAY.length; ++i) {
                        ScopeKind result = VALUES_ARRAY[i];
                        if (result.getName().equals(name)) {
                                return result;
                        }
                }
                return null;
        }

        /**
         * Returns the '<em><b>Scope Kind</b></em>' literal with the specified integer value.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public static ScopeKind get(int value) {
                switch (value) {
                        case INSTANCE_COMPLETE_VALUE: return INSTANCE_COMPLETE;
                        case DOWNWARDS_CONTAINMENT_COMPLETE_VALUE: return DOWNWARDS_CONTAINMENT_COMPLETE;
                        case UPWARDS_CONTAINMENT_COMPLETE_VALUE: return UPWARDS_CONTAINMENT_COMPLETE;
                        case CONTAINMENT_COMPLETE_VALUE: return CONTAINMENT_COMPLETE;
                        case PARTIAL_VALUE: return PARTIAL;
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
        private ScopeKind(int value, String name, String literal) {
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
        
} //ScopeKind
