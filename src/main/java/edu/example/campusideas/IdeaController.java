package edu.example.campusideas;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/api/ideas")
public class IdeaController {
    private final IdeaStore store;
    public IdeaController(IdeaStore store) {
        this.store = store;
    }
    // TODO 2: //
    @GetMapping("/all")
    public List<Idea> getIdeas() {
        // TODO 3://
    	return store.findAll();
    	}
    // TODO 4: //
    @PostMapping("/create")
    public ResponseEntity<Idea> createIdea(/* TODO 5: */ @Valid @RequestBody IdeaRequest request) {
        // TODO 6: 
    	Idea idea = store.add(request);
    	return ResponseEntity.status(HttpStatus.CREATED).body(idea);
    }
}
