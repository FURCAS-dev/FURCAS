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
package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.BenchmarkProcessor;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.ActivationOption;

public class BenchmarkAsPluginTest extends TestCase {
    @Test
    public void testStartBenchmarks() throws IOException {
        List<ActivationOption> optionList = new ArrayList<ActivationOption>();
        // TracebackStep
//        optionList.add(new ActivationOption(true, true, true, true, "All optimizations activated, TracebackSteps"));
//        optionList.add(new ActivationOption(false, true, true, true, "Without delta propagation, TracebackSteps"));
        optionList.add(new ActivationOption(true, false, true, true, "Without unused checks, TracebackSteps"));
//        optionList.add(new ActivationOption(true, true, true, false, "Without OperationCallExp selection, TracebackSteps"));
//        optionList.add(new ActivationOption(false, false, true, true,
//                "Without delta propagation, without unused checks, TracebackSteps"));
//        optionList.add(new ActivationOption(true, false, true, false,
//                "Without unused checks, without OperationCallExp selection, TracebackSteps"));
//        optionList.add(new ActivationOption(false, true, true, false,
//                "Without delta propagation, without OperationCallExp selection, TracebackSteps"));
//        optionList.add(new ActivationOption(false, false, true, false,
//                "Without unused checks, without delta propagation, without OperationCallExp selection, TracebackSteps"));
//        // NavigationStep
//        optionList.add(new ActivationOption(true, true, false, false, "With delta propagation, NavigationSteps"));
//        optionList.add(new ActivationOption(false, true, false, true, "Without delta propagation, NavigationSteps"));
        BenchmarkProcessor.start(/* warm-ups */ 1, /* measures */ 1,
                System.getProperty("java.io.tmpdir")+File.separator+"result.data",
                /* numberOfJobs */ 1,
                /* delayPreparation */ true, System.getProperty("java.io.tmpdir")+File.separator+"exceptions.dump",
                /* verbose */ true,
                "modifyElementaryTypesEventTrace.trace", "NgpmModel.xmi", /* noShrinking */ true,
                /* oclId */ null /* meaning ALL */, optionList);
    }
}
