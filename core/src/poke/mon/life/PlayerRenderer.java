package poke.mon.life;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import poke.mon.constants.Constants;
import poke.mon.handlers.LifeHandler;
import poke.mon.handlers.MapHandler;

public class PlayerRenderer implements LifeHandler {

	private Texture texture;
	private int columns = 4, rows = 4;
	private TextureRegion[][] textureRegion;
	private TextureRegion[] frames;
	private TextureRegion currentFrame;
	private Animation animation;
	private String player;
	private Rectangle bounds;
	private int moveAnimation;
	private int currentDirection;
	private Vector2 targetPosition;
	private boolean isX = false;
	private boolean isY = false;
	private Vector2 position;
	private float speed = .01f;
	
	
	public PlayerRenderer(String player) {
		frames = new TextureRegion[rows * columns];
		targetPosition = new Vector2();
		position = new Vector2();
		this.player = player;
		try {
			texture = new Texture(Gdx.files.internal("players/" + this.player).toString());
		} catch (Exception e) {
			// new ExceptionHandler(this.getClass().getName(), e);
		}
		textureRegion = TextureRegion.split(texture, texture.getWidth() / columns, texture.getHeight() / rows);
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				frames[index++] = textureRegion[i][j];
			}
		}
		animation = new Animation(1, frames);
		animation.setPlayMode(PlayMode.NORMAL);
		currentFrame = animation.getKeyFrame(0, true);
		bounds = new Rectangle();
		position.set(0, 0);
		targetPosition.set(0, 0);
	}
	
	public void draw(Batch batch, MapHandler map) {
		movement();
		position.lerp(targetPosition, speed);
		System.out.println(targetPosition);
		map.getCamera().position.set(getX(), getY(), 0);
		map.getCamera().update();
		batch.setProjectionMatrix(map.getCamera().combined);
		currentFrame = animation.getKeyFrame(currentDirection + moveAnimation, true);
		batch.draw(currentFrame, getX(), getY());
	}
	
	@Override
	public void movement() {
			//System.out.println(position);
		if (hasTranslated()) {
			System.out.println("ASAAS");
			isX = false;
			isY = false;
		}
		if (Gdx.input.isKeyPressed(Keys.D)) {
			targetPosition.x = (float) Math.floor(position.x + Constants.units);
			currentDirection = MovementHandler.RIGHT.getDirection();
			isX = true;
		} else if (Gdx.input.isKeyPressed(Keys.A)) {
			targetPosition.x = (float) Math.floor(position.x - Constants.units);
			currentDirection = MovementHandler.LEFT.getDirection();
			isX = true;
		}		
	}

	/*
 	public void draw(Batch batch, float delta) {
		timer += delta;
		movement(delta);
		if (!targetPosition.equals(position)) {
			if (translatingX()) {
				position.set((float) (getX() + ((xOffset / Constants.pixel) * (Constants.pixel * 2)) * delta), getY());
				if (position.x > targetPosition.x && xOffset > 0) {
					position.x = targetPosition.x;
				}
				if (position.x < targetPosition.x && xOffset < 0) {
					position.x = targetPosition.x;
				}
			}
			if (translatingY()) {
				position.set(getX(), (float) (getY() + ((yOffset / Constants.pixel) * 1)));
			}
		}
		if (moveAnimation < 0 || moveAnimation > 3) {
			moveAnimation = 0;
		}
		map.getCamera().position.set(getX(), getY(), 0);
		map.getCamera().update();
		batch.setProjectionMatrix(map.getCamera().combined);
		currentFrame = animation.getKeyFrame(currentDirection + moveAnimation, true);
		batch.draw(currentFrame, getX(), getY());
	}
	
	@Override
	public void movement(float delta) {
		if (isTranslating()) {
		//	return;
		}
		if (hasTranslated()) {
			isX = false;
			isY = false;
			if (moveAnimation % 2 == 1) {
				moveAnimation++;
			}
		}
		xOffset = 0;
		yOffset = 0;
		if (timer < .5) {
			//return;
		}
		if (isIdleFrame()) {
			//System.out.println(timer);
			timer = 0;
			if (Gdx.input.isKeyPressed(Keys.W)) {
				currentDirection = Movement.goUp();
				yOffset += Constants.pixel;
				isY = true;
			//	moveAnimation++;
			} else if (Gdx.input.isKeyPressed(Keys.A)) {
				currentDirection = Movement.goLeft();
				xOffset -= Constants.pixel;
				isX = true;
				//moveAnimation++;
			}else if (Gdx.input.isKeyPressed(Keys.S)) {
				currentDirection = Movement.goDown();
				yOffset -= Constants.pixel;
				isY = true;
			//	moveAnimation++;
			} else if (Gdx.input.isKeyPressed(Keys.D)) {
				currentDirection = Movement.goRight();
				xOffset += Constants.pixel;
				isX = true;
				//moveAnimation++;
			}
			targetPosition.set(getX() + xOffset, getY() + yOffset);
		}
	}
*/
	
	
	@Override
	public boolean translatingX() {
		return isX && (targetPosition.x != getX());
	}

	@Override
	public boolean translatingY() {
		return isY && (targetPosition.y != getY());
	}

	@Override
	public boolean translatedX() {
		return isX && (targetPosition.x == getX());
	}

	@Override
	public boolean translatedY() {
		return isY && (targetPosition.y == getY());
	}

	@Override
	public boolean isIdleFrame() {
		return moveAnimation % 2 == 0;
	}

	@Override
	public boolean isTranslating() {
		return translatingX() || translatingY();
	}

	@Override
	public boolean hasTranslated() {
		return translatedX() || translatedY();
	}

	@Override
	public void setMoveAnimation(int moveAnimation) {
		this.moveAnimation = moveAnimation;
	}

	@Override
	public int getMoveAnimation() {
		return moveAnimation;
	}

	@Override
	public TextureRegion getLifeFrame() {
		return currentFrame;
	}

	@Override
	public boolean isFacingDown() {
		return currentDirection == MovementHandler.DOWN.getDirection();
	}

	@Override
	public boolean isFacingLeft() {
		return currentDirection == MovementHandler.LEFT.getDirection();
	}

	@Override
	public boolean isFacingRight() {
		return currentDirection == MovementHandler.RIGHT.getDirection();
	}

	@Override
	public boolean isFacingUp() {
		return currentDirection == MovementHandler.UP.getDirection();
	}

	@Override
	public void dispose() {
		texture.dispose();
	}

	@Override
	public Rectangle getBounds() {
		return bounds;
	}

	@Override
	public Texture getTexture() {
		return texture;
	}

	@Override
	public float getX() {
		return position.x;
	}

	@Override
	public float getY() {
		return position.y;
	}

	@Override
	public void setX(float x) {
		position.set(getX() + x, position.y);
	}

	@Override
	public void setY(float y) {
		position.set(position.x, getY() + y);
	}

	@Override
	public Vector2 getPosition() {
		return position;
	}
	
	@Override
	public Vector2 getTargetPosition() {
		return targetPosition;
	}

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
	}	
	
}