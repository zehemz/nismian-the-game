package com.bahoga.nismian.dialog;

public class DialogNode
{
    private final String text;
    private final String[] responses;
    private final String[] nextNodesKeys;

    public DialogNode(final String text, final String[] responses,
                      final String[] nextNodesKeys) throws Exception
    {
        this.text = text;
        this.responses = responses;

        //la cantidad de nextNodesKeys debe ser igual a la de responses
        if(responses.length != nextNodesKeys.length)
            throw new Exception("La cantidad de nextNodesKeys debe ser igual a la de responses");

        this.nextNodesKeys = nextNodesKeys;
    }

    public String getText()
    {
        return text;
    }

    public String[] getResponses()
    {
        return responses;
    }

    public String[] getNextNodesKeys()
    {
        return nextNodesKeys;
    }
}
