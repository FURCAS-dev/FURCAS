/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifier;
import de.hpi.sam.bp2009.solution.eventManager.NotificationIdentifierBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EventManagerImpl extends EObjectImpl implements EventManager {
    private class EventAdapter extends EContentAdapter{
        @Override
        public void notifyChanged(Notification notification) {
            super.notifyChanged(notification);
            handleEMFEvent(notification);	
        }
    }
    private EventAdapter adapter = new EventAdapter();
    private HashMap<NotificationIdentifier, Set<Adapter>> identifierToListener = new HashMap<NotificationIdentifier, Set<Adapter>>();
    private NotificationIdentifierBuilder bld = EventManagerFactory.eINSTANCE.createNotificationIdentifierBuilder();



    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     */
    protected EventManagerImpl() {
        super();
        this.adapter= new EventAdapter();
    }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return EventManagerPackage.Literals.EVENT_MANAGER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void handleEMFEvent(Notification notification) {
        for(NotificationIdentifier id: bld.buildFrom(notification)){
            for(Adapter a : getListenerList(id)){
                notifyApplication(a, notification, null);
            }
        }

    }
    private Set<Adapter> getListenerList(NotificationIdentifier id) {
        Set<Adapter> rs = identifierToListener.get(id);
        if(rs==null){
            return Collections.emptySet();
        }
        return rs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void notifyApplication(Adapter application, Notification event, EventFilter matchingFilter) {
        application.notifyChanged(event);
    }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void subscribe(EList<Notifier> root, EventFilter filter, Adapter caller) {
        for(Notifier noti: root){
            subscribe(noti, filter, caller);
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public void subscribe(Notifier root, EventFilter filter, Adapter caller) {
        root.eAdapters().add(adapter);
        for(NotificationIdentifier id: filter.buildNotificationIdentifiers(EventManagerFactory.eINSTANCE.createNotificationIdentifier())){
            if(identifierToListener.get(id)==null){
                identifierToListener.put(id, new HashSet<Adapter>());
            }
            getListenerList(id).add(caller);
        }




    }
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public boolean unsubscribe(Adapter caller) {
        boolean result = false;
        for(Set<Adapter> set : identifierToListener.values()){
            result = result?result:set.remove(caller);
        }
        return result;
    }

    @Override
    @Deprecated
    public void subscribeTransactional(EList<Notifier> root,
            EventFilter filter, Adapter caller) {
        // TODO Auto-generated methodsubscribeTransactional stub
        System.out.println("subscribeTransactional");

    }

} //EventManagerImpl
