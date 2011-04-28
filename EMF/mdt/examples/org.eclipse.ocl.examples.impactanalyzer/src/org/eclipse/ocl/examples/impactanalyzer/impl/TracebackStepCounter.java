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


/**
 * Counts the number of traceback steps performed during the execution of
 * {@link ImpactAnalyzer#getContextObjects(org.eclipse.emf.common.notify.Notification)).
 * 
 * @author Axel Uhl (d043530)
 */
public interface TracebackStepCounter {
    void tracebackStepExecuted();
}
