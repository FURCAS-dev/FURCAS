package com.sap.furcas.emf.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

/**
 *
 */
public class SeparatorArgStub extends PargStub implements SeparatorPArg {

    private final Sequence sequence;

    public SeparatorArgStub(Sequence sequence) {
        this.sequence = sequence;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.SeparatorPArg#getSeparatorSequence()
     */
    @Override
    	public Sequence getSeparatorSequence() {
        return sequence;
    }

    /*
     * (non-Javadoc)
     * 
     * @see TCS.SeparatorPArg#setSeparatorSequence(TCS.Sequence)
     */
    @Override
    	public void setSeparatorSequence(Sequence value) {
    }

    @Override
    public EClass eClass() {
        return TCSPackage.eINSTANCE.getSeparatorPArg();
    }

}