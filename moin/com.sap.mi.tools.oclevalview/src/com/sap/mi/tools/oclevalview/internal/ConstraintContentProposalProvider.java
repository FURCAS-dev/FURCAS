package com.sap.mi.tools.oclevalview.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.StructuralFeature;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.swt.widgets.Control;

public class ConstraintContentProposalProvider implements
		IContentProposalProvider {
	public static final char DELIMITER = '.';

	private Control reference;

	public ConstraintContentProposalProvider(Control reference) {
		super();
		this.reference = reference;
	}

	public IContentProposal[] getProposals(String contents, int position) {
		boolean hasDelimiter;
		try {
			hasDelimiter = (contents.charAt(position - 1) == DELIMITER);
		} catch (Exception e) {
			hasDelimiter = false;
		}

		if (!hasDelimiter)
			return new IContentProposal[0];

		List<IContentProposal> proposals;
		try {
			RefClass refClass = (RefClass) reference.getData();
			Iterator<ModelElement> it = ((MofClass) refClass.refMetaObject()).getContents()
					.iterator();
			StructuralFeature feature;
			proposals = new ArrayList<IContentProposal>();
			while (it.hasNext()) {
				feature = (StructuralFeature) it.next();
				proposals.add(new FeatureProposal(feature.getName()));
			}
		} catch (Exception e) {
			proposals = new ArrayList<IContentProposal>(0);
		}

		return proposals.toArray(new IContentProposal[proposals.size()]);
	}

	class FeatureProposal implements IContentProposal {
		String feature;

		FeatureProposal(String feature) {
			this.feature = feature;
		}

		public String getContent() {
			return this.feature;
		}

		public int getCursorPosition() {
			return 0;
		}

		public String getDescription() {
			return "MOF Feature " + this.feature; //$NON-NLS-1$
		}

		public String getLabel() {
			return this.feature;
		}

	}
}
