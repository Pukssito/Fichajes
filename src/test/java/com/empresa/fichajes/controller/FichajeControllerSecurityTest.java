package com.empresa.fichajes.controller;

import com.empresa.fichajes.dao.FichajeDao;
import com.empresa.fichajes.dao.UsuarioDao;
import com.empresa.fichajes.service.security.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FichajeController.class)
@Import(com.empresa.fichajes.service.security.WebSecurityConfig.class)
class FichajeControllerSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FichajeDao fichajeDao;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UsuarioDao usuarioDao;

    @Test
    void crearFichajeSinAutenticacionDevuelve401() throws Exception {
        mockMvc.perform(post("/api/fichajes/fichar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"tipo\":\"ENTRADA\"}"))
                .andExpect(status().isUnauthorized());
    }
}
