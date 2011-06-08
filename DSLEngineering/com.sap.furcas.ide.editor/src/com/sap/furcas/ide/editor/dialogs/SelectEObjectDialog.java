package com.sap.furcas.ide.editor.dialogs;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import com.sap.furcas.ide.editor.DialogsImages;

/**
 * Dialog used to find and select an element of a desired type
 * within a composite.
 * 
 * @author Roman Andrej
 * @author Stephan Erb
 */
public class SelectEObjectDialog extends TitleAreaDialog {

    private TreeViewer viewer;
    private EObject selection;
    private EObject rootOfSelection;
    private Button OKbutton, CANCELbutton;

    private final Collection<Class<?>> filterList; 

    public SelectEObjectDialog(Shell parent, Object input, Collection<Class<?>> filterList, AdapterFactory adapterFactory) {
        super(parent);
        this.setShellStyle(SWT.RESIZE | SWT.MAX | SWT.CLOSE);
        this.filterList = filterList;
        
        create();
        
        viewer.setContentProvider(new FilteredContentProvider(adapterFactory, filterList));
        viewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
        viewer.setInput(input);
        viewer.expandAll();
        
        setTitle("Select Object");
        setMessage(getMessageWithTypeInformation());
        setTitleImage(DialogsImages.imageRegistry.get(DialogsImages.FURCAS_LOGO_SMALL));
    }
    
    private String getMessageWithTypeInformation() {
        if (filterList.isEmpty()) {
            return "Please select an object of any type.";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Please select an object of type ");
        for (Iterator<Class<?>> iterator = filterList.iterator(); iterator.hasNext();) {
            String name = iterator.next().getSimpleName();
            builder.append(name);
            if (iterator.hasNext()) {
               builder.append(", ");
            }
        }
        return builder.toString();
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Select Object");
        newShell.addShellListener(new ShellAdapter() {
            @Override
            public void shellClosed(ShellEvent e) {
                selection = null;
            }
        });
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayout(new FormLayout());
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        /** create a treeviewer */
        viewer = new TreeViewer(container, SWT.BORDER);
        viewer.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                ITreeSelection sel = (ITreeSelection) event.getSelection();
                if (sel.isEmpty()) {
                    OKbutton.setEnabled(false);
                    return;
                }
                // in the tree selected object
                selection = (EObject) sel.getFirstElement();
                // root element of tree (tree contains the selected object)
                rootOfSelection = (EObject) sel.getPaths()[0].getFirstSegment();

                if (selection != null && rootOfSelection != null && isInstanceOfProvidedService(selection)) {
                    OKbutton.setEnabled(true);
                } else {
                    OKbutton.setEnabled(false);
                }
            }

        });
        final Tree tree = viewer.getTree();
        final FormData fd_tree = new FormData();
        fd_tree.bottom = new FormAttachment(100, -61);
        fd_tree.top = new FormAttachment(0, 5);
        fd_tree.left = new FormAttachment(0, 5);
        fd_tree.right = new FormAttachment(100, -5);
        tree.setLayoutData(fd_tree);

        /** Separator */
        Label separator;
        separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
        final FormData fd_separator = new FormData();
        fd_separator.left = new FormAttachment(0, -2);
        fd_separator.right = new FormAttachment(100, 4);
        fd_separator.top = new FormAttachment(100, -7);
        fd_separator.bottom = new FormAttachment(100, 1);
        separator.setLayoutData(fd_separator);

        return area;
    }

    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.Dialog#createButtonsForButtonBar(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        CANCELbutton = createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        CANCELbutton.addSelectionListener(new SelectionAdapter() {

            /* (non-Javadoc)
             * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
             */
            @Override
            public void widgetSelected(SelectionEvent e) {
                selection = null;
            }
        });

        OKbutton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        OKbutton.setEnabled(false);

    }

    @Override
    protected void cancelPressed() {
        super.cancelPressed();
        this.selection = null;
    }

    /**
     * Return the initial size of the dialog
     */
    @Override
    protected Point getInitialSize() {
        return new Point(500, 400);
    }

    /**
     * True if the object is a candidate for return value
     */
    private boolean isInstanceOfProvidedService(Object object) {
        for (Class<?> c : filterList) {
            if (c.isAssignableFrom(object.getClass())) {
                return true;
            }
        }
        return false;
    }

    public EObject getResult() {
        return selection;
    }

    public EObject getRootOfResult() {
        return rootOfSelection;
    }

}