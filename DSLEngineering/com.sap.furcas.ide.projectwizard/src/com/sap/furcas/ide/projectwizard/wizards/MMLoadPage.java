package com.sap.furcas.ide.projectwizard.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/* 
 * This wizardpage is displayed when the user chooses to import some kind of existing MetaModel into his
 * Metamodelproject. Until now it just tells you how to do it manually. TODO 
 * */
public class MMLoadPage extends WizardPage {
    public FurcasWizard wizard;

    protected MMLoadPage(String pageName, FurcasWizard wiz) {
        super(pageName);
        wizard = wiz;
        setTitle("Uh oh");
        setDescription("Not fully implemented yet.");
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 4;
        Label label = new Label(container, SWT.NULL);
        label.setText("Resource URIs:");
        
        
        Button button1 = new Button(container, SWT.PUSH);
        button1.setText("Browse Registered Packages...");
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
            }

            @Override
            public void mouseDown(MouseEvent e) {
                browseRegistered();
            }

            @Override
            public void mouseUp(MouseEvent e) {
            }

        });
        
        
        Button button2 = new Button(container, SWT.PUSH);
        button2.setText("Browse File System...");
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
            }

            @Override
            public void mouseDown(MouseEvent e) {
                browseRegistered();
            }

            @Override
            public void mouseUp(MouseEvent e) {
            }

        });

        Button button3 = new Button(container, SWT.PUSH);
        button3.setText("Browse Workspace...");
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
            }

            @Override
            public void mouseDown(MouseEvent e) {
                browseRegistered();
            }

            @Override
            public void mouseUp(MouseEvent e) {
            }

        });
        GridData gd = new GridData();
        gd.horizontalAlignment = GridData.FILL;
        gd.horizontalSpan = 4;
        Text text = new Text(container, SWT.NULL | SWT.BORDER);
        text.setLayoutData(gd);
        setErrorMessage(null);
        setPageComplete(true);
        setControl(container);

    }

    protected void browseRegistered() {
        // TODO Auto-generated method stub

    }

    @Override
    public IWizardPage getNextPage() {
        return null;
    }

}
