package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import data.classes.ClassesPackage;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationResourceLoader;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;


public class NgpmModelBasedOclIaTest extends TestCase {
    Resource ngpmModel = null;
    List<RawNotification> modifyElementaryTypesTrace = null;

    @Override
    public void setUp(){
	ngpmModel = NotificationResourceLoader.loadModel("NgpmModel.xmi");
	modifyElementaryTypesTrace = NotificationResourceLoader.loadTrace("modifyElementaryTypesEventTrace.trace");
    }

    @Test
    public void testVariableExpressionWithCollectionType() {
	OCLExpression exp = (OCLExpression) OclIaTest.parse("context NestedTypeDefinition inv: self.getNamedValuesInScope()", ClassesPackage.eINSTANCE).iterator().next().getSpecification().getBodyExpression();

	RawNotification rawNotification = modifyElementaryTypesTrace.get(1);
	Notification notification = rawNotification.convertToNotification(ngpmModel);

	ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, data.classes.ClassesPackage.eINSTANCE.getNestedTypeDefinition());
	Collection<EObject> impact = ia.getContextObjects(notification);
	assertEquals(impact.size(), 0);
    }

}
