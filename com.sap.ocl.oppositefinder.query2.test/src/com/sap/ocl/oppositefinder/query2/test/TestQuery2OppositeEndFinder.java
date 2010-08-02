package com.sap.ocl.oppositefinder.query2.test;

import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Before;
import org.junit.Test;

import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;
import company.CompanyFactory;
import company.CompanyPackage;
import company.Department;
import company.Division;
import company.Freelance;
import company.Student;

public class TestQuery2OppositeEndFinder extends TestCase {
    private Query2OppositeEndFinder oppositeEndFinder = Query2OppositeEndFinder.getInstance();
    private ResourceSet rs;
    private Resource r;
    private Division div1;
    private Department dep1;
    private Department dep2;
    private Student student;
    private Freelance freelance;
    
    @Before
    public void setUp() {
        rs = new ResourceSetImpl();
        r = rs.createResource(URI.createURI("file:///humba.xmi"));
        rs.getResources().add(r);
        div1 = CompanyFactory.eINSTANCE.createDivision();
        div1.setName("div1");
        r.getContents().add(div1);
        dep1 = CompanyFactory.eINSTANCE.createDepartment();
        dep1.setName("dep1");
        div1.getDepartment().add(dep1);
        dep2 = CompanyFactory.eINSTANCE.createDepartment();
        dep1.setName("dep2");
        div1.getDepartment().add(dep2);
        student = CompanyFactory.eINSTANCE.createStudent();
        student.setName("student");
        dep1.getEmployee().add(student);
        freelance = CompanyFactory.eINSTANCE.createFreelance();
        freelance.setName("freelance");
        dep2.getEmployee().add(freelance);
    }
    
    @Test
    public void testAllInstancesForAbstractBaseClass() {
        Set<EObject> allEmployees = oppositeEndFinder.getAllInstancesSeeing(CompanyPackage.eINSTANCE.getEmployee(), div1);
        assertTrue(allEmployees.contains(student));
        assertTrue(allEmployees.contains(freelance));
    }
}
