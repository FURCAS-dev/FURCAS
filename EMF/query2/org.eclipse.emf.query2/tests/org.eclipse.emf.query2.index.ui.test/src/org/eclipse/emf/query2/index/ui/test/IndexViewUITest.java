package org.eclipse.emf.query2.index.ui.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import library.LibraryPackage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.index.Index;
import org.eclipse.emf.query.index.IndexFactory;
import org.eclipse.emf.query.index.query.descriptors.EObjectDescriptor;
import org.eclipse.emf.query.index.query.descriptors.EReferenceDescriptor;
import org.eclipse.emf.query.index.query.descriptors.ResourceDescriptor;
import org.eclipse.emf.query.index.update.IndexUpdater;
import org.eclipse.emf.query.index.update.ResourceIndexer;
import org.eclipse.emf.query.index.update.UpdateCommandAdapter;
import org.eclipse.emf.query2.librarytest.Parser;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotViewMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class IndexViewUITest {

	private static SWTWorkbenchBot bot;
	private SWTBotTree tree;
	private static int resourceIndexLength = 0;

	@BeforeClass
	public static void beforeClass() throws Exception {
		createIndices();
		bot = new SWTWorkbenchBot();
		bot.viewByTitle("Welcome").close(); //$NON-NLS-1$
	}

	// Indexes are generated, re-using the parser in library test plugin, where
	// resources are created and loaded
	private static void createIndices() {
		Index DEFAULT_INDEX = IndexFactory.getInstance();
		final ResourceIndexer indexer = new ResourceIndexer();
		final ResourceSet rs = new ResourceSetImpl();
		DEFAULT_INDEX.executeUpdateCommand(new UpdateCommandAdapter() {
			public void execute(final IndexUpdater updater) {
				indexer.resourceChanged(updater,EcorePackage.eINSTANCE.eResource());
				indexer.resourceChanged(updater,LibraryPackage.eINSTANCE.eResource());
				Parser parser = new Parser();
				// load the resources
				parser.loadResources(rs);
				EList<Resource> resources = rs.getResources();
				indexer.resourceChanged(updater,resources.toArray(new Resource[0]));
				// unload the resources
				for (Iterator iterator = resources.iterator(); iterator.hasNext();) {
					Resource resource = (Resource) iterator.next();
					resource.unload();
				}
			}
		});

		Object[] resourceMap = DEFAULT_INDEX.getGlobalTables().resourceIndex.getResourceMap();
		for (Object object : resourceMap) {
			if (object != null && object instanceof ResourceDescriptor) {
				if (!((ResourceDescriptor) object).getURI().isEmpty()) {
					resourceIndexLength++;
				}
			}
		}
	}

	@Test
	/**
	 * Tests the opening of the index view
	 */
	public void testOpenIndexView() {
		bot.menu("Window").menu("Show View").menu("Other...").click(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		tree = bot.tree(0);
		SWTBotTreeItem  tItem = tree.getTreeItem("EMF Query 2").expand(); //$NON-NLS-1$
		tItem.getNode("Index View").doubleClick(); //$NON-NLS-1$
		assertTrue(bot.viewByTitle("Index View").isActive()); //$NON-NLS-1$
		
		bot.menu("Window").menu("Show View").menu("Other...").click(); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		tree = bot.tree(0);
		tItem = tree.getTreeItem("General").expand(); //$NON-NLS-1$
		tItem.getNode("Properties").doubleClick(); //$NON-NLS-1$
		bot.viewByTitle("Index View").setFocus(); //$NON-NLS-1$
	}

	@Test
	/**
	 * Tests the contents of the index view, if they contain the indexed resources
	 */
	public void testIndexContents() {
		int elementTypeIndexCount = IndexFactory.getInstance().getGlobalTables().elementTypeIndex.size();
		tree = bot.tree(0);
		SWTBotTreeItem tItem = tree.getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		bot.sleep(2000);
		assertTrue(tItem.getItems().length == resourceIndexLength);
		tItem.collapse();
		tItem = tree.getTreeItem("Type Index").expand(); //$NON-NLS-1$
		assertTrue(tItem.getItems().length == elementTypeIndexCount);
		tItem.collapse();
	}

	@Test
	/**
	 * Tests the properties of contents in index view, if the expected number/value of properties are displayed
	 */
	public void testResourceIndexProperties() {
		tree = bot.tree(0);
		SWTBotTreeItem tItem = tree.getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		String uri = tItem.getNode(0).getText();
		tItem.getNode(0).select();

		// Checks if the properties for resource indices are as expected
		SWTBotTreeItem[] item = bot.tree(1).getTreeItem("Basic").getItems(); //$NON-NLS-1$
		assertTrue(bot.tree(1).getTreeItem("Basic").getNodes().size() == 1); //$NON-NLS-1$
		assertTrue(bot.tree(1).getTreeItem("Basic").cell(0, 1).equals(uri)); //$NON-NLS-1$
	}
	
	//Checks the properties for object in Type index
	@Test
	public void testPropertiesofTypeIndex() {
		tree = bot.tree(0);
		SWTBotTreeItem tItem = tree.getTreeItem("Type Index").expand(); //$NON-NLS-1$
		tItem.getNode(0).select();
		assertTrue(bot.tree(1).getTreeItem("Basic").getNodes().size() == 1); //$NON-NLS-1$
		String[] uri = getElementIndexURI();
		assertTrue(bot.tree(1).getTreeItem("Basic").cell(0, 1).equals(uri[0])); //$NON-NLS-1$
		tItem.getNode(0).expand().getNode(0).select();
		assertTrue(bot.tree(1).getTreeItem("Basic").getNodes().size() == 1); //$NON-NLS-1$
		assertTrue(bot.tree(1).getTreeItem("Basic").cell(0, 1).equals(uri[1])); //$NON-NLS-1$
	}

	// Checks the properties for objects in eobjectTable
	@Test
	public void testPropertiesofEObjectTable() {
		SWTBotTreeItem tItem = bot.tree(0).getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		ResourceDescriptor objectDescriptor = null;
		for (int i = 0; i < tItem.getItems().length; i++) {
			SWTBotTreeItem resourceItem = tItem.getNode(i).expand();
			SWTBotTreeItem eObjectItem = resourceItem.getNode(0).expand();
			// Checks if eObjectTable exists for the given resource
			if (eObjectItem.getNodes().size() > 0) {
				ResourceDescriptor resDesc = getResourceDesc(resourceItem);
				eObjectItem.getNode(0).select();
				Object[] eObjTable = resDesc.getEObjectTable();
				// Checks if the properties displayed for eObject elements are correct
				SWTBotTreeItem treeItem = bot.tree(1).getTreeItem("Basic"); //$NON-NLS-1$
				if (eObjTable[0] instanceof EObjectDescriptor) {
					assertTrue(treeItem.cell(0, 1).equals(((EObjectDescriptor) eObjTable[0]).getFragment().toString()));
				}
				assertTrue(treeItem.getNodes().size() == 2);
				eObjectItem.collapse();
				break;
			} else
				resourceItem.collapse();
		}
	}

	
    //Tests the properties of objects in incoming table
	@Test
	public void testPropertiesofIncomingTable() {
		SWTBotTreeItem tItem = bot.tree(0).getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		for (int i = 0; i < tItem.getItems().length; i++) {
			SWTBotTreeItem resourceItem = tItem.getNode(i).expand();
			// Expand the incomingLinkTable
			SWTBotTreeItem incomingTableItem = resourceItem.getNode(1).expand();
			if (incomingTableItem.getNodes().size() > 0) {
				ResourceDescriptor resDesc = getResourceDesc(resourceItem);
				incomingTableItem.getNode(0).select();
				Object[] incomingLinks = resDesc.getIncomingLinksTable();
				// Checks if the properties for incomingTable are set/displayed as expected
				SWTBotTreeItem treeItem = bot.tree(1).getTreeItem("Basic"); //$NON-NLS-1$
				if (incomingLinks[0] instanceof EReferenceDescriptor) {
					EReferenceDescriptor eReferenceDescriptor = (EReferenceDescriptor) incomingLinks[0];
					assertTrue(treeItem.cell(0, 1).equals(eReferenceDescriptor.getEReferenceURI()));
					assertTrue(treeItem.cell(1, 1).equals(eReferenceDescriptor.getSourceFragment()));
					assertTrue(treeItem.cell(2, 1).equals(eReferenceDescriptor.getSourceResourceURI().toString()));
					assertTrue(treeItem.cell(3, 1).equals(eReferenceDescriptor.getTargetFragment()));
					assertTrue(treeItem.cell(4, 1).equals(eReferenceDescriptor.getTargetResourceURI().toString()));
				}
				assertTrue(treeItem.getNodes().size() == 5);
				incomingTableItem.collapse();
				break;
			} else
				resourceItem.collapse();
		}

	}
 
	//Tests the properties of objects in outgoing table
	@Test
	public void testPropertiesofOutgoingTable() {
		SWTBotTreeItem tItem = bot.tree(0).getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		for (int i = 0; i < tItem.getItems().length; i++) {
			SWTBotTreeItem resourceItem = tItem.getNode(i).expand();
			// Expand the OutgoingLinkTable
			SWTBotTreeItem outgoingTableItem = resourceItem.getNode(2).expand();
			if (outgoingTableItem.getNodes().size() > 0) {
				ResourceDescriptor resDesc = getResourceDesc(resourceItem);
				outgoingTableItem.getNode(0).select();
				Object[] outgoingLinks = resDesc.getOutgoingLinkTable();
				// Checks if the properties for outgoingTable are set/displayedas expected
				SWTBotTreeItem treeItem = bot.tree(1).getTreeItem("Basic"); //$NON-NLS-1$
				if (outgoingLinks[0] instanceof EReferenceDescriptor) {
					EReferenceDescriptor eReferenceDescriptor = (EReferenceDescriptor) outgoingLinks[0];
					assertTrue(treeItem.cell(0, 1).equals(eReferenceDescriptor.getEReferenceURI()));
					assertTrue(treeItem.cell(1, 1).equals(eReferenceDescriptor.getSourceFragment()));
					assertTrue(treeItem.cell(2, 1).equals(eReferenceDescriptor.getSourceResourceURI().toString()));
					assertTrue(treeItem.cell(3, 1).equals(eReferenceDescriptor.getTargetFragment()));
					assertTrue(treeItem.cell(4, 1).equals(eReferenceDescriptor.getTargetResourceURI().toString()));
				}
				assertTrue(treeItem.getNodes().size() == 5);
				outgoingTableItem.collapse();
				break;
			} else
				resourceItem.collapse();
		}
	}


	@Test
	public void testToolBarButtons() {
		//testUncheckEobjectTable();
		//testCheckEobjectTable();
		testLegendsDialog();
	}

	private void testLegendsDialog() {
		bot.viewByTitle("Index View").menu("Display Legends").click();//$NON-NLS-1$ //$NON-NLS-2$
		assertTrue(bot.activeShell().getText().equals("Legends")); //$NON-NLS-1$
		class UIThread implements Runnable {
			
			public void run() {
				assertTrue(bot.activeShell().widget.getChildren().length ==4);
			}
		}
		bot.button("OK").click(); //$NON-NLS-1$
		bot.viewByTitle("Index View").setFocus(); //$NON-NLS-1$
		
	}

	@Test
	/**
	 * Tests if the text filter, filters the results as expected
	 */
	public void testTextFilter() {
		String filterText = "person/Z.xmi"; //$NON-NLS-1$
		bot.text(0).setText("*" + filterText); //$NON-NLS-1$
		SWTBotTreeItem tItem = bot.tree(0).getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		bot.sleep(1000);
		for (int i = 0; i < tItem.getNodes().size(); i++) {
			assertTrue(tItem.getNode(i).getText().contains(filterText));
		}
	}

	@Test
	/**
	 * Tests context menu actions - copy qualified name
	 */
	public void testCopyQualifiedNameAction() {
		SWTBotTreeItem tItem = bot.tree(0).getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		final String uri = tItem.getNode(0).getText();
		tItem.getNode(0).contextMenu("Copy Qualified Name").click(); //$NON-NLS-1$
		class UIThread implements Runnable {
			
			public void run() {
				Transfer[] dataType = new Transfer[] { TextTransfer.getInstance() };
				Clipboard clipBoard = new Clipboard(Display.getDefault());
				assertTrue(clipBoard.getContents(dataType[0]).equals(uri));
			}
		}
	}

	private void testUncheckEobjectTable() {
		boolean eObjectTableExists = false;
		bot.viewByTitle("Index View").menu("EObject Table").click(); //$NON-NLS-1$ //$NON-NLS-2$
		bot.sleep(500);
		SWTBotTreeItem tItem = bot.tree(0).getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		for (int i = 0; i < tItem.getItems().length; i++) {
			SWTBotTreeItem resourceItem = tItem.getNode(i).expand();
			SWTBotTreeItem eObjectItem = resourceItem.getNode(0).expand();
			if (eObjectItem.getNodes().size() > 0) {
				eObjectTableExists = true;
				break;
			} else
				resourceItem.collapse();
		}
		assertFalse(eObjectTableExists);

	}
	
	private void testCheckEobjectTable() {
		boolean eObjectTableExists = false;
		SWTBotViewMenu eObjectMenuItem = bot.viewByTitle("Index View").menu("EObject Table"); //$NON-NLS-1$ //$NON-NLS-2$
		bot.sleep(500);
		eObjectMenuItem.click();
		SWTBotTreeItem tItem = bot.tree(0).getTreeItem("Resource Index").expand(); //$NON-NLS-1$
		for (int i = 0; i < tItem.getItems().length; i++) {
			SWTBotTreeItem resourceItem = tItem.getNode(i).expand();
			SWTBotTreeItem eObjectItem = resourceItem.getNode(0).expand();
			if (eObjectItem.getNodes().size() > 0) {
				eObjectTableExists = true;
				break;
			} else
				resourceItem.collapse();
		}
		assertTrue(eObjectTableExists);
	}
	
	private ResourceDescriptor getResourceDesc(SWTBotTreeItem resourceItem) {
		Object[] resourceDesc = IndexFactory.getInstance().getGlobalTables().resourceIndex.getResourceMap();
		ResourceDescriptor resDesc = getResourceDesc(resourceDesc,resourceItem.getText());
		return resDesc;
	}
	
	private ResourceDescriptor getResourceDesc(Object[] eObjectDescriptor,String item) {
		ResourceDescriptor objectDescriptor = null;
		for (int i = 0; i < eObjectDescriptor.length; i++) {
			if (eObjectDescriptor[i] instanceof ResourceDescriptor)
				if (((ResourceDescriptor) eObjectDescriptor[i]).getURI().toString().equals(item))
					objectDescriptor = (ResourceDescriptor) eObjectDescriptor[i];
		}
		return objectDescriptor;
	}
	
	private String[] getElementIndexURI(){
		String[] uri = new String[2];
		Object[] resourceDesc = IndexFactory.getInstance().getGlobalTables().elementTypeIndex.getUnderlyingMapTable();
		for (int i = 0; i < resourceDesc.length; i++) {
			if (resourceDesc[i]!=null){
				Object[] typesArray = (Object[]) resourceDesc[i];
				for (int j = 0; j < typesArray.length; j++) {
					if (j == 0) {
					uri[0] = typesArray[j].toString();
					} else {
						if (typesArray[j] != null && typesArray[j] instanceof URI) {
							uri[1] = typesArray[j].toString();
							break;
						}
					}
				}
				break;
			}
		}
		return uri;
	}

	@AfterClass
	public static void sleep() {
		bot.sleep(2000);
		bot.closeAllEditors();
	}

}
