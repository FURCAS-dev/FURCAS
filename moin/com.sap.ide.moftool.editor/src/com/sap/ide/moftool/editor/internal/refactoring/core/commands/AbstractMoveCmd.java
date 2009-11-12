package com.sap.ide.moftool.editor.internal.refactoring.core.commands;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.ide.moftool.editor.core.commands.MofPartitionService;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public abstract class AbstractMoveCmd<T extends RefBaseObject> extends Command {

	private final T object2Move;

	public AbstractMoveCmd(T object2Move, Connection connection, String description) {
		super(connection, description);
		this.object2Move = object2Move;
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectDeletion((Partitionable) object2Move);
	}
	
	protected T getObject2Move() {
		return object2Move;
	}

}