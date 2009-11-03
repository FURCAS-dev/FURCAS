package com.sap.mi.gfw.eclipse.internal.editor;

import org.eclipse.gef.SharedImages;
import org.eclipse.gef.internal.GEFMessages;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.tools.MarqueeSelectionTool;

/**
 * A palette ToolEntry for a {@link org.eclipse.gef.tools.MarqueeSelectionTool}.
 * 
 * @author hudsonr
 * @since 2.1
 */
public class GfwMarqueeToolEntry extends ToolEntry {

	/**
	 * Creates a new MarqueeToolEntry that can select nodes.
	 */
	public GfwMarqueeToolEntry() {
		this(null, null);
	}

	/**
	 * Constructor for MarqueeToolEntry.
	 * 
	 * @param label
	 *            the label
	 */
	public GfwMarqueeToolEntry(String label) {
		this(label, null);
	}

	/**
	 * Constructor for MarqueeToolEntry.
	 * 
	 * @param label
	 *            the label; can be <code>null</code>
	 * @param description
	 *            the description (can be <code>null</code>)
	 */
	public GfwMarqueeToolEntry(String label, String description) {
		super(label, description, SharedImages.DESC_MARQUEE_TOOL_16, SharedImages.DESC_MARQUEE_TOOL_24, GfwMarqueeSelectionTool.class);
		if (label == null || label.length() == 0)
			setLabel(GEFMessages.MarqueeTool_Label);
		setUserModificationPermission(PERMISSION_NO_MODIFICATION);
	}

	/**
	 * Gets the description.
	 * 
	 * @return the description
	 * 
	 * @see org.eclipse.gef.palette.PaletteEntry#getDescription()
	 */
	@Override
	public String getDescription() {
		String description = super.getDescription();
		if (description != null)
			return description;

		Object value = getToolProperty(MarqueeSelectionTool.PROPERTY_MARQUEE_BEHAVIOR);
		if (value instanceof Integer) {
			int selectionType = ((Integer) value).intValue();
			if (selectionType == MarqueeSelectionTool.BEHAVIOR_NODES_AND_CONNECTIONS)
				return GEFMessages.MarqueeTool_Desc;
			if (selectionType == MarqueeSelectionTool.BEHAVIOR_CONNECTIONS_TOUCHED)
				return GEFMessages.MarqueeTool_Connections_Desc;
		}
		return GEFMessages.MarqueeTool_Nodes_Desc;
	}

}
