/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.ocl.test;

import java.util.List;
import java.util.Properties;

/**
 * The TestAdapter is responsible for handling technology-specific model manipulations such as creating, deleting and setting the values of model elements.
 * 
 * @author Joerg Kiegeland
 * @author Omar Ekine
 * 
 */
public interface OCLTestAdapter {

	/**
	 * The string to use in separating namespaces when specifying qualified model element names.
	 */
	public static final String NAMESPACE_SEPARATOR = "::";

	/**
	 * The regex string to use in separating namespaces when specifying qualified model element names.
	 */
	public static final String NAMESPACE_SEPARATOR_REGEX = "::";

	/**
	 * Creates a model element of the given type.
	 * 
	 * @param modelElementType
	 *            the fully qualified name of the class in the metamodel. The namespaces must be separated by {@link #NAMESPACE_SEPARATOR}.
	 * @return the newly created instance.
	 */
	Object createModelElement(String modelElementType);

	/**
	 * Sets the value of the <code>property</code> of the given <code>modelElement</code> to <code>value</code>.
	 * 
	 * @param modelElement
	 *            the model element whoose property value is to be set.
	 * @param property
	 *            the name of the property.
	 * @param value
	 *            the value to set. If <code>property has multiple multiplicity</code>, value can be a collection or an array.
	 */
	void setValueForFeature(Object modelElement, String property, Object value);

	/**
	 * Adds the given <code>value</code> the the list of values of the given <code>modelElement</code>'s <code>property</code>.
	 * 
	 * @param modelElement
	 *            the model element whoose property value is to be added.
	 * @param property
	 *            the name of the property. It must be a multi value property.
	 * @param value
	 *            the value(s) to add. To add many values at once, pass a collection or an array.
	 */
	void addValueForFeature(Object modelElement, String property, Object value);

	/**
	 * Deletes the given model element from the model.
	 * 
	 * @param modelElement
	 *            the model element to delete.
	 */
	void delete(Object modelElement);

	/**
	 * Evaluates the given <code>oclExpression</code>.
	 * 
	 * @param oclExpression
	 *            the OCL expression to evaluate.
	 * @return the list of values that resulted from the evaluation. If the expression is a constraint, the list should contain only one Bolean value.
	 */
	List evaluate(String oclExpression);

	/**
	 * Evaluates the given <code>oclExpression</code> on the given <code>self</code> model element.
	 * 
	 * @param oclExpression
	 *            the expression to evaluate.
	 * @param self
	 *            the model element to use as self.
	 * @return the list of values that resulted from the evaluation. If the expression is a constraint, the list should contain only one Bolean value.
	 */
	List evaluate(String oclExpression, Object self);

	void setUp(Properties properties) throws Exception;

	void tearDown() throws Exception;

	Number getNumber(int i);

	void setValueForStaticFeature(String className, String property, Object value);

	boolean supportStaticFeatures();

	Object getEnumLiteral(String qualifiedName);

	String getLiteralLabel(Object enumLiteral);

	public String getLiteralLabelFromQualifiedName(String qualifiedName);

	Object getIdentityObject(Object obj);

	boolean supportsTuple();

	Object getValueForFeature(Object modelElement, String property);

	/**
	 * Determines if the given <code>modelElement</code> is of the given <code>modelElementType</code>.
	 * 
	 * @param modelElement
	 *            the model element whose type is to be determined.
	 * @param modelElementType
	 *            the qualified type name.
	 * @param considerSuperTypes
	 *            if true, <code>modelElementType</code> may be a super type name.
	 * @return return true in one of the following cases:
	 *         <ul>
	 *         <li> the qualified name of the <code>modelElement</code> is the same as <code>modelElementType</code>.
	 *         <li> considerSuperTypes is true and the qualified name of the one of <code>modelElement</code>'s super types is the same as <code>modelElementType</code>.
	 *         <ul>
	 */
	boolean isOfType(Object modelElement, String modelElementType, boolean considerSuperTypes);
}
