
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.Query;
import org.eclipse.emf.query2.QueryStandaloneSetup;
import org.eclipse.emf.query2.query.MQLquery;
import org.eclipse.emf.query2.query.Model;
import org.eclipse.emf.query2.query.NamedQuery;
import org.eclipse.emf.query2.transformation.QueryTransformer;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Injector;

public class LibraryTransformation extends Assert {

	private static Model model;

	@BeforeClass
	public static void setup() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("..");
		Injector injector = new QueryStandaloneSetup().createInjectorAndDoEMFRegistration();

		XtextResourceSet set = injector.getInstance(XtextResourceSet.class);
		set.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		URI resourceURI = URI.createURI("platform:/resource/org.eclipse.emf.query2.sample/data/lib.query");
		URI normalized = set.getURIConverter().normalize(resourceURI);
		LazyLinkingResource xtextResource = (LazyLinkingResource) set.getResource(normalized, true);
		model = (Model) xtextResource.getContents().get(0);

	}

	@Test
	public void transform() {
		for (NamedQuery query : model.getNamedQueries()) {
			Query transform = QueryTransformer.transform(query.getQuery());
			System.out.println("\n"+query.getName()+"\n----------------------------------");
			System.out.println(transform.toString().replaceAll("\\n", " ").trim());
		}
	}

}
