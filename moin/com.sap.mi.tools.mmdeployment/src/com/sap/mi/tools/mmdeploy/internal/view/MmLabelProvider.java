package com.sap.mi.tools.mmdeploy.internal.view;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;

import com.sap.ide.util.ui.image.IImageKey;
import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;
import com.sap.mi.tools.mmdeploy.internal.MmDeploymentPlugin;
import com.sap.mi.tools.mmdeploy.internal.messages.MmDeploymentMessages;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentStatus;
import com.tssap.util.ui.image.ISapImage;
import com.tssap.util.ui.image.SapImage;

/**
 * The label provider for the deployment view
 * 
 * @author d031150
 */
class MmLabelProvider extends ColumnLabelProvider {

	private final Viewer mViewer;
	private final int mColIndex;

	/**
	 * Creates a label provider intended for the whole viewer
	 */
	MmLabelProvider(Viewer viewer) {
		this(viewer, -1);
	}

	/**
	 * Creates a label provider intended for the column with the given index
	 */
	MmLabelProvider(Viewer viewer, int columnIndex) {
		mViewer = viewer;
		// need to pass in the index since it's not supplied in getToolTipText()
		mColIndex = columnIndex;
	}

	@Override
	public void update(ViewerCell cell) {
		super.update(cell);
		Object element = cell.getElement();
		int idx = cell.getColumnIndex();

		String text = getColumnText(element, idx);
		cell.setText(text);

		Image image = getColumnImage(element, idx);
		cell.setImage(image);
	}

	String getColumnText(Object element, int index) {
		if (element instanceof MmPendingNode && index == 0) {
			return MmDeploymentMessages.labelProvider_loading;
		}
		if (element instanceof MmWorkingSetNode && index == 0) {
			MmWorkingSetNode cat = (MmWorkingSetNode) element;
			return cat.getName();
		} else if (element instanceof MmNode) {
			MmNode node = ((MmNode) element);
			MmDeploymentInfo metamodel = node.getMetamodel();
			switch (index) {
				case 0:
					return metamodel.getLabel();
				case 1:
					return metamodel.getContainerName();
				case 2:
					return metamodel.getBundleId();
				case 3:
					return metamodel.getMetaModelPluginVersion().getVersionString();
				case 4:
					return MmLabelProvider.getStatusText(metamodel);
				default:
					break;
			}
		}
		return ""; //$NON-NLS-1$
	}

	private Image getColumnImage(Object element, int index) {
		if (element instanceof MmWorkingSetNode && index == 0) {
			IImageKey imageName = MmDeploymentPlugin.IMAGE_NAME_WORKING_SET;
			return MmDeploymentPlugin.getSharedImage(imageName);
		} else if (element instanceof MmNode) {
			MmNode node = ((MmNode) element);
			MmDeploymentInfo metamodel = node.getMetamodel();
			ISapImage imageKey = null;
			switch (index) {
				case 0:
					MmDeploymentStatus status = metamodel.getStatus();
					switch (status) {
						case DEPLOYED:
							imageKey = SapImage.ICON_LED_GREEN;
							break;
						case NOT_DEPLOYED:
							imageKey = SapImage.ICON_LED_RED;
							break;
						case VERSION_DIFFER:
							imageKey = SapImage.ICON_LED_RED;
							break;
						case ERROR_NOT_DEPLOYABLE:
							imageKey = SapImage.ICON_LED_RED;
							break;
						case UNKNOWN:
							imageKey = SapImage.ICON_LED_YELLOW;
							break;
						default:
							imageKey = SapImage.ICON_LED_YELLOW;
							break;
					}
				default:
					break;
			}
			if (imageKey != null)
				return MmDeploymentPlugin.getSharedImage(imageKey, mViewer.getControl());
		}
		return null;
	}

	@Override
	public String getToolTipText(Object element) {
		if (mColIndex == 0 && element instanceof MmNode) {
			MmNode node = ((MmNode) element);
			MmDeploymentInfo metamodel = node.getMetamodel();
			return getStatusText(metamodel);
		}
		return null;
	}

	static String toMmString(Collection<MmDeploymentInfo> metamodels) {
		StringBuilder text = new StringBuilder();
		for (Iterator<MmDeploymentInfo> iter = metamodels.iterator(); iter.hasNext();) {
			MmDeploymentInfo mm = iter.next();

			text.append(mm.getLabel());
			text.append("\t"); //$NON-NLS-1$
			text.append(mm.getContainerName());
			text.append("\t"); //$NON-NLS-1$
			text.append(mm.getBundleId());
			text.append("\t"); //$NON-NLS-1$
			text.append(mm.getMetaModelPluginVersion().getVersionString());
			text.append("\t"); //$NON-NLS-1$
			text.append(getStatusText(mm));

			if (iter.hasNext())
				text.append(System.getProperty("line.separator")); //$NON-NLS-1$
		}
		return text.toString();
	}

	static String getStatusText(MmDeploymentInfo metamodel) {
		return MetamodelManagerUI.getInstance().getStatusInfo(metamodel);
	}

}