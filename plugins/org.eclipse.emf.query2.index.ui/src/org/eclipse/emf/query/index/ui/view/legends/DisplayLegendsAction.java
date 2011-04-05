package org.eclipse.emf.query.index.ui.view.legends;

import org.eclipse.emf.query.index.ui.Messages;
import org.eclipse.emf.query.index.ui.images.IndexUIImageRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class DisplayLegendsAction extends Action {

	private String mDialogTitle;
	private ILegendManager mLegendManager;

	/**
	 * @wbp.parser.entryPoint
	 */
	public DisplayLegendsAction(String dialogTitle, ILegendManager legendManager) {
		super(Messages.Query2IndexUI_IndexView_Legend);
		this.mDialogTitle = dialogTitle;
		this.mLegendManager = legendManager;
	}

	@Override
	public String getDescription() {
		return Messages.Query2IndexUI_IndexView_Legend;
	}

	@Override
	public String getToolTipText() {
		return Messages.Query2IndexUI_IndexView_Legend;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return super.getImageDescriptor();
	}

	@Override
	public void run() {
		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
		LegendsDialog legend = new LegendsDialog(mDialogTitle, IndexUIImageRegistry.getImage(IndexUIImageRegistry.LEGEND_ICON), shell, mLegendManager);
		legend.open();
	}

}
