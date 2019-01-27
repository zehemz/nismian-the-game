package com.bahoga.nismian.dialog;

import com.badlogic.gdx.Gdx;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class DialogLoader
{
    private DialogLoader()
    {
    }

    static public Dialog loadDialog(final String fileName)
    {
        //cargar el archivo e ir poblando el dialogo con nodos
        Dialog dialogo = new Dialog();

        Path path = Paths.get(fileName);

        if(Files.exists(path))
        {
            if(Files.isReadable(path))
            {
                Charset charset = Charset.forName("ISO-8859-1");

                try(BufferedReader reader = Files.newBufferedReader(path, charset))
                {
                    String key = null;
                    ArrayList<String> responses = new ArrayList<>();
                    ArrayList<String> indexes = new ArrayList<>();
                    StringBuilder textBuilder = new StringBuilder();

                    String line = null;

                    Pattern nodePattern = Pattern.compile("^(node)\\s.+"); //node key
                    Pattern responsePattern = Pattern.compile("^\\[.+|.+\\]$"); //[respuesta|nextKey]
                    Pattern textPattern = Pattern.compile("^:"); //:texto del dialogo
                    Pattern endNodePattern = Pattern.compile("^(===)");

                    while((line = reader.readLine()) != null)
                    {
                        if(nodePattern.matcher(line).find()) //principio de nodo
                        {
                            key = line.split(" ")[1];

                            textBuilder.setLength(0);
                            responses = new ArrayList<>();
                            indexes = new ArrayList<>();
                        }
                        else if(textPattern.matcher(line).find()) //texto de diálogo
                        {
                            textBuilder.append(line.substring(1));
                            textBuilder.append("\n");
                        }
                        else if(responsePattern.matcher(line).find()) //respuesta
                        {
                            responses.add(line.split("[\\[|\\]]")[1]);
                            indexes.add(line.split("[\\[|\\]]")[2]);
                        }
                        else if(endNodePattern.matcher(line).find())
                        {
                            try
                            {
                                DialogNode node = new DialogNode(textBuilder.toString(),
                                        responses.toArray(new String[responses.size()]),
                                        indexes.toArray(new String[indexes.size()]));

                                dialogo.add(node, key);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                Gdx.app.log("DIALOG", "File not readable");
            }
        }
        else
        {
            Gdx.app.log("DIALOG", "File not found");
        }
        return dialogo;
    }
}
