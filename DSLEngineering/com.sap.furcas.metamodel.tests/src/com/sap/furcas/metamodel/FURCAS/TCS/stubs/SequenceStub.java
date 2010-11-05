/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import static org.junit.Assert.fail;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConditionalElement;
import com.sap.furcas.metamodel.FURCAS.TCS.FunctionTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;


/**
 *
 */
public class SequenceStub extends LocatedElementStub implements Sequence {

    public EList<SequenceElement> elements = new BasicEList<SequenceElement>();

    /* (non-Javadoc)
     * @see TCS.Sequence#getAlternativeContainer()
     */
    public Alternative getAlternativeContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getBlockContainer()
     */
    @Override
    public Block getBlockContainer() {
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
     * @see TCS.Sequence#getElseContainer()
     */
    @Override
    public ConditionalElement getElseContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getFunctionContainer()
     */
    @Override
    public FunctionTemplate getFunctionContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getOtContainer()
     */
    @Override
    public OperatorTemplate getOtContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getPrefixContainer()
     */
    @Override
    public ClassTemplate getPrefixContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getSeparatorContainer()
     */
    @Override
    public SeparatorPArg getSeparatorContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getTemplateContainer()
     */
    @Override
    public ClassTemplate getTemplateContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#getThenContainer()
     */
    @Override
    public ConditionalElement getThenContainer() {
        fail("not implemented yet");
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setAlternativeContainer(TCS.Alternative)
     */
    public void setAlternativeContainer(Alternative value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setBlockContainer(TCS.Block)
     */
    @Override
    public void setBlockContainer(Block value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setElseContainer(TCS.ConditionalElement)
     */
    @Override
    public void setElseContainer(ConditionalElement value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setFunctionContainer(TCS.FunctionTemplate)
     */
    @Override
    public void setFunctionContainer(FunctionTemplate value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setOtContainer(TCS.OperatorTemplate)
     */
    @Override
    public void setOtContainer(OperatorTemplate value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setPrefixContainer(TCS.ClassTemplate)
     */
    @Override
    public void setPrefixContainer(ClassTemplate value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setSeparatorContainer(TCS.SeparatorPArg)
     */
    @Override
    public void setSeparatorContainer(SeparatorPArg value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setTemplateContainer(TCS.ClassTemplate)
     */
    @Override
    public void setTemplateContainer(ClassTemplate value) {
        fail("not implemented yet");
        
    }

    /* (non-Javadoc)
     * @see TCS.Sequence#setThenContainer(TCS.ConditionalElement)
     */
    @Override
    public void setThenContainer(ConditionalElement value) {
        fail("not implemented yet");
        
    }


}
