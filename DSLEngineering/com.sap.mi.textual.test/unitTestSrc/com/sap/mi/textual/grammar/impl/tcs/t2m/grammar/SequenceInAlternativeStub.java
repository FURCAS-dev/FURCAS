package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import tcs.SequenceInAlternative;

import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.stub.SequenceStub;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

public class SequenceInAlternativeStub extends SequenceStub implements
		SequenceInAlternative {
	private String disambiguate;
	@Override
	public String getDisambiguate() throws JmiException {
		return disambiguate;
	}

	@Override
	public void setDisambiguate(String newValue) throws JmiException {
		disambiguate = newValue;
	}


}
