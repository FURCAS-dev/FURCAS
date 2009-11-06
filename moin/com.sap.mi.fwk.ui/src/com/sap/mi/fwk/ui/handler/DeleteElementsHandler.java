/**
 * Copyright (c) 2008 by SAP AG, Walldorf. http://www.sap.com All rights
 * reserved.
 * 
 * This software is the confidential and proprietary information of SAP AG,
 * Walldorf. You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered
 * into with SAP.
 * 
 */
package com.sap.mi.fwk.ui.handler;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.ConnectionManagerUI;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.JmiHelper;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.ExecutionCancelledException;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * (c) 2000 - 2009 SAP AG
 * 
 * @author d024127
 * 
 */
public class DeleteElementsHandler extends AbstractCommandHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		IStructuredSelection strSel = ModelAdapter.getInstance().adaptObject(selection, IStructuredSelection.class);

		if (strSel != null && !strSel.isEmpty()) {

			Shell shell = HandlerUtil.getActiveShellChecked(event);
			boolean openQuestion;
			if (strSel.size() == 1) {
				openQuestion = MessageDialog.openQuestion(shell, MiFwkUiMessages.DeleteElementHandler_confimtitleSingle,
						MiFwkUiMessages.DeleteElementHandler_confirmmsgSingle);
			} else {
				openQuestion = MessageDialog.openQuestion(shell, MiFwkUiMessages.DeleteElementHandler_confimtitleMultiple,
						MiFwkUiMessages.DeleteElementHandler_confirmmsgMultiple);
			}
			if (!openQuestion) {
				return null;
			}

			RefBaseObject rbo = ModelAdapterUI.getInstance().getRefBaseObject(strSel);
			if (rbo != null) {
				Connection targetConnection = ((Partitionable) rbo).get___Connection();
				Set<RefObject> objs = new HashSet<RefObject>();
				for (Object o : strSel.toArray()) {
					rbo = ModelAdapterUI.getInstance().getRefBaseObject(o);
					if (rbo != null) {
						RefObject rboLocal = (RefObject) ModelAdapter.getInstance().resolveInConnection(rbo, targetConnection);
						objs.add(rboLocal);
					}
				}
				Command deleteCmd = new DeleteElementsCommand(targetConnection, objs);
				try {
					execute(deleteCmd);
					ConnectionManagerUI.getInstance().saveIfNecessary(targetConnection, null);
				} catch (ExecutionCancelledException e) {
					// $JL-EXC$
					// user canceled command execution, undo not necessary since
					// command has been rolled back
				} catch (Exception e) {
					throw new ExecutionException(e.getLocalizedMessage(), e);
				}
			}
		}
		return null;
	}

	private final class DeleteElementsCommand extends Command {

		private final Set<RefObject> objs;

		/**
		 * @param connection
		 */
		protected DeleteElementsCommand(Connection connection, Set<RefObject> objs) {
			super(connection, MiFwkUiMessages.DeleteElementsCmd_desc);
			this.objs = objs;
		}

		@Override
		public boolean canExecute() {
			return this.objs != null && this.objs.size() > 0;
		}

		@Override
		public void doExecute() {
			for (RefObject ro : objs) {
				// only delete living elements
				if (ro.is___Alive()) {
					ro.refDelete();
				}
			}
		}

		@Override
		public Collection<PartitionOperation> getAffectedPartitions() {
			Collection<PRI> affectedPartitions = new HashSet<PRI>();
			JmiHelper helper = getConnection().getJmiHelper();
			for (RefObject ro : objs) {
				affectedPartitions.addAll(helper.getAffectedPartitionsForRefDelete(ro));
			}
			Collection<PartitionOperation> ops = new HashSet<PartitionOperation>();
			for (PRI pri : affectedPartitions) {
				ops.add(new PartitionOperation(PartitionOperation.Operation.EDIT, pri));
			}
			return ops;
		}
	}
}
