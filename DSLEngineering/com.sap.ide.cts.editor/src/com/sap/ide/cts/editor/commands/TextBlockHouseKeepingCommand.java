package com.sap.ide.cts.editor.commands;

import java.util.Collection;

import org.eclipse.core.resources.IProject;

import textblocks.TextBlock;

import com.sap.furcas.textual.textblocks.TbChangeUtil;
import com.sap.furcas.textual.textblocks.TbNavigationUtil;
import com.sap.furcas.textual.textblocks.TbValidationUtil;
import com.sap.furcas.textual.textblocks.validation.IllegalTextBlocksStateException;
import com.sap.mi.fwk.IPartitionScopeProvider;
import com.sap.mi.fwk.PartitionService;
import com.sap.mi.fwk.QueryService;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;

/**
 * Command to clean-up all TextBlocks of a project. <b>Generally
 * it is a big workaround and should not be needed at all </b> 
 * 
 * <p>
 * Beyond the normal {@link CleanUpTextBlocksCommand} this command tries to
 * recover broken mappings and deletes all broken and unusable TextBlocks.
 * </p>
 *
 * @author D049157
 * 
 */
public class TextBlockHouseKeepingCommand extends Command {

    private final IProject project;

    public TextBlockHouseKeepingCommand(Connection co, IProject project) {
	super(co);
	this.project = project;
    }

    @Override
    public boolean canExecute() {
	return true;
    }
 
    @Override
    public void doExecute() {
	RefObject[] allBlocks = getAllTextBlocks(getConnection(), project);

	for (RefObject refObj : allBlocks) {
	    TextBlock block = (TextBlock) refObj;

	    if (!block.is___Alive()) {
		// corresponding root might have been deleted before
		continue;
	    }
	    if (block.getVersion() == null) {
		// those blocks should not exist at all
		block.refDelete();
		continue;
	    }

	    if (TbNavigationUtil.isUltraRoot(block)) {
		if (block.getType() == null) {
		    Boolean success = handleBrokenMapping(block);
		    if (!success) {
			// There is nothing we can do
			block.refDelete();
		    }
		}
		TbChangeUtil.cleanUp(block);
	    }

	    try {
		// final check if everything is OK
		if (block.is___Alive()) {
		    TbValidationUtil.assertTextBlockConsistency(block);
		}
	    } catch (IllegalTextBlocksStateException e) {
		// sorry my friend, we failed
		block.refDelete();
	    }
	}
    }

    private Boolean handleBrokenMapping(TextBlock block) {
	System.out.println("Not yet implemented: handle broken Mapping for " + block);
	return true;
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
	// Be lazy and just request save for all dirty MOIN based editors
	// in this project
	return null;
    }

    private RefObject[] getAllTextBlocks(Connection co, IProject project) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project, co,
		IPartitionScopeProvider.PartitionScope.INNER);
	QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet result = co.getMQLProcessor().execute("select tb from textblocks::TextBlock as tb", queryScopeProvider); //$NON-NLS-1$
	RefObject[] textBlocks = result.getRefObjects("tb"); //$NON-NLS-1$
	return textBlocks;
    }

}
