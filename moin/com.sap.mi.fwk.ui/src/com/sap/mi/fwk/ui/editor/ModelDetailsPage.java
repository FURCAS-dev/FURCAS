package com.sap.mi.fwk.ui.editor;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;

/**
 * <p>Title:       ModelDetailsPage</p>
 * <p>Description: Convenience details page class that wrapps a {@link SectionPart} as a {@link IDetailsPage}.
 * A details page is used within a {@link MasterDetailsBlock} in order to display the details
 * of the selection of the master part. Creation of a details page is done on first access. 
 * At this point in time the <code>createContents</code> is called by the framework in order to 
 * create the corresponding controls.</p>
 * <p>Copyright:   Copyright (c) 2007</p>
 * <p>Company:     SAP AG</p>
 * @author        d022960
 * @since         NYC
 */
public abstract class ModelDetailsPage implements IDetailsPage {

	private SectionPart mSectionPart = null;
	private IManagedForm mManagedForm = null;
	
	/**
	 * Constructor
	 * @param managedForm the managed form for this page
	 */
	public ModelDetailsPage(IManagedForm managedForm) {
		mManagedForm = managedForm;
	}
	
	/**
	 * This method has to be implemented by clients in order to create the corresponding {@link SectionPart} instance.
	 * @param parent the parent composite 
	 * @param managedForm the managed form that has been passed to the constructor
	 * @return the section part which is wrapped by this {@link IDetailsPage} implementation 
	 */
	protected abstract SectionPart createDetailsPart(Composite parent, IManagedForm managedForm);

	/**
	 * Returns the {@link SectionPart} instance that is wrapped by this instance. The section part has to be
	 * created with a call of <code>createContents</code> first, otherwise a IllegalStateException is thrown.
	 * @return the {@link SectionPart} instance that is wrapped by this instance
	 */
	protected SectionPart getSectionPart() {
		if (mSectionPart == null) {
			throw new IllegalStateException("MasterDetailsPageAdapter not fully initialized.\nCall createContents first in order to create the corresponding SectionPart instance"); //$NON-NLS-1$
		}
		return mSectionPart;
	}
	
	protected IManagedForm getManagedForm() {
		return mManagedForm;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IDetailsPage#createContents(Composite)
	 */
	public void createContents(Composite parent) {
		mSectionPart = createDetailsPart(parent, mManagedForm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#commit(boolean)
	 */
	public void commit(boolean onSave) {
		if (mSectionPart != null) {
			mSectionPart.commit(onSave);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#dispose()
	 */
	public void dispose() {
		if (mSectionPart != null) {
			mSectionPart.dispose();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#initialize(IManagedForm)
	 */
	public void initialize(IManagedForm form) {
		if (mSectionPart != null) {
			mSectionPart.initialize(form);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#isDirty()
	 */
	public boolean isDirty() {
		if (mSectionPart != null) {
			return mSectionPart.isDirty();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#isStale()
	 */
	public boolean isStale() {
		if (mSectionPart != null) {
			return mSectionPart.isStale();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#refresh()
	 */
	public void refresh() {
		if (mSectionPart != null) {
			mSectionPart.refresh();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#setFocus()
	 */
	public void setFocus() {
		if (mSectionPart != null) {
			mSectionPart.setFocus();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IFormPart#setFormInput()
	 */
	public boolean setFormInput(Object input) {
		if (mSectionPart != null) {
			return mSectionPart.setFormInput(input);
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.forms.IPartSelectionListener#selectionChanged(IFormPart, ISelection)
	 */
	public void selectionChanged(IFormPart part, ISelection selection) {
		if (mSectionPart != null) {
			mSectionPart.setFormInput(selection);
		}
	}
}
