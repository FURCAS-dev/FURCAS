/*
 * Created on 27.07.2006
 */
package com.sap.tc.moin.repository.core.links;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndStorageLink;
import com.sap.tc.moin.repository.core.MemoryLinkManager;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;

public abstract class AbstractEndStorageLinkImpl implements EndStorageLink {

    /**
     * Buffers the result of the calc. hashCode
     */
    private int hashCode = Integer.MIN_VALUE;

    private final byte storageEndNumber;

    private final MriReference storageEnd;

    private final MoinReference otherEnd;

    /**
     * Caches the composite end. See {@link #getCompositeEnd()}
     */
    protected byte compositeEnd;

    public AbstractEndStorageLinkImpl( int storageEndNumber, MriReference storageEnd, MoinReference otherEnd ) {

        this.storageEnd = storageEnd;
        this.otherEnd = otherEnd;
        this.storageEndNumber = (byte) storageEndNumber;
    }

    public MoinReference getEnd( int endNumber ) {

        if ( this.storageEndNumber == endNumber ) {
            return this.storageEnd;
        } else if ( 1 - this.storageEndNumber == endNumber ) {
            return this.otherEnd;
        } else {
            throw new MoinIllegalArgumentException( CoreLinksMessages.NOLEGALARGUMENT, endNumber, this.storageEndNumber, ( 1 - this.storageEndNumber ) );
        }
    }

    /**
     * If this link {@link EndStorageLink#canHaveDuplicates() allows for
     * duplicates}, equality is based only on the Java object identity.
     * Otherwise, equality of links requires that the {@link #getMetaObject meta
     * objects}, and references at the link ends are
     * {@link MoinReference#equals equal}including their order but regardless
     * their {@link #odering ordering criterion}. The equality and order of the
     * ends is checked by this implementation of <tt>equals</tt>. To be used by
     * subclass implementations which may have to check additional parts of the
     * link state for equality.
     */
    @Override
    public boolean equals( Object o ) {

        return equalsInternal( o, true );
    }

    public boolean logicalEquals( Object o ) {

        return equalsInternal( o, false );
    }

