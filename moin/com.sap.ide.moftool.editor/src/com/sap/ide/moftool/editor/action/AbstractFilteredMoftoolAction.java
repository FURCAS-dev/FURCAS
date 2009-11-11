package com.sap.ide.moftool.editor.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.sap.ide.moftool.editor.core.service.ModelElementService;
import com.sap.mi.fwk.ModelAdapter;

public abstract class AbstractFilteredMoftoolAction<T extends RefBaseObject> extends Action {
	
	private IStructuredSelection mSelection;

	public AbstractFilteredMoftoolAction(IStructuredSelection selection, String text, ImageDescriptor imageDescriptor) {
		super(text, imageDescriptor);
		if (selection != null) {
			mSelection = selection;
			setEnabled(enabledForSelection(selection));
		}
	}
	/**
	 * Returned list containing only ( adaptable) development Objects, list may be
	 * empty - in case the original selection is mixed.
	 * 
	 * @param structuredSelection
	 * @return
	 */
	protected static List<RefObject> filterSelection(
			IStructuredSelection structuredSelection) {
		List<RefObject> res = new ArrayList<RefObject>(structuredSelection
				.size());
		Iterator<?> it = structuredSelection.iterator();
		while (it.hasNext()) {
			Object obj = (Object) it.next();
			RefObject devobj = ModelAdapter.getInstance().adaptObject(obj,
					RefObject.class);
			if (devobj != null) {
				res.add(devobj);
			}
		}
		return res;
	}
	
	public boolean visibleForSelection(
			IStructuredSelection structuredSelection) {
		List<RefObject> ldevobjs = filterSelection(structuredSelection);
		if (ldevobjs.size() == 0) {
			return false;
		}
		for (RefObject devobj : ldevobjs) {
			if (!visibleForContext(devobj)) {
				return false;
			}
		}
		return true;
	}

	protected abstract boolean visibleForContext(RefObject devobj) ;

	public boolean enabledForSelection(
			IStructuredSelection structuredSelection) {
		List<RefObject> ldevobjs = filterSelection(structuredSelection);
		if (ldevobjs.size() == 0) {
			return false;
		}
		for (RefObject devobj : ldevobjs) {
			if (!enabledForContext(devobj)) {
				return false;
			}
		}
		return true;
	}
	
//	public static boolean visibleForContext(Object context) {
//		return (context instanceof T);
//	}

	public boolean enabledForContext(RefObject context) {
		if (ModelElementService.isForeignObject(context)) {
			return false;
		}
		return true;
	}

	public final void setContext(IStructuredSelection sel) {
		this.mSelection = sel;
	}
	
	/**
	 * 
	 * @param structuredSelection
	 */
	public void runWithSelection(IStructuredSelection structuredSelection) {
		List<RefObject> ldevobjs = filterSelection(structuredSelection);
		for (RefObject devobj : ldevobjs) {
			runSingleWithContext((T) devobj);
		}
	}
	protected abstract void runSingleWithContext(T devobj);
	
	@Override
	public final void run() {
		runWithSelection(this.mSelection);
	}
	
}
