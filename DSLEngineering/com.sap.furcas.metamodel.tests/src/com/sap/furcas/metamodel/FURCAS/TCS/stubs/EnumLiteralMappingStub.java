/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumLiteralVal;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;

/**
 *
 */
public class EnumLiteralMappingStub extends SequenceElementStub implements EnumLiteralMapping {

    public EnumLiteralVal literal;
    public LiteralStub element;

    public EnumLiteralMappingStub(String literal, String elementRepresentation) {
	super();
	this.literal = new EnumLiteralValStub();
	this.literal.setName(literal);

	this.element = new LiteralStub();
	element.representation = elementRepresentation;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.EnumLiteralMapping#getElement()
     */
    @Override
    public SequenceElement getElement() {

	return element;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.EnumLiteralMapping#getLiteral()
     */
    @Override
    public EnumLiteralVal getLiteral() {
	return literal;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.EnumLiteralMapping#setElement(TCS.SequenceElement)
     */
    @Override
    public void setElement(SequenceElement value) {

    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.EnumLiteralMapping#setLiteral(TCS.EnumLiteralVal)
     */
    @Override
    public void setLiteral(EnumLiteralVal value) {

    }

    class EnumLiteralValStub extends LocatedElementStub implements EnumLiteralVal {

	private String name;

	/*
	 * (non-Javadoc)
	 * 
	 * @see TCS.EnumLiteralVal#getName()
	 */
	@Override
	public String getName() {
	    return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see TCS.EnumLiteralVal#setName(java.lang.String)
	 */
	@Override
	public void setName(String value) {
	    name = value;
	}

    }

}