    private boolean equalsInternal( Object o, boolean considerJavaIdentity ) {

        if ( this == o ) {
            return true;
        }

        boolean result;
        if ( canHaveDuplicates( ) && considerJavaIdentity ) {
            result = super.equals( o );
        } else {
            result = false;
            if ( o instanceof EndStorageLink ) {
                EndStorageLink otherLink = (EndStorageLink) o;
                result = getEndNumberOfStorageEnd( ) == otherLink.getEndNumberOfStorageEnd( );
                if ( result ) {
                    result = getMetaObject( ).equals( otherLink.getMetaObject( ) );
                    if ( result ) {

                        MriReference storageEnd1 = getStorageEnd( );
                        MoinReference otherEnd1 = getOtherEnd( );

                        MriReference storageEnd2 = otherLink.getStorageEnd( );
                        MoinReference otherEnd2 = otherLink.getOtherEnd( );

                        result = storageEnd1.equals( storageEnd2 );
                        if ( result ) {
                            result = otherEnd1.equals( otherEnd2 );
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * In compliance with the {@link #equals}implementation, the hash code of a
     * link here is computed as the {@link #getJavaIdentity()}if this link
     * {@link EndStorageLink#canHaveDuplicates() allows for duplicates};
     * otherwise it is based on the hash code of all the references that
     * constitute the {@link #ends}and the hash code of the
     * {@link #getMetaObject meta object} of which this link is an instance.
     * Subclasses may want to add more of their specific state to the
     * construction to their hash code.
     */
    @Override
    public int hashCode( ) {

        if ( hashCode == Integer.MIN_VALUE ) {
            if ( canHaveDuplicates( ) ) {
                hashCode = System.identityHashCode( this );
            } else {
                hashCode = 0;

                // use only the LRIs for hashCode because otherwise the hashCode
                // could not be cached, because if a MRI
                // is used, the hashCode would have to change on repartitioning
                hashCode ^= this.getStorageEnd( ).getLri( ).hashCode( );
                hashCode ^= this.getOtherEnd( ).getLri( ).hashCode( );
                hashCode ^= getMetaObject( ).hashCode( );
                // if an Association/Attribute has double storage, two
                // EndStorageLinks will exist, which differ only in
                // the endstorageNumber/otherEndNumber. Therefore, this
                // difference must be reflected in the hashCode.
                hashCode ^= this.getEndNumberOfStorageEnd( );
            }
        }
        return hashCode;
    }

    /**
     * Tells which end of the link's {@link #getAssociation association}is
     * composite. If none is composite, <tt>-1</tt> is returned.
     * <p>
     * For attribute links, it's always the first end (index 0) that is the
     * composite one, namely the attribute value's owner, unless the attribute
     * type is an {@link com.sap.tc.moin.repository.mmi.model.AliasType}. AliasTypesare datatypes,
     * therefore attributes of such types don't have composition semantics.
     * <p>
     * Thus, for attributes of non-aliased types this operation returns
     * <tt>0</tt>, otherwise <tt>-1</tt> because alias-typed attributes don't
     * have composition semantics.
     */
    public int getCompositeEnd( ) {

        return compositeEnd;
    }

    /**
     * Tells which end of the link's {@link #getAssociation association}is
     * composed. If none is composite and therefore none is composed,
     * <tt>-1</tt> is returned.
     * <p>
     * For attributes, it's always the second end (index 1) that is the composed
     * one, namely the attribute value itself, unless the attribute type is an
     * {@link com.sap.tc.moin.repository.mmi.model.AliasType}. AliasTypesare datatypes, therefore
     * attributes of such types don't have composition semantics.
     * <p>
     * Thus, for attributes of non-aliased types this operation returns
     * <tt>1</tt>, otherwise <tt>-1</tt> because alias-typed attributes don't
     * have composition semantics.
     */
    public int getComponentEnd( ) {

        return compositeEnd == -1 ? -1 : ( 1 - compositeEnd );
    }

    public boolean isUpperMultiplicityOne( CoreSession session, int end ) {

        return getUpperBound( session, end ) == 1;
    }

    /**
     * The string representation lists all the references at this link's ends.
     */
    @Override
    public String toString( ) {

        StringBuffer result = new StringBuffer( );
        result.append( this.getStorageEnd( ).toString( ) );
        result.append( " / " ); //$NON-NLS-1$
        result.append( this.getOtherEnd( ).toString( ) );

        return result.toString( );
    }

    public int getEndNumberOfOtherEnd( ) {

        return 1 - this.storageEndNumber;
    }

    public int getEndNumberOfStorageEnd( ) {

        return this.storageEndNumber;
    }

    public MoinReference getOtherEnd( ) {

        return this.otherEnd;
    }

    public MriReference getStorageEnd( ) {

        return this.storageEnd;
    }

    public boolean isOtherEnd( int endNumber ) {

        return endNumber == ( 1 - this.storageEndNumber );
    }

    public boolean isStorageEnd( int endNumber ) {

        return endNumber == this.storageEndNumber;
    }

    public MemoryLinkManager getMemoryLinkManager( CoreConnection connection ) {

        return this.storageEnd.get( connection.getSession( ) ).get___Workspace( ).getMemoryLinkManager( );
    }

    public CorePartitionable getElementAtEnd( CoreSession session, int endNumber ) {

        MoinReference reference = getEnd( endNumber );
        CorePartitionable result = reference.getWithoutException( session );
        if ( result == null && session != null ) {
            session.getConsistencyViolationRegistry( ).notifyDanglingLinkInconsistency( reference.getLri( ), this );
        }
        return result;
    }

    public final MRI getMetaObjectMri( ) {

        return ( (CorePartitionable) getMetaObject( ) ).get___Mri( );
    }

    public final MRI getStorageEndMri( ) {

        return getStorageEnd( ).getMri( );
    }

    public LRI getOtherEndLri( ) {

        return getOtherEnd( ).getLri( );
    }
}