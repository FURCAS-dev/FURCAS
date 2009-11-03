package com.sap.mi.fwk.services.local.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;

/**
 * Helper for SWT controls, e.g. for setting proper button size hints. If
 * possible, use {@link Dialog#setButtonLayoutData(Button)} or
 * {@link Dialog#setButtonLayoutFormData(Button)}.
 * 
 * @author d031150
 */
public final class SWTUtil {

	/**
	 * Sets width and height hint for the button control. Uses the button's grid
	 * data if available, otherwise attaches a new one.
	 * 
	 * @param button
	 *            the button for which to set the dimension hint
	 */
	public static void setButtonWidthHint(Button button) {
		GridData data;
		if (button.getLayoutData() instanceof GridData) {
			data = (GridData) button.getLayoutData();
		} else {
			data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
			button.setLayoutData(data);
		}
		data.widthHint = computeWidthHint(button);
	}

	/**
	 * Sets width and height hint for the button control. Uses the button's form
	 * data if available, otherwise attaches a new one.
	 * 
	 * @param button
	 *            the button for which to set the dimension hint
	 */
	public static void setButtonWidthHintFormData(Button button) {
		FormData data;
		if (button.getLayoutData() instanceof FormData) {
			data = (FormData) button.getLayoutData();
		} else {
			data = new FormData();
			button.setLayoutData(data);
		}
		data.width = computeWidthHint(button);
	}

	private static int computeWidthHint(Control control) {
		PixelConverter converter = new PixelConverter(control);
		int widthHint = converter.convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		Point minSize = control.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		return Math.max(widthHint, minSize.x);
	}

	private static final class PixelConverter {
		private final FontMetrics fFontMetrics;

		public PixelConverter(Control control) {
			GC gc = new GC(control);
			gc.setFont(control.getFont());
			fFontMetrics = gc.getFontMetrics();
			gc.dispose();
		}

		/**
		 * @see DialogPage#convertHeightInCharsToPixels
		 */
		public int convertHeightInCharsToPixels(int chars) {
			return Dialog.convertHeightInCharsToPixels(fFontMetrics, chars);
		}

		/**
		 * @see DialogPage#convertHorizontalDLUsToPixels
		 */
		public int convertHorizontalDLUsToPixels(int dlus) {
			return Dialog.convertHorizontalDLUsToPixels(fFontMetrics, dlus);
		}

		/**
		 * @see DialogPage#convertVerticalDLUsToPixels
		 */
		public int convertVerticalDLUsToPixels(int dlus) {
			return Dialog.convertVerticalDLUsToPixels(fFontMetrics, dlus);
		}

		/**
		 * @see DialogPage#convertWidthInCharsToPixels
		 */
		public int convertWidthInCharsToPixels(int chars) {
			return Dialog.convertWidthInCharsToPixels(fFontMetrics, chars);
		}
	}

}
