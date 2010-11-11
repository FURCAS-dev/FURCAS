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
package de.hpi.sam.bp2009.solution.oclToAst;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.ocl.ecore.delegate.DelegateDomain;
import org.eclipse.ocl.ecore.delegate.DelegateDomain.Factory.Registry;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.osgi.framework.BundleContext;

/**
 * When started, registers the {@link OclAstDelegateDomain} with the {@link DelegateDomain.Factory.Registry}
 * for the URI 
 * 
 * @author Axel Uhl
 *
 */
public class Activator extends Plugin {

    @Override
    public void start(BundleContext context) throws Exception {
        Registry delegateDomainFactoryRegistry = DelegateDomain.Factory.Registry.INSTANCE;
        delegateDomainFactoryRegistry.put(OCLDelegateDomain.OCL_DELEGATE_URI, DelegateDomain.Factory.INSTANCE);
    }

}
