package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class RealWorldReplayNotificationProducer implements NotificationProducer {

    @Override
    public Collection<Notification> produce() {
	XMLResource instanceResource = loadModel("fixtures/models/NgpmModel.xmi");
	Collection<RawEventInformation> rawEventInformationList = loadTrace("fixtures/eventtraces/primitiveEventTrace.trace");

	return convertToNotifications(instanceResource, rawEventInformationList);
    }

    private XMLResource loadModel(String path) {
	InputStream fileStream = RealWorldReplayNotificationProducer.class.getResourceAsStream(path);

	XMLResource instanceResource = null;
	ResourceSetImpl resultRS;

	resultRS = new ResourceSetImpl();
        resultRS.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi",
        	new XMIResourceFactoryImpl());

        try {
	    instanceResource = (XMLResource)resultRS.createResource(URI.createURI("http://de.hpi.sam.bp2009.solution.impactAnalyzer.benchmarks/test.xmi"));
	    instanceResource.load(fileStream, null);
        } catch (IOException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

        if(instanceResource == null)
            throw new RuntimeException("Not able to create resource");

	return instanceResource;
    }

    private Collection<Notification> convertToNotifications(XMLResource resource, Collection<RawEventInformation> eventInformationList){
	ArrayList<Notification> notificationList = new ArrayList<Notification>();


	for(RawEventInformation rawInformation : eventInformationList){
	    if(rawInformation.getEventType().equals("AttributeValueChangeEvent")){
	    	String mofId = rawInformation.getAttributeMap().get("MRI").split("#")[1];
			EObject obj = resource.getEObject(mofId);

			EAttribute attribute = null;

			for(EObject contentObject : obj.eClass().getEAllAttributes()) {
			    if(contentObject instanceof EAttribute){
			    	if(((EAttribute) contentObject).getName().equals(rawInformation.getAttributeMap().get("attribute"))){
			    	    attribute = (EAttribute)contentObject;
			    	}
			    }
			}

			if(obj != null) {
				obj.eSet(attribute,  rawInformation.getAttributeMap().get("newValue"));

			    notificationList.add(NotificationHelper.createAttributeChangeNotification(obj, attribute, rawInformation.getAttributeMap().get("oldValue"), rawInformation.getAttributeMap().get("newValue")));
			}
	    }
	}

	return notificationList;
    }

    private Collection<RawEventInformation> loadTrace(String path){
	ArrayList<RawEventInformation> informationList = new ArrayList<RawEventInformation>();

	InputStream traceInput = this.getClass().getResourceAsStream(path);
	InputStreamReader ireader = new InputStreamReader(traceInput);
	BufferedReader reader = new BufferedReader(ireader);

	try {
	    while (reader.ready()) {
		String newLine = reader.readLine();
		String[] splitOnOpenBracket = newLine.split("\\(");
		String[] splitOnComma = splitOnOpenBracket[1].split("\\)")[0].split(",");

		HashMap<String, String> hashMap = new HashMap<String, String>();

		for (String attributePair : splitOnComma) {
		    String[] attributePairSplitted = attributePair.split("=");

		    hashMap.put(attributePairSplitted[0], attributePairSplitted[1]);
		}

		informationList.add(new RawEventInformation(splitOnOpenBracket[0], hashMap));
	    }

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return informationList;
    }

    private class RawEventInformation{

	private final String eventType;
	private final Map<String, String> attributeMap;

	public RawEventInformation(String eventType, Map<String, String> attributeMap){
	    this.eventType = eventType;
	    this.attributeMap = attributeMap;
	    // TODO Auto-generated constructor stub
	}

	public String getEventType() {
	    return eventType;
	}

	public Map<String, String> getAttributeMap() {
	    return attributeMap;
	}

    }
}
