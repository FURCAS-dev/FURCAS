package com.sap.tc.moin.repository.core.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent;
import com.sap.tc.moin.repository.shared.util.QualifiedName;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.PartitionMembershipChangeEvent}
 * 
 * @author Daniel Vocke (D044825)
 */
public class PartitionMembershipChangeEventImpl extends ModelChangeEventImpl implements PartitionMembershipChangeEvent {

    /**
     * the partition from which the element was /shall be moved to another
     * partition
     */
    private PRI oldPartitionPri = null;

    /**
     * the partition the element was / shall be moved to
     */
    private PRI newPartitionPri = null;

    /**
     * the {@link LRI} of the element that was moved
     */
    private LRI affectedElementLri = null;

    /**
     * @param affectedElement the element that was / shall be moved
     * @param oldPartition the partition from which the element was /shall be
     * moved to another partition
     * @param newPartition the partition the element was / shall be moved to
     */
    public PartitionMembershipChangeEventImpl( CoreConnection triggeringConnection, RefObject affectedElement, ModelPartition oldPartition, ModelPartition newPartition ) {

        super( triggeringConnection );
        oldPartitionPri = oldPartition.getPri( );
        newPartitionPri = newPartition.getPri( );
        affectedElementLri = ( (Partitionable) affectedElement ).get___Mri( ).getLri( );
        this.classFilterLris = Collections.singleton( ( (Partitionable) affectedElement.refMetaObject( ) ).get___Mri( ).getLri( ) );
        this.immediatePackageExtentLri = ( (Partitionable) affectedElement.refImmediatePackage( ) ).get___Mri( ).getLri( );
        storeElementForCompositeParentCalculation( affectedElement );
    }

    /*
     * @seecom.sap.tc.moin.repository.events.PartitionMembershipChangeEvent#
     * getAffectedElement()
     */
    public MRI getAffectedElementOldMri( ) {

        return oldPartitionPri.createMri( affectedElementLri.getMofId( ) );
    }

    /*
     * @seecom.sap.tc.moin.repository.events.PartitionMembershipChangeEvent#
     * getAffectedElementNewMRI()
     */
    public MRI getAffectedElementNewMri( ) {

        return newPartitionPri.createMri( affectedElementLri.getMofId( ) );
    }

    /*
     * @seecom.sap.tc.moin.repository.events.PartitionMembershipChangeEvent#
     * getAffectedElement(com.sap.tc.moin.repository.core.impl.Connection)
     */
    public RefObject getAffectedElement( Connection resolvingConnection ) {

        return (RefObject) ( resolvingConnection.getElement( getAffectedElementOldMri( ).getLri( ) ) );
    }

    /*
     * @seecom.sap.tc.moin.repository.events.PartitionMembershipChangeEvent#
     * getNewPartitionMri()
     */
    public PRI getNewPartitionPri( ) {

        return newPartitionPri;
    }

    /*
     * @seecom.sap.tc.moin.repository.events.PartitionMembershipChangeEvent#
     * getNewPartition(com.sap.tc.moin.repository.core.impl.Connection)
     */
    public ModelPartition getNewPartition( Connection resolvingConnection ) {

        return resolvingConnection.getPartition( getNewPartitionPri( ) );
    }

    /*
     * @seecom.sap.tc.moin.repository.events.PartitionMembershipChangeEvent#
     * getOldPartitionMri()
     */
    public PRI getOldPartitionPri( ) {

        return oldPartitionPri;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.events.PartitionMembershipChangeEvent#
     * getOldPartition(com.sap.tc.moin.repository.core.impl.Connection)
     */
    public ModelPartition getOldPartition( Connection resolvingConnection ) {

        return resolvingConnection.getPartition( getOldPartitionPri( ) );
    }

    /**
     * @see com.sap.tc.moin.repository.events.ChangeEventImpl#getAffectedPartitionsMRIs()
     * @return a set containing both, the old and the new partition
     */
    @Override
    public Object getAffectedPartitionsPRIs( ) {

        // cache result?
        List<PRI> result = new ArrayList<PRI>( 2 );

        result.add( oldPartitionPri );
        result.add( newPartitionPri );

        return result;
    }

    /**
     * @see com.sap.tc.moin.repository.events.ChangeEventImpl#getAffectedElementsMRIs()
     * @return the {@link PartitionMembershipChangeEvent#getAffectedElement()
     * affected Element}
     */
    @Override
    public Collection<LRI> getAffectedElementsLris( ) {

        return Collections.singletonList( getAffectedElementNewMri( ).getLri( ) );
    }

    @Override
    protected String getParameterString( ) {

        StringBuilder buf = new StringBuilder( );
        ModelElementInternal metaObject = (ModelElementInternal) eventTriggerConnection.getElement( this.classFilterLris.iterator( ).next( ) );
        buf.append( "type=" ).append( QualifiedName.toDotSeparatedString( metaObject.getQualifiedName( eventTriggerConnection ) ) ); //$NON-NLS-1$
        buf.append( ",oldPRI=" ).append( getOldPartitionPri( ).toString( ) ); //$NON-NLS-1$
        buf.append( ",newPRI=" ).append( getNewPartitionPri( ).toString( ) ); //$NON-NLS-1$
        buf.append( ",oldMRI=" ).append( getAffectedElementOldMri( ).toString( ) ); //$NON-NLS-1$
        buf.append( ",newMRI=" ).append( getAffectedElementNewMri( ).toString( ) ); //$NON-NLS-1$
        return buf.toString( );
    }

    @Override
    protected String getTypeString( ) {

        return "PartitionMembershipChangeEvent"; //$NON-NLS-1$
    }

    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( affectedElementLri == null ) ? 0 : affectedElementLri.hashCode( ) );
        result = prime * result + ( ( newPartitionPri == null ) ? 0 : newPartitionPri.hashCode( ) );
        result = prime * result + ( ( oldPartitionPri == null ) ? 0 : oldPartitionPri.hashCode( ) );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final PartitionMembershipChangeEventImpl other = (PartitionMembershipChangeEventImpl) obj;
        if ( affectedElementLri == null ) {
            if ( other.affectedElementLri != null ) {
                return false;
            }
        } else if ( !affectedElementLri.equals( other.affectedElementLri ) ) {
            return false;
        }
        if ( newPartitionPri == null ) {
            if ( other.newPartitionPri != null ) {
                return false;
            }
        } else if ( !newPartitionPri.equals( other.newPartitionPri ) ) {
            return false;
        }
        if ( oldPartitionPri == null ) {
            if ( other.oldPartitionPri != null ) {
                return false;
            }
        } else if ( !oldPartitionPri.equals( other.oldPartitionPri ) ) {
            return false;
        }
        return true;
    }

}
