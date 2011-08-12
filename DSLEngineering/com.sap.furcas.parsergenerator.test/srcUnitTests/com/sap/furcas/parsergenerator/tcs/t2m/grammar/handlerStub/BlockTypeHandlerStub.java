/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.t2m.grammar.handlerStub;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.parsergenerator.tcs.t2m.grammar.BlockTypeHandler;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.RuleBodyStringBuffer;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;

/**
 *
 */
public class BlockTypeHandlerStub extends BlockTypeHandler {

    @Override
    public void addElement(EObject element, RuleBodyStringBuffer buffer)
            throws MetaModelLookupException {
        elements.add(element);
        buffers.add(buffer);
    }
    
    public List<EObject> elements = new ArrayList<EObject>();
    public List<RuleBodyStringBuffer> buffers = new ArrayList<RuleBodyStringBuffer>();
    

}
