package org.eclipse.ocl.examples.eventmanager.tests.filters;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.examples.eventmanager.filters.EventFilter;
import org.eclipse.ocl.examples.eventmanager.filters.PackageFilter;
import org.junit.Test;

public class PackageFilterTest extends EventFilterTest{
	@Override
	protected void setUp() throws Exception{
		super.setUp();
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		PackageFilter f = new PackageFilter(p);
		setFixture(f);
	}
	@Test
	public void testGetFilterCriterion() {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		PackageFilter f = new PackageFilter(p);
		assertTrue("Filter criterion is Package itself", f.getFilterCriterion()==p);
	}


	@Test
	public void testGetEPackage() {
		EPackage p = EcoreFactory.eINSTANCE.createEPackage();
		PackageFilter f = new PackageFilter(p);
		assertTrue("Construtor sets EPackage", p == f.getEPackage());
	}

	@Test
	public void testSetNegated() {
		EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		pkg.getEClassifiers().add(cls);
		EObject notifier = new DynamicEObjectImpl(cls);
		Notification noti = new ENotificationImpl((InternalEObject) notifier, 0, null, null, null);
		
		PackageFilter f = new PackageFilter(pkg);
		f.setNegated(true);
		assertFalse("Matches not notfier from pkg", f.matchesFor(noti));		}

	@Override
	@Test
	public void testMatchesFor__Notification() {
		EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		pkg.getEClassifiers().add(cls);
		EObject notifier = new DynamicEObjectImpl(cls);
		Notification noti = new ENotificationImpl((InternalEObject) notifier, 0, null, null, null);
		
		PackageFilter f = new PackageFilter(pkg);
		assertTrue("Matches notfier from pkg", f.matchesFor(noti));	
	}
	@Test
	public void testNotMatchesFor__Notification() {
		EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
		EPackage secondPkg = EcoreFactory.eINSTANCE.createEPackage();
		EClass cls = EcoreFactory.eINSTANCE.createEClass();
		secondPkg.getEClassifiers().add(cls);
		EObject notifier = new DynamicEObjectImpl(cls);
		Notification noti = new ENotificationImpl((InternalEObject) notifier, 0, null, null, null);
		
		PackageFilter f = new PackageFilter(pkg);
		assertFalse("Do not match foreign cls", f.matchesFor(noti));
	}
	@Override
	EventFilter getFilterFor(Object f) {
		return new PackageFilter((EPackage) f);
	}
	EPackage p1 = EcoreFactory.eINSTANCE.createEPackage();
	@Override
	Object getFilterCriterion1() {
		return p1;
	}
	EPackage p2 = EcoreFactory.eINSTANCE.createEPackage();
	@Override
	Object getFilterCriterion2() {
		return p2;
	}

	EPackage testPkg= EcoreFactory.eINSTANCE.createEPackage();

	EClass testCls = EcoreFactory.eINSTANCE.createEClass();
	{
		testPkg.getEClassifiers().add(testCls);
	}
	
	@Override
	public Notification[] giveMatchingNotifications() {
		return new Notification[]{ new ENotificationImpl(new DynamicEObjectImpl(testCls), 0, null, null, null)};
	}
	@Override
	public Notification giveNotMatchingNotifcation() {
		EPackage otherPkg = EcoreFactory.eINSTANCE.createEPackage();
		EClass otherCls = EcoreFactory.eINSTANCE.createEClass();
		otherPkg.getEClassifiers().add(otherCls);
		return new ENotificationImpl(new DynamicEObjectImpl(otherCls), 0, null, null, null);
	}
	@Override
	public EventFilter giveTestFilter() {
		return getFilterFor(testPkg);
	}
}
