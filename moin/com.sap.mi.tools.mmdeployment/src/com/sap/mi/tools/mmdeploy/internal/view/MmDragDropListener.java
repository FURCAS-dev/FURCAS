package com.sap.mi.tools.mmdeploy.internal.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.IWorkingSet;

import com.sap.mi.fwk.ui.mm.MetamodelManagerUI;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * Handles dragging in deployment view
 * 
 * @author d031150
 */
final class MmDragListener extends DragSourceAdapter {
	private final MmDeploymentView mView;

	MmDragListener(MmDeploymentView view) {
		mView = view;
	}
	public void dragStart(DragSourceEvent event) {
		IStructuredSelection selectedMetamodels = getSelectedMetamodels();
		LocalSelectionTransfer.getTransfer().setSelection(selectedMetamodels);
		event.doit = !selectedMetamodels.isEmpty();
	}

	public void dragSetData(DragSourceEvent event) {
		if (LocalSelectionTransfer.getTransfer().isSupportedType(event.dataType)) {
			event.data = LocalSelectionTransfer.getTransfer().getSelection();
		}
	}
	private IStructuredSelection getSelectedMetamodels() {
		IStructuredSelection sel = (IStructuredSelection) mView.getSite().getSelectionProvider().getSelection();
		List<MmNode> result = new ArrayList<MmNode>(sel.size());
		Object[] objects = sel.toArray();
		for (Object object : objects) {
			if (!(object instanceof MmNode))
				return StructuredSelection.EMPTY;
			result.add((MmNode) object);
		}
		return new StructuredSelection(result);
	}
}

/**
 * Handles dropping in deployment view
 * 
 * @author d031150
 */
final class MmDropListener extends ViewerDropAdapter {
	private final MmDeploymentView mView;

	MmDropListener(MmDeploymentView view) {
		super(view.getViewer());
		mView = view;
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		setFeedbackEnabled(false);

		// null target is valid, means new working set
		if (target == null)
			return true;

		MmWorkingSetNode targetSet;
		if (target instanceof MmWorkingSetNode)
			targetSet = (MmWorkingSetNode) target;
		else if (target instanceof MmNode)
			targetSet = ((MmNode) target).getWorkingSet();
		else
			return false;
		IStructuredSelection sel = (IStructuredSelection) LocalSelectionTransfer.getTransfer().getSelection();
		if (sel.isEmpty())
			return false;
		Object[] objects = sel.toArray();
		for (Object object : objects) {
			MmNode node = (MmNode) object;
			if (targetSet.equals(node.getWorkingSet()))
				return false;
		}
		MmNode sourceNode = ((MmNode) objects[0]);
		
		// copying from or to Others doesn't make sense
		if ((operation & DND.DROP_COPY) != 0) {
			if (targetSet.isOthers())
				return false;
			if (sourceNode.getWorkingSet().isOthers())
				return false;
		}
		
		return true;
	}

	@Override
	public boolean performDrop(Object data) {
		int currentOp = getCurrentOperation();
		MetamodelManagerUI mmManager = MetamodelManagerUI.getInstance();
		IStructuredSelection sel = (IStructuredSelection) data;
		Set<MmDeploymentInfo> metamodels = new HashSet<MmDeploymentInfo>();
		Object[] objects = sel.toArray();
		for (Object object : objects) {
			MmNode node = (MmNode) object;
			metamodels.add(node.getMetamodel());
		}
		MmNode sourceNode = ((MmNode) objects[0]);
		
		Object target = getCurrentTarget();
		if (target == null) { // null target means new working set
			IWorkingSet set = mmManager.createMetamodelWorkingSet(metamodels);
			MmWorkingSetNode newNode = MmContentProvider.toWorkingSetNode(set);
			mView.expand(newNode);
		}
		else {
			MmWorkingSetNode targetSet;
			if (target instanceof MmWorkingSetNode)
				targetSet = (MmWorkingSetNode) target;
			else if (target instanceof MmNode)
				targetSet = ((MmNode) target).getWorkingSet();
			else
				return false;
			IWorkingSet targetWorkingSet = targetSet.getWorkingSet();
		
			// add to target
			if (!targetSet.isOthers())
				mmManager.addToMetamodelWorkingSet(metamodels, targetWorkingSet);
		}
		
		// remove from source if in move mode
		if ((currentOp & DND.DROP_MOVE) != 0) {
			if (!sourceNode.getWorkingSet().isOthers()) {
				IWorkingSet sourceSet = sourceNode.getWorkingSet().getWorkingSet();
				mmManager.removeFromMetamodelWorkingSet(metamodels, sourceSet);
			}
		}
		
		return true;
	}
}

