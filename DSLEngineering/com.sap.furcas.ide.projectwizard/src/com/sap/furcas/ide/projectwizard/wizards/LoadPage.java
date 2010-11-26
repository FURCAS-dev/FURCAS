package com.sap.furcas.ide.projectwizard.wizards;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.ecore.xmi.XMLResource;
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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sap.furcas.ide.projectwizard.util.ProjectInfo;

/* 
 * This wizardpage is displayed when the user chooses to import some kind of existing MetaModel into his
 * Metamodelproject.
 * */
public class LoadPage extends WizardPage {
    public FurcasWizard wizard;
    public Text uriField;
    public Label wrongType;
    ProjectInfo pi;
    public EPackage eP;
    ClassChooserPage cCP;

    protected LoadPage(String pageName, FurcasWizard wiz, ProjectInfo pi) {
        super(pageName);
        this.pi = pi;
        wizard = wiz;
        setTitle("Uh oh");
        setDescription("Not fully implemented yet. No effect until now. Please add the desired metamodel manually.");
    }

    @Override
    public void createControl(Composite parent) {
        final Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 3;
        Label label = new Label(container, SWT.NULL);
        label.setText("Resource URIs:");

        Button button1 = new Button(container, SWT.PUSH);
        button1.setText("Browse Registered Packages...");
        button1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                pi.setFromWorkspace(false);
                RegisteredPackageDialog registeredPackageDialog = new RegisteredPackageDialog(getShell());
                registeredPackageDialog.open();
                Object[] result = registeredPackageDialog.getResult();
                if (result != null) {
                    List<?> nsURIs = Arrays.asList(result);
                    String nsURI = nsURIs.get(0).toString();
                    pi.setNsURI(nsURI);
                    if (registeredPackageDialog.isDevelopmentTimeVersion()) {
                        ResourceSet resourceSet = new ResourceSetImpl();
                        resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
                        Map<String, URI> ePackageNsURItoGenModelLocationMap = EcorePlugin.getEPackageNsURIToGenModelLocationMap();
                        for (int i = 0, length = result.length; i < length; i++) {
                            URI location = ePackageNsURItoGenModelLocationMap.get(result[i]);
                            Resource resource = resourceSet.getResource(location, true);
                            EcoreUtil.resolveAll(resource);
                        }
                        for (Resource resource : resourceSet.getResources()) {
                            for (EPackage ePackage : getAllPackages(resource)) {
                                if (nsURIs.contains(ePackage.getNsURI())) {
                                    eP = ePackage;
                                    uriField.setText(resource.getURI().toString());
                                    break;
                                }
                            }
                        }
                    } else {
                        eP = (EPackage) result[0];
                        uriField.setText(result[0].toString());
                    }
                }
            }

        });

        Button button3 = new Button(container, SWT.PUSH);
        button3.setText("Browse Workspace...");
        button3.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                pi.setFromWorkspace(true);
                IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), "Choose Metamodel",
                        "Select the desired Metamodel an click OK.", false, null, null);
                if (files.length > 0) {
                    IProject mMproject = files[0].getProject();
                    pi.setMmProject(mMproject.getName());
                    eP = fileToEPack(files[0]);
                    uriField.setText(URI.createPlatformResourceURI(files[0].getFullPath().toString(), true).toString());
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
        gd.verticalAlignment = GridData.FILL;
        gd.horizontalSpan = 4;
        gd.verticalSpan = 2;
        gd.grabExcessHorizontalSpace = true;
        wrongType = new Label(container, SWT.WRAP);
        wrongType.setText("The File you choose must be a .ecore file. \nWhitespaces before and after URIs will be deleted.");
        wrongType.setLayoutData(gd);
        wrongType.setVisible(false);
        setErrorMessage(null);
        setControl(container);

    }

    protected EPackage fileToEPack(IFile iFile) {
        ResourceSet resSet = new ResourceSetImpl();
        resSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
        URI fileURI = URI.createPlatformResourceURI("/" + iFile.getProject().getName() + "/" + iFile.getProjectRelativePath().toString(), true);
        Resource resource = resSet.createResource(fileURI);
        Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_ENCODING, "UTF-8");
        try {
            resource.load(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        EList<EObject> sd = resource.getContents();
        for (EObject object : sd){
            if(object instanceof EPackage){
                EPackage ePack = (EPackage) object;
                pi.setNsURI(ePack.getNsURI());
                return ePack;
            }
        }
        return null;
    }

    protected void dialogChanged() {
        String text = uriField.getText();
        text = text.trim();
        if (!text.endsWith(".ecore")) {
            wrongType.setVisible(true);
            setPageComplete(false);
        } else {
            wrongType.setVisible(false);
            setPageComplete(true);
            getNextPage();
        }
        if (!uriField.getText().matches(text))
            uriField.setText(text);
        pi.setURIPath(uriField.getText());
        wizard.getWiz().getContainer().updateButtons();
        if (getNextPage() != null){
            getNextPage().setTreeInput(eP);
        }
    }

    @Override
    public ClassChooserPage getNextPage() {
        if (cCP == null) {
            cCP = new ClassChooserPage("cCP",wizard.page.getProjectInfo());
            cCP.setPageComplete(false);
            wizard.addPage(cCP);
        }
        if (cCP.geteP() == null)
            cCP.seteP(eP);
        
        
        return cCP;
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
