package com.sap.mi.tools.diagnostics.internal.actions;

import java.io.IOException;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.sap.mi.tools.diagnostics.internal.model.ConnectionNode;
import com.tssap.util.ui.dialog.ExtendedMessageDialog;

/**
 * Dumps a connection's creation stack trace either to console or clipboard
 * 
 * @author d031150
 */
public class DumpAllocationStackTraceAction 
	extends DiagnosticsViewerAction implements IMenuCreator {
    
	private Menu mMenu;

    DumpAllocationStackTraceAction(StructuredViewer viewer) {
        super("Dump Allocation Stack To", viewer); //$NON-NLS-1$
        setMenuCreator(this);
    }
    
    @Override
    protected boolean updateSelection(IStructuredSelection structuredSelection) {
        if (!super.updateSelection(structuredSelection))
        	return false;
        IStructuredSelection selection = getStructuredSelection();
        Object firstElement = selection.getFirstElement();
        if (firstElement instanceof ConnectionNode
        		&& ((ConnectionNode) firstElement).isAlive()) {
        	return true;
        }
        return false;
    }

    public boolean isAvailable() {
        IStructuredSelection selection = getStructuredSelection();
        if (selection.size() == 1) {
            Object firstElement = selection.getFirstElement();
            if (firstElement instanceof ConnectionNode) {
            	return true;
            }
        }
        return false;
    }

    public void dispose() {
        if (mMenu != null) {
            mMenu.dispose();
            mMenu = null;
        }
    }

    public Menu getMenu(Control parent) {
        if (mMenu == null) {
            mMenu = new Menu(parent);
            installMenuListener(mMenu);
        }
        return mMenu;
    }

    public Menu getMenu(Menu parent) {
        if (mMenu == null) {
            mMenu = new Menu(parent);
            installMenuListener(mMenu);
        }
        return mMenu;
    }

    private void installMenuListener(final Menu menu) {
        menu.addMenuListener(new MenuAdapter() {
            @Override
			public void menuShown(MenuEvent e) {
                fillMenu(menu);
            }
        });
    }

    private void fillMenu(Menu menu) {
        MenuItem[] items = menu.getItems();
        for (MenuItem item : items)
            item.dispose();

        ActionContributionItem item = new ActionContributionItem(new DumpToConsoleAction());
        item.fill(menu, -1);
        item = new ActionContributionItem(new DumpToClipboardAction());
        item.fill(menu, -1);
    }
    
    
    private abstract class DumpToAction extends Action {
    	DumpToAction(String text) {
            super(text);
        }
    	
    	protected abstract void dump(String stackTrace) throws IOException;

        @Override
		public void run() {
            Object firstElement = getStructuredSelection().getFirstElement();
            if (firstElement instanceof ConnectionNode) {
            	ConnectionNode connectionNode = (ConnectionNode) firstElement;
				try {
					String trace = connectionNode.showAllocationStackTrace();
					dump(trace);
				} catch (IOException e) {
	                ExtendedMessageDialog.showError(
	                        mViewer.getControl().getShell(), 
	                        "Error on Dump",  //$NON-NLS-1$
	                        e.getMessage(), 
	                        null, 
	                        new String[] {IDialogConstants.OK_LABEL}, 
	                        e);
				}
			}

        }
    }

    private final class DumpToConsoleAction extends DumpToAction {
        DumpToConsoleAction() {
            super("Console"); //$NON-NLS-1$
        }
		@Override
		protected void dump(String stackTrace) throws IOException {
			System.out.println(stackTrace); //$JL-SYS_OUT_ERR$
		}
    }

    private final class DumpToClipboardAction extends DumpToAction {
    	DumpToClipboardAction() {
            super("Clipboard"); //$NON-NLS-1$
        }
    	@Override
    	protected void dump(String stackTrace) throws IOException {
    		Clipboard clipboard = new Clipboard(mViewer.getControl().getDisplay());
    		try {
    			clipboard.setContents(
    					new Object[] { stackTrace }, 
    					new Transfer[] { TextTransfer.getInstance()});
    		}
    		finally {
    			clipboard.dispose();
    		}
    	}
    }

}
