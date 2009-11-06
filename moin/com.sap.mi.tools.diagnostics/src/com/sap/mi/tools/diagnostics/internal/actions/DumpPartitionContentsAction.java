package com.sap.mi.tools.diagnostics.internal.actions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MenuAdapter;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import com.sap.mi.tools.diagnostics.internal.model.ConnectionNode;
import com.sap.mi.tools.diagnostics.internal.model.PartitionNode;

/**
 * Dumps a partition's contents either to the system editor, console, or clipboard
 * 
 * @author d031150
 */
public class DumpPartitionContentsAction 
	extends DiagnosticsViewerAction implements IMenuCreator {
    
	private Menu mMenu;

    DumpPartitionContentsAction(StructuredViewer viewer) {
        super("Dump Contents To", viewer); //$NON-NLS-1$
        setMenuCreator(this);
    }
    
    @Override
    protected boolean updateSelection(IStructuredSelection structuredSelection) {
        return super.updateSelection(structuredSelection);
    }

    public boolean isAvailable() {
        IStructuredSelection selection = getStructuredSelection();
        if (selection.size() == 1) {
            Object firstElement = selection.getFirstElement();
            if (firstElement instanceof PartitionNode) {
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

        ActionContributionItem item = new ActionContributionItem(new DumpToEditorAction());
        item.fill(menu, -1);
        item = new ActionContributionItem(new DumpToConsoleAction());
        item.fill(menu, -1);
        item = new ActionContributionItem(new DumpToClipboardAction());
        item.fill(menu, -1);
    }
    
    
    private abstract class DumpToAction extends Action {
    	DumpToAction(String text) {
            super(text);
        }
    	
    	protected abstract void dump(String priString, String contents) throws IOException;

        @Override
		public void run() {
            Object firstElement = getStructuredSelection().getFirstElement();
            if (firstElement instanceof PartitionNode) {
				PartitionNode node = (PartitionNode) firstElement;
				try {
					ConnectionNode connectionNode = node.getParent();
					String priString = node.getDelegate();
					String contents = connectionNode.showContentOfModelPartition(priString);
					dump(priString, contents);
				} catch (IOException e) {
	                ErrorDialog.openError(
	                        mViewer.getControl().getShell(), 
	                        "Error on Dump",  //$NON-NLS-1$
	                        e.getMessage(), 
	                        null);
				}
			}

        }
    }

    private final class DumpToConsoleAction extends DumpToAction {
        DumpToConsoleAction() {
            super("Console"); //$NON-NLS-1$
        }
		@Override
		protected void dump(String priString, String contents) throws IOException {
			System.out.println(contents); //$JL-SYS_OUT_ERR$
		}
    }

    private final class DumpToClipboardAction extends DumpToAction {
    	DumpToClipboardAction() {
            super("Clipboard"); //$NON-NLS-1$
        }
    	@Override
    	protected void dump(String priString, String contents) throws IOException {
    		Clipboard clipboard = new Clipboard(mViewer.getControl().getDisplay());
    		try {
    			clipboard.setContents(
    					new Object[] { contents }, 
    					new Transfer[] { TextTransfer.getInstance()});
    		}
    		finally {
    			clipboard.dispose();
    		}
    	}
    }

    private final class DumpToEditorAction extends DumpToAction {
    	DumpToEditorAction() {
            super("System Editor"); //$NON-NLS-1$
        }
    	@Override
    	protected void dump(String priString, String contents) throws IOException {
    		IPath priPath = new Path(priString);
    		if (priPath.getFileExtension() == null)
    			priPath = priPath.addFileExtension("xmi"); //$NON-NLS-1$

    		IPath path = writeToFile(contents, priPath);
			openSystemExternalEditor(path);

    	}
		private IPath writeToFile(String contents, IPath priPath) throws IOException {
			String fileName = priPath.lastSegment();
    		IPath dir = new Path(System.getProperty("java.io.tmpdir")).append("Moin/Dump"); //$NON-NLS-1$ //$NON-NLS-2$
			IPath path = dir.append(fileName);
			
			FileWriter writer = null;
			try {
				new File(dir.toOSString()).mkdirs();
				File file = new File(path.toOSString());
				file.createNewFile();
				writer = new FileWriter(file);
				writer.write(contents);
				writer.flush();
				return path;
			} 
			finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (IOException e) { //$JL-EXC$
					}
				}
			}
		}
    	
    	private boolean openSystemExternalEditor(final IPath location) {
    		final boolean result[] = { false };
    		BusyIndicator.showWhile(mViewer.getControl().getDisplay(), new Runnable() {
    			public void run() {
    				if (location != null) {
    					result[0] = Program.launch(location.toOSString());
    				}
    			}
    		});

    		return result[0];

    	}
    }

}
