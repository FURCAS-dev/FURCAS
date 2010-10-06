/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import tcs.LocatedElement;

import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.BlockTypeHandler;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.RuleBodyStringBuffer;

/**
 *
 */
public class BlockTypeHandlerStub extends BlockTypeHandler {

    @Override
    public void addElement(LocatedElement element, RuleBodyStringBuffer buffer)
            throws MetaModelLookupException {
        elements.add(element);
        buffers.add(buffer);
    }
    
    public List<LocatedElement> elements = new ArrayList<LocatedElement>();
    public List<RuleBodyStringBuffer> buffers = new ArrayList<RuleBodyStringBuffer>();
    

}
