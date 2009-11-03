package com.sap.tc.moin.xm.generation.core.metamodel.om;

/**
 * Enumeration for the different kinds of XSD components, like simple type
 * definition, complex type definition, element declaration, attribute
 * declaration.
 */
public enum XmXsdComponentKind {

    GlobalSimpleType, LocalSimpleType, GlobalComplexType, LocalComplexType, GlobalAttribute, LocalAttribute, GlobalElement, LocalElement, ElementWildcard, AttributeWildcard, MixedContent, SimpleContent // simple
    // content of a complex type definition
    ,
    SubstitutionGroupHead,
    Undefined,
    DocumentRoot;
}
