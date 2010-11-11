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

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.utilities.AbstractVisitor;

import com.sap.emf.ocl.oclwithhiddenopposites.expressions.OppositePropertyCallExp;
import com.sap.emf.ocl.oclwithhiddenopposites.utilities.VisitorWithHiddenOpposite;

public abstract class AbstractVisitorWithHiddenOpposites<T>
        extends
        AbstractVisitor<T, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint>
        implements VisitorWithHiddenOpposite<T> {

    public AbstractVisitorWithHiddenOpposites() {
        super();
    }

    public AbstractVisitorWithHiddenOpposites(T initialValue) {
        super(initialValue);
    }

    /**
     * Visits the property-call source and then its qualifiers (if any). Returns the result of
     * {@link #handlePropertyCallExp(PropertyCallExp, Object, List)}.
     */
    public T visitOppositePropertyCallExp(OppositePropertyCallExp callExp) {
        // source is null when the property call expression is an
        // association class navigation qualifier
        T sourceResult = safeVisit(callExp.getSource());

        return handleOppositePropertyCallExp(callExp, sourceResult);
    }

    /**
     * Visits the specified opposite property call with the results of visiting
     * its source. It is assumed that there are no qualifiers for an opposite
     * property call expression.
     * 
     * @param callExp the property call expression, if there is a source
     * @param sourceResult the result of visiting the expression's source
     * @param qualifierResults the results of visiting the expression's
     *     qualifiers, or an empty list if there are no qualifiers
     * 
     * @return the accumulated {@link #result}, by default
     * 
     * @see #visitPropertyCallExp(PropertyCallExp)
     */
    protected T handleOppositePropertyCallExp(OppositePropertyCallExp callExp,
            T sourceResult) {
        return result;
    }

}
