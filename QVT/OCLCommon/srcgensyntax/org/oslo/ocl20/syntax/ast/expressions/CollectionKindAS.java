/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.expressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Collection Kind AS</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage#getCollectionKindAS()
 * @model
 * @generated
 */
public final class CollectionKindAS extends AbstractEnumerator {
	/**
	 * The '<em><b>SET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SET = 0;

	/**
	 * The '<em><b>BAG</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BAG</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BAG_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BAG = 1;

	/**
	 * The '<em><b>SEQUENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SEQUENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SEQUENCE = 2;

	/**
	 * The '<em><b>COLLECTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COLLECTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COLLECTION_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COLLECTION = 3;

	/**
	 * The '<em><b>ORDERED SET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ORDERED SET</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORDERED_SET_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ORDERED_SET = 4;

	/**
	 * The '<em><b>SET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET
	 * @generated
	 * @ordered
	 */
	public static final CollectionKindAS SET_LITERAL = new CollectionKindAS(SET, "SET", "SET");

	/**
	 * The '<em><b>BAG</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BAG
	 * @generated
	 * @ordered
	 */
	public static final CollectionKindAS BAG_LITERAL = new CollectionKindAS(BAG, "BAG", "BAG");

	/**
	 * The '<em><b>SEQUENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEQUENCE
	 * @generated
	 * @ordered
	 */
	public static final CollectionKindAS SEQUENCE_LITERAL = new CollectionKindAS(SEQUENCE, "SEQUENCE", "SEQUENCE");

	/**
	 * The '<em><b>COLLECTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COLLECTION
	 * @generated
	 * @ordered
	 */
	public static final CollectionKindAS COLLECTION_LITERAL = new CollectionKindAS(COLLECTION, "COLLECTION", "COLLECTION");

	/**
	 * The '<em><b>ORDERED SET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORDERED_SET
	 * @generated
	 * @ordered
	 */
	public static final CollectionKindAS ORDERED_SET_LITERAL = new CollectionKindAS(ORDERED_SET, "ORDERED_SET", "ORDERED_SET");

	/**
	 * An array of all the '<em><b>Collection Kind AS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CollectionKindAS[] VALUES_ARRAY =
		new CollectionKindAS[] {
			SET_LITERAL,
			BAG_LITERAL,
			SEQUENCE_LITERAL,
			COLLECTION_LITERAL,
			ORDERED_SET_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Collection Kind AS</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Collection Kind AS</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionKindAS get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionKindAS result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Kind AS</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionKindAS getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CollectionKindAS result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Collection Kind AS</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollectionKindAS get(int value) {
		switch (value) {
			case SET: return SET_LITERAL;
			case BAG: return BAG_LITERAL;
			case SEQUENCE: return SEQUENCE_LITERAL;
			case COLLECTION: return COLLECTION_LITERAL;
			case ORDERED_SET: return ORDERED_SET_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private CollectionKindAS(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CollectionKindAS
