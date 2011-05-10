/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: NaturelessEditorCallback.java,v 1.1 2011/05/05 20:34:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.model;

import org.eclipse.xtext.ui.editor.AbstractDirtyStateAwareEditorCallback;

/**
 * NaturelessEditorCallback is used in place of NatureAddingEditorCallback to suppress
 * the unnecessary add-nature pop-up.
 */
public class NaturelessEditorCallback extends AbstractDirtyStateAwareEditorCallback {

}
