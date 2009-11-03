package com.sap.tc.moin.repository.test.ocl.ia.evaluation;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.events.type.AttributeValueChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;

/**
 * This is a helper class providing some common methods which are used in
 * various parts of the evaluation.
 * 
 * @author d039141
 */
public class EventPrinter {

    /**
     * Returns the qualified name of a ModelElement as a String
     * 
     * @param e1 the ModelElement
     * @return the qualified name of a ModelElement as a String
     */
    private static String printQName( ModelElement e1 ) {

        List<String> qName = e1.getQualifiedName( );
        if ( qName == null || qName.size( ) == 0 ) {
            return e1.getName( );
        }
        String s = "";
        int index = 0;
        for ( Iterator<String> i = qName.iterator( ); i.hasNext( ); index++ ) {
            s += i.next( );
            if ( index < qName.size( ) - 1 ) {
                s += "::";
            }
        }
        return s;

    }

    /**
     * Turns a ModelChangeEvent into a readable string representation
     * 
     * @param mce the ModelChangeEvent to turn into a string
     * @return a string representing mce in readable way
     */
    public static String printEvent( ModelChangeEvent mce ) {

        StringBuilder s = new StringBuilder( );

        if ( mce instanceof AttributeValueChangeEvent ) {
            AttributeValueChangeEvent avce = (AttributeValueChangeEvent) mce;
            RefObject affectedElement = avce.getAffectedElement( avce.getEventTriggerConnection( ) );
            Attribute attr = avce.getAffectedMetaObject( avce.getEventTriggerConnection( ) );
            s.append( "AttributeValueChangeEvent(" ).append( print( affectedElement ) ).append( ", " ).append( attr.getName( ) ).append( ", " ).append( avce.getNewValue( ) ).append( ", " ).append( avce.getOldValue( ) ).append( ")" );
        } else if ( mce instanceof ElementCreateEvent ) {
            ElementCreateEvent eae = (ElementCreateEvent) mce;
            RefObject affectedElement = eae.getAffectedElement( eae.getEventTriggerConnection( ) );
            s.append( "ElementAddEvent(" ).append( print( affectedElement ) ).append( ")" );
        } else if ( mce instanceof ElementDeleteEvent ) {
            ElementDeleteEvent ere = (ElementDeleteEvent) mce;
            RefObject affectedElement = ere.getAffectedElement( ere.getEventTriggerConnection( ) );
            s.append( "ElementRemoveEvent(" ).append( print( affectedElement ) ).append( ")" );
        } else if ( mce instanceof LinkAddEvent ) {
            LinkAddEvent lae = (LinkAddEvent) mce;
            RefFeatured metaObject = lae.getAffectedMetaObject( lae.getEventTriggerConnection( ) );
            String name = metaObject.refMofId( );
            Object end1 = "";
            Object end2 = "";
            if ( metaObject instanceof Association ) {
                Association assoc = (Association) metaObject;
                end1 = lae.getStoredLinkEndMri( );
                end2 = lae.getNonStoredLinkEndLri( );
                name = assoc.getName( );
            } else if ( metaObject instanceof Reference ) {
                Reference ref = (Reference) metaObject;
                end1 = ref.getExposedEnd( );
                end2 = ref.getReferencedEnd( );
                name = ref.getName( );
            }

            s.append( "LinkAddEvent(" ).append( name ).append( ", " ).append( print( end1 ) ).append( ", " ).append( print( end2 ) ).append( ")" );
        } else if ( mce instanceof LinkRemoveEvent ) {
            LinkRemoveEvent lre = (LinkRemoveEvent) mce;
            RefFeatured metaObject = lre.getAffectedMetaObject( lre.getEventTriggerConnection( ) );
            String name = metaObject.refMofId( );
            Object end1 = "";
            Object end2 = "";
            if ( metaObject instanceof Association ) {
                Association assoc = (Association) metaObject;
                end1 = lre.getStoredLinkEndMri( );
                end2 = lre.getNonStoredLinkEndLri( );
                name = assoc.getName( );
            } else if ( metaObject instanceof Reference ) {
                Reference ref = (Reference) metaObject;
                end1 = ref.getExposedEnd( );
                end2 = ref.getReferencedEnd( );
                name = ref.getName( );
            }
            s.append( "LinkRemoveEvent(" ).append( name ).append( ", " ).append( print( end1 ) ).append( ", " ).append( print( end2 ) ).append( ")" );
        }
        return s.toString( );
    }

    /**
     * @param o
     * @return the String representation
     */
    private static String print( Object o ) {

        if ( o instanceof Classifier ) {
            return EventPrinter.printQName( (Classifier) o );
        } else if ( o instanceof RefObject ) {
            RefObject metaObject = ( (RefObject) o ).refMetaObject( );
            return getName( (RefObject) o ) + ":" + print( metaObject );
        } else {
            return o.toString( );
        }
    }

    /**
     * @param o
     * @return the name
     */
    private static String getName( RefObject o ) {

        try {
            Method m = o.getClass( ).getMethod( "getName", new Class[0] );
            Object res = m.invoke( o, new Object[0] );
            return res.toString( );
        } catch ( Exception e ) {
            return o.refMofId( );
        }

    }
}
