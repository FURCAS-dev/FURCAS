package com.sap.tc.moin.repository;

/**
 * Identifies a data area.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface DataAreaDescriptor {

    /**
     * Returns the ID of the facility that hosts the data area (e. g. "PF").
     * 
     * @return the ID of the {@link Facility}
     */
    public String getFacilityId( );

    /**
     * Returns the name of the data area.
     * 
     * @return Data area name.
     */
    public String getDataAreaName( );

    /**
     * The returned String has to have the format:
     * <b>&lt;FacilityId&gt;.&lt;DataAreaName&gt;:</b>
     * <p>
     * Example:
     * <p>
     * "<code>PF.dev_1:</code>"
     */
    public String toString( );

    /**
     * Tells if this descriptor describes the metamodel data area.
     * 
     * @return <code>true</code> if this descriptor describes the metamodel data
     * area, <code>false</code> otherwise.
     */
    public boolean isMetamodelDataArea( );

}
