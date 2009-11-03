package com.sap.mi.tools.cockpit.editor.ui.dialog.legend;

/**
 * @author d003456
 * 
 */
public class LegendGroup implements ILegendGroup {

	private ILegendElement[] elements;

	private String groupName;

	/**
	 * Constructor
	 * 
	 * @param elements
	 * @param groupName
	 */
	public LegendGroup(ILegendElement[] elements, String groupName) {

		this.elements = elements;
		this.groupName = groupName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.ui.dialog.legend.ILegendGroup#getLegendElements()
	 */
	public ILegendElement[] getLegendElements() {

		return this.elements;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.tools.cockpit.editor.ui.dialog.legend.ILegendGroup#getLegendGroupName()
	 */
	public String getLegendGroupName() {

		return this.groupName;
	}

}
