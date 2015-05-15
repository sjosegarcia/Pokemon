package poke.mon.handlers;

public enum MovementHandler {

	DOWN(0),
	LEFT(4),
	RIGHT(8),
	UP(12);
	
	private int direction;
	
	private MovementHandler(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public static class Movement {
		
		public static int goDown() {
			return MovementHandler.DOWN.getDirection();
		}
		
		public static int goLeft() {
			return MovementHandler.LEFT.getDirection();
		}
		
		public static int goRight() {
			return MovementHandler.RIGHT.getDirection();
		}
		
		public static int goUp() {
			return MovementHandler.UP.getDirection();
		}
		
	}
	
}
