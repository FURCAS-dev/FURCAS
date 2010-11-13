/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package de.hpi.sam.bp2009.solution.impactAnalyzer.impl;

import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;


import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLFactory;


public class OCLFactoryImpl implements OCLFactory {

    public OCL createOCL(EcoreEnvironmentFactory environmentFactory) {
        return OCL.newInstance(environmentFactory);
    }

    public OCL createOCL(OppositeEndFinder oppositeEndFinder) {
        return OCL.newInstance();
    }

}
