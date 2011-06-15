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
	
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    @Override
    public boolean performFinish() {

	return false;
    }

    /**
     * Gets the selected reference conf.
     * 
     * @return the selected reference conf
     */
    public IProjectMetaRefConf getSelectedReferenceConf() {
	return null;
    }


}
