package de.hpi.sam.bp2009.benchframework.randomGenerator.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorOptionObject;


public class RandomGeneratorWizardPage extends WizardPage {
    private static final String PAGETITLE = "Model Instanciator Configuration";
    private static final String PAGEDESC = "Set the options for the Model Instanciator.";
    private static final String LABELTEXT = "Enter the URI of the metaModel to instantiate, if empty we use petrinet";
    private static final String TOOLTIPTEXT = "This url is used to load an EPackage from the PackageRegistry";

    private RandomGeneratorOptionObject option;
    protected boolean validPackage = true;

    protected RandomGeneratorWizardPage(String pageName) {
        super(pageName);
        setTitle(PAGETITLE);
        setDescription(PAGEDESC);
        setPageComplete(false);
    }

    protected RandomGeneratorWizardPage(String pageName, RandomGeneratorOptionObject option) {
        this(pageName);
        this.option = option;
    }

    public void createControl(final Composite parent) {
        // create the widgets for the page
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, true);
        composite.setLayout(layout);

        Label label = new Label(composite, SWT.CENTER);
        label.setText(LABELTEXT);
        buildTextBox(composite);

        Button btn = new Button(composite, SWT.CENTER);
        btn.setText("Load Model");
        btn.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                try {
                    FileDialog dialog = new FileDialog(parent.getShell(), SWT.OPEN);
                    dialog.setFilterNames(new String[] { "XMI Files" });
                    dialog.setFilterExtensions(new String[] { "*.xmi" });

                    String absoluteFilePath = dialog.open();

                    if (absoluteFilePath == null)
                        return;
                    loadModel(absoluteFilePath);
                    setPageComplete(true);
                } catch (Exception e1) {
                    // TODO Show Error Message
                    e1.printStackTrace();
                }
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                // nothing to do here

            }
        });
        setControl(composite);
    }
    
    protected void loadModel(String absoluteFilePath) {
        ResourceSetImpl rs = new ResourceSetImpl();
        rs.getResource(URI.createFileURI(absoluteFilePath), true);
        option.setModelInstance(rs);
        option.setInstanceLoaded(true);
    }

    private void buildTextBox(Composite composite) {
        Text fileName = new Text(composite, SWT.BORDER);
        fileName.setText(option.getMetaModel().getNsURI());
        fileName.setToolTipText(TOOLTIPTEXT);
        fileName.addModifyListener(new ModifyListener() {

            @Override
            public void modifyText(ModifyEvent e) {
                // check if given URI is a package in package registry
                EPackage pckg = Registry.INSTANCE.getEPackage(((Text) e.getSource()).getText());
                if (pckg != null) {
                    option.setMetaModel(pckg);
                    validPackage = true;
                } else {
                    validPackage = false;
                }
            }
        });
    }

    @Override
    public boolean canFlipToNextPage() {
        return validPackage;
    }
}
