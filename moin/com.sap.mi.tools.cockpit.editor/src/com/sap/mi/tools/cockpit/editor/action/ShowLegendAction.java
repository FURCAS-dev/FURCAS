package com.sap.mi.tools.cockpit.editor.action;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.sap.mi.tools.cockpit.editor.MOINBrowser;
import com.sap.mi.tools.cockpit.editor.Messages;
import com.sap.mi.tools.cockpit.editor.ui.dialog.legend.ILegendElement;
import com.sap.mi.tools.cockpit.editor.ui.dialog.legend.ILegendGroup;
import com.sap.mi.tools.cockpit.editor.ui.dialog.legend.LegendDialog;
import com.sap.mi.tools.cockpit.editor.ui.dialog.legend.LegendElement;
import com.sap.mi.tools.cockpit.editor.ui.dialog.legend.LegendGroup;

/**
 * @author d003456
 * 
 */
public class ShowLegendAction extends Action {

	/**
	 * Constructor
	 */
	public ShowLegendAction() {
		super();
		setText(Messages.ShowLegendAction_0_xmit);
		setImageDescriptor(MOINBrowser.getDefault().getImageDescriptor(
				MOINBrowser.SHOW_LEGEND_IMAGE));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		ILegendElement[] metaModelNodes = new LegendElement[8];
		metaModelNodes[0] = new LegendElement(PlatformUI.getWorkbench()
				.getSharedImages().getImage(
						org.eclipse.ui.ide.IDE.SharedImages.IMG_OBJ_PROJECT),
				Messages.ShowLegendAction_1_xtxt);
		metaModelNodes[1] = new LegendElement(MOINBrowser.getDefault()
				.getImage(MOINBrowser.CONTAINER_IMAGE), Messages.ShowLegendAction_2_xtxt);
		metaModelNodes[2] = new LegendElement(MOINBrowser.getDefault()
				.getImage(MOINBrowser.CONTAINER_PATH_IMAGE), Messages.ShowLegendAction_3_xtxt);
		metaModelNodes[3] = new LegendElement(PlatformUI.getWorkbench()
				.getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE),
				Messages.ShowLegendAction_4_xtxt);
		metaModelNodes[4] = new LegendElement(MOINBrowser.getDefault()
				.getImage(MOINBrowser.METAMODEL_IMAGE), Messages.ShowLegendAction_5_xtxt);
		metaModelNodes[5] = new LegendElement(MOINBrowser.getDefault()
				.getImage(MOINBrowser.PACKAGE_IMAGE), Messages.ShowLegendAction_6_xtxt);
		metaModelNodes[6] = new LegendElement(MOINBrowser.getDefault()
				.getImage(MOINBrowser.TYPE_IMAGE), Messages.ShowLegendAction_7_xtxt);
		metaModelNodes[7] = new LegendElement(MOINBrowser.getDefault()
				.getImage(MOINBrowser.MOVE_UP_IMAGE), Messages.ShowLegendAction_8_xtxt);

		ILegendElement[] modelNodes = new LegendElement[10];
		modelNodes[0] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.OBJECT_IMAGE), Messages.ShowLegendAction_9_xtxt);
		modelNodes[1] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.ATTRIBUTE_IMAGE), Messages.ShowLegendAction_10_xtxt);
		modelNodes[2] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.ZERO_TO_UNBOUND_ATTRIBUTE_IMAGE),
				Messages.ShowLegendAction_11_xtxt);
		modelNodes[3] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.LITERAL_IMAGE), Messages.ShowLegendAction_12_xtxt);
		modelNodes[4] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.ENUMERATION_TYPE_IMAGE), Messages.ShowLegendAction_13_xtxt);
		modelNodes[5] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.STRUCTURE_TYPE_IMAGE), Messages.ShowLegendAction_14_xtxt);
		modelNodes[6] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.ZERO_TO_ONE_ASSOCIATION_IMAGE),
				Messages.ShowLegendAction_15_xtxt);
		modelNodes[7] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.ZERO_TO_UNBOUND_ASSOCIATION_IMAGE),
				Messages.ShowLegendAction_16_xtxt);
		modelNodes[8] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.ZERO_TO_ONE_COMPOSITION_IMAGE),
				Messages.ShowLegendAction_17_xtxt);
		modelNodes[9] = new LegendElement(MOINBrowser.getDefault().getImage(
				MOINBrowser.ZERO_TO_UNBOUND_COMPOSITION_IMAGE),
				Messages.ShowLegendAction_18_xtxt);

		ILegendGroup[] groups = new LegendGroup[2];
		groups[0] = new LegendGroup(metaModelNodes,
				Messages.ShowLegendAction_19_xhed);
		groups[1] = new LegendGroup(modelNodes, Messages.ShowLegendAction_20_xhed);

		LegendDialog.showLegendDialog(Messages.ShowLegendAction_21_xhed, groups);
	}

}
