package com.empresa.fichajes.service.security;

import com.empresa.fichajes.dao.UsuarioDao;
import com.empresa.fichajes.entity.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UsuarioDao usuarioDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthService authService;

    @Test
    @DisplayName("login retorna usuario con credenciales validas")
    void loginConCredencialesValidas() {
        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");
        usuario.setPassword("hashed");

        when(usuarioDao.findByEmail("test@example.com")).thenReturn(Optional.of(usuario));
        when(passwordEncoder.matches("secret", "hashed")).thenReturn(true);

        Optional<Usuario> result = authService.login("test@example.com", "secret");

        assertTrue(result.isPresent());
        assertEquals(usuario, result.get());
    }

    @Test
    @DisplayName("login retorna vacio con credenciales invalidas")
    void loginConCredencialesInvalidas() {
        when(usuarioDao.findByEmail("wrong@example.com")).thenReturn(Optional.empty());

        Optional<Usuario> resultUsuarioNoExiste = authService.login("wrong@example.com", "secret");
        assertTrue(resultUsuarioNoExiste.isEmpty());

        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");
        usuario.setPassword("hashed");
        when(usuarioDao.findByEmail("test@example.com")).thenReturn(Optional.of(usuario));
        when(passwordEncoder.matches("bad", "hashed")).thenReturn(false);

        Optional<Usuario> resultPasswordIncorrecta = authService.login("test@example.com", "bad");
        assertTrue(resultPasswordIncorrecta.isEmpty());
    }
}
