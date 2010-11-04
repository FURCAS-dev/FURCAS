package com.sap.furcas.ide.dslproject.builder;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.ide.dslproject.Activator;
import com.sap.furcas.ide.dslproject.Constants;
import com.sap.furcas.ide.dslproject.conf.IProjectMetaRefConf;
import com.sap.furcas.parsergenerator.tcs.generator.GrammarGenerator;
import com.sap.furcas.parsergenerator.tcs.generator.ParserGenerator;
import com.sap.furcas.parsergenerator.tcs.generator.errorhandling.EclipseMarkerUtil;
import com.sap.furcas.parsergenerator.tcs.generator.errorhandling.GenerationErrorHandler;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;
import com.sap.furcas.utils.projects.ReferenceScopeBean;


/**
 * The Class SyntaxBuilder.
 */
public class SyntaxBuilder extends IncrementalProjectBuilder {

    /**
     * The Class TCSProjectResourceVisitor.
     */
    class TCSBuildVisitor implements IResourceVisitor {

	/** The mymonitor. */
	private final IProgressMonitor mymonitor;

	/**
	 * Instantiates a new tCS project resource visitor.
	 * 
	 * @param monitor
	 *            the monitor
	 */
	public TCSBuildVisitor(IProgressMonitor monitor) {
	    mymonitor = monitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core
	 * .resources.IResource)
	 */
	@Override
	public boolean visit(IResource resource) {
	    try {
		buildGrammar(resource, mymonitor);
	    } catch (CoreException e) {
		Activator.logger.logError("Failed to build grammar from resource " + resource, e);
	    }
	    // return true to continue visiting children.
	    return true;
	}
    }

    /**
     * The Class TCSProjectResourceVisitor.
     */
    class TCSCleanVisitor implements IResourceVisitor {

	/** The mymonitor. */
	private final IProgressMonitor mymonitor;

	/**
	 * Instantiates a new tCS project resource visitor.
	 * 
	 * @param monitor
	 *            the monitor
	 */
	public TCSCleanVisitor(IProgressMonitor monitor) {
	    mymonitor = monitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IResourceVisitor#visit(org.eclipse.core
	 * .resources.IResource)
	 */
	@Override
	public boolean visit(IResource resource) {

	    try {
		cleanResource(resource, mymonitor);
	    } catch (CoreException e) {
		Activator.logger.logError("Failed to clean resource " + resource);
	    }
	    // return true to continue visiting children.
	    return true;
	}
    }

    /**
     * The Class TCSProjectDeltaVisitor.
     */
    class TCSProjectDeltaVisitor implements IResourceDeltaVisitor {

	/** The mymonitor. */
	private final IProgressMonitor mymonitor;

