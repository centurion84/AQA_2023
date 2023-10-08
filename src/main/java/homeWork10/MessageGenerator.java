package homeWork10;

public class MessageGenerator {
    public static String infoMessage(String message, String... args) {
        String formattedMessage = String.format("INFO: %s", message);
        if (args.length > 0) {
            formattedMessage += " - " + String.join(", ", args);
        }
        return formattedMessage;
    }

    public static String errorMessage(String message, int errorCode, String... args) {
        String formattedMessage = String.format("ERROR %d: %s", errorCode, message);
        if (args.length > 0) {
            formattedMessage += " - " + String.join(", ", args);
        }
        return formattedMessage;
    }

    public static String debugMessage(String message, String... args) {
        String formattedMessage = String.format("DEBUG: %s", message);
        if (args.length > 0) {
            formattedMessage += " - " + String.join(", ", args);
        }
        return formattedMessage;
    }
}
