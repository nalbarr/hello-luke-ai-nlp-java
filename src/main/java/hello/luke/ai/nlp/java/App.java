package hello.luke.ai.nlp.java;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public String foo() {
        return "Hello World.";
    }

    public void logFoo() {
        logger.info(foo());
    }

    public void simpleStanfordNLP() {
         // creates a StanfordCoreNLP object, with POS tagging, lemmatization,
        // NER, parsing, and coreference resolution
        Properties props = new Properties();

        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        // read some text in the text variable
        String text = "She went to America last week.";

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

        //System.out.println( "End of Processing" );
        logger.info("End of Processing");
    }

    public static void main(String[] args) {
        logger.info("*** main() enter.");
        App app = new App();
        app.logFoo();
        app.simpleStanfordNLP();
    }
}