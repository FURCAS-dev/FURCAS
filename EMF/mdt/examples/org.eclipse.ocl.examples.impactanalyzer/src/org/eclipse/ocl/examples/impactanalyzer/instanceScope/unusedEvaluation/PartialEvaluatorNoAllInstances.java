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
package org.eclipse.ocl.examples.impactanalyzer.instanceScope.unusedEvaluation;


import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorImpl;

/**
 * A partial evaluator which doesn't attempt to perform <code>allInstances()</code> requests
 * and instead throws a {@link NoAllInstancesDuringEvaluationForUnusedCheck} exception when
 * it happens. Useful in case partial evaluations are carried out to gain performance and if
 * performing the <code>allInstances()</code> call costs more than it saves.
 * 
 * @author Axel Uhl (D043530)
 *
 */
public class PartialEvaluatorNoAllInstances extends PartialEvaluatorImpl {
    public PartialEvaluatorNoAllInstances(OCLFactory oclFactory) {
        this(new PartialEcoreEnvironmentFactoryNoAllInstances(), oclFactory);
    }
    
    protected PartialEvaluatorNoAllInstances(PartialEcoreEnvironmentFactoryNoAllInstances environmentFactory, OCLFactory oclFactory) {
        super(environmentFactory, oclFactory);
    }
}
