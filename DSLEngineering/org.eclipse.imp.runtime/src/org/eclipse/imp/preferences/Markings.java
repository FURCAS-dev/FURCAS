/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/

package org.eclipse.imp.preferences;

public class Markings {
	private Markings() {};	
	
	static public final String MODIFIED_NOTE = "Modified fields are marked in red.";
	
	static public final String TAB_ERROR_MARK = "**";
	static public final String TAB_ERROR_NOTE = "Tabs with invalid field values are marked with \"" +
		TAB_ERROR_MARK + "\"";

}
