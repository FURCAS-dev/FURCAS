package com.sap.mi.tools.mmdeploy.internal.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;

/**
 * Copies textual information about the selected metamodels into the clipboard
 * 
 * @author d031150
 */
public final class CopyMmInfoAction extends AbstractHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
    	Collection<MmDeploymentInfo> metamodels = getMetamodels(event);
    	if (metamodels.isEmpty())
    		return null;
    	
		String text = MmLabelProvider.toMmString(metamodels);
    	Display display = HandlerUtil.getActiveShellChecked(event).getDisplay();
		Clipboard clipboard = new Clipboard(display);
		try {
			clipboard.setContents(
					new Object[] { text }, 
					new Transfer[] { TextTransfer.getInstance() });
		}
		finally {
			clipboard.dispose();
		}
		
		return null;
    }
	
	private Collection<MmDeploymentInfo> getMetamodels(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection sel = (IStructuredSelection) HandlerUtil.getCurrentSelection(event);
		if (sel == null || sel.isEmpty())
			return Collections.emptyList();
		
		Object[] objects = sel.toArray();
		List<MmDeploymentInfo> metamodels = new ArrayList<MmDeploymentInfo>(objects.length);
		IAdapterManager adapterManager = Platform.getAdapterManager();
		for (Object object : objects) {
			MmDeploymentInfo info = (MmDeploymentInfo) adapterManager.getAdapter(object, MmDeploymentInfo.class);
			if (info != null) {
				metamodels.add(info);
			}
			MmDeploymentInfo[] infos = (MmDeploymentInfo[]) adapterManager.getAdapter(object,
					MmDeploymentInfo[].class);
			if (infos != null) {
				metamodels.addAll(Arrays.asList(infos));
			}
		}
		return metamodels;
	}

}
