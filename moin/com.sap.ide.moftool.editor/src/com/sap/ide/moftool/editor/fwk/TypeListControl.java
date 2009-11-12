package com.sap.ide.moftool.editor.fwk;

import java.util.Collection;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.IObservableCollection;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ObservableSetContentProvider;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.databinding.MoinUpdateValueStrategy;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.ReferenceDescriptor;
import com.sap.tc.moin.repository.mmi.descriptors.StructuralFeatureDescriptor;

public class TypeListControl extends Composite {

	private Button addButton;
	private Button removeButton;
	private Button downButton;
	private Button upButton;
	private ListViewer lv;
	private final boolean ordered;
	private Connection connection;
	private final ListWidgetHelper helper;
	private RefObject modelElement;
	private ReferenceDescriptor<?, ?, ?> referenceDescriptor;

	public TypeListControl(FormToolkit formToolkit, final Composite parent, boolean ordered,
			final ListWidgetHelper helper) {
		super(parent, SWT.NONE);
		this.ordered = ordered;
		this.helper = helper;
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		setLayout(layout);
		lv = new ListViewer(this, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		formToolkit.adapt(lv.getControl(), true, false);
		lv.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		if (ordered) {
			lv.setContentProvider(new ObservableListContentProvider());
		} else {
			lv.setContentProvider(new ObservableSetContentProvider());
		}
		lv.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return (String) helper.getToUiConverter().convert(element);
			}
		});
		Composite buttons = formToolkit.createComposite(this);
		buttons.setLayout(new FillLayout(SWT.VERTICAL));

		addButton = formToolkit.createButton(buttons, LocalizationMessages.TypeListControl_0_XBUT, SWT.PUSH);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ModelElement element2Add = helper.openAddDialog(parent.getShell(), connection, modelElement);
				if (element2Add != null) {
					((Collection) modelElement.refGetValue(getStructuralFeature(modelElement, referenceDescriptor)))
							.add(element2Add);
				}
			}
		});

		if (ordered) {
			upButton = formToolkit.createButton(buttons, LocalizationMessages.TypeListControl_1_XBUT, SWT.PUSH);
			upButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Object element = ((IStructuredSelection) lv.getSelection()).getFirstElement();
					List list = (List) modelElement
							.refGetValue(getStructuralFeature(modelElement, referenceDescriptor));
					int indexOf = list.indexOf(element);
					list.remove(indexOf);
					list.add(indexOf - 1, element);
				}
			});
			downButton = formToolkit.createButton(buttons, LocalizationMessages.TypeListControl_2_XBUT, SWT.PUSH);
			downButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Object element = ((IStructuredSelection) lv.getSelection()).getFirstElement();
					List list = (List) modelElement
							.refGetValue(getStructuralFeature(modelElement, referenceDescriptor));
					int indexOf = list.indexOf(element);
					list.remove(indexOf);
					list.add(indexOf + 1, element);
				}
			});
		} else {
			lv.setSorter(new ViewerSorter());
		}

		removeButton = formToolkit.createButton(buttons, LocalizationMessages.TypeListControl_3_XBUT, SWT.PUSH);
		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Object element2Delete = ((IStructuredSelection) lv.getSelection()).getFirstElement();
				if (element2Delete != null) {
					((Collection) modelElement.refGetValue(getStructuralFeature(modelElement, referenceDescriptor)))
							.remove(element2Delete);
				}
			}
		});
		buttons.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		lv.getControl().setEnabled(enabled);
		addButton.setEnabled(enabled);
		if (ordered) {
			upButton.setEnabled(enabled);
			downButton.setEnabled(enabled);
		}
		removeButton.setEnabled(enabled);
	}

	@Override
	public boolean setFocus() {
		return lv.getControl().setFocus();
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		lv.getControl().setVisible(visible);
		addButton.setVisible(visible);
		if (ordered) {
			upButton.setVisible(visible);
			downButton.setVisible(visible);
		}
		removeButton.setVisible(visible);
	}

	public void setInput(final RefObject modelElement, final ReferenceDescriptor<?, ?, ?> referenceDescriptor,
			DataBindingContext dbc) {
		this.modelElement = modelElement;
		this.referenceDescriptor = referenceDescriptor;
		connection = ((Partitionable) modelElement).get___Connection();
		IConverter toUiConverter = helper.getToUiConverter();
		IConverter toModelConverter = helper.getToModelConverter(connection);

//		IObservableList listObservable = SWTObservables.observeItems(lv.getControl());
//		UpdateListStrategy toModelStrategy = new MoinUpdateListStrategy().setConverter(toModelConverter);
//		if (getStructuralFeature(modelElement, referenceDescriptor).getMultiplicity().isOrdered()) {
//			IObservableList referenceValue = MoinObservables.observeList((ModelElement) modelElement,
//					referenceDescriptor);
//			dbc.bindList(listObservable, referenceValue, toModelStrategy, new MoinUpdateListStrategy()
//					.setConverter(toUiConverter));
//		} else {
//			// FIXME This is not yet possible
//			 IObservableSet referenceValue = MoinObservables.observeSet((ModelElement) modelElement,
//					 referenceDescriptor);
//			 dbc.bindSet(new ListToSetAdapter(listObservable)., referenceValue,
//			 toModelStrategy, new MoinUpdateSetStrategy()
//			 .setConverter(toUiConverter));
//
//		}
//
		// Children - binding the input of the list and the buttons area to the
		// list of referenced child components and its selection
		// IObservableSet knownElements = ((ObservableSetContentProvider)
		// contentProvider).getKnownElements();
//		if (ordered) {
//			lv.setContentProvider(new ObservableListContentProvider());
//		} else {
//			lv.setContentProvider(new ObservableSetContentProvider());
//		}
		IObservableSet knownElements = null;
		if (ordered) {
			IObservableCollection input = MoinObservables.observeList(modelElement, referenceDescriptor);
			lv.setInput(input);
			knownElements = ((ObservableListContentProvider) lv.getContentProvider()).getKnownElements();
		} else {
			IObservableCollection input = MoinObservables.observeSet(modelElement, referenceDescriptor);
			lv.setInput(input);
			knownElements = ((ObservableSetContentProvider) lv.getContentProvider()).getKnownElements();
		}
		// And a standard label provider that maps columns
//		IObservableMap attributeMap = MoinObservables.observeMap(knownElements, modelElement, referenceDescriptor,
//				ModelElement.DESCRIPTORS.NAME());
//		lv.setLabelProvider(new ObservableMapLabelProvider(attributeMap));

		// Observables for state of list
		IViewerObservableValue childrenSelection = ViewersObservables.observeSingleSelection(lv);

		// Add button is always enabled --> no special coding here

		// Remove button: enabled when at least one element is selected
		// IObservableValue removeButtonEnablementModel = new
		// RemoveChildComponentEnablement(childrenSelection);
		IObservableValue removeButtonEnablementTarget = SWTObservables.observeEnabled(removeButton);
		dbc.bindValue(removeButtonEnablementTarget, childrenSelection/* removeButtonEnablementModel */, null,
				new MoinUpdateValueStrategy().setConverter(new IConverter() {

					public Object getToType() {
						return Boolean.class;
					}

					public Object getFromType() {
						return ModelElement.class;
					}

					public Object convert(Object fromObject) {
						return fromObject != null;
					}
				}));
		if (ordered) {
			IObservableValue upButtonEnablementTarget = SWTObservables.observeEnabled(upButton);
			dbc.bindValue(upButtonEnablementTarget, childrenSelection, null, new MoinUpdateValueStrategy()
					.setConverter(new IConverter() {

						public Object getToType() {
							return Boolean.class;
						}

						public Object getFromType() {
							return ModelElement.class;
						}

						public Object convert(Object fromObject) {
							List list = (List) modelElement.refGetValue(getStructuralFeature(modelElement,
									referenceDescriptor));
							int indexOf = list.indexOf(fromObject);
							return fromObject != null && indexOf > 0;
						}
					}));

			IObservableValue downButtonEnablementTarget = SWTObservables.observeEnabled(downButton);
			dbc.bindValue(downButtonEnablementTarget, childrenSelection, null, new MoinUpdateValueStrategy()
					.setConverter(new IConverter() {

						public Object getToType() {
							return Boolean.class;
						}

						public Object getFromType() {
							return ModelElement.class;
						}

						public Object convert(Object fromObject) {
							List list = (List) modelElement.refGetValue(getStructuralFeature(modelElement,
									referenceDescriptor));
							int indexOf = list.indexOf(fromObject);
							return fromObject != null && indexOf < list.size() - 1;
						}
					}));
		}
	}

	public static StructuralFeature getStructuralFeature(
			RefBaseObject modelElement,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> featureDescriptor) {
		Assert.isLegal(modelElement != null, "MofClass must not be null"); //$NON-NLS-1$
		Assert.isLegal(featureDescriptor != null, "Feature descriptor must not be null"); //$NON-NLS-1$

		Connection connection = ModelAdapter.getInstance().getConnection(modelElement);
		StructuralFeature structuralFeature = connection.getMetamodelElement(featureDescriptor);

		if (structuralFeature == null) {
			throw new IllegalArgumentException(
					"Attribute or Reference with name <" + featureDescriptor.getQualifiedName() //$NON-NLS-1$
							+ "> not defined for metamodel entity <" + modelElement.toString() + ">"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return structuralFeature;
	}

	public void setEditable(boolean enabled) {
		addButton.setEnabled(enabled);
		removeButton.setEnabled(enabled);
		lv.getList().setEnabled(enabled);
		if (ordered) {
			upButton.setEnabled(enabled);
			downButton.setEnabled(enabled);
		}
	}
}
