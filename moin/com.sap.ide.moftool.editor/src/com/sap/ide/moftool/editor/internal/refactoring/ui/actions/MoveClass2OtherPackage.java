package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MoveClassCmd;
import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.SelectPackageDialog;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;

public class MoveClass2OtherPackage extends AbstractMoveAction<MofClass> {

	@Override
	protected Command createCommand(MofClass value, MofPackage target, Connection con) {
		return new MoveClassCmd((MofClass) value, target, con);
	}

	@Override
	protected FilteredItemsSelectionDialog getSelectionDialog(Shell shell, final MofClass value, Connection con) {
		return new SelectPackageDialog(shell, con, new SameContainerFilterer(value));
	}
}
