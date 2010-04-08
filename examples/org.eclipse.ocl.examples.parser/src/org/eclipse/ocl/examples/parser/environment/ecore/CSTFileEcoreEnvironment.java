/******************************************************************************
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CSTFileEcoreEnvironment.java,v 1.2 2010/04/08 06:26:21 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.environment.ecore;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.EcorePackage;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.internal.OCLFactoryImpl;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.examples.parser.environment.CSTFileEnvironment;
import org.eclipse.ocl.expressions.ExpressionsPackage;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.expressions.impl.ExpressionsPackageImpl;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;
import org.eclipse.ocl.types.OCLStandardLibrary;
import org.eclipse.ocl.types.TypesPackage;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.UtilitiesPackage;

@SuppressWarnings("restriction")		// FIXME Eliminate @SuppressWarnings("restriction")
public abstract class CSTFileEcoreEnvironment<RV extends ICSTRootEcoreEnvironment, V extends ICSTNodeEcoreEnvironment, CST extends CSTNode>
	extends CSTFileEnvironment<EPackage, EClassifier, EOperation, EStructuralFeature,
	EEnumLiteral, EParameter,
	EObject, CallOperationAction, SendSignalAction, Constraint,
	EClass, EObject, RV, V, CST> implements ICSTFileEcoreEnvironment
{
	// FIXME This is a public duplicate of EcoreEnvironment.OCL_PACKAGES
	public static final Map<List<String>, EPackage> OCL_PACKAGES =
        new java.util.HashMap<List<String>, EPackage>();
        
    static {
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
    }
	
	private EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter,
			EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject>
	factory;
	
//	private TypeResolver<EClassifier, EOperation, EStructuralFeature> typeResolver;

    protected CSTFileEcoreEnvironment(FileHandle file, ResourceSet resourceSet, XMIResource astResource) {
		super(file, resourceSet, astResource);
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
     * @see #getStates(EClassifier, List)
	 */
	protected void collectStates(EClassifier owner, List<String> pathPrefix, List<EObject> states) {
		// do nothing
	}

    // implements the inherited specification
//	@Override
	public EnvironmentFactory<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter,
			EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject>
	createFactory() {
		EPackage.Registry registry = getRegistry();
		if (registry  == EPackage.Registry.INSTANCE) {
			return EcoreEnvironmentFactory.INSTANCE;
		} else {
			return new EcoreEnvironmentFactory(registry);
		}
	}
	
//	@Override
	@SuppressWarnings("deprecation")
	protected TypeResolver<EClassifier, EOperation, EStructuralFeature> createTypeResolver() {
		return new EcoreTypeResolverImpl(this, ast);
	}

	@Deprecated
	@Override
	protected TypeResolver<EClassifier, EOperation, EStructuralFeature> createTypeResolver(Resource resource) {
		return new EcoreTypeResolverImpl(this, resource);
	}

