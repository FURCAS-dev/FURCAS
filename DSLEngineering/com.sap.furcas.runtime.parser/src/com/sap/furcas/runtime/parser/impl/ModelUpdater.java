package com.sap.furcas.runtime.parser.impl;

import org.eclipse.emf.common.util.URI;

import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit;

/**
 * Can be used by the parser to update a feature on a model element, based on an OCL definition.
 * Such objects can be obtained from a {@link ModelUpdaterRegistry} using the {@link URI} of
 * a {@link Property} or {@link PropertyInit} that has an OCL definition.
 * 
 * @author Axel Uhl (d043530)
 *
 */
public interface ModelUpdater {

}
