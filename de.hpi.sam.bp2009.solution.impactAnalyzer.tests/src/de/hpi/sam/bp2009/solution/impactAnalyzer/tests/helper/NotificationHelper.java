package de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class NotificationHelper {
    public static class TestAdapter extends AdapterImpl{
        Notification noti= null;
        public Notification getNoti(){
            return noti;
        }

        @Override
        public void notifyChanged(Notification notification) {
            noti=notification;
            // this adapter removes itself once a notification is caught
            if(getTarget()!=null){
                getTarget().eAdapters().remove(this);
            }
        }
    }// TestAdapter

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
            return myTestA.getNoti();
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
                }
                else {
                    return null;
                }

            } else {
                notifier.eSet(feature, objectToAdd);
            }
            return myTestA.getNoti();
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
            return myTestA.getNoti();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Notification createElementAddNotification(EObject notifier) {
        EReference ref = notifier.eClass().getEAllContainments().get(0);
        EObject newObj = notifier.eClass().getEPackage().getEFactoryInstance().create((EClass) ref.getEType());

        TestAdapter myTestA = new TestAdapter();
        notifier.eAdapters().add(myTestA);

        if (ref.isMany()){
            Object ob = notifier.eGet(ref);
            if (ob != null && ob instanceof EList<?>){
                ((EList<EObject>)ob).add(newObj); 
            }
            else {
                return null;
            }
        }else{
            notifier.eSet(ref, newObj);
        }
        return myTestA.getNoti();
    }

    public static Notification createElementDeleteNotification(EObject notifier){
        TestAdapter myTestA = new TestAdapter();
        notifier.eContainer().eAdapters().add(myTestA);

        EcoreUtil.delete(notifier);

        return myTestA.getNoti();
    }
}
