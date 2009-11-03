package com.sap.tc.moin.repository.events.filter;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

/**
 * The Composition Hierarchy filteris used to specify the root instance of a composition hierarchy that
 * shall be observed.
 * 
 * @see com.sap.tc.moin.repository.events.filter.EventFilter
 * @author Daniel Vocke (D044825)
 */
public class CompositionHierarchyFilter extends EventFilter {

    /**
     * @param rootInstance The JMI instance that is the root of the composition hierarchy
     */
    public CompositionHierarchyFilter( RefBaseObject rootInstance ) {

        super( rootInstance );
    }

    /**
     * @param rootInstanceMri The MRI of the instance that is the root of the composition hierarchy
     */
    public CompositionHierarchyFilter( MRI rootInstanceMri ) {

        super( rootInstanceMri );
    }

    /**
     * @param filterCriteria a collection of filter criteria
     */
    public CompositionHierarchyFilter( Set<LRI> filterCriteria ) {

        super( filterCriteria );
    }
}