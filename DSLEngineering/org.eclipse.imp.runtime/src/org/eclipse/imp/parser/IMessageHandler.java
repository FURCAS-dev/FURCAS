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

/**
 * This interface describes something that can process messages emitted
 * by a parser or other language processing front-end.
 */
public interface IMessageHandler {
    /**
     * Clear all previously-issued messages. Typically called at the
     * beginning of a parsing "session".
     */
    void clearMessages();

    /**
     * Issue a single message with the given text and source position.
     * @param msg the message text
     * @param startOffset 0-based, inclusive
     * @param endOffset 0-based, inclusive
     * @param startCol 1-based, inclusive
     * @param endCol 1-based, inclusive
     * @param startLine 1-based, inclusive
     * @param endLine 1-based, inclusive
     */
    void handleSimpleMessage(String msg, int startOffset, int endOffset,
            int startCol, int endCol,
            int startLine, int endLine);

    /**
     * Begins a group of related messages (e.g. the first describing an error
     * relating multiple entities, identifying the position of the first entity,
     * followed by individual messages, one per additional entity).
     * @param groupName
     */
    void startMessageGroup(String groupName);

    /**
     * Ends a group of related messages
     */
    void endMessageGroup();
}
