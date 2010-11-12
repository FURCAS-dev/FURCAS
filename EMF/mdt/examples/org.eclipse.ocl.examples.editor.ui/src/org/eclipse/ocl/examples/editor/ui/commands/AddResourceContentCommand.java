/*******************************************************************************
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.commands;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class AddResourceContentCommand extends AbstractCommand
{
	protected final Resource resource;
	protected final String typeName;
	protected final EObject content;
	
	public AddResourceContentCommand(Resource resource, String typeName, EObject content) {
		this.resource = resource;
		this.typeName = typeName;
		this.content = content;
	}

	public void execute() {
		redo();
	}

	@Override
	public String getLabel() {
		return "Add " + typeName;
	}

	@Override
	protected boolean prepare() {
		return true;
	}

	public void redo() {
		resource.getContents().add(content);
	}

	@Override
	public void undo() {
		resource.getContents().remove(content);
	}

}
