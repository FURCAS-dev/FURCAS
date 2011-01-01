/*******************************************************************************
 * Copyright (c) 2008-2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.ide.cts.editor.prettyprint.imported;

public class SyntaxAndModelMismatchException extends Exception {

    String message;

    public SyntaxAndModelMismatchException(String message) {
	this.message = message;
    }

    public SyntaxAndModelMismatchException(Exception cause) {
	super(cause);
    }

    @Override
    public String getMessage() {
	return message != null ? message : super.getMessage();
    }

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

}
