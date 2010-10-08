package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import com.sap.furcas.metamodel.TCS.SequenceInAlternative;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.SequenceStub;

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
