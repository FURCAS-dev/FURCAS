package ocljmi;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Reader;

import org.oslo.ocl20.OclProcessor;

import uk.ac.kent.cs.kmf.util.ILog;
import uk.ac.kent.cs.kmf.util.OutputStreamLog;

/**
 * 
 * @author Octavian Patrascoiu
 *
 */
public class CodeGenerator {
	/**
	 *  Constructor
	 */
	OclProcessor processor;
	public CodeGenerator(OclProcessor proc, String inputFileName, String outputDir, String pkgName, String outputClassName, ILog log) {
		this.processor = proc;
		this.inputFileName = inputFileName;
		this.outputClassName = outputClassName;
		this.outputDir = outputDir;
		this.pkgName = pkgName;
		this.log = log;
	}

	public void generate() {
		// Generate the code
		try {
			//--- Prepare input ---
			System.out.println("Reading File - " + inputFileName);
			Reader input = new FileReader(inputFileName);
			//--- Prepare output --- 
			String outputFileName = outputDir + "/" + this.pkgName.replaceAll("[.]","/") + "/" + outputClassName+".java";
			PrintWriter output = new PrintWriter(new FileWriter(outputFileName), true);
			//--- Invoke generation from Ocl4Emf
			this.processor.generate(input, output, pkgName, outputClassName, log);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public static void main(String args[]) {
		// Check arguments
		if (args.length != 4) {
			System.out.println("Usage: ");
			System.out.println("       - basePackage name ");
			System.out.println("       - package name ");
			System.out.println("       - model name ");
			System.out.println("       - input file name ");
			System.out.println("       - output directory name ");
			System.out.println("       - output package name ");
			System.out.println("       - output class name ");
			return;
		}
		
		// Init the model and log
		ILog log = new OutputStreamLog(System.out);
		Ocl4Jmi.InitModel(args[0], args[1], args[3], log);

		// Create a code generator
		CodeGenerator codeGen = new CodeGenerator(Ocl4Jmi.processor, args[3], args[4], args[5], args[6], log);
		// Generate the code
		codeGen.generate();
	}
	private String inputFileName;
	public String outputDir;
	private String outputClassName;
	private String pkgName;
	private ILog log;
}
