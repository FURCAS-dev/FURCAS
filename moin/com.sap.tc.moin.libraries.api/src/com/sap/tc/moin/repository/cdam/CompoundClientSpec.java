package com.sap.tc.moin.repository.cdam;

import java.util.Collection;

import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.Facility;

/**
 * Compound client spec. The compound client spec contains a set of facility
 * specific client specs.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface CompoundClientSpec {

    /**
     * Returns the id of the compound client spec.
     * 
     * @return id of the compound client spec
     */
    public String getId( );

    /**
     * Returns all contained client specs.
     * 
     * @return all client specs
     */
    public Collection<ClientSpec> getClientSpecs( );

    /**
     * Returns all contained clientspecs of a given facility.
     * 
     * @param facility
     * @return all clientspecs of a given facility
     */
    public Collection<ClientSpec> getClientSpecs( Facility facility );

    /**
     * Returns the client spec for a DataArea; maybe null <br>
     * TODO change behavior such that instead of null-returning an exception is
     * thrown
     * 
     * @param dataArea
     * @return client spec
     */
    public ClientSpec getClientSpec( DataAreaDescriptor dataArea );

    /**
     * Returns the associated compound data area.
     * 
     * @return compound data area
     */
    public CompoundDataArea getCompoundDataArea( );

}
