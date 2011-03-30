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
package org.eclipse.ocl.examples.impactanalyzer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.DerivedPropertyNotifier;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;
import org.eclipse.ocl.examples.impactanalyzer.configuration.OptimizationActivation;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;



public class ImpactAnalyzerFactoryImpl implements ImpactAnalyzerFactory {

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, notifyOnNewContextElements, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, context, notifyOnNewContextElements, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, context, notifyOnNewContextElements, oppositeEndFinder, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, notifyOnNewContextElements, oppositeEndFinder, OptimizationActivation.getOption(), oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, notifyOnNewContextElements, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, context, notifyOnNewContextElements, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, EClass context, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, context, notifyOnNewContextElements, oppositeEndFinder, configuration, oclFactory);
    }

    public ImpactAnalyzer createImpactAnalyzer(OCLExpression expression, boolean notifyOnNewContextElements, OppositeEndFinder oppositeEndFinder, ActivationOption configuration, OCLFactory oclFactory) {
        return new ImpactAnalyzerImpl(expression, notifyOnNewContextElements, oppositeEndFinder, configuration, oclFactory);
    }

	public DerivedPropertyNotifier createDerivedPropertyNotifier(
			EStructuralFeature property, OCLFactory oclFactory) {
		return new DerivedPropertyNotifierImpl(OptimizationActivation.getOption(), DefaultOppositeEndFinder.getInstance(),
				oclFactory, property);
	}

	public DerivedPropertyNotifier createDerivedPropertyNotifier(
			EStructuralFeature property, ActivationOption configuration,
			OCLFactory oclFactory) {
		return new DerivedPropertyNotifierImpl(configuration, DefaultOppositeEndFinder.getInstance(),
				oclFactory, property);
	}

	public DerivedPropertyNotifier createDerivedPropertyNotifier(
			EStructuralFeature property, OppositeEndFinder oppositeEndFinder,
			OCLFactory oclFactory) {
		return new DerivedPropertyNotifierImpl(OptimizationActivation.getOption(), oppositeEndFinder,
				oclFactory, property);
	}

	public DerivedPropertyNotifier createDerivedPropertyNotifier(
			EStructuralFeature property, OppositeEndFinder oppositeEndFinder,
			ActivationOption configuration, OCLFactory oclFactory) {
		return new DerivedPropertyNotifierImpl(configuration, oppositeEndFinder,
				oclFactory, property);
	}

	public DerivedPropertyNotifier createDerivedPropertyNotifier(EPackage pkg,
			OCLFactory oclFactory) {
		return new DerivedPropertyNotifierImpl(OptimizationActivation.getOption(), DefaultOppositeEndFinder.getInstance(),
				oclFactory, pkg);
	}

	public DerivedPropertyNotifier createDerivedPropertyNotifier(EPackage pkg,
			ActivationOption configuration, OCLFactory oclFactory) {
		return new DerivedPropertyNotifierImpl(configuration, DefaultOppositeEndFinder.getInstance(),
				oclFactory, pkg);
	}

	public DerivedPropertyNotifier createDerivedPropertyNotifier(EPackage pkg,
			OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
		return new DerivedPropertyNotifierImpl(OptimizationActivation.getOption(), oppositeEndFinder,
				oclFactory, pkg);
	}

	public DerivedPropertyNotifier createDerivedPropertyNotifier(EPackage pkg,
			OppositeEndFinder oppositeEndFinder,
			ActivationOption configuration, OCLFactory oclFactory) {
		return new DerivedPropertyNotifierImpl(configuration, oppositeEndFinder,
				oclFactory, pkg);
	}

}
