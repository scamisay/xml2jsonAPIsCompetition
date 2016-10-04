package xml2jsonAPIsCompetition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import xml2jsonAPIsCompetition.domain.XMLConsumer;
import xml2jsonAPIsCompetition.domain.XMLProcessor;
import xml2jsonAPIsCompetition.domain.XMLProcessor_orgJson;

@SpringBootApplication
public class Xml2jsonApIsCompetitionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Xml2jsonApIsCompetitionApplication.class, args);

		XMLConsumer consumer = new XMLConsumer();

		XMLProcessor processor = new XMLProcessor_orgJson(consumer);
		processor.processAllFiles();
	}
}
