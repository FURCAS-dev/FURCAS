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
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.model.ShrinkedResourceProvider;



public class BenchmarkNotificationPreparer {

    public static Collection<RawNotification> prepareRealWorldReplayNotification(String eventTraceFixturePath){
    	return new RealWorldReplayNotificationProducer().produce(eventTraceFixturePath);
    }

    public static Collection<NotificationForModelList> prepareModelSizeVariationNotification(
            String eventTraceFixturePath, String modelFixturePath, boolean noShrinking){
	ArrayList<NotificationForModelList> result = new ArrayList<NotificationForModelList>();

	Resource fullSizeModel = NotificationResourceLoader.loadModel(modelFixturePath);
	List<Resource> resources;
	if (noShrinking) {
	    resources = Collections.singletonList(fullSizeModel);
        } else {
            ShrinkedResourceProvider resourceProvider = new ShrinkedResourceProvider(fullSizeModel);
            resourceProvider.runShrinkingProcess();
            resources = resourceProvider.getAllResourcesFromLargeToSmall();
        }
	for(Resource model : resources){
	    System.out.println("\t\t\tCreate notifications for resource: " + model.getURI().toString());
	    Collection<RawNotification> notiList = new RealWorldReplayNotificationProducer().produce(eventTraceFixturePath);
	    System.out.println("\t\t\t\t " + notiList.size() + " created");
	    result.add(new NotificationForModelList(model, (List<RawNotification>)notiList));
	}

	return result;
    }

}
