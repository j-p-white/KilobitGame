package KilobiteGame;

public class Robot {
private int centerX = 100;
private int centerY = 382;
private boolean jumped = false;

private int speedX =0; 
private int speedY =1;

public int getCenterX() {
	return centerX;
}

public void setCenterX(int centerX) {
	this.centerX = centerX;
}

public int getCenterY() {
	return centerY;
}

public void setCenterY(int centerY) {
	this.centerY = centerY;
}

public boolean isJumped() {
	return jumped;
}

public void setJumped(boolean jumped) {
	this.jumped = jumped;
}

public int getSpeedX() {
	return speedX;
}

public void setSpeedX(int speedX) {
	this.speedX = speedX;
}

public int getSpeedY() {
	return speedY;
}

public void setSpeedY(int speedY) {
	this.speedY = speedY;
}

public void update(){
	if(speedX <0){
		centerX += speedX;
	}else if(speedX ==0){
		System.out.println("dont scroll background");
	}else{
		if(centerX<=150){
			centerX += speedX;
		}
		else{
			System.out.println("scrolling");
		}
	}//end scrolling else
	if(centerY + speedY >=382){
		centerY = 382;
	}else{
		centerY = speedY;
	}
	
	if(jumped==true){
		speedY+=1;
		
		if(centerY+speedY >=382){
			centerY = 382;
			speedY = 0;
			jumped = false;
		}
	}
	//prevents going beyond zero
	if(centerX + speedX<=60){
		centerX = 61;
	}
}//end update

public void moveRight(){
	speedX = 6;
}
public void moveLeft(){
	speedX = -6;
}

public void stop(){
	speedX=0;
}
public void jump(){
	if(jumped == false){
		speedY = -15;
		jumped = true;
	}
}
}