	/**
	 * Instantiates a new tCS project delta visitor.
	 * 
	 * @param mymonitor
	 *            the mymonitor
	 */
	public TCSProjectDeltaVisitor(IProgressMonitor mymonitor) {
	    super();
	    this.mymonitor = mymonitor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse
	 * .core.resources.IResourceDelta)
	 */
	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
	    IResource resource = delta.getResource();
	    switch (delta.getKind()) {
	    case IResourceDelta.ADDED:
		// handle added resource
		buildGrammar(resource, mymonitor);
		break;
	    case IResourceDelta.REMOVED:
		// handle removed resource
		break;
	    case IResourceDelta.CHANGED:
		// handle changed resource
		buildGrammar(resource, mymonitor);
		break;
	    default:
		break;
	    }
	    // return true to continue visiting children.
	    return true;
	}
    }

    // private SAXParserFactory parserFactory;

    /** The Constant BUILDER_ID. */
    public static final String BUILDER_ID = Activator.class.getPackage().getName() + ".syntaxBuilder";

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.internal.events.InternalBuilder#build(int,
     * java.util.Map, org.eclipse.core.runtime.IProgressMonitor)
     */
    @Override
    @SuppressWarnings("rawtypes")
    // Map is defined without generic in supertype
    protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
	if (kind == FULL_BUILD) {
	    fullBuild(monitor);
	} else {
	    IResourceDelta delta = getDelta(getProject());
	    if (delta == null) {
		fullBuild(monitor);
	    } else {
		incrementalBuild(delta, monitor);
	    }
	}
	return null;
    }

    /**
     * Builds the grammar.
     * 
     * @param resource
     *            the resource
     * @param mymonitor
     *            the mymonitor
     * 
     * @throws CoreException
     *             the core exception
     */
    void buildGrammar(IResource resource, IProgressMonitor mymonitor) throws CoreException {
	if (resource instanceof IFile && resource.getName().endsWith(Constants.TCS_EXTENSION)) {
	    IFile file = (IFile) resource;
	    if (file.isDerived()) {
		return;
	    }
	    EclipseMarkerUtil.deleteMarkers(file);
	    IProject project = resource.getProject();
	    EclipseMarkerUtil.deleteMarkers(project);
	    if (project == null) {
		// possible ?
		return;
	    }
	    SyntaxGenerationNature nature = SyntaxGenerationNature.getNatureFromProject(project);

	    if (nature != null) {
		mymonitor.beginTask("Building Grammar", 100);
		IProjectMetaRefConf conf = nature.getMetaModelReferenceConf();
		if (conf != null) {
		    GenerationErrorHandler errorhandler = new GenerationErrorHandler(file);
		    ReferenceScopeBean refScopeBean = conf.getMetaLookUpForProject();
		    try {
			ResourceSet targetResourceSet = null;
			if (BuildHelper.isModelProject(project)) {
			    targetResourceSet = BuildHelper.getResourceSetForProject(project);
			} else {
			    targetResourceSet = new ResourceSetImpl();
			}

			String targetpackage = getPackage(file, project);
			Class<? extends ObservableInjectingParser> parserSuperClass = null;
			IFile grammarfile = GrammarGenerator.buildGrammar(refScopeBean, targetResourceSet, file,
				mymonitor, errorhandler, targetpackage, parserSuperClass);
			// grammarfile.getParent().refreshLocal(1,
			// mymonitor);
			if (grammarfile.exists()) { // TODO and changed
			    errorhandler = new GenerationErrorHandler(grammarfile);
			    ParserGenerator.buildParser(grammarfile, mymonitor, errorhandler);

			    // refresh dir where java was generated so that
			    // Java builder can compile
			    grammarfile.getParent().refreshLocal(1, mymonitor);
			}
		    } finally {
			// if (refScopeBean != null &&
			// refScopeBean.getConnection() != null) {
			// refScopeBean.getConnection().close();
			// }
		    }

		} else { // conf is null
		    String message = "Build failed: Project " + project.getName()
			    + " has DSL Syntax Definition Nature but no metamodel reference configured.";
		    EclipseMarkerUtil.addMarker(project, message, -1, IMarker.SEVERITY_ERROR);

		}
		mymonitor.done();
	    } else {
		Activator.logger.logWarning("getProject was null for IFile: " + resource.getName());
	    }

	}
    }

    /**
     * returns the files path in package notation exept for the filename, or
     * returns "generated" if no such path exists
     * 
     * @param file
     * @param project
     * @return
     */
    private static String getPackage(IFile file, IProject project) {
	String targetPackage = null;
	IPath path = file.getParent().getProjectRelativePath();
	if (path != null && path.segmentCount() >= 2) { // source folder /
							// packagefolder1
	    targetPackage = path.segment(1);
	    for (int i = 2; i < path.segmentCount(); i++) {
		String segment = path.segment(i);
		targetPackage += '.' + segment;
	    }
	} else {
	    targetPackage = "generated";
	}
	return targetPackage;
    }

    @Override
    protected void clean(IProgressMonitor monitor) throws CoreException {
	super.clean(monitor);
	try {
	    getProject().accept(new TCSCleanVisitor(monitor));
	} catch (CoreException e) {
	    Activator.logger.logError("Failed cleaning project " + getProject(), e);
	}
    }

    // private SAXParser getParser() throws ParserConfigurationException,
    // SAXException {
    // // if (parserFactory == null) {
    // // parserFactory = SAXParserFactory.newInstance();
    // // }
    // // return parserFactory.newSAXParser();
    // }

    /**
     * @param resource
     * @param mymonitor
     */
    public void cleanResource(IResource resource, IProgressMonitor mymonitor) throws CoreException {
	if (resource instanceof IFile && resource.getName().endsWith(Constants.TCS_EXTENSION)) {
	    // Only delete if we are sure that we can rebuild it
	    // one condition for that is the availability of the metamodel
	    SyntaxGenerationNature nature = SyntaxGenerationNature.getNatureFromProject(resource.getProject());

	    if (nature != null) {
		IProjectMetaRefConf conf = nature.getMetaModelReferenceConf();
		if (conf.getMetaLookUpForProject() != null) {
		    IFile file = (IFile) resource;
		    // delete markers
		    EclipseMarkerUtil.deleteMarkers(file);
		    // delete grammarfile
		    IFile[] genfiles = GrammarGenerator.getFilesForClean(file);
		    for (int i = 0; i < genfiles.length; i++) {
			IFile genfile = genfiles[i];
			if (genfile.exists()) {
			    EclipseMarkerUtil.deleteMarkers(genfile);
			    genfile.delete(IResource.FORCE, mymonitor);
			}
		    }
		}
	    }
	}
    }

    /**
     * Full build.
     * 
     * @param monitor
     *            the monitor
     * 
     * @throws CoreException
     *             the core exception
     */
    protected void fullBuild(final IProgressMonitor monitor) {
	try {
	    getProject().accept(new TCSBuildVisitor(monitor));
	} catch (CoreException e) {
	    Activator.logger.logError("Failed during full build of " + getProject(), e);
	}
    }

    /**
     * Incremental build.
     * 
     * @param delta
     *            the delta
     * @param monitor
     *            the monitor
     * 
     * @throws CoreException
     *             the core exception
     */
    protected void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
	// the visitor does the work.
	delta.accept(new TCSProjectDeltaVisitor(monitor));
    }
}
