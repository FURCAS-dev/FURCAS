package de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class NotificationHelper {
    public static class TestAdapter extends AdapterImpl{
        private Notification noti= null;

        @Override
        public void notifyChanged(Notification notification) {
            setNoti(notification);
        }

        /**
         * @param noti the {@link Notification} to set
         */
        void setNoti(Notification noti) {
            this.noti = noti;
        }

        /**
         * @return the {@link Notification}
         */
        Notification getNoti() {
            return noti;
        }
    }// TestAdapter

    private static Notification getNotificationfrom(TestAdapter adapter){
        Notification noti = adapter.getNoti();
        // this adapter removes itself once a notification is caught
        if(adapter.getTarget()!=null){
            adapter.getTarget().eAdapters().remove(adapter);
        }
        return noti;
    }
    
    public static Notification createAttributeChangeNotification(EObject notifier, EAttribute feature, Object oldValue, Object newValue) {
        EDataType dataType = feature.getEAttributeType();
        boolean validOldValue = dataType.isInstance(oldValue) || 
        (feature.isMany() && oldValue instanceof EList<?> && dataType.isInstance(((EList<?>)oldValue).get(0)));
        boolean validNewValue = dataType.isInstance(newValue) ||
        (feature.isMany() && newValue instanceof EList<?> && dataType.isInstance(((EList<?>)newValue).get(0)));

        if (feature.isChangeable() && validOldValue && validNewValue){
            notifier.eSet(feature, oldValue);
            TestAdapter myTestA = new TestAdapter();
            notifier.eAdapters().add(myTestA);
            notifier.eSet(feature, newValue);
            return getNotificationfrom(myTestA);
        }
        return null;                
    }

    @SuppressWarnings("unchecked")
    public static Notification createReferenceAddNotification(EObject notifier, EReference feature, EObject objectToAdd){
        boolean validObjectToAdd = feature.getEType().isInstance(objectToAdd);

        if (feature.isChangeable() && validObjectToAdd){
            TestAdapter myTestA = new TestAdapter();
            notifier.eAdapters().add(myTestA);

            if (feature.isMany()){
                Object ob = notifier.eGet(feature);
                if (ob != null && ob instanceof EList<?>){
                    ((EList<EObject>)ob).add(objectToAdd); 
                } else {
                    return null;
                }
            } else {
                notifier.eSet(feature, objectToAdd);
            }
            return getNotificationfrom(myTestA);
        }
        return null;                
    }

    @SuppressWarnings("unchecked")
    public static Notification createReferenceRemoveNotification(EObject notifier, EReference feature, EObject objectToRemove){
        boolean validObjectToAdd = feature.getEType().isInstance(objectToRemove);
        if (feature.isChangeable() && validObjectToAdd){
            TestAdapter myTestA = new TestAdapter();
            notifier.eAdapters().add(myTestA);

            if (feature.isMany()){
                Object ob = notifier.eGet(feature);
                if (ob != null && ob instanceof EList<?>){
                    ((EList<EObject>)ob).remove(objectToRemove); 
                } else {
                    return null;
                }                               
            } else {
                notifier.eUnset(feature);
            }
            return getNotificationfrom(myTestA);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Notification createElementAddNotification(EObject container, EReference ref, EObject target) {
        TestAdapter myTestA = new TestAdapter();
        container.eAdapters().add(myTestA);

        if (ref.isMany()){
            Object ob = container.eGet(ref);
            if (ob != null && ob instanceof EList<?>){
                ((EList<EObject>)ob).add(target); 
            }
            else {
                return null;
            }
        }else{
            container.eSet(ref, target);
        }
        return getNotificationfrom(myTestA);
    }

    public static Notification createElementDeleteNotification(EObject notifier){
        TestAdapter myTestA = new TestAdapter();
        notifier.eContainer().eAdapters().add(myTestA);

        EcoreUtil.delete(notifier);

        return getNotificationfrom(myTestA);
    }
}
