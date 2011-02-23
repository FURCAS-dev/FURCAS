/**
 * <copyright>
 *
 * Copyright (c) 2005,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bugs 182994, 252600
 *
 * </copyright>
 *
 * $Id: PivotEnvironment.java,v 1.1 2011/02/11 20:00:28 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.AbstractEnvironment;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.OCLFactory;
import org.eclipse.ocl.examples.pivot.StandardLibrary;
import org.eclipse.ocl.examples.pivot.State;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.UMLReflection;

/**
 * Implementation of the {@link Environment} for parsing OCL expressions on
 * Ecore models.  The <code>EcoreEnvironment</code> uses a client-supplied
 * package registry (or the global registry) to look up {@link EPackage}s
 * by qualified name.
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 */
public class PivotEnvironment extends AbstractEnvironment {
	
	/**
	 * The namespace URI of the Ecore representation of the OCL Standard Library.
	 * 
	 * @since 1.3
	 */
//	public static final String OCL_STANDARD_LIBRARY_NS_URI = "http://www.eclipse.org/ocl/1.1.0/oclstdlib.ecore"; //$NON-NLS-1$

//    private static final Map<List<String>, org.eclipse.ocl.examples.pivot.Package> OCL_PACKAGES =
//        new java.util.HashMap<List<String>, org.eclipse.ocl.examples.pivot.Package>();
    
    
/*    static {
        List<String> names = new java.util.ArrayList<String>();
        names.add(ExpressionsPackageImpl.OCL_ROOT_PACKAGE.getName());
        OCL_PACKAGES.put(names, ExpressionsPackageImpl.OCL_ROOT_PACKAGE);
        
        names = new java.util.ArrayList<String>(names);
        names.add(ExpressionsPackage.eINSTANCE.getName());
        OCL_PACKAGES.put(names, ExpressionsPackage.eINSTANCE);
        
        names = new java.util.ArrayList<String>(names);
        names.set(1, TypesPackage.eINSTANCE.getName());
        OCL_PACKAGES.put(names, TypesPackage.eINSTANCE);
        
        names = new java.util.ArrayList<String>(names);
        names.set(1, UtilitiesPackage.eINSTANCE.getName());
        OCL_PACKAGES.put(names, UtilitiesPackage.eINSTANCE);
        
        names = new java.util.ArrayList<String>(names);
        names.set(1, EcorePackage.eINSTANCE.getName());
        OCL_PACKAGES.put(names, EcorePackage.eINSTANCE);
    } */
	
	private final EnvironmentFactory factory;
	private TypeManager typeManager;
	
	/**
	 * Initializes me with a package registry for package look-ups.
	 * 
	 * @param reg a package registry
	 *
	public PivotEnvironment(EPackage.Registry reg, TypeManager typeManager) {
		registry = reg;
		typeResolver = createTypeResolver();
		this.typeManager = typeManager;
		uml = new PivotReflectionImpl(typeManager);
	} */
	
    /**
     * Initializes me with a package registry and a resource in which I am
     * persisted (and from which I load myself if it already has content).
     * 
     * @param reg a package registry
     * @param resource a resource, which may or may not already have content
     *
	protected PivotEnvironment(EPackage.Registry reg, Resource resource) {
		registry = reg;
		typeResolver = createTypeResolver(resource);
	} */

	/**
	 * Initializes me with an environment factory from which package registry
	 * and opposite end finder (if any) are obtained consistently, and from a
	 * resource in which I am persisted (and from which I load myself if it
	 * already has content).
	 * 
	 * @param reg
	 *            a package registry
	 * @param resource
	 *            a resource, which may or may not already have content
	 * @since 3.1
	 */
	protected PivotEnvironment(PivotEnvironmentFactory factory, Resource resource) {
		this.factory = factory;
		this.typeManager = factory.getTypeManager();
	}

    /**
     * Initializes me with a parent environment, from which I inherit such things
     * as a package registry and a resource.
     * 
     * @param parent my parent environment
     */
	protected PivotEnvironment(PivotEnvironment parent) {		
		super(parent);
		factory = parent.factory;
		typeManager = parent.typeManager;
	}

    // implements the inherited specification
	public EnvironmentFactory getFactory() {
		return factory;
	}
	
	/**
	 * Obtains the states matching the specified path prefix in the owner type
	 * by trying the {@link #collectStates} method on it and, recursively, its
	 * supertypes to find all matches.  For implicit (<code>null</code>) owners,
	 * looks up the innermost-scoped variable as the implicit source and tries
	 * again on this variable's type.
	 * <p>
	 * To extend this implementation, override the
	 * {@link #collectStates} method.
	 * </p>
	 */
	public List<State> getStates(Type owner, List<String> pathPrefix) {
		List<State> result = new ArrayList<State>();
		
/*		collectStates(owner, pathPrefix, result);
		
		if (owner instanceof EClass) {
			// search supertypes
			for (EClass superclass : ((EClass) owner).getEAllSuperTypes()) {
				collectStates(superclass, pathPrefix, result);
			}
		} */
		
		return result;
	}
	
	/**
	 * Implemented by subclasses to find all states in the specified owner type
	 * that match the given path name prefix and add them to the accumulator
	 * list.  The default implementation does nothing, as Ecore does not model
	 * states.
	 * <p>
	 * Implementors must only provide the states defined directly in the
	 * namespace indicated by the path prefix (i.e., only one level).
	 * </p>
	 * 
	 * @param owner the owner type
	 * @param pathPrefix partial qualified name, specifying the parent of the
     *     states to be collection
	 * @param states a list of states directly owned by the namespace indicated
	 *     by path prefix, within the owner type
     *     
     * @see #getStates(Type, List)
	 */
	protected void collectStates(Type owner, List<String> pathPrefix, List<State> states) {
		// do nothing
	}
	
	public Constraint getDefinition(Object feature) {
    	Constraint result = null;
		ETypedElement typedFeature = (ETypedElement) feature;
    	
    	EAnnotation ann = typedFeature.getEAnnotation(
    			Environment.OCL_NAMESPACE_URI);
    	
    	if ((ann != null) && !ann.getContents().isEmpty()) {
    		for (EObject o : ann.getContents()) {
    			if ((o instanceof Constraint)
    					&& UMLReflection.DEFINITION.equals(((Constraint) o).getStereotype())) {
    				
    				result = (Constraint) o;
    				break;
    			}
    		}
    	}
    	
    	return result;
	}

	public StandardLibrary getOCLStandardLibrary() {
		return typeManager;
	}

	public TypeManager getTypeManager() {
		return typeManager;
	}

	public OCLFactory getOCLFactory() {
		return OCLFactoryImpl.INSTANCE;
	}

//	@Override
//	protected OCLRoot createOCLLibrary() {
//		return EcoreOCLLibrary.getDefault();
//	}
}

