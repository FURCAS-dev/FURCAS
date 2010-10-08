/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import com.sap.furcas.metamodel.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.TCS.EnumLiteralVal;
import com.sap.furcas.metamodel.TCS.LiteralRef;

/**
 *
 */
public class EnumLiteralMappingStub extends SequenceElementStub implements EnumLiteralMapping {

    public EnumLiteralVal literal;
    public LiteralStub element;
    
    
    
    public EnumLiteralMappingStub(String literal,
            String elementRepresentation) {
        super();
        this.literal = new EnumLiteralValStub();
        this.literal.setName(literal);
        
        this.element = new LiteralStub();
        element.representation = elementRepresentation;
    }

    /* (non-Javadoc)
     * @see TCS.EnumLiteralMapping#getElement()
     */
    public LiteralRef getElement() {
      
        return element;
    }

    /* (non-Javadoc)
     * @see TCS.EnumLiteralMapping#getLiteral()
     */
    public EnumLiteralVal getLiteral() {
        return literal;
    }

    /* (non-Javadoc)
     * @see TCS.EnumLiteralMapping#setElement(TCS.SequenceElement)
     */
    public void setElement(LiteralRef value) {
        
    }

    /* (non-Javadoc)
     * @see TCS.EnumLiteralMapping#setLiteral(TCS.EnumLiteralVal)
     */
    public void setLiteral(EnumLiteralVal value) {

    }

    class EnumLiteralValStub extends LocatedElementStub implements EnumLiteralVal {

        private String name;

        /* (non-Javadoc)
         * @see TCS.EnumLiteralVal#getName()
         */
        public String getName() {
            return name;
        }

        /* (non-Javadoc)
         * @see TCS.EnumLiteralVal#setName(java.lang.String)
         */
        public void setName(String value) {
            name = value;
        }

    }

}
