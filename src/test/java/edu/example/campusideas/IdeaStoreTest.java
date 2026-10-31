package edu.example.campusideas;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
// True unit tests: no Spring context, HTTP client, or server is involved.

class IdeaStoreTest {
    @Test void freshStoreContainsTwoSeedIdeas() {
        IdeaStore store = new IdeaStore();
        assertEquals(2, store.findAll().size());
    }
    
    @Test
    void addingIdeaStoresItsTitleAndCategory() {
    	IdeaStore store = new IdeaStore();
    	IdeaRequest newIdea = new IdeaRequest("Test", "Idea");
    	Idea Idea = store.add(newIdea);
    	assert Idea != null : "Idea is empty!";
    	assert store.findAll().contains(Idea) : "Comparison Failure!";

        // Arrange: construct a fresh store and an IdeaRequest.
        // Act: call add(request).
        // Assert: verify returned title/category and that findAll contains the idea.
    }
    @Test
    void twoNewIdeasReceiveDifferentIds() {
    	IdeaStore store = new IdeaStore();
    	IdeaRequest request1 = new IdeaRequest("RequestOne", "Test");
    	IdeaRequest request2 = new IdeaRequest("RequestTwo", "NewTest");
    	Idea req = store.add(request1);
    	assert req.id() != store.findAll().get(0).id() && req.id() != store.findAll().get(1).id(): "First request has been assigned an existing Id!";
    	
    	req = store.add(request2);
    	assert req.id() != store.findAll().get(0).id() && req.id() != store.findAll().get(1).id(): "Second request has been assigned an existing Id!";
    	
    	assertEquals(4, store.findAll().size());

        // Arrange: use a fresh store.
        // Act: add two requests.
        // Assert: ids differ; neither reuses a seed id; list size grows to four.
    }
}
