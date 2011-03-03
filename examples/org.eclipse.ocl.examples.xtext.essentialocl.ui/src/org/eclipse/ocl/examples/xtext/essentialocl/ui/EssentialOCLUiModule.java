/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: EssentialOCLUiModule.java,v 1.4 2011/03/03 20:05:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui;

import org.eclipse.ocl.examples.xtext.base.pivot2cs.BaseLocationInFileProvider;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseDocument;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseEObjectTextHover;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.model.BaseTerminalsTokenTypeToPartitionMapper;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.BaseAntlrTokenToAttributeIdMapper;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLHighlightingConfiguration;
import org.eclipse.ocl.examples.xtext.essentialocl.ui.syntaxcoloring.EssentialOCLSemanticHighlightingCalculator;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.model.ITokenTypeToPartitionTypeMapper;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

/**
 * Use this class to register components to be used within the IDE.
 */
public class EssentialOCLUiModule extends org.eclipse.ocl.examples.xtext.essentialocl.ui.AbstractEssentialOCLUiModule {
	public EssentialOCLUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return BaseAntlrTokenToAttributeIdMapper.class;
	}
	
	public Class<? extends DispatchingEObjectTextHover> bindDispatchingEObjectTextHover() {
		return BaseEObjectTextHover.class;
	}
	
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return BaseLocationInFileProvider.class;
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return EssentialOCLSemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return EssentialOCLHighlightingConfiguration.class;
	}

	public Class<? extends ITokenTypeToPartitionTypeMapper> bindITokenTypeToPartitionTypeMapper() {
		return BaseTerminalsTokenTypeToPartitionMapper.class;
	}

	public Class<? extends XtextDocument> bindXtextDocument() {
		return BaseDocument.class;
	}
}
