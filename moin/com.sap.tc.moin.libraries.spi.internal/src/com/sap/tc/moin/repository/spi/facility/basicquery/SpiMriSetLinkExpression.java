package com.sap.tc.moin.repository.spi.facility.basicquery;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationCategory;

/**
 * LinkExpression with an MRI set as link target.
 */
@Deprecated
public final class SpiMriSetLinkExpression extends SpiLinkExpression {

    private Set<MRI> linkTargetSet;

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
    protected SpiMriSetLinkExpression( boolean isLinked, MRI linkType, SpiFqlAssociationCategory linkCategory, byte associationEndOfLinkedObject, byte storageEnd, SpiModelElementExpression fromModelElementExpression, MRI[] linkTarget ) {

        super( isLinked, linkType, linkCategory, associationEndOfLinkedObject, storageEnd, fromModelElementExpression, linkTarget );
        if ( linkTarget != null && linkTarget.length > 0 ) {
            linkTargetSet = new HashSet<MRI>( );
            for ( int i = 0; i < linkTarget.length; i++ ) {
                linkTargetSet.add( linkTarget[i] );
            }
        } else {
            linkTargetSet = Collections.emptySet( );
        }
    }

    @Override
    public MRI[] getLinkTarget( ) {

        return (MRI[]) super.getLinkTarget( );
    }

    public Set<MRI> getLinkTargetSet( ) {

        return linkTargetSet;
    }

    @Override
    public Set<MRI> getLinkTargetTypesSet( ) {

        return null;
    }

    @Override
    public Set<MRI> getLinkTargetElementsSet( ) {

        return this.getLinkTargetSet( );
    }

    @Override
    public Set<PRI> getLinkTargetScopeSet( ) {

        return null;
    }

    @Override
    public boolean getLinkTargetScopeIncluded( ) {

        return false;
    }

}
