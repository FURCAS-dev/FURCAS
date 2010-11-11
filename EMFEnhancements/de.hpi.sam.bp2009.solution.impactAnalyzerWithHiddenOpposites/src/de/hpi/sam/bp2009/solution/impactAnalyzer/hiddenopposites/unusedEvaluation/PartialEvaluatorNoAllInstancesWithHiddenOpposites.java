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
package de.hpi.sam.bp2009.solution.impactAnalyzer.hiddenopposites.unusedEvaluation;

import org.eclipse.emf.ecore.opposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.NoAllInstancesDuringEvaluationForUnusedCheck;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.unusedEvaluation.PartialEvaluatorNoAllInstances;

/**
 * A partial evaluator which doesn't attempt to perform <code>allInstances()</code> requests
 * and instead throws a {@link NoAllInstancesDuringEvaluationForUnusedCheck} exception when
 * it happens. Useful in case partial evaluations are carried out to gain performance and if
 * performing the <code>allInstances()</code> call costs more than it saves.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class PartialEvaluatorNoAllInstancesWithHiddenOpposites extends PartialEvaluatorNoAllInstances {
    public PartialEvaluatorNoAllInstancesWithHiddenOpposites(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        super(new PartialEcoreEnvironmentNoAllInstWithHiddenOppositesFactory(oppositeEndFinder), oclFactory);
    }
}
