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
 * $Id: TypeResolverImpl.java,v 1.1 2007/01/25 18:29:10 cdamus Exp $
 */
package org.eclipse.ocl.ecore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.AbstractTypeResolver;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.internal.OCLEcorePlugin;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;


/**
 * Ecore implementation of the {@link TypeResolver} interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
class TypeResolverImpl
	extends AbstractTypeResolver<EPackage, EClassifier, EOperation, EStructuralFeature, EParameter> {
	
    /**
     * Initializes me with an environment.  I create my own resource for
     * persistence of model-based types.
     * 
     * @param env the environment that I persist
     */
	public TypeResolverImpl(EcoreEnvironment env) {
		super(env);
	}
	
    /**
     * Initializes me with a resource in which I will persist the model-based
     * types that I generate in my associated {@link Environment}.
     * 
     * @param env my environment
     * @param resource my resource
     */
	public TypeResolverImpl(EcoreEnvironment env, Resource resource) {
		super(env, resource);
	}
    
    // Documentation copied from the inherited implementation
    @Override
	protected Resource createResource() {
		Resource.Factory factory = OCLEcorePlugin.getEcoreResourceFactory();
        
        return factory.createResource(URI.createURI("ocl:///oclenv.ecore")); //$NON-NLS-1$
	}
    
    // Documentation copied from the inherited implementation
    @Override
    protected EPackage createTuplePackage() {
        EPackage result = super.createTuplePackage();
        
        result.setEFactoryInstance(new TupleFactory());
        
        return result;
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected EPackage createPackage(String name) {
        EPackage result = EcoreFactory.eINSTANCE.createEPackage();
        
        result.setName(name);
        getResource().getContents().add(result);
        
        return result;
    }
    
    // Documentation copied from the inherited specification
    @Override
	protected EPackage findPackage(String name) {
		EPackage result = null;
		
		for (EObject o : getResource().getContents()) {
			if (o instanceof EPackage) {
				EPackage epkg = (EPackage) o;
				
				if (name.equals(epkg.getName())) {
					result = epkg;
					break;
				}
			}
		}
		
		return result;
	}
    
    // Documentation copied from the inherited specification
    @Override
    protected void addClassifier(EPackage pkg, EClassifier classifier) {
        pkg.getEClassifiers().add(classifier);
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected void addOperation(EClassifier owner, EOperation operation) {
        ((EClass) owner).getEOperations().add(operation);
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected void addProperty(EClassifier owner, EStructuralFeature property) {
        ((EClass) owner).getEStructuralFeatures().add(property);
    }
	
    // Documentation copied from the inherited specification
    @Override
	protected EClass createShadowClass(EClassifier type) {
		return OCLStandardLibraryImpl.createShadowClass(type);
	}
    
    // Documentation copied from the inherited specification
    @Override
    protected EClassifier getShadowedClassifier(EClassifier shadow) {
        if (shadow instanceof EClass) {
            return OCLStandardLibraryImpl.getRealClassifier((EClass) shadow);
        }
        
        return null;
	}
}
