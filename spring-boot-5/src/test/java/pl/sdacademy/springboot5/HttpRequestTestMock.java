package pl.sdacademy.springboot5;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest
public class HttpRequestTestMock {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingService service;

    @Test
    public void shouldGetCorrectAnswerFromController() throws Exception {
        mockMvc.perform(get("/greetingEndpoint"))
//                .andDo(print())
//                .andExpect(status().isOk())
                .andExpect(status().isIAmATeapot())
                .andExpect(content().string(containsString("Hello")));
    }

    @Test
    public void shouldReturnGreetingFromService() throws Exception {
        when(service.greeting()).thenReturn("Hello Mock");
        mockMvc.perform(get("/greetingService"))
//                .andDo(print())
//                .andExpect(status().isOk())
                .andExpect(status().isIAmATeapot())
                .andExpect(content().string(containsString("Hello Mock")));
    }
}
