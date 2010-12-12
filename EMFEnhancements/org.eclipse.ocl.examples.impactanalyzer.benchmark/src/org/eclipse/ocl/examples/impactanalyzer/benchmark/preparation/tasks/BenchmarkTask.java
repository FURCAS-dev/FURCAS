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
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.tasks;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;

import org.eclipse.emf.ecore.EObject;

/**
 * A BenchmarkTask is a class which implements the callable interface, and
 * therefore contains the call of the logic or the algorithm, which shall be
 * measured by a benchmark. Thus, for different types of benchmarks different
 * BenchmarkTasks are necessary.
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface BenchmarkTask extends Callable<Collection<EObject>> {
    public boolean activate();
    public void beforeCall();
    public void afterCall();
    public boolean deactivate();

    public void callEvaluation();

    public Map<String, String> getAdditionalMeasurementInformation();
    public Map<String, String> getAdditionalInformation();
    public Object getResult();
}
