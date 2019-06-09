package br.com.rp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "agendamento")
public class Agendamento extends BaseEntity implements Serializable {

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_agendamento", nullable = false)
	private Date dataAgendamento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
	private Cliente cliente;

	public Agendamento() {

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
}
