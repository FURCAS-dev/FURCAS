/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonNonProposal.java,v 1.1 2010/03/11 14:51:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import org.eclipse.imp.editor.SourceProposal;
import org.eclipse.jface.text.IDocument;

public class CommonNonProposal extends SourceProposal implements ICommonProposal
{
	public CommonNonProposal(String proposal, String prefix, int offset) {
		super(proposal, proposal, prefix, offset);
	}

	@Override
	public void apply(IDocument document) {}		// Do nothing

	public int compareTo(ICommonProposal o) {
		return getDisplayString().compareTo(o.getDisplayString());	// FIXME Class sort first
	}
}