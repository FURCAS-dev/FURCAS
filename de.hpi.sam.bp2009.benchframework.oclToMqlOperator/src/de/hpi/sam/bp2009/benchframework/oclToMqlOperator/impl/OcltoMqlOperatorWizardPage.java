package de.hpi.sam.bp2009.benchframework.oclToMqlOperator.impl;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.oclToMqlOperator.OclToMqlOptionObject;


public class OcltoMqlOperatorWizardPage extends WizardPage {
    private static final String WARNING     =       "Check if the Random Model Instantiator is in List before the OCLToMql Operator!";
    private static final String PAGETITEL   =       "OCLToMql Operator Configuration";
    private static final String PAGEDESC    =       "Set the options for the OCLToMql Operator.";
    private static final String LABELTEXT   =       "Enter the Expression in OCL";
    private static final String LABELTEXTOCL =      "evaluate in OCL, if doesn't check this button the query would evaluate in mql";


    ArrayList<Text> textareas= new ArrayList<Text>();
    private Composite composite;
    private Composite textareacomposite;
    //      private Text textarea;
    private ScrolledComposite scrolledComposite;
    private OclToMqlOptionObject option; 

    protected OcltoMqlOperatorWizardPage(String pageName) {
        super(pageName);
        setTitle(PAGETITEL);
        setDescription(PAGEDESC);

        setPageComplete(false);
    }


    protected OcltoMqlOperatorWizardPage(String pageName, OclToMqlOptionObject option) {
        this(pageName);
        this.option = option;
    }
    public void createControl(Composite parent) {
        //create the widgets for the page
        scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);
        composite = new Composite(scrolledComposite, SWT.NONE);
        scrolledComposite.setContent(composite);
        GridLayout layout = new GridLayout(2, false);
        composite.setLayout(layout);
        Label note = new Label (composite, SWT.NONE);
        note.setText(WARNING);
        Label empty = new Label (composite, SWT.NONE);
        empty.setText("");
        Button btn1 = new Button(composite, SWT.CHECK);
        btn1.setText(LABELTEXTOCL);
        
        btn1.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if(((Button)(e.getSource())).getSelection())
                    option.setUseEvaluator(true);
                else
                    option.setUseEvaluator(false);
            }                          

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                //Nothing to do
            }
        });
        

        Label label = new Label(composite, SWT.CENTER);
        label.setText(LABELTEXT);
        //
        //              textarea = new Text(composite, SWT.NONE);
        //              textarea.setSize(400, 10);

        Button addButton = new Button(composite, SWT.PUSH);
        addButton.setText("+");
        addButton.addSelectionListener(new SelectionAdapter() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                // add another textarea to the page
                //                              if (textarea.getText() != "") {
                Text txt = new Text(textareacomposite, SWT.UP);
                //                                      txt.setText(textarea.getText());
                //                                      textarea.setText("");           
                textareas.add(txt);
                textareacomposite.layout();
                composite.layout();
                scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
                //                              }
            }
        });

        textareacomposite = new Composite(composite, SWT.NONE);
        GridLayout textlayout = new GridLayout(1,false);
        textareacomposite.setLayout(textlayout);
        textareacomposite.setSize(400, 10);
        scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        setControl(scrolledComposite);
        setPageComplete(true);

    }

    @Override
    public boolean canFlipToNextPage() {
        return true;
    }

    @Override
    public IWizardPage getNextPage() {
        // TODO create an EList with all constraints and pass it to the option object
        EList<String> constraints = new BasicEList<String>();
        for (Text tb: textareas){
            String con=tb.getText();
            if(con!=null && con.length()>0)
                constraints.add(tb.getText());
        }
        if (option==null)
            return super.getNextPage();
        else{
            option.getConstraints().clear();
            option.getConstraints().addAll(constraints);}
        return super.getNextPage();
    }
}
