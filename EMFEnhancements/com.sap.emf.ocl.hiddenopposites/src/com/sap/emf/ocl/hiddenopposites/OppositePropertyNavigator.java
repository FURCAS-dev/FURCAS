/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.emf.ocl.hiddenopposites;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.ObjectUtil;


public class OppositePropertyNavigator {
    private final OppositeEndFinder oppositeEndFinder;

    public OppositePropertyNavigator(OppositeEndFinder oppositeEndFinder) {
        this.oppositeEndFinder = oppositeEndFinder;
    }

    public Object navigateOppositeProperty(EStructuralFeature property, Object target) throws IllegalArgumentException {
        Object result;
        if (property instanceof EReference && ((EReference) property).isContainment()) {
            EObject resultCandidate = ((EObject) target).eContainer();
            if (resultCandidate == null) {
                result = null;
            } else {
                // first check if the container is assignment-compatible to the property's owning type:
                if (((EClass) property.eContainer()).isSuperTypeOf(resultCandidate.eClass())) {
                    Object propertyValue = resultCandidate.eGet(property);
                    if (propertyValue == target
                            || (propertyValue instanceof Collection<?> && ((Collection<?>) propertyValue).contains(target))) {
                        // important to create a copy because, e.g., the partial evaluator may modify the resulting collection
                        result = coerceValue(property, resultCandidate, /* copy */true);
                    } else {
                        result = null;
                    }
                } else {
                    result = null;
                }
            }
        } else if (oppositeEndFinder == null) {
            result = null;
        } else {
            result = oppositeEndFinder.navigateOppositePropertyWithForwardScope(property, (EObject) target);
        }
        return result;
    }

    /**
     * Copied invisible method from base class.
     * 
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
     * Copied invisible method from base class and adjusted to fetch UMLReflection object
     * from a temporarily-constructed EcoreEnvironmentWithHiddenOppositesImpl inheriting the
     * getUMLReflection() operation.
     *  
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
        EClassifier oclType = new EcoreEnvironmentWithHiddenOppositesImpl(EPackage.Registry.INSTANCE).
                getUMLReflection().getOCLType(element);
        CollectionKind result = null;
        if (oclType instanceof CollectionType<?, ?>) {
            result = ((CollectionType<?, ?>) oclType).getKind();
            ObjectUtil.dispose(oclType);  // we created this object
        }
        return result;
    }
    

}
