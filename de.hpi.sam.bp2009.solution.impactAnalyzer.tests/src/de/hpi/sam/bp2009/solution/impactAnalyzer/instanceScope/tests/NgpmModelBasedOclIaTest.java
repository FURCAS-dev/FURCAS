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
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.model.ModelCloner;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationResourceLoader;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromClassTcsPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;

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
	Notification notification = rawNotification.convertToNotification(ModelCloner.cloneResource(ngpmModel,"1"));

	ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, data.classes.ClassesPackage.eINSTANCE.getNestedTypeDefinition());
	Collection<EObject> impact = ia.getContextObjects(notification);
	assertEquals(impact.size(), 0);
    }

    public void testExpressionWithLargeNavigationStepGraph(){
	OCLExpressionWithContext expr = new OCLExpressionFromClassTcsPicker().pickUpExpression(44);

	Notification notification = getNotification(10, ngpmModel);

	ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(expr.getExpression(), expr.getContext());
	Collection<EObject> impact = ia.getContextObjects(notification);
	assertNotNull(impact);
    }


    private Notification getNotification(int id, Resource model){
         Resource clonedModel = ModelCloner.cloneResource(model, String.valueOf(Math.random()));

        for(int i = 0; i < (id - 1); i++) {
                changeModel(i, clonedModel);
        }
        return changeModel(id - 1, clonedModel);
    }

        private Notification changeModel(int id, Resource clonedModel) {
                RawNotification raw = modifyElementaryTypesTrace.get(id);

        System.out.println(raw.getEventType());
        if(raw.isSplitCandidate()){
                System.out.println("candidate");
                raw.split().get(0).convertToNotification(clonedModel);
                return raw.split().get(1).convertToNotification(clonedModel);
        } else
	    return raw.convertToNotification(clonedModel);
        }

}
