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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

/**
 * A {@link NotificationProducer} creates {@link Notification} in a specified way.
 * They either can create synthesized notifications on synthesized models or
 * simulate real word notifications on real world models.
 *
 * @author Manuel Holzleitner (D049667)
 */
public interface NotificationProducer {
    public Collection<RawNotification> produce(String file);
}
