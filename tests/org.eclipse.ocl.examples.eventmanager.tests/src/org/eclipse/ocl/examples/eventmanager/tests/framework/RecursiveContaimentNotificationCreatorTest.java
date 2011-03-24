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
import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
    
    public void testCreateNotificationForMultipleInsertedElements(){
    	EPackage root = EcoreFactory.eINSTANCE.createEPackage();
    	EClass container = EcoreFactory.eINSTANCE.createEClass();
    	root.getEClassifiers().add(container);

    	container.setName("container");
    	EReference conRef = EcoreFactory.eINSTANCE.createEReference();
    	conRef.setName("conRef");
    	conRef.setContainment(true);
    	conRef.setLowerBound(0);
    	conRef.setUpperBound(5);
    	container.getEStructuralFeatures().add(conRef);
    	EClass child = EcoreFactory.eINSTANCE.createEClass();
    	root.getEClassifiers().add(child);
    	child.setName("child");
    	conRef.setEType(child);

    	EObject con = new DynamicEObjectImpl(container);
    	EList<EObject> list = new BasicEList<EObject>();
    	for(int i = 0; i<5; i++){
    		list.add(new DynamicEObjectImpl(child));
    	}
    	con.eSet(conRef, list);
    	
    	EList<EObject> l = new BasicEList<EObject>();
    	l.add(con);
    	Notification n = new ENotificationImpl(new DynamicEObjectImpl(container), Notification.ADD, conRef, null, con);
    	Collection<Notification> result = EventManagerFactory.eINSTANCE.createNotificationForComposites(n);
        /*
         * Expect
         * ADD for container
         * 1 ADD_MANY for 5 children
         */
        assertEquals("Get not expected events",2,result.size());
        Iterator<Notification> iterator = result.iterator();
        Notification n1 = iterator.next();
        Notification n2 = iterator.next();
        /*
         * Expect
         * ADD for container
         * 1 ADD_MANY for 5 children
         */
        assertTrue("Expect Add and Add_Many", 
        		(n1.getEventType() == Notification.ADD && n2.getEventType() == Notification.ADD_MANY) 
        		||
        		(n2.getEventType() == Notification.ADD && n1.getEventType() == Notification.ADD_MANY) 
        		);
        
        EList<EObject> list2 = new BasicEList<EObject>();
    	for(int i = 0; i<1; i++){
    		list2.add(new DynamicEObjectImpl(child));
    	}
    	con.eSet(conRef, list2);
    	n = new ENotificationImpl(new DynamicEObjectImpl(container), Notification.ADD, conRef, null, con);
    	result = EventManagerFactory.eINSTANCE.createNotificationForComposites(n);
        /*
         * Expect
         * ADD for container
         * 1 ADD for 1 children
         */
        assertEquals("Get not expected Events",2,result.size());
        iterator = result.iterator();
        n1 = iterator.next();
        n2 = iterator.next();
        /*
         * Expect
         * ADD for container
         * 1 ADD_MANY for 5 children
         */
        assertTrue("Expect Add and Add", 
        		(n1.getEventType() == Notification.ADD && n2.getEventType() == Notification.ADD) 
        		);
    }

}
