package com.br.pdvpostocombustivel.api.produto.dto;

import com.br.pdvpostocombustivel.enums.TipoCombustivel;
import com.br.pdvpostocombustivel.enums.TipoLubrificante;
import com.br.pdvpostocombustivel.enums.TipoProduto;

//Para entrada
public record ProdutoRequest(
        String nome,
        String referencia,
        String fornecedor,
        String marca,
        TipoProduto tipoProduto,
        TipoCombustivel tipoCombustivel,
        TipoLubrificante tipoLubrificante
) {
}
