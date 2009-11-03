/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlPrimitiveType;

/**
 * This interface stands for an attribute reference of a type.
 */
public interface TypeAttrReference extends TypeReference {

    String toString( int indent, StringBuilder accumSb );

    boolean isMultiValued( );

    String getAttrName( );

    SpiFqlPrimitiveType getAttrType( );
}
