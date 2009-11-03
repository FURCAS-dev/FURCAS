package com.sap.tc.moin.repository.spi.ps;


/**
 * This enumeration type represents the {@link TypedElement#getType() type} of a
 * MOF {@link Attribute attribute}.
 */
public enum SpiValueTypeEnum {

    /**
     * The {@link PrimitiveType} named <code>"String"</code>.
     */
    PRIMITIVE_TYPE_STRING,
    /**
     * The {@link PrimitiveType} named <code>"Boolean"</code>.
     */
    PRIMITIVE_TYPE_BOOLEAN,
    /**
     * The {@link PrimitiveType} named <code>"Integer"</code>.
     */
    PRIMITIVE_TYPE_INTEGER,
    /**
     * The {@link PrimitiveType} named <code>"Long"</code>.
     */
    PRIMITIVE_TYPE_LONG,
    /**
     * The {@link PrimitiveType} named <code>"Double"</code>.
     */
    PRIMITIVE_TYPE_DOUBLE,
    /**
     * The {@link PrimitiveType} named <code>"Float"</code>.
     */
    PRIMITIVE_TYPE_FLOAT,
    /**
     * Some {@link EnumerationType}.
     */
    ENUMERATION_TYPE,
    /**
     * Some {@link StructureType}.
     */
    STRUCTURE_TYPE,
    /**
     * Object-valued attribute typed with some {@link MofClass}.
     */
    OBJECT_TYPED
}
