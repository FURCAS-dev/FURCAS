package com.sap.ap.cts.refactoring.model;

import com.sap.ide.refactoring.core.model.rename.NamedElementDefaultImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;


public class NamedElementAdapter extends NamedElementDefaultImpl {

    public NamedElementAdapter(RefObject wrapped) {
	super(wrapped, "name");
    }


}
