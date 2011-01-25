/**
 * <copyright> 
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 182994
 *
 * </copyright>
 *
 * $Id: TypeResolverImpl.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.util.PivotPlugin;


/**
 * Ecore implementation of the {@link TypeResolver} interface.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TypeResolverImpl extends AbstractTypeResolver {
	
    /**
     * Initializes me with an environment.  I create my own resource for
     * persistence of model-based types.
     * 
     * @param env the environment that I persist
     */
	public TypeResolverImpl(PivotEnvironment env) {
		super(env);
	}
	
    /**
     * Initializes me with a resource in which I will persist the model-based
     * types that I generate in my associated {@link Environment}.
     * 
     * @param env my environment
     * @param resource my resource
     */
	public TypeResolverImpl(PivotEnvironment env, Resource resource) {
		super(env, resource);
	}
    
    // Documentation copied from the inherited implementation
    @Override
	protected Resource createResource() {
//    	return null;
//    	throw new UnsupportedOperationException(getClass().getName() + ".createResource");
		Resource.Factory factory = PivotPlugin.getPivotResourceFactory();
        
        return factory.createResource(URI.createURI("ocl:///oclenv.ecore")); //$NON-NLS-1$
	}
    
    // Documentation copied from the inherited implementation
    @Override
    protected org.eclipse.ocl.examples.pivot.Package createTuplePackage() {
    	throw new UnsupportedOperationException(getClass().getName() + ".createTuplePackage");
//    	org.eclipse.ocl.examples.pivot.Package result = super.createTuplePackage();
        
//        result.setEFactoryInstance(new TupleFactory());
        
//        return result;
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected org.eclipse.ocl.examples.pivot.Package createPackage(String name) {
    	org.eclipse.ocl.examples.pivot.Package result = PivotFactory.eINSTANCE.createPackage();
        
        result.setName(name);
        getResource().getContents().add(result);
        
        return result;
    }
    
    // Documentation copied from the inherited specification
    @Override
	protected org.eclipse.ocl.examples.pivot.Package findPackage(String name) {
    	org.eclipse.ocl.examples.pivot.Package result = null;
		
		for (EObject o : getResource().getContents()) {
			if (o instanceof org.eclipse.ocl.examples.pivot.Package) {
				org.eclipse.ocl.examples.pivot.Package epkg = (org.eclipse.ocl.examples.pivot.Package) o;
				
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
    protected void addClassifier(org.eclipse.ocl.examples.pivot.Package pkg, Type classifier) {
        pkg.getOwnedTypes().add(classifier);
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected void addOperation(Type owner, Operation operation) {
        ((org.eclipse.ocl.examples.pivot.Class) owner).getOwnedOperations().add(operation);
    }
    
    // Documentation copied from the inherited specification
    @Override
    protected void addProperty(Type owner, Property property) {
        ((org.eclipse.ocl.examples.pivot.Class) owner).getOwnedAttributes().add(property);
    }
	
    // Documentation copied from the inherited specification
    @Override
	protected org.eclipse.ocl.examples.pivot.Class createShadowClass(Type type) {
    	throw new UnsupportedOperationException(getClass().getName() + ".createShadowClass");
//		return OCLStandardLibraryImpl.createShadowClass(type);
	}
    
    // Documentation copied from the inherited specification
    @Override
    protected Type getShadowedClassifier(Type shadow) {
    	throw new UnsupportedOperationException(getClass().getName() + ".getShadowedClassifier");
//        if (shadow instanceof EClass) {
//            return OCLStandardLibraryImpl.getRealClassifier((EClass) shadow);
//        }
        
//        return null;
	}

	public Type resolve(Type type) {
		return type;
	}
}
