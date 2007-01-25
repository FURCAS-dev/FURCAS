/**
 * <copyright>
 *
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: AbstractEnvironment.java,v 1.1 2007/01/25 18:24:37 cdamus Exp $
 */
package org.eclipse.ocl;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.util.UnicodeSupport;
import org.eclipse.ocl.utilities.TypedElement;

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
public abstract class AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E>
	implements Environment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> {

	/* Used to generate implicit iterator variables */
	private static int generatorInt = 0;
	
	private AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent;
	
	private PK contextPackage;
	private O contextOperation;
	private P contextProperty;
	
	/*
	 * List of declared variables and implicit variables, including "self".
	 * Implicit variables are generated when there is an iterator without any
	 * iteration variable specified.
	 */
	private List<VariableEntry> namedElements = new java.util.ArrayList<VariableEntry>();

	private Variable<C, PM> selfVariable;
	
    // map of operations to body conditions
	private Map<O, CT> operationBodies = new java.util.HashMap<O, CT>();
	
    // map of attributes to initial-value expressions
	private Map<P, CT> propertyInitializers = new java.util.HashMap<P, CT>();
	
    // map of attributes to derivation expressions
	private Map<P, CT> propertyDerivations = new java.util.HashMap<P, CT>();
	
	
    /**
     * Initializes me without a parent environment.
     */
	protected AbstractEnvironment() {
		super();
	}
	
    /**
     * Initializes me with the specified parent environment, which should be
     * of the same type as me.
     * 
     * @param parent an environment of the same type as me (or <code>null</code>)
     */
	protected AbstractEnvironment(
			AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent) {
		
		this.parent = parent;
	}
	
	/**
     * Generates a new, unique name for an implicit iterator variable.
     * 
     * @return the new name
	 */
	private synchronized String generateName() {
		generatorInt++;
		return "temp" + generatorInt;//$NON-NLS-1$
	}

    // implements the interface method
	public AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> getParent() {
		return parent;
	}

    /**
     * Assigns me a parent environment after construction.  It is not advisable
     * to set the parent to <code>null</code> if I previously had one.
     * 
     * @param parent my new parent
     */
	protected void setParent(AbstractEnvironment<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> parent) {
		this.parent = parent;
	}
	
    // implements the interface method
	public PK getContextPackage() {
		if (contextPackage != null) {
			return contextPackage;
		} else if (getParent() != null) {
			return getParent().getContextPackage();
		}
		
		return null;
	}

    /**
     * Assigns my context package.
     * 
     * @param contextPackage my new context package
     */
	protected void setContextPackage(PK contextPackage) {
		this.contextPackage = contextPackage;
	}
	
    // implements the interface method
	public C getContextClassifier() {
		return getSelfVariable().getType();
	}
	
    // implements the interface method
	public O getContextOperation() {
		if (contextOperation != null) {
			return contextOperation;
		} else if (getParent() != null) {
			return getParent().getContextOperation();
		}
		
		return null;
	}

    /**
     * Assigns my context operation.  This method does <em>not</em> create the
     * variables for parameters and the return result.
     * 
     * @param contextOperation my context operation
     */
	protected void setContextOperation(O contextOperation) {
		this.contextOperation = contextOperation;
	}
	
    // implements the interface method
	public P getContextProperty() {
		if (contextProperty != null) {
			return contextProperty;
		} else if (getParent() != null) {
			return getParent().getContextProperty();
		}
		
		return null;
	}

    /**
     * Assigns my context property.
     * 
     * @param contextProperty my context property
     */
	protected void setContextProperty(P contextProperty) {
		this.contextProperty = contextProperty;
	}
	
    /**
     * Obtains the resource in which my
     * {@linkplain Environment#getTypeResolver() type resolver} persists
     * OCL-generated types and additional features.
     * 
     * @return my resource
     */
	protected Resource getResource() {
		return getTypeResolver().getResource();
	}
	
    // implements the interface method
	public boolean isEmpty() {
		return namedElements.isEmpty();
	}
	
    // implements the interface method
	public Collection<Variable<C, PM>> getVariables() {
		Collection<Variable<C, PM>> result = new java.util.ArrayList<Variable<C, PM>>();
		
		for (int i = 0; i < namedElements.size(); i++) {
			VariableEntry elem = (VariableEntry) namedElements.get(i);
			
			if (elem.isExplicit) {
				result.add(elem.variable);
			}
		}
		
		if (getParent() != null) {
			// add all non-shadowed parent variables
			for (Variable<C, PM> parentVar : getParent().getVariables()) {
				if (lookupLocal(parentVar.getName()) == null) {
					result.add(parentVar);
				}
			}
		}
		
		return result;
	}

    // implements the interface method
	public boolean addElement(String name, Variable<C, PM> elem, boolean isExplicit) {

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
		
		return true;
	}

    /**
     * Persists the specified variable in my resource.  Subclasses may extend
     * this method to perform other actions following the addition of a variable
     * to the environment.
     * 
     * @param name the variable name
     * @param variable the variable added
     * @param isExplicit whether it is an explicit or implicit variable
     */
	protected void addedVariable(String name, Variable<C, PM> variable, boolean isExplicit) {
		getResource().getContents().add(variable);
	}

    // implements the interface method
	public void deleteElement(String name) {

		for (Iterator<VariableEntry> iter = namedElements.iterator(); iter.hasNext();) {
			VariableEntry elem = iter.next();
			
			if (elem.name.equals(name)) {
				iter.remove();
				
				removedVariable(name, elem.variable, elem.isExplicit);
			}
		}
	}

    /**
     * Removes the specified variable from my resource.  Subclasses may extend
     * this method to perform other actions following the removal of a variable
     * from the environment.
     * 
     * @param name the variable name
     * @param variable the variable removed
     * @param isExplicit whether it was an explicit or implicit variable
     */
	protected void removedVariable(String name, Variable<C, PM> variable, boolean isExplicit) {
		getResource().getContents().remove(variable);
	}

    // implements the interface method
	public void setSelfVariable(Variable<C, PM> var) {
		selfVariable = var;
		
		// ensure that the environment knows its package context
		if (getContextPackage() == null) {
			C contextClassifier = getContextClassifier();
			
			if (contextClassifier != null) {
				setContextPackage(getUMLReflection().getPackage(contextClassifier));
			}
		}
	}
	
    // implements the interface method
	public Variable<C, PM> getSelfVariable() {
		Variable<C, PM> result = selfVariable;
		
		if ((result == null) && (getParent() != null)) {
			result = getParent().getSelfVariable();
		}
		
		return result;
	}
	
    /**
     * Allows subclasses to add a newly OCL-defined additional property to
     * the environment.  This should be called by the subclass's implementation
     * of the {@link Environment#defineAttribute} method.
     * 
     * @param owner the classifier in which context the attribute is defined
     * @param property the additional attribute
     */
	protected void addProperty(C owner, P property) {
		if (getParent() != null) {
			// propagate additional properties as high as possible so that they
			//    will be accessible to all child environments of the root
			getParent().addProperty(owner, property);
		} else {
			getTypeResolver().resolveAdditionalAttribute(owner, property);
		}
	}
	
	public List<P> getAdditionalAttributes(C classifier) {
		if (getParent() != null) {
			return getParent().getAdditionalAttributes(classifier);
		}
		
		List<P> result = null;
		TypeResolver<C, O, P> res = getTypeResolver();
		
		List<P> additionals = res.getAdditionalAttributes(classifier);
		if (!additionals.isEmpty()) {
			result = new java.util.ArrayList<P>(additionals);
		}
		
		for (C general : getUMLReflection().getAllSupertypes(classifier)) {
			additionals = res.getAdditionalAttributes(general);
			if (!additionals.isEmpty()) {
				if (result == null) {
					result = new java.util.ArrayList<P>(additionals);
				} else {
					result.addAll(additionals);
				}
			}
		}
		
		return result;
	}
	
    /**
     * Allows subclasses to add a newly OCL-defined additional operation to
     * the environment.  This should be called by the subclass's implementation
     * of the {@link Environment#defineOperation} method.
     * 
     * @param owner the classifier in which context the attribute is defined
     * @param operation the additional operation
     */
	protected void addOperation(C owner, O operation) {
		if (getParent() != null) {
			// propagate additional operations as high as possible so that they
			//    will be accessible to all child environments of the root
			getParent().addOperation(owner, operation);
		} else {
			getTypeResolver().resolveAdditionalOperation(owner, operation);
		}
	}
	
	public List<O> getAdditionalOperations(C classifier) {
		if (getParent() != null) {
			return getParent().getAdditionalOperations(classifier);
		}
		
		List<O> result = null;
		TypeResolver<C, O, P> res = getTypeResolver();
		
		List<O> additionals = res.getAdditionalOperations(classifier);
		if (!additionals.isEmpty()) {
			result = new java.util.ArrayList<O>(additionals);
		}
		
		for (C general : getUMLReflection().getAllSupertypes(classifier)) {
			additionals = res.getAdditionalOperations(general);
			if (!additionals.isEmpty()) {
				if (result == null) {
					result = new java.util.ArrayList<O>(additionals);
				} else {
					result.addAll(additionals);
				}
			}
		}
		
		return result;
	}
	
    // implements the interface method
	public void setInitConstraint(P property, CT constraint) {
		if (getParent() != null) {
			// propagate initializers as high as possible so that they
			//    will be accessible to all child environments of the root
			getParent().setInitConstraint(property, constraint);
		} else {
			propertyInitializers.put(property, constraint);
		}
	}

    // implements the interface method
	public CT getInitConstraint(P property) {
		if (getParent() != null) {
			return getParent().getInitConstraint(property);
		}
		
    	return propertyInitializers.get(property);
	}
	
    // implements the interface method
	public void setDeriveConstraint(P property, CT constraint) {
		if (getParent() != null) {
			// propagate derivations as high as possible so that they
			//    will be accessible to all child environments of the root
			getParent().setDeriveConstraint(property, constraint);
		} else {
			propertyDerivations.put(property, constraint);
		}
	}
	
    // implements the interface method
	public CT getDeriveConstraint(P property) {
		if (getParent() != null) {
			return getParent().getDeriveConstraint(property);
		}
		
    	return propertyDerivations.get(property);
	}
	
    // implements the interface method
	public void setBodyCondition(O operation, CT constraint) {
		if (getParent() != null) {
			// propagate bodies as high as possible so that they
			//    will be accessible to all child environments of the root
			getParent().setBodyCondition(operation, constraint);
		} else {
			operationBodies.put(operation, constraint);
		}
	}
	
    // implements the interface method
	public CT getBodyCondition(O operation) {
		if (getParent() != null) {
			return getParent().getBodyCondition(operation);
		}
		
    	return operationBodies.get(operation);
	}
	
    // implements the interface method
	public Variable<C, PM> lookupLocal(String name) {

		for (int i = 0; i < namedElements.size(); i++) {
			VariableEntry elem = (VariableEntry) namedElements.get(i);
			if (elem.name.equals(name)) {
				return elem.variable;
			}
		}
		return null;
	}

    // implements the interface method
	public Variable <C, PM>lookup(String name) {
		Variable<C, PM> elem = lookupLocal(name);

		if (elem != null) {
			return elem;
		}

		if (getParent() != null) {
			return getParent().lookup(name);
		} else
			return null;
	}
	
    // implements the interface method
	public O lookupOperation(C owner, String name, List<? extends TypedElement<C>> args) {
		if (owner == null) {
			Variable<C, PM> vdcl = lookupImplicitSourceForOperation(name, args);
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}

		return TypeUtil.findOperationMatching(this, owner, name, args);
	}
	
    // implements the interface method
	public P lookupProperty(C owner, String name) {
		if (owner == null) {
			Variable<C, PM> vdcl = lookupImplicitSourceForProperty(name);
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}

		List<P> properties = TypeUtil.getAttributes(this, owner);
		
		for (P property : properties) {
			if (name.equals(getUMLReflection().getName(property))) {
				return property;
			}
		}
		
		return null;
	}

    // implements the interface method
	public C lookupAssociationClassReference(C owner, String name) {
		if (owner == null) {
			Variable<C, PM> vdcl = lookupImplicitSourceForAssociationClass(name);
			
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}

		C result = null;
		
		List<P> properties = getUMLReflection().getAttributes(owner);
		Iterator<P> iter = properties.iterator();
		while ((result == null) && iter.hasNext()) {
			P next = iter.next();
			
			C assocClass = getUMLReflection().getAssociationClass(next);
			if ((assocClass != null) && name.equals(initialLower(assocClass))) {
				result = assocClass;
			}
		}
		
		return result;
	}

    // implements the interface method
	public C lookupSignal(C owner, String name, List<? extends TypedElement<C>> args) {
		if (owner == null) {
			Variable<C, PM> vdcl = lookupImplicitSourceForSignal(name, args);
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}

		return TypeUtil.findSignalMatching(this, owner,
            getUMLReflection().getSignals(owner), name, args);
	}
	
    // implements the interface method
	public S lookupState(C owner, List<String> path) throws SemanticException {
		if (owner == null) {
			Variable<C, PM> vdcl = lookupImplicitSourceForState(path);
			
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}
		
		int lastIndex = path.size() - 1;
		String lastName = path.get(lastIndex);
		
		List<S> states = getStates(owner, path.subList(0, lastIndex));
		S result = null;
		
		for (S next : states) {
			if (lastName.equals(getUMLReflection().getName(next))) {
				if (result == null) {
					result = next;
				} else {
					// ambiguous reference to the state
					String msg = OCLMessages.bind(
							OCLMessages.AmbiguousState_ERROR_,
							path,
                            getUMLReflection().getQualifiedName(owner));
					throw new SemanticException(msg);
				}
			}
		}
		
		return result;
	}
	
    // implements the interface method
	public Variable<C, PM> lookupImplicitSourceForOperation(
			String name,
			List<? extends TypedElement<C>> args) {

		Variable<C, PM> vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			
			if (!element.isExplicit) {
				O eop = TypeUtil.findOperationMatching(this, vdcl.getType(), name, args);
				if (eop != null) {
					return vdcl;
				}
			}
		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			O eop = TypeUtil.findOperationMatching(this, vdcl.getType(), name, args);
			if (eop != null) {
				return vdcl;
			}
		}
		
		return null;
	}

    // implements the interface method
	public Variable<C, PM> lookupImplicitSourceForProperty(String name) {
		Variable<C, PM> vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (!element.isExplicit) {
				P property = lookupProperty(vdcl.getType(), name);
				if (property != null) {
					return vdcl;
				}
			}

		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			P property = lookupProperty(vdcl.getType(), name);
			if (property != null) {
				return vdcl;
			}
		}
		
		return null;

	}

    // implements the interface method
	public Variable<C, PM> lookupImplicitSourceForAssociationClass(String name) {
		Variable<C, PM> vdcl;
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (!element.isExplicit) {
				C ac = lookupAssociationClassReference(vdcl.getType(), name);
				if (ac != null) {
					return vdcl;
				}
			}

		}

		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			C ac = lookupAssociationClassReference(vdcl.getType(), name);
			if (ac != null) {
				return vdcl;
			}
		}
		return null;
	}

    // implements the interface method
	public Variable<C, PM> lookupImplicitSourceForSignal(
			String name,
			List<? extends TypedElement<C>> args) {

		Variable<C, PM> vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			C owner = vdcl.getType();
			
			if (!element.isExplicit) {
				C sig = TypeUtil.findSignalMatching(this, owner,
                    getUMLReflection().getSignals(owner), name, args);
				if (sig != null) {
					return vdcl;
				}
			}
		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			C owner = vdcl.getType();
			
			C sig = TypeUtil.findSignalMatching(this, owner,
                getUMLReflection().getSignals(owner), name, args);
			if (sig != null) {
				return vdcl;
			}
		}
		
		return null;
	}
	
    // implements the interface method
	public Variable<C, PM> lookupImplicitSourceForState(List<String> path)
			throws SemanticException {
		Variable<C, PM> vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			C owner = vdcl.getType();
			
			if (!element.isExplicit && (owner != null)) {
				S state = lookupState(owner, path);
				if (state != null) {
					return vdcl;
				}
			}
		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			C owner = vdcl.getType();
			
			if (owner != null) {
				S state = lookupState(owner, path);
				if (state != null) {
					return vdcl;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Gets the name of a named <code>element</code> with its initial character
	 * in lower case.
	 * 
	 * @param element a named element
	 * @return the element's name, with an initial lower case letter
	 */
	protected String initialLower(Object element) {
		StringBuffer result = new StringBuffer(getUMLReflection().getName(element));
		
		if (result.length() > 0) {
			UnicodeSupport.setCodePointAt(
					result,
					0,
					UnicodeSupport.toLowerCase(UnicodeSupport.codePointAt(result, 0)));
		}
		
		return result.toString();
	}
	
	
	/**
     * Wrapper for OCL variable declarations that additionally tracks whether
     * they are explicit or implicit variables.
     * 
     * @author Christian W. Damus (cdamus)
	 */
	protected final class VariableEntry {
		final String name;
		final Variable<C, PM> variable;
		final boolean isExplicit;
		
		VariableEntry(String name, Variable<C, PM> variable, boolean isExplicit) {
			this.name = name;
			this.variable = variable;
			this.isExplicit = isExplicit;
		}
		
		public String toString() {
			return "VariableEntry[" + name + ", "  //$NON-NLS-1$//$NON-NLS-2$
				+ (isExplicit? "explicit, " : "implicit, ") + variable + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
}
