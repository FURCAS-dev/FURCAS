package com.sap.furcas.ide.dslproject.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Messages;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;

/**
 * The Class AddSyntaxNatureWizard.
 */
public class AddSyntaxNatureWizard extends org.eclipse.jface.wizard.Wizard {

    /** The _target project. */
    private final IProject myTargetProject;

    /** The _page. */
    private SelectMetaModelReferenceUIPage myPage;

    /**
     * Instantiates a new adds the syntax nature wizard.
     * 
     * @param targetProject
     *            the target project
     */
    public AddSyntaxNatureWizard(IProject targetProject) {
	super();
	this.myTargetProject = targetProject;
	this.setHelpAvailable(false);
	this.setWindowTitle(Messages.AddNatureWizardTitle);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
    public void addPages() {
	ReferenceMetaModelSelectionWizardPage page2 = new ReferenceMetaModelSelectionWizardPage(Messages.AddNatureWizardTitle,
		myTargetProject);
	addPage(page2);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {
	if (myPage.isValidSelection()) {
	    IProjectMetaRefConf conf = myPage.getCurrentlySelectedMMConf();
	    try {
		conf.configureProject(myTargetProject);
	    } catch (CoreException e) {
		Activator.logger.logError("", e);
		return false;
	    }
	    return true;
	}
	return false;
    }

    /**
     * Gets the selected reference conf.
     * 
     * @return the selected reference conf
     */
    public IProjectMetaRefConf getSelectedReferenceConf() {
	return myPage.getCurrentlySelectedMMConf();
    }

    /**
     * The Class ReferenceMetaModelSelectionWizardPage.
     */
    private class ReferenceMetaModelSelectionWizardPage extends WizardPage implements IWizardPage {

	/** The target project. */
	private final IProject targetProject;

	/**
	 * Instantiates a new reference meta model selection wizard page.
	 * 
	 * @param pageName
	 *            the page name
	 * @param targetProject
	 *            the target project
	 */
	public ReferenceMetaModelSelectionWizardPage(String pageName, IProject targetProject) {
	    super(pageName);
	    this.targetProject = targetProject;
	    this.setTitle(Messages.AddNatureWizardTitle);

	    this.setDescription(Messages.AddNatureWizardMMPageDescription);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt
	 * .widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
	    Composite pageComposite = new Composite(parent, SWT.NULL);
	    pageComposite.setLayout(new GridLayout());
	    myPage = new SelectMetaModelReferenceUIPage(pageComposite, targetProject);
	    setControl(pageComposite);
	}

    }

}
