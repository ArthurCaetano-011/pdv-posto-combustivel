package com.br.pdvpostocombustivel.api.produto.dto;

//Para resposta
public record ProdutoResponse(
        String nome,
        String referencia,
        String fornecedor,
        String marca,
        String categoria
) {
}
