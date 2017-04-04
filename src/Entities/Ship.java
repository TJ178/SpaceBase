package Entities;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import importing.ImportManager;


public class Ship extends PolyEntity {
	//ArrayList<ShipModule> components;
	
	public Ship(int x, int y, int h, int w, double angel){
		super(x, y, h, w, angel, "tomShip", null);
		int[] shipX = {0,115,115,275,275,385,385,310,310,80,80,0};
		int[] shipY = {100,100,35,35,100,100,340,340,490,490,345,345};
		int[] EngineRx = {300,385,385,300};
		int[] EngineLx = {0,85,85,0};
		int[] EngineLRy = {100,100,340,340};
		int[] cockpitX = {115,275,275,115};
		int[] cockpitY = {35,35,100,100};
		int[] storageX = {115,275,275,115};
		int[] storageY = {100,100,315,315};
		int[] mainEngineX = {80,310,310,80};
		int[] mainEngineY = {315,315,490,490};
		
		
		components = new ArrayList<Entity>();
		this.setBounds(new Polygon(translateBounds(shipX,x),translateBounds(shipY,y),shipX.length));
		components.add(new ShipModule(new Polygon(translateBounds(EngineRx,x),translateBounds(EngineLRy,y),EngineRx.length), "EngineR"));
		components.add(new ShipModule(new Polygon(translateBounds(EngineLx,x),translateBounds(EngineLRy,y),EngineLRy.length), "EngineL"));
		components.add(new ShipModule(new Polygon(translateBounds(cockpitX,x), translateBounds(cockpitY,y), cockpitX.length), "Cockpit"));
		components.add(new ShipModule(new Polygon(translateBounds(storageX,x), translateBounds(storageY,y), storageX.length), "Storage"));
		components.add(new ShipModule(new Polygon(translateBounds(mainEngineX,x), translateBounds(mainEngineY,y), mainEngineX.length), "MainEngine"));
	}

	@Override
	public void tickAction(Object b) {
		Integer[] is = ((Integer[])b);
		//xCoord = is[0];
		//yCoord = is[1];
		
	}
	public void draw(Graphics g){
		g.drawImage(ImportManager.getImage(image), xCoord, yCoord, height, width, null);
	}

	@Override
	public void whenClicked(int x, int y) {
		boolean done = false;
		int i = 0;
		while(!done && i < components.size()){
			if(components.get(i).checkBounds(x,y)){
				done = true;
			}
			else
				i++;
		}
		//if(bounds.contains(x, y))
		//	System.out.print("yay");
		
	}


}
