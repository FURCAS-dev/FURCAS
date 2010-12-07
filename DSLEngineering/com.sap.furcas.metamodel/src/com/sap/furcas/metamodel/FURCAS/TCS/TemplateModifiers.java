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
 * A representation of the literals of the enumeration '<em><b>Template Modifiers</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage#getTemplateModifiers()
 * @model
 * @generated
 */
public enum TemplateModifiers implements Enumerator {
        /**
     * The '<em><b>Abstract</b></em>' literal object.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #ABSTRACT_VALUE
     * @generated
     * @ordered
     */
        ABSTRACT(1, "abstract", "abstract"),

        /**
     * The '<em><b>Operatored</b></em>' literal object.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #OPERATORED_VALUE
     * @generated
     * @ordered
     */
        OPERATORED(2, "operatored", "operatored"),

        /**
     * The '<em><b>Main</b></em>' literal object.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #MAIN_VALUE
     * @generated
     * @ordered
     */
        MAIN(3, "main", "main"),

        /**
     * The '<em><b>Context</b></em>' literal object.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #CONTEXT_VALUE
     * @generated
     * @ordered
     */
        CONTEXT(4, "context", "context"),

        /**
     * The '<em><b>Add To Context</b></em>' literal object.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @see #ADD_TO_CONTEXT_VALUE
     * @generated
     * @ordered
     */
        ADD_TO_CONTEXT(5, "addToContext", "addToContext");

        /**
     * The '<em><b>Abstract</b></em>' literal value.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Abstract</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @see #ABSTRACT
     * @model name="abstract"
     * @generated
     * @ordered
     */
        public static final int ABSTRACT_VALUE = 1;

        /**
     * The '<em><b>Operatored</b></em>' literal value.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Operatored</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @see #OPERATORED
     * @model name="operatored"
     * @generated
     * @ordered
     */
        public static final int OPERATORED_VALUE = 2;

        /**
     * The '<em><b>Main</b></em>' literal value.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Main</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @see #MAIN
     * @model name="main"
     * @generated
     * @ordered
     */
        public static final int MAIN_VALUE = 3;

        /**
     * The '<em><b>Context</b></em>' literal value.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Context</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @see #CONTEXT
     * @model name="context"
     * @generated
     * @ordered
     */
        public static final int CONTEXT_VALUE = 4;

        /**
     * The '<em><b>Add To Context</b></em>' literal value.
     * <!-- begin-user-doc -->
         * <p>
         * If the meaning of '<em><b>Add To Context</b></em>' literal object isn't clear,
         * there really should be more of a description here...
         * </p>
         * <!-- end-user-doc -->
     * @see #ADD_TO_CONTEXT
     * @model name="addToContext"
     * @generated
     * @ordered
     */
        public static final int ADD_TO_CONTEXT_VALUE = 5;

        /**
     * An array of all the '<em><b>Template Modifiers</b></em>' enumerators.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        private static final TemplateModifiers[] VALUES_ARRAY =
                new TemplateModifiers[] {
            ABSTRACT,
            OPERATORED,
            MAIN,
            CONTEXT,
            ADD_TO_CONTEXT,
        };

        /**
     * A public read-only list of all the '<em><b>Template Modifiers</b></em>' enumerators.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static final List<TemplateModifiers> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

        /**
     * Returns the '<em><b>Template Modifiers</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static TemplateModifiers get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TemplateModifiers result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

        /**
     * Returns the '<em><b>Template Modifiers</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static TemplateModifiers getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            TemplateModifiers result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

        /**
     * Returns the '<em><b>Template Modifiers</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
     * @generated
     */
        public static TemplateModifiers get(int value) {
        switch (value) {
            case ABSTRACT_VALUE: return ABSTRACT;
            case OPERATORED_VALUE: return OPERATORED;
            case MAIN_VALUE: return MAIN;
            case CONTEXT_VALUE: return CONTEXT;
            case ADD_TO_CONTEXT_VALUE: return ADD_TO_CONTEXT;
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
        private TemplateModifiers(int value, String name, String literal) {
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
        
} //TemplateModifiers
