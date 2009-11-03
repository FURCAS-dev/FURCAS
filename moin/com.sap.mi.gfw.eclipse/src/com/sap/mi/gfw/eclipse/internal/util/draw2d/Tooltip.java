package com.sap.mi.gfw.eclipse.internal.util.draw2d;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

public class Tooltip extends FlowPage {

	private static final int TOOLTIP_MAX_WIDTH = 250;
	private static final Border TOOLTIP_BORDER = new MarginBorder(0, 2, 1, 2);

	private static Font boldFont;

	private TextFlow header;
	private TextFlow description;
	private String headerText;
	private String descriptionText;

	public Tooltip() {
		setForegroundColor(GFColorConstants.TOOLTIP_FG);
		setBackgroundColor(GFColorConstants.TOOLTIP_BG);
		setOpaque(true);
		setBorder(TOOLTIP_BORDER);

		header = new TextFlow();
		header.setForegroundColor(ColorConstants.darkGray);
		header.setFont(getBoldFont());
		add(header);

		description = new TextFlow();
		description.setForegroundColor(ColorConstants.darkGray);
		add(description);
	}

	public void setHeader(String text) {
		headerText = text;
		adjustTexts();
	}

	public void setDescription(String text) {
		descriptionText = text;
		adjustTexts();
	}

	private void adjustTexts() {
		description.setText(descriptionText);
		if (headerText != null && descriptionText != null) {
			// needs extra line-break
			header.setText(headerText + "\n"); //$NON-NLS-1$
		} else {
			header.setText(headerText);
		}
	}

	@Override
	public Dimension getPreferredSize(int w, int h) {
		Dimension d = super.getPreferredSize(-1, -1);
		if (d.width > TOOLTIP_MAX_WIDTH)
			d = super.getPreferredSize(TOOLTIP_MAX_WIDTH, -1);
		return d;
	}

	// TODO: move to service layer
	public static Font getBoldFont() {
		if (boldFont == null) {
			FontData fd = Display.getDefault().getSystemFont().getFontData()[0];
			fd.setStyle(fd.getStyle() | SWT.BOLD);
			boldFont = new Font(Display.getDefault(), fd);
		}
		return boldFont;
	}
}
