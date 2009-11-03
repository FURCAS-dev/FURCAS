package com.sap.tc.moin.repository.spi.facility.basicquery;

import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationCategory;

/**
 * LinkExpression with a model element cluster expression as link target.
 */
@Deprecated
public final class SpiClusterExternalLinkExpression extends SpiLinkExpression {

    /**
     * @param isLinked specifies whether the object should be linked or not
     * @param linkType MRI of the association or attribute
     * @param linkCategory link category (ATTRIBUTE or ASSOCIATION)
     * @param associationEndOfLinkedObject link direction (0 or 1)
     * @param storageEnd storage end (0 or 1)
     * @param fromModelElementExpression set of model elements specified by a
     * ModelElementExpression
     * @param linkTarget link target
     */
    protected SpiClusterExternalLinkExpression( boolean isLinked, MRI linkType, SpiFqlAssociationCategory linkCategory, byte associationEndOfLinkedObject, byte storageEnd, SpiModelElementExpression fromModelElementExpression, SpiModelElementClusterExpression linkTarget ) {

        super( isLinked, linkType, linkCategory, associationEndOfLinkedObject, storageEnd, fromModelElementExpression, linkTarget );
    }

    @Override
    public SpiModelElementClusterExpression getLinkTarget( ) {

        return (SpiModelElementClusterExpression) super.getLinkTarget( );
    }

    @Override
    public Set<MRI> getLinkTargetTypesSet( ) {

        return getLinkTarget( ).getHeaderModelElementExpression( ).getTypesSet( );
    }

    @Override
    public Set<MRI> getLinkTargetElementsSet( ) {

        return getLinkTarget( ).getHeaderModelElementExpression( ).getElementsSet( );
    }

    @Override
    public Set<PRI> getLinkTargetScopeSet( ) {

        return getLinkTarget( ).getHeaderModelElementExpression( ).getPartitionExpression( ).getPartitionSet( );
    }

    @Override
    public boolean getLinkTargetScopeIncluded( ) {

        return getLinkTarget( ).getHeaderModelElementExpression( ).getPartitionExpression( ).isIncludeList( );
    }

}
