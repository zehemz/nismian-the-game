package com.bahoga.nismian.dialog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dialog
{
    private Map<String, DialogNode> nodes;
    private DialogNode currentNode;

    public Dialog()
    {
        nodes = new HashMap<>();
    }

    public void add(final DialogNode node, final String key)
    {
        if(nodes.size() == 0)
            currentNode = node;

        nodes.put(key, node);
    }

    public String[] getResponses()
    {
        if(currentNode != null)
            return currentNode.getResponses();

        return null;
    }

    public String getText()
    {
        if(currentNode != null)
            return currentNode.getText();

        return null;
    }

    public String respond(final int index)
    {
        if(index < currentNode.getResponses().length)
        {
            currentNode = nodes.get(currentNode.getNextNodesKeys()[index]);
            return currentNode.getText();
        }

        return "That response is not available.";
    }

    public boolean hasNext()
    {
        return currentNode.getNextNodesKeys().length > 0;
    }
}
