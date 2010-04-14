/***********************************************************************
 * Copyright (c) 2007 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id: EMFRecordingChangeCommand.java,v 1.1 2008/05/26 12:25:14 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.tabbedproperties;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecoretools.tabbedproperties.internal.Messages;

/**
 * An automatic command
 * 
 * @author David Sciamma
 */
public abstract class EMFRecordingChangeCommand extends AbstractCommand {

	private Set<Resource> notifiers;

	private ChangeRecorder recorder;

	private ChangeDescription change;

	/**
	 * Constructor
	 * 
	 * @param resource
	 */
	public EMFRecordingChangeCommand(Resource resource) {
		super(Messages.EMFRecordingChangeCommand_RecordingChangeCommand);
		recorder = new ChangeRecorder();
		notifiers = Collections.singleton(resource);
	}

	/**
	 * I run the runnable when I execute the first time.
	 */
	public void execute() {
		try {
			recorder.beginRecording(notifiers);
			doExecute();
		} finally {
			change = recorder.endRecording();
		}
	}

	/**
	 * I am ready to execute if I haven't recorded any changes, yet.
	 * 
	 * @return boolean
	 */
	protected boolean prepare() {
		return change == null;
	}

	/**
	 * TODO comment this method
	 */
	protected abstract void doExecute();

	/**
	 * Applies (undoes) changes recorded previously, recording the new changes
	 * meanwhile.
	 */
	private void applyChanges() {
		try {
			recorder.beginRecording(notifiers);
			change.apply();
		} finally {
			change = recorder.endRecording();
		}
	}

	/**
	 * I can undo if I have recorded any changes previously.
	 * 
	 * @return boolean
	 */
	public boolean canUndo() {
		return change != null;
	}

	/**
	 * Undoes by applying recorded changes.
	 */
	public void undo() {
		applyChanges();
	}

	/**
	 * Redoes by applying changes recorded in the last undo.
	 */
	public void redo() {
		applyChanges();
	}

	/**
	 * @see org.eclipse.emf.common.command.AbstractCommand#dispose()
	 */
	public void dispose() {
		change = null;
		recorder = null;
		notifiers = null;
	}
}