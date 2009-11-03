package com.sap.tc.moin.repository.spi.ps.serializer;

import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiElementBase;

/**
 * The interface {@link SpiElement} represents a MOIN model element in the
 * serializer scenario. It mainly offers methods for retrieving attribute values
 * and links connected to the model element.
 */
public interface SpiElement extends SpiElementBase {

    /**
     * Returns the element's {@link MRI}.
     * 
     * @return the element's MRI
     */
    public MRI get___Mri( );

    /**
     * Returns all links in the model partition that are stored at the element,
     * grouped by their {@link SpiAssociation associations}.
     * 
     * @return all links in the model partition that are stored at the element,
     * grouped by their associations
     */
    public Map<SpiAssociation, List<SpiLink>> get___LinksByAssociation( );
}