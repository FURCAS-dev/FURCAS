package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import company.CompanyFactory;
import company.Department;
import company.impl.DepartmentImpl;

import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.OCLWithHiddenOppositesFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.tests.helper.BaseDepartmentTest;

public class NavigationStepDebugGraphTest extends BaseDepartmentTest  {
    
    private Department dep1;
    private Department dep2;
    private Department dep3;
    
    private static final String recursiveBudgetCalculation = "context Department \n"+
    								"inv: self.sumBudget() < 100000";
    
    protected OCLExpression recursiveBudgetCalculationAST = null;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        createInstances();
        
        this.recursiveBudgetCalculationAST = (OCLExpression) parse( recursiveBudgetCalculation, this.comp).iterator()
	.next().getSpecification().getBodyExpression();
        
        if (this.comp.eResource() != null) {
            this.comp.eResource().getContents().add(this.recursiveBudgetCalculationAST);
        }
        
    }

    @Override
    @After
    public void tearDown() {
        EcoreUtil.delete(this.dep1);
        EcoreUtil.delete(this.dep2);
        EcoreUtil.delete(this.dep3);
        super.tearDown();
    }
    
    @Test
    public void testRecursiveOcl(){
	System.out.println("Test recursive ocl operation call");
	Set<OCLExpression> stmts = new HashSet<OCLExpression>();
	
	stmts.add(this.recursiveBudgetCalculationAST);
	
	Notification noti = NotificationHelper.createAttributeChangeNotification(this.dep3, this.departmentBudget, this.dep3.getBudget(), this.dep3.getBudget() + 20);
	Collection<EObject> instances = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(this.recursiveBudgetCalculationAST, this.dep1.eClass(), /* notifyOnNewContextElements */ false,
	        new OCLWithHiddenOppositesFactory()).getContextObjects(noti);
	
	compareInstances(instances, new EObject[] { this.dep1, this.dep2, this.dep3 });
    }
    
    private void createInstances() {

        this.dep1 = CompanyFactory.eINSTANCE.createDepartment();
        this.dep1.setName("Dep1");
        this.dep1.setBudget(1200);
        this.dep1.setMaxJuniors(5);
        
        this.dep2 = CompanyFactory.eINSTANCE.createDepartment();
        this.dep2.setName("Dep2");
        this.dep2.setBudget(1000);
        this.dep2.setMaxJuniors(5);
        
        dep2.setParentDepartment(dep1);
        dep1.getSubDepartment().add(dep2);
        
        this.dep3 = CompanyFactory.eINSTANCE.createDepartment();
        this.dep3.setName("Dep3");
        this.dep3.setBudget(1000);
        this.dep3.setMaxJuniors(5);
        
        this.dep3.setParentDepartment(dep2);        
        this.dep2.getSubDepartment().add(dep3);
        
        this.allDepartments.add((DepartmentImpl)dep1);
        if (this.comp.eResource() != null) {
            this.comp.eResource().getContents().add(dep1);
        }
    }
    
    /**
     * @param instances
     * @param expectedInstances
     */
    private void compareInstances(Collection<EObject> instances, EObject[] expectedInstances) {

        Set<EObject> expected = new HashSet<EObject>();
        for (int i = 0; i < expectedInstances.length; i++) {
            expected.add(expectedInstances[i]);
        }

        if (instances.containsAll(expected) && instances.size() == expected.size()) {
            System.out.println(">> SUCCESS exact match\n");
        } else if (instances.containsAll(expected) && instances.size() != expected.size()) {
            System.out.println(">> SUCCESS \n excess context instances:\n");
            instances.removeAll(expected);
            for (Iterator<EObject> i = instances.iterator(); i.hasNext();) {
                System.out.println(i.next() + "\n");
            }
        } else {
            System.out.println(">> FAILURE\n");
            expected.removeAll(instances);
            for (EObject o : expected) {
                System.out.print(o + "not in result");
            }
            System.out.println("");
            fail("Returned instances does not match expected instances!");
        }
    }
}
