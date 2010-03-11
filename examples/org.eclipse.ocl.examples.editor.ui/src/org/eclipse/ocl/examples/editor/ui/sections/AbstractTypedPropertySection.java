/*******************************************************************************
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.ocl.examples.editor.ui.sections;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ocl.examples.common.utils.ClassUtils;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;

public abstract class AbstractTypedPropertySection<T> extends AbstractPropertySection
{
	protected final Class<T> elementClass;
	protected T element;
    private TransactionalEditingDomain editingDomain = null;

	AbstractTypedPropertySection(Class<T> elementClass) {
		this.elementClass = elementClass;
	}

    /**
     * Gets the editing domain from my EObject input.
     * 
     * @return my editing domain
     */
    protected TransactionalEditingDomain getEditingDomain() {
        if (editingDomain == null) {
            if (element instanceof EObject)
                editingDomain = TransactionUtil.getEditingDomain((EObject)element);
            else if (element instanceof Resource)
                editingDomain = TransactionUtil.getEditingDomain((Resource)element);
            else if (element instanceof ResourceSet)
                editingDomain = TransactionUtil.getEditingDomain((ResourceSet)element);
        }
        return editingDomain;
    }
    
    /**
     * Sets the editingDomain.
     * @param editingDomain The editingDomain to set.
     */
    protected void setEditingDomain(TransactionalEditingDomain editingDomain) {
        this.editingDomain = editingDomain;
    }
	
	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		Assert.isTrue(selection instanceof IStructuredSelection);
		Object input = ((IStructuredSelection)selection).getFirstElement();
		Assert.isNotNull(input);
		Assert.isTrue(elementClass.isAssignableFrom(input.getClass()));
		element = ClassUtils.asClassUnchecked(input);
	}
}