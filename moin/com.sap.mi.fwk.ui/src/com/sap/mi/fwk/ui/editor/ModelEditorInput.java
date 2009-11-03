package com.sap.mi.fwk.ui.editor;

import java.lang.ref.WeakReference;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableElement;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.mi.fwk.ui.internal.editor.IRunnableWithEditor;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * The input for model editors. Clients may instantiate or subclass.
 * 
 * @author d024127
 * @author d031150
 * 
 * @see ModelEditorPart
 * @see ModelMultiPageEditorPart
 * @see ModelFormEditorPart
 * @see IModelEditor
 */
public class ModelEditorInput implements IEditorInput, IPersistableElement {

    private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_EDITORS);

    /**
     * The stored {@link MRI} string
     */
    private final String mMriName;

    /**
     * The stored project name. Used to create the editor's connection with.
     */
    private String mProjectName = null;

    /**
     * The cached input name
     * 
     * @see #getLiveName()
     */
    private String mName;

    /**
     * The cached input tooltip
     * 
     * @see #getLiveToolTipText()
     */
    private String mTooltip;

    /**
     * The editor's connection set by {@link #setEditorConnection(Connection)} that is used to resolve {@link #mMriName} into live
     * objects. Implemented as a weak reference to avoid memory leaks (Eclipse stores editor inputs longer than the editor lives).
     * 
     * @see #getConnection()
     * @see #getConnectionOrFail()
     */
    private WeakReference<Connection> mConnection;

    private boolean restoreEnabled;

    private IRunnableWithEditor followUp;

    /**
     * Creates an input out of a {@link MRI} string and a project name
     * 
     * @param mriString
     *            a mri string as returned by {@link MRI#toString()} that denotes the input's {@link RefBaseObject}
     * @param projectName
     *            the name of the project this input operates in
     * @see MRI
     * @see IProject
     */
    public ModelEditorInput(String mriString, String projectName) {
	this(mriString);
	setProjectName(projectName);
    }

    /**
     * Creates an input out of a {@link MRI} string. If the project context is known at the time of creating the input, use
     * {@link #ModelEditorInput(String, String)}.
     * 
     * @param mriString
     *            a mri string as returned by {@link MRI#toString()} that denotes the input's {@link RefBaseObject}
     * @see #ModelEditorInput(String, String)
     */
    public ModelEditorInput(String mriString) {
	if (mriString == null) {
	    throw new IllegalStateException("mriString must not be null"); //$NON-NLS-1$
	}
	mMriName = mriString;
    }

    /**
     * Creates an input out of a {@link MRI}. If the project context is known at the time of creating the input, use
     * {@link #ModelEditorInput(String, String)}.
     * 
     * @param mri
     *            a mri that denotes the input's {@link RefBaseObject}
     * @see #ModelEditorInput(String, String)
     */
    public ModelEditorInput(MRI mri) {
	if (mri == null) {
	    throw new IllegalStateException("mri must not be null"); //$NON-NLS-1$
	}
	mMriName = mri.toString();
    }

    /**
     * Creates an input out of a model element. Both the input's {@link MRI} information and project context can be computed out
     * of it.
     * 
     * @param modelElement
     *            the model element the input operates on
     * @see #ModelEditorInput(String, String)
     */
    public ModelEditorInput(RefBaseObject modelElement) {
	if (modelElement == null) {
	    throw new IllegalStateException("modelElement must not be null"); //$NON-NLS-1$
	}
	mMriName = modelElement.get___Mri().toString();
	Connection connection = modelElement.get___Connection();
	setEditorConnection(connection);
    }

    /**
     * @return <code>null</code>
     */
    public ImageDescriptor getImageDescriptor() {
	return null;
    }

    /**
     * @return the cached name or the input's {@link MRI} string
     * @see #getLiveName()
     */
    public String getName() {
	if (mName != null) {
	    return mName;
	}
	return mMriName;
    }

    protected boolean hasName() {
	return mName != null;
    }

    protected void setName(String name) {
	this.mName = name;
    }

    protected String getExceptionText() {
	String result = MiFwkUiMessages.bind(MiFwkUiMessages.ModelEditorInput_objectNotFound, mName, mProjectName);
	return result;
    }

    /**
     * @return the cached tooltip or the input's {@link MRI} string
     * @see #getLiveToolTipText()
     */
    public String getToolTipText() {
	if (mTooltip != null) {
	    return mTooltip;
	}
	return getName();
    }

    /**
     * Returns a name for the input from the input's model object. Called at a time when it can be assumed that
     * {@link #getRefObject()} returns a "living" object. The result it cached so that it can be used by Eclipse even when the
     * editor or its connection is already closed. The default implementation tries to return a human readable string by searching
     * for a <code>name</code> or an <code>id</code> attribute, otherwise the object's MOF id is used. Subclasses may return a
     * text more appropriate to the input's object. Also note the remarks on the name in {@link IEditorInput#getName()}.
     * 
     * @return a name or <code>null</code> to indicate that a it can currently not be obtained.
     * @see IEditorInput#getName()
     * @see #getLiveName()
     */
    protected String getLiveName() {
	RefBaseObject object = getRefObject();
	if (object != null) {
	    String name = ModelManager.getInstance().getObjectName(object);
	    return name;
	}
	return null;
    }

    /**
     * Returns a tooltip for the input from the input's model object. Called at a time when it can be assumed that
     * {@link #getRefObject()} returns a "living" object. The result it cached so that it can be used by Eclipse even when the
     * editor or its connection is already closed. The default implementation tries to return the object's live name and MOF type.
     * Subclasses may return a text more appropriate to the input's object. Also note the remarks on the tooltip in
     * {@link IEditorInput#getToolTipText()}.
     * 
     * @return a tooltip or <code>null</code> to indicate that a it can currently not be obtained.
     * @see IEditorInput#getToolTipText()
     * @see #getLiveToolTipText()
     */
    protected String getLiveToolTipText() {
	RefBaseObject object = getRefObject();
	if (object != null) {
	    String name = getLiveName();
	    String typeName = ((ModelElement) object.refMetaObject()).getName();
	    String tip = MiFwkUiMessages.bind(MiFwkUiMessages.ModelEditorInput_tooltip, name, typeName);
	    return tip;
	}
	return null;
    }

    /**
     * Returns the concrete model element represented by the given MRI, if the requested adapter is either the the same class or
     * super class. In addition the method examines all composition parents and checks whether or not they are of the requested
     * class or a sub class.
     * <ul>
     * <li>get model element for mri</li>
     * <li>if adapter == modelElement.class return modelElement</li>
     * <li>if adapter == modelElement.superclass return modelElement</li>
     * <li>if adapter == modelElement.compositionParent.class return modelElement</li>
     * <li>if adapter == modelElement.anyCompositionParent.class return modelElement</li>
     * <li>if adapter == Connection return connection</li>
     * <li>if adapter == IProject return project the modelElement belongs to</li>
     * <li>if adapter == IFile returns the file (aka. Partition) in which the root element of this editor is contained</li>
     * </ul>
     * 
     * @param adapter
     *            the adapter class to look up
     * @return a object castable to the given class, or <code>null</code> if this object does not have an adapter for the given
     *         class
     */
    @SuppressWarnings("unchecked")
    public Object getAdapter(Class adapter) {
	if (RefBaseObject.class.isAssignableFrom(adapter)) {
	    RefBaseObject refObject = getRefObject(adapter);
	    return refObject;
	} else if (Connection.class.isAssignableFrom(adapter)) {
	    return getConnection();
	} else if (IProject.class == adapter) {
	    IProject project = getProject();
	    return project;
	} else if (IFile.class == adapter) {
	    RefBaseObject refObject = getRefObject();
	    if (refObject != null) {
		return ModelAdapter.getInstance().getFile(refObject);
	    }
	}
	return null;
    }

    /**
     * Saves {@link MRI} string and project name
     */
    public void saveState(IMemento memento) {
	// Do not store anything for deleted objects
	if (!exists()) {
	    return;
	}
	// Store project name and mri
	memento.putString(ModelObjectElementFactory.KEY_MRI, mMriName);
	memento.putString(ModelObjectElementFactory.KEY_PROJECTNAME, mProjectName);
	memento.putString(ModelObjectElementFactory.KEY_OBJECT_NAME, getName());
    }

    /**
     * Called from {@link ModelEditor} to populate the editor's connection to its input. The connection is needed on requests to
     * resolve the stored {@link #mMriName}.
     * 
     * @param connection
     *            the current connection
     * @throws RuntimeException
     *             if <code>connection</code> parameter is null
     * @see #getConnection()
     */
    public void setEditorConnection(Connection connection) {
	if (connection == null) {
	    throw new IllegalArgumentException("Connection must not be null"); //$NON-NLS-1$
	}

	if (!connection.isAlive()) {
	    throw new IllegalArgumentException("Connection must not be closed: " + connection); //$NON-NLS-1$
	}

	mConnection = new WeakReference<Connection>(connection);
	try {
	    IProject project = ModelAdapterUI.getInstance().getProject(connection);
	    if (project == null) {
		project = ConnectionManager.getInstance().getProjectForDefaultConnection(connection);
	    }
	    if (project != null) {
		setProjectName(project.getName());
	    }
	} catch (Exception e) {
	    // do nothing
	}

	RefBaseObject obj = getRefObject(RefBaseObject.class);
	if (obj != null) {
	    if (mName == null) {
		mName = getLiveName();
	    } else {
		String newName = getLiveName();
		if (newName != null) {
		    mName = newName;
		}
	    }
	    mTooltip = getLiveToolTipText();
	}
    }

    /**
     * Set the project name this input (and its editors) operate in
     * 
     * @param projectName
     *            the project name to set. Must not be <code>null</code>.
     */
    public void setProjectName(String projectName) {
	if (projectName == null || projectName.length() == 0) {
	    // Should only happen on a temporary basis for editors restored from
	    // old information.
	    // TODO [Editors] Remove extended hint around march 2007.
	    String msg = "Project name must neither be null nor empty. " //$NON-NLS-1$
		    + "Usually this a one-time effect for editors restored from old information. " //$NON-NLS-1$
		    + "However, if this happens more than once, contact the MOIN in Eclipse team."; //$NON-NLS-1$
	    throw new IllegalArgumentException(msg);
	}
	mProjectName = projectName;
    }

    /**
     * Returns the model object the editor input is working on
     * 
     * @return the object or <code>null</code> if no such object can be obtained, e.g. if the input's editor is not yet
     *         initialized.
     */
    public final RefBaseObject getRefObject() {
	RefBaseObject object = getRefObject(RefBaseObject.class);
	return object;
    }

    /**
     * @return the {@link MRI} string this input and its editors operate on
     */
    public final String getMriString() {
	return mMriName;
    }

    /**
     * @return the name of the project this input and its editors operate in
     */
    public final String getProjectName() {
	return mProjectName;
    }

    /**
     * @return {@link ModelObjectElementFactory#FACTORY_ID}
     */
    public String getFactoryId() {
	return ModelObjectElementFactory.FACTORY_ID;

    }

    /**
     * @return <code>true</code> if the input's state denotes a living MOIN object <br>
     *         Note:<br>
     *         finished.
     */
    public boolean exists() {
	if (mMriName == null || mProjectName == null) {
	    return false;
	}
	IProject project = getProject();
	if (project == null || !project.isAccessible()) {
	    return false;
	}
	MRI mri = getMri();
	if (mri == null) {
	    return false;
	}
	return true;
    }

    /**
     * @return this input
     */
    public IPersistableElement getPersistable() {
	if (this.restoreEnabled) {
	    return this;
	}
	return null;
    }

    /*
     * Sets whether this editor may be restored
     */
    void setRestoreEnabled(boolean enabled) {
	this.restoreEnabled = enabled;
    }

    /*
     * Registers a follow up action. Do not make public due to internal IRunnableWithEditor class.
     */
    void setFollowUp(IRunnableWithEditor followUp) {
	this.followUp = followUp;
    }

    /*
     * Clears and returns the follow up action. Do not make public due to internal IRunnableWithEditor class.
     */
    IRunnableWithEditor clearFollowUp() {
	IRunnableWithEditor result = this.followUp;
	this.followUp = null;
	return result;
    }

    /**
     * This method returns an instance which is either of the same <code>Class</code> object a sub class or sub interface of the
     * class defined by <code>adapter</code> - <code>null</code> otherwise. The implementation also checks composite children.
     * 
     * @param adapter
     * 
     * @return
     */
    private RefBaseObject getRefObject(Class<RefBaseObject> adapter) {
	try {
	    MRI mri = getMri();
	    if (mri != null) {
		// do not fail if Moin has not been initialized at the point in
		// time this method is called
		// this is consistent with getMri() which also simply return
		// null in case initialization is not complete
		Connection connection = getConnection();
		if (connection != null && connection.isAlive()) {
		    RefBaseObject modelElement = connection.getElement(mri);
		    if (modelElement == null) {
			return null;
		    }

		    // Climb up the chain of composition. Also uses a counter to
		    // prevent infinite loops
		    // in case refImmediateComposite does not return null
		    // TODO ModelEditorInput must not adapt to composite
		    // children
		    // as this is completely unpredictable - e.g. the first
		    // element in an unordered collection might be returned
		    int i = 0;
		    RefBaseObject o = modelElement;
		    do {
			if (adapter.isAssignableFrom(((Partitionable) o).get___JmiInterface())) {
			    return o;
			}

			if (o instanceof RefObject) {
			    o = ((RefObject) o).refImmediateComposite();
			} else {
			    break;
			}
		    } while (o != null && ++i < 1000);
		}
	    }
	} catch (Exception e) {
	    MiFwkUIPlugin.logError("Exception attempting to load mri: " + mMriName, e, sTracer); //$NON-NLS-1$
	}
	return null;
    }

    private IProject getProject() {
	if (mProjectName != null) {
	    IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject(mProjectName);
	    return p;
	}
	return null;
    }

    /**
     * @return the resolved MRI or <code>null</code> in case of failures
     */
    private MRI getMri() {
	if (mMriName == null) {
	    return null;
	}

	Connection connection = getConnection();

	if (connection != null && connection.isAlive() && connection.getSession() != null
		&& connection.getSession().getMoin() != null) {
	    return connection.getSession().getMoin().createMri(mMriName);
	} else {

	    ModelManager modelManager = ModelManager.getInstance();
	    try {
		MRI mri = modelManager.getMoinInstance().createMri(mMriName);
		return mri;
	    } catch (RuntimeException e) { // $JL-EXC$
		// If MRI resolution fails, this usually indicates
		// closed/deleted/not yet initialized project. May be called by
		// Eclipse at any time (async even). Since we cannot
		// control this flow, fail quietly here.
		return null;
	    }
	}
    }

    /**
     * @return the current connection or <code>null</code>
     */
    private Connection getConnection() {
	if (mConnection != null) {
	    Connection connection = mConnection.get();
	    return connection;
	}
	return null;
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
	final ModelEditorInput other = (ModelEditorInput) obj;
	if (mMriName == null) {
	    if (other.mMriName != null) {
		return false;
	    }
	} else if (!mMriName.equals(other.mMriName)) {
	    return false;
	}
	if (mProjectName == null) {
	    if (other.mProjectName != null) {
		return false;
	    }
	} else if (!mProjectName.equals(other.mProjectName)) {
	    return false;
	}
	return true;
    }

    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 0; // super.hashCode();
	result = PRIME * result + ((mMriName == null) ? 0 : mMriName.hashCode());
	result = PRIME * result + ((mProjectName == null) ? 0 : mProjectName.hashCode());
	return result;
    }

    @Override
    public String toString() {
	String s = super.toString() + " mriName: " + mMriName + " in project " + mProjectName + " on Connection " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		+ String.valueOf(getConnection()) + " (null=OK)"; //$NON-NLS-1$
	return s;
    }
}
