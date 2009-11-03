package com.sap.tc.moin.facility.primary.ipi;

import java.util.Collection;

import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.spi.facility.SpiDataArea;

/**
 * Facility internal IPI interface which provides access to data area management
 * related operations.
 * 
 * @see DataArea
 * @see SpiDataArea
 * @see IpiDataArea
 */
public interface IpiDataAreaManager {

    /**
     * Create a data area that can be used for regular editing.
     * 
     * @param dataAreaName The name of the data area to create.
     * @return A data area that can be used for regular editing.
     */
    public IpiDataArea createRegularDataArea( String dataAreaName );

    /**
     * Gets the {@link IpiDataArea} with the specified name or <code>null</code>
     * if no data area with the given name is available.
     * <p>
     * In the Primary facility, a {@link DataArea} maps to 1
     * DevelopmentConfiguration and the names of the data areas are in fact the
     * names of the development configurations. This method only returns a
     * result if the corresponding DevelopmentConfiguration has been imported
     * into the MOIN repository.
     * <p>
     * The Primary Facility implementation of method
     * {@link com.sap.tc.moin.repository.Facility#getDataAreaByName(String)}
     * delegates to this method of the Di service since the implementation
     * differ for the server-side and the local scenario.
     * 
     * @param name the name of the DataArea as obtained through
     * {@link #getDataAreaNames()}
     * @return the DataArea or <code>null</code> if no data area with the given
     * name available.
     * @see com.sap.tc.moin.repository.Facility#getDataAreaByName(String)
     */
    public IpiDataArea getDataAreaByName( String name );

    /**
     * The methods deletes the data area with the given name and the
     * corresponding client specs.
     * 
     * @param name The name of the data area to delete
     */
    public void deleteDataArea( String name );

    /**
     * Gets the names of the available {@link DataArea DataAreas} within this
     * Facility.
     * <p>
     * In the Primary facility, a {@link DataArea} maps to 1
     * DevelopmentConfiguration and the names of the data areas are in fact the
     * names of the development configurations. This method retrieves the names
     * of all development configurations that were <em>imported</em> into the
     * MOIN repository (in contrary to
     * NwdiAdministration#getAvailableDevelopmentConfigurations() which provides
     * a list of development configurations available on SLD).
     * <p>
     * The Primary Facility implementation of method
     * {@link com.sap.tc.moin.repository.Facility#getDataAreaNames()} delegates
     * to this method of the NWDI service since the implementation differ for
     * the server-side and the local scenario.
     * 
     * @return an {@link Collection} of {@link String}s
     * @see com.sap.tc.moin.repository.Facility#getDataAreaNames()
     */
    public Collection<String> getDataAreaNames( );

    /**
     * Returns the meta model data area.
     * 
     * @return The meta model data area.
     */
    public DataArea getMetaModelDataArea( );

    /**
     * Returns the transient data area.
     * 
     * @return The transient data area.
     */
    public DataArea getTransientDataArea( );

    /**
     * Get the descriptors for all regular data areas, i.e. all registered data
     * areas except the transient and the meta-model data area.
     * 
     * @return the descriptors for all regular data areas
     */
    public Collection<DataAreaDescriptor> getRegularDataAreaDescriptors( );

}
