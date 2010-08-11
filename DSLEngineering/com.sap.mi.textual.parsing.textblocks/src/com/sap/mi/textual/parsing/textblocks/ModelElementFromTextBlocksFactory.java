package com.sap.mi.textual.parsing.textblocks;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import com.sap.mi.textual.parsing.textblocks.observer.TextBlockProxy;

public interface ModelElementFromTextBlocksFactory {

	Collection<? extends EObject> createModelElementsFromTextBlock(TextBlockProxy newVersion);
}
