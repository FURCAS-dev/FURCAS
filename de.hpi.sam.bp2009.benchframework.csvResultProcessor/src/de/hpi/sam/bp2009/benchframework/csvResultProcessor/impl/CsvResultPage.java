package de.hpi.sam.bp2009.benchframework.csvResultProcessor.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.hpi.sam.bp2009.benchframework.Operator;
import de.hpi.sam.bp2009.benchframework.ResultObject;
import de.hpi.sam.bp2009.benchframework.csvResultProcessor.OclOperator;
import de.hpi.sam.bp2009.benchframework.loopOperator2.impl.EndLoopImpl;

/**
 * @author tobias.hoppe
 *
 */
public class CsvResultPage extends WizardPage {
    private static final String SAVE_BUTTON_LABEL = "save";
    private static final String PAGENAME = "CSV Result Page";
    private static final String PAGETITLE = "CSV Result Page";
    private static final String PAGEDESCRIPTION = "Save results to a .csv file";
    private static final String TEXTLABEL = "File Name:";
    private static final String BUTTONLABEL = "Browse";

    String filePath;
    Text textarea;
    private EList<Operator> ops;

    public CsvResultPage(EList<Operator> ops){
        super(PAGENAME);
        setTitle(PAGETITLE);
        setDescription(PAGEDESCRIPTION);
        this.ops = ops;
    }

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
    }

    protected CsvResultPage(String pageName) {
        super(pageName);
    }

    public void createControl(Composite parent) {
        final Composite composite = new Composite(parent, SWT.None);
        GridLayout layout = new GridLayout(3, false);
        composite.setLayout(layout);
        Label txtlabel = new Label(composite, SWT.NONE);
        txtlabel.setText(TEXTLABEL);

        textarea = new Text(composite, SWT.RESIZE);
        //TODO initial resizing would be a nice feature
        textarea.setSize(300, 15);

        textarea.addModifyListener(new ModifyListener() {	
            @Override
            public void modifyText(ModifyEvent e) {
                // update filePath on change
                filePath = textarea.getText();
            }
        });

        Button loadButton = new Button(composite, SWT.NONE);
        loadButton.setText(BUTTONLABEL);
        loadButton.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // open a file dialog
                FileDialog dialog = new FileDialog(getShell(), SWT.SAVE);
                String[] filterNames = new String[] {"CSV Files", "All Files (*)"};
                String[] filterExtensions = new String[] {"*.csv", "*"};
                String filterPath = "/";
                String platform = SWT.getPlatform();
                if (platform.equals("win32") || platform.equals("wpf")) {
                    filterNames = new String[] {"CSV Files", "All Files (*.*)"};
                    filterExtensions = new String[] {"*.csv", "*.*"};
                    filterPath = "c:\\";
                }
                dialog.setFilterNames(filterNames);
                dialog.setFilterExtensions(filterExtensions);
                dialog.setFilterPath(filterPath);
                dialog.setFileName("testrun_results");
                textarea.setText(dialog.open());
            }
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {}
        });

        Button saveButton = new Button(composite, SWT.NONE);
        saveButton.setText(SAVE_BUTTON_LABEL);
        saveButton.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                //save result as csv
                File result = new File(textarea.getText());
                FileOutputStream fw = null;
                try {
                    result.createNewFile();														
                    fw = new FileOutputStream(result);
                    if (result.exists()){
                        for (Operator op : ops) {
                            ResultObject r = op.getResult();
                            if (op instanceof OclOperator){
                                HashMap<Notification, LinkedList<String>> affectedExprs = ((OclOperator)op).getAffectedExprs();
                                for (Notification noti: affectedExprs.keySet()){
                                    String no = noti.toString();
                                    no = no.replace("eventType", " , eventType");
                                    r.setMessage(r.getMessage()
                                            + "\n\n" + affectedExprs.get(noti).size() 
                                            + ",  affected Expression(s) , \n , " + affectedExprs.get(noti).toString().replace(",", ", \n , ") 
                                            + " , \n , for: " 
                                            + no);
                                }
                                r.setMessage(r.getMessage() 
                                        + "evaluation time for all ");
                            }
                            String msg;
                            if (r != null){
                                if (op instanceof EndLoopImpl) msg = "\n\n";
                                else {									
                                    msg = r.getCSV();
                                    //if msg is not empty and don't ends with a comma, append one
                                    msg = msg.trim();
                                    if ((!msg.endsWith(",") && !"".equals(msg))) msg += " , "; 
                                }								
                                fw.write(msg.getBytes());
                            }						
                        }
                    }
                    else System.err.println("File could not be written.");
                } catch (IOException e1) {
                    System.err.println("File could not be saved");
                    e1.printStackTrace();
                } finally {
                    try {
                        fw.close();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }		
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {}
        });		
        setControl(composite);		
    }
}
