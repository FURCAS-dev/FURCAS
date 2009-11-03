package com.sap.mi.tools.cockpit.mql.ui.form;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.mi.tools.cockpit.mql.Messages;

/**
 * @author d003456
 * 
 */
public final class TemplatesViewPart extends SectionPart {

	private static final String LIFT_WIDGET_NAME_KEY = "name"; //$NON-NLS-1$

	private static final String LIFT_BUTTON_WIDGET_ADD = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.addButton"; //$NON-NLS-1$
	
	private static final String LIFT_BUTTON_WIDGET_RESET = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.resetButton"; //$NON-NLS-1$
	
	private static final String LIFT_BUTTON_WIDGET_UP = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.upButton"; //$NON-NLS-1$
	
	private static final String LIFT_BUTTON_WIDGET_DOWN = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.downButton"; //$NON-NLS-1$
	
	private static final String LIFT_BUTTON_WIDGET_DELETE = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.deleteButton"; //$NON-NLS-1$
	
	private static final String LIFT_TREE_WIDGET = "com.sap.mi.tools.cockpit.mql.ui.form.TemplatesViewPart.tree"; //$NON-NLS-1$

	private Label modelOperationsSeparator;

	private Label upDownSeparator;

	private Button downButton;

	private Button upButton;

	private Button exportButton;

	private Button importButton;

	private Button resetButton;

	private Button deleteButton;

	private Button addButton;

	private Composite buttonsComposite;

	private Tree tree;

	private TreeViewer treeViewer;

	private Composite treeAndButtonsComposite;

	private final static String SECTION_TITLE = Messages.TemplatesViewPart_0_xhed;

	private final static String SECTION_DESCRIPTION_INITIAL = Messages.TemplatesViewPart_1_xtxt;

	private final static String BUTTON_ADD = Messages.TemplatesViewPart_2_xbut;

	private final static String BUTTON_ADD_TOOLTIP = Messages.TemplatesViewPart_3_xtol;

	private final static String BUTTON_DELETE = Messages.TemplatesViewPart_4_xbut;

	private final static String BUTTON_DELETE_TOOLTIP = Messages.TemplatesViewPart_5_xtol;

	private final static String BUTTON_RESET = Messages.TemplatesViewPart_6_xbut;

	private final static String BUTTON_RESET_TOOLTIP = Messages.TemplatesViewPart_7_xtol;

	private final static String BUTTON_IMPORT = Messages.TemplatesViewPart_8_xbut;

	private final static String BUTTON_IMPORT_TOOLTIP = Messages.TemplatesViewPart_9_xtol;

	private final static String BUTTON_EXPORT = Messages.TemplatesViewPart_10_xbut;

	private final static String BUTTON_EXPORT_TOOLTIP = Messages.TemplatesViewPart_11_xtol;

	private final static String BUTTON_UP = Messages.TemplatesViewPart_12_xbut;

	private final static String BUTTON_UP_TOOLTIP = Messages.TemplatesViewPart_13_xtol;

	private final static String BUTTON_DOWN = Messages.TemplatesViewPart_14_xbut;

	private final static String BUTTON_DOWN_TOOLTIP = Messages.TemplatesViewPart_15_xtol;

	QueryMasterDetailPart masterDetailPart;

	/**
	 * Create the {@link SectionPart}.
	 * 
	 * @param parent
	 * @param masterDetailPart
	 * @param toolkit
	 * @param style
	 */
	public TemplatesViewPart(Composite parent, QueryMasterDetailPart masterDetailPart, FormToolkit toolkit, int style) {

		super(parent, toolkit, style);
		this.masterDetailPart = masterDetailPart;
		createClient(getSection(), toolkit);
	}

