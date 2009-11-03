package com.sap.tc.moin.xm.adapter.ie;

import static com.sap.tc.moin.repository.JmiHelper.MULTIPLICITY_BOUND_INFINITE;

import java.util.Collection;
import java.util.Locale;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidObjectException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.friends.RefObjectUtil;
import com.sap.tc.moin.friends.core.CoreUtilitiesFactory;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalNullArgumentException;
import com.sap.tc.moin.repository.exception.MoinIllegalStateException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mmi.reflect.RefClassCalculatedMofId;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.kernel.XmParserCallback;



/**
 * Implementation of the XM Parser Call-back in the Import case.
 */
final class ImportCallback extends ImportExportCallback implements XmParserCallback<RefObject, RefClass, RefAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, ImportCallback.class );

    private final JmiHelper jmiHelper;

    private ModelPartition partition;

    /**
     * Constructor.
     * 
     * @param aConnection
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    ImportCallback( final Connection aConnection ) {

        super( aConnection );
        this.jmiHelper = aConnection.getJmiHelper( );
    }

    /**
     * Sets the PRI.
     * 
     * @param pri
     * @throws NullPointerException if <tt>aPri</tt> is <code>null</code>
     * @throws IllegalArgumentException if the model partition for the given PRI
     * does not exist
     */
    @Override
    void setPri( final PRI pri ) {

        super.setPri( pri );
        this.partition = this.getConnection( ).getPartition( pri );
    }

    /**
     * Removes all model elements from the model partition, without deleting the
     * links pointing into the model partition. Remark: The following situation
     * can occur: Suppose an external link points to a model element before the
     * import, and the model element is deleted after the import. Now, we have a
     * dangling link. Must we delete this link? Answer: NO!
     */
    void clearPartition( ) {

        final RefObjectUtil util = CoreUtilitiesFactory.getRefObjectUtil( );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            if ( !this.partition.getElements( ).isEmpty( ) ) {
                LOGGER.trace( MoinSeverity.DEBUG, "Partition {0} contains elements. These elements are removed.", this.partition.getPri( ) ); //$NON-NLS-1$
            }
        }
        for ( final Partitionable el : this.partition.getElements( ) ) {
            util.deleteIsolated( (RefObject) el );
        }

    }


    public RefObject createClassInstance( final RefClass clazz, final String... logicalKey ) {

        return ( (RefClassCalculatedMofId) clazz ).refCreateInstanceInPartition( this.partition, logicalKey );
    }

    @SuppressWarnings( "unchecked" )
    public void setOrAddAttribute( final RefObject parentRefObject, final String attributeName, final String value ) {

        final com.sap.tc.moin.repository.mmi.model.Attribute attribute = this.getAttribute( parentRefObject, attributeName );

        if ( attribute == null ) {
            throw new InvalidNameException( attributeName );
        }
        if ( value == null ) {
            throw new MoinIllegalNullArgumentException( "value" ); //$NON-NLS-1$
        }

        final Class<?> primitiveClass = jmiHelper.getJavaPrimitiveOrWrapperType( attribute );
        final Object objectValue;
        if ( primitiveClass == String.class ) {
            objectValue = value;
        } else if ( primitiveClass == long.class ) {
            objectValue = Long.parseLong( value );
        } else if ( primitiveClass == boolean.class ) {
            objectValue = Boolean.parseBoolean( value );
        } else if ( primitiveClass == int.class ) {
            objectValue = Integer.parseInt( value );
        } else if ( primitiveClass == double.class ) {
            objectValue = Double.parseDouble( value );
        } else if ( primitiveClass == float.class ) {
            objectValue = Float.parseFloat( value );
        } else if ( primitiveClass == Long.class ) {
            objectValue = Long.valueOf( value );
        } else if ( primitiveClass == Boolean.class ) {
            objectValue = Boolean.valueOf( value );
        } else if ( primitiveClass == Integer.class ) {
            objectValue = Integer.valueOf( value );
        } else if ( primitiveClass == Double.class ) {
            objectValue = Double.valueOf( value );
        } else if ( primitiveClass == Float.class ) {
            objectValue = Float.valueOf( value );
        } else {
            final String className = primitiveClass == null ? "" : primitiveClass.getName( ); //$NON-NLS-1$
            LOGGER.traceWithStack( MoinSeverity.ERROR, XmIeMessages.UNSUPPORTEDPRIMITIVETYPE, new Object[] { attributeName, className } );
            throw new MoinIllegalStateException( XmIeMessages.UNSUPPORTEDPRIMITIVETYPE, new Object[] { attributeName, className } );
        }

        if ( attribute.getMultiplicity( ).getUpper( ) > 1 || attribute.getMultiplicity( ).getUpper( ) == MULTIPLICITY_BOUND_INFINITE ) {
            ( (Collection) parentRefObject.refGetValue( attribute.getName( ) ) ).add( objectValue );
        } else {
            parentRefObject.refSetValue( attribute.getName( ), objectValue );
        }
    }


    /**
     * Returns the attribute of a class instance with a certain name. The
     * attributes of the super classes are taken into account. If the attribute
     * does not exist a IllegalSteteException is added to the errors list.
     * 
     * @param classInstance instance
     * @param attributeName attribute name
     * @return attribute, <tt>null</tt> if the attribute is not found
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    private Attribute getAttribute( final RefObject classInstance, final String attributeName ) {

        if ( attributeName == null ) {
            throw new MoinNullPointerException( "attributeName" ); //$NON-NLS-1$
        }

        final MofClass mofClass = (MofClass) classInstance.refMetaObject( );
        final com.sap.tc.moin.repository.mmi.model.Attribute attribute = jmiHelper.getAttributeByName( mofClass, attributeName, true );
        return attribute;
    }


    public void addLink( final RefAssociation refAss, final RefObject endARefObject, final RefObject endBRefObject, final String endBName ) {

        final Association ass = refAss.refMetaObject( );
        try {
            final AssociationEnd endB = (AssociationEnd) ass.lookupElement( endBName );
            createLink( refAss, endBRefObject, jmiHelper.isFirstAssociationEnd( ass, endB ), endARefObject );
        } catch ( final NameNotFoundException e ) {
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmIeMessages.INCORRECTASSOCIATIONENDNAME, new Object[] { endBName, "endBName", ass.getQualifiedName( ) } ); //$NON-NLS-1$
            final MoinIllegalArgumentException newe = new MoinIllegalArgumentException( XmIeMessages.INCORRECTASSOCIATIONENDNAME, new Object[] { endBName, "endBName", ass.getQualifiedName( ) } ); //$NON-NLS-1$
            newe.initCause( e );
            throw newe;
        } catch ( final TypeMismatchException e ) {
            LOGGER.trace( e, MoinSeverity.ERROR, e.getLocalizedMessage( Locale.ENGLISH ) );
            throw new IllegalArgumentException( e.getLocalizedMessage( ), e );
        }
    }

    public void addLink( final RefAssociation refAss, final RefObject endARefObject, final String mofIdOfElementAtEndB, final String endBName ) {

        final Association ass = refAss.refMetaObject( );
        try {
            final AssociationEnd endB = (AssociationEnd) ass.lookupElement( endBName );
            final DataAreaDescriptor das = this.getPri( ).getDataAreaDescriptor( );
            final LRI lri = this.getConnection( ).getSession( ).getMoin( ).createLri( das.getFacilityId( ), das.getDataAreaName( ), mofIdOfElementAtEndB );
            CoreUtilitiesFactory.getRefObjectUtil( ).addLinkTarget( endARefObject, endB, lri );
        } catch ( final NameNotFoundException e ) {
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmIeMessages.INCORRECTASSOCIATIONENDNAME, new Object[] { endBName, "endBName", ass.getQualifiedName( ) } ); //$NON-NLS-1$
            final MoinIllegalArgumentException newe = new MoinIllegalArgumentException( XmIeMessages.INCORRECTASSOCIATIONENDNAME, new Object[] { endBName, "endBName", ass.getQualifiedName( ) } ); //$NON-NLS-1$
            newe.initCause( e );
            throw newe;
        } catch ( final TypeMismatchException e ) {
            LOGGER.trace( e, MoinSeverity.ERROR, e.getLocalizedMessage( ) );
            throw new IllegalArgumentException( e.getLocalizedMessage( ), e );
        }
    }

//    public RefClass getTypeOfAssociationEnd( final RefAssociation refAss, final String endName ) {
//
//        if ( endName == null ) {
//            throw new MoinIllegalNullArgumentException( "endName" ); //$NON-NLS-1$
//        }
//        final Association ass = refAss.refMetaObject( );
//        try {
//            final AssociationEnd endB = (AssociationEnd) ass.lookupElement( endName );
//            final MofClass clazz = (MofClass) endB.getType( );
//            final String dotSeparatedQualifiedName = this.getDotSeparatedQualifiedName( clazz.getQualifiedName( ) );
//            final String containerName = ( (Partitionable) clazz ).get___Partition( ).getPri( ).getContainerName( );
//            return this.getClass( containerName, dotSeparatedQualifiedName );
//        } catch ( final NameNotFoundException e ) {
//            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmIeMessages.INCORRECTASSOCIATIONENDNAME, new Object[] { endName, "endName", ass.getQualifiedName( ) } ); //$NON-NLS-1$
//            throw new MoinIllegalArgumentException( XmIeMessages.INCORRECTASSOCIATIONENDNAME, new Object[] { endName, "endName", ass.getQualifiedName( ) }, e ); //$NON-NLS-1$
//        }
//    }

    /**
     * Create an association link between a model element A and class instance
     * B.
     * 
     * @param refAss association
     * @param endAObject object A
     * @param endAIsFirst
     * @param endBObject class instance B
     * @return class instance B
     * @throws TypeMismatchException if the instance objects are not compatible
     * with the association.
     * @throws InvalidObjectException if one or more instance objects are not
     * valid instance objects.
     */
    private RefObject createLink( final RefAssociation refAss, final RefObject endAObject, final boolean endAIsFirst, final RefObject endBObject ) {

        if ( endAIsFirst ) {
            refAss.refAddLink( endAObject, endBObject );
        } else {
            refAss.refAddLink( endBObject, endAObject );
        }
        return endBObject;
    }


}
