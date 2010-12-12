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
import java.util.List;

import org.eclipse.ocl.examples.impactanalyzer.benchmark.PathOptions;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.BenchmarkNotificationPreparer;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.NotificationForModelList;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl.BenchmarkOCLPreparer;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;


/**
 * The {@link BenchmarkTaskPreparer} provides methods for creating a collection of
 * specific {@link BenchmarkTask}s.
 *
 * @author Manuel Holzleitner (D049667)
 */
public class BenchmarkTaskPreparer {
     public static BenchmarkTaskStepwiseBuilder createBenchmarkBuilder(boolean noShrinking, Integer oclId, List<ActivationOption> optionList){
     	System.out.println("Start Preparation");
    	System.out.println("\t Prepare OCL Expressions");
    	Collection<OCLExpressionWithContext> expressionList = BenchmarkOCLPreparer.prepareAll(oclId);
    	System.out.println("\t\t " + expressionList.size() + " successfully prepared");

    	System.out.println("\t Prepare Notifications");
    	Collection<NotificationForModelList> notificationForModelList = BenchmarkNotificationPreparer.prepareModelSizeVariationNotification(
    	        PathOptions.getEventTraceFixturePath(), PathOptions.getModelFixturePath(), noShrinking);
    	System.out.println("\t\t " + notificationForModelList.size() + " successfully prepared");

    	System.out.println("\t Prepare Benchmark Tasks:");

    	return new BenchmarkTaskStepwiseBuilder(expressionList, notificationForModelList, optionList);
     }
}
