package it.proprietarioautomobile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "automobile")
public class Automobile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modello")
	private String modello;
	@Column(name = "targa")
	private String targa;
	@Column(name = "annoimmatricolazione")
	private int annoImmatricolazione;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "proprietario_id")
	private Proprietario proprietario;
	
	
	public Automobile() {}
	public Automobile(String marca, String modello) {
		this.marca = marca;
		this.modello = modello;
	}
	public Automobile(String marca, int annoImmatricolazione, Proprietario proprietario) {
		this.marca = marca;
		this.annoImmatricolazione = annoImmatricolazione;
		this.proprietario = proprietario;
	}

	public Long getId() {
		return id;
	}
	public String getMarca() {
		return marca;
	}
	public String getModello() {
		return modello;
	}
	public String getTarga() {
		return targa;
	}
	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public void setTarga(String targa) {
		this.targa = targa;
	}
	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	@Override
	public String toString() {
		return "Automobile [id=" + id + ", marca=" + marca + ", modello=" + modello + ", targa=" + targa
				+ ", annoImmatricolazione=" + annoImmatricolazione + ", proprietario=" + proprietario + "]";
	}
}
