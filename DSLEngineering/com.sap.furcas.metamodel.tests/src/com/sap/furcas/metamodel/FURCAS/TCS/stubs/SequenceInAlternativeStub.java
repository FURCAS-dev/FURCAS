package com.sap.furcas.metamodel.FURCAS.TCS.stubs;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;

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


}
