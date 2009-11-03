/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlPrimitiveType;

/**
 * Compares an attribute of the particular atomic entry with a constant. It
 * comes in two flavors: 1) numeric comparison and 2) like-equality.
 */
public abstract class ConstantComparison extends WhereClause {

    protected String attrName;

    protected SpiFqlPrimitiveType attrType;

    protected boolean isMultiValued;

    public String getAttrName( ) {

        return this.attrName;
    }

    public boolean isMultiValued( ) {

        return this.isMultiValued;
    }

    public SpiFqlPrimitiveType getAttrType( ) {

        return this.attrType;
    }

    public void setAttrName( String attrName ) {

        this.attrName = attrName;
    }

    public void setMultiValued( boolean isMultiValued ) {

        this.isMultiValued = isMultiValued;
    }

    public void setAttrType( SpiFqlPrimitiveType attrType ) {

        this.attrType = attrType;
    }

}
