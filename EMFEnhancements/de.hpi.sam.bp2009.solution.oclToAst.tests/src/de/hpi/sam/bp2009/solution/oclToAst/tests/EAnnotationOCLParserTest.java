/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.oclToAst.tests;

import java.io.IOException;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.query2.EcoreHelper;
import org.eclipse.ocl.expressions.OCLExpression;

import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.ErrorMessage;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;
import de.hpi.sam.bp2009.solution.oclToAst.impl.EAnnotationOCLParserImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>EAnnotation OCL Parser</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement) <em>Convert Ocl Annotation</em>}</li>
 * </ul>
 * </p>
 */
public class EAnnotationOCLParserTest extends TestCase {

	/**
	 * The fixture for this EAnnotation OCL Parser test case.
	 */
	protected EAnnotationOCLParser fixture = null;

	public static void main(String[] args) {
		TestRunner.run(EAnnotationOCLParserTest.class);
	}

	/**
	 * Constructs a new EAnnotation OCL Parser test case with the given name.
	 */
	public EAnnotationOCLParserTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this EAnnotation OCL Parser test case.
	 */
	protected void setFixture(EAnnotationOCLParser fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this EAnnotation OCL Parser test case.
	 * @generated
	 */
	protected EAnnotationOCLParser getFixture() {
		return fixture;
	}

	/**

	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(OclToAstFactory.eINSTANCE.createEAnnotationOCLParser());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement) <em>Convert Ocl Annotation</em>}' operation.
	 * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
	 */
	public void testConvertOclAnnotation__EModelElement() {
		EClass placeC = EcoreFactory.eINSTANCE.createEClass();
		placeC.setName("Place");	
		EAttribute placeTokens = EcoreFactory.eINSTANCE.createEAttribute();
		placeTokens.setName("noTokens");
		placeTokens.setEType(EcorePackage.eINSTANCE.getEInt());
		placeC.getEStructuralFeatures().add(placeTokens);

		EAnnotation anno= EcoreFactory.eINSTANCE.createEAnnotation();
		anno.setSource(EAnnotationOCLParser.ANNOTATION_SOURCE);
		anno.getDetails().put("someKey", "self.noTokens>4");
		placeC.getEAnnotations().add(anno);

		getFixture().convertOclAnnotation(placeC);
		assertTrue(placeC.getEAnnotation(EAnnotationOCLParser.ANNOTATION_SOURCE).getContents().get(0) instanceof OCLExpression<?>);
	}
	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement) <em>Convert Ocl Annotation</em>}' operation.
	 * @see de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser#convertOclAnnotation(org.eclipse.emf.ecore.EModelElement)
	 */
	public void testConvertOclAnnotation__EOperation() {
		EClass aClass= EcoreFactory.eINSTANCE.createEClass();
		aClass.setName("aClass");
		
		EOperation operation = EcoreFactory.eINSTANCE.createEOperation();
		operation.setName("doSomething");	
		EParameter parameter = EcoreFactory.eINSTANCE.createEParameter();
		parameter.setName("noTokens");
		parameter.setEType(EcorePackage.eINSTANCE.getEInt());
		operation.getEParameters().add(parameter);

		aClass.getEOperations().add(operation);
		EAnnotation anno= EcoreFactory.eINSTANCE.createEAnnotation();
		anno.setSource(EAnnotationOCLParser.ANNOTATION_SOURCE);
		anno.getDetails().put("body", "4");
		operation.getEAnnotations().add(anno);
		getFixture().convertOclAnnotation(operation);
		assertTrue(operation.getEAnnotation(EAnnotationOCLParser.ANNOTATION_SOURCE).getContents().get(0) instanceof OCLExpression<?>);
	}
	public void testRunAnnotationsParserOnMdrsMetamodel() {
	        String uri = "file://c:/Documents%20and%20Settings/D043530/emfmdrs-workspace/com.sap.mdrs.ecore/model/mdrs.ecore";
	        final ResourceSet load_resourceSet = new ResourceSetImpl();
	        /*
	         * Register XML Factory implementation using DEFAULT_EXTENSION
	         */
	        load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
	        /*
	         * Load the resource using the URI
	         */
	        Resource r;
			try {
				r = load_resourceSet.getResource(URI.createURI(uri), true);
			} catch (Exception e1) {
				e1.printStackTrace();
				return;
			}
	        EcoreHelper.getInstance().addResourceToDefaultIndex(r);
	        
	        try {
	            r.load(null);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        EAnnotationOCLParser parser = new EAnnotationOCLParserImpl();
	        parser.traversalConvertOclAnnotations((EPackage) r.getContents().get(0));
	        for(ErrorMessage e : parser.getAllOccurredErrorMessages()){
	        	if(e.getException()!=null){
	        		e.getException().printStackTrace();
	        	}
	        }
	        try {
	            r.save(null);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

} //EAnnotationOCLParserTest
