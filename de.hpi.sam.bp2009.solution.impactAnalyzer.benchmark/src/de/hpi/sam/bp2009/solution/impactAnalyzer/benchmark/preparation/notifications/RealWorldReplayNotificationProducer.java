package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
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
	return produce("shortEventTrace.trace");
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
        	System.out.println("AttributeValueChangeEvent");
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

        	    if(attribute != null){
                	    //TODO: Move modifying model to replay notifications into special class
                	    //obj.eSet(attribute, rawInformation.getAttributeMap().get("newValue"));

                	    notificationList.add(NotificationHelper.createAttributeChangeNotification(obj, attribute, rawInformation
                		    .getAttributeMap().get("oldValue"), rawInformation.getAttributeMap().get("newValue")));
        	    }
        	}else{
        	    System.out.println("Element with MOFID: " + mofId + " cannot be found in Resource");
        	}
            }else if(rawInformation.getEventType().equals("LinkRemoveEvent")){
        	System.out.println("LinkRemoveEvent");
        	String mofId1 = rawInformation.getAttributeMap().get("MRI1").split("#")[1];
        	EObject obj1 = resource.getEObject(mofId1);

        	String mofId2 = rawInformation.getAttributeMap().get("MRI1").split("#")[1];
        	EObject obj2 = resource.getEObject(mofId2);

        	if(obj1 != null && obj2 != null){
        	    System.out.println("Both not null");

        	    for(EStructuralFeature reference : obj1.eClass().getEAllStructuralFeatures()){
        		if(obj1.eGet(reference) != null){
        		    if(obj1.eGet(reference) instanceof EList){
        		        @SuppressWarnings("unchecked")
                                EList<EObject> eObjectList = (EList<EObject>)obj1.eGet(reference);
        			for(EObject referencedObj : eObjectList){
        			    if(referencedObj.equals(obj2)){
        				System.out.println("Reference 1 found 1");
        			    }
        			}
        		    }else if(obj1.eGet(reference).equals(obj2)){
        			System.out.println("Reference 1 found 2");
        		    }
        		}
        	    }
        	    /*
        	    for(EReference reference : obj2.eClass().getEAllReferences()){
        		if(obj2.eGet(reference) != null && obj2.eGet(reference).equals(obj1)){
        		    System.out.println("Reference 2 found");
        		}
        	    }*/
        	}


            }else if(rawInformation.getEventType().equals("ElementDeleteEvent")){
        	System.out.println("ElementDeleteEvent");
        	String mofId = rawInformation.getAttributeMap().get("MRI").split("#")[1];
        	EObject obj = resource.getEObject(mofId);

        	if (obj != null) {
        	    notificationList.add(NotificationHelper.createElementDeleteNotification(obj));
        	}
            }else if(rawInformation.getEventType().equals("ElementCreateEvent")){
        	System.out.println("ElementCreateEvent");

        	    ClassLoader classLoader = RealWorldReplayNotificationProducer.class.getClassLoader();


        	    try {
        		String clazz = "NativeImpl";

        	        Class<?> aClass = classLoader.loadClass("data.classes.ClassesPackage");
        	        Field instance = aClass.getField("eINSTANCE");
        	        EPackage pack= (EPackage)instance.get(null);


        	        Method thisMethod = pack.getClass().getDeclaredMethod("get" + clazz);
        	        // call the method
        	        EClass classToCreate = (EClass)thisMethod.invoke(pack);

        	        EObject obj = pack.getEFactoryInstance().create(classToCreate);

        	        NotificationHelper.createNewElementAddToResourceNotification(obj, resource);

        	        ((XMLResource)resource).setID(obj, rawInformation.getAttributeMap().get("MRI").split("#")[1]);
        	    } catch (ClassNotFoundException e) {
        	           e.printStackTrace();
        	    } catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    } catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
            }


        }

        return notificationList;
    }
}
