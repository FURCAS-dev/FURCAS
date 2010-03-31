package com.sap.tc.moin.repository.test.jmitck.tst;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

/**
 * ObjectCreator for creating instances of Collections conforming to the
 * CollOfString type. This type defines a collection whose elements are Strings
 */
@SuppressWarnings( "nls" )
public class CollOfStringCreator implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    /**
     * Returns a new Collection containing String values.
     * 
     * @param initValues ignored in this implementation.
     * @param root ignored in this implementation.
     * @return a new Collection conforming to the CollOfString type.
     */
    public Object createObject( String initValues, RefPackage root ) {

        List<String> args = new ArrayList<String>( );
        args.add( "ninetynine" );
        args.add( "ninetyeight" );
        return args;
    }
}
