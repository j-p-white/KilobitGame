package KilobiteGame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingGameClass extends Applet implements Runnable,KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		setSize(800,480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame f = (Frame) this.getParent().getParent();
		f.setTitle("my practice title");
	}
	
	@Override
	public void start(){
		super.start();
		Thread t = new Thread(this);
		t.start();
	}
	
	@Override
	public void stop(){
		super.stop(); 
	}
	
	@Override
	public void destroy(){
		super.destroy();
	}

	@Override
	public void run() {
			while(true){
				repaint();
				try{
					Thread.sleep(17);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			break;
			
		case KeyEvent.VK_DOWN:
			break;	
			
		case KeyEvent.VK_LEFT:
			break;
			
		case KeyEvent.VK_RIGHT:
			break;
			
		case KeyEvent.VK_SPACE:
			break;	
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
