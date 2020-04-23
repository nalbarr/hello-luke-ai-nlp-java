package hello.luke.ai.nlp.java;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import edu.stanford.nlp.pipeline.Annotation;
//import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import java.io.InputStream;
import java.io.FileInputStream;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public String foo() {
        return "Hello World.";
    }

    public void logFoo() {
        logger.info(foo());
    }

    /*
    public void simpleStanfordNLP() {
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization,
        // NER, parsing, and coreference resolution
        // read some text in the text variable
        // create an empty Annotation just with the given text
        // run all Annotators on this text
        Properties props = new Properties();

        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");

        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

        String text = "She went to America last week.";

        Annotation document = new Annotation(text);

        pipeline.annotate(document);

        logger.info("End of Processing");
    }
    */

    public void simpleOpenNLP() {
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String sentence = "Donald Trump is president.";
        String tokens[] = tokenizer.tokenize(sentence);
        for (int i=0; i < tokens.length; i++) {
            logger.info(String.format("%d: %s", i, tokens[i]));
        }
    }

    public void mediumOpenNLP() {
        try {
            InputStream inputStream = new FileInputStream("en-token.bin"); 
            TokenizerModel model = new TokenizerModel(inputStream);
            TokenizerME tokenizer = new TokenizerME(model);
            String tokens[] = tokenizer.tokenize("Mr. Barack Obama was president.");
            for (int i=0; i < tokens.length; i++) {
                logger.info(String.format("%d: %s", i, tokens[i]));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }    

    public static void main(String[] args) {
        logger.info("*** main() enter.");
        App app = new App();
        app.logFoo();
        //app.simpleStanfordNLP();
        app.simpleOpenNLP();
        app.mediumOpenNLP();
    }
}
