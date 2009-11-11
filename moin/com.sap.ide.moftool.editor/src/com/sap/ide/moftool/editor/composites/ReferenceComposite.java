package com.sap.ide.moftool.editor.composites;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.sap.ide.moftool.editor.core.commands.MofService;
import com.sap.ide.moftool.editor.gen.composites.ReferenceCompositeBase;
import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.databinding.MoinDataBindingContext;
import com.sap.mi.fwk.ui.databinding.MoinObservables;
import com.sap.mi.fwk.ui.databinding.MoinUpdateValueStrategy;

public class ReferenceComposite extends ReferenceCompositeBase {

	public class MultiplicityConverter implements IConverter {

		private final RefObject refObject;

		public MultiplicityConverter(RefObject refObject) {
			this.refObject = refObject;
		}

		public Object convert(Object fromObject) {
			MultiplicityType oldType = (MultiplicityType) fromObject;
			ModelPackage modelPackage = (ModelPackage) ModelAdapter.getInstance().getConnection(refObject).getPackage(null, "Model"); //$NON-NLS-1$
			return MofService.createMultiplicityType(modelPackage, oldType.getLower(), oldType.getUpper(), oldType.isOrdered(), oldType
					.isUnique());
		}

		public Object getFromType() {
			return MultiplicityType.class;
		}

		public Object getToType() {
			return MultiplicityType.class;
		}

	}

	public ReferenceComposite(Section section, FormToolkit formToolkit, String title, String description) {
		super(section, formToolkit, title, description);
	}

	@Override
	protected void bindAssociationEnd(MoinDataBindingContext dbc, Reference refObject, Control associationEnd) {
		IObservableValue refType = MoinObservables.observeValue(refObject, Reference.DESCRIPTORS.TYPE());
		IObservableValue assocEndType = MoinObservables.observeValue(refObject.getReferencedEnd(), AssociationEnd.DESCRIPTORS.TYPE());
		dbc.bindValue(refType, assocEndType, null, null);

		IObservableValue refMultiplicity = MoinObservables.observeValue(refObject, Reference.DESCRIPTORS.MULTIPLICITY());
		IObservableValue assocEndMultiplicity = MoinObservables.observeValue(refObject.getReferencedEnd(), AssociationEnd.DESCRIPTORS
				.MULTIPLICITY());
		dbc.bindValue(refMultiplicity, assocEndMultiplicity, new MoinUpdateValueStrategy()
				.setConverter(new MultiplicityConverter(refObject)), new MoinUpdateValueStrategy().setConverter(new MultiplicityConverter(
				refObject)));

		IObservableValue refIsChangeable = MoinObservables.observeValue(refObject, Reference.DESCRIPTORS.IS_CHANGEABLE());
		IObservableValue assocEndIsChangeable = MoinObservables.observeValue(refObject.getReferencedEnd(), AssociationEnd.DESCRIPTORS
				.IS_CHANGEABLE());
		dbc.bindValue(refIsChangeable, assocEndIsChangeable, null, null);
	}

	@Override
	protected Control createAssociationEnd(Composite rootComposite, FormToolkit formToolkit) {
		return null;
	}

}
