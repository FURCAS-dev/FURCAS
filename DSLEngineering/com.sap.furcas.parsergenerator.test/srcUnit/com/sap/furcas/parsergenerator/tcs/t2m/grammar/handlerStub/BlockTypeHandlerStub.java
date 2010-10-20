/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.LocatedElement;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.BlockTypeHandler;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;

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
