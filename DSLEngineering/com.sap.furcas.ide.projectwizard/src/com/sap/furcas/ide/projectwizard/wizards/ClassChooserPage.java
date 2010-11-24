package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

import com.sap.furcas.ide.projectwizard.util.ProjectInfo;

/* 
 * This page lets the user choose one or more natures to add to the DSL Project.
 * */

public class ClassChooserPage extends WizardPage {

    private EPackage eP;
    
    public EPackage geteP() {
        return eP;
    }

    public void seteP(EPackage eP) {
        this.eP = eP;
    }

    ProjectInfo pi;

    protected ClassChooserPage(String pageName, ProjectInfo pi) {
        super(pageName);
        this.pi = pi;
        setTitle("Class Chooser");
        setDescription("Choose one class of the metamodel, that you want to use in the DSL");
        setPageComplete(false);
    }

    Button button;
    List list;

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
        list = new List(container, SWT.BORDER | SWT.V_SCROLL);
        list.setItems(getClasses());
        setupList();
        list.setLayoutData(gridData);
        list.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event e) {
              String[] selection = list.getSelection();
              pi.setClassName(selection[0]);
              setPageComplete(true);
            }
          });
        setControl(container);
        setPageComplete(false);
    }

    private void setupList() {
        String[] items;
        Integer removed = 0;
        items = list.getItems();
        for (int i = 0; i < items.length; i++) {
            if (items[i].matches(" ")) {
                list.remove(i - removed);
                removed++;
            }
        }

    }

    private String[] getClasses() {
        EList<EObject> ePs = eP.eContents();
        String[] items = new String[ePs.size()];
        for (int i = 0; i < ePs.size(); i++) {
            if (ePs.get(i) instanceof EClass) {
                EClass eC = (EClass) ePs.get(i);
                items[i] = eC.getName();
            } else
                items[i] = " ";
        }
        return items;
    }

}
