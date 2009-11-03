package com.sap.mi.gfw.eclipse.internal.parts.directedit;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.sap.mi.gfw.features.IDirectEditingFeature;
import com.sap.mi.gfw.func.IDirectEditing;

/**
 * implementation of a locator for direct edit CellEditors
 */
public class TextCellLocator implements CellEditorLocator {

	private IFigure figure;

	private IDirectEditingFeature directEditingFeature;

	private int initialWidth = -1;

	public TextCellLocator(IFigure figure, IDirectEditingFeature directEditingFeature) {
		this.figure = figure;
		this.directEditingFeature = directEditingFeature;

	}

	public void relocate(CellEditor celleditor) {

		Control control = celleditor.getControl();

		if (directEditingFeature.getEditingType() == IDirectEditing.TYPE_MULTILINETEXT) {

			// IFigure parentFigure = figure.getParent();
			Rectangle rect = figure.getClientArea().getCopy();
			figure.translateToAbsolute(rect);
			org.eclipse.swt.graphics.Rectangle trim = ((Text) control).computeTrim(0, 0, 0, 0);
			rect.translate(trim.x, trim.y);
			rect.width += trim.width;
			rect.height += trim.height;
			// control.setBounds(rect.x, rect.y, rect.width, rect.height);

			int correction = 16;

			Text text = (Text) celleditor.getControl();
			Dimension d = FigureUtilities.getTextExtents(text.getText(), text.getFont());
			rect.x += (rect.width - d.width - correction) / 2;
			rect.y += (rect.height - d.height) / 2;

			text.setBounds(rect.x, rect.y, d.width + correction, d.height);

		} else if (directEditingFeature.getEditingType() == IDirectEditing.TYPE_TEXT) {

			Rectangle rect = figure.getBounds().getCopy();

			// no longer needed
			// figure.getParent().revalidate();

			figure.translateToAbsolute(rect);

			if (directEditingFeature.stretchTextfieldToFitText()) {

				Text text = (Text) control;
				Point pref = text.computeSize(-1, -1);

				// initialWidth is the minimum width for the field
				if (initialWidth == -1) {
					initialWidth = pref.x;
				}

				if (pref.x < initialWidth)
					pref.x = initialWidth;

				control.setBounds(rect.x, rect.y, pref.x + 10, pref.y);
			} else {

				int height = control.getFont().getFontData()[0].getHeight();

				control.setBounds(rect.x + 2, rect.y + 2, rect.width - 4, height * 2);
			}

		} else if (directEditingFeature.getEditingType() == IDirectEditing.TYPE_DROPDOWN) {
			Rectangle rect = figure.getBounds().getCopy();

			figure.translateToAbsolute(rect);
			int minWidth = 80;
			if (rect.width > minWidth) {
				minWidth = rect.width;
			}
			control.setBounds(rect.x, rect.y, minWidth, 14);

		}

	}

	public IFigure getFigure() {
		return figure;
	}

}
