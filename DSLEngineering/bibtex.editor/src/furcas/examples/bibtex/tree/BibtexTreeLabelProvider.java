package furcas.examples.bibtex.tree;

import bibtex.Author;
import bibtex.Entry;
import bibtex.LiteratureDb;

import com.sap.ide.treeprovider.GenericRefObjectNode;
import com.sap.ide.treeprovider.TextLabelProvider;
import com.sap.mi.fwk.ui.tree.nodes.TreeNodeRefObject;

public class BibtexTreeLabelProvider implements TextLabelProvider {

    @Override
    public String getText(Object treenode) {
	if (treenode instanceof TreeNodeRefObject) {
	    TreeNodeRefObject<?> node = (TreeNodeRefObject<?>) treenode;
	    String roleName = "";
	    if (node instanceof GenericRefObjectNode) {
		String nodeRoleName = ((GenericRefObjectNode) node).getRoleName();
		if (nodeRoleName != null) {
		    roleName = nodeRoleName+": ";
		}
	    }
	    if (node.getValue() instanceof Entry) {
		Entry f = (Entry) node.getValue();
		return roleName + f.getId() +  "->" + (f.getAuthor().size()>0? f.getAuthor().iterator().next().getName() : "<no author>") + " : " + f.getTitle();
	    } 
	    if (node.getValue() instanceof Author) {
		Author f = (Author) node.getValue();
		return roleName + f.getName();
	    } 
	    if (node.getValue() instanceof LiteratureDb) {
		LiteratureDb f = (LiteratureDb) node.getValue();
		return "DB:" + f.getName();
	    }
	}
	return null;
    }
    
}
