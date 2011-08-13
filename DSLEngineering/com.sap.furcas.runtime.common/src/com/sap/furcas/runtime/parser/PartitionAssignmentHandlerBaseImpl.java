/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.parser;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * A simple default implementation of the {@link PartitionAssignmentHandlerBase}.
 * It can be used run standalone {@linkplain EMFModelAdapter}s. Parsers shall
 * use a full-blown {@linkplain PartitionAssignmentHandler} instead.
 * 
 * @author Stephan Erb
 */
public class PartitionAssignmentHandlerBaseImpl implements PartitionAssignmentHandlerBase {

    private final Resource resource;

    public PartitionAssignmentHandlerBaseImpl(Resource resource) {
        this.resource = resource;
    }
    
    @Override
    public void assignToDefaultPartition(EObject element) {
        if (element.eResource() != resource) {
            resource.getContents().add(element);
        }
    }

}
