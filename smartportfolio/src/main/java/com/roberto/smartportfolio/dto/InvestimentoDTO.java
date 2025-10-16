
package com.roberto.smartportfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestimentoDTO {
    private String ticker;
    private int quantidade;
    private double precoCompra;
    private double precoAtual;
}
