package com.sap.tc.moin.repository.spi.facility.basicquery;

/**
 * Attribute of a model element specified by a model element expression
 */
@Deprecated
public final class SpiAttributeInModelElement {

    private SpiModelElementExpression modelElementExpression;

    private String attributeId;

    /**
     * @param modelElementExpression model element expression which specifies
     * the model elements of the attribute
     * @param attributeId ID of the attribute
     */
    public SpiAttributeInModelElement( SpiModelElementExpression modelElementExpression, String attributeId ) {

        this.modelElementExpression = modelElementExpression;
        this.attributeId = attributeId;
    }

    /**
     * @return Returns the attributeId.
     */
    public String getAttributeId( ) {

        return this.attributeId;
    }

    /**
     * @return Returns the modelElementExpression.
     */
    public SpiModelElementExpression getModelElementExpression( ) {

        return this.modelElementExpression;
    }

    /**
     *
     */
    @Override
    public String toString( ) {

        return this.modelElementExpression.getAlias( ) + "." + this.attributeId; //$NON-NLS-1$
    }
}
