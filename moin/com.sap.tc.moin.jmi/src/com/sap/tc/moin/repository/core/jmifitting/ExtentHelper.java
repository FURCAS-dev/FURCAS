package com.sap.tc.moin.repository.core.jmifitting;

import com.sap.tc.moin.repository.core.CoreConnection;

public class ExtentHelper {

    private static final ThreadLocal<Integer> threadExtentIdContainer = new ThreadLocal<Integer>( );

    private static final ThreadLocal<CoreConnection> threadConnectionContainer = new ThreadLocal<CoreConnection>( );

    public static int getCurrentExtentId( ) {

        return threadExtentIdContainer.get( );
    }

    public static void setCurrentExtentId( int extentId ) {

        threadExtentIdContainer.set( extentId );
    }

    public static CoreConnection getCurrentConnection( ) {

        return threadConnectionContainer.get( );
    }

    public static void setCurrentConnection( CoreConnection connection ) {

        threadConnectionContainer.set( connection );
    }
}
