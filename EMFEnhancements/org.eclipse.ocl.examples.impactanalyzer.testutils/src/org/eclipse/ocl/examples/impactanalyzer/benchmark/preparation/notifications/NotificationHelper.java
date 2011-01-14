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

import org.eclipse.emf.common.notify.Notification;

import data.classes.ClassTypeDefinition;
import data.classes.SapClass;
import data.classes.TypeDefinition;

public class NotificationHelper extends org.eclipse.ocl.examples.testutils.NotificationHelper {
    public static Notification createChangeLowerMultiplicityNotification(TypeDefinition notifier, int value) {
        TestAdapter myTestA = new TestAdapter();
        notifier.eAdapters().add(myTestA);
        notifier.setLowerMultiplicity(value);
        return getNotificationfrom(myTestA);
    }

    public static Notification createChangeClazzNotification(ClassTypeDefinition notifier, SapClass value) {
        TestAdapter myTestA = new TestAdapter();
        notifier.eAdapters().add(myTestA);
        notifier.setClazz(value);
        return getNotificationfrom(myTestA);
    }
}
