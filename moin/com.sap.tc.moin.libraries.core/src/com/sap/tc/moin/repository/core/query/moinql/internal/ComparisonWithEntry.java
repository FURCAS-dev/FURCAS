package com.sap.tc.moin.repository.core.query.moinql.internal;

/**
 * This class embodies the comparison with entry. It comes in two flavors: type
 * and attribute comparisons.
 */
public abstract class ComparisonWithEntry extends WithEntry {

    abstract public TypeReference getLeftTypeReference( );

    abstract public TypeReference getRightTypeReference( );

    abstract public AtomicEntry getLeftAtomicEntry( );

    abstract public AtomicEntry getRightAtomicEntry( );

    abstract public void setLeftType( TypeReference typeRef );

    abstract public void setRightType( TypeReference typeRef );

}
