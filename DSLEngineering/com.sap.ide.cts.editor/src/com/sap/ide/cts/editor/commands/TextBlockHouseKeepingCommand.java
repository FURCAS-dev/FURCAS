package com.sap.ide.cts.editor.commands;

import java.util.Collection;

import org.eclipse.core.commands.Command;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.validation.IllegalTextBlocksStateException;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;
import com.sap.ide.cts.editor.CtsActivator;


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

    public TextBlockHouseKeepingCommand(ResourceSet co, IProject project) {
	super(co);
	this.project = project;
    }

    @Override
    public boolean canExecute() {
	return true;
    }
 
    @Override
    public void doExecute() {
	EObject[] allBlocks = getAllTextBlocks(getEditingDomain(), project);

	System.out.println("Clean up started for: " + allBlocks.length + " Blocks");

	for (EObject refObj : allBlocks) {
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
			continue;
		    }
		}
		TbChangeUtil.cleanUp(block);
	    }
	}
	System.out.println("Clean up finished");
    }

    private Boolean handleBrokenMapping(TextBlock block) {
	try {
	    TbValidationUtil.assertTextBlockConsistencyRecursive(block);
	} catch (IllegalTextBlocksStateException e) {
	    CtsActivator.logWarning("Deleteing TB: Borken Mapping AND Inconsistent");
	    return false;
	}
	try {
	    TbValidationUtil.assertCacheIsUpToDate(block);
	} catch (IllegalTextBlocksStateException e) {
	    CtsActivator.logWarning("Deleteing TB: Borken Mapping AND Cached String does not match TB conent.");
	    return false;
	}
	
	
	return true;
    }

    @Override
    public Collection<EOperation> getAffectedPartitions() {
	// Be lazy and just request save for all dirty MOIN based editors
	// in this project
	return null;
    }

    private EObject[] getAllTextBlocks(ResourceSet co, IProject project) {
	IPartitionScopeProvider partitionScopeProvider = PartitionService.getInstance().getPartitionScopeProvider(project, co,
		IPartitionScopeProvider.PartitionScope.INNER);
	QueryScopeProvider queryScopeProvider = QueryService.getInstance().getQueryScopeProvider(partitionScopeProvider);
	MQLResultSet result = co.getMQLProcessor().execute("select tb from textblocks::TextBlock as tb", queryScopeProvider); //$NON-NLS-1$
	EObject[] textBlocks = result.getRefObjects("tb"); //$NON-NLS-1$
	return textBlocks;
    }

}
