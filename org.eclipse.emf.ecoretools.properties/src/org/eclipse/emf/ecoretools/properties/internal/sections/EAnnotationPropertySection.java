/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: EAnnotationPropertySection.java,v 1.8 2009/05/06 13:54:14 jlescot Exp $
 **********************************************************************/

package org.eclipse.emf.ecoretools.properties.internal.sections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.ui.celleditor.ExtendedDialogCellEditor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.ecoretools.properties.internal.Messages;
import org.eclipse.emf.ecoretools.tabbedproperties.EMFRecordingChangeCommand;
import org.eclipse.emf.ecoretools.tabbedproperties.providers.TabbedPropertiesLabelProvider;
import org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection;
import org.eclipse.emf.edit.ui.celleditor.FeatureEditorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerEditor;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationEvent;
import org.eclipse.jface.viewers.ColumnViewerEditorActivationStrategy;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.FocusCellOwnerDrawHighlighter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.TreeViewerEditor;
import org.eclipse.jface.viewers.TreeViewerFocusCellManager;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * Annotations section <br>
 * creation : 23 avr. 2008
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class EAnnotationPropertySection extends AbstractTabbedPropertySection {

	private static class MultiLineInputDialog extends InputDialog {

		public MultiLineInputDialog(Shell parentShell, String title, String message, String initialValue, IInputValidator validator ) {
			super(parentShell, title, message, initialValue, validator);
			setShellStyle(getShellStyle() | SWT.RESIZE);
		}

		/**
		 * @see org.eclipse.jface.dialogs.Dialog#createButtonBar(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected Control createButtonBar(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			// create a layout with spacing and margins appropriate for the font
			// size.
			GridLayout layout = new GridLayout();
			layout.numColumns = 0; // this is incremented by createButton
			layout.makeColumnsEqualWidth = true;
			layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
			layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
			layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
			layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
			composite.setLayout(layout);
			GridData data = new GridData(GridData.HORIZONTAL_ALIGN_END | GridData.VERTICAL_ALIGN_CENTER);
			composite.setLayoutData(data);
			composite.setFont(parent.getFont());

			// Add the buttons to the button bar.
			createButtonsForButtonBar(composite);
			return composite;
		}

		/**
		 * @see org.eclipse.jface.dialogs.InputDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
		 */
		@Override
		protected Control createDialogArea(Composite parent) {
			Control control = super.createDialogArea(parent);
			Text text = getText();
			if (text != null) {
				GridData data = new GridData(GridData.FILL_BOTH);
				data.grabExcessVerticalSpace = true;
				data.grabExcessHorizontalSpace = true;
				data.heightHint = 5 * text.getLineHeight();
				data.widthHint = convertHorizontalDLUsToPixels(IDialogConstants.ENTRY_FIELD_WIDTH);
				text.setLayoutData(data);
			}

			return control;
		}

		/*
		 * @see org.eclipse.jface.dialogs.InputDialog#getInputTextStyle()
		 */
		@Override
		protected int getInputTextStyle() {
			return SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;
		}
	}

	private class ViewerContentProvider implements ITreeContentProvider {

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List) {
				return ((List<?>) parentElement).toArray();
			}
			if (parentElement instanceof Map) {
				return ((Map<?, ?>) parentElement).entrySet().toArray();
			}
			return Collections.EMPTY_LIST.toArray();
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof List) {
				return ((List<?>) element).isEmpty();
			}
			if (element instanceof Map) {
				return ((Map<?, ?>) element).isEmpty();
			}
			return false;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public void dispose() {
			// Ignore
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// Ignore
		}
	}

	private Group groupEAnnotations;

	private Group groupMapEntries;

	private TreeViewer eAnnotationViewer;

	private TreeViewer mapEntryViewer;

	private EAnnotation currentEAnnotation;

	private Entry<?, ?> currentEntry;

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getFeature()
	 */
	@Override
	protected EStructuralFeature getFeature() {
		return EcorePackage.Literals.EMODEL_ELEMENT__EANNOTATIONS;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#getLabelText()
	 */
	@Override
	protected String getLabelText() {
		return Messages.EAnnotationPropertySection_Annotations;
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractTabbedPropertySection#createWidgets(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createWidgets(Composite composite) {
		super.createWidgets(composite);
		groupEAnnotations = getWidgetFactory().createGroup(composite, Messages.EAnnotationPropertySection_AnnotationsGroup);
		groupEAnnotations.setLayout(new GridLayout());

		createGroupEAnnotationContents(groupEAnnotations);

		groupMapEntries = getWidgetFactory().createGroup(composite, Messages.EAnnotationPropertySection_EntriesGroup);
		groupMapEntries.setLayout(new GridLayout());

		createGroupMapEntryContents(groupMapEntries);
	}

	/**
	 * @see org.eclipse.emf.ecoretools.tabbedproperties.sections.AbstractListPropertySection#setSectionData(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void setSectionData(Composite composite) {
		super.setSectionData(composite);
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		groupEAnnotations.setLayoutData(data);

		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(groupEAnnotations, ITabbedPropertyConstants.VSPACE);
		groupMapEntries.setLayoutData(data);
	}

	/**
	 * Create the group contents
	 * 
	 * @param parent
	 *            the parent Composite
	 */
	protected void createGroupEAnnotationContents(Composite parent) {
		TabbedPropertySheetWidgetFactory widgetFactory = getWidgetFactory();
		Composite composite = widgetFactory.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridData featureViewerData2 = new GridData(GridData.FILL_BOTH);
		featureViewerData2.grabExcessHorizontalSpace = true;
		featureViewerData2.grabExcessVerticalSpace = true;
		featureViewerData2.verticalSpan = 2;
		featureViewerData2.heightHint = 80;

		createEAnnotationViewer(composite, featureViewerData2);

		addRemoveButtonEAnnotationComposite(composite, eAnnotationViewer);
	}

	/**
	 * Create the group contents
	 * 
	 * @param parent
	 *            the parent Composite
	 */
	protected void createGroupMapEntryContents(Composite parent) {
		TabbedPropertySheetWidgetFactory widgetFactory = getWidgetFactory();
		Composite composite = widgetFactory.createComposite(parent);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridData featureViewerData2 = new GridData(GridData.FILL_BOTH);
		featureViewerData2.grabExcessHorizontalSpace = true;
		featureViewerData2.grabExcessVerticalSpace = true;
		featureViewerData2.verticalSpan = 2;
		featureViewerData2.heightHint = 80;

		createMapEntryViewer(composite, featureViewerData2);

		addRemoveButtonMapEntryComposite(composite, mapEntryViewer);
	}

	private void createMapEntryViewer(Composite parent, GridData layoutData) {
		mapEntryViewer = createTreeViewer(parent, layoutData);

		final TextCellEditor textCellEditor = new TextCellEditor(mapEntryViewer.getTree());
		TreeViewerColumn columnKey = new TreeViewerColumn(mapEntryViewer, SWT.NONE);
		columnKey.getColumn().setResizable(true);
		columnKey.getColumn().setMoveable(true);
		columnKey.getColumn().setWidth(200);
		columnKey.getColumn().setText(Messages.EAnnotationPropertySection_Key);
		columnKey.setLabelProvider(new ColumnLabelProvider() {

			private ILabelProvider labelProvider = getLabelProvider();

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof Entry) {
					return (((Entry<?, ?>) element).getKey() != null) ? ((Entry<?, ?>) element).getKey().toString() : Messages.EAnnotationPropertySection_Null;
				}
				return Messages.EAnnotationPropertySection_Unknown;
			}

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
			 */
			@Override
			public Image getImage(Object element) {
				return labelProvider.getImage(element);
			}

			/**
			 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
			 */
			@Override
			public void dispose() {
				labelProvider.dispose();
				super.dispose();
			}

		});
		columnKey.setEditingSupport(new EditingSupport(eAnnotationViewer) {

			@Override
			protected boolean canEdit(Object element) {
				if (false == element instanceof Entry) {
					return false;
				}
				return true;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return textCellEditor;
			}

			@Override
			protected Object getValue(Object element) {
				if (false == element instanceof Entry) {
					return ""; //$NON-NLS-1$
				}
				return ((((Entry<?, ?>) element).getKey() == null) ? "" : ((Entry<?, ?>) element).getKey()); //$NON-NLS-1$
			}

			@Override
			protected void setValue(Object element, Object value) {
				if (false == element instanceof Entry) {
					return;
				}
				final String text = value.toString();
				if (currentEAnnotation != null && currentEAnnotation.getDetails().get(text) != null)
				{
					return;
				}
				final Entry<?, ?> entry = (Entry<?, ?>) element;
				getEditingDomain().getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						currentEAnnotation.getDetails().put(text, entry.getValue().toString());
						currentEAnnotation.getDetails().remove(entry);
					}
				});

				mapEntryViewer.refresh();
			}

		});

		TreeViewerColumn columnValue = new TreeViewerColumn(mapEntryViewer, SWT.NONE);
		columnValue.getColumn().setResizable(true);
		columnValue.getColumn().setMoveable(true);
		columnValue.getColumn().setWidth(200);
		columnValue.getColumn().setText(Messages.EAnnotationPropertySection_Value);
		columnValue.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if (false == element instanceof Entry) {
					return ""; //$NON-NLS-1$
				}
				return ((((Entry<?, ?>) element).getValue() == null) ? "" : ((Entry<?, ?>) element).getValue().toString()); //$NON-NLS-1$
			}

		});

		final DialogCellEditor dialogCellEditor = new ExtendedDialogCellEditor(mapEntryViewer.getTree(), getLabelProvider()) {

			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				MultiLineInputDialog dialog = new MultiLineInputDialog(cellEditorWindow.getShell(), Messages.EAnnotationPropertySection_EntryValue, null, getCurrentEntryValue(), null);
				dialog.open();

				return dialog.getValue();
			}

			private String getCurrentEntryValue() {
				if (currentEntry == null) {
					return ""; //$NON-NLS-1$
				}
				return currentEntry.getValue().toString();
			}
		};
		columnValue.setEditingSupport(new EditingSupport(eAnnotationViewer) {

			@Override
			protected boolean canEdit(Object element) {
				if (false == element instanceof Entry) {
					return false;
				}
				return true;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return dialogCellEditor;
			}

			@Override
			protected Object getValue(Object element) {
				if (false == element instanceof Entry) {
					return ""; //$NON-NLS-1$
				}
				return ((((Entry<?, ?>) element).getValue() == null) ? "" : ((Entry<?, ?>) element).getValue()); //$NON-NLS-1$
			}

			@Override
			protected void setValue(Object element, Object value) {
				if (false == element instanceof Entry) {
					return;
				}
				final String text = value.toString();
				@SuppressWarnings("unchecked")
				final Entry<?, String> entry = (Entry<?, String>) element;
				getEditingDomain().getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						entry.setValue(text);
					}
				});

				mapEntryViewer.update(element, null);
			}

		});

		mapEntryViewer.setContentProvider(new ViewerContentProvider());
		mapEntryViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (false == event.getSelection() instanceof IStructuredSelection) {
					currentEntry = null;
					return;
				}
				Object selection = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (false == selection instanceof Entry) {
					currentEntry = null;
					return;
				}
				currentEntry = (Entry<?, ?>) selection;
			}

		});
	}

	private void createEAnnotationViewer(Composite parent, GridData layoutData) {
		eAnnotationViewer = createTreeViewer(parent, layoutData);

		final TextCellEditor textCellEditor = new TextCellEditor(eAnnotationViewer.getTree());
		TreeViewerColumn columnName = new TreeViewerColumn(eAnnotationViewer, SWT.NONE);
		columnName.getColumn().setResizable(true);
		columnName.getColumn().setMoveable(true);
		columnName.getColumn().setWidth(200);
		columnName.getColumn().setText(Messages.EAnnotationPropertySection_Source);
		columnName.setLabelProvider(new ColumnLabelProvider() {

			private ILabelProvider labelProvider = getLabelProvider();

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				if (element instanceof EAnnotation) {
					return ((EAnnotation) element).getSource();
				}
				return Messages.EAnnotationPropertySection_Unknown;
			}

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getImage(java.lang.Object)
			 */
			@Override
			public Image getImage(Object element) {
				return labelProvider.getImage(element);
			}

			/**
			 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
			 */
			@Override
			public void dispose() {
				labelProvider.dispose();
				super.dispose();
			}

		});
		columnName.setEditingSupport(new EditingSupport(eAnnotationViewer) {

			@Override
			protected boolean canEdit(Object element) {
				if (false == element instanceof EAnnotation) {
					return false;
				}
				return true;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return textCellEditor;
			}

			@Override
			protected Object getValue(Object element) {
				if (false == element instanceof EAnnotation) {
					return ""; //$NON-NLS-1$
				}
				return ((((EAnnotation) element).getSource() == null) ? "" : ((EAnnotation) element).getSource()); //$NON-NLS-1$
			}

			@Override
			protected void setValue(Object element, Object value) {
				if (false == element instanceof EAnnotation) {
					return;
				}
				final String text = value.toString();
				if (((EModelElement) getEObject()).getEAnnotation(text) != null) {
					return;
				}
				final EAnnotation eAnnotation = (EAnnotation) element;
				getEditingDomain().getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						eAnnotation.setSource(text);
					}
				});

				eAnnotationViewer.update(element, null);
			}

		});

		TreeViewerColumn columnEReference = new TreeViewerColumn(eAnnotationViewer, SWT.NONE);
		columnEReference.getColumn().setResizable(true);
		columnEReference.getColumn().setMoveable(true);
		columnEReference.getColumn().setWidth(200);
		columnEReference.getColumn().setText(Messages.EAnnotationPropertySection_References);
		columnEReference.setLabelProvider(new ColumnLabelProvider() {

			private ILabelProvider labelProvider = getLabelProvider();

			/**
			 * @see org.eclipse.jface.viewers.ColumnLabelProvider#getText(java.lang.Object)
			 */
			@Override
			public String getText(Object element) {
				if (false == element instanceof EAnnotation) {
					return ""; //$NON-NLS-1$
				}
				String content = ""; //$NON-NLS-1$
				for (EObject eObject : ((EAnnotation) element).getReferences()) {
					content = labelProvider.getText(eObject) + ", " + content; //$NON-NLS-1$
				}

				return content;
			}

			/**
			 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
			 */
			@Override
			public void dispose() {
				labelProvider.dispose();
				super.dispose();
			}

		});

		final DialogCellEditor dialogCellEditor = new ExtendedDialogCellEditor(eAnnotationViewer.getTree(), getLabelProvider()) {

			@Override
			protected Object openDialogBox(Control cellEditorWindow) {
				FeatureEditorDialog dialog = new FeatureEditorDialog(cellEditorWindow.getShell(), labelProvider, currentEAnnotation, EcorePackage.Literals.EANNOTATION__REFERENCES,
						Messages.EAnnotationPropertySection_ChooseReferences, getPotentialReferences());
				dialog.open();

				return dialog.getResult();
			}

			private List<?> getPotentialReferences() {
				List<EObject> potentialMatches = new ArrayList<EObject>();
				if (currentEAnnotation.eResource() == null) {
					return Collections.emptyList();
				}
				for (Iterator<EObject> it = currentEAnnotation.eResource().getAllContents(); it.hasNext();) {
					potentialMatches.add(it.next());
				}

				return potentialMatches;
			}
		};
		columnEReference.setEditingSupport(new EditingSupport(eAnnotationViewer) {

			private ILabelProvider labelProvider = getLabelProvider();

			@Override
			protected boolean canEdit(Object element) {
				if (false == element instanceof EAnnotation) {
					return false;
				}
				return true;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return dialogCellEditor;
			}

			@Override
			protected Object getValue(Object element) {
				if (false == element instanceof EAnnotation) {
					return ""; //$NON-NLS-1$
				}
				String content = ""; //$NON-NLS-1$
				for (EObject eObject : ((EAnnotation) element).getReferences()) {
					content = labelProvider.getText(eObject) + ", " + content; //$NON-NLS-1$
				}

				return content;
			}

			@Override
			protected void setValue(Object element, final Object value) {
				if (false == element instanceof EAnnotation || value == null) {
					return;
				}
				final EAnnotation eAnnotation = (EAnnotation) element;
				getEditingDomain().getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						if (value instanceof List) {
							eAnnotation.getReferences().clear();
							@SuppressWarnings("unchecked")
							List<EObject> eObjectValues = (List<EObject>) value;
							eAnnotation.getReferences().addAll(eObjectValues);
						}
					}
				});

				eAnnotationViewer.update(element, null);
			}

		});

		eAnnotationViewer.setContentProvider(new ViewerContentProvider());
		eAnnotationViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (false == event.getSelection() instanceof IStructuredSelection) {
					currentEAnnotation = null;
					return;
				}
				Object selection = ((IStructuredSelection) event.getSelection()).getFirstElement();
				if (false == selection instanceof EAnnotation) {
					currentEAnnotation = null;
					return;
				}
				currentEAnnotation = (EAnnotation) selection;
				mapEntryViewer.setInput(getMapEntries());
			}

		});
	}

	private Collection<? extends EAnnotation> getEAnnotations() {
		if (getEObject() instanceof EModelElement) {
			return ((EModelElement) getEObject()).getEAnnotations();
		}
		return Collections.emptyList();
	}

	private Collection<Map.Entry<String, String>> getMapEntries() {
		if (currentEAnnotation != null) {
			return currentEAnnotation.getDetails();
		}
		return Collections.emptyList();
	}

	private TreeViewer createTreeViewer(Composite parent, GridData layoutData) {
		TreeViewer treeViewer = new TreeViewer(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
		treeViewer.getTree().setLinesVisible(true);
		treeViewer.getTree().setHeaderVisible(true);
		treeViewer.getTree().setLayoutData(layoutData);

		TreeViewerFocusCellManager focusCellManager = new TreeViewerFocusCellManager(treeViewer, new FocusCellOwnerDrawHighlighter(treeViewer));
		ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(treeViewer) {

			@Override
			protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
				return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL || event.eventType == ColumnViewerEditorActivationEvent.MOUSE_CLICK_SELECTION
						|| (event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED && event.keyCode == SWT.CR) || event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
			}
		};

		TreeViewerEditor.create(treeViewer, focusCellManager, actSupport, ColumnViewerEditor.TABBING_HORIZONTAL | ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR | ColumnViewerEditor.TABBING_VERTICAL
				| ColumnViewerEditor.KEYBOARD_ACTIVATION);

		return treeViewer;
	}

	private void addRemoveButtonEAnnotationComposite(Composite parent, TreeViewer viewer) {
		TabbedPropertySheetWidgetFactory widgetFactory = getWidgetFactory();
		Composite comp = widgetFactory.createComposite(parent);
		comp.setLayout(new GridLayout());

		Button add = widgetFactory.createButton(comp, Messages.EAnnotationPropertySection_Add, SWT.NONE);
		add.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		add.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do
			}

			public void widgetSelected(SelectionEvent e) {
				if (false == getEObject() instanceof EModelElement) {
					return;
				}
				final EAnnotation newEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				setDefaultNameForElement((EModelElement) getEObject(), newEAnnotation);
				getEditingDomain().getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						((EModelElement) getEObject()).getEAnnotations().add(newEAnnotation);
					}
				});

				eAnnotationViewer.setInput(getEAnnotations());
			}

			private void setDefaultNameForElement(EModelElement container, EAnnotation elementToConfigure) {
				Boolean foundName = false;
				int count = 0;
				while (!foundName && count < 10000) {
					if (container.getEAnnotation(Messages.EAnnotationPropertySection_EAnnotation + count) == null) {
						elementToConfigure.setSource(Messages.EAnnotationPropertySection_EAnnotation + count);
						foundName = true;
					}
					count++;
				}
			}

		});

		Button remove = widgetFactory.createButton(comp, Messages.EAnnotationPropertySection_Remove, SWT.NONE);
		remove.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		remove.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do
			}

			public void widgetSelected(SelectionEvent e) {
				if (false == getEObject() instanceof EModelElement) {
					return;
				}
				getEditingDomain().getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						((EModelElement) getEObject()).getEAnnotations().remove(currentEAnnotation);
					}
				});

				eAnnotationViewer.setInput(getEAnnotations());
			}

		});
	}

	private void addRemoveButtonMapEntryComposite(Composite parent, TreeViewer viewer) {
		TabbedPropertySheetWidgetFactory widgetFactory = getWidgetFactory();
		Composite comp = widgetFactory.createComposite(parent);
		comp.setLayout(new GridLayout());

		Button add = widgetFactory.createButton(comp, Messages.EAnnotationPropertySection_Add, SWT.NONE);
		add.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		add.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do
			}

			public void widgetSelected(SelectionEvent e) {
				if (currentEAnnotation == null) {
					return;
				}
				getEditingDomain().getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						currentEAnnotation.getDetails().put(getKeyString(currentEAnnotation), ""); //$NON-NLS-1$
					}
				});

				mapEntryViewer.setInput(getMapEntries());
			}

			private String getKeyString(EAnnotation container) {
				int count = 0;
				for (Map.Entry<String, String> eDetail : container.getDetails()) {
					if (eDetail.getKey() != null) {
						if (eDetail.getKey().equals(Messages.EAnnotationPropertySection_EStringToStringMapEntry + count)) {
							count++;
						}
					}
				}
				return Messages.EAnnotationPropertySection_EStringToStringMapEntry + count;
			}

		});

		Button remove = widgetFactory.createButton(comp, Messages.EAnnotationPropertySection_Remove, SWT.NONE);
		remove.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		remove.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// Nothing to do
			}

			public void widgetSelected(SelectionEvent e) {
				if (currentEAnnotation == null) {
					return;
				}
				getEditingDomain().getCommandStack().execute(new EMFRecordingChangeCommand(getEObject().eResource()) {

					@Override
					protected void doExecute() {
						currentEAnnotation.getDetails().remove(currentEntry);
					}
				});

				mapEntryViewer.setInput(getMapEntries());
			}

		});
	}

	protected ILabelProvider getLabelProvider() {
		return new TabbedPropertiesLabelProvider(new EcoreItemProviderAdapterFactory());
	}

	@Override
	public void refresh() {
		super.refresh();
		eAnnotationViewer.setInput(getEAnnotations());
		mapEntryViewer.setInput(getMapEntries());
	}

}
