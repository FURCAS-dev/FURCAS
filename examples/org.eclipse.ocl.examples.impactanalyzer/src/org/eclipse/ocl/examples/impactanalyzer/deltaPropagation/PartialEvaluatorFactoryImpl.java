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
package org.eclipse.ocl.examples.impactanalyzer.deltaPropagation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;

public class PartialEvaluatorFactoryImpl implements PartialEvaluatorFactory {

    public PartialEvaluatorImpl createPartialEvaluator(Notification atPre, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new PartialEvaluatorImpl(atPre, oppositeEndFinder, oclFactory);
    }

    public PartialEvaluatorImpl createPartialEvaluator(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory) {
        return new PartialEvaluatorImpl(oclFactory, oppositeEndFinder);
    }

}
