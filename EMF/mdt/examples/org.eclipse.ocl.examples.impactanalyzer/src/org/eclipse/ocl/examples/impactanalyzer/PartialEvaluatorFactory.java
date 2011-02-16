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
package org.eclipse.ocl.examples.impactanalyzer;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorFactoryImpl;
import org.eclipse.ocl.examples.impactanalyzer.deltaPropagation.PartialEvaluatorImpl;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;

public interface PartialEvaluatorFactory {
    PartialEvaluatorFactory INSTANCE = new PartialEvaluatorFactoryImpl();
    PartialEvaluatorImpl createPartialEvaluator(Notification atPre, OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory);
    PartialEvaluatorImpl createPartialEvaluator(OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory);
}
