package com.sap.mi.gfw.tb;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.features.IFeature;
import com.sap.mi.gfw.features.context.IContext;

/**
 * The Class ContextButtonEntry.
 */
public class ContextButtonEntry extends AbstractContextEntry implements IContextButtonEntry {

	private List<IFeature> dragAndDropFeatures = new ArrayList<IFeature>();

	private List<IContextButtonEntry> contextButtonMenuEntries = new ArrayList<IContextButtonEntry>();

	/**
	 * Add a menu feature. Will be triggered when you click the button.
	 * 
	 * @param contextButtonEntry
	 *            the context button entry
	 */
	public void addContextButtonMenuEntry(IContextButtonEntry contextButtonEntry) {
		contextButtonMenuEntries.add(contextButtonEntry);
	}

	/**
	 * Gets the context button menu entries.
	 * 
	 * @return returns the menu features
	 */
	public List<IContextButtonEntry> getContextButtonMenuEntries() {
		return contextButtonMenuEntries;
	}

	/**
	 * add a drag and drop feature. gets triggered when you drag from the button and drop on an arbitrary part of the screen
	 * 
	 * @param dragAndDropFeature
	 *            the drag and drop feature
	 */
	public void addDragAndDropFeature(IFeature dragAndDropFeature) {
		dragAndDropFeatures.add(dragAndDropFeature);
	}

	/**
	 * Gets the drag and drop features.
	 * 
	 * @return returns the drag and drop features
	 */
	public List<IFeature> getDragAndDropFeatures() {
		return dragAndDropFeatures;
	}

	/**
	 * Creates a context button entry.
	 * 
	 * @param feature
	 *            feature that will be triggered on click
	 * @param context
	 *            the context used with the feature
	 */
	public ContextButtonEntry(IFeature feature, IContext context) {
		super(feature, context);
	}

	/**
	 * @deprecated Use {@link #ContextButtonEntry(IFeature, IContext)} instead.
	 */
	@Deprecated
	public ContextButtonEntry(IFeature feature, IContext context, int p1) {
		super(feature, context);
	}

	/**
	 * @deprecated Use {@link #ContextButtonEntry(IFeature, IContext)} instead.
	 */
	@Deprecated
	public ContextButtonEntry(IFeature feature, IContext context, int p1, int p2) {
		this(feature, context);
	}
}
