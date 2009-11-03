package com.sap.mi.gfw.command;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.gfw.Messages;
import com.sap.mi.gfw.features.IFeatureProvider;

/**
 * The Class CommandContainer.
 */
public class CommandContainer implements ICommand {

	/**
	 * The commands.
	 */
	List<ICommand> commands = new ArrayList();

	/**
	 * The executed.
	 */
	boolean executed = false;

	/**
	 * The feature provider.
	 */
	IFeatureProvider featureProvider;

	/**
	 * Instantiates a new command container.
	 * 
	 * @param featureProvider
	 *            the feature provider
	 */
	public CommandContainer(IFeatureProvider featureProvider) {
		super();
		this.featureProvider = featureProvider;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.ICommand#canExecute()
	 */
	public boolean canExecute() {
		if (executed) {
			return false;
		}

		boolean ret = true;
		for (ICommand c : commands) {
			ret = ret && c.canExecute();
			if (ret == false) {
				break;
			}
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.ICommand#execute()
	 */
	public boolean execute() {
		if (!canExecute()) {
			return false;
		}

		boolean ret = true;
		for (ICommand c : commands) {
			ret = ret && c.execute();
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.ICommand#canUndo()
	 */
	public boolean canUndo() {
		if (!executed) {
			return false;
		}
		boolean ret = true;
		for (ICommand c : commands) {
			ret = ret && c.canUndo();
			if (ret == false) {
				break;
			}
		}
		return ret;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.command.ICommand#undo()
	 */
	public boolean undo() {
		if (!canUndo()) {
			return false;
		}

		boolean ret = true;
		for (ICommand c : commands) {
			ret = ret && c.undo();
		}
		return ret;
	}

	/**
	 * Adds the.
	 * 
	 * @param command
	 *            the command
	 */
	public void add(ICommand command) {
		commands.add(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.IDescription#getDescription()
	 */
	public String getDescription() {
		final int size = commands.size();
		String ret = ""; //$NON-NLS-1$
		if (size > 0) {
			if (size > 1) {
				ret = size + " " + Messages.CommandContainer_0_xfld; //$NON-NLS-1$
				ret = ret + " ("; //$NON-NLS-1$
				boolean begin = true;
				for (ICommand c : commands) {
					if (!begin) {
						ret = ret + ", "; //$NON-NLS-1$
					}
					ret = ret + c.getDescription();
					begin = false;
				}
				ret = ret + ")"; //$NON-NLS-1$
			} else {
				final ICommand firstCommand = commands.get(0);
				if (firstCommand != null) {
					ret = firstCommand.getDescription();
				}
			}
		}

		return ret;
	}

	/**
	 * Contains commands.
	 * 
	 * @return true, if successful
	 */
	public boolean containsCommands() {
		return commands != null && commands.size() > 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sap.mi.gfw.features.IFeatureProviderHolder#getFeatureProvider()
	 */
	public IFeatureProvider getFeatureProvider() {
		return featureProvider;
	}

	/**
	 * Gets the commands.
	 * 
	 * @return the commands
	 */
	public ICommand[] getCommands() {
		return commands.toArray(new ICommand[0]);
	}
}
