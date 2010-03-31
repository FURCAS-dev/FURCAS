package com.sap.tc.moin.repository.test.jmitck.tst;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.Aclass;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ColorKind;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.ColorKindEnum;
import com.sap.tc.moin.repository.test.jmitck.tst.simplemodel.SimpleModelPackage;

/**
 * ObjectCreator for creating instances of the Aclass type.
 */
@SuppressWarnings( "nls" )
public class CreateAclass implements com.sap.tc.moin.repository.test.jmitck.modelsem.ObjectCreator {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, CreateAclass.class );

    /**
     * Returns a new Aclass instance. Parses the initValues String for values to
     * pass into the factory method.
     * 
     * @param initValues values to be used in the factory method
     * @param root a SimpleModelPackage instance, the extent for the returned
     * Aclass instance
     * @return a new Aclass instance
     */
    public Object createObject( String initValues, RefPackage root ) {

        int intVal = 0;
        ColorKind color = null;
        List<Integer> intList = new ArrayList<Integer>( );

        if ( ( initValues != null ) && !initValues.equals( "&nbsp;" ) && !initValues.equals( "" ) ) {

            StringTokenizer st = new StringTokenizer( initValues, "," );
            try {
                intVal = Integer.parseInt( st.nextToken( ) );
                color = ColorKindEnum.forName( st.nextToken( ) );
                if ( st.hasMoreTokens( ) ) {
                    String collString = st.nextToken( );
                    // Strip Integer() token off
                    if ( collString.startsWith( "Integer(" ) && collString.endsWith( ")" ) ) {
                        collString = collString.substring( 8, collString.length( ) - 1 );
                    }
                    StringTokenizer st2 = new StringTokenizer( collString, "|" );
                    while ( st2.hasMoreTokens( ) ) {
                        intList.add( new Integer( st2.nextToken( ) ) );
                    }
                }
            } catch ( Throwable th ) {
                log.trace( th, MoinSeverity.INFO, "Caught when attempting to apply the string \"" + initValues + "\" to the factory for Aclass" );
                throw new TestErrorException( "If the complexAttrInitializers " + "parameter is provided, it must be " + "in the format " + "number,color,[number[|number]+]?" );
            }
        }
        Aclass aClass = (Aclass) ( (SimpleModelPackage) root ).getAclass( ).refCreateInstance( );
        aClass.setAttribute( intVal );
        aClass.setColor( color );
        aClass.getAttributeColl( ).addAll( intList );
        return aClass;
    }
}
