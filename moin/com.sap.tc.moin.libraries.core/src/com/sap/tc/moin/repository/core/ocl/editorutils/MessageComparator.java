package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.io.Serializable;
import java.util.Comparator;

import com.sap.tc.moin.repository.ProcessMessage;


/**
 * A Comparator for Process errors
 */
public class MessageComparator implements Comparator<ProcessMessage>, Serializable {

    private static final long serialVersionUID = 1L;

    public int compare( ProcessMessage o1, ProcessMessage o2 ) {

        int result = o1.getStartPosition( ) - o2.getStartPosition( );
        if ( result == 0 ) {
            result = o1.getEndPosition( ) - o2.getEndPosition( );
            if ( result == 0 ) {
                return o1.getMessage( ).compareTo( o2.getMessage( ) );
            }
        }
        return result;
    }

}