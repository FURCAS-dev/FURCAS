/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlLocalConstraint;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryEntry;

/**
 * A WhereClause provides a means to put constraints on primitive typed
 * attribute values. A where-clause may put any number of constraints on the
 * attributes of one alias and connect them logically via and/or.
 */
public abstract class WhereClause implements SpiFqlLocalConstraint {

    protected AtomicEntry atomicEntry;

    abstract public String toString( int indent, StringBuilder accumSb );

    public AtomicEntry getAtomicEntry( ) {

        return this.atomicEntry;
    }

    public void setAtomicEntry( AtomicEntry alias ) {

        this.atomicEntry = alias;
    }

    /*
     * FQL
     */

    public SpiFqlQueryEntry getFqlQueryEntry( ) {

        return this.atomicEntry;
    }

}