//	@Override
	protected UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> createUMLReflection() {
		return UMLReflectionImpl.INSTANCE;
	}

	public EStructuralFeature defineAttribute(
			EClassifier owner,
			org.eclipse.ocl.expressions.Variable<
				EClassifier, EParameter> variable,
			Constraint constraint) {
		
		EStructuralFeature result;
		
		String name = variable.getName();
		EClassifier type = variable.getType();
		
		if (type instanceof EClass) {
			result = EcoreFactory.eINSTANCE.createEReference();
		} else {
			result = EcoreFactory.eINSTANCE.createEAttribute();
		}
		
		result.setName(name);
		result.setEType(type);
		
		Constraint existing = getDefinition(result);
		if (existing != null) {
			// replace existing definition
			EcoreUtil.replace(existing, constraint);
		} else {
			EAnnotation ann = result.getEAnnotation(Environment.OCL_NAMESPACE_URI);
			if (ann == null) {
				ann = EcoreFactory.eINSTANCE.createEAnnotation();
				ann.setSource(Environment.OCL_NAMESPACE_URI);
				result.getEAnnotations().add(ann);
			}

			ann.getContents().add(constraint);
		}
		
		addHelperProperty(owner, result);
		
		return result;
	}
	
	public EOperation defineOperation(EClassifier owner, String name,
			EClassifier type,
			List<org.eclipse.ocl.expressions.Variable<
				EClassifier, EParameter>> params,
			Constraint constraint) {
		EOperation result = EcoreFactory.eINSTANCE.createEOperation();
		
		result.setName(name);
		result.setEType((type == null) ? getOCLStandardLibrary().getOclVoid() :
            type);
		
		for (Variable<EClassifier, EParameter> next : params) {
			EParameter param = EcoreFactory.eINSTANCE.createEParameter();
			param.setName(next.getName());
			param.setEType((next.getType() == null)?
                getOCLStandardLibrary().getOclVoid() : next.getType());
			
			result.getEParameters().add(param);
		}
		
		Constraint existing = getDefinition(result);
		if (existing != null) {
			// replace existing definition
			EcoreUtil.replace(existing, constraint);
		} else {
			EAnnotation ann = result.getEAnnotation(Environment.OCL_NAMESPACE_URI);
			if (ann == null) {
				ann = EcoreFactory.eINSTANCE.createEAnnotation();
				ann.setSource(Environment.OCL_NAMESPACE_URI);
				result.getEAnnotations().add(ann);
			}

			ann.getContents().add(constraint);
		}
		
		addHelperOperation(owner, result);
		
		return result;
	}
	
