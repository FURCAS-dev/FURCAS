package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * The {@link RealWorldReplayNotificationProducer} produces {@link Notification}s out of
 * a event trace which was created in MOIN by printing Event.toString(); on several events.
 *
 * At the moment, it is not guaranteed that all types of events can be easily replayed.
 * In fact, the following event types are supported at the moment:
 * - AttributeValueChangeEvent
 *
 * @author Manuel Holzleitner (D049667)
 */
public class RealWorldReplayNotificationProducer implements NotificationProducer {
    /**
     * Produces a default list of notifications out of the NGPM model and a
     * primitive event trace as default
     */
    @Override
    public Collection<Notification> produce() {
	//TODO: Make the primitive event trace less primitive
	return produce("primitiveEventTrace.trace");
    }

    /**
     * Produces a list of notifications out of the NGPM model according to
     * the name of the event trace fixture
     *
     * @param traceFilename
     */
    public Collection<Notification> produce(String traceFixtureName){
	return produce("NgpmModel.xmi", traceFixtureName);
    }

    /**
     * Produces a list of notifications out of a trace and model fixture. Therefore this fixtures
     * must always be added to the fixtures folder in de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications
     *
     * @param modelFilename
     * @param traceFilename
     * @return Collection of notifications which can be created out of
     */
    public Collection<Notification> produce(String modelFilename, String traceFilename){
	XMLResource instanceResource = NotificationResourceLoader.loadModel(modelFilename);
	Collection<NotificationResourceLoader.RawEventInformation> rawEventInformationList = NotificationResourceLoader.loadTrace(traceFilename);

	return convertToNotifications(instanceResource, rawEventInformationList);
    }

    /**
     * Produces a list of notifications out of a trace and model fixture. Therefore this fixtures
     * must always be added to the fixtures folder in de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications
     *
     * @param modelFilename
     * @param traceFilename
     * @return Collection of notifications which can be created out of
     */
    public Collection<Notification> produce(Resource model, String traceFilename){
	Resource instanceResource = model;
	Collection<NotificationResourceLoader.RawEventInformation> rawEventInformationList = NotificationResourceLoader.loadTrace(traceFilename);

	return convertToNotifications(instanceResource, rawEventInformationList);
    }



    private Collection<Notification> convertToNotifications(Resource resource, Collection<NotificationResourceLoader.RawEventInformation> eventInformationList){
        ArrayList<Notification> notificationList = new ArrayList<Notification>();

        for (NotificationResourceLoader.RawEventInformation rawInformation : eventInformationList) {
            // FIXME: Conversion only works for AttributeValueChanges at the moment. Add support for all event types
            // FIXME: By adding support for more events the following if condition must be refactored
            if (rawInformation.getEventType().equals("AttributeValueChangeEvent")) {
        	String mofId = rawInformation.getAttributeMap().get("MRI").split("#")[1];
        	EObject obj = resource.getEObject(mofId);

        	EAttribute attribute = null;
        	if (obj != null) {

        	    for (EObject contentObject : obj.eClass().getEAllAttributes()) {
                	    if (contentObject instanceof EAttribute) {
                		if (((EAttribute) contentObject).getName().equals(rawInformation.getAttributeMap().get("attribute"))) {
                		    attribute = (EAttribute) contentObject;
                		}
                	    }
        	    }

        	    //TODO: Move modifying model to replay notifications into special class
        	    obj.eSet(attribute, rawInformation.getAttributeMap().get("newValue"));
        	    notificationList.add(NotificationHelper.createAttributeChangeNotification(obj, attribute, rawInformation
        		    .getAttributeMap().get("oldValue"), rawInformation.getAttributeMap().get("newValue")));
        	}else{
        	    System.out.println("Element with MOFID: " + mofId + " cannot be found in Resource");
        	}
            }
        }

        return notificationList;
    }
}
