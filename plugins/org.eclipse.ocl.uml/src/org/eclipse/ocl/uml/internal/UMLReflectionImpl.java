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
 *   Zeligsoft - Bug 245897
 *	 E.D.Willink Bug 298128
 *
 * </copyright>
 *
 * $Id: UMLReflectionImpl.java,v 1.2 2010/02/08 20:57:13 ewillink Exp $
 */

package org.eclipse.ocl.uml.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.types.BagType;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.types.OrderedSetType;
import org.eclipse.ocl.types.PrimitiveType;
import org.eclipse.ocl.types.SequenceType;
import org.eclipse.ocl.types.SetType;
import org.eclipse.ocl.uml.UMLEnvironment;
import org.eclipse.ocl.uml.options.UMLParsingOptions;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.utilities.ExpressionInOCL;
import org.eclipse.ocl.utilities.OCLFactory;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.ocl.utilities.UMLReflectionWithOpposite;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Implementation of the UML reflection service for the UML environment.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class UMLReflectionImpl
    implements
    UMLReflection<Package, Classifier, Operation, Property, EnumerationLiteral, Parameter, State, CallOperationAction, SendSignalAction, Constraint>,
    UMLReflectionWithOpposite<Property> {

	private static Set<String> ECORE_INTEGER_TYPES = new java.util.HashSet<String>(
		Arrays.asList(EcorePackage.Literals.EINT.getName(),
			EcorePackage.Literals.EINTEGER_OBJECT.getName(),
			EcorePackage.Literals.ELONG.getName(),
			EcorePackage.Literals.ELONG_OBJECT.getName(),
			EcorePackage.Literals.ESHORT.getName(),
			EcorePackage.Literals.ESHORT_OBJECT.getName(),
			EcorePackage.Literals.EBIG_INTEGER.getName()));

	private static Set<String> ECORE_REAL_TYPES = new java.util.HashSet<String>(
		Arrays.asList(EcorePackage.Literals.EFLOAT.getName(),
			EcorePackage.Literals.EFLOAT_OBJECT.getName(),
			EcorePackage.Literals.EDOUBLE.getName(),
			EcorePackage.Literals.EDOUBLE_OBJECT.getName(),
			EcorePackage.Literals.EBIG_DECIMAL.getName()));

	private static Set<String> ECORE_BOOLEAN_TYPES = new java.util.HashSet<String>(
		Arrays.asList(EcorePackage.Literals.EBOOLEAN.getName(),
			EcorePackage.Literals.EBOOLEAN_OBJECT.getName()));
	
    private final UMLEnvironment env;
    
    public UMLReflectionImpl(UMLEnvironment env) {
        this.env = env;
    }
    
    final java.lang.Class<? extends Association> getAssociationClassType() {
        return env.getValue(UMLParsingOptions.ASSOCIATION_CLASS_TYPE);
    }
    
    /**
     * Default implementation just gets the name of the named element's
     * {@link org.eclipse.emf.ecore.EObject#eClass() metaclass} or, if it is a
     * {@link TypedElement}, the name of its type.
     */
    public String getDescription(Object namedElement) {
        if (namedElement instanceof TypedElement) {
            Type type = ((TypedElement) namedElement).getType();
            return (type == null) ? OCLStandardLibraryImpl.INSTANCE
                .getOclVoid().getName()
                : type.getName();
        } else if (namedElement instanceof EnumerationLiteral) {
            return ((EnumerationLiteral) namedElement).getEnumeration()
                .getName();
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
            ((NamedElement) namedElement).getQualifiedName() : null;
    }
    
    public Classifier getOCLType(Object metaElement) {
        Classifier result = null;
        
        if (metaElement instanceof TypedElement) {
            TypedElement typedElement = (TypedElement) metaElement;
            result = (Classifier) typedElement.getType();
            
            if (result == null) {
                // absence of a type in UML indicates void type
                result = OCLStandardLibraryImpl.INSTANCE.getOclVoid();
            }
            
            if (isMany(typedElement)) {
                result = getOCLCollectionType(
                        result,
                        isOrdered(typedElement),
                        isUnique(typedElement));
            } else {
                result = getOCLType(result);
            }
        } else if (metaElement instanceof Operation) {
            // Operations are not TypedElements!
            Operation operation = (Operation) metaElement;
            result = (Classifier) operation.getType();
            
            if (result == null) {
                // absence of a type in UML indicates void type
                result = OCLStandardLibraryImpl.INSTANCE.getOclVoid();
            }
            
            if (isMany(operation)) {
                result = getOCLCollectionType(
                        result,
                        isOrdered(operation),
                        isUnique(operation));
            } else {
                result = getOCLType(result);
            }
        } else if (metaElement instanceof Classifier) {
            result = getOCLType((Classifier) metaElement);
        }
        
        return result;
    }
    
    public boolean isMany(Object metaElement) {
        if (metaElement instanceof MultiplicityElement) {
            return ((MultiplicityElement) metaElement).isMultivalued();
        } else if (metaElement instanceof Operation) {
            int upper = ((Operation) metaElement).getUpper();
            return (upper > 1) || (upper < 0);
        }
        
        return false;
    }
    
    /**
     * Queries whether the specified {@link MultiplicityElement} or
     * {@link Operation} is unique.
     * 
     * @param metaElement a multiplicity-element or operation
     * @return whether it is unique
     */
    protected boolean isUnique(Object metaElement) {
        if (metaElement instanceof MultiplicityElement) {
            return ((MultiplicityElement) metaElement).isUnique();
        } else if (metaElement instanceof Operation) {
            return ((Operation) metaElement).isUnique();
        }
        
        return false;
    }
    
    /**
     * Queries whether the specified {@link MultiplicityElement} or
     * {@link Operation} is ordered.
     * 
     * @param metaElement a multiplicity-element or operation
     * @return whether it is ordered
     */
    protected boolean isOrdered(Object metaElement) {
        if (metaElement instanceof MultiplicityElement) {
            return ((MultiplicityElement) metaElement).isOrdered();
        } else if (metaElement instanceof Operation) {
            return ((Operation) metaElement).isOrdered();
        }
        
        return false;
    }
    
    public Classifier asOCLType(Classifier modelType) {
        return getOCLType(modelType);
    }
    
    public Package getNestingPackage(Package pkg) {
        return pkg.getNestingPackage();
    }
    
    public List<Package> getNestedPackages(Package pkg) {
        return pkg.getNestedPackages();
    }
    
    public Package getPackage(Classifier classifier) {
        return classifier.getNearestPackage();
    }
    
    public List<Classifier> getClassifiers(Package pkg) {
        EList<Type> types = pkg.getOwnedTypes();
        List<Classifier> result = new java.util.ArrayList<Classifier>(types.size());
        
        for (Type t : types) {
            if (t instanceof Classifier) {
                result.add((Classifier) t);
            }
        }
        
        return result;
    }
    
    public Classifier getOwningClassifier(Object feature) {
        Classifier result = null;
        
        if (feature instanceof Feature) {
            result = (Classifier) ((Feature) feature).getOwner();
        }
        
        if (result instanceof Class) {
            Classifier shadowed = OCLStandardLibraryImpl.getRealClassifier(
                (Class) result);
            
            if (shadowed != null) {
                result = shadowed;
            }
        }
        
        return result;
    }
    
    public List<Parameter> getParameters(Operation operation) {
        List<Parameter> result = new java.util.ArrayList<Parameter>(
                operation.getOwnedParameters().size());
        
        for (Parameter p : operation.getOwnedParameters()) {
            if (p.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
                result.add(p);
            }
        }
        
        return result;
    }
    
    public Operation createOperation(String name, Classifier resultType,
            List<String> paramNames, List<Classifier> paramTypes) {
        
        Operation result = UMLFactory.eINSTANCE.createOperation();
        result.setName(name);
        
        // OCL can only define query operations
        result.setIsQuery(true);
        
        if (resultType != null) {
            result.setType(resultType);
        }
        
        int i = 0;
        for (String pname : paramNames) {
            result.createOwnedParameter(pname, paramTypes.get(i++));
        }
        
        return result;
    }
    
    public List<Operation> getOperations(Classifier classifier) {
        return OCLUMLUtil.getAllOperations(classifier);
    }
    
    public Property getOpposite(Property property) {
    	return property.getOtherEnd();
    }
    
    public Property createProperty(String name, Classifier resultType) {
        Property result = UMLFactory.eINSTANCE.createProperty();
        
        result.setName(name);
        result.setType(resultType);
        
        return result;
    }
    
    public List<Property> getAttributes(Classifier classifier) {
        return OCLUMLUtil.getAllAttributes(classifier);
    }
    
    public Collection<? extends Classifier> getAllSupertypes(
            Classifier classifier) {
        
        return classifier.allParents();
    }
    
    public boolean isQuery(Operation operation) {
        return operation.isQuery();
    }
    
    public boolean isStatic(Object feature) {
        return (feature instanceof Feature) && ((Feature) feature).isStatic();
    }
    
    public boolean setIsStatic(Object feature, boolean isStatic) {
        if (!(feature instanceof Feature))
        	return false;
        ((Feature) feature).setIsStatic(isStatic);
        return true;
    }

    public boolean isAssociationClass(Classifier classifier) {
        return getAssociationClassType().isInstance(classifier);
    }
    
    public Classifier getAssociationClass(Property property) {
        return getAssociationClassType().isInstance(property.getAssociation())?
                property.getAssociation() : null;
    }
    
    public List<Property> getMemberEnds(Classifier associationClass) {
        if (getAssociationClassType().isInstance(associationClass)) {
            return ((Association) associationClass).getMemberEnds();
        }
        
        return Collections.emptyList();
    }

    public boolean isOperation(Object metaElement) {
        return metaElement instanceof Operation;
    }

	public boolean isPackage(Object metaElement) {
        return metaElement instanceof Package;
	}
    
    public boolean isProperty(Object metaElement) {
        return metaElement instanceof Property;
    }
    
    public boolean isClassifier(Object metaElement) {
        return metaElement instanceof Classifier;
    }
    
    public boolean isClass(Object metaElement) {
        return metaElement instanceof Class;
    }

	public boolean isConstraint(Object metaElement) {
        return metaElement instanceof Constraint;
	}
    
    public boolean isDataType(Object metaElement) {
        return metaElement instanceof DataType;
    }
    
    public boolean isStereotype(Classifier type) {
        return type instanceof Stereotype;
    }
    
    public Object getStereotypeApplication(Object baseElement,
            Classifier stereotype) {
        Object result = null;
        
        if (baseElement instanceof Element) {
            Element element = (Element) baseElement;
            Stereotype stereo = (Stereotype) stereotype;
            
            if (element.isStereotypeApplied(stereo)) {
                result = element.getStereotypeApplication(stereo);
            }
 
    		if (result == null) {
    			// maybe some specializing stereotype is applied?

				List<Stereotype> applied = element
					.getAppliedSubstereotypes(stereo);
				if (!applied.isEmpty()) {
					return element.getStereotypeApplication(applied.get(0));
				}
    		}
       }
        
        return result;
    }
    
    public boolean isEnumeration(Classifier type) {
        return type instanceof Enumeration;
    }

    public Classifier getEnumeration(EnumerationLiteral enumerationLiteral) {
        return enumerationLiteral.getEnumeration();
    }

    public List<EnumerationLiteral> getEnumerationLiterals(Classifier enumerationType) {
        return ((Enumeration) enumerationType).getOwnedLiterals();
    }
    
    public EnumerationLiteral getEnumerationLiteral(Classifier enumerationType,
            String literalName) {
        return ((Enumeration) enumerationType).getOwnedLiteral(literalName);
    }
    
    public boolean isComparable(Classifier type) {
        if ((type instanceof PrimitiveType<?>)
            || (type.getOperation("<", null, null) != null)) { //$NON-NLS-1$
            
            return true;
        }
        
        EClassifier eclassifier = env.getEClassifier(type, null);
        
        return (eclassifier != null)
            && Comparable.class.isAssignableFrom(eclassifier.getInstanceClass());
    }
    
    public Operation getOperation(CallOperationAction callOperationAction) {
        return callOperationAction.getOperation();
    }
    
    public Classifier getSignal(SendSignalAction sendSignalAction) {
        return sendSignalAction.getSignal();
    }
    
    public String getStereotype(Constraint constraint) {
        EList<String> keywords = constraint.getKeywords();
        return keywords.isEmpty()? null : keywords.get(0);
    }
    
    public void setStereotype(Constraint constraint, String stereotype) {
        // first, clear existing keywords (there wouldn't usually be any)
        for (String keyword : constraint.getKeywords()) {
            constraint.removeKeyword(keyword);
        }
        
        constraint.addKeyword(stereotype);
    }
    
    public String getConstraintName(Constraint constraint) {
        return constraint.getName();
    }
    
    public void setConstraintName(Constraint constraint, String name) {
        constraint.setName(name);
    }
    
    public ExpressionInOCL<Classifier, Parameter>
    getSpecification(Constraint constraint) {
        
        if (constraint.getSpecification() instanceof ExpressionInOCL<?, ?>) {
            return (org.eclipse.ocl.uml.ExpressionInOCL) constraint.getSpecification();
        }
        
        return null;
    }
    
    public void setSpecification(
            Constraint constraint,
            org.eclipse.ocl.utilities.ExpressionInOCL<Classifier, Parameter> specification) {
        
        constraint.setSpecification(
            (org.eclipse.ocl.uml.ExpressionInOCL) specification);
    }
    
    public Constraint getConstraint(
            ExpressionInOCL<Classifier, Parameter> specification) {
        EObject container = specification.eContainer();
        
        if (container instanceof Constraint) {
            return (Constraint) container;
        }
        
        return null;
    }
    
    public List<Element> getConstrainedElements(Constraint constraint) {
        return constraint.getConstrainedElements();
    }

	public void addConstrainedElement(Constraint constraint, EObject constrainedElement) {
		constraint.getConstrainedElements().add((Element) constrainedElement);
	}
    
    public List<Property> getQualifiers(Property property) {
        return property.getQualifiers();
    }

    public Classifier getCommonSuperType(Classifier type1, Classifier type2) {
    
        if (ObjectUtil.equal(type1, type2)) {
            return type2;
        }
        
        if (type1.conformsTo(type2)) {
            return type2;
        }
        if (type2.conformsTo(type1)) {
            return type1;
        }
        List<Classifier> type1Ancestors = new ArrayList<Classifier>(
                type1.allParents());
        
        List<Classifier> type2Ancestors = new ArrayList<Classifier>(
                type2.allParents());
        
        type1Ancestors.retainAll(type2Ancestors);
        if (!type1Ancestors.isEmpty()) {
            // the least common ancestor type will be the first, because UML
            //   computes the ancestors starting with the immediate parents
            return type1Ancestors.get(0);
        }
    
        return null;
    }

    public int getRelationship(Classifier type1, Classifier type2) {
        if (ObjectUtil.equal(type1, type2)) {
            return SAME_TYPE;
        }
        
        if (type2.conformsTo(type1)) {
            return STRICT_SUPERTYPE;
        } else if (type1.conformsTo(type2)) {
            return STRICT_SUBTYPE;
        } else if ((type2 instanceof BehavioredClassifier) && (type1 instanceof Interface)) {
            for (Interface i : ((BehavioredClassifier) type2).getAllImplementedInterfaces()) {
                if (i.conformsTo(type1)) {
                    return STRICT_SUPERTYPE;
                }
            }
        } else if ((type1 instanceof BehavioredClassifier) && (type2 instanceof Interface)) {
            for (Interface i : ((BehavioredClassifier) type1).getAllImplementedInterfaces()) {
                if (i.conformsTo(type2)) {
                    return STRICT_SUBTYPE;
                }
            }
        }
    
        return UNRELATED_TYPE;
    }

    /**
     * Translator from primitive UML types to OCL types
     * 
     * @param dataType a data type in the UML metamodel
     * @return the corresponding OCL classifier
     */
    private Classifier getOCLTypeFor(DataType dataType) {
    
        // First check if it is already an OCL data type (Enumerations represent
        //    themselves)
        if (dataType instanceof Enumeration) {
            return dataType;
        }
        if (dataType instanceof CollectionType<?, ?>) {
            return dataType;
        }
        if (dataType instanceof PrimitiveType<?>) {
            return dataType;
        }
    
        if (dataType instanceof org.eclipse.uml2.uml.PrimitiveType) {
            // Boolean -> OCL_BOOLEAN
            if (PrimitiveType.BOOLEAN_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getBoolean();
            } else if (PrimitiveType.REAL_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getReal();
            } else if (PrimitiveType.STRING_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getString();
            } else if (PrimitiveType.INTEGER_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getInteger();
            } else if (PrimitiveType.UNLIMITED_NATURAL_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getUnlimitedNatural();
            } else if (SequenceType.SINGLETON_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getSequence();
            } else if (SetType.SINGLETON_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getSet();
            } else if (BagType.SINGLETON_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getBag();
            } else if (OrderedSetType.SINGLETON_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getOrderedSet();
            } else if (CollectionType.SINGLETON_NAME.equals(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getCollection();
            } else if ("Object".equals(dataType.getName())) { //$NON-NLS-1$
                return OCLStandardLibraryImpl.INSTANCE.getOclAny();
            } else if (ECORE_INTEGER_TYPES.contains(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getInteger();
            } else if (ECORE_REAL_TYPES.contains(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getReal();
            } else if (ECORE_BOOLEAN_TYPES.contains(dataType.getName())) {
                return OCLStandardLibraryImpl.INSTANCE.getBoolean();
            } else if ("EString".equals(dataType.getName())) { //$NON-NLS-1$
                return OCLStandardLibraryImpl.INSTANCE.getString();
            }
        }
        
        // All other data types map to themselves
        return dataType;
    }

    /**
     * Obtains the appropriate OCL type for a {@link Classifier}, if it
     * corresponds to an OCL primitive type.
     * 
     * @param type the type to convert to an OCL type
     * @return the corresponding OCL type
     */ 
    Classifier getOCLType(Classifier type) {
        Classifier resultType = type;
    
        if (resultType instanceof DataType) {
            resultType = getOCLTypeFor((DataType) resultType);
        }
        
        return resultType;
    }

    /**
     * Obtains the appropriate OCL collection type for a {@link Classifier}, 
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
     * @see #getOCLType(Classifier)
     */ 
    Classifier getOCLCollectionType(Classifier type,
            boolean isOrdered, boolean isUnique) {
        Classifier resultType = type;
    
        if (resultType instanceof DataType) {
            resultType = getOCLTypeFor((DataType) resultType);
        }
        
        OCLFactory oclFactory = OCLFactoryImpl.INSTANCE;
        
        if (isOrdered) {
            if (isUnique) {
                resultType = (Classifier) oclFactory.createOrderedSetType(resultType);
            } else {
                resultType = (Classifier) oclFactory.createSequenceType(resultType);
            }
        } else {
            if (isUnique) {
                resultType = (Classifier) oclFactory.createSetType(resultType);
            } else {
                resultType = (Classifier) oclFactory.createBagType(resultType);
            }
        }
        
        return resultType;
    }

    public List<Classifier> getSignals(Classifier owner) {
        if (owner instanceof Class) {
            List<Reception> receptions = OCLUMLUtil.getAllReceptions((Class) owner);
            
            if (!receptions.isEmpty()) {
                List<Classifier> result = new java.util.ArrayList<Classifier>(
                        receptions.size());
                
                for (Reception r : receptions) {
                    if (r.getSignal() != null) {
                        result.add(r.getSignal());
                    }
                }
                
                return result;
            }
        }
        
        return Collections.emptyList();
    }

    public CallOperationAction createCallOperationAction(Operation operation) {
        CallOperationAction result = UMLFactory.eINSTANCE.createCallOperationAction();
        result.setOperation(operation);
        return result;
    }

    public SendSignalAction createSendSignalAction(Classifier signal) {
        SendSignalAction result = UMLFactory.eINSTANCE.createSendSignalAction();
        result.setSignal((Signal) signal);
        return result;
    }

    public Constraint createConstraint() {
        return UMLFactory.eINSTANCE.createConstraint();
    }

    public ExpressionInOCL<Classifier, Parameter> createExpressionInOCL() {
        return org.eclipse.ocl.uml.UMLFactory.eINSTANCE.createExpressionInOCL();
    }
    
    public void setName(
    		org.eclipse.ocl.utilities.TypedElement<Classifier> element,
    		String name) {
    	element.setName(name);
    }
    
    public void setType(
    		org.eclipse.ocl.utilities.TypedElement<Classifier> element,
    		Classifier type) {
    	element.setType(type);
    }
}
