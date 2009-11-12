package com.sap.ide.moftool.editor.internal.refactoring.core.commands;


import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.internal.LocalizationMessages;
import com.sap.tc.moin.repository.Connection;

/**
 * @author D052321
 *
 */
public class MoveAssocCmd extends AbstractMoveCmd<Association> {

	private final MofPackage targetPackage;

	public MoveAssocCmd(Association assoc2Move, MofPackage targetPackage, Connection connection) {
		super(assoc2Move, connection, LocalizationMessages.MoveAssocCmd_0_XMSG);
		this.targetPackage = targetPackage;
	}

	@Override
	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(targetPackage, getObject2Move().getName()).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		getObject2Move().setContainer(targetPackage);
	}

}
