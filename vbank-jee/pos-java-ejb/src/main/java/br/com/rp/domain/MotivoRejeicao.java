package br.com.rp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name = "motivorejeicao")
public class MotivoRejeicao extends BaseEntity implements Serializable {

	@Lob
	@Column(name = "ds_motivo")
	private String dsMotivo;

	public MotivoRejeicao() {

	}

	public String getDsMotivo() {
		return dsMotivo;
	}

	public void setDsMotivo(String dsMotivo) {
		this.dsMotivo = dsMotivo;
	}
}
