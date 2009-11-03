package com.sap.mi.fwk.ui.test.editors;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.tc.moin.repository.MRI;

public class TestEditorInput extends ModelEditorInput {

	public TestEditorInput(String mriName) {
		super(mriName);
	}

	public TestEditorInput(RefBaseObject obj) {
		super(obj);
	}

	public TestEditorInput(MRI mri) {
		super(mri);
	}
}
