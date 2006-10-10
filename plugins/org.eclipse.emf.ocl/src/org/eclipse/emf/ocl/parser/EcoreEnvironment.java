/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 IBM Corporation and others.
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
 * $Id$
 */

package org.eclipse.emf.ocl.parser;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.internal.l10n.OCLMessages;
import org.eclipse.emf.ocl.internal.parser.OCLParser;
import org.eclipse.emf.ocl.types.impl.TypeUtil;
import org.eclipse.emf.ocl.uml.util.UMLTypeUtil;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.UTF16;

/**
 * An Environment stores the variables created while evaluating an OCL
 * expression, including self. It also stores the package, if the OCL package
 * statement is used. Methods are provided for querying whether variable,
 * property, operation, and association class reference names belong to the
 * environment.
 * <p>
 * This environment provides persistence of dynamically-generated types via
 * its {@link TypeResolver}'s resource.  The default resolver implementation
 * uses the most basic resource implementation, which does not support
 * persistence, so clients requiring persistence should initialize it with their
 * own resource.  Persistence of {@link Variable}s is virtual:  the variables
 * are stored in a resource that reconstructs variables on-the-fly from data
 * encoded in their URI fragments.
 * </p>
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEnvironment
	implements PersistentEnvironment {

	/* Used to generate implicit iterator variables */
	private static int generatorInt = 0;
	
	/**
	 * Obtains the appropriate OCL type for an Ecore typed element, according
	 * to its type, multiplicity, orderedness, and uniqueness.  The mapping is
	 * as follows:
	 * <ul>
	 *   <li>single-valued: EDataTypes map to corresponding OCL primitives
	 *       where possible.  Not a collection type</li>
	 *   <li>multi-valued: element type mapped to OCL primitives where possible.
	 *       Overall type maps to a collection type:
	 *     <ul>
	 *       <li>ordered, unique: ordered set type</li>
	 *       <li>ordered, non-unique: sequence type</li>
	 *       <li>non-ordered, unique: set type</li>
	 *       <li>non-ordered, non-unique: bag type</li>
	 *     </ul>
	 *   </li>
	 * </ul>
	 * 
	 * @param typedElement the ECore typed element to get the OCL type for
	 * @return the corresponding OCL type
	 * 
	 * @see #getOCLType(EClassifier)
	 * @see #getOCLCollectionType(EClassifier, boolean, boolean)
	 */	
	public static EClassifier getOCLType(ETypedElement typedElement) {
		return TypeUtil.getOCLType(typedElement);
	}
	
	/**
	 * Obtains the appropriate OCL type for an {@link EClassifier}, if it
	 * corresponds to an OCL primitive type.
	 * 
	 * @param type the type to convert to an OCL type
	 * @return the corresponding OCL type
	 */	
	public static EClassifier getOCLType(EClassifier type) {
		return TypeUtil.getOCLType(type);
	}
	
	/**
	 * Obtains the appropriate OCL collection type for an {@link EClassifier}, 
	 * according to the collection's orderedness and uniqueness.  The mapping is
	 * as follows:
	 * <ul>
	 *   <li>ordered, unique: ordered set type</li>
	 *   <li>ordered, non-unique: sequence type</li>
	 *   <li>non-ordered, unique: set type</li>
	 *   <li>non-ordered, non-unique: bag type</li>
	 * </ul>
	 * <p>
	 * Note that the collection's element <code>type</code> is mapped to an
	 * OCL primitive type where possible.
	 * </p>
	 * 
	 * @param type the type to get the corresponding OCL collection type for
	 * @param isOrdered whether the OCL type should be ordered
	 * @param isUnique whether the OCL type should be unique
	 * 
	 * @return the corresponding OCL type
	 * 
	 * @see #getOCLType(EClassifier)
	 */	
	public static EClassifier getOCLCollectionType(EClassifier type,
			boolean isOrdered, boolean isUnique) {
		return TypeUtil.getOCLCollectionType(type, isOrdered, isUnique);
	}

	/*
	 * List of declared variables and implicit variables. This list includes
	 * "self" Implicit variables are generated when there is an iterator with no
	 * iteration variable specified.
	 */
	private List namedElements = new java.util.ArrayList();

	private Variable selfVariable;
	
	private Environment parent;

	private EOperation contextOperation;
	
	private EStructuralFeature contextProperty;
	
	private synchronized String generateName() {
		generatorInt++;
		return "temp" + generatorInt;//$NON-NLS-1$
	}

	/*
	 * The defaultPackage is set when the OCL constraints are within a package
	 * statement. Otherwise, the defaultPackage is null.
	 */
	private EPackage defaultPackage;

	/**
	 * The registry for package lookups.
	 */
	private EPackage.Registry registry;
	
	private EnvironmentFactory factory;

	private Resource resource;
	
	private TypeResolver typeResolver;
	
	/**
	 * Create an environment, set the default package from a package
	 * statement, and set the package registry to the global package
     * registry.
	 * 
	 * @param pkg
	 */
	public EcoreEnvironment(EPackage pkg) {
		this(pkg, EPackage.Registry.INSTANCE);
	}

	/**
	 * Create an environment, set the default package from a package
	 * statement, and set the package registry
	 * 
	 * @param pkg
	 * @param reg
	 */
	public EcoreEnvironment(EPackage pkg, EPackage.Registry reg) {
		defaultPackage = pkg;
		registry = reg;
		
		resource = new EnvironmentResource();
	}

	public EcoreEnvironment(Environment parent) {
		if (parent instanceof EcoreEnvironment) {
			EcoreEnvironment eparent = (EcoreEnvironment) parent;
			defaultPackage = eparent.defaultPackage;
			registry = eparent.registry;
			
			resource = eparent.resource;
			typeResolver = eparent.getTypeResolver();
		} else {
			defaultPackage = parent.getContextClassifier().getEPackage();
			registry = EPackage.Registry.INSTANCE;
			
			resource = new EnvironmentResource();
		}
		this.parent = parent;
	}

	public EnvironmentFactory getFactory() {
		if (factory != null) {
			return factory;
		}
		
		if (getParent() != null) {
			factory = getParent().getFactory();
			if (factory != null) {
				return factory;
			}
		}
		
		// obtain a reasonable default factory
		if (registry == EPackage.Registry.INSTANCE) {
			factory = EcoreEnvironmentFactory.ECORE_INSTANCE;
		} else {
			factory = new EcoreEnvironmentFactory(registry);
		}
		
		return factory;
	}
	
	/**
	 * Sets the factory that created me.  This method should only be invoked
	 * by that factory.
	 * 
	 * @param factory my originating factory
	 */
	protected void setFactory(EnvironmentFactory factory) {
		this.factory = factory;
	}
	
	/**
	 * Set the parent environment
	 * 
	 * @param env
	 */
	public void setParent(Environment env) {
		parent = env;
	}

	/**
	 * get the parent environment
	 * 
	 * @return Environment
	 */
	public Environment getParent() {
		return parent;
	}
	
	public EClassifier getContextClassifier() {
		return getSelfVariable().getType();
	}
	
	public EOperation getContextOperation() {
		if (contextOperation != null) {
			return contextOperation;
		} else if (getParent() != null) {
			return getParent().getContextOperation();
		}
		
		return null;
	}
	
	public void setContextOperation(EOperation operation) {
		this.contextOperation = operation;
	}
	
	public EStructuralFeature getContextProperty() {
		if (contextProperty != null) {
			return contextProperty;
		} else if (getParent() != null) {
			return getParent().getContextProperty();
		}
		
		return null;
	}
	
	public void setContextProperty(EStructuralFeature property) {
		this.contextProperty = property;
	}

	public TypeResolver getTypeResolver() {
		if (typeResolver == null) {
			typeResolver = createTypeResolver();
		}
		
		return typeResolver;
	}
	
	/**
	 * Creates a new type resolver for use with this environment.
	 * 
	 * @return a new type resolver
	 */
	protected TypeResolver createTypeResolver() {
		return new TypeResolverImpl();
	}
	
	/**
	 * Is the environment empty?
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		if (namedElements.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the VariableDeclaration for a variable name. Does not look in
	 * parent environment scopes.
	 * 
	 * @param name
	 * @return VariableDeclaration
	 */
	public Variable lookupLocal(String name) {

		for (int i = 0; i < namedElements.size(); i++) {
			VariableEntry elem = (VariableEntry) namedElements.get(i);
			if (elem.name.equals(name)) {
				return elem.variable;
			}
		}
		return null;
	}

	/**
	 * returns the VariableDeclaration for a variable Looks in parent
	 * environment scope if not found in current scope.
	 * 
	 * @param name
	 * @return VariableDeclaration
	 */
	public Variable lookup(String name) {
		Variable elem = lookupLocal(name);

		if (elem != null) {
			return elem;
		}

		if (parent != null) {
			return parent.lookup(name);
		} else
			return null;
	}

	public EPackage lookupPackage(List path) {
		EPackage pkg = null;
		EPackage currPkg = defaultPackage;

		// Check whether this package is in the default package
		if (defaultPackage != null) {
			while (currPkg != null) {
				pkg = currPkg;
				
				for (int i = 0; i < path.size(); i++) {
					String name = (String) path.get(i);
					EList subPackages = pkg.getESubpackages();
					pkg = null;
					for (int j = 0; j < subPackages.size(); j++) {
						pkg = (EPackage) subPackages.get(j);
						if (name.equals(pkg.getName()))
							break;
						pkg = null;
					}
					if (pkg == null)
						break;
				}
				
				if (pkg != null) {
					return pkg;
				}
				
				currPkg = currPkg.getESuperPackage();
			}
		}
		
		// Check whether this package exists in the global package registry
		return findPackage(path, registry);
	}

	/**
	 * Finds the EClassifier corresponding to the path: name::...::name If no
	 * EClassifier is found, return null.
	 * 
	 * @param names
	 * @return EClassifier
	 */
	public EClassifier lookupPathName(List names) {
		EPackage pkg = null;
		EPackage currPkg = defaultPackage;

		if (names.size() > 1) {

			// Check whether this package is in the default package
			if (defaultPackage != null) {
				while (currPkg != null) {

					pkg = currPkg;
					for (int i = 0; i < names.size() - 1; i++) {
						String name = (String) names.get(i);
						EList subPackages = pkg.getESubpackages();
						pkg = null;
						for (int j = 0; j < subPackages.size(); j++) {
							pkg = (EPackage) subPackages.get(j);
							if (name.equals(pkg.getName()))
								break;
							pkg = null;
						}
						if (pkg == null)
							break;
					}
					if (pkg != null) {
						return pkg.getEClassifier((String) names
							.get(names.size() - 1));
					}
					currPkg = currPkg.getESuperPackage();
				}
			}
			// Check whether this package exists
			List newNames = names.subList(0, names.size() - 1);
			pkg = findPackage(newNames, registry);
			if (pkg == null)
				return null;
			return pkg.getEClassifier((String) names
				.get(names.size() - 1));
		} else if (defaultPackage != null) {
			String name = (String) names.get(0);
			EClassifier result = null;
			while (currPkg != null) {
				result = currPkg.getEClassifier(name);
				if (result != null) {
					return result;
				}
				currPkg = currPkg.getESuperPackage();
			}
		}
		return null;
	}

	public void setSelfVariable(Variable var) {
		selfVariable = var;
	}
	
	public Variable getSelfVariable() {
		Variable result = selfVariable;
		
		if ((result == null) && (getParent() != null)) {
			result = getParent().getSelfVariable();
		}
		
		return result;
	}
	
	/**
	 * Adds a variable declaration to the environment. If the name is null, then
	 * a new unique temporary name is generated.
	 * 
	 * @param name
	 * @param elem --
	 *            variable declaration
	 * @param exp --
	 *            is the variable implicit?
	 * @return - boolean
	 */
	public boolean addElement(String name, Variable elem, boolean exp) {

		if (name == null) {
			name = generateName();
			while (lookup(name) != null) {
				name = generateName();
			}
		} else if (lookup(name) != null)
			return false;

		elem.setName(name);
		VariableEntry newelem = new VariableEntry(
			name,
			elem,
			exp);
		namedElements.add(newelem);
		
		resource.getContents().add(elem);
		
		return true;
	}

	/**
	 * Removes a name when it goes out of scope.
	 * 
	 * @param name
	 */
	public void deleteElement(String name) {

		for (Iterator iter = namedElements.iterator(); iter.hasNext();) {
			VariableEntry elem = (VariableEntry) iter.next();
			
			if (elem.name.equals(name)) {
				iter.remove();
				
				resource.getContents().remove(elem.variable);
			}
		}
	}
	
	public Collection getVariables() {
		Collection result = new java.util.ArrayList();
		
		for (int i = 0; i < namedElements.size(); i++) {
			VariableEntry elem = (VariableEntry) namedElements.get(i);
			
			if (elem.isExplicit) {
				result.add(elem.variable);
			}
		}
		
		if (getParent() != null) {
			result.addAll(getParent().getVariables());
		}
		
		return result;
	}

	public EOperation lookupOperation(EClassifier owner, String name, EList args) {

		return TypeUtil.findOperationMatching(owner, name, args);
	}

	public EClass lookupSignal(EClassifier owner, String name, EList args) {
		return TypeUtil.findSignalMatching(owner, getSignals(owner), name, args);
	}

	/**
	 * By default, return an empty list because Ecore does not support the
	 * modeling of signals.
	 */
	public EList getSignals(EClassifier owner) {
		return ECollections.EMPTY_ELIST;
	}
	
	public EStructuralFeature lookupProperty(EClassifier owner, String name) {
		EClass ownerClass = null;
		
		if (owner != null && owner instanceof EClass) {
			ownerClass = (EClass) owner;
		}

		if (ownerClass == null) {
			Variable vdcl = lookupImplicitSourceForProperty(name);
			if (vdcl == null) {
				return null;
			}
			
			ownerClass = (EClass) vdcl.getType();
		}

		EList properties = TypeUtil.getProperties(ownerClass);
		
		for (Iterator iter = properties.iterator(); iter.hasNext();) {
			EStructuralFeature next = (EStructuralFeature) iter.next();
			
			if (name.equals(next.getName())) {
				return next;
			}
		}
		
		return null;
	}

	public EClass lookupAssociationClassReference(EClassifier parentClassifier,
			String name) {

		EClass owner = null;
		if ((parentClassifier != null) && parentClassifier instanceof EClass) {
			owner = (EClass) parentClassifier;
		} else if (parentClassifier != null) {
			owner = parentClassifier.eClass();
		}

		if (owner == null) {
			Variable vdcl = lookupImplicitSourceForAssociationClass(name);
			if (vdcl == null)
				return null;
			owner = (EClass) vdcl.getType();
		}

		EClass result = null;
		
		EList properties = owner.getEAllReferences();
		Iterator iter = properties.iterator();
		while ((result == null) && iter.hasNext()) {
			EReference next = (EReference) iter.next();
			
			EClass assocClass = getAssociationClass(next);
			if ((assocClass != null) && name.equals(initialLower(assocClass))) {
				result = assocClass;
			}
		}
		
		return result;
	}
	
	/**
	 * Gets the name of a named <code>elem</code>ent with its initial character
	 * in lower case.
	 * 
	 * @param elem a named element
	 * @return the element's name, with an initial lower case letter
	 */
	public static String initialLower(ENamedElement elem) {
		StringBuffer result = new StringBuffer(elem.getName());
		
		if (result.length() > 0) {
			UTF16.setCharAt(
					result,
					0,
					UCharacter.toLowerCase(UTF16.charAt(result, 0)));
		}
		
		return result.toString();
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
	public EList getStates(EClassifier owner, List pathPrefix) {
		if (owner == null) {
			Variable vdcl;
			
			for (int i = namedElements.size() - 1; i >= 0; i--) {
				VariableEntry element = (VariableEntry) namedElements.get(i);
				vdcl = element.variable;
				
				// only classes can have states
				if (vdcl.getType() instanceof EClass) {
					return getStates(vdcl.getType(), pathPrefix);
				}
	
			}
			
			// try the "self" variable, last
			vdcl = getSelfVariable();
			if (vdcl != null) {
				// only classes can have states
				if (vdcl.getType() instanceof EClass) {
					return getStates(vdcl.getType(), pathPrefix);
				}
			}
		} else {
			EList result = new BasicEList();
			
			collectStates(owner, pathPrefix, result);
			
			if (owner instanceof EClass) {
				// search supertypes
				for (Iterator iter = ((EClass) owner).getEAllSuperTypes().iterator(); iter.hasNext();) {
					collectStates((EClass) iter.next(), pathPrefix, result);
				}
			}
			
			return result;
		}
		
		return ECollections.EMPTY_ELIST;
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
	 * @param pathPrefix partial
	 * @param states a list of states directly owned by the namespace indicated
	 *     by path prefix, within the owner type
	 */
	protected void collectStates(EClassifier owner, List pathPrefix, List states) {
		// do nothing
	}
	
	/**
	 * Ecore does not model states, so this method returns null.  Environments
	 * that support UML states must override this implementation.
	 */
	public String getStateName(EObject state) {
		return null;
	}

	public Variable lookupImplicitSourceForProperty(String name) {
		Variable vdcl;
		
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (!element.isExplicit && (vdcl.getType() instanceof EClass)) {
				EStructuralFeature property = lookupProperty(vdcl.getType(), name);
				if (property != null)
					return vdcl;
			}

		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			if (vdcl.getType() instanceof EClass) {
				EStructuralFeature property = lookupProperty(vdcl.getType(), name);
				if (property != null)
					return vdcl;
			}
		}
		
		return null;

	}

	public Variable lookupImplicitSourceForAssociationClass(String name) {
		Variable vdcl;
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (!element.isExplicit && (vdcl.getType() instanceof EClass)) {
				EClass ac = lookupAssociationClassReference(vdcl.getType(), name);
				if (ac != null)
					return vdcl;
			}

		}

		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			if (vdcl.getType() instanceof EClass) {
				EClass ac = lookupAssociationClassReference(vdcl.getType(), name);
				if (ac != null)
					return vdcl;
			}
		}
		return null;
	}

	/**
	 * Looks in the EMF registry for a package with the specified qualified
	 * package name. Uses the global package registry.
	 * 
	 * @param packageNames
	 *            the qualified package name
	 * @return the matching EPackage, or <code>null</code> if not found
	 */
	static public EPackage findPackage(List packageNames) {
		return findPackage(packageNames, EPackage.Registry.INSTANCE);
	}

	/**
	 * Looks in the given registry for a package with the specified qualified
	 * package name.
	 * 
	 * @param packageNames
	 *            the qualified package name
	 * @param registry the EPackage.Registry to look in
	 * @return the matching EPackage, or <code>null</code> if not found
	 */
	static public EPackage findPackage(List packageNames, EPackage.Registry registry) {
		if (packageNames.isEmpty()) {
			return null;
		}
		
		String name = (String) packageNames.get(0);
		for (Iterator iter = registry.values().iterator(); iter.hasNext();) {
			Object next = iter.next();

			if (next instanceof EPackage) {
				EPackage ePackage = (EPackage) next;
				
				// only consider root-level packages when searching by name
				if ((ePackage.getESuperPackage() == null)
						&& name.equals(ePackage.getName())) {
					
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
	}

	/**
	 * Looks in the given package for a nested package with the specified relative
	 * package name.
	 * 
	 * @param packageNames
	 *            the relativ package name
	 * @param package the starting package to look in
	 * @return the matching EPackage, or <code>null</code> if not found
	 */
	private static EPackage findNestedPackage(List packageNames, EPackage superpackage) {
		if (packageNames.isEmpty()) {
			// stopping condition
			return superpackage;
		}
		
		String name = (String) packageNames.get(0);
		
		for (Iterator iter = superpackage.getESubpackages().iterator(); iter.hasNext();) {
			EPackage next = (EPackage) iter.next();

			if (name.equals(next.getName())) {
				EPackage tentativeResult = findNestedPackage(
						packageNames.subList(1, packageNames.size()),
						next);
				
				if (tentativeResult != null) {
					return tentativeResult;
				}
			}
		}

		return null;
	}

	/**
	 * Looks in the given registry for a package with the specified qualified
	 * package name, matching the name against the namespace prefixes of the
	 * packages in the registry.
	 * 
	 * @param packageNames
	 *            the qualified package name
	 * @param registry the EPackage.Registry to look in
	 * @return the NSPrefix-matching EPackage, or <code>null</code> if not found
	 */
	private static EPackage findPackageByNSPrefix(List packageNames, EPackage.Registry registry) {

		StringBuffer stringBuffer = new StringBuffer();
		Iterator it = packageNames.iterator();
		while (it.hasNext()) {
			stringBuffer.append(it.next());
			if (it.hasNext()) {
				stringBuffer.append(".");//$NON-NLS-1$
			}
		}

		String nsPrefix = stringBuffer.toString();

		for (Iterator iter = registry.values().iterator(); iter.hasNext();) {
			Object next = iter.next();

			if (next instanceof EPackage) {
				EPackage ePackage = (EPackage) next;
				if (nsPrefix.equals(ePackage.getNsPrefix())) {
					return ePackage;
				}
			}
		}

		return null;
	}

	public Variable lookupImplicitSourceForOperation(String name,
			EList params) throws SemanticException {

		Variable vdcl;
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (!element.isExplicit && (vdcl.getType() instanceof EClass)) {
				EOperation eop = TypeUtil.findOperationMatching(vdcl.getType(), name, params);
				if (eop != null)
					return vdcl;
			}
		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			if (vdcl.getType() instanceof EClass) {
				EOperation eop = TypeUtil.findOperationMatching(vdcl.getType(), name, params);
				if (eop != null)
					return vdcl;
			}
		}

		String errMessage = name + "(";//$NON-NLS-1$
		for (int i = 0; i < params.size(); i++) {
			if (i > 0)
				errMessage += ", ";//$NON-NLS-1$
			errMessage += ((OCLExpression) params.get(i)).getType().getName();
		}
		errMessage += ")";//$NON-NLS-1$
		String message = OCLMessages.bind(
				OCLMessages.IllegalSignature_ERROR_,
				errMessage);
		OCLParser.ERR(message);
		return null;
	}
	
	/**
	 * Default implementation just gets the name of the named element's
	 * {@link org.eclipse.emf.ecore.EObject#eClass() eClass} or, if it is an
	 * {@link ETypedElement}, the name of its type.
	 */
	public String getDescription(ENamedElement namedElement) {
		if (namedElement instanceof ETypedElement) {
			return ((ETypedElement) namedElement).getEType().getName();
		} else if (namedElement instanceof EEnumLiteral) {
			return ((EEnumLiteral) namedElement).getEEnum().getName();
		} else if (namedElement == null) {
			return null;
		}
		return namedElement.eClass().getName();
	}
	
	/**
	 * Determines whether the specified <code>operation</code> is a query
	 * operation.  Note that an environment that correctly supports query
	 * operations would need to supply appropriately annotated
	 * {@link EOperation}s or otherwise override this method.
	 * 
	 * @param operation an operation
	 * @return whether it is a query operation.  An {@link EOperation} that
	 *     is not annotated is considered to be a query by default
	 */
	public boolean isQuery(EOperation operation) {
		return UMLTypeUtil.isQuery(operation);
	}

	/**
	 * Determines whether the specified <code>eclass</code> is an association
	 * class.  Note that an environment that correctly supports association
	 * classes would need to supply appropriately annotated {@link EClass}es.
	 * 
	 * @param eclass an Ecore class
	 * @return whether it is an association class
	 */
	public boolean isAssociationClass(EClass eclass) {
		return UMLTypeUtil.isAssociationClass(eclass);
	}
	
	/**
	 * Obtains the association class that the specified reference represents,
	 * as an {@link EClass}, if any.  This gets the "class" aspect of the
	 * association class, for which the reference represents the "association"
	 * aspect.  Note that an environment that correctly supports association
	 * classes would need to supply appropriately annotated {@link EReference}s.
	 * 
	 * @param reference a reference
	 * @return the association class, or <code>null</code> if the reference
	 *     does not represent an association class
	 */
	public EClass getAssociationClass(EReference reference) {
		return UMLTypeUtil.getAssociationClass(reference);
	}
	
	/**
	 * Obtains the ends of the specified association class as a list of
	 * {@link EReference}s.  Note that an environment that correctly supports
	 * association classes would need to supply appropriately annotated
	 * {@link EClass}es.
	 * 
	 * @param associationClass an EClass representing an association class
	 * @return the {@link EReference}s representing its member ends (the
	 *     association roles)
	 */
	public EList getMemberEnds(EClass associationClass) {
		return UMLTypeUtil.getMemberEnds(associationClass);
	}
	
	/**
	 * Gets the qualifiers of an association end.
	 * Note that an environment that correctly supports association end
	 * qualifiers would need to supply appropriately annotated {@link EReference}s.
	 * 
	 * @param property a property of the model class
	 * @return the qualifiers (as a list of {@link EStructuralFeature}s, or an
	 *     empty list if the property has no qualifiers
	 */
	public EList getQualifiers(EStructuralFeature property) {
		return UMLTypeUtil.getQualifiers(property);
	}
	
	private static final class VariableEntry {
		final String name;
		final Variable variable;
		final boolean isExplicit;
		
		VariableEntry(String name, Variable variable, boolean isExplicit) {
			this.name = name;
			this.variable = variable;
			this.isExplicit = isExplicit;
		}
		
		public String toString() {
			return "VariableEntry[" + name + ", "  //$NON-NLS-1$//$NON-NLS-2$
				+ (isExplicit? "explicit, " : "implicit, " + variable + "]"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}
}

