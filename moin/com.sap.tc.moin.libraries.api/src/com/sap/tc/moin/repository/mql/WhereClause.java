/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A where-clause comes in several variants and can be build up to a complicated
 * boolean logic {@link WhereEntry}.
 */
abstract public class WhereClause extends MQLElement {

    abstract protected void toString( StringBuilder sb, int indent );
}
