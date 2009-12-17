package com.sap.ide.cts.editor.ocliatests;

import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import ngpm.NgpmPackage;

import org.junit.Before;
import org.junit.Test;

import tcs.ConcreteSyntax;

import com.sap.ap.metamodel.utils.MetamodelUtils;
import com.sap.ide.cts.editor.test.util.StandaloneConnectionBasedTest;
import com.sap.ide.cts.editor.test.util.TcsTestHelper;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.events.ChangeListener;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.OclRegistryService;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

import data.classes.Association;
import data.classes.AssociationEnd;
import data.classes.SapClass;
import dataaccess.expressions.literals.ObjectLiteral;

public class OclIaTest extends
		StandaloneConnectionBasedTest {

	@Before
	public void initParsingHandler() {
		// create tcs Syntax
		ConcreteSyntax tcsSyntax = TcsTestHelper
				.createTcsSyntaxMappingOnConnection(connection);
		assertNotNull(tcsSyntax);
	}

	@Test
	public void testGetFloorTokenNull() throws OclManagerException {
	    ObjectLiteral ol = connection.createElement(ObjectLiteral.CLASS_DESCRIPTOR);
	    SapClass cl1 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	    cl1.setName("HumbaClass1");
	    cl1.setValueType(true);
	    ol.setValueClass(cl1);
	    Association a = connection.createElement(Association.CLASS_DESCRIPTOR);
	    a.setName("Assoc");
	    AssociationEnd ae1 = connection.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	    ae1.setName("Humba1");
	    ae1.setType(MetamodelUtils.createClassTypeDefinitionExactlyOne(connection, cl1));
	    a.getEnds().add(ae1);
	    AssociationEnd ae2 = connection.createElement(AssociationEnd.CLASS_DESCRIPTOR);
	    ae2.setName("Humba2");
	    SapClass cl2 = connection.createElement(SapClass.CLASS_DESCRIPTOR);
	    cl2.setName("HumbaClass2");
	    ae2.setType(MetamodelUtils.createClassTypeDefinitionExactlyOne(connection, cl2));
	    a.getEnds().add(ae2);
	    OclRegistryService oclRegistry = connection.getOclRegistryService();
	    final OclExpressionRegistration registration = oclRegistry
		.getFreestyleRegistry()
		.createExpressionRegistration(
			"testForIA",
			"self.oclAsType(dataaccess::expressions::literals::ObjectLiteral).valueClass.getAssociationEnds().otherEnd()"+
			"->select(ae|ae.name='Humba')",
		    OclRegistrationSeverity.Info, new String[] { "TestOclIA" }, connection.getClass(ObjectLiteral.CLASS_DESCRIPTOR),
		    new RefPackage[] { connection.getPackage(NgpmPackage.PACKAGE_DESCRIPTOR) });
	    EventFilter eventFilter = registration.getEventFilter();
	    connection.getEventRegistry().registerListener(new ChangeListener() {
		@Override
		public void notify(ChangeEvent event) {
		    Set<MRI> affectedElements = registration.getAffectedModelElements((ModelChangeEvent) event, connection);
		    Set<RefBaseObject> elements = new HashSet<RefBaseObject>();
		    for (MRI affectedElementMri : affectedElements) {
			elements.add(connection.getElement(affectedElementMri));
		    }
		    System.out.println("Elements: "+elements);
		}
	    }, eventFilter);
	    ae1.setName("ChangedHumba1");
	}
}
