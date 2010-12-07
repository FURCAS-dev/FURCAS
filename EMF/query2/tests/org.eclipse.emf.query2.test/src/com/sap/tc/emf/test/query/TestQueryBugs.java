package com.sap.tc.emf.test.query;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.ui.IndexFactory;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessor;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.test.mm.Company.CompanyFactory;
import org.eclipse.emf.query2.test.mm.Company.CompanyPackage;
import org.eclipse.emf.query2.test.mm.Company.Department;
import org.eclipse.emf.query2.test.mm.Company.Division;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.emf.test.query.setup.IndexerForTest;

/**
 * This test primarily contains the tests for the bugs solved for bugzilla.
 * Please mark the test with the Bugzilla ID for future reference.
 * @author Saurav Sarkar
 *
 */
public class TestQueryBugs extends QueryTestCase{
	private ResourceSet rs;
    private Resource r;
    private Division div1;
    private Department dep1;
	@Before
	public void setUp(){
		
		rs = new ResourceSetImpl();
		r = rs.createResource(URI.createFileURI("c://querybugs.xmi"));
	    div1 = CompanyFactory.eINSTANCE.createDivision();
	    div1.setName("div1");
	       
	    dep1 = CompanyFactory.eINSTANCE.createDepartment();
	    dep1.setName("dep1");
	    dep1.setBudget(50);
	    div1.getDepartment().add(dep1);
	    
	    IndexerForTest.index(IndexFactory.getInstance(), r);
	    r.unload();
	}
	@Test
	public void testAllDivison_Bug331905(){
		String query = "select div.name from [" + EcoreUtil.getURI(CompanyPackage.Literals.DIVISION) + "] as div";
		
		QueryProcessor createQueryProcessor = QueryProcessorFactory.getDefault().createQueryProcessor(getDefaultIndexStore());
		ResultSet resultSet = createQueryProcessor.execute(query, this.getQueryContextWithEmptyRS());
		
		// check the results
		if(!resultSet.isEmpty()){
		assertEquals(resultSet.getAttribute(0, "div", "name"), this.div1.getName());
		
		}
	}
	//This a Query context which passes the resourceset as null to the Query processor
	private QueryContext getQueryContextWithEmptyRS() {
		return new QueryContext() {

			@Override
			public URI[] getResourceScope() {
				final List<URI> result = new ArrayList<URI>();
				IndexFactory.getInstance().executeQueryCommand(new QueryCommand() {

					@Override
					public void execute(QueryExecutor queryExecutor) {
						ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
						for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
							result.add(desc.getURI());
						}
					}

				});
				return result.toArray(new URI[0]);
				//return uriScope.toArray(new URI[] {});
			}

			@Override
			public ResourceSet getResourceSet() {
				return null;
			}
		};
	}
}
