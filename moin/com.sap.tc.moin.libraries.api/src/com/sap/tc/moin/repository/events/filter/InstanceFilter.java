package com.sap.tc.moin.repository.events.filter;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

/**
 * InstanceFilters are used to specify a specific model element (instance) that
 * shall be observed. If you want to observe a composition hierarchy, use the
 * <@link CompositionHierarchyFilter>.
 * 
 * @see com.sap.tc.moin.repository.events.filter.EventFilter
 * @author Daniel Vocke (D044825)
 */
public class InstanceFilter extends EventFilter {

    /**
     * @param instance The JMI instance that shall be observed.
     */
    public InstanceFilter( RefBaseObject instance ) {

        super( instance );
    }

    /**
     * @param instanceMri The <code>MRI</code> of the instance that shall be
     * observed.
     */
    public InstanceFilter( MRI instanceMri ) {

        super( instanceMri );
    }

    /**
     * @param instanceMris The <code>MRI</code>s of the instances that shall
     * be observed.
     */
    public InstanceFilter( MRI... instanceMris ) {

        super( getLriSet( instanceMris ) );
    }

    /**
     * @param filterCriteria a collection of filter criteria
     */
    public InstanceFilter( Set<LRI> filterCriteria ) {

        super( filterCriteria );
    }

    private static Set<LRI> getLriSet( MRI... mris ) {

        Set<LRI> result = new HashSet<LRI>( );
        for ( MRI mri : mris ) {
            result.add( mri.getLri( ) );
        }
        return result;
    }
}