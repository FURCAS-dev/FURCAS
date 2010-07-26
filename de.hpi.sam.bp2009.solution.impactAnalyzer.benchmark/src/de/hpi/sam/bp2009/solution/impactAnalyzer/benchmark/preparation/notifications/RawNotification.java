package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

public class RawNotification {
    	private final static String LINK_ADD_EVENT = "LinkAddEvent";
    	private final static String LINK_REMOVE_EVENT = "LinkRemoveEvent";
    	private final static String ATTRIBUTE_VALUE_CHANGE_EVENT = "AttributeValueChangeEvent";
    	private final static String ELEMENT_DELETE_EVENT = "ElementDeleteEvent";
    	private final static String ELEMENT_CREATE_EVENT ="ElementCreateEvent";

	private final String eventType;
	private final Map<String, String> attributeMap;

	private int splitNumber = -1;

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


	public boolean isSplitCandidate(){
	    return getEventType().equals(LINK_ADD_EVENT) || getEventType().equals(LINK_REMOVE_EVENT);
	}

	public boolean wasSplitted(){
	    return isSplitCandidate() && splitNumber >= 0;
	}

	public int getSplitNumber(){
	    assert wasSplitted();

	    return splitNumber;
	}

	private void setSplitNumber(int i){
	    assert isSplitCandidate();

	    splitNumber = i;
	}

	public ArrayList<RawNotification> split(){
	    if(!isSplitCandidate())
		throw new RuntimeException("This notification cannot be splitted");

	    ArrayList<RawNotification> result = new ArrayList<RawNotification>();

	    if(getEventType().equals(LINK_ADD_EVENT) || getEventType().equals(LINK_REMOVE_EVENT)){
    		for(int i = 0; i < 2; i++){
    		RawNotification noti = new RawNotification(getEventType(), getAttributeMap());
    		noti.setSplitNumber(i);
    		result.add(noti);
		}
	    }

	    return result;
	}


