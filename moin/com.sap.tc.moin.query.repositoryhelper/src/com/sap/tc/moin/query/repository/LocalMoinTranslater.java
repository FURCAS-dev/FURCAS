package com.sap.tc.moin.query.repository;

import com.sap.tc.moin.repository.MRI;


/**
 * Helper for translating remote MOIN Resource Identifiers to local ones and
 * vice-versa.
 * 
 * @author D044522
 */
public interface LocalMoinTranslater {

    /**
     * Attempts to find the local counterpart of a MRI received from the
     * TeamServer. The first local import of the
     * {@link com.sap.tc.moin.repository.DataAreaDescriptor}'s corresponding
     * {@link com.sap.ide.dii05.model.api.IDevelopmentConfiguration} is
     * searched. Subsequent imports of the same DevConf will be ignored.
     * 
     * @param remote MRI received from the TeamServer
     * @return local counterpart, if available, null otherwise.
     */
    MRI getLocalMri( final MRI remote );

    /**
     * Attempts to calculate the remote counterpart of a local MRI.
     * 
     * @param local MRI from the client workspace.
     * @return remote counterpart, if corresponding
     * {@link com.sap.ide.dii05.model.api.IDevelopmentConfiguration} is
     * available on SLD, null otherwise.
     */
    MRI getRemoteMri( final MRI local );

}
