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

package org.eclipse.imp.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.imp.parser.IParseController;

/**
 * This class provides a message handler that creates markers in
 * response to received messages.
 * 
 * MarkerCreators are instantiated with a file (IFile) and a parse
 * controller (IParseController).  The parse controller should
 * be parsing the file and generating the messages that are
 * received by the MarkerCreator.  The MarkerCreator, in turn,
 * creates a problem marker for each error message received,
 * uses the parse controller to compute a line number for the
 * token provided with each message, and attaches the marker to
 * the given file at the computed line.
 */
public class MarkerCreator implements IMessageHandler {
	
    protected IParseController parseController;
    protected IFile file;
    protected String problemType;

    public MarkerCreator(IFile file, IParseController parseController) {
        this(file, parseController, IMarker.PROBLEM);
    }

    // TODO Replace single String arg with a triple of String problem types - one each for info, warning, error
    public MarkerCreator(IFile file, IParseController parseController, String problemType) {
        this.file = file;
        this.parseController = parseController;
        this.problemType = problemType;
    }

    public void clearMessages() {
        // TODO Clear markers on this file?
    }

    public void handleSimpleMessage(String msg, int startOffset, int endOffset,
            int startCol, int endCol,
            int startLine, int endLine)
    {	
        try {
            // Based closely on the Eclipse "FAQ How do I create problem markers for my compiler?"
            IMarker m = file.createMarker(problemType);

            String[] attributeNames = new String[] {IMarker.LINE_NUMBER, IMarker.CHAR_START, IMarker.CHAR_END, IMarker.MESSAGE, IMarker.PRIORITY, IMarker.SEVERITY};
            Object[] values = new Object[] {startLine, startOffset, endOffset, msg, IMarker.PRIORITY_HIGH, IMarker.SEVERITY_ERROR};
            m.setAttributes(attributeNames, values);
 
        } catch (CoreException e) {
            System.err.println("MarkerCreator.handleMessage:  CoreException trying to create marker");
        } catch (Exception e) {
            System.err.println("MarkerCreator.handleMessage:  Exception trying to create marker");
        }
    }

    public void endMessageGroup() { }

    public void startMessageGroup(String groupName) { }
}