	/**
	 * Fill the section.
	 */
	private void createClient(Section section, FormToolkit toolkit) {

		final GridData gd_importButton;
		final GridData gd_upButton;
		section.setText(TemplatesViewPart.SECTION_TITLE);
		section.setDescription(TemplatesViewPart.SECTION_DESCRIPTION_INITIAL);
		this.treeAndButtonsComposite = toolkit.createComposite(section, SWT.WRAP);
		final GridLayout gridLayout;
		final GridData gd_queryTemplatesSection = new GridData(GridData.FILL_BOTH);
		section.setLayoutData(gd_queryTemplatesSection);

		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginRight = 2;
		gridLayout.marginLeft = 2;
		this.treeAndButtonsComposite.setLayout(gridLayout);
		toolkit.paintBordersFor(this.treeAndButtonsComposite);

		this.treeViewer = new TreeViewer(this.treeAndButtonsComposite, SWT.BORDER);
		this.tree = this.treeViewer.getTree();
		toolkit.adapt(this.tree, true, true);
		this.tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.tree.setData(TemplatesViewPart.LIFT_WIDGET_NAME_KEY, TemplatesViewPart.LIFT_TREE_WIDGET);

		this.buttonsComposite = new Composite(this.treeAndButtonsComposite, SWT.NONE);
		this.buttonsComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		this.buttonsComposite.setLayout(new GridLayout());
		toolkit.adapt(this.buttonsComposite);

		this.addButton = toolkit.createButton(this.buttonsComposite, TemplatesViewPart.BUTTON_ADD, SWT.NONE);
		this.addButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		this.addButton.setToolTipText(TemplatesViewPart.BUTTON_ADD_TOOLTIP);
		this.addButton.setData(TemplatesViewPart.LIFT_WIDGET_NAME_KEY, TemplatesViewPart.LIFT_BUTTON_WIDGET_ADD);

		this.deleteButton = toolkit.createButton(this.buttonsComposite, TemplatesViewPart.BUTTON_DELETE, SWT.NONE);
		this.deleteButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		this.deleteButton.setToolTipText(TemplatesViewPart.BUTTON_DELETE_TOOLTIP);
		this.deleteButton.setData(TemplatesViewPart.LIFT_WIDGET_NAME_KEY, TemplatesViewPart.LIFT_BUTTON_WIDGET_DELETE);

		this.resetButton = new Button(this.buttonsComposite, SWT.NONE);
		this.resetButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		toolkit.adapt(this.resetButton, true, true);
		this.resetButton.setText(TemplatesViewPart.BUTTON_RESET);
		this.resetButton.setToolTipText(TemplatesViewPart.BUTTON_RESET_TOOLTIP);
		this.resetButton.setData(TemplatesViewPart.LIFT_WIDGET_NAME_KEY, TemplatesViewPart.LIFT_BUTTON_WIDGET_RESET);

		this.modelOperationsSeparator = toolkit.createSeparator(this.buttonsComposite, SWT.HORIZONTAL);
		this.modelOperationsSeparator.setVisible(false);
		this.modelOperationsSeparator.setEnabled(false);
		this.modelOperationsSeparator.setDragDetect(false);

		this.exportButton = new Button(this.buttonsComposite, SWT.NONE);
		this.exportButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		toolkit.adapt(this.exportButton, true, true);
		this.exportButton.setText(TemplatesViewPart.BUTTON_EXPORT);
		this.exportButton.setToolTipText(TemplatesViewPart.BUTTON_EXPORT_TOOLTIP);

		this.importButton = new Button(this.buttonsComposite, SWT.NONE);
		gd_importButton = new GridData(SWT.FILL, SWT.CENTER, false, false);
		this.importButton.setLayoutData(gd_importButton);
		toolkit.adapt(this.importButton, true, true);
		this.importButton.setText(TemplatesViewPart.BUTTON_IMPORT);
		this.importButton.setToolTipText(TemplatesViewPart.BUTTON_IMPORT_TOOLTIP);

		this.upDownSeparator = toolkit.createSeparator(this.buttonsComposite, SWT.HORIZONTAL);
		this.upDownSeparator.setDragDetect(false);
		this.upDownSeparator.setEnabled(false);
		this.upDownSeparator.setVisible(false);

		this.upButton = new Button(this.buttonsComposite, SWT.NONE);
		gd_upButton = new GridData(SWT.FILL, SWT.CENTER, false, false);
		this.upButton.setLayoutData(gd_upButton);
		toolkit.adapt(this.upButton, true, true);
		this.upButton.setText(TemplatesViewPart.BUTTON_UP);
		this.upButton.setToolTipText(TemplatesViewPart.BUTTON_UP_TOOLTIP);
		this.upButton.setData(TemplatesViewPart.LIFT_WIDGET_NAME_KEY, TemplatesViewPart.LIFT_BUTTON_WIDGET_UP);

		this.downButton = new Button(this.buttonsComposite, SWT.NONE);
		this.downButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		toolkit.adapt(this.downButton, true, true);
		this.downButton.setText(TemplatesViewPart.BUTTON_DOWN);
		this.downButton.setToolTipText(TemplatesViewPart.BUTTON_DOWN_TOOLTIP);
		this.downButton.setData(TemplatesViewPart.LIFT_WIDGET_NAME_KEY, TemplatesViewPart.LIFT_BUTTON_WIDGET_DOWN);

		section.setClient(this.treeAndButtonsComposite);
	}

	public TreeViewer getTreeViewer() {

		return this.treeViewer;
	}

	public Tree getTree() {

		return this.tree;
	}

	public final Button getAddButton() {

		return this.addButton;
	}

	public final Button getDeleteButton() {

		return this.deleteButton;
	}

	/**
	 * @return the exportButton
	 */
	public final Button getExportButton() {

		return this.exportButton;
	}

	/**
	 * @return the importButton
	 */
	public final Button getImportButton() {

		return this.importButton;
	}

	/**
	 * @return the resetButton
	 */
	public final Button getResetButton() {

		return this.resetButton;
	}

	/**
	 * @return the downButton
	 */
	public final Button getDownButton() {

		return this.downButton;
	}

	/**
	 * @return the upButton
	 */
	public final Button getUpButton() {

		return this.upButton;
	}

	/*
	 * (non-Javadoc) set input when all controls are provided
	 * 
	 * @see org.eclipse.ui.forms.AbstractFormPart#setFormInput(java.lang.Object)
	 */
	@Override
	public boolean setFormInput(Object input) {

		this.masterDetailPart.setInput();
		return true;
	}

}
