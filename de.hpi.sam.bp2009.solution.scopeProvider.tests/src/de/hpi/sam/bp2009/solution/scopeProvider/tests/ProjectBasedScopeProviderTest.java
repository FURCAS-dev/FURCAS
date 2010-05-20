/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.scopeProvider.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.query2.QueryContext;

import de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider;
import de.hpi.sam.bp2009.solution.scopeProvider.impl.ProjectBasedScopeProviderImpl;
import de.hpi.sam.petriNet.PetriNetFactory;
import de.hpi.sam.petriNet.PetriNetPackage;

/**
 * <!-- begin-user-doc --> A test case for the model object '<em><b>Project Based Scope Provider</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 * <li>
 * {@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#setupForEObjects(org.eclipse.emf.common.util.Collection)
 * <em>Setup For EObjects</em>}</li>
 * <li>
 * {@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#setupForResources(org.eclipse.emf.common.util.Collection)
 * <em>Setup For Resources</em>}</li>
 * <li>
 * {@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.Collection)
 * <em>Setup For Resource Sets</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getForwardScopeAsEObjects() <em>Get Forward Scope
 * As EObjects</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getForwardScopeAsProjects() <em>Get Forward Scope
 * As Projects</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getForwardScopeAsResources() <em>Get Forward
 * Scope As Resources</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getForwardScopeAsURIs() <em>Get Forward Scope As
 * UR Is</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getBackwardScopeAsEObjects() <em>Get Backward
 * Scope As EObjects</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getBackwardScopeAsProjects() <em>Get Backward
 * Scope As Projects</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getBackwardScopeAsResources() <em>Get Backward
 * Scope As Resources</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ProjectBasedScopeProvider#getBackwardScopeAsURIs() <em>Get Backward Scope
 * As UR Is</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setInMemoryResources(org.eclipse.emf.common.util.Collection)
 * <em>Set In Memory Resources</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getInMemoryResources() <em>Get In Memory Resources</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsQueryContext() <em>Get Forward Scope As
 * Query Context</em>}</li>
 * <li>{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsQueryContext() <em>Get Backward Scope As
 * Query Context</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProjectBasedScopeProviderTest extends TestCase {
    Container c1 = new Container();
    Container c2 = new Container();

    private Collection<EObject> iteratorToCollection(Iterator<?> treeIterator) {
        Collection<EObject> treeAsList = new ArrayList<EObject>();
        while (treeIterator.hasNext()) {
            Object next = treeIterator.next();
            if (next instanceof EObject)
                treeAsList.add((EObject) next);
        }
        return treeAsList;
    }

    /**
     * The fixture for this Project Based Scope Provider test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProjectBasedScopeProvider fixture = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static void main(String[] args) {
        TestRunner.run(ProjectBasedScopeProviderTest.class);
    }

    /**
     * Constructs a new Project Based Scope Provider test case with the given name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProjectBasedScopeProviderTest(String name) {
        super(name);
    }

    /**
     * Sets the fixture for this Project Based Scope Provider test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void setFixture(ProjectBasedScopeProvider fixture) {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Project Based Scope Provider test case. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ProjectBasedScopeProvider getFixture() {
        return fixture;
    }

    class Container {
        IProject p;
        Resource r1;
        Resource r2;
        EObject o;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     * @generated NOT
     */
    @Override
    protected void setUp() throws Exception {

        EPackage metaModel = PetriNetPackage.eINSTANCE;
        c1 = serializeModelToProject("1", metaModel);
        c2 = serializeModelToProject("2", metaModel);
        IProject[] projects = { c2.p };
        IProjectDescription desc = c1.p.getDescription();
        desc.setReferencedProjects(projects);
        c1.p.setDescription(desc, null);
    }

    @SuppressWarnings("unused")
    private Resource serializeMetaModel(EPackage package1, String uri) {
        ResourceSet metaResourceSet = new ResourceSetImpl();

        /*
         * Register XML Factory implementation to handle .ecore files
         */
        metaResourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMLResourceFactoryImpl());

        /*
         * Create empty resource with the given URI
         */
        Resource metaResource = metaResourceSet.createResource(URI.createURI(uri));

        /*
         * Add bookStoreEPackage to contents list of the resource
         */
        metaResource.getContents().add(package1);

        package1.setNsURI(uri);
        try {
            /*
             * Save the resource
             */
            metaResource.save(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return metaResource;

    }

    private Container serializeModelToProject(String projectName, EPackage metaModel) {
        IProject p1 = new ProjectCreator(ResourcesPlugin.getWorkspace()).createProject(projectName);
        IFolder folder3 = p1.getFolder("model");
        try {
            folder3.create(false, true, null);
        } catch (CoreException e1) {
            e1.printStackTrace();
        }
        // serializeMetaModel(metaModel,folder3.getRawLocationURI().toString()+"/metaModel.ecore");

        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMLResourceFactoryImpl());
        resourceSet.getPackageRegistry().put(metaModel.getNsURI(), metaModel);
        Resource resource = resourceSet.createResource(URI.createURI(folder3.getRawLocationURI().toString() + "/test1.xmi"));

        resource.getContents().add(PetriNetFactory.eINSTANCE.createPlace());

        /*
         * Save the resource using OPTION_SCHEMA_LOCATION save option toproduce xsi:schemaLocation attribute in the document
         */
        Map<String, Boolean> options = new HashMap<String, Boolean>();
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        try {
            resource.save(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Resource resource1 = resourceSet.createResource(URI.createURI(folder3.getRawLocationURI().toString() + "/test2.xmi"));

        // RandomGeneratorFactory.eINSTANCE.createRandomGenerator().generateRandomModel(1, resource1,metaModel);
        resource1.getContents().add(PetriNetFactory.eINSTANCE.createPlace());

        /*
         * Save the resource using OPTION_SCHEMA_LOCATION save option toproduce xsi:schemaLocation attribute in the document
         */
        Map<String, Boolean> options1 = new HashMap<String, Boolean>();
        options1.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        try {
            resource1.save(options1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Container c = new Container();
        c.p = p1;
        c.r1 = resource;
        c.r2 = resource1;
        return c;

    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#tearDown()
     * @generated NOT
     */
    @Override
    protected void tearDown() throws Exception {
        setFixture(null);
        c1.p.delete(true, null);
        c2.p.delete(true, null);
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.Collection)
     * <em>Setup For EObjects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForEObjects__Collection() {
        int number = c1.r1.getContents().size();
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1.getContents().get(number - 1)));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.Collection)
     * <em>Setup For EObjects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForEObjects__Collection2() {
        EObject[] list = new EObject[2];
        int number = c1.r1.getContents().size();
        list[0] = (c1.r1.getContents().get(number - 1));
        number = c2.r1.getContents().size();
        list[1] = (c2.r1.getContents().get(number - 1));
        setFixture(new ProjectBasedScopeProviderImpl(list));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        result.add(c2.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.Collection)
     * <em>Setup For EObjects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForEObjects(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForEObjects__Collection3() {
        EObject[] list = new EObject[2];
        int number = c1.r1.getContents().size();
        list[0] = (c1.r1.getContents().get(number - 1));
        number = c1.r2.getContents().size();
        list[1] = (c1.r2.getContents().get(number - 1));
        setFixture(new ProjectBasedScopeProviderImpl(list));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.Collection)
     * <em>Setup For Resources</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForResources__Collection() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));
        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.Collection)
     * <em>Setup For Resources</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForResources__Collection2() {
        Resource[] list = new Resource[2];

        list[0] = c1.r1;
        list[1] = c2.r1;
        setFixture(new ProjectBasedScopeProviderImpl(list));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        result.add(c2.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.Collection)
     * <em>Setup For Resources</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResources(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForResources__Collection3() {
        Resource[] list = new Resource[2];
        list[0] = (c1.r1);
        list[1] = (c1.r2);
        setFixture(new ProjectBasedScopeProviderImpl(list));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.Collection)
     * <em>Setup For Resource Sets</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForResourceSets__Collection() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1.getResourceSet()));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.Collection)
     * <em>Setup For Resource Sets</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForResourceSets__Collection2() {
        Resource[] list = new Resource[2];
        list[0] = (c1.r1);
        list[1] = (c2.r1);
        setFixture(new ProjectBasedScopeProviderImpl(list));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        result.add(c2.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '
     * {@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.Collection)
     * <em>Setup For Resource Sets</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#setupForResourceSets(org.eclipse.emf.common.util.Collection)
     * @generated NOT
     */
    public void testSetupForResourceSets__Collection3() {
        ResourceSet rs = new ResourceSetImpl();
        rs.getResources().add(c1.r1);
        rs.getResources().add(c1.r2);
        setFixture(new ProjectBasedScopeProviderImpl(rs));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        Collection<IProject> initprojects = getFixture().getInitialProjects();
        assertTrue(initprojects.containsAll(result) && result.containsAll(initprojects));
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsEObjects()
     * <em>Get Forward Scope As EObjects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsEObjects()
     * @generated NOT
     */
    public void testGetForwardScopeAsEObjects() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));
        ArrayList<EObject> result = new ArrayList<EObject>();
        result.addAll(iteratorToCollection(c1.r1.getAllContents()));
        result.addAll(iteratorToCollection(c1.r2.getAllContents()));
        result.addAll(iteratorToCollection(c2.r1.getAllContents()));
        result.addAll(iteratorToCollection(c2.r2.getAllContents()));

        Collection<EObject> scope = getFixture().getForwardScopeAsEObjects();
        assertTrue(result.size() == scope.size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsEObjects()
     * <em>Get Forward Scope As EObjects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsEObjects()
     * @generated NOT
     */
    public void testGetForwardScopeAsEObjects2() {
        int number = c2.r2.getContents().size();
        setFixture(new ProjectBasedScopeProviderImpl(c2.r2.getContents().get(number - 1)));

        ArrayList<EObject> result = new ArrayList<EObject>();
        result.addAll(iteratorToCollection(c2.r1.getAllContents()));
        result.addAll(iteratorToCollection(c2.r2.getAllContents()));
        Collection<EObject> scope = getFixture().getForwardScopeAsEObjects();
        assertTrue(result.size() == scope.size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsProjects()
     * <em>Get Forward Scope As Projects</em>}' operation.
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsProjects()
     * @generated NOT
     */
    public void testGetForwardScopeAsProjects() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));
        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        result.add(c2.p);
        Collection<IProject> scope = getFixture().getForwardScopeAsProjects();
        assertTrue(scope.containsAll(result) && result.containsAll(scope));
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources()
     * <em>Get Forward Scope As Resources</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources()
     * @Ignore
     */
    public void testGetForwardScopeAsResources() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));

        ArrayList<Resource> result = new ArrayList<Resource>();
        result.add(c1.r1);
        result.add(c1.r2);
        result.add(c2.r1);
        result.add(c2.r2);
        // FIXME
        // getFixture().setInMemoryResources(result);
        Collection<Resource> scope = getFixture().getForwardScopeAsResources();
        assertTrue(scope.size() == result.size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources()
     * <em>Get Forward Scope As Resources</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsResources()
     * @generated NOT
     */
    public void testGetForwardScopeAsResources2() {
        setFixture(new ProjectBasedScopeProviderImpl(c2.r1));

        ArrayList<Resource> result = new ArrayList<Resource>();
        result.add(c2.r1);
        result.add(c2.r2);
        // FIXME getFixture().setInMemoryResources(result);
        Collection<Resource> scope = getFixture().getForwardScopeAsResources();
        assertTrue(scope.size() == result.size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsURIs()
     * <em>Get Forward Scope As UR Is</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsURIs()
     * @generated NOT
     */
    public void testGetForwardScopeAsURIs() {
        setFixture(new ProjectBasedScopeProviderImpl(c2.r1));

        ArrayList<URI> result = new ArrayList<URI>();
        result.add(c2.r1.getURI());
        result.add(c2.r2.getURI());
        Collection<URI> scope = getFixture().getForwardScopeAsURIs();
        assertTrue(scope.containsAll(result) && result.containsAll(scope));
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsURIs()
     * <em>Get Forward Scope As UR Is</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsURIs()
     * @generated NOT
     */
    public void testGetForwardScopeAsURIs2() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));

        ArrayList<URI> result = new ArrayList<URI>();
        result.add(c1.r1.getURI());
        result.add(c1.r2.getURI());
        result.add(c2.r1.getURI());
        result.add(c2.r2.getURI());

        Collection<URI> scope = getFixture().getForwardScopeAsURIs();
        assertTrue(scope.containsAll(result) && result.containsAll(scope));
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsEObjects()
     * <em>Get Backward Scope As EObjects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsEObjects()
     * @generated NOT
     */
    public void testGetBackwardScopeAsEObjects() {
        int number = c2.r2.getContents().size();
        setFixture(new ProjectBasedScopeProviderImpl(c2.r2.getContents().get(number - 1)));

        ArrayList<EObject> result = new ArrayList<EObject>();
        result.addAll(iteratorToCollection(c1.r1.getAllContents()));
        result.addAll(iteratorToCollection(c1.r2.getAllContents()));
        result.addAll(iteratorToCollection(c2.r1.getAllContents()));
        result.addAll(iteratorToCollection(c2.r2.getAllContents()));
        Collection<EObject> scope = getFixture().getBackwardScopeAsEObjects();
        assertTrue(result.size() == scope.size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsEObjects()
     * <em>Get Backward Scope As EObjects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsEObjects()
     * @generated NOT
     */
    public void testGetBackwardScopeAsEObjects2() {
        int number = c1.r1.getContents().size();
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1.getContents().get(number - 1)));

        ArrayList<EObject> result = new ArrayList<EObject>();
        result.addAll(iteratorToCollection(c1.r1.getAllContents()));
        result.addAll(iteratorToCollection(c1.r2.getAllContents()));
        Collection<EObject> scope = getFixture().getBackwardScopeAsEObjects();
        assertTrue(result.size() == scope.size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsProjects()
     * <em>Get Backward Scope As Projects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsProjects()
     * @generated NOT
     */
    public void testGetBackwardScopeAsProjects() {
        setFixture(new ProjectBasedScopeProviderImpl(c2.r1));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);
        result.add(c2.p);

        Collection<IProject> scope = getFixture().getBackwardScopeAsProjects();
        assertTrue(scope.containsAll(result) && result.containsAll(scope));
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsProjects()
     * <em>Get Backward Scope As Projects</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsProjects()
     * @generated NOT
     */
    public void testGetBackwardScopeAsProjects2() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));

        ArrayList<IProject> result = new ArrayList<IProject>();
        result.add(c1.p);

        Collection<IProject> scope = getFixture().getBackwardScopeAsProjects();
        assertTrue(scope.containsAll(result) && result.containsAll(scope));
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsResources()
     * <em>Get Backward Scope As Resources</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsResources()
     * @generated NOT
     */
    public void testGetBackwardScopeAsResources() {
        setFixture(new ProjectBasedScopeProviderImpl(c2.r1));

        ArrayList<Resource> result = new ArrayList<Resource>();
        result.add(c1.r1);
        result.add(c1.r2);
        result.add(c2.r1);
        result.add(c2.r2);
        // FIXME getFixture().setInMemoryResources(result);
        Collection<Resource> scope = getFixture().getBackwardScopeAsResources();
        assertTrue(scope.size() == result.size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsResources()
     * <em>Get Backward Scope As Resources</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsResources()
     * @generated NOT
     */
    public void testGetBackwardScopeAsResources2() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));

        ArrayList<Resource> result = new ArrayList<Resource>();
        result.add(c1.r1);
        result.add(c1.r2);
        // FIXME getFixture().setInMemoryResources(result);
        Collection<Resource> scope = getFixture().getBackwardScopeAsResources();
        assertTrue(scope.size() == result.size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsURIs()
     * <em>Get Backward Scope As UR Is</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsURIs()
     * @generated NOT
     */
    public void testGetBackwardScopeAsURIs() {
        setFixture(new ProjectBasedScopeProviderImpl(c2.r1));

        ArrayList<URI> result = new ArrayList<URI>();
        result.add(c1.r1.getURI());
        result.add(c1.r2.getURI());
        result.add(c2.r1.getURI());
        result.add(c2.r2.getURI());

        Collection<URI> scope = getFixture().getBackwardScopeAsURIs();
        assertTrue(scope.containsAll(result) && result.containsAll(scope));
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getInMemoryResources()
     * <em>Get In Memory Resources</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getInMemoryResources()
     * @generated NOT
     */
    public void testGetInMemoryResources() {
        setFixture(new ProjectBasedScopeProviderImpl(new ResourceSetImpl().createResource(URI.createURI("http://something.ru"))));
        assert (getFixture().getInMemoryResources().size() == 0);
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsQueryContext()
     * <em>Get Forward Scope As Query Context</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getForwardScopeAsQueryContext()
     * @generated NOT
     */
    public void testGetForwardScopeAsQueryContext() {
        //in this test all resources must be located in the same resourceSet, 
        //that is why all resources from c2 are moved to the resourceSet of c1
        c1.r1.getResourceSet().getResources().addAll(c2.r1.getResourceSet().getResources());
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));
        QueryContext context = getFixture().getForwardScopeAsQueryContext();

        ArrayList<URI> result = new ArrayList<URI>();
        result.add(c1.r1.getURI());
        result.add(c1.r2.getURI());
        result.add(c2.r1.getURI());
        result.add(c2.r2.getURI());

        ArrayList<Resource> resultAsRs = new ArrayList<Resource>();
        resultAsRs.add(c1.r1);
        resultAsRs.add(c1.r2);
        resultAsRs.add(c2.r1);
        resultAsRs.add(c2.r2);

        URI[] scope = context.getResourceScope();
        assertTrue(Arrays.asList(scope).containsAll(result) && result.containsAll(Arrays.asList(scope)));
        assertTrue(resultAsRs.size() == context.getResourceSet().getResources().size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsQueryContext()
     * <em>Get Backward Scope As Query Context</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsQueryContext()
     * @generated NOT
     */
    public void testGetBackwardScopeAsQueryContext() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));
        QueryContext context = getFixture().getBackwardScopeAsQueryContext();

        ArrayList<URI> result = new ArrayList<URI>();
        result.add(c1.r1.getURI());
        result.add(c1.r2.getURI());

        ArrayList<Resource> resultAsRs = new ArrayList<Resource>();
        resultAsRs.add(c1.r1);
        resultAsRs.add(c1.r2);

        URI[] scope = context.getResourceScope();
        assertTrue(Arrays.asList(scope).containsAll(result) && result.containsAll(Arrays.asList(scope)));
        assertTrue(resultAsRs.size() == context.getResourceSet().getResources().size());
    }

    /**
     * Tests the '{@link de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsURIs()
     * <em>Get Backward Scope As UR Is</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.hpi.sam.bp2009.solution.scopeProvider.ScopeProvider#getBackwardScopeAsURIs()
     * @generated NOT
     */
    public void testGetBackwardScopeAsURIs2() {
        setFixture(new ProjectBasedScopeProviderImpl(c1.r1));
        ArrayList<URI> result = new ArrayList<URI>();
        result.add(c1.r1.getURI());
        result.add(c1.r2.getURI());

        Collection<URI> scope = getFixture().getBackwardScopeAsURIs();
        assertTrue(scope.containsAll(result) && result.containsAll(scope));
    }

} // ScopeProviderTest
