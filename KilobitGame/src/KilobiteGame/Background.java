package KilobiteGame;

public class Background {
	private int bgX,bgY,speedX;
	
	// setting background variables
	public Background(int x,int y){
		bgX = x;
		bgY = y;
		speedX = 0;
	}
	
	//constatnt repeating background
	//1,2,1,2,1,2,....for a while
	public void update(){
		bgX +=speedX; 
		
		if(bgX <=-2160){
			bgX +=4320;
		}
	}//end update

	
	public int getBgX() {
		return bgX;
	}

	public void setBgX(int bgX) {
		this.bgX = bgX;
	}

	public int getBgY() {
		return bgY;
	}

	public void setBgY(int bgY) {
		this.bgY = bgY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	
}//end class
