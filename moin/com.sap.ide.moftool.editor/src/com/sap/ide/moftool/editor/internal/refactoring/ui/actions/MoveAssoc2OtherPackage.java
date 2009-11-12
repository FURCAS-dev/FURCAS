package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MoveAssocCmd;
import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.SelectPackageDialog;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;

public class MoveAssoc2OtherPackage extends AbstractMoveAction<Association> {

	@Override
	protected Command createCommand(Association value, MofPackage target, Connection con) {
		return new MoveAssocCmd((Association) value, target, con);
	}

	@Override
	protected FilteredItemsSelectionDialog getSelectionDialog(Shell shell, final Association value, Connection con) {
		return new SelectPackageDialog(shell, con, new SameContainerFilterer(value));
	}
}
