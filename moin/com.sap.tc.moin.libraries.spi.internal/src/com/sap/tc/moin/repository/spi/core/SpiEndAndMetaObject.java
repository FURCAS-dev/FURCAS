package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.MRI;


public interface SpiEndAndMetaObject {

    /**
     * Returns the {@link MRI} of the meta object.
     */
    public MRI getMetaObject( );

    /**
     * The endNumber which is basic part of this key object.
     * 
     * @return the endNumber which is basic part of this key object.
     */
    public byte getFromEnd( );

    /**
     * Convenience method which dynamically calculates the "toEnd" out of the
     * "fromEnd" (i.e. toEnd = 1 - {@link #getFromEnd()}.
     * 
     * @return the end number of the association end this.
     */
    public byte getToEnd( );
}
