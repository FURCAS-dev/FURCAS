/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: TracingAdapter.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.common.label.Label;

public class TracingAdapter extends AdapterImpl
{
	public static final TracingOption NOTIFICATION = new TracingOption("notification"); //$NON-NLS-1$

	private static Map<Integer,String> eventTypes = null;
	
	public static void debugNotification(Object target, Notification notification) {
		if (NOTIFICATION.isActive() && (notification.getEventType() != Notification.REMOVING_ADAPTER)) {
			NOTIFICATION.println(Label.labelFor(target)
					+ " <= " + Label.labelFor(notification.getNotifier())
					+ "\n    " + getEventType(notification.getEventType())
					+ " " + getFeatureType(notification)
//					+ " " + getFeatureType(notification.getNotifier().getClass(), featureID)
					+ " " + Label.labelFor(notification.getOldValue())
					+ " => " + Label.labelFor(notification.getNewValue()));
		}
	}

	private static String getEventType(int eventType) {
		if (eventTypes == null) {
			Notification notification = new NotificationImpl(0, 0, 0);
			eventTypes = new HashMap<Integer,String>();
			for (Field field : Notification.class.getFields()) {
				try {
					int value = field.getInt(notification);
					eventTypes.put(Integer.valueOf(value), field.getName());
				} catch (Exception e) {}
			}
		}
		String eventString = eventTypes.get(Integer.valueOf(eventType));
		if (eventString == null)
			return "eventType[" + eventType +"]";
		else
			return eventString;
	}

	private static String getFeatureType(Notification notification) {
		Object feature = notification.getFeature();
		if (feature == null) {
			Object notifier = notification.getNotifier();
			if (notifier instanceof ResourceSet) {
				int featureID = notification.getFeatureID(ResourceSet.class);
				switch (featureID) {
					case ResourceSet.RESOURCE_SET__RESOURCES:
						return "ResourceSet.resources";
					default:
						return "ResourceSet.featureID[" + featureID + "]";
				}
			}
			else if (notifier instanceof Resource) {
				int featureID = notification.getFeatureID(Resource.class);
				switch (featureID) {
					case Resource.RESOURCE__CONTENTS:
						return "Resource.contents";
					case Resource.RESOURCE__ERRORS:
						return "Resource.errors";
					case Resource.RESOURCE__IS_LOADED:
						return "Resource.isLoaded";
					case Resource.RESOURCE__IS_MODIFIED:
						return "Resource.isModified";
					case Resource.RESOURCE__IS_TRACKING_MODIFICATION:
						return "Resource.isTrackingModification";
					case Resource.RESOURCE__RESOURCE_SET:
						return "Resource.resourceSet";
					case Resource.RESOURCE__URI:
						return "Resource.uri";
					case Resource.RESOURCE__WARNINGS:
						return "Resource.warnings";
					default:
						return "Resource.featureID[" + featureID + "]";
				}
			}
			feature = notification.getFeature();
			@SuppressWarnings("unused")
			int featureID = notification.getFeatureID(null);
			return "<null-"+ notifier.getClass().getName() + "-Feature>";
		}
		if (!(feature instanceof EStructuralFeature))
			return "<" + feature.getClass().getName() + "-Feature>";
		return ((EStructuralFeature)feature).getEContainingClass().getName() + "." + ((EStructuralFeature)feature).getName();
	}
	
	/**
	 * Respond to a notification.
	 */
	protected void handleNotification(Notification notification) {}
	
	/**
	 * Provide debug of the notification if tracing selected and
	 * then pass to handleNotification.
	 */
	@Override
	public final void notifyChanged(Notification notification)
	{
		debugNotification(target, notification);
		handleNotification(notification);
	}
}