/*
 * Created on 03.08.2006
 */
package com.sap.tc.moin.repository.core.links;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;

import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.EndStorageLinkFactory;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.ReferenceManager;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.SpiPartitionable;

public class EndStorageLinkFactoryImpl implements EndStorageLinkFactory {


    private final SpiJmiHelper jmiHelper;

    private final ReferenceManager referenceManager;

    public EndStorageLinkFactoryImpl( SpiJmiHelper jmiHelper, ReferenceManager referenceManager ) {

        this.jmiHelper = jmiHelper;
        this.referenceManager = referenceManager;

    }

    public EndStorageLink createEndStorageLink( CoreSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Association association, byte endNumberOfStorageEnd ) {

        return createEndStorageLink( session, elementAtEnd0, elementAtEnd1, endNumberOfStorageEnd, association, true );
    }

    public EndStorageLink createEndStorageLink( CoreSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, Attribute attribute, byte endNumberOfStorageEnd ) {

        return createEndStorageLink( session, elementAtEnd0, elementAtEnd1, endNumberOfStorageEnd, attribute, false );
    }

    public EndStorageLink createEndStorageLink( CoreSession session, byte endNumberOfStorageEnd, Association association, MriReference storageEnd, MoinReference referenceOtherEnd ) {

        return this.buildEndStorageLink( session, endNumberOfStorageEnd, association, true, storageEnd, referenceOtherEnd );
    }

    public EndStorageLink createEndStorageLink( CoreSession session, byte endNumberOfStorageEnd, Attribute attribute, MriReference storageEnd, MoinReference referenceOtherEnd ) {

        return this.buildEndStorageLink( session, endNumberOfStorageEnd, attribute, false, storageEnd, referenceOtherEnd );
    }

    private EndStorageLink createEndStorageLink( CoreSession session, SpiPartitionable elementAtEnd0, SpiPartitionable elementAtEnd1, int endNumberOfStorageEnd, Object metaObject, boolean association ) {

        CorePartitionable storageEnd = null;
        CorePartitionable otherEnd = null;
        if ( endNumberOfStorageEnd == 0 ) {
            storageEnd = (CorePartitionable) elementAtEnd0;
            otherEnd = (CorePartitionable) elementAtEnd1;
        } else if ( endNumberOfStorageEnd == 1 ) {
            storageEnd = (CorePartitionable) elementAtEnd1;
            otherEnd = (CorePartitionable) elementAtEnd0;
        } else {
            throw new MoinIllegalArgumentException( CoreLinksMessages.STORAGEENDNUMBERWRONG, endNumberOfStorageEnd );
        }
        MoinReference referenceOtherEnd = createMoinReferenceForOtherEnd( storageEnd, otherEnd );
        MriReference referenceStorageEnd = createMriReferenceForStorageEnd( storageEnd );
        return buildEndStorageLink( session, endNumberOfStorageEnd, metaObject, association, referenceStorageEnd, referenceOtherEnd );
    }

    private MoinReference createMoinReferenceForOtherEnd( CorePartitionable storageEnd, CorePartitionable otherEnd ) {

        MemoryLinkManager memoryLinkManager = storageEnd.get___Workspace( ).getMemoryLinkManager( );
        return memoryLinkManager.createMoinReferenceForOtherEnd( storageEnd.get___Partition( ).getPri( ), otherEnd );
    }

    private MriReference createMriReferenceForStorageEnd( CorePartitionable element ) {

        Workspace workspace = element.get___Workspace( );
        if ( workspace.isShared( ) ) {
            // TODO throw an exception in that case and take care that error
            // handling is done way before.
            return referenceManager.getMriReference( element, null );
        }
        return referenceManager.getMriReference( element, workspace );
    }

    private EndStorageLink buildEndStorageLink( CoreSession session, int endNumberOfStorageEnd, Object metaObject, boolean association, MriReference storageEnd, MoinReference referenceOtherEnd ) {


        AbstractEndStorageLinkImpl result;
        if ( association ) {
            Association theAssociation = (Association) metaObject;
            byte orderedEnd = jmiHelper.getOrderedEnd( session, theAssociation );
            byte compositeEnd = jmiHelper.getCompositeEnd( session, theAssociation );
            result = new AssociationEndStorageLinkImpl( endNumberOfStorageEnd, storageEnd, referenceOtherEnd, theAssociation, orderedEnd, compositeEnd );
        } else {
            AttributeImpl attribute = (AttributeImpl) metaObject;
            byte compositeEnd;
            //TODO enable once we support AliasType
//            if ( ( attribute.getType( session ) instanceof AliasType ) ) {
//                // In case of an AliasType, aggregation semantics do not
//                // apply (see JMI 1.0 specification, section 4.8.10). So in this
//                // special case, the AttributeLink must not be composite.
//                compositeEnd = -1;
//            } else {
//                compositeEnd = 0;
//            }
            compositeEnd = 0;
            result = new AttributeEndStorageLinkImpl( endNumberOfStorageEnd, storageEnd, referenceOtherEnd, attribute, compositeEnd );
        }
        return result;
    }
}