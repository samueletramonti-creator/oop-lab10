package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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
    public ReadFromFile() throws FileNotFoundException, IOException{
        final var file = new FileInputStream(FILE_PATH);
        this.input = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
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
        final var lines = this.input.lines().toList();
        if (lines.isEmpty()) {
            throw new IOException("File not found");
        }
        int i = 0;
        for (String line : lines) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                st.nextToken();
                if (i == 0) {
                    this.min = Integer.parseInt(st.nextToken());
                } else if (i == 1) {
                    this.max = Integer.parseInt(st.nextToken());
                } else {
                    this.attempts = Integer.parseInt(st.nextToken());
                }
                i++;
            }
        }
        
    }
}
