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
package org.eclipse.ocl.examples.impactanalyzer.benchmark.preparation.notifications;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * The {@link NotificiationForModelList} encapsulates a list of notifications for one model
 *
 * @author Manuel Holzleitner (D049667)
 */
public class NotificationForModelList {
    private final Resource model;
    private final List<RawNotification> notificationList;

    public NotificationForModelList(Resource model, List<RawNotification> notificationList){
	this.model = model;
	this.notificationList = notificationList;
    }

    public Resource getModel() {
	return model;
    }

    public List<RawNotification> getNotificationList() {
	return notificationList;
    }

}
