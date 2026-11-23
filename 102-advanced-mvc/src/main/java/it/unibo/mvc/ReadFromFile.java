package it.unibo.mvc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class ReadFromFile {
    private static final String FILE_PATH = "src/main/resources/config.yml";
    private final BufferedReader input;
    private int max;
    private int min;
    private int attempts;

    /**
     * Constructor for the access at file.
     * 
     * @throws FileNotFoundException
     */
    public ReadFromFile() throws FileNotFoundException{
        final var file = new FileInputStream(FILE_PATH);
        this.input = new BufferedReader(new InputStreamReader(file));
        this.setValues();
    }

    /**
     * Method to get the max.
     * 
     * @return the maximum value
     */
    public int getMax() {
        return this.max;
    }

    /**
     * Method to get the min.
     * 
     * @return the minimum value
     */
    public int getMin() {
        return this.min;
    }

    /**
     * Method to get attempt.
     * 
     * @return the attempt value
     */
    public int getAttempt() {
        return this.attempts;
    }

    /**
     * Method to read the file.
     * 
     * @throws IOException
     */
    private void setValues() throws IOException{
        final var lines = this.input.readAllLines();
        final StringTokenizer st = new StringTokenizer(lines);
    }
}
