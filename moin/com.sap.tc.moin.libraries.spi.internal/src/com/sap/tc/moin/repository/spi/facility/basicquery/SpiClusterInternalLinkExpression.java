package com.sap.tc.moin.repository.spi.facility.basicquery;

import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationCategory;

/**
 * LinkExpression with a model element expression as link target. The isLinked()
 * condition is always true.
 */
@Deprecated
public final class SpiClusterInternalLinkExpression extends SpiLinkExpression {

    /**
     * @param linkType MRI of the association or attribute
     * @param linkCategory link category (ATTRIBUTE or ASSOCIATION)
     * @param associationEndOfLinkedObject link direction (0 or 1)
     * @param storageEnd storage end (0 or 1)
     * @param fromModelElementExpression set of model elements specified by a
     * ModelElementExpression
     * @param linkTarget link target
     */
    protected SpiClusterInternalLinkExpression( MRI linkType, SpiFqlAssociationCategory linkCategory, byte associationEndOfLinkedObject, byte storageEnd, SpiModelElementExpression fromModelElementExpression, SpiModelElementExpression linkTarget ) {

        super( true, linkType, linkCategory, associationEndOfLinkedObject, storageEnd, fromModelElementExpression, linkTarget );
    }

    @Override
    public SpiModelElementExpression getLinkTarget( ) {

        return (SpiModelElementExpression) super.getLinkTarget( );
    }

    @Override
    public Set<MRI> getLinkTargetTypesSet( ) {

        return getLinkTarget( ).getTypesSet( );
    }

    @Override
    public Set<MRI> getLinkTargetElementsSet( ) {

        return getLinkTarget( ).getElementsSet( );
    }

    @Override
    public Set<PRI> getLinkTargetScopeSet( ) {

        return getLinkTarget( ).getScope( );
    }

    @Override
    public boolean getLinkTargetScopeIncluded( ) {

        return getLinkTarget( ).scopeIsIncluded( );
    }

}
