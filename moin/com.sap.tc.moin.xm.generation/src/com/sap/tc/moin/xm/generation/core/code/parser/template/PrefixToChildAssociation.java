package com.sap.tc.moin.xm.generation.core.code.parser.template;

import java.util.List;


/** Maps a prefix to child associations. */
public interface PrefixToChildAssociation {


    /**
     * Returns a prefix for which handler exists.
     * 
     * @return prefix, cannot be <code>null</code>
     */
    public String getPrefix( );

    /**
     * Returns the list of child associations.
     * 
     * @return list, cannot be <code>null</code>
     */
    public List<ChildAssociation> getChildAssociations( );

}
