package com.sap.mi.gfw;

import com.sap.mi.gfw.dt.IDiagramTypeProvider;
import com.sap.mi.gfw.features.IFeatureProvider;
import com.sap.mi.gfw.internal.platform.PlatformRegistry;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.platform.IDiagramEditor;
import com.sap.mi.gfw.platform.IGFWExtensionManager;
import com.sap.mi.gfw.platform.IPlatformService;

/**
 * The Class GfwUtil.
 */
public class GfwUtil {

	/**
	 * The Constant METAMODEL_ID.
	 */
	public static final String METAMODEL_ID = "sap.com/com/sap/mi/gfw/mm"; //$NON-NLS-1$

	/**
	 * Gets the extension manager.
	 * 
	 * @return the extension manager
	 */
	public static IGFWExtensionManager getExtensionManager() {
		return PlatformRegistry.getInstance().getGFWExtensionManager();
	}

	/**
	 * Gets the platform service.
	 * 
	 * @return the platform service
	 */
	public static IPlatformService getPlatformService() {
		return PlatformRegistry.getInstance().getPlatformService();
	}

	/**
	 * Create an instance of a feature provider (and also the diagram type provider) without having a diagram editor open. This instance can
	 * be used for the generation of diagrams in the background. All features which do not expect an open editor can be reused.
	 * 
	 * @param diagram
	 *            The diagram on which the diagram type provider will work
	 * @param providerId
	 *            Id of the diagram type provider which should be used
	 * 
	 * @return the new feature provider instance
	 */
	public static IFeatureProvider createFeatureProvider(Diagram diagram) {
		IGFWExtensionManager em = getExtensionManager();
		String[] dtpExtensionIds = em.getDiagramTypeProviderExtensionIds(diagram.getDiagramTypeId());
		if (dtpExtensionIds != null && dtpExtensionIds.length > 0) {
			IDiagramTypeProvider dtp = createDiagramTypeProvider(diagram, dtpExtensionIds[0]);
			return dtp.getFeatureProvider();
		}
		return null;
	}

	/**
	 * Create an instance of a diagram type provider (and also the feature provider) without having a diagram editor open. This instance can
	 * be used for the generation of diagrams in the background. All features which do not expect an open editor can be reused.
	 * 
	 * @param diagram
	 *            The diagram on which the diagram type provider will work
	 * @param providerId
	 *            Id of the diagram type provider which should be used
	 * 
	 * @return the new dtp instance
	 */
	public static IDiagramTypeProvider createDiagramTypeProvider(Diagram diagram, String providerId) {

		IDiagramTypeProvider dtp = null;

		if (getExtensionManager() != null) {
			dtp = getExtensionManager().createDiagramTypeProvider(providerId);
			if (dtp != null) {
				IDiagramEditor diagramEditor = getPlatformService().createDiagramEditorDummy(dtp);
				dtp.init(diagram, diagramEditor);
			}
		}
		return dtp;
	}

}
