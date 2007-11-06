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
 * $Id: UMLEnvironmentFactory.java,v 1.6 2007/11/06 19:47:01 cdamus Exp $
 */

package org.eclipse.ocl.uml;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.AbstractEnvironmentFactory;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.helper.OCLHelper;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.ValueSpecification;



/**
 * Implementation of the {@link EnvironmentFactory} for parsing OCL expressions
 * on UML models.
 * <p>
 * The parser environments created by the UML environment factory support OCL
 * expressions at both the metamodel (M2) and user model (M1) levels.  For
 * user model constraints, use the classifier in the model as the context
 * classifier in invocations of an {@link OCL} or an {@link OCLHelper}
 * created by it.  For metamodel OCL (used, for example, to query the user
 * model, itself) use the metaclass of any element in the user model as the
 * context classifier.  A convenient way to obtain this metaclass is via the
 * {@link OCLUMLUtil#getMetaclass(org.eclipse.uml2.uml.Element)} method.
 * </p>
 *
 * @author Christian W. Damus (cdamus)
 */
public class UMLEnvironmentFactory
	extends AbstractEnvironmentFactory<
		Package, Classifier, Operation, Property,
		EnumerationLiteral, Parameter,
		State, CallOperationAction, SendSignalAction, Constraint,
		Class, EObject> {

    private final EPackage.Registry registry;
	private final ResourceSet resourceSet;

    private Package umlMetamodel;
    
    // cache of EClass to UML Classfier
    private Map<EClass, Classifier> eclassToClassifierMap =
        new java.util.HashMap<EClass, Classifier>();
    private Map<List<String>, Package> packageCache =
        new java.util.HashMap<List<String>, Package>();
    
    /**
     * Initializes me.  Environments that I create will use a private resource
     * set and its package registry to look up UML packages and their Ecore
     * definitions.
     */
	public UMLEnvironmentFactory() {
		this(new ResourceSetImpl());
	}
	
    /**
     * Initializes me with a resource set that the environments I create
     * will use (along with its package registry) to look up UML packages and
     * their Ecore definitions.
     * 
     * @param rset my resource set (must not by <code>null</code>)
     */
	public UMLEnvironmentFactory(ResourceSet rset) {
		this(rset.getPackageRegistry(), rset);
	}
	
    /**
     * Initializes me with a resource set and package registry that the
     * environments I create will use to look up UML packages and
     * their Ecore definitions.
     * 
     * @param registry my package registry (must not be <code>null</code>)
     * @param rset my resource set (must not be <code>null</code>)
     */
	public UMLEnvironmentFactory(EPackage.Registry registry, ResourceSet rset) {
		super();
		
		this.registry = registry;
		this.resourceSet = rset;
	}
	
    // implements the inherited specification
	public UMLEnvironment createEnvironment() {
		UMLEnvironment result = new UMLEnvironment(registry, resourceSet);
		result.setFactory(this);
		return result;
	}
	
    // implements the inherited specification
	public Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> loadEnvironment(
			Resource resource) {
		UMLEnvironment result = new UMLEnvironment(registry, resourceSet, resource);
		result.setFactory(this);
		return result;
	}
	
    /**
     * Obtains the package registry that the environment I create will use to
     * look up the Ecore definitions of UML packages.
     * 
     * @return my package registry
     */
	public final EPackage.Registry getEPackageRegistry() {
		return registry;
	}
	
    /**
     * Obtains the resource set that the environment I create will use to
     * find UML packages.
     * 
     * @return my resource set
     */
	public final ResourceSet getResourceSet() {
		return resourceSet;
	}
	
    /**
     * Obtains the UML metamodel library, loaded in my resource set.
     * 
     * @return the UML metamodel
     */
	protected Package getUMLMetamodel() {
        if (umlMetamodel == null) {
            umlMetamodel = OCLUMLUtil.getUMLMetamodel(getResourceSet());
        }
        
        return umlMetamodel;
	}
	
    // implements the inherited specification
	@Override
	protected Package lookupPackage(List<String> pathname) {
        Package result = packageCache.get(pathname);
        
		if (result == null) {
		    result = OCLUMLUtil.findPackage(pathname, resourceSet);
            packageCache.put(pathname, result);
        }
        
        return result;
	}

    // implements the inherited specification
	@Override
	protected Classifier getClassifier(Object context) {
		Classifier result;
		
		if (context instanceof InstanceSpecification) {
			InstanceSpecification instance = (InstanceSpecification) context;
			if (!instance.getClassifiers().isEmpty()) {
				result = instance.getClassifiers().get(0);
			} else {
			    // unclassified instance specification
                result = OCLStandardLibraryImpl.INSTANCE.getOclAny();
            }
		} else if (context instanceof ValueSpecification) {
			if (context instanceof InstanceValue) {
				result = getClassifier(((InstanceValue) context).getInstance());
			} else if (context instanceof LiteralBoolean) {
				result = OCLStandardLibraryImpl.INSTANCE.getBoolean();
			} else if (context instanceof LiteralString) {
				result = OCLStandardLibraryImpl.INSTANCE.getString();
			} else if (context instanceof LiteralInteger) {
				result = OCLStandardLibraryImpl.INSTANCE.getInteger();
			} else { // TODO: Should OCL add a LiteralReal value specification?
                result = OCLStandardLibraryImpl.INSTANCE.getOclAny();
            }
		} else if (context instanceof EObject) {
			// an instance of a metaclass that was modeled in UML and
			//   generated to code?
			EClass eclass = ((EObject) context).eClass();
            
            result = eclassToClassifierMap.get(eclass);
            if (result == null) {
                result = OCLUMLUtil.getClassifier(eclass, resourceSet);
                
                if (result == null) {
                    // cache the failed lookup for next time
                    result = OCLStandardLibraryImpl.INSTANCE.getOclAny();
                }
                
                eclassToClassifierMap.put(eclass, result);
            }
		} else {
			// maybe it's an instance of a standard data type?
			if (context instanceof String) {
				result = OCLStandardLibraryImpl.INSTANCE.getString();
			} else if (context instanceof Boolean) {
				result = OCLStandardLibraryImpl.INSTANCE.getBoolean();
			} else if (context instanceof Integer) {
				result = OCLStandardLibraryImpl.INSTANCE.getInteger();
			} else if (context instanceof Double) {
				result = OCLStandardLibraryImpl.INSTANCE.getReal();
			} else {
				// it's just some weirdo object that we don't understand
				result = OCLStandardLibraryImpl.INSTANCE.getOclAny();
			}
		}
		
		return result;
	}

    // implements the inherited specification
	public Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject>
	createEnvironment(
			Environment<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint, Class, EObject> parent) {
		
		if (!(parent instanceof UMLEnvironment)) {
			throw new IllegalArgumentException(
				"Parent environment must be a UML environment: " + parent); //$NON-NLS-1$
		}
		
		UMLEnvironment result = new UMLEnvironment(parent);
		result.setFactory(this);
		return result;
	}

    // implements the inherited specification
	public EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> createEvaluationEnvironment() {
		return new UMLEvaluationEnvironment(this);
	}

    // implements the inherited specification
	public EvaluationEnvironment<Classifier, Operation, Property, Class, EObject>
	createEvaluationEnvironment(
			EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
		return new UMLEvaluationEnvironment(parent);
	}
}
