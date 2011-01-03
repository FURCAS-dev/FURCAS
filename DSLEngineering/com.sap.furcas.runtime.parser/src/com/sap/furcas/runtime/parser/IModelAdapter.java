/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-02-26 15:24:24 +0100 (Fr, 26 Feb 2010) $
 * Revision: $Revision: 9496 $
 * Author: $Author: d043530 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.DeferredActionResolvingException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IModelElementInvestigator;

/**
 * The Interface IModelAdapter, which is passed to the facade and will be called during parsing
 * whenever Model CRUD actions need to be executed.
 * A ModelAdapter may have state insofar as it may choose to defer creation or update actions,
 * e.g. in order to wait for some more data to be send before deciding whether to create or reuse a modelElement,
 * or in order to create immutable ModelElements (Such as MOF StructureTypes).
 */
public interface IModelAdapter extends IModelElementInvestigator { // extends Investigator for convenience

    /**
     * Returns true if the ModelAdapter has some deferred actions that could be performed
     * calling performDeferredActions
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
     * Creates a new element of the named type in the model or reuses an existing one 
     * and sets the features as given by the map.
     * 
     * Reusage policy is expected as follows: If the adapter is aware that this is a reparsing 
     * of a text, and for the given location a mapping test2ModelElement exists already, and the
     * existing ModelElement Type matches then the adapter should use that existing modelElement
     * and change attributes if required.
     * 
     * If the text is not reparsed it is still up to them ModelAdapter to decide whether to reuse some existing 
     * other ModelElement or not. E.g. all ModelElements of the same type with all the same attributes. 
     * This may be DSL specific, may involve custom code, and may also involve a user decision.
     * 
     * @param typeName the type name
     * @param firstToken may be null
     * @param lastToken
     * 
     * @return the object
     * 
     * @throws ModelAdapterException the model handler exception
     * @throws ModelElementCreationException 
     */
    public Object createOrResolveElement(List<String> typeName, Map<String, List<Object>> attributes, ANTLR3LocationToken firstToken,
            ANTLR3LocationToken lastToken, boolean resolveOnly, boolean createOnly) throws ModelAdapterException,
            ModelElementCreationException;

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
     * Searches immediately within the contextObject for Elements of the given type, 
     * with the given key and value, then set the reference to those.
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
     * Attempts to set the feature of the given name of the given modelElement to another 
     * modelelement to be retrieved using the query, in which the keyValue can be used 
     * (which can also be a model Element!).
     */
    public Object setReferenceWithOCLQuery(Object modelElement, String propertyName, Object keyValue, String oclQuery, Object contextElement,
            Object currentForeachElement) throws ModelAdapterException, ReferenceSettingException;

    /**
     * Creates a new Reference by using the model element of the ocl query as base
     */
    public Collection<?> evaluateOCLQuery(Object modelElement, Object keyValue, String oclQuery, Object contextElement) throws ModelAdapterException;

    /**
     * Used to fetch the search scope where to find the mapping model for the given <tt>languageId</tt>.
     */
    public Collection<URI> getPRIPartitions(ResourceSet rs, String languageId);
    
    /**
     * Return all modelElements of the given type with are known to this model adapter instance.
     */
    public Collection<Object> getElementsOfType(List<String> list) throws ModelAdapterException; 

}
