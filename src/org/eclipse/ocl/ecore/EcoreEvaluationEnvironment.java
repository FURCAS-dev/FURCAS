/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation and others.
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
 * $Id: EcoreEvaluationEnvironment.java,v 1.7 2008/02/16 00:07:23 cdamus Exp $
 */

package org.eclipse.ocl.ecore;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ocl.AbstractEvaluationEnvironment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.LazyExtentMap;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.util.UnicodeSupport;
import org.eclipse.ocl.utilities.PredefinedType;

/**
 * Implementation of the {@link EvaluationEnvironment} for evaluation of OCL
 * expressions on instances of Ecore models (i.e., on M0 models).
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEvaluationEnvironment
    extends
    AbstractEvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
	implements EvaluationEnvironment.Enumerations<EEnumLiteral> {

    /**
     * Initializes me.
     */
    public EcoreEvaluationEnvironment() {
        super();
    }

    /**
     * Initializes me with my parent evaluation environment (nesting scope).
     * 
     * @param parent
     *            my parent (nesting scope); must not be <code>null</code>
     */
    public EcoreEvaluationEnvironment(
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
        super(parent);
    }

    @Override
    public Object callOperation(EOperation operation, int opcode,
            Object source, Object[] args)
        throws IllegalArgumentException {

        // TODO: WBN to pull up createValue to the superclass as a pass-thru
        // so that subclasses don't have to override callOperation
        return coerceValue(operation, super.callOperation(operation, opcode,
            source, args), true);
    }

    // implements the inherited specification
    @Override
    protected Method getJavaMethodFor(EOperation operation, Object receiver) {
        Method result = null;

        // in the case of infix operators, we need to replace the name with
        // a valid Java name. We will choose the legacy OCL parser names
        // which some clients already depend on
        String operName = operation.getName();
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
        EClass container = operation.getEContainingClass();

        // get the corresponding java instance class
        Class<?> containerClass = container.getInstanceClass();

        // get the parameter types as java classes
        EList<EParameter> parms = operation.getEParameters();
        Class<?>[] javaParms = new Class[parms.size()];
        for (int i = 0, n = parms.size(); i < n; i++) {
            EParameter parm = parms.get(i);

            if (parm.isMany()) {
                javaParms[i] = EList.class; // TODO: EList could be suppressed
            } else {
                javaParms[i] = parm.getEType().getInstanceClass();
            }
        }

        // lookup the method on the java class
        try {
            result = containerClass.getMethod(operName, javaParms);
        } catch (NoSuchMethodException e) {
            // do nothing
        }

        return result;
    }

    // implements the inherited specification
    @Override
    protected Object getInvalidResult() {
        return OCLStandardLibraryImpl.OCL_INVALID;
    }

    // implements the inherited specification
    public Object navigateProperty(EStructuralFeature property,
            List<?> qualifiers, Object target)
        throws IllegalArgumentException {

        if (target instanceof EObject) {
            EObject etarget = (EObject) target;

            if (etarget.eClass().getEAllStructuralFeatures().contains(property)) {
                return coerceValue(property, etarget.eGet(property), true);
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * Obtains the collection kind appropriate for representing the values of
     * the specified typed element.
     * 
     * @param element
     *            a typed element (property, operation, etc.)
     * 
     * @return the collection kind appropriate to the multiplicity, orderedness,
     *         and uniqueness of the element, or <code>null</code> if it is
     *         not many
     */
    private static CollectionKind getCollectionKind(ETypedElement element) {
        EClassifier oclType = UMLReflectionImpl.INSTANCE.getOCLType(element);
        
        CollectionKind result = null;
        
        if (oclType instanceof CollectionType) {
            result = ((CollectionType<?, ?>) oclType).getKind();
            ObjectUtil.dispose(oclType);  // we created this object
        }
        
        return result;
    }

    /**
     * Coerces the value of the specified typed element into the appropriate
     * representation, derived from the supplied <code>value</code> template.
     * The <code>value</code> is coerced to the appropriate collection kind
     * for this element (or scalar if not multi-valued). The original value may
     * either be used as is where possible or, optionally, copied into the new
     * collection (if multi-valued).
     * 
     * @param element
     *            a typed element (property, operation, etc.)
     * @param value
     *            the computed value of the element
     * @param copy
     *            whether to copy the specified value into the resulting
     *            collection/scalar value
     * 
     * @return the value, in the appropriate OCL collection type or scalar form
     *         as required
     * 
     * @see #getCollectionKind(ETypedElement)
     */
    private Object coerceValue(ETypedElement element, Object value, boolean copy) {
        CollectionKind kind = getCollectionKind(element);

        if (kind != null) {
            if (value instanceof Collection) {
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
            if (value instanceof Collection) {
                Collection<?> collection = (Collection<?>) value;
                return collection.isEmpty() ? null
                    : collection.iterator().next();
            } else {
                return value;
            }
        }
    }

    // implements the inherited specification
    public Object navigateAssociationClass(EClassifier associationClass,
            EStructuralFeature navigationSource, Object target)
        throws IllegalArgumentException {

        if (target instanceof EObject) {
            EObject etarget = (EObject) target;

            EReference ref = getAssociationClassReference(etarget,
                (EClass) associationClass);

            if (etarget.eClass().getEAllStructuralFeatures().contains(ref)) {
                return etarget.eGet(ref);
            }
        }

        throw new IllegalArgumentException();
    }

    /**
     * Retrieves the reference feature in the specified context object that
     * references the specified association class.
     * 
     * @param context
     *            the context object
     * @param associationClass
     *            the association class that it references
     * @return the reference in question
     */
    private EReference getAssociationClassReference(EObject context,
            EClass associationClass) {
        EReference result = null;

        StringBuffer nameBuf = new StringBuffer(associationClass.getName());
        UnicodeSupport.setCodePointAt(nameBuf, 0, UnicodeSupport
            .toLowerCase(UnicodeSupport.codePointAt(nameBuf, 0)));
        String name = nameBuf.toString();

        for (EReference next : context.eClass().getEAllReferences()) {
            if (name.equals(next.getName())
                && (associationClass == next.getEReferenceType())) {
                result = next;
                break;
            }
        }

        return result;
    }

    // implements the inherited specification
    public Tuple<EOperation, EStructuralFeature> createTuple(EClassifier type,
            Map<EStructuralFeature, Object> values) {

        EClass tupleType = (EClass) type;

        EObject tuple = tupleType.getEPackage().getEFactoryInstance().create(
            tupleType);

        for (Map.Entry<EStructuralFeature, Object> entry : values.entrySet()) {
            EStructuralFeature property = entry.getKey();
            Object value = entry.getValue();

            if (property.isMany() && (value instanceof Collection)) {
                @SuppressWarnings("unchecked")
                Collection<Object> coll = (Collection<Object>) tuple
                    .eGet(property);
                coll.addAll((Collection<?>) value);
            } else if ((property.getEType() instanceof CollectionType)
                && (value instanceof Collection)) {
                // always copy the collection to the correct type
                @SuppressWarnings("unchecked")
                CollectionType<EClassifier, EOperation> collType = (CollectionType<EClassifier, EOperation>) property
                    .getEType();
                tuple.eSet(property, CollectionUtil.createNewCollection(
                    collType.getKind(), (Collection<?>) value));
            } else {
                tuple.eSet(property, value);
            }
        }

        @SuppressWarnings("unchecked")
        Tuple<EOperation, EStructuralFeature> result = (Tuple<EOperation, EStructuralFeature>) tuple;

        return result;
    }

    // implements the inherited specification
    public Map<EClass, Set<EObject>> createExtentMap(Object object) {
        if (object instanceof EObject) {
            return new LazyExtentMap<EClass, EObject>((EObject) object) {

                // implements the inherited specification
                @Override
                protected boolean isInstance(EClass cls, EObject element) {
                    return cls.isInstance(element);
                }
            };
        }

        return Collections.emptyMap();
    }

    // implements the inherited specification
    public boolean isKindOf(Object object, EClassifier classifier) {
        // special case for Integer/UnlimitedNatural and Real which
        // are not related types in java but are in OCL
        if ((object.getClass() == Integer.class)
            && (classifier.getInstanceClass() == Double.class)) {
            return Boolean.TRUE;
        }

        return classifier.isInstance(object);
    }

    // implements the inherited specification
    public boolean isTypeOf(Object object, EClassifier classifier) {
        if (classifier instanceof EClass && object instanceof EObject) {
            return ((EObject) object).eClass() == classifier;
        } else if (!(object instanceof EObject)
            && !(classifier instanceof EClass)) {
            return object.getClass() == classifier.getInstanceClass();
        }

        return false;
    }

    // implements the inherited specification
    public EClassifier getType(Object object) {
        return EcoreEnvironmentFactory.oclType(object);
    }
    
    /**
     * Ecore implementation of the enumeration literal value.
     * 
     * @since 1.2
     */
    public Enumerator getValue(EEnumLiteral enumerationLiteral) {
    	return enumerationLiteral.getInstance();
    }
}