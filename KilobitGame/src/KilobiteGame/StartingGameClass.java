package KilobiteGame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;

public class StartingGameClass extends Applet implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		setSize(800,480);
		setBackground(Color.BLACK);
		setFocusable(true);
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
	
}
