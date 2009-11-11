package com.sap.ide.moftool.editor.gen.sections;

import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.sap.ide.moftool.editor.sections.ModelDataBoundSection;
import com.sap.ide.moftool.editor.fwk.AbstractMoftoolPropertySection;

public abstract class OperationsPropertySection {

	public static class OperationProperties extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Operation> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Operation> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.OperationComposite(
					section, formToolkit, Messages.OperationsSection_OperationProperties,
					Messages.OperationsSection_EditPropertiesOfTheOperation);
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

	public static class ReturnType extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Operation> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Operation> classDetailsComp = new com.sap.ide.moftool.editor.composites.OperationReturnParameterComposite(
					section, formToolkit, Messages.OperationsSection_ReturnType, ""); //$NON-NLS-1$ 
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

	public static class ExceptionsRaisedByTheOperation extends AbstractMoftoolPropertySection {

		protected ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Operation> createContentsInternal(FormToolkit formToolkit,
				Section section) {
			ModelDataBoundSection<com.sap.tc.moin.repository.mmi.model.Operation> classDetailsComp = new com.sap.ide.moftool.editor.gen.composites.OperationExceptionComposite(
					section, formToolkit, Messages.OperationsSection_ExceptionsRaisedByTheOperation, ""); //$NON-NLS-1$ 
			classDetailsComp.createClient();
			return classDetailsComp;
		}

	}

}
