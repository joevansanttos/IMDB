package ioasys.controller.dto;


import ioasys.modelo.Voto;

public class VotoDto {
	
	private Integer valor;
	private String nomeFilme;

	public Integer getValor() {
		return valor;
	}



	public void setValor(Integer valor) {
		this.valor = valor;
	}



	public String getNomeFilme() {
		return nomeFilme;
	}



	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}



	public VotoDto(Voto voto) {
        this.nomeFilme = voto.getFilme().getNome();        
        this.valor = voto.getValor();
        
        
    }

	

}
