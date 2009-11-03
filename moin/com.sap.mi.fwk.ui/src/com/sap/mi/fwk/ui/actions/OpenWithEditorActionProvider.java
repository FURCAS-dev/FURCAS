package com.sap.mi.fwk.ui.actions;

import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonMenuConstants;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.ModelAdapterUI;
import com.sap.mi.fwk.ui.editor.ModelEditorManager;
import com.sap.mi.fwk.ui.internal.messages.MiFwkUiMessages;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

public class OpenWithEditorActionProvider extends CommonActionProvider {

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_EDITORS);

	@Override
	public void fillContextMenu(IMenuManager menu) {
		super.fillContextMenu(menu);

		if (PlatformUI.getWorkbench().isClosing() || PlatformUI.getWorkbench().getActiveWorkbenchWindow() == null) {
			return;
		}

		ISelection selection = getContext().getSelection();
		final RefObject ro = ModelAdapterUI.getInstance().getRefObject(selection);

		if (ro != null) {
			final IMenuManager submenu = new MenuManager(MiFwkUiMessages.OpenWithEditorActionProvider_openwith);
			menu.appendToGroup(ICommonMenuConstants.GROUP_OPEN_WITH, submenu);
			
			final Collection<IEditorDescriptor> editorDescriptors = ModelEditorManager.getInstance().getEditorDescriptors(ro);
			for (final IEditorDescriptor editorDescriptor : editorDescriptors) {

				// unsure whether inline class is a good idea here
				// use it to reduce class count
				final IContributionItem aci = new ActionContributionItem(new Action() {
					@Override
					public String getText() {
						return editorDescriptor.getLabel();
					}

					@Override
					public ImageDescriptor getImageDescriptor() {
						return editorDescriptor.getImageDescriptor();
					}

					@Override
					public void run() {
						try {
							if (ro.is___Alive()) {
								ModelEditorManager.getInstance().openEditor(ro, editorDescriptor.getId());
							}
						} catch (final PartInitException e) {
							OpenWithEditorActionProvider.sTracer.error("Editor could not be started", e); //$NON-NLS-1$
						}
					}

					public boolean isEnabled() {
						return ro.is___Alive();
					}
				});
				submenu.add(aci);
			}
		}
	}
}