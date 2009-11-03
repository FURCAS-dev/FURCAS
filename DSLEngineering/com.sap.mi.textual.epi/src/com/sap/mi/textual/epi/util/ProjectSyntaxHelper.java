/**
 * 
 */
package com.sap.mi.textual.epi.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.sap.mi.fwk.ModelAdapter;
import com.sap.mi.fwk.ui.editor.ModelEditorInput;
import com.sap.mi.fwk.ui.editor.ModelObjectElementFactory;
import com.sap.mi.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.epi.Activator;
import com.sap.mi.textual.epi.conf.DeployedMetaProjectConf;
import com.sap.mi.textual.epi.conf.IProjectMetaRefConf;
import com.sap.mi.textual.epi.conf.ProjectMetaRefConfFactory;
import com.sap.mi.textual.grammar.ParserFacade;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.syntaxmodel.moinadapter.ModelInjectionResult;
import com.sap.mi.textual.syntaxmodel.moinadapter.TCS2MOINInjectorFacade;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * 
 */
public class ProjectSyntaxHelper {

	/**
	 * @param shell
	 * @param result
	 */
	public static void openEditorOnResult(Shell shell, RefObject result) {
		// create ModelEditorInput
		ModelObjectElementFactory fac = new ModelObjectElementFactory();
		final ModelEditorInput eInput = fac.createEditorInput(result);

		// open Editor using Editor Input

		shell.getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, eInput,
							"com.sap.mi.tcs.editor.ActionsEditor");
				} catch (PartInitException e) {
					Activator.logError(e);
				}
			}
		});
	}

	public static RefObject createMapping(String content,
			Connection connection, List<String> metaModelContainerNames,
			ParserFacade tcsParserFacade)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException, ModelAdapterException {

		Set<PRI> referencePRIs = new HashSet<PRI>();

		if (metaModelContainerNames != null) {
			for (String metaModelContainerName : metaModelContainerNames) {

				try {

					// this fails during non-plugin Junit-tests
					DeployedMetaProjectConf conf = new DeployedMetaProjectConf(
							metaModelContainerName, null);
					referencePRIs.addAll(conf.getMetaLookUpForProject()
							.getReferencePRIs());

				} catch (Exception e) {
					// do nothing
				}

			}

			return createMapping(content, connection, referencePRIs,
					tcsParserFacade);
		}

		return null;
	}

	/**
	 * @param content
	 * @param connection
	 * @param b
	 * @return
	 * @throws UnknownProductionRuleException
	 * @throws IOException
	 * @throws InvalidParserImplementationException
	 * @throws ModelAdapterException
	 */
	public static RefObject createMapping(String content,
			Connection connection, ParserFacade tcsParserFacade)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException, ModelAdapterException {
		Set<PRI> referencePRIs = new HashSet<PRI>();
		try {
			try {
				IProjectMetaRefConf conf = ProjectMetaRefConfFactory
						.getConfig(ModelAdapter.getInstance().getProject(
								connection));
				referencePRIs.addAll(conf.getMetaLookUpForProject()
						.getReferencePRIs());
			} catch (IllegalStateException e) {
				// no dsl nature
				// do nothing
			}
			return createMapping(content, connection, referencePRIs,
					tcsParserFacade);

		} catch (CoreException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static RefObject createMapping(String content,
			Connection connection, Set<PRI> referencePRIs)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException, ModelAdapterException {
		return createMapping(content, connection, referencePRIs, null);
	}

	public static RefObject createMapping(String content,
			Connection connection, Set<PRI> referencePRIs,
			ParserFacade tcsParserFacade)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException, ModelAdapterException {
		Moin moin = connection.getSession().getMoin();
		Set<PRI> allReferencePRIs = new HashSet<PRI>();
		allReferencePRIs
				.add(moin
						.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm"));
		allReferencePRIs
				.add(moin
						.createPri("PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm"));

		allReferencePRIs.addAll(referencePRIs);

		ByteArrayInputStream input = new ByteArrayInputStream(content
				.getBytes());
		ModelInjectionResult result = TCS2MOINInjectorFacade
				.parseSyntaxDefinition(input, connection, allReferencePRIs,
						null, tcsParserFacade);

		return result.getSyntax();

	}

}
