package com.sap.mi.tools.cockpit.mql.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.runtime.Assert;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.tools.cockpit.mql.QueryConsole;
import com.sap.mi.tools.cockpit.mql.ui.view.QueryConsoleView;
import com.sap.mi.tools.cockpit.mql.wizard.QueryTemplateWizard;

/**
 * The model for query templates in {@link QueryConsoleView}.
 * 
 * @author d003456
 * @see QueryTemplateNode
 * @see QueryTemplateWizard
 * @see ArtificialRootNode
 */
public final class Model {

	private static final Logger tracer = Logger.getLogger(MiLocations.MI_MQLVIEW);

	private final static String QUERY_MEMENTO = "query.template.memento"; //$NON-NLS-1$

	private final static String QUERY_KEY = "query.key"; //$NON-NLS-1$

	private final static String QUERY_VALUE = "query.value"; //$NON-NLS-1$

	private final static String QUERY_TEMPLATES_FILE_NAME = "querytemplates.xml"; //$NON-NLS-1$

	private final static String QUERY_MEMEMTO_ROOT = "query.template.memento.root"; //$NON-NLS-1$

	private File templatesFile;

	private static Model model;

	private ArtificialRootNode root = null;

	private QueryTemplateNode selectedNode = null;

	private final List<IModelChangedListener> modelChangedListeners = new ArrayList<IModelChangedListener>();

	private XMLMemento memento;

	/**
	 * Invisible Constructor
	 */
	private Model() {

	}

	/**
	 * @return instance of {@link Model}.
	 */
	public static synchronized Model getInstance() {

		if (Model.model == null) {
			Model.model = new Model();
		}
		return Model.model;
	}

	/**
	 * Register Listener
	 * 
	 * @param listener
	 *            - a listener should observe state changes in the model
	 * 
	 */
	public void addModelChangedListener(IModelChangedListener listener) {

		if (!this.modelChangedListeners.contains(listener))
			this.modelChangedListeners.add(listener);
	}

	/**
	 * Unregister Listener.
	 * 
	 * @param listener
	 *            - the Listener should be unregistered
	 * 
	 */
	public void removeModelChangedListener(IModelChangedListener listener) {

		this.modelChangedListeners.remove(listener);
	}

	/**
	 * Broadcast state changes.
	 * 
	 * @param obj
	 *            object changed
	 * @param operation
	 *            the operation {@link OP} done on the model
	 */
	public void fireModelChanged(Object obj, OP operation) {

		for (final IModelChangedListener listener : this.modelChangedListeners) {
			listener.modelChanged(obj, operation);
		}
	}

	/**
	 * Sets the {@link ArtificialRootNode} root node.
	 * 
	 * @param root
	 *            the root to set
	 */
	public void setRoot(ArtificialRootNode root) {

		Assert.isNotNull(root);
		this.templatesFile = QueryConsole.getDefault().getStateLocation().append(Model.QUERY_TEMPLATES_FILE_NAME).toFile();
		if (!this.templatesFile.exists()) {
			try {
				this.templatesFile.createNewFile();
			}
			catch (final IOException e) {
				Model.tracer.log(Level.SEVERE, e.getMessage(), e);
			}
		} else {
			FileReader reader;
			try {
				reader = new FileReader(this.templatesFile);
				this.memento = XMLMemento.createReadRoot(reader);
			}
			catch (final WorkbenchException e) {
				this.memento = null;
				Model.tracer.log(Level.SEVERE, e.getMessage(), e);
			}
			catch (final FileNotFoundException e) {
				this.memento = null;
				Model.tracer.log(Level.SEVERE, e.getMessage(), e);
			}
		}
		this.root = root;
		initialize();
	}

	/**
	 * Resets model to predefined content.
	 * 
	 * @see #createPreConfiguredChildren
	 */
	public void resetModel() {

		this.memento = null;
		initialize();
		Model.model.fireModelChanged(null, OP.NEW_TREE);
	}

	/**
	 * Returns the {@link ArtificialRootNode} root node.
	 * 
	 * @return root node
	 */
	public ArtificialRootNode getRoot() {

		return this.root;
	}

	/**
	 * @return Returns the selectedNode.
	 */
	public Object getSelectedNode() {

		return this.selectedNode;
	}

	/**
	 * Sets the current selected node.
	 * 
	 * @param selectedNode
	 *            The selectedNode to set
	 */
	public void setSelectedNode(QueryTemplateNode selectedNode) {

		this.selectedNode = selectedNode;
	}

	/**
	 * Search newTemplateName already exists.
	 * 
	 * @param newTemplateName
	 * @return true if it already exists, false otherwise
	 */
	public boolean lookUp(String newTemplateName) {

		final boolean found = false;
		final List<QueryTemplateNode> templates = this.root.getChildren();
		if (templates != null && templates.size() > 0) {
			for (final Iterator<QueryTemplateNode> iterator = templates.iterator(); iterator.hasNext();) {
				final QueryTemplateNode queryTemplate = iterator.next();
				if (queryTemplate.getTemplateName().equals(newTemplateName)) {
					return true;
				}

			}
		}
		return found;
	}

