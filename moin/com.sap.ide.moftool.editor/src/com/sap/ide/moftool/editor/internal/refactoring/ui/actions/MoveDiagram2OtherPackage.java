package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MoveDiagramCmd;
import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.SelectPackageDialog;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;

public class MoveDiagram2OtherPackage extends AbstractMoveAction<Diagram> {

	@Override
	protected Command createCommand(Diagram value, MofPackage target, Connection con) {
		return new MoveDiagramCmd(value, target, con);
	}

	@Override
	protected FilteredItemsSelectionDialog getSelectionDialog(Shell shell, final Diagram value, Connection con) {
		return new SelectPackageDialog(shell, con, new SameContainerDiagramFilterer(value));
	}
}
