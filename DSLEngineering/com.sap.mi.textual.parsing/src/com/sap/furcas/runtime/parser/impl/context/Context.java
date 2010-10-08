/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-06-17 18:01:56 +0200 (Mi, 17 Jun 2009) $
 * Revision: $Revision: 7088 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.impl.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * implements a tree based structure to look up duplicates and missing references.
 */
class Context {
	
	/** The context element. */
	private Object element;
	
	/** The parent. */
	private Context parent;
	
	/** The contents. Does not have to be list, but makes it easier this way for testing */
	private List<Object> contents = new ArrayList<Object>();
	
	/** The imported contexts. */
	private List<Object> importedContexts = new ArrayList<Object>(); 
	
	private Collection<Context> childContexts;
	
	private String[] tags;

	// Only for root Context
    /**
     * Instantiates a new context.
     */
    public Context() {
        this.parent = null;
    }
    
    /**
     * Instantiates a new context.
     * 
     * @param element the element
     * @param parent the parent
     */
    private Context(Object element, Context parent) {
        this();
        this.parent = parent;
        this.element = element;
        this.parent.addChild(this);
    }
    
	
	/**
     * @param context
     */
    private void addChild(Context context) {
        if (this.childContexts == null) {
            this.childContexts = new ArrayList<Context>();
        }
        this.childContexts.add(context);
    }

    /**
	 * returns a new context which is a child of this context, adds the context to the map of elements to Contexts.
	 * 
	 * @param element the element
	 * @param contextByElement the context by element
	 * 
	 * @return the context
	 */
	public Context createContext(Object element) {
		Context newContext = new Context(element, this);
		
		return newContext;
	}


	/**
	 * Adds the element to this context.
	 * 
	 * @param element the e
	 */
	public void add(Object element) {
		contents.add(element);
	}
	
	/**
	 * Iterator.
	 * 
	 * @return the context iterator
	 */
	public ContextIterator iterator() {
	    // special construction to iterate over own and imported contexts
		return new ContextIterator(this, contents.iterator(), importedContexts);
	}
	
	/**
	 * Iterator getter for internal use only, keeps track of already traversed imported contexts.
	 * 
	 * @param traversed the traversed
	 * 
	 * @return the context iterator
	 */
	ContextIterator iterator(List<Context> traversed) {
		return new ContextIterator(traversed, this, contents.iterator(), importedContexts);
	}
	
	/**
	 * Parent.
	 * 
	 * @return the context
	 */
	public Context getParent() {
		return parent;
	}
	
	/**
	 * Import context.
	 * 
	 * @param c the c
	 */
	public void importContext(Context c) {
		importedContexts.add(c);
	}
	
	/**
	 * Gets the element.
	 * 
	 * @return the element
	 */
	public Object getElement() {
		return element;
	}
	
	/**
     * Gets the element.
     * 
     * @return the element
     */
    public void setElement(Object element) {
        this.element = element;
    }

	public String toString() {
	    return this.element + " " + this.contents;
	}

    /**
     * @return
     */
    public Collection<Context> getChildContexts() {
        return this.childContexts;
    }

    /**
     * @param proxy
     * @param realObject
     */
    public void replaceElement(Object proxy, Object realObject) {
        if (this.contents.remove(proxy)) {
            contents.add(realObject);
        }
    }

    /**
     * recursive call to remove a whole subtree from the map, and remove the parent() relationships.
     * @param childContext 
     * @param contextByElement
     * @return all elements removed from subTree as a Set
     */
    public static Set<Object> removeWithChildren(Context childContext) {
        // initialize result HashSet and call recursive method.
        Set<Object> resultSet = new HashSet<Object>();
        removeWithChildren(childContext.getParent(), childContext, resultSet);
        return resultSet;
    }
    
    private static void removeWithChildren(Context parentContext, Context childContext, Set<Object> deletedObjects) {
        // recursively call for all sub contexts
        Collection<Context> childSubContexts = childContext.childContexts;
        if (childSubContexts != null) {
            List<Context> toBeRemoved = new ArrayList<Context>();
            for (Iterator<Context> iterator = childSubContexts.iterator(); iterator.hasNext();) {
                Context subContext = iterator.next();
                toBeRemoved.add(subContext);
            }
            // cannot remove while going through iterator, therefore removing here.
            for (Iterator<Context> iterator = toBeRemoved.iterator(); iterator.hasNext();) {
                Context subContext = iterator.next();
                removeWithChildren(childContext, subContext, deletedObjects);
            }
        }
        
        // add actual element of context for removal
        deletedObjects.addAll(childContext.contents);
        
        if (parentContext != null) {
            parentContext.childContexts.remove(childContext);
            parentContext.contents.remove(childContext.getElement());
            // add elements in context for removal
            deletedObjects.add(childContext.getElement());
            childContext.parent = null;
        }
        
    }

    /**
     * @param proxy
     */
    public void remove(Object proxy) {
        this.contents.remove(proxy);
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags2) {
        this.tags = tags2;
    }

    public List<Object> getElements() {
	return contents;
    }
	
}

