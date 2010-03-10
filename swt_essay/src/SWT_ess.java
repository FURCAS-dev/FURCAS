
public class SWT_ess {
	public static void main(String[] args) {
	    Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setLayout(new GridLayout(3, true));

	    // Create three checkboxes
	    new Button(shell, SWT.CHECK).setText("Checkbox 1");
	    new Button(shell, SWT.CHECK).setText("Checkbox 2");
	    new Button(shell, SWT.CHECK).setText("Checkbox 3");

	    shell.pack();
	    shell.open();
	    while (!shell.isDisposed()) {
	      if (!display.readAndDispatch()) {
	        display.sleep();
	      }
	    }
	    display.dispose();
	  }
}
