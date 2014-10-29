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
	private Heliboy hb1,hb2;
	private Image currentSprite,image,character,characterDown,characterJumped,background,heliboy;
	private URL base;
	private Graphics second;
	private static Background bg1,bg2;
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
		//set the charecter image
		character = getImage(base,"data/character.png");
		characterDown = getImage(base,"data/down.png");
		characterJumped = getImage(base,"data/jumped.png");
		currentSprite = character;
		background = getImage(base,"data/background.png");
	}
	
	@Override
	public void start(){
		super.start();
		hb1 = new Heliboy(340,360);
		hb2 = new Heliboy(700,360);
		bg1 = new Background(0,0);
		bg2 = new Background(2160,0);
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
				robot.update();
				if(robot.isJumped()){
					currentSprite = characterJumped;
				}else if(robot.isJumped()==false&&robot.isDucked()==false){
					currentSprite = character;
				}
				hb1.update();
				hb2.update();
				bg1.update();
				bg2.update();
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
			currentSprite = characterDown;
			if(robot.isJumped() == false){
				robot.setDucked(true);
				robot.setSpeedX(0);
			}
			break;	
			
		case KeyEvent.VK_LEFT:
			robot.moveLeft();
			robot.setMovingLeft(true);
			break;
			
		case KeyEvent.VK_RIGHT:
			robot.moveRight();
			robot.setMovingRight(true);
			break;
			
		case KeyEvent.VK_SPACE:
			robot.jump();
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
			currentSprite = character;
			robot.setDucked(false);
			break;
			
		case KeyEvent.VK_LEFT:
			robot.stopLeft();
			break;
			
		case KeyEvent.VK_RIGHT:
			robot.stopRight();
			break;
			
		case KeyEvent.VK_SPACE:
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
	
	//this lines are painted in their order, right now char is on the ground
	public void paint(Graphics g){
		 	g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
		 	g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
			g.drawImage(currentSprite, robot.getCenterX() -61, robot.getCenterY() -63, this);
			g.drawImage(heliboy, hb1.getCenterX()-48, hb1.getCenterY()-48, this);
			g.drawImage(heliboy, hb2.getCenterX()-48, hb2.getCenterY()-48, this);
	}
	
	public static Background getBg1(){
		return bg1;
	}
	
	public static Background getBg2(){
		return bg2;
	}
}