    public Notification convertToNotification(Resource resource){
            // FIXME: Conversion only works for AttributeValueChanges at the moment. Add support for all event types
            // FIXME: By adding support for more events the following if condition must be refactored
            if (getEventType().equals(ATTRIBUTE_VALUE_CHANGE_EVENT)) {
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
        		String oldValue = getAttributeMap().get("oldValue");
        		String newValue = getAttributeMap().get("newValue");

        		Object oldValueParsed = null;
        		Object newValueParsed = null;


		    if (oldValue.equalsIgnoreCase("true") || oldValue.equalsIgnoreCase("false")) {
			oldValueParsed = Boolean.parseBoolean(oldValue);
			newValueParsed = Boolean.parseBoolean(newValue);
		    }

		    if (oldValueParsed == null || newValueParsed == null) {
			try {
			    oldValueParsed = Integer.parseInt(oldValue);
			    newValueParsed = Integer.parseInt(newValue);
			} catch (NumberFormatException e) {

			}
		    }

		    if (oldValueParsed == null || newValueParsed == null) {
			oldValueParsed = oldValue;
			newValueParsed = newValue;
		    }

			return NotificationHelper.createAttributeChangeNotification(obj, attribute, oldValueParsed, newValueParsed);
        	    }
        	}else{
        	    //System.out.println("Element with MOFID: " + mofId + " cannot be found in Resource");
        	}
            }else if(getEventType().equals(LINK_REMOVE_EVENT)){
        	//System.out.println("LinkRemoveEvent");

        	String mofId1 = getAttributeMap().get("MRI1").split("#")[1];
        	EObject obj1 = resource.getEObject(mofId1);

        	String mofId2 = getAttributeMap().get("MRI2").split("#")[1];
        	EObject obj2 = resource.getEObject(mofId2);

        	if(obj1 != null && obj2 != null){
        	//	System.out.println("Both not null");
        		
        	    if(wasSplitted() && getSplitNumber() == 0){
        	 //   	System.out.println("Split" + 0);
        	    	return createLinkRemoveNotification(obj1, obj2);
        	    }
        	   else if(wasSplitted() && getSplitNumber() == 1){
        	//	   System.out.println("Split" + 1);
        		   return createLinkRemoveNotification(obj2, obj1);
        	   }
        		   
		    else
			return null;
        	}
            }else if(getEventType().equals(LINK_ADD_EVENT)){
        	//System.out.println("LinkAddEvent");

        	String mofId1 = getAttributeMap().get("MRI1").split("#")[1];
        	EObject obj1 = resource.getEObject(mofId1);

        	String mofId2 = getAttributeMap().get("MRI2").split("#")[1];
        	EObject obj2 = resource.getEObject(mofId2);
        	
        	String rolename1 = getAttributeMap().get("AE2");
        	String rolename2 = getAttributeMap().get("AE3");

        	if(obj1 != null && obj2 != null){
        	//	System.out.println("Both not null");
        		
        	    if(wasSplitted() && getSplitNumber() == 0){
        	 //   	System.out.println("Split" + 0);
        	    	return createLinkAddNotification(obj1, obj2, rolename1, rolename2);
        	    }        	    	
        	    else if(wasSplitted() && getSplitNumber() == 1){
        	 //   	System.out.println("Split" + 1);
        	    	return createLinkAddNotification(obj2, obj1, rolename2, rolename1);
        	    }
        	    else
        	    	return null;
        	}
            }else if(getEventType().equals(ELEMENT_DELETE_EVENT)){
        	//System.out.println("ElementDeleteEvent");
        	String mofId = getAttributeMap().get("MRI").split("#")[1];
        	EObject obj = resource.getEObject(mofId);

        	if (obj != null)
		    return NotificationHelper.createElementDeleteNotification(obj);
            }else if(getEventType().equals(ELEMENT_CREATE_EVENT)){
        	//System.out.println("ElementCreateEvent");

        	//FIXME: Change
        	    ClassLoader classLoader = RealWorldReplayNotificationProducer.class.getClassLoader();

        	    try {
        		String type = getAttributeMap().get("type");

        	   	String[] splittedType = type.split("\\.");

        		String clazz = splittedType[splittedType.length - 1];

        		String packagePath = type.split(clazz)[0];

        		String fullPackagePath = packagePath + splittedType[splittedType.length - 2].substring(0,1).toUpperCase() + splittedType[splittedType.length - 2].substring(1) + "Package";

        	        Class<?> aClass = classLoader.loadClass(fullPackagePath);
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

    private Notification createLinkRemoveNotification(EObject obj1, EObject obj2) {
	for(EReference reference : obj1.eClass().getEAllReferences()){
	if(obj1.eGet(reference) != null){
	    if(obj1.eGet(reference) instanceof EList){
	        @SuppressWarnings("unchecked")
	            EList<EObject> eObjectList = (EList<EObject>)obj1.eGet(reference);
		for(EObject referencedObj : eObjectList){
		    if(referencedObj.equals(obj2))
			return NotificationHelper.createReferenceRemoveNotification(obj1, reference, obj2);
		}
	    }else if(obj1.eGet(reference).equals(obj2))
	    	return NotificationHelper.createReferenceRemoveNotification(obj1, reference, obj2);
	}
	}

	return null;
    }

    private Notification createLinkAddNotification(EObject obj1, EObject obj2, String rolename1, String rolename2) {
    	Notification result = null;
	for(EReference reference : obj1.eClass().getEAllReferences()){
		if(reference.getEType().isInstance(obj2)){
			//System.out.println("Match1");
			if(reference.getName().equals(rolename1) || reference.getName().equals(rolename2)){
				//System.out.println("Match2");
				result = NotificationHelper.createReferenceAddNotification(obj1, reference, obj2);
			}
		}
	}

	return result;
    }
}
