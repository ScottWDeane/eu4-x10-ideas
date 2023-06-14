package x10;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
public class x10script {
    public static void main(String[] args) {
        System.out.println("Starting program.");

        // clear out our output folder
        deleteAllOldOutputFiles("./demo/src/output");

    public static void deleteAllOldOutputFiles(String outputFolder) {
        File[] files = new File(outputFolder).listFiles();
        if (files.length > 0) {
            for (File oldOutputFile : files) {
                oldOutputFile.delete();
            }
        }
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
