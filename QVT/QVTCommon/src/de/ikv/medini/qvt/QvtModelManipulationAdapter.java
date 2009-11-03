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

package de.ikv.medini.qvt;

import java.util.Collection;
import java.util.Set;

import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.standard.lib.OclAny;
import org.oslo.ocl20.standard.lib.OclAnyModelElement;

import de.ikv.medini.qvt.model.qvtbase.TypedModel;

/**
 * A model manipulation adapter is used by the QVT engine to create, delete and modify the values of model elements.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public interface QvtModelManipulationAdapter {

	/**
	 * Creates a model element of the given <code>oclModelElementType</code> in the given <code>typedModel</code>.
	 * 
	 * @param oclModelElementType
	 *            the type of the model element to be created.
	 * @param typedModel
	 *            the model in which to create the model element.
	 * @return the newly created model element.
	 */
	OclAnyModelElement createOclAnyModelElement(OclModelElementType oclModelElementType, TypedModel typedModel);

	/**
	 * Modifies the value of the given <code>property</code> in the given <code>modelElement</code>. If the property has single multiplicity, then its value should be set to
	 * <code>value</code>. Otherwise <code>value</code> should be added to its list of values.
	 * 
	 * @param modelElement
	 *            the model element whose property's value is to be set.
	 * @param property
	 *            the property whose value is to be modified.
	 * @param value
	 *            the value to set or add.
	 */
	void setOrAddValueForFeauture(OclAnyModelElement modelElement, Property property, OclAny value);

	/**
	 * Finds the given model element in the target model. Although the model element to search for is passed as an argument, it may have been actually deleted from the model since
	 * last accessed by the engine (e.g. as a result of deleting its container). In such a case, <code>null</code> must be returned. If the model element is still in the model,
	 * the <code>modelElement</code> argument can simply be returned.
	 * 
	 * @param modelElement
	 *            the model element to search for.
	 * @return <code>modelElement</code> if it is still contained in the target model, <code>null</code> otherwise.
	 */
	OclAny findElementInTarget(OclAny modelElement);

	/**
	 * Deletes the given <code>modelElement</code> from the target model.
	 * 
	 * @param modelElement
	 *            the model element to delete.
	 */
	void deleteElementInTarget(OclAny modelElement);

	/**
	 * Determines whether the given <code>modelElement</code> has been modified since the last transformation which produced the given trace.
	 * 
	 * TODO replace this with an override strategy that can be plugged into the engine.
	 * 
	 * @param modelElement
	 *            the model element whose modification is to be determined.
	 * @param oldTrace
	 *            the trace produced in the former transformation.
	 * @return true if modified, false not or cannot be determined.
	 * 
	 */
	boolean isModified(OclAnyModelElement modelElement, Trace oldTrace);

	/**
	 * Removes the given <code>values</code> from the <code>property</code>'s values of the given <code>modelElement</code>.
	 * 
	 * @param modelElement
	 *            the model element whose property's values are to be removed.
	 * @param property
	 *            the property whose values are to be removed.
	 * @param values
	 *            the values to remove. If the property does not have multiple multiplicity, this collection should contain only one value.
	 */
	void unsetOrRemoveValuesForFeature(OclAnyModelElement modelElement, Property property, Collection values);

	/**
	 * Checks whether <code>property1</code> is the opposite of <code>property2</code>
	 * 
	 * @param property1
	 * @param property2
	 * @return
	 */
	boolean isOpposite(Property property1, Property property2);

	/**
	 * Determines whether all referenced elements of <code>element</code> are within the given target set.
	 * 
	 * Thus, if <code>targetElements</code> is empty, true is returned if the element has no references at all.
	 * 
	 * @param element
	 * @param targetElements
	 *            set of {@link OclAny} instances
	 * @return
	 */
	boolean areAllReferencesWithin(OclAny element, Set targetElements);

	/**
	 * The reverse of {@link #setOrAddValueForFeauture(OclAnyModelElement, Property, OclAny)}
	 * 
	 * @param modelElement
	 *            the model element whose property's value is to be unset.
	 * @param property
	 *            the property whose value is to be modified.
	 * @param value
	 *            the value to unset or remove.
	 * @return true iff the value was set before
	 */
	boolean unsetOrRemoveValueForFeauture(OclAnyModelElement modelElement, Property property, OclAny value);

	/**
	 * Returns true iff the property is settable
	 * 
	 * @param property
	 * @return
	 */
	boolean isChangeable(Property property);

	/**
	 * Tells whether the given metaclass is abstract
	 * 
	 * @param type
	 * @return
	 */
	boolean isAbstract(Classifier type);

}
