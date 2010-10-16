/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-30 09:59:50 +0200 (So, 30 Aug 2009) $
 * Revision: $Revision: 7772 $
 * Author: $Author: c5127705 $
 *******************************************************************************/
package com.sap.furcas.runtime.common.exceptions;


/**
 * to be thrown when ModelAdapter cannot resolve a reference.
 * Used as explicit subclass since this case might be treated differently from
 * general ModelAdapterExceptions.
 */
public class ReferenceSettingException extends ModelAdapterException {

    public ReferenceSettingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReferenceSettingException(String message) {
        super(message);
    }

    /**
     * 
     */
    private static final long serialVersionUID = 5721350998010932596L;

}
