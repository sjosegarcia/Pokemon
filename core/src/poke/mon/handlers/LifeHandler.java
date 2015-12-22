package poke.mon.handlers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface LifeHandler {
	
	public void draw(Batch batch, MapHandler map);
	public TextureRegion getLifeFrame();
	public void movement();
	public void dispose();
	public Rectangle getBounds();
	public Texture getTexture();
	public boolean isFacingDown();
	public boolean isFacingLeft();
	public boolean isFacingRight();
	public boolean isFacingUp();
	public boolean translatedX();
	public boolean translatedY();
	public boolean isIdleFrame();
	public boolean hasTranslated();
	public boolean translatingX();
	public boolean isTranslating();
	public boolean translatingY();
	public void setMoveAnimation(int moveAnimation);
	public int getMoveAnimation();
	public float getX();
	public float getY();
	public void setX(float x);
	public void setY(float y);
	public Vector2 getPosition();
	public Vector2 getTargetPosition();
}