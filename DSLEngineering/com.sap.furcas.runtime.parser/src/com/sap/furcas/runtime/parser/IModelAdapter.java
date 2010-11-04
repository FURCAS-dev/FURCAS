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

import org.eclipse.emf.ecore.resource.Resource;
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
     * returns true if the ModelAdapter has some deferred actions that could be performed
     * calling performDeferredActions
     * @return
     */
    boolean hasDeferredActions();
    
    /**
     * performs deferred actions, if any. The contract is that if this method finishes without Exception,
     * then hasDeferredActions() would return false if called next.
     * The method returns a map mapping mock objects to real model elements, such that any code that 
     * previously dealt with mock elements as if they were Modelelements may make a substitution.
     * The exception thrown is a collection of ModelAdapterException to accommodate for the adapter
     * trying to resolve as many actions as possible, as it should best do.
     * @throws DeferredActionResolvingException
     * @returns a map mapping mock Objects to real model Elements
     */
    Map<Object, Object> performAllDeferredActions() throws DeferredActionResolvingException;
    


	
	/**
     * creates a new element of the named type in the model or reuses an existing one 
     * and sets the features as given by the map.
     * Reusage policy is expected as follows: If the adapter is aware that this is a reparsing 
     * of a text, and for the given location a mapping test2ModelElement exists already, and the
     * existing ModelElement Type matches then the adapter should use that 
     * existing modelElement and change attributes if required.
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
    Object createOrResolveElement(List<String> typeName, Map<String, List<Object>> attributes, ANTLR3LocationToken firstToken, ANTLR3LocationToken lastToken, boolean resolveOnly, boolean createOnly) throws ModelAdapterException, ModelElementCreationException;

	
	/**
	 * commands the Adapter to find a modelElement of targetType 
	 * having targetKeyName == targetKeyValue, and then set this
	 * modelelement as reference of property referencePropertyName
	 * of the given modelelement.
	 * i.e. setReference (John, "father", "person", "name", "Henry")
	 * should find a Person of name Henry and make this the father of John. 
	 * 
	 * @param SourceModelElement the type name
	 * @param targetType qualified name of the type of the referenced object
	 * @param targetKeyName key to identify the target reference among candidates
	 * @param targetkeyValue value to identify the candidate
	 * 
	 * @return the referred Object or null if none could be found
	 * 
	 * @throws ModelAdapterException if the model adapter could not perform some operation because of an exception
	 * @throws ReferenceSettingException if setting the reference failed for practical reasons, i.e. ambiguous reference
	 */
	Object setReference(Object sourceModelElement, String referencePropertyName, List<String> targetType, String targetKeyName, Object targetKeyValue) throws ModelAdapterException, ReferenceSettingException;

	 /**
	  * Searches immediately within the contextObject for Elements of the given type, 
	  * with the given key and value, then set the reference to those.
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
            List<String> valueTypeName, String keyName, Object keyValue, Object contextObject) throws ModelAdapterException, ReferenceSettingException;
    
	
	/**
	 * sets ( or adds for multivalued) property of the model element to some object value.
	 * The contract is that both the modelElement and the value are Objects created by a 
	 * create... method of the modelAdapter (or primitives for value).
	 * @param modelElement the modelElement
	 * @param prop the prop
	 * @param value the value
	 * 
	 * @throws ModelAdapterException the model handler exception
	 */ 
	void set(Object modelElement, String prop, Object value) throws ModelAdapterException;

	/**
	 * same as {@link #set(Object, String, Object)} with additionally specified index 
	 * on where to set the value in an ordered property.
	 * @param modelElement the modelElement
	 * @param prop the prop
	 * @param value the value
	 * @param index where to add the element within an ordered property
	 * 
	 * @throws ModelAdapterException the model handler exception
	 */ 
	void set(Object modelElement, String prop, Object value, int index) throws ModelAdapterException;


	/**
	 * Unsets the poperty <tt> prop</tt> of the given <tt>modelElement</tt> which had the given
	 * <tt>value</tt> before.
	 */
	void unset(Object modelElement, String prop, Object value) throws ModelAdapterException;
    /**
     * Creates or simply returns an enum literal.
     */
    Object createEnumLiteral(List<String> enumName, String name) throws ModelAdapterException;

    /**
     * Attempts to set the feature of the given name of the given modelElement to another 
     * modelelement to be retrieved using the query, in which the key Value can be used 
     * (which can also be a model Element!).
     */
    Object setOclReference(Object modelElement, String propertyName,
            Object keyValue, String mqlQuery, Object contextElement, Object currentForeachElement) throws ModelAdapterException, ReferenceSettingException;
    
    /**
     * Uses the oclQuery to create a new model element which is returned
     */
    Collection<?> getPredicateOclReference(Object modelElement, String propertyName,
            Object keyValue, String oclQuery, Object contextElement) throws ModelAdapterException;

    /**
     * Used to fetch the search scope where to find the mapping model for the given <tt>languageId</tt>.
     * 
     * @param con
     * @param languageId
     * @return
     */
    Collection<Resource> getPRIPartitions(ResourceSet rs, String languageId);

}
