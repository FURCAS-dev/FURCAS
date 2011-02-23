/**
 * <copyright>
 *
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   E.D.Willink - Refactoring to support extensibility and flexible error handling 
 *   Zeligsoft - Bugs 243079, 244948, 244886, 246469, 233673
 *   Adolfo Sanchez-Barbudo Herrera - Bug 234354, 233673
 *
 * </copyright>
 *
 * $Id: AbstractEnvironment.java,v 1.4 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.options.Option;

/**
 * A partial implementation of the {@link Environment} interface providing
 * some useful common behavior for providers of metamodel bindings.  It is
 * recommended to extend this class rather than to implement the
 * <code>Environment</code> interface from scratch.
 * <p>
 * In particular, this class provides:
 * </p>
 * <ul>
 *   <li>maintenance of the context package, classifier, operation, and property</li>
 *   <li>tracking of variable declarations</li>
 *   <li>lookup of operations, attributes, etc. by delegation to the other
 *       model introspection methods</li>
 *   <li>determination of implicit source variables for operation calls,
 *       attribute navigations, etc.</li>
 *   <li>tracking of operation bodies and attribute initializers/derivations</li>
 *   <li>storage of additional attributes and operations</tt>
 * </ul>
 * <p>
 * along with some subclass hook methods and convenience methods.
 * </p>
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this class. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public abstract class AbstractEnvironment extends AbstractBasicEnvironment
	implements Environment.Internal {
	
	private org.eclipse.ocl.examples.pivot.Package contextPackage;
//	private Operation contextOperation;
//	private Property contextProperty;

	private Variable selfVariable;

    /**
     * Initializes me without a parent environment.
     */
	protected AbstractEnvironment() {
		super(null);
	}
    
    /**
     * Initializes me with the specified parent environment.
     * 
     * @param parent an environment (or <code>null</code>)
     */
    protected AbstractEnvironment(Environment.Internal parent) {      
        super(parent);
    }
	
    /**
     * Initializes me with the specified parent environment, which should be
     * of the same type as me.
     * 
     * @param parent an environment of the same type as me (or <code>null</code>)
     */
	protected AbstractEnvironment(AbstractEnvironment parent) {	
		super(parent);
	}

    // implements the interface method
    public Environment.Internal getInternalParent() {
        return (Environment.Internal) super.getParent();
    }

    // implements the interface method
    /**
     * @deprecated Since 1.2, use the {@link #getInternalParent()} method, instead.
     */
	@Override
	@Deprecated
	public AbstractEnvironment getParent() {
		return (AbstractEnvironment) super.getParent();
	}

    /**
     * Assigns me a parent environment after construction.  It is not advisable
     * to set the parent to <code>null</code> if I previously had one.
     * 
     * @param parent my new parent
     */
    public void setInternalParent(Environment.Internal parent) {
        super.setParent(parent);
    }

    /**
     * Assigns me a parent environment after construction.  It is not advisable
     * to set the parent to <code>null</code> if I previously had one.
     * 
     * @param parent my new parent
     */
	protected void setParent(AbstractEnvironment parent) {
		super.setParent(parent);
	}
	
    // implements the interface method
	public org.eclipse.ocl.examples.pivot.Package getContextPackage() {
		if (contextPackage != null) {
			return contextPackage;
		} else if (getInternalParent() != null) {
			return getInternalParent().getContextPackage();
		}
		
		return null;
	}

    /**
     * Assigns my context package.
     * 
     * @param contextPackage my new context package
     */
	protected void setContextPackage(org.eclipse.ocl.examples.pivot.Package contextPackage) {
		this.contextPackage = contextPackage;
	}
	
    // implements the interface method
	public Type getContextClassifier() {
		Variable selfVariable = getSelfVariable();
		return selfVariable != null ? selfVariable.getType() : null;
	}
	
    // implements the interface method
/*	public Operation getContextOperation() {
		if (contextOperation != null) {
			return contextOperation;
		} else if (getInternalParent() != null) {
			return getInternalParent().getContextOperation();
		}
		
		return null;
	} */

    /**
     * Assigns my context operation.  This method does <em>not</em> create the
     * variables for parameters and the return result.
     * 
     * @param contextOperation my context operation
     */
	protected void setContextOperation(Operation contextOperation) {
//		this.contextOperation = contextOperation;
	}
	
    // implements the interface method
/*	public Property getContextProperty() {
		if (contextProperty != null) {
			return contextProperty;
		} else if (getInternalParent() != null) {
			return getInternalParent().getContextProperty();
		}
		
		return null;
	} */

    /**
     * Assigns my context property.
     * 
     * @param contextProperty my context property
     */
	protected void setContextProperty(Property contextProperty) {
//		this.contextProperty = contextProperty;
	}

    // implements the interface method
	public boolean addElement(String name, Variable elem, boolean isExplicit) {
		throw new UnsupportedOperationException();
/*		// FIXME this is now redundant
		if (name == null) {
			name = generateName();
			while (lookup(name) != null) {
				name = generateName();
			}
		} else if (lookupLocal(name) != null) {
			return false;
		}
		
		elem.setName(name);
		VariableEntry newelem = new VariableEntry(name, elem, isExplicit);
		namedElements.add(newelem);
		
		addedVariable(name, elem, isExplicit);
		
		return true; */
	}

    // implements the interface method
	public void setSelfVariable(Variable var) {
		selfVariable = var;
		
		// ensure that the environment knows its package context
		if (getContextPackage() == null) {
			Type contextClassifier = getContextClassifier();
			
			if (contextClassifier != null) {
				setContextPackage(contextClassifier.getPackage());
			}
		}
	}
	
    // implements the interface method
	public Variable getSelfVariable() {
		Variable result = selfVariable;
		
		if ((result == null) && (getInternalParent() != null)) {
			result = getInternalParent().getSelfVariable();
		}
		
		return result;
	}
    
    /**
     * Queries whether I have a non-OK setting for the specified problem option.
     * In such cases, I will need to be concerned with reporting the problem.
     * 
     * @param option the problem option
     * @return whether I have a setting for it that is not OK
     * 
     * @see ProblemHandler.Severity#OK
     */
    public boolean notOK(Option<ProblemHandler.Severity> option) {
        ProblemHandler.Severity sev = getValue(option);
        return (sev != null) && !sev.isOK();
    }
    
    /**
     * I dispose my type resolver, if it is an {@link AbstractTypeResolver}
     * and I am the root environment (which owns the resolver).
     * 
     * @since 1.2
     */
    public void dispose() {
    }    

	//
	// Nested classes
	//
	
    /**
     * Wrapper for OCL variable declarations that additionally tracks whether
     * they are explicit or implicit variables.
     * 
     * @author Christian W. Damus (cdamus)
	 */
	protected final class VariableEntry {
		final String name;
		final Variable variable;
		final boolean isExplicit;
		
		VariableEntry(String name, Variable variable, boolean isExplicit) {
			this.name = name;
			this.variable = variable;
			this.isExplicit = isExplicit;
		}
		
		@Override
		public String toString() {
			return "VariableEntry[" + name + ", "  //$NON-NLS-1$//$NON-NLS-2$
				+ (isExplicit? "explicit, " : "implicit, ") + variable + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
}