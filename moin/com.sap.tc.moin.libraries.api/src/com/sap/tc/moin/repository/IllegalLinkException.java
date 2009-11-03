package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;

/**
 * Is thrown if a link between {@link #getFromElement() "fromElement"} and
 * {@link #getToElement() "toElement"} should be established which is considered
 * illegal by the responsible facility (which is the facility of the
 * "fromElement"). Storage of the link is defined at the "fromElement". The
 * {@link #getMetaObject() "metaObject"} is the meta object of the illegal link,
 * i.e. either an {@link Attribute} or an {@link Association}.
 * 
 * @author d044711
 */
public final class IllegalLinkException extends MoinLocalizedBaseRuntimeException {

    private static final long serialVersionUID = 1L;

    private MRI fromElement;

    private MRI toElement;

    private MRI metaObject;


    /**
     * Creates an instance of this exception.
     * 
     * @param message
     * @param actFrom the element from where the link starts
     * @param actTo the element where the link goes to
     * @param actMeta the meta object of the link
     */

    public IllegalLinkException( MoinLocalizedString message, MRI actFrom, MRI actTo, MRI actMeta ) {

        super( message, actFrom, actTo, actMeta );
        this.fromElement = actFrom;
        this.toElement = actTo;
        this.metaObject = actMeta;
    }


    /**
     * Returns the element from where the link starts.
     * 
     * @return the MRI of the element from where the link starts
     */
    public MRI getFromElement( ) {

        return this.fromElement;
    }


    /**
     * Returns the element where the link goes to.
     * 
     * @return the MRI of the element where the link goes to
     */
    public MRI getToElement( ) {

        return this.toElement;
    }



    /**
     * Returns the meta object of the illegal link, i.e. either an
     * {@link Attribute} or an {@link Association}.
     * 
     * @return the meta object of the illegal link
     */
    public MRI getMetaObject( ) {

        return this.metaObject;
    }


}