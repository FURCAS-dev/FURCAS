package com.sap.tc.moin.repository.spi.facility.basicquery;

import java.util.Set;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationCategory;

/**
 * Link search criterion. A LinkExpression describes the existence or
 * non-existences of a link from a model element to an element of a Set of model
 * elements. The set of model elements is expressed either by the MRIs of the
 * model elements or by a ModelElementExpression, which defines a query
 * expression that selects model elements. The linkType defines the type of the
 * link, which is either the MRI of the association or the MRI of the attribute.
 * The associationEndOfLinkedObject describes the direction of the link. The
 * field isLinked describes whether the existence or the non-existence of the
 * link is to be checked. Let ME be a model element and S the set of model
 * elements defined by the LinkExpression then the link expression is satisfied
 * for ME0 if isLinked is true and there is (at least one) model element ME1 in
 * S for which such a link exists or if isLinked is false and there is no model
 * element ME1 in S for which such a link exists.
 */
@Deprecated
abstract public class SpiLinkExpression {

    private boolean isLinked;

    private MRI linkType;

    private SpiFqlAssociationCategory linkCategory;

    private SpiModelElementExpression fromModelElementExpression;

    private byte associationEndOfLinkedObject;

    private byte storageEnd;

    private Object linkTarget;

    /**
     * @param isLinked specifies whether the object should be linked or not
     * @param linkType MRI of the association or attribute
     * @param linkCategory link category (ATTRIBUTE or ASSOCIATION)
     * @param associationEndOfLinkTarget link direction (0 or 1)
     * @param storageEnd storage end (0 or 1)
     * @param fromModelElementExpression set of model elements specified by a
     * ModelElementExpression
     * @param linkTarget link target
     */
    protected SpiLinkExpression( boolean isLinked, MRI linkType, SpiFqlAssociationCategory linkCategory, byte associationEndOfLinkTarget, byte storageEnd, SpiModelElementExpression fromModelElementExpression, Object linkTarget ) {

        this.isLinked = isLinked;
        this.linkType = linkType;
        this.linkCategory = linkCategory;
        this.associationEndOfLinkedObject = associationEndOfLinkTarget;
        this.storageEnd = storageEnd;
        this.fromModelElementExpression = fromModelElementExpression;
        this.linkTarget = linkTarget;
    }

    public byte getAssociationEndOfLinkedObject( ) {

        return associationEndOfLinkedObject;
    }

    public SpiModelElementExpression getFromModelElementExpression( ) {

        return fromModelElementExpression;
    }

    public boolean isLinked( ) {

        return isLinked;
    }

    public MRI getLinkType( ) {

        return linkType;
    }

    public byte getStorageEnd( ) {

        return storageEnd;
    }

    public Object getLinkTarget( ) {

        return linkTarget;
    }

    public SpiFqlAssociationCategory getLinkCategory( ) {

        return linkCategory;
    }

    public abstract Set<MRI> getLinkTargetTypesSet( );

    public abstract Set<MRI> getLinkTargetElementsSet( );

    public abstract Set<PRI> getLinkTargetScopeSet( );

    public abstract boolean getLinkTargetScopeIncluded( );

    public Set<MRI> getFromTypesSet( ) {

        return getFromModelElementExpression( ).getTypesSet( );
    }

    public Set<PRI> getFromScopeSet( ) {

        return getFromModelElementExpression( ).getScope( );
    }

    public boolean getFromScopeIncluded( ) {

        return getFromModelElementExpression( ).scopeIsIncluded( );
    }

    public Set<MRI> getFromElementsSet( ) {

        return getFromModelElementExpression( ).getElementsSet( );
    }

    /**
     *
     */
    public void toString( StringBuffer sb, int ident, boolean newline ) {

        SpiUtils.toStringNewLine( sb, ident );
        sb.append( SpiUtils.OPENING_PARENTHESES );
        if ( this.isLinked ) {
            sb.append( SpiUtils.IS_LINKED );
        } else {
            sb.append( SpiUtils.NOT_LINKED );
        }
        sb.append( ',' );
        sb.append( SpiUtils.LINK_TYPE );
        sb.append( SpiUtils.EQUAL );
        sb.append( SpiUtils.mriIdForPrinting( this.linkType ) );
        sb.append( ',' );
        sb.append( SpiUtils.ASSOCIATION_END_LINKED_OBJ );
        sb.append( SpiUtils.EQUAL );
        sb.append( this.associationEndOfLinkedObject );
        sb.append( ',' );
        sb.append( SpiUtils.STORAGE_END );
        sb.append( SpiUtils.EQUAL );
        sb.append( this.storageEnd );
        sb.append( ',' );
        sb.append( SpiUtils.LINK_FROM );
        sb.append( ": " ); //$NON-NLS-1$
        sb.append( this.fromModelElementExpression.getAlias( ) );
        sb.append( ", " ); //$NON-NLS-1$
        sb.append( SpiUtils.LINK_TO );
        sb.append( ": " ); //$NON-NLS-1$
        if ( linkTarget instanceof MRI[] ) {
            MRI[] toLinkedModelElements = (MRI[]) linkTarget;
            SpiUtils.mriArrayForPrinting( sb, toLinkedModelElements );
        } else if ( linkTarget instanceof SpiModelElementExpression ) {
            SpiModelElementExpression modelElementExpression = (SpiModelElementExpression) linkTarget;
            sb.append( modelElementExpression.getAlias( ) );
        } else if ( linkTarget instanceof SpiModelElementClusterExpression ) {
            SpiModelElementClusterExpression modelElementClusterExpression = (SpiModelElementClusterExpression) linkTarget;
            modelElementClusterExpression.toString( sb, ident + 1, true );
        }
        sb.append( SpiUtils.CLOSING_PARENTHESES );
    }

}