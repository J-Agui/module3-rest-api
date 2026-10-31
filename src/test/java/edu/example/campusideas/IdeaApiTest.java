package edu.example.campusideas;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.fail;
// API/component test: exercises routing and JSON through MockMvc, without a live network server.
@SpringBootTest
@AutoConfigureMockMvc
class IdeaApiTest {
    @Autowired private MockMvc mvc;
    @Test
    void validPostReturnsCreatedIdea() throws Exception {
    	
    	mvc.perform(post("/api/ideas/create").contentType(MediaType.APPLICATION_JSON).content("{\"id\": \"3\", \"title\": \"Tester\", \"category\": \"content\"}")).andExpect(status().isCreated());

    }
}
