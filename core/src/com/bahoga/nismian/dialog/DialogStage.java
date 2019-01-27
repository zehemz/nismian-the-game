package com.bahoga.nismian.dialog;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.bahoga.nismian.UI;

public class DialogStage extends Stage
{
    private boolean visibility = false;
    private TextArea textArea;

    private Dialog dialog;

    public DialogStage()
    {
        final Skin skin = new Skin(Gdx.files.internal(UI.SKIN_URI.value));
        final BitmapFont textFont = skin.getFont(UI.SKIN_TEXT_FONT.value);

        TextField.TextFieldStyle textFieldStyle;
        textFieldStyle = skin.get("default", TextField.TextFieldStyle.class);
        textFieldStyle.fontColor = Color.RED;
        textFieldStyle.background = null;
        textFieldStyle.cursor = skin.newDrawable("cursor", Color.RED);
        textFieldStyle.cursor.setMinWidth(2f);

        float width = getWidth();

        Image image = new Image(new Texture("dialogs/dialog_box.png"));
        textArea = new TextArea("", textFieldStyle);
        textArea.setWidth(500);
        textArea.setHeight(200);

        image.setPosition(width/2 - image.getWidth()/2, 0);
        textArea.setPosition(width/2 - image.getWidth()/2 + 35, 30);

        addActor(image);
        addActor(textArea);
    }

    @Override
    public boolean keyDown(int keyCode)
    {
        if(keyCode == Input.Keys.UP)
        {
            textArea.moveCursorLine(textArea.getFirstLineShowing()-1);
            return true;
        }
        if(keyCode == Input.Keys.DOWN)
        {
            textArea.moveCursorLine(textArea.getFirstLineShowing()+
                                    textArea.getLinesShowing());
            return true;
        }
        if(Input.Keys.NUM_0 <= keyCode && keyCode <= Input.Keys.NUM_9)
        {
            appendText(Input.Keys.toString(keyCode));
            return true;
        }
        if(keyCode == Input.Keys.ENTER)
        {
            String entrada = textArea.getText();
            String opcion = entrada.substring(entrada.length()-1);
            chooseResponse(opcion);
            return true;
        }
        return false;
    }

    private void chooseResponse(final String opcion)
    {
        int response = Integer.parseInt(opcion) - 1; // menos uno porque las opciones
                                //se muestran 1-based pero el array es 0-based

        dialog.respond(response);
        showNode();
    }

    @Override
    public void draw()
    {
        act(Gdx.graphics.getDeltaTime());

        if(visibility)
        {
            super.draw();
        }
    }

    public void runDialog()
    {
        if(dialog != null)
        {
            setVisibility(true);
            showNode();
        }
    }

    private void showNode()
    {
        StringBuilder builder = new StringBuilder(dialog.getText());

        for(int i=0; i<dialog.getResponses().length; i++)
        {
            builder.append("\n");
            builder.append((i+1));
            builder.append(" ");
            builder.append(dialog.getResponses()[i]);
        }
        builder.append("\n");
        setText(builder.toString());
    }

    private void appendText(final String response)
    {
        textArea.appendText(response);
    }

    public void setDialog(final Dialog dialog)
    {
        this.dialog = dialog;
    }

    public void setText(final String text)
    {
        textArea.setText(text);
    }

    public void setVisibility(final boolean visible)
    {
        this.visibility = visible;
    }
}
