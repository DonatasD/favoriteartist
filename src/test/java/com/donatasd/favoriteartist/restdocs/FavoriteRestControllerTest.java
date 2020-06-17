package com.donatasd.favoriteartist.restdocs;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.donatasd.favoriteartist.api.favorite.dto.CreateFavoriteDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Donatas Daubaras
 */
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets/favorites")
public class FavoriteRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void findAllByUserId() throws Exception {
    this.mockMvc.perform(get("/api/favorites?userId=1"))
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("findByUser"));
  }

  @Test
  public void createFavorite() throws Exception {
    var createDTO = new CreateFavoriteDTO(2L, 3492L);
    var content = objectMapper.writeValueAsString(createDTO);
    this.mockMvc
        .perform(
            post("/api/favorites")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andDo(document("create"));
  }
}
