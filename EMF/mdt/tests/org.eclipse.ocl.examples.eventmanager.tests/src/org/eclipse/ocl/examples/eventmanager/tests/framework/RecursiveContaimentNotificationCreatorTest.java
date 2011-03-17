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
package org.eclipse.ocl.examples.eventmanager.tests.framework;


import java.util.Collection;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class RecursiveContaimentNotificationCreatorTest extends TestCase {

    @Before
    public void setUp() {
        try {
			super.setUp();
		} catch (Exception e) {
			/*...*/
		}
    }

    @After
    public void tearDown(){
        try {
			super.tearDown();
		} catch (Exception e) {
			/*...*/
		}
    }

    @Test
    public void testCreateNotificationForComposites() {
    	EPackage root = EcoreFactory.eINSTANCE.createEPackage();
    	EClass containerCls = EcoreFactory.eINSTANCE.createEClass();
    	root.getEClassifiers().add(containerCls);
    	EClass childCls = EcoreFactory.eINSTANCE.createEClass();
    	root.getEClassifiers().add(childCls);

    	EReference conRef = EcoreFactory.eINSTANCE.createEReference();
    	conRef.setContainment(true);
    	conRef.setEType(childCls);
    	conRef.setLowerBound(0);
    	conRef.setUpperBound(1);
    	conRef.setName("contained");
    	
    	EAttribute attr = EcoreFactory.eINSTANCE.createEAttribute();
    	attr.setEType(EcorePackage.eINSTANCE.getEInt());
    	childCls.getEStructuralFeatures().add(attr);
    	containerCls.getEStructuralFeatures().add(conRef);
    	
    	EObject container = new DynamicEObjectImpl(containerCls);
    	EObject child = new DynamicEObjectImpl(childCls);
    	container.eSet(conRef, child);
    	child.eSet(attr, 2);

    	
    	Notification noti = new ENotificationImpl((InternalEObject) container, Notification.ADD, conRef, null, child);
    	Collection<Notification> list = EventManagerFactory.eINSTANCE.createNotificationForComposites(noti
    	);
        /*
         * Expect
         * SET for child attr
         * ADD of child
         */
        assertTrue("Get "+list.size()+" events, expected 2",list.size()==2);
    }

}
