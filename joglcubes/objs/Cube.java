package joglcubes.objs;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.glu.GLUquadric;

public class Cube {
	private GL2 gl;
	private float rquad;
	private float[] tr, rot;
	public boolean rotate;
	private float[][] pos = { { -1f, -1f, 1f }, { 1f, -1f, 1f }, 
		{ -1f, -1f, -1f }, { 1f, -1f, -1f }, 
		{ -1f, 1f, 1f }, { 1f, 1f, 1f }, 
		{ -1f, 1f, -1f }, { 1f, 1f, -1f } }; // set the default pos of each vertex
	
	public Cube(boolean toggleRot) {
		rquad = 0.f;
		rotate = toggleRot;
	}
	
	public void init(GL2 newgl, float newv, float[] newt, float[] newr) {
		gl = newgl;
		if (newv>0) setPosVal(newv);
		tr = newt; // translation
		rot = newr; // rotation
	}
	
	// sets the pos. of each vertex by the given value
	/* { // front view 
	 { -1f, -1f, 1f }, // 0 top-left corner
	 { 1f, -1f, 1f }, // 1 top-right
	 { -1f, -1f, -1f }, // 2 bottom-left
	 { 1f, -1f, -1f }, // 3 bottom-right
	 // back view
	 { -1f, 1f, 1f }, // 4 top-left corner
	 { 1f, 1f, 1f }, // 5 top-right
	 { -1f, 1f, -1f }, // 6 bottom-left
	 { 1f, 1f, -1f } // 7 bottom-right
    };*/
	private void setPosVal(float val) {
		pos = new float[][] {
			{ -val, -val, val }, { val, -val, val },
	    	{ -val, -val, -val }, { val, -val, -val }, 
	    	{ -val, val, val }, { val, val, val }, 
	    	{ -val, val, -val }, { val, val, -val } };
	}
	
	// set a new pos. manually
	public void setPos(float[][] newpos) { pos = newpos; }
	
	public void Display() {
	    gl.glLoadIdentity();
//	    gl.glTranslatef( 0f, 0f, -5.0f ); 
	    gl.glTranslatef( tr[0], tr[1], tr[2] );

	    // Rotate The Cube On X, Y & Z
	    if (rotate)
	    	gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);
	    else
	    	gl.glRotatef( rot[0], rot[1], rot[2], rot[3] );
		
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Object
	    
	    // Front Face
		gl.glColor3f(1f,0f,0f); //red color
	    gl.glVertex3f(pos[0][0], pos[0][1], pos[0][2]); // bottom-left of the texture and quad	    
	    gl.glVertex3f(pos[1][0], pos[1][1], pos[1][2]);  // bottom-right of the texture and quad	    
	    gl.glVertex3f(pos[5][0], pos[5][1], pos[5][2]);   // top-right of the texture and quad   
	    gl.glVertex3f(pos[4][0], pos[4][1], pos[4][2]);  // top-left of the texture and quad
	    // Back Face
	    gl.glColor3f(0f,1f,0f); //green color
	    gl.glVertex3f(pos[2][0], pos[2][1], pos[2][2]);
	    gl.glVertex3f(pos[6][0], pos[6][1], pos[6][2]);
	    gl.glVertex3f(pos[7][0], pos[7][1], pos[7][2]);
	    gl.glVertex3f(pos[3][0], pos[3][1], pos[3][2]);
	    // Top Face
	    gl.glColor3f(0f,0f,1f); //blue color
	    gl.glVertex3f(pos[6][0], pos[6][1], pos[6][2]);
	    gl.glVertex3f(pos[4][0], pos[4][1], pos[4][2]);
	    gl.glVertex3f(pos[5][0], pos[5][1], pos[5][2]);
	    gl.glVertex3f(pos[7][0], pos[7][1], pos[7][2]);
	    // Bottom Face
	    gl.glColor3f(1f,1f,0f); //yellow red+green color
	    gl.glVertex3f(pos[2][0], pos[2][1], pos[2][2]);
	    gl.glVertex3f(pos[3][0], pos[3][1], pos[3][2]);
	    gl.glVertex3f(pos[1][0], pos[1][1], pos[1][2]);
	    gl.glVertex3f(pos[0][0], pos[0][1], pos[0][2]);
	    // Right face
	    gl.glColor3f(1f,0f,1f); //pink color
	    gl.glVertex3f(pos[3][0], pos[3][1], pos[3][2]);
	    gl.glVertex3f(pos[7][0], pos[7][1], pos[7][2]);
	    gl.glVertex3f(pos[5][0], pos[5][1], pos[5][2]);
	    gl.glVertex3f(pos[1][0], pos[1][1], pos[1][2]);
	    // Left Face
	    gl.glColor3f(1f,1f,1f); //white color
	    gl.glVertex3f(pos[2][0], pos[2][1], pos[2][2]);
	    gl.glVertex3f(pos[0][0], pos[0][1], pos[0][2]);
	    gl.glVertex3f(pos[4][0], pos[4][1], pos[4][2]);
	    gl.glVertex3f(pos[6][0], pos[6][1], pos[6][2]);
	    
	    gl.glEnd();
	      
	    if (rotate) rquad -= 0.2f;
	}
	
}
