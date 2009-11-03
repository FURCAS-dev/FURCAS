package com.sap.tc.moin.repository.spi.facility;

import java.util.List;

import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.spi.core.SpiStage;

/**
 * The SPI interface for the DataArea.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 */
public interface SpiDataArea extends DataArea {

    /**
     * Returns all shared stages of the DataArea.
     * 
     * @return all shared stages of this DataArea; list may be empty.
     */
    public List<SpiStage> getAllSharedStages( );

    /**
     * Returns the client-specific stage for the given clientSpecId, if
     * possible. Returns null otherwise.
     * 
     * @param clientSpecId The id for which the stage is requested.
     * @return The client-specific stage for the given clientSpecId if it
     * exists, <code>null</code> otherwise.
     */
    public SpiStage getClientSpecificStage( String clientSpecId );

    /**
     * Returns true if the data area supports exactly one stage.
     * 
     * @return <code>true</code> if the data area supports exactly one stage,
     * <code>false</code> otherwise.
     * @see #getSingleStage()
     */
    public boolean hasSingleStageOnly( );

    /**
     * Returns the single stage if the data area supports exactly one stage.
     * 
     * @return The single stage if the data area supports exactly one stage.
     * @throws UnsupportedOperationException Thrown if the data area does not
     * support exactly one stage.
     * @see #hasSingleStageOnly()
     */
    public SpiStage getSingleStage( );

    /**
     * Returns <code>true</code> if the data area supports exactly one
     * client-spec.
     * 
     * @return <code>true</code> if the data area supports exactly one
     * client-spec, <code>false</code> otherwise.
     * @see #getSingleClientSpec()
     */
    public boolean hasSingleClientspecOnly( );

    /**
     * Returns the single client spec if the data area supports exactly one
     * client spec.
     * 
     * @return The single client spec if the data area supports exactly one
     * client spec.
     * @throws UnsupportedOperationException Thrown if the data area supports
     * more than one client specs.
     * @see #hasSingleClientspecOnly()
     */
    public SpiClientSpec getSingleClientSpec( );
}