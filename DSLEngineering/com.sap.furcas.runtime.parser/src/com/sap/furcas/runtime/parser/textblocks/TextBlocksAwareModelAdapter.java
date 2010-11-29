/**
 * 
 */
package com.sap.furcas.runtime.parser.textblocks;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.runtime.common.exceptions.DeferredActionResolvingException;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.common.exceptions.ReferenceSettingException;
import com.sap.furcas.runtime.common.interfaces.IBareModelAdapter;
import com.sap.furcas.runtime.parser.ANTLR3LocationToken;
import com.sap.furcas.runtime.parser.ModelElementCreationException;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;
import com.sap.furcas.runtime.parser.impl.ModelElementProxy;
import com.sap.furcas.runtime.tcs.TcsUtil;


/**
 * simple implementation using a simple resolution strategy and a IBareModelAdapter else.
 */
public class TextBlocksAwareModelAdapter extends DefaultTextAwareModelAdapter {

    private final IBareModelAdapter modelAdapter;

    
    /**
     * @param modelAdapter
     */
    public TextBlocksAwareModelAdapter(IBareModelAdapter modelAdapter) {
        super(modelAdapter);
        if (modelAdapter == null) {
            throw new IllegalArgumentException();
        }
        this.modelAdapter = modelAdapter;
    }
    

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.ITextAwareModelAdapter#createOrResolveElement(java.util.List, java.util.Map, com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken, com.sap.mi.textual.grammar.antlr3.ANTLR3LocationToken)
     */
    @Override
    public Object createOrResolveElement(List<String> typeName,
            Map<String, List<Object>> attributes, ANTLR3LocationToken firstToken,
            ANTLR3LocationToken lastToken, boolean resolveOnly, boolean createOnly) throws ModelAdapterException, ModelElementCreationException {

//        ModelElementProxy proxy = (ModelElementProxy) proxyObject;
        // If referenceOnly, merely resolve it, don't create it
        if (resolveOnly) {

            try {
                Collection<Object> resultSet = modelAdapter.queryElement(typeName, attributes);

                if (resultSet != null && resultSet.size()>=1) {
                    if (resultSet.size()==1) {
                        return resultSet.iterator().next();
                    } else {
                        throw new ModelElementCreationException("Reference " + typeName  + " with attributes " + attributes + " is ambiguous.");
                    }
                } else {
                   throw new ModelElementCreationException("Reference "+typeName  + " with attributes " + attributes +" could not be resolved.");
                }
            } catch (ModelAdapterException e) {
                // TODO move this to getModelAdapter() and delete ModelElement on errors (?)
                throw new ModelElementCreationException("BUG: Exception resolving type " + typeName + " with attributes " + attributes + " : " + e.getMessage(), e);
            }
        } else { // create new object and set its attributes, this is the default behavior
        	Object createdObject = null;
        	//TODO:This is only a temporary solution
        	//Re-Use ModelElement if there is one in the "old textblock with the same type"
//        	AbstractToken tok = input.getTokenModelElementForParserToken(firstToken);
//        	if(tok != null && tok.getParentBlock() != null) {
//        		//check the reference version
//        		TextBlock referenceVersionTB = TbVersionUtil.getOtherVersion(tok.getParentBlock(), VersionEnum.REFERENCE);
//        		if(referenceVersionTB != null) {
//	        		for (RefObject ro : referenceVersionTB.getCorrespondingModelElements()) {
//						//if type equals given name re-use that element
//	        			if(((MofClass)ro.refMetaObject()).getQualifiedName().equals(typeName)){
//	        				if(createdObject != null) {
//	        					ParsingTextblocksActivator.logWarning("Multiple elements could be re-used, during update phase, we're using the first one:" + ro);
//	        				}
//	        				createdObject = ro;
//	        			}
//					}
//        		}
//        	} 
        	//nothing found, so create a new element
        	if(true /*createdObject == null*/) {
        		createdObject = modelAdapter.createElement(typeName);
        	}
        	if(createdObject == null) {
        		return null;
        	}
            
            Set<String> features = attributes.keySet();
            for (String prop : features) {
                List<Object> valueList = attributes.get(prop);
                for (Iterator<Object> iterator = valueList.iterator(); iterator.hasNext();) {
                    // TODO: for single value properties, cause error when trying to set more than once?
                    Object value = iterator.next();
                    if (value instanceof ModelElementProxy) {
                        ModelElementProxy valueProxy = (ModelElementProxy) value;
                        value = valueProxy.getRealObject();
                      //TODO this should be checked after delayed references have been resolved as
                        //due to semantically predicated templates elements may be resolved later on
//                        if (value == null) 
//                        	throw new RuntimeException("Bug: proxy value for '" +prop +"' of type "+valueProxy.getType()+" had not been resolved.");
                    }
                    try {
                        set(createdObject, prop, value);
                    } catch (ModelAdapterException e) {
                        // TODO move this to getModelAdapter() and delete ModelElement on errors (?)
                        throw new ModelElementCreationException("Exception setting feature " + prop + " for object " + createdObject + " to " + value + ": " + e.getMessage(), e);
                    }
                }
            }
            return createdObject;
        }       
    }
    

  


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#createEnumLiteral(java.util.List, java.lang.String)
     */
    @Override
    public Object createEnumLiteral(List<String> enumName, String name)
            throws ModelAdapterException {
        return modelAdapter.createEnumLiteral(enumName, name);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#hasDeferredActions()
     */
    @Override
    public boolean hasDeferredActions() {
        return modelAdapter.hasDeferredActions();
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#performAllDeferredActions()
     */
    @Override
    public Map<Object, Object> performAllDeferredActions()
            throws DeferredActionResolvingException {
        return modelAdapter.performAllDeferredActions();
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object, java.lang.String, java.lang.Object)
     */
    @Override
    public void set(Object modelElement, String prop, Object value)
            throws ModelAdapterException {
        modelAdapter.set(modelElement, prop, value);
    }
    
    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#set(java.lang.Object, java.lang.String, java.lang.Object, int)
     */
    @Override
    public void set(Object modelElement, String prop, Object value, int index)
            throws ModelAdapterException {
        modelAdapter.set(modelElement, prop, value, index);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#setMQLReference(java.lang.Object, java.lang.String, java.lang.Object, java.lang.String, java.lang.Object)
     */
    @Override
    public Object setReferenceWithOCLQuery(Object modelElement, String propertyName,
            Object keyValue, String oclQuery, Object contextElement, Object currentForeachElement)
            throws ModelAdapterException, ReferenceSettingException {
        return modelAdapter.setReferenceWithOCLQuery(modelElement, propertyName, keyValue, oclQuery, contextElement, currentForeachElement);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#setReference(java.lang.Object, java.lang.String, java.util.List, java.lang.String, java.lang.Object)
     */
    @Override
    public Object setReferenceWithLookup(Object sourceModelElement,
            String referencePropertyName, List<String> targetType,
            String targetKeyName, Object targetKeyValue)
            throws ModelAdapterException, ReferenceSettingException {
        return modelAdapter.setReferenceWithLookup(sourceModelElement, referencePropertyName, targetType, targetKeyName, targetKeyValue);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelAdapter#setWithinContextObject(java.lang.Object, java.lang.String, java.util.List, java.lang.String, java.lang.Object, java.lang.Object)
     */
    @Override
    public Object setReferenceWithContextLookup(Object modelElement,
            String propertyName, List<String> valueTypeName, String keyName,
            Object keyValue, Object contextObject)
            throws ModelAdapterException, ReferenceSettingException {
        return modelAdapter.setReferenceWithContextLookup(modelElement, propertyName, valueTypeName, keyName, keyValue, contextObject);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelElementInvestigator#get(java.lang.Object, java.lang.String)
     */
    @Override
    public Object get(Object modelElement, String propertyName)
            throws ModelAdapterException {
        return modelAdapter.get(modelElement, propertyName);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelElementInvestigator#getMetaType(java.util.List)
     */
    @Override
    public Object getMetaType(List<String> typeName)
            throws ModelAdapterException {
        return modelAdapter.getMetaType(typeName);
    }

    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.IModelElementInvestigator#instanceOf(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean instanceOf(Object instance, Object metaType)
            throws ModelAdapterException {
        return modelAdapter.instanceOf(instance, metaType);
    }


	public void setTextBlocksStream(ITextBlocksTokenStream input) {
		// no-op; token stream not used by this class
	}

	@Override
	public Collection<URI> getPRIPartitions(ResourceSet conn, String languageId) {
		return TcsUtil.getSyntaxePartitions(conn, languageId);
	}
    
}
