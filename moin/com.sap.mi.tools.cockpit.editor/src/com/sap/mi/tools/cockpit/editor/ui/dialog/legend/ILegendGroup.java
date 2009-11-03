package com.sap.mi.tools.cockpit.editor.ui.dialog.legend;

public interface ILegendGroup {
	/**
	 * @return the array of legend elements
	 */
	public ILegendElement[] getLegendElements();

	/**
	 * @return the title of the group
	 */
	public String getLegendGroupName();
}
