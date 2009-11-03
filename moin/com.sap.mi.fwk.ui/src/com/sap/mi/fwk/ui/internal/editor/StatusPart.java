package com.sap.mi.fwk.ui.internal.editor;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Shows a status. Copied from
 * <code>org.eclipse.ui.internal.part.StatusPart</code>.
 */
public class StatusPart {

	public static final String WIDGET_NAME_TEXT = StatusPart.class.getName() + ".text"; //$NON-NLS-1$
	public static final String WIDGET_NAME_TEXT_DETAILS = StatusPart.class.getName() + ".detailsText"; //$NON-NLS-1$
	public static final String WIDGET_NAME_BUTTON = StatusPart.class.getName() + ".detailsButton"; //$NON-NLS-1$

	boolean showingDetails = false;
	private final Button detailsButton;
	private final Composite detailsArea;
	private Control details = null;
	private final IStatus reason;

	public StatusPart(final Composite parent, IStatus reason_) {
		Color bgColor = parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND);
		Color fgColor = parent.getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND);

		parent.setBackground(bgColor);
		parent.setForeground(fgColor);

		this.reason = reason_;
		GridLayout layout = new GridLayout();

		layout.numColumns = 3;

		int spacing = 8;
		int margins = 8;
		layout.marginBottom = margins;
		layout.marginTop = margins;
		layout.marginLeft = margins;
		layout.marginRight = margins;
		layout.horizontalSpacing = spacing;
		layout.verticalSpacing = spacing;
		parent.setLayout(layout);

		Label imageLabel = new Label(parent, SWT.NONE);
		imageLabel.setBackground(bgColor);
		Image image = getImage();
		if (image != null) {
			image.setBackground(bgColor);
			imageLabel.setImage(image);
			imageLabel.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_CENTER | GridData.VERTICAL_ALIGN_BEGINNING));
		}

		Text text = new Text(parent, SWT.MULTI | SWT.READ_ONLY | SWT.WRAP);
		text.setBackground(bgColor);
		text.setForeground(fgColor);

		// text.setForeground(JFaceColors.getErrorText(text.getDisplay()));
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setText(reason.getMessage());
		text.setData("name", WIDGET_NAME_TEXT); //$NON-NLS-1$ for testing

		detailsButton = new Button(parent, SWT.PUSH);
		detailsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showDetails(!showingDetails);
			}
		});

		detailsButton.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		detailsButton.setVisible(reason.getException() != null);
		detailsButton.setData("name", WIDGET_NAME_BUTTON); //$NON-NLS-1$ for testing

		updateDetailsText();

		detailsArea = new Composite(parent, SWT.NONE);
		detailsArea.setBackground(bgColor);
		detailsArea.setForeground(fgColor);
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 3;
		data.verticalSpan = 1;
		detailsArea.setLayoutData(data);
		detailsArea.setLayout(new FillLayout());
		parent.layout(true);
	}

	public void setFocus() {
		if (detailsButton != null && !detailsButton.isDisposed()) {
			detailsButton.setFocus();
		}
	}

	/**
	 * Return the image for the upper-left corner of this part
	 * 
	 * @return the image
	 */
	private Image getImage() {
		Display d = Display.getCurrent();

		switch (reason.getSeverity()) {
			case IStatus.ERROR:
				return d.getSystemImage(SWT.ICON_ERROR);
			case IStatus.WARNING:
				return d.getSystemImage(SWT.ICON_WARNING);
			default:
				return d.getSystemImage(SWT.ICON_INFORMATION);
		}
	}

	private void showDetails(boolean shouldShow) {
		if (shouldShow == showingDetails) {
			return;
		}
		this.showingDetails = shouldShow;
		updateDetailsText();
	}

	private void updateDetailsText() {
		if (details != null) {
			details.dispose();
			details = null;
		}

		if (showingDetails) {
			detailsButton.setText(IDialogConstants.HIDE_DETAILS_LABEL);
			Text detailsText = new Text(detailsArea, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.READ_ONLY
					| SWT.LEFT_TO_RIGHT);
			detailsText.setText(getDetails(reason));
			detailsText.setBackground(detailsText.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
			detailsText.setData("name", WIDGET_NAME_TEXT_DETAILS); //$NON-NLS-1$ for testing
			details = detailsText;
			detailsArea.layout(true);
		} else {
			detailsButton.setText(IDialogConstants.SHOW_DETAILS_LABEL);
		}
	}

	private String getDetails(IStatus status) {
		if (status.getException() != null) {
			return getStackTrace(status.getException());
		}

		return ""; //$NON-NLS-1$
	}

	private String getStackTrace(Throwable throwable) {
		StringWriter swriter = new StringWriter();
		PrintWriter pwriter = new PrintWriter(swriter);
		throwable.printStackTrace(pwriter);
		pwriter.flush();
		pwriter.close();
		return swriter.toString();
	}
}
