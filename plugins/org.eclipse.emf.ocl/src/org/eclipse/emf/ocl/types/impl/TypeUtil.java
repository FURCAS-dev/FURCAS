/**
 * <copyright>
 *
 * Copyright (c) 2006, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 243079
  *
 * </copyright>
 * 
 * $Id: TypeUtil.java,v 1.19 2009/07/27 15:28:57 ewillink Exp $
 */
package org.eclipse.emf.ocl.types.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ocl.expressions.CollectionKind;
import org.eclipse.emf.ocl.expressions.ExpressionsFactory;
import org.eclipse.emf.ocl.expressions.OCLExpression;
import org.eclipse.emf.ocl.expressions.TypeExp;
import org.eclipse.emf.ocl.expressions.UnspecifiedValueExp;
import org.eclipse.emf.ocl.expressions.Variable;
import org.eclipse.emf.ocl.internal.OCLPlugin;
import org.eclipse.emf.ocl.internal.parser.CompatibilityParser;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.emf.ocl.parser.PersistentEnvironment;
import org.eclipse.emf.ocl.parser.SemanticException;
import org.eclipse.emf.ocl.parser.TypeResolver;
import org.eclipse.emf.ocl.types.CollectionType;
import org.eclipse.emf.ocl.types.PrimitiveBoolean;
import org.eclipse.emf.ocl.types.PrimitiveInteger;
import org.eclipse.emf.ocl.types.PrimitiveReal;
import org.eclipse.emf.ocl.types.PrimitiveString;
import org.eclipse.emf.ocl.types.PrimitiveType;
import org.eclipse.emf.ocl.types.TupleType;
import org.eclipse.emf.ocl.types.TypeType;
import org.eclipse.emf.ocl.types.TypesFactory;
import org.eclipse.emf.ocl.types.util.Types;
import org.eclipse.emf.ocl.uml.TypedElement;
import org.eclipse.emf.ocl.utilities.PredefinedType;
import org.eclipse.ocl.internal.l10n.OCLMessages;

