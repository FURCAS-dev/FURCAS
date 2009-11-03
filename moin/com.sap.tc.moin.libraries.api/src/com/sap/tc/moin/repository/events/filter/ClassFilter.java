package com.sap.tc.moin.repository.events.filter;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.Partitionable;

/**
 * Class filters are used to specify the type of the model element to observe.
 * Clients will have to set the meta object as filter criterion in order to
 * reduce the set of delivered events to events that indicate a change of
 * elements of the requested type. If the <code>includeSubClasses</code> flag
 * is set to true, subclasses will also be included.<br>
 * 
 * @see com.sap.tc.moin.repository.events.filter.EventFilter
 * @author Daniel Vocke (D044825)
 */

public class ClassFilter extends EventFilter {

    /**
     * @param filterCriterion defines the type of the observed instances.
     * @param includeSubclasses defines whether subtypes are also included.
     */
    public ClassFilter( MofClass filterCriterion, boolean includeSubclasses ) {

        super( includeSubclasses ? getSubTypesSet( filterCriterion ) : ( (Partitionable) filterCriterion ).get___Mri( ) );
    }

    /**
     * @param filterCriteria a collection of filter criteria
     * @param includeSubclasses includes all sub-classes of the given
     * filterCriteria
     */
    public ClassFilter( Set<MofClass> filterCriteria, boolean includeSubclasses ) {

        super( includeSubclasses ? getSubTypesSet( filterCriteria ) : getLris( filterCriteria ) );
    }

    /**
     * @param filterCriterion a collection of filter criterion
     */
    public ClassFilter( LRI filterCriterion ) {

        super( filterCriterion );
    }

    private static Set<LRI> getLris( Collection<MofClass> classes ) {

        Set<LRI> lris = new HashSet<LRI>( );
        for ( MofClass clazz : classes ) {
            lris.add( ( (Partitionable) clazz ).get___Mri( ).getLri( ) );
        }

        return lris;
    }

    private static Set<LRI> getSubTypesSet( Collection<MofClass> classes ) {

        Set<LRI> subTypes = new HashSet<LRI>( );
        for ( MofClass clazz : classes ) {
            subTypes.addAll( getSubTypesSet( clazz ) );
        }
        return subTypes;
    }

    private static Set<LRI> getSubTypesSet( MofClass clazz ) {

        Set<LRI> subTypes = new HashSet<LRI>( );
        subTypes.add( ( (Partitionable) clazz ).get___Mri( ).getLri( ) );

        Collection<MofClass> subClasses = getSubTypes( clazz );

        for ( MofClass subClass : subClasses ) {
            subTypes.add( ( (Partitionable) subClass ).get___Mri( ).getLri( ) );
        }

        return subTypes;
    }

    /**
     * @param generalizableElement
     * @return
     */
    private static Collection<MofClass> getSubTypes( GeneralizableElement generalizableElement ) {

        ModelPackage modelPackage = (ModelPackage) generalizableElement.refMetaObject( ).refImmediatePackage( );
        return (Collection) modelPackage.getGeneralizes( ).getSubtype( generalizableElement );
    }

}