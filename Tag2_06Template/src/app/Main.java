package app;

import de.processor.CharacterCounter;
import de.processor.FileProcessor;
import de.processor.LineCounter;

public class Main {
    public static void main(String[] args) {


        FileProcessor fileProcessor = new FileProcessor();
        fileProcessor.addCharacterHandler(new CharacterCounter());
        fileProcessor.addCharacterHandler(new LineCounter());
        fileProcessor.run("StorGroupPolicy.log");
    }
}