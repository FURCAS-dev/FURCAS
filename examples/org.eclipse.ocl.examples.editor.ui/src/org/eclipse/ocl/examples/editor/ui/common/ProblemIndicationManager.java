/**
 * <copyright>
 * 
 * Copyright (c) 2010 Eclipse Modeling Project and others.
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
 * $Id: ProblemIndicationManager.java,v 1.1 2010/03/13 13:16:11 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.common;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.MarkerHelper;
import org.eclipse.emf.common.ui.editor.ProblemEditorPart;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ui.IEditorPart;

/**
 * ProblemIndicationManager manages the problems associated with the resources
 * of an editor using a ResourceSet. 
 * <p>
 * The code is based on the auto-generated EcoreEditor code and is separated out
 * to support re-use in single and multi-page editors.
 */
public abstract class ProblemIndicationManager extends EContentAdapter
{
	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 */
	protected static String getString(String key)
	{
		return OCLExamplesEditorPlugin.INSTANCE.getString(key);
	}

	/**
	 * This looks up a string in plugin.properties, making a substitution.
	 */
	protected static String getString(String key, Object s1)
	{
		return OCLExamplesEditorPlugin.INSTANCE.getString(key, new Object [] { s1 });
	}

	private final class UpdateProblemIndicationRunnable implements Runnable
	{
		public void run()
		{
			updateProblemIndication();
		}
	}

	/**
	 * Map to store the diagnostic associated with a resource.
	 */
	protected Map<Resource, Diagnostic> resourceToDiagnosticMap = new LinkedHashMap<Resource, Diagnostic>();

	/**
	 * Controls whether the problem indication should be updated.
	 */
	protected boolean updateProblemIndication = true;

	/**
	 * The MarkerHelper is responsible for creating workspace resource markers presented
	 * in Eclipse's Problems View.
	 */
	protected MarkerHelper markerHelper = new EditUIMarkerHelper();

	/**
	 * Returns a diagnostic describing the errors and warnings listed in the resource
	 * and the specified exception (if any).
	 */
	public Diagnostic analyzeResourceProblems(Resource resource, Exception exception) 
	{
		if (!resource.getErrors().isEmpty() || !resource.getWarnings().isEmpty())
		{
			BasicDiagnostic basicDiagnostic = new BasicDiagnostic
			(Diagnostic.ERROR, "org.eclipse.emf.ecore.editor", 0,
					getString("_UI_CreateModelError_message", resource.getURI()),
					new Object [] { exception == null ? (Object)resource : exception });
			basicDiagnostic.merge(EcoreUtil.computeDiagnostic(resource, true));
			return basicDiagnostic;
		}
		else if (exception != null)
		{
			return new BasicDiagnostic
			(Diagnostic.ERROR, "org.eclipse.emf.ecore.editor", 0,
					getString("_UI_CreateModelError_message", resource.getURI()),
					new Object[] { exception });
		}
		else
			return Diagnostic.OK_INSTANCE;
	}

	protected abstract void asyncExec(Runnable runnable);

	protected abstract void createProblemEditor(BasicDiagnostic diagnostic);

	protected abstract ProblemEditorPart getProblemEditor();

	protected abstract ResourceSet getResourceSet();

	public List<?> getTargetObjects(Object object, IMarker marker) {
		return markerHelper.getTargetObjects(object, marker);
	}

	public void handleResourceException(Resource resource, Exception exception, boolean forceUpdate) {
		if (forceUpdate || !resourceToDiagnosticMap.containsKey(resource))
		{
			resourceToDiagnosticMap.put(resource, analyzeResourceProblems(resource, exception));
		}
	}

	public void initializeProblemIndication(Resource resource, Exception exception) {
		Diagnostic diagnostic = analyzeResourceProblems(resource, exception);
		if (diagnostic.getSeverity() != Diagnostic.OK) {
			resourceToDiagnosticMap.put(resource, diagnostic);
		}
		getResourceSet().eAdapters().add(this);
		updateProblemIndication();
	}

	@Override
	public void notifyChanged(Notification notification)
	{
		if (notification.getNotifier() instanceof Resource)
		{
			switch (notification.getFeatureID(Resource.class))
			{
			case Resource.RESOURCE__IS_LOADED:
			case Resource.RESOURCE__ERRORS:
			case Resource.RESOURCE__WARNINGS:
			{
				Resource resource = (Resource)notification.getNotifier();
				Diagnostic diagnostic = analyzeResourceProblems(resource, null);
				if (diagnostic.getSeverity() != Diagnostic.OK)
					resourceToDiagnosticMap.put(resource, diagnostic);
				else
					resourceToDiagnosticMap.remove(resource);
				if (updateProblemIndication) {
					asyncExec(new UpdateProblemIndicationRunnable());
				}
				break;
			}
			}
		}
		else
		{
			super.notifyChanged(notification);
		}
	}

	protected void refreshMarkers(BasicDiagnostic diagnostic) {
		ResourceSet resourceSet = getResourceSet();
		if (markerHelper.hasMarkers(resourceSet))
		{
			markerHelper.deleteMarkers(resourceSet);
			if (diagnostic.getSeverity() != Diagnostic.OK)
			{
				try
				{
					markerHelper.createMarkers(diagnostic);
				}
				catch (CoreException exception)
				{
					OCLExamplesEditorPlugin.INSTANCE.log(exception);
				}
			}
		}
	}
	
	public void resumeProblemIndicationUpdate() {
		updateProblemIndication = true;
		updateProblemIndication();
	}

	protected abstract void setActiveEditor(IEditorPart editor);

	@Override
	protected void setTarget(Resource target)
	{
		basicSetTarget(target);
	}
	
	public void suspendProblemIndicationUpdate() {
		updateProblemIndication = false;
	}

	@Override
	protected void unsetTarget(Resource target)
	{
		basicUnsetTarget(target);
	}
	
	/**
	 * Updates the problems indication with the information described in the specified diagnostic.
	 */
	public void updateProblemIndication()
	{
		if (updateProblemIndication)
		{
			BasicDiagnostic diagnostic = new BasicDiagnostic
				(Diagnostic.OK, "org.eclipse.emf.ecore.editor", 0, null,
						new Object [] { getResourceSet() });
			for (Diagnostic childDiagnostic : resourceToDiagnosticMap.values()) {
				if (childDiagnostic.getSeverity() != Diagnostic.OK) {
					diagnostic.add(childDiagnostic);
				}
			}
			ProblemEditorPart problemEditor = getProblemEditor();
			if (problemEditor != null) {
				problemEditor.setDiagnostic(diagnostic);
				if (diagnostic.getSeverity() != Diagnostic.OK) {
					setActiveEditor(problemEditor);
				}
			}
			else if (diagnostic.getSeverity() != Diagnostic.OK) {
				createProblemEditor(diagnostic);
			}

			refreshMarkers(diagnostic);
		}
	}
}
