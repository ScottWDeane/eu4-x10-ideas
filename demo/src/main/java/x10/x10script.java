package x10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class x10script {
    public static void main(String[] args) {
        System.out.println("Starting program.");

        // clear out our output folder
        deleteAllOldOutputFiles("./demo/src/output");

        // get all the file names from inside the "input" folder
        List<String> inputFileNames = fetchAllInputFiles();

        // loop through all our input files
        for (String inputIdeasFileName : inputFileNames) {
            FileOutputStream outputFile =
                    prepareOutputFilePath("./demo/src/output/" + inputIdeasFileName);
            File inputFile = new File("./demo/src/input/" + inputIdeasFileName);

            try {
                Scanner myReader = new Scanner(inputFile);
                while (myReader.hasNextLine()) {
                    // grab the line
                    String currLine = myReader.nextLine();
                    if (isLineAnIdeaWithNumbersToMultiply(currLine)) {
                        currLine = modifyLine(currLine);
                    }
                    try {
                        IOUtils.write(currLine + "\n", outputFile, "UTF-8");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Failed to write line.");
                    }
                }
                // no more lines? close the reader
                myReader.close();
                try {
                    outputFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // close the output file
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteAllOldOutputFiles(String outputFolder) {
        File[] files = new File(outputFolder).listFiles();
        if (files.length > 0) {
            for (File oldOutputFile : files) {
                oldOutputFile.delete();
            }
        }
    }

    public static List<String> fetchAllInputFiles() {
        // read from folder "input", which should be under ""./demo/src/input"
        List<String> allInputFiles = new ArrayList<String>();
        File[] files = new File("./demo/src/input").listFiles();
        for (File file : files) {
            if (file.isFile()) {
                allInputFiles.add(file.getName());
            }
        }
        return allInputFiles;
    }

    // use input file name to generate the output file path
    public static FileOutputStream prepareOutputFilePath(String fileName) {
        String outputFile = "./demo/src/output/" + fileName;
        try {
            FileOutputStream s = FileUtils.openOutputStream(new File(outputFile));
            return s;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public static Boolean isLineAnIdeaWithNumbersToMultiply(String line) {
        Pattern pattern = Pattern.compile("^.*\\b\\d+(\\.\\d+)?\\b.*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        return matcher.find();
    }

    public static String modifyLine(String input) {
        Pattern pattern = Pattern.compile("[-+]?\\d*\\.?\\d+");
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            double value = Double.parseDouble(matcher.group()) * 10;
            matcher.appendReplacement(result, String.format("%.1f", value));
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
