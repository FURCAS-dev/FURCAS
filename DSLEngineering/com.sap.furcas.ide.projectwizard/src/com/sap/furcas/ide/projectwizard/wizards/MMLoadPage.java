package com.sap.furcas.ide.projectwizard.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.presentation.EcoreActionBarContributor.ExtendedLoadResourceAction.RegisteredPackageDialog;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/* 
 * This wizardpage is displayed when the user chooses to import some kind of existing MetaModel into his
 * Metamodelproject.
 * */
public class MMLoadPage extends WizardPage {
    public FurcasWizard wizard;
    public Text uriField;
    public Label wrongType;
    ProjectInfo pi;

    protected MMLoadPage(String pageName, FurcasWizard wiz, ProjectInfo pi) {
        super(pageName);
        this.pi = pi;
        wizard = wiz;
        setTitle("Uh oh");
        setDescription("Not fully implemented yet. No effect until now. Please add the desired metamodel manually.");
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
        button1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                RegisteredPackageDialog registeredPackageDialog = new RegisteredPackageDialog(getShell());
                registeredPackageDialog.open();
                Object[] result = registeredPackageDialog.getResult();
                if (result != null) {
                    List<?> nsURIs = Arrays.asList(result);
                    if (registeredPackageDialog.isDevelopmentTimeVersion()) {
                        ResourceSet resourceSet = new ResourceSetImpl();
                        resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
                        StringBuffer uris = new StringBuffer();
                        Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
                        for (int i = 0, length = result.length; i < length; i++) {
                            URI location = ePackageNsURItoGenModelLocationMap.get(result[i]);
                            Resource resource = resourceSet.getResource(location, true);
                            EcoreUtil.resolveAll(resource);
                        }
                        for (Resource resource : resourceSet.getResources()) {
                            for (EPackage ePackage : getAllPackages(resource)) {
                                if (nsURIs.contains(ePackage.getNsURI())) {
                                    uris.append(resource.getURI());
                                    uris.append("  ");
                                    break;
                                }
                            }
                        }
                        uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
                    } else {
                        StringBuffer uris = new StringBuffer();
                        for (int i = 0, length = result.length; i < length; i++) {
                            uris.append(result[i]);
                            uris.append("  ");
                        }
                        uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
                    }
                }
            }
        });

        Button button2 = new Button(container, SWT.PUSH);
        button2.setText("Browse File System...");
        button2.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                // TODO Register the chosen .ecore file, maybe not here but in one of the next steps
                FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN);
                fileDialog.setText("Import");
                fileDialog.setFilterPath("C:/");
                String[] filterExt = { "*.ecore" };
                fileDialog.setFilterExtensions(filterExt);
                fileDialog.open();
                String filterPath = fileDialog.getFilterPath();
                String[] fileNames = fileDialog.getFileNames();
                StringBuffer uris = new StringBuffer();

                for (int i = 0, len = fileNames.length; i < len; i++) {
                    uris.append(URI.createFileURI(filterPath + File.separator + fileNames[i]).toString());
                    uris.append("  ");
                }
                uriField.setText((uriField.getText() + "  " + uris.toString()).trim());

                String fileName = fileDialog.getFileName();
                if (fileName != null) {
                    uriField.setText(URI.createFileURI(filterPath + File.separator + fileName).toString());

                }
            }
        });

        Button button3 = new Button(container, SWT.PUSH);
        button3.setText("Browse Workspace...");
        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), "Choose Metamodel",
                        "Select the desired Metamodel an click OK.", true, null, null);
                if (files.length > 0) {
                    StringBuffer text = new StringBuffer();
                    for (int i = 0; i < files.length; ++i) {
                        text.append(URI.createPlatformResourceURI(files[i].getFullPath().toString(), true));
                        text.append("  ");
                    }
                    uriField.setText(text.toString());
                }
            }
        });
        GridData gd = new GridData();
        gd.horizontalAlignment = GridData.FILL;
        gd.horizontalSpan = 4;
        uriField = new Text(container, SWT.NULL | SWT.BORDER);
        uriField.setLayoutData(gd);
        uriField.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                dialogChanged();
            }
        });
        gd = new GridData();
        gd.horizontalAlignment = GridData.FILL;
        gd.horizontalSpan = 4;
        gd.grabExcessHorizontalSpace = true;
        wrongType = new Label(container, SWT.NULL);
        wrongType.setLayoutData(gd);
        setErrorMessage(null);
        setControl(container);

    }

    protected void dialogChanged() {
        String text = uriField.getText();
        text = text.trim();
        if (!text.endsWith(".ecore")) {
            wrongType.setText("The File you choose must be a .ecore file. Whitespaces before and after URIs will be deleted.");
            setPageComplete(false);
        } else {
            wrongType.setText("");
            setPageComplete(true);
        }
        if (!uriField.getText().matches(text))
            uriField.setText(text);
        pi.setURIPath(uriField.getText());
    }

    @Override
    public IWizardPage getNextPage() {
        return null;
    }

    protected Collection<EPackage> getAllPackages(Resource resource) {
        List<EPackage> result = new ArrayList<EPackage>();
        for (TreeIterator<?> j = new EcoreUtil.ContentTreeIterator<Object>(resource.getContents()) {
            private static final long serialVersionUID = 1L;

            @Override
            protected Iterator<? extends EObject> getEObjectChildren(EObject eObject) {
                return eObject instanceof EPackage ? ((EPackage) eObject).getESubpackages().iterator() : Collections
                        .<EObject> emptyList().iterator();
            }
        }; j.hasNext();) {
            Object content = j.next();
            if (content instanceof EPackage) {
                result.add((EPackage) content);
            }
        }
        return result;
    }

    protected String getURIPath() {
        return uriField.getText();
    }

}
