package com.sap.tc.moin.friends.ide.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.friends.ide.IdePrimaryFacilityUtil;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;


public class IdeUtilitiesFactory {

    volatile private static IdePrimaryFacilityUtil facilityUtil;



    public static IdePrimaryFacilityUtil getFacilityUtil( ) throws MoinBaseRuntimeException {

        if ( facilityUtil == null ) {
            facilityUtil = (IdePrimaryFacilityUtil) getUtil( "com.sap.tc.moin.friends.ide.impl.IdePrimaryFacilityUtilImpl" ); //$NON-NLS-1$
        }
        return facilityUtil;
    }



    private static Object getUtil( String className ) throws MoinBaseRuntimeException {

        MoinLocalizedString message = IdeUtilitiesMessages.GETUTILFAILED;
        try {
            Class facilityUtilClass = Class.forName( className );
            Constructor myConstructor = facilityUtilClass.getConstructor( );
            Object myInstance = myConstructor.newInstance( );
            return myInstance;
        } catch ( SecurityException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( IllegalArgumentException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( ClassNotFoundException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( NoSuchMethodException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( InstantiationException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( IllegalAccessException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        } catch ( InvocationTargetException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, message );
        }
    }

}
