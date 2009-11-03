package com.sap.tc.moin.repository.core.xmi.reader;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.xmi.reader.parser.ParserResult;

/**
 * The small interface has to be implemented by all repository implementations. It consists of one method for updating
 * the repository, and one method for rolling back all modifications in the case of an error.
 * <p>
 * Currently, there are two different implementations, one covering the "load a model partition from the persistent
 * store" scenario, and one for importing externally created XMI documents (see
 * {@link com.sap.tc.moin.repository.core.xmi.reader.LoadingRepositoryService} and
 * {@link com.sap.tc.moin.repository.core.xmi.reader.ImportingRepositoryService}).
 */
public interface RepositoryService {

    /**
     * Perform all necessary updates based on what is contained in the {@link ParserResult}. The collection of
     * composition roots found in the XMI documents is returned.
     */
    public Collection<RefObject> updateRepository( ParserResult parserResult );

    /**
     * Performs a rollback of all repository modifications made by this RepositoryService instance since its
     * construction. To support this, concrete implementations need to keep track of all their modifications.
     */
    public void rollbackChanges( );
}