package com.br.pdvpostocombustivel.api.estoque;

import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueRequest;
import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueResponse;
import com.br.pdvpostocombustivel.domain.entity.Estoque;
import com.br.pdvpostocombustivel.domain.repository.EstoqueRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstoqueService {

    // implementa a interface repository de estoque
    private final EstoqueRepository repository;

    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public EstoqueResponse create(EstoqueRequest req) {
        Estoque novaEstoque = toEntity(req);
        return toResponse(repository.save(novaEstoque));
    }

    // READ by ID - validar a utilização desse método
    @Transactional(readOnly = true)
    public EstoqueResponse getById(Long id) {
        Estoque e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado. id = " + id));
        return toResponse(e);
    }

    // READ by Lote de Fabricação
    @Transactional(readOnly = true)
    public EstoqueResponse getByLoteFabricacao(String loteFabricacao) {
        Estoque e = repository.findByLoteFabricacao(loteFabricacao)
                .orElseThrow(() -> new IllegalArgumentException("Lote de Fabricação não encontrado. id = " + loteFabricacao));
        return toResponse(e);
    }

    // LIST paginado
    @Transactional(readOnly = true)
    public Page<EstoqueResponse> list (int page, int size, String sortBy, Sort.Direction direction){
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction,sortBy));
        return repository.findAll(pageable).map(this::toResponse);
    }

    public EstoqueResponse update(Long id, EstoqueRequest req){
        Estoque e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada. id=" + id));

        if (req.loteFabricacao() != null && !req.loteFabricacao().equals(e.getLoteFabricacao()) ){
            validarUnicidadeLoteFabricacao(req.loteFabricacao(), id);
        }

        e.setQuantidade(req.quantidade());
        e.setLocalTanque(req.localTanque());
        e.setLocalEndereco(req.localEndereco());
        e.setLoteFabricacao(req.loteFabricacao());
        e.setDataValidade(req.dataValidade());

        return toResponse(repository.save(e));
    }

    // PATCH - atualiza apenas campos não nulos
    public EstoqueResponse patch(Long id, EstoqueRequest req){
        Estoque e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Estoque não encontrado. id = " +id));

        if(req.quantidade() != null) e.setQuantidade(req.quantidade());
        if(req.localTanque() != null) e.setLocalTanque(req.localTanque());
        if(req.localEndereco() != null) e.setLocalEndereco(req.localEndereco());
        if(req.loteFabricacao() != null){
            if(!req.loteFabricacao().equals(e.getLoteFabricacao())){
                validarUnicidadeLoteFabricacao(req.loteFabricacao(), id);
            }
            e.setLoteFabricacao(req.loteFabricacao());
        }
        if(req.dataValidade() != null) e.setDataValidade(req.dataValidade());

        return toResponse(repository.save(e));
    }

    //DELETE
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Estoque não encontrado. id = " +id);
        }
        repository.deleteById(id);
    }

    // ---------- Helpers ----------
    private void validarUnicidadeLoteFabricacao(String loteFabricacao, Long idAtual){
        repository.findByLoteFabricacao(loteFabricacao).ifPresent(existente -> {
            if(idAtual == null || !existente.getId().equals(idAtual)){
                throw new DataIntegrityViolationException("Lote de Fabricação já foi cadastraado: "+loteFabricacao);
            }
        });
    }

    private Estoque toEntity(EstoqueRequest req){
        return new Estoque(
                req.quantidade(),
                req.localTanque(),
                req.localEndereco(),
                req.loteFabricacao(),
                req.dataValidade(),
                req.tipoEstoque()
        );
    }

    private EstoqueResponse toResponse(Estoque e){
        return new EstoqueResponse(
                e.getQuantidade(),
                e.getLocalTanque(),
                e.getLocalEndereco(),
                e.getLoteFabricacao(),
                e.getDataValidade()
        );
    }
}
