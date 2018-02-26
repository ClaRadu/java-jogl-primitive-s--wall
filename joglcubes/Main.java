package joglcubes;

import java.awt.Dimension;
import java.awt.DisplayMode;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.*;
import com.jogamp.opengl.glu.GLUquadric;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.awt.GLCanvas;

import javax.swing.JFrame;

import joglcubes.objs.*;


public class Main implements GLEventListener {
   private static final int CANVAS_WIDTH = 640;  // width of the drawable
   private static final int CANVAS_HEIGHT = 480; // height of the drawable
   private static final int FPS = 300; // animator's target frames per second

   public static DisplayMode dm, dm_old;
   private GLU glu = new GLU();
   
   Wall wall;
//   Cube cube;
   Text txt;
      
   @Override
   public void display( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
     
      // show object(s)
      wall.Display();
//      cube.Display();
      // show text
      txt.Display();

   }
   
   @Override
   public void dispose( GLAutoDrawable drawable ) {
      // TODO Auto-generated method stub
   }
   
   @Override
   public void init( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      gl.glShadeModel( GL2.GL_SMOOTH );
      gl.glClearColor( 0f, 0f, 0f, 0f );
      gl.glClearDepth( 1.0f );
      gl.glEnable( GL2.GL_DEPTH_TEST );
      gl.glDepthFunc( GL2.GL_LEQUAL );
      gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
      
	  // create object(s)
/*      float[] tr = { 0f, 0f, -5f }; // translation
      float[] rot = { -75.f, 1f, 0f, 0f }; // rotation
      cube = new Cube(true);
      cube.init(gl, .5f, tr, rot);*/
      // add wall of cubes
      wall = new Wall(.5f, -5f, gl, false);      
      // add text
      txt = new Text(drawable);
   }
      
   @Override
   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      if( height <= 0 )
         height = 1;
			
      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      gl.glMatrixMode( GL2.GL_PROJECTION );
      gl.glLoadIdentity();
		
      glu.gluPerspective( 70.0f, h, 1.0, 20.0 );
      gl.glMatrixMode( GL2.GL_MODELVIEW );
      gl.glLoadIdentity();
   }
      
   public static void main( String[] args ) {
	
      final GLProfile profile = GLProfile.get( GLProfile.GL2 );
      GLCapabilities capabilities = new GLCapabilities( profile );
      
      // The canvas
      final GLCanvas glcanvas = new GLCanvas( capabilities );
      glcanvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      
      Main mn = new Main();
		
      glcanvas.addGLEventListener( mn );
      glcanvas.setFocusable(true);
      glcanvas.requestFocus();
		
      final JFrame frame = new JFrame ( " Primitive(s) Wall - CRG" );
      frame.getContentPane().add( glcanvas );
      frame.setSize( frame.getContentPane().getPreferredSize() );
      frame.setVisible(true);

      final FPSAnimator animator = new FPSAnimator(glcanvas, FPS, true);
      animator.start();
   }
	
}
