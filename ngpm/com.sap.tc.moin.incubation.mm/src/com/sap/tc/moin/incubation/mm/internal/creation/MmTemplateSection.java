package com.sap.tc.moin.incubation.mm.internal.creation;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.ResourceBundle;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.OptionTemplateSection;
import org.eclipse.pde.ui.templates.PluginReference;
import org.eclipse.pde.ui.templates.StringOption;
import org.eclipse.pde.ui.templates.TemplateOption;
import org.osgi.framework.Bundle;

import com.sap.mi.fwk.ModelManager;
import com.sap.tc.moin.incubation.mm.internal.Activator;
import com.sap.tc.moin.incubation.mm.internal.resource.MmBuilder;

public class MmTemplateSection extends OptionTemplateSection {

	private static final String NATURE_MM = "com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelNature";
	private static final String[] NATURES = new String[] { ModelManager.MOIN_NATURE, NATURE_MM, MmBuilder.NATURE_ID };
	private static final String[] BUILDERS = new String[] {"com.sap.mi.fwk.MoinConstraintChecker"};
	private static final String EXTPOINT_METAMODELS = "com.sap.tc.moin.runtime.MoinMetaModel";

	private static final String KEY_MM_NAME = "containerName";
	private static final String KEY_MM_DESCRIPTION = "description";
	private StringOption optionName;
	private StringOption optionDesc;
	private boolean changed;

	public MmTemplateSection() {
		setPageCount(1);
		createOptions();
	}

	@Override
	public String getSectionId() {
		return "metamodelPlugin";
	}

	private void createOptions() {
		optionName = (StringOption) addOption(KEY_MM_NAME, "&Container name", null, 0);
		optionName.setRequired(true);
		optionDesc = (StringOption) addOption(KEY_MM_DESCRIPTION, "&Description", null, 0);
		optionDesc.setRequired(true);
	}

	@Override
	public void addPages(Wizard wizard) {
		WizardPage page = createPage(0, null);
		page.setTitle("Metamodel Plugin");
		page.setDescription("Enter the metamodel properties");
		wizard.addPage(page);
		markPagesAdded();
	}

	@Override
	public boolean isDependentOnParentWizard() {
		return true;
	}

	@Override
	protected void initializeFields(IFieldData data) {
		if (changed) {
			return;
		}
		// In a new project wizard, we don't know this yet - the
		// model has not been created
		optionName.setValue(MmBuilder.getContainerName(data.getId(), data.getProvider()));
		optionDesc.setValue(data.getName());
	}

	@Override
	public void initializeFields(IPluginModelBase model) {
		if (changed) {
			return;
		}
		// In the new extension wizard, the model exists so
		// we can initialize directly from it
		IPluginBase plugin = model.getPluginBase();
		optionName.setValue(MmBuilder.getContainerName(plugin.getId(), plugin.getProviderName()));
		optionDesc.setValue(plugin.getName());
	}

	@Override
	public void validateOptions(TemplateOption source) {
		changed = true;
		WizardPage page = getPage(0);

		String text = (String) optionName.getValue();
		String[] parts = text.split("/");
		if (parts.length != 2 || parts[0].length() == 0 || text.endsWith("/")) {
			page.setPageComplete(false);
			page.setErrorMessage(NLS.bind("{0} must follow the pattern ''vendor/name''", optionName.getMessageLabel()));
			return;
		}
		super.validateOptions(source);
	}

	public String getUsedExtensionPoint() {
		return EXTPOINT_METAMODELS;
	}

	@Override
	public IPluginReference[] getDependencies(String schemaVersion) {
		IPluginReference[] dep = new IPluginReference[2];
		dep[0] = new PluginReference("com.sap.tc.moin.ide.facade", null, 0); //$NON-NLS-1$
		dep[1] = new PluginReference("com.sap.tc.moin.libraries.jmi.facade", null, 0); //$NON-NLS-1$
		return dep;
	}

