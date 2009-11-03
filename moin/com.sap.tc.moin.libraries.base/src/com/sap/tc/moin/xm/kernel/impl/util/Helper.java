package com.sap.tc.moin.xm.kernel.impl.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.kernel.XmCallback;
import com.sap.tc.moin.xm.kernel.impl.XmExceptionMessages;

/**
 * Helper methods for the XM Parser/Serializer. Each XM Parser/Serializer
 * instance has an instance of this class. It caches MOF class instances(
 * RefObject instances in the case of Import/Export or SpiElement instances in
 * the case of CPS).
 * 
 * @param <TMofClass> either RefClass in the case of Import/Export of SpiClass
 * in the case of CPS
 * @param <TElement> either a RefObject representing a MOF class instance in the
 * case of Import/Export or a SpiElement in the case of CPS
 * @param <TMofAssociation> either a RefAssociation in the case of Import/Export
 * or a SpiAssociation in the case of CPS
 */
public abstract class Helper<TElement, TMofClass, TMofAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, Helper.class );

    private XmCallback<TElement, TMofClass, TMofAssociation> callBack;

    /**
     * Cache either RefObject or SpiElement. The keys are the corresponding
     * MOFIDs.
     */
    private final Map<String, TElement> mofId2ModelElement = new HashMap<String, TElement>( );

    private final List<Exception> errors = new LinkedList<Exception>( );

    private final Map<AssociationDescriptor<? extends RefAssociation>, TMofAssociation> associationCache = new HashMap<AssociationDescriptor<? extends RefAssociation>, TMofAssociation>( );


    private final Map<ClassDescriptor<? extends RefClass, ? extends RefObject>, TMofClass> classCache = new HashMap<ClassDescriptor<? extends RefClass, ? extends RefObject>, TMofClass>( );

    /**
     * Constructor.
     */
    public Helper( ) {

    }

    /**
     * Sets the call-back object.
     * 
     * @param aCallBack call-back
     * @throws NullPointerException if <tt>aCallBack</tt> is <code>null</code>
     */
    public void setCallback( final XmCallback<TElement, TMofClass, TMofAssociation> aCallBack ) {

        if ( aCallBack == null ) {
            throw new MoinNullPointerException( "aCallBack" ); //$NON-NLS-1$
        }
        this.callBack = aCallBack;
    }


    /**
     * Returns the call-back object.
     * 
     * @return call-back
     */
    public XmCallback<TElement, TMofClass, TMofAssociation> getCallBack( ) {

        return this.callBack;
    }


    /**
     * Returns the MOIN class for a class descriptor.
     * 
     * @param classDescriptor class descriptor
     * @return MOIN class cannot be <code>null</code>
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public TMofClass getClass( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor ) {

        if ( classDescriptor == null ) {
            throw new MoinNullPointerException( "classDescriptor" ); //$NON-NLS-1$
        }
        TMofClass result = this.classCache.get( classDescriptor );
        if ( result == null ) {
            result = this.getCallBack( ).getClass( classDescriptor.getModelContainerName( ), getDotSeparatedQualifiedName( classDescriptor.getQualifiedName( ) ) );
            if ( result != null ) {
                this.classCache.put( classDescriptor, result );
            } else {
                if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                    LOGGER.trace( MoinSeverity.WARNING, "No class with qualified name {0} found", getDotSeparatedQualifiedName( classDescriptor.getQualifiedName( ) ) ); //$NON-NLS-1$
                }
            }
        }
        return result;
    }

    /**
     * Returns the MOIN association for a association descriptor.
     * 
     * @param assocoiationDescriptor association descriptor
     * @return MOIN association can be <code>null</code>, in the CP/S serializer
     * case when an association is requested which is not used in the
     * model-partition
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public TMofAssociation getAssociation( final AssociationDescriptor<? extends RefAssociation> assocoiationDescriptor ) {

        if ( assocoiationDescriptor == null ) {
            throw new MoinNullPointerException( "assocoiationDescriptor" ); //$NON-NLS-1$
        }
        TMofAssociation result = this.associationCache.get( assocoiationDescriptor );
        if ( result == null ) {
            result = this.getCallBack( ).getAssociation( assocoiationDescriptor.getModelContainerName( ), getDotSeparatedQualifiedName( assocoiationDescriptor.getQualifiedName( ) ) );
            // can be null in the serializer case
            if ( result != null ) {
                this.associationCache.put( assocoiationDescriptor, result );
            } else {
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, "No association with qualified name {0} found; probably because no link of such an association is contained in the model partition in the CPS case", getDotSeparatedQualifiedName( assocoiationDescriptor.getQualifiedName( ) ) ); //$NON-NLS-1$
                }
            }
        }
        return result;
    }

    /**
     * Resets the model helper. Must be called after a mapping is finished.
     */
    protected void reset( ) {

        this.mofId2ModelElement.clear( );
        this.errors.clear( );
        this.associationCache.clear( );
        this.classCache.clear( );
    }

    /**
     * Return the PRI.
     * 
     * @return PRI
     */
    public PRI getPri( ) {

        return this.callBack.getPri( );
    }

    /**
     * Adds an entry to the model element cache.
     * 
     * @param mofId MOFID
     * @param modelElement model element
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public void put( final String mofId, final TElement modelElement ) {

        if ( mofId == null ) {
            throw new MoinNullPointerException( "mofId" ); //$NON-NLS-1$
        }
        if ( modelElement == null ) {
            throw new MoinNullPointerException( "modelElement" ); //$NON-NLS-1$
        }
        this.mofId2ModelElement.put( mofId, modelElement );
    }

    /**
     * Returns for a mofId the corresponding model element contained in the
     * cache.
     * 
     * @param mofId MOFID
     * @return model element can be <tt>null</tt> if the handle was not
     * contained in the cache
     */
    public TElement get( final String mofId ) {

        return this.mofId2ModelElement.get( mofId );
    }

    /**
     * Calculates the model element MOFID from the model elements type and
     * logical key.
     * 
     * @param clazz model elements type
     * @param logicalKey logical key
     * @return MOFID
     * @throws NullPointerException if a parameter is <code>null</code>
     * @throws IllegalArgumentException if <tt>logicalKey</tt> is an empty array
     */
    public String calculateElementMofid( final TMofClass clazz, final String... logicalKey ) {

        if ( clazz == null ) {
            throw new MoinNullPointerException( "clazz" ); //$NON-NLS-1$
        }
        if ( logicalKey == null ) {
            throw new MoinNullPointerException( "logicalKey" ); //$NON-NLS-1$
        }
        if ( logicalKey.length == 0 ) {
            LOGGER.trace( MoinSeverity.ERROR, XmExceptionMessages.STRINGPARAMETEREMPTY, "logicalKey" ); //$NON-NLS-1$
            throw new MoinIllegalArgumentException( XmExceptionMessages.STRINGPARAMETEREMPTY, "logicalKey" ); //$NON-NLS-1$
        }
        // assumption: use MofId of RefClass as locality scope
        return this.callBack.calculateElementMofId( clazz, logicalKey );
    }

    /**
     * Transforms the array representing a qualified name into a dot separated
     * string.
     * 
     * @param qName array
     * @return dot separated string
     * @throws NullPointerException if <tt>qName</tt> is <code>null</code>
     */
    public static String getDotSeparatedQualifiedName( final String[] qName ) {

        if ( qName == null ) {
            throw new MoinNullPointerException( "qName" ); //$NON-NLS-1$
        }
        if ( qName.length == 0 ) {
            LOGGER.trace( MoinSeverity.ERROR, XmExceptionMessages.STRINGPARAMETEREMPTY, "qName" ); //$NON-NLS-1$
            throw new MoinIllegalArgumentException( XmExceptionMessages.STRINGPARAMETEREMPTY, "qName" ); //$NON-NLS-1$
        }
        final StringBuilder sb = new StringBuilder( );
        for ( int i = 0; i < qName.length - 1; i++ ) {
            sb.append( qName[i] );
            sb.append( '.' );
        }
        sb.append( qName[qName.length - 1] );
        return sb.toString( );
    }


}
