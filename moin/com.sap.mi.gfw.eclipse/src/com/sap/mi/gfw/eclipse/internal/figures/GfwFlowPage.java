package com.sap.mi.gfw.eclipse.internal.figures;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;

public class GfwFlowPage extends FlowPage {

	private TextFlow textFlow;

	private int verticalAlignment = PositionConstants.TOP;

	public GfwFlowPage(TextFlow textFlow) {
		this.textFlow = textFlow;
	}

	@Override
	public void setBounds(Rectangle r) {

		super.setBounds(r);
		// call validate() before textFlow.getSize() otherwise getSize() returns
		// the old values
		validate();

		// if vertical alignment == PositionConstants.TOP then change nothing
		if (getVerticalAligment() == PositionConstants.MIDDLE) {
			// Dimension d = FigureUtilities.getTextExtents(textFlow.getText(),
			// textFlow.getFont());
			Dimension d = textFlow.getSize();
			int y = (r.height - d.height) / 2;
			r.y += y;
			r.height += Math.abs(y);
		} else if (getVerticalAligment() == PositionConstants.BOTTOM) {
			Dimension d = textFlow.getSize();
			int y = r.height - d.height;
			r.y += y;
			r.height += Math.abs(y);
		}
		super.setBounds(r);
	}

	public void setVerticalAligment(int value) {
		verticalAlignment = value;
	}

	public int getVerticalAligment() {
		return verticalAlignment;
	}
}
