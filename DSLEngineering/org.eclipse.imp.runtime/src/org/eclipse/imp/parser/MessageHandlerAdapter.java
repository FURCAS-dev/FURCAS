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

package org.eclipse.imp.parser;

import lpg.runtime.ParseErrorCodes;

public class MessageHandlerAdapter implements lpg.runtime.IMessageHandler {
    protected final IMessageHandler fIMPHandler;

    public MessageHandlerAdapter(IMessageHandler impHandler) {
        fIMPHandler= impHandler;
    }

    public void handleMessage(int errorCode, int[] msgLocation, int[] errorLocation, String filename, String[] errorInfo) {
        if (fIMPHandler == null) // there might be no IMP msg handler if we're parsing on behalf of the structure compare view
            return;
        int startOffset= msgLocation[lpg.runtime.IMessageHandler.OFFSET_INDEX];
        int length= msgLocation[lpg.runtime.IMessageHandler.LENGTH_INDEX];
        int startLine= msgLocation[lpg.runtime.IMessageHandler.START_LINE_INDEX];
        int endLine= msgLocation[lpg.runtime.IMessageHandler.END_LINE_INDEX];
        int startCol= msgLocation[lpg.runtime.IMessageHandler.START_COLUMN_INDEX];
        int endCol= msgLocation[lpg.runtime.IMessageHandler.END_COLUMN_INDEX];
//      String message = MessageFormat.format(ParseErrorCodes.errorMsgText[errorCode], (Object[]) errorInfo);
        String message = ParseErrorCodes.errorMsgText[errorCode] + ":";

        for (int i = 0; i < errorInfo.length; i++)
            message += " " + errorInfo[i];

        fIMPHandler.handleSimpleMessage(message, startOffset, startOffset + length - 1,
                startCol, endCol, startLine, endLine);
    }
}
