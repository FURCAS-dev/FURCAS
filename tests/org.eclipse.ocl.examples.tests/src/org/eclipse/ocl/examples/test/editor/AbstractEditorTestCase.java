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
 * $Id: AbstractEditorTestCase.java,v 1.3 2010/03/22 01:27:21 ewillink Exp $
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.editor.ui.builder.CommonBuilder;
import org.eclipse.ocl.examples.editor.ui.cst.CSTOutline;
import org.eclipse.ocl.examples.editor.ui.cst.ICSTOutlinePage;
import org.eclipse.ocl.examples.editor.ui.imp.CommonParseController;
import org.eclipse.ocl.examples.editor.ui.imp.CommonParseResult;
import org.eclipse.ocl.examples.editor.ui.imp.CommonPropertySheetPage;
import org.eclipse.ocl.examples.editor.ui.imp.CommonTextEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Synchronizer;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.ui.views.properties.IPropertySheetPage;

public abstract class AbstractEditorTestCase<E extends CommonTextEditor, ET extends EcoreTestFile, OT extends OCLTestFile> extends TestCase
{
	public static final String testClassName = "testClass";
	public static final String testPackageName = "testPackage";
	public static final String oldInvariantName = "oldInvariant";
	public static final String newInvariantName = "newInvariant";
	public static final String oldInvariantExpression = "true <> false";
	public static final String newInvariantExpression = "-- a prefix\nfalse <> true\n-- a suffix";
	public static final String newInvariantPart1 = "\ncontext " + testPackageName + "::" + testClassName + "\nin";
	public static final String newInvariantPart2 = "v " + newInvariantName + ":" + newInvariantExpression + "\n";

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
	protected List<IFile> files = new ArrayList<IFile>();

	protected IFile ecoreFile;
	protected ET ecoreTestFile;
	protected OT oclTestFile;
	protected EPackage initPackage;
	protected EClass initClass;
	protected IFileEditorInput editorInput;
	protected E editor;
	protected IWorkbenchPage page;
	protected IContentOutlinePage astOutlinePage;
	protected ICSTOutlinePage cstOutlinePage;
	protected CommonPropertySheetPage propertyPage;
	protected Display display;
	protected IDocumentProvider documentProvider;
	protected IDocument document;
	protected CommonParseController parseController;

	protected void checkTextSelection(int start, int length, Class<? extends CSTNode> cstClass) {
		ISelection cstSelection = cstOutlinePage.getSelection();
		ModelTreeNode cstTreeNode = (ModelTreeNode) ((IStructuredSelection)cstSelection).getFirstElement();
		CSTNode cstNode = (CSTNode) cstTreeNode.getASTNode();
		assertTrue(cstClass.isAssignableFrom(cstNode.getClass()));
		assertEquals(start, cstNode.getStartOffset());
		assertEquals(start + length, cstNode.getEndOffset() + 1);
//
		ISelection astSelection = astOutlinePage.getSelection();
		ModelTreeNode astTreeNode = (ModelTreeNode) ((IStructuredSelection)astSelection).getFirstElement();
		Object astNode = astTreeNode.getASTNode();
		checkTextASTSelection(astNode, cstNode);
//
		ISelection propertySelection = propertyPage.getSelection();
		Object propertyNode =  ((IStructuredSelection)propertySelection).getFirstElement();
		assertSame(astNode, propertyNode);
	}
	
	protected abstract void checkTextASTSelection(Object astNode, CSTNode cstNode);

	protected abstract ET createEcoreTestFile(IFile ecoreFile);
	
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

	protected abstract OT createOCLTestFile(ET ecoreTestFile);

	protected abstract ICreationFactory getCreationFactory();

	protected void doTestTextSelection(String text, Class<? extends CSTNode> cstClass) throws InterruptedException {
		int start = checkPresent("Search For", document, text);
		int length = text.length();
		editor.selectAndReveal(start, length);
		display.readAndDispatch();
//		readAndDispatchFor(1000);
		checkTextSelection(start, length, cstClass);
	}

	protected abstract String getEditorId();
	
	protected String getProjectId() {
		return getClass().getPackage().getName();
	}

	protected CommonParseResult parse(String documentText) {
		CommonParseResult parseResult = parseController.parseWithoutCaching(documentText, monitor);
		// Occasionally we get an NPE from the AST
		//  try to pin it down
		//  ?? IMP schedules its parse concurrently ??
		assertNotNull(parseResult.getAST());
		assertNotNull(ecoreTestFile);
		return parseResult;
	}

	protected void readAndDispatchFor(long delay) throws InterruptedException {
		Display display = editor.getDisplay();
		long waitUntil = System.currentTimeMillis() + delay;
		do {		
			if (!display.readAndDispatch())
				Thread.sleep(100);
		} while(System.currentTimeMillis() < waitUntil);
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
		page = workbenchWindow.getActivePage();
		dummySynchronizer = new Synchronizer(Display.getDefault());

		ecoreFile = project.getFile(getName() + " .ecore");
		ecoreTestFile = createEcoreTestFile(ecoreFile);
		initPackage = ecoreTestFile.createEPackage(null, testPackageName);
		initClass = ecoreTestFile.createEClass(initPackage, testClassName);
		oclTestFile = createOCLTestFile(ecoreTestFile);
		oclTestFile.createInvariant(initClass, oldInvariantName, oldInvariantExpression);
		editorInput = oclTestFile.getEditorInput();
		@SuppressWarnings("unchecked")
		E castEditor = (E) page.openEditor(editorInput, getEditorId());
		editor = castEditor;
		assertNotNull("Editor is open", page.findEditor(editorInput));
		display = editor.getDisplay();
		documentProvider = editor.getDocumentProvider();
		document = documentProvider.getDocument(editorInput);
		parseController = (CommonParseController) editor.getParseController();
		//
		display.readAndDispatch();
		@SuppressWarnings("unused")
		IViewPart propertyPart = page.showView("org.eclipse.ui.views.PropertySheet");
		display.readAndDispatch();
		@SuppressWarnings("unused")
		IViewPart cstPart = page.showView("org.eclipse.ui.views.ContentOutline");
		display.readAndDispatch();
		@SuppressWarnings("unused")
		IViewPart astPart = page.showView(CSTOutline.VIEW_ID); //, null, IWorkbenchPage.VIEW_ACTIVATE);
		display.readAndDispatch();
		editor.setFocus();
		astOutlinePage = (IContentOutlinePage) editor.getAdapter(IContentOutlinePage.class);
		cstOutlinePage = (ICSTOutlinePage) editor.getAdapter(ICSTOutlinePage.class);
		propertyPage = (CommonPropertySheetPage) editor.getAdapter(IPropertySheetPage.class);
	}

	@Override
	protected void tearDown() throws Exception {
		page.closeEditor(editor, false);
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
