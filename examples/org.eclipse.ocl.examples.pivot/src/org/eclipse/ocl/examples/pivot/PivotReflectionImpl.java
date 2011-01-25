/**
 * <copyright>
 *
 * Copyright (c) 2006,2011 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 240230
 *   Achim Demelt - Bug 245897
 *	 E.D.Willink Bug 298128
 *
 * </copyright>
 *
 * $Id: PivotReflectionImpl.java,v 1.2 2011/01/24 20:47:52 ewillink Exp $
 */

package org.eclipse.ocl.examples.pivot;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;

/**
 * Implementation of the UML reflection service for the Ecore environment.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class PivotReflectionImpl implements UMLReflection {

    protected final TypeManager typeManager;

    /**
     * Initializes me.
     */
    protected PivotReflectionImpl(TypeManager typeManager) {
        this.typeManager = typeManager;
    }
    
    /**
     * Default implementation just gets the name of the named element's
     * {@link org.eclipse.emf.ecore.EObject#eClass() eClass} or, if it is an
     * {@link TypedElement}, the name of its type.
     */
    public String getDescription(Object namedElement) {
        if (namedElement instanceof TypedElement) {
            Type type = ((TypedElement) namedElement).getType();
            return (type == null) ? typeManager.getOclVoidType().getName()
                : type.getName();
        } else if (namedElement instanceof EnumerationLiteral) {
            return ((EnumerationLiteral) namedElement).getEnumeration().getName();
        } else if (namedElement == null) {
            return null;
        }

        return ((EObject) namedElement).eClass().getName();
    }
    
    public String getName(Object namedElement) {
        return (namedElement instanceof NamedElement)?
            ((NamedElement) namedElement).getName() : null;
    }
    
    public String getQualifiedName(Object namedElement) {
        return (namedElement instanceof NamedElement)?
            getQualifiedName((NamedElement) namedElement) : null;
    }
    
    /**
     * Helper for the {@link #getQualifiedName(Object)}.
     */
    private String getQualifiedName(NamedElement namedElement) {
        StringBuffer result = new StringBuffer();
        
        getQualifiedName(result, namedElement);
        
        return result.toString();
    }
    
    /**
     * Helper for the {@link #getQualifiedName(Object)}.
     */
    private void getQualifiedName(StringBuffer buf, NamedElement namedElement) {
        EObject container = namedElement.eContainer();
        if (container instanceof NamedElement) {
            getQualifiedName(buf, (NamedElement) container);
            
            buf.append("::"); //$NON-NLS-1$
        }
        
        buf.append(namedElement.getName());
    }
    
    public Type getOCLType(Object metaElement) {
        Type result = null;
        
        if (metaElement == PivotPackage.Literals.MULTIPLICITY_ELEMENT___UPPER_BOUND) {
            // the upper bound of multiplicity has UnlimitedNatural type
        	result = typeManager.getUnlimitedNaturalType();
        } else if (metaElement instanceof TypedMultiplicityElement) {
        	TypedMultiplicityElement typedElement = (TypedMultiplicityElement) metaElement;
            result = typedElement.getType();
            
            if (isMany(typedElement)) {
            	result = getOCLCollectionType(
                        result,
                        typedElement.isOrdered(),
                        typedElement.isUnique());
            } else {
                result = getOCLType(result);
            }
        } else if (metaElement instanceof Type) {
            result = getOCLType((Type) metaElement);
        }
        
        return result;
    }
    
    public Collection<? extends Type> getAllSupertypes(Type classifier) {
    	throw new UnsupportedOperationException(getClass().getName() + ".getAllSupertypes");
/*        if (classifier instanceof org.eclipse.ocl.examples.pivot.Class) {
            return ((org.eclipse.ocl.examples.pivot.Class) classifier).getEAllSuperTypes();
        }
        
        return Collections.emptySet(); */
    }
    
    public boolean isMany(Object metaElement) {
        return (metaElement instanceof TypedElement) &&
                isMany((TypedElement) metaElement);
    }
    
    public Type asOCLType(Type modelType) {
        return getOCLType(modelType);
    }
    
    public org.eclipse.ocl.examples.pivot.Package getNestingPackage(org.eclipse.ocl.examples.pivot.Package pkg) {
        return pkg.getNestingPackage();
    }
    
    public Set<org.eclipse.ocl.examples.pivot.Package> getNestedPackages(org.eclipse.ocl.examples.pivot.Package pkg) {
        return new HashSet<org.eclipse.ocl.examples.pivot.Package>(pkg.getNestedPackages());
    }
    
    public org.eclipse.ocl.examples.pivot.Package getPackage(Type classifier) {
        return classifier.getPackage();
    }
    
    public List<Type> getClassifiers(org.eclipse.ocl.examples.pivot.Package pkg) {
        return pkg.getOwnedTypes();
    }
    
    public Type getOwningClassifier(Object feature) {
        if (feature instanceof Feature) {
            return ((Feature) feature).getFeaturingClass();
        }
        return null;
    }
    
    public List<Parameter> getParameters(Operation operation) {
        return operation.getOwnedParameters();
    }
    
    public Operation createOperation(String name, Type resultType,
            List<String> paramNames, List<Type> paramTypes) {
        
        Operation result = PivotFactory.eINSTANCE.createOperation();
        result.setName(name);
        result.setType(resultType);
        
        int i = 0;
        for (String pname : paramNames) {
            Parameter param = PivotFactory.eINSTANCE.createParameter();
            
            param.setName(pname);
            param.setType(paramTypes.get(i++));
            
            result.getOwnedParameters().add(param);
        }
        
        return result;
    }
    
    public List<Operation> getOperations(Type classifier) {
    	throw new UnsupportedOperationException(getClass().getName() + ".getOperations");
/*        List<Operation> result;
        
        if (classifier instanceof org.eclipse.ocl.examples.pivot.Class) {
            result = ((org.eclipse.ocl.examples.pivot.Class) classifier).getEAllOperations();
        } else {
            result = Collections.emptyList();
        }
        
        return result; */
    }
    
    public Property createProperty(String name, Type resultType) {       
        Property result = PivotFactory.eINSTANCE.createProperty();
        result.setName(name);
        result.setType(resultType);       
        return result;
    }
    
    public List<Property> getAttributes(Type classifier) {
    	throw new UnsupportedOperationException(getClass().getName() + ".getAttributes");
/*        List<Property> result;
        
        if (classifier instanceof org.eclipse.ocl.examples.pivot.Class) {
            result = ((org.eclipse.ocl.examples.pivot.Class) classifier).getEAllStructuralFeatures();
        } else {
            result = Collections.emptyList();
        }
        
        return result; */
    }

    public List<Signal> getSignals(Type owner) {
        return Collections.emptyList();
    }
    
    /**
     * Determines whether the specified <code>operation</code> is a query
     * operation.  By default, all operations are assumed to be queries.
     * 
     * @param operation an operation
     * @return <code>true</code>, by default
     */
    public boolean isQuery(Operation operation) {
        return true;
    }
    
    public boolean isStatic(Object feature) {
        return false;
    }

    /**
     * Determines whether the specified <code>eclass</code> is an association
     * class.  By default, it is assumed that nothing is an association class
     * because Ecore does not directly support this concept.
     * 
     * @param eclass an Ecore class
     * @return <code>false</code>, by default
     */
    public boolean isAssociationClass(Type eclass) {
        return false;
    }
    
    /**
     * Obtains the association class that the specified reference represents,
     * as an {@link EClass}, if any.  By default, it is assumed that nothing is
     * an association class because Ecore does not directly support this concept.
     * 
     * @param reference a reference
     * @return <code>null</code>, by default
     */
    public org.eclipse.ocl.examples.pivot.Class getAssociationClass(Property reference) {
        return null;
    }
    
    /**
     * Obtains the ends of the specified association class as a list of
     * {@link EReference}s.  By default, it is assumed that nothing is an
     * association class because Ecore does not directly support this concept.
     * 
     * @param associationClass an EClass representing an association class
     * @return an empty list, by default
     */
    public List<Property> getMemberEnds(Type associationClass) {
        return Collections.emptyList();
    }

    public boolean isOperation(Object metaElement) {
        return metaElement instanceof Operation;
    }

	public boolean isPackage(Object metaElement) {
        return metaElement instanceof org.eclipse.ocl.examples.pivot.Package;
	}
    
    public boolean isProperty(Object metaElement) {
        return metaElement instanceof Property;
    }
    
    public boolean isClassifier(Object metaElement) {
        return metaElement instanceof Type;
    }
    
    public boolean isClass(Object metaElement) {
        return metaElement instanceof org.eclipse.ocl.examples.pivot.Class;
    }

	public boolean isConstraint(Object metaElement) {
        return metaElement instanceof Constraint;
	}
    
    public boolean isDataType(Object metaElement) {
        return metaElement instanceof DataType;
    }
    
    public boolean isEnumeration(Type type) {
        return type instanceof Enumeration;
    }

    public Enumeration getEnumeration(EnumerationLiteral enumerationLiteral) {
        return enumerationLiteral.getEnumeration();
    }

    public List<EnumerationLiteral> getEnumerationLiterals(Type enumerationType) {
        return ((Enumeration) enumerationType).getOwnedLiterals();
    }
    
    public EnumerationLiteral getEnumerationLiteral(Type enumerationType,
            String literalName) {
        return ObjectUtil.getNamedElement(((Enumeration) enumerationType).getOwnedLiterals(), literalName);
    }
    
    public boolean isStereotype(Type type) {
        return false;
    }
    
    public Object getStereotypeApplication(Object baseElement, Type stereotype) {
        return null;
    }
    
    public boolean isComparable(Type type) {
    	throw new UnsupportedOperationException(getClass().getName() + ".isComparable");
//        Class<?> javaClass = type.getInstanceClass();
        
//        return (javaClass != null) && Comparable.class.isAssignableFrom(javaClass);
    }
    
    public CallOperationAction createCallOperationAction(Operation operation) {
        CallOperationAction result = PivotFactory.eINSTANCE.createCallOperationAction();
        result.setOperation(operation);
        return result;
    }
    
    public Operation getOperation(CallOperationAction callOperationAction) {
        return callOperationAction.getOperation();
    }
    
    public SendSignalAction createSendSignalAction(Signal signal) {
        SendSignalAction result = PivotFactory.eINSTANCE.createSendSignalAction();
        result.setSignal(signal);
        return result;
    }
    
    public Signal getSignal(SendSignalAction sendSignalAction) {
        return sendSignalAction.getSignal();
    }
    
    public Constraint createConstraint() {
        return PivotFactory.eINSTANCE.createConstraint();
    }
    
    public String getStereotype(Constraint constraint) {
        return constraint.getStereotype();
    }
    
    public void setStereotype(Constraint constraint, String stereotype) {
        constraint.setStereotype(stereotype);
    }
    
    public String getConstraintName(Constraint constraint) {
        return constraint.getName();
    }
    
    public void setConstraintName(Constraint constraint, String name) {
        constraint.setName(name);
    }
    
    public ExpressionInOcl createExpressionInOcl() {
        return PivotFactory.eINSTANCE.createExpressionInOcl();
    }
    
    public ExpressionInOcl getSpecification(Constraint constraint) {        
        return (ExpressionInOcl) constraint.getSpecification();
    }
    
    public void setSpecification(Constraint constraint, ExpressionInOcl specification) {
        constraint.setSpecification(specification);
    }
    
    public Constraint getConstraint(ExpressionInOcl specification) {
        EObject container = specification.eContainer();       
        if (container instanceof Constraint) {
            return (Constraint) container;
        }      
        return null;
    }
    
    public List<Element> getConstrainedElements(Constraint constraint) {
        return constraint.getConstrainedElements();
    }

	public void addConstrainedElement(Constraint constraint, Element constrainedElement) {
		constraint.getConstrainedElements().add(constrainedElement);
	}
    
    /**
     * Gets the qualifiers of an association end.
     * By default, it is assumed that properties never have qualifiers
     * because Ecore does not directly support this concept.
     * 
     * @param property a property of the model class
     * @return an empty list, by default
     */
    public List<Property> getQualifiers(Property property) {
        return ECollections.emptyEList();
    }

    /**
     * Get the common supertype of two types.
     * 
     * @param type1
     * @param type2
     * @return the common supertype
     */
    public Type getCommonSuperType(Type type1, Type type2) {
    	return TypeUtil.getCommonSuperType(type1, type2);
/*        if (ObjectUtil.equal(type1, type2)) {
            return type2;
        }
        
        if (type1 instanceof org.eclipse.ocl.examples.pivot.Class && type2 instanceof org.eclipse.ocl.examples.pivot.Class) {
            org.eclipse.ocl.examples.pivot.Class eClass1 = (org.eclipse.ocl.examples.pivot.Class) type1;
            org.eclipse.ocl.examples.pivot.Class eClass2 = (org.eclipse.ocl.examples.pivot.Class) type2;
            if (typeManager.conformsTo(eClass2, eClass1)) {
                return eClass1;
            }
            if (typeManager.conformsTo(eClass1, eClass2)) {
                return eClass2;
            }
            List<org.eclipse.ocl.examples.pivot.Class> allSuperAndSelf1 = new ArrayList<org.eclipse.ocl.examples.pivot.Class>(
                    eClass1.getEAllSuperTypes());
            allSuperAndSelf1.add(eClass1);
            
            List<org.eclipse.ocl.examples.pivot.Class> allSuperAndSelf2 = new ArrayList<org.eclipse.ocl.examples.pivot.Class>(
                    eClass2.getEAllSuperTypes());
            allSuperAndSelf2.add(eClass2);
            
            allSuperAndSelf1.retainAll(allSuperAndSelf2);
            if (!allSuperAndSelf1.isEmpty()) {
                // because EMF records supertypes from highest to lowest in the
                //   hierarchy, the least common supertype is the *last*
                return allSuperAndSelf1.get(allSuperAndSelf1.size() - 1);
            }
        }
    
        return null; */
    }

    /**
     * Computes the relationship between two types.
     * 
     * @param type1 a type
     * @param type2 another type
     * 
     * @return either {@link #UNRELATED_TYPE}, {@link #STRICT_SUBTYPE},
     *    {@link #STRICT_SUPERTYPE}, or {@link #SAME_TYPE} according to the
     *    relationship between the types
     */
    public int getRelationship(Type type1, Type type2) {
        return TypeUtil.getTypeRelationship(type1, type2);
    }

    /**
     * Translator from primitive EMF types to OCL types
     * 
     * @param dataType a data type in the EMF metamodel
     * @return  the corresponding OCL classifier
     */
    private Type getOCLTypeFor(DataType dataType) {
    
        // First check if it is already an OCL data type (EEnums represent
        //    themselves)
        if (dataType instanceof Enumeration) {
            return dataType;
        }
        if (dataType instanceof CollectionType) {
            return dataType;
        }
        if (dataType instanceof PrimitiveType) {
            return dataType;
        }
    
/*        Class<?> instanceClass = dataType.getInstanceClass();
    
        if (instanceClass != null) {
	        if (instanceClass == Boolean.class
	            || instanceClass == boolean.class) {
	            return typeManager.getBooleanType();
	        } else if (instanceClass == Double.class
				|| instanceClass == BigDecimal.class
				|| instanceClass == double.class
				|| instanceClass == Float.class || instanceClass == float.class) {
				return typeManager.getRealType();
			} else if (instanceClass == String.class) {
				return typeManager.getStringType();
			} else if (instanceClass == Integer.class
				|| instanceClass == int.class || instanceClass == Long.class
				|| instanceClass == long.class || instanceClass == Short.class
				|| instanceClass == short.class
				|| instanceClass == BigInteger.class) {
				return typeManager.getIntegerType();
	        } else if (List.class.isAssignableFrom(instanceClass)) {
	            return typeManager.getSequenceType();
	        } else if (Set.class.isAssignableFrom(instanceClass)) {
	            return typeManager.getSetType();
	        } else if (Collection.class.isAssignableFrom(instanceClass)) {
	            return typeManager.getCollectionType();
	        } else if (instanceClass == Object.class) {
	            return typeManager.getOclAnyType();
	        }
        } */
        
        // All other data types map to themselves
        return dataType;
    }

    /**
     * Obtains the appropriate OCL type for an {@link Type}, if it
     * corresponds to an OCL primitive type.
     * 
     * @param type the type to convert to an OCL type
     * @return the corresponding OCL type
     */ 
    Type getOCLType(Type type) {
        Type resultType = type;
    
        if (resultType instanceof DataType) {
            resultType = getOCLTypeFor((DataType) resultType);
        }
        
        return resultType;
    }

    /**
     * Obtains the appropriate OCL collection type for an {@link Type}, 
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
     * @see #getOCLType(Type)
     */ 
    Type getOCLCollectionType(Type type, boolean isOrdered, boolean isUnique) {
        Type resultType = type;
    
        if (resultType instanceof DataType) {
            resultType = getOCLTypeFor((DataType) resultType);
        }
        
        OCLFactory oclFactory = OCLFactoryImpl.INSTANCE;
        
        if (isOrdered) {
            if (isUnique) {
                resultType = (Type) oclFactory.createOrderedSetType(resultType);
            } else {
                resultType = (Type) oclFactory.createSequenceType(resultType);
            }
        } else {
            if (isUnique) {
                resultType = (Type) oclFactory.createSetType(resultType);
            } else {
                resultType = (Type) oclFactory.createBagType(resultType);
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
    static boolean isMany(TypedMultiplicityElement typedElement) {
        int upperBound = typedElement.getUpper().intValue();
        return (upperBound > 1) || (upperBound < 0);
    }
    
    /**
     * Queries whether a prospective <tt>ancestor</tt> really is a container
     * (recursively) of the specified <tt>descendent</tt>.  This utility is
     * like the similar {@link EcoreUtil} operation, except that it does not
     * require the arguments to be {@link InternalEObject}s.
     * 
     * @param ancestor a prospective ancestor element
     * @param descendent a prospective descendent element
     * @return <code>true</code> if the ancestor contains (recursively) the
     *    descendent
     */
    public static boolean isAncestor(EObject ancestor, EObject descendent) {
        while (descendent != null) {
            if (descendent == ancestor) {
                return true;
            }
            
            descendent = descendent.eContainer();
        }
        
        return false;
    }
    
    public void setName(TypedElement element, String name) {
    	element.setName(name);
    }
    
    public void setType(TypedElement element, Type type) {
    	element.setType(type);
    }

	public boolean setIsStatic(Object feature, boolean isStatic) {
		return false;
	}
}