	@Override
	protected void updateModel(IProgressMonitor monitor) throws CoreException {
		IPluginBase plugin = model.getPluginBase();
		String containerName = (String) optionName.getValue();
		String[] parts = containerName.split("/");
		String providerName = parts[0];
		String id = parts[1];

		if (!id.equals(plugin.getId())) {
			plugin.setId(id);
		}

		if (!providerName.equals(plugin.getProviderName())) {
			plugin.setProviderName(providerName);
		}

		String desc = optionDesc.getText();
		if (!desc.equals(plugin.getName())) {
			plugin.setName(desc);
		}

		IPluginExtension extension = createExtension(getUsedExtensionPoint(), true);
		IPluginModelFactory factory = model.getPluginFactory();

		IPluginElement mmElement = factory.createElement(extension);
		mmElement.setName("metamodel"); //$NON-NLS-1$
		mmElement.setAttribute("class", getMmPackageQualified(id, providerName) + ".MetamodelExtension"); //$NON-NLS-1$

		extension.add(mmElement);
		if (!extension.isInTheModel()) {
			plugin.add(extension);
		}
	}

	@Override
	public void execute(final IProject project, IPluginModelBase model, IProgressMonitor monitor) throws CoreException {
		super.execute(project, model, monitor);
		IProjectDescription description = project.getDescription();

		addNatures(description, NATURES, monitor);
		addBuilders(description, BUILDERS, monitor);

		project.setDescription(description, monitor);

		// FIXME Refresh from filesystem since currently plugin facility does
		// not process resource events
		Job job = new Job("Refreshing") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IStatus result = ModelManager.getInstance().refreshFromFileSystem(project, monitor);
				monitor.done();
				return result;
			}
		};
		job.setRule(project.getWorkspace().getRuleFactory().refreshRule(project));
		job.schedule();
	}

	public String[] getNewFiles() {
		return new String[0];
	}

	@Override
	protected ResourceBundle getPluginResourceBundle() {
		Bundle bundle = Platform.getBundle(Activator.ID);
		return Platform.getResourceBundle(bundle);
	}

	@Override
	protected URL getInstallURL() {
		return Activator.getDefault().getInstallURL();
	}

	private static void addBuilders(IProjectDescription description, String[] builders, IProgressMonitor monitor)
			throws CoreException {
		ICommand[] newCommands = new ICommand[builders.length];
		for (int i = 0; i < builders.length; i++) {
			newCommands[i] = description.newCommand();
			newCommands[i].setBuilderName(builders[i]);
		}

		ICommand[] prevCommands = description.getBuildSpec();
		ICommand[] allCommands = new ICommand[prevCommands.length + newCommands.length];
		System.arraycopy(newCommands, 0, allCommands, 0, newCommands.length);
		System.arraycopy(prevCommands, 0, allCommands, newCommands.length, prevCommands.length);
		description.setBuildSpec(allCommands);
	}

	private static void addNatures(IProjectDescription description, String[] natureIds, IProgressMonitor monitor)
			throws CoreException {
		String[] prevNatures = description.getNatureIds();
		String[] newNatures = new String[prevNatures.length + natureIds.length];
		System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		System.arraycopy(natureIds, 0, newNatures, prevNatures.length, natureIds.length);
		description.setNatureIds(newNatures);
	}

	private String getMmPackageQualified(String name, String vendor) {
		String bundleName = "com.sap.tc.moin.libraries.base"; //$NON-NLS-1$
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			throw new IllegalArgumentException("Bundle not found. Bundle name = " + //$NON-NLS-1$
					bundleName);
		}

		try {
			Class<?> classObject = bundle.loadClass("com.sap.tc.moin.repository.shared.util.Utilities");
			Method method = classObject.getMethod("getMMPackageQualified", String.class); //$NON-NLS-1$
			String result = (String) method.invoke(null, MmBuilder.getContainerName(name, vendor));
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
