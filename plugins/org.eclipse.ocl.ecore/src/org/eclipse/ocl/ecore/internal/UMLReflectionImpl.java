/**
 * <copyright>
 *
 * Copyright (c) 2006, 2010 IBM Corporation and others.
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
 * $Id: UMLReflectionImpl.java,v 1.13 2010/12/15 17:32:44 ewillink Exp $
 */

package org.eclipse.ocl.ecore.internal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.TypedElement;

/**
 * Implementation of the UML reflection service for the Ecore environment.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class UMLReflectionImpl
    implements
    org.eclipse.ocl.utilities.UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> {

    /** Shared instance of the stateless reflection service. */
    public static final UMLReflectionImpl INSTANCE = new UMLReflectionImpl();

    /**
     * Initializes me.
     */
    protected UMLReflectionImpl() {
        super();
    }
    
    /**
     * Default implementation just gets the name of the named element's
     * {@link org.eclipse.emf.ecore.EObject#eClass() eClass} or, if it is an
     * {@link ETypedElement}, the name of its type.
     */
    public String getDescription(Object namedElement) {
        if (namedElement instanceof ETypedElement) {
            EClassifier type = ((ETypedElement) namedElement).getEType();
            return (type == null) ? OCLStandardLibraryImpl.INSTANCE
                .getOclVoid().getName()
                : type.getName();
        } else if (namedElement instanceof EEnumLiteral) {
            return ((EEnumLiteral) namedElement).getEEnum().getName();
        } else if (namedElement == null) {
            return null;
        }

        return ((EObject) namedElement).eClass().getName();
    }
    
    public String getName(Object namedElement) {
        return (namedElement instanceof ENamedElement)?
            ((ENamedElement) namedElement).getName() : null;
    }
    
    public String getQualifiedName(Object namedElement) {
        return (namedElement instanceof ENamedElement)?
            getQualifiedName((ENamedElement) namedElement) : null;
    }
    
    /**
     * Helper for the {@link #getQualifiedName(Object)}.
     */
    private String getQualifiedName(ENamedElement namedElement) {
        StringBuffer result = new StringBuffer();
        
        getQualifiedName(result, namedElement);
        
        return result.toString();
    }
    
    /**
     * Helper for the {@link #getQualifiedName(Object)}.
     */
    private void getQualifiedName(StringBuffer buf, ENamedElement namedElement) {
        EObject container = namedElement.eContainer();
        if (container instanceof ENamedElement) {
            getQualifiedName(buf, (ENamedElement) container);
            
            buf.append("::"); //$NON-NLS-1$
        }
        
        buf.append(namedElement.getName());
    }
    
    public EClassifier getOCLType(Object metaElement) {
        EClassifier result = null;
        
        if (metaElement == EcorePackage.Literals.ETYPED_ELEMENT__UPPER_BOUND) {
            // the upper bound of multiplicity has UnlimitedNatural type
            return OCLStandardLibraryImpl.INSTANCE.getUnlimitedNatural();
        } else if (metaElement instanceof ETypedElement) {
            ETypedElement typedElement = (ETypedElement) metaElement;
            result = typedElement.getEType();
            
            if (isMany(typedElement)) {
                result = getOCLCollectionType(
                        result,
                        typedElement.isOrdered(),
                        typedElement.isUnique());
            } else {
                result = getOCLType(result);
            }
        } else if (metaElement instanceof EClassifier) {
            result = getOCLType((EClassifier) metaElement);
        }
        
        return result;
    }
    
    public Collection<? extends EClassifier> getAllSupertypes(EClassifier classifier) {
        if (classifier instanceof EClass) {
            return ((EClass) classifier).getEAllSuperTypes();
        }
        
        return Collections.emptySet();
    }
    
    public boolean isMany(Object metaElement) {
        return (metaElement instanceof ETypedElement) &&
                isMany((ETypedElement) metaElement);
    }
    
    public EClassifier asOCLType(EClassifier modelType) {
        return getOCLType(modelType);
    }
    
    public EPackage getNestingPackage(EPackage pkg) {
        return pkg.getESuperPackage();
    }
    
    public List<EPackage> getNestedPackages(EPackage pkg) {
        return pkg.getESubpackages();
    }
    
    public EPackage getPackage(EClassifier classifier) {
        return classifier.getEPackage();
    }
    
    public List<EClassifier> getClassifiers(EPackage pkg) {
        return pkg.getEClassifiers();
    }
    
    public EClassifier getOwningClassifier(Object feature) {
        if (feature instanceof EOperation) {
            EOperation operation = (EOperation) feature;
            
            return OCLStandardLibraryImpl.getOwner(operation);
        } else if (feature instanceof EStructuralFeature) {
            return OCLStandardLibraryImpl.getOwner((EStructuralFeature) feature);
        }
        
        return null;
    }
    
    public List<EParameter> getParameters(EOperation operation) {
        return operation.getEParameters();
    }
    
    public EOperation createOperation(String name, EClassifier resultType,
            List<String> paramNames, List<EClassifier> paramTypes) {
        
        EOperation result = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEOperation();
        result.setName(name);
        result.setEType(resultType);
        
        int i = 0;
        for (String pname : paramNames) {
            EParameter param = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEParameter();
            
            param.setName(pname);
            param.setEType(paramTypes.get(i++));
            
            result.getEParameters().add(param);
        }
        
        return result;
    }
    
    public List<EOperation> getOperations(EClassifier classifier) {
        List<EOperation> result;
        
        if (classifier instanceof EClass) {
            result = ((EClass) classifier).getEAllOperations();
        } else {
            result = Collections.emptyList();
        }
        
        return result;
    }
    
    public EStructuralFeature createProperty(String name, EClassifier resultType) {
        
        EStructuralFeature result;
        
        if (resultType instanceof EClass) {
            result = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEReference();
        } else {
            result = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
        }
        
        result.setName(name);
        result.setEType(resultType);
        
        return result;
    }
    
    public List<EStructuralFeature> getAttributes(EClassifier classifier) {
        List<EStructuralFeature> result;
        
        if (classifier instanceof EClass) {
            result = ((EClass) classifier).getEAllStructuralFeatures();
        } else {
            result = Collections.emptyList();
        }
        
        return result;
    }

    public List<EClassifier> getSignals(EClassifier owner) {
        return Collections.emptyList();
    }
    
    /**
     * Determines whether the specified <code>operation</code> is a query
     * operation.  By default, all operations are assumed to be queries.
     * 
     * @param operation an operation
     * @return <code>true</code>, by default
     */
    public boolean isQuery(EOperation operation) {
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
    public boolean isAssociationClass(EClassifier eclass) {
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
    public EClass getAssociationClass(EStructuralFeature reference) {
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
    public List<EStructuralFeature> getMemberEnds(EClassifier associationClass) {
        return Collections.emptyList();
    }

    public boolean isOperation(Object metaElement) {
        return metaElement instanceof EOperation;
    }

	public boolean isPackage(Object metaElement) {
        return metaElement instanceof EPackage;
	}
    
    public boolean isProperty(Object metaElement) {
        return metaElement instanceof EStructuralFeature;
    }
    
    public boolean isClassifier(Object metaElement) {
        return metaElement instanceof EClassifier;
    }
    
    public boolean isClass(Object metaElement) {
        return metaElement instanceof EClass;
    }

	public boolean isConstraint(Object metaElement) {
        return metaElement instanceof Constraint;
	}
    
    public boolean isDataType(Object metaElement) {
        return metaElement instanceof EDataType;
    }
    
    public boolean isEnumeration(EClassifier type) {
        return type instanceof EEnum;
    }

    public EClassifier getEnumeration(EEnumLiteral enumerationLiteral) {
        return enumerationLiteral.getEEnum();
    }

    public List<EEnumLiteral> getEnumerationLiterals(EClassifier enumerationType) {
        return ((EEnum) enumerationType).getELiterals();
    }
    
    public EEnumLiteral getEnumerationLiteral(EClassifier enumerationType,
            String literalName) {
        return ((EEnum) enumerationType).getEEnumLiteral(literalName);
    }
    
    public boolean isStereotype(EClassifier type) {
        return false;
    }
    
    public Object getStereotypeApplication(Object baseElement, EClassifier stereotype) {
        return null;
    }
    
    public boolean isComparable(EClassifier type) {
        Class<?> javaClass = type.getInstanceClass();
        
        return (javaClass != null) && Comparable.class.isAssignableFrom(javaClass);
    }
    
    public CallOperationAction createCallOperationAction(EOperation operation) {
        CallOperationAction result = EcoreFactory.eINSTANCE.createCallOperationAction();
        result.setOperation(operation);
        return result;
    }
    
    public EOperation getOperation(CallOperationAction callOperationAction) {
        return callOperationAction.getOperation();
    }
    
    public SendSignalAction createSendSignalAction(EClassifier signal) {
        SendSignalAction result = EcoreFactory.eINSTANCE.createSendSignalAction();
        result.setSignal((EClass) signal);
        return result;
    }
    
    public EClass getSignal(SendSignalAction sendSignalAction) {
        return sendSignalAction.getSignal();
    }
    
    public Constraint createConstraint() {
        return EcoreFactory.eINSTANCE.createConstraint();
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
    
    public ExpressionInOCL<EClassifier, EParameter> createExpressionInOCL() {
        return EcoreFactory.eINSTANCE.createExpressionInOCL();
    }
    
    public ExpressionInOCL<EClassifier, EParameter> getSpecification(
            Constraint constraint) {
        
        return constraint.getSpecification();
    }
    
    public void setSpecification(
            Constraint constraint,
            ExpressionInOCL<EClassifier, EParameter> specification) {
        constraint.setSpecification(specification);
    }
    
    public Constraint getConstraint(
            ExpressionInOCL<EClassifier, EParameter> specification) {
        EObject container = specification.eContainer();
        
        if (container instanceof Constraint) {
            return (Constraint) container;
        }
        
        return null;
    }
    
    public List<EModelElement> getConstrainedElements(Constraint constraint) {
        return constraint.getConstrainedElements();
    }

	public void addConstrainedElement(Constraint constraint, EObject constrainedElement) {
		constraint.getConstrainedElements().add((EModelElement) constrainedElement);
	}
    
    /**
     * Gets the qualifiers of an association end.
     * By default, it is assumed that properties never have qualifiers
     * because Ecore does not directly support this concept.
     * 
     * @param property a property of the model class
     * @return an empty list, by default
     */
    public List<EStructuralFeature> getQualifiers(EStructuralFeature property) {
        return ECollections.emptyEList();
    }

    /**
     * Get the common supertype of two types.
     * 
     * @param type1
     * @param type2
     * @return the common supertype
     */
    public EClassifier getCommonSuperType(EClassifier type1, EClassifier type2) {
    
        if (ObjectUtil.equal(type1, type2)) {
            return type2;
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
            List<EClass> allSuperAndSelf1 = new ArrayList<EClass>(
                    eClass1.getEAllSuperTypes());
            allSuperAndSelf1.add(eClass1);
            
            List<EClass> allSuperAndSelf2 = new ArrayList<EClass>(
                    eClass2.getEAllSuperTypes());
            allSuperAndSelf2.add(eClass2);
            
            allSuperAndSelf1.retainAll(allSuperAndSelf2);
            if (!allSuperAndSelf1.isEmpty()) {
                // because EMF records supertypes from highest to lowest in the
                //   hierarchy, the least common supertype is the *last*
                return allSuperAndSelf1.get(allSuperAndSelf1.size() - 1);
            }
        }
    
        return null;
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
    public int getRelationship(EClassifier type1, EClassifier type2) {
        if (ObjectUtil.equal(type1, type2)) {
            return SAME_TYPE;
        }
        
        if ((type1 instanceof EClass) && (type2 instanceof EClass)) {
            EClass class1 = (EClass) type1;
            EClass class2 = (EClass) type2;
            
            if (class1.isSuperTypeOf(class2)) {
                return STRICT_SUPERTYPE;
            } else if (class2.isSuperTypeOf(class1)) {
                return STRICT_SUBTYPE;
            }
        }
    
        return UNRELATED_TYPE;
    }

    /**
     * Translator from primitive EMF types to OCL types
     * 
     * @param dataType a data type in the EMF metamodel
     * @return  the corresponding OCL classifier
     */
    private EClassifier getOCLTypeFor(EDataType dataType) {
    
        // First check if it is already an OCL data type (EEnums represent
        //    themselves)
        if (dataType instanceof EEnum) {
            return dataType;
        }
        if (dataType instanceof CollectionType<?, ?>) {
            return dataType;
        }
        if (dataType instanceof PrimitiveType<?>) {
            return dataType;
        }
    
        Class<?> instanceClass = dataType.getInstanceClass();
    
        if (instanceClass != null) {
	        if (instanceClass == Boolean.class
	            || instanceClass == boolean.class) {
	            return OCLStandardLibraryImpl.INSTANCE.getBoolean();
	        } else if (instanceClass == Double.class
				|| instanceClass == BigDecimal.class
				|| instanceClass == double.class
				|| instanceClass == Float.class || instanceClass == float.class) {
				return OCLStandardLibraryImpl.INSTANCE.getReal();
			} else if (instanceClass == String.class) {
				return OCLStandardLibraryImpl.INSTANCE.getString();
			} else if (instanceClass == Integer.class
				|| instanceClass == int.class || instanceClass == Long.class
				|| instanceClass == long.class || instanceClass == Short.class
				|| instanceClass == short.class
				|| instanceClass == BigInteger.class) {
				return OCLStandardLibraryImpl.INSTANCE.getInteger();
	        } else if (List.class.isAssignableFrom(instanceClass)) {
	            return OCLStandardLibraryImpl.INSTANCE.getSequence();
	        } else if (Set.class.isAssignableFrom(instanceClass)) {
	            return OCLStandardLibraryImpl.INSTANCE.getSet();
	        } else if (Collection.class.isAssignableFrom(instanceClass)) {
	            return OCLStandardLibraryImpl.INSTANCE.getCollection();
	        } else if (instanceClass == Object.class) {
	            return OCLStandardLibraryImpl.INSTANCE.getOclAny();
	        }
        }
        
        // All other data types map to themselves
        return dataType;
    }

    /**
     * Obtains the appropriate OCL type for an {@link EClassifier}, if it
     * corresponds to an OCL primitive type.
     * 
     * @param type the type to convert to an OCL type
     * @return the corresponding OCL type
     */ 
    EClassifier getOCLType(EClassifier type) {
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
    public EClassifier getOCLCollectionType(EClassifier type,
            boolean isOrdered, boolean isUnique) {
        EClassifier resultType = type;
    
        if (resultType instanceof EDataType) {
            resultType = getOCLTypeFor((EDataType) resultType);
        }
        
        OCLFactory oclFactory = OCLFactoryImpl.INSTANCE;
        
        if (isOrdered) {
            if (isUnique) {
                resultType = (EClassifier) oclFactory.createOrderedSetType(resultType);
            } else {
                resultType = (EClassifier) oclFactory.createSequenceType(resultType);
            }
        } else {
            if (isUnique) {
                resultType = (EClassifier) oclFactory.createSetType(resultType);
            } else {
                resultType = (EClassifier) oclFactory.createBagType(resultType);
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
    static boolean isMany(ETypedElement typedElement) {
        if (typedElement instanceof EStructuralFeature) {
            int upperBound = typedElement.getUpperBound();
            return (upperBound > 1) || (upperBound < 0);
        }
        
        return typedElement.isMany();
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
    
    public void setName(TypedElement<EClassifier> element, String name) {
    	element.setName(name);
    }
    
    public void setType(TypedElement<EClassifier> element, EClassifier type) {
    	element.setType(type);
    }

	public boolean setIsStatic(Object feature, boolean isStatic) {
		return false;
	}
}
