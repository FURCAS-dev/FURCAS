package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.widgets.SearchableTree;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import com.sap.furcas.ide.projectwizard.util.MNComposedAdapterFactory;
import com.sap.furcas.ide.projectwizard.util.ProjectInfo;

/**
 * This page lets the user choose one or more natures to add to the DSL Project.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class ClassChooserPage extends WizardPage {

    /**
     * References the chosen metamodel.
     */
    private EPackage eP;

    /**
     * References the searchable Tree, where the contents of the metamodel are displayed.
     */
    private SearchableTree searchTree;

    /**
     * 
     * @return An EPackage referencing the metamodel
     */
    public EPackage geteP() {
        return eP;
    }

    /**
     * Sets the EPackage referencing the metamodel
     * 
     * @param eP
     *            The EPackage referencing the metamodel
     */
    public void seteP(EPackage eP) {
        this.eP = eP;
    }

    /**
     * The user input
     */
    ProjectInfo pi;

    /**
     * Sets some variables of the page.
     * 
     * @param pageName
     *            Name of the Page
     * @param pi
     *            The user input
     */
    protected ClassChooserPage(String pageName, ProjectInfo pi) {
        super(pageName);
        this.pi = pi;
        setTitle("Class Chooser");
        setDescription("Choose one class of the metamodel, that you want to use in the DSL");
        setPageComplete(false);
    }

    List list;

    /**
     * Creates the UI of the page. The main element is the search Tree. It consists of a Searchfield and a treeviewer.
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
        GridData gridData;
        gridData = new GridData();
        gridData.horizontalSpan = 2;
        gridData.horizontalAlignment = SWT.FILL;
        gridData.grabExcessHorizontalSpace = true;
        gridData.verticalAlignment = SWT.FILL;
        gridData.grabExcessVerticalSpace = true;
        searchTree = new SearchableTree(container, SWT.SINGLE);
        ComposedAdapterFactory adapterFactory = MNComposedAdapterFactory.getAdapterFactory();
        searchTree.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
        searchTree.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
        searchTree.setLayoutData(gridData);
        setTreeInput(eP);
        searchTree.getTreeViewer().addSelectionChangedListener(new ISelectionChangedListener() {

            // If a class is selected. The variable className if the ProjectInfo instance will be
            // set to the name of that class. The page is complete afterwards and the user can
            // press finish. If the selected element is not a class, then the user won't be able
            // to finish the wizard.
            //
            public void selectionChanged(SelectionChangedEvent event) {
                if (event.getSelection().isEmpty()) {
                    setPageComplete(false);
                } else if (event.getSelection() instanceof IStructuredSelection) {
                    {
                        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                        Object object = selection.getFirstElement();
                        if (object instanceof EClass) {
                            EClass eC = (EClass) object;
                            pi.setClassName(eC.getName());
                            setPageComplete(true);
                        } else
                            setPageComplete(false);
                    }
                }
            }
        });

        setControl(container);
        setPageComplete(false);
    }

    /**
     * Sets the contents of the treeviewer to the contents of the metamodel chosen on the {@link}LoadPage.
     * 
     * @param object
     *            The object the TreeViewers input is set to.
     */
    public void setTreeInput(Object object) {
        if (object instanceof EPackage) {
            EPackage ePack = (EPackage) object;
            if (searchTree != null) {
                if (ePack.getESuperPackage() == null)
                    searchTree.setInput(ePack);
                else
                    searchTree.setInput(ePack.getESuperPackage());
            }
        }       
    }
}
