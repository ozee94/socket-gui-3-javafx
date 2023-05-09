package application.utils;

import javafx.beans.InvalidationListener;
import javafx.css.PseudoClass;
import javafx.scene.control.TreeCell;

public class CustomTreeCell<T> extends TreeCell<T> {

    private static final PseudoClass ROOT = PseudoClass.getPseudoClass("root");

    public CustomTreeCell() {
        getStyleClass().add("custom-tree-cell");

        InvalidationListener listener = observable -> {
            boolean isRoot = getTreeView() != null && getTreeItem() == getTreeView().getRoot();
            pseudoClassStateChanged(ROOT, isRoot);
        };

        treeViewProperty().addListener(listener);
        treeItemProperty().addListener(listener);
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            graphicProperty().unbind();
            setGraphic(null);
        } else {
            setText(item.toString());
            graphicProperty().bind(getTreeItem().graphicProperty());
        }
    }
}