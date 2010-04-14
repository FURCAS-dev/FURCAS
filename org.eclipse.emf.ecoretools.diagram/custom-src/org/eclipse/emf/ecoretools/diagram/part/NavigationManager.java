/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *
 * $Id: NavigationManager.java,v 1.2 2009/05/06 13:36:41 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.part;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecoretools.diagram.Messages;
import org.eclipse.emf.ecoretools.diagram.part.EcoreDiagramEditor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.notation.Diagram;

/**
 * This class is responsible of the navigation through the diagrams. Then it
 * stores the history of this navigation to allow next and previous actions. <br>
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public class NavigationManager {

	private EcoreDiagramEditor editor;

	private int previousLimit = 30;

	private Stack<Diagram> previousDiagrams = new Stack<Diagram>();

	private Stack<Diagram> nextDiagrams = new Stack<Diagram>();

	private List<INavigationListener> eventListeners = new ArrayList<INavigationListener>();

	/**
	 * Constructor
	 * 
	 * @param editor
	 *            the editor
	 */
	public NavigationManager(EcoreDiagramEditor editor) {
		super();
		this.editor = editor;
	}

	/**
	 * Appends the listener to the list of navigation listeners. Multiple adds
	 * result in multiple notifications.
	 * 
	 * @param listener
	 *            the event listener
	 */
	public void addNavigationListener(INavigationListener listener) {
		eventListeners.add(listener);
	}

	/**
	 * Removes the first occurrence of the specified listener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removeNavigationListener(INavigationListener listener) {
		eventListeners.remove(listener);
	}

	/**
	 * Notify the listeners that the active diagram as changed
	 * 
	 * @param newDiagram
	 *            The new active diagram
	 */
	public void notifyListeners(Diagram newDiagram) {
		for (int i = 0; i < eventListeners.size(); i++) {
			eventListeners.get(i).diagramChanged(newDiagram);
		}
	}

	/**
	 * Returns <code>true</code> if a previous action can be performed
	 * 
	 * @return a boolean
	 */
	public boolean canDoPrevious() {
		return !previousDiagrams.isEmpty();
	}

	/**
	 * Returns <code>true</code> if a next action can be performed
	 * 
	 * @return a boolean
	 */
	public boolean canDoNext() {
		return !nextDiagrams.isEmpty();
	}

	/**
	 * Go backward in the browse history
	 */
	public void previous() {
		Diagram oldDiagram = editor.getDiagram();
		// Add a new browse command to the editor command stack
		Diagram prevDiagram = previousDiagrams.pop();
		getEditorCommandStack().execute(createNavigateCommand(prevDiagram.getDiagram()));
		nextDiagrams.add(oldDiagram);
		// Send event
		notifyListeners(prevDiagram.getDiagram());
	}

	/**
	 * Go forward in the browse history
	 */
	public void next() {
		Diagram oldDiagram = editor.getDiagram();
		// Add a new browse command to the editor command stack
		Diagram nextDiagram = nextDiagrams.pop();
		getEditorCommandStack().execute(createNavigateCommand(nextDiagram.getDiagram()));
		previousDiagrams.add(oldDiagram);
		// Send event
		notifyListeners(nextDiagram.getDiagram());
	}

	/**
	 * Creates the navigation command for the given diagram
	 * 
	 * @param newDiagram
	 *            the destination diagram
	 * @return the navigation command
	 */
	private Command createNavigateCommand(Diagram newDiagram) {
		return new ChangeActiveDiagramCommand(editor, newDiagram);
	}

	/**
	 * Change the current diagram
	 * 
	 * @param newDiagram
	 *            the new active diagram
	 */
	public void set(Diagram newDiagram) {
		Diagram oldDiagram = editor.getDiagram();
		if (oldDiagram != newDiagram || (oldDiagram == null && newDiagram == null)) {
			// Add a new browse command to the editor command stack
			getEditorCommandStack().execute(createNavigateCommand(newDiagram));
			// Clear the next stack
			nextDiagrams.clear();
			// Add a new previous diagram
			addPreviousDiagram(editor, oldDiagram);
			// Send event
			notifyListeners(newDiagram);
		}
	}

	private void addPreviousDiagram(EcoreDiagramEditor previousModeler, Diagram diag) {
		if (diag != null) {
			if (getPreviousLimit() > 0) {
				while (previousDiagrams.size() >= getPreviousLimit()) {
					previousDiagrams.remove(0);
				}
			}
			previousDiagrams.push(diag);
		}
	}

	/**
	 * Returns the depth of the browse stack
	 * 
	 * @return the limit
	 */
	public int getPreviousLimit() {
		return previousLimit;
	}

	/**
	 * Returns the command stack of the editor
	 * 
	 * @return the command stack
	 */
	private CommandStack getEditorCommandStack() {
		return (CommandStack) editor.getAdapter(CommandStack.class);
	}

	/**
	 * The GEF command used to store the navigation actions in the editor's
	 * command stack <br>
	 * 
	 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques
	 *         LESCOT</a>
	 */
	private class ChangeActiveDiagramCommand extends Command {

		/** The editor of the new diagram */
		private EcoreDiagramEditor editor;

		/** The diagram which was replaced by the new */
		private Diagram oldDiagram;

		/** The diagram to activate */
		private Diagram newDiagram;

		/**
		 * Constructor in case of the new diagram to be activated in the same editor as the given one
		 * 
		 * @param ed
		 *            the Editor
		 * @param newDiag
		 *            the new active diagram
		 */
		public ChangeActiveDiagramCommand(EcoreDiagramEditor ed, Diagram newDiag) {
			super(Messages.NavigationManager_CreateDiagram);
			this.editor = ed;
			this.newDiagram = newDiag;
		}

		/**
		 * @see org.eclipse.gef.commands.Command#canExecute()
		 */
		public boolean canExecute() {
			return editor != null;
		}

		/**
		 * @see org.eclipse.gef.commands.Command#canUndo()
		 */
		public boolean canUndo() {
			return editor != null;
		}

		/**
		 * @see org.eclipse.gef.commands.Command#execute()
		 */
		public void execute() {
			oldDiagram = editor.getDiagram();
			redo();
		}

		/**
		 * @see org.eclipse.gef.commands.Command#redo()
		 */
		public void redo() {
			editor.changeActiveDiagram(newDiagram);
		}

		/**
		 * @see org.eclipse.gef.commands.Command#undo()
		 */
		public void undo() {
			editor.changeActiveDiagram(oldDiagram);
		}
	}
}
