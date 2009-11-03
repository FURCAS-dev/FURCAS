package com.sap.tc.moin.repository.spi.s2x.serializer;

/**
 * This class is used from MOIN to fill the
 * {@link com.sap.s2x.etc.TranslationUnit translation unit} in the S2X
 * translation format.
 * <p>
 * The main difference is that only the resource name can be set in this class.
 * The rest is always set by MOIN itself.
 */
public class SpiS2XTranslationUnit {

    private String resName = ""; //$NON-NLS-1$

    public SpiS2XTranslationUnit( ) {
    }

    public SpiS2XTranslationUnit( String resName ) {
        this.resName = resName;
    }

    public String getResName( ) {
        return resName;
    }

    public void setResName( String resName ) {
        this.resName = resName;
    }
}
