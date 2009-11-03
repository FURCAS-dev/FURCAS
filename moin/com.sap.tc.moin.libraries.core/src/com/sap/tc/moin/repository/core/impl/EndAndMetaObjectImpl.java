package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.core.EndAndMetaObject;
import com.sap.tc.moin.repository.core.MetamodelMriReference;
import com.sap.tc.moin.repository.core.MoinReference;
import com.sap.tc.moin.repository.core.WorkspaceSet;

/**
 * Implementation of interface
 * {@link com.sap.tc.moin.repository.core.EndAndMetaObject}.
 */
public final class EndAndMetaObjectImpl implements EndAndMetaObject, Comparable<EndAndMetaObjectImpl> {

    private final byte fromEnd;

    private final String mofId;

    private MetamodelMriReference metaObject;

    private final int hashCode;

    private int fromEndMultiplicityUpper = Integer.MIN_VALUE;

    private int toEndMultiplicityUpper = Integer.MIN_VALUE;

    EndAndMetaObjectImpl( byte fromEnd, String mofIdMetaObject ) {

        this.fromEnd = fromEnd;
        this.mofId = mofIdMetaObject;
        this.hashCode = fromEnd ^ mofIdMetaObject.hashCode( );
    }

    @Override
    public boolean equals( Object o ) {

        if ( this == o ) {
            return true;
        }
        if ( o instanceof EndAndMetaObjectImpl ) {
            EndAndMetaObjectImpl other = (EndAndMetaObjectImpl) o;
            return other.fromEnd == fromEnd && other.mofId == mofId; // $JL-STRING$ MOF IDs are interned
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return hashCode;
    }

    public byte getFromEnd( ) {

        return fromEnd;
    }

    public MRI getMetaObject( ) {

        return metaObject.getMri( );
    }

    public MoinReference getMetaObject( CoreMoin moin ) {

        if ( this.metaObject == null ) {
            WorkspaceSet workspaceSet = moin.getMetamodelWorkspace( ).getWorkspaceSet( );

            this.metaObject = workspaceSet.getReferenceManager( ).getMetamodelMriReference( moin.getMetamodelWorkspace( ).getMetamodelElement( mofId ) );
        }
        return metaObject;
    }

    public byte getToEnd( ) {

        return (byte) ( 1 - this.fromEnd );
    }

    public int compareTo( EndAndMetaObjectImpl o ) {

        int result = mofId.compareTo( o.mofId );
        if ( result == 0 ) {
            // Need to compare the fromEnd, too.
            return Byte.valueOf( fromEnd ).compareTo( Byte.valueOf( o.fromEnd ) );
        }
        return result;
    }

    public String getMetaObjectMofId( ) {

        return this.mofId;
    }

    public boolean isFromEndMultiplicityOne( CoreConnection connection ) {

        if ( fromEndMultiplicityUpper == Integer.MIN_VALUE ) {
            WorkspaceSet workspaceSet = connection.getSession( ).getWorkspaceSet( );
            CorePartitionable mo = getMetaObject( workspaceSet.getMoin( ) ).get( connection.getSession( ) );
            if ( mo instanceof Association ) {
                AssociationEnd end = workspaceSet.getMoin( ).getJmiHelper( ).getAssociationEnds( connection.getSession( ), (Association) mo ).get( fromEnd );
                fromEndMultiplicityUpper = end.getMultiplicity( ).getUpper( );
            } else {
                fromEndMultiplicityUpper = 1;
            }
        }
        return fromEndMultiplicityUpper == 1;
    }

    public boolean isToEndMultiplicityOne( CoreSession session, WorkspaceSet workspaceSet ) {

        if ( toEndMultiplicityUpper == Integer.MIN_VALUE ) {
            CorePartitionable mo = getMetaObject( workspaceSet.getMoin( ) ).get( session );
            if ( mo instanceof Association ) {
                AssociationEnd end = workspaceSet.getMoin( ).getJmiHelper( ).getAssociationEnds( session, (Association) mo ).get( getToEnd( ) );
                toEndMultiplicityUpper = end.getMultiplicity( ).getUpper( );
            } else {
                toEndMultiplicityUpper = ( (Attribute) mo ).getMultiplicity( ).getUpper( );
            }
        }
        return toEndMultiplicityUpper == 1;
    }
}