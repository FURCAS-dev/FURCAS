package com.sap.tc.moin.repository.core.impl;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.core.impl.MoinCoreConsistencyChecker.CheckId;

public final class CheckResult {

    private EnumMap<CheckId, List<String>> messages = new EnumMap<CheckId, List<String>>( CheckId.class );

    public void addIncident( CheckId checkId, String message ) {

        List<String> messageList = messages.get( checkId );
        if ( messageList == null ) {
            messages.put( checkId, messageList = new ArrayList<String>( ) );
        }
        messageList.add( message );
    }

    public boolean isEmpty( ) {

        return messages.isEmpty( );
    }

    @Override
    public String toString( ) {

        StringBuilder sb = new StringBuilder( );
        for ( Entry<CheckId, List<String>> entry : messages.entrySet( ) ) {
            String checkDescription = entry.getKey( ).getCheckDescription( );
            sb.append( checkDescription ).append( '\n' );
            for ( String message : entry.getValue( ) ) {
                sb.append( message ).append( '\n' );
            }
        }
        return sb.toString( );
    }
}