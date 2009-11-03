package com.sap.tc.moin.repository.spi.facility.fql;

import com.sap.tc.moin.repository.MRI;

/**
 * This association-based join constraint is defined between one query entry and
 * a nested query or fixed set of elements. Moreover, this association-based
 * join constraint can be negated!
 * 
 * @author D045917
 */
public interface SpiFqlAssociationViaNestedQueryConstraint extends SpiFqlAssociationConstraint {

    /**
     * Returns if this association is negated.
     */
    boolean isNegated( );

    /**
     * Returns the nested query or result of this join constraint.
     */
    NestedQueryOrResult getNestedQueryOrResult( );

    /**
     * We support two forms for the nested structure: a nested query or a nested
     * result set.
     */
    interface NestedQueryOrResult {

    }

    /**
     * The nested structure entails a query
     */
    interface NestedFqlQuery extends NestedQueryOrResult {

        SpiFqlQuery getNestedFqlQuery( );
    }

    /**
     * The nested structure entails a set of MRIs
     */
    interface NestedResult extends NestedQueryOrResult {

        /**
         * Returns a fixed set of result elements. This method does not return
         * null.
         */
        MRI[] getNestedResults( );
    }

}
