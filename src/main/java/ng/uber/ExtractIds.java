package ng.uber;

import java.util.*;
import java.util.regex.*;

public class ExtractIds {

    public static List<String> extractIdsFromMessages(List<String> messages) {
        List<String> result = new ArrayList<>();
        // Define the regex pattern to match @id followed by digits
        Pattern pattern = Pattern.compile("@id(\\d+)");

        for (String message : messages) {
            Matcher matcher = pattern.matcher(message);
            while (matcher.find()) {
                // Add the matched ID to the result list
                result.add(matcher.group(0).substring(1)); // Remove leading '@'
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> messages = Arrays.asList(
                "This is a string @id123,id32,id998, @hi, @@, @id23",
                "@id555 @id42 This is another message @id78"
        );

        List<String> ids = extractIdsFromMessages(messages);
        System.out.println("Extracted IDs: " + ids);
    }
}

