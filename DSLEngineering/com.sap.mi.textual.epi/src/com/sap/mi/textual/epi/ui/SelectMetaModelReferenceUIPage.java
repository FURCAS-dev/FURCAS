package com.sap.mi.textual.epi.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ListDialog;

import com.sap.mi.textual.epi.Activator;
import com.sap.mi.textual.epi.Constants;
import com.sap.mi.textual.epi.Messages;
import com.sap.mi.textual.epi.builder.SyntaxGenerationNature;
import com.sap.mi.textual.epi.conf.DeployedMetaProjectConf;
import com.sap.mi.textual.epi.conf.IProjectMetaRefConf;
import com.sap.mi.textual.epi.conf.OpenMOF14MetaProjectConf;

/**
 * reusable collection of controls, providers and listeners for selecting a
 * referred meta model.
 * 
 * @author C5107456
 */
public class SelectMetaModelReferenceUIPage {

    // for use with selection events
    /** The Constant REF_PROJ. */
    private static final int REF_PROJ = 0;

    /** The Constant DEP_META. */
    private static final int DEP_META = 1;

    // can become 0 for open metamodel or 1 for deployed metamodel
    /** The _selection. */
    private int myCurrentSelection = -1;

    // private MetaModelInfo originalSelectedMMInfo;
    // private MetaModelInfo currentlySelectedMMInfo;
    /** The _original selected mm conf. */
    private IProjectMetaRefConf myOriginalSelectedMMConf;

    /** The _currently selected mm conf. */
    private IProjectMetaRefConf myCurrentlySelectedMMConf;

    /** The _deployed mm group controls. */
    private final List<Control> myDeployedMMGroupControls = new ArrayList<Control>();

    /** The _ref project mm group controls. */
    private final List<Control> myRefProjectMMGroupControls = new ArrayList<Control>();

    // private SyntaxGenerationNature _syntaxGenNature;
    /** The ws root. */
    private final IWorkspaceRoot wsRoot;

    /**
     * Instantiates a new select meta model reference ui page.
     * 
     * @param pageComposite
     *            the page composite
     * @param project
     *            the project
     */
    public SelectMetaModelReferenceUIPage(Composite pageComposite, IProject project) {

	// wsRoot = project.getWorkspace().getRoot();
	IWorkspace workspace = ResourcesPlugin.getWorkspace();
	wsRoot = workspace.getRoot();

	doCreatePage(pageComposite, project);

    }

