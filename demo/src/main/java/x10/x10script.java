package x10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class x10script {
    public static void main(String[] args) {
        System.out.println("Starting program.");
    public static String modifyLine(String currLine) {
        String output = "";
        // grab just the numeric portion at the end (preserving the sign)
        String pattern = "(-?\\d+(?:\\.\\d+)?)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(currLine);
        if (matcher.find()) {
            String numericalValueStr = matcher.group();
            double numericalValue = Double.parseDouble(numericalValueStr);
            double multipliedValue = numericalValue * 10;
            output = currLine.replace(numericalValueStr, String.valueOf(multipliedValue));
        }
        return output;
    }
}
