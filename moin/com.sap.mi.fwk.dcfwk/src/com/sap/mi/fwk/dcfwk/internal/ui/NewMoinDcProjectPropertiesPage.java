package com.sap.mi.fwk.dcfwk.internal.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.ui.api.typefw.BasicDcTypeDelegate;
import com.sap.mi.fwk.dcfwk.IMoinDcType;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.internal.messages.DcFwkMessages;

/**
 * Wizard page containing additional properties for Moin DC projects
 * 
 * @author d031150
 */
public class NewMoinDcProjectPropertiesPage extends WizardPage {

	// Attached to controls that are referenced by UI test
	private static final String WIDGET_DATA_NAME = "name"; //$NON-NLS-1$

	private static final String CONTROL_NAME_CREATE_PP = "CreateDefaultPublicPart.checkbox_"; //$NON-NLS-1$

	private static final Map<Purpose, String> sButtonTextForPurpose = new HashMap<Purpose, String>(Purpose.VALUES
			.size());
	private static final Map<Purpose, String> sButtonTooltipForPurpose = new HashMap<Purpose, String>(
			sButtonTextForPurpose.size());

	static {
		sButtonTextForPurpose.put(Purpose.COMPILATION_LITERAL, DcFwkMessages.ProjPropPage_ButtonCreatePpComp_text);
		sButtonTextForPurpose.put(Purpose.ASSEMBLY_LITERAL, DcFwkMessages.ProjPropPage_ButtonCreatePpAssmbl_text);
		sButtonTextForPurpose.put(Purpose.INFRASTRUCTURE_LITERAL, DcFwkMessages.ProjPropPage_ButtonCreatePpInfra_text);
		sButtonTooltipForPurpose
				.put(Purpose.COMPILATION_LITERAL, DcFwkMessages.ProjPropPage_ButtonCreatePpComp_tooltip);
		sButtonTooltipForPurpose.put(Purpose.ASSEMBLY_LITERAL, DcFwkMessages.ProjPropPage_ButtonCreatePpAssmbl_tooltip);
		sButtonTooltipForPurpose.put(Purpose.INFRASTRUCTURE_LITERAL,
				DcFwkMessages.ProjPropPage_ButtonCreatePpInfra_text);
	}

	private final MoinDcOptions mOptions;
	private final Map<Button, Purpose> mButtonsToPurpose = new HashMap<Button, Purpose>(sButtonTextForPurpose.size());

	private final IMoinDcType mDcType;

	/**
	 * Creates a new project creation wizard page.
	 * 
	 * @param dcType
	 * 
	 * @param pageName
	 *            the name of this page
	 */
	public NewMoinDcProjectPropertiesPage(IMoinDcType dcType, MoinDcOptions options) {
		super(NewMoinDcProjectPropertiesPage.class.getName());
		mDcType = dcType;
		setTitle(DcFwkMessages.ProjPropPage_Title);
		setDescription(DcFwkMessages.ProjPropPage_Desc);

		mOptions = options;
	}

	/**
	 * (non-Javadoc) Method declared on IDialogPage.
	 */
	@SuppressWarnings("unchecked")
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);
		Font font = parent.getFont();

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setControl(composite);

		composite.setFont(font);
		GridLayout layout = new GridLayout(1, true);
		layout.marginTop = convertHeightInCharsToPixels(1);
		layout.marginLeft = convertWidthInCharsToPixels(2);
		composite.setLayout(layout);

		SelectionListener listener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				Button b = ((Button) e.widget);
				boolean create = b.getSelection();
				Purpose purpose = mButtonsToPurpose.get(b);
				mOptions.setCreatePublicParts(purpose, create);
				setPageComplete(validatePage());
			}
		};

		List<Purpose> purposes = Purpose.VALUES;
		for (Purpose purpose : purposes) {
			if (mDcType instanceof BasicDcTypeDelegate
					&& !((BasicDcTypeDelegate) mDcType).supportsPublicPartPurpose(purpose))
				continue;
			// bug #0120031469 0002272858 2008
			// the enumeration 'Purpose' does not contain a fixed set of values
			// as we only support the purposes 'COMPILATION', 'ASSEMBLY' and
			// 'INFRASTRUCTURE'
			// we have to skip the others
			if (sButtonTextForPurpose.containsKey(purpose)) {
				Button button = new Button(composite, SWT.CHECK);
				button.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
				button.setText(sButtonTextForPurpose.get(purpose));
				button.setToolTipText(sButtonTooltipForPurpose.get(purpose));
				button.setEnabled(mOptions.isPublicPartCreationChangeable(purpose));
				button.setSelection(mOptions.getPublicPartCreationDefault(purpose));
				button.setFont(font);
				button.setData(WIDGET_DATA_NAME, CONTROL_NAME_CREATE_PP + purpose.getLiteral());
				button.addSelectionListener(listener);
				mButtonsToPurpose.put(button, purpose);
			}
		}
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	protected boolean validatePage() {
		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	/**
	 * @return the options with the user decision for whether to create public
	 *         parts
	 */
	public MoinDcOptions getOptions() {
		return mOptions;
	}

}
