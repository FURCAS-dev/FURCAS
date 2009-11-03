package com.sap.tc.moin.repository.events.filter;

import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Attribute;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;

/**
 * The AttributeFilter is used to specify the meta type of an MOF-attribute that was changed. (= an attribute of an
 * M2-Class)<br>
 * Example: A Client that wants to be notified about renamings of all instances of a specific type will just have to
 * register to the attribute "name" of that type (meta class).<br>
 * This filter implicitly restrict the type of the events to AttributeChangeEvents.
 * 
 * @see com.sap.tc.moin.repository.events.filter.EventFilter
 * @author Daniel Vocke (D044825)
 */
public class AttributeFilter extends EventFilter {

    /**
     * @param filterCriterion The meta type of the attributes that shall be observed. You will have to pass the
     * {@link Attribute Attribute} as filterCriterion.
     */
    public AttributeFilter( Attribute filterCriterion ) {

        super( filterCriterion );
    }

    /**
     * @param filterCriterion The meta type of the attributes that shall be observed. You will have to pass the
     * {@link MRI MRI}of the meta type.
     */
    public AttributeFilter( MRI filterCriterion ) {

        super( filterCriterion );
    }

    /**
     * @param filterCriteria a collection of filter criteria
     */
    public AttributeFilter( Set<LRI> filterCriteria ) {

        super( filterCriteria );
    }

}