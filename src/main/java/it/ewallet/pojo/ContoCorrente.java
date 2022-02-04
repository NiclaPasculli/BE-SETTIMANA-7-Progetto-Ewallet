package it.ewallet.pojo;

import java.util.Objects;

public class ContoCorrente {
	
	private String dataCreazione;
	private int iban;
	private double saldo;
	private String intestatario;
	
	
	
	public String getDataCreazione() {
		return dataCreazione;
	}
	
	public int getIban() {
		return iban;
	}
	public double getSaldo() {
		return saldo;
	}
	public String getIntestatario() {
		return intestatario;
	}
	public void setDataCreazione(String dataCreazione) {
		this.dataCreazione = dataCreazione;
	}
	public void setIban(int iban) {
		this.iban = iban;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iban);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContoCorrente other = (ContoCorrente) obj;
		return iban == other.iban;
	}
	
	
	
	
	

}
