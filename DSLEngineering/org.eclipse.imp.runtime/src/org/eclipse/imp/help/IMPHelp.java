/*******************************************************************************
* Copyright (c) 2008 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.help;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.help.IContextProvider;
import org.eclipse.imp.editor.LanguageServiceManager;
import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.parser.ISourcePositionLocator;
import org.eclipse.imp.runtime.RuntimePlugin;
import org.eclipse.imp.services.IHelpService;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.HelpEvent;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.texteditor.ITextEditor;

public class IMPHelp {
    private final static Object[] NO_ELEMENTS= new Object[0];

    public static void setHelp(LanguageServiceManager svcMgr, StructuredViewer viewer, String contextId) {
        IMPViewerHelpListener listener= new IMPViewerHelpListener(svcMgr, viewer, contextId);
        viewer.getControl().addHelpListener(listener);
    }

    public static void setHelp(LanguageServiceManager svcMgr, ITextEditor editor, StyledText text, String contextId) {
        IMPEditorHelpListener listener= new IMPEditorHelpListener(svcMgr, editor, contextId);
        text.addHelpListener(listener);
    }

    private static abstract class IMPHelpListenerBase implements HelpListener {
        protected String fContextId;

        public IMPHelpListenerBase(String contextId) {
            fContextId= contextId;
        }
    }

    private static class IMPViewerHelpListener extends IMPHelpListenerBase {
        private StructuredViewer fViewer;
        private final IHelpService fHelpService;
        private final IParseController fParseController;

        public IMPViewerHelpListener(LanguageServiceManager svcManager, StructuredViewer viewer, String contextId) {
            super(contextId);
            fHelpService= svcManager.getContextHelp();
            fParseController= svcManager.getParseController();
            fViewer= viewer;
        }

        /*
         * @see HelpListener#helpRequested(HelpEvent)
         * 
         */
        public void helpRequested(HelpEvent e) {
            try {
                Object[] selected= null;
                if (fViewer != null) {
                    ISelection selection= fViewer.getSelection();
                    if (selection instanceof IStructuredSelection) {
                        selected= ((IStructuredSelection) selection).toArray();
                    }
                }
                IMPHelpContext.displayHelp(fHelpService, fParseController, fContextId, selected);
            } catch (CoreException x) {
                RuntimePlugin.getInstance().logException(x.getMessage(), x);
            }
        }
    }

    private static class IMPEditorHelpListener extends IMPHelpListenerBase {
        private final ITextEditor fEditor;
        private final IHelpService fHelpService;
        private final ISourcePositionLocator fLocator;
        private final IParseController fParseController;

        public IMPEditorHelpListener(LanguageServiceManager svcManager, ITextEditor editor, String contextId) {
            super(contextId);
            fHelpService= svcManager.getContextHelp();
            fParseController= svcManager.getParseController();
            fLocator= fParseController.getSourcePositionLocator();
            fEditor= editor;
        }

        /*
         * @see HelpListener#helpRequested(HelpEvent)
         * 
         */
        public void helpRequested(HelpEvent e) {
            try {
                Object[] selected= null;

                if (fEditor != null) {
                    ITextSelection textSel= (ITextSelection) fEditor.getSelectionProvider().getSelection();
                    Object node= fLocator.findNode(fParseController.getCurrentAst(), textSel.getOffset());

                    selected= new Object[] { node };
                }
                IMPHelpContext.displayHelp(fHelpService, fParseController, fContextId, selected);
            } catch (CoreException x) {
                RuntimePlugin.getInstance().logException(x.getMessage(), x);
            }
        }
    }

    /**
     * Creates and returns a help context provider for the given part.
     * 
     * @param part the part for which to create the help context provider
     * @param contextId the optional context ID used to retrieve static help
     * @return the help context provider
     */
    public static IContextProvider getHelpContextProvider(IWorkbenchPart part, LanguageServiceManager srvcMgr, String contextId) {
        ISelectionProvider provider= part.getSite().getSelectionProvider();
        if (provider != null) {
            ISelection sel= provider.getSelection();
            if (sel instanceof IStructuredSelection) {
                IStructuredSelection selection= (IStructuredSelection) sel;

                return new IMPHelpContextProvider(srvcMgr, contextId, selection.toArray());
            } else if (sel instanceof ITextSelection) {
                ITextSelection textSel= (ITextSelection) sel;
//                IParseController parseController= srvcMgr.getParseController();

                return new IMPHelpContextProvider(srvcMgr, contextId, new Region(textSel.getOffset(), textSel.getLength()));
//                ISourcePositionLocator nodeLocator= parseController.getNodeLocator();
//                Object node= nodeLocator.findNode(parseController.getCurrentAst(), textSel.getOffset(), textSel.getOffset() + textSel.getLength());
//
//                if (node != null) {
//                    elements= new Object[] { node };
//                } else {
//                    elements= NO_ELEMENTS;
//                }
            }
        }
        return null;
    }
}
