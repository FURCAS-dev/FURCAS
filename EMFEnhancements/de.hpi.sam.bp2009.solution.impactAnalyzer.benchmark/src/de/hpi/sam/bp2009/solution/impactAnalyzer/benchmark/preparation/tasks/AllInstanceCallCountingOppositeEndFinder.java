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
package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;


public class AllInstanceCallCountingOppositeEndFinder implements OppositeEndFinder{
    private int allInstancesCalled = 0;
    private int findOppositeEndsCalled = 0;
    private int getAllOppositeEndsCalled = 0;

    private final OppositeEndFinder delegate = DefaultOppositeEndFinder.getInstance();

    public AllInstanceCallCountingOppositeEndFinder() {
    }

    @Override
    public Set<EObject> getAllInstancesSeeing(EClass cls, Notifier context) {
	setAllInstancesCalled(getAllInstancesCalled() + 1);
        return delegate.getAllInstancesSeeing(cls, context);
    }

    @Override
    public void findOppositeEnds(EClassifier classifier, String name, List<EStructuralFeature> ends) {
	findOppositeEndsCalled++;
	delegate.findOppositeEnds(classifier, name, ends);
    }

    @Override
    public Map<String, EStructuralFeature> getAllOppositeEnds(EClassifier classifier) {
	setGetAllOppositeEndsCalled(getGetAllOppositeEndsCalled() + 1);
	return delegate.getAllOppositeEnds(classifier);
    }

    @Override
    public Collection<EObject> navigateOppositePropertyWithForwardScope(EStructuralFeature property, EObject target) {
	return delegate.navigateOppositePropertyWithForwardScope(property, target);
    }

    @Override
    public Collection<EObject> navigateOppositePropertyWithBackwardScope(EStructuralFeature property, EObject target) {
	return delegate.navigateOppositePropertyWithBackwardScope(property, target);
    }

    @Override
    public Set<EObject> getAllInstancesSeenBy(EClass cls, Notifier context) {
	setAllInstancesCalled(getAllInstancesCalled() + 1);
	return delegate.getAllInstancesSeenBy(cls, context);
    }

    public void setAllInstancesCalled(int allInstancesCalled) {
	this.allInstancesCalled = allInstancesCalled;
    }

    public void resetAllInstancesCalled() {
	this.allInstancesCalled = 0;
    }

    public int getAllInstancesCalled() {
	return allInstancesCalled;
    }

    public void setFindOppositeEndsCalled(int findOppositeEndsCalled) {
	this.findOppositeEndsCalled = findOppositeEndsCalled;
    }

    public void resetFindOppositeEndsCalled() {
	this.findOppositeEndsCalled = 0;
    }

    public void resetAll(){
	resetAllInstancesCalled();
	resetFindOppositeEndsCalled();
	resetGetAllOppositeEndsCalled();
    }

    public int getFindOppositeEndsCalled() {
	return findOppositeEndsCalled;
    }

    public void setGetAllOppositeEndsCalled(int getAllOppositeEndsCalled) {
	this.getAllOppositeEndsCalled = getAllOppositeEndsCalled;
    }

    public void resetGetAllOppositeEndsCalled() {
	this.getAllOppositeEndsCalled = 0;
    }

    public int getGetAllOppositeEndsCalled() {
	return getAllOppositeEndsCalled;
    }
}
