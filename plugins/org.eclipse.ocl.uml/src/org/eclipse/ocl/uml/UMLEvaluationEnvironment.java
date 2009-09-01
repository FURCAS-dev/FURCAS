/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 247079
 *   Bas Elzinga - Bug 259630
 *
 * </copyright>
 *
 * $Id: UMLEvaluationEnvironment.java,v 1.16 2009/09/01 20:11:00 ewillink Exp $
 */

package org.eclipse.ocl.uml;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.AbstractEvaluationEnvironment;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.LazyExtentMap;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.TupleType;
import org.eclipse.ocl.uml.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.uml.options.EvaluationMode;
import org.eclipse.ocl.uml.options.UMLEvaluationOptions;
import org.eclipse.ocl.uml.util.OCLUMLUtil;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.utilities.PredefinedType;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Implementation of the {@link EvaluationEnvironment} for evaluation of OCL
 * expressions on instances of UML models (i.e., on M0 models).
 * 
 * @author Christian W. Damus (cdamus)
 */
public class UMLEvaluationEnvironment
    extends
    AbstractEvaluationEnvironment<Classifier, Operation, Property, Class, EObject>
	implements EvaluationEnvironment.Enumerations<EnumerationLiteral> {
    
    private static final EPackage CACHE_MISS = EcoreFactory.eINSTANCE
        .createEPackage();

    private final EPackage.Registry registry;

    // cache of UML to Ecore package mappings
    private final Map<Package, EPackage> packageMap = new java.util.HashMap<Package, EPackage>();

    private final Map<Feature, String> featureNameMap = new java.util.HashMap<Feature, String>();
    
    private final UMLEnvironmentFactory factory;

    private ValueExtractor valueExtractor;
    
    /**
     * Initializes me.
     */
    public UMLEvaluationEnvironment(UMLEnvironmentFactory factory) {
        this.factory = factory;
        this.registry = factory.getEPackageRegistry();
    }

    /**
     * Initializes me with my parent evaluation environment (nesting scope).
     * 
     * @param parent
     *            my parent (nesting scope); must not be <code>null</code>
     */
    public UMLEvaluationEnvironment(
            EvaluationEnvironment<Classifier, Operation, Property, Class, EObject> parent) {
        super(parent);

        UMLEvaluationEnvironment umlParent = (UMLEvaluationEnvironment) getParent();

        this.factory = umlParent.factory;
        this.registry = umlParent.getEPackageRegistry();
    }

    /**
     * Obtains my package registry for looking up the Ecore definitions of UML
     * packages.
     * 
     * @return my package registry
     */
    protected final EPackage.Registry getEPackageRegistry() {
        return registry;
    }
    
    /**
     * Queries my effective evaluation mode which is just my assigned mode,
     * unless I am {@link EvaluationMode#ADAPTIVE}.  In that case, I derive an
     * effective evaluation mode from my <tt>self</tt> context variable.
     * <p>
     * <b>Note</b> that my effective evaluation mode is inherited from my parent
     * evaluation environment, if I have one.
     * </p>
     * 
     * @return my effective evaluation mode
     * 
     * @see #getParent()
     * @see #getEffectiveEvaluationMode(Object)
     * 
     * @since 1.2
     */
    protected EvaluationMode getEffectiveEvaluationMode() {
        return getEffectiveEvaluationMode(getValueOf(Environment.SELF_VARIABLE_NAME));
    }
    
    /**
     * Queries my effective evaluation mode which is just my assigned mode,
     * unless I am {@link EvaluationMode#ADAPTIVE}.  In that case, I derive an
     * effective evaluation mode from the specified <tt>context</tt> object.
     * <p>
     * <b>Note</b> that my effective evaluation mode is inherited from my parent
     * evaluation environment, if I have one.
     * </p>
     * 
     * @return a context object
     * @return my effective evaluation mode
     * 
     * @see #getParent()
     * 
     * @since 1.2
     */
    protected EvaluationMode getEffectiveEvaluationMode(Object context) {
        EvaluationMode result = getValue(UMLEvaluationOptions.EVALUATION_MODE);
        
        if (result == EvaluationMode.ADAPTIVE) {
            if (context instanceof InstanceSpecification) {
                result = EvaluationMode.INSTANCE_MODEL;
            } else {
                result = EvaluationMode.RUNTIME_OBJECTS;
            }
        }
        
        return result;
    }
    
    @Override
    public Object callOperation(Operation operation, int opcode, Object source,
            Object[] args)
        throws IllegalArgumentException {

        // TODO: WBN to pull up createValue to the superclass as a pass-thru
        // so that subclasses don't have to override callOperation
        return coerceValue(operation, super.callOperation(operation, opcode,
            source, args), true);
    }

    // implements the inherited specification
    @Override
    protected Method getJavaMethodFor(Operation operation, Object receiver) {
        Method result = null;
        
        String operName = getEcoreOperationName(operation);

        // in the case of infix operators, we need to replace the name with
        // a valid Java name. We will choose the legacy OCL parser names
        // which some clients already depend on
        int opcode = OCLStandardLibraryUtil.getOperationCode(operName);
        switch (opcode) {
            case PredefinedType.PLUS:
                operName = "plus"; //$NON-NLS-1$
                break;
            case PredefinedType.MINUS:
                operName = "minus"; //$NON-NLS-1$
                break;
            case PredefinedType.TIMES:
                operName = "times"; //$NON-NLS-1$
                break;
            case PredefinedType.DIVIDE:
                operName = "divide"; //$NON-NLS-1$
                break;
            case PredefinedType.LESS_THAN:
                operName = "lessThan"; //$NON-NLS-1$
                break;
            case PredefinedType.LESS_THAN_EQUAL:
                operName = "lessThanEqual"; //$NON-NLS-1$
                break;
            case PredefinedType.GREATER_THAN:
                operName = "greaterThan"; //$NON-NLS-1$
                break;
            case PredefinedType.GREATER_THAN_EQUAL:
                operName = "greaterThanEqual"; //$NON-NLS-1$
                break;
        }

        // get containing class for the operation
        Classifier container = (Classifier) operation.getOwner();

        // get the corresponding Ecore classifier
        EClassifier eclassifier = getEClassifier(container, receiver);

        // get the corresponding java instance class
        java.lang.Class<?> containerClass = eclassifier.getInstanceClass();

        // get the parameter types as java classes
        EList<Parameter> parms = operation.getOwnedParameters();
        EList<java.lang.Class<?>> javaParms = new BasicEList<java.lang.Class<?>>(
            parms.size());
        for (int i = 0, n = parms.size(); i < n; i++) {
            Parameter parm = parms.get(i);

            if (parm.getDirection() != ParameterDirectionKind.RETURN_LITERAL) {
                if (parm.isMultivalued()) {
                    javaParms.add(EList.class); // TODO: EList could be
                    // suppressed
                } else {
                    eclassifier = getEClassifier((Classifier) parm.getType(),
                        receiver);
                    javaParms.add(eclassifier.getInstanceClass());
                }
            }
        }

        // lookup the method on the java class
        try {
            result = containerClass.getMethod(operName, javaParms
                .toArray(new java.lang.Class<?>[javaParms.size()]));
        } catch (NoSuchMethodException e) {
            // do nothing
        }

        return result;
    }

    /**
     * Gets the name of the specified operation, accounting for the possibility
     * that it is aliased using an Ecore stereotype.  The resulting name is
     * cached for fast repeated access.
     * 
     * @param operation an operation
     * @return the name of the corresponding Ecore operation
     */
    private String getEcoreOperationName(Operation operation) {
        String result = featureNameMap.get(operation);
        
        if (result == null) {
            result = operation.getName();
            
            Stereotype stereo = getAppliedEcoreStereotype(operation,
                UMLUtil.STEREOTYPE__E_OPERATION);
            if (stereo != null) {
                // look for an <<eOperation>> alias name
                String alias = (String) operation.getValue(stereo,
                    UMLUtil.TAG_DEFINITION__OPERATION_NAME);
                if ((alias != null) && (alias.length() > 0)) {
                    result = alias;
                }
            }
            
            featureNameMap.put(operation, result);
        }
        
        return result;
    }
    
    private Stereotype getAppliedEcoreStereotype(Element element,
            String name) {
        return element.getAppliedStereotype("Ecore" //$NON-NLS-1$
            + NamedElement.SEPARATOR + name);
    }

    // implements the inherited specification
    @Override
    protected Object getInvalidResult() {
        return OCLStandardLibraryImpl.INVALID;
    }

    // implements the inherited specification
    public Object navigateProperty(Property property, List<?> qualifiers,
            Object source)
        throws IllegalArgumentException {

        switch (getEffectiveEvaluationMode()) {
        case INSTANCE_MODEL:
            InstanceSpecification instance = (InstanceSpecification) source;

            // in the case that the association owns the property and the
            // source is an instance of that association, then we are navigating
            // an end from the association, itself, so this is not a
            // non-navigable property scenario
            Association association = property.getOwningAssociation();
            if ((association != null) && !isInstance(association, instance)) {
                // non-navigable property. Qualifiers don't apply
                return navigateNonNavigableProperty(property, association,
                    instance);
            }

            // TODO: In case there is no slot, look for an init constraint
            // and a default value, in that order
            for (Slot slot : instance.getSlots()) {
                if (slot.getDefiningFeature() == property) {
                    if (!qualifiers.isEmpty()) {
                        return findValueQualifiedBy(instance, property,
                            qualifiers);
                    }

                    return getValue(slot);
                }
            }

            // look for a slot on a property that redefines the property
            // we are looking for
            for (Slot slot : instance.getSlots()) {
                if (redefines(slot.getDefiningFeature(), property)) {
                    if (!qualifiers.isEmpty()) {
                        return findValueQualifiedBy(instance, property,
                            qualifiers);
                    }

                    return getValue(slot);
                }
            }

            // an instance needs not have a slot for every feature
            return isMultivaluedSlot(instance, property) ? CollectionUtil
                .createNewCollection(getCollectionKind(property))
                : null;
        case RUNTIME_OBJECTS:
        	if (source instanceof EObject) {
	            // TODO: In case the property is unset, look for an init constraint
	            // and a default value, in that order
	            EObject esource = (EObject) source;
	
	            EStructuralFeature feature = esource.eClass()
	                .getEStructuralFeature(getEcoreAttributeName(property));
	
	            if (feature != null) {
	                Object result = esource.eGet(feature);
	
	                return coerceValue(property, result, true);
	            } else {
	                // must be a non-navigable property?
	                Property otherEnd = property.getOtherEnd();
	                if (otherEnd != null) {
	                    EClass eclass = null;
	                    
	                    Element owner = otherEnd.getOwner();
	                    if ((owner instanceof Classifier) && (owner != otherEnd.getAssociation())) {
	                        eclass = (EClass) OCLUMLUtil.getEClassifier(
	                            (Classifier) owner, source, registry);
	                    }
	
	                    if (eclass != null) {
	                        EStructuralFeature eEnd = eclass
	                            .getEStructuralFeature(getEcoreAttributeName(otherEnd));
	
	                        if (eEnd != null) {
	                            Collection<Object> result = createCollection(property);
	
	                            // maybe eEnd is a containment reference
	                            if (esource.eContainmentFeature() == eEnd) {
	                                result.add(esource.eContainer());
	                            } else {
	                                for (EStructuralFeature.Setting setting : UML2Util
	                                    .getNonNavigableInverseReferences(esource)) {
	                                    if (setting.getEStructuralFeature() == eEnd) {
	                                        result.add(setting.getEObject());
	                                    }
	                                }
	                            }
	                            
	                            return coerceValue(property, result, false);
	                        }
	                    }
	                }
	            }
        	} else if (source instanceof Tuple<?, ?>) {
        		@SuppressWarnings("unchecked")
        		Tuple<Operation, Property> tuple = (Tuple<Operation, Property>) source;
        		
        		if (tuple.getTupleType().oclProperties().contains(property)) {
        			return tuple.getValue(property);
        		}
        	}
        }

        throw new IllegalArgumentException(
            "no such property: " + property.getName()); //$NON-NLS-1$
    }

    /**
     * Gets the name of the specified attribute, accounting for the possibility
     * that it is aliased using an Ecore stereotype.  The resulting name is
     * cached for fast repeated access.
     * 
     * @param attribute an attribute
     * @return the name of the corresponding Ecore attribute
     */
    private String getEcoreAttributeName(Property attribute) {
        String result = featureNameMap.get(attribute);
        
        if (result == null) {
            Stereotype stereo = getAppliedEcoreStereotype(attribute,
                UMLUtil.STEREOTYPE__E_ATTRIBUTE);
            String aliasAttribute = UMLUtil.TAG_DEFINITION__ATTRIBUTE_NAME;
            if (stereo == null) {
                stereo = getAppliedEcoreStereotype(attribute,
                    UMLUtil.STEREOTYPE__E_REFERENCE);
                aliasAttribute = UMLUtil.TAG_DEFINITION__REFERENCE_NAME;
            }
            if (stereo != null) {
                // look for an <<eAttribute>> or <<eReference>> alias name
                String alias = (String) attribute.getValue(stereo,
                    aliasAttribute);
                if ((alias != null) && (alias.length() > 0)) {
                    result = alias;
                }
            }
            
            if (result == null) {
                result = UMLUtil.getValidJavaIdentifier(attribute.getName());
            }
            
            featureNameMap.put(attribute, result);
        }
        
        return result;
    }
    
    /**
     * Obtains the collection kind appropriate for representing the values of
     * the specified feature.
     * 
     * @param feature
     *            a feature
     * 
     * @return the collection kind appropriate to the multiplicity, orderedness,
     *         and uniqueness of the feature, or <code>null</code> if it is
     *         not many
     */
    private static CollectionKind getCollectionKind(Feature feature) {
        MultiplicityElement element = null;

        if (feature instanceof MultiplicityElement) {
            element = (MultiplicityElement) feature;
        } else if (feature instanceof Operation) {
            element = ((Operation) feature).getReturnResult();
        }

        if (element != null) {
            return element.isMultivalued() ? CollectionKind.getKind(element
                .isOrdered(), element.isUnique())
                : null;
        }

        return null; // void operation is implicitly scalar
    }

    /**
     * Creates a collection value for the specified feature. The collection type
     * is arbitrary if the feature is not multi-valued (but in a context where a
     * collection is needed for computation).
     * 
     * @param feature
     *            a feature (property, operation, etc.)
     * @return a collection to store its value
     */
    private Collection<Object> createCollection(Feature feature) {
        CollectionKind kind = getCollectionKind(feature);

        if (kind != null) {
            return CollectionUtil.createNewCollection(kind);
        } else {
            // doesn't matter the collection type
            return new BasicEList.FastCompare<Object>();
        }
    }

    /**
     * Coerces the value of the specified feature into the appropriate
     * representation, derived from the supplied <code>value</code> template.
     * The <code>value</code> is coerced to the appropriate collection kind
     * for this feature (or scalar if not multi-valued). The original value may
     * either be used as is where possible or, optionally, copied into the new
     * collection (if multi-valued).
     * 
     * @param feature
     *            a feature (property, operation, etc.)
     * @param value
     *            the computed value of the property
     * @param copy
     *            whether to copy the specified value into the resulting
     *            collection/scalar value
     * 
     * @return the value, in the appropriate OCL collection type or scalar form
     *         as required
     * 
     * @see #getCollectionKind(Feature)
     */
    private Object coerceValue(Feature feature, Object value, boolean copy) {
        CollectionKind kind = getCollectionKind(feature);

        if (kind != null) {
            if (value instanceof Collection<?>) {
                return copy ? CollectionUtil.createNewCollection(kind,
                    (Collection<?>) value)
                    : value;
            } else {
                Collection<Object> result = CollectionUtil
                    .createNewCollection(kind);
                result.add(value);
                return result;
            }
        } else {
            if (value instanceof Collection<?>) {
                Collection<?> collection = (Collection<?>) value;
                return collection.isEmpty() ? null
                    : collection.iterator().next();
            } else {
                return value;
            }
        }
    }

    /**
     * Navigates a non-navigable property in an instance specification context.
     * 
     * @param property
     *            the non-navigable property to navigate
     * @param association
     *            the association of which the property is a member
     * @param instance
     *            the instance specification from which we are navigating the
     *            property
     * 
     * @return the property value
     */
    private Object navigateNonNavigableProperty(Property property,
            Association association, InstanceSpecification instance) {
        Collection<InstanceSpecification> result = CollectionUtil
            .createNewSet();

        Property otherEnd = property.getOtherEnd();

        for (Slot slot : getSlotsReferencing(instance)) {
            // TODO: Handle redefinition of the other end
            if (slot.getDefiningFeature() == otherEnd) {
                InstanceSpecification referencer = slot.getOwningInstance();

                if (referencer != null) {
                    if (isInstance(association, referencer)) {
                        // get value of the other end. Multiplicity of an
                        // association end is always 1 from the association's
                        // perspective
                        Slot otherSlot = getSlot(referencer, property);
                        if (otherSlot != null) {
                            ValueSpecification value = otherSlot.getValues()
                                .isEmpty() ? null
                                : otherSlot.getValues().get(0);
                            if ((value != null)
                                && (value instanceof InstanceValue)) {
                                result.add(((InstanceValue) value)
                                    .getInstance());
                            }
                        }
                    } else {
                        // navigable opposite
                        result.add(referencer);
                    }
                }
            }
        }

        return coerceValue(property, result, true);
    }

    /**
     * Queries whether the specified property redefines (recursively) another
     * property.
     * 
     * @param feature
     *            a property
     * @param redefined
     *            a property that (we hope) it redefines
     * 
     * @return <code>true</code> if the feature redefines the redefined
     *         property (or some property that, recursively, redefines it);
     *         <code>false</code>, otherwise
     */
    private boolean redefines(StructuralFeature feature, Property redefined) {
        if (feature == redefined) {
            // base case
            return true;
        }

        if (feature instanceof Property) {
            Property property = (Property) feature;

            for (Property next : property.getRedefinedProperties()) {
                if (redefines(next, redefined)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Gets the Java value in an instance's slot.
     * 
     * @param slot
     *            a slot
     * @return the value in the slot, as a Java object (not a
     *         {@link ValueSpecification})
     */
    private Object getValue(Slot slot) {
        List<ValueSpecification> values = slot.getValues();

        if (isMultivaluedSlot(slot)) {
            StructuralFeature feature = slot.getDefiningFeature();

            // create a collection of the kind appropriate to the feature.
            // If the feature is ordered, then the order of the values in
            // the slot is preserved
            return getValueExtractor()
                .extractValues(
                    values,
                    CollectionKind.getKind(feature.isOrdered(), feature
                        .isUnique()));
        } else {
            return values.isEmpty() ? null
                : getValueExtractor().extractValue(values.get(0));
        }
    }

    /**
     * Queries whether an instance's slot is multivalued. This depends on the
     * owner, because a member-end slot of an association class link has
     * multiplicity 1 regardless of the multiplicity of the slot's defining
     * property.
     * 
     * @param slot
     *            a slot
     * @return whether the slot is multi-valued from the perspective of its
     *         owner's type
     */
    private boolean isMultivaluedSlot(Slot slot) {
        return isMultivaluedSlot(slot.getOwningInstance(), (Property) slot
            .getDefiningFeature());
    }

    private boolean isMultivaluedSlot(InstanceSpecification owner,
            Property property) {
        Classifier classifier = owner.getClassifiers().isEmpty() ? null
            : owner.getClassifiers().get(0);

        if (classifier instanceof Association) {
            return (property.getAssociation() != classifier)
                && property.isMultivalued();
        }

        return property.isMultivalued();
    }

    private ValueExtractor getValueExtractor() {
        if (valueExtractor == null) {
            valueExtractor = new ValueExtractor();
        }

        return valueExtractor;
    }

    Object findValueQualifiedBy(InstanceSpecification source,
            Property property, List<?> qualifiers) {
        // from amongst the links referencing this source instance, find the
        // one that has the specified qualifier values and get its value for
        // the property
        Association association = property.getAssociation();
        Property otherEnd = property.getOtherEnd();

        for (EStructuralFeature.Setting setting : UML2Util
            .getNonNavigableInverseReferences(source)) {

            if (setting.getEStructuralFeature() == UMLPackage.Literals.INSTANCE_VALUE__INSTANCE) {

                InstanceValue value = (InstanceValue) setting.getEObject();
                if (value.getOwner() instanceof Slot) {
                    Slot slot = (Slot) value.getOwner();

                    // TODO: Account for redefinition of the member ends
                    if (slot.getDefiningFeature() == otherEnd) {
                        InstanceSpecification link = slot.getOwningInstance();

                        for (Classifier c : link.getClassifiers()) {
                            if (c.conformsTo(association)) {
                                // found a link instance of this association.
                                // Look for the qualifier values
                                if (match(link, property.getQualifiers(),
                                    qualifiers)) {
                                    // get the property value for this link
                                    return navigateProperty(property,
                                        Collections.emptyList(), link);
                                }

                            }
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * Queries whether the specified <code>instance</code> has slots for the
     * given <code>properties</code> that have these <code>values</code>.
     * 
     * @param instance
     *            an instance specification
     * @param properties
     *            a list of properties
     * @param values
     *            values to look for in the slots of the instance defined by the
     *            given properties
     * 
     * @return <code>true</code> if this instance has the matching property
     *         values; <code>false</code>, otherwise
     */
    private boolean match(InstanceSpecification instance,
            List<Property> properties, List<?> values) {

        int found = 0;

        for (Slot slot : instance.getSlots()) {
            int index = properties.indexOf(slot.getDefiningFeature());

            if (index >= 0) {
                Object actualValue = getValue(slot);

                if (UML2Util.safeEquals(actualValue, values.get(index))) {
                    found++;
                }
            }
        }

        return found == properties.size();
    }

    // implements the inherited specification
    public Object navigateAssociationClass(Classifier associationClass,
            Property navigationSource, Object source)
        throws IllegalArgumentException {

        switch (getEffectiveEvaluationMode()) {
        case INSTANCE_MODEL:
            InstanceSpecification sourceInstance = (InstanceSpecification) source;

            Collection<Property> ends;
            if (navigationSource != null) {
                // qualified navigation: select the links belonging to the
                // the navigation source, i.e., where the opposite of the
                // navigation source references the source instance
                ends = Collections.singleton(navigationSource.getOtherEnd());
            } else {
                // unqualified navigation: select links where either end is
                // the navigation source
                ends = ((AssociationClass) associationClass).getMemberEnds();
            }

            // find link instances of this association class that have a slot
            // referencing the source instance
            Collection<InstanceSpecification> links = CollectionUtil
                .createNewSet();

            for (Slot slot : getSlotsReferencing(sourceInstance)) {
                // only consider slots that are defined by association
                // ends, because the association class may have other
                // properties that can reference our source instance
                // TODO: Account for redefinition of the member ends
                if (ends.contains(slot.getDefiningFeature())) {
                    InstanceSpecification link = slot.getOwningInstance();

                    if (isInstance(associationClass, link)) {
                        // found a link!
                        links.add(link);
                    }
                }
            }

            // these association class instances are the answer. If we know the
            // navigation source and it is not many, then do not return a
            // collection value
            if ((navigationSource != null) && !navigationSource.isMultivalued()) {
                return links.isEmpty() ? null
                    : links.iterator().next();
            }

            return links;
        case RUNTIME_OBJECTS:
            // UML-to-Ecore conversion does not support association classes.
            // Fall through
        }

        throw new IllegalArgumentException(
            "no such association class: " + associationClass.getName()); //$NON-NLS-1$
    }

    private boolean isInstance(Classifier classifier,
            InstanceSpecification instance) {
        for (Classifier c : instance.getClassifiers()) {
            if (c.conformsTo(classifier)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Finds the slot defined by the specified property in a given instance
     * specification.
     * 
     * @param instance
     *            an instance specification
     * @param property
     *            a property of (one of) the instance's classifier(s)
     * 
     * @return the instance's slot for this property, or <code>null</code> if
     *         no such slot is defined
     */
    private Slot getSlot(InstanceSpecification instance, Property property) {
        for (Slot slot : instance.getSlots()) {
            // TODO: Account for property redefinition
            if (slot.getDefiningFeature() == property) {
                return slot;
            }
        }

        return null;
    }

    /**
     * Performs a reverse-reference lookup for slots that have
     * <code>InstanceValue</code>s referencing the specified instance
     * specification.
     * 
     * @param instance
     *            an instance specification
     * @return the slots referencing it (or an empty collection if none)
     */
    private Collection<Slot> getSlotsReferencing(InstanceSpecification instance) {
        Collection<Slot> result = CollectionUtil.createNewSet();

        for (EStructuralFeature.Setting setting : UML2Util
            .getNonNavigableInverseReferences(instance)) {
            if (setting.getEStructuralFeature() == UMLPackage.Literals.INSTANCE_VALUE__INSTANCE) {
                InstanceValue value = (InstanceValue) setting.getEObject();
                if (value.getOwner() instanceof Slot) {
                    result.add((Slot) value.getOwner());
                }
            }
        }

        return result;
    }

    // implements the inherited specification
    public Tuple<Operation, Property> createTuple(Classifier type,
            Map<Property, Object> values) {

        @SuppressWarnings("unchecked")
        TupleType<Operation, Property> tupleType = (TupleType<Operation, Property>) type;

        return new TupleImpl(tupleType, values);
    }

    // implements the inherited specification
    public Map<Class, Set<EObject>> createExtentMap(Object object) {
        if (object instanceof EObject) { // covers both run-time EObjects and model InstanceSpecifications
            switch (getEffectiveEvaluationMode(object)) {
            case INSTANCE_MODEL:
                return new LazyExtentMap<Class, EObject>((EObject) object) {
    
                    // implements the inherited specification
                    @Override
                    protected boolean isInstance(Class cls, EObject element) {
                        boolean result = false;
    
                        if (element instanceof InstanceSpecification) {
                            EList<Classifier> classifiers = ((InstanceSpecification) element)
                                .getClassifiers();
    
                            for (Classifier c : classifiers) {
                                if (c.conformsTo(cls)) {
                                    result = true;
                                    break;
                                }
                            }
                        }
    
                        return result;
                    }
                };
            case RUNTIME_OBJECTS:
                return new LazyExtentMap<Class, EObject>((EObject) object) {
    
                    // implements the inherited specification
                    @Override
                    protected boolean isInstance(Class cls, EObject element) {
                        EClassifier eclass = getEClassifier(cls, element);
    
                        return (eclass != null) && eclass.isInstance(element);
                    }
                };
            }
        }
        
        return Collections.emptyMap();
    }

    // implements the inherited specification
    public boolean isKindOf(Object object, Classifier classifier) {
        switch (getEffectiveEvaluationMode()) {
        case INSTANCE_MODEL:
            if (object instanceof ValueSpecification) {
                ValueSpecification value = (ValueSpecification) object;
    
                if (value.getType() != null) {
                    Classifier type = (Classifier) value.getType();
    
                    // special case for Integer/UnlimitedNatural and Real
                    // which are not related types in java but are in OCL
                    if ((type == OCLStandardLibraryImpl.INSTANCE.getInteger())
                        && (classifier == OCLStandardLibraryImpl.INSTANCE.getReal())) {
                        return true;
                    }
    
                    return type.conformsTo(classifier);
                }
            } else if (object instanceof InstanceSpecification) {
                InstanceSpecification instance = (InstanceSpecification) object;
    
                for (Classifier c : instance.getClassifiers()) {
                    if (c.conformsTo(classifier)) {
                        return true;
                    }
                }
            }
            break;
        case RUNTIME_OBJECTS:
            if (object instanceof EObject) {
                // special case for Integer/UnlimitedNatural and Real
                // which are not related types in java but are in OCL
                EClassifier eclassifier = getEClassifier(classifier, object);
    
                if (eclassifier == null) {
                    return false;
                }
    
                if ((object.getClass() == Integer.class)
                    && (eclassifier.getInstanceClass() == Double.class)) {
                    return Boolean.TRUE;
                }
    
                return eclassifier.isInstance(object);
            }
            break;
        }
        
        return false;
    }

    // implements the inherited specification
    public boolean isTypeOf(Object object, Classifier classifier) {
        switch (getEffectiveEvaluationMode()) {
        case INSTANCE_MODEL:
            if (object instanceof ValueSpecification) {
                ValueSpecification value = (ValueSpecification) object;
    
                return value.getType() == classifier;
            } else if (object instanceof InstanceSpecification) {
                return ((InstanceSpecification) object).getClassifiers().contains(
                    classifier);
            }
            break;
        case RUNTIME_OBJECTS:
            if (object instanceof EObject) {
                EClassifier eclassifier = getEClassifier(classifier, object);
    
                if (eclassifier == null) {
                    return false;
                }
    
                if ((eclassifier instanceof EClass) && (object instanceof EObject)) {
                    return ((EObject) object).eClass() == eclassifier;
                } else if (!(object instanceof EObject)
                    && !(eclassifier instanceof EClass)) {
                    return object.getClass() == eclassifier.getInstanceClass();
                }
            }
            break;
        }

        return false;
    }

    public Classifier getType(Object object) {
        return factory.getClassifier(object);
    }

    /**
     * Looks up the Ecore definition of the specified UML package.
     * 
     * @param pkg
     *            a UML package
     * @return its Ecore definition, or <code>null</code> if not found
     */
    protected EPackage getEPackage(Package pkg) {
        EPackage result = packageMap.get(pkg);

        if (result == null) {
            result = OCLUMLUtil.getEPackage(pkg, registry);

            if (result == null) {
                result = CACHE_MISS;
            }

            packageMap.put(pkg, result);
        }

        return (result == CACHE_MISS) ? null
            : result;
    }

    /**
     * Looks up the Ecore definition of the specified UML classifier, using the
     * specified <code>element</code> as a context for finding profile
     * applications in the case that the classifier is a stereotype or some
     * other type in a {@link Profile}. Finding the Ecore definition of a
     * profile type requires finding the actual applied version of the profile.
     * 
     * @param umlClassifier
     *            a UML classifier
     * @param element
     *            an element in the context of which the OCL evaluation is being
     *            performed
     * @return the corresponding Ecore classifier, or <code>null</code> if not
     *         found
     */
    protected EClassifier getEClassifier(Classifier umlClassifier,
            Object element) {
        EClassifier result = null;
        Package umlPackage = umlClassifier.getPackage();
        EPackage ecorePackage = null;

        if (umlPackage instanceof Profile) {
            // use the element to get the most appropriate profile definition
            Profile profile = (Profile) umlPackage;

            if (element instanceof Element) {
                Element umlElement = (Element) element;

                Package nesting = umlElement.getNearestPackage();
                while (nesting != null) {
                    ProfileApplication appl = nesting
                        .getProfileApplication(profile);
                    if (appl != null) {
                        ecorePackage = appl.getAppliedDefinition();
                        break;
                    }

					nesting = (nesting.getOwner() == null)
						? null
						: nesting.getOwner().getNearestPackage();
                }
            }

            if (ecorePackage == null) {
                // assume the latest definition of the profile (if any)
                ecorePackage = profile.getDefinition();
            }
        } else if (umlPackage != null) {
            ecorePackage = getEPackage(umlPackage);
        }

        if (ecorePackage != null) {
            result = ecorePackage.getEClassifier(UML2Util
                .getValidJavaIdentifier(umlClassifier.getName()));
        }

        return result;
    }
    
    /**
     * Implements the interface by finding the corresponding <tt>Enumerator</tt>
     * value in a generated (or dynamic) EMF implementation, else the same
     * enumeration literal (supporting the instance-specification model case).
     * 
     * @since 1.2
     */
    public Object getValue(EnumerationLiteral enumerationLiteral) {
        if (getEffectiveEvaluationMode() == EvaluationMode.RUNTIME_OBJECTS) {
            Object context = getValueOf(Environment.SELF_VARIABLE_NAME);
            
            // if we're in an instance-specification world (model of instances)
            // then we use the models of enumeration literals (M1 level), not
            // the run-time instances (M0 level)
            Enumeration umlEnum = enumerationLiteral.getEnumeration();
            EClassifier eType = OCLUMLUtil.getEClassifier(umlEnum, context,
                getEPackageRegistry());

            if (eType instanceof EEnum) {
                EEnumLiteral eLiteral = ((EEnum) eType).getELiterals().get(
                    umlEnum.getOwnedLiterals().indexOf(enumerationLiteral));

                if (eLiteral != null) {
                    return eLiteral.getInstance();
                }
            }
        }

        return enumerationLiteral;
    }

    /**
     * UML implementation of a tuple value.
     * 
     * @author Christian W. Damus (cdamus)
     */
    static class TupleImpl
        implements Tuple<Operation, Property> {

        private final TupleType<Operation, Property> type;

        private final Map<String, Object> parts = new java.util.HashMap<String, Object>();

        /**
         * Initializes me with a map of part values.
         * 
         * @param type
         *            my type
         * @param values
         *            my parts
         */
        TupleImpl(TupleType<Operation, Property> type,
                Map<Property, Object> values) {
            this.type = type;

            for (Map.Entry<Property, Object> entry : values.entrySet()) {
                parts.put(entry.getKey().getName(), entry.getValue());
            }
        }

        // implements the inherited specification
        public TupleType<Operation, Property> getTupleType() {
            return type;
        }

        // implements the inherited specification
        public Object getValue(String partName) {
            return parts.get(partName);
        }

        // implements the inherited specification
        public Object getValue(Property part) {
            return getValue(part.getName());
        }

        // overrides the inherited implementation
        @Override
        public boolean equals(Object o) {
            boolean result = o instanceof TupleImpl;

            if (result) {
                TupleImpl other = (TupleImpl) o;

                result &= other.type.equals(type);
                result &= other.parts.equals(parts);
            }

            return result;
        }

        // overrides the inherited implementation
        @Override
        public int hashCode() {
            return 37 * type.hashCode() + 17 * parts.hashCode();
        }
        
        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            result.append("Tuple{"); //$NON-NLS-1$
            
            for (Iterator<Property> iter =  getTupleType().oclProperties().iterator();
                    iter.hasNext();) {
                
                Property p = iter.next();
                
                result.append(p.getName());
                result.append(" = "); //$NON-NLS-1$
                result.append(toString(getValue(p)));
                
                if (iter.hasNext()) {
                    result.append(", "); //$NON-NLS-1$
                }
            }
            
            result.append("}"); //$NON-NLS-1$
            return result.toString();
        }
        
        private String toString(Object o) {
            if (o instanceof String) {
                return "'" + (String) o + "'"; //$NON-NLS-1$ //$NON-NLS-2$
            } else if (o instanceof Collection<?>) {
                return CollectionUtil.toString((Collection<?>) o);
            } else if (o == null) {
                return "null"; //$NON-NLS-1$
            } else {
                return o.toString();
            }
        }
    }

    /**
     * A converter of UML value specifications to OCL (Java) values.
     * 
     * @author Christian W. Damus (cdamus)
     */
    class ValueExtractor
        extends UMLSwitch<Object> {

        @Override
        public Object caseLiteralBoolean(LiteralBoolean object) {
            return Boolean.valueOf(object.booleanValue());
        }

        @Override
        public Object caseLiteralInteger(LiteralInteger object) {
            return new Integer(object.integerValue());
        }

        @Override
        public Object caseLiteralNull(LiteralNull object) {
            return null;
        }

        @Override
        public Object caseLiteralString(LiteralString object) {
            return object.stringValue();
        }

        @Override
        public Object caseLiteralUnlimitedNatural(LiteralUnlimitedNatural object) {
            return new Integer(object.unlimitedValue());
        }

        @Override
        public Object caseInstanceValue(InstanceValue object) {
            return object.getInstance();
        }

        @Override
        public Object caseValueSpecification(ValueSpecification object) {
            // the default case is a value specification that we don't
            // understand
            return OCLStandardLibraryImpl.INVALID;
        }

        /**
         * Converts the specified collection of UML values to a collection of
         * OCL values.
         * 
         * @param values
         *            UML values
         * @return the corresponding OCL values
         */
        Collection<?> extractValues(
                Collection<? extends ValueSpecification> values,
                CollectionKind collectionKind) {
            Collection<Object> result = CollectionUtil
                .createNewCollection(collectionKind);

            for (ValueSpecification value : values) {
                result.add(extractValue(value));
            }

            return result;
        }

        /**
         * Converts the specified UML values to an OCL value.
         * 
         * @param values
         *            a UML value
         * @return the corresponding OCL value
         */
        Object extractValue(ValueSpecification value) {
            return doSwitch(value);
        }
    }
}