    /**
     * creates the page contents.
     * 
     * @param pageComposite
     *            the page composite
     * @param project
     *            the project
     */
    private void doCreatePage(final Composite pageComposite, IProject project) {

	// !! Assumes that syntaxGenNature has been set before
	if (project != null) {
	    myOriginalSelectedMMConf = SyntaxGenerationNature.getMetaModelReferenceConf(project);
	    myCurrentlySelectedMMConf = SyntaxGenerationNature.getMetaModelReferenceConf(project);
	}

	// Page has 3 groups (boxes) of widgets, each showing a different way of
	// referring to a metamodel
	// only one way can be selected, therefore the groups are triggered by
	// radio buttons.

	Group refProjectGroup;
	Group deployedMMGroup;

	// the first group allows to select another project in the workspace
	// that has MOINMetaNature
	Button refProjectChoiceButton = new Button(pageComposite, SWT.RADIO);
	refProjectChoiceButton.setText(Messages.RefProjectRadioButton);
	refProjectChoiceButton.setSelection(false);
	refProjectGroup = new Group(pageComposite, SWT.NULL);
	GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	refProjectGroup.setLayout(layout);

	// The second group allows to select a deployed metamodel
	Button deployedMMChoiceButton = new Button(pageComposite, SWT.RADIO);
	deployedMMChoiceButton.setText(Messages.DeployedMetaRadioButton);
	deployedMMChoiceButton.setSelection(false);
	deployedMMGroup = new Group(pageComposite, SWT.NULL);
	deployedMMGroup.setLayout(new GridLayout());
	layout = new GridLayout();
	layout.numColumns = 2;
	deployedMMGroup.setLayout(layout);

	String metamodelName = Messages.WorkbenchPropertyPage_NoMetaModelSetMessage;
	String refProjectName = Messages.WorkbenchPropertyPage_NoRefProjectSetMessage;
	// String ecoreFileName =
	// Messages.WorkbenchPropertyPage_NoEcoreFileSetMessage;

	if (myCurrentlySelectedMMConf != null) {
	    if (myCurrentlySelectedMMConf instanceof DeployedMetaProjectConf) {
		deployedMMChoiceButton.setSelection(true);
		selectGroup(DEP_META);
		metamodelName = ((DeployedMetaProjectConf) myCurrentlySelectedMMConf).getContainerName();
	    } else if (myCurrentlySelectedMMConf instanceof OpenMOF14MetaProjectConf) {
		refProjectChoiceButton.setSelection(true);
		selectGroup(REF_PROJ);
		refProjectName = ((OpenMOF14MetaProjectConf) myCurrentlySelectedMMConf).getRefProjectName();
	    }
	}

	setupDeployedProjectGroup(deployedMMGroup, metamodelName, project);
	setupRefProjectGroup(refProjectGroup, refProjectName);
	// setupEcoreGroup(ecoreMMGroup, ecoreFileName);

	if (myCurrentlySelectedMMConf != null) {
	    if (myCurrentlySelectedMMConf instanceof DeployedMetaProjectConf) {
		setControlsEnabled(myDeployedMMGroupControls, true);
		setControlsEnabled(myRefProjectMMGroupControls, false);
	    } else if (myCurrentlySelectedMMConf instanceof OpenMOF14MetaProjectConf) {
		setControlsEnabled(myDeployedMMGroupControls, false);
		setControlsEnabled(myRefProjectMMGroupControls, true);
	    }

	} else {
	    setControlsEnabled(myDeployedMMGroupControls, false);
	    setControlsEnabled(myRefProjectMMGroupControls, false);

	}

	GroupEnableListener listener = new GroupEnableListener(refProjectChoiceButton, deployedMMChoiceButton);
	refProjectChoiceButton.addListener(SWT.Selection, listener);
	deployedMMChoiceButton.addListener(SWT.Selection, listener);

    }

    /**
     * Setup deployed project group.
     * 
     * @param group
     *            the group
     * @param metamodelName
     *            the metamodel name
     * @param project
     *            the current project that is going to be configured
     */
    private void setupDeployedProjectGroup(final Group group, String metamodelName, final IProject project) {
	myDeployedMMGroupControls.add(group);

	GridData gridData1 = new GridData();
	gridData1.grabExcessHorizontalSpace = true;
	gridData1.horizontalAlignment = SWT.FILL;
	group.setLayoutData(gridData1);

	// Label label = new Label(group, SWT.NULL);
	// _deployedMMGroupControls.add(label);
	// label.setText(Messages.MetaModelLabel);
	group.setText(Messages.MetaModelLabel);

	final Text metamodelText = new Text(group, SWT.READ_ONLY);

	GridData gridData = new GridData();
	gridData.grabExcessHorizontalSpace = true;
	gridData.horizontalAlignment = SWT.FILL;

	metamodelText.setLayoutData(gridData);
	metamodelText.setText(metamodelName);
	metamodelText.setEditable(false);
	myDeployedMMGroupControls.add(metamodelText);

	Button changeButton = new Button(group, SWT.NULL);
	myDeployedMMGroupControls.add(changeButton);
	changeButton.setText(Messages.ChangeLabel);

	final ListDialog dialog = new ListDialog(group.getShell());

	IStructuredContentProvider cp = new MetaModelListContentProvider();

	dialog.setContentProvider(cp);
	dialog.setLabelProvider(new MetaModelListLabelProvider());
	dialog.setTitle(Messages.SelectDeployedMetamodelDialogTitle);
	// must set something not null, just for inputChanged to be called.
	dialog.setInput(this);

	// ArrayList<Object> initialElements = new ArrayList<Object>(1);
	// dialog.setInitialElementSelections(initialElements);

	Listener buttonListener = new Listener() {
	    @Override
	    public void handleEvent(Event event) {
		if (dialog.open() == ListDialog.OK) {

		    Object[] result = dialog.getResult();
		    if (result.length == 1) { // should be guaranteed by
					      // Dialog?
			String containerName = (String) result[0];
			myCurrentlySelectedMMConf = new DeployedMetaProjectConf(containerName, project);
			metamodelText.setText(containerName);
			group.update();
		    }
		}
	    }
	};

	changeButton.addListener(SWT.Selection, buttonListener);
    }

