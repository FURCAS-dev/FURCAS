package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationResourceLoader;

/**
 *
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

	return result;
    }

    public void runShrinkingProcess(){
	System.out.println("\t\t\tResource Shrinking Process started...");

	IncrementalResourceShrinker resourceShrinker = new IncrementalResourceShrinker();

	int cloneId = 0;
	Resource nextResourceToShrink = ModelCloner.cloneResource(fullSizeResource, String.valueOf(cloneId));
	while(resourceShrinker.shrink(nextResourceToShrink) > 1){
		cloneId++;
		
	    shrinkedResourceList.add(nextResourceToShrink);
	    nextResourceToShrink = ModelCloner.cloneResource(nextResourceToShrink, String.valueOf(cloneId));
	    //persistShrinkedResource();
	}

	resourcesWereShrinked = true;

	System.out.println("\t\t\tResource Shrinking Process finished with " + shrinkedResourceList.size() + " resources");
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
