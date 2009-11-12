package com.sap.ide.moftool.editor.fwk;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.sap.ide.moftool.editor.plugin.MOFToolEditorPlugin;
import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;

public abstract class AbstractMoftoolPropertySection extends AbstractPropertySection {

	private ModelDataBoundSection<? extends RefObject> comp;

	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		FormToolkit formToolkit = getWidgetFactory();
		Composite compositeBody = formToolkit.createComposite(parent, SWT.FLAT);
		// used for JUnit testing
		compositeBody.setData("name", getClass().getName()); //$NON-NLS-1$
		TableWrapLayout layout = new TableWrapLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 10;
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		compositeBody.setLayout(layout);
		formToolkit.paintBordersFor(compositeBody);

		// Create the properties section that wraps the DataBoundComposite with
		// a blue faded separator here
		Section section = getWidgetFactory().createSection(compositeBody,
				Section.COMPACT | Section.EXPANDED | Section.TWISTIE);
		Composite cs = getWidgetFactory().createCompositeSeparator(section);
		section.setSeparatorControl(cs);

		// Section section = comp.getControl();
		// current composite
		TableWrapData tableWrapData = new TableWrapData(TableWrapData.FILL_GRAB);
		tableWrapData.colspan = 2;
		section.setLayoutData(tableWrapData);

		comp = createContentsInternal(formToolkit, section);
	}

	protected abstract ModelDataBoundSection<?> createContentsInternal(FormToolkit formToolkit, Section section);

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		comp.setInput(getSelectedModelElement(selection));
	}
	
	@Override
	public void aboutToBeShown() {
		comp.setFocus();
	}
	
	@Override
	public void refresh() {
		comp.refresh();
	}
	
	private RefObject getSelectedModelElement(ISelection selection) {
		return MOFToolEditorPlugin.getBusinessRefObject(selection);
	}
}
