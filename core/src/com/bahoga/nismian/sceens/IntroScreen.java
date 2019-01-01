package com.bahoga.nismian.sceens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bahoga.nismian.Constants;
import com.bahoga.nismian.NismianGame;

public class IntroScreen extends ScreenAdapter
{
    private NismianGame game;

    private SpriteBatch batch;
    private Engine engine;

    private Viewport viewport;

    private Stage stage;
    private TextButton button;
    private Label label;

    public IntroScreen(NismianGame game)
    {
        this.game = game;
        this.batch = game.batch;

        viewport = new FitViewport(400, 320,
                new OrthographicCamera());
        stage = new Stage(viewport, batch);

        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        //Skin skin = new Skin(Gdx.files.internal("skins/craftacular/craftacular-ui.json"));
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = new BitmapFont();
        button = new TextButton("Play", skin);
        button.addListener(new ChangeListener()
        {
            @Override
            public void changed(ChangeEvent event, Actor actor)
            {
                switchToPlayScreen();
            }

            private void switchToPlayScreen()
            {
                game.switchToPlayScreen();
            }
        });
        table.add(button).expandX().padTop(10);

        label = new Label("Soy una label", new Label.LabelStyle(new BitmapFont(), Color.YELLOW));
        table.add(label).expandX().padTop(10);

        stage.addActor(table);
    }

    @Override
    public void show()
    {
        super.show();
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        //stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        super.resize(width, height);
    }

}
