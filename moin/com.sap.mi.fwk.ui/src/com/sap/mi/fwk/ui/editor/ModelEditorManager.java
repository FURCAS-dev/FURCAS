package com.sap.mi.fwk.ui.editor;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.progress.IProgressService;
import org.osgi.framework.Bundle;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.editor.IRunnableWithEditor;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.mi.fwk.ui.internal.preferences.EditorSavePreferencesHelper;
import com.sap.mi.fwk.ui.mbeans.EditorRegistryEntryMBean;
import com.sap.mi.fwk.ui.mbeans.EditorRegistryMBean;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * Accessor facility for editors based on Moin objects. Operations like opening
 * and finding such editors are provided.
 * 
 * @author d031150
 * @author d024127
 */
public final class ModelEditorManager {

	private static final Logger sTracer = Logger.getLogger(MiLocations.MI_EDITORS);

	private static final String EXT_POINT_EDITORS_LEGACY = MiFwkUIPlugin.PLUGIN_ID + ".editorregistry"; //$NON-NLS-1$
	private static final String ELEM_ADDITIONAL_EDITOR = "additionalEditor";//$NON-NLS-1$
	private static final String ATT_OBJ_CLASS = "objClass";//$NON-NLS-1$
	private static final String ATT_DEFAULT_EDITOR_ID = "defaultEditorId";//$NON-NLS-1$

	private static final String EXT_POINT_EDITORS = MiFwkUIPlugin.PLUGIN_ID + ".modelObjectEditorAssociations"; //$NON-NLS-1$
	private static final String ELEM_ASSOCIATION = "association";//$NON-NLS-1$
	private static final String ATT_OBJECT_CLASS = "objectClass";//$NON-NLS-1$
	private static final String ATT_EDITOR_ID = "editorId";//$NON-NLS-1$
	private static final String ATT_INPUT_FACTORY = "inputFactory";//$NON-NLS-1$
	private static final String ATT_DEFAULT = "default";//$NON-NLS-1$
	private static final String ATT_HANDLE_CHILDREN = "canHandleChildren";//$NON-NLS-1$

	private static final boolean JMX_ENABLED = (System.getProperty("com.sun.management.jmxremote.port") != null); //$NON-NLS-1$
	private static CompositeType sCompositeEditorDescription;
	private static TabularType sTabularEditorDescriptions;

	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$

	private static ModelEditorManager sInstance;

