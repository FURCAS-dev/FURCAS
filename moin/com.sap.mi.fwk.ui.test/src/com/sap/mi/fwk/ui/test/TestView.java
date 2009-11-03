package com.sap.mi.fwk.ui.test;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetPage;

import com.sap.ide.metamodel.webdynpro.component.view.View;
import com.sap.mi.fwk.ui.properties.RefObjectPropertySourceManager;

/**
 * Test view for the generic {@link RefObject} property support
 * 
 * @author d031150
 */
public class TestView extends ViewPart {
	
	static final String ID_VIEW = "com.sap.mi.fwk.ui.test.views.refObjectProperties";
	
	private TreeViewer viewer;
	private View view;
	private PropertySheetPage mPropertyPage;

	/**
	 * The constructor.
	 */
	public TestView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		viewer = new TreeViewer(parent);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setInput(this);
		getSite().setSelectionProvider(viewer);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		if (viewer != null)
			viewer.getControl().setFocus();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(Class adapter) {
        if (IPropertySheetPage.class == adapter)
            return setupPropertyPage();
		return super.getAdapter(adapter);
	}
	
	public void setInputAndSelect(View view) {
		this.view = view;
		if (viewer != null) {
			viewer.refresh();
			viewer.setSelection(new StructuredSelection(view));
		}
	}
	
    private IPropertySheetPage setupPropertyPage() {
        if (mPropertyPage != null) {
            mPropertyPage.dispose();
        }
        mPropertyPage = new PropertySheetPage();
        PropertySheetEntry p = new PropertySheetEntry();
        p.setPropertySourceProvider(new RefObjectPropertySourceManager());
        mPropertyPage.setRootEntry(p);
        return mPropertyPage;
    }

	class ViewContentProvider implements ITreeContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (view != null)
				return new Object[] {view};
			return new Object[0];
		}
		public Object[] getChildren(Object parentElement) {
			return new Object[0];
		}
		public Object getParent(Object element) {
			return null;
		}
		public boolean hasChildren(Object element) {
			return false;
		}
	}
	class ViewLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			if (element instanceof View) {
				View view = (View) element;
				return view.getName();
			}
			return super.getText(element);
		}
	}

}