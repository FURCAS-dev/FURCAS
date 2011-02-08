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
 * $Id: PivotEnvironment.java,v 1.3 2011/01/30 11:17:26 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.lpg.ProblemHandler;

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
	
	private TypeResolver typeResolver;

	private TypeManager typeManager;

	private UMLReflection uml;
	
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
		this.typeResolver = createTypeResolver(resource);
		this.uml = new PivotReflectionImpl(typeManager);
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
		typeResolver = parent.typeResolver;
		typeManager = parent.typeManager;
		uml = parent.uml;
	}

    // implements the inherited specification
	public EnvironmentFactory getFactory() {
		return factory;
	}
	
    // implements the inherited specification
//	public OCLStandardLibrary<Type> getOCLStandardLibrary() {
//		return OCLStandardLibraryImpl.INSTANCE;
//	}

    // implements the inherited specification
	public TypeResolver getTypeResolver() {
		return typeResolver;
	}

    // implements the inherited specification
//    public OCLFactory getOCLFactory() {
//        return OCLFactoryImpl.INSTANCE;
//    }
    
    // implements the inherited specification
    public UMLReflection getUMLReflection() {
        return uml;
    }
	
	@Override
	protected ProblemHandler createDefaultProblemHandler(AbstractParser parser) {
		return new PivotProblemHandler(parser);
	}

	/**
	 * Creates a new type resolver for use with this environment, persisted
	 * in a default resource.
	 * 
	 * @return a new type resolver
	 * 
	 * @deprecated Override the {@link #createTypeResolver(Resource)} method,
	 *     instead, handling the case where the resource is <code>null</code>
	 */
	@Deprecated
    protected TypeResolver createTypeResolver() {
		return createTypeResolver(null);
	}
		
    /**
     * <p>
     * Creates a new type resolver for use with this environment.
     * </p><p>
     * Subclasses may override.
     * </p>
     * 
	 * @param resource the resource for the type resolver's persistence
	 * @return a new type resolver
     * 
     * @since 1.2
	 */
	protected TypeResolver createTypeResolver(Resource resource) {
		return new TypeResolverImpl(this, resource);
	}

    /**
     * {@inheritDoc}
     * <p>
     * Implements the inherited specification by looking up the qualified name
     * in my package registry.
     * </p>
     *
	public org.eclipse.ocl.examples.pivot.Package lookupPackage(List<String> path) {
        if (!path.isEmpty() && OCL_PACKAGES.containsKey(path)) {
            return OCL_PACKAGES.get(path);
        }
        
		EPackage pkg = null;
		EPackage currPkg = getContextPackage();

		// Check whether this package is in the default package
		if (currPkg != null) {
            List<String> lookup = path;
            
			while (currPkg != null) {
				pkg = currPkg;
				
				for (int i = 0; i < lookup.size(); i++) {
					String name = lookup.get(i);
					pkg = EcoreForeignMethods.getESubpackage(pkg, name);
					
					if (pkg == null) {
						break;
					}
				}
				
				if (pkg != null) {
					return pkg;
				}

                if ((currPkg == getContextPackage()) && (lookup.size() > 0)
                    && EcoreForeignMethods.isNamed(lookup.get(0), currPkg)) {
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
		return findPackage(path, registry);
	} */

    /* implements the inherited specification
	public Type lookupClassifier(List<String> names) {
		EPackage pkg = null;
		EPackage currPkg = getContextPackage();

		if (names.size() > 1) {
            List<String> lookup = names;

			// Check whether this package is in the default package
			if (currPkg != null) {
				while (currPkg != null) {

					pkg = currPkg;
					for (int i = 0; i < lookup.size() - 1; i++) {
						String name = lookup.get(i);
						pkg = EcoreForeignMethods.getESubpackage(pkg, name);
						
						if (pkg == null) {
							break;
						}
					}
					
					if (pkg != null) {
						return EcoreForeignMethods.getEClassifier(pkg, lookup
                            .get(lookup.size() - 1));
					}

                    if ((currPkg == getContextPackage()) && (lookup.size() > 1)
                        && EcoreForeignMethods.isNamed(lookup.get(0), currPkg)) {
                        // handle the case where the first part of the qualified
                        // name matches the context package name
                        lookup = lookup.subList(1, lookup.size());
                    } else {
                        lookup = names;
                        currPkg = currPkg.getESuperPackage();
                    }
				}
			}
			
			// Check whether this package exists
			List<String> newNames = names.subList(0, names.size() - 1);
			pkg = findPackage(newNames, registry);
			if (pkg == null) {
				return null;
			}
			
			return EcoreForeignMethods.getEClassifier(pkg, names.get(names.size() - 1));
		} else if (getContextPackage() != null) {
			String name = names.get(0);
			EClassifier result = null;
			while (currPkg != null) {
				result = EcoreForeignMethods.getEClassifier(currPkg, name);
				
				if (result != null) {
					return result;
				}
				
				currPkg = currPkg.getESuperPackage();
			}
		}
		
		return null;
	} */
	
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

    /* implements the inherited specification
	public Property defineAttribute(
			Type owner,
			org.eclipse.ocl.expressions.Variable<
				Type, Parameter> variable,
			Constraint constraint) {
		
		String name = variable.getName();
		EClassifier type = variable.getType();
		mergeProperty(owner, name, type, constraint);
		Property result;		
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
	} */
	
    /* implements the inherited specification
	public Operation defineOperation(Type owner, String name,
			Type type,
			List<org.eclipse.ocl.expressions.Variable<
				Type, Parameter>> params,
			Constraint constraint) {
		mergeOperation(owner, name, type, params, constraint);
		Operation result = EcoreFactory.eINSTANCE.createEOperation();
		
		result.setName(name);
		result.setEType((type == null) ? getOCLStandardLibrary().getOclVoid() :
            type);
		
		for (Variable<Type, Parameter> next : params) {
			Parameter param = EcoreFactory.eINSTANCE.createEParameter();
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
	} */
	
    /* implements the inherited specification
	public void undefine(Object feature) {
		Constraint definition = getDefinition(feature);
		
		if (definition == null) {
			throw new IllegalArgumentException(
                "not an additional feature: " + feature); //$NON-NLS-1$
		}
		
		EcoreUtil.remove((EObject) feature);
		EcoreUtil.remove(definition);
		
		definition.getConstrainedElements().clear();
	} */
	
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
	 * Looks in the EMF registry for a package with the specified qualified
	 * package name. Uses the global package registry.
	 * 
	 * @param packageNames
	 *            the qualified package name
	 * @return the matching EPackage, or <code>null</code> if not found
	 *
	static public org.eclipse.ocl.examples.pivot.Package findPackage(List<String> packageNames) {
		return findPackage(packageNames, EPackage.Registry.INSTANCE);
	} */

	/**
	 * Looks in the given registry for a package with the specified qualified
	 * package name.
	 * 
	 * @param packageNames
	 *            the qualified package name
	 * @param registry the EPackage.Registry to look in
	 * @return the matching EPackage, or <code>null</code> if not found
	 *
	static public org.eclipse.ocl.examples.pivot.Package findPackage(List<String> packageNames, EPackage.Registry registry) {
		if (packageNames.isEmpty()) {
			return null;
		}
		
//        if (OCL_PACKAGES.containsKey(packageNames)) {
//            return OCL_PACKAGES.get(packageNames);
//        }
        
		String name = packageNames.get(0);
		for (Object next : registry.values()) {
			if (next instanceof EPackage) {
				EPackage ePackage = (EPackage) next;
				
				// only consider root-level packages when searching by name
				if ((ePackage.getESuperPackage() == null)
						&& EcoreForeignMethods.isNamed(name, ePackage)) {
					
					EPackage tentativeResult = findNestedPackage(
							packageNames.subList(1, packageNames.size()),
							ePackage);
					
					if (tentativeResult != null) {
						return tentativeResult;
					}
				}
			}
		}

		return findPackageByNSPrefix(packageNames, registry);
	} */

	/**
	 * Looks in the given package for a nested package with the specified relative
	 * package name.
	 * 
	 * @param packageNames
	 *            the relativ package name
	 * @param epackage the starting package to look in
	 * @return the matching EPackage, or <code>null</code> if not found
	 *
	private static EPackage findNestedPackage(
			List<String> packageNames,
			org.eclipse.ocl.examples.pivot.Package epackage) {
		
	    EPackage result = epackage;
	    
		for (String name : packageNames) {
		    result = EcoreForeignMethods.getESubpackage(result, name);
		    
		    if (result == null) {
		        break;
		    }
		}
		
		return result;
	} */

	/**
	 * Looks in the given registry for a package with the specified qualified
	 * package name, matching the name against the namespace prefixes of the
	 * packages in the registry.
	 * 
	 * @param packageNames
	 *            the qualified package name
	 * @param registry the EPackage.Registry to look in
	 * @return the NSPrefix-matching EPackage, or <code>null</code> if not found
	 *
	private static org.eclipse.ocl.examples.pivot.Package findPackageByNSPrefix(
			List<String> packageNames,
			EPackage.Registry registry) {

		StringBuffer stringBuffer = new StringBuffer();
		Iterator<String> it = packageNames.iterator();
		while (it.hasNext()) {
			stringBuffer.append(it.next());
			if (it.hasNext()) {
				stringBuffer.append(".");//$NON-NLS-1$
			}
		}

		String nsPrefix = stringBuffer.toString();

		for (Object next : registry.values()) {
			if (next instanceof EPackage) {
				EPackage ePackage = (EPackage) next;
				if (nsPrefix.equals(ePackage.getNsPrefix())) {
					return ePackage;
				}
			}
		}

		return null;
	} */

    // implements the inherited specification
	public boolean isInPostcondition(OclExpression exp) {
		
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

	public StandardLibrary getOCLStandardLibrary() {
		return typeManager;
	}

	public TypeManager getTypeManager() {
		return typeManager;
	}

	public org.eclipse.ocl.examples.pivot.Package lookupPackage(List<String> names) {
		// TODO Auto-generated method stub
		return null;
	}

	public Type lookupClassifier(List<String> names) {
		// TODO Auto-generated method stub
		return null;
	}

	public Property defineAttribute(Type owner,
			Variable variable, Constraint constraint) {
		// TODO Auto-generated method stub
		return null;
	}

	public Operation defineOperation(Type owner, String name, Type type,
			List<Variable> params, Constraint constraint) {
		// TODO Auto-generated method stub
		return null;
	}

	public void undefine(Object feature) {
		// TODO Auto-generated method stub
		
	}

	public OCLFactory getOCLFactory() {
		return OCLFactoryImpl.INSTANCE;
	}

//	@Override
//	protected OCLRoot createOCLLibrary() {
//		return EcoreOCLLibrary.getDefault();
//	}
}

