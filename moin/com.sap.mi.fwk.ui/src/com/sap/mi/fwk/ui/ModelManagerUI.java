package com.sap.mi.fwk.ui;

import com.sap.mi.fwk.ConnectionManager;
import com.sap.mi.fwk.mm.MetamodelManager;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;

/**
 * Accessor for UI-related framework services
 * 
 * @author d031150
 */
public final class ModelManagerUI {

	private static ModelManagerUI sInstance;

	/**
	 * Returns the MarkerManagerUI instance
	 * 
	 * @return The MarkerManagerUI instance
	 */
	public static MarkerManagerUI getMarkerManagerUI() {
		return MarkerManagerUI.getInstance();
	}

	/**
	 * @return the instance
	 */
	public static synchronized ModelManagerUI getInstance() {
		if (sInstance == null)
			sInstance = new ModelManagerUI();
		return sInstance;
	}

	/**
	 * @return the editor manager
	 */
	public static ModelEditorManager getEditorManager() {
		return ModelEditorManager.getInstance();
	}

	/**
	 * @return the command manager
	 */
	public static CommandManager getCommandManager() {
		return CommandManager.getInstance();
	}

	/**
	 * @return the UI part of the connection manager
	 * @see ConnectionManager
	 */
	public static ConnectionManagerUI getConnectionManagerUI() {
		return ConnectionManagerUI.getInstance();
	}

	/**
	 * @return the UI part of the metamodel manager
	 * @see MetamodelManager
	 */
	public static MetamodelManagerUI getMetamodelManagerUI() {
		return MetamodelManagerUI.getInstance();
	}

	/**
	 * For internal use only
	 */
	public static void shutDown() {
		if (sInstance == null)
			return;

		ModelEditorManager.dispose();
		sInstance = null;
	}

	private ModelManagerUI() {
	}

}
