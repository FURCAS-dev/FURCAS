/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-11-21 16:16:57 +0100 (Fr, 21 Nov 2008) $
 * Revision: $Revision: 2322 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.common.interfaces;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sap.furcas.runtime.common.exceptions.DeferredActionResolvingException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;

/**
 * This interface defines a set of methods allowing to create and change model elements
 * (CRUD actions).
 * 
 * A ModelAdapter may have state insofar as it may choose to defer creation or update actions,
 * e.g. in order to wait for some more data to be send before deciding whether to create or
 * reuse a modelElement, or in order to create immutable ModelElements (such as StructureTypes).
 *
 * @see {@linkplain IModelAdapter} for an enhanced version of this interface that is aware
 *      of the textual representation of the modified model elements.
 */
public interface IBareModelAdapter extends IModelElementInvestigator { // extends Investigator for convenience

    /**
     * Returns true if the ModelAdapter has some deferred actions that could
     * be performed calling performDeferredActions.
     */
    public boolean hasDeferredActions();

    /**
     * Performs deferred actions, if any.
     * 
     * The method returns a map, mapping mock objects to real
     * model elements, such that any code that previously dealt with mock
     * elements as if they were model elements may make a substitution.
     * 
     * The exception thrown is a collection of ModelAdapterException to
     * accommodate for the adapter trying to resolve as many actions as
     * possible, as it should best do.
     * 
     * The contract is that if this method finishes without an exception,
     * then hasDeferredActions() would have returned true.
     * 
     * @throws DeferredActionResolvingException
     * @returns a map mapping mock Objects to real model Elements
     */
    public Map<Object, Object> performAllDeferredActions() throws DeferredActionResolvingException;

    /**
     * Creates a new element of the named type in the model. The returned
     * Object should allow calling set() and the other methods of this
     * interface such that the ModelAdapter can then set an attribute to a
     * corresponding modelElement (meaning it is allowed to return proxies
     * rather than actual modelElements).
     */
    public abstract Object createElement(List<String> typeName) throws ModelAdapterException;

    /**
     * Commands the Adapter to find a modelElement of targetType having
     * targetKeyName == targetKeyValue, and then set this modelelement as
     * reference of property referencePropertyName of the given
     * source modelelement.
     * 
     * For example: setReference (John, "father", "person", "name", "Henry")
     * should find a Person of name Henry and make this the father of John.
     * 
     * @param SourceModelElement the type name
     * @param targetType qualified name of the type of the referenced object
     * @param targetKeyName  key to identify the target reference among candidates
     * @param targetkeyValue value to identify the candidate
     * 
     * @return the referred Object or null if none could be found
     * 
     * @throws ModelAdapterException if the model adapter could not perform some operation because of an exception
     * @throws ReferenceSettingException if setting the reference failed for practical reasons, i.e. ambiguous reference
     */
    public Object setReferenceWithLookup(Object sourceModelElement, String referencePropertyName, List<String> targetType, String targetKeyName,
            Object targetKeyValue) throws ModelAdapterException, ReferenceSettingException;

    /**
     * Searches immediately within the contextObject for elements of the
     * given type, with the given key and value, then set the reference to
     * those.
     * 
     * Sets within context of an element, if not null, contextElement must be a subtype of type MOF::Namespace (thus containing
     * other modelElements)
     * 
     * @see com.sap.furcas.runtime.parser.IModelAdapter#setReferenceWithContextLookup(java.lang.Object, java.lang.String, java.util.List,
     *      java.lang.String, java.lang.Object, java.lang.Object)
     */
    public Object setReferenceWithContextLookup(Object modelElement, String propertyName, List<String> valueTypeName, String keyName,
            Object keyValue, Object contextObject) throws ModelAdapterException, ReferenceSettingException;

    /**
     * Sets (or adds for multi-valued) property of the model element to some
     * object value. The contract is that both the modelElement and the
     * value are objects created by a create... method of the modelAdapter
     * (or primitives for value).
     */
    public void set(Object modelElement, String prop, Object value) throws ModelAdapterException;

    /**
     * Same as {@link #set(Object, String, Object)} with additionally
     * specified index on where to set the value in an ordered property.
     */
    public void set(Object modelElement, String prop, Object value, int index) throws ModelAdapterException;

    /**
     * Unsets the poperty <tt>prop</tt> of the given <tt>modelElement</tt> which had the given
     * <tt>value</tt> before.
     */
    public void unset(Object modelElement, String prop, Object value) throws ModelAdapterException;

    /**
     * Creates or simply returns an enum literal.
     */
    public Object createEnumLiteral(List<String> enumName, String name) throws ModelAdapterException;

    /**
     * Attempts to set the feature of the given name of the given
     * modelElement to another modelelement to be retrieved using the query,
     * in which the keyValue can be used (which can also be a model element!).
     */
    public Object setReferenceWithOCLQuery(Object modelElement, String propertyName, Object keyValue, String oclQuery, Object contextElement,
            Object currentForeachElement) throws ModelAdapterException, ReferenceSettingException;

    /**
     * Creates a new Reference by using the model element of the ocl query as base
     */
    public Collection<?> evaluateOCLQuery(Object modelElement, Object keyValue, String oclQuery, Object contextElement) throws ModelAdapterException;
    
    /**
     * Queries for a modelElement of the given type having the attributes specified.
     */
    public Collection<Object> queryElement(List<String> type, Map<String, List<Object>> attributes) throws ModelAdapterException;
}
