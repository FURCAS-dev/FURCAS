/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import tcs.Property;

import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.PropertyTypeHandler;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBuffer;

/**
 *
 */
public class PropertyHandlerStub extends PropertyTypeHandler {

    /**
     * @param metaLookup
     * @param syntaxLookup
     */
    public PropertyHandlerStub() {
        super(new MetaLookupStub(), null, null, null);
    }
    
    @Override
    public void addElement(Property prop, RuleBodyStringBuffer buffer)
            throws SyntaxElementException, MetaModelLookupException {
        elements.add(prop);
        buffers.add(buffer);
    }
    
    public List<Property> elements = new ArrayList<Property>();
    public List<RuleBodyStringBuffer> buffers = new ArrayList<RuleBodyStringBuffer>();
    
    


}
