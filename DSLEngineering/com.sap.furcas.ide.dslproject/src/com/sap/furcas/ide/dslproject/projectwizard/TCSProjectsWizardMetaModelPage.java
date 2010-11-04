package com.sap.furcas.ide.dslproject.projectwizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.sap.furcas.ide.dslproject.Messages;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;
import com.sap.furcas.ide.dslproject.ui.SelectMetaModelReferenceUIPage;


public class TCSProjectsWizardMetaModelPage extends WizardPage {

    /** The page. */
    private SelectMetaModelReferenceUIPage page;

    private IProject project;
    
    private boolean metamodelSelectionIgnoreFlag = false;

    
    /**
     * @param selection
     */
    protected TCSProjectsWizardMetaModelPage(ISelection selection) {
        super("Metamodel Selection");
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent) {
        Composite pageComposite = new Composite(parent, SWT.NULL);
        this.setDescription(Messages.AddNatureWizardMMPageDescription);
        
        pageComposite.setLayout(new GridLayout());
        
        
        final Button disableMetaModelSelectionButton = new Button(pageComposite, SWT.CHECK);
        disableMetaModelSelectionButton.setText("Do not set metamodel reference yet. Grammar and Parser will not be generated until reference is set in Project properties.");
        disableMetaModelSelectionButton.setSelection(false);
        metamodelSelectionIgnoreFlag = false;
        GridData gridData = new GridData();
        gridData.grabExcessHorizontalSpace = true;
        gridData.horizontalAlignment = SWT.FILL;
        disableMetaModelSelectionButton.setLayoutData(gridData);
        
        
        Composite containedPageComposite = new Composite(pageComposite, SWT.NULL);
        gridData = new GridData();
        gridData.grabExcessHorizontalSpace = true;
        gridData.horizontalAlignment = SWT.FILL;
        containedPageComposite.setLayoutData(gridData);
        
        project = null;
        
        // TODO Gimmick: maybe use selected project as Metamodel reference if it has the right nature
        // may need to adapt project, as could be e.g. IJavaProject, which is not instanceOf IProject
//        if (getElement() instanceof IProject) {
//            project = (IProject) getElement();
//        } else if (getElement() instanceof IAdaptable) {
//            Object projectObject = getElement().getAdapter(IProject.class);
//            if (projectObject  != null && projectObject instanceof IProject) {
//                project = (IProject) projectObject;
//            }
//        }
        
//      if (project != null) {
//      mySyntaxGenNature  = SyntaxGenerationNature.getNatureFromProject(project);

        
        page = new SelectMetaModelReferenceUIPage(pageComposite, project );


        Listener buttonListener = new Listener() {
            public void handleEvent(Event event) {
                metamodelSelectionIgnoreFlag = disableMetaModelSelectionButton.getSelection();
            }
        };

        disableMetaModelSelectionButton.addListener(SWT.Selection, buttonListener);
        
        
        setControl(pageComposite);

    }


    /**
     * @return
     */
    public boolean isValidSelection() {
        if (! metamodelSelectionIgnoreFlag) {
            if ( page.isValidSelection()) {
                this.setErrorMessage(null);
                return true; 
            } else {
                this.setErrorMessage("Either select a metamodel reference or check the box.");
                return false;
            }
        } else {
            this.setErrorMessage(null);
            return true; 
        }
    }

    /**
     * @return
     */
    public IProjectMetaRefConf getCurrentlySelectedMMConf() {
        return page.getCurrentlySelectedMMConf();
    }
   

}