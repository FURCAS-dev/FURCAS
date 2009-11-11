package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.NamespaceService;
import com.sap.ide.moftool.editor.exec.ExecMOFToolDefaultImpl;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

public class ChangeReturnTypeCommand extends Command {

	Operation mOp;
	RefObject mType;

	public ChangeReturnTypeCommand(Connection connection, String description, Operation op, RefObject type) {
		super(connection, LocalizationMessages.ChangeReturnTypeCommand_0_XMIT);
		mOp = op;
		mType = type;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void doExecute() {
		// TODO Auto-generated method stub
		Boolean returnParameterExists = false;
		Parameter param = null;
		Parameter retParam = null;
		
		mOp.setName(mOp.getName());
		
		List<ModelElement> contents = mOp.getContents();
		for (ModelElement obj : contents) {
			if (obj instanceof Parameter) {
				param = (Parameter)obj;
				// TODO
				if (param.getDirection().equals(DirectionKindEnum.RETURN_DIR)) {
					returnParameterExists = true;
					break;
				}
			}
		}			
		if (returnParameterExists ) {
			retParam = param;
		} else {
			// Create the name for the new parameter
			String name = NamespaceService.getValidNameForNewSubobject(mOp, ExecMOFToolDefaultImpl.NEW_PARAMETER_NAME);		        
			// Create the new parameter
			CreateParameterCommand command = new CreateParameterCommand(name, DirectionKindEnum.RETURN_DIR,
					mOp, ModelAdapter.getInstance().getConnection(mOp));
	        command.execute();
			retParam = command.getParameter();
		}
		if (mType instanceof Classifier) {
			retParam.setType((Classifier)mType);

		}
	}
	
	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectModification((Partitionable)mOp);
	}


}
