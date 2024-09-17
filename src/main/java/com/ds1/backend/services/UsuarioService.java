package com.ds1.backend.services;

import com.ds1.backend.models.Usuario;
import com.ds1.backend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> atualizar(Long id, Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setMatricula(usuarioAtualizado.getMatricula());
            usuarioExistente.setSenha(usuarioAtualizado.getSenha());
            usuarioExistente.setTipoUsuario(usuarioAtualizado.getTipoUsuario());
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            usuarioExistente.setCpf(usuarioAtualizado.getCpf());
            usuarioExistente.setNome(usuarioAtualizado.getNome());
            return usuarioRepository.save(usuarioExistente);
        });
    }

    public boolean deletar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
