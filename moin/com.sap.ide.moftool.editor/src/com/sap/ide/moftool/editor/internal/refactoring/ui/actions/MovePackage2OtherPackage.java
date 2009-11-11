package com.sap.ide.moftool.editor.internal.refactoring.ui.actions;

import java.util.HashSet;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

import com.sap.ide.moftool.editor.internal.refactoring.core.commands.MovePackageCmd;
import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.AndPredicateFilter;
import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.IPackageFilterCallback;
import com.sap.ide.moftool.editor.internal.refactoring.ui.dialog.SelectPackageDialog;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;

public class MovePackage2OtherPackage extends AbstractMoveAction<MofPackage> {

	private final class SubHierarchyFilter implements IPackageFilterCallback {
		private final MofPackage value;

		private SubHierarchyFilter(MofPackage value) {
			this.value = value;
		}

		public boolean matches(MofPackage pack) {
			Set<Namespace> parentContainer = new HashSet<Namespace>();
			Namespace last = pack;
			while (last != null) {
				parentContainer.add(last);
				last = last.getContainer();
			}
			return !parentContainer.contains(value);
		}

	}

	@Override
	protected Command createCommand(MofPackage value, MofPackage target, Connection con) {
		return new MovePackageCmd(value, target, con);
	}

	@Override
	protected FilteredItemsSelectionDialog getSelectionDialog(Shell shell, final MofPackage value, Connection con) {
		return new SelectPackageDialog(shell, con, new AndPredicateFilter(new SameContainerFilterer(value),
				new SubHierarchyFilter(value)));
	}

}
