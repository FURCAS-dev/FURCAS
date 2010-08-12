package com.sap.ap.cts.refactoring.model;

import com.sap.ide.refactoring.model.move.MovableElementDefaultImpl;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class MovableElementAdapter extends MovableElementDefaultImpl{

    public MovableElementAdapter(RefObject wrapped) {
	super(wrapped);
    }

}
