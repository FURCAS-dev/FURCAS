/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider.tests;

import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import de.hpi.sam.bp2009.benchframework.randomGenerator.RandomGeneratorFactory;
import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.ScopeProviderFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Scope Provider</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.EList) <em>Setup For EObjects</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.EList) <em>Setup For Resources</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.EList) <em>Setup For Resource Sets</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsEObjects() <em>Get Forward Scope As EObjects</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsProjects() <em>Get Forward Scope As Projects</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources() <em>Get Forward Scope As Resources</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsURIs() <em>Get Forward Scope As UR Is</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsEObjects() <em>Get Backward Scope As EObjects</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsProjects() <em>Get Backward Scope As Projects</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsResources() <em>Get Backward Scope As Resources</em>}</li>
 *   <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsURIs() <em>Get Backward Scope As UR Is</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ScopeProviderTest extends TestCase {

	/**
	 * The fixture for this Scope Provider test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeProvider fixture = null;
	private Container c1;
	private Container c2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ScopeProviderTest.class);
	}

	/**
	 * Constructs a new Scope Provider test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeProviderTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Scope Provider test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(ScopeProvider fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Scope Provider test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScopeProvider getFixture() {
		return fixture;
	}
	class Container{
		IProject p;
		Resource r1;
		Resource r2;
		EObject o;
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		c1=createProjectWithResources("1");
		c2=createProjectWithResources("2");
		IProject[] projects={c2.p};
		IProjectDescription desc = c1.p.getDescription();
		desc.setReferencedProjects(projects);
		c1.p.setDescription(desc, null);
	}

	private Container createProjectWithResources(String projectName)
			throws CoreException, IOException {
		IProject p1 = new ProjectCreator(ResourcesPlugin.getWorkspace()).createProject(projectName);
		setFixture(ScopeProviderFactory.eINSTANCE.createScopeProvider());
		IFolder folder3 = p1.getFolder("model");

		NullProgressMonitor monitor = new NullProgressMonitor();

		// "creating package = 3 folders"
		folder3.create(false, true, monitor);	
		
		ResourceSetImpl resultRS = new ResourceSetImpl();
		Resource resource1 = resultRS.createResource(URI.createURI(folder3.getRawLocationURI().toString()+"/test1.xmi"));
		
		EPackage metaModel=RandomGeneratorFactory.eINSTANCE.createRandomGeneratorOptionObject().getMetaModel();
		resultRS.getPackageRegistry().put(metaModel.getNsURI(), metaModel);		
		RandomGeneratorFactory.eINSTANCE.createRandomGenerator().generateRandomModel(1, resource1,metaModel);
		
		resource1.save(null);
		Resource resource2 = resultRS.createResource(URI.createURI(folder3.getRawLocationURI().toString()+"/test2.xmi"));
		
		resultRS.getPackageRegistry().put(metaModel.getNsURI(), metaModel);		
		RandomGeneratorFactory.eINSTANCE.createRandomGenerator().generateRandomModel(1, resource2,metaModel);
		
		resource2.save(null);
		Container c= new Container();
		c.p=p1;
		c.r1=resource1;
		c.r2=resource2;
		return c;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
		c1.p.delete(true, null);
		c2.p.delete(true, null);
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.EList) <em>Setup For EObjects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	public void testSetupForEObjects__EList() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.EList) <em>Setup For Resources</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	public void testSetupForResources__EList() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.EList) <em>Setup For Resource Sets</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.EList)
	 * @generated
	 */
	public void testSetupForResourceSets__EList() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsEObjects() <em>Get Forward Scope As EObjects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsEObjects()
	 * @generated
	 */
	public void testGetForwardScopeAsEObjects() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsProjects() <em>Get Forward Scope As Projects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsProjects()
	 * @generated NOT
	 */
	public void testGetForwardScopeAsProjects() {
		BasicEList<Resource> list= new BasicEList<Resource>();
		list.add(c1.r1);
		getFixture().setupForResources(list);
		
		BasicEList<IProject> result= new BasicEList<IProject>();
		result.add(c1.p);
		result.add(c2.p);
		assertTrue(getFixture().getForwardScopeAsProjects().containsAll(result));
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources() <em>Get Forward Scope As Resources</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources()
	 * @generated NOT
	 */
	public void testGetForwardScopeAsResources() {
		BasicEList<Resource> list= new BasicEList<Resource>();
		list.add(c1.r1);
		getFixture().setupForResources(list);
		
		BasicEList<Resource> result= new BasicEList<Resource>();
		result.add(c1.r1);
		result.add(c1.r2);
		result.add(c2.r1);
		result.add(c2.r2);
		assertTrue(getFixture().getForwardScopeAsResources().containsAll(result));
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources() <em>Get Forward Scope As Resources</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources()
	 * @generated NOT
	 */
	public void testGetForwardScopeAsResources2() {
		BasicEList<Resource> list= new BasicEList<Resource>();
		list.add(c2.r1);
		getFixture().setupForResources(list);
		
		BasicEList<Resource> result= new BasicEList<Resource>();
		result.add(c2.r1);
		result.add(c2.r2);
		assertTrue(getFixture().getForwardScopeAsResources().containsAll(result));
	}
	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsURIs() <em>Get Forward Scope As UR Is</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsURIs()
	 * @generated
	 */
	public void testGetForwardScopeAsURIs() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsEObjects() <em>Get Backward Scope As EObjects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsEObjects()
	 * @generated
	 */
	public void testGetBackwardScopeAsEObjects() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsProjects() <em>Get Backward Scope As Projects</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsProjects()
	 * @generated
	 */
	public void testGetBackwardScopeAsProjects() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsResources() <em>Get Backward Scope As Resources</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsResources()
	 * @generated
	 */
	public void testGetBackwardScopeAsResources() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

	/**
	 * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsURIs() <em>Get Backward Scope As UR Is</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsURIs()
	 * @generated
	 */
	public void testGetBackwardScopeAsURIs() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //ScopeProviderTest
