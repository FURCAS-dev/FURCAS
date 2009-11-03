package com.sap.tc.moin.repository.core.xmi.reader;

import com.sap.tc.moin.repository.mmi.model.MofClass;

/**
 * Represents an end of a link.
 */
public interface LinkEnd {

    public String getMofId( );

    public MofClass getType( );
}
