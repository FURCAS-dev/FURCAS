/**
 * <copyright>
 *
 * Copyright (c) 2007, 2009 IBM Corporation, Zeligsoft Inc., Borland Software Corp., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Lexer and Parser refactoring to support extensibility and flexible error handling
 *             - Bugs 243976, 242236, 283509
 *   Zeligsoft - Bugs 245760, 243976, 242236
 *   Borland - Bug 266320
 *   
 * </copyright>
 *
 * $Id: AbstractBasicEnvironment.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.util.Collection;
import java.util.Map;

import org.eclipse.ocl.examples.pivot.options.Option;

/**
 * Partial implementation of the {@link BasicEnvironment} interface, providing
 * default behaviours for most features.
 * 
 * @since 1.2
 */
public abstract class AbstractBasicEnvironment implements BasicEnvironment {
	private BasicEnvironment parent;					// parent in environment hierarchy
	
	private final Map<Option<?>, Object> options =
	    new java.util.HashMap<Option<?>, Object>();
	
    /**
     * Initializes me with the specified parent environment, which should be
     * of the same type as me.
     * 
     * @param parent an environment of the same type as me (or <code>null</code>)
     */
	protected AbstractBasicEnvironment(BasicEnvironment parent) {	
		this.parent = parent;
	}

	/**
	 * The abstract environment implementation is adaptable.  The default
	 * implementation adapts to and interface actually implemented by the
	 * receiver in addition to the {@link ProblemHandler} interface.
	 * <p>
	 * Subclasses may override or extend this implementation.
	 * </p>
	 */
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(java.lang.Class<T> adapterType) {
		T result;
		
		if (adapterType.isAssignableFrom(getClass())) {
			result = (T) this;
		} else {
			result = null;
		}
		
		return result;
	}

    // implements the interface method
	public BasicEnvironment getParent() {
		return parent;
	}

    /**
     * Assigns me a parent environment after construction.  It is not advisable
     * to set the parent to <code>null</code> if I previously had one.
     * 
     * @param parent my new parent
     */
	protected void setParent(BasicEnvironment parent) {
		this.parent = parent;
	}
	
	protected Map<Option<?>, Object> basicGetOptions() {
	    return options;
	}
	
	public Map<Option<?>, Object> getOptions() {
		Map<Option<?>, Object> result = (getParent() != null)
			? new java.util.HashMap<Option<?>, Object>(getParent().getOptions())
		    : new java.util.HashMap<Option<?>, Object>();
		
		result.putAll(basicGetOptions());
		
		return result;
	}
	
	public <T> void setOption(Option<T> option, T value) {
		basicGetOptions().put(option, value);
	}
	
	public <T> void putOptions(Map<? extends Option<T>, ? extends T> options) {
		Map<Option<?>, Object> myOptions = basicGetOptions();
		
		myOptions.clear();
		myOptions.putAll(options);
	}
	
	public <T> T removeOption(Option<T> option) {
		T result = getValue(option);
		
		basicGetOptions().remove(option);
		
		return result;
	}
	
	public <T> Map<Option<T>, T> removeOptions(Collection<Option<T>> options) {
		Map<Option<T>, T> result = new java.util.HashMap<Option<T>, T>();
		
		Map<Option<?>, Object> myOptions = basicGetOptions();
		
		for (Option<T> next : options) {
			result.put(next, getValue(next));
			myOptions.remove(next);
		}
		
		return result;
	}
	
	public Map<Option<?>, Object> clearOptions() {
		Map<Option<?>, Object> myOptions = basicGetOptions();
		
		Map<Option<?>, Object> result = new java.util.HashMap<Option<?>, Object>(
				myOptions);
		
		myOptions.clear();
		
		return result;
	}
	
	public boolean isEnabled(Option<Boolean> option) {
		Boolean result = getValue(option);
		return (result == null)? false : result.booleanValue();
	}
	
	public <T> T getValue(Option<T> option) {
		@SuppressWarnings("unchecked")
		T result = (T) getOptions().get(option);
		
		if (result == null) {
		    result = (getParent() != null)? getParent().getValue(option)
		        : option.getDefaultValue();
		}
		
		return result;
	}
}