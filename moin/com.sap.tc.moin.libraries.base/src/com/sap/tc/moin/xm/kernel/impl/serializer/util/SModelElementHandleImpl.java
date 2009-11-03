package com.sap.tc.moin.xm.kernel.impl.serializer.util;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.AttributeDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.xm.serializer.SModelElementHandle;
import com.sap.tc.moin.xm.kernel.impl.util.ModelElementHandleImpl;


final class SModelElementHandleImpl<TElement, TMofClass, TMofAssociation> extends ModelElementHandleImpl implements SModelElementHandle {

    private final SerializerHelperImpl<TElement, TMofClass, TMofAssociation> sHelper;

    private final MRI mri;

    /**
     * Constructor.
     * 
     * @param aMri
     * @param classDescriptor
     * @param serializerHelper
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public SModelElementHandleImpl( final MRI aMri, final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final SerializerHelperImpl<TElement, TMofClass, TMofAssociation> serializerHelper ) {

        super( aMri.getMofId( ), classDescriptor );
        if ( serializerHelper == null ) {
            throw new MoinNullPointerException( "serializerHelper" ); //$NON-NLS-1$
        }
        this.sHelper = serializerHelper;
        this.mri = aMri;
    }

    public Object getAttribute( final AttributeDescriptor<? extends Attribute, ? extends RefObject, ? extends Object> attributeDescriptor ) {

        return this.sHelper.getSerializerCallback( ).getAttributeValue( this.sHelper.get( this.getMofid( ) ), attributeDescriptor.getName( ) );
    }

    public MRI getMri( ) {

        return this.mri;
    }

}
