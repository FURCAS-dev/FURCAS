package com.sap.tc.moin.xm.kernel.impl.serializer.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.descriptors.AssociationDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.serializer.SModelElementHandle;
import com.sap.tc.moin.repository.xm.serializer.SerializerHelper;
import com.sap.tc.moin.repository.xm.serializer.XmlOutputHandler;
import com.sap.tc.moin.xm.kernel.XmSerializerCallback;
import com.sap.tc.moin.xm.kernel.impl.XmExceptionMessages;
import com.sap.tc.moin.xm.kernel.impl.serializer.sax.XmlOutputHandlerImpl;
import com.sap.tc.moin.xm.kernel.impl.util.Helper;

/**
 * Helper methods for the serialization. One instance per XM Serializer is
 * created.
 */
public final class SerializerHelperImpl<TElement, TMofClass, TMofAssociation> extends Helper<TElement, TMofClass, TMofAssociation> implements SerializerHelper {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, SerializerHelperImpl.class );

    private XmlOutputHandlerImpl handler;

    /**
     * Constructor.
     */
    public SerializerHelperImpl( ) {

        super( );
    }

    /**
     * Sets the output handler.
     * 
     * @param aHandler output handler
     */
    public void setOutputHandler( final XmlOutputHandlerImpl aHandler ) {

        this.handler = aHandler;
    }


    public XmlOutputHandler getOutputHandler( ) {

        return this.handler;
    }


    @Override
    public void reset( ) {

        super.reset( );
    }


    public void addNamespacePrefixDeclarations( final Map<String, String> prefix2Ns ) {

        if ( prefix2Ns == null ) {
            throw new MoinNullPointerException( "prefix2Ns" ); //$NON-NLS-1$
        }


        final StringBuilder sb = new StringBuilder( );
        for ( final Entry<String, String> entry : prefix2Ns.entrySet( ) ) {
            if ( "".equals( entry.getKey( ) ) ) { //$NON-NLS-1$
                continue;
            }
            sb.append( " xmlns:" );//$NON-NLS-1$
            sb.append( entry.getKey( ) );
            sb.append( "=\"" );//$NON-NLS-1$
            sb.append( entry.getValue( ) );
            sb.append( "\"" );//$NON-NLS-1$
        }
        if ( sb.length( ) > 0 ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, "Namespace prefix declaration: {0}", sb.toString( ) ); //$NON-NLS-1$
            }
            ( (XmlOutputHandlerImpl) this.getOutputHandler( ) ).addRawAttribute( sb.toString( ) );
        }

    }

    /**
     * Returns the serializer call-back.
     * 
     * @return serializer call-back
     */
    XmSerializerCallback<TElement, TMofClass, TMofAssociation> getSerializerCallback( ) {

        return (XmSerializerCallback<TElement, TMofClass, TMofAssociation>) this.getCallBack( );
    }

    public Collection<SModelElementHandle> getModelElements( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor ) {

        final Collection<TElement> instances = this.getSerializerCallback( ).getInstances( this.getClass( classDescriptor ) );
        final List<SModelElementHandle> result;
        if ( instances == null ) {
            // this can occur on the CP/S case, when no instances are found for the class
            LOGGER.trace( MoinSeverity.INFO, "No model element of class {0} in CP/S case found", Arrays.toString( classDescriptor.getQualifiedName( ) ) ); //$NON-NLS-1$
            result = Collections.emptyList( );
        } else {
            final List<SModelElementHandle> intermediateResult = new ArrayList<SModelElementHandle>( instances.size( ) );
            for ( final TElement instance : instances ) {
                final String mofId = this.getSerializerCallback( ).getInstanceMofId( instance );
                this.put( mofId, instance );
                intermediateResult.add( new SModelElementHandleImpl<TElement, TMofClass, TMofAssociation>( this.getSerializerCallback( ).getMri( instance ), this.getSerializerCallback( ).getType( instance ), this ) );
            }
            if ( LOGGER.isTraced( MoinSeverity.INFO ) && intermediateResult.isEmpty( ) ) {
                LOGGER.trace( MoinSeverity.INFO, "No model element of class {0} found", Arrays.toString( classDescriptor.getQualifiedName( ) ) ); //$NON-NLS-1$
            }
            result = intermediateResult;
        }
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) && !result.isEmpty( ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "{0} model elements of class {1} returned", new Object[] { result.size( ), Arrays.toString( classDescriptor.getQualifiedName( ) ) } ); //$NON-NLS-1$
        }
        return result;
    }



    public SModelElementHandle getModelElement( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String... logicalKey ) {


        final String mofId = this.getMofId( classDescriptor, logicalKey );
        TElement element = this.get( mofId );
        if ( element == null ) {
            // not yet existing in cache --> search
            element = this.getSerializerCallback( ).getClassInstance( this.getClass( classDescriptor ), logicalKey );
            // add to cache
            if ( element != null ) {
                this.put( mofId, element );
            } else {
                if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                    LOGGER.trace( MoinSeverity.INFO, "No model element of class {0} with logical key {1} found", new Object[] { Arrays.toString( classDescriptor.getQualifiedName( ) ), Arrays.toString( logicalKey ) } ); //$NON-NLS-1$
                }
            }
        }
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Model element {0} of class {1} for logical key {2} returned", new Object[] { element, Arrays.toString( classDescriptor.getQualifiedName( ) ), Arrays.toString( logicalKey ) } ); //$NON-NLS-1$
        }
        return this.createHandle( element );
    }

    public SModelElementHandle getModelElement( final MRI mri ) {

        if ( mri == null ) {
            throw new MoinNullPointerException( "mri" ); //$NON-NLS-1$
        }
        TElement element = this.get( mri.getMofId( ) );
        if ( element == null ) {
            // not yet existing in cache --> search
            element = this.getSerializerCallback( ).getClassInstance( mri );
            // add to cache
            if ( element != null ) {
                this.put( mri.getMofId( ), element );
            } else {
                if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                    LOGGER.trace( MoinSeverity.INFO, "No model element found for MRI {0}", mri ); //$NON-NLS-1$
                }
            }
        }
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Model element {0} for MRI {1} returned", new Object[] { element, mri } ); //$NON-NLS-1$
        }
        return this.createHandle( element );
    }

    public SModelElementHandle getModelElement( final LRI lri ) {

        if ( lri == null ) {
            throw new MoinNullPointerException( "lri" ); //$NON-NLS-1$
        }
        TElement element = this.get( lri.getMofId( ) );
        if ( element == null ) {
            // not yet existing in cache --> search
            element = this.getSerializerCallback( ).getClassInstance( lri );
            // add to cache
            if ( element != null ) {
                this.put( lri.getMofId( ), element );
            } else {
                if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                    LOGGER.trace( MoinSeverity.INFO, "No model element found for LRI {0}", lri ); //$NON-NLS-1$
                }
            }
        }
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Model element {0} for LRI {1} returned", new Object[] { element, lri } ); //$NON-NLS-1$
        }
        return this.createHandle( element );
    }


    public LRI calculateLri( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String... logicalKey ) {

        return this.getPri( ).createMri( this.getMofId( classDescriptor, logicalKey ) ).getLri( );
    }


    private String getMofId( final ClassDescriptor<? extends RefClass, ? extends RefObject> classDescriptor, final String... logicalKey ) {

        if ( logicalKey == null ) {
            throw new MoinNullPointerException( "logicalKey" ); //$NON-NLS-1$
        }
        if ( logicalKey.length == 0 ) {
            LOGGER.trace( MoinSeverity.ERROR, XmExceptionMessages.STRINGPARAMETEREMPTY, "logicalKey" ); //$NON-NLS-1$
            throw new MoinIllegalArgumentException( XmExceptionMessages.STRINGPARAMETEREMPTY, "logicalKey" ); //$NON-NLS-1$
        }
        final TMofClass clazz = this.getClass( classDescriptor );
        return this.getCallBack( ).calculateElementMofId( clazz, logicalKey );
    }

    /**
     * Creates a handle for a model element.
     * 
     * @param element model element, can be <code>null</code>
     * @return handle or <code>null</code> if <tt>element</tt> is
     * <code>null</code>
     */
    private SModelElementHandle createHandle( final TElement element ) {

        if ( element != null ) {
            return new SModelElementHandleImpl<TElement, TMofClass, TMofAssociation>( this.getSerializerCallback( ).getMri( element ), this.getSerializerCallback( ).getType( element ), this );
        } else {
            return null;
        }
    }

    public Collection<SModelElementHandle> getLinks( final SModelElementHandle endInputModelElement, final AssociationDescriptor<? extends RefAssociation> descriptor, final String endOutputName ) {

        if ( endOutputName == null ) {
            throw new MoinNullPointerException( "endOutputName" ); //$NON-NLS-1$
        }
        final Collection<SModelElementHandle> result;
        final TElement elementA = this.get( endInputModelElement.getMofid( ) );
        final TMofAssociation assoc = this.getAssociation( descriptor );
        if ( assoc != null ) {
            final Collection<TElement> instances = this.getSerializerCallback( ).getLinkedInstances( elementA, assoc, endOutputName );
            final List<SModelElementHandle> intermediateResult = new ArrayList<SModelElementHandle>( instances.size( ) );
            for ( final TElement instance : instances ) {
                if ( instance == null ) {
                    // this happens when the link is broken, i.e. when there is an end  for which only a MOFID exists
                    // but the refObject could not be found
                    if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
                        LOGGER.trace( MoinSeverity.INFO, "Broken link of asscociation {0} with output end name {1} and input model element MOFID {2} detected", new Object[] { assoc, endOutputName, endInputModelElement.getMofid( ) } ); //$NON-NLS-1$
                    }
                } else {
                    final String mofId = this.getSerializerCallback( ).getInstanceMofId( instance );
                    this.put( mofId, instance );
                    intermediateResult.add( new SModelElementHandleImpl<TElement, TMofClass, TMofAssociation>( this.getSerializerCallback( ).getMri( instance ), this.getSerializerCallback( ).getType( instance ), this ) );
                }
            }
            if ( LOGGER.isTraced( MoinSeverity.INFO ) && intermediateResult.isEmpty( ) ) {
                LOGGER.trace( MoinSeverity.INFO, "No linked model element found for association {0} with end output name {1} and end input MOFID {2}", new Object[] { assoc, endOutputName, endInputModelElement.getMofid( ) } ); //$NON-NLS-1$
            }
            result = intermediateResult;
        } else {
            if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                LOGGER.trace( MoinSeverity.WARNING, "No association found with qualified name {0} and meta-model container {1} ", new Object[] { Arrays.toString( descriptor.getQualifiedName( ) ), descriptor.getModelContainerName( ) } ); //$NON-NLS-1$
            }
            result = Collections.emptyList( );
        }
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) && !result.isEmpty( ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "{0} model elements linked to model element {1} via association {2} and end name {3} returned", new Object[] { result.size( ), elementA, assoc, endOutputName } ); //$NON-NLS-1$
        }
        return result;
    }
}
