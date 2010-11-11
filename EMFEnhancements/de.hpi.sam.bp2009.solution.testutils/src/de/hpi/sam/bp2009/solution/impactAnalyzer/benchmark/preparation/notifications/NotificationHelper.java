/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EEnumImpl;
import org.eclipse.emf.ecore.impl.EEnumLiteralImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

public class NotificationHelper {
    public static class TestAdapter extends AdapterImpl {
        private Notification noti = null;

        @Override
        public void notifyChanged(Notification notification) {
            setNoti(notification);
        }

        /**
         * @param noti
         *            the {@link Notification} to set
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

    private static Notification getNotificationfrom(TestAdapter adapter) {
        Notification noti = adapter.getNoti();
        // this adapter removes itself once a notification is caught
        if (adapter.getTarget() != null) {
            adapter.getTarget().eAdapters().remove(adapter);
        }
        return noti;
    }

    public static Notification createAttributeChangeNotification(EObject notifier, EAttribute feature, Object oldValue,
            Object newValue) {
        EDataType dataType = feature.getEAttributeType();

        boolean validOldValue = oldValue == null || dataType.isInstance(oldValue)
                || (feature.isMany() && oldValue instanceof EList<?> && dataType.isInstance(((EList<?>) oldValue).get(0))
                || dataType instanceof EEnumImpl && oldValue instanceof EEnumLiteralImpl && ((EEnumLiteralImpl)oldValue).getEEnum().equals(dataType));
        boolean validNewValue = dataType.isInstance(newValue)
                || (feature.isMany() && newValue instanceof EList<?> && dataType.isInstance(((EList<?>) newValue).get(0))
                || dataType instanceof EEnumImpl && newValue instanceof EEnumLiteralImpl && ((EEnumLiteralImpl)newValue).getEEnum().equals(dataType));

        if (feature.isChangeable() && validOldValue && validNewValue) {
            if (oldValue != null) {
                notifier.eSet(feature, oldValue);
            }
            TestAdapter myTestA = new TestAdapter();
            notifier.eAdapters().add(myTestA);
            notifier.eSet(feature, newValue);
            return getNotificationfrom(myTestA);
        }

        System.err.println("Warning! Invalid parameters for NotificationHelper#createAttributeChangeNotification");
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Notification createReferenceAddNotification(EObject notifier, EReference feature, EObject objectToAdd) {
        boolean validObjectToAdd = feature.getEType().isInstance(objectToAdd);

        if (feature.isChangeable() && validObjectToAdd) {
            TestAdapter myTestA = new TestAdapter();
            notifier.eAdapters().add(myTestA);

            if (feature.isMany()) {
                Object ob = notifier.eGet(feature);
                if (ob != null && ob instanceof EList<?>) {
                    ((EList<EObject>) ob).add(objectToAdd);
                } else {
                    System.err.println("Warning! Invalid parameters for NotificationHelper#createReferenceAddNotification");
                    return null;
                }
            } else {
                notifier.eSet(feature, objectToAdd);
            }
            return getNotificationfrom(myTestA);
        }
        System.err.println("Warning! Invalid parameters for NotificationHelper#createReferenceAddNotification");
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Notification createReferenceRemoveNotification(EObject notifier, EReference feature, EObject objectToRemove) {
        boolean validObjectToAdd = feature.getEType().isInstance(objectToRemove);
        if (feature.isChangeable() && validObjectToAdd) {
            TestAdapter myTestA = new TestAdapter();
            notifier.eAdapters().add(myTestA);

            if (feature.isMany()) {
                Object ob = notifier.eGet(feature);
                if (ob != null && ob instanceof EList<?>) {
                    ((EList<EObject>) ob).remove(objectToRemove);
                } else {
                    System.err.println("Warning! Invalid parameters for NotificationHelper#createReferenceRemoveNotification");
                    return null;
                }
            } else {
                notifier.eUnset(feature);
            }
            return getNotificationfrom(myTestA);
        }
        System.err.println("Warning! Invalid parameters for NotificationHelper#createReferenceRemoveNotification");

        return null;
    }

    @SuppressWarnings("unchecked")
    public static Notification createReferenceChangeNotification(EObject notifier, EReference feature, EObject from, EObject to) {
        boolean validFrom = feature.getEType().isInstance(from) || (from == null && to != null);
        boolean validTo = feature.getEType().isInstance(to) || (to == null && from != null);
        if (feature.isChangeable() && validFrom && validTo) {
            TestAdapter myTestA = new TestAdapter();
            notifier.eAdapters().add(myTestA);

            if (feature.isMany()) {
                Object ob = notifier.eGet(feature);

                if (ob != null && ob instanceof EList<?>) {
                    EList<EObject> newValue = (EList<EObject>) ob;
                    if (from != null) {
                        newValue.remove(from);
                    }
                    if (to != null) {
                        newValue.add(to);
                    }
                    notifier.eSet(feature, newValue);
                } else {
                    System.err.println("Warning! Invalid parameters for NotificationHelper#createReferenceChangeNotification");
                    return null;
                }
            } else {
                notifier.eSet(feature, to);
            }
            return getNotificationfrom(myTestA);
        }
        System.err.println("Warning! Invalid parameters for NotificationHelper#createReferenceChangeNotification");
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Notification createElementAddNotification(Notifier container, EReference ref, EObject target) {
        TestAdapter myTestA = new TestAdapter();
        container.eAdapters().add(myTestA);

        if (ref != null) {
            if (ref.isMany()) {
                Object ob = ((EObject) container).eGet(ref);
                if (ob != null && ob instanceof EList<?>) {
                    ((EList<EObject>) ob).add(target);
                } else {
                    System.err.println("Warning! Invalid parameters for NotificationHelper#createElementAddNotification");
                    return null;
                }
            } else {
                ((EObject) container).eSet(ref, target);
            }
        } else {
            // container is a Resource or ResourceSet
            if (container instanceof Resource){
                ((Resource)container).getContents().add(target);
            } else {
		throw new IllegalArgumentException("Events for adding Resources to ResourceSets should not reach the ImpactAnalyzer.");
	    }
        }
        return getNotificationfrom(myTestA);
    }

    public static Notification createElementDeleteNotification(EObject target) {
        TestAdapter myTestA = new TestAdapter();
        if(target.eContainer() != null){
        	target.eContainer().eAdapters().add(myTestA);
        }else{
        	//System.out.println("Resource delete");
        	target.eResource().eAdapters().add(myTestA);
        }

        EcoreUtil.delete(target);
        return getNotificationfrom(myTestA);
    }

    public static Notification createChangeLowerMultiplicityNotification(TypeDefinition notifier, int value) {
        TestAdapter myTestA = new TestAdapter();
        notifier.eAdapters().add(myTestA);
        notifier.setLowerMultiplicity(value);
        return getNotificationfrom(myTestA);
    }

    public static Notification createNewElementAddToResourceNotification(EObject objectToAdd, Resource target) {
        TestAdapter myTestA = new TestAdapter();
        target.eAdapters().add(myTestA);
        target.getContents().add(objectToAdd);
        return getNotificationfrom(myTestA);
    }

    public static Notification createChangeClazzNotification(ClassTypeDefinition notifier, SapClass value) {
        TestAdapter myTestA = new TestAdapter();
        notifier.eAdapters().add(myTestA);
        notifier.setClazz(value);
        return getNotificationfrom(myTestA);
    }
}
