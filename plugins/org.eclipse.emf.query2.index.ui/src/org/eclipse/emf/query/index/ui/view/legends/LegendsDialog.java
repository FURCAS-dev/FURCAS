package org.eclipse.emf.query.index.ui.view.legends;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class LegendsDialog extends Dialog {

	private String mDialogTitle;
	private Image mDialogImage;
	private ILegendManager mLegendManager;
	private Point mparentLength;

	protected LegendsDialog(String dialogTitle, Image dialogImage, Shell parentShell, ILegendManager legendManager) {
		super(parentShell);
		mparentLength = parentShell.getSize();
		this.mDialogTitle = dialogTitle;
		this.mDialogImage = dialogImage;
		this.mLegendManager = legendManager;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite out = (Composite) super.createDialogArea(parent);
		out = new LegendsComposite(mLegendManager, out, new Point(600, mparentLength.y - 500));
		return out;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		if (mDialogImage != null)
			newShell.setImage(mDialogImage);
		if (mDialogTitle != null)
			newShell.setText(mDialogTitle);
	}

}
