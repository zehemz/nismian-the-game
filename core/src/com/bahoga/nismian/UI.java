package com.bahoga.nismian;

public enum UI
{
    SKIN_URI ("skins/craftacular/craftacular-ui.json"),
    SKIN_TITLE_FONT ("title"), //sacado del json del skin
    SKIN_TEXT_FONT ("font") //sacado del json del skin
    ;

    public final String value;

    UI(final String value)
    {
        this.value = value;
    }
}
