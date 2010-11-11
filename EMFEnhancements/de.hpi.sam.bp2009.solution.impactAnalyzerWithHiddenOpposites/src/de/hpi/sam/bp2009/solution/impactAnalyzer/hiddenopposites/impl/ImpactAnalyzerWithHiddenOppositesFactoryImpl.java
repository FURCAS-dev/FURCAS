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
package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.ecore.OCLExpression;


import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;

public class ImpactAnalyzerWithHiddenOppositesFactoryImpl implements ImpactAnalyzerFactory {

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OCLFactory oclFactory) {
        return new ImpactAnalyzerWithHiddenOppositesImpl(expression, notifyOnNewContextElements, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OCLFactory oclFactory) {
        return new ImpactAnalyzerWithHiddenOppositesImpl(expression, context, notifyOnNewContextElements, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new ImpactAnalyzerWithHiddenOppositesImpl(expression, context, notifyOnNewContextElements, oppositeEndFinder, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new ImpactAnalyzerWithHiddenOppositesImpl(expression, notifyOnNewContextElements, oppositeEndFinder, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerWithHiddenOppositesImpl(expression, notifyOnNewContextElements, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerWithHiddenOppositesImpl(expression, context, notifyOnNewContextElements, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerWithHiddenOppositesImpl(expression, context, notifyOnNewContextElements, oppositeEndFinder, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerWithHiddenOppositesImpl(expression, notifyOnNewContextElements, oppositeEndFinder, configuration, oclFactory);
    }

}
