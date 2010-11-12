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
 * $Id: ICSTOutlinePage.java,v 1.1 2010/03/11 14:51:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.cst;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.part.IPage;

/**
 * Marker-style interface for a CST outline page. This interface defines
 * the minimum requirement for pages within the CST outline view, namely
 * they must be pages (implement <code>IPage</code>) and provide selections
 * (implement <code>ISelectionProvider</code>).
 * <p>
 * Access to a CST outline page begins when an editor is activated. When
 * activation occurs, the CST outline view will ask the editor for its
 * CST outline page. This is done by invoking 
 * <code>getAdapter(ICSTOutlinePage.class)</code> on the editor.  
 * If the editor returns a page, the view then creates the controls for that
 * page (using <code>createControl</code>) and makes the page visible.
 * </p>
 * <p>
 * Clients may implement this interface from scratch, or subclass the
 * abstract base class <code>CSTOutlinePage</code>.
 * </p>
 * <p> 
 * Note that this interface extends <code>ISelectionProvider</code>.
 * This is no longer required in the case of implementors who also 
 * implement <code>IPageBookViewPage</code> (or extend <code>Page</code>)
 * as they are now passed an <code>IPageSite</code> during their initialization 
 * and this site can be configured with a selection provider. 
 * However to avoid a breaking change 
 *  1) this interface will continue to extend ISelectionProvider 
 *  2) if an ICSTOutlinePage does not set a selection provider for its 
 * site, the CSTOutline will continue to use the page itself for 
 * this purpose. 
 * </p> 
 *
 * @see CSTOutlinePage
 */
public interface ICSTOutlinePage extends IPage, ISelectionProvider {
}
