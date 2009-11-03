/*
 * Created on 02.08.2006
 */
package com.sap.tc.moin.repository.core;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

public interface LogicalLinkManager {

    public Collection<CorePartitionable> getComponentChildren( CoreSession session, CorePartitionable modelElement );

    public Collection<EndStorageLink> getComponentChildrenLinks( CoreSession session, CorePartitionable modelElement );

    /**
     * Gets the composite parent link for the given element. According to MOF
     * spec, each model element may at most have one composite parent.
     * Therefore, either <code>null</code> (if there is no composite parent)
     * or the existing link to the composite parent is returned. If there are
     * more than one composite parent links (i.e. an inconsistency), an
     * exception will be thrown.
     * 
     * @param componentElement the element of which the composite parent link is
     * requested.
     * @return the composite parent link or <code>null</code> if there is no
     * such link. If there is more than one composite parent link (which is an
     * inconsistency) an exception will be thrown.
     * @see #getCompositeParentLinks(CorePartitionable)
     */
    public EndStorageLink getCompositeParentLink( CoreSession session, CorePartitionable componentElement );

    /**
     * This method basically does the same as
     * {@link #getCompositeParentLink(CorePartitionable)} with the difference
     * that it doesn't throw an exception if there is more than one composite
     * parent link for the given component element.<br>
     * So it can be used to detect an inconsistency or to check constraints.
     * 
     * @param componentElement the element of which the composite parent links
     * are requested
     * @return a List of composite parent links, never <code>null</code>
     * @see #getCompositeParentLink(CorePartitionable)
     */
    public List<EndStorageLink> getCompositeParentLinks( CoreSession session, CorePartitionable componentElement );

    public JmiList<CorePartitionable> getElementsForEndAndMetaobject( CoreConnection connection, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd );

    public int getNumberOfElementsForEndAndMetaObjectIncludingOverflows( CoreSession session, EndAndMetaObject endAndMetaObject, CorePartitionable elementAtEnd );

    public List<EndStorageLink> getLinksForElement( CoreSession session, CorePartitionable element );

    public Map<EndStorageLink, Integer> getLinksForElementWithIndexInformation( CoreSession session, CorePartitionable element );

    public void elementRelocated( CoreConnection connection, CoreModelPartition oldPartition, CoreModelPartition newPartition, CorePartitionable element );

    public EndStorageLink createLink( CoreSession session, CorePartitionable elementAtStoredEnd, LRI target, byte numberOfStoredEnd, Association association );

    public EndStorageLink createLink( CoreSession session, CorePartitionable elementAtEnd0, CorePartitionable elementAtEnd1, Object metaObject, boolean association );

    public EndStorageLink getLink( CoreSession session, CorePartitionable elementAtEnd0, CorePartitionable elementAtEnd1, RefObject metaObject, boolean association );

    public Collection<EndStorageLink> getLinksForAttribute( CoreSession session, CorePartitionable elementAtEnd0, CorePartitionable elementAtEnd1, Attribute attribute );

    public EndStorageLink createLinkForAttribute( CoreSession session, SessionWorkspace workspaceOfStorageEnd, MRI elementAtEnd0, CorePartitionable elementAtEnd1, Attribute metaObject );
}
