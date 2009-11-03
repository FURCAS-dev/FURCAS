package com.sap.tc.moin.repository.core.transactions.microtransactionables;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.core.events.AttributeValueAddEventImpl;
import com.sap.tc.moin.repository.core.events.AttributeValueChangeEventImpl;
import com.sap.tc.moin.repository.core.events.AttributeValueRemoveEventImpl;
import com.sap.tc.moin.repository.core.events.ElementCreateEventImpl;
import com.sap.tc.moin.repository.core.events.ElementDeleteEventImpl;
import com.sap.tc.moin.repository.core.events.LinkAddEventImpl;
import com.sap.tc.moin.repository.core.events.LinkRemoveEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionCreateEventImpl;
import com.sap.tc.moin.repository.core.events.PartitionDeleteEventImpl;
import com.sap.tc.moin.repository.events.type.ChangeEvent;

public class EventComparator extends ClassListBasedComparator<ChangeEvent> {

    private static List<Class<?>> eventClasses = new ArrayList<Class<?>>( 9 );

    public static final EventComparator instance = new EventComparator( );

    static {
        // When adding new event classes, remember to adapt the list size!!
        eventClasses.add( PartitionCreateEventImpl.class );
        eventClasses.add( LinkRemoveEventImpl.class );
        eventClasses.add( ElementDeleteEventImpl.class );
        eventClasses.add( ElementCreateEventImpl.class );
        eventClasses.add( LinkAddEventImpl.class );
        eventClasses.add( AttributeValueChangeEventImpl.class );
        eventClasses.add( AttributeValueRemoveEventImpl.class );
        eventClasses.add( AttributeValueAddEventImpl.class );
        eventClasses.add( PartitionDeleteEventImpl.class );
    }

    private EventComparator( ) {

        super( eventClasses );
    }
}
