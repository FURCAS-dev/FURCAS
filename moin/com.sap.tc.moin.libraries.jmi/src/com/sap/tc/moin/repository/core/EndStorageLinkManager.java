/*
 * Created on 19.07.2006
 */
package com.sap.tc.moin.repository.core;

import java.util.Collection;

/**
 * Common interface for link managers (either memory or query based).
 * 
 * @author d044711
 */
public interface EndStorageLinkManager {

    /**
     * Gets the workspace this link manager is associated to.
     * 
     * @return the workspace this link manager is associated to.
     */
    public Workspace getWorkspace( );

    /**
     * Gets the associated (by the "metaObject" of the given EndAndMetaObject)
     * elements for the specified element (which is at the "fromEnd" of the
     * given EndAndMetaObject). <br>
     * The collection returned is an instance of {@link JmiList}.
     * 
     * @param endAndMetaObject the combined key which specifies the end number
     * "from" where navigation starts and the corresponding metaObject
     * (attribute/association) on whose behalf the elements are connected.
     * @param elementAtEnd the element at the "fromEnd" of the given
     * EndAndMetaObject for which the associated (by the "metaObject" of the
     * given EndAndMetaObject) elements are requested.
     * @return
     */
    public JmiList<CorePartitionable> getElementsForEndAndMetaobject( CoreConnection connection, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd );

    /**
     * Special method intended for the case that the upper multiplicity of the
     * referenced end is either 0 or 1. If there are more elements found, an
     * exception will be thrown which contains the MRIs of the (more than one)
     * referenced elements.<br>
     * This method will NOT check if the upper multiplicity of the
     * Association/Attribute is really 0 or 1. That means that the exception
     * will be thrown if there is more than one referenced element even if the
     * upper multiplicity is greater than one. So the caller has to make sure
     * that he doesn't call this method for an Association/Attribute that has an
     * upper multiplicity greater than one in order to avoid an exception.
     * 
     * @param endAndMetaObject the combined key which specifies the end number
     * "from" where navigation starts and the corresponding metaObject
     * (attribute/association) on whose behalf the elements are connected.
     * @param elementAtEnd the element at the "fromEnd" of the given
     * EndAndMetaObject for which the associated (by the "metaObject" of the
     * given EndAndMetaObject) elements are requested.
     * @return <code>null</code> if there is no such element, otherwise the
     * one and only referenced element.
     */
    public CorePartitionable getSingleElementForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd );

    public Collection<EndStorageLink> getLinksForEndAndMetaObject( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd );

    public int getNumberOfElementsForEndAndMetaObjectIncludingOverflows( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd );
}