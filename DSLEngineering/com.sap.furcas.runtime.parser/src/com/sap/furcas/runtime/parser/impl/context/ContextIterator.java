/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * Revision: $Revision: 6272 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.impl.context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * The Class ContextIterator allows to traverse a context including imported contexts.
 * 
 */
class ContextIterator implements Iterator<Object> {
	
	/** This Iterator returns elements of the model  */
	private Iterator<?> generalIterator;
	
	/** The current iterator. */
	private ContextIterator currentIterator = null;
	
	/** The imported contexts. */
	private Iterator<Object> importedContexts;
	
	/** The traversed. */
	private List<Context> traversed;
	
	// TODO: Use this for Delayed references somehow
	/** The finish current. */
	private boolean finishCurrent = false;
	
	/**
	 * Instantiates a new context iterator for the given context, including importedContexts.
	 * 
	 * @param context the c
	 * @param i the i
	 * @param importedContexts2 the imported contexts2
	 */
	public ContextIterator(Context context, Iterator<?> i, List<Object> importedContexts2) {
		 this(new ArrayList<Context>(), context, i, importedContexts2);
	}
	
	/**
	 * Instantiates a new context iterator.
	 * 
	 * @param traversed the traversed
	 * @param c the c
	 * @param i the i
	 * @param imported the imported
	 */
	public ContextIterator(List<Context> traversed, Context c, Iterator<?> i, List<Object> imported) {
		this.traversed = traversed;
		traversed.add(c);
		this.generalIterator = i;
		this.importedContexts = imported.iterator();
	}
	
	/**
	 * sets the finishCurrent variable to true and calls finishCurrent on currentIterator recursively.
	 */
	public void finishCurrent() {
		finishCurrent = true;
		if (this.currentIterator != null) {
		    this.currentIterator.finishCurrent();
        }
	}
	
	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
	    if ( ! this.generalIterator.hasNext()) {
	        // analyze whether we need to find another generalContext to go through next
	        while (importedContexts.hasNext() && !finishCurrent) {
	            // loop over imported contexts
	            Context c = (Context) importedContexts.next();
	            if (! traversed.contains(c)) {
	                // find one imported context that has not been traversed
	                traversed.add(c);
	                // mark that context as traversed
	                this.currentIterator = c.iterator(traversed);
	                this.generalIterator = this.currentIterator;
	                break;
	            } else {
	                throw new RuntimeException("Context found multiple times in imported Contexts: " + c);
	            }
	        }
	    }
		return this.generalIterator.hasNext();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
		return generalIterator.next();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}

