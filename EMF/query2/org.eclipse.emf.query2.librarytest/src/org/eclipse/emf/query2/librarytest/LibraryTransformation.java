package org.eclipse.emf.query2.librarytest;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.query.IndexQueryFactory;
import org.eclipse.emf.query.index.query.QueryCommand;
import org.eclipse.emf.query.index.query.QueryExecutor;
import org.eclipse.emf.query.index.query.ResourceQuery;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryContext;
import org.eclipse.emf.query2.QueryProcessorFactory;
import org.eclipse.emf.query2.ResultSet;
import org.eclipse.emf.query2.syntax.QueryStandaloneSetup;
import org.eclipse.emf.query2.syntax.query.Model;
import org.eclipse.emf.query2.syntax.query.NamedQuery;
import org.eclipse.emf.query2.syntax.transformation.QueryTransformer;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Injector;


public class LibraryTransformation extends QueryTestCase {
	private static Model model;
	
	
	@BeforeClass
	public static void setup() {
		if (!Platform.isRunning()) {
			 new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("..");
		}
		
		Injector injector = new QueryStandaloneSetup().createInjectorAndDoEMFRegistration();
		XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
		set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		URI resourceURI = URI.createURI("platform:/plugin/org.eclipse.emf.query2.librarytest/data/lib.query");
		URI normalized = set.getURIConverter().normalize(resourceURI);
		LazyLinkingResource xtextResource = (LazyLinkingResource) set.getResource(normalized, true);
		model = (Model) xtextResource.getContents().get(0);
	}

	@Test
	public void transform() {

		for (NamedQuery query : model.getNamedQueries()) {

			final ResourceSet rs = new ResourceSetImpl();

			Query transform = QueryTransformer.transform(query.getQuery());
			System.out.println("\n" + query.getName() + "\n----------------------------------");
			System.out.println(transform.toString().trim());
			
			long start = System.nanoTime();
			ResultSet execute = QueryProcessorFactory.getDefault().createQueryProcessor(getDefaultIndexStore()).execute(transform, getQueryContext(rs));
			long end = System.nanoTime();

			System.out.println(execute);
			System.out.println("Size: "+execute.getSize());
			long time = end-start;
			System.out.println("QueryTime: "+ time+"ns ("+(time/1000000000f)+"s)");
		}
	}

	private QueryContext getQueryContext(final ResourceSet rs) {
		return new QueryContext() {

			@Override
			public URI[] getResourceScope() {
				final List<URI> result = new ArrayList<URI>();
				getDefaultIndexStore().executeQueryCommand(new QueryCommand() {

					@Override
					public void execute(QueryExecutor queryExecutor) {
						ResourceQuery<ResourceDescriptor> resourceQuery = IndexQueryFactory.createResourceQuery();
						for (ResourceDescriptor desc : queryExecutor.execute(resourceQuery)) {
							result.add(desc.getURI());
						}
					}

				});
				return result.toArray(new URI[0]);
			}

			@Override
			public ResourceSet getResourceSet() {
				return rs;
			}

		};
	}
}
