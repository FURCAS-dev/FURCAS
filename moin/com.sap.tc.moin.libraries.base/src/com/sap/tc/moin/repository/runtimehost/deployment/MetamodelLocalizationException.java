/**
 * 
 */
package com.sap.tc.moin.repository.runtimehost.deployment;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.spi.runtimehost.mm.SpiMetamodelRegistry;


/**
 * TODO: move to SPI, use common exception-handling paradigm Exception thrown if
 * localized resources of a meta-model cannot be resolved.
 * 
 * @see SpiMetamodelRegistry#getLocalizedString(com.sap.tc.moin.repository.CRI,
 * java.util.Locale, String)
 * @author d032434
 */
public class MetamodelLocalizationException extends MoinDeploymentException {

    public enum ErrorCode {
        METAMODEL_NOT_FOUND, RESOURCEBUNDLE_NOT_FOUND, RESOURCE_NOT_FOUND
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    private transient CRI cri;

    private String resourceBundleName;

    private String resourceKey;

    /**
     * @param message
     * @param args
     * @param errorCode
     * @param cri
     * @param resourceBundleName
     * @param resourceKey
     */
    public MetamodelLocalizationException( ErrorCode errorCode, CRI cri, String resourceBundleName, String resourceKey ) {

        super( getLocalizedMessage( errorCode ), cri, resourceBundleName, resourceKey );
        this.errorCode = errorCode;
        this.cri = cri;
        this.resourceBundleName = resourceBundleName;
        this.resourceKey = resourceKey;
    }


    private static MoinLocalizedString getLocalizedMessage( ErrorCode errorCode ) {

        return null;
    }

}
