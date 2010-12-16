package com.sap.ide.refactoring.op.move;

import java.util.Collection;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.sap.ide.refactoring.model.move.MovableElementTarget;
import com.sap.ide.treeprovider.ModelElementImageFacade;


public class MoveInputPage extends UserInputWizardPage {

    /**
     * Table label provider for the target selection table.
     */
    public static class TargetLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(final Object element, final int column) {
	    if (column == 0 && element instanceof MovableElementTarget) {
		return ModelElementImageFacade.getImage(((MovableElementTarget) element).getWrappedModelElement());
	    } else {
		return null;
	    }
	}

	@Override
	public String getColumnText(final Object element, final int column) {
	    final MovableElementTarget target = (MovableElementTarget) element;
	    switch (column) {
	    case 0:
		return target.getName();
	    case 1:
		return target.getType();
	    case 2:
		return target.getRole();
	    default:
		return null;
	    }
	}
    }

    public MoveInputPage(String name) {
	super(name);
    }

    @Override
    protected MoveRefactoring getRefactoring() {
	return (MoveRefactoring) super.getRefactoring();
    }

    @Override
    public void createControl(final Composite parent) {
	final Composite control = new Composite(parent, SWT.NONE);
	setControl(control);

	final GridLayout layout = new GridLayout();
	layout.numColumns = 2;
	control.setLayout(layout);

	Label label = new Label(control, SWT.SINGLE);
	label.setText("Select new composite parent:");

	GridData data = new GridData();
	data.horizontalSpan = 2;
	label.setLayoutData(data);

	final Composite composite = new Composite(control, SWT.NULL);

	final Table table = new Table(composite, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);
	table.setHeaderVisible(true);
	table.setLinesVisible(false);

	TableColumn columnName = new TableColumn(table, SWT.NONE);
	columnName.setText("Name");
	columnName.setResizable(true);

	TableColumn columnType = new TableColumn(table, SWT.NONE);
	columnType.setText("Type");
	columnType.setResizable(true);

	TableColumn columnRole = new TableColumn(table, SWT.NONE);
	columnRole.setText("Role");
	columnRole.setResizable(true);

	TableColumnLayout tableColumnLayout = new TableColumnLayout();
	composite.setLayout(tableColumnLayout);
	tableColumnLayout.setColumnData(columnName, new ColumnWeightData(40, true));
	tableColumnLayout.setColumnData(columnType, new ColumnWeightData(40, true));
	tableColumnLayout.setColumnData(columnRole, new ColumnWeightData(40, true));

	final TableViewer viewer = new TableViewer(table);
	viewer.setContentProvider(new ArrayContentProvider());
	viewer.setLabelProvider(new TargetLabelProvider());

	final Collection<MovableElementTarget> targets = getRefactoring().getElementToMove().getPotentialMovingTargets();
	viewer.setInput(targets.toArray());
	viewer.setSelection(new StructuredSelection(new Object[] { targets.iterator().next() }));

	viewer.addSelectionChangedListener(new ISelectionChangedListener() {

	    @Override
	    public final void selectionChanged(final SelectionChangedEvent event) {
		final Object element = ((IStructuredSelection) event.getSelection()).getFirstElement();
		if (element instanceof MovableElementTarget) {
		    final MovableElementTarget target = (MovableElementTarget) element;
		    handleTargetChanged(target);
		}
	    }
	});

	data = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
	data.heightHint = getTableHeightHint(table, 7);
	data.widthHint = convertWidthInCharsToPixels(30);
	data.horizontalSpan = 2;
	composite.setLayoutData(data);
	
	table.setFocus();
    }

    private void handleTargetChanged(MovableElementTarget target) {
	getRefactoring().setTarget(target);
    }

    private int getTableHeightHint(Table table, int rows) {
	if (table.getFont().equals(JFaceResources.getDefaultFont())) {
	    table.setFont(JFaceResources.getDialogFont());
	}
	int result = table.getItemHeight() * rows + table.getHeaderHeight();
	if (table.getLinesVisible()) {
	    result += table.getGridLineWidth() * (rows - 1);
	}
	return result;
    }
}