package com.sap.tc.moin.test.xmlunit;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceListener;
import org.w3c.dom.Node;

public class IgnoreTestListener implements DifferenceListener {

    public IgnoreTestListener( ) {

    }

    private boolean isIgnoredDifference( Difference difference ) {

        int differenceId = difference.getId( );
        for ( int i = 0; i < ignoreValues.length; i++ )
            if ( differenceId == ignoreValues[i] )
                return true;

        return false;
    }

    public int differenceFound( Difference difference ) {

        return !isIgnoredDifference( difference ) ? 0 : 2;
    }

    public void skippedComparison( Node node, Node node1 ) {

    }

    public void setIgnoreValues( int values[] ) {

        ignoreValues = values;
    }

    private int ignoreValues[];
}
