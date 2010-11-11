package com.sap.ide.cts.editor.folding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.jdt.internal.ui.preferences.OverlayPreferenceStore;
import org.eclipse.jdt.internal.ui.preferences.OverlayPreferenceStore.OverlayKey;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jdt.ui.text.folding.IJavaFoldingPreferenceBlock;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.sap.ide.cts.editor.CtsActivator;


@SuppressWarnings("restriction")
public class CtsFoldingPreferenceBlock implements IJavaFoldingPreferenceBlock {

	private IPreferenceStore fStore;
	private OverlayPreferenceStore fOverlayStore;
	private OverlayKey[] fKeys;
	private Map fCheckBoxes= new HashMap();
	
	public CtsFoldingPreferenceBlock() {
		fStore= CtsActivator.getDefault().getPreferenceStore();
		fKeys= createKeys();
		fOverlayStore= new OverlayPreferenceStore(fStore, fKeys);
	}
	private OverlayKey[] createKeys() {
		ArrayList<OverlayKey> overlayKeys= new ArrayList<OverlayKey>();
		overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.EDITOR_FOLDING_INNERTYPES));
		overlayKeys.add(new OverlayPreferenceStore.OverlayKey(OverlayPreferenceStore.BOOLEAN, PreferenceConstants.EDITOR_FOLDING_METHODS));
		return (OverlayKey[]) overlayKeys.toArray(new OverlayKey[overlayKeys.size()]);
	}
	@Override
	public Control createControl(Composite parent) {
		fOverlayStore.load();
		fOverlayStore.start();
		
		Composite inner= new Composite(parent, SWT.NONE);
		GridLayout layout= new GridLayout(1, true);
		layout.verticalSpacing= 3;
		layout.marginWidth= 0;
		inner.setLayout(layout);
		return inner;
	}

	private void initializeFields() {
		Iterator<?> it= fCheckBoxes.keySet().iterator();
		while (it.hasNext()) {
			Button b= (Button) it.next();
			String key= (String) fCheckBoxes.get(b);
			b.setSelection(fOverlayStore.getBoolean(key));
		}
	}
	@Override
	public void dispose() {
		fOverlayStore.stop();

	}
	@Override
	public void initialize() {
		initializeFields();

	}
	@Override
	public void performDefaults() {
		fOverlayStore.loadDefaults();
		initializeFields();
	}
	@Override
	public void performOk() {
		fOverlayStore.propagate();

	}

}
