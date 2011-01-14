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
package org.eclipse.ocl.examples.eventmanager.framework;

import java.lang.ref.WeakReference;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.ocl.examples.eventmanager.EventManager;


/**
 * The <code>Notifier</code> encapsulates the knowledge how to notify the listeners.
 * 
 * @author Daniel Vocke (D044825)
 */
public class AdapterCapsule {

    /**
     * the listener that will be notified when an event is fired.
     */
    protected WeakReference<? extends Adapter> _listener = null;

    /**
     * the type of the listener that will be notified.
     */
    protected ListenerTypeEnum _listenerType = null;

    protected EventManager _manager;
    
    public AdapterCapsule(WeakReference<? extends Adapter> listener, ListenerTypeEnum listenerType, EventManager manager) {
        _listener = listener;
        _listenerType=listenerType;
        _manager = manager;
    }

    /**
     * @return the listener associated to this notifier
     */
    public WeakReference<? extends Adapter> getListener() {
        return _listener;
    }

    /**
     * Each Notifier is responsible for exactly one listener and its role. If a listener implements multiple roles (Pre_Op, Post_Op,postCommit-Listener)
     * then for each role another instance of <code>Notifier</code> handles the invocation of the listener's <code>notify</code> method.
     * 
     * @param listener the instance of the listener
     * @param listenerType the role of the listener that shall be notified
     * @return whether this instance is responsible for the listener-instance and the specified role or not.
     */
    public boolean isResponsibleFor(Adapter listener, ListenerTypeEnum listenerType){
        if (_listener !=null && _listener.get()!=null && _listener.get().equals(listener) && _listenerType.matches(listenerType))
            return true;
        else
            return false;
    }
    
    /**
     * @return the type of the listener that this Notifier will notify
     */
    public ListenerTypeEnum getListenerType(){
        return _listenerType;
    }
    /**
     * This method is defined here because of convenience reasons. The implementation can be found in subclasses.
     * 
     * @param connection
     */
    public void deferNotification(){
        /*
         * do nothing. Deferment is implemented in the subclass DeferringNotifier.
         */
    }
    
    /**
     * This method is defined here because of convenience reasons. The implementation can be found in subclasses.
     * @param connection
     */
    public void deliverDeferredEvents(){
        /*
         * do nothing. Deferment is implemented in the subclass DeferringNoptifier
         */
    }
    
    /**
     * This method is defined here because of convenience reasons. The implementation can be found in subclasses.
     * @param connection
     */
    public void cancelDeferment(){
        /*
         * do nothing. Deferment is implemented in the subclass DeferringNoptifier
         */
    }
    /**
     * notifies the encapsulated listener about the passed event
     * 
     * @param event the event that will be sent to the listener
     */
    public void fireEvent(Notification event) {
        /*
         * 
         */
        ListenerTypeEnum dedicatedListenerType = getDedicatedListenerType(event);
        if (!dedicatedListenerType.matches(_listenerType))
        {
            //ERROR!!! This may not happen!
            //TODO log and throw exception
        }
        
        if (dedicatedListenerType.matches(ListenerTypeEnum.preChange)) {
            try {
                _listener.get().notifyChanged(event);
            } catch (VetoException e) {
                // VetoExceptions are OK, so pass them on to the next exception block
                throw e;
            } catch (Exception e) {
                //TODO
                e.printStackTrace();
            }
        } else if (dedicatedListenerType.matches(ListenerTypeEnum.postChange)) {
            try {
                _listener.get().notifyChanged(event);
            } catch (VetoException e) {
                // VetoExceptions are OK, so pass them on to the next exception block
                throw e;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            //ERROR The deferredNotifier must handle other types of invocation!!!
            //TODO log and throw exception
        }
    }

    private org.eclipse.ocl.examples.eventmanager.framework.ListenerTypeEnum getDedicatedListenerType(Notification event) {

        return ListenerTypeEnum.postChange;
        
    }

    /**
     * @return "DeferringNotifier for Pre_Commit_Tx Listener " for example
     */
    public String toString(){
        return getClass().getName()+" for "+ _listenerType.toString();
    }
}
