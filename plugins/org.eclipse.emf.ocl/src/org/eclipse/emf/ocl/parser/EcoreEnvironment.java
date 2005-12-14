/**
 * <copyright>
 *
 * Copyright (c) 2005 IBM Corporation and others.
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
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ocl.expressions.OclExpression;
import org.eclipse.emf.ocl.expressions.VariableDeclaration;
import org.eclipse.emf.ocl.internal.OclEnginePlugin;
import org.eclipse.emf.ocl.internal.l10n.OclMessages;
import org.eclipse.emf.ocl.internal.parser.OclParser;
import org.eclipse.emf.ocl.types.AnyType;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.internal.impl.AnyTypeImpl;
import org.eclipse.emf.ocl.types.internal.impl.CollectionTypeImpl;
import org.eclipse.emf.ocl.types.internal.impl.PrimitiveTypeImpl;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.AssociationClass;
import org.eclipse.emf.ocl.uml.AssociationClassEnd;
import org.eclipse.emf.ocl.uml.AssociationEnd;
import org.eclipse.emf.ocl.uml.Operation;
import org.eclipse.emf.ocl.uml.Qualifier;
import org.eclipse.osgi.util.NLS;

import antlr.SemanticException;

/**
 * An Environment stores the variables created while evaluating an OCL
 * expression, including self. It also stores the package, if the OCL package
 * statement is used. Methods are provided for querying whether variable,
 * attribute, reference, and operation names belong to the environment.
 * 
 * @author Edith Schonberg (edith)
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEnvironment
	implements Environment {

	private static final String UnknownOperationOwnerType_ERROR_ =
		OclMessages.UnknownOperationOwnerType_ERROR_;

	private static final String IllegalSignature_ERROR_ =
		OclMessages.IllegalSignature_ERROR_;

	/* Used to generate implicit iterator variables */
	private static int generatorInt = 0;

	/**
	 * Translator from primitive EMF types to OCL types
	 * 
	 * @param dataType a data type in the EMF metamodel
	 * @return  the corresponding OCL classifier
	 */
	private static EClassifier getOclTypeFor(EDataType dataType) {

		// First check if it is already an OCL data type (EEnums represent
		//    themselves)
		if (dataType instanceof EEnum)
			return dataType;
		if (dataType instanceof CollectionType)
			return dataType;
		if (dataType instanceof PrimitiveType)
			return dataType;

		Class instanceClass = dataType.getInstanceClass();

		// Boolean/boolean -> OCL_BOOLEAN
		if (instanceClass == Boolean.class
			|| instanceClass == boolean.class)
			return PrimitiveTypeImpl.OCL_BOOLEAN;

		// Double/double/Float/float -> OCL_REAL
		else if (instanceClass == Double.class
			|| instanceClass == double.class
			|| instanceClass == Float.class || instanceClass == float.class)
			return PrimitiveTypeImpl.OCL_REAL;

		// String -> OCL_STRING
		else if (instanceClass == String.class)
			return PrimitiveTypeImpl.OCL_STRING;

		// Integer/int/Long/long/Short/short -> OCL_INTEGER
		else if (instanceClass == Integer.class
			|| instanceClass == int.class || instanceClass == Long.class
			|| instanceClass == long.class || instanceClass == Short.class
			|| instanceClass == short.class)
			return PrimitiveTypeImpl.OCL_INTEGER;

		// List -> OCL_SEQUENCE
		else if (List.class.isAssignableFrom(instanceClass))
			return CollectionTypeImpl.OCL_SEQUENCE;

		// Set -> OCL_SET
		else if (Set.class.isAssignableFrom(instanceClass))
			return CollectionTypeImpl.OCL_SET;

		// Collection -> OCL_COLLECTION
		else if (Collection.class.isAssignableFrom(instanceClass))
			return CollectionTypeImpl.OCL_COLLECTION;

		// All other data types -> OCL_ANY_TYPE
		return AnyTypeImpl.OCL_ANY_TYPE;
	}
	
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
	 * @see #getOclType(EClassifier)
	 * @see #getOclCollectionType(EClassifier, boolean, boolean)
	 */	
	public static EClassifier getOclType(ETypedElement typedElement) {
		EClassifier resultType = typedElement.getEType();
		
		if (typedElement.isMany()) {
			resultType = getOclCollectionType(
				resultType,
				typedElement.isOrdered(),
				typedElement.isUnique());
		} else {
			resultType = getOclType(resultType);
		}
		
		return resultType;
	}
	
	/**
	 * Obtains the appropriate OCL type for an {@link EClassifier}, if it
	 * corresponds to an OCL primitive type.
	 * 
	 * @param type the type to convert to an OCL type
	 * @return the corresponding OCL type
	 */	
	public static EClassifier getOclType(EClassifier type) {
		EClassifier resultType = type;

		if (resultType instanceof EDataType) {
			resultType = getOclTypeFor((EDataType) resultType);
		}
		
		return resultType;
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
	 * @see #getOclType(EClassifier)
	 */	
	public static EClassifier getOclCollectionType(EClassifier type,
			boolean isOrdered, boolean isUnique) {
		EClassifier resultType = type;

		if (resultType instanceof EDataType) {
			resultType = getOclTypeFor((EDataType) resultType);
		}
		
		// TODO: Cache the collection types generated by this method
		if (isOrdered) {
			if (isUnique) {
				resultType = TypesFactory.eINSTANCE.createOrderedSetType(resultType);
			} else {
				resultType = TypesFactory.eINSTANCE.createSequenceType(resultType);
			}
		} else {
			if (isUnique) {
				resultType = TypesFactory.eINSTANCE.createSetType(resultType);
			} else {
				resultType = TypesFactory.eINSTANCE.createBagType(resultType);
			}
		}
		
		return resultType;
	}

	/*
	 * List of declared variables and implicit variables. This list includes
	 * "self" Implicit variables are generated when there is an iterator with no
	 * iteration variable specified.
	 */
	private List namedElements = new java.util.ArrayList();

	private VariableDeclaration selfVariable;
	
	private Environment parent;

	private EOperation contextOperation;
	
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

	/**
	 * Create an environment, set the default package from a package
	 * statement, and set the package registry to the global package
     * registry.
	 * 
	 * @param pkg
	 */
	public EcoreEnvironment(EPackage pkg) {
		defaultPackage = pkg;
		registry = EPackage.Registry.INSTANCE;
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
	}

	public EcoreEnvironment(Environment parent) {
		if (parent instanceof EcoreEnvironment) {
			defaultPackage = ((EcoreEnvironment) parent).defaultPackage;
			registry = ((EcoreEnvironment) parent).registry;
		} else {
			registry = EPackage.Registry.INSTANCE;
		}
		this.parent = parent;
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
		return contextOperation;
	}
	
	public void setContextOperation(EOperation operation) {
		this.contextOperation = operation;
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
	public VariableDeclaration lookupLocal(String name) {

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
	public VariableDeclaration lookup(String name) {
		VariableDeclaration elem = lookupLocal(name);

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
		}

		if (defaultPackage == null)
			return null;
		return defaultPackage.getEClassifier((String) names.get(0));

	}

	public void setSelfVariable(VariableDeclaration var) {
		selfVariable = var;
	}
	
	public VariableDeclaration getSelfVariable() {
		VariableDeclaration result = selfVariable;
		
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
	public boolean addElement(String name, VariableDeclaration elem, boolean exp) {

		if (name == null) {
			name = generateName();
			while (lookup(name) != null) {
				name = generateName();
			}
		} else if (lookup(name) != null)
			return false;

		elem.setVarName(name);
		VariableEntry newelem = new VariableEntry(
			name,
			elem,
			exp);
		namedElements.add(newelem);
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

	public EAttribute lookupAttribute(EClassifier parentClassifier, String name) {

		EClass owner = null;

		if (parentClassifier != null && parentClassifier instanceof EClass) {
			owner = (EClass) parentClassifier;
		} else if (parentClassifier != null) {
			owner = parentClassifier.eClass();
		}

		if (owner == null) {
			VariableDeclaration vdcl = lookupImplicitSourceForAttribute(name);
			if (vdcl == null)
				return null;
			owner = (EClass) vdcl.getType();
		}

		EList properties = owner.getEAllAttributes();
		Iterator iter = properties.iterator();
		while (iter.hasNext()) {
			EAttribute attr = (EAttribute) iter.next();
			if (attr.getName().equals(name))
				return attr;
		}
		return null;
	}

	public EReference lookupReference(EClassifier parentClassifier, String name) {

		EClass owner = null;
		if (parentClassifier != null && parentClassifier instanceof EClass) {
			owner = (EClass) parentClassifier;
		} else if (parentClassifier != null) {
			owner = parentClassifier.eClass();
		}

		if (owner == null) {
			VariableDeclaration vdcl = lookupImplicitSourceForAssociationEnd(name);
			if (vdcl == null)
				return null;
			owner = (EClass) vdcl.getType();
		}

		EList properties = owner.getEAllReferences();
		Iterator iter = properties.iterator();
		while (iter.hasNext()) {
			EReference ref = (EReference) iter.next();
			if (ref.getName().equals(name))
				return ref;
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
			VariableDeclaration vdcl = lookupImplicitSourceForAssociationClass(name);
			if (vdcl == null)
				return null;
			owner = (EClass) vdcl.getType();
		}

		EClass result = null;
		
		EList properties = owner.getEAllReferences();
		Iterator iter = properties.iterator();
		while ((result == null) && iter.hasNext()) {
			Object next = iter.next();
			
			if (next instanceof AssociationClassEnd) {
				AssociationClassEnd ref = (AssociationClassEnd) next;
			
				if (name.equals(initialLower(ref.getAssociationClass()))) {
					result = ref.getAssociationClass();
				}
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
			result.setCharAt(0, Character.toLowerCase(result.charAt(0)));
		}
		
		return result.toString();
	}

	/**
	 * Find the operation in the specified classifier
	 * 
	 * @param owner EClassifier owning operations
	 * @param name name of operation
	 * @param args list of arguments to match against the operation signature
	 */
	public static EOperation lookupOperation(EClassifier owner, String name,
		EList args) throws SemanticException {

		if (args == null) {
			args = ECollections.EMPTY_ELIST;
		}
		
		if (owner instanceof EClass) {

			// Must check both the AnyType operations (allInstances, etc)
			// and the operations of the class itself.
			EList properties = AnyTypeImpl.OCL_ANY_TYPE.getOperations();
			for (Iterator iter = properties.iterator(); iter.hasNext();) {
				EOperation oper = (EOperation) iter.next();
				if (oper.getName().equals(name) && matchArgs(oper, args))
					return oper;

			}

			properties = ((EClass) owner).getEAllOperations();
			for (Iterator iter = properties.iterator(); iter.hasNext();) {
				EOperation oper = (EOperation) iter.next();
				if (oper.getName().equals(name) && matchArgs(oper, args))
					return oper;
			}
		}

		EList operations = null;
		if (owner instanceof AnyType) {
			AnyType source = (AnyType) owner;
			operations = source.getOperations();

		} else if (owner instanceof CollectionType) {
			CollectionType source = (CollectionType) owner;
			operations = source.getOperations();
		} else if (owner instanceof EEnum || owner instanceof TupleType
				|| owner == Types.OCL_VOID || owner == AnyTypeImpl.OCL_ANY_TYPE) {
			operations = AnyTypeImpl.OCL_ANY_TYPE.getOperations();
		} else if (owner instanceof EDataType) {
			EClassifier prim = getOclTypeFor((EDataType) owner);
			if (prim instanceof PrimitiveType) {
				operations = ((PrimitiveType) prim).getOperations();
			} else {
				operations = AnyTypeImpl.OCL_ANY_TYPE.getOperations();
			}
		} else {
			String message = NLS.bind(
				UnknownOperationOwnerType_ERROR_, new Object[] {owner, name });
			IllegalArgumentException error = new IllegalArgumentException(
				message);
			OclEnginePlugin.throwing(EcoreEnvironment.class,
				"lookupOperation", error);//$NON-NLS-1$
			throw error;
		}

		for (Iterator iter = operations.iterator(); iter.hasNext();) {
			EOperation oper = (EOperation) iter.next();
			if (oper.getName().equals(name) && matchArgs(oper, args))
				return oper;

		}

		String errMessage = owner.getName() + "." + name + "(";//$NON-NLS-2$//$NON-NLS-1$
		for (int i = 0; i < args.size(); i++) {
			if (i > 0)
				errMessage += ", ";//$NON-NLS-1$
			errMessage += ((OclExpression) args.get(i)).getType().getName();
		}
		errMessage += ")";//$NON-NLS-1$
		String message = NLS.bind(IllegalSignature_ERROR_,
			new Object[] {errMessage });
		OclParser.ERR(message);
		return null;
	}

	/**
	 * Compares an actual argument list against the signature of a operation.
	 * 
	 * @param oper
	 * @param args a list of {@link OclExpression}s or {@link VariableDeclaration}s
	 * @return true or false
	 */
	private static boolean matchArgs(EOperation oper, EList args) {
		EList operArgs = oper.getEParameters();
		Iterator iter = operArgs.iterator();
		int argsize;

		if (args == null)
			argsize = 0;
		else
			argsize = args.size();

		if (operArgs.size() != argsize)
			return false;

		for (int i = 0; iter.hasNext(); i++) {
			EParameter param = (EParameter) iter.next();
			Object arg = args.get(i);
			EClassifier argType = null;
			
			if (arg instanceof OclExpression) {
				argType = ((OclExpression) arg).getType();
			} else if (arg instanceof VariableDeclaration) {
				argType = ((VariableDeclaration) arg).getType();
			}
			
			EClassifier paramType = getOclType(param);

			if (paramType instanceof EClass && argType instanceof EClass)
				continue;
			// OCL_VOID matched anything
			if (paramType == AnyTypeImpl.OCL_ECLASSIFIER)
				continue;

			if (argType instanceof EDataType)
				argType = argType.eClass();
			if (paramType instanceof EDataType)
				paramType = paramType.eClass();

			String argTypeName = argType.getName();
			String paramTypeName = paramType.getName();

			// shallow type checking -- signature checking.
			if (argTypeName.equals("SetType") || //$NON-NLS-1$
				argTypeName.equals("BagType") || //$NON-NLS-1$
				argTypeName.equals("SequenceType") || //$NON-NLS-1$
				argTypeName.equals("OrderedSetType")) { //$NON-NLS-1$
				if (paramTypeName.equals("CollectionType"))continue;//$NON-NLS-1$
				if (paramTypeName.equals("AnyType"))return false;//$NON-NLS-1$
			}
			if (paramTypeName.equals("PrimitiveReal")) {//$NON-NLS-1$
				if (argTypeName.equals("PrimitiveInteger"))continue; //$NON-NLS-1$
			}
			//if (paramTypeName.equals("EClassifier")) continue;
			if (paramTypeName.equals("AnyType"))continue; //$NON-NLS-1$
			if (!paramTypeName.equals(argTypeName))
				return false;
		}
		return true;
	}

	public VariableDeclaration lookupImplicitSourceForAttribute(String name) {
		VariableDeclaration vdcl;
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (vdcl.getType() instanceof EClass) {
				EAttribute eattr = lookupAttribute(vdcl.getType(), name);
				if (eattr != null)
					return vdcl;
			}

		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			if (vdcl.getType() instanceof EClass) {
				EAttribute eattr = lookupAttribute(vdcl.getType(), name);
				if (eattr != null)
					return vdcl;
			}
		}
		return null;

	}

	public VariableDeclaration lookupImplicitSourceForAssociationEnd(String name) {
		VariableDeclaration vdcl;
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (vdcl.getType() instanceof EClass) {
				EReference eref = lookupReference(vdcl.getType(), name);
				if (eref != null)
					return vdcl;
			}

		}

		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			if (vdcl.getType() instanceof EClass) {
				EReference eref = lookupReference(vdcl.getType(), name);
				if (eref != null)
					return vdcl;
			}
		}
		return null;
	}

	public VariableDeclaration lookupImplicitSourceForAssociationClass(String name) {
		VariableDeclaration vdcl;
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (vdcl.getType() instanceof EClass) {
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

		StringBuffer stringBuffer = new StringBuffer();
		Iterator it = packageNames.iterator();
		while (it.hasNext()) {
			stringBuffer.append(it.next());
			if (it.hasNext()) {
				stringBuffer.append(".");//$NON-NLS-1$
			}
		}

		String nsPresfix = stringBuffer.toString();

		for (Iterator iter = registry.values().iterator(); iter.hasNext();) {
			Object next = iter.next();

			if (next instanceof EPackage) {
				EPackage ePackage = (EPackage) next;
				if (ePackage.getNsPrefix().equals(nsPresfix)) {
					return ePackage;
				}
			}
		}

		return null;
	}

	public VariableDeclaration lookupImplicitSourceForOperation(String name,
			EList params) throws SemanticException {

		VariableDeclaration vdcl;
		for (int i = namedElements.size() - 1; i >= 0; i--) {
			VariableEntry element = (VariableEntry) namedElements.get(i);
			vdcl = element.variable;
			if (vdcl.getType() instanceof EClass) {
				EOperation eop = lookupOperation(vdcl.getType(), name, params);
				if (eop != null)
					return vdcl;
			}
		}
		
		// try the "self" variable, last
		vdcl = getSelfVariable();
		if (vdcl != null) {
			if (vdcl.getType() instanceof EClass) {
				EOperation eop = lookupOperation(vdcl.getType(), name, params);
				if (eop != null)
					return vdcl;
			}
		}
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
		}
		return namedElement.eClass().getName();
	}
	
	/**
	 * Determines whether the specified <code>operation</code> is a query
	 * operation.  Note that an environment that correctly supports query
	 * operations would need to supply {@link Operation}s instead of
	 * {@link EOperation}s.
	 * 
	 * @param operation an operation
	 * @return whether it is a query operation.  An {@link EOperation} that
	 *     is not an {@link Operation} is considered to be a query by default
	 */
	public static boolean isQuery(EOperation operation) {
		boolean result = true;
		
		if (operation instanceof Operation) {
			result = ((Operation) operation).isQuery();
		}
		
		return result;
	}

	/**
	 * Determines whether the specified <code>eclass</code> is an association
	 * class.  Note that an environment that correctly supports association
	 * classes would need to supply {@link AssociationClass}es instead of
	 * {@link EClass}es.
	 * 
	 * @param eclass an EMF class
	 * @return whether it is an association class
	 */
	public static boolean isAssociationClass(EClass eclass) {
		return eclass instanceof AssociationClass;
	}
	
	/**
	 * Gets the types of the qualifiers of an association end.
	 * Note that an environment that correctly supports association end
	 * qualifiers would need to supply {@link AssociationEnd}s instead of
	 * {@link EReference}s.
	 * 
	 * @param associationEnd an association end
	 * @return the qualifier types (as a list of {@link EClassifier}s, or an
	 *     empty list if the association end is not an {@link AssociationEnd}
	 */
	public static List getQualifierTypes(EReference associationEnd) {
		List result = ECollections.EMPTY_ELIST;
		
		if (associationEnd instanceof AssociationEnd) {
			result = new BasicEList(
				((AssociationEnd) associationEnd).getQualifiers());
			
			for (ListIterator iter = result.listIterator(); iter.hasNext();) {
				iter.set(getOclType((Qualifier) iter.next()));
			}
		}
		
		return result;
	}
	
	private static final class VariableEntry {
		final String name;
		final VariableDeclaration variable;
		final boolean isExplicit;
		
		VariableEntry(String name, VariableDeclaration variable, boolean isExplicit) {
			this.name = name;
			this.variable = variable;
			this.isExplicit = isExplicit;
		}
	}
}

