package com.sap.furcas.metamodel.TCS.stubs;

import com.sap.furcas.metamodel.TCS.SequenceInAlternative;

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
