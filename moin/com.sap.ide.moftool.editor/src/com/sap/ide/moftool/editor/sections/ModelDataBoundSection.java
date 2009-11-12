package com.sap.ide.moftool.editor.sections;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.ide.moftool.editor.fwk.BrowseTypeControl;
import com.sap.ide.moftool.editor.fwk.ListWidgetHelper;
import com.sap.ide.moftool.editor.fwk.MultiplicityTypeControl;
import com.sap.ide.moftool.editor.fwk.TypeListControl;
import com.sap.ide.moftool.editor.fwk.BrowseTypeControl.TypeFilter;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.databinding.controls.DataBoundSectionComposite;
import com.sap.tc.moin.repository.mmi.descriptors.StructuralFeatureDescriptor;

public abstract class ModelDataBoundSection<M extends RefObject> extends DataBoundSectionComposite<M> {

	private List<Control> controls = new ArrayList<Control>();
	private List<MultiplicityTypeControl> multiControls = new ArrayList<MultiplicityTypeControl>();

	public ModelDataBoundSection(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	protected void createLabel(String label, int hSpan, Composite rootComposite, FormToolkit toolkit) {
		Label labelWidget = toolkit.createLabel(rootComposite, label);
		GridData layoutData = new GridData(SWT.LEFT, SWT.TOP, false, false);
		layoutData.horizontalSpan = hSpan;
		labelWidget.setLayoutData(layoutData);
	}

	protected void createLabel(String label, Composite rootComposite, FormToolkit toolkit) {
		createLabel(label, 1, rootComposite, toolkit);
	}

	protected Text createSingleLineText(String label, boolean readonly, Composite rootComposite, FormToolkit toolkit) {
		createLabel(label, rootComposite, toolkit);
		Text t = toolkit.createText(rootComposite, ""); //$NON-NLS-1$
		t.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		if (readonly) {
			t.setEnabled(false);
		}
		return register(t);
	}

	private <T extends Control> T register(T c) {
		controls.add(c);
		return c;
	}
	
	private MultiplicityTypeControl register(MultiplicityTypeControl m) {
		multiControls .add(m);
		return m;
	}

	protected Text createMultiLineText(String label, int height, boolean readonly, Composite rootComposite,
			FormToolkit toolkit) {
		createLabel(label, rootComposite, toolkit);
		Text t = toolkit.createText(rootComposite, "", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL); //$NON-NLS-1$
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
		if (height > 1) {
			GC gc = new org.eclipse.swt.graphics.GC(t);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < height; i++) {
				sb.append("\n"); //$NON-NLS-1$
			}
			gd.heightHint = gc.textExtent(sb.toString()).y;
			gc.dispose();
		}
		t.setLayoutData(gd);
		if (readonly) {
			t.setEnabled(false);
		}
		return register(t);
	}

	protected Button createCheckbox(String label, boolean readonly, Composite rootComposite, FormToolkit toolkit) {
		Button b = toolkit.createButton(rootComposite, label, SWT.CHECK);
		b.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1));
		if (readonly) {
			b.setEnabled(false);
		}
		return register(b);
	}

	protected MultiplicityTypeControl createMultiplicity(String label, boolean readonly, Composite rootComposite,
			FormToolkit toolkit) {
		MultiplicityTypeControl m = new MultiplicityTypeControl(rootComposite, toolkit, label);
		if (readonly) {
			m.setEnabled(false);
		}
		return register(m);
	}

	protected BrowseTypeControl createTypeBrowser(String label, TypeFilter typeFilter, boolean readonly,
			Composite rootComposite, FormToolkit toolkit) {
		createLabel(label, rootComposite, toolkit);
		BrowseTypeControl b = new BrowseTypeControl(toolkit, rootComposite, SWT.NONE, typeFilter);
		b.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		if (readonly) {
			b.setEnabled(false);
		}
		return register(b);
	}

	protected TypeListControl createList(String label, boolean readonly, boolean ordered, ListWidgetHelper helper,
			Composite rootComposite, FormToolkit toolkit) {
		GridData gd = new GridData(SWT.FILL, SWT.TOP, true, false);
		if (label != null) {
			createLabel(label, rootComposite, toolkit);
		} else {
			gd.horizontalSpan = 2;
		}
		TypeListControl t = new TypeListControl(toolkit, rootComposite, ordered, helper);
		t.setLayoutData(gd);
		if (readonly) {
			t.setEnabled(false);
		}
		return register(t);
	}

	protected ComboViewer createCombo(String label, boolean readonly, Composite rootComposite, FormToolkit toolkit) {
		createLabel(label, rootComposite, toolkit);
		CCombo c = new CCombo(rootComposite, SWT.READ_ONLY | SWT.DROP_DOWN);
		toolkit.adapt(c, false, false);
		c.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		c.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		ComboViewer cViewer = new ComboViewer(c);
		cViewer.setContentProvider(new ArrayContentProvider());
		if (readonly) {
			c.setEnabled(false);
		}
		register(c);
		return cViewer;
	}

	protected void bindText(Text t, DataBindingContext dbc, IObservableValue modelObservableValue) {
		org.eclipse.core.databinding.observable.value.IObservableValue target = org.eclipse.jface.databinding.swt.SWTObservables
				.observeText(t, SWT.Modify);
		dbc.bindValue(target, modelObservableValue, null, null);
	}

	protected void bindCheckbox(Button checkbox, DataBindingContext dbc, IObservableValue modelObservableValue) {
		org.eclipse.core.databinding.observable.value.IObservableValue target = org.eclipse.jface.databinding.swt.SWTObservables
				.observeSelection(checkbox);
		dbc.bindValue(target, modelObservableValue, null, null);
	}

	protected void bincCombobox(ComboViewer combo, DataBindingContext dbc, RefObject refObject,
			StructuralFeatureDescriptor<? extends StructuralFeature, ? extends RefObject, ? extends Object> descriptor) {
		IObservableList list = MoinObservables.unmodifiableObservableEnumerationList(refObject, descriptor);
		combo.setInput(list);
		org.eclipse.core.databinding.observable.value.IObservableValue target = org.eclipse.jface.databinding.viewers.ViewersObservables
				.observeSingleSelection(combo);
		org.eclipse.core.databinding.observable.value.IObservableValue model = com.sap.mi.fwk.ui.databinding.MoinObservables
				.observeValue(refObject, descriptor);
		dbc.bindValue(target, model, null, null);
	}

	protected void disableAllControls() {
		for (Control c : controls) {
			c.setEnabled(false);
		}
		for (MultiplicityTypeControl c : multiControls) {
			c.setEnabled(false);
		}
	}

}
