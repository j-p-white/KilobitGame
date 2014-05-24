package KilobiteGame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.net.URL;

public class StartingGameClass extends Applet implements Runnable,KeyListener{
	private Robot robot;
	private Image image,character;
	private URL base;
	private Graphics second;
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		setSize(800,480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame f = (Frame) this.getParent().getParent();
		f.setTitle("my practice title");
		try{
			base = getDocumentBase();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		character = getImage(base,"data/character.png");
	}
	
	@Override
	public void start(){
		super.start();
		robot = new Robot();
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
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			System.out.println("stop moving up");
			break;
			
		case KeyEvent.VK_DOWN:
			System.out.println("stop moving down");
			break;
			
		case KeyEvent.VK_LEFT:
			System.out.println("stop moving left");
			break;
			
		case KeyEvent.VK_RIGHT:
			System.out.println("stop moving right");
			break;
			
		case KeyEvent.VK_SPACE:
			System.out.println("stop Jumping");
			break;	
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Graphics g){
		if(image==null){
			image = createImage(this.getWidth(),this.getHeight());
			second = image.getGraphics();
		}
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);
		
		
		g.drawImage(image,0,0,this);
	}
	
	public void paint(Graphics g){
		 	g.drawImage(character, robot.getCenterX() -61, robot.getCenterY() -63, this);
	}
	
}
