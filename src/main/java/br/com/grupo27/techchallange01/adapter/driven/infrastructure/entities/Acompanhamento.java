package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.abstractions.Produto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ACOMPANHAMENTO")
public class Acompanhamento extends Produto {
    
}

