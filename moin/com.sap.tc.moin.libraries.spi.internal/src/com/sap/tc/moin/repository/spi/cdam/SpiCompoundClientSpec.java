package com.sap.tc.moin.repository.spi.cdam;

import java.util.Collection;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DuplicateElementException;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.spi.core.SpiResourceInfo;

/**
 * Compound client spec for internal use.
 * 
 * @author d026715
 */
public interface SpiCompoundClientSpec extends CompoundClientSpec {

    /**
     * Resolves the {@link SpiResourceInfo} of the given LRI by finding the
     * correct PRI and the correct Stage. In case the element with the given
     * {@link LRI} exists more than one time because of inconsistencies, a
     * {@link DuplicateElementException} is thrown, containing the list of
     * {@link MRI}s of the results.
     * 
     * @param lri {@link LRI} of the element to resolve.
     * @return Resolved {@link SpiResourceInfo} of the element.
     * @throws DuplicateElementException
     */
    public SpiResourceInfo getResourceInfo( LRI lri );

    /**
     * Resolves the {@link SpiResourceInfo} of the given PRI.
     * 
     * @param pri {@link PRI} to resolve.
     * @return Resolved {@link SpiResourceInfo}
     */
    public SpiResourceInfo getResourceInfo( PRI pri );

    /**
     * Return the live collection of all {@link ClientSpec}s for a given
     * facility.
     * 
     * @param facility Facility to get the {@link ClientSpec}s for.
     * @return Collection of the contained {@link ClientSpec}s
     */
    public Collection<ClientSpec> getClientSpecsLive( Facility facility );
}
