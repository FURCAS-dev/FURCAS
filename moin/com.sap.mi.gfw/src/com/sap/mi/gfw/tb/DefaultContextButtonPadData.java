package com.sap.mi.gfw.tb;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.datatypes.IRectangle;
import com.sap.mi.gfw.datatypes.impl.RectangleImpl;

/**
 * A very simple implementation of {@link IContextButtonPadData} without any real functionality.
 * 
 * This class is not intended to be instanciated by customers.
 */
public class DefaultContextButtonPadData implements IContextButtonPadData {

	private List<IContextButtonEntry> genericContextButtons;
	private List<IContextButtonEntry> domainSpecificContextButtons;
	private IContextButtonEntry collapseContextButton;
	private IRectangle location;

	/**
	 * Creates a new {@link DefaultContextButtonPadData}.
	 * 
	 * This class is not intended to be instanciated by customers.
	 */
	public DefaultContextButtonPadData() {
		genericContextButtons = new ArrayList<IContextButtonEntry>();
		domainSpecificContextButtons = new ArrayList<IContextButtonEntry>();
		location = new RectangleImpl(0, 0, 0, 0);
	}

	public List<IContextButtonEntry> getGenericContextButtons() {
		return genericContextButtons;
	}

	public List<IContextButtonEntry> getDomainSpecificContextButtons() {
		return domainSpecificContextButtons;
	}

	public IContextButtonEntry getCollapseContextButton() {
		return collapseContextButton;
	}

	public void setCollapseContextButton(IContextButtonEntry collapseContextButton) {
		this.collapseContextButton = collapseContextButton;
	}

	public IRectangle getPadLocation() {
		return location;
	}
}
