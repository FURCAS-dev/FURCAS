package com.sap.tc.moin.facility.primary.diservice.impl;



public class DiComponentModelUtilImpl {

    /** ***************** Naming conventions ******************************** */

    private static final String DC_NAME_SEPARATOR = "/"; //$NON-NLS-1$

    private static final String DC_TYPE_NAME_SEPARATOR = "/"; //$NON-NLS-1$

    public static String getFullDcName( String dcVendor, String dcName ) {

        return dcVendor + DC_NAME_SEPARATOR + dcName;
    }

    public static String getFullDcTypeName( String dcTypeVendor, String dcTypeName ) {

        return dcTypeVendor + DC_TYPE_NAME_SEPARATOR + dcTypeName;
    }

}
