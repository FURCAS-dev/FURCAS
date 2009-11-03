package com.sap.tc.moin.xm.kernel.impl.util;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.xm.ModelElementHandle;

/**
 * Implementation of {@link ModelElementHandle}.
 */
public abstract class ModelElementHandleImpl implements ModelElementHandle {

    private final String mofId;

    private final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor;

    /**
     * @param aMofId MOFID
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public ModelElementHandleImpl( final String aMofId, final ClassDescriptor<? extends RefClass, ? extends RefObject> aClassDescriptor ) {

        if ( aMofId == null ) {
            throw new MoinNullPointerException( "aMofId" ); //$NON-NLS-1$
        }
        if ( aClassDescriptor == null ) {
            throw new MoinNullPointerException( "aClassDescriptor" ); //$NON-NLS-1$
        }
        this.mofId = aMofId;
        this.classDescriptor = aClassDescriptor;
    }


    public String getMofid( ) {

        return this.mofId;
    }



    @Override
    public int hashCode( ) {


        return mofId.hashCode( );
    }

    @Override
    public boolean equals( final Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final ModelElementHandleImpl other = (ModelElementHandleImpl) obj;
        if ( !mofId.equals( other.mofId ) ) {
            return false;
        }
        return true;
    }


    public ClassDescriptor<? extends RefClass, ? extends RefObject> getType( ) {

        return this.classDescriptor;
    }

}
