package org.eclipse.emf.query2.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.DirtyResourceFactory;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;

import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.test.mm.Company.CompanyFactory;
import org.eclipse.emf.query2.test.mm.Company.CompanyPackage;
import org.eclipse.emf.query2.test.mm.Company.Department;
import org.eclipse.emf.query2.test.mm.Company.Division;
import org.eclipse.emf.query2.test.mm.Company.Employee;
import org.eclipse.emf.query2.test.mm.Company.Freelance;
import org.eclipse.emf.query2.test.mm.Company.Student;
import org.eclipse.emf.query2.test.mm.Company.Transport;
import org.eclipse.emf.query2.test.setup.IndexSetupManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This test primarily contains the tests for the bugs solved for bugzilla.
 * Please mark the test with the Bugzilla ID for future reference.
 * 
 * @author Saurav Sarkar
 * 
 */
public class TestQueryBugs extends QueryTestCase {
	private ResourceSet rs;
	private Resource r;
	private Resource r1;
	private Division div1;
	private Department dep1;
	private Division div2inRes2;
	private Division div1inRes2;
	private Department dep2;
	private Department dep1inres2;

	private Student student;
	private Freelance freelance;
	private Employee director;
	private Employee secretary;
	private Transport truck;

	@Before
	public void setUp() {
		rs = new ResourceSetImpl();
		
		IPath path = QueryTestsPlugin.getPluginInstance().getStateLocation();
		String res1URI = path.append("/test1.xmi").toOSString(); //$NON-NLS-1$
		r = rs.createResource(URI.createFileURI(res1URI));

		div1 = CompanyFactory.eINSTANCE.createDivision();
		div1.setName("div1"); //$NON-NLS-1$

		dep1 = CompanyFactory.eINSTANCE.createDepartment();
		dep1.setName("dep1"); //$NON-NLS-1$
		dep1.setBudget(50);
		div1.getDepartment().add(dep1);
		director = CompanyFactory.eINSTANCE.createEmployee();
		director.setName("director"); //$NON-NLS-1$
		div1.setDirector(director);
		secretary = CompanyFactory.eINSTANCE.createEmployee();
		secretary.setName("secretary"); //$NON-NLS-1$
		dep1.getEmployee().add(director);
		truck = CompanyFactory.eINSTANCE.createTransport();
		truck.setName("truck"); //$NON-NLS-1$

		div1.setBudget(70);
		dep2 = CompanyFactory.eINSTANCE.createDepartment();
		dep1.setName("dep2"); //$NON-NLS-1$
		div1.getDepartment().add(dep2);
		student = CompanyFactory.eINSTANCE.createStudent();
		student.setName("student"); //$NON-NLS-1$
		dep1.getEmployee().add(student);
		freelance = CompanyFactory.eINSTANCE.createFreelance();
		freelance.setName("freelance"); //$NON-NLS-1$
		dep2.getEmployee().add(freelance);
		String res2URI = path.append("/test2.xmi").toOSString(); //$NON-NLS-1$
		r1 = rs.createResource(URI.createFileURI(res2URI));

		dep1inres2 = CompanyFactory.eINSTANCE.createDepartment();
		dep1inres2.setName("dep1inres2"); //$NON-NLS-1$
		dep1inres2.setBudget(50);

		div1.getDepartment().add(dep1inres2);
		div1inRes2 = CompanyFactory.eINSTANCE.createDivision();
		div1inRes2.setName("div1inRes2"); //$NON-NLS-1$

		div1inRes2.getDepartment().add(dep1inres2);
		r.getContents().add(dep1);
		r.getContents().add(dep2);
		r.getContents().add(director);
		r.getContents().add(student);
		r.getContents().add(freelance);
		r1.getContents().add(dep1inres2);
		r.getContents().add(div1);
		r1.getContents().add(div1inRes2);
		r1.getContents().add(truck);
		r.getContents().add(div1);

		IndexSetupManager.index(IndexFactory.getInstance(), r);
		IndexSetupManager.index(IndexFactory.getInstance(), r1);

		try {
			r.save(null);
			r1.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		r.unload();
		r1.unload();

		// Add the DirtyResourceFactory as an adapter to the resource set

		rs.eAdapters().add(DirtyResourceFactory.getInstance());
	}

	/**
	 * This tests test the DirtyResourceFactory which is an eContentAdapter
	 * which keeps track of the dirty resources. This check the backward
	 * navigation which happens from divison to transport. Check
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=324176
	 */
	@Test
	public void testDirtyResourceFactory_Bug324176() {
		ResultSet resultSet = null;

		String query = "select div.name, dep.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.DEPARTMENT) + "] as dep, " + "[" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ EcoreUtil.getURI(CompanyPackage.Literals.TRANSPORT) + "] as trans, [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + "] as div " //$NON-NLS-1$ //$NON-NLS-2$
				+ " where div.department = dep" + " where div.commuting = trans" + " where dep.budget > 60"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		QueryProcessor createQueryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(getDefaultIndexStore());
		try {
			r1.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// truck has been added as the 3rd element
		truck = (Transport) r1.getContents().get(2);
		div2inRes2 = CompanyFactory.eINSTANCE.createDivision();
		r1.getContents().add(div2inRes2);
		div2inRes2.setName("div2inRes2"); //$NON-NLS-1$
		Department dep2inRes2 = CompanyFactory.eINSTANCE.createDepartment();
		dep2inRes2.setName("dep2inRes2"); //$NON-NLS-1$
		r1.getContents().add(dep2inRes2);

		div2inRes2.getDepartment().add(dep2inRes2);
		div2inRes2.setCommuting(truck);

		dep2inRes2.setBudget(100);

		resultSet = createQueryProcessor.execute(query, this.getQueryContext());
		assertEquals(resultSet.getAttribute(0, "div", "name"), this.div2inRes2.getName()); //$NON-NLS-1$ //$NON-NLS-2$

	}

	/**
	 * This tests when a null resource set is passed. Check
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=331905
	 */
	@Test
	public void testAllDivison_Bug331905() {
		String query = "select div.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + "] as div"; //$NON-NLS-1$ //$NON-NLS-2$

		QueryProcessor createQueryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(getDefaultIndexStore());
		ResultSet resultSet = createQueryProcessor.execute(query, this.getQueryContextWithEmptyRS());

		// check the results
		if (!resultSet.isEmpty()) {
			assertEquals(resultSet.getAttribute(0, "div", "name"), this.div1.getName()); //$NON-NLS-1$ //$NON-NLS-2$

		}
	}

	@After
	public void cleanUp() {
		// remove the DirtyResourceFactory when done with the query execution
		rs.eAdapters().remove(DirtyResourceFactory.getInstance());
		DirtyResourceFactory.flushIndex();
	}

	// This a Query context which passes the resourceset as null to the Query
	// processor
	private QueryContext getQueryContextWithEmptyRS() {
		return new QueryContext() {

			public URI[] getResourceScope() {
				final List<URI> result = new ArrayList<URI>();
				IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {

					public void execute(QueryExecutor queryExecutor) {
						ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
						for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
							result.add(desc.getURI());
						}
					}

				});
				return result.toArray(new URI[0]);

			}

			public ResourceSet getResourceSet() {
				return null;
			}
		};
	}

	private QueryContext getQueryContext() {
		return new QueryContext() {

			public URI[] getResourceScope() {
				final List<URI> result = new ArrayList<URI>();
				IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {

					public void execute(QueryExecutor queryExecutor) {
						ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
						for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
							result.add(desc.getURI());
						}
					}

				});
				return result.toArray(new URI[0]);

			}

			public ResourceSet getResourceSet() {
				return rs;
			}
		};
	}
}
