package edu.example.campusideas;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {
    @GetMapping("/api/hello")
    public Map<String, String> hello() {
        // TODO 1: Personalize the message. Keep the JSON key "message".
        return Map.of("message", "Greetings to Jose's Campus Idea Board!");
    }
}
