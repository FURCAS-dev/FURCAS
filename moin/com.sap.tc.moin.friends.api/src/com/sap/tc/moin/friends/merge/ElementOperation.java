package com.sap.tc.moin.friends.merge;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;


/**
 * Element Operation
 */
public interface ElementOperation extends Operation {

    /**
     * @return the element owner
     */
    public RefClass getOwner( );
}
