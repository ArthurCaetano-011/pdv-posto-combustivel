package com.br.pdvpostocombustivel.api.acesso;

import com.br.pdvpostocombustivel.api.acesso.dto.AcessoRequest;
import com.br.pdvpostocombustivel.api.acesso.dto.AcessoResponse;
import com.br.pdvpostocombustivel.api.acesso.dto.LoginRequest;
import com.br.pdvpostocombustivel.api.acesso.dto.LoginResponse;
import com.br.pdvpostocombustivel.domain.entity.Acesso;
import com.br.pdvpostocombustivel.domain.repository.AcessoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.security.auth.login.LoginException;

@Service
@Transactional
public class AcessoService {

    private final AcessoRepository repository;

    public AcessoService(AcessoRepository repository) {
        this.repository = repository;
    }

    // AUTHENTICATE
    @Transactional(readOnly = true)
    public LoginResponse authenticate(LoginRequest loginRequest) throws LoginException {
        Acesso acesso = repository.findByUsuario(loginRequest.usuario())
                .orElseThrow(() -> new LoginException("Usuário ou senha inválidos."));

        // TODO: Implementar a verificação de senha com criptografia (ex: BCrypt)
        if (!acesso.getSenha().equals(loginRequest.senha())) {
            throw new LoginException("Usuário ou senha inválidos.");
        }

        // TODO: Gerar um token JWT real
        String token = "fake-jwt-token-for-" + acesso.getUsuario();

        return new LoginResponse(token, acesso.getTipoAcesso());
    }

    // CREATE
    public AcessoResponse create(AcessoRequest req) {
        Acesso novoAcesso = toEntity(req);
        return toResponse(repository.save(novoAcesso));
    }

    // READ by ID
    @Transactional(readOnly = true)
    public AcessoResponse getById(Long id) {
        Acesso a = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. id=" + id));
        return toResponse(a);
    }

    // READ by Usuario
    @Transactional(readOnly = true)
    public AcessoResponse getByUsuario(String usuario) {
        Acesso a = repository.findByUsuario(usuario)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. usuario=" + usuario));
        return toResponse(a);
    }

    // LIST paginado
    @Transactional(readOnly = true)
    public Page<AcessoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    // UPDATE
    public AcessoResponse update(Long id, AcessoRequest req) {
        Acesso a = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. id=" + id));

        if (req.usuario() != null && !req.usuario().equals(a.getUsuario())) {
            validarUnicidadeUsuario(req.usuario(), id);
        }

        a.setSenha(req.senha());
        a.setUsuario(req.usuario());
        a.setTipoAcesso(req.tipoAcesso());

        return toResponse(repository.save(a));
    }

    // PATCH
    public AcessoResponse patch(Long id, AcessoRequest req) {
        Acesso a = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Acesso não encontrado. id=" + id));

        if (req.senha() != null)  a.setSenha(req.senha());
        if (req.usuario() != null) {
            if (!req.usuario().equals(a.getUsuario())) {
                validarUnicidadeUsuario(req.usuario(), id);
            }
            a.setUsuario(req.usuario());
        }
        if (req.tipoAcesso() != null) a.setTipoAcesso(req.tipoAcesso());

        return toResponse(repository.save(a));
    }

    // DELETE
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Acesso não encontrado. id=" + id);
        }
        repository.deleteById(id);
    }

    // ---------- Helpers ----------
    private void validarUnicidadeUsuario(String usuario, Long idAtual) {
        repository.findByUsuario(usuario).ifPresent(existente -> {
            if (idAtual == null || !existente.getId().equals(idAtual)) {
                throw new DataIntegrityViolationException("Usuario já cadastrado: " + usuario);
            }
        });
    }

    private Acesso toEntity(AcessoRequest req) {
        return new Acesso(
                req.usuario(),
                req.senha(),
                req.tipoAcesso()
        );
    }

    private AcessoResponse toResponse(Acesso a) {
        return new AcessoResponse(
                a.getUsuario(),
                a.getSenha(),
                a.getTipoAcesso()
        );
    }
}
