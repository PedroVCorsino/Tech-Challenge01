package br.com.grupo27.techchallange01.core.domain.entities;

import br.com.grupo27.techchallange01.core.domain.entities.abstractions.Produto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BEBIDA")
public class Bebida extends Produto {
    
}

