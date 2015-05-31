package api.awt.menu;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;

public class MenuDemo {
	public static void main(String[] args) {
		/*
		 * [1] 컴포넌트 생성
		 * */
		Frame frame = new Frame("메모장");
		frame.setSize(500, 300);
		Toolkit toolkit = Toolkit.getDefaultToolkit(); // Toolkit 객체생성
		Dimension dimension = toolkit.getScreenSize(); // 화면크기
		
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");
		
		MenuItem itemNew = new MenuItem("New"); 
		MenuItem itemOpen = new MenuItem("Open");
		Menu subMenu = new Menu("Others");
		MenuItem itemExit = new MenuItem("Exit");
		
		MenuItem subMenuPrint = new MenuItem("Print");
		MenuItem subMenuPreview = new MenuItem("PrintPreview");
		MenuItem subMenuSetup = new MenuItem("PrintSetup");
		subMenu.add(subMenuPrint);
		subMenu.add(subMenuPreview);
		subMenu.add(subMenuSetup);
		
		Menu menuEdit = new Menu("Edit");
		Menu menuView = new Menu("View");
		Menu menuHelp = new Menu("Help");
		
		
		
		/*
		 * [2] 컴포넌트 결합
		 * */
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(subMenu);
		menuFile.addSeparator(); // 메뉴 분리선
		menuFile.add(itemExit);
		
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuView);
		menuBar.setHelpMenu(menuHelp);
		
		frame.setMenuBar(menuBar);
		
		/*
		 * [3] 컴포넌트 구체화
		 * */
		frame.setLocation(dimension.width/2, dimension.height/2); 
		// frame.setLocation(dimension.width/2-150, dimension.height/2-100);  
		// 화면을 가운데로 두는 소스
		frame.setVisible(true);
	}
}
