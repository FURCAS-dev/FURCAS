package com.sap.tc.moin.repository.core.events;

import java.util.Collection;
import java.util.Collections;

import com.sap.tc.moin.repository.mmi.model.__impl.ModelElementInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.shared.util.QualifiedName;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.ElementChangeEvent}
 * 
 * @author Daniel Vocke (D044825)
 */

public abstract class ElementChangeEventImpl extends ModelChangeEventImpl implements ElementChangeEvent {

    protected MRI elementMri = null;

    ElementChangeEventImpl( CoreConnection triggeringConnection ) {

        super( triggeringConnection );
    }

    /**
     * @param affectedElement the changed element
     */
    ElementChangeEventImpl( CoreConnection triggeringConnection, RefFeatured affectedElement ) {

        super( triggeringConnection );

        elementMri = retrieveElementMri( affectedElement );

        // set additional members (which cannot be computed with an MRI)
        this.classFilterLris = Collections.singletonList( retrieveElementLri( affectedElement.refMetaObject( ) ) );

        this.immediatePackageExtentLri = ( (Partitionable) affectedElement.refImmediatePackage( ) ).get___Mri( ).getLri( );

        storeElementForCompositeParentCalculation( affectedElement );
    }

    /**
     * @param affectedElement the changed element
     */
    ElementChangeEventImpl( CoreConnection triggeringConnection, MRI affectedElementMri, MRI metaObjectMri, MRI immediatePackageExtentMri ) {

        super( triggeringConnection );

        elementMri = affectedElementMri;

        // set additional members (which cannot be computed with an MRI)
        this.classFilterLris = Collections.singletonList( metaObjectMri.getLri( ) );

        this.immediatePackageExtentLri = immediatePackageExtentMri.getLri( );

        getCompositeParentLRIsIncludingSelf( ).add( affectedElementMri.getLri( ) );
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.ElementChangeEvent#getAffectedElement()
     */

    public MRI getAffectedElementMri( ) {

        return elementMri;
    }

    /*
     * @see
     * com.sap.tc.moin.repository.events.ElementChangeEvent#getAffectedElement
     * (com.sap.tc.moin.repository.core.impl.Connection)
     */
    public RefObject getAffectedElement( Connection resolvingConnection ) {

        return (RefObject) resolvingConnection.getElement( getAffectedElementMri( ).getLri( ) );
    }

    /**
     * @return the MRI of the affected partition (= the partition where the
     * affectedElement lives in)
     */
    @Override
    public Object getAffectedPartitionsPRIs( ) {

        return elementMri.getPri( );
    }

    /**
     * @see com.sap.tc.moin.repository.events.ChangeEventImpl#getAffectedElementsMRIs()
     * @return a list containing only the
     * {@link ElementChangeEvent#getAffectedElement() affected element}
     */
    public Object getAffectedElementsMRIs( ) {

        return getAffectedElementMri( );
    }

    @Override
    protected String getParameterString( ) {

        try {
            RefBaseObject rbo = eventTriggerConnection.getElement( classFilterLris.iterator( ).next( ) );
            ModelElementInternal metaObject = ( rbo instanceof ModelElementInternal ? (ModelElementInternal) rbo : (ModelElementInternal) rbo.refMetaObject( ) );
            return "type=" + QualifiedName.toDotSeparatedString( metaObject.getQualifiedName( eventTriggerConnection ) ); //$NON-NLS-1$
        } catch ( Exception ex ) {
            return "type=???"; //$NON-NLS-1$
        }
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.core.events.ModelChangeEventImpl#
     * getAffectedElementsLris()
     */
    @Override
    public Collection<LRI> getAffectedElementsLris( ) {

        return Collections.singletonList( getAffectedElementMri( ).getLri( ) );
    }

}
