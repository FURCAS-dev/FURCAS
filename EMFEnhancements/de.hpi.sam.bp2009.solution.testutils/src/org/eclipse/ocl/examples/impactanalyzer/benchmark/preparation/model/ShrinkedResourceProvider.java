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
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications.NotificationResourceLoader;


/**
 * TODO: Write documentation for this class
 *
 * @author Manuel Holzleitner (D049667)
 */
public class ShrinkedResourceProvider {
    private final Resource fullSizeResource;
    private final ArrayList<Resource> shrinkedResourceList = new ArrayList<Resource>();

    private boolean resourcesWereShrinked = false;

    public boolean resourcesWereShrinked(){
	return resourcesWereShrinked;
    }

    public ShrinkedResourceProvider(Resource sourceResource){
	fullSizeResource = sourceResource;
    }

    public ArrayList<Resource> getAllResourcesFromLargeToSmall(){
	ArrayList<Resource> result = new ArrayList<Resource>();

	result.add(fullSizeResource);
	result.addAll(shrinkedResourceList);

	/*for(Resource toVisualize : result){
		EmfModelVisualizer visualizer = new EmfModelVisualizer(toVisualize);
		visualizer.visualize("C:\\tmp\\"+ toVisualize.getURI().lastSegment() + ".graphml");
	}*/

	return result;
    }

    public void runShrinkingProcess(){
	System.out.println("\t\tResource Shrinking Process started...");

	IncrementalResourceShrinker resourceShrinker = new IncrementalResourceShrinker();
	shrinkedResourceList.addAll(resourceShrinker.shrinkIncrementally(fullSizeResource));

	resourcesWereShrinked = true;

	System.out.println("\t\tResource Shrinking Process finished with " + shrinkedResourceList.size() + " resources");
    }

    public void persistShrinkedResource(){
	    //TODO: Implement saving resources
            try {
        	//FIXME: Does not work in an plugin environment
        	String resourcePath = NotificationResourceLoader.MODEL_FIXTURE_LOCATION + fullSizeResource.getURI().lastSegment();
        	System.out.println(resourcePath);
        	File f = new File("/tmp/"+ resourcePath);
        	f.getParentFile().mkdirs();
        	f.createNewFile();
        	FileOutputStream fos = new FileOutputStream(f);

        	fullSizeResource.save(fos, null);
            } catch (IOException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
            }
    }

    public void loadPersistetShrinkedResources(){
	//TODO: implement loading persisted resources
	//resourcesWereShrinked = true;
	throw new RuntimeException("Not implemented at the moment");
    }


}
