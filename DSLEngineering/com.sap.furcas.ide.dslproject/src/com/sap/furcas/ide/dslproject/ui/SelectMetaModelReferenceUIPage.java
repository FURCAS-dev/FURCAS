package com.sap.furcas.ide.dslproject.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;

import com.sap.furcas.ide.dslproject.Messages;
import com.sap.furcas.ide.dslproject.builder.SyntaxGenerationNature;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;

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

    /**
     * Instantiates a new select meta model reference ui page.
     * 
     * @param pageComposite
     *            the page composite
     * @param project
     *            the project
     */
    public SelectMetaModelReferenceUIPage(Composite pageComposite, IProject project) {
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

	// String ecoreFileName =
	// Messages.WorkbenchPropertyPage_NoEcoreFileSetMessage;



	if (myCurrentlySelectedMMConf == null) {
	    setControlsEnabled(myDeployedMMGroupControls, false);
	    setControlsEnabled(myRefProjectMMGroupControls, false);
	}

	GroupEnableListener listener = new GroupEnableListener(refProjectChoiceButton, deployedMMChoiceButton);
	refProjectChoiceButton.addListener(SWT.Selection, listener);
	deployedMMChoiceButton.addListener(SWT.Selection, listener);

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
	return false;
    }
}
