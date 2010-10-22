package com.sap.furcas.ide.dslproject.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.dialogs.PropertyPage;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Messages;
import com.sap.furcas.ide.dslproject.builder.EclipseProjectBuildStarter;
import com.sap.furcas.ide.dslproject.builder.SyntaxGenerationNature;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;

/**
 * The Class WorkbenchPropertyPage.
 */
public class WorkbenchPropertyPage extends PropertyPage implements IWorkbenchPropertyPage {

    /** The page. */
    private SelectMetaModelReferenceUIPage page;

    /** The _syntax gen nature. */
    private SyntaxGenerationNature mySyntaxGenNature;

    private IProject project;

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse
     * .swt.widgets.Composite)
     */
    @Override
    protected Control createContents(Composite parent) {
	Composite pageComposite = new Composite(parent, SWT.NULL);
	// FillLayout layout = new FillLayout();
	// layout.type = SWT.VERTICAL;
	pageComposite.setLayout(new GridLayout());
	this.setDescription(Messages.AddNatureWizardMMPageDescription);

	project = null;

	// may need to adapt project, as could be e.g. IJavaProject, which is
	// not instanceOf IProject
	if (getElement() instanceof IProject) {
	    project = (IProject) getElement();
	} else { // getElement() is always instanceof IAdaptable
	    Object projectObject = getElement().getAdapter(IProject.class);
	    if (projectObject != null && projectObject instanceof IProject) {
		project = (IProject) projectObject;
	    }
	}

	if (project != null) {
	    mySyntaxGenNature = SyntaxGenerationNature.getNatureFromProject(project);

	    page = new SelectMetaModelReferenceUIPage(pageComposite, project);
	} else {
	    // should never happen
	    Activator.logger.logWarning("Bug: PropertyPage invoked without IProject as Element, check plugin.xml.");
	}

	return pageComposite;

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#performOk()
     */
    @Override
    public boolean performOk() {
	if (page == null) {
	    return true;
	}
	if (page.isValidSelection()) {
	    if (mySyntaxGenNature != null) {
		if (page.hasConfigChanged()) {
		    IProjectMetaRefConf conf = page.getCurrentlySelectedMMConf();
		    mySyntaxGenNature.setMetaModel(conf);

		    EclipseProjectBuildStarter.buildProject(project, getShell());

		}
		this.setMessage(null, IMessageProvider.NONE);
	    } else {
		// should never happen
		this.setMessage(Messages.WorkbenchPropertyPage_NoDSLNature, IMessageProvider.ERROR);
	    }
	    return true;
	} else {
	    this.setMessage(Messages.WorkbenchPropertyPage_IncompleteSelection, IMessageProvider.ERROR);
	}
	return false;
    }

}
