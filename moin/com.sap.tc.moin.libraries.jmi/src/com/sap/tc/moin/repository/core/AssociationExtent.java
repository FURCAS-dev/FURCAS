package com.sap.tc.moin.repository.core;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;


public interface AssociationExtent extends Extent {

    /**
     * Returns the cached list of association ends of this association.
     */
    public List<AssociationEnd> get___AssociationEnds( );

    /**
     * Sets the cached list of association ends.
     */
    public void set___AssociationEnds( List<AssociationEnd> ends );

    /**
     * Returns the cached association end number for which storage is defined.
     */
    public byte get___StoredEnd( );

    /**
     * Sets the cached association end number for which storage is defined.
     */
    public void set___StoredEnd( byte end );

    public byte get___CompositeEnd( );

    public void set___CompositeEnd( byte compositeEnd );

    public byte get___OrderedEnd( );

    public void set___OrderedEnd( byte end );
}
