package entidades;


public class Carro {
	private Integer id;
	private String modelo;
	private String cor;
	private Integer ano;
	
	
	public Carro(String modelo, String cor, Integer ano) {
		super();
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public Integer getAno() {
		return ano;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	
}
