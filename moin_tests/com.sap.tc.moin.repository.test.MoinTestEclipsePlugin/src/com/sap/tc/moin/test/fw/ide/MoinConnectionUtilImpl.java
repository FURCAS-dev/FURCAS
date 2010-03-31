package com.sap.tc.moin.test.fw.ide;

import org.eclipse.core.resources.IProject;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.ide.MoinFactory;


@SuppressWarnings( "nls" )
public class MoinConnectionUtilImpl implements MoinConnectionUtil {

    public Moin getMoinInstance( ) {

        return MoinFactory.getMoinInstance( );
    }

    public Connection createTransientConnection( ) throws Exception {

        // (2) Get the CompoundClientSpecification corresponding to the given infrastructure client ID:
        CompoundDataAreaManager compoundDataAreaManager = ( (IdeCompoundDataAreaManager) ( getMoinInstance( ).getCompoundDataAreaManager( ) ) );
        CompoundClientSpec clientSpecTransientOnly = compoundDataAreaManager.getCompoundClientSpecTransientOnly( );

        // (3) Create the session for the given client spec
        Session session = getMoinInstance( ).createSession( clientSpecTransientOnly );
        Connection connection = session.createConnection( );

        return connection;
    }

}
