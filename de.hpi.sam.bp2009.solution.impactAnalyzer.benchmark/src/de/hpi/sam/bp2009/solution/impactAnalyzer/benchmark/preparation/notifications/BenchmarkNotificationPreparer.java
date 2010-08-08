package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.PathOptions;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model.ShrinkedResourceProvider;


public class BenchmarkNotificationPreparer {

    public static Collection<RawNotification> prepareRealWorldReplayNotification(){
    	return new RealWorldReplayNotificationProducer().produce(PathOptions.getEventTraceFixturePath());
    }

    public static Collection<NotificationForModelList> prepareModelSizeVariationNotification(){
	ArrayList<NotificationForModelList> result = new ArrayList<NotificationForModelList>();

	Resource fullSizeModel = NotificationResourceLoader.loadModel(PathOptions.getModelFixturePath());
	ShrinkedResourceProvider resourceProvider = new ShrinkedResourceProvider(fullSizeModel);
	resourceProvider.runShrinkingProcess();

	for(Resource model : resourceProvider.getAllResourcesFromLargeToSmall()){
	    System.out.println("\t\t\tCreate notifications for resource: " + model.getURI().toString());

	    Collection<RawNotification> notiList = new RealWorldReplayNotificationProducer().produce(PathOptions.getEventTraceFixturePath());
	    System.out.println("\t\t\t\t " + notiList.size() + " created");

	    result.add(new NotificationForModelList(model, (List<RawNotification>)notiList));
	}

	return result;
    }

}
