package com.sap.tc.moin.xm.generation;


/**
 * Protocol of the generation. Contains currently only warning messages.
 * 
 * @noimplement This class is not intended to be sub-classed by clients.
 */
public interface XmGenerationProtocol {


    /**
     * Returns the protocol in string format. Currently only warning messages
     * are returned.
     * 
     * @return protocol in string format, cannot be <code>null</code>
     */
    String toString( );

}
