package com.sap.tc.moin.friends;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

/**
 * Represents a link on behalf of an {@link Association}.
 * <p>
 * Such a link connects two elements on behalf of an {@link Association} and is
 * always stored at one of the two elements. Therefore, the element where the
 * link is stored can be retrieved by {@link #getStoredEnd()} whereas the
 * "other" element (which is part of the link) can be retrieved by
 * {@link #getOtherEnd()}.<br>
 * The "metaobject" of such a link is always an {@link Association} which can be
 * retrieved by {@link #getAssociation()}. If the {@link AssociationEnd} of the
 * "other" end is ordered (which implicates that its multiplicity is > 1), the
 * {@link #getPosition() position} of the link can be relevant. Position count
 * starts at 0. If the {@link AssociationEnd} of the "other" end is not ordered,
 * {@link #getPosition() position} will always be -1.
 */
public interface AssociationLink {

    /**
     * Returns the element where the link is stored.
     * 
     * @return the element where the link is stored.
     */
    public MRI getStoredEnd( );

    /**
     * Returns the "other" element of this link (which is at the non-storage
     * end).
     * 
     * @return the "other" element of this link (which is at the non-storage
     * end).
     */
    public LRI getOtherEnd( );

    /**
     * Returns the "metaobject" of this link, i.e. the
     * {@link Association association} on whose behalf this link exists.
     * 
     * @return the "metaobject" of this link which is always an
     * {@link Association association}.
     */
    public MRI getAssociation( );

    /**
     * Returns the position of the link.<br>
     * If the {@link AssociationEnd} of the {@link #getOtherEnd() "other" end}
     * is ordered (which implicates that its multiplicity is > 1), the
     * {@link #getPosition() position} of the link can be relevant. Position
     * count starts at 0. If the {@link AssociationEnd} of the "other" end is
     * not ordered, {@link #getPosition() position} will always be -1.
     * 
     * @return the position of this link, -1 if the {@link AssociationEnd} of
     * the {@link #getOtherEnd() "other" end} is not ordered
     */
    public int getPosition( );

}
