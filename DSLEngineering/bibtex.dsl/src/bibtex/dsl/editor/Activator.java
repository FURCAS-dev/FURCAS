package bibtex.dsl.editor; 

import generated.BibtexLexer;
import generated.BibtexParser;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import bibtex.dsl.parser.BibtexParserFactory;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.runtime.syntaxprovider.AbstractSyntaxProvider;
import com.sap.furcas.runtime.syntaxprovider.SyntaxProvider;


/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements SyntaxProvider {
    private final SyntaxProvider delegate;

    public static final String PLUGIN_ID = "Bibtex.dsl"; //NON-NLS-1
    private static Activator plugin;

    public Activator() {
        delegate = new AbstractSyntaxProvider<BibtexParser, BibtexLexer>(new BibtexParserFactory(),
                DefaultOppositeEndFinder.getInstance());
    }

    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }

    public static Activator getDefault() {
        return plugin;
    }

    @Override
    public ResourceSet getResourceSet() throws ParserException, IOException {
        return delegate.getResourceSet();
    }

    @Override
    public ConcreteSyntax getSyntax() throws IOException, ParserException {
        return delegate.getSyntax();
    }

}