//	@Override
	public EClassifier getClassifier(EPackage pkg, String name) {
		EClassifier result = pkg.getEClassifier(name);

		if ((result == null) && AbstractOCLAnalyzer.isEscaped(name)) {
			// try the unescaped name
			result = pkg.getEClassifier(AbstractOCLAnalyzer.unescape(name));
		}

		return result;
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
	
	/**
	 * Foreign method for {@link EPackage#getEClassifier(String)} that accounts
	 * for possibility of underscore-escaped names.
	 * 
	 * @param pkg
	 *            a package
	 * @param name
	 *            a possibly underscore-escaped name of a nested classifier
	 * 
	 * @return the matching classifier, or <code>null</code> if none
	 */
	@Deprecated // use getClassifier
	public EClassifier getEClassifier(EPackage pkg, String name) {
		return getClassifier(pkg, name);
	}

	public EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature,
	EEnumLiteral, EParameter,EObject, CallOperationAction, SendSignalAction, Constraint,
	EClass, EObject> getFactory() {
		if (factory == null) {
			// obtain a reasonable default factory
			if (registry == EPackage.Registry.INSTANCE) {
				factory = EcoreEnvironmentFactory.INSTANCE;
			} else {
				factory = new EcoreEnvironmentFactory(registry);
			}
		}
		return factory;
	}

//	@Override
	public EPackage getNestedPackage(EPackage pkg, String name) {
		for (EPackage sub : pkg.getESubpackages()) {
			if (name.equals(sub.getName())) {
				return sub;
			}
		}

		if (AbstractOCLAnalyzer.isEscaped(name)) {
			// try the unescaped name
			name = AbstractOCLAnalyzer.unescape(name);

			for (EPackage sub : pkg.getESubpackages()) {
				if (name.equals(sub.getName())) {
					return sub;
				}
			}
		}

		return null;
	}

	public OCLFactory getOCLFactory() {
		return OCLFactoryImpl.INSTANCE;
	}

	public OCLStandardLibrary<EClassifier> getOCLStandardLibrary() {
		return OCLStandardLibraryImpl.INSTANCE;
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
	public List<EObject> getStates(EClassifier owner, List<String> pathPrefix) {
		EList<EObject> result = new BasicEList<EObject>();
		
		collectStates(owner, pathPrefix, result);
		
		if (owner instanceof EClass) {
			// search supertypes
			for (EClass superclass : ((EClass) owner).getEAllSuperTypes()) {
				collectStates(superclass, pathPrefix, result);
			}
		}
		
		return result;
	}

	public UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> getUMLReflection() {
        return UMLReflectionImpl.INSTANCE;
    }

	public boolean isInPostcondition(
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> exp) {
		
		Constraint constraint = null;
		EObject parent = exp;
		while (parent != null) {
			if (parent instanceof Constraint) {
				constraint = (Constraint) parent;
				break;
			}
			
			parent = parent.eContainer();
		}
		
		return (constraint != null)
				&& UMLReflection.POSTCONDITION.equals(constraint.getStereotype());
	}


	public EClassifier lookupClassifier(List<String> names) {
 		return lookupClassifier(getContextPackage(), names);
	}

    public EClassifier lookupClassifier(EPackage contextPackage, List<String> names) {
		EPackage pkg = null;
		EPackage currPkg = contextPackage;

		UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> reflection = getUMLReflection();
		if (names.size() > 1) {
            List<String> lookup = names;

			// Check whether this package is in the default package
			if (currPkg != null) {
				while (currPkg != null) {

					pkg = currPkg;
					for (int i = 0; i < lookup.size() - 1; i++) {
						String name = lookup.get(i);
						pkg = getNestedPackage(pkg, name);
						
						if (pkg == null) {
							break;
						}
					}
					
					if (pkg != null) {
						return getClassifier(pkg, lookup.get(lookup.size() - 1));
					}

                    if ((currPkg == contextPackage) && (lookup.size() > 1)
                        && isNamed(currPkg, lookup.get(0))) {
                        // handle the case where the first part of the qualified
                        // name matches the context package name
                        lookup = lookup.subList(1, lookup.size());
                    } else {
                        lookup = names;
                        currPkg = reflection.getNestingPackage(currPkg);
                    }
				}
			}
			
			// Check whether this package exists
			List<String> newNames = names.subList(0, names.size() - 1);
			EPackage.Registry registry = getRegistry();
			pkg = EcoreEnvironment.findPackage(newNames, registry);
			if (pkg == null) {
				return null;
			}
			
			return getClassifier(pkg, names.get(names.size() - 1));
		} else if (contextPackage != null) {
			String name = names.get(0);
			EClassifier result = null;
			while (currPkg != null) {
				result = getClassifier(currPkg, name);
				
				if (result != null) {
					return result;
				}
				
				currPkg = reflection.getNestingPackage(currPkg);
			}
		}
		
		return null;
	}

	@Override
	protected boolean isNamed(EObject element, String name) {
		return (element instanceof ENamedElement)
		&& AbstractOCLAnalyzer.equalName(name, ((ENamedElement)element).getName());
	}

    /**
     * {@inheritDoc}
     * <p>
     * Implements the inherited specification by looking up the qualified name
     * in my package registry.
     * </p>
     */
    public EPackage lookupPackage(List<String> path) {
        if (!path.isEmpty() && OCL_PACKAGES.containsKey(path)) {
            return OCL_PACKAGES.get(path);
        }
        
		EPackage pkg = null;
		EPackage currPkg = getContextPackage();
//		UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> reflection = getUMLReflection();

		// Check whether this package is in the default package
		if (currPkg != null) {
            List<String> lookup = path;
            
			while (currPkg != null) {
				pkg = currPkg;
				
				for (int i = 0; i < lookup.size(); i++) {
					String name = lookup.get(i);
					pkg = getNestedPackage(pkg, name);
					
					if (pkg == null) {
						break;
					}
				}
				
				if (pkg != null) {
					return pkg;
				}

                if ((currPkg == getContextPackage()) && (lookup.size() > 0)
                    && isNamed(currPkg, lookup.get(0))) {
                    // handle the case where the first part of the qualified
                    // name matches the context package name
                    lookup = lookup.subList(1, lookup.size());
                } else {
                    lookup = path;
                    currPkg = currPkg.getESuperPackage();
                }
			}
		}
		
		// Check whether this package exists in the global package registry
		EPackage.Registry registry = getRegistry();
		return EcoreEnvironment.findPackage(path, registry);
	}
    
    // implements the inherited specification
	public void undefine(Object feature) {
		Constraint definition = getDefinition(feature);
		
		if (definition == null) {
			throw new IllegalArgumentException(
                "not an additional feature: " + feature); //$NON-NLS-1$
		}
		
		EcoreUtil.remove((EObject) feature);
		EcoreUtil.remove(definition);
		
		definition.getConstrainedElements().clear();
	}
}
