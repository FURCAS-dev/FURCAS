/**
 * <copyright>
 * </copyright>
 *
 * $Id: NavigationRole.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Navigation Role</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage#getNavigationRole()
 * @model
 * @generated
 */
public enum NavigationRole implements Enumerator
{
	/**
	 * The '<em><b>ITERATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ITERATOR_VALUE
	 * @generated
	 * @ordered
	 */
	ITERATOR(0, "ITERATOR", "ITERATOR"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ACCUMULATOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCUMULATOR_VALUE
	 * @generated
	 * @ordered
	 */
	ACCUMULATOR(0, "ACCUMULATOR", "ACCUMULATOR"), //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>EXPRESSION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXPRESSION_VALUE
	 * @generated
	 * @ordered
	 */
	EXPRESSION(0, "EXPRESSION", "EXPRESSION"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ITERATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ITERATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ITERATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ITERATOR_VALUE = 0;

	/**
	 * The '<em><b>ACCUMULATOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ACCUMULATOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCUMULATOR
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ACCUMULATOR_VALUE = 0;

	/**
	 * The '<em><b>EXPRESSION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXPRESSION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXPRESSION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int EXPRESSION_VALUE = 0;

	/**
	 * An array of all the '<em><b>Navigation Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final NavigationRole[] VALUES_ARRAY =
		new NavigationRole[]
		{
			ITERATOR,
			ACCUMULATOR,
			EXPRESSION,
		};

	/**
	 * A public read-only list of all the '<em><b>Navigation Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<NavigationRole> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Navigation Role</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NavigationRole get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			NavigationRole result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Navigation Role</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NavigationRole getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			NavigationRole result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Navigation Role</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NavigationRole get(int value)
	{
		switch (value)
		{
			case ITERATOR_VALUE: return ITERATOR;
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
	private NavigationRole(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //NavigationRole
