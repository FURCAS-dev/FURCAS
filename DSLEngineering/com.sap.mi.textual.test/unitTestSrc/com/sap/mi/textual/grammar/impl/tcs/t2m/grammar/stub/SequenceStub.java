/**
 * 
 */
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.TCS.Alternative;
import com.sap.furcas.metamodel.TCS.Block;
import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ConditionalElement;
import com.sap.furcas.metamodel.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.TCS.Sequence;
import com.sap.furcas.metamodel.TCS.SequenceElement;


/**
 *
 */
public class SequenceStub extends LocatedElementStub implements Sequence {

    public List<SequenceElement> elements = new ArrayList<SequenceElement>();

    /* (non-Javadoc)
     * @see TCS.Sequence#getAlternativecontainer()
     */
    public Alternative getAlternativeContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getBlockcontainer()
     */
    public Block getBlockcontainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getElements()
     */
    @Override
    public EList<SequenceElement> getElements() {
        return elements;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getElsecontainer()
     */
    public ConditionalElement getElsecontainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getFunctioncontainer()
     */
    public FunctionTemplate getFunctioncontainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getOtcontainer()
     */
    public OperatorTemplate getOtcontainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getPrefixcontainer()
     */
    public ClassTemplate getPrefixcontainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getSeparatorcontainer()
     */
    public SeparatorPArg getSeparatorcontainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getTemplatecontainer()
     */
    public ClassTemplate getTemplatecontainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getThencontainer()
     */
    public ConditionalElement getThencontainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setAlternativecontainer(TCS.Alternative)
     */
    public void setAlternativeContainer(Alternative value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setBlockcontainer(TCS.Block)
     */
    public void setBlockcontainer(Block value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setElsecontainer(TCS.ConditionalElement)
     */
    public void setElsecontainer(ConditionalElement value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setFunctioncontainer(TCS.FunctionTemplate)
     */
    public void setFunctioncontainer(FunctionTemplate value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setOtcontainer(TCS.OperatorTemplate)
     */
    public void setOtcontainer(OperatorTemplate value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setPrefixcontainer(TCS.ClassTemplate)
     */
    public void setPrefixcontainer(ClassTemplate value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setSeparatorcontainer(TCS.SeparatorPArg)
     */
    public void setSeparatorcontainer(SeparatorPArg value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setTemplatecontainer(TCS.ClassTemplate)
     */
    public void setTemplatecontainer(ClassTemplate value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setThencontainer(TCS.ConditionalElement)
     */
    public void setThencontainer(ConditionalElement value) {
        fail("not implemented yet");
        
    }


}
