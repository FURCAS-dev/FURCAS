/**
 * <copyright>
 *
 * Copyright (c) 2002, 2007 IBM Corporation and others.
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

package org.eclipse.emf.query.statements;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.conditions.eobjects.EObjectSource;
import org.eclipse.emf.query.conditions.eobjects.IEObjectSource;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.EStructuralFeatureValueGetter;
import org.eclipse.emf.query.conditions.eobjects.structuralfeatures.IEStructuralFeatureValueGetter;
import org.eclipse.emf.query.internal.statements.EObjectContentIterator;
import org.eclipse.emf.query.internal.statements.FlatEObjectContentIterator;
import org.eclipse.emf.query.internal.statements.QueryClause;

/**
 * The &quot;FROM&quot; clause for the {@link org.eclipse.emf.query.statements.SELECT}
 *  and {@link org.eclipse.emf.query.statements.UPDATE} statements. 
 * This clause is used to specify the input source of EObjects to be queried.
 * 
 * @author Yasser Lulu 
 */
public class FROM extends QueryClause {

    private EObjectCondition filterCondition;
    private IEStructuralFeatureValueGetter eStructuralFeatureValueGetter;
    private IEObjectSource eObjectSource;
    private IteratorKind iteratorKind;
    private boolean canPrune;

    public FROM(IEObjectSource eObjectSource) {
        this(eObjectSource, IteratorKind.HIERARCHICAL_LITERAL);
    }

    public FROM(IEObjectSource eObjectSource, IteratorKind iteratorKind) {
        this(eObjectSource, null, iteratorKind, null);
    }

    public FROM(
        IEObjectSource eObjectSource,
        EObjectCondition filterCondition) {
        this(
            eObjectSource,
            filterCondition,
            IteratorKind.HIERARCHICAL_LITERAL,
            null);
    }

    public FROM(
        IEObjectSource eObjectSource,
        EObjectCondition filterCondition,
        IteratorKind iteratorKind,
        IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
        this.eObjectSource = eObjectSource;
        this.iteratorKind = iteratorKind;
        this.filterCondition = filterCondition;
        this.eStructuralFeatureValueGetter = eStructuralFeatureValueGetter;
        canPrune = (iteratorKind == IteratorKind.HIERARCHICAL_LITERAL);
    }

    public FROM(EObject eObject) {
        this(eObject, IteratorKind.HIERARCHICAL_LITERAL);
    }

    public FROM(EObject eObject, IteratorKind iteratorKind) {
        this(eObject, null, iteratorKind, null);
    }

    public FROM(EObject eObject, EObjectCondition filterCondition) {
        this(eObject, filterCondition, IteratorKind.HIERARCHICAL_LITERAL, null);
    }

    public FROM(
        EObject eObject,
        EObjectCondition filterCondition,
        IteratorKind iteratorKind,
        IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
        this(
            new EObjectSource(eObject),
            filterCondition,
            iteratorKind,
            eStructuralFeatureValueGetter);
    }

    public FROM(Collection<? extends EObject> eObjects) {
        this(eObjects, IteratorKind.HIERARCHICAL_LITERAL);
    }

    public FROM(Collection<? extends EObject> eObjects,
    		EObjectCondition filterCondition) {
        this(
            eObjects,
            filterCondition,
            IteratorKind.HIERARCHICAL_LITERAL,
            null);
    }

    public FROM(Collection<? extends EObject> eObjects, IteratorKind iteratorKind) {
        this(eObjects, null, iteratorKind, null);
    }

    public FROM(
        Collection<? extends EObject> eObjects,
        EObjectCondition filterCondition,
        IteratorKind iteratorKind,
        IEStructuralFeatureValueGetter eStructuralFeatureValueGetter) {
        this(
            new EObjectSource(eObjects),
            filterCondition,
            iteratorKind,
            eStructuralFeatureValueGetter);
    }

    public boolean canBePruned() {
        return canPrune;
    }

    public TreeIterator<EObject> iterator() {
        return (iteratorKind == IteratorKind.HIERARCHICAL_LITERAL)
            ? new EObjectContentIterator(getEObjects(),
                filterCondition,
                getEStructuralFeatureValueGetter())
            : new FlatEObjectContentIterator(getEObjects(),
                getEStructuralFeatureValueGetter());
    }

    private Set<? extends EObject> getEObjects() {
        return eObjectSource.getEObjects();
    }

    private IEStructuralFeatureValueGetter getEStructuralFeatureValueGetter() {
        if (eStructuralFeatureValueGetter == null) {
            eStructuralFeatureValueGetter =
            EStructuralFeatureValueGetter.getInstance();
        }
        return eStructuralFeatureValueGetter;
    }

}