    /**
     * Setup ref project group.
     * 
     * @param group
     *            the group
     * @param refProjectName
     *            the ref project name
     */
    private void setupRefProjectGroup(final Group group, String refProjectName) {
	myRefProjectMMGroupControls.add(group);
	GridData gridData1 = new GridData();
	gridData1.grabExcessHorizontalSpace = true;
	gridData1.horizontalAlignment = SWT.FILL;
	group.setLayoutData(gridData1);
	group.setText(Messages.RefProjectLabel);

	Label label = new Label(group, SWT.NULL);
	label.setText(Messages.MessageRefProjectLabel);
	myRefProjectMMGroupControls.add(label);

	final Text metamodelText = new Text(group, SWT.READ_ONLY);
	myRefProjectMMGroupControls.add(metamodelText);
	GridData gridData = new GridData();
	gridData.grabExcessHorizontalSpace = true;
	gridData.horizontalAlignment = SWT.FILL;
	metamodelText.setLayoutData(gridData);

	metamodelText.setText(refProjectName);
	metamodelText.setEditable(false);

	Button changeButton = new Button(group, SWT.NULL);
	changeButton.setText(Messages.ChangeLabel);
	myRefProjectMMGroupControls.add(changeButton);

	final ListDialog dialog = new ListDialog(group.getShell());

	IStructuredContentProvider cp = new MoinMetaProjectListContentProvider();

	dialog.setContentProvider(cp);
	dialog.setLabelProvider(new MoinMetaProjectListLabelProvider());
	dialog.setTitle(Messages.SelectRefProjectDialogTitle);

	// must set something not null, just for inputChanged to be called.
	dialog.setInput(wsRoot);

	// ArrayList<Object> initialElements = new ArrayList<Object>(1);
	// dialog.setInitialElementSelections(initialElements);

	Listener buttonListener = new Listener() {
	    @Override
	    public void handleEvent(Event event) {
		if (dialog.open() == ListDialog.OK) {

		    Object[] result = dialog.getResult();
		    if (result.length == 1) {
			// should be guaranteed by Dialog?
			IProject proj = (IProject) result[0];
			myCurrentlySelectedMMConf = new OpenMOF14MetaProjectConf(proj);
			metamodelText.setText(proj.getName());
			group.update();
		    }
		}
	    }
	};

	changeButton.addListener(SWT.Selection, buttonListener);
    }

    /**
     * handles event on the radio buttons, assumes only 2 such buttons exist.
     * 
     * @author C5107456
     */
    private final class GroupEnableListener implements Listener {

	/** The b1. */
	private final Button b1;
	private final Button b2;

	/**
	 * Instantiates a new group enable listener.
	 * 
	 * @param b1
	 *            the b1
	 */
	public GroupEnableListener(Button b1, Button b2) {
	    super();
	    this.b1 = b1;
	    this.b2 = b2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets
	 * .Event)
	 */
	@Override
	public void handleEvent(Event event) {
	    if (b1.getSelection() == true) {
		selectGroup(REF_PROJ);
	    } else if (b2.getSelection() == true) {
		selectGroup(DEP_META);
	    }
	}
    };

    /**
     * The Class MetaModelListContentProvider.
     */
    private final class MetaModelListContentProvider implements IStructuredContentProvider {

	// private Viewer mViewer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(
	 * java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {

	    Set<String> nameSet = new HashSet<String>();

	    Collection<MmDeploymentInfo> metamodels = MetamodelManager.getInstance().getDeployedMetamodels();

	    for (MmDeploymentInfo metamodel : metamodels) {
		nameSet.add(metamodel.getContainerName());
	    }
	    Collection<MmDeploymentInfo> importedMetamodels = MetamodelManager.getInstance().getImportedMetamodels();
	    for (MmDeploymentInfo metamodel : importedMetamodels) {
		nameSet.add(metamodel.getContainerName());
	    }
	    nameSet.add("sap.com/tc/moin/mof_1.4");

	    String[] result = new String[nameSet.size()];
	    int i = 0;
	    for (Iterator<String> iterator = nameSet.iterator(); iterator.hasNext();) {
		String contName = iterator.next();
		result[i] = contName;
		i++;
	    }
	    return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse
	 * .jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	    // mViewer= viewer;
	}

    }

