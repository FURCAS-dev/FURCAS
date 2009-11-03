package com.sap.tc.moin.repository.core.ocl.editorutils;

import com.sap.tc.moin.friends.ocl.editor.RegionWrappedMRI;
import com.sap.tc.moin.repository.MRI;


/**
 * The RegionWrappedMRI implementation
 */
public class RegionWrappedMRIImpl implements RegionWrappedMRI {

    private int length;

    private int offset;

    private MRI mri;


    /**
     * @param actMri MRI
     * @param actOffset offset
     * @param actLength length
     */
    public RegionWrappedMRIImpl( MRI actMri, int actOffset, int actLength ) {

        this.mri = actMri;
        this.offset = actOffset;
        this.length = actLength;
    }

    public int getLength( ) {

        return this.length;
    }

    public MRI getMRI( ) {

        return this.mri;
    }

    public int getOffset( ) {

        return this.offset;
    }

}
