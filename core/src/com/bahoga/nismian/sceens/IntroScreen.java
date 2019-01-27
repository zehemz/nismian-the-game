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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.bahoga.nismian.Constants;
import com.bahoga.nismian.NismianGame;
import com.bahoga.nismian.UI;
import com.bahoga.nismian.dialog.Dialog;
import com.bahoga.nismian.dialog.DialogLoader;
import com.bahoga.nismian.dialog.DialogStage;

import java.util.Scanner;

public class IntroScreen extends ScreenAdapter
{
    private NismianGame game;

    private SpriteBatch batch;
    private Engine engine;

    private Viewport viewport;

    private Stage stage;
    private TextButton button;
    private Label titleLabel;
    private Label footerLabel;

    public IntroScreen(NismianGame game)
    {
        this.game = game;
        this.batch = game.batch;

        viewport = new FitViewport(Constants.INTRO_VIEWPORT_WIDTH,
                                    Constants.INTRO_VIEWPORT_HEIGHT,
                                    new OrthographicCamera());
        stage = new Stage(viewport, batch);

        Gdx.input.setInputProcessor(stage);

        final Skin skin = new Skin(Gdx.files.internal(UI.SKIN_URI.value));
        final BitmapFont titleFont = skin.getFont(UI.SKIN_TITLE_FONT.value);
        final BitmapFont textFont = skin.getFont(UI.SKIN_TEXT_FONT.value);

        final Table table = new Table();
        //table.setDebug(true);
        table.top();
        table.setFillParent(true);

        titleLabel = new Label("Nismian. The game.", new Label.LabelStyle(titleFont, Color.YELLOW));
        table.add(titleLabel).center().padTop(80);
        table.row();

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
        table.add(button).center().padTop(60);
        table.row();

        footerLabel = new Label("By Bahoga productions, your mom's favorite.", skin, "default");
        table.add(footerLabel).expandY().bottom().padBottom(10);

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
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        super.resize(width, height);
    }

    @Override
    public void dispose()
    {
        stage.dispose();
    }
}