    /**
     * The Class MetaModelListLabelProvider.
     */
    private static final class MetaModelListLabelProvider extends LabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
	    if (element instanceof MmDeploymentInfo) {
		MmDeploymentInfo mm = (MmDeploymentInfo) element;
		return mm.getContainerName();
	    }

	    String label = super.getText(element);
	    if (label == null) {

	    }
	    return label;
	}
    }

    /**
     * The Class MoinMetaProjectListContentProvider.
     */
    private final class MoinMetaProjectListContentProvider implements IStructuredContentProvider {

	// private Viewer mViewer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IStructuredContentProvider#getElements(
	 * java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {

	    Object[] result = null;
	    if (inputElement instanceof IResource) {
		IResource res = (IResource) inputElement;
		IProject[] allProjects = null;
		allProjects = res.getWorkspace().getRoot().getProjects();
		ArrayList<IProject> filteredList = new ArrayList<IProject>(allProjects.length);
		for (int i = 0; i < allProjects.length; i++) {
		    IProject project = allProjects[i];
		    try {
			if (project.isOpen()) {
			    if (project.hasNature(Constants.MOIN_METAMODEL_NATURE_ID)) {
				filteredList.add(project);
			    }
			}
		    } catch (CoreException e) {
			Activator.logger.logError("", e);
		    }
		}
		result = filteredList.toArray();
	    }
	    return result;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse
	 * .jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	    // mViewer= viewer;
	}

    }

    /**
     * The Class MoinMetaProjectListLabelProvider.
     */
    private static final class MoinMetaProjectListLabelProvider extends LabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
	    if (element instanceof IProject) {
		IProject project = (IProject) element;
		return project.getName();
	    }

	    String label = super.getText(element);
	    if (label == null) {

	    }
	    return label;
	}
    }

    /**
     * Sets the controls enabled.
     * 
     * @param controls
     *            the controls
     * @param enabled
     *            the enabled
     */
    private static void setControlsEnabled(List<Control> controls, boolean enabled) {
	for (Control control : controls) {
	    control.setEnabled(enabled);
	}
    }

    /**
     * Select group.
     * 
     * @param newSelection
     *            the new selection
     */
    protected void selectGroup(int newSelection) {

	// also copes with selection == -1 and others
	if (newSelection == REF_PROJ) {
	    if (myCurrentSelection != REF_PROJ) { // only if changed
		myCurrentSelection = REF_PROJ;
		setControlsEnabled(myRefProjectMMGroupControls, true);
	    }
	} else {
	    setControlsEnabled(myRefProjectMMGroupControls, false);
	}

	if (newSelection == DEP_META) {
	    if (myCurrentSelection != DEP_META) {
		myCurrentSelection = DEP_META;
		setControlsEnabled(myDeployedMMGroupControls, true);
	    }
	} else {
	    setControlsEnabled(myDeployedMMGroupControls, false);
	}

    }

    /**
     * Checks for config changed.
     * 
     * @return true, if successful
     */
    public boolean hasConfigChanged() {
	// has changed if original and current are not equal
	if (myOriginalSelectedMMConf != null) {
	    return !myOriginalSelectedMMConf.equals(myCurrentlySelectedMMConf);
	}
	return myCurrentlySelectedMMConf != null; // return true if current is
						  // not null, as original is
						  // null here
    }

    /**
     * Gets the currently selected mm conf.
     * 
     * @return the currently selected mm conf
     */
    public IProjectMetaRefConf getCurrentlySelectedMMConf() {
	return myCurrentlySelectedMMConf;
    }

    /**
     * Checks if is valid selection.
     * 
     * @return true, if is valid selection
     */
    public boolean isValidSelection() {
	if (myCurrentlySelectedMMConf != null) {
	    // check that current conf type is same as enabled button
	    if (myCurrentlySelectedMMConf instanceof OpenMOF14MetaProjectConf) {
		// in this case, the first group of controls must be selected
		return myCurrentSelection == REF_PROJ; // return true if first
						       // button is selected
	    } else if (myCurrentlySelectedMMConf instanceof DeployedMetaProjectConf) {
		return myCurrentSelection == DEP_META; // return if second
						       // button is selected
	    }
	}
	return false;
    }
}
