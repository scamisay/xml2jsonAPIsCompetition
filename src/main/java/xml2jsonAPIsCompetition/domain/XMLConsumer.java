package xml2jsonAPIsCompetition.domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by scamisay on 03/10/16.
 */
public class XMLConsumer {

    private List<String> fileNames;
    private Iterator<String> it;
    private String current;

    public XMLConsumer() {
        try {
            fileNames = Files.list(Paths.get("src/main/resources/xmlFiles"))
                    .filter(Files::isRegularFile)
                    .map(path -> path.toString())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("No pude leer la carpeta ");
        }
    }

    public void start(){
        it = fileNames.iterator();
    }

    public boolean hasNext() {
        return it.hasNext();
    }

    public String getCurrent() {
        return current;
    }

    public String next() {
        String filePath = null;
        try{
            filePath = it.next();
            current = filePath;
        }catch (Exception e){
            throw new RuntimeException("Problemas con el Iterator");
        }

        String content = null;
        try{
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        }catch (Exception e){
            throw new RuntimeException("No se pudo leer " + filePath);
        }
        return content;
    }
}
