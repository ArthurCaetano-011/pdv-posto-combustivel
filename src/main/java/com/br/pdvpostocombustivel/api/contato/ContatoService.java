package com.br.pdvpostocombustivel.api.contato;


import com.br.pdvpostocombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostocombustivel.api.contato.dto.ContatoResponse;
import com.br.pdvpostocombustivel.domain.entity.Contato;
import com.br.pdvpostocombustivel.domain.repository.ContatoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

public class ContatoService {

        private final ContatoRepository repository;

        public ContatoService(ContatoRepository repository) {
            this.repository = repository;
        }

        // CREATE
        public ContatoResponse create(ContatoRequest req) {
            Contato novoContato = toEntity(req);
            return toResponse(repository.save(novoContato));
        }

        // READ by ID - validar a utilização desse método
        @Transactional(readOnly = true)
        public ContatoResponse getById(Long id) {
            Contato c = repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id =" + id));
            return toResponse(c);
        }

        // READ by Email
        @Transactional(readOnly = true)
        public ContatoResponse getByEmail(String email) {
            Contato c = repository.findByEmail(email)
                    .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. e-mail =" + email));
            return toResponse(c);
        }
        // READ by Telefone
        @Transactional(readOnly = true)
        public ContatoResponse getByTelefone(String telefone) {
        Contato c = repository.findByTelefone(telefone)
                .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. telefone =" + telefone));
        return toResponse(c);
        }

        // LIST paginado
        @Transactional(readOnly = true)
        public Page<ContatoResponse> list(int page, int size, String sortBy, Sort.Direction direction) {
            Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortBy));
            return repository.findAll(pageable).map(this::toResponse);
        }

        // UPDATE  - substitui todos os campos
        public ContatoResponse update(Long id, ContatoRequest req) {
            Contato c = repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id =" + id));

            if (req.email() != null && !req.email().equals(c.getEmail())) {
                validarUnicidadeEmail(req.email(), id);
            }
            if (req.telefone() != null && !req.telefone().equals(c.getTelefone())) {
                validarUnicidadeTelefone(req.telefone(), id);
            }

            c.setTelefone(req.telefone());
            c.setEmail(req.email());
            c.setEndereco(req.endereco());

            return toResponse(repository.save(c));
        }

        // PATCH - atualiza apenas campos não nulos
        public ContatoResponse patch(Long id, ContatoRequest req) {
            Contato c = repository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Contato não encontrado. id =" + id));

            if (req.endereco() != null)  c.setEndereco(req.endereco());
            if (req.email() != null) {
                if (!req.email().equals(c.getEmail())) {
                    validarUnicidadeEmail(req.email(), id);
                }
                c.setEmail(req.email());
            }

            return toResponse(repository.save(c));
        }

        // DELETE
        public void delete(Long id) {
            if (!repository.existsById(id)) {
                throw new IllegalArgumentException("Contato não encontrado. id =" + id);
            }
            repository.deleteById(id);
        }

        // ---------- Helpers ----------
        private void validarUnicidadeEmail(String email, Long idAtual) {
            repository.findByEmail(email).ifPresent(existente -> {
                if (idAtual == null || !existente.getId().equals(idAtual)) {
                    throw new DataIntegrityViolationException("E-mail já cadastrado: " + email);
                }
            });
        }
    private void validarUnicidadeTelefone(String telefone, Long idAtual) {
        repository.findByTelefone(telefone).ifPresent(existente -> {
            if (idAtual == null || !existente.getId().equals(idAtual)) {
                throw new DataIntegrityViolationException("Telefone já cadastrado: " + telefone);
            }
        });
    }


        private Contato toEntity(ContatoRequest req) {
            return new Contato(
                    req.telefone(),
                    req.email(),
                    req.endereco(),
                    req.tipoContato()
            );
        }

        private ContatoResponse toResponse(Contato c) {
            return new ContatoResponse(
                    c.getTelefone(),
                    c.getEmail(),
                    c.getEndereco()
            );
        }
}
