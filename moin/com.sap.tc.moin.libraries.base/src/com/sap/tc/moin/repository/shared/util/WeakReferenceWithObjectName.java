package com.sap.tc.moin.repository.shared.util;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

import javax.management.ObjectName;

import com.sap.tc.moin.repository.shared.util.HousekeepingThread.ActionOnBeingGarbageCollectedProvider;
import com.sap.tc.moin.repository.spi.jmx.SpiJmxHelper;

/**
 * This subclass of {@link java.lang.ref.WeakReference} is used by the JMX
 * instrumentation. It registers itself with the give reference queue and holds
 * a JMX {@link ObjectName} as additional information. After garbage collection,
 * it unregisters the MBean with this object name.
 */
public final class WeakReferenceWithObjectName<T> extends WeakReference<T> implements ActionOnBeingGarbageCollectedProvider {

    private final ObjectName objectName;

    public WeakReferenceWithObjectName( T referent, ObjectName objectName, ReferenceQueue<T> refQueue ) {

        super( referent, refQueue );
        this.objectName = objectName;
    }

    public void actionOnBeingGarbageCollected( Reference referenceToObjectWhichHasBeenGarbageCollected ) {

        SpiJmxHelper.unregisterMBean( objectName );
    }
}