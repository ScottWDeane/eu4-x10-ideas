package x10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class x10script {
    public static void main(String[] args) {
        System.out.println("Starting program.");
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
