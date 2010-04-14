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
 * $Id: PackageComponentEditPolicy.java,v 1.4 2009/01/29 10:02:08 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.diagram.edit.policies;

import java.util.List;

import org.eclipse.emf.ecoretools.diagram.edit.commands.RemoveDiagramCommand;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.MultiDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * Remove package associated diagrams <br>
 * creation : 01 sept. 2007
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 * @author <a href="mailto:david.sciamma@anyware-tech.com">David Sciamma</a>
 */
public class PackageComponentEditPolicy extends ComponentEditPolicy {

	/**
	 * Takes into account linked diagrams
	 */
	@Override
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompositeCommand cc = new CompositeCommand(null);

		TransactionalEditingDomain editingDomain = getEditingDomain();
		if (editingDomain == null) {
			return null;
		}
		List<?> toDel = deleteRequest.getEditParts();
		if (toDel == null || toDel.isEmpty()) {
			deleteLinkedDiagram(cc, getHost());
			cc.compose(new DeleteCommand(editingDomain, (View) getHost().getModel()));
		} else {
			for (int i = 0; i < toDel.size(); i++) {
				IGraphicalEditPart gep = (IGraphicalEditPart) toDel.get(i);
				deleteLinkedDiagram(cc, gep);
				cc.compose(new DeleteCommand(editingDomain, (View) gep.getModel()));
			}
		}
		return new ICommandProxy(cc.reduce());
	}

	private void deleteLinkedDiagram(CompositeCommand cc, EditPart editPart) {
		View view = (View) editPart.getModel();
		MultiDiagramLinkStyle style = (MultiDiagramLinkStyle) view.getStyle(NotationPackage.eINSTANCE.getMultiDiagramLinkStyle());
		if (style != null) {
			cc.compose(new RemoveDiagramCommand(style));
		}
	}

	private TransactionalEditingDomain getEditingDomain() {
		if (getHost() instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart) getHost()).getEditingDomain();
		} else if (getHost() instanceof IEditingDomainProvider) {
			Object domain = ((IEditingDomainProvider) getHost()).getEditingDomain();
			if (domain instanceof TransactionalEditingDomain) {
				return (TransactionalEditingDomain) domain;
			}
		}
		return null;
	}

}
