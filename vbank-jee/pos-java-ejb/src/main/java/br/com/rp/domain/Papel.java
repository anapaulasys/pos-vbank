package br.com.rp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "acao")
public class Papel extends BaseEntity implements Serializable{
	
	/*
	 * Descrição da ação. Nesse atributo será informado o nome de cada 
	 * método para identificação da ação.
	 */
	@Column(name = "ds_acao", length = 60, nullable = false)
	private String descricaoPapel;
	
	public Papel() {

	}
	
	public Papel(String descricaoPapel) {
		super();
		this.descricaoPapel = descricaoPapel;
	}



	public String getDescricaoAcao() {
		return descricaoPapel;
	}

	public void setDescricaoAcao(String descricaoPapel) {
		this.descricaoPapel = descricaoPapel;
	}

}
