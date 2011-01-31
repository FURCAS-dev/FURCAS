package com.sap.furcas.ide.editor.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.common.util.EcoreHelper;
import com.sap.furcas.runtime.textblocks.TbNavigationUtil;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;
import com.sap.furcas.runtime.textblocks.validation.IllegalTextBlocksStateException;
import com.sap.furcas.runtime.textblocks.validation.TbValidationUtil;

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
public class TextBlockHouseKeepingCommand extends AbstractCommand {

    private final IProject project;
    private final QueryProcessor queryProcessor;
    private final ResourceSet resourceSet;

    public TextBlockHouseKeepingCommand(ResourceSet resourceSet, IProject project) {
	super("Clean-up TextBlocks in project:" + project.getName());
        this.resourceSet = resourceSet;
	this.project = project;
	queryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance());
    }

    @Override
    public boolean canExecute() {
	return true;
    }
 
    @Override
    public void execute() {
        List<EObject> allBlocks = getAllTextBlocks(resourceSet, project);

	System.out.println("Clean up started for: " + allBlocks.size() + " Blocks");

	for (EObject refObj : allBlocks) {
	    TextBlock block = (TextBlock) refObj;

	    if (!EcoreHelper.isAlive(block)) {
		// corresponding root might have been deleted before
		continue;
	    }
	    if (block.getVersion() == null) {
		// those blocks should not exist at all
		EcoreUtil.delete(block);
		continue;
	    }

	    if (TbNavigationUtil.isUltraRoot(block)) {
		if (block.getType() == null) {
		    Boolean success = handleBrokenMapping(block);
		    if (!success) {
			// There is nothing we can do
		        EcoreUtil.delete(block);
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
	    CtsActivator.logWarning("Deleteing TB: Broken Mapping AND Inconsistent");
	    return false;
	}
	try {
	    TbValidationUtil.assertCacheIsUpToDate(block);
	} catch (IllegalTextBlocksStateException e) {
	    CtsActivator.logWarning("Deleteing TB: Broken Mapping AND Cached String does not match TB conent.");
	    return false;
	}
	
	
	return true;
    }

    private List<EObject> getAllTextBlocks(ResourceSet rs, IProject project) {
        //FIXME: How to restrict the query scope to the given project?
	//QueryContext context = EcoreHelper.createProjectDependencyQueryContextProvider(rs, Collections.EMPTY_SET).getForwardScopeQueryContext(context);
        QueryContext context = EcoreHelper.getQueryContext(rs);
	ResultSet result = queryProcessor.execute("select tb from textblocks::TextBlock as tb", context); //$NON-NLS-1$
	
	URI[] resultURIs = result.getUris("tb");
        List<EObject> textBlocks = new ArrayList<EObject>(resultURIs.length);
        
        for (URI uri : resultURIs) {
            textBlocks.add(rs.getEObject(uri, true));
        }
        
	return textBlocks;
    }

    @Override
    public void redo() {
        // TODO Auto-generated method stub
        
    }

}
