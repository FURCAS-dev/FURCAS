/**
 * 
 */
package com.sap.furcas.runtime.parser.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.Token;

import com.sap.furcas.runtime.common.interfaces.IModelElementProxy;

/**
 * A ModelElementProxy is a class that represents an occurence of a ModelElement
 * in a text. The intended use is currently that a parser lets the Injector
 * create a proxy, call diverse set methods on the proxy, and when done without
 * error, will make the injector resolve the proxy by creating it or retrieving
 * a suitable existing one.
 */
public class ModelElementProxy implements IModelElementProxy {

	private List<String> type;
	private Map<String, List<Object>> attributeMap = new HashMap<String, List<Object>>();
	private Object realObject;
	private boolean referenceOnly;
	private Token firstToken;
	private Token lastToken;
	private Object textBlock;

	/**
	 * @param name
	 * @param creationCandidate
	 *                true if this ModelElement may be created if it cannot
	 *                be resolved
	 * @param context
	 * @param addToContext2
	 */
	public ModelElementProxy(List<String> name, boolean creationCandidate) {
		type = name;
		referenceOnly = !creationCandidate; // if not a creation
							// candidate, is only
							// reference
	}

	public ModelElementProxy(List<String> name, boolean creationCandidate,
			Token firstToken) {
		this(name, creationCandidate);
		this.firstToken = firstToken;
	}

	/**
	 * @return
	 */
	public List<String> getType() {
		return type;
	}

	/**
	 * @return
	 */
	Set<String> getSetFeatures() {
		return attributeMap.keySet();
	}

	/**
	 * @return
	 */
	List<Object> getAttributeValues(String property) {
		return attributeMap.get(property);
	}

	/**
	 * @param prop
	 * @param value
	 */
	public void addProxyAttribute(String prop, Object value) {
		List<Object> existingList = attributeMap.get(prop);
		if (existingList == null) {
			existingList = new ArrayList<Object>();
		}
		if(value instanceof Collection<?>) {
		    existingList.addAll((Collection<?>)value);
		} else {
		    existingList.add(value);
		}
		attributeMap.put(prop, existingList);
	}

	/**
	 * @param prop
	 * @param value
	 * @param index
	 */
	public void addProxyAttribute(String prop, Object value, int index) {
		List<Object> existingList = attributeMap.get(prop);
		if (existingList == null) {
			existingList = new ArrayList<Object>();
		}
		if(value instanceof Collection<?>) {
		    existingList.addAll(index, (Collection<?>)value);
		} else {
		    existingList.add(index, value);
		}
		
		attributeMap.put(prop, existingList);
	}

	/**
	 * @param createdObject
	 */
	public void setRealObject(Object createdObject) {
		realObject = createdObject;
	}

	public Object getRealObject() {
		return realObject;
	}

	@Override
	public String toString() {
		String result = type.toString() + '{' + attributeMap + '}';
		if (realObject != null) {
			result += "=>" + realObject;
		}
		return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.textual.grammar.IModelElementProxy#isReferenceOnly()
	 */
	@Override
	public boolean isReferenceOnly() {
		return referenceOnly;
	}
	
	public void setIsReferenceOnly(boolean value) {
	    this.referenceOnly = value;
	}

	/**
	 * @return
	 */
	public Map<String, List<Object>> getAttributeMap() {

		return attributeMap;
	}

	/**
	 * @return the firstToken
	 */
	public Token getFirstToken() {
		return firstToken;
	}

	/**
	 * @param firstToken
	 *                the firstToken to set
	 */
	public void setFirstToken(Token firstToken) {
		this.firstToken = firstToken;
	}

	/**
	 * @return the lastToken
	 */
	public Token getLastToken() {
		return lastToken;
	}

	/**
	 * @param lastToken
	 *                the lastToken to set
	 */
	public void setLastToken(Token lastToken) {
		this.lastToken = lastToken;
	}

	/**
	 * Unsets the proxies prop.
	 * @param prop
	 * @param value
	 */
	public void unsetProxyAttribute(String prop, Object value) {
		List<Object> existingList = attributeMap.get(prop);
		if (existingList == null) {
			return;
		}
		if(value instanceof Collection<?>) {
		    existingList.removeAll((Collection<?>)value);
		} else {
		    existingList.remove(value);
		}
	}

        public void setTextBlock(Object currentTextBlock) {
            this.textBlock = currentTextBlock;
        }
        
        public Object getTextBlock() {
            return textBlock;
        }

}
