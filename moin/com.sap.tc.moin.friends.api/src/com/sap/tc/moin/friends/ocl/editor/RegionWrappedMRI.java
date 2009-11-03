package com.sap.tc.moin.friends.ocl.editor;

import com.sap.tc.moin.repository.MRI;


/**
 * The MRI with region info
 */
public interface RegionWrappedMRI {

    /**
     * @return offset
     */
    public int getOffset( );

    /**
     * @return length
     */
    public int getLength( );

    /**
     * @return MRI
     */
    public MRI getMRI( );
}
