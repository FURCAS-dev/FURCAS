/*
 * Created on 19.03.2005
 */
package com.sap.tc.moin.repository.core.links;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;

/**
 * This link implementation is for links that represent the relation between a
 * model element that is used as an attribute's value, and its owning model
 * element. As opposed to an
 * {@link com.sap.tc.moin.friends.impl.AssociationLinkImpl}, this kind of link
 * does not have metadata for both ends explicitly represented in the metamodel.
 * Instead, the metadata of the owning end has to be "made up" in this
 * implementation, including a multiplicity of "1", aggregation kind
 * {@link AggregationKindEnum#COMPOSITE} or {@link AggregationKindEnum#NONE} and
 * the type which is the class owning the {@link Attribute}.
 * <p>
 * It's always the first end (index 0) that references the owner, and the second
 * end (index 1) that references the attribute value.
 * 
 * @author D043530
 */
public class AttributeEndStorageLinkImpl extends AbstractEndStorageLinkImpl implements EndStorageLink {

    /**
     * The attribute that describes the metadata for the owned end.
     */
    private final Attribute attribute;

    /**
     * For attributes, the possibility to have duplicate links depends on the
     * attribute's uniqueness and upper multiplicity settings. If the upper
     * multiplicity is >1 or unbounded then duplicates may exist if the
     * uniqueness is set to <tt>false</tt>. Otherwise, duplicates cannot exist,
     * either because the upper multiplicity is 1, or uniqueness is already set
     * to <tt>true</tt>.
     * <p>
     * This fact is computed once at construction time of this link.
     * 
     * @see #canHaveDuplicates()
     */
    private final boolean canHaveDuplicates;

    public AttributeEndStorageLinkImpl( int storageEndNumber, MriReference storageEnd, MoinReference otherEnd, Attribute attribute, byte compositeEnd ) {

        super( storageEndNumber, storageEnd, otherEnd );
        this.attribute = attribute;
        MultiplicityType multiplicity = ( (AttributeImpl) attribute ).getMultiplicity( );
        if ( multiplicity.getUpper( ) == 1 || multiplicity.isUnique( ) ) {
            canHaveDuplicates = false;
        } else {
            canHaveDuplicates = true;
        }
        this.compositeEnd = compositeEnd;
    }

    /**
     * The string representation of an attribute link contains the name of the
     * attribute, its MOF ID and a string representation of the ends which is
     * computed by {@link AbstractLinkImpl#toString}.
     */
    @Override
    public String toString( ) {

        StringBuffer result = new StringBuffer( );
        result.append( "Attribute link for attribute " );//$NON-NLS-1$
        result.append( attribute.getName( ) );
        result.append( " with MOF ID " );//$NON-NLS-1$
        result.append( getAttribute( ).refMofId( ) );
        result.append( ". " );//$NON-NLS-1$
        result.append( super.toString( ) );
        return result.toString( );
    }

    /**
     * The attribute for which this is a link between the owner and the
     * attribute value.
     */
    public Attribute getAttribute( ) {

        return attribute;
    }

    /**
     * Returns the {@link #attribute} that is the metaobject for this link
     */
    public RefObject getMetaObject( ) {

        return getAttribute( );
    }

    /**
     * If the attribute that is this link's {@link #getMetaObject() meta object}
     * is ordered, <tt>1</tt> is returned; <tt>-1</tt> otherwise (indicating
     * that none of the ends is ordered).
     */
    public int getOrderedEnd( ) {

        return ( attribute.getMultiplicity( ).isOrdered( ) ? 1 : -1 );
    }

    /**
     * For attributes, the possibility to have duplicate links depends on the
     * attribute's uniqueness and upper multiplicity settings. If the upper
     * multiplicity is >1 or unbounded then duplicates may exist if the
     * uniqueness is set to <tt>false</tt>. Otherwise, duplicates cannot exist,
     * either because the upper multiplicity is 1, or uniqueness is already set
     * to <tt>true</tt>.
     * <p>
     * This fact is computed once at construction time of this link.
     */
    public boolean canHaveDuplicates( ) {

        return canHaveDuplicates;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.repository.core.impl.Link#getUpperBound(int)
     */
    public int getUpperBound( CoreSession session, int end ) {

        int result;
        if ( end == 0 ) {
            result = 1;
        } else {
            result = ( (Attribute) getMetaObject( ) ).getMultiplicity( ).getUpper( );
        }
        return result;
    }
}