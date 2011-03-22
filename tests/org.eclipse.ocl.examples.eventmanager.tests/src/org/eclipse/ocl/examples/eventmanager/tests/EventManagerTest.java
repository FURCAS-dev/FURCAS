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
package org.eclipse.ocl.examples.eventmanager.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.OrFilter;
import org.eclipse.ocl.examples.eventmanager.tests.filters.ClassFilterTest;
import org.eclipse.ocl.examples.eventmanager.tests.filters.EventFilterTest;
import org.junit.Test;


public class EventManagerTest extends TestCase {

	protected EventManager fixture = null;
	private ResourceImpl res;

	public static class Application extends AdapterImpl implements Adapter {
		private boolean b;

		public Application() {
			b = false;
		}
		public boolean isNotified() {
			return b;
		}
		public void reset() {
			b=false;
		}
		public void notifyChanged(Notification msg) {
			this.b = true;

		}

	}

	public static void main(String[] args) {
		TestRunner.run(EventManagerTest.class);
	}

	protected void setFixture(EventManager fixture) {
		this.fixture = fixture;
	}

	protected EventManager getFixture() {
		return fixture;
	}

	@Override
	public void setUp() throws  Exception {       
		super.setUp();
		ResourceSet set = new ResourceSetImpl();
		res = new ResourceImpl();
		set.getResources().add(res);
		setFixture((EventManager) EventManagerFactory.eINSTANCE.getEventManagerFor(set));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 * @generated NOT
	 */
	@Override
	public void tearDown() {
		EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE.remove("http://de.hpi.sam.bp2009.OCL");
		setFixture(null);
		res = null;
	}

	@Test
	public void testSimpleElementInsertFilter() {
		EClass cls = EcoreFactory.eINSTANCE.createEClass();

		EventFilter f = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(cls);
		res.getContents().add(new DynamicEObjectImpl(cls));
		Application app = new Application();
		getFixture().subscribe(f, app);
		getFixture().handleEMFEvent(new NotificationImpl(Notification.ADD, null, new DynamicEObjectImpl(cls)){
			@Override
			public Object getFeature() {
				EReference ref = EcoreFactory.eINSTANCE.createEReference();
				ref.setContainment(true);        		
				return ref;
			}
		});
		assertTrue("Not notified",app.isNotified());
	}

	@Test
	public void testDoubleElementInsertFilter() {
		EClass cls = EcoreFactory.eINSTANCE.createEClass();

		EventFilter f1 = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(cls);
		EventFilter f2 = EventManagerFactory.eINSTANCE.createFilterForElementInsertionOrDeletion(cls);
		EventFilter f = new OrFilter(f1, f2);
		Application app = new Application();
		getFixture().subscribe(f, app);
		getFixture().handleEMFEvent(new NotificationImpl(Notification.ADD, null, new DynamicEObjectImpl(cls)){
			@Override
			public Object getFeature() {
				EReference ref = EcoreFactory.eINSTANCE.createEReference();
				ref.setContainment(true);        		
				return ref;
			}
		});
		assertTrue("Not notified",app.isNotified());
	}



	/**
	 * Test whether a sucessfully {@link EventManager#subscribe(EventFilter, Adapter) subscribed} {@link Adapter adapter}
	 * get not {@link Adapter#notifyChanged(Notification) notified} after successful {@link EventManager#unsubscribe(Adapter) unsubscription}
	 */
	public void testUnsubscribe__Adapter() {
		EventFilterTest test = new ClassFilterTest();
		Application adapter = new Application();
		assertSubscribeAndUnsubscribe(test, adapter);
	}
	/**
	 * test whether one can subscribe an adapter twice
	 */
	public void testUnsubscribeDouble__Adapter() {
		EventFilterTest test = new ClassFilterTest();
		Application adapter = new Application();
		assertSubscribeAndUnsubscribe(test, adapter);
		assertSubscribeAndUnsubscribe(test, adapter);
	}
	public void testUnsubscribeDoubleAndDifferentFilters__Adapter() {
		Application adapter = new Application();
		assertSubscribeAndUnsubscribe(new ClassFilterTest(), adapter);
		assertSubscribeAndUnsubscribe(new ClassFilterTest(), adapter);
	}
	private void assertSubscribeAndUnsubscribe(EventFilterTest test,
			Application adapter) {
		getFixture().subscribe(test.giveTestFilter(), adapter);
		getFixture().handleEMFEvent(test.giveMatchingNotifications()[0]);
		assertTrue("Subscription failed",adapter.isNotified());
		getFixture().unsubscribe(adapter);
		adapter.reset();
		getFixture().handleEMFEvent(test.giveMatchingNotifications()[0]);
		assertFalse("Unsubscription failed", adapter.isNotified());
	}
	public void testResourceAddContainmentFilter(){
		Application app = new Application();
		getFixture().subscribe(EventManagerFactory.eINSTANCE.createContainmentFilter(), app);
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		res.getContents().add(new DynamicEObjectImpl(cls));
		assertTrue("Not notified",app.isNotified());
	}
} // EventManagerTest
