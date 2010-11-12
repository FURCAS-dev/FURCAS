/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * $Id: AbstractUnparser.java,v 1.2 2010/04/08 06:26:27 ewillink Exp $
 *
 * </copyright>
 *
 * $Id: AbstractUnparser.java,v 1.2 2010/04/08 06:26:27 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.unparser;

import org.eclipse.emf.ecore.resource.Resource;

public abstract class AbstractUnparser implements IUnparser
{
	protected final Resource resource;
	private final StringBuffer buffer = new StringBuffer();
	private int indentDepth = 0;
	private boolean startOfLine = true;

	public AbstractUnparser(Resource resource) {
		this.resource = resource;
	}

	public void append(String string) {
		if (string == null)
			return;
		int start = 0;
		int end = string.length();
		while (start < end) {
			int index = string.indexOf('\n', start);
			if (startOfLine && (indentDepth > 0))
				for (int i = indentDepth; i > 0; --i)
					buffer.append("    ");
			buffer.append(string.substring(start, index >= 0 ? index : end));
			if (index >= 0) {
				buffer.append("\n");
				startOfLine = true;
				start = index + 1;
			}
			else {
				start = end;
				startOfLine = false;
			}
		}
	}
	
	public void appendName(Object object) {
		append(formatName(object));
	}
	
	public void appendQualifiedName(Object object) {
		append(formatQualifiedName(object));
	}

	public void exdent() {
		assert indentDepth > 0;
		indentDepth--;		
	}
	
	protected abstract String formatName(Object object);

	protected abstract String formatQualifiedName(Object object);

	public byte[] getBytes() {
		return buffer.toString().getBytes();
	}

	public String getString() {
		return buffer.toString();
	}

	public void indent() {
		indentDepth++;		
	}
	
	protected void initialize() {}

	public abstract void unparse();

	protected void unparseUnsupported(Object object) {
		append("***" + getClass().getSimpleName() + "-Unsupported-" + object.getClass().getSimpleName() + "***\n");
	}
}
