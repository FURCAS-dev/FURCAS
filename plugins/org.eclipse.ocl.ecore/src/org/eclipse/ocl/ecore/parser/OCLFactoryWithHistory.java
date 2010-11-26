package org.eclipse.ocl.ecore.parser;

import org.eclipse.ocl.ecore.OppositePropertyCallExp;
import org.eclipse.ocl.ecore.utilities.OCLFactoryWithHiddenOpposite;
import org.eclipse.ocl.utilities.OCLFactory;


public class OCLFactoryWithHistory
		extends org.eclipse.ocl.parser.OCLFactoryWithHistory
		implements OCLFactoryWithHiddenOpposite {

	OCLFactoryWithHistory(OCLFactory delegate) {
		super(delegate);
	}

    public OppositePropertyCallExp createOppositePropertyCallExp() {
    	if (delegate instanceof OCLFactoryWithHiddenOpposite) {
    		return record(((OCLFactoryWithHiddenOpposite) delegate).createOppositePropertyCallExp());
    	} else {
    		return null;
    	}
    }

}
