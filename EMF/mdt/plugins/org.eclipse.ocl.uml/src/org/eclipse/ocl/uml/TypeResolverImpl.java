/**
 * <copyright> 
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
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
 * $Id: TypeResolverImpl.java,v 1.5 2009/06/25 19:23:24 ewillink Exp $
 */
package org.eclipse.ocl.uml;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.AbstractTypeResolver;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;


/**
 * UML implementation of the {@link TypeResolver} interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TypeResolverImpl
	extends AbstractTypeResolver<Package, Classifier, Operation, Property, Parameter> {
	
    /**
     * Initializes me with an {@link Environment}.
     * 
     * @param env my environment
     */
	public TypeResolverImpl(UMLEnvironment env) {
		super(env);
	}
	
	/**
	 * Initializes me with a resource in which I will persist the model-based
	 * types that I generate in my associated {@link Environment}.
	 * 
	 * @param resource my resource
	 */
	public TypeResolverImpl(UMLEnvironment env, Resource resource) {
		super(env, resource);
	}
	
    // Documentation copied from the inherited implementation
    @Override
	protected Resource createResource() {
		return UMLResource.Factory.INSTANCE.createResource(
				URI.createURI("ocl:///oclenv.uml")); //$NON-NLS-1$
	}
    
    // Documentation copied from the inherited specification
    @Override
    protected Package createPackage(String name) {
        Package result = UMLFactory.eINSTANCE.createPackage();
        
        result.setName(name);
        getResource().getContents().add(result);
        
        return result;
    }
	
    // Documentation copied from the inherited specification
    @Override
	protected Package findPackage(String name) {
		Package result = null;
		
		for (EObject o : getResource().getContents()) {
			if (o instanceof Package) {
				Package pkg = (Package) o;
				
				if (name.equals(pkg.getName())) {
					result = pkg;
					break;
				}
			}
		}
		
		return result;
	}
    
    // Documentation copied from the inherited specification
    @Override
    protected void addClassifier(Package pkg, Classifier classifier) {
        pkg.getPackagedElements().add(classifier);
    }
	
	// Documentation copied from the inherited specification
    @Override
	protected void addOperation(Classifier owner, Operation operation) {
		((Class) owner).getOwnedOperations().add(operation);
	}
	
	// Documentation copied from the inherited specification
    @Override
	protected void addProperty(Classifier owner, Property property) {
		((Class) owner).getOwnedAttributes().add(property);
	}
	
    // Documentation copied from the inherited specification
    @Override
	protected Class createShadowClass(Classifier type) {
		// the additional features may have invalid characters in their names
		Class result = UMLFactory.eINSTANCE.createClass();
		result.setName(type.getName() + "_Class"); //$NON-NLS-1$
		
        result.createSubstitution("realOwner", type); //$NON-NLS-1$
		return result;
	}
	
    // Documentation copied from the inherited specification
    @Override
	protected Classifier getShadowedClassifier(Classifier shadow) {
        if (shadow instanceof Class) {
            return OCLStandardLibraryImpl.getRealClassifier((Class) shadow);
        }
        
        return null;
	}
    
	@Override
    public CollectionType<Classifier, Operation> resolveCollectionType(
            CollectionKind kind, Classifier elementType) {
        
        CollectionType<Classifier, Operation> result = super.resolveCollectionType(
                kind, elementType);
        
        // ensure that the collection type's operations are correctly defined
        DataType umlResult = (DataType) result;
        Collection<Operation> ownedOperations = umlResult.getOwnedOperations();
        if (ownedOperations.isEmpty()) {
            // first, add a token operation to ensure that the list is not
            // empty, avoiding unbounded recursion
            Operation token = UMLFactory.eINSTANCE.createOperation();
            ownedOperations.add(token);
            
            try {
                ownedOperations.addAll(OCLStandardLibraryImpl.createCollectionTypeOperations(
                        getEnvironment(), kind));
            } finally {            
                ownedOperations.remove(token);  // remove the token
            }
        }
        
        return result;
    }
}
