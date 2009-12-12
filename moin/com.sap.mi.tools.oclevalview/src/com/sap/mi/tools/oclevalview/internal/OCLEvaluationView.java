package com.sap.mi.tools.oclevalview.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.MessageFormat;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

import com.sap.mi.fwk.ModelManager;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.ocl.exceptions.ParsingException;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.ocl.freestyle.OclFreestyleRegistry;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;
import com.sap.tc.moin.repository.ocl.registry.OclRegistrationSeverity;

/**
 * The evaluation view
 * 
 * @author d024127
 */
public final class OCLEvaluationView extends ViewPart {

	private static boolean isSectionExpanded = true;

	private Text m1Object;

	private Text m1ObjectLabel;

	private Text oclContext;

	private Text oclExpression;

	private Text result;

	private Text txtProject;

	private final MoinOclWrapper registry = new MoinOclWrapper();

	private Button checkbox;

	private Label resultLabel;

	private Button evaluate;

	private FormToolkit toolkit;

	@Override
	public void createPartControl(Composite parent) {
		
		final GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;

		this.toolkit = new FormToolkit(parent.getDisplay());
		final Composite pane = this.toolkit.createComposite(parent, SWT.NONE);
		pane.setLayout(gridLayout);

		final Display display = pane.getDisplay();
		final Color background = JFaceColors.getBannerBackground(display);
		pane.setBackground(background);

		final ScrolledForm form = this.toolkit.createScrolledForm(pane);
		final GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		form.setLayoutData(gridData);
		form.setText(Messages.OCLEvaluationView_0_Xhed);

		final Composite bodyForm = form.getBody();
		final TableWrapLayout layout = new TableWrapLayout();
		layout.leftMargin = 10;
		bodyForm.setLayout(layout);

		TableWrapData tableWrapData;
		int basicSectionStyle = ExpandableComposite.TWISTIE | ExpandableComposite.COMPACT | ExpandableComposite.TITLE_BAR;
		if (OCLEvaluationView.isSectionExpanded) {
			basicSectionStyle |= ExpandableComposite.EXPANDED;
		}

		/*
		 * Expression Section
		 */

		final Section expressionSection = this.toolkit.createSection(bodyForm, basicSectionStyle);

		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		expressionSection.setLayoutData(tableWrapData);
		expressionSection.setText(Messages.OCLEvaluationView_1_xhed);

		Composite composite = this.toolkit.createComposite(expressionSection, SWT.FILL);
		TableWrapLayout compositeLayout = new TableWrapLayout();
		compositeLayout.numColumns = 3;
		compositeLayout.verticalSpacing = 10;
		composite.setLayout(compositeLayout);
		this.toolkit.paintBordersFor(composite);

		final Label sectionLbl = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_2_xtxt);
		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.colspan = 3;
		sectionLbl.setLayoutData(tableWrapData);

