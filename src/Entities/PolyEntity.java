package Entities;

import importing.ImportManager;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class PolyEntity extends Entity {
	ArrayList<Entity> components;
	
	PolyEntity(int x, int y, int h, int w, double angel, String img, ArrayList<Entity> coms){
		super(x, y, h, w, angel, img);
		components = coms;
	}
	
	protected int[] translateBounds (int[] arrayOld, int x){
		int[] arrayNew = new int[arrayOld.length];
		for (int i = 0; i < arrayOld.length; i++){
			arrayNew[i] = arrayOld[i] + x;
		}
		
		return arrayNew;
	}
	
	
	@Override
	public abstract void tickAction(Object b);

	@Override
	public abstract void draw(Graphics g);
	
}
