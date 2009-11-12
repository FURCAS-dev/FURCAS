package com.sap.ide.moftool.editor.core.commands;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Parameter;

import com.sap.ide.moftool.editor.core.LocalizationMessages;
import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;

/**
 * Command that can be used to changes the sequence of parameters by
 * moving one parameter up or down
 * @author d027044
 */
public class MoveParameterCommand extends Command {
	
	// Constants for indicating the direction of the move
	public static final int DIR_UP = 0;
	public static final int DIR_DOWN = 1;
	
	private Parameter mParameter = null;
	private int mDir = DIR_UP;
	
	private Namespace mContainer = null;
	private int mParameterPosition = -1;
	private Parameter mOtherParameter = null;
	private int mOtherParameterPosition = -1;
	private int mInsertPosition = -1;

	/**
	 * Creates a new command to change the sequence of parameters
	 * @param parameter
	 * The parameter to move up or down
	 * @param dir
	 * Direction (see {@link MoveParameterCommand#DIR_UP} and {@link #DIR_DOWN})
	 * @param connection
	 * The MOIN connection to use for the change
	 */
	public MoveParameterCommand(Parameter parameter, int dir, Connection connection) {
		// Initialize
		super(connection, LocalizationMessages.MoveParameterCommand_0_XMIT);
		mParameter = parameter;
		mDir = dir;
		
		// Search for parameters to exchange
		mContainer = mParameter.getContainer();
		mParameterPosition = mContainer.getContents().indexOf(mParameter);
		ListIterator<ModelElement> iterator = mContainer.getContents().listIterator(mParameterPosition);
		
		// Search for other parameter to switch position
		mOtherParameter = null;
		mOtherParameterPosition = mParameterPosition;
		if (mDir == DIR_UP) {
			// Search for previous parameter
			while (iterator.hasPrevious()) {
				Object object = iterator.previous();
				mOtherParameterPosition--;
				if (object instanceof Parameter) {
					mOtherParameter = (Parameter)object;
					mInsertPosition = mOtherParameterPosition;
					break;
				}
			}
		}
		else {
			// Search for next parameter (we have to skip one otherwise we find the parameter itself)
			if (iterator.hasNext()) {
				iterator.next();
			}
			while (iterator.hasNext()) {
				Object object = iterator.next();
				mOtherParameterPosition++;
				if (object instanceof Parameter) {
					mOtherParameter = (Parameter)object;
					mInsertPosition = mParameterPosition;
					break;
				}
			}
		}
	}

	@Override
	public boolean canExecute() {
		// Command can be executed if another parameter was found and parameter
		// is not foreign
		return ((mOtherParameter != null) && !ModelElementService.isForeignObject(mParameter));
	}

	@Override
	public void doExecute() {
		// Command can be executed if another parameter was found
		if (mOtherParameter != null) {
			// Other parameter exists
			List<ModelElement> contents = mContainer.getContents();
			
			// Remove both parameters ...
			contents.remove(mParameter);
			contents.remove(mOtherParameter);
			
			// ... and add them again in the right sequence 
			if (mParameterPosition < mOtherParameterPosition) {
				// Parameter to move was before other parameter
				contents.add(mInsertPosition, mOtherParameter);
				contents.add(mInsertPosition + 1, mParameter);
			}
			else {
				// Parameter to move was behind other parameter
				contents.add(mInsertPosition, mParameter);
				contents.add(mInsertPosition + 1, mOtherParameter);
			}
		}
	}

	@Override
	public Collection<PartitionOperation> getAffectedPartitions() {
		return MofPartitionService.getAffectedDefaultPartitionsForObjectModification((Partitionable)mParameter);
	}
}
