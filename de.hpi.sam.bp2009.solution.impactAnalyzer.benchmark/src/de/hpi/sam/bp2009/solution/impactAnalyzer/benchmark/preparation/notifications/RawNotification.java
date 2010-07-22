package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

public class RawNotification {
	private final String eventType;
	private final Map<String, String> attributeMap;

	public RawNotification(String eventType, Map<String, String> attributeMap){
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


    public Notification convertToNotification(Resource resource){
            // FIXME: Conversion only works for AttributeValueChanges at the moment. Add support for all event types
            // FIXME: By adding support for more events the following if condition must be refactored
            if (getEventType().equals("AttributeValueChangeEvent")) {
        	//System.out.println("AttributeValueChangeEvent");
        	
        	String mofId = getAttributeMap().get("MRI").split("#")[1];
        	EObject obj = resource.getEObject(mofId);

        	EAttribute attribute = null;
        	if (obj != null) {

        	    for (EObject contentObject : obj.eClass().getEAllAttributes()) {
                	    if (contentObject instanceof EAttribute) {
                		if (((EAttribute) contentObject).getName().equals(getAttributeMap().get("attribute"))) {
                		    attribute = (EAttribute) contentObject;
                		}
                	    }
        	    }

        	    if(attribute != null){
                	    //TODO: Move modifying model to replay notifications into special class
                	    //obj.eSet(attribute, rawInformation.getAttributeMap().get("newValue"));
                	    	return NotificationHelper.createAttributeChangeNotification(obj, attribute, getAttributeMap().get("oldValue"), getAttributeMap().get("newValue"));

        	    }
        	}else{
        	    //System.out.println("Element with MOFID: " + mofId + " cannot be found in Resource");
        	}
            }else if(getEventType().equals("LinkRemoveEvent")){
        	//System.out.println("LinkRemoveEvent");
        	/*String mofId1 = getAttributeMap().get("MRI1").split("#")[1];
        	
        	EObject obj1 = resource.getEObject(mofId1);

        	String mofId2 = getAttributeMap().get("MRI1").split("#")[1];
        	EObject obj2 = resource.getEObject(mofId2);

        	if(obj1 != null && obj2 != null){
        	    //System.out.println("Both not null");

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
        	    
        	    for(EReference reference : obj2.eClass().getEAllReferences()){
        		if(obj2.eGet(reference) != null && obj2.eGet(reference).equals(obj1)){
        		    System.out.println("Reference 2 found");
        		}
        	    }
        	}*/
            }else if(getEventType().equals("ElementDeleteEvent")){
        	//System.out.println("ElementDeleteEvent");
        	String mofId = getAttributeMap().get("MRI").split("#")[1];
        	EObject obj = resource.getEObject(mofId);

        	if (obj != null) {
        			return NotificationHelper.createElementDeleteNotification(obj);

        	}
            }else if(getEventType().equals("ElementCreateEvent")){
        	//System.out.println("ElementCreateEvent");

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
        	        

        	        	Notification res = NotificationHelper.createNewElementAddToResourceNotification(obj, resource);
             	    	((XMLResource)resource).setID(obj, getAttributeMap().get("MRI").split("#")[1]);
             	    	return res;
        	        
        	        
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


        return null;
    }
}
