/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: MarkerProblemHandler.java,v 1.1 2010/03/11 14:51:24 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.imp.parser.IMessageHandler;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.lpg.AbstractProblemHandler;
import org.eclipse.ocl.lpg.ProblemHandler;

public abstract class MarkerProblemHandler<PK, C, O, P, EL, PM, S, COA, SSA, CT, CLS, E> extends AbstractProblemHandler implements IMessageHandler
{
	public static final String BUILDER_ID = "builderId";
	public static Map<ProblemHandler.Severity, Integer> severityMap = new HashMap<ProblemHandler.Severity, Integer>();
	
	static {
		severityMap.put(ProblemHandler.Severity.ERROR, Integer.valueOf(IMarker.SEVERITY_ERROR));
		severityMap.put(ProblemHandler.Severity.FATAL, Integer.valueOf(IMarker.SEVERITY_ERROR));
		severityMap.put(ProblemHandler.Severity.INFO, Integer.valueOf(IMarker.SEVERITY_INFO));
		severityMap.put(ProblemHandler.Severity.WARNING, Integer.valueOf(IMarker.SEVERITY_WARNING));
	}

	protected final ICreationFactory creationFactory;
	protected final IResource resource;
	protected String page = null;
	protected Map<Integer, List<Map<String, Object>>> entries = null;		// Map of line number to list of markers attributes for line
	private ProblemLimit problemLimit = null;

	public MarkerProblemHandler(ICreationFactory creationFactory, IResource resource) {
		super(null);
		this.creationFactory = creationFactory;
		this.resource = resource;
	}

	public void addMarker(int severity, String message, int lineNumber, int charStart, int charEnd) {
		String adjustedMessage = message;
		if (problemLimit != null) {
			adjustedMessage = problemLimit.check(severity, message);
			if (adjustedMessage == null)
				return;
		}
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put(IMarker.MESSAGE, adjustedMessage);
		attributes.put(IMarker.SEVERITY, Integer.valueOf(severity));
		if (lineNumber == -1) {
			lineNumber = 1;
		}
		Integer lineKey = Integer.valueOf(lineNumber);
		attributes.put(IMarker.LINE_NUMBER, lineKey);
		if (charStart <= charEnd) {
			attributes.put(IMarker.CHAR_START, Integer.valueOf(charStart));
			attributes.put(IMarker.CHAR_END, Integer.valueOf(charEnd));
		}
		attributes.put(BUILDER_ID, creationFactory.getBuilderId());
		if (entries == null)
			entries = new HashMap<Integer, List<Map<String, Object>>>();
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

    public void endMessageGroup() { }
	
	@Override public void flush(Monitor monitor) {
		//	Re-use existing markers wherever possible
		//	a) since many rebuilds generate the same errors
		//	b) to avoid a marker being deleted by a refreshMarkers on editor entry before
		//		gotoMarker is invoked to go to a pre-existing context.
		if (resource.exists()) {
			IWorkspaceRunnable action = new IWorkspaceRunnable()
			{
				public void run(IProgressMonitor monitor) throws CoreException {
					String markerId = creationFactory.getProblemMarkerId();
					if ((entries != null) || OCLExamplesEditorPlugin.MARKER_DELETE.isActive()) {
						IMarker[] oldMarkers = resource.findMarkers(markerId, false, IResource.DEPTH_ZERO);
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
							if (oldMarker != null) {
								if (OCLExamplesEditorPlugin.MARKER_DELETE.isActive())
									OCLExamplesEditorPlugin.MARKER_DELETE.println(formatMarker(oldAttributes));
								oldMarker.delete();
							}
						}
						if (entries != null) {
							for (List<Map<String, Object>> lineEntries : entries.values()) {
								for (Map<String, Object> entry : lineEntries) {
									if (OCLExamplesEditorPlugin.MARKER_CREATE.isActive())
										OCLExamplesEditorPlugin.MARKER_CREATE.println(formatMarker(entry));
									IMarker marker = resource.createMarker(markerId);
									marker.setAttributes(entry);
								}
							}
						}
					}
					else
						resource.deleteMarkers(markerId, false, IResource.DEPTH_ZERO);
				}
			};
			try {
				IProgressMonitor progressMonitor = monitor != null ? BasicMonitor.toIProgressMonitor(monitor) : new NullProgressMonitor();
				resource.getWorkspace().run(action, resource, IWorkspace.AVOID_UPDATE, progressMonitor);
			} catch (CoreException e) {
				OCLExamplesEditorPlugin.logError("Failed to update resource markers", e);
			}
		}
	}

	protected String formatMarker(Map<?, ?> attributes) {
		StringBuffer s = new StringBuffer();
		s.append(resource.getName());
		s.append(" ");
		s.append(attributes.get(IMarker.LINE_NUMBER));
		s.append(":");
		s.append(attributes.get(IMarker.CHAR_START));
		s.append("-");
		s.append(attributes.get(IMarker.CHAR_END));
		s.append(" ");
		s.append(attributes.get(IMarker.MESSAGE));
		return s.toString();
	}

	@Override public void handleProblem(ProblemHandler.Severity problemSeverity, ProblemHandler.Phase processingPhase,
			String problemMessage, String processingContext, int startOffset, int endOffset) {
		int line = -1;
		if (startOffset >= 0) {
			int leftToken = Math.abs(getParser().getIPrsStream().getTokenIndexAtCharacter(startOffset));	// abs to move non-token to predecessor
			if (leftToken >= 0)
				line = getParser().getIPrsStream().getLine(leftToken);
		}
		Integer severity = severityMap.get(problemSeverity);
		addMarker(severity != null ? severity.intValue() : IMarker.SEVERITY_ERROR,
				processingPhase + ": " + problemMessage, line, startOffset, endOffset+1);
	}		

	public void handleSimpleMessage(String msg, int startOffset, int endOffset,
			int startCol, int endCol, int startLine, int endLine) {
		addMarker(IMarker.SEVERITY_ERROR, msg, startLine, startOffset, endOffset+1);
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

    public void startMessageGroup(String groupName) { }
}