/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EcoreCreationWizardPage.java,v 1.7 2009/03/25 13:43:35 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.part;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;

/**
 * This page displays the new file information inputs.<br>
 * 
 * Creation : 26 Nov. 2007
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class EcoreCreationWizardPage extends WizardPage {

	private static final String BROWSE_TEXT = Messages.EcoreCreationWizardPage_Browse;

	private static final String DOMAIN_EXT = "ecore"; //$NON-NLS-1$

	private static final String DIAGRAM_EXT = "diag"; //$NON-NLS-1$

	/**
	 * Contains the resource that is initially selected when the wizard is
	 * opened. In the case of a file with an invalid extension, we store the
	 * container of the file. This variable is then used to load the
	 * corresponding data in the wizard.
	 */
	private IResource selectedResource;

	// SWT objects
	private Button existingModelBt;

	private Button newModelBt;

	private Group newModelGrp;

	private Text directoryFd;

	private Button directoryBt;

	private Text nameFd;

	private Group existingModelGrp;

	private Text modelFd;

	private Button modelBt;

	private TreeViewer viewer;

	private Button initializeBt;

	private ModifyListener validationListener = new ModifyListener() {

		public void modifyText(ModifyEvent e) {
			setPageComplete(validatePage());
		}
	};

	/**
	 * Constructor
	 * 
	 * @param pageName
	 *            the page title
	 * @param selection
	 *            the selected object
	 */
	public EcoreCreationWizardPage(String pageName, IStructuredSelection selection) {
		super(pageName);
		setPageComplete(false);

		Object sel = selection.getFirstElement();
		if (sel != null && sel instanceof IResource) {
			if (sel instanceof IFile) {
				// check whether the selected file as the expected extension
				if (DOMAIN_EXT.equals(((IFile) sel).getFileExtension())) {
					selectedResource = (IFile) sel;
				} else {
					selectedResource = ((IResource) sel).getParent();
				}
			} else {
				selectedResource = (IResource) sel;
			}
		} else {
			selectedResource = ResourcesPlugin.getWorkspace().getRoot();
		}
	}

	/**
	 * Creation of the wizard page
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite mainComp = new Composite(parent, SWT.NONE);
		mainComp.setLayout(new GridLayout());
		mainComp.setLayoutData(new GridData(GridData.FILL_BOTH));
		mainComp.setFont(parent.getFont());

		createDestinationGroup(mainComp);

		// Initialize widgets value
		loadData();

		// Add listeners
		hookListeners();

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(mainComp);

		setPageComplete(validatePage());
	}

	/**
	 * Create the Destination group
	 * 
	 * @param parent
	 *            the Composite
	 */
	protected void createDestinationGroup(Composite parent) {
		// Group activated when the user choose to create a new domain file
		newModelBt = new Button(parent, SWT.RADIO);
		newModelBt.setText(Messages.EcoreCreationWizardPage_CreateNewModel);
		newModelBt.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		createNewModelGroup(parent);

		// Group activated when the user choose to create from an existing
		// domain file
		existingModelBt = new Button(parent, SWT.RADIO);
		existingModelBt.setText(Messages.EcoreCreationWizardPage_CreateFromExistingModel);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.verticalIndent = 20;
		existingModelBt.setLayoutData(gd);

		createExistingModelGroup(parent);
	}

	private void createNewModelGroup(Composite parent) {
		newModelGrp = new Group(parent, SWT.NONE);
		newModelGrp.setLayout(new GridLayout(3, false));
		newModelGrp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// The destination directory
		Label directoryLbl = new Label(newModelGrp, SWT.NONE);
		directoryLbl.setText(Messages.EcoreCreationWizardPage_Directory);

		directoryFd = new Text(newModelGrp, SWT.BORDER);
		directoryFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		directoryFd.setEnabled(false);

		directoryBt = new Button(newModelGrp, SWT.PUSH);
		directoryBt.setText(BROWSE_TEXT);

		// The new name of the domain file to create
		Label nameLbl = new Label(newModelGrp, SWT.NONE);
		nameLbl.setText(Messages.EcoreCreationWizardPage_DomainFileName);

		nameFd = new Text(newModelGrp, SWT.BORDER);
		GridData layoutNameFd = new GridData(GridData.FILL_HORIZONTAL);
		layoutNameFd.horizontalSpan = 2;
		nameFd.setLayoutData(layoutNameFd);
	}

	private void createExistingModelGroup(Composite parent) {
		existingModelGrp = new Group(parent, SWT.NONE);
		existingModelGrp.setLayout(new GridLayout(3, false));
		existingModelGrp.setLayoutData(new GridData(GridData.FILL_BOTH));

		// Selection of the existing domain file
		Label modelLbl = new Label(existingModelGrp, SWT.NONE);
		modelLbl.setText(Messages.EcoreCreationWizardPage_DomainModel);

		modelFd = new Text(existingModelGrp, SWT.BORDER);
		modelFd.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		modelFd.setEnabled(false);

		modelBt = new Button(existingModelGrp, SWT.PUSH);
		modelBt.setText(BROWSE_TEXT);

		// The TreeViewer in charge of rendering the domain model
		Label viewerLbl = new Label(existingModelGrp, SWT.NONE);
		viewerLbl.setText(Messages.EcoreCreationWizardPage_Select);

		viewer = new TreeViewer(existingModelGrp, SWT.SINGLE | SWT.BORDER);
		GridData gdViewer = new GridData(GridData.FILL_BOTH);
		gdViewer.horizontalSpan = 2;
		gdViewer.minimumHeight = 100;
		viewer.getTree().setLayoutData(gdViewer);

		initializeBt = new Button(existingModelGrp, SWT.CHECK);
		initializeBt.setText(Messages.EcoreCreationWizardPage_InitializeWithExistingElements);
		GridData gdInit = new GridData(GridData.FILL_HORIZONTAL);
		gdInit.horizontalSpan = 3;
		initializeBt.setLayoutData(gdInit);
	}

	/**
	 * Initialize widgets value
	 */
	private void loadData() {
		if (selectedResource instanceof IFile) {
			existingModelBt.setSelection(true);

			directoryFd.setText(selectedResource.getParent().getFullPath().toString());
			nameFd.setText(EcoreDiagramEditorUtil.getUniqueFileName(selectedResource.getParent().getFullPath(), "DefaultName", DOMAIN_EXT)); //$NON-NLS-1$
			modelFd.setText(selectedResource.getFullPath().toString());
			if (loadModelFile()) {
				existingModelBt.setFocus();
			}

			setNewModelGroupEnabled(false);
		} else {
			newModelBt.setSelection(true);

			directoryFd.setText(selectedResource.getFullPath().toString());
			nameFd.setText(EcoreDiagramEditorUtil.getUniqueFileName(selectedResource.getFullPath(), "DefaultName", DOMAIN_EXT)); //$NON-NLS-1$
			nameFd.setFocus();

			setExistingModelGroupEnabled(false);
		}

		initializeBt.setSelection(true);
	}
	
	private void setNewModelGroupEnabled(boolean enabled) {
		directoryBt.setEnabled(enabled);
		nameFd.setEnabled(enabled);
	}
	
	private void setExistingModelGroupEnabled(boolean enabled) {
		modelBt.setEnabled(enabled);
		viewer.getControl().setEnabled(enabled);
		initializeBt.setEnabled(enabled);
	}

	/**
	 * Add the listeners to the Buttons and the Text widgets
	 */
	private void hookListeners() {
		directoryFd.addModifyListener(validationListener);
		nameFd.addModifyListener(validationListener);

		modelFd.addModifyListener(validationListener);

		// Button listeners
		directoryBt.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleDirectoryChoose();
			}
		});

		modelBt.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				handleModelChoose();
			}
		});

		existingModelBt.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (existingModelBt.getSelection()) {
					setNewModelGroupEnabled(false);
					setExistingModelGroupEnabled(true);
				}
				setPageComplete(validatePage());
			}
		});

		newModelBt.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (newModelBt.getSelection()) {
					setNewModelGroupEnabled(true);
					setExistingModelGroupEnabled(false);
				}
				setPageComplete(validatePage());
			}
		});

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				setPageComplete(validatePage());
			}
		});
	}

	/**
	 * Handle the directory choice button action
	 */
	protected void handleDirectoryChoose() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), (IContainer) ResourcesPlugin.getWorkspace().getRoot().findMember(directoryFd.getText()), false,
				Messages.EcoreCreationWizardPage_ChooseDestinationDirectory);
		if (dialog.open() == Window.OK) {
			Object[] results = dialog.getResult();
			if (results.length == 1 && results[0] instanceof IPath) {
				IPath newPath = (IPath) results[0];
				directoryFd.setText(newPath.toString());
			}
		}
	}

	/**
	 * Handle the model choice button action
	 */
	protected void handleModelChoose() {
		// The initial directory is always the Workspace
		String initialDirectory = ResourcesPlugin.getWorkspace().getRoot().getFullPath().toString();

		ResourceSelectionDialog dialog = new ResourceSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot().findMember(initialDirectory),
				Messages.EcoreCreationWizardPage_ChooseAnExistingDomainFile);
		if (dialog.open() == Window.OK) {
			Object[] results = dialog.getResult();
			if (results.length == 1 && results[0] instanceof IFile) {
				modelFd.setText(((IFile) results[0]).getFullPath().toString());

				// update the other widgets
				loadModelFile();
			}
		}
	}

	/**
	 * Load the domain file selected and update the associated widgets
	 * 
	 * @return true if the file was loaded successfully, return false otherwise.
	 */
	protected boolean loadModelFile() {
		URI uri = URI.createPlatformResourceURI(modelFd.getText(), true);
		Resource resource = getResourceSet().getResource(uri, true);

		if (resource != null) {
			ComposedAdapterFactory adapterFactory = getAdapterFactory();

			// Set the tree providers of the domain file contents
			AdapterFactoryContentProvider adapterContentProvider = new AdapterFactoryContentProvider(adapterFactory);
			adapterContentProvider.inputChanged(viewer, null, null);
			viewer.setContentProvider(new WizardContentProvider(adapterContentProvider));
			viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));

			viewer.setInput(resource.getContents());
			viewer.refresh();
			viewer.setSelection(new StructuredSelection(resource.getContents()), true);

			return true;
		}
		return false;
	}

	/**
	 * Subclasses must implement this method to return the
	 * ComposedAdapterFactory
	 * 
	 * @return the ComposedAdapterFactory
	 */
	public ComposedAdapterFactory getAdapterFactory() {
		List<AdapterFactory> factories = new ArrayList<AdapterFactory>();
		factories.add(new org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());

		return new ComposedAdapterFactory(factories);
	}

	/**
	 * Return the ResourceSet used to store the domain and diagram file. By
	 * default create a new ResourceSet.
	 * 
	 * @return ResourceSet
	 */
	protected ResourceSet getResourceSet() {
		return new ResourceSetImpl();
	}

	/**
	 * Check if the informations contained in the page are OK
	 * 
	 * @return true is OK
	 */
	protected boolean validatePage() {
		// erase all previous messages
		setMessage(null);
		setErrorMessage(null);

		if (isNewModel()) {
			return validateNewModelGroup();
		} else {
			return validateExistingModel();
		}
	}

	/**
	 * Validate the group if the user has chosen to create a new diagram/domain
	 * files
	 * 
	 * @return <code>true</code> if data is valid
	 */
	private boolean validateNewModelGroup() {
		IContainer container = getSelectedIContainer();
		if (container == null || container instanceof IWorkspaceRoot) {
			setErrorMessage(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizardPage_UnvalidDestinationContainer);
			return false;
		}

		if (getFileName() == null || "".equals(getFileName())) { //$NON-NLS-1$
			setErrorMessage(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizardPage_DomainFileNotEmpty);
			return false;
		} else if (!getFileName().endsWith("." + DOMAIN_EXT)) { //$NON-NLS-1$
			setErrorMessage(NLS.bind(Messages.EcoreCreationWizardPageExtensionError, DOMAIN_EXT));
			return false;
		} else {
			validateExistingFiles();
		}

		return true;
	}

	/**
	 * Check if the created files does not already exist
	 */
	private void validateExistingFiles() {
		if (modelFileExist()) {
			if (diagramFileExist()) {
				setMessage(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizardPage_FilesAlreadyExist, IMessageProvider.WARNING);
			} else {
				setMessage(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizardPage_DomainFileAlreadyExists, IMessageProvider.WARNING);
			}
		} else if (diagramFileExist()) {
			setMessage(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizardPage_DiagramFileAlreadyExists, IMessageProvider.WARNING);
		}
	}

	private boolean modelFileExist() {
		return isNewModel() ? ResourcesPlugin.getWorkspace().getRoot().findMember(directoryFd.getText() + File.separator + nameFd.getText()) != null : ResourcesPlugin.getWorkspace().getRoot()
				.findMember(modelFd.getText()) != null;
	}

	private boolean diagramFileExist() {
		return isNewModel() ? ResourcesPlugin.getWorkspace().getRoot().findMember(directoryFd.getText().concat(File.separator).concat(nameFd.getText()).concat(DIAGRAM_EXT)) != null : ResourcesPlugin
				.getWorkspace().getRoot().findMember(modelFd.getText().concat(DIAGRAM_EXT)) != null;
	}

	/**
	 * Validate the group if the user has chosen to create a new diagram file
	 * from an existing domain file
	 * 
	 * @return <code>true</code> if data is valid
	 */
	private boolean validateExistingModel() {
		// the user has chosen an existing domain file
		if (modelFd.getText() == null || "".equals(modelFd.getText())) { //$NON-NLS-1$
			setErrorMessage(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizardPage_ChooseExistingDomainFile);
			return false;
		}

		if (!DOMAIN_EXT.equals(((IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(modelFd.getText())).getFileExtension())) {
			setErrorMessage(NLS.bind(Messages.EcoreCreationWizardPageExtensionError, DOMAIN_EXT));
			return false;
		}

		if (diagramFileExist()) {
			setMessage(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizardPage_DiagramFileAlreadyExists, IMessageProvider.WARNING);
		}

		// Check whether the selected domain element is an EPackage
		if (!(getDiagramEObject() instanceof EPackage)) {
			setErrorMessage(org.eclipse.emf.ecoretools.diagram.Messages.EcoreCreationWizardPage_ChooseAnEPackageElement);
			return false;
		}

		return true;
	}

	/**
	 * Returns the selected destination container
	 * 
	 * @return the selected container
	 */
	public IContainer getSelectedIContainer() {
		if (isNewModel()) {
			return (IContainer) ResourcesPlugin.getWorkspace().getRoot().findMember(directoryFd.getText());
		} else {
			return ((IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(modelFd.getText())).getParent();
		}
	}

	/**
	 * Returns the selected domain file name (including file extension)
	 * 
	 * @return the domain file name. Returns null if no domain file name is set.
	 */
	public String getFileName() {
		if (isNewModel()) {
			if (nameFd != null && !nameFd.isDisposed()) {
				return nameFd.getText();
			}
		} else {
			if (modelFd != null && !modelFd.isDisposed()) {
				IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(modelFd.getText());
				return resource.getName();
			}
		}
		return null;
	}

	/**
	 * Returns the selected EObject that will be associated with the diagrams
	 * file. If no object is selected, returns the rootEObject of the domain
	 * model
	 * 
	 * @return the selected EObject or null if the viewer input is not already
	 *         set
	 */
	public EObject getDiagramEObject() {
		if (((IStructuredSelection) viewer.getSelection()).getFirstElement() == null) {
			if (viewer.getInput() != null) {
				return (EObject) ((EList<?>) viewer.getInput()).get(0);
			} else {
				return null;
			}
		} else {
			return (EObject) AdapterFactoryEditingDomain.unwrap(((IStructuredSelection) viewer.getSelection()).getFirstElement());
		}
	}

	/**
	 * Subclasses must implement this method to return the editorID on which the
	 * templates should be filtered
	 * 
	 * @return the string that represent an editorID
	 */
	public String getEditorID() {
		return "org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditorID"; //$NON-NLS-1$
	}

	/**
	 * Return the domain model URI
	 * 
	 * @return URI
	 */
	public URI getDomainModelURI() {
		if (isNewModel()) {
			return URI.createPlatformResourceURI(directoryFd.getText().concat(File.separator).concat(getFileName()), false);
		}
		return URI.createPlatformResourceURI(modelFd.getText(), false);
	}

	/**
	 * Return the diagram model URI
	 * 
	 * @return URI
	 */
	public URI getDiagramModelURI() {
		if (isNewModel()) {
			return URI.createPlatformResourceURI(directoryFd.getText().concat(File.separator).concat(getFileName()).concat(DIAGRAM_EXT), false);
		}
		return URI.createPlatformResourceURI(modelFd.getText().concat(DIAGRAM_EXT), false);
	}

	/**
	 * Return the choice of creation made by the user
	 * 
	 * @return true if the domain file is not created yet
	 */
	public boolean isNewModel() {
		return newModelBt.getSelection();
	}

	/**
	 * Returns if the diagram must be initialized with domain model objects
	 * 
	 * @return <code>true</code> if diagram must be initialized
	 */
	public boolean isInitialized() {
		return initializeBt.getSelection();
	}

	/**
	 * This Content Provider displays contents of domain model and its
	 * rootEObject. For the domain model, this provider delegates contents
	 * computing to the model content provider. <br>
	 * 
	 * Creation : 26 Nov. 2007
	 * 
	 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques
	 *         LESCOT</a>
	 */
	public static class WizardContentProvider implements ITreeContentProvider {

		private static final Object[] NO_CHILDREN = new Object[0];

		private ITreeContentProvider delegatedModelProvider;

		/**
		 * Constructor
		 * 
		 * @param delegatedProvider
		 *            the delegated content provider
		 */
		public WizardContentProvider(ITreeContentProvider delegatedProvider) {
			delegatedModelProvider = delegatedProvider;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(Object parentElement) {
			// Return the edited domain model as root element
			if (parentElement instanceof List) {
				return new Object[] { ((List<?>) parentElement).get(0) };
			}

			// For the domain model objects, retrieves model children and merges
			// result with rootEObject associated with this element
			if (parentElement instanceof IWrapperItemProvider || parentElement instanceof FeatureMap.Entry || parentElement instanceof EObject) {
				// Model children
				List<Object> children = new ArrayList<Object>();
				Object[] modelChildren = delegatedModelProvider.getChildren(AdapterFactoryEditingDomain.unwrap(parentElement));
				for (int i = 0; i < modelChildren.length; i++) {
					children.add(modelChildren[i]);
				}

				return children.toArray(new Object[children.size()]);
			}

			return NO_CHILDREN;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		public Object getParent(Object element) {
			// Delegates
			if (element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject) {
				return delegatedModelProvider.getParent(AdapterFactoryEditingDomain.unwrap(element));
			}

			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(Object element) {
			if (element instanceof IWrapperItemProvider || element instanceof FeatureMap.Entry || element instanceof EObject) {
				return getChildren(AdapterFactoryEditingDomain.unwrap(element)).length > 0;
			}

			return false;
		}

		/**
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
			// Do nothing
		}

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
		 *      java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// Do nothing
		}

	}

}
