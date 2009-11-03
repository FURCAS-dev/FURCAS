package com.sap.mi.fwk.internal;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.services.local.ErrorHandling;
import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.ide.MoinFactory;
import com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState;
import com.tssap.util.trace.TracerI;

/**
 * The framework plugin class
 * 
 * @author d031150
 */
public final class MiFwkPlugin extends Plugin {

	public static final String PLUGIN_ID = "com.sap.mi.fwk"; //$NON-NLS-1$
	public static final String EXT_POINT_ID_UIHOOK = PLUGIN_ID + ".uiHook"; //$NON-NLS-1$

	private static MiFwkPlugin sInstance;

	public MiFwkPlugin() {
		sInstance = this;
	}

	public static MiFwkPlugin getDefault() {
		return sInstance;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		ModelManager.shutDown();

		super.stop(context);
	}

	/**
	 * Checks whether the object is not <code>null</code> and alive
	 * 
	 * @throws RuntimeException
	 *             otherwise
	 */
	public static void assertObjectAlive(RefBaseObject object) {
		assertObjectNotNull(object);
		if (!((Partitionable) object).is___Alive()) {
			throw new IllegalArgumentException("Object must be alive"); //$NON-NLS-1$
		}
	}

	/**
	 * Checks whether the object is not <code>null</code>
	 * 
	 * @throws RuntimeException
	 *             otherwise
	 */
	public static void assertObjectNotNull(Object object) {
		if (object == null) {
			throw new IllegalArgumentException("Object must not be null"); //$NON-NLS-1$
		}
	}

	/**
	 * Checks whether the connection is not <code>null</code> and not closed
	 * 
	 * @throws RuntimeException
	 *             otherwise
	 */
	public static void assertConnectionAlive(Connection connection) {
		if (connection == null) {
			throw new IllegalArgumentException("Connection must not be null"); //$NON-NLS-1$
		}
		if (!connection.isAlive()) {
			throw new IllegalArgumentException("Connection must not be closed"); //$NON-NLS-1$
		}
	}

	/**
	 * Checks whether the project is not <code>null</code> and open
	 * 
	 * @throws RuntimeException
	 *             otherwise
	 */
	public static void assertProjectOpen(IProject project) {
		if (project == null) {
			throw new IllegalArgumentException("Project is null"); //$NON-NLS-1$
		}
		if (!project.isAccessible()) {
			throw new IllegalArgumentException("Project is not open: " + project.getName()); //$NON-NLS-1$
		}
	}

	/**
	 * Checks whether the project is not <code>null</code>, open and a Moin
	 * project
	 * 
	 * @throws RuntimeException
	 *             otherwise
	 */
	public static void assertMoinProjectOpen(IProject project) {
		assertProjectOpen(project);
		if (!ModelManager.getInstance().isMoinProject(project)) {
			throw new IllegalArgumentException("Project has no Moin nature: " + project.getName()); //$NON-NLS-1$
		}
	}

	public static void assertIsMoinRelevant(final IProject project, final ContainerInitializationState projectInitState) {
		if (ContainerInitializationState.NOT_MOIN_RELEVANT == projectInitState) {
			throw new IllegalArgumentException("Not a Moin project: " + project //$NON-NLS-1$
					+ ". This may happen during project creation, " //$NON-NLS-1$
					+ "check whether you can fail gracefully in this case."); //$NON-NLS-1$
		}
	}

	public static void logError(Throwable e, TracerI tracer) {
		logError(e.getMessage(), e, tracer);
	}

	public static void logError(String message, Throwable e, TracerI tracer) {
		ErrorHandling.logError(message, e, tracer, PLUGIN_ID);
	}

	public static IStatus createStatus(int severity, String message, Throwable exception) {
		return createStatus(severity, 0, message, exception);
	}

	public static IStatus createStatus(int severity, int code, String message, Throwable exception) {
		return ErrorHandling.createStatus(severity, code, message, exception, PLUGIN_ID);
	}

	/**
	 * @return the primary facility
	 */
	private static IdePrimaryFacility getIdePrimaryFacility() {
		Moin moin = MoinFactory.getMoinInstance();
		Collection<Facility> facilities = moin.getFacilities();
		for (Facility facility : facilities) {
			if (facility instanceof IdePrimaryFacility) {
				return (IdePrimaryFacility) facility;
			}
		}
		throw new IllegalStateException("Bad configuration: Primary Facility not found: " + moin); //$NON-NLS-1$
	}

	/**
	 * Returns the compound data area manager which dispatches to the correct
	 * facility.
	 */
	public static IdeCompoundDataAreaManager getIdeCompoundDataAreaManager() {
		Moin moin = MoinFactory.getMoinInstance();
		return (IdeCompoundDataAreaManager) moin.getCompoundDataAreaManager();
	}

	/**
	 * @return the resource identifier factory of the IDE facility
	 * 
	 * @see #getIdePrimaryFacility()
	 */
	// public static IdeResourceIdentifierFactory getIdeRiFactory() {
	// return (IdeResourceIdentifierFactory)
	// getIdePrimaryFacility().getRIFactory();
	// }
	public static ResourceIdentifierFactory getRiFactory() {
		return getIdePrimaryFacility().getRIFactory();
	}
}
