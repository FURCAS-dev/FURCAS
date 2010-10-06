/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-11-21 16:16:57 +0100 (Fr, 21 Nov 2008) $
 * Revision: $Revision: 2322 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.mi.textual.grammar;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.furcas.textual.common.interfaces.IModelElementInvestigator;
import com.sap.mi.textual.grammar.exceptions.DeferredActionResolvingException;
import com.sap.mi.textual.grammar.exceptions.ReferenceSettingException;

/**
 * ModelAdapter merely containing actions in the model, rather than the
 * ITextAwareModelAdapter, which may have knowledge about text representation.
 */
public interface IBareModelAdapter extends IModelElementInvestigator { // extends
									// Investigator
									// for
									// convenience

	/**
	 * returns true if the ModelAdapter has some deferred actions that could
	 * be performed calling performDeferredActions
	 * 
	 * @return
	 */
	boolean hasDeferredActions();

	/**
	 * performs deferred actions, if any. The contract is that if this
	 * method finishes without Exception, then hasDeferredActions() would
	 * return true. The method returns a map mapping mock opbjects to real
	 * model elements, such that any code that previously dealt with mock
	 * elements as if they were Modelelements may make a substitution. The
	 * exception thrown is a collection of ModelAdapterException to
	 * accommodate for the adapter trying to resolve as many actions as
	 * possible, as it should best do.
	 * 
	 * @throws DeferredActionResolvingException
	 * @returns a map mapping mock Objects to real model Elements
	 */
	Map<Object, Object> performAllDeferredActions()
			throws DeferredActionResolvingException;

	/**
	 * creates a new element of the named type in the model. The returned
	 * Object should allow calling set() and the other methods of this
	 * interface such that the Modeladapter can then set an attribute to a
	 * corresponding modelElement (meaning it is allowed to return proxies
	 * rather than actual modelElements).
	 * 
	 * @param typeName
	 *                the type name
	 * 
	 * @return the object
	 * 
	 * @throws ModelAdapterException
	 *                 the model handler exception
	 */
	public abstract Object createElement(List<String> typeName)
			throws ModelAdapterException;

	/**
	 * commands the Adapter to find a modelElement of targetType having
	 * targetKeyName == targetKeyValue, and then set this modelelement as
	 * reference of property referencePropertyName of the given
	 * modelelement. i.e. setReference (John, "father", "person", "name",
	 * "Henry") should find a Person of name Henry and make this the father
	 * of John.
	 * 
	 * @param SourceModelElement
	 *                the type name
	 * @param targetType
	 *                qualified name of the type of the referenced object
	 * @param targetKeyName
	 *                key to identify the target reference among candidates
	 * @param targetkeyValue
	 *                value to identify the candidate
	 * 
	 * @return the referred Object or null if none could be found
	 * 
	 * @throws ModelAdapterException
	 *                 if the model adapter could not perform some operation
	 *                 because of an exception
	 * @throws ReferenceSettingException
	 *                 if setting the reference failed for practical
	 *                 reasons, i.e. ambiguous reference
	 */
	Object setReference(Object sourceModelElement,
			String referencePropertyName, List<String> targetType,
			String targetKeyName, Object targetKeyValue)
			throws ModelAdapterException, ReferenceSettingException;

	/**
	 * Searches immediately within the contextObject for Elements of the
	 * given type, with the given key and value, then set the reference to
	 * those.
	 * 
	 * @param modelElement
	 * @param propertyName
	 * @param valueTypeName
	 * @param keyName
	 * @param keyValue
	 * @param navigatedObject
	 * @return
	 * @throws ReferenceSettingException
	 * @throws ModelAdapterException
	 */
	Object setWithinContextObject(Object modelElement, String propertyName,
			List<String> valueTypeName, String keyName,
			Object keyValue, Object contextObject)
			throws ModelAdapterException, ReferenceSettingException;

	/**
	 * sets ( or adds for multivalued) property of the model element to some
	 * object value. The contract is that both the modelElement and the
	 * value are Objects created by a create... method of the modelAdapter
	 * (or primitives for value).
	 * 
	 * @param modelElement
	 *                the modelElement
	 * @param prop
	 *                the prop
	 * @param value
	 *                the value
	 * 
	 * @throws ModelAdapterException
	 *                 the model handler exception
	 */
	void set(Object modelElement, String prop, Object value)
			throws ModelAdapterException;

	/**
	 * same as {@link #set(Object, String, Object)} with additionally
	 * specified index on where to set the value in an ordered property.
	 * 
	 * @param modelElement
	 *                the modelElement
	 * @param prop
	 *                the prop
	 * @param value
	 *                the value
	 * @param index
	 *                where to add the element within an ordered property
	 * 
	 * @throws ModelAdapterException
	 *                 the model handler exception
	 */
	void set(Object modelElement, String prop, Object value, int index)
			throws ModelAdapterException;

	/**
	 * Unsets the poperty <tt> prop</tt> of the given <tt>modelElement</tt>
	 * which had the given <tt>value</tt> before.
	 * 
	 * @param modelElement
	 * @param prop
	 * @param value
	 * @throws ModelAdapterException 
	 * 
	 * @throws ModelAdapterException
	 */
	void unset(Object modelElement, String prop, Object value) throws ModelAdapterException;

	/**
	 * Creates or simply returns an enum literal.
	 * 
	 * @param enumName
	 * @param name
	 * @return
	 */
	Object createEnumLiteral(List<String> enumName, String name)
			throws ModelAdapterException;

	/**
	 * Attempts to set the feature of the given name of the given
	 * modelElement to another modelelement to be retrieved using the query,
	 * in which the key Value can be used (which can also be a model
	 * Element!).
	 * 
	 * @param modelElement
	 * @param propertyName
	 * @param keyValue
	 * @param mqlQuery
	 * @param contextElement
	 * @param currentForeachElement TODO
	 */
	Object setOclReference(Object modelElement, String propertyName,
			Object keyValue, String mqlQuery, Object contextElement, Object currentForeachElement)
			throws ModelAdapterException, ReferenceSettingException;
	/**
	 * Creates a new Reference by using the model element of the ocl query as base
	 * @param modelElement
	 * @param propertyName
	 * @param keyValue
	 * @param oclQuery
	 * @param contextElement
	 * @return
	 * @throws ModelAdapterException
	 */
	
	Collection<?> getPredicateOclReference(Object modelElement, String propertyName,
			Object keyValue, String oclQuery, Object contextElement)
			throws ModelAdapterException;

	/**
	 * Queries for a modelElement of the given type having the attributes
	 * specified.
	 * 
	 * @param type
	 * @param attributes
	 * @return
	 * @throws ModelAdapterException
	 */
	Collection<Object> queryElement(List<String> type,
			Map<String, List<Object>> attributes)
			throws ModelAdapterException;
	

}
