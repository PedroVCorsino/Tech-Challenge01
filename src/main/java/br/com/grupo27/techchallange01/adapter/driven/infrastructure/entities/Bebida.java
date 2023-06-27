package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.Produto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BEBIDA")
public class Bebida extends Produto {
    
}

