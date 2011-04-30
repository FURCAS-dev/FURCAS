/*******************************************************************************
* Copyright (c) 2008 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Stan Sutton (suttons@us.ibm.com) - initial API and implementation
*    Copied liberally and adapted from an implementation provided by
*   E. D. Willink as an attachment to Eclipse bugzilla bug #245296 (and
*   copyrighted 2008 under EPL v. 1.0 http://www.eclipse.org/legal/epl-v10.html).
*
*******************************************************************************/

package org.eclipse.imp.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.imp.builder.ProblemLimit.LimitExceededException;
import org.eclipse.imp.core.ErrorHandler;
import org.eclipse.imp.parser.IParseController;

/**
 * An implementation of IMessageHandler for collecting messages over time
 * and then creating a group of corresponding resource markers in one batch using
 * a single workspace operation.
 * 
 * Copied liberally from a MarkerProblemHandler implementation provided by
 * E. D. Willink as an attachment to Eclipse bugzilla bug #245296 (and
 * copyrighted 2008 under EPL v. 1.0 http://www.eclipse.org/legal/epl-v10.html).
 * 
 * @author Stan Sutton (suttons@us.ibm.com)
 */
public class MarkerCreatorWithBatching extends MarkerCreator {
    protected String page = null; // TODO Is this used anywhere?
    protected Map<Integer, List<Map<String, Object>>> entries = null; // Map of line number to list of marker attributes for line
    protected ProblemLimit problemLimit = null;
    protected BuilderBase builder = null;

    // TODO Make these private and final
    public String BUILDER_ID;
    public String PROBLEM_MARKER_ID;

    public Map<Integer, Integer> severityMap = new HashMap<Integer, Integer>();

    {
        severityMap.put(IMarker.SEVERITY_ERROR, IMarker.SEVERITY_ERROR);
        severityMap.put(IMarker.SEVERITY_INFO, IMarker.SEVERITY_INFO);
        severityMap.put(IMarker.SEVERITY_WARNING, IMarker.SEVERITY_WARNING);
    }

    /*
     * NOTE:  The parse controller that is provided in constructing an instance of this
     * type is used to obtain a parse stream that is used in processing error messages
     * received by the instance.  In particular, error messages are associated with positions
     * in the text, those positions are used to identify corresponding parse tokens, and
     * those parse tokens are used in determining positions for error markers.  For that
     * reason, the given parse controller should provide a parse stream that is consistent
     * with (if not identical to) the one obtained when the error messages were generated.
     * Also for that reason, no additional parsing is done within the marker creator.
     * Violation of this assumption can lead to markers (and marker annotations) that are
     * not correctly located with respect to the underling error in the text.
     */


    /**
     * Constructor to use when you want to create markers that are not related to a
     * particular builder and that will have the marker type provided here.
     * 
     * @param resource         The resource (e.g., file) on which markers are to be placed
     * @param parseController  The source of the parse stream to which error messages will
     *                         be related
     * @param problemType      The type of problem marker (i.e., the problem marker id)
     */
    public MarkerCreatorWithBatching(IFile file, IParseController parseController, String problemType) {
        super(file, parseController, problemType);
        BUILDER_ID = null;
        PROBLEM_MARKER_ID = problemType;
    }

    /**
     * Constructor to use when you want to create markers that are related to a
     * particular builder and that will have a marker type and builder id based
     * on that builder.
     * 
     * @param file              The file on which markers are to be placed
     * @param parseController   The source of the parse stream to which error messages will
     *                          be related
     * @param builder           The builder that is presumably driving the creation of
     *                          markers and that defines the type of marker and builder id
     *                          that will be used here
     */
    public MarkerCreatorWithBatching(IFile file, IParseController parseController, BuilderBase builder) {
        super(file, parseController, builder.getErrorMarkerID());

        this.builder = builder;

        if (builder != null) {
            BUILDER_ID = builder.getBuilderID();
        } else {
            BUILDER_ID = parseController.getLanguage().getName() + ".builder";
        }

        if (builder != null) {
            PROBLEM_MARKER_ID = builder.getErrorMarkerID();
        } else {
            PROBLEM_MARKER_ID = parseController.getLanguage().getName() + ".builder";
        }
    }

    public void setSeverityMap(Map<Integer, Integer>  mapOfSeverities) {
        // TODO:  Figure out what to do about target severities that do not correspond
        // to  marker severities
        severityMap = mapOfSeverities;
    }

    public Map<Integer, Integer> getSeverityMap() {
        return severityMap;
    }

