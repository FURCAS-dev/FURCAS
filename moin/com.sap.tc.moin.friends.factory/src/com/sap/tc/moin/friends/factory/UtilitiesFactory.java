package com.sap.tc.moin.friends.factory;

import com.sap.tc.moin.friends.ConnectionUtil;
import com.sap.tc.moin.friends.MetaModelChecker;
import com.sap.tc.moin.friends.ModelElementNameGenerator;
import com.sap.tc.moin.friends.MoinUtil;
import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.friends.core.CoreUtilitiesFactory;
import com.sap.tc.moin.repository.exception.MoinBaseRuntimeException;

public class UtilitiesFactory {

    /**
     * MetaModelChecker
     * 
     * @return MetaModelChecker instance
     * @throws MoinBaseRuntimeException
     */
    public static MetaModelChecker getMetaModelChecker( ) throws MoinBaseRuntimeException {

        return CoreUtilitiesFactory.getMetaModelChecker( );
    }

    /**
     * ModelElementNameGenerator
     * 
     * @return ModelElementNameGenerator instance
     * @throws MoinBaseRuntimeException
     */
    public static ModelElementNameGenerator getModelElementNameGenerator( ) throws MoinBaseRuntimeException {

        return CoreUtilitiesFactory.getModelElementNameGenerator( );
    }

    /**
     * ConnectionUtil
     * 
     * @return ConnectionUtil instance
     * @throws MoinBaseRuntimeException
     */
    public static ConnectionUtil getConnectionUtil( ) throws MoinBaseRuntimeException {

        return CoreUtilitiesFactory.getConnectionUtil( );
    }

    /**
     * RefObjectUtil
     * 
     * @return RefObjectUtil instance
     * @throws MoinBaseRuntimeException
     */
    public static RefObjectUtil getRefObjectUtil( ) throws MoinBaseRuntimeException {

        return CoreUtilitiesFactory.getRefObjectUtil( );
    }

    /**
     * MoinUtil
     * 
     * @return MoinUtil instance
     * @throws MoinBaseRuntimeException
     */
    public static MoinUtil getMoinUtil( ) throws MoinBaseRuntimeException {

        return CoreUtilitiesFactory.getMoinUtil( );
    }

}
