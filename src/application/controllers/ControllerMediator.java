package application.controllers;

public class ControllerMediator {

	private static ControllerMediator instance = null;

	private PanelViewController panelViewController = null;
	private TreeViewController treeViewController = null;
	private SocketViewController socketViewController = null;

	private ControllerMediator() {
	}

	public PanelViewController getPanelViewController() {
		return panelViewController;
	}

	public void setPanelViewController(PanelViewController panelViewController) {
		if (this.panelViewController == null) {
			this.panelViewController = panelViewController;
		}
	}

	public TreeViewController getTreeViewController() {
		return treeViewController;
	}

	public void setTreeViewController(TreeViewController treeViewController) {
		if (this.treeViewController == null) {
			this.treeViewController = treeViewController;
		}
	}
	
	public SocketViewController getSocketViewController() {
		return socketViewController;
	}
	
	public void setSocketViewController(SocketViewController socketViewController) {
		if (this.socketViewController == null) {
			this.socketViewController = socketViewController;
		}
	}

	public static ControllerMediator getInstance() {
		if (instance == null) {
			instance = new ControllerMediator();
		}
		return instance;
	}
}
