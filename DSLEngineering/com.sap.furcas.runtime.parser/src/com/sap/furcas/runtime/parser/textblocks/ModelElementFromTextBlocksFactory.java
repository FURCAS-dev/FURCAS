package com.sap.furcas.runtime.parser.textblocks;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.runtime.parser.textblocks.observer.TextBlockProxy;

public interface ModelElementFromTextBlocksFactory {

	Collection<? extends EObject> createModelElementsFromTextBlock(TextBlockProxy newVersion);
}
