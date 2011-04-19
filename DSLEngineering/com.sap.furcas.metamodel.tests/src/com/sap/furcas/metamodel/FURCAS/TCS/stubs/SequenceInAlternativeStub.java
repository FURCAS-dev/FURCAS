package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import org.eclipse.emf.ecore.EClass;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.TCSPackage;

public class SequenceInAlternativeStub extends SequenceStub implements
		SequenceInAlternative {
	private String disambiguate;
	@Override
	public String getDisambiguate()  {
		return disambiguate;
	}

	@Override
	public void setDisambiguate(String newValue)  {
		disambiguate = newValue;
	}

	    @Override
	    public EClass eClass() {
	        return TCSPackage.eINSTANCE.getSequenceInAlternative();
	    }

}
