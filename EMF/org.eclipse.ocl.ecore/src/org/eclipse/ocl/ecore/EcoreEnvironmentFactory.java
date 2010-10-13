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
 * $Id: EcoreEnvironmentFactory.java,v 1.2 2007/03/22 21:59:19 cdamus Exp $
 */

package org.eclipse.ocl.ecore;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.AbstractEnvironmentFactory;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;



/**
 * Implementation of the {@link EnvironmentFactory} for parsing OCL expressions
 * on Ecore models.
 *
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEnvironmentFactory
	extends AbstractEnvironmentFactory<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> {
	
	/**
     * A convenient shared instance of the environment factory, that creates
     * environments using the global package registry.
	 */
    public static EcoreEnvironmentFactory INSTANCE = new EcoreEnvironmentFactory();
	
	private final EPackage.Registry registry;

	/**
	 * Initializes me.  Environments that I create will use the global package
     * registry to look up packages.
	 */
	public EcoreEnvironmentFactory() {
		this(EPackage.Registry.INSTANCE);
	}
	
	/**
	 * Initializes me with an <code>EPackage.Registry</code> that the
     * environments I create will use to look up packages.
     * 
     * @param reg my package registry (must not be <code>null</code>)
	 */
	public EcoreEnvironmentFactory(EPackage.Registry reg) {
		super();
		this.registry = reg;
	}
	
    // implements the inherited specification
    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	createEnvironment() {
		EcoreEnvironment result = new EcoreEnvironment(registry);
		result.setFactory(this);
		return result;
	}
	
    // implements the inherited specification
    public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	loadEnvironment(Resource resource) {
		EcoreEnvironment result = new EcoreEnvironment(registry, resource);
		result.setFactory(this);
		return result;
	}
	
    /**
     * Obtains the package registry used by environment that I create to look
     * up packages.
     * 
     * @return my package registry
     */
	public final EPackage.Registry getEPackageRegistry() {
		return registry;
	}
	
    // implements the inherited specification
	@Override
	protected EPackage lookupPackage(List<String> pathname) {
		return EcoreEnvironment.findPackage(pathname, registry);
	}

    // implements the inherited specification
	@Override
	protected EClassifier getClassifier(Object context) {
        return oclType(context);
	}
    
    static EClassifier oclType(Object object) {
        EClassifier result = null;
        
        if (object instanceof EObject) {
            result = ((EObject) object).eClass();
        } else {
            // maybe it's an instance of an Ecore data type?
            for (EClassifier next : EcorePackage.eINSTANCE.getEClassifiers()) {
                if ((next != EcorePackage.Literals.EJAVA_OBJECT) && (next.isInstance(object))) {
                    result = UMLReflectionImpl.INSTANCE.asOCLType(next);
                    break;
                }
            }
            
            if (result == null) {
                // it's just some weirdo object that we don't understand
                result = OCLStandardLibraryImpl.INSTANCE.getOclAny();
            }
        }
        
        return result;
    }

    // implements the inherited specification
	public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
	createEnvironment(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
		if (!(parent instanceof EcoreEnvironment)) {
			throw new IllegalArgumentException(
				"Parent environment must be an Ecore environment: " + parent); //$NON-NLS-1$
		}
		
		EcoreEnvironment result = new EcoreEnvironment(parent);
		result.setFactory(this);
		return result;
	}

    // implements the inherited specification
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
	createEvaluationEnvironment() {
		return new EcoreEvaluationEnvironment();
	}

    // implements the inherited specification
	public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
	createEvaluationEnvironment(
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
		return new EcoreEvaluationEnvironment(parent);
	}
}
