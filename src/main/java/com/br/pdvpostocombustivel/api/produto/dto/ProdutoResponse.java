package com.br.pdvpostocombustivel.api.produto.dto;

import com.br.pdvpostocombustivel.enums.TipoProduto;

//Para resposta
public record ProdutoResponse(
        String nome,
        String referencia,
        String fornecedor,
        String marca,
        String categoria,
        TipoProduto tipoProduto
) {
}
