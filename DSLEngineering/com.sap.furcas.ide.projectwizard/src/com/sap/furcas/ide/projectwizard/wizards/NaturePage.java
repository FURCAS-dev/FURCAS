package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.core.resources.IProjectNatureDescriptor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

/* 
 * This page lets the user choose one or more natures to add to the DSL Project.
 * */

public class NaturePage extends WizardPage {

    Button button;
    List list;

    public NaturePage(ISelection selection) {
        super("wizardPage");
        setTitle("Nature Page");
        setDescription("Just a testpage.");
        setPageComplete(false);
    }

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

        list = new List(container, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL);
        list.setItems(getNatures());
        setupList();
        list.setLayoutData(gridData);
        Label label = new Label(container, SWT.NULL | SWT.WRAP);
        label.setText("This page shows all the natures registered in your workbench.\n"
                + "The Java and the Java plugin nature, are not listed as they\n"
                + "are always automatically added. You can choose any other nature\n"
                + "to add to your project but you have to remember certain\n" + "dependencies of natures to each other.");
        setControl(container);
    }

    private void setupList() {
        String[] items;
        Integer removed = 0;
        items = list.getItems();
        for (int i=1 ; i < items.length ; i ++){
            if (items[i].matches(" ")){
                list.remove(i-removed);
                removed++;
            }
        }
        
    }

    private String[] getNatures() {
        String[] naturenames;
        try {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            IProjectNatureDescriptor[] natures = workspace.getNatureDescriptors();
            naturenames = new String[natures.length];
            for (int i = 0; i < natures.length; i++) {
                if (!natures[i].getNatureId().matches("org.eclipse.pde.PluginNature")
                        && !natures[i].getNatureId().matches("org.eclipse.jdt.core.javanature")) {
                    if (natures[i].getLabel().length() < 2)
                        naturenames[i] = natures[i].getNatureId();
                    else
                        naturenames[i] = natures[i].getLabel();
                }
                else
                    naturenames[i]=" ";
            }
        } finally {

        }
        ;
        return naturenames;

    }

}