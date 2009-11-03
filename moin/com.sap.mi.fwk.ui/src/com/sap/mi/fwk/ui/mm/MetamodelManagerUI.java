package com.sap.mi.fwk.ui.mm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.IWorkingSetManager;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.mi.fwk.ui.internal.mm.MmElementFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentStatus;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * UI related services for Moin metamodels
 * 
 * @author d031150
 */
public final class MetamodelManagerUI {

	/**
	 * The id of the "Deployed Metamodels" view
	 * 
	 * @see #showDeploymentView()
	 */
	public static final String ID_DEPLOY_VIEW = "com.sap.mi.views.MmDeployment"; //$NON-NLS-1$

	/**
	 * The id of the metamodels working set
	 */
	public static final String ID_METAMODEL_WORKING_SET = "com.sap.mi.fwk.ui.metamodelWorkingSet"; //$NON-NLS-1$

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_DEPLOYTOOL);
	private static MetamodelManagerUI sInstance;

	/**
	 * @return the metamodel manager
	 */
	public static MetamodelManager getMetamodelManager() {
		return MetamodelManager.getInstance();
	}

	/**
	 * @return the instance
	 */
	public static synchronized MetamodelManagerUI getInstance() {
		if (sInstance == null) {
			sInstance = new MetamodelManagerUI();
		}
		return sInstance;
	}

	/**
	 * Shows the deployment view in the active page and gives focus to it. Must
	 * be called from the UI thread.
	 * 
	 * @return the view part or <code>null</code> in case of an error
	 * 
	 * @see #ID_DEPLOY_VIEW
	 */
	public IViewPart showDeploymentView() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			IWorkbenchPage page = window.getActivePage();
			if (page != null) {
				try {
					return page.showView(ID_DEPLOY_VIEW);
				} catch (PartInitException e) {
					sTracer.error("Unable to open view " + ID_DEPLOY_VIEW, e); //$NON-NLS-1$
				}
			}
		}
		return null;
	}

	/**
	 * @return all visible metamodel working sets
	 */
	public Collection<IWorkingSet> getMetamodelWorkingSets() {
		IWorkingSet[] sets = PlatformUI.getWorkbench().getWorkingSetManager().getWorkingSets();
		List<IWorkingSet> result = new ArrayList<IWorkingSet>(sets.length);
		for (IWorkingSet set : sets) {
			if (isMetamodelWorkingSet(set)) {
				result.add(set);
			}
		}
		return Collections.unmodifiableCollection(result);
	}

	/**
	 * Adds the given metamodels to the given working set. Has no effect if the
	 * metamodels are already contained in the set.
	 * 
	 * @param metamodels
	 *            the metamodels to add
	 * @param workingSet
	 *            the working set to modify
	 * @throws RuntimeException
	 *             if the working set is none for metamodels
	 */
	public void addToMetamodelWorkingSet(Collection<MmDeploymentInfo> metamodels, IWorkingSet workingSet) {
		if (!isMetamodelWorkingSet(workingSet)) {
			throw new IllegalArgumentException("No metamodel working set: " + workingSet.getId()); //$NON-NLS-1$
		}
		if (metamodels.isEmpty()) {
			return;
		}

		Set<IAdaptable> elements = new LinkedHashSet<IAdaptable>(Arrays.asList(workingSet.getElements()));
		for (MmDeploymentInfo metamodel : metamodels) {
			IAdaptable adaptable = MmElementFactory.createMmAdaptable(metamodel.getContainerName());
			elements.add(adaptable);
		}
		workingSet.setElements(elements.toArray(new IAdaptable[elements.size()]));
	}

	/**
	 * Removes the given metamodels from the given working set. Has no effect if
	 * the metamodels are not contained in the set.
	 * 
	 * @param metamodels
	 *            the metamodels to remove
	 * @param workingSet
	 *            the working set to modify
	 * @throws RuntimeException
	 *             if the working set is none for metamodels
	 */
	public void removeFromMetamodelWorkingSet(Collection<MmDeploymentInfo> metamodels, IWorkingSet workingSet) {
		if (!isMetamodelWorkingSet(workingSet)) {
			throw new IllegalArgumentException("No metamodel working set: " + workingSet.getId()); //$NON-NLS-1$
		}
		if (workingSet.isEmpty()) {
			return;
		}

		Set<IAdaptable> elements = new LinkedHashSet<IAdaptable>(Arrays.asList(workingSet.getElements()));
		for (MmDeploymentInfo metamodel : metamodels) {
			IAdaptable adaptable = MmElementFactory.createMmAdaptable(metamodel.getContainerName());
			elements.remove(adaptable);
		}
		workingSet.setElements(elements.toArray(new IAdaptable[elements.size()]));
	}

	/**
	 * Creates a new working set containing the given metamodels. Its name will
	 * automatically be chosen based on the metamodel labels.
	 * 
	 * @param metamodels
	 *            the metamodels to be contained in the set to create
	 * @return the new set
	 */
	public IWorkingSet createMetamodelWorkingSet(Collection<MmDeploymentInfo> metamodels) {
		Set<IAdaptable> elements = new LinkedHashSet<IAdaptable>(metamodels.size());
		for (MmDeploymentInfo metamodel : metamodels) {
			IAdaptable adaptable = MmElementFactory.createMmAdaptable(metamodel.getContainerName());
			elements.add(adaptable);
		}

		IWorkingSetManager wsManager = PlatformUI.getWorkbench().getWorkingSetManager();
		String nameBase;
		if (metamodels.isEmpty()) {
			nameBase = MiFwkUiMessages.MetamodelManager_newWorkingSet_name;
		} else { // choose label of first metamodel according to visual order
			List<MmDeploymentInfo> mms = new ArrayList<MmDeploymentInfo>(metamodels);
			Collections.sort(mms, new MmLabelSorter());
			nameBase = mms.get(0).getLabel();
		}
		String name = getUniqueWsName(nameBase);
		IWorkingSet newSet = wsManager.createWorkingSet(name, elements.toArray(new IAdaptable[elements.size()]));
		newSet.setId(ID_METAMODEL_WORKING_SET);
		wsManager.addWorkingSet(newSet);
		return newSet;
	}

	/**
	 * Returns an information text describing the status of the given metamodel.
	 * It contains an error description in case of a deployment failure.
	 * 
	 * @param metamodel
	 *            the metamodel to get the status text for
	 * @return the text
	 */
	public String getStatusInfo(MmDeploymentInfo metamodel) {
		if (metamodel == null) {
			throw new IllegalArgumentException("Metamodel must not be null"); //$NON-NLS-1$
		}
		MmDeploymentStatus status = metamodel.getStatus();
		StringBuilder statusText;
		switch (status) {
			case DEPLOYED:
				statusText = new StringBuilder(MiFwkUiMessages.MetamodelManager_status_deployed);
				break;
			case NOT_DEPLOYED:
				statusText = new StringBuilder(MiFwkUiMessages.MetamodelManager_status_notDeployed);
				break;
			case UNKNOWN:
				statusText = new StringBuilder(MiFwkUiMessages.MetamodelManager_status_unknown);
				break;
			case VERSION_DIFFER:
				statusText = new StringBuilder(MiFwkUiMessages.MetamodelManager_status_versionConflict);
				break;
			case ERROR_NOT_DEPLOYABLE:
				statusText = new StringBuilder(MiFwkUiMessages.MetamodelManager_status_notDeployable);
				break;
			default:
				statusText = new StringBuilder(status.toString());
				break;
		}
		String msg = metamodel.getLastReportedErrorMessage();
		if (msg != null) {
			statusText.append(": ").append(msg); //$NON-NLS-1$
		}
		return statusText.toString();
	}

	private String getUniqueWsName(String nameBase) {
		Collection<IWorkingSet> sets = getMetamodelWorkingSets();
		List<String> names = new ArrayList<String>(sets.size());
		for (IWorkingSet set : sets) {
			names.add(set.getName());
		}
		int count = 0;
		String name = nameBase;
		while (names.contains(name)) {
			name = nameBase + count++;
		}
		return name;
	}

	private boolean isMetamodelWorkingSet(IWorkingSet workingSet) {
		return ID_METAMODEL_WORKING_SET.equals(workingSet.getId());
	}

	private MetamodelManagerUI() {
	}

	private static final class MmLabelSorter implements Comparator<MmDeploymentInfo> {
		public int compare(MmDeploymentInfo o1, MmDeploymentInfo o2) {
			if (o1.equals(o2)) {
				return 0;
			}
			return o1.getLabel().compareToIgnoreCase(o2.getLabel());
		}
	}

}
