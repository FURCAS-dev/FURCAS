/**
 * 
 */
package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.BlockArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class BlockStub extends SequenceElementStub implements Block {

    /* (non-Javadoc)
     * @see TCS.Block#getBlockArgs()
     */
    @Override
    public EList<BlockArg> getBlockArgs() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Block#getBlockSequence()
     */
    @Override
    public Sequence getBlockSequence() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see TCS.Block#setBlockSequence(TCS.Sequence)
     */
    @Override
    public void setBlockSequence(Sequence value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getBlock();
    }
}