		final Label metamodelLbl = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_3_xfld);
		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		metamodelLbl.setLayoutData(tableWrapData);

		this.txtProject = this.toolkit.createText(composite, "");//$NON-NLS-1$
		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.colspan = 2;
		this.txtProject.setLayoutData(tableWrapData);
		this.toolkit.adapt(this.txtProject, true, true);
		addDropTarget(this.txtProject);

		Label label;

		// Object

		label = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_4_xfld, SWT.NONE);
		tableWrapData = new TableWrapData(TableWrapData.LEFT);
		label.setLayoutData(tableWrapData);

		this.m1Object = this.toolkit.createText(composite, ""); //$NON-NLS-1$
		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.colspan = 2;
		this.m1Object.setLayoutData(tableWrapData);
		this.m1Object.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				// TODO Add d&d support
				String label = Messages.OCLEvaluationView_5_xfld;
				RefClass context = null;
				String contextLabel = ""; //$NON-NLS-1$

				final RefObject object = (RefObject) e.widget.getData();
				if (object != null) {
					label = ModelManager.getInstance().getObjectName(object);
					context = object.refClass();
					contextLabel = ((Partitionable) object).get___JmiInterface().getCanonicalName();
				}

				// Set label of M1 object
				OCLEvaluationView.this.m1ObjectLabel.setText(label);

				// Set canonical name
				OCLEvaluationView.this.oclContext.setText(contextLabel);
				OCLEvaluationView.this.oclContext.setData(context);

				OCLEvaluationView.this.updateEvaluateButton();
			}
		});
		addDropTarget(this.m1Object);

		// Add d&d capacity

		final Color colorDisabled = parent.getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND);

		// Label
		label = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_6_xfld, SWT.NONE);
		tableWrapData = new TableWrapData(TableWrapData.LEFT);
		label.setLayoutData(tableWrapData);
		this.m1ObjectLabel = this.toolkit.createText(composite, "", SWT.READ_ONLY); //$NON-NLS-1$
		this.m1ObjectLabel.setForeground(colorDisabled);

		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.colspan = 2;
		this.m1ObjectLabel.setLayoutData(tableWrapData);
		this.m1ObjectLabel.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				// TODO
			}
		});
		addDropTarget(this.m1ObjectLabel);

		// Context

		label = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_7_xfld, SWT.NONE);
		tableWrapData = new TableWrapData(TableWrapData.LEFT);
		label.setLayoutData(tableWrapData);
		this.oclContext = this.toolkit.createText(composite, "", SWT.READ_ONLY); //$NON-NLS-1$
		this.oclContext.setForeground(colorDisabled);

		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.colspan = 2;
		this.oclContext.setLayoutData(tableWrapData);
		this.oclContext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				// TO DO
			}
		});
		addDropTarget(this.oclContext);

		// Resolve domain model

		this.checkbox = this.toolkit.createButton(composite, Messages.OCLEvaluationView_8_xbut, SWT.CHECK);
		tableWrapData = new TableWrapData(TableWrapData.LEFT);
		tableWrapData.colspan = 3;
		this.checkbox.setLayoutData(tableWrapData);

		// Expression

		label = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_9_xfld, SWT.NONE);
		tableWrapData = new TableWrapData(TableWrapData.LEFT);
		label.setLayoutData(tableWrapData);

		
		this.oclExpression = this.toolkit.createText(composite, "", SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);//$NON-NLS-1$
		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.heightHint = 100;
		tableWrapData.grabVertical = true;
		tableWrapData.colspan = 2;
		this.oclExpression.setLayoutData(tableWrapData);
		this.oclExpression.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				OCLEvaluationView.this.updateEvaluateButton();
			}
		});
		
		
		this.evaluate = this.toolkit.createButton(composite, Messages.OCLEvaluationView_10_xbut, SWT.NONE);
		tableWrapData = new TableWrapData(TableWrapData.LEFT);
		this.evaluate.setLayoutData(tableWrapData);

		final SelectionListener listener = new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {

				widgetSelected(e);
			}

			public void widgetSelected(SelectionEvent e) {

				OCLEvaluationView.this.processExpression();
			}
		};
		this.evaluate.addSelectionListener(listener);

		expressionSection.setClient(composite);

		/*
		 * Expression Section
		 */

		final Section resultSection = this.toolkit.createSection(bodyForm, basicSectionStyle);

		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		resultSection.setLayoutData(tableWrapData);
		resultSection.setText(Messages.OCLEvaluationView_0_xhed);

		composite = this.toolkit.createComposite(resultSection, SWT.FILL);
		compositeLayout = new TableWrapLayout();
		compositeLayout.numColumns = 1;
		compositeLayout.verticalSpacing = 10;
		composite.setLayout(compositeLayout);
		this.toolkit.paintBordersFor(composite);

		this.resultLabel = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_11_xfld);
		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		this.resultLabel.setLayoutData(tableWrapData);

		this.result = this.toolkit.createText(composite, "", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY); //$NON-NLS-1$
		tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.heightHint = 100;
		tableWrapData.grabVertical = true;
		this.result.setLayoutData(tableWrapData);
		this.result.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				// TO DO
			}
		});
		addDropTarget(this.result);
		resultSection.setClient(composite);

		updateEvaluateButton();
	}

	@Override
	public void dispose() {

		if (this.toolkit != null) {
			this.toolkit.dispose();
			this.toolkit = null;
		}
		super.dispose();
	}

	private void addDropTarget(final Control droppable) {

		// Allow data to be copied or moved to the drop target
		final int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		final DropTarget target = new DropTarget(droppable, operations);

		final Transfer[] types = new Transfer[] { LocalSelectionTransfer.getInstance() };
		target.setTransfer(types);

		target.addDropListener(new DropTargetListener() {
			public void dragEnter(DropTargetEvent event) {

				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}

				event.detail = DND.DROP_MOVE;
				final ISelection obj = org.eclipse.jface.util.LocalSelectionTransfer.getTransfer().getSelection();

				final RefObject re = ModelAdapterUI.getInstance().getRefObject(obj);
				if (re == null) {
					event.detail = DND.DROP_NONE;
				}
			}

			public void dragOver(DropTargetEvent event) {

				event.feedback = DND.FEEDBACK_SELECT;
			}

			public void dragOperationChanged(DropTargetEvent event) {

				if (event.detail == DND.DROP_DEFAULT) {
					if ((event.operations & DND.DROP_COPY) != 0) {
						event.detail = DND.DROP_COPY;
					} else {
						event.detail = DND.DROP_NONE;
					}
				}
			}

			public void dragLeave(DropTargetEvent event) {

			}

			public void dropAccept(DropTargetEvent event) {

			}

			public void drop(DropTargetEvent event) {

				final ISelection obj = org.eclipse.jface.util.LocalSelectionTransfer.getTransfer().getSelection();
				final RefObject re = ModelAdapterUI.getInstance().getRefObject(obj);
				if (re != null) {
					event.detail = DND.DROP_NONE;
					setObject(re);
					updateEvaluateButton();
				}
			}
		});
	}

	private void processExpression() {

		RefObject obj;
		try {
			obj = (RefObject) this.m1Object.getData();
		}
		catch (final Exception e) {
			obj = null;
		}

		if (obj != null)
			this.registry.evaluate(obj, this.oclExpression.getText());
		else
			this.result.setText(Messages.OCLEvaluationView_0_xmsg);
	}

	@Override
	public void setFocus() {

	}

	public void setObject(RefBaseObject refBaseObj) {

		if (refBaseObj == null) {
			this.m1Object.setData(null);
			this.m1Object.setText(""); //$NON-NLS-1$
			this.txtProject.setData(null);
			this.txtProject.setText(""); //$NON-NLS-1$
		} else {

		    //TODO uncomment if GFW is added again
//			if (refBaseObj instanceof PictogramElement && this.checkbox.getSelection()) {
//				refBaseObj = LinkUtil.getBusinessObjectForLinkedPictogramElement((PictogramElement) refBaseObj);
//			}

			this.m1Object.setData(refBaseObj);
			this.m1Object.setText(refBaseObj.toString());
			final IProject project = ModelAdapterUI.getInstance().getProject(refBaseObj);
			if (project != null) {
				final String decoratedProjectName = PlatformUI.getWorkbench().getDecoratorManager().getLabelDecorator().decorateText(
						project.getName(), project);
				if (decoratedProjectName != null) {
					this.txtProject.setText(decoratedProjectName);
				}
			} else {
				this.txtProject.setText(Messages.OCLEvaluationView_12_xmsg);
			}
		}
	}

	private void updateEvaluateButton() {

		final String oclExpr = this.oclExpression.getText();
		if ("".equals(oclExpr) || oclExpr == null || this.m1Object.getData() == null) { //$NON-NLS-1$
			this.evaluate.setEnabled(false);
		} else {
			this.evaluate.setEnabled(true);
		}
	}

	public class MoinOclWrapper {
		private static final String GLX_OCL_EVALUATOR = "urn:com.sap.glx.ocl.evaluator"; //$NON-NLS-1$

		private static final String GLX_OCL_EXPRESSION = MoinOclWrapper.GLX_OCL_EVALUATOR + ".expression"; //$NON-NLS-1$

		private final String errorReport = Messages.OCLEvaluationView_13_xmsg;

		public void evaluate(RefObject data, String oclExpression) {

			if (!((Partitionable) data).is___Alive()) {
				OCLEvaluationView.this.result.setText(Messages.OCLEvaluationView_14_xmsg);
				return;
			}

			final long start = System.nanoTime();
			OclExpressionRegistration expression;
			try {
				final String name = MoinOclWrapper.GLX_OCL_EXPRESSION;
				final OclRegistrationSeverity severity = OclRegistrationSeverity.Warning;
				final String[] categories = new String[] { MoinOclWrapper.GLX_OCL_EVALUATOR };
				final RefClass context = data.refClass();
				final Connection conn = ((Partitionable) data).get___Connection();
				final RefPackage[] typesPackages = new RefPackage[] { context.refOutermostPackage(), conn.getPackage(ModelPackage.PACKAGE_DESCRIPTOR) };

				
				final OclFreestyleRegistry ocl = conn.getOclRegistryService().getFreestyleRegistry();

				try {
					if (ocl.getRegistration(name) != null)
						ocl.deleteRegistration(name);
				}
				catch (final RuntimeException e) { // $JL-EXC$
					// getRegistration() comlains about names not registered -
					// ignore this since we want to delete the entry anyway
				}

				expression = ocl.createExpressionRegistration(name, oclExpression, severity, categories, context, typesPackages);
				final long end = System.nanoTime();
				final double time = Math.round((end - start) / 1000000d) / 1000d;
				final String resultText = Messages.OCLEvaluationView_15_xmsg;
				OCLEvaluationView.this.resultLabel.setText(MessageFormat.format(resultText, new Object[] { time }));

				OCLEvaluationView.this.result.setText(String.valueOf(expression.evaluateExpression(data)));
			}
			catch (final OclManagerException e) {
				final StringWriter buffer = new StringWriter();
				final PrintWriter writer = new PrintWriter(buffer);
				if (e.getCause() instanceof ParsingException) {
					// todo: printReport(Locale, Stream)
					writer.println(MessageFormat.format(this.errorReport, new Object[] { ((ParsingException) e.getCause()).getReport()
							.toString() }));
				} else {
					writer.println((e.getMessage() != null) ? MessageFormat.format(this.errorReport,
							new Object[] { e.getLocalizedMessage() }) : Messages.OCLEvaluationView_16_xmsg);
				}

				OCLEvaluationView.this.result.setText(buffer.toString());
			}
			catch (final Exception e) {
				final String message = (e.getMessage() != null) ? MessageFormat.format(this.errorReport, new Object[] { e
						.getLocalizedMessage() }) : Messages.OCLEvaluationView_17_xmsg;
				OCLEvaluationView.this.result.setText(message);
			}

		}
	}

}
