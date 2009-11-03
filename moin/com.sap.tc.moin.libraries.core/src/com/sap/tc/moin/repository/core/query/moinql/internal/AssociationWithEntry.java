package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationCategory;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryEntry;


/**
 * This class embodies associative with entries, currently the Association
 * Predicate and the links predicate. It records all properties with regard to
 * associations, except the information of the toType.
 */
public abstract class AssociationWithEntry extends WithEntry {

    protected MRI assocMRI;

    protected SpiFqlAssociationCategory assocCategory;

    protected String assocName;

    protected int toAssocEnd;

    protected boolean toStorage;

    protected String toAssocEndName;

    protected AtomicEntryReference fromType;

    protected boolean fromStorage;

    protected int fromAssocEnd;

    protected String fromAssocEndName;

    public int getToAssocEnd( ) {

        return this.toAssocEnd;
    }

    public MRI getAssocMRI( ) {

        return this.assocMRI;
    }

    public AtomicEntryReference getFromType( ) {

        return this.fromType;
    }

    public String getToAssocEndName( ) {

        return this.toAssocEndName;
    }

    public String getAssocName( ) {

        return this.assocName;
    }

    public boolean hasStorageAtFromEnd( ) {

        return this.fromStorage;
    }

    public String getFromAssocEndName( ) {

        return this.fromAssocEndName;
    }

    public int getFromAssocEnd( ) {

        return this.fromAssocEnd;
    }

    public boolean hasStorageAtToEnd( ) {

        return this.toStorage;
    }

    public SpiFqlAssociationCategory getAssocCategory( ) {

        return this.assocCategory;
    }

    public void setToAssocEnd( int assocEnd ) {

        this.toAssocEnd = assocEnd;
    }

    public void setToAssocEndName( String assocEndName ) {

        this.toAssocEndName = assocEndName;
    }

    public void setAssocMRI( MRI assocMRI ) {

        this.assocMRI = assocMRI;
    }

    public void setAssocName( String assocName ) {

        this.assocName = assocName;
    }

    public void setFromType( AtomicEntryReference linkedTo ) {

        this.fromType = linkedTo;
    }

    public void setFromStorage( boolean linkedToStored ) {

        this.fromStorage = linkedToStored;
    }

    public void setToStorage( boolean stored ) {

        this.toStorage = stored;
    }

    /*
     * FQL
     */

    public SpiFqlQueryEntry getFromEndEntry( ) {

        return this.getFromType( ).getAtomicEntry( );
    }

}
