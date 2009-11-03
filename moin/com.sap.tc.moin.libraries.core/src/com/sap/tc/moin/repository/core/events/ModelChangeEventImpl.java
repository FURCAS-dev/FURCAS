package com.sap.tc.moin.repository.core.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;

/**
 * This is the implementation of
 * {@link com.sap.tc.moin.repository.events.type.ModelChangeEvent}
 * 
 * @author Daniel Vocke (D044825)
 */
public abstract class ModelChangeEventImpl extends ChangeEventImpl implements ModelChangeEvent {

    // It must be a Set to avoid duplicates, possible in LinkChangeEvents
    private Collection<LRI> compositeParentLRIsIncludingSelf = null;

    private RefBaseObject element0ForCompositeParentCalculation = null;

    private RefBaseObject element1ForCompositeParentCalculation = null;

    /**
     * this member is filled in the constructor of the concrete event
     */
    protected Collection<LRI> classFilterLris = null;

    /**
     * this member is filled in the constructor of the concrete event
     */
    protected LRI immediatePackageExtentLri = null;

    /**
     * Constructor
     */
    public ModelChangeEventImpl( CoreConnection triggeringConnection ) {

        super( triggeringConnection );
    }

    /**
     * @return the element(s) that might be touched by the actions that this
     * event indicates. The return type is either {@link MRI}if only one element
     * is affected or {@link List}if more than one element is affected.
     */
    public abstract Collection<LRI> getAffectedElementsLris( );

    protected Collection<LRI> getCompositeParentLRIsIncludingSelf( ) {

        if ( compositeParentLRIsIncludingSelf == null ) {
            compositeParentLRIsIncludingSelf = new ArrayList<LRI>( 8 );
        }
        return compositeParentLRIsIncludingSelf;
    }

    /**
     * @return all transitive containers of the affectedElement including the
     * immediatePackage
     */
    public Collection<LRI> getAffectedElementsLRIsIncludingCompositeParents( ) {

        if ( element0ForCompositeParentCalculation != null ) {
            addCompositeParentLRIsToCache( element0ForCompositeParentCalculation );
            element0ForCompositeParentCalculation = null;
        }

        if ( element1ForCompositeParentCalculation != null ) {
            addCompositeParentLRIsToCache( element1ForCompositeParentCalculation );
            element1ForCompositeParentCalculation = null;
        }

        return compositeParentLRIsIncludingSelf;
    }

    private void addCompositeParentLRIsToCache( RefBaseObject element ) {

        getCompositeParentLRIsIncludingSelf( ).add( ( (Partitionable) element ).get___Mri( ).getLri( ) );
        RefFeatured parent = ( (RefObjectImpl) element ).refImmediateComposite( eventTriggerConnection.getSession( ) );
        if ( parent != null ) {
            addCompositeParentLRIsToCache( parent );
        }
    }

    protected void storeElementForCompositeParentCalculation( RefBaseObject element ) {

        element0ForCompositeParentCalculation = element;
    }

    protected void storeElementForCompositeParentCalculation( RefBaseObject element, int index ) {

        if ( index == 0 ) {
            element0ForCompositeParentCalculation = element;
        } else {
            element1ForCompositeParentCalculation = element;
        }
    }

    /**
     * @return a <code>LRI</code> which points to the affected MetaObject. This
     * method is needed by the ClassFilterTable in order to determine the
     * metaObject of the affected element. The return type is either {@link MRI}
     * if only one element is affected or {@link List}if more than one element
     * is affected.
     */
    public Collection<LRI> getClassFilterLris( ) {

        return classFilterLris;
    }

    /**
     * @return a <code>MRI</code> which points to the extent in which the
     * affected object lives. This method is needed by the PackageFilterTable in
     * order to determine the extent of the affected element. The return type is
     * either {@link MRI}if only one element is affected or {@link List}if more
     * than one element is affected.
     */
    public LRI getImmediatePackageExtentLri( ) {

        return immediatePackageExtentLri;
    }

}