package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.sap.ide.moftool.editor.core.ui.wizards.CreateGeneralizableElementWizard;
import com.sap.ide.moftool.editor.core.ui.wizards.CreateGeneralizableElementWizardPage.ObjectTypeEnum;
import com.sap.ide.moftool.editor.internal.refactoring.core.commands.PromoteToRootPackage;
import com.sap.mi.fwk.ui.tree.nodes.ITreeNode;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;

public class ChangePartitionAction implements IObjectActionDelegate {

	private ISelection selection;
	private IWorkbenchPart targetPart;

	public ChangePartitionAction() {
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.targetPart = targetPart;

	}

	public void run(IAction action) {
//		try {
//			if (selection instanceof IStructuredSelection) {
//				IStructuredSelection sel = (IStructuredSelection) selection;
//				if (sel.getFirstElement() instanceof ITreeNode) {
//					ITreeNode<MofPackage> tn = (ITreeNode<MofPackage>) sel.getFirstElement();
//
//					Connection con = (Connection) tn.getAdapter(Connection.class.getName());
//
//					CreateGeneralizableElementWizard wizard = new CreateGeneralizableElementWizard(con, null,
//							"Promote to Root", "Promote to Root", "Make this package a root package", "Name", true, tn
//									.getValue().getName(), new Path(((Partitionable) tn.getValue()).get___Partition().getPri()
//									.getPartitionName()).removeFileExtension().lastSegment(), false, true, ObjectTypeEnum.Package);
//					WizardDialog dialog = new WizardDialog(targetPart.getSite().getShell(), wizard);
//					if (dialog.open() != Window.OK) {
//						return;
//					}
//					wizard.getPartitionName();
//					wizard.getPrefix();
//					new PromoteToRootPackage(tn.getValue(), wizard.getPartitionName(), wizard.getPrefix()).execute();
//					con.save();
//				}
//			}
//		} catch (Exception e) {
//			sTracer.log(Level.SEVERE, e.getMessage(), e);
//		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;

	}

}
