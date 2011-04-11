package com.sap.furcas.runtime.parser.impl;

import org.eclipse.emf.common.util.URI;

import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit;

/**
 * Allows callers to look up a {@link ModelUpdater} by the {@link URI} of either a
 * {@link Property} or a {@link PropertyInit} taken from a mapping.
 * 
 * @author Axel Uhl (d043530)
 *
 */
public interface ModelUpdaterRegistry {
    ModelUpdater getModelUpdater(URI propertyOrInjectorActionURI);
}
