package com.sap.tc.moin.repository.test.graphicsfw;

import org.custommonkey.xmlunit.Difference;
import org.custommonkey.xmlunit.DifferenceListener;
import org.w3c.dom.Node;

/**
 * Difference listener for the diff of two models used in the test cases of this package.
 * 
 * @author d043982
 *
 */
public class IgnoreTestListenerForPictogramsTest implements DifferenceListener {


    private int[] ignoreValues;


    private boolean isIgnoredDifference( Difference difference ) {

        int differenceId = difference.getId( );

        for ( int i = 0; i < ignoreValues.length; ++i ) {
            if ( differenceId == ignoreValues[i] ) {
                return true;
            }
        }

        String localName = difference.getTestNodeDetail( ).getNode( ).getLocalName( );
        /*If the attribute Name is "timestamp" ignore the difference, because the timestamp
         * is always different
         */
        if ( localName.equals( "timestamp" ) ) {
            return true;
        }

        /* If the attribute Name is "xmi.uuid" ignore the difference, because they are different
         * when using a local stored reference model
         */
        if ( localName.equals( "xmi.uuid" ) ) {
            return true;
        }
        return false;
    }


    public int differenceFound( Difference difference ) {

        if ( isIgnoredDifference( difference ) ) {
            return RETURN_IGNORE_DIFFERENCE_NODES_SIMILAR;
        } else {
            return RETURN_ACCEPT_DIFFERENCE;
        }
    }


    public void skippedComparison( Node control, Node test ) {

        // do nothing
    }

    public void setIgnoreValues( int[] values ) {

        this.ignoreValues = values;
    }


}
