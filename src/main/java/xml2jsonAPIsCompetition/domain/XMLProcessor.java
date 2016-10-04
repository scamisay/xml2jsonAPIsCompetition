package xml2jsonAPIsCompetition.domain;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by scamisay on 03/10/16.
 */
public abstract class XMLProcessor {

    protected XMLConsumer consumer;

    protected List<String> failureList = new ArrayList<>();

    public XMLProcessor(XMLConsumer consumer) {
        this.consumer = consumer;
    }

    public void processAllFiles(){
        consumer.start();

        while (consumer.hasNext()){
            try{
                processXML(consumer.next());
            }catch (Exception e){
                failureList.add(consumer.getCurrent());
            }

        }

        printResults();
    }

    private void printResults() {
        System.out.println("Resultados con "+getAPIName()+":");
        if(failureList.isEmpty()){
            System.out.println("Todos los XMLs fueron convertidos exitosamente!");
        }else{
            failureList.forEach( error -> System.out.println(error));
        }
    }

    protected abstract String getAPIName();


    protected abstract void processXML(String xmlFile);
}
