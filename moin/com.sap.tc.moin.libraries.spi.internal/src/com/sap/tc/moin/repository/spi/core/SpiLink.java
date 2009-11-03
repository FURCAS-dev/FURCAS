/*
 * Created on 28.06.2006
 */
package com.sap.tc.moin.repository.spi.core;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;


/**
 * <p>
 * This interface is not intended to be implemented by service providers. The
 * implementation will be provided by the MOIN Core.
 * 
 * @author d044711
 */
public interface SpiLink {


    public MRI getMetaObjectMri( );

    public MRI getStorageEndMri( );

    public LRI getOtherEndLri( );

    /**
     * Returns the end number of the storage end of this link.
     * 
     * @return the end number of the storage end of this link.
     */
    public int getEndNumberOfStorageEnd( );

    /**
     * Returns the end number of the "other" (which is other than the storage
     * end) of this link).
     * 
     * @return the end number of the "other" end.
     */
    public int getEndNumberOfOtherEnd( );

}
