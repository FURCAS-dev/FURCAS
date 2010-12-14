package com.sap.furcas.ide.editor.autoedit;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

import com.sap.furcas.ide.editor.CtsActivator;
import com.sap.furcas.ide.editor.matching.CtsDynamicMatcher;
import com.sap.furcas.ide.editor.matching.CtsStaticMatcher;
import com.sap.furcas.ide.editor.matching.ICtsDynamicMatcher;

public class CtsAutoEditStrategy implements IAutoEditStrategy {

    @Override
    public void customizeDocumentCommand(IDocument d, DocumentCommand c) {
        CtsAutoEdit bAutoEdit = null;
        IConfigurationElement[] config = Platform.getExtensionRegistry()
                .getConfigurationElementsFor(
                        "com.sap.ide.cts.editor.autoEditing");
        if (config.length != 0) {
            IConfigurationElement e = config[0];
            String autoEditingType = e.getAttribute("autoEditingType");
            if (autoEditingType.indexOf("static") != -1) {
                CtsStaticMatcher bsm = new CtsStaticMatcher();
                if (autoEditingType.equals("static (configurable)")) {
                    String autoIndentBraces = e
                            .getAttribute("autoIndentBraces");
                    if (autoIndentBraces != null) {
                        String braces[] = autoIndentBraces.split(",");
                        if (braces.length == 2)
                            bsm.setAutoIndentChars(braces[0], braces[1]);
                    }
                }
                bAutoEdit = new CtsAutoEdit(bsm);
            }
            if (autoEditingType.equals("dynamic (default)"))
                bAutoEdit = new CtsAutoEdit(new CtsDynamicMatcher());
            if (autoEditingType.equals("dynamic (configurable)")) {
                Object o;
                try {
                    o = e.createExecutableExtension("dynamicAutoEditingClass");
                    if (o instanceof ICtsDynamicMatcher) {
                        bAutoEdit = new CtsAutoEdit((ICtsDynamicMatcher) o);
                    }
                } catch (CoreException e1) {
                    CtsActivator.logError(e1);
                    return;
                }
            }

            if (bAutoEdit.isNewLineDetected(d, c))
                bAutoEdit.autoEditAfterNewLine(d, c);
        }

    }

}