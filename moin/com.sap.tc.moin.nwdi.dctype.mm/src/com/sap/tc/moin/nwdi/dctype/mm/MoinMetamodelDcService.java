package com.sap.tc.moin.nwdi.dctype.mm;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

public abstract class MoinMetamodelDcService {

	private static final Logger stracer = Logger.getLogger(MoinMetamodelDcService.class);

	/**
	 * @return whether the given project has the Moin metamodel nature, i.e. whether metamodel
	 *         content can be placed in the project. Returns <code>false</code>
	 *         for closed projects.
	 */
	public static boolean isMetamodelProject(IProject project) {
		if (project == null) {
			return false;
		}

		try {
			// Closed projects are unable to return their natures
			if (!project.isAccessible()) {
				return false;
			}
			boolean hasNature = project.hasNature(MoinMetaModelDcType.ID_NATURE);
			return hasNature;
		} catch (CoreException e) {
			stracer.log(Level.SEVERE, e.getMessage(), e);
			return false;
		}
	}
}
