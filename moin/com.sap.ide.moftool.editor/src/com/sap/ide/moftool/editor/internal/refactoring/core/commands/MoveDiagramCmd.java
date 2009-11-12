package com.sap.ide.moftool.editor.internal.refactoring.core.commands;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.core.runtime.IStatus;

import com.sap.ide.moftool.editor.core.service.DiagramService;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.internal.LocalizationMessages;
import com.sap.mi.gfw.mm.pictograms.Diagram;
import com.sap.mi.gfw.util.LinkUtil;
import com.sap.tc.moin.repository.Connection;

public class MoveDiagramCmd extends AbstractMoveCmd<Diagram> {

	private final MofPackage targetPackage;

	public MoveDiagramCmd(Diagram diag2Move, MofPackage targetPackage, Connection connection) {
		super(diag2Move, connection, LocalizationMessages.MoveDiagramCmd_0_XMSG);
		this.targetPackage = targetPackage;
	}

	public boolean canExecute() {
		return NamespaceService.checkForNewSubobject(targetPackage, getObject2Move().getName()).getSeverity() != IStatus.ERROR;
	}

	@Override
	public void doExecute() {
		MofPackage oldPackage = DiagramService.getDiagramPackage(getObject2Move());
		LinkUtil.removeFromRefObject(getObject2Move(), oldPackage);
		LinkUtil.assignToDiagram(getObject2Move(), targetPackage);
	}
}
