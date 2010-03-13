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
 * $Id: AbstractEditorTestCase.java,v 1.2 2010/03/13 18:11:25 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.editor.ui.builder.CommonBuilder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Synchronizer;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractEditorTestCase extends TestCase
{
	protected static void checkAbsent(String when, IDocument document, String what) {
		int index = document.get().indexOf(what);
		if (index >= 0) {
			fail(when + " - '" + what + "' found");
		}
	}
	
	protected static void checkAbsent(String when, Collection<String> strings, String what) {
		if (strings.contains(what)) {
			fail(when + " - '" + what + "' found");
		}
	}

	protected static int checkPresent(String when, IDocument document, String what) {
		int index = document.get().indexOf(what);
		if (index < 0) {
			fail(when + " - '" + what + "' not found");
		}
		return index;
	}
	
	protected static void checkPresent(String when, Collection<String> strings, String what) {
		if (!strings.contains(what)) {
			fail(when + " - '" + what + "' not found");
		}
	}

	public static class LogListener implements ILogListener
	{
		private List<IStatus> statuses = new ArrayList<IStatus>();
		
		public void logging(IStatus status, String plugin) {
			statuses.add(status);
		}

		public List<IStatus> getStatuses() {
			return statuses;
		}
	}

	public static class BuilderSession
	{
		private final IFile file;
		private boolean ended = false;
		private boolean started = false;
		
		public BuilderSession(IFile file) {
			this.file = file;
		}
		
		public void end() {
			if (!started)
				System.out.println("Not started " + file);
			else if (ended)
				System.out.println("Already ended " + file);
			ended = true;
			synchronized (this) {
				notifyAll();
			}
		}

		public boolean hasEnded() {
			return ended;
		}

		public boolean hasStarted() {
			return started;
		}

		public void start() {
			if (started)
				System.out.println("Already started " + file);
			else if (ended)
				System.out.println("Already ended " + file);
			started = true;
		}
	}

	public static class BuilderListener implements CommonBuilder.BuilderListener
	{
		private Map<IFile, BuilderSession> pendingSessions = new HashMap<IFile, BuilderSession>();
		private Map<IFile, BuilderSession> activeSessions = new HashMap<IFile, BuilderSession>();
		
		public synchronized void endBuild(IFile file) {
			BuilderSession session = activeSessions.get(file);
			if (session == null)
				System.out.println("No session for " + file);
			else {
				activeSessions.remove(file);
				session.end();
			}
		}

		public synchronized void beginBuild(IFile file) {
			BuilderSession session = pendingSessions.get(file);
			if (session == null)
				System.out.println("No session pending for " + file);
			else {
				pendingSessions.remove(file);
				activeSessions.put(file, session);
				session.start();
			}
		}

		public BuilderSession createSession(IFile file) {
			BuilderSession session = pendingSessions.get(file);
			if (session != null)
				System.out.println("Session pending for " + file);
			else {
				session = new BuilderSession(file);
				pendingSessions.put(file, session);
			}
			return session;
		}
	}
	
	protected Synchronizer dummySynchronizer;
	protected IProgressMonitor monitor = new NullProgressMonitor();
	protected IProject project;
	protected IWorkbenchPage workbenchPage;
	protected List<IFile> files = new ArrayList<IFile>();
	protected IFile createFile(String fileName) throws CoreException {
		IFile file = project.getFile(fileName);
		IContainer container = file.getParent();
		if (container instanceof IFolder) {
			IFolder folder = (IFolder)container;
			if (!folder.exists())
				folder.create(true, false, null);
		}
		files.add(file);
		return file;
	}

	protected IFile createFile(String fileName, String contents) throws CoreException {
		IFile file = createFile(fileName);
		setFileContents(file, contents);
		return file;
	}

	protected IFile createFile(IFolder folder, String fileName, String contents) throws CoreException {
		IFile file = folder.getFile(fileName);
		setFileContents(file, contents);
		files.add(file);
		return file;
	}

	protected IFolder createFolder(String fileName) throws CoreException {
		IFolder folder = project.getFolder(fileName);
		folder.create(true, true, monitor);
		return folder;
	}

	protected abstract ICreationFactory getCreationFactory();

	protected abstract String getEditorId();
	
	protected String getProjectId() {
		return getClass().getPackage().getName();
	}

	protected void runAsyncMessages(Display display, final String message) {
//		if (PagedEditor.traceEditorShowDirty.isActive())
//			PagedEditor.traceEditorShowDirty.println("Waiting for " + message);		
		Synchronizer savedSynchronizer = display.getSynchronizer();
		display.setSynchronizer(dummySynchronizer);
		display.setSynchronizer(savedSynchronizer);
//		if (PagedEditor.traceEditorShowDirty.isActive())
//			PagedEditor.traceEditorShowDirty.println("Waited for " + message);		
	}

	protected void setFileContents(IFile file, String contents) throws CoreException {
		InputStream source = new ByteArrayInputStream(contents.getBytes());
		file.create(source, true, monitor);
	}
			
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		project = workspace.getRoot().getProject(getProjectId());
		if (!project.exists())
			project.create(monitor);
		if (!project.isOpen())
			project.open(monitor);
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		workbenchPage = workbenchWindow.getActivePage();
		dummySynchronizer = new Synchronizer(Display.getDefault());
	}

	@Override
	protected void tearDown() throws Exception {
		Exception ex = null;
		for (IFile file : files) {
			try {
				file.delete(true, false, monitor);
			} catch (CoreException e) {
				if (ex == null)
					ex = e;
			}
		}
		if (ex != null)
			throw ex;
		super.tearDown();
	}

	protected List<IStatus> waitForBuilder(BuilderSession session, LogListener logListener) {
		long endTime = System.currentTimeMillis() + 2000;
		Thread.yield();
		List<IStatus> statuses = logListener.getStatuses();
		while (System.currentTimeMillis() < endTime) {
			if (session.hasEnded())
				break;
			if (statuses.size() > 0)
				break;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
		return statuses;
	}
}
