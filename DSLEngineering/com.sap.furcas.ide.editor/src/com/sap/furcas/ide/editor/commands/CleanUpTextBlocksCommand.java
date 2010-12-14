package com.sap.furcas.ide.editor.commands;

import org.eclipse.emf.common.command.AbstractCommand;

import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.runtime.textblocks.modifcation.TbChangeUtil;


public class CleanUpTextBlocksCommand extends AbstractCommand {

	private final TextBlock rootBlock;
	private TextBlock newRootBlock;

	public CleanUpTextBlocksCommand(TextBlock rootBlock) {
		super("Cleanup Textblocks");
		this.rootBlock = rootBlock;
	}

	@Override
	public boolean canExecute() {
		return true;
	}

	@Override
	public void execute() {
		newRootBlock = (TextBlock) TbChangeUtil.cleanUp(rootBlock);
	}

	@Override
    public void redo() {
        // TODO Auto-generated method stub
        
    }

//    @Override
//    public Collection<?> getAffectedObjects() {
//        URI pri = partitionable.eResource().getURI();
//        EOperation editOperation = new EOperation(EOperation..Operation.EDIT, pri);
//        return Collections.singleton(editOperation);
//    }


	public TextBlock getNewRootBlock() {
		return newRootBlock;
	}

}
