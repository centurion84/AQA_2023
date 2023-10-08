package homeWork10;

import org.testng.annotations.Test;

public class MessageGeneratorTest {

    @Test
    public void messagesTest() {
        String info = MessageGenerator.infoMessage("Application started", "Version 1.0");
        System.out.println(info);

        String error = MessageGenerator.errorMessage("File not found", 404, "Path:", "/path/to/file");
        System.out.println(error);

        String debug = MessageGenerator.debugMessage("Debug message", "Parameter 1", "42", "true");
        System.out.println(debug);
    }
}
