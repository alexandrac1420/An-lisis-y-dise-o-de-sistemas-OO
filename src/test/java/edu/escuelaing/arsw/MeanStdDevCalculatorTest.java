package edu.escuelaing.arsw;

import junit.framework.TestCase;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.IOException;

public class MeanStdDevCalculatorTest extends TestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    protected void setUp() throws IOException {
        System.setOut(new PrintStream(outContent));
    }

    protected void tearDown() {
        System.setOut(originalOut);
        outContent.reset();
    }

    public void testMultipleTables() {
        String[] args = {"src/test/java/edu/escuelaing/arsw/resources/multiple_tables.txt"};
        MeanStdDevCalculator.main(args);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Tabla 1:"));
        assertTrue(output.contains("Media: 550,60"));
        assertTrue(output.contains("Desviación Estándar: 572,03"));
        assertTrue(output.contains("Tabla 2:"));
        assertTrue(output.contains("Media: 60,32"));
        assertTrue(output.contains("Desviación Estándar: 62,26"));
        assertTrue(output.contains("Tabla 3:"));
        assertTrue(output.contains("Media: 1,10"));
        assertTrue(output.contains("Desviación Estándar: 0,00"));
        assertTrue(output.contains("Tabla 4:"));
        assertTrue(output.contains("Media: 100,00"));
        assertTrue(output.contains("Desviación Estándar: NaN"));
    }

    public void testEmptyFile() {
        String[] args = {"src/test/java/edu/escuelaing/arsw/resources/empty_file.txt"};
        MeanStdDevCalculator.main(args);
        String output = outContent.toString().trim();
        assertEquals("", output);
    }

    public void testSingleValue() {
        String[] args = {"src/test/java/edu/escuelaing/arsw/resources/single_value.txt"};
        MeanStdDevCalculator.main(args);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Tabla 1:"));
        assertTrue(output.contains("Media: 42,00"));
        assertTrue(output.contains("Desviación Estándar: NaN"));
    }

    public void testTwoValues() {
        String[] args = {"src/test/java/edu/escuelaing/arsw/resources/two_values.txt"};
        MeanStdDevCalculator.main(args);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Tabla 1:"));
        assertTrue(output.contains("Media: 15,00"));
        assertTrue(output.contains("Desviación Estándar: 7,07"));
    }

    public void testProcessNumbersIgnoreText() {
        String[] args = {"src/test/java/edu/escuelaing/arsw/resources/file_with_text.txt"};
        MeanStdDevCalculator.main(args);
        String output = outContent.toString().trim();
        assertTrue(output.contains("Tabla 1:"));
        assertTrue(output.contains("Media: 10,33"));
        assertTrue(output.contains("Desviación Estándar: 5,01"));
        assertTrue(output.contains("Tabla 2:"));
        assertTrue(output.contains("Media: 25,17"));
        assertTrue(output.contains("Desviación Estándar: 5,01"));
    }
}