	/**
	 * Saves model with {@link XMLMemento} in an {@link File} file. If a problem occurs, the {@link IOException} is thrown.
	 * 
	 * @param file
	 *            the file where model should be saved in
	 * @throws IOException
	 */
	public void exportModel(File file) throws IOException {

		final List<QueryTemplateNode> children = this.root.getChildren();
		this.memento = XMLMemento.createWriteRoot(Model.QUERY_MEMEMTO_ROOT);

		for (final QueryTemplateNode queryTemplate : children) {
			final IMemento child = this.memento.createChild(Model.QUERY_MEMENTO);
			child.putString(Model.QUERY_KEY, queryTemplate.getTemplateName());
			child.putString(Model.QUERY_VALUE, queryTemplate.getQuery());
		}
		final Writer writer = new FileWriter(file);
		this.memento.save(writer);
	}

	/**
	 * Imports query templates from an XML file. The file should be generated before by {@link Model#exportModel(File)}. If a problem
	 * occurs, the {@link Exception} is thrown.
	 * 
	 * @param file
	 *            the XML file containing query templates
	 * @return true, if import succeeded, otherwise false
	 * @throws Exception
	 * @see QueryTemplateNode
	 */
	public boolean importModel(File file) throws Exception {

		boolean importOK = false;
		XMLMemento memento;
		FileReader reader;
		reader = new FileReader(file);
		memento = XMLMemento.createReadRoot(reader);
		final List<QueryTemplateNode> children = new ArrayList<QueryTemplateNode>();
		if (memento.getChildren(Model.QUERY_MEMENTO).length > 0) {
			createChildrenFromState(children, memento);
			this.root.setChildren(children);
			this.memento = memento;
			importOK = true;
			fireModelChanged(null, OP.NEW_TREE);
		}
		return importOK;
	}

	/**
	 * Saves model with {@link XMLMemento} to <code>querytemplates.xml</code> in workspace.
	 */
	public void saveModel() {

		try {
			exportModel(this.templatesFile);
		}
		catch (final Exception e) {
			Model.tracer.log(Level.SEVERE, e.getMessage(), e);
		}
	}

	private void initialize() {

		final List<QueryTemplateNode> children = new ArrayList<QueryTemplateNode>();
		if (this.memento != null) {
			createChildrenFromState(children, this.memento);
		} else {
			createPreConfiguredChildren(children);
		}
		this.root.setChildren(children);
		saveModel();
	}

	private void createChildrenFromState(final List<QueryTemplateNode> children, XMLMemento memento) {

		final IMemento[] mementos = memento.getChildren(Model.QUERY_MEMENTO);
		for (int i = 0; i < mementos.length; i++) {
			final QueryTemplateNode template = new QueryTemplateNode(mementos[i].getString(Model.QUERY_KEY), mementos[i]
					.getString(Model.QUERY_VALUE), TEMPLATE_TYPE.USER_DEFINED);
			if (!children.contains(template)) {
				template.setParent(this.root);
				children.add(template);
			}
		}
	}

	@SuppressWarnings("nls")//$NON-NLS-1$
	private void createPreConfiguredChildren(final List<QueryTemplateNode> children) {

		final QueryTemplateNode one = new QueryTemplateNode("name from XsdSimpleTypeDefinition",
				"select xsd.name from XSD1::XsdSimpleTypeDefinition as xsd", TEMPLATE_TYPE.STANDARD);
		one.setParent(this.root);
		children.add(one);

		final QueryTemplateNode two = new QueryTemplateNode(
				"name 2 from XsdSimpleTypeDefinition",
				"select el.name  from XSD1::XsdSimpleTypeDefinition as xsd, XSD1::XsdElementDeclaration as el where el.typeDefinition=xsd where xsd.name='AbsolutePointAngularPrecisionCodeDatDef'",
				TEMPLATE_TYPE.STANDARD);
		two.setParent(this.root);
		children.add(two);

		final QueryTemplateNode six = new QueryTemplateNode("name from Model",
				"select c.name from Model::Class as c where for c ( name like 'A*' )", TEMPLATE_TYPE.STANDARD);
		six.setParent(this.root);
		children.add(six);

		final QueryTemplateNode seven = new QueryTemplateNode("2 names from Model",
				"select c1.name, c2.name from Model::Class as c1, Model::Class as c2", TEMPLATE_TYPE.STANDARD);
		seven.setParent(this.root);
		children.add(seven);

		final QueryTemplateNode eight = new QueryTemplateNode(
				"name from Model multiplicity",
				"select a.name, m.upper from Model::Attribute as a, Model::MultiplicityType as m where a.multiplicity = m where for m ( upper > 1 )",
				TEMPLATE_TYPE.STANDARD);
		eight.setParent(this.root);
		children.add(eight);

		final QueryTemplateNode nine = new QueryTemplateNode("name from Model AssociationEnd",
				"select end.name, t from Model::AssociationEnd as end, Model::Classifier as t where end.\"type\" = t",
				TEMPLATE_TYPE.STANDARD);
		nine.setParent(this.root);
		children.add(nine);
	}
}
