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
 * $Id: AbstractEnvironment.java,v 1.3 2011/01/30 11:17:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import java.lang.Class;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.AmbiguousLookupException;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.examples.pivot.messages.OCLMessages;
import org.eclipse.ocl.lpg.AbstractBasicEnvironment;
import org.eclipse.ocl.lpg.ProblemHandler;
import org.eclipse.ocl.options.Option;
import org.eclipse.ocl.options.ProblemOption;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;
import org.eclipse.ocl.util.UnicodeSupport;

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
	implements Environment.Internal, Environment.Lookup {
    
	/* Used to generate implicit iterator variables */
	private int generatorInt = 0;
	
	private org.eclipse.ocl.examples.pivot.Package contextPackage;
	private Operation contextOperation;
	private Property contextProperty;
	
	/*
	 * List of declared variables and implicit variables, including "self".
	 * Implicit variables are generated when there is an iterator without any
	 * iteration variable specified.
	 */
	private List<VariableEntry> namedElements = new java.util.ArrayList<VariableEntry>();

	private Variable selfVariable;
	
    // map of operations to body conditions
	private Map<Operation, Constraint> operationBodies = new java.util.HashMap<Operation, Constraint>();
	
    // map of attributes to initial-value expressions
	private Map<Property, Constraint> propertyInitializers = new java.util.HashMap<Property, Constraint>();
	
    // map of attributes to derivation expressions
	private Map<Property, Constraint> propertyDerivations = new java.util.HashMap<Property, Constraint>();
	
	private TypeChecker typeChecker;

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
	
	/**
     * Generates a new, unique name for an implicit iterator variable.
     * 
     * @return the new name
	 */
	private String generateName() {
		generatorInt++;
		return "temp" + generatorInt;//$NON-NLS-1$
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
		return getSelfVariable().getType();
	}
	
    // implements the interface method
	public Operation getContextOperation() {
		if (contextOperation != null) {
			return contextOperation;
		} else if (getInternalParent() != null) {
			return getInternalParent().getContextOperation();
		}
		
		return null;
	}

    /**
     * Assigns my context operation.  This method does <em>not</em> create the
     * variables for parameters and the return result.
     * 
     * @param contextOperation my context operation
     */
	protected void setContextOperation(Operation contextOperation) {
		this.contextOperation = contextOperation;
	}
	
    // implements the interface method
	public Property getContextProperty() {
		if (contextProperty != null) {
			return contextProperty;
		} else if (getInternalParent() != null) {
			return getInternalParent().getContextProperty();
		}
		
		return null;
	}

    /**
     * Assigns my context property.
     * 
     * @param contextProperty my context property
     */
	protected void setContextProperty(Property contextProperty) {
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
	public Collection<Variable> getVariables() {
		Collection<Variable> result = new java.util.ArrayList<Variable>();
		
		for (int i = 0; i < namedElements.size(); i++) {
			VariableEntry elem = namedElements.get(i);
			
			if (elem.isExplicit) {
				result.add(elem.variable);
			}
		}
		
		if (getInternalParent() != null) {
			// add all non-shadowed parent variables
			for (Variable parentVar : getInternalParent().getVariables()) {
				if (lookupLocal(parentVar.getName()) == null) {
					result.add(parentVar);
				}
			}
		}
		
		return result;
	}

    // implements the interface method
	public boolean addElement(String name, Variable elem, boolean isExplicit) {
		// FIXME this is now redundant
		if (name == null) {
			name = generateName();
			while (lookup(name) != null) {
				name = generateName();
			}
		} else if (lookupLocal(name) != null) {
			return false;
		}
		
		getUMLReflection().setName(elem, name);
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
	protected void addedVariable(String name, Variable variable, boolean isExplicit) {
//		getResource().getContents().add(variable);
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
	protected void removedVariable(String name, Variable variable, boolean isExplicit) {
		getResource().getContents().remove(variable);
	}

    // implements the interface method
	public void setSelfVariable(Variable var) {
		selfVariable = var;
		
		// ensure that the environment knows its package context
		if (getContextPackage() == null) {
			Type contextClassifier = getContextClassifier();
			
			if (contextClassifier != null) {
				setContextPackage(getUMLReflection().getPackage(contextClassifier));
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
    
    public void addHelperProperty(Type owner, Property property) {
        addProperty(owner, property);
    }
	
    /**
     * Allows subclasses to add a newly OCL-defined additional property to
     * the environment.  This should be called by the subclass's implementation
     * of the {@link Environment#defineAttribute} method.
     * 
     * @param owner the classifier in which context the attribute is defined
     * @param property the additional attribute
     * 
     * @deprecated Since 1.2, use the
     *    {@link Environment.Internal#addHelperProperty(Object, Object)}
     *    API, instead
     */
    @Deprecated
	protected void addProperty(Type owner, Property property) {
		if (getInternalParent() != null) {
			// propagate additional properties as high as possible so that they
			//    will be accessible to all child environments of the root
		    getInternalParent().addHelperProperty(owner, property);
		} else {
			getTypeResolver().resolveAdditionalAttribute(owner, property);
		}
	}
	
	public List<Property> getAdditionalAttributes(Type classifier) {
		if (getInternalParent() != null) {
			return getInternalParent().getAdditionalAttributes(classifier);
		}
		
		List<Property> result = null;
		TypeResolver res = getTypeResolver();
		
		List<Property> additionals = res.getAdditionalAttributes(classifier);
		if (!additionals.isEmpty()) {
			result = new java.util.ArrayList<Property>(additionals);
		}
		
		Collection<? extends Type> allParents = /*(classifier instanceof PredefinedType)
			? OCLStandardLibraryUtil.getAllSupertypes(this,
				(PredefinedType) classifier)
			:*/ getUMLReflection().getAllSupertypes(classifier);
			
		for (Type general : allParents) {
			additionals = res.getAdditionalAttributes(general);
			if (!additionals.isEmpty()) {
				if (result == null) {
					result = new java.util.ArrayList<Property>(additionals);
				} else {
					result.addAll(additionals);
				}
			}
		}
		
		if (result == null) {
			result = Collections.emptyList();
		}
		
		return result;
	}
	
	public void addHelperOperation(Type owner, Operation operation) {
		addOperation(owner, operation);
	}
    
    /**
     * Allows subclasses to add a newly OCL-defined additional operation to
     * the environment.  This should be called by the subclass's implementation
     * of the {@link Environment#defineOperation} method.
     * 
     * @param owner the classifier in which context the attribute is defined
     * @param operation the additional operation
     * 
     * @deprecated Since 1.2, use the
     *    {@link Environment.Internal#addHelperOperation(Object, Object)}
     *    API, instead
     */
    @Deprecated
    protected void addOperation(Type owner, Operation operation) {
        if (getInternalParent() != null) {
            // propagate additional operations as high as possible so that they
            //    will be accessible to all child environments of the root
            getInternalParent().addHelperOperation(owner, operation);
        } else {
            getTypeResolver().resolveAdditionalOperation(owner, operation);
        }
    }
	
	public List<Operation> getAdditionalOperations(Type classifier) {
		if (getInternalParent() != null) {
			return getInternalParent().getAdditionalOperations(classifier);
		}
		
		List<Operation> result = null;
		TypeResolver res = getTypeResolver();
		
		List<Operation> additionals = res.getAdditionalOperations(classifier);
		if (!additionals.isEmpty()) {
			result = new java.util.ArrayList<Operation>(additionals);
		}
		
		Collection<? extends Type> allParents = /*(classifier instanceof PredefinedType<?>)
			? OCLStandardLibraryUtil.getAllSupertypes(this,
				(PredefinedType<?>) classifier)
			:*/ getUMLReflection().getAllSupertypes(classifier);
			
		for (Type general : allParents) {
			additionals = res.getAdditionalOperations(general);
			if (!additionals.isEmpty()) {
				if (result == null) {
					result = new java.util.ArrayList<Operation>(additionals);
				} else {
					result.addAll(additionals);
				}
			}
		}
		
		if (result == null) {
			result = Collections.emptyList();
		}
		
		return result;
	}
	
    // implements the interface method
	public void setInitConstraint(Property property, Constraint constraint) {
		if (getInternalParent() != null) {
			// propagate initializers as high as possible so that they
			//    will be accessible to all child environments of the root
			getInternalParent().setInitConstraint(property, constraint);
		} else {
			propertyInitializers.put(property, constraint);
		}
	}

    // implements the interface method
	public Constraint getInitConstraint(Property property) {
		if (getInternalParent() != null) {
			return getInternalParent().getInitConstraint(property);
		}
		
    	return propertyInitializers.get(property);
	}
	
    // implements the interface method
	public void setDeriveConstraint(Property property, Constraint constraint) {
		if (getInternalParent() != null) {
			// propagate derivations as high as possible so that they
			//    will be accessible to all child environments of the root
			getInternalParent().setDeriveConstraint(property, constraint);
		} else {
			propertyDerivations.put(property, constraint);
		}
	}
	
    // implements the interface method
	public Constraint getDeriveConstraint(Property property) {
		if (getInternalParent() != null) {
			return getInternalParent().getDeriveConstraint(property);
		}
		
    	return propertyDerivations.get(property);
	}
	
    // implements the interface method
	public void setBodyCondition(Operation operation, Constraint constraint) {
		if (getInternalParent() != null) {
			// propagate bodies as high as possible so that they
			//    will be accessible to all child environments of the root
			getInternalParent().setBodyCondition(operation, constraint);
		} else {
			operationBodies.put(operation, constraint);
		}
	}
	
    // implements the interface method
	public Constraint getBodyCondition(Operation operation) {
		if (getInternalParent() != null) {
			return getInternalParent().getBodyCondition(operation);
		}
		
    	return operationBodies.get(operation);
	}
    
    // implements the interface method
    public Variable lookupLocal(String name) {
        // support operation parameters whose names need to be escaped in OCL
        Variable result = doLookupLocal(name);
        
        if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
            result = doLookupLocal(AbstractOCLAnalyzer.unescape(name));
        }
        
        return result;
    }
    
    private Variable doLookupLocal(String name) {
		for (int i = 0; i < namedElements.size(); i++) {
			VariableEntry elem = namedElements.get(i);
			if (elem.name.equals(name)) {
				return elem.variable;
			}
		}
		return null;
	}

    // implements the interface method
	public Variable lookup(String name) {
		Variable elem = lookupLocal(name);

		if (elem != null) {
			return elem;
		}

		if (getInternalParent() != null) {
			return getInternalParent().lookup(name);
		} else {
            return null;
        }
	}
   
    // implements the interface method
    public Operation lookupOperation(Type owner, String name, List<? extends TypedElement> args) {
        Operation result = doLookupOperation(owner, name, args);
        
        if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
            result = doLookupOperation(owner, AbstractOCLAnalyzer.unescape(name), args);
        }
        
        return result;
    }
    
	private Operation doLookupOperation(Type owner, String name, List<? extends TypedElement> args) {
		if (owner == null) {
			Variable vdcl = lookupImplicitSourceForOperation(name, args);
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}

		return TypeUtil.findOperationMatching(this, owner, name, args);
	}
	
    // implements the interface method
	public Property lookupProperty(Type owner, String name) {
	    Property result = doLookupProperty(owner, name);
	    
	    if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
            result = doLookupProperty(owner, AbstractOCLAnalyzer.unescape(name));
        }
	    
	    return result;
	}
	
	private Property doLookupProperty(Type owner, String name) {
        if (owner == null) {
            Variable vdcl = lookupImplicitSourceForProperty(name);
            if (vdcl == null) {
                return null;
            }
            
            owner = vdcl.getType();
        }

        return TypeUtil.findAttribute(this, owner, name);
	}

    // implements the interface method
    public Type lookupAssociationClassReference(Type owner, String name) {
        Type result = doLookupAssociationClassReference(owner, name);
        
        if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
            result = doLookupAssociationClassReference(owner, AbstractOCLAnalyzer
                .unescape(name));
        }
        
        return result;
    }
    
    // implements the interface method
	private Type doLookupAssociationClassReference(Type owner, String name) {
		if (owner == null) {
			Variable vdcl = lookupImplicitSourceForAssociationClass(name);
			
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}

		Type result = null;
		
		List<Property> properties = getUMLReflection().getAttributes(owner);
		Iterator<Property> iter = properties.iterator();
		while ((result == null) && iter.hasNext()) {
			Property next = iter.next();
			
			Type assocClass = getUMLReflection().getAssociationClass(next);
			if ((assocClass != null) && name.equals(initialLower(assocClass))) {
				result = assocClass;
			}
		}
		
		return result;
	}

    // implements the interface method
    public Signal lookupSignal(Type owner, String name, List<? extends TypedElement> args) {
    	Signal result = doLookupSignal(owner, name, args);
        
        if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
            result = doLookupSignal(owner, AbstractOCLAnalyzer.unescape(name), args);
        }
        
        return result;
    }
    
    private Signal doLookupSignal(Type owner, String name, List<? extends TypedElement> args) {
		if (owner == null) {
			Variable vdcl = lookupImplicitSourceForSignal(name, args);
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}

		return TypeUtil.findSignalMatching(this, owner,
            getUMLReflection().getSignals(owner), name, args);
	}
	
    // implements the interface method
	public State lookupState(Type owner, List<String> path) throws LookupException {
		if (owner == null) {
			Variable vdcl = lookupImplicitSourceForState(path);
			
			if (vdcl == null) {
				return null;
			}
			
			owner = vdcl.getType();
		}
		
		int lastIndex = path.size() - 1;
		String lastName = path.get(lastIndex);
		
		List<State> states = getStates(owner, path.subList(0, lastIndex));
		State result = null;
		
		for (State next : states) {
		    String nextName = getUMLReflection().getName(next);
		    
		    boolean matched = lastName.equals(nextName);
		    if (!matched && AbstractOCLAnalyzer.isEscaped(lastName)) {
		        matched = AbstractOCLAnalyzer.unescape(lastName).equals(nextName);
		    }
		    
			if (matched) {
				if (result == null) {
					result = next;
				} else {
					// ambiguous reference to the state
					String msg = OCLMessages.bind(
							OCLMessages.AmbiguousState_ERROR_,
							path,
                            getUMLReflection().getQualifiedName(owner));
					throw new LookupException(msg);
				}
			}
		}
		
		return result;
	}
	
    // implements the interface method
	public Variable lookupImplicitSourceForOperation(
			String name,
			List<? extends TypedElement> args) {

		Variable vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = namedElements.get(i);
			vdcl = element.variable;
			Type owner = vdcl.getType();
			
			if (!element.isExplicit && (owner != null)) {
				Operation eop = lookupOperation(owner, name, args);
				if (eop != null) {
					return vdcl;
				}
			}
		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			Type owner = vdcl.getType();
			if (owner != null) {
				Operation eop = lookupOperation(owner, name, args);
				if (eop != null) {
					return vdcl;
				}
			}
		}
		
		return null;
	}

    // implements the interface method
	public Variable lookupImplicitSourceForProperty(String name) {
		Variable vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = namedElements.get(i);
			vdcl = element.variable;
			Type owner = vdcl.getType();
			
			if (!element.isExplicit && (owner != null)) {
				Property property = safeTryLookupProperty(owner, name);
				if (property != null) {
					return vdcl;
				}
			}

		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			Type owner = vdcl.getType();
			if (owner != null) {
				Property property = safeTryLookupProperty(owner, name);
				if (property != null) {
					return vdcl;
				}
			}
		}
		
		return null;

	}
	
	/**
	 * Wrapper for the "try" operation that doesn't throw, but just returns the
	 * first ambiguous match in case of ambiguity.
	 */
    private Property safeTryLookupProperty(Type owner, String name) {
	    Property result = null;
	    
	    try {
	        result = tryLookupProperty(owner, name);
        } catch (LookupException e) {
            if (!e.getAmbiguousMatches().isEmpty()) {
                result = (Property) e.getAmbiguousMatches().get(0);
            }
	    }
        
        return result;
	}

    // implements the interface method
	public Variable lookupImplicitSourceForAssociationClass(String name) {
		Variable vdcl;
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = namedElements.get(i);
			vdcl = element.variable;
			Type owner = vdcl.getType();
			
			if (!element.isExplicit && (owner != null)) {
				Type ac = lookupAssociationClassReference(owner, name);
				if (ac != null) {
					return vdcl;
				}
			}

		}

		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			Type owner = vdcl.getType();
			if (owner != null) {
				Type ac = lookupAssociationClassReference(owner, name);
				if (ac != null) {
					return vdcl;
				}
			}
		}
		return null;
	}

    // implements the interface method
	public Variable lookupImplicitSourceForSignal(
			String name,
			List<? extends TypedElement> args) {

		Variable vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = namedElements.get(i);
			vdcl = element.variable;
			Type owner = vdcl.getType();
			
			if (!element.isExplicit && (owner != null)) {
				Signal sig = lookupSignal(owner, name, args);
				if (sig != null) {
					return vdcl;
				}
			}
		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			Type owner = vdcl.getType();
			
			if (owner != null) {
				Signal sig = lookupSignal(owner, name, args);
				if (sig != null) {
					return vdcl;
				}
			}
		}
		
		return null;
	}
	
    // implements the interface method
	public Variable lookupImplicitSourceForState(List<String> path)
			throws LookupException {
		Variable vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = namedElements.get(i);
			vdcl = element.variable;
			Type owner = vdcl.getType();
			
			if (!element.isExplicit && (owner != null)) {
				State state = lookupState(owner, path);
				if (state != null) {
					return vdcl;
				}
			}
		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			Type owner = vdcl.getType();
			
			if (owner != null) {
				State state = lookupState(owner, path);
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
	    String name = getUMLReflection().getName(element);
	    if (name == null) {
	        return null;
	    }
	    
		StringBuffer result = new StringBuffer(name);
		
		if (result.length() > 0) {
			UnicodeSupport.setCodePointAt(
					result,
					0,
					UnicodeSupport.toLowerCase(UnicodeSupport.codePointAt(result, 0)));
		}
		
		return result.toString();
	}
	
	/**
	 * This default implementation simply delegates to the
	 * {@link Environment#lookupAssociationClassReference(Object, String)} method.
	 * 
	 * @since 1.2
	 */
	public Type tryLookupAssociationClassReference(Type owner, String name)
        throws LookupException {
        
        return lookupAssociationClassReference(owner, name);
    }

    /**
     * This default implementation simply delegates to the
     * {@link Environment#lookupClassifier(List)} method.
     * 
     * @since 1.2
     */
    public Type tryLookupClassifier(List<String> names)
        throws LookupException {
        
        return lookupClassifier(names);
    }

    /**
     * This default implementation simply delegates to the
     * {@link Environment#lookupOperation(Object, String, List)} method.
     * 
     * @since 1.2
     */
    public Operation tryLookupOperation(Type owner, String name,
            List<? extends TypedElement> args)
        throws LookupException {
        
        return lookupOperation(owner, name, args);
    }

    /**
     * This default implementation simply delegates to the
     * {@link Environment#lookupSignal(Object, String, List)} method.
     * 
     * @since 1.2
     */
    public Signal tryLookupSignal(Type owner, String name,
            List<? extends TypedElement> args)
        throws LookupException {
        
        return lookupSignal(owner, name, args);
    }

    /**
     * This default implementation simply delegates to the
     * {@link Environment#lookupPackage(List)} method.
     * 
     * @since 1.2
     */
    public org.eclipse.ocl.examples.pivot.Package tryLookupPackage(List<String> names)
        throws LookupException {
        
        return lookupPackage(names);
    }

    /**
     * This default implementation simply delegates to the
     * {@link Environment#lookupProperty(Object, String)} method.
     * 
     * @since 1.2
     */
    public Property tryLookupProperty(Type owner, String name)
        throws LookupException {
        
        Property result = lookupProperty(owner, name);
        
        if (result == null) {
            // looks up non-navigable named ends as well as unnamed ends.  Hence
            // the possibility of ambiguity
            result = lookupNonNavigableEnd(owner, name);
            
            if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
                result = lookupNonNavigableEnd(owner, AbstractOCLAnalyzer.unescape(name));
            }
        }

        return result;
    }

    /**
     * Looks up a non-navigable association end on behalf of
     * the specified <code>owner</code> classifier (which is at that end).
     * 
     * @param owner
     *            a classifier in the context of which the property is used
     * @param name
     *            the end name to look up
     * 
     * @return the non-navigable end, or <code>null</code> if it cannot
     *         be found
     *         
     * @throws LookupException in case that multiple non-navigable properties
     *     are found that have the same name and the problem option is ERROR
     *     or worse
     */
    private Property lookupNonNavigableEnd(Type owner, String name) throws LookupException {
        if (owner == null) {
            Variable vdcl = lookupImplicitSourceForProperty(name);

            if (vdcl == null) {
                return null;
            }

            owner = vdcl.getType();
        }

        List<Property> matches = new java.util.ArrayList<Property>(2);
        findNonNavigableAssociationEnds(owner, name, matches);

        if (matches.isEmpty()) {
            // search for unnamed ends (named but non-navigable ends take priority)
            findUnnamedAssociationEnds(owner, name, matches);
        }
        
        if (matches.isEmpty()) {
            return null;
        } else if (matches.size() > 1) {
            // ambiguous matches.  What to do?
            if (notOK(ProblemOption.AMBIGUOUS_ASSOCIATION_ENDS)) {
                ProblemHandler.Severity sev = getValue(ProblemOption.AMBIGUOUS_ASSOCIATION_ENDS);

                // will have to report the problem
                String message = OCLMessages.bind(OCLMessages.Ambig_AssocEnd_,
                    name, getUMLReflection().getName(owner));

                if (sev.getDiagnosticSeverity() >= Diagnostic.ERROR) {
                    throw new AmbiguousLookupException(message, matches);
                } else {
                    getProblemHandler().analyzerProblem(sev, message,
                        "lookupNonNavigableProperty", -1, -1); //$NON-NLS-1$
                }
            }
        }
        
        return matches.get(0);
    }
    
    /**
     * Searches for non-navigable association ends with the specified
     * <tt>name</tt> at the given <tt>classifier</tt>'s end of an association.
     * Subclasses should reimplement this method if they support non-navigable
     * association ends.
     * 
     * @param classifier a classifier at an association end
     * @param name the non-navigable end name to look for
     * @param ends collects the ends found by the subclass implementation
     */
    protected void findNonNavigableAssociationEnds(Type classifier, String name, List<Property> ends) {
        // no default implementation
    }
    
    /**
     * Searches for unnamed association ends using the specified <tt>name</tt>
     * at the given <tt>classifier</tt>'s end of an association.
     * Subclasses should reimplement this method if they support non-navigable
     * association ends.  It is expected, in OCL, that the supplied <tt>name</tt>
     * is the {@linkplain #initialLower(Object) initial-lower-case name} of the
     * type of the unnamed end.
     * 
     * @param classifier a classifier at an association end
     * @param name the initial-lower classifier name to look for
     * @param ends collects the ends found by the subclass implementation
     */
    protected void findUnnamedAssociationEnds(Type classifier, String name, List<Property> ends) {
        // no default implementation
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
        if ((getInternalParent() == null)
                && (getTypeResolver() instanceof AbstractTypeResolver)) {
            ((AbstractTypeResolver) getTypeResolver()).dispose();
        }
    }    

    /**
     * Obtains my extensible type checker utility.  If it has not already been
     * initialized before, then it is lazily {@linkplain #createTypeChecker()}.
     * 
     * @return my type-checker
     * 
     * @since 1.3
     * 
     * @see #createTypeChecker()
     */
    protected TypeChecker getTypeChecker() {
    	if (typeChecker == null) {
    		typeChecker = createTypeChecker();
    	}
    	
    	return typeChecker;
    }
    
    /**
     * Creates my extensible type checker utility when it is first needed.
     * A default implementation is supplied, which subclasses may replace by
     * overriding this method.
     * 
     * @return a new type-checker
     * 
     * @since 1.3
     * 
     * @see #getTypeChecker()
     */
   protected TypeChecker createTypeChecker() {
    	return new AbstractTypeChecker(this) {

			@Override
			protected Type resolve(Type type) {
				return getTypeResolver().resolve(type);
			}

			@Override
			protected CollectionType resolveCollectionType(
					CollectionKind kind, Type elementType) {
				
				return getTypeResolver().resolveCollectionType(kind, elementType);
			}

			@Override
			protected TupleType resolveTupleType(
					EList<? extends TypedElement> parts) {
				
				return getTypeResolver().resolveTupleType(parts);
			}
		};
    }
    
	/**
	 * Since {@link AbstractTypeResolver} implements {@link TypeChecker},
	 * AbstractEnvironment will try to adapt {@link TypeChecker}, via its
	 * {@link TypeResolver}.
	 * 
	 * @since 1.3
	 * 
	 * @see org.eclipse.ocl.lpg.AbstractBasicEnvironment#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getAdapter(Class<T> adapterType) {
		if (adapterType == TypeChecker.class) {
			return (T) getTypeChecker();
		}
		
		return super.getAdapter(adapterType);
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