package poke.mon.life;

import poke.mon.constants.Constants;
import poke.mon.handlers.LifeHandler;
import poke.mon.handlers.MapHandler;
import poke.mon.handlers.MovementHandler.Movement;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class PlayerRenderer implements LifeHandler {

	private Texture texture;
	private int columns = 4, rows = 4;
	private TextureRegion[][] textureRegion;
	private TextureRegion[] frames = new TextureRegion[rows * columns];
	private TextureRegion currentFrame;
	private Animation animation;
	private String player;
	private MapHandler map;
	private Rectangle bounds;
	private CollisionDetection cd;
	private int moveAnimation;
	private int currentDirection;
	private Vector2 targetPosition = new Vector2();
	private boolean isX = false;
	private boolean isY = false;
	private float timer = 0;
	private Vector2 position = new Vector2();
	private int xOffset, yOffset;
	private boolean cannotMove = false;

	public PlayerRenderer(String player) {
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

	public void draw(Batch batch, float delta) {
		timer += delta;
		movement();
		if (!targetPosition.equals(position)) {
			if (translatingX()) {
				position.set((float) (getX() + ((xOffset / Constants.pixel) * 1)), getY());
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
		currentFrame = animation.getKeyFrame(currentDirection + moveAnimation,
				true);
		batch.draw(currentFrame, getX(), getY());
	}

	@Override
	public void movement() {
		/* TODO Fix the logic where if the player is
		// holding down the movement button, that it
		// will wait until the idle frame finishes
		// rendering and displays for a couple of
		// miliseconds before firing off the new render */
		if (isTranslating()) {
			cannotMove = true;
			return;
		}
		if (hasTranslated()) {
			isX = false;
			isY = false;
			if (moveAnimation % 2 == 1) {
				moveAnimation++;
			}
			System.out.println(timer);
		}
		if (cannotMove) {
			if (timer >= 1) {// .53)
				cannotMove = false;
			}
			// return;
		}
		xOffset = 0;
		yOffset = 0;
		timer = 0;
		if (isIdleFrame()) {
			if (Gdx.input.isKeyPressed(Keys.W)) {
				currentDirection = Movement.goUp();
				yOffset += Constants.pixel;
				isY = true;
				moveAnimation++;
			} else if (Gdx.input.isKeyPressed(Keys.A)) {
				currentDirection = Movement.goLeft();
				xOffset -= Constants.pixel;
				isX = true;
				moveAnimation++;
			} else if (Gdx.input.isKeyPressed(Keys.S)) {
				currentDirection = Movement.goDown();
				yOffset -= Constants.pixel;
				isY = true;
				moveAnimation++;
			} else if (Gdx.input.isKeyPressed(Keys.D)) {
				currentDirection = Movement.goRight();
				xOffset += Constants.pixel;
				isX = true;
				moveAnimation++;
			}
			targetPosition.set(getX() + xOffset, getY() + yOffset);
		}
	}

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
	public void setMap(MapHandler map) {
		this.map = map;
		cd = new CollisionDetection(this);
	}

	@Override
	public MapHandler getMap() {
		return map;
	}

	@Override
	public TextureRegion getLifeFrame() {
		return currentFrame;
	}

	@Override
	public boolean isFacingDown() {
		return currentDirection == Movement.goDown();
	}

	@Override
	public boolean isFacingLeft() {
		return currentDirection == Movement.goLeft();
	}

	@Override
	public boolean isFacingRight() {
		return currentDirection == Movement.goRight();
	}

	@Override
	public boolean isFacingUp() {
		return currentDirection == Movement.goUp();
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

	/*
	 * public void update(float delta) { float overflowX = 0, overflowY = 0; if
	 * (moving) { if (playerX != 0) { position.x += playerX * TILE_WIDTH *
	 * (delta / MOVE_TIME); if ((playerX < 0 && position.x <= targetPosition.x)
	 * || (playerX > 0 && position.x >= targetPosition.x)) { moving = false;
	 * overflowX = playerX - targetPosition.x; } } else if (playerY != 0) {
	 * position.y += playerY * TILE_HEIGHT * (delta / MOVE_TIME); if ((playerY <
	 * 0 && position.y <= targetPosition.y) || (playerY > 0 && position.y >=
	 * targetPosition.y)) { moving = false; overflowY = playerY -
	 * targetPosition.y; } } System.out.println(position + "Overflow: " +
	 * overflowX + "Target Position: " + targetPosition); }
	 * 
	 * if (!moving) { playerX = Gdx.input.isKeyPressed(Keys.A) ? -1 :
	 * (Gdx.input.isKeyPressed(Keys.D) ? 1 : 0); playerY = playerX != 0 ? 0 :
	 * (Gdx.input.isKeyPressed(Keys.W) ? 1 : (Gdx.input.isKeyPressed(Keys.S) ?
	 * -1 : 0));
	 * 
	 * if (playerX != 0 || playerY != 0) { moving = true; targetPosition.x =
	 * position.x + (playerX * TILE_WIDTH); targetPosition.y = position.y +
	 * playerY * TILE_HEIGHT;
	 * 
	 * if (overflowX != 0 && targetPosition.x != position.x) { if
	 * (Math.abs(overflowX) > 0.001f) { update(delta * (overflowX / (TILE_WIDTH
	 * * (delta / MOVE_TIME)))); } } else if (overflowY != 0 && targetPosition.y
	 * != position.y) { if (Math.abs(overflowY) > 0.001f) { update(delta *
	 * (overflowY / (TILE_HEIGHT * (delta / MOVE_TIME)))); } } } } }
	 */

}