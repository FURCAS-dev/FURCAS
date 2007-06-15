/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
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
 * $Id: CompatibilityUMLReflection.java,v 1.4 2007/06/15 18:40:44 cdamus Exp $
 */

package org.eclipse.emf.ocl.internal.parser;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ocl.parser.Environment;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;


/**
 * @author cdamus
 *
 */
class CompatibilityUMLReflection extends UMLReflectionImpl {
    private static final Map<ETypedElement, Boolean> staticFeatures =
        new java.util.WeakHashMap<ETypedElement, Boolean>();
    
    private final Environment oldStyle;
    
    CompatibilityUMLReflection(Environment oldStyle) {
        this.oldStyle = oldStyle;
    }

    @Override
    public String getDescription(Object namedElement) {
        return oldStyle.getDescription((ENamedElement) namedElement);
    }

    @Override
    public List<EStructuralFeature> getMemberEnds(EClassifier associationClass) {
        return oldStyle.getMemberEnds((EClass) associationClass);
    }

    @Override
    public EClass getAssociationClass(EStructuralFeature reference) {
        return (reference instanceof EReference)?
            oldStyle.getAssociationClass((EReference) reference) : null;
    }
    
    @Override
    public List<EStructuralFeature> getQualifiers(EStructuralFeature property) {
        return oldStyle.getQualifiers(property);
    }

    @Override
    public List<EClassifier> getSignals(EClassifier owner) {
        return oldStyle.getSignals(owner);
    }

    @Override
    public boolean isAssociationClass(EClassifier eclass) {
        return eclass instanceof EClass &&
            oldStyle.isAssociationClass((EClass) eclass);
    }

    @Override
    public boolean isQuery(EOperation operation) {
        // if this is an OCL Standard Library operation, then it is a query
        //    operation as the OCL Standard Library only has queries
        if (UMLReflectionImpl.isAncestor(OCLStandardLibraryImpl.stdlibPackage, operation)) {
            return true;
        }
        
        return oldStyle.isQuery(operation);
    }

    @Override
    public String getName(Object namedElement) {
        String result = super.getName(namedElement);
        
        if (result == null && (namedElement instanceof EObject)) {
            // perhaps it was a state?
            result = oldStyle.getStateName((EObject) namedElement);
        }
        
        return result;
    }
    
    @Override
    public List<EOperation> getOperations(EClassifier classifier) {
        return UMLReflectionImpl.INSTANCE.getOperations(classifier);
    }
    
    @Override
    public List<EStructuralFeature> getAttributes(EClassifier classifier) {
        return UMLReflectionImpl.INSTANCE.getAttributes(classifier);
    }
    
    /**
     * Mark the specified feature as static.
     * 
     * @param feature a static structural feature or operation
     */
    static void setStatic(ETypedElement feature) {
        staticFeatures.put(feature, Boolean.TRUE);
    }
    
    /**
     * Extends the inherited implementation to support an annotation that
     * denotes static-ness.
     */
    public boolean isStatic(Object feature) {
        return Boolean.TRUE.equals(staticFeatures.get(feature))
                || super.isStatic(feature);
    }
}
