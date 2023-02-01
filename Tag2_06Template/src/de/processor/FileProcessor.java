package de.processor;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    private List<CharacterHandler> handlers = new ArrayList<>();

    public void addCharacterHandler(CharacterHandler handler) {
        handlers.add(handler);
    }
    public void removeCharacterHandler(CharacterHandler handler) {
        handlers.remove(handler);
    }
    public final void run(String filename) {

        try(FileReader reader = new FileReader(Thread.currentThread().getContextClassLoader().getResource(filename).getFile())) {
            init();
            int c;
            while((c = reader.read()) != -1) {
                process((char) c);
            }
           dispose();;

        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    private void init() {
        handlers.forEach(CharacterHandler::init);
    }

    private void process(final char c){
        handlers.forEach(h->h.process(c));
    }

    private void dispose() {
        handlers.forEach(CharacterHandler::dispose);
    }
}