    public void addMarker(int severity, String message, int lineNumber, int charStart, int charEnd)
    throws ProblemLimit.LimitExceededException
    {
        String adjustedMessage = message;
        if (problemLimit != null) {
            adjustedMessage = problemLimit.check(severity, message);
            if (adjustedMessage == null)
                return;
        }
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put(IMarker.MESSAGE, adjustedMessage);
        attributes.put(IMarker.SEVERITY, severity);
        if (lineNumber == -1) {
            lineNumber = 1;
        }
        Integer lineKey = Integer.valueOf(lineNumber);
        attributes.put(IMarker.LINE_NUMBER, lineKey);
        if (charStart <= charEnd) {
            attributes.put(IMarker.CHAR_START, charStart);
            attributes.put(IMarker.CHAR_END, charEnd);
        }
//      attributes.put(BUILDER_ID, creationFactory.getBuilderId());
        if (builder != null) {
            attributes.put(BUILDER_ID, builder.getBuilderID());
        }
        if (entries == null) {
            entries = new HashMap<Integer, List<Map<String, Object>>>();
        }
        List<Map<String, Object>> lineEntries = entries.get(lineKey);
        if (lineEntries == null) {
            lineEntries = new ArrayList<Map<String, Object>>();
            entries.put(lineKey, lineEntries);
        }
        lineEntries.add(attributes);
        if (adjustedMessage != message)
            throw new ProblemLimit.LimitExceededException(adjustedMessage);
    }

    public void clearMessages() {
        // TODO Auto-generated method stub
    }

    public void startMessageGroup(String groupName) { }

    public void endMessageGroup() { }

    public void flush(IProgressMonitor monitor) {
        // Re-use existing markers wherever possible
        //  a) since many rebuilds generate the same errors
        //  b) to avoid a marker being deleted by a refreshMarkers on editor entry before
        //     gotoMarker is invoked to go to a pre-existing context.
        if (file.exists()) {
            IWorkspaceRunnable action = new IWorkspaceRunnable() {
                public void run(IProgressMonitor monitor) throws CoreException {
                    String markerId = PROBLEM_MARKER_ID;
                    if (entries != null) {
                        IMarker[] oldMarkers = file.findMarkers(markerId, false, IFile.DEPTH_ZERO);
                        for (IMarker oldMarker : oldMarkers) {
                            Map<?, ?> oldAttributes = oldMarker.getAttributes();
                            List<Map<String, Object>> lineEntries = entries.get(oldAttributes.get(IMarker.LINE_NUMBER));
                            if (lineEntries != null) {
                                for (Map<String, Object> newAttributes : lineEntries) {
                                    if (isSameMarker(oldAttributes, newAttributes)) {
                                        lineEntries.remove(newAttributes);
                                        oldMarker = null;
                                        break;
                                    }
                                }
                            }
                            if (oldMarker != null)
                                oldMarker.delete();
                        }
                        for (List<Map<String, Object>> lineEntries : entries.values()) {
                            for (Map<String, Object> entry : lineEntries) {
                                IMarker marker = file.createMarker(markerId);
                                marker.setAttributes(entry);
                            }
                        }
                    } else
                        file.deleteMarkers(markerId, false, IFile.DEPTH_ZERO);
                }
            };
            try {
                // TODO:  Allow for the introduction of a non-null progress monitor
//              IProgressMonitor progressMonitor = monitor != null ? BasicMonitor.toIProgressMonitor(monitor) : new NullProgressMonitor();
                IProgressMonitor progressMonitor = new NullProgressMonitor();
                file.getWorkspace().run(action, file, IWorkspace.AVOID_UPDATE, progressMonitor);
            } catch (CoreException e) {
                ErrorHandler.logError("Failed to update file markers", e);
            }
        }
    }

    public void handleSimpleMessage(
            String msg, int startOffset, int endOffset,
            int startCol, int endCol, int startLine, int endLine)
    {
        try {
            addMarker(IMarker.SEVERITY_ERROR, msg, startLine, startOffset, endOffset+1);
        } catch (LimitExceededException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Return true if newAttributes and oldAttributes provide the same marker description.
     */
    public boolean isSameMarker(Map<?, ?> oldAttributes, Map<String, Object> newAttributes) {
        Set<?> oldKeys = oldAttributes.keySet();
        Set<String> newKeys = newAttributes.keySet();
        if (oldKeys.size() != newKeys.size())
            return false;
        for (String key : newKeys) {
            if (!oldAttributes.containsKey(key))
                return false;
            Object oldValue = oldAttributes.get(key);
            Object newValue = newAttributes.get(key);
            if (oldValue == newValue)
                continue;
            if (oldValue == null)
                return false;
            if (newValue == null)
                return false;
            if (!oldValue.equals(newValue))
                return false;
        }
        return true;
    }

    public void setProblemLimit(ProblemLimit problemLimit) {
        this.problemLimit = problemLimit;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
