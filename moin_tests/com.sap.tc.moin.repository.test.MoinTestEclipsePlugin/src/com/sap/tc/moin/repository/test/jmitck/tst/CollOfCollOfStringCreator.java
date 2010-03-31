package com.sap.tc.moin.repository.test.jmitck.tst;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * ObjectCreator for creating instances of Collections conforming to the
 * CollOfCollOfString type. This type defines a collection whose elements are
 * CollOfString type.
 */
@SuppressWarnings( "nls" )
public class CollOfCollOfStringCreator implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new Collection of two collections, where each of those
     * collections contain a number of Strings.
     * 
     * @param initValues ignored in this implementation.
     * @param root ignored in this implementation.
     * @return a new Collection conforming to the CollOfCollOfString type.
     */
    public Object createObject( String initValues, RefPackage root ) {

        List<Object> args = new ArrayList<Object>( );
        List<String> elements = new ArrayList<String>( );
        elements.add( "ninetynine" );
        elements.add( "ninetyeight" );
        args.add( elements );
        elements = new ArrayList<String>( );
        elements.add( "noventa nueve" );
        elements.add( "noventa ocho" );
        elements.add( "noventa siete" );
        args.add( elements );
        return args;
    }
}
