package it.ewallet.pojo;

import java.util.Objects;

public class Movimento {
	
	private int ibanM;
	private double importo;
	private String dataM;
	private String tipo;
	
	
	
	public int getIbanM() {
		return ibanM;
	}
	public double getImporto() {
		return importo;
	}
	public String getDataM() {
		return dataM;
	}
	public String getTipo() {
		return tipo;
	}
	public void setIbanM(int ibanM) {
		this.ibanM = ibanM;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	public void setDataM(String dataM) {
		this.dataM = dataM;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ibanM);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimento other = (Movimento) obj;
		return Objects.equals(ibanM, other.ibanM);
	}
	
	
	

}
