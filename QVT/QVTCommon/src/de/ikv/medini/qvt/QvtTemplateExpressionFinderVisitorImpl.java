/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.model.qvttemplate.TemplateExp;

/**
 * A anexpression finder visitor capable of handling object templates.
 * 
 * @author Michael Wagner
 * @author Omar Ekine
 * @author Joerg Kiegeland
 * 
 */
public class QvtTemplateExpressionFinderVisitorImpl extends QvtExpressionFinderVisitorImpl {

	List templateExpressions = new ArrayList();

	public QvtTemplateExpressionFinderVisitorImpl() {
		super();
	}

	public Object visit(ObjectTemplateExp host, Object data) {
		this.addToTemplateExpressions(host);
		List propertyTemplateItems = host.getPart();
		for (Iterator iter = propertyTemplateItems.iterator(); iter.hasNext();) {
			PropertyTemplateItem currentPropertyTemplateItem = (PropertyTemplateItem) iter.next();
			currentPropertyTemplateItem.accept(this, data);
		}
		return null;
	}

	public List getTemplateExpressions() {
		return this.templateExpressions;
	}

	private void addToTemplateExpressions(TemplateExp templateExp) {
		if (!this.templateExpressions.contains(templateExp)) {
			this.templateExpressions.add(templateExp);
		}
	}

}
