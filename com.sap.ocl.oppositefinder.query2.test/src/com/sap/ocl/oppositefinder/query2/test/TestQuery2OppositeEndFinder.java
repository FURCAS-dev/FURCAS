package com.sap.ocl.oppositefinder.query2.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.ocl.ecore.VoidType;
import org.junit.Before;
import org.junit.Test;

import com.sap.ocl.oppositefinder.query2.DefaultQueryContextProvider;
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
    
    @Test
    public void testFindOppositeEnds() {
        List<EStructuralFeature> ends = new ArrayList<EStructuralFeature>();
        findOppositeEnds(CompanyPackage.eINSTANCE.getDepartment(), "department2division", ends);
        assertEquals(1, ends.size());
        assertEquals(CompanyPackage.eINSTANCE.getDivision_Department(), ends.get(0));
    }
    
    private void findOppositeEnds(EClassifier classifier, String name, List<EStructuralFeature> ends) {

        if (!(classifier instanceof VoidType)) { // OclVoid has no properties, not even opposites
            ResourceSet rs = classifier.eResource().getResourceSet();
            if (rs == null) {
                rs = new ResourceSetImpl();
            }
            StringBuilder allClassifierSupertypeUris = new StringBuilder();
            allClassifierSupertypeUris.append('[');
            allClassifierSupertypeUris.append(EcoreUtil.getURI(classifier));
            allClassifierSupertypeUris.append("]"); //$NON-NLS-1$
            if (classifier instanceof EClass) { // don't do this for the VoidType
                for (EClass supertype : ((EClass) classifier).getEAllSuperTypes()) {
                    allClassifierSupertypeUris.append(',');
                    allClassifierSupertypeUris.append('[');
                    allClassifierSupertypeUris.append(EcoreUtil.getURI(supertype));
                    allClassifierSupertypeUris.append(']');
                }
            }
            final ResultSet result = QueryProcessorFactory.getDefault().createQueryProcessor(IndexFactory.getInstance()).execute(
                    "select oppositeParent from [http://www.eclipse.org/emf/2002/Ecore#//EReference] as oppositeParent, " + //$NON-NLS-1$
                            "[http://www.eclipse.org/emf/2002/Ecore#//EAnnotation] as annotation, " + //$NON-NLS-1$
                            "[http://www.eclipse.org/emf/2002/Ecore#//EStringToStringMapEntry] as detail, " + //$NON-NLS-1$
                            "[http://www.eclipse.org/emf/2002/Ecore#//EClassifier] as classifier in elements {" + //$NON-NLS-1$
                            allClassifierSupertypeUris + "} " + //$NON-NLS-1$
                            "where oppositeParent.eAnnotations = annotation " + //$NON-NLS-1$
                            "where annotation.details = detail " + //$NON-NLS-1$
                            "where detail.key = 'Property.oppositeRoleName'" + //$NON-NLS-1$
                            "where detail.value = '" + name + "' " + //$NON-NLS-1$ //$NON-NLS-2$
                            "where oppositeParent.eType = classifier", //$NON-NLS-1$
                    new DefaultQueryContextProvider().getForwardScopeQueryContext(rs));
            for (int i = 0; i < result.getSize(); i++) {
                ends.add((EReference) rs.getEObject(result.getUri(i, "oppositeParent"), /* loadOnDemand */true)); //$NON-NLS-1$
            }
        }
    }
    
}
