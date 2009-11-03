package com.sap.tc.moin.repository.spi.ps.serializer;

import com.sap.tc.moin.repository.spi.ps.SpiAssociation;

/**
 * An instance of {@link SpiLink} represents a link between two elements. A link
 * consists of two ends (numbered 0 and 1, corresponding to the end numbers in
 * the metamodel). The element at the
 * {@link SpiAssociation#get___StoredEndNumber() stored end} is always part of
 * the current partition being serialized, whereas the element at the other end
 * can either be a member of the current or a different partition. The elements
 * at the link's ends can be retrieved via
 * {@link SpiSerializerCallback#getElementAtLinkEnd(SpiLink, int)}.
 */
public interface SpiLink {

    /**
     * Returns the link's {@link SpiAssociation association}.
     * 
     * @return the link's association
     */
    public SpiAssociation get___Association( );
}
