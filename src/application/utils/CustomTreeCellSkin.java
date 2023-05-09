package application.utils;

import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.scene.control.skin.TreeCellSkin;

public class CustomTreeCellSkin<T> extends TreeCellSkin<T>{
	
	public CustomTreeCellSkin(TreeCell<T> control) {
        super(control);
    }

    @Override
    protected void layoutChildren(double x, double y, double w, double h) {
        super.layoutChildren(x, y, w, h);

        TreeView<T> tree = getSkinnable().getTreeView();

        int level = tree.getTreeItemLevel(getSkinnable().getTreeItem());
        if (!tree.isShowRoot()) {
            level--;
        }
        double leftMargin = getIndent() * level;

        x += leftMargin;

        double disclosureWidth = 18;

        final int padding = 3;
        // x += disclosureWidth + padding;
        x += 3;

        w -= (leftMargin + disclosureWidth + padding);

        layoutLabelInArea(x, y, w, h);
    }
}
