package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.solution.eventManager.util.NotificationHelper;

class MyNotification extends NotificationImpl {

    private Object feature;
    private Notifier notifier;

    /**
     * @return the feature
     */
    public Object getFeature() {
        return feature;
    }

    /**
     * @return the notifier
     */
    public Notifier getNotifier() {
        return notifier;
    }

    public MyNotification(int eventType, Object oldValue, Object newValue, Notifier noti, Object feature) {
        super(eventType, oldValue, newValue);
        this.feature = feature;
        this.notifier = noti;
    }

}

public class RecursiveContaimentNotificationCreator {

    public static Collection<Notification> createNotificationForComposites(Notification event) {
        Set<Notification> result = new HashSet<Notification>();
        Object f = event.getFeature();
        if (f != null && f instanceof EReference && ((EReference) f).isContainment()) {
            handleValues(event, result);
        } else if (f == null && (event.getNotifier() instanceof Resource)) {
            handleValues(event, result);
        }
        result.add(event);

        return result;

    }

    private static void handleValues(Notification event, Set<Notification> result) {
        Object value = NotificationHelper.isAddEvent(event) ? event.getNewValue() : event.getOldValue();
        if (NotificationHelper.isManyEvent(event)) {
            assert (value instanceof Collection<?>);
            Collection<?> valueCol = (Collection<?>) value;
            for (Object o : valueCol) {
                if (o instanceof EObject) {
                    addNotification((EObject) o, NotificationHelper.isAddEvent(event), event, result);
                }
            }
        }else{
            if (value instanceof EObject) {
                addNotification((EObject) value, NotificationHelper.isAddEvent(event), event, result);
            }
        }
    }

    private static void addNotification(EObject o, boolean add, Notification event, Set<Notification> result) {
        for (EStructuralFeature ref : o.eClass().getEAllStructuralFeatures()) {
            //init new Notification
            Notification notification=null;
            
            Object valueOfRef = o.eGet(ref);
            
            if(valueOfRef==null){
                //no value so nothing to do here
                continue;
            }
            if (ref.isMany()) {
                //can cast value to list
                EList<?> values = (EList<?>) valueOfRef;
                switch (values.size()) {
                case 0: {
                    // no content
                    break;
                }
                case 1: {
                    //create single add notification
                    notification= new MyNotification(add ? Notification.ADD : Notification.REMOVE, add ? null : values
                            .get(0), !add ? null : values.get(0), o, ref);
                    
                    break;
                }

                default:{
                    //create many add notification
                    notification= new MyNotification(add ? Notification.ADD_MANY : Notification.REMOVE_MANY, add ? null : values
                            , !add ? null : values,  o, ref);
                    
                    break;
                }
                }

            }else{
                //simple set notification
                    notification= new MyNotification(Notification.SET, add ? null : valueOfRef
                            , !add ? null : valueOfRef, o, ref);
                
            }
            if(notification!=null ){
                //recursive call for new notification
                if(ref instanceof EReference && ((EReference)ref).isContainment()){
                    handleValues(notification, result);
                }
                result.add(notification);
            }
            
        }
    }
}
