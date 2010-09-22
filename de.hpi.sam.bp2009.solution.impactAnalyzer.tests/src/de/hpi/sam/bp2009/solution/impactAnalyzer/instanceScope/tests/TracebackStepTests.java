package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;

import modelmanagement.ModelmanagementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import data.classes.ClassesFactory;
import data.classes.ClassesPackage;
import data.classes.SapClass;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.configuration.OptimizationActivation;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;

public class TracebackStepTests extends BaseDepartmentTest {
    private EPackage cp;
    private ResourceSetImpl rs;
    private boolean oldTracebackStepISAActive;
    
    @Override
    public void setUp() {
        this.cp = ClassesPackage.eINSTANCE;
        this.rs = new ResourceSetImpl();
        this.rs.eAdapters().add(new ECrossReferenceAdapter());
        this.rs.getResources().add(this.cp.eResource());
        oldTracebackStepISAActive = OptimizationActivation.getOption().isTracebackStepISAActive();
        OptimizationActivation.getOption().setTracebackStepISAActive(true);
    }

    @Override
    public void tearDown() {
        this.rs = null;
        this.cp = null;
        OptimizationActivation.getOption().setTracebackStepISAActive(oldTracebackStepISAActive);
    }

    @Test
    public void testSimpleLetExp() {
        OCLExpression exp = (OCLExpression) parse(
                "context data::classes::SapClass inv testSimpleLetExp:\n"
                        + "let x:data::classes::SapClass=self in x.name", this.cp).iterator().next()
                .getSpecification().getBodyExpression();
        this.cp.eResource().getContents().add(exp);
        SapClass c1 = ClassesFactory.eINSTANCE.createSapClass();
        c1.setName("Trala");
        this.cp.eResource().getContents().add(c1);
        Notification noti = NotificationHelper.createAttributeChangeNotification(c1, ModelmanagementPackage.eINSTANCE
                .getNamedElement_Name(), "Trala", "Humba");
        ImpactAnalyzer ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(exp, ClassesPackage.eINSTANCE.getSapClass());
        Collection<EObject> impact = ia.getContextObjects(noti);
        assertEquals(1, impact.size());
        assertTrue(impact.contains(c1));
    }
}
