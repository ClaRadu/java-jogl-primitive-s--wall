package joglcubes.objs;

import com.jogamp.opengl.GL2;

public class Wall {
	private Cube[] cubes;
	private Cube cube;
	private float[][] tr;
	float[] rot, tr1;
	private int no=15;
	
	public Wall(float dim, float z, GL2 gl, boolean rotate) { // constructor
		cubes = new Cube[no];
		init(dim, z);
		for (int i=0; i<no; i++) {
			cubes[i] = new Cube(rotate);
			cubes[i].init(gl, dim, tr[i], rot);
		}
	}
	
	// init array contaning translation vectors
	private void init(float dim, float z) {
		// calc initial values
		float offset = dim*0.2f;
		float len = dim*2f;
		
		tr = new float[no][];
		rot = new float[] { -75.f, 1f, 0f, 0f };
		
		// first, init array
		for (int i=0; i<no; i++) tr[i] = new float[] { 0f, 0f, z };
		
		// now add the correct positions with offsets, so the wall looks right
		// x
		tr[0][0] = -len*2-offset*3;
		tr[4][0] = -tr[0][0];
		tr[5][0] = -len*2-offset*2;
		tr[9][0] = -tr[5][0];
		tr[10][0] = -len*2-offset;
		tr[14][0] = -tr[10][0];
		tr[1][0] = -len-offset*2;
		tr[6][0] = len+offset;
		tr[11][0] = -len-offset/2;
		tr[3][0] = -tr[1][0];
		tr[8][0] = -tr[6][0];
		tr[13][0] = -tr[11][0];
		
		// y
		for (int i=0; i<no; i++) {
			if (isbetween(i, 0, 4)) tr[i][1] = len+offset;
//			if (isbetween(i, 5, 9)) tr[i][1] = 0f;
			if (isbetween(i, 10, 14)) tr[i][1] = -len;
//			System.out.println("x="+tr[i][0]+" y="+tr[i][1]+" z="+tr[i][2]);
		}
	}
	
	public void Display() { 
		for (int i=0; i<no; i++)
			cubes[i].Display();
	}
	
	// checks if value is between given range
	private boolean isbetween(int val, int low, int hi) { return val >= low && val <= hi; }

}