	static {
		try {
			sCompositeEditorDescription = new CompositeType("EditorDescrition", "EditorDescrition", new String[] { //$NON-NLS-1$ //$NON-NLS-2$
					"EditorID", "DisplayName", "FactoryClass" }, new String[] { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					"EditorID", "DisplayName", "FactoryClass" }, new OpenType[] { SimpleType.STRING, //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
							SimpleType.STRING, SimpleType.STRING });
			sTabularEditorDescriptions = new TabularType("EditorDescriptions", //$NON-NLS-1$
					"Attribute values (only primitive ones)", sCompositeEditorDescription, new String[] { "EditorID" }); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (OpenDataException e) {
			// never throw exceptions in static initializer
			sTracer.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	private Map<String, DescriptorList> mRegistry;
	private final Map<String, EditorRegistryEntryMBean> mBeanRegistry = new HashMap<String, EditorRegistryEntryMBean>();
	private ObjectName mEditorRegistryBean;
	private final IResourceChangeListener mResourceListener;

	/**
	 * @return the instance of this class
	 */
	public static synchronized ModelEditorManager getInstance() {
		if (sInstance == null) {
			sInstance = new ModelEditorManager();
		}
		return sInstance;
	}

	/**
	 * Returns all registered editor infos for the given model object's class.
	 * Can be used to e.g. implement an "Open With" action. If it's only of
	 * interest whether there is any editor for the object at all, use
	 * {@link #hasEditorDescriptors(RefBaseObject)}, which more efficiently can
	 * answer this.
	 * 
	 * @param object
	 *            the model object. Must not be <code>null</code>.
	 * @return the registered editor descriptors
	 * 
	 * @see #hasEditorDescriptors(RefBaseObject)
	 * @see IEditorRegistry
	 */
	public Collection<IEditorDescriptor> getEditorDescriptors(RefBaseObject object) {
		if (object == null) {
			throw new IllegalArgumentException("object parameter must not be null"); //$NON-NLS-1$
		}
		Collection<EditorDescriptorWithObject> infos = getDescriptors(object, true);
		Collection<IEditorDescriptor> editors = new ArrayList<IEditorDescriptor>(infos.size());
		for (EditorDescriptorWithObject desc : infos) {
			editors.add(desc.getEditorDescriptor());
		}
		return editors;
	}

	/**
	 * Returns whether the are registered model editors for the given object's
	 * class. Can be used to implement the enablement state of "Open" actions.
	 * 
	 * @param object
	 *            a model object
	 * @return <code>true</code> iff there is at least one editor registered
	 * 
	 * @see #getEditorDescriptors(RefBaseObject)
	 */
	public boolean hasEditorDescriptors(RefBaseObject object) {
		if (object == null) {
			throw new IllegalArgumentException("object parameter must not be null"); //$NON-NLS-1$
		}
		Collection<EditorDescriptorWithObject> infos = getDescriptors(object, false);
		return infos.size() > 0;
	}

	/**
	 * Starts an editor for the given model object. The editor must be
	 * registered at the
	 * <code>com.sap.mi.fwk.ui.modelObjectEditorAssociations</code> extension
	 * point. If no editor is found for the given object, its composite parents
	 * are considered. Such a parent editor is launched with the parent as input
	 * object, and the child is passed in as a selection using the
	 * {@link ISelectionListener} protocol (if the part implements or adapts to
	 * it) or through the {@link IWorkbenchSite#getSelectionProvider() site's
	 * selection provider}.
	 * 
	 * @param object
	 *            the object to open the editor for
	 * @return the launched editor or <code>null</code> if no matching editor is
	 *         found
	 * @throws PartInitException
	 *             in case of failures
	 * 
	 * @see #openEditor(RefBaseObject, String)
	 */
	public IEditorPart openEditor(RefBaseObject object) throws PartInitException {
		IEditorPart editor = openEditor(object, null, null);
		return editor;
	}

	/**
	 * Starts an editor for the given model object. The editor must be
	 * registered at the
	 * <code>com.sap.mi.fwk.ui.modelObjectEditorAssociations</code> extension
	 * point. If no editor is found for the given object, its composite parents
	 * are considered. Such a parent editor is launched with the parent as input
	 * object, and the child is passed in as a selection using the
	 * {@link ISelectionListener} protocol (if the part implements or adapts to
	 * it) or through the {@link IWorkbenchSite#getSelectionProvider() site's
	 * selection provider}.
	 * 
	 * @param object
	 *            the object to open the editor for
	 * @param editorId
	 *            The editor id or <code>null</code>. If no id is specified, the
	 *            first among multiple matching editors is opened.
	 * @return the launched editor or <code>null</code> if no matching editor is
	 *         found
	 * @throws PartInitException
	 *             in case of failures
	 * 
	 * @see #openEditor(RefBaseObject)
	 */
	public IEditorPart openEditor(RefBaseObject object, String editorId) throws PartInitException {
		IEditorPart editor = openEditor(object, editorId, null);
		return editor;
	}

	/**
	 * Starts an editor for the given model object. The editor must be
	 * registered at the
	 * <code>com.sap.mi.fwk.ui.modelObjectEditorAssociations</code> extension
	 * point. If no editor is found for the given object, its composite parents
	 * are considered. Such a parent editor is launched with the parent as input
	 * object, and the child is passed in as a selection using the
	 * {@link ISelectionListener} protocol (if the part implements or adapts to
	 * it) or through the {@link IWorkbenchSite#getSelectionProvider() site's
	 * selection provider}.
	 * 
	 * @param object
	 *            the object to open the editor for
	 * @param editorId
	 *            The editor id or <code>null</code>. If no id is specified, the
	 *            first among multiple matching editors is opened.
	 * @param followUp
	 *            an additional follow up action, which will be processed
	 *            asychronously. Useful for editors that create their UI in a
	 *            deferred way and that should e.g. passed a selection. May be
	 *            <code>null</code>.
	 * @return the launched editor or <code>null</code> if no matching editor is
	 *         found
	 * @throws PartInitException
	 *             in case of failures
	 * 
	 * @see #openEditor(RefBaseObject)
	 */
	// ATTENTION WITH API CHANGES!!! - Called via reflection from
	// com.sap.mi.fwk.test.service.internal.InvocationHelper
	public IEditorPart openEditor(final RefBaseObject object, String editorId, final Runnable followUp) throws PartInitException {
		if (object == null) {
			throw new IllegalArgumentException("object parameter must not be null"); //$NON-NLS-1$
		}

		EditorDescriptorWithObject desc = null;
		Collection<EditorDescriptorWithObject> descsToObject = getDescriptors(object, true);
		for (EditorDescriptorWithObject d : descsToObject) {
			if (editorId == null || editorId.equals(d.getId())) {
				desc = d;
				break;
			}
		}

		if (desc != null) {
			IWorkbenchWindow window = getActiveOrFirstWorkbenchWindow();
			final IEditorInput[] input = new IEditorInput[1];
			final EditorDescriptorWithObject descToOpen = desc;

			// fist input creation is long running since many lazy things
			// may happen:
			// - Gfw extension instantiation
			// - diagram to business object resolution in Moin
			BusyIndicator.showWhile(window.getShell().getDisplay(), new Runnable() {
				public void run() {
					input[0] = descToOpen.createInput();
				}
			});
			if (input[0] == null) {
				return null;
			}

			// wrap whole selection setting in runnable block (see comments
			// below)
			IRunnableWithEditor selectionSetter = new IRunnableWithEditor() {
				public void run(IEditorPart part) {
					// determine whether start object is a primary object
					// if these objects are not equal in sense of being same
					// pointer not .equals!!! the object which came in as
					// parameter is NOT the one the editor will be started for.
					// In this case the original object parameter will be handed
					// over to the editor as selection change. It is the editors
					// responsibilty to react upon this selection change via
					// ISelectionListener.selectionChanged
					try {
						if (object != descToOpen.getStartObject()) {
							ISelection sel = new StructuredSelection(object);
							ISelectionListener listener = ModelAdapterUI.getInstance().adaptObject(part, ISelectionListener.class);
							if (listener != null) {
								listener.selectionChanged(part, sel);
							} else {
								ISelectionProvider selProvider = part.getSite().getSelectionProvider();
								if (selProvider != null) {
									selProvider.setSelection(sel);
								}
							}
						}
					} catch (RuntimeException e) {
						MiFwkUIPlugin.logError(e, sTracer);
					}

					// also run now the external follow up action
					try {
						if (followUp != null) {
							followUp.run();
						}
					} catch (RuntimeException e) {
						MiFwkUIPlugin.logError(e, sTracer);
					}
				}
			};

			// register the block for execution (see comment below)
			if (input[0] instanceof ModelEditorInput) {
				((ModelEditorInput) input[0]).setFollowUp(selectionSetter);

				// fix for CSN 1386874 to avoid editors being opened twice
				((ModelEditorInput) input[0]).setRestoreEnabled(true);
			}

			// actually open the editor
			IWorkbenchPage page = window.getActivePage();
			IEditorPart part = page.openEditor(input[0], desc.getId(), true, IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);

			if (part != null && input[0] instanceof ModelEditorInput) {
				/*
				 * The selection setter block above will be executed for
				 * deferred editors async after this open operation, in this
				 * case it is null since ModeEditor already has obtained and
				 * cleared it. For classical editors, however, we need to
				 * execute it since execution would be too early in
				 * ModelEditor's init() phase (UI not created there).
				 */
				IRunnableWithEditor selectionSetter2 = ((ModelEditorInput) input[0]).clearFollowUp();
				if (selectionSetter2 != null) {
					try {
						selectionSetter2.run(part);
					} catch (RuntimeException e) {
						MiFwkUIPlugin.logError(e, sTracer);
					}
				}
			}

			if (sTracer.isLoggable(Level.FINE)) {
				sTracer.logp(Level.FINE, "ModelEditorManager", "openEditor", "Opening editor: " + part); //$NON-NLS-1$ //$NON-NLS-2$
			}
			return part;
		}
		return null;
	}

	/**
	 * @deprecated use {@link #openEditor(RefBaseObject, String)}
	 */
	@Deprecated
	public IEditorPart startEditor(RefBaseObject obj, ModelEditorDescription editorDesc) throws PartInitException {
		if (editorDesc == null) {
			throw new IllegalArgumentException("editorDesc parameter must not be null"); //$NON-NLS-1$
		}

		return openEditor(obj, editorDesc.getEditorID());
	}

	/**
	 * Returns an editor input object for the given model object. Calling this
	 * method is only necessary for clients that explicitly need to access an
	 * editor input. Otherwise use {@link #openEditor(RefBaseObject)}.
	 * 
	 * @param object
	 *            the object to retrieve an input for
	 * @return the editor input or <code>null</code> if no editor is available
	 *         for the object or in case of an error
	 */
	public IEditorInput getEditorInput(RefBaseObject object) {
		if (object == null) {
			throw new IllegalArgumentException("object parameter must not be null"); //$NON-NLS-1$
		}

		final Collection<EditorDescriptorWithObject> editorDescs = getDescriptors(object, false);
		if (editorDescs.size() > 0) {
			final IEditorInput[] input = new IEditorInput[1];

			// fist input creation is long running since many lazy things
			// may happen:
			// - Gfw extension instantiation
			// - diagram to business object resolution in Moin
			BusyIndicator.showWhile(PlatformUI.getWorkbench().getDisplay(), new Runnable() {
				public void run() {
					input[0] = editorDescs.iterator().next().createInput();
				}
			});

			return input[0];
		}
		return null;
	}

	/**
	 * Converts the given input object into an input suitable for the editor
	 * with the given id (which must be a registered model editor). May be used
	 * during {@link IEditorPart#init(IEditorSite, IEditorInput) editor
	 * initialization} when Eclipse tries to launch an editor with a foreign
	 * input, usually an {@link IFileEditorInput}.
	 * 
	 * @param otherInput
	 *            the foreign input. Must not be <code>null</code>.
	 * @param editorId
	 *            the id of a registered editor. Must not be <code>null</code>.
	 * @return the converted input or the <code>otherInput</code> if the
	 *         conversion was not sucessful.
	 * 
	 * @see IModelEditorInputFactory#createEditorInput(IEditorInput)
	 */
	public IEditorInput convertEditorInput(final IEditorInput otherInput, String editorId) {
		final EditorDescriptor desc = getDescriptorForId(editorId);
		if (desc != null) {
			final IEditorInput[] input = new IEditorInput[1];

			final IRunnableWithProgress operation = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					monitor.setTaskName(MiFwkUiMessages.ModelEditorManager_startingEditor);
					input[0] = desc.getFactory().createEditorInput(otherInput);
				}
			};

			IProgressService ps = PlatformUI.getWorkbench().getProgressService();
			try {
				ps.busyCursorWhile(operation);
			} catch (Exception e) {
				sTracer.log(Level.SEVERE, "Editor input could not be created", e); //$NON-NLS-1$
				throw new RuntimeException(e);
			}

			if (input[0] != null) {
				return input[0];
			}
		}
		return otherInput;
	}

	/**
	 * @return all active model editors
	 */
	public Set<IModelEditor> getAllActiveModelEditors() {
		Set<IModelEditor> result = new HashSet<IModelEditor>();
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		for (IWorkbenchWindow window : windows) {
			IWorkbenchPage[] pages = window.getPages();
			for (IWorkbenchPage page : pages) {
				IEditorReference[] references = page.getEditorReferences();
				for (IEditorReference reference : references) {
					// do not try to restore editor since it will be closed
					// anyway
					IEditorPart part = reference.getEditor(false);
					if (part != null) {
						IModelEditor editor = findModelEditor(part);
						if (editor != null) {
							result.add(editor);
						}
					}
				}
			}
		}

		return Collections.unmodifiableSet(result);
	}

	/**
	 * @deprecated use {@link #getAllActiveModelEditorsByPage2()}
	 * @return all active model editors, sorted by {@link IWorkbenchPage pages}
	 */
	@Deprecated
	public Map<IWorkbenchPage, Set<IModelEditor>> getAllActiveModelEditorsByPage() {
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		Map<IWorkbenchPage, Set<IModelEditor>> result = new HashMap<IWorkbenchPage, Set<IModelEditor>>(windows.length * 2);
		for (IWorkbenchWindow window : windows) {
			IWorkbenchPage[] pages = window.getPages();
			for (IWorkbenchPage page : pages) {
				IEditorReference[] references = page.getEditorReferences();
				for (IEditorReference reference : references) {
					// do not try to restore editor since it will be
					// closed anyway
					IEditorPart part = reference.getEditor(false);
					if (part != null) {
						IModelEditor editor = findModelEditor(part);
						if (editor != null) {
							Set<IModelEditor> editors = result.get(page);
							if (editors == null) {
								editors = new HashSet<IModelEditor>(references.length);
								result.put(page, editors);
							}
							editors.add(editor);
						}
					}
				}
			}
		}

		return Collections.unmodifiableMap(result);
	}

	/**
	 * @return all active model editors, sorted by {@link IWorkbenchPage pages}
	 */
	public Map<IWorkbenchPage, Set<IEditorReference>> getAllActiveModelEditorsByPage2() {
		IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
		Map<IWorkbenchPage, Set<IEditorReference>> result = new HashMap<IWorkbenchPage, Set<IEditorReference>>(windows.length * 2);
		for (IWorkbenchWindow window : windows) {
			IWorkbenchPage[] pages = window.getPages();
			for (IWorkbenchPage page : pages) {
				IEditorReference[] references = page.getEditorReferences();
				for (IEditorReference reference : references) {
					Set<IEditorReference> editors = result.get(page);
					if (editors == null) {
						editors = new HashSet<IEditorReference>(references.length);
						result.put(page, editors);
					}
					editors.add(reference);
				}
			}
		}

		return Collections.unmodifiableMap(result);
	}

	/**
	 * @return all active editors that use the given connection
	 * 
	 * @see #getAllActiveModelEditors(Collection)
	 */
	public Collection<IModelEditor> getAllActiveModelEditors(Connection connection) {
		Collection<IModelEditor> editors = getAllActiveModelEditors(Collections.singleton(connection));
		return editors;
	}

	/**
	 * @return all active editors that use the given connections
	 * 
	 * @see #getAllActiveModelEditors(Connection)
	 */
	public Collection<IModelEditor> getAllActiveModelEditors(Collection<Connection> connections) {
		Collection<IModelEditor> result = new HashSet<IModelEditor>(connections.size());
		Collection<IModelEditor> editors = getAllActiveModelEditors();
		for (IModelEditor editor : editors) {
			Connection connection = editor.getConnection();
			if (connection != null && connections.contains(connection)) {
				result.add(editor);
			}
		}
		return Collections.unmodifiableCollection(result);
	}

	/**
	 * @return all connections of the given editors
	 */
	public Collection<Connection> getConnectionsOfEditors(Collection<IModelEditor> editors) {
		Collection<Connection> result = new HashSet<Connection>(editors.size());
		for (IModelEditor editor : editors) {
			Connection connection = editor.getConnection();
			if (connection != null) {
				result.add(connection);
			}
		}
		return Collections.unmodifiableCollection(result);
	}

	/**
	 * Closes all model editors
	 * 
	 * @param save
	 *            <code>true</code> to save the editor contents if required
	 *            (recommended), and <code>false</code> to discard any unsaved
	 *            changes
	 * @return <code>true</code> if all editors were successfully closed, and
	 *         <code>false</code> if at least one editor is still open
	 */
	public boolean closeAllActiveModelEditors(boolean save) {
		return closeModelEditors(save, null);
	}

	/**
	 * Closes all editors responsible for the given object in all workbench
	 * pages (perspectives)
	 * 
	 * @param object
	 *            the object the corresponding editors are to be closed for
	 * @param save
	 *            <code>true</code> to save the editor contents if required
	 *            (recommended), and <code>false</code> to discard any unsaved
	 *            changes
	 * @return <code>true</code> if the editors were successfully closed, and
	 *         <code>false</code> if at least one is still open
	 */
	public boolean closeModelEditors(final RefBaseObject object, boolean save) {
		boolean success = closeModelEditors(save, new IFilter() {
			public boolean select(Object toTest) {
				IEditorReference editor = (IEditorReference) toTest;
				ModelEditorInput input = null;
				try {
					// MW: Fix for CSN 702774 2009: Prevent class cast exception for other editors that do not have a ModelEditorInput
					IEditorInput editorInput = editor.getEditorInput();
					if (editorInput instanceof ModelEditorInput) {
						input = (ModelEditorInput) editorInput;
					}
				} catch (PartInitException e) {
					sTracer.log(Level.SEVERE, "Error closing editor. " + editor, e);//$NON-NLS-1$
					return false;
				}
				if (input != null && object.equals(input.getRefObject())) {
					return true;
				}
				return false;
			}
		});
		return success;
	}

	/**
	 * Saves all dirty ModelEditors currently open. This method is usually
	 * called before opening a command group to avoid conflicting access to
	 * partitions. If <code>editorsToExclude</code> is not <code>null</code>,
	 * the given editors will not be saved.
	 * 
	 * @param editorsToExclude
	 *            editors not to save or <code>null</code> if called from a none
	 *            editor context
	 * @param confirm
	 *            If true a dialog is presented where the user can selectively
	 *            save a subset of editors
	 * @return <code>false</code>, if user canceled the dialog,
	 *         <code>true</code> otherwise.
	 * @see #saveDirtyModelEditors(Collection, boolean)
	 */
	public boolean saveAllDirtyModelEditors(Collection<IModelEditor> editorsToExclude, boolean confirm) {
		Collection<IModelEditor> editors = new ArrayList<IModelEditor>(getAllActiveModelEditors());
		if (editorsToExclude != null) {
			editors.removeAll(editorsToExclude);
		}
		boolean success = saveDirtyModelEditors(editors, confirm);
		return success;
	}

	/**
	 * Saves the given ModelEditors. This method is usually called before
	 * executing a command to avoid conflicting access to partitions. If
	 * <code>editorsToExclude</code> is not <code>null</code>, the given editors
	 * will not be saved.
	 * 
	 * @param editorsToSave
	 *            the editors to save
	 * @param confirm
	 *            If <code>true</code>, a dialog is presented where the user can
	 *            selectively save a subset of editors.
	 * @return <code>false</code>, if user canceled the dialog or decided not to
	 *         save all editors, <code>true</code> otherwise.
	 * @see #saveAllDirtyModelEditors(Collection, boolean)
	 */
	public boolean saveDirtyModelEditors(final Collection<IModelEditor> editorsToSave, final boolean confirm) {
		List<IEditorPart> dirtyParts = new ArrayList<IEditorPart>(editorsToSave.size());

		for (IModelEditor editor : editorsToSave) {
			IEditorPart part = findEditorPart(editor);
			if (part.isDirty()) {
				dirtyParts.add(part);
			}
		}

		if (!dirtyParts.isEmpty()) {

			boolean result = EditorSavePreferencesHelper.getInstance().getEditorSaveState();
			if (result) {
				if (!openEditorSaveDialog(dirtyParts)) {
					return false;
				}
			}

			IWorkbenchPage page = null;
			for (IEditorPart part : dirtyParts) {
				page = part.getEditorSite().getPage();
				page.saveEditor(part, false);
			}
		}
		return true;
	}

	private boolean openEditorSaveDialog(List<IEditorPart> dirtyParts) {
		StringBuffer sb = new StringBuffer(MiFwkUiMessages.ModelEditorManagerSaveDialog_save_the_following_editors);
		for (IEditorPart part : dirtyParts) {
			sb.append("\n").append(part.getTitle()); //$NON-NLS-1$ for testing
		}
		sb.append("\n").append(MiFwkUiMessages.ModelEditorManagerSaveDialog_press_ok_to_save); //$NON-NLS-1$ for testing
		MessageDialogWithToggle dialog = new MessageDialogWithToggle(Display.getCurrent().getActiveShell(),
				MiFwkUiMessages.ModelEditorManagerSaveDialog_save_conflicting_editors, null, sb.toString(), MessageDialog.QUESTION,
				new String[] { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 0,
				MiFwkUiMessages.ModelEditorManagerSaveDialog_do_not_show_again, false) {
			@Override
			protected void configureShell(Shell shell) {
				super.configureShell(shell);
				shell.setData(WIDGET_DATA_NAME, "ModelEditorManager.Dialog.ConfirmSave"); //$NON-NLS-1$ for testing
			}

			@Override
			protected Button createToggleButton(Composite parent) {
				Button b = super.createToggleButton(parent);
				b.setData(WIDGET_DATA_NAME, "ModelEditorManager.Dialog.EditorSaveDialogState"); //$NON-NLS-1$ for testing
				return b;
			}
		};
		if (dialog.open() == Window.OK) {
			if (dialog.getToggleState()) {
				EditorSavePreferencesHelper.getInstance().setEditorSaveState(false);
				if (sTracer.isLoggable(Level.FINE)) {
					sTracer.logp(Level.FINE, "ModelEditorManager", "openEditorSaveDialog", "Save dialog disabled by user"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Maps from {@link IEditorPart} to {@link IModelEditor}. May return null if
	 * the given part is not a Moin editor.
	 */
	public IModelEditor findModelEditor(IEditorPart part) {
		return ModelAdapterUI.getInstance().adaptObject(part, IModelEditor.class);
	}

	/**
	 * Maps from {@link IModelEditor} to {@link IEditorPart}
	 */
	public IEditorPart findEditorPart(IModelEditor editor) {
		return ModelAdapterUI.getInstance().adaptObject(editor, IEditorPart.class);
	}

	/**
	 * @return all open editors for the given object in all workbench pages
	 *         (perspectives)
	 */
	public Collection<IEditorPart> findEditorParts(RefBaseObject object) {
		Collection<EditorDescriptorWithObject> descs = getDescriptors(object, true);
		if (descs.size() > 0) {
			Collection<IEditorPart> result = new ArrayList<IEditorPart>(descs.size());
			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
			for (IWorkbenchWindow window : windows) {
				IWorkbenchPage[] pages = window.getPages();
				for (IWorkbenchPage page : pages) {
					for (EditorDescriptorWithObject desc : descs) {
						String editorId = desc.getId();
						IEditorInput input = desc.createInput();
						if (input == null) {
							continue;
						}
						IEditorReference[] refs = page.findEditors(input, editorId, IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
						for (IEditorReference ref : refs) {
							IEditorPart editor = ref.getEditor(false);
							if (editor != null) {
								result.add(editor);
							}
						}
					}
				}
			}
			return result;
		}
		return Collections.emptyList();
	}

	/**
	 * Returns descriptors for the given object. If <code>all</code> is
	 * <code>false</code>, it will stop as soon as one descriptor (usually the
	 * default) is found.
	 */
	private synchronized Collection<EditorDescriptorWithObject> getDescriptors(final RefBaseObject object, boolean all) {
		try {
			Class<RefBaseObject> jmiClass = object.get___JmiInterface();
			String jmiClassName = jmiClass.getName();

			// query the registry for an existing entry for the Jmi class
			Map<String, DescriptorList> registry = getRegistry(true);
			DescriptorList descriptorList = registry.get(jmiClassName);
			// none -> create one
			if (descriptorList == null) {
				descriptorList = new DescriptorList();
				registry.put(jmiClassName, descriptorList);
			}
			Collection<EditorDescriptor> descs = descriptorList.getDescriptors();

			// Scan the metamodel on Java-level for super classes.
			// Only done once and then cached (isComplete==false).
			if (!descriptorList.isComplete()) {
				for (Class<?> intf : getAllInterfaces(jmiClass, new ArrayList<Class<?>>())) {
					String intfName = intf.getName();
					DescriptorList superDescList = registry.get(intfName);
					if (superDescList != null) {
						Collection<EditorDescriptor> superDescs = superDescList.getDescriptors();
						descs.addAll(superDescs);
						createMBean(intfName, superDescs);
					}
				}
				descriptorList.setComplete();
			}

			// build preliminary result adding the start object
			// use LinkedHashSet to be stable with the order,
			// avoiding duplicates
			Collection<EditorDescriptorWithObject> result = new LinkedHashSet<EditorDescriptorWithObject>(descs.size());
			for (EditorDescriptor d : descs) {
				result.add(new EditorDescriptorWithObject(d, object));
			}

			// if there is result data and not all entries are requested, return
			if (descs.size() > 0 && !all) {
				return result;
			}

			// Scan the object's composition hierarchy if needed
			// (parent.canHandleChildren==true). Add the respective start object
			// to the result. The different objects are also the reson we must
			// not cache the descriptors.
			RefBaseObject currentObject = object;
			while (currentObject instanceof RefObject) {
				currentObject = ((RefObject) currentObject).refImmediateComposite();
				if (currentObject == null) {
					break;
				}
				String parentClassName = ((Partitionable) currentObject).get___JmiInterface().getName();
				DescriptorList parentDescriptorList = registry.get(parentClassName);
				if (parentDescriptorList != null) {
					Collection<EditorDescriptor> parentDescs = parentDescriptorList.getDescriptors();
					for (EditorDescriptor d : parentDescs) {
						if (d.canHandleChildren()) {
							result.add(new EditorDescriptorWithObject(d, currentObject));
						}
					}
				}
			}

			return result;
		} catch (CoreException e) {
			MiFwkUIPlugin.logError(e, sTracer);
			return Collections.emptyList();
		}
	}

	/**
	 * Hidden constructors
	 */
	private ModelEditorManager() {
		if (JMX_ENABLED) {
			try {
				mEditorRegistryBean = new EditorRegistryMBeanImpl().getObjectName();
			} catch (NotCompliantMBeanException e) {
				sTracer.logp(Level.SEVERE, ModelEditorManager.class.getName(), "init", "MBean not registered", e); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}

		mResourceListener = new ProjectCloseListener();
		ResourcesPlugin.getWorkspace().addResourceChangeListener(mResourceListener,
				IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE);

		// register part listener
		// mPartListener = new ModelPartListener();
		// IPartService service =
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService();
		// service.addPartListener(mPartListener);
	}

	private synchronized void disposeRegistry() {
		mRegistry = null;
		if (JMX_ENABLED) {
			// need to copy here since bean impl. modifies the registry map
			Collection<EditorRegistryEntryMBean> beans = new HashSet<EditorRegistryEntryMBean>(mBeanRegistry.values());
			for (EditorRegistryEntryMBean bean : beans) {
				try {
					bean.delete();
				} catch (Exception e) {
					sTracer.log(Level.SEVERE, "Bean not unregistered. bean:" + bean, e); //$NON-NLS-1$
				}
			}
			mBeanRegistry.clear();
		}
	}

	/**
	 * Closes all model editors
	 * 
	 * @param save
	 *            <code>true</code> to save the editor contents if required
	 *            (recommended), and <code>false</code> to discard any unsaved
	 *            changes
	 * @param filter
	 *            if supplied, used to select which editors are to be closed.
	 *            May be <code>null</code>.
	 * @return <code>true</code> if all editors were successfully closed, and
	 *         <code>false</code> if at least one editor is still open
	 */
	private boolean closeModelEditors(boolean save, IFilter filter) {
		// sort editors along pages since we want to exploit its mass close
		// operation
		Map<IWorkbenchPage, Set<IEditorReference>> editorsByPage = getAllActiveModelEditorsByPage2();
		Set<Entry<IWorkbenchPage, Set<IEditorReference>>> entries = editorsByPage.entrySet();
		for (Entry<IWorkbenchPage, Set<IEditorReference>> entry : entries) {
			IWorkbenchPage page = entry.getKey();
			Set<IEditorReference> editors = entry.getValue();
			Set<IEditorReference> editorsToClose = new HashSet<IEditorReference>(editors.size());
			for (IEditorReference editor : editors) {
				if (filter == null || filter.select(editor)) {
					editorsToClose.add(editor);
				}
			}
			boolean success = page.closeEditors(editorsToClose.toArray(new IEditorReference[editorsToClose.size()]), save);
			if (!success) {
				return false;
			}
		}

		return true;
	}

	/**
	 * For internal use only
	 */
	public static synchronized void dispose() {
		if (sInstance == null) {
			return;
		}

		if (JMX_ENABLED && sInstance.mEditorRegistryBean != null) {
			try {
				MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
				mBeanServer.unregisterMBean(sInstance.mEditorRegistryBean);
			} catch (Exception e) {
				sTracer.log(Level.SEVERE, "Bean not unregistered. bean:" + sInstance.mEditorRegistryBean, e); //$NON-NLS-1$
			}
			sInstance.mEditorRegistryBean = null;
		}

		ResourcesPlugin.getWorkspace().removeResourceChangeListener(sInstance.mResourceListener);
		sInstance.disposeRegistry();

		// if (sInstance.mPartListener != null) {
		// IPartService service =
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService();
		// service.removePartListener(sInstance.mPartListener);
		// sInstance.mPartListener = null;
		// }

		if (sTracer.isLoggable(Level.FINE)) {
			sTracer.logp(Level.FINE, "ModelEditorManager", "dispose", "Model Editor Manager disposed"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		sInstance = null;
	}

	/**
	 * Fills the registry with data from both the old (
	 * <code>editorregistry</code>) and new (
	 * <code>modelObjectEditorAssociations</code>) extension points.
	 * <code>mRegistry</code> must only be accessed from this method to
	 * guarantee consistency.
	 */
	private synchronized Map<String, DescriptorList> getRegistry(boolean loadIfNecessary) {
		// If the registry is not filled yet and loading is not requested
		// return an empty map. Otherwise fill if not done.
		if (mRegistry != null) {
			return mRegistry;
		} else if (!loadIfNecessary) {
			return Collections.emptyMap();
		}

		IExtensionRegistry extRegistry = Platform.getExtensionRegistry();
		IExtension[] extensionsLegacy = extRegistry.getExtensionPoint(EXT_POINT_EDITORS_LEGACY).getExtensions();
		IExtension[] extensions = extRegistry.getExtensionPoint(EXT_POINT_EDITORS).getExtensions();
		mRegistry = new HashMap<String, DescriptorList>((extensions.length + extensionsLegacy.length) * 4 / 3);
		addToRegistry(extensions, mRegistry);
		addToRegistryLegacy(extensionsLegacy, mRegistry);

		return mRegistry;
	}

	/**
	 * Fills the registry with using the given extensions from the new extension
	 * point
	 */
	private void addToRegistry(IExtension[] extensions, Map<String, DescriptorList> registry) {
		for (IExtension ext : extensions) {
			IConfigurationElement[] elems = ext.getConfigurationElements();
			for (IConfigurationElement assoc : elems) {
				if (!ELEM_ASSOCIATION.equals(assoc.getName())) {
					MiFwkUIPlugin.logError("Unknown element " + assoc.getName() + " in extension from " //$NON-NLS-1$ //$NON-NLS-2$
							+ ext.getContributor().getName(), null, sTracer);
					continue;
				}
				try {
					// read the object class and get editor list if there
					// are already registered editors
					String className = assoc.getAttribute(ATT_OBJECT_CLASS);
					if (className == null || className.length() == 0) {
						MiFwkUIPlugin.logError("Object class must not be empty in extension from " //$NON-NLS-1$
								+ ext.getContributor().getName(), null, sTracer);
						continue;
					}
					String editorId = assoc.getAttribute(ATT_EDITOR_ID);
					if (editorId == null || editorId.length() == 0) {
						MiFwkUIPlugin.logError("Editor id must not be empty in extension from " //$NON-NLS-1$
								+ ext.getContributor().getName(), null, sTracer);
						continue;
					}
					DescriptorList descriptorList = registry.get(className);
					if (descriptorList == null) {
						descriptorList = new DescriptorList();
					}
					Collection<EditorDescriptor> allEditorDescs = descriptorList.getDescriptors();
					boolean defaultEditor = Boolean.valueOf(assoc.getAttribute(ATT_DEFAULT));
					String handleChildrenValue = assoc.getAttribute(ATT_HANDLE_CHILDREN);
					boolean handleChildren = handleChildrenValue == null || Boolean.valueOf(handleChildrenValue);
					EditorDescriptor editorDesc = new EditorDescriptor(editorId, className, defaultEditor, handleChildren, assoc);
					if (defaultEditor) {
						addToHead(allEditorDescs, editorDesc);
					} else {
						allEditorDescs.add(editorDesc);
					}

					registry.put(className, descriptorList);
					createMBean(className, descriptorList.getDescriptors());
				} catch (CoreException e) {
					MiFwkUIPlugin.logError(e, sTracer);
				}
			}
		}
	}

	/**
	 * Fills the registry with using the given extensions from the old extension
	 * point
	 */
	private void addToRegistryLegacy(IExtension[] extensions, Map<String, DescriptorList> registry) {
		for (IExtension ext : extensions) {
			IConfigurationElement[] elems = ext.getConfigurationElements();
			for (IConfigurationElement objClass : elems) {
				try {
					// read the object class and get editor list if there
					// are already registered editors
					String className = objClass.getAttribute(ATT_OBJ_CLASS);
					DescriptorList descriptorList = registry.get(className);
					if (descriptorList == null) {
						// no editors registered so far -> create new list
						descriptorList = new DescriptorList();
					}
					Collection<EditorDescriptor> allEditorDescs = descriptorList.getDescriptors();
					// read default editor and add it to the head
					String defaultEditorId = objClass.getAttribute(ATT_DEFAULT_EDITOR_ID);
					String handleChildrenValue = objClass.getAttribute(ATT_HANDLE_CHILDREN);
					boolean handleChildren = handleChildrenValue == null || Boolean.valueOf(handleChildrenValue);
					if (defaultEditorId != null) {
						EditorDescriptor editorDesc = new EditorDescriptor(defaultEditorId, className, true, handleChildren, objClass);
						addToHead(allEditorDescs, editorDesc);
					}
					IConfigurationElement[] addEditors = objClass.getChildren(ELEM_ADDITIONAL_EDITOR);
					for (IConfigurationElement addEditor : addEditors) {
						String addEditorId = addEditor.getAttribute(ATT_EDITOR_ID);
						String handleChildrenAddValue = addEditor.getAttribute(ATT_HANDLE_CHILDREN);
						boolean handleChildrenAdd = handleChildrenAddValue == null || Boolean.valueOf(handleChildrenAddValue);
						EditorDescriptor modelEditorDesc = new EditorDescriptor(addEditorId, className, false, handleChildrenAdd, addEditor);
						allEditorDescs.add(modelEditorDesc);
					}
					registry.put(className, descriptorList);
					createMBean(className, descriptorList.getDescriptors());

				} catch (CoreException e) {
					MiFwkUIPlugin.logError(e, sTracer);
				}
			}
		}
	}

	private EditorDescriptor getDescriptorForId(String editorId) {
		Collection<DescriptorList> descLists = getRegistry(true).values();
		for (DescriptorList descList : descLists) {
			Collection<EditorDescriptor> descs = descList.getDescriptors();
			for (EditorDescriptor desc : descs) {
				if (desc.getId().equals(editorId)) {
					return desc;
				}
			}
		}
		return null;
	}

	/**
	 * Returns an array containing all class names currently registered in the
	 * editor registry
	 * 
	 * @return Array with all registered class names
	 */
	public synchronized String[] getAllClassNames() {
		Set<String> names = getRegistry(false).keySet();
		return names.toArray(new String[names.size()]);
	}

	/**
	 * @return the active workbench window, or the first one if there is no
	 *         active window
	 */
	public IWorkbenchWindow getActiveOrFirstWorkbenchWindow() {
		IWorkbenchWindow result = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (result == null) {
			IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
			if (windows != null && windows.length > 0) {
				result = windows[0];
			}
		}
		return result;
	}

	/**
	 * Returns the active {@link IProject}. Active means the project which the
	 * user most likely worked in before this method was called. This method is
	 * not intended to be used when a context menu is activated and therefore
	 * the concrete object {@link ISelection} is known since it might return a
	 * different project or null. Whenever this method is used to determine the
	 * project the user should get the chance to select a different one (or one
	 * at all) from a given list.
	 * 
	 * @return The active project or null if no project could be determined
	 */
	public IProject getActiveProject() {
		IProject project = null;
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		// trivial cases 0
		if (projects.length == 0) {
			return null;
		}
		// ... and 1
		if (projects.length == 1) {
			return projects[0];
		}
		// get the current selection
		// This can be either supplied by a view or an editor
		IWorkbenchPage page = getActiveOrFirstWorkbenchWindow().getActivePage();
		if (page != null) {
			ISelection sel = getActiveOrFirstWorkbenchWindow().getActivePage().getSelection();
			if (sel instanceof IStructuredSelection && !sel.isEmpty()) {
				IStructuredSelection structSel = (IStructuredSelection) sel;
				// retrieve selected element
				Object obj = structSel.getFirstElement();

				// if its a RefObject we can get the project right away
				if (obj instanceof RefBaseObject) {
					RefBaseObject refObj = (RefBaseObject) obj;
					try {
						project = ModelAdapterUI.getInstance().getProject(refObj);
						// consider : MieAdapter, which follows a different
						// policy, it used the
						// Connection attached to the object, this is "Safe
						// in MS6".
						// - also works for a transient partition;
						// - yields a different result if the object is in a
						// different workspace.
						// return MieAdapter.getProject(obj);
						if (project == null) {
							return ModelAdapterUI.getInstance().getProject((RefBaseObject) obj);
						}
						return project;
					} catch (Exception e) {
						// something went wrong ... let's go on and search
						MiFwkUIPlugin.logError("Selected object was of type RefObject but mri could not be determined. refObj: " //$NON-NLS-1$
								+ refObj, e, sTracer);
					}
				}

				// if obj is an adaptable ...
				project = ModelAdapterUI.getInstance().getProject(obj);
				if (project != null) {
					return project;
				}
				IResource r = ModelAdapterUI.getInstance().adaptObject(obj, IResource.class);
				if (r != null) {
					return r.getProject();
				}

				RefBaseObject refObj = ModelAdapterUI.getInstance().getRefBaseObject(obj);
				if (refObj != null) {
					// consider using only MieAdapter
					project = ModelAdapterUI.getInstance().getProject(refObj);
					if (project == null) {
						project = ModelAdapterUI.getInstance().getProject((RefBaseObject) obj);
					}
					return project;
				}

				// markers do not adapt to projects so let's try instanceof
				if (obj instanceof IMarker) {
					IResource res = ((IMarker) obj).getResource();
					if (res != null) {
						project = res.getProject();
						if (project != null) {
							return project;
						}
					}
				}

				// tree selections are used in CommonNavigator so try them
				if (sel instanceof ITreeSelection) {
					ITreeSelection treeSel = (ITreeSelection) sel;
					TreePath[] paths = treeSel.getPaths();
					if (paths.length > 0) {
						// first segment returns the root node for a given tree
						// selection
						Object firstSegment = paths[0].getFirstSegment();
						if (firstSegment instanceof IResource) {
							return ((IResource) firstSegment).getProject();
						}
					}
				}
			}

			// ok, either nothing has been found so far or the selection was not
			// structured
			// so let's search the active part for EditorInput
			IWorkbenchPart part = page.getActivePart();
			if (part instanceof IEditorPart) {
				// if its an editor check the input
				project = checkEditorPartInput((IEditorPart) part);
				if (project != null) {
					return project;
				}
			}

			// active part was not an editor so try the last known active editor
			IEditorPart editPart = page.getActiveEditor();
			project = checkEditorPartInput(editPart);
		}
		// TODO search the navigation history
		// go backwards and ask parts
		return project;
	}

	/**
	 * Returns the active {@link IModelEditor} (if any) based on the current
	 * {@link ISelection}. If no such selection exists, the method tries to
	 * adapt the editor returned by {@link IWorkbenchPage#getActiveEditor()} to
	 * {@link IModelEditor}.
	 * 
	 * @return The currently active IModelEditor or null if no such editor is
	 *         active
	 */
	public IModelEditor getActiveModelEditor() {
		IWorkbenchWindow activeWorkbenchWindow = getActiveOrFirstWorkbenchWindow();
		if (activeWorkbenchWindow != null) {
			IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
			ISelection sel = page.getSelection();
			if (sel instanceof IStructuredSelection && !sel.isEmpty()) {
				Object head = ((IStructuredSelection) sel).getFirstElement();
				if (head instanceof IAdaptable) {
					IModelEditor editor = (IModelEditor) ((IAdaptable) head).getAdapter(IModelEditor.class);
					if (editor != null) {
						return editor;
					}
				}
			}
			IEditorPart part = page.getActiveEditor();
			if (part != null) {
				return (IModelEditor) part.getAdapter(IModelEditor.class);
			}
		}
		return null;
	}

	/**
	 * Method returns the current {@link StatusLineManager}. If no
	 * StatusLineManager is available, a new StatusLineManager will be created
	 * and returned. In most cases this will not have any effect and will not be
	 * able to display status info, but it makes null pointer checks when
	 * calling the method obsolete
	 * 
	 * @return the status line manager of the active part or a new one if there
	 *         is no such part
	 */
	public IStatusLineManager getActiveStatusLineManager() {
		IWorkbenchPart activePart = getActiveOrFirstWorkbenchWindow().getActivePage().getActivePart();
		if (activePart instanceof IViewPart) {
			IViewPart viewPart = (IViewPart) activePart;
			return viewPart.getViewSite().getActionBars().getStatusLineManager();
		} else if (activePart instanceof IEditorPart) {
			IEditorPart editorPart = (IEditorPart) activePart;
			IEditorActionBarContributor contributor = editorPart.getEditorSite().getActionBarContributor();
			if (contributor instanceof EditorActionBarContributor) {
				EditorActionBarContributor editorContributor = (EditorActionBarContributor) contributor;
				return editorContributor.getActionBars().getStatusLineManager();
			}
		}
		// this is a useless dummy but avoids nasty null pointer checks when
		// calling the method
		return new StatusLineManager();
	}

	private IProject checkEditorPartInput(IEditorPart part) {
		if (part == null) {
			return null;
		}
		IEditorInput ip = part.getEditorInput();
		IProject p = (IProject) ip.getAdapter(IProject.class);
		if (p != null) {
			return p;
		}
		IResource r = (IResource) ip.getAdapter(IResource.class);
		if (r != null) {
			return r.getProject();
		}
		return null;
	}

	private void createMBean(String className, Collection<EditorDescriptor> set) {
		if (JMX_ENABLED) {
			try {
				new EditorRegistryEntryMBeanImpl(className, set);
			} catch (NotCompliantMBeanException e) {
				MiFwkUIPlugin.logError(e, sTracer);
			}
		}
	}

	private List<Class<?>> getAllInterfaces(Class<?> clazz, List<Class<?>> result) {
		Class<?>[] interfaces = clazz.getInterfaces();
		result.addAll(Arrays.asList(interfaces));
		for (Class<?> interf : interfaces) {
			getAllInterfaces(interf, result);
		}
		return result;
	}

	private <T> void addToHead(Collection<T> c, T toAdd) {
		if (c instanceof List) {
			((List<T>) c).add(0, toAdd);
		} else {
			// add by swapping to a temporary list
			Collection<T> tmp = new ArrayList<T>(c);
			c.clear();
			c.add(toAdd);
			c.addAll(tmp);
		}
	}

	private final class EditorRegistryMBeanImpl extends StandardMBean implements EditorRegistryMBean {
		private final ObjectName mObjectName;

		public EditorRegistryMBeanImpl() throws NotCompliantMBeanException {
			super(EditorRegistryMBean.class);
			try {
				mObjectName = new ObjectName("com.sap.mi.fwk:type=EditorRegistry"); //$NON-NLS-1$
				ManagementFactory.getPlatformMBeanServer().registerMBean(this, mObjectName);
			} catch (InstanceAlreadyExistsException e) {
				throw new RuntimeException(e);
			} catch (MBeanRegistrationException e) {
				throw new RuntimeException(e);
			} catch (NotCompliantMBeanException e) {
				throw new RuntimeException(e);
			} catch (MalformedObjectNameException e) {
				throw new RuntimeException(e);
			}
		}

		public void reload() {
			disposeRegistry();
			getRegistry(true);
		}

		public ObjectName getObjectName() {
			return mObjectName;
		}
	}

	private final class EditorRegistryEntryMBeanImpl extends StandardMBean implements EditorRegistryEntryMBean {

		private final String className;
		private final Collection<EditorDescriptor> descs;
		private final ObjectName mObjectName;

		public EditorRegistryEntryMBeanImpl(String className, Collection<EditorDescriptor> descs) throws NotCompliantMBeanException {
			super(EditorRegistryEntryMBean.class);
			this.className = className;
			this.descs = descs;
			try {
				mObjectName = new ObjectName("com.sap.mi.fwk:type=EditorRegistryEntry,name=" + className); //$NON-NLS-1$
				MBeanServer server = ManagementFactory.getPlatformMBeanServer();
				try {
					server.unregisterMBean(mObjectName);
				} catch (InstanceNotFoundException e) { // $JL-EXC$
				}
				server.registerMBean(this, getObjectName());
				synchronized (ModelEditorManager.this) {
					mBeanRegistry.put(className, this);
				}
			} catch (InstanceAlreadyExistsException e) {
				throw new RuntimeException(e);
			} catch (MBeanRegistrationException e) {
				throw new RuntimeException(e);
			} catch (NotCompliantMBeanException e) {
				throw new RuntimeException(e);
			} catch (MalformedObjectNameException e) {
				throw new RuntimeException(e);
			}
		}

		public ObjectName getObjectName() {
			return mObjectName;
		}

		public void delete() {
			try {
				synchronized (ModelEditorManager.this) {
					mBeanRegistry.remove(className);
				}
				ManagementFactory.getPlatformMBeanServer().unregisterMBean(mObjectName);
			} catch (InstanceNotFoundException e) {
				throw new RuntimeException(e);
			} catch (MBeanRegistrationException e) {
				throw new RuntimeException(e);
			}
		}

		public String getClassName() {
			return className;
		}

		public TabularData getEditors() {
			TabularData result = new TabularDataSupport(sTabularEditorDescriptions);
			for (EditorDescriptor desc : descs) {
				Map<String, String> items = new HashMap<String, String>(3);
				items.put("EditorID", desc.getId()); //$NON-NLS-1$
				items.put("DisplayName", desc.getDisplayName()); //$NON-NLS-1$
				String factoryClass = (desc.getFactory() != null ? desc.getFactory().getClass().getName() : ""); //$NON-NLS-1$
				items.put("FactoryClass", factoryClass); //$NON-NLS-1$
				try {
					CompositeData row = new CompositeDataSupport(sCompositeEditorDescription, items);
					result.put(row);
				} catch (OpenDataException e) {
					throw new RuntimeException(e);
				}
			}
			return result;
		}

		public CompositeData getDefaultEditor() {
			for (EditorDescriptor desc : descs) {
				if (desc.isDefault()) {
					Map<String, String> items = new HashMap<String, String>();
					items.put("EditorID", desc.getId()); //$NON-NLS-1$
					items.put("DisplayName", desc.getDisplayName()); //$NON-NLS-1$
					String factoryClass = (desc.getFactory() != null ? desc.getFactory().getClass().getName() : ""); //$NON-NLS-1$
					items.put("FactoryClass", factoryClass); //$NON-NLS-1$
					try {
						CompositeData result = new CompositeDataSupport(sCompositeEditorDescription, items);
						return result;
					} catch (OpenDataException e) {
						throw new RuntimeException(e);
					}
				}
			}
			return null;
		}
	}

	/**
	 * Closes all active non-dirty modeleditors which reference the closed
	 * project. Dirty editors will be presented via Eclipse dialog. Eclipse
	 * determines based on the editor input whether closing a projects affects
	 * the editor. {@link ModelEditorInput} uses this technique and returns an
	 * IFile when asked by Eclipse framework.
	 * 
	 * @see ModelEditorInput#getAdapter(Class)
	 * @author d024127
	 */
	private final class ProjectCloseListener implements IResourceChangeListener {
		private final EditorCloser editorCloser = new EditorCloser();
		private final IFilter editorCloseFilter = new EditorCloseFilter();
		private volatile IProject currentProject;
		private volatile boolean deletion;

		private final class EditorCloser implements Runnable {
			public void run() {
				closeModelEditors(!deletion, editorCloseFilter);
			}
		}

		private final class EditorCloseFilter implements IFilter {
			public boolean select(Object toTest) {
				if (toTest instanceof IEditorReference) {
					IEditorReference ref = (IEditorReference) toTest;
					IEditorInput input = null;
					try {
						input = ref.getEditorInput();
					} catch (PartInitException e) {
						sTracer.log(Level.SEVERE, "Editor input not retrieved", e); //$NON-NLS-1$
						return false;
					}
					IProject project = (IProject) input.getAdapter(IProject.class);
					if (currentProject.equals(project)) {
						return true;
					}
				}
				return false;
			}
		}

		public void resourceChanged(IResourceChangeEvent event) {
			IResource resource = event.getResource();
			if (resource == null) {
				return; // might happen for some event types
			}

			currentProject = resource.getProject();
			// save editors since partition files survives
			// the closing of a project.
			// When the user deletes the project saving
			// makes no sense since
			// the partition file will be gone afterwards ->
			// flag for saving is
			// !preDelete == preClose
			deletion = (event.getType() == IResourceChangeEvent.PRE_DELETE);
			if (Display.getCurrent() != null) {
				// UI thread: close synchronously so that the editor still has a
				// valid project
				editorCloser.run();
			} else {
				/*
				 * Bad luck in non-UI thread: the project will already be closed
				 * in the UI thread (asyncExec, sync is too dangerous), and we
				 * can only notify the user about the failed save. Hope is that
				 * this will remain an unusual scenario.
				 */
				PlatformUI.getWorkbench().getDisplay().asyncExec(editorCloser);
			}
		}
	}

	/**
	 * Describes an object to editor association stored in the registry. Does
	 * not hold any reference to a live model object.
	 */
	private static class EditorDescriptor {

		private final IEditorDescriptor mEditorDesc;
		private final String mClassName;
		private final transient IConfigurationElement mConfigElement;

		private final boolean mCanHandleChildren;
		private final boolean mIsDefault;

		EditorDescriptor(String editorId, String className, boolean isDefault, boolean canHandleChildren,
				IConfigurationElement configElement) throws CoreException {
			mEditorDesc = PlatformUI.getWorkbench().getEditorRegistry().findEditor(editorId);
			if (mEditorDesc == null) {
				throw new CoreException(MiFwkUIPlugin.createStatus(IStatus.ERROR, "No such editor " + editorId, null)); //$NON-NLS-1$
			}
			mClassName = className;
			mIsDefault = isDefault;
			mCanHandleChildren = canHandleChildren;
			mConfigElement = configElement;
		}

		IEditorDescriptor getEditorDescriptor() {
			return mEditorDesc;
		}

		String getDisplayName() {
			return mEditorDesc.getLabel();
		}

		String getId() {
			return mEditorDesc.getId();
		}

		boolean isDefault() {
			return mIsDefault;
		}

		boolean canHandleChildren() {
			return mCanHandleChildren;
		}

		IModelEditorInputFactory getFactory() {
			if (mConfigElement.getAttribute(ATT_INPUT_FACTORY) != null) {
				try {
					Object ext = mConfigElement.createExecutableExtension(ATT_INPUT_FACTORY);
					if (ext instanceof IModelEditorInputFactory) {
						return (IModelEditorInputFactory) ext;
					} else if (ext != null) {
						MiFwkUIPlugin.logError(ext + " is not an instance of " //$NON-NLS-1$
								+ IModelEditorInputFactory.class.getName(), null, sTracer);
					}
				} catch (CoreException e) {
					MiFwkUIPlugin.logError(e, sTracer);
				}
			}
			return new ModelObjectElementFactory();
		}

		Bundle getContributor() {
			String name = mConfigElement.getContributor().getName();
			return Platform.getBundle(name);
		}

		String getClassName() {
			return mClassName;
		}

		IConfigurationElement getConfigElement() {
			return mConfigElement;
		}

		@Override
		public String toString() {
			return mEditorDesc.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (mCanHandleChildren ? 1231 : 1237);
			result = prime * result + ((mClassName == null) ? 0 : mClassName.hashCode());
			result = prime * result + ((mEditorDesc == null) ? 0 : mEditorDesc.hashCode());
			result = prime * result + (mIsDefault ? 1231 : 1237);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final EditorDescriptor other = (EditorDescriptor) obj;
			if (mCanHandleChildren != other.mCanHandleChildren) {
				return false;
			}
			if (mClassName == null) {
				if (other.mClassName != null) {
					return false;
				}
			} else if (!mClassName.equals(other.mClassName)) {
				return false;
			}
			if (mEditorDesc == null) {
				if (other.mEditorDesc != null) {
					return false;
				}
			} else if (!mEditorDesc.equals(other.mEditorDesc)) {
				return false;
			}
			if (mIsDefault != other.mIsDefault) {
				return false;
			}
			return true;
		}
	}

	/**
	 * In addition to {@link EditorDescriptor} holds a reference to the model
	 * object the editor can be started with. Must therefore not be cached.
	 */
	private static final class EditorDescriptorWithObject extends EditorDescriptor {

		private final RefBaseObject mStartObject;

		EditorDescriptorWithObject(EditorDescriptor desc, RefBaseObject startObject) throws CoreException {
			super(desc.getId(), desc.getClassName(), desc.isDefault(), desc.canHandleChildren(), desc.getConfigElement());
			mStartObject = startObject;
		}

		RefBaseObject getStartObject() {
			return mStartObject;
		}

		/**
		 * @return <code>null</code> if no input can be created
		 */
		IEditorInput createInput() {
			IModelEditorInputFactory factory = getFactory();
			try {
				ModelEditorInput input = factory.createEditorInput(mStartObject);
				if (input == null) {
					String msg = "Factory " + factory + " returned null for editor input for " + mStartObject; //$NON-NLS-1$ //$NON-NLS-2$
					MiFwkUIPlugin.logWarning(msg, sTracer);
				}
				return input;
			} catch (RuntimeException e) {
				String msg = "Exception in factory while creating editor input for " + mStartObject; //$NON-NLS-1$
				MiFwkUIPlugin.logError(msg, e, sTracer);
				return null;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((mStartObject == null) ? 0 : mStartObject.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!super.equals(obj)) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final EditorDescriptorWithObject other = (EditorDescriptorWithObject) obj;
			if (mStartObject == null) {
				if (other.mStartObject != null) {
					return false;
				}
			} else if (!mStartObject.equals(other.mStartObject)) {
				return false;
			}
			return true;
		}
	}

	/**
	 * Holds a collection of editor descriptors and an indicator whether the
	 * list is complete.
	 */
	private static final class DescriptorList {
		private Set<EditorDescriptor> mDescriptors;
		private boolean mComplete;

		DescriptorList() {
			// use LinkedHashSet to be stable with the order,
			// but avoid duplicates
			mDescriptors = new LinkedHashSet<EditorDescriptor>();
		}

		Collection<EditorDescriptor> getDescriptors() {
			return mDescriptors;
		}

		/**
		 * Sets whether this list holds information from all objects' super
		 * classes.
		 */
		synchronized void setComplete() {
			if (!mComplete) {
				mDescriptors = Collections.unmodifiableSet(mDescriptors);
				mComplete = true;
			}
		}

		boolean isComplete() {
			return mComplete;
		}

		@Override
		public String toString() {
			StringBuilder b = new StringBuilder("Complete=").append(mComplete); //$NON-NLS-1$
			b.append("\n"); //$NON-NLS-1$
			return b.append(mDescriptors).toString();
		}
	}

}
