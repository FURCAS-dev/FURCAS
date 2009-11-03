package com.sap.mi.fwk.dcfwk.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import com.sap.ide.dii05.lib.api.util.DiiResourceService;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.ui.api.typefw.DiiNewDcService;
import com.sap.ide.dii05.ui.api.typefw.IGenericNewDcWizard;
import com.sap.ide.dii05.ui.api.typefw.IGenericNewDcWizardData;
import com.sap.ide.dii05.ui.api.typefw.ITypeSpecificNewDcWizard;
import com.sap.mi.fwk.dcfwk.BasicMoinDcType;
import com.sap.mi.fwk.dcfwk.IMoinDcType;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.sap.mi.fwk.dcfwk.internal.DcFwkPlugin;
import com.sap.mi.fwk.dcfwk.internal.ui.NewMoinDcProjectPropertiesPage;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Implementation of a DC wizard for Moin DC types.
 * <p/>
 *
 * Clients may instantiate or just use the default behavior of
 * {@link BasicMoinDcType}.
 *
 * @author d031150
 */
public final class NewMoinDcWizardDelegate extends Wizard implements ITypeSpecificNewDcWizard {

	private IGenericNewDcWizardData mWizardData;
	private final IMoinDcType mDcType;
	private NewMoinDcProjectPropertiesPage mPropertiesPage;
	private IDevelopmentComponent mDc;
	private IProject mProject;

	/**
	 * Creates a wizard delegate
	 *
	 * @param outerWizard
	 *            the enframing DC wizard
	 * @param moinDcType
	 *            the DC type implementation
	 */
	public NewMoinDcWizardDelegate(IGenericNewDcWizard outerWizard, IMoinDcType moinDcType) {
		mDcType = moinDcType;
		setContainer(outerWizard.getContainer());
		setWindowTitle(outerWizard.getWindowTitle());
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		// need to have a fresh options instance to not interfere with previous
		// settings from earlier DC creation runs
		MoinDcOptions options = MoinProject.getOptions(mDcType, null, true);
		mPropertiesPage = new NewMoinDcProjectPropertiesPage(mDcType, options);
		addPage(mPropertiesPage);
	}

	@Override
	public final boolean performFinish() {
		// Need to enclose this in a workspace runnable in order to
		// prevent parallel operations, e.g. builders, to run before
		// the project creation is completed.
		IRunnableWithProgress createOp = new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				createDc(mWizardData, monitor);
				if (monitor.isCanceled()) {
					throw new OperationCanceledException();
				}
			}

		};

		IRunnableWithProgress initOp = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				try {
					MoinProject.initDc(mDc, mProject, mDcType, mPropertiesPage.getOptions(), true, monitor);
					if (monitor.isCanceled()) {
						throw new InterruptedException();
					}
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				}
			}
		};

		IWizardContainer container = getContainer();
		try {
			// Cancelable is false to avoid partially-created projects.
			// Exception handling, however considers cancel exceptions.
			container.run(true, false, createOp);
			container.run(true, false, initOp);
		} catch (InterruptedException e) { // $JL-EXC$
			return false;
		} catch (InvocationTargetException e) { // $JL-EXC$
			Throwable cause = e.getCause();
			if (cause instanceof CoreException) {
				IStatus status = ((CoreException) cause).getStatus();
				ExtendedMessageDialog.showError(container.getShell(), "Internal Error", status.getMessage(), null, //$NON-NLS-1$
						new String[] { IDialogConstants.OK_LABEL }, status);
			} else {
				ExtendedMessageDialog.showError(container.getShell(), "Internal Error", cause.getMessage(), null, //$NON-NLS-1$
						new String[] { IDialogConstants.OK_LABEL }, cause instanceof Exception ? (Exception) cause
								: new Exception(cause));
			}
			return false;
		}

		return true;
	}

	public void update(IGenericNewDcWizardData data) {
		mWizardData = data;
	}

	protected void createDc(IGenericNewDcWizardData data, IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}
		// CSN 0003054154/2008: Do not set a task name for the main monitor
		// since that name would be prepended to each sub task name; this will
		// lead to too long task names and bear no additional and relevant
		// information
		monitor.beginTask("", 100); //$NON-NLS-1$

		IProjectDescription projectDescription = data.getProjectDescription();

		// Create a new project including folder structure
		mProject = MoinProject.createProject(projectDescription, mDcType, new SubProgressMonitor(monitor, 33,
				SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		// Update project with development component stuff
		IStatus status = DiiNewDcService.createNewDcForProject(mProject, data, new SubProgressMonitor(monitor, 33,
				SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
		if (status.getSeverity() == IStatus.CANCEL || monitor.isCanceled()) {
			// We do not try to delete the project on cancel since outer wizard
			// most probably cannot cope with the project being deleted again.
			throw new OperationCanceledException();
		} else if (!status.isOK()) {
			mProject.delete(true, monitor);
			mProject = null;
			throw new CoreException(status);
		}

		mDc = DiiResourceService.getDevelopmentComponent(mProject);
		if (mDc == null) {
			Exception e = new Exception("Could not get IDevelopmentComponent for project " + mProject.getName()); //$NON-NLS-1$
			status = new Status(IStatus.ERROR, DcFwkPlugin.PLUGIN_ID, 0, e.getMessage(), e);
			throw new CoreException(status);
		}

		MoinProject.configureDc(mDc, mDcType, mPropertiesPage.getOptions(), new SubProgressMonitor(monitor, 33,
				SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK), data.getChangeListProvider());

		monitor.done();
	}

}