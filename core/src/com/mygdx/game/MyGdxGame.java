package com.mygdx.game;

import ExternalLib.GifDecoder;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;


public class MyGdxGame extends ApplicationAdapter {
  SpriteBatch batch;
  Animation<TextureRegion> animation;
  ShapeRenderer shape;
  Color color;
  float elapsed;
  float x;
  float y;
  
  
  @Override
  public void create () {
      batch = new SpriteBatch();
      animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Ghost's/Blue-Ghost/Blue-Ghost_avatar_left.gif").read());
      shape = new ShapeRenderer();
      
      x = 10;
      y = 0;
      
    
  }

  public void update() {
	  
      if(Gdx.input.isKeyPressed(Keys.D )){
          animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Ghost's/Blue-Ghost/Blue-Ghost_avatar_right.gif").read());
          x += 3.5;
      }
      if(Gdx.input.isKeyPressed(Keys.A)){
          animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Ghost's/Blue-Ghost/Blue-Ghost_avatar_left.gif").read());
          x -= 3.5;
      }
      if(Gdx.input.isKeyPressed(Keys.W)) {
    	  y += 3.5;
          animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Ghost's/Blue-Ghost/Blue-Ghost_avatar_up.gif").read());
      }
      if(Gdx.input.isKeyPressed(Keys.S)) {
    	  y -= 3.5;
          animation = GifDecoder.loadGIFAnimation(Animation.PlayMode.LOOP, Gdx.files.internal("Ghost's/Blue-Ghost/Blue-Ghost_avatar_down.gif").read());
      }
  }
  
  @Override
  public void render () {
	  update();
	  
      elapsed += Gdx.graphics.getDeltaTime();
      Gdx.gl.glClearColor(0, 0, 0, 1);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      
      
      batch.begin();
      batch.draw(animation.getKeyFrame(elapsed), x, y);
      batch.end();
      
	  
  }

  @Override
  public void dispose () {
      batch.dispose();
      shape.dispose();
  }
}	