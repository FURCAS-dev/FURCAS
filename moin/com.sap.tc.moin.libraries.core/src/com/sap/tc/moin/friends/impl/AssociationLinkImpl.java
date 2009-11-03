package com.sap.tc.moin.friends.impl;

import com.sap.tc.moin.friends.AssociationLink;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;


public class AssociationLinkImpl implements AssociationLink {

    private MRI storedEnd;

    private LRI otherEnd;

    private MRI association;

    private int position;

    public AssociationLinkImpl( MRI storedEnd, LRI otherEnd, MRI association, int position ) {

        this.storedEnd = storedEnd;
        this.otherEnd = otherEnd;
        this.association = association;
        this.position = position;
    }

    public AssociationLinkImpl( MRI storedEnd, LRI otherEnd, MRI association ) {

        this( storedEnd, otherEnd, association, -1 );
    }


    public MRI getAssociation( ) {

        return association;
    }

    public LRI getOtherEnd( ) {

        return otherEnd;
    }

    public int getPosition( ) {

        return position;
    }

    public MRI getStoredEnd( ) {

        return storedEnd;
    }

}
