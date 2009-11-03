/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlJoinConstraint;

/**
 * A JoinWhereEntry entails a constraint over multiple From-Entries. There are
 * two possibilities 1) a semantic join over primitive typed attributes or
 * aliases, or 2) a connection via a meta-model association. There are two ways
 * to express the latter, depending on whether attributes from both involved
 * types are required or not. If not, a nested query is used, which may lead to
 * a more efficient handling in the facility.
 */
public abstract class WithEntry implements SpiFqlJoinConstraint {

    abstract public String toString( int indent, StringBuilder accumSb );

}
