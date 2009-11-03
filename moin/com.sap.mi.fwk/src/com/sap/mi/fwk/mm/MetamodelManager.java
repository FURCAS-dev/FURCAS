package com.sap.mi.fwk.mm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentStatus;
import com.sap.tc.moin.repository.ide.metamodels.MoinDeploymentException;

/**
 * Facility to access and import Moin Metamodels
 * 
 * @author d031150
 */
public final class MetamodelManager {

	private static MetamodelManager sInstance;

	private static final String CONTAINER_NAME_DUMMY = ""; //$NON-NLS-1$
	private static final String CONTAINER_NAME_MOF = "sap.com/tc/moin/mof_1.4"; //$NON-NLS-1$

	/**
	 * @return the instance of this class
	 */
	public static synchronized MetamodelManager getInstance() {
		if (sInstance == null)
			sInstance = new MetamodelManager();
		return sInstance;
	}

	/**
	 * @return all metamodels that are currently deployed, i.e. installed.
	 * 
	 * @see #getDeployedMetamodel(String)
	 * @see #getImportedMetamodels()
	 */
	public Collection<MmDeploymentInfo> getDeployedMetamodels() {
		Collection<MmDeploymentInfo> metamodels = MoinFactory.getMmDeploymentManager().getMetaModelPluginList();
		return metamodels;
	}

	/**
	 * @return the metamodel with thegiven name or <code>null</code>
	 * 
	 * @see #getDeployedMetamodels()
	 */
	public MmDeploymentInfo getDeployedMetamodel(String metamodelContainerName) {
		Map<String, MmDeploymentInfo> metamodels = getMetamodelsByName(new String[] { metamodelContainerName }, false);
		if (metamodels.size() == 1)
			return metamodels.values().iterator().next();
		return null;
	}

	/**
	 * @return all metamodels that are imported and can be accessed by model
	 *         data
	 */
	public Collection<MmDeploymentInfo> getImportedMetamodels() {
		Collection<MmDeploymentInfo> metamodels = getDeployedMetamodels();
		List<MmDeploymentInfo> result = new ArrayList<MmDeploymentInfo>(metamodels.size());
		for (MmDeploymentInfo metamodel : metamodels) {
			if (MmDeploymentStatus.DEPLOYED == metamodel.getStatus())
				result.add(metamodel);
		}
		return Collections.unmodifiableCollection(result);
	}

	/**
	 * Returns whether the specified metamodels are all imported
	 * 
	 * @param metamodelContainerNames
	 *            the id of the metamodels, e.g.
	 *            <code>sap.com/tc/moin/webdynpro/webdynpro</code>
	 * @return <code>true</code> if all metamodels are imported
	 */
	// ATTENTION WITH API CHANGES!!! - Called via reflection from
	// com.sap.mi.fwk.test.service.internal.InvocationHelper
	public boolean isMetamodelImported(String... metamodelContainerNames) {
		if (metamodelContainerNames == null || metamodelContainerNames.length == 0)
			return false;
		Map<String, MmDeploymentInfo> mmInfos = getMetamodelsByName(metamodelContainerNames, false);
		Collection<MmDeploymentInfo> metamodels = mmInfos.values();
		for (MmDeploymentInfo mm : metamodels) {
			if (MmDeploymentStatus.DEPLOYED != mm.getStatus())
				return false;
		}

		Set<String> unknownIds = new HashSet<String>(Arrays.asList(metamodelContainerNames));
		unknownIds.removeAll(mmInfos.keySet());
		removeSpecialIds(unknownIds);
		// if there are still unknown ids remaining, return false
		if (unknownIds.size() > 0)
			return false;
		return true;
	}

	/**
	 * Imports the metamodels specified by their container name. If a metamodel
	 * is already imported, this has no effect.
	 * 
	 * @param metamodelContainerNames
	 *            the ids of the metamodels, e.g.
	 *            <code>sap.com/tc/moin/webdynpro/webdynpro</code>
	 * @param monitor
	 *            an optional progress monitor
	 * @throws MoinDeploymentException
	 *             if import fails, or the respective metamodel is not
	 *             importable or if the supplied metamodel names are unknown
	 *             (blank "" metamodelContainerNames are ignored)
	 * 
	 * @deprecated Explicit Metamodel import is no longer necessary - Metamodels
	 *             are always in state "imported" / "deployed" as long as the
	 *             corresponding metamodel plugin is properly defined. If this
	 *             needs to be checked, use
	 *             {@link #isMetamodelImported(String...)}.
	 */
	@Deprecated
	public void importMetamodels(IProgressMonitor monitor, String... metamodelContainerNames)
			throws MoinDeploymentException {
		// call is just to ensure invalid ids are detected
		getMetamodelsByName(metamodelContainerNames, true);
	}

	/**
	 * Imports all available metamodels. Failures are logged and reported as
	 * return value in form of a multi status. If a metamodel is already
	 * imported, this has no effect.
	 * 
	 * @param monitor
	 *            an optional progress monitor
	 * 
	 * @deprecated explicit Metamodel import is no longer necessary - Metamodels
	 *             are always in state "imported" / "deployed" as long as the
	 *             corresponding metamodel plugin is properly defined
	 */
	@Deprecated
	public IStatus importAllMetamodels(IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}

	/**
	 * Returns the metamodels with the specified container names
	 * 
	 * @param metamodelContainerNames
	 *            the ids of the metamodels, e.g.
	 *            <code>sap.com/tc/moin/webdynpro/webdynpro</code>
	 * @param failForUnknownIds
	 *            if <code>true</code>, an exception is thrown for any unknown
	 *            metamodel name
	 */
	private Map<String, MmDeploymentInfo> getMetamodelsByName(String[] metamodelContainerNames,
			boolean failForUnknownIds) throws MoinDeploymentException {
		Map<String, MmDeploymentInfo> result = new HashMap<String, MmDeploymentInfo>(metamodelContainerNames.length);
		Collection<MmDeploymentInfo> metamodels = getDeployedMetamodels();
		Set<String> ids = new HashSet<String>(Arrays.asList(metamodelContainerNames));
		for (MmDeploymentInfo metamodel : metamodels) {
			String name = metamodel.getContainerName();
			if (ids.contains(name))
				result.put(name, metamodel);
		}

		if (failForUnknownIds) {
			removeSpecialIds(ids).removeAll(result.keySet());
			if (!ids.isEmpty()) {
				throw new MoinDeploymentException("Unknown metamodels: " + ids, null); //$NON-NLS-1$
			}
		}
		return result;
	}

	private Set<String> removeSpecialIds(Set<String> ids) {
		// an empty string as id (generated by TG temporarily), is not treated
		// as an error
		ids.remove(CONTAINER_NAME_DUMMY);
		// also exclude MOF metamodel, which is there always there (passed in by
		// MOF tooling)
		ids.remove(CONTAINER_NAME_MOF);
		return ids;
	}

	private MetamodelManager() {
	}

}
