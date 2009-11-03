package com.sap.tc.moin.xm.kernel.impl;

import com.sap.tc.moin.repository.exception.MoinLocalizedString;
import com.sap.tc.moin.repository.xm.XmException;


/** Thrown if an error occurs in the XM kernel framework. */
public class XmKernelException extends XmException {

    private static final long serialVersionUID = -6346029142408526419L;

    public XmKernelException( final MoinLocalizedString message, final Object... args ) {

        super( message, args );
    }

    public XmKernelException( final Throwable cause, final MoinLocalizedString message, final Object... args ) {

        super( cause, message, args );
    }
}
