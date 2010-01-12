package de.hpi.sam.bp2009.benchframework.testrunWizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IWorkbench;

import de.hpi.sam.bp2009.benchframework.BenchMarker;
import de.hpi.sam.bp2009.benchframework.Generator;
import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultProcessor;

public class StartPage extends WizardPage implements Listener
{
	
	IWorkbench workbench;
	IStructuredSelection selection;

	ArrayList<Generator> selectedGenerators = new ArrayList<Generator>();
	ArrayList<Operator> selectedOperators = new ArrayList<Operator>();
	ArrayList<BenchMarker> selectedBenchMarkers = new ArrayList<BenchMarker>();
	ArrayList<ResultProcessor> selectedResultProcessors = new ArrayList<ResultProcessor>();
	
	ArrayList<Button> generatorButtons = new ArrayList<Button>();
	ArrayList<Button> operatorButtons = new ArrayList<Button>();
	ArrayList<Button> benchmarkerButtons = new ArrayList<Button>();
	ArrayList<Button> resultProcessorButtons = new ArrayList<Button>();
	
	
	public StartPage(	IWorkbench workbench,
						IStructuredSelection selection) {
		super("Page1");
		setTitle("Testrun Wizard");
		setDescription("Pick the components you want to use.");
		this.workbench = workbench;
		this.selection = selection;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(	Composite parent,
								List<Generator> generators,
								List<Operator> operators,
								List<BenchMarker> benchMarkers,
								List<ResultProcessor> resultProcessors) {

		Composite wrapper = new Composite(parent, SWT.NULL);
		GridLayout grid = new GridLayout();
		grid.numColumns = 2;
		wrapper.setLayout(grid);
		
		new Label(wrapper, SWT.NONE).setText("available Generators:");
		
		Composite generatorComposite = new Composite(wrapper, SWT.NONE);
		generatorComposite.setLayout(grid);
		for (Generator entry:generators){
			new Label(generatorComposite, SWT.NONE).setText(entry.getClass().getName());
			Button b = new Button(generatorComposite, SWT.CHECK);
			b.setText(entry.getClass().getName());	
			b.addListener(SWT.Selection, this);
			generatorButtons.add(b);
		}
		
		new Label(wrapper, SWT.NONE).setText("available Operators:");
		
		Composite operatorComposite = new Composite(wrapper, SWT.NONE);
		operatorComposite.setLayout(grid);
		for (Operator entry:operators){
			new Label(operatorComposite, SWT.NONE).setText(entry.getClass().getName());
			Button b = new Button(operatorComposite, SWT.CHECK);
			b.setText(entry.getClass().getName());
			b.addListener(SWT.Selection, this);
			operatorButtons.add(b);
		}
		
		new Label(wrapper, SWT.NONE).setText("available Benchmarkers:");
		
		Composite benchmarkerComposite = new Composite(wrapper, SWT.NONE);
		benchmarkerComposite.setLayout(grid);
		for (BenchMarker entry:benchMarkers){
			new Label(benchmarkerComposite, SWT.NONE).setText(entry.getClass().getName());
			Button b = new Button(benchmarkerComposite, SWT.CHECK);
			b.setText(entry.getClass().getName());
			b.addListener(SWT.Selection, this);
			benchmarkerButtons.add(b);
		}
		
		new Label(wrapper, SWT.NONE).setText("available Result Processors:");
		
		Composite resultComposite = new Composite(wrapper, SWT.NONE);
		resultComposite.setLayout(grid);
		for (ResultProcessor entry:resultProcessors){
			new Label(resultComposite, SWT.NONE).setText(entry.getClass().getName());
			Button b = new Button(resultComposite, SWT.CHECK);
			b.setText(entry.getClass().getName());
			b.addListener(SWT.Selection, this);
			resultProcessorButtons.add(b);
		}

		setControl(wrapper);		
	}
	
	/**
	 * @see Listener#handleEvent(Event)
	 */
	public void handleEvent(Event event) {
		//TODO brauchen wir die?

//	    Status status = new Status(IStatus.OK, "not_used", 0, "", null);
//
//	    if ((event.widget == fromText) || (event.widget == toText)) {
//	        if (fromText.getText().equals(toText.getText()) && !"".equals(fromText.getText()))
//	            status = new Status(IStatus.ERROR, "not_used", 0, 
//	                "Departure and destination cannot be the same", null);        
//	        destinationStatus = status;
//	    }
//
//	    if ((event.widget == returnDate) || (event.widget == returnMonth)
//	    	|| (event.widget == returnYear) || (event.widget == travelDate)
//	    	|| (event.widget == travelMonth) || (event.widget == travelYear)) {
//			if	(isReturnDateSet() && !validDates()) 
//	            status = new Status(IStatus.ERROR, "not_used", 0, 
//	                "Return date cannot be before the travel date", null);	                
//	        timeStatus = status;
//			
//	    }
//	    applyToStatusLine(findMostSevere());
//		getWizard().getContainer().updateButtons();
	}
	
	public IWizardPage getNextPage()
	{
		//TODO model mit Liste der nächsten Optionsseiten befüllen und einfach davon die nächste zurückgeben
		saveDataToModel();
		
//		if (planeButton.getSelection()) {
//			PlanePage page = ((HolidayWizard)getWizard()).planePage;
//			page.onEnterPage();
//			return page;
//		}
//
//		if (carButton.getSelection()) { 
//			CarPage page = ((HolidayWizard)getWizard()).carPage;
//			return page;
//		}
		return null;
	}

	/**
	 * @see IWizardPage#canFlipToNextPage()
	 */
	public boolean canFlipToNextPage()
	{
		if (selectedBenchMarkers.size()>0 && selectedGenerators.size()>0 && selectedOperators.size()>0 && selectedResultProcessors.size()>0)
			return true;
		return false;
	}

	private void saveDataToModel()
	{
		//TODO model mit Liste der nächsten Optionsseiten befüllen und einfach davon die nächste zurückgeben
	}

	@Override
	public void createControl(Composite parent) {
		List<Generator> generators = new ArrayList<Generator>();
		List<Operator> operators = new ArrayList<Operator>();
		List<BenchMarker> benchMarkers = new ArrayList<BenchMarker>();
		List<ResultProcessor> resultProcessors = new ArrayList<ResultProcessor>();
		createControl(parent, generators, operators, benchMarkers, resultProcessors);
	}

}

