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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;


/**
 * The {@link RealWorldReplayNotificationProducer} produces {@link Notification}s out of
 * a event trace which was created in MOIN by printing Event.toString(); on several events.
 *
 * At the moment, it is not guaranteed that all types of events can be easily replayed.
 * In fact, the following event types are supported at the moment:
 * - AttributeValueChangeEvent
 *
 * @author Manuel Holzleitner (D049667)
 */
public class RealWorldReplayNotificationProducer implements NotificationProducer {

    /**
     * Produces a list of notifications out of a trace and model fixture. Therefore this fixtures
     * must always be added to the fixtures folder in de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications
     *
     * @param modelFilename
     * @param traceFilename
     * @return Collection of notifications which can be created out of
     */
    public Collection<RawNotification> produce(String traceFilename){
    	return NotificationResourceLoader.loadTrace(traceFilename);
    }
}