/**
 * Static utilities for introspecting OCL types.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class TypeUtil {
	
	/**
	 * Not instantiable
	 */
	private TypeUtil() {
		super();
	}

	/**
	 * Find the operation in the specified classifier
	 * 
	 * @param owner EClassifier owning operations
	 * @param name name of operation
	 * @param args list of arguments to match against the operation signature
	 * 
	 * @return the matching operation, or <code>null</code> if not found
	 */
	public static EOperation findOperationMatching(EClassifier owner, String name,
		EList args) {

		if (args == null) {
			args = ECollections.EMPTY_ELIST;
		}

		EList operations = getOperations(owner);
		
		for (Iterator iter = operations.iterator(); iter.hasNext();) {
			EOperation oper = (EOperation) iter.next();
			if (oper.getName().equals(name) && matchArgs(owner, oper.getEParameters(), args))
				return oper;

		}
		
		return null;
	}

	/**
	 * Find a matching signal in the specified list.
	 * 
	 * @param receiver the type that receives the signal
	 * @param signals the signals to search
	 * @param name name of signal to find
	 * @param args list of arguments to match against the signal signature
	 * 
	 * @return the matching signal, or <code>null</code> if not found
	 */
	public static EClass findSignalMatching(EClassifier receiver, EList signals,
			String name, EList args) {

		if (args == null) {
			args = ECollections.EMPTY_ELIST;
		}
		
		for (Iterator iter = signals.iterator(); iter.hasNext();) {
			EClass signal = (EClass) iter.next();
			if (signal.getName().equals(name)
					&& matchArgs(receiver, signal.getEAllStructuralFeatures(), args)) {
				return signal;
			}
		}
		
		return null;
	}
	
	/**
	 * Obtains all of the OCL operations applicable to the specified owner type.
	 * 
	 * @param owner the operation owner type
	 * 
	 * @return an unmodifiable list of its operations
	 */
	public static EList getOperations(EClassifier owner) {
		EList result;
		
		if (owner instanceof PredefinedType) {
			PredefinedType source = (PredefinedType) owner;
			result = ECollections.unmodifiableEList(source.getOperations());
		} else if (owner instanceof EClass) {
			result = new BasicEList();
			
			// Include both the AnyType operations (oclIsKindOf, etc)
			// and the operations of the class itself.
			result.addAll(((EClass) owner).getEAllOperations());
			result.addAll(Types.OCL_ANY_TYPE.getOperations());
			
			result = ECollections.unmodifiableEList(result);
		} else if (owner instanceof EEnum) {
			result = ECollections.unmodifiableEList(
					Types.OCL_ANY_TYPE.getOperations());
		} else if (owner instanceof EDataType) {
            // in case there is a corresponding OCL type
			owner = TypeUtil.getOCLTypeFor((EDataType) owner);
			if (owner instanceof PrimitiveType) {
				result = ECollections.unmodifiableEList(
						((PrimitiveType) owner).getOperations());
			} else {
				result = ECollections.unmodifiableEList(
						Types.OCL_ANY_TYPE.getOperations());
			}
		} else {
			result = ECollections.EMPTY_ELIST;
		}
		
		if (owner != null) {
			EList additionalOperations = getAdditionalOperations(owner);
			if (additionalOperations != null && !additionalOperations.isEmpty()) {
				result = new BasicEList(result);
				result.addAll(additionalOperations);
			}
		}
		
		return result;
	}
	
	public static EList getProperties(EClassifier owner) {
		EList result;
		
		if (owner instanceof EClass) {
			result = ((EClass) owner).getEAllStructuralFeatures();
		} else {
            // in case there is a corresponding OCL type
            owner = TypeUtil.getOCLType(owner);
			result = ECollections.EMPTY_ELIST;
		}
		
		if (owner != null) {
			EList additionalproperties = getAdditionalProperties(owner);
			if (additionalproperties != null && !additionalproperties.isEmpty()) {
				result = new BasicEList(result);
				result.addAll(additionalproperties);
			}
		}
		
		return result;
	}

	/**
	 * Compares an actual argument list against the signature of a operation.
	 * 
	 * @param owner the type that owns the operation
	 * @param params the {@link ETypedElement}s to match against the arguments
	 * @param args a list of {@link OCLExpression}s or {@link Variable}s
	 * 
	 * @return true or false
	 */
	private static boolean matchArgs(EClassifier owner, EList params, EList args) {
		int argsize;

		if (args == null)
			argsize = 0;
		else
			argsize = args.size();

		if (params.size() != argsize)
			return false;
		
		Iterator iter = params.iterator();

		for (int i = 0; iter.hasNext(); i++) {
			ETypedElement param = (ETypedElement) iter.next();
			Object arg = args.get(i);
			EClassifier argType = null;
			
			// handle parameters of type OclType
			if (param.getEType() instanceof TypeType) {
				if (arg instanceof TypeExp) {
					continue;
				}
				return false;
			}
			
			if (arg instanceof OCLExpression) {
				argType = ((OCLExpression) arg).getType();
			} else if (arg instanceof Variable) {
				argType = ((Variable) arg).getType();
			}
			
			EClassifier paramType = TypeUtil.getOCLType(param);
			paramType = resolveGenericType(owner, paramType, argType);
			
			if (paramType == AnyTypeImpl.OCL_T) {
				// this is a collection operation, and the collection is empty
				//   (element type is OclVoid).  Any argument matches in this
				//   case, because any kind of element can be considered to not
				//   be in an empty collection
				continue;
			}
			
			if ((TypeUtil.getRelationship(argType, paramType) & PredefinedType.SUBTYPE) == 0) {
				return false;
			}
		}
		return true;
	}

	private static EClassifier resolveGenericType(
			EClassifier owner,
			EClassifier paramType,
			EClassifier argType) {
		EClassifier result = paramType;
		
		if (result == AnyTypeImpl.OCL_T) {
			// substitute the owner type (or owner's element type in
			//   the case of a collection)
			result = owner;
			if (result instanceof CollectionType) {
				result = ((CollectionType) result).getElementType();
				
				if (result == Types.OCL_VOID) {
					// special case for empty collections, whose element type is OclVoid.
					//   We want any argument to be accepted, and to solely determine
					//   the element type of the resulting collection
					result = AnyTypeImpl.OCL_T;
				}
			}
		} else if (result instanceof CollectionType) {
			// handle generic collection operation with parameter of
			//    type <collectionKind>(T)
			CollectionType collType = (CollectionType) result;
			EClassifier elemType = collType.getElementType();
			
			if (elemType == AnyTypeImpl.OCL_T) {
				result = TypesFactory.eINSTANCE.createCollectionType(
						collType.getKind(),
						(owner instanceof CollectionType)?
								((CollectionType)owner).getElementType()
								: owner);
			} else if (elemType == AnyTypeImpl.OCL_T2) {
				// wildard to match any other collection type
				result = TypesFactory.eINSTANCE.createCollectionType(
						collType.getKind(),
						(argType instanceof CollectionType)?
								((CollectionType)argType).getElementType()
								: argType);
			}
		}
		
		return result;
	}
	
	public static EOperation resolveGenericSignature(EClassifier owner, EOperation oper) {
		EOperation result = EcoreFactory.eINSTANCE.createEOperation();
		
		result.setName(oper.getName());
		
		for (Iterator iter = oper.getEParameters().iterator(); iter.hasNext();) {
			EParameter param = (EParameter) iter.next();
			
			EParameter resolved = EcoreFactory.eINSTANCE.createEParameter();
			resolved.setName(param.getName());
			resolved.setEType(resolveGenericType(owner, param.getEType(), AnyTypeImpl.OCL_T));
			result.getEParameters().add(resolved);
		}
		
		result.setEType(getResultType(owner, oper));
		
		return result;
	}
	
	public static EClassifier getResultType(EClassifier owner, EOperation oper) {
		
		if (owner instanceof PredefinedType) {
			PredefinedType pt = (PredefinedType) owner;
			
			int opcode = pt.getOperationCodeFor(oper.getName());
			
			EList parameters = oper.getEParameters();
			int paramCount = parameters.size();
			EList args = new BasicEList(paramCount);
			for (int i = 0; i < paramCount; i++) {
				EParameter param = (EParameter) parameters.get(i);
				EClassifier paramType = param.getEType();
				
				if (paramType == Types.OCL_TYPE) {
					// need a TypeExp
					TypeExp exp = ExpressionsFactory.eINSTANCE.createTypeExp();
					exp.setReferredType(AnyTypeImpl.OCL_T);
					exp.setType(Types.OCL_TYPE);
					args.add(exp);
				} else {
					if (paramType instanceof CollectionType) {
						CollectionType ct = (CollectionType) paramType;
						
						if (ct.getElementType() == AnyTypeImpl.OCL_T2) {
							// special handling for the Collection(T2) parameter
							//   of the product collection operation
							paramType = TypesFactory.eINSTANCE.createCollectionType(
									ct.getKind(), AnyTypeImpl.OCL_T);
						}
					}
					
					// unspecified value expression will do
					UnspecifiedValueExp exp = ExpressionsFactory.eINSTANCE.createUnspecifiedValueExp();
					exp.setType(paramType);
					args.add(exp);
				}
			}
			
			try {
				return ((PredefinedType) owner).getResultTypeFor(owner, opcode, args);
			} catch (Exception e) {
				// doesn't matter.  Just return the default
			}
		}
		
		return TypeUtil.getOCLType(oper.getEType());
	}
	
	public static boolean type1AsType2(EClassifier type1, EClassifier type2)
		throws SemanticException {
		if (typeCompare(type1, type2) != -1) {
			return true;
		}
		String message = OCLMessages.bind(
				OCLMessages.CastTypeMismatch_ERROR_,
				getName(type1),
				getName(type2));
		CompatibilityParser.ERR(message);
		return false;
	}

	/**
	 * Compare 2 types. Returns 0 if types are exactly equal, -1 if type1
	 * conforms to type2 (type1 is a subtype of type2) 1 if type2 conforms to
	 * type1 (type2 is a subtype of type1) Throws an IllegalArgumentException if
	 * there is no type conformance.
	 * 
	 * @param type1 -
	 *            EClassifier
	 * @param type2 -
	 *            EClassifier
	 * @return the ordering key
	 */
	public static int typeCompare(EClassifier type1, EClassifier type2) {
	
		switch (TypeUtil.getRelationship(type1, type2)) {
		case PredefinedType.SAME_TYPE:
			return 0;
		case PredefinedType.STRICT_SUBTYPE:
			return -1;
		case PredefinedType.STRICT_SUPERTYPE:
			return 1;
		default:
			String message = OCLMessages.bind(
					OCLMessages.TypeMismatch_ERROR_,
					getName(type1),
					getName(type2));
			IllegalArgumentException error = new IllegalArgumentException(message);
			OCLPlugin.throwing(AnyTypeImpl.class, "typeCompare", error);//$NON-NLS-1$
			throw error;
		}
	}
	
	/**
	 * Null-safe alternative to {@link ENamedElement#getName()}.
	 * 
	 * @param element a named element that may be <code>null</code>
	 * @return the element's name, or <code>null</code> if the element is <code>null</code>
	 */
	static String getName(ENamedElement element) {
		return (element == null)? null : element.getName();
	}

	/**
	 * Get the common supertype of two types.
	 * 
	 * @param type1
	 * @param type2
	 * @return the common supertype
	 */
	public static EClassifier commonSuperType(EClassifier type1,
		EClassifier type2) throws SemanticException {
	
		if (eq(type1, type2)) {
			return type2;
		}
		
		// as a special case, where one type is the generic T type,
		//   take the other as the common super type (the generic type T
		//   represents any type, so matches the other type by definition)
		if (type1 == AnyTypeImpl.OCL_T) {
			return type2;
		} else if (type2 == AnyTypeImpl.OCL_T) {
			return type1;
		}
		
		if ((type1 == Types.OCL_VOID) || (type1 == Types.INVALID))
			return type2;
		if ((type2 == Types.OCL_VOID) || (type2 == Types.INVALID))
			return type1;
		
		if (type1 == Types.OCL_ANY_TYPE && !(type2 instanceof CollectionType))
			return Types.OCL_ANY_TYPE;
		if (type2 == Types.OCL_ANY_TYPE && !(type1 instanceof CollectionType))
			return Types.OCL_ANY_TYPE;
	
		if (type1 == Types.OCL_INTEGER
				&& type2 == Types.OCL_REAL)
				return Types.OCL_REAL;
		if (type2 == Types.OCL_INTEGER
				&& type1 == Types.OCL_REAL)
				return Types.OCL_REAL;
	
		if (type1 instanceof CollectionType) {
			return ((CollectionTypeImpl) type1).getCommonSupertype(type2);
		}
	
		if (type1 instanceof TupleType) {
			return ((TupleTypeImpl) type1).getCommonSupertype(type2);
		}
	
		if (type1 instanceof EClass && type2 instanceof EClass) {
			EClass eClass1 = (EClass) type1;
			EClass eClass2 = (EClass) type2;
			if (eClass1.isSuperTypeOf(eClass2)) {
				return eClass1;
			}
			if (eClass2.isSuperTypeOf(eClass1)) {
				return eClass2;
			}
			List allSuperAndSelf1 = new ArrayList(eClass1.getEAllSuperTypes());
			allSuperAndSelf1.add(eClass1);
			List allSuperAndSelf2 = new ArrayList(eClass2.getEAllSuperTypes());
			allSuperAndSelf2.add(eClass2);
			allSuperAndSelf1.retainAll(allSuperAndSelf2);
			if (!allSuperAndSelf1.isEmpty()) {
				return (EClassifier) allSuperAndSelf1.get(allSuperAndSelf1
					.size() - 1);
			}
		}
	
		String message = OCLMessages.bind(OCLMessages.TypeMismatch_ERROR_,
				getName(type1),
				getName(type2));
		CompatibilityParser.ERR(message);
		return null;
	}
	
	/**
	 * Null-safe equality.
	 * 
	 * @param a an object (may be <code>null</code>)
	 * @param b another object (may be <code>null</code>)
	 * 
	 * @return whether <code>a</code> and <code>b</code> are equal
	 */
	private static boolean eq(Object a, Object b) {
		return (a == null)? b == null : a.equals(b);
	}

	/**
	 * Computes the relationship between two types.
	 * 
	 * @param type1 a type
	 * @param type2 another type
	 * 
	 * @return either {@link PredefinedType#UNRELATED_TYPE},
     *    {@link PredefinedType#STRICT_SUBTYPE},
	 *    {@link PredefinedType#STRICT_SUPERTYPE}, or
     *    {@link PredefinedType#SAME_TYPE} according to the
	 *    relationship between the types
	 */
	public static int getRelationship(EClassifier type1, EClassifier type2) {
		if (eq(type1, type2)) {
			return PredefinedType.SAME_TYPE;
		}
		
		if (type1 == Types.OCL_ANY_TYPE && !(type2 instanceof CollectionType))
			return PredefinedType.STRICT_SUPERTYPE;
		if (type2 == Types.OCL_ANY_TYPE && !(type1 instanceof CollectionType))
			return PredefinedType.STRICT_SUBTYPE;
		
		if (type1 instanceof PredefinedType) {
			return ((PredefinedType) type1).getRelationshipTo(type2);
		} else if (type2 instanceof PredefinedType) {
			return inverseRelationship(((PredefinedType) type2).getRelationshipTo(type1));
		}
		
		if (type1 instanceof EClass && type2 instanceof EClass) {
			if (eq(type1, type2))
				return PredefinedType.SAME_TYPE;
			if (((EClass) type1).isSuperTypeOf((EClass) type2))
				return PredefinedType.STRICT_SUPERTYPE;
			if (((EClass) type2).isSuperTypeOf((EClass) type1))
				return PredefinedType.STRICT_SUBTYPE;
		}
	
		return PredefinedType.UNRELATED_TYPE;
	}

	static int inverseRelationship(int rel) {
		switch (rel) {
		case PredefinedType.STRICT_SUBTYPE:
			return PredefinedType.STRICT_SUPERTYPE;
		case PredefinedType.STRICT_SUPERTYPE:
			return PredefinedType.STRICT_SUBTYPE;
		case PredefinedType.SUBTYPE:
			return PredefinedType.SUPERTYPE;
		case PredefinedType.SUPERTYPE:
			return PredefinedType.SUBTYPE;
		default:
			// same type, unrelated type, related type are their own inverses
			return rel;
		}
	}
	
	static boolean isPrimitive(Object o) {
		return o instanceof Integer || o instanceof String
			|| o instanceof Boolean || o instanceof Double;
	}

	static boolean isComparable(EClassifier type) {
		return (type instanceof EDataType) && Comparable.class.isAssignableFrom(
				((EDataType) type).getInstanceClass());
	}

	static EOperation createUnaryOperation(EClassifier resultType,
		String name) {
		EOperation result = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEOperation();
		result.setEType(resultType);
		result.setName(name);
		return result;
	}

	static EOperation createBinaryOperation(EClassifier resultType,
		String name, EClassifier param, String paramName) {
		EOperation result = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEOperation();
		result.setEType(resultType);
		result.setName(name);
		EParameter parameter = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEParameter();
		parameter.setEType(param);
		parameter.setName(paramName);
		result.getEParameters().add(parameter);
	
		return result;
	}

	static EOperation createTernaryOperation(EClassifier resultType,
		String name, EClassifier param1, String param1Name,
		EClassifier param2, String param2Name) {
		EOperation result = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEOperation();
		result.setEType(resultType);
		result.setName(name);
		EParameter parameter = EcorePackage.eINSTANCE.getEcoreFactory()
			.createEParameter();
		parameter.setEType(param1);
		parameter.setName(param1Name);
		result.getEParameters().add(parameter);
		
		parameter = EcorePackage.eINSTANCE.getEcoreFactory().createEParameter();
		parameter.setEType(param2);
		parameter.setName(param2Name);
		result.getEParameters().add(parameter);
	
		return result;
	}
	
	static EStructuralFeature createProperty(ETypedElement element) {
		return createProperty(
				element.getName(),
				TypeUtil.getOCLType(element)); // handle collection type
	}
	
	static EStructuralFeature createProperty(TypedElement element) {
		return createProperty(element.getName(), element.getType());
	}
	
	private static EStructuralFeature createProperty(String name, EClassifier type) {
		EStructuralFeature result;
		
		if (type instanceof EClass) {
			result = EcoreFactory.eINSTANCE.createEReference();
		} else {
			result = EcoreFactory.eINSTANCE.createEAttribute();
			
			// Convert the OCL type back to an EMF type, if primitive
			if (type == Types.OCL_BOOLEAN) {
				type = EcorePackage.eINSTANCE.getEBoolean();
			} else if (type == Types.OCL_INTEGER) {
				type = EcorePackage.eINSTANCE.getEIntegerObject();
			} else if (type == Types.OCL_STRING) {
				type = EcorePackage.eINSTANCE.getEString();
			} else if (type == Types.OCL_REAL) {
				type = EcorePackage.eINSTANCE.getEDoubleObject();
			}
		}
		
		result.setName(name);
		result.setEType(type);
		
		return result;
	}

	/**
	 * Translator from primitive EMF types to OCL types
	 * 
	 * @param dataType a data type in the EMF metamodel
	 * @return  the corresponding OCL classifier
	 */
	private static EClassifier getOCLTypeFor(EDataType dataType) {
	
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
			return Types.OCL_BOOLEAN;
	
		// Double/double/Float/float -> OCL_REAL
		else if (instanceClass == Double.class
			|| instanceClass == double.class
			|| instanceClass == Float.class || instanceClass == float.class)
			return Types.OCL_REAL;
	
		// String -> OCL_STRING
		else if (instanceClass == String.class)
			return Types.OCL_STRING;
	
		// Integer/int/Long/long/Short/short -> OCL_INTEGER
		else if (instanceClass == Integer.class
			|| instanceClass == int.class || instanceClass == Long.class
			|| instanceClass == long.class || instanceClass == Short.class
			|| instanceClass == short.class)
			return Types.OCL_INTEGER;
	
		// List -> OCL_SEQUENCE
		else if (List.class.isAssignableFrom(instanceClass))
			return CollectionTypeImpl.OCL_SEQUENCE;
	
		// Set -> OCL_SET
		else if (Set.class.isAssignableFrom(instanceClass))
			return CollectionTypeImpl.OCL_SET;
	
		// Collection -> OCL_COLLECTION
		else if (Collection.class.isAssignableFrom(instanceClass))
			return CollectionTypeImpl.OCL_COLLECTION;
	
		// Object -> OCL_ANY_TYPE
		else if (instanceClass == Object.class)
			return Types.OCL_ANY_TYPE;
		
		// All other data types map to themselves
		return dataType;
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
	 * @see #getOCLType(EClassifier)
	 * @see #getOCLCollectionType(EClassifier, boolean, boolean)
	 */	
	public static EClassifier getOCLType(ETypedElement typedElement) {
		EClassifier resultType = typedElement.getEType();
		
		if (isMany(typedElement)) {
			resultType = getOCLCollectionType(
				resultType,
				typedElement.isOrdered(),
				typedElement.isUnique());
		} else {
			resultType = getOCLType(resultType);
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
	public static EClassifier getOCLType(EClassifier type) {
		EClassifier resultType = type;
	
		if (resultType instanceof EDataType) {
			resultType = getOCLTypeFor((EDataType) resultType);
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
	 * @see #getOCLType(EClassifier)
	 */	
	public static EClassifier getOCLCollectionType(EClassifier type,
			boolean isOrdered, boolean isUnique) {
		EClassifier resultType = type;
	
		if (resultType instanceof EDataType) {
			resultType = getOCLTypeFor((EDataType) resultType);
		}
		
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
	
	/**
	 * Custom is-many determination to assume that XSD unspecified multiplicities
	 * are many.
	 * 
	 * @param typedElement a typed element
	 * 
	 * @return whether it is not definitely a scalar
	 */
	public static boolean isMany(ETypedElement typedElement) {
		if (typedElement instanceof EStructuralFeature) {
			int upperBound = typedElement.getUpperBound();
			return (upperBound > 1) || (upperBound < 0);
		}
		
		return typedElement.isMany();
	}

	/**
	 * Resolves the specified type against the model-based types defined by
	 * the specified environment's type resolver, for consistency with the
	 * environment (especially for persistence).
	 * 
	 * @param env the parser environment
	 * @param type the type to resolve
	 * 
	 * @return the environment's corresponding type
	 */
	public static EClassifier resolveType(Environment env, EClassifier type) {
		return (env instanceof PersistentEnvironment)?
				((PersistentEnvironment) env).getTypeResolver().resolve(type) :
				type;
	}

	public static EStructuralFeature defineProperty(EClassifier owner, Variable variable) {
		EStructuralFeature result;
		
		String name = variable.getName();
		EClassifier type = variable.getType();
		
		if (type instanceof EClass) {
			result = EcoreFactory.eINSTANCE.createEReference();
		} else {
			result = EcoreFactory.eINSTANCE.createEAttribute();
		}
		
		result.setName(name);
		
		setType(result, type);
		
		AdditionalFeaturesAdapter adapter = getAdditionalFeatures(owner);
		if (adapter == null) {
			adapter = new AdditionalFeaturesAdapter();
			owner.eAdapters().add(adapter);
		}
		
		adapter.define(result);
		
		return result;
	}
	
	public static EOperation defineOperation(EClassifier owner, String name, EList params, EClassifier type) {
		EOperation result = EcoreFactory.eINSTANCE.createEOperation();
		
		result.setName(name);
		
		setType(result, type);
		
		for (Iterator iter = params.iterator(); iter.hasNext();) {
			Variable next = (Variable) iter.next();
			
			EParameter param = EcoreFactory.eINSTANCE.createEParameter();
			param.setName(next.getName());
			setType(param, next.getType());
			
			result.getEParameters().add(param);
		}
		
		AdditionalFeaturesAdapter adapter = getAdditionalFeatures(owner);
		if (adapter == null) {
			adapter = new AdditionalFeaturesAdapter();
			owner.eAdapters().add(adapter);
		}
		
		adapter.define(result);
		
		return result;
	}
	
	private static void setType(ETypedElement element, EClassifier type) {
		if (type == Types.OCL_VOID) {
			type = null;
		}
		
		if (!(type instanceof CollectionType)) {
			element.setEType(unOCLType(type));
		} else {
			CollectionType collType = (CollectionType) type;
			EClassifier elementType = collType.getElementType();
			
			if (elementType == Types.OCL_VOID) {
				elementType = null;
			}
			
			element.setEType(unOCLType(elementType));
			element.setUpperBound(ETypedElement.UNBOUNDED_MULTIPLICITY);
			
			switch (collType.getKind().getValue()) {
			case CollectionKind.BAG:
				element.setOrdered(false);
				element.setUnique(false);
				break;
			case CollectionKind.SET:
				element.setOrdered(false);
				element.setUnique(true);
				break;
			case CollectionKind.SEQUENCE:
				element.setOrdered(true);
				element.setUnique(false);
				break;
			case CollectionKind.ORDERED_SET:
				element.setOrdered(true);
				element.setUnique(true);
				break;
			}
		}
	}
	
	static EClassifier unOCLType(EClassifier oclType) {
		EClassifier result = oclType;
		
		if (oclType instanceof PrimitiveType) {
			if (oclType instanceof PrimitiveBoolean) {
				result = EcorePackage.Literals.EBOOLEAN_OBJECT;
			} else if (oclType instanceof PrimitiveString) {
				result = EcorePackage.Literals.ESTRING;
			} else if (oclType instanceof PrimitiveInteger) {
				result = EcorePackage.Literals.EINTEGER_OBJECT;
			} else if (oclType instanceof PrimitiveReal) {
				result = EcorePackage.Literals.EDOUBLE_OBJECT;
			}
		}
		
		return result;
	}
	
	public static EList getAdditionalProperties(EClassifier owner) {
		EList result = null;
		
		AdditionalFeaturesAdapter adapter = getAdditionalFeatures(owner);
		if (adapter != null && adapter.getAdditionalProperties() != null) {
			if (result == null) {
				result = new BasicEList(adapter.getAdditionalProperties());
			}
		}
		
		if (owner instanceof EClass) {
			for (Iterator iter = ((EClass) owner).getEAllSuperTypes().iterator(); iter.hasNext();) {
				EClass next = (EClass) iter.next();
				
				adapter = getAdditionalFeatures(next);
				if (adapter != null && adapter.getAdditionalProperties() != null) {
					if (result == null) {
						result = new BasicEList(adapter.getAdditionalProperties());
					} else {
						result.addAll(adapter.getAdditionalProperties());
					}
				}
			}
		}
		
		return result;
	}
	
	public static EList getAdditionalOperations(EClassifier owner) {
		EList result = null;
		
		AdditionalFeaturesAdapter adapter = getAdditionalFeatures(owner);
		if (adapter != null && adapter.getAdditionalOperations() != null) {
			if (result == null) {
				result = new BasicEList(adapter.getAdditionalOperations());
			}
		}
		
		if (owner instanceof EClass) {
			for (Iterator iter = ((EClass) owner).getEAllSuperTypes().iterator(); iter.hasNext();) {
				EClass next = (EClass) iter.next();
				
				adapter = getAdditionalFeatures(next);
				if (adapter != null && adapter.getAdditionalOperations() != null) {
					if (result == null) {
						result = new BasicEList(adapter.getAdditionalOperations());
					} else {
						result.addAll(adapter.getAdditionalOperations());
					}
				}
			}
		}
		
		if (result == null) {
			result = ECollections.EMPTY_ELIST;
		}
		
		return result;
	}
	
	static AdditionalFeaturesAdapter getAdditionalFeatures(EClassifier owner) {
		return (AdditionalFeaturesAdapter) EcoreUtil.getExistingAdapter(
				owner, AdditionalFeaturesAdapter.class);
	}
	
	public static void undefineAdditionalFeatures(EClassifier owner) {
		AdditionalFeaturesAdapter adapter = getAdditionalFeatures(owner);
		
		if (adapter != null) {
			owner.eAdapters().remove(adapter);
		}
	}
	
	public static void resolveAdditionalFeatures(EClassifier owner, Environment env) {
		AdditionalFeaturesAdapter adapter = getAdditionalFeatures(owner);
		
		if (adapter != null) {
			adapter.resolve(owner, env);
		}
	}
	
	private static class AdditionalFeaturesAdapter extends AdapterImpl {
		private EList additionalProperties;
		private EList additionalOperations;
		
		@SuppressWarnings("unused")
		protected EClassifier getOwner() {
			return (EClassifier) getTarget();
		}
		
		@Override
        public boolean isAdapterForType(Object type) {
			return type == AdditionalFeaturesAdapter.class;
		}
		
		public EList getAdditionalOperations() {
			return additionalOperations;
		}
		
		public EList getAdditionalProperties() {
			return additionalProperties;
		}
		
		public void define(EOperation operation) {
			if (additionalOperations == null) {
				additionalOperations = new BasicEList();
			}
			
			additionalOperations.add(operation);
		}
		
		public void define(EStructuralFeature property) {
			if (additionalProperties == null) {
				additionalProperties = new BasicEList();
			}
			
			additionalProperties.add(property);
		}
		
		public void resolve(EClassifier owner, Environment env) {
			if (env instanceof PersistentEnvironment) {
				TypeResolver resolver = ((PersistentEnvironment) env).getTypeResolver();
				Resource resource = resolver.getResource();
				
				if (additionalProperties != null) {
					for (ListIterator iter = additionalProperties.listIterator(); iter.hasNext();) {
						EStructuralFeature next = (EStructuralFeature) iter.next();
						
						EStructuralFeature resolved;
						if (next.eIsProxy()) {
							resolved = (EStructuralFeature) EcoreUtil.resolve(next, resource);
						} else {
							resolved = resolver.resolveAdditionalProperty(owner, next);
						}
						
						if (resolved != next) {
							iter.set(resolved);
						}
					}
				}
				
				if (additionalOperations != null) {
					for (ListIterator iter = additionalOperations.listIterator(); iter.hasNext();) {
						EOperation next = (EOperation) iter.next();
						
						EOperation resolved;
						if (next.eIsProxy()) {
							resolved = (EOperation) EcoreUtil.resolve(next, resource);
						} else {
							resolved = resolver.resolveAdditionalOperation(owner, next);
						}
						
						if (resolved != next) {
							iter.set(resolved);
						}
					}
				}
			}
		}
	}
}
