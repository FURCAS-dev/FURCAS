package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * Operations can be derived, i.e. relate to a reference which is based in a
 * derived attribute
 */
public interface JmiGeneratorClassOperationDervied extends JmiGeneratorClassOperation {

    /**
     * @return the type of the underlying association
     */
    public String getAssociationType( );

    /**
     * @return the type of the underlying association's implementation class
     */
    public String getAssociationImplementationType( );

    /**
     * @return the name of the association end
     */
    public String getAssociationEndName( );
}
