package com.sap.tc.moin.xm.kernel.impl.parser.util;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.xm.parser.PModelElementHandle;
import com.sap.tc.moin.xm.kernel.impl.util.ModelElementHandleImpl;


/**
 * Implementation of the model element handle for the parser.
 * 
 * @param <TElement>
 * @param <TMofClass>
 * @param <TMofAssociation>
 */
final class PModelElementHandleImpl<TElement, TMofClass, TMofAssociation> extends ModelElementHandleImpl implements PModelElementHandle {


    private final ParserHelperImpl<TElement, TMofClass, TMofAssociation> pHelper;

    /**
     * Constructor.
     * 
     * @param mofId
     * @param classDescriptor
     * @param serializerHelper
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public PModelElementHandleImpl( final String mofId, final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final ParserHelperImpl<TElement, TMofClass, TMofAssociation> parserHelper ) {

        super( mofId, classDescriptor );
        if ( parserHelper == null ) {
            throw new MoinNullPointerException( "parserHelper" ); //$NON-NLS-1$
        }
        this.pHelper = parserHelper;
    }

    public void setOrAddAttribute( final AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor, final String value ) {

        this.pHelper.setOrAddAttribute( this.pHelper.get( this.getMofid( ) ), attributeDescriptor.getName( ), value );
    }



}
