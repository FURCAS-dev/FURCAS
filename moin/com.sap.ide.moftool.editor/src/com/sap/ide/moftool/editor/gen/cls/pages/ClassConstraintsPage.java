package com.sap.ide.moftool.editor.gen.cls.pages;

import com.sap.ide.moftool.editor.fwk.TableLayoutedModelFormMasterDetailPage;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;

import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IDetailsPageProvider;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.IFormPage;

import com.sap.ide.moftool.editor.fwk.ModelDetailsPageProvider;
import com.sap.ide.moftool.editor.fwk.ModelMasterDetailBlock;
import com.sap.ide.moftool.editor.fwk.TreeSection;
import org.eclipse.ui.IWorkbenchPart;

public class ClassConstraintsPage extends TableLayoutedModelFormMasterDetailPage {

	private static final String ID = "cls.pages.classConstraints"; //$NON-NLS-1$

	public ClassConstraintsPage(FormEditor editor, String title) {
		super(editor, ID, title);
	}

	@Override
	protected MasterDetailPart createMasterBlockInternal(Composite body, IManagedForm managedForm) {
		MasterDetailPart part = new MasterDetailPart(this);
		part.createContent(managedForm);
		return part;
	}

	private class MasterDetailPart extends ModelMasterDetailBlock {

		protected MasterDetailPart(IFormPage page) {
			super(page);
		}

		protected SectionPart createMasterPartInternal(Composite parent, IManagedForm managedForm) {
			return new ClassConstraintsPage.TreeSectionImpl(getPage(), parent, managedForm,
					Messages.ClassConstraintsPage_Constraints);
		}

		@Override
		protected IDetailsPageProvider createDetailsProvider() {
			return new DetailsPageProvider(getManagedForm());
		}

	}

	/**
	 * Details page handling ContextNodes. The details page will be lazily
	 * instantiated for ContextNode selections.
	 */
	private class DetailsPageProvider extends ModelDetailsPageProvider {

		public DetailsPageProvider(IManagedForm managedForm) {
			super(managedForm);
		}

		public IDetailsPage getPage(Object key) {

			if (com.sap.tc.moin.repository.mmi.model.Constraint.class.equals(key)) {
				return new com.sap.ide.moftool.editor.gen.sections.ConstraintSection.DetailsPage(getManagedForm());
			}

			return null;
		}

		public Object getPageKeyInternal(RefObject object) {

			if (object instanceof com.sap.tc.moin.repository.mmi.model.Constraint) {
				return com.sap.tc.moin.repository.mmi.model.Constraint.class;
			}

			return null;
		}
	}

	private class TreeSectionImpl extends TreeSection {
		public TreeSectionImpl(IWorkbenchPart part, Composite parent, IManagedForm managedForm, String title) {
			super(part, parent, managedForm, title);
		}

		protected IBaseLabelProvider createLabelProvider() {
			return new com.sap.ide.moftool.editor.tree.provider.TreeLabelProviderTreeClassConstraints();
		}

		protected ITreeContentProvider createContentProvider() {
			return new com.sap.ide.moftool.editor.tree.provider.TreeProviderTreeClassConstraints();
		}

		protected org.eclipse.ui.actions.ActionGroup getActionProvider(IWorkbenchPart part) {
			com.sap.ide.moftool.editor.action.prov.ActProvAPTClassConstraints provider = new com.sap.ide.moftool.editor.action.prov.ActProvAPTClassConstraints();
			provider.init(part);
			return provider;
		}

	}

}
