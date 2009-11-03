package com.sap.tc.moin.xm.adapter.ie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.TypeMismatchException;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.xm.kernel.XmSerializerCallback;


/**
 * Implementation of the XM Parser Call-back in the Export case.
 */
final class ExportCallback extends ImportExportCallback implements XmSerializerCallback<RefObject, RefClass, RefAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, ExportCallback.class );

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    private static final String MQL_ALIAS_INSTANCE = "instance"; //$NON-NLS-1$


    /**
     * Constructor.
     * 
     * @param aConnection
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    ExportCallback( final Connection aConnection ) {

        super( aConnection );
    }



    public Collection<RefObject> getInstances( final RefClass refClass ) {

        if ( refClass == null ) {
            throw new MoinNullPointerException( "refClass" ); //$NON-NLS-1$
        }
        final FromEntry fe = this.getFromType( refClass.refMetaObject( ).getQualifiedName( ), ( (Partitionable) refClass.refMetaObject( ) ).get___Partition( ).getPri( ).getContainerName( ), MQL_ALIAS_INSTANCE );
        final MQLQuery mq = new MQLQuery( new SelectEntry[] { new SelectAlias( MQL_ALIAS_INSTANCE ) }, new FromEntry[] { fe } );
        final MQLResultSet mrs = this.getConnection( ).getMQLProcessor( ).execute( mq, this.getConnection( ).getMQLProcessor( ).getInclusivePartitionScopeProvider( this.getPri( ) ) );
        return Arrays.asList( mrs.getRefObjects( MQL_ALIAS_INSTANCE ) );
    }

    private FromType getFromType( final List<String> qualifiedName, final String container, final String mqlAlias ) {

        return new FromType( mqlAlias, qualifiedName.toArray( EMPTY_STRING_ARRAY ), container, true );
    }


    public RefObject getClassInstance( final RefClass mofClass, final String... logicalKeys ) {

        return (RefObject) this.getConnection( ).getElement( this.getPri( ).createMri( this.calculateElementMofId( mofClass, logicalKeys ) ) );
    }

    public RefObject getClassInstance( final MRI mri ) {

        if ( mri == null ) {
            throw new MoinNullPointerException( "mri" ); //$NON-NLS-1$
        }
        return (RefObject) this.getConnection( ).getElement( mri );
    }

    public RefObject getClassInstance( final LRI lri ) {

        if ( lri == null ) {
            throw new MoinNullPointerException( "lri" ); //$NON-NLS-1$
        }
        return (RefObject) this.getConnection( ).getElement( lri );
    }

//    public String getQualifiedName( final RefObject instance ) {
//
//        final MofClass cl = (MofClass) instance.refMetaObject( );
//        final List<String> qualifiedMofClassName = cl.getQualifiedName( );
//        return toDotSeparatedString( qualifiedMofClassName );
//    }

//    public String getMetamodelContainer( final RefObject instance ) {
//
//        final MofClass cl = (MofClass) instance.refMetaObject( );
//        return ( (Partitionable) cl ).get___Partition( ).getPri( ).getContainerName( );
//    }

    public MRI getMri( final RefObject instance ) {

        return instance.get___Mri( );
    }

//    /**
//     * Creates a dot-separated String from the List entries. On each entry of
//     * the passed List the toString method is invoked to get a String.
//     * 
//     * @param qualifiedName the qualified name in {@link List} format
//     * @return the dot-separated String which represents the qualifiedName
//     */
//    private static final String toDotSeparatedString( final List<String> qualifiedName ) {
//
//        final int size = qualifiedName.size( );
//        int len = 0;
//        for ( int i = 0; i < size; i++ ) {
//            len += qualifiedName.get( i ).length( );
//            if ( i > 0 ) {
//                len++; // space for the dot separator
//            }
//        }
//        final StringBuilder result = new StringBuilder( len );
//        for ( int i = 0; i < size; i++ ) {
//            if ( i > 0 ) {
//                result.append( '.' );
//            }
//            result.append( qualifiedName.get( i ) );
//        }
//        return result.toString( );
//    }

    public Object getAttributeValue( final RefObject instance, final String attributeName ) {

        final MofClass cl = (MofClass) instance.refMetaObject( );
        final Attribute attr = this.getConnection( ).getJmiHelper( ).getAttributeByName( cl, attributeName, true );
        if ( attr == null ) {
            // this check is necessary in order to restrict the request to attributes, otherwise it may be possible
            // to fetch reference values with this method
            LOGGER.logAndTrace( MoinSeverity.ERROR, XmIeMessages.ATTRIBUTENOTONTYPE, cl.getQualifiedName( ), attributeName );
            throw new MoinIllegalArgumentException( XmIeMessages.ATTRIBUTENOTONTYPE, cl.getQualifiedName( ), attributeName );
        }
        Object result = instance.refGetValue( attributeName );
        if ( result != null ) {
            if ( !Collection.class.isAssignableFrom( result.getClass( ) ) ) {
                // single value 
                result = result.toString( );
            } else {
                // multi valued; convert to string list
                final Collection<?> list = (Collection<?>) result;
                final Collection<String> resultList = new ArrayList<String>( list.size( ) );
                for ( final Object ob : list ) {
                    resultList.add( ob.toString( ) );
                }
                result = resultList;
            }
        }
        return result;
    }


    public Collection<RefObject> getLinkedInstances( final RefObject endAinstance, final RefAssociation association, final String endBName ) {

        String endAName = null;
        boolean found = false;
        for ( final AssociationEnd end : this.getConnection( ).getJmiHelper( ).getAssociationEnds( association.refMetaObject( ) ) ) {
            if ( !endBName.equals( end.getName( ) ) ) {
                endAName = end.getName( );
            } else {
                found = true;
            }
        }
        if ( !found ) {
            LOGGER.logAndTrace( MoinSeverity.ERROR, XmIeMessages.ASSOCIATIONINCORRECTENDNAME, new Object[] { association.refMetaObject( ).getQualifiedName( ), endBName } );
            throw new MoinIllegalArgumentException( XmIeMessages.ASSOCIATIONINCORRECTENDNAME, new Object[] { association.refMetaObject( ).getQualifiedName( ), endBName } );
        }
        try {
            return association.refQuery( endAName, endAinstance );
        } catch ( final TypeMismatchException e ) {
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmIeMessages.TYPENOTFITTINGTOASSOCEND, new Object[] { ( (MofClass) endAinstance.refMetaObject( ) ).getQualifiedName( ), endAName, association.refMetaObject( ).getQualifiedName( ) } );
            throw new MoinIllegalArgumentException( e, XmIeMessages.TYPENOTFITTINGTOASSOCEND, new Object[] { ( (MofClass) endAinstance.refMetaObject( ) ).getQualifiedName( ), endAName, association.refMetaObject( ).getQualifiedName( ) } );
        } catch ( final InvalidCallException e ) {
            LOGGER.logAndTrace( e, MoinSeverity.ERROR, XmIeMessages.TYPENOTFITTINGTOASSOCEND, new Object[] { ( (MofClass) endAinstance.refMetaObject( ) ).getQualifiedName( ), endAName, association.refMetaObject( ).getQualifiedName( ) } );
            throw new MoinIllegalArgumentException( e, XmIeMessages.TYPENOTFITTINGTOASSOCEND, new Object[] { ( (MofClass) endAinstance.refMetaObject( ) ).getQualifiedName( ), endAName, association.refMetaObject( ).getQualifiedName( ) } );
        }
        // returns all linked instances not only those which are in the partition. Therefore the following lines are commented.
//        // return only objects contained in the current partition
//        return this.getPartitionObjects( refObjs );
    }

    private List<RefObject> elements;

    @SuppressWarnings( "unchecked" )
    public Collection<RefObject> getStoredElements( ) {

        if ( elements == null ) {
            elements = new ArrayList( this.getConnection( ).getPartition( this.getPri( ) ).getElements( ) );
        }
        return this.elements;
    }
}
