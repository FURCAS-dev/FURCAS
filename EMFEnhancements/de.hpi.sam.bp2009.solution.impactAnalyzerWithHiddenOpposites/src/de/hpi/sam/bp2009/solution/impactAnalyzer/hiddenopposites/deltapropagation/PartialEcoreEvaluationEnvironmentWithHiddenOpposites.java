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
package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.deltapropagation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.emf.ocl.hiddenopposites.EvaluationEnvironmentWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositePropertyNavigator;

import de.hpi.sam.bp2009.solution.impactAnalyzer.deltaPropagation.PartialEcoreEvaluationEnvironment;

public class PartialEcoreEvaluationEnvironmentWithHiddenOpposites extends PartialEcoreEvaluationEnvironment implements
        EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>,
        EvaluationEnvironmentWithHiddenOpposites {

    private final OppositePropertyNavigator oppositePropertyNavigator;

    public PartialEcoreEvaluationEnvironmentWithHiddenOpposites(OppositeEndFinder oppositeEndFinder) {
        super(oppositeEndFinder);
        this.oppositePropertyNavigator = new OppositePropertyNavigator(oppositeEndFinder);
    }
    
    public PartialEcoreEvaluationEnvironmentWithHiddenOpposites(
            EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
        super(parent);
        oppositePropertyNavigator = ((PartialEcoreEvaluationEnvironmentWithHiddenOpposites) parent).oppositePropertyNavigator;
    }
    
    @Override
    public Object navigateOppositeProperty(EStructuralFeature property, Object source) throws IllegalArgumentException {
        return oppositePropertyNavigator.navigateOppositeProperty(property, source);
    }
}
