/**
 * 
 */
package de.hpi.sam.bp2009.benchframework.simpleResultProcessor.impl;

import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOperator;

/**
 * @author Philipp
 * @author Tobias Hoppe
 *
 */
public class SimpleResultPage extends WizardPage {
    private static final String PAGENAME = "Simple Result View";
    private static final String PAGETITLE	=	"Simple Result View";
    private static final String PAGEDESC	=	"All Results generated";

    private EList<Operator> ops;
    private Composite composite;
    private ScrolledComposite scrolledComposite;

    /**
     * @return the ops
     */
    public EList<Operator> getOps() {
        return ops;
    }
    /**
     * @param ops the ops to set
     */
    public void setOps(EList<Operator> ops) {
        this.ops = ops;
        if(composite!=null)
            composite.layout(true, true);
    }
    /**
     * @param pageName
     */
    public SimpleResultPage(String pageName) {
        super(pageName);
    }
    public SimpleResultPage( EList<Operator> ops){
        super(PAGENAME);
        setTitle(PAGETITLE);
        setDescription(PAGEDESC);
        this.ops=ops;
    }
    /* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    @Override
    public void createControl(Composite parent) {
        //create the widgets for the page
        scrolledComposite = new ScrolledComposite(parent, SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);
        composite = new Composite(scrolledComposite,SWT.NONE);
        scrolledComposite.setContent(composite);
        GridLayout layout = new GridLayout(2, false);
        composite.setLayout(layout);
        composite.setBounds(10, 40, 200, 200);

        for(Operator o:ops){
            ResultObject r = o.getResult();
            if (o instanceof OclOperator){
                HashMap<Notification, LinkedList<String>> affectedExprs = ((OclOperator)o).getAffectedExprs();
                for (Notification noti: affectedExprs.keySet()){
                    r.setMessage(r.getMessage()
                            + "\n" + affectedExprs.get(noti).size() 
                            + " affected Expressions for: " 
                            + noti.toString());
                }
            }
            Label label1 = new Label(composite, SWT.CENTER);
            label1.setText(o.getName());
            try{
                r.getComposite(composite);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        setControl(scrolledComposite);
    }
    public static String getCustomStackTrace(Throwable aThrowable) {
        //add the class name and any message passed to constructor
        final StringBuilder result = new StringBuilder();
        result.append(aThrowable.toString());
        final String NEW_LINE = System.getProperty("line.separator");
        result.append(NEW_LINE);

        //add each element of the stack trace
        for (StackTraceElement element : aThrowable.getStackTrace() ){
            result.append( element );
            result.append( NEW_LINE );
        }
        return result.toString();
    }

}
