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
import com.sun.org.apache.regexp.internal.REUtil;

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
		final GridLayout layout = new GridLayout();
		layout.marginLeft = 10;
		bodyForm.setLayout(layout);

		
		int basicSectionStyle = ExpandableComposite.TWISTIE | ExpandableComposite.COMPACT | ExpandableComposite.TITLE_BAR;
		if (OCLEvaluationView.isSectionExpanded) {
			basicSectionStyle |= ExpandableComposite.EXPANDED;
		}

		/*
		 * Expression Section
		 */

		final Section expressionSection = this.toolkit.createSection(bodyForm, basicSectionStyle);

		// OCL Expression
		GridData gridDataExpressionSection = new GridData(GridData.FILL_BOTH);
		gridDataExpressionSection.heightHint = 350;
		expressionSection.setLayoutData(gridDataExpressionSection);
		expressionSection.setText(Messages.OCLEvaluationView_1_xhed);

		// 
		Composite composite = this.toolkit.createComposite(expressionSection);
		GridLayout gridLayoutExpressionComposite = new GridLayout(2, false);
		gridLayoutExpressionComposite.marginWidth = 10;
		gridLayoutExpressionComposite.marginHeight = 10;
		composite.setLayout(gridLayoutExpressionComposite);
		this.toolkit.paintBordersFor(composite);

		// Set context for your ...
		final Label sectionLbl = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_2_xtxt);
		GridData gridDataSectionLb1 = new GridData(GridData.FILL_HORIZONTAL);
		gridDataSectionLb1.horizontalSpan = 2;
		gridDataSectionLb1.grabExcessHorizontalSpace = true;
		sectionLbl.setLayoutData(gridDataSectionLb1);

		// Project
		final Label metamodelLbl = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_3_xfld);
		GridData gridDataMetamodelLb1 = new GridData();
		gridDataMetamodelLb1.horizontalSpan = 1;
		metamodelLbl.setLayoutData(gridDataMetamodelLb1);

		//
		this.txtProject = this.toolkit.createText(composite, "");//$NON-NLS-1$
		GridData gridDataTxtProject = new GridData(GridData.FILL_HORIZONTAL);
		gridDataTxtProject.horizontalSpan = 1;
		this.txtProject.setLayoutData(gridDataTxtProject);
		this.toolkit.adapt(this.txtProject, true, true);
		addDropTarget(this.txtProject);

		
		Label label;
		GridData gridDataLabel;
		
		// Object

		label = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_4_xfld, SWT.NONE);
		gridDataLabel = new GridData();
		gridDataLabel.horizontalSpan = 1;
		label.setLayoutData(gridDataLabel);

		this.m1Object = this.toolkit.createText(composite, ""); //$NON-NLS-1$
		GridData gridDataM1Object = new GridData(GridData.FILL_HORIZONTAL);
		gridDataM1Object.horizontalSpan = 1;
		this.m1Object.setLayoutData(gridDataM1Object);
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
		gridDataLabel = new GridData();
		gridDataLabel.horizontalSpan = 1;
		label.setLayoutData(gridDataLabel);
		this.m1ObjectLabel = this.toolkit.createText(composite, "", SWT.READ_ONLY); //$NON-NLS-1$
		this.m1ObjectLabel.setForeground(colorDisabled);
		GridData gridDataM1ObjectTxt = new GridData(GridData.FILL_HORIZONTAL);
		gridDataM1ObjectTxt.horizontalSpan = 1;
		
		this.m1ObjectLabel.setLayoutData(gridDataM1ObjectTxt);
		this.m1ObjectLabel.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				// TODO
			}
		});
		addDropTarget(this.m1ObjectLabel);

		// Context

		label = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_7_xfld, SWT.NONE);
		gridDataLabel = new GridData();
		gridDataLabel.horizontalSpan = 1;
		label.setLayoutData(gridDataLabel);
		this.oclContext = this.toolkit.createText(composite, "", SWT.READ_ONLY); //$NON-NLS-1$
		this.oclContext.setForeground(colorDisabled);
		GridData gridDataOclContext = new GridData(GridData.FILL_HORIZONTAL);

		this.oclContext.setLayoutData(gridDataOclContext);
		this.oclContext.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				// TO DO
			}
		});
		addDropTarget(this.oclContext);

		// Resolve domain model

		this.checkbox = this.toolkit.createButton(composite, Messages.OCLEvaluationView_8_xbut, SWT.CHECK);
		GridData gridDataCheckbox = new GridData(GridData.FILL_HORIZONTAL);
		gridDataCheckbox.horizontalSpan = 2;
		this.checkbox.setLayoutData(gridDataCheckbox);

		// Expression

		label = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_9_xfld, SWT.NONE);
		gridDataLabel = new GridData(GridData.FILL_VERTICAL);
		gridDataLabel.horizontalSpan = 1;
		label.setLayoutData(gridDataLabel);

		
		this.oclExpression = this.toolkit.createText(composite, "", SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);//$NON-NLS-1$
		GridData gridDataOclExpression = new GridData(GridData.FILL_BOTH);
		gridDataOclExpression.heightHint = 100;
		this.oclExpression.setLayoutData(gridDataOclExpression);
		this.oclExpression.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				OCLEvaluationView.this.updateEvaluateButton();
			}
		});
		
		
		this.evaluate = this.toolkit.createButton(composite, Messages.OCLEvaluationView_10_xbut, SWT.NONE);
		GridData gridDataEvaluate = new GridData();
		gridDataEvaluate.horizontalSpan = 2;
		gridDataEvaluate.horizontalAlignment = SWT.RIGHT;
		this.evaluate.setLayoutData(gridDataEvaluate);

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

		//
		GridData gridDataReslutSection = new GridData(GridData.FILL_HORIZONTAL);
		gridDataReslutSection.heightHint = 300;
		resultSection.setLayoutData(gridDataReslutSection);
		resultSection.setText(Messages.OCLEvaluationView_0_xhed);

		//
		composite = this.toolkit.createComposite(resultSection, SWT.FILL);
		GridLayout gridLayoutResultComposite = new GridLayout();//(2,false);
		gridLayoutResultComposite.marginWidth = 10;
		composite.setLayout(gridLayoutResultComposite);
		this.toolkit.paintBordersFor(composite);

		// 
		this.resultLabel = this.toolkit.createLabel(composite, Messages.OCLEvaluationView_11_xfld);
		GridData gridDataResultLabel = new GridData(GridData.FILL_HORIZONTAL);
		gridDataResultLabel.heightHint = 50;
		this.resultLabel.setData(gridDataResultLabel);

		//
		this.result = this.toolkit.createText(composite, "", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
		GridData gridDataResultText = new GridData(GridData.FILL_HORIZONTAL);
		gridDataResultText.heightHint = 140;
		this.result.setLayoutData(gridDataResultText);
		this.result.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				// TO DO
			}
		});
		addDropTarget(this.result);
		resultSection.setClient(composite);

		/**
		 * Hack!! somehow the scrollbar for the whole OCLEvaluationView only works correctly after 
		 * the an fold of an expandable section. So the hack ensures that the scrollbar is working correctly.
		 */
		// Hack Begin
		resultSection.setExpanded(false);
		resultSection.setExpanded(true);
		// Hack End
		
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
