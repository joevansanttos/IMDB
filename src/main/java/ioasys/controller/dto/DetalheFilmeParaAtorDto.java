package ioasys.controller.dto;

import org.springframework.data.domain.Page;

import ioasys.modelo.Filme;

public class DetalheFilmeParaAtorDto {
	
	//private Long id;
    private String nome;
    private String data;
    //private List<VotoDto> votos;
    
    
    

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

		

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public static Page<FilmeDto> converter(Page<Filme> filmes) {
		return filmes.map(FilmeDto::new);
    }
	
	public DetalheFilmeParaAtorDto(Filme filme){
		
        this.data = filme.getData();
        this.nome = filme.getnome();
    
        /*
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String text = filme.getDataCriacao().format(formatters);
        LocalDate parsedDate = LocalDate.parse(text, formatters);        
        this.dataLancamento = parsedDate;
        */
        //this.votos = new ArrayList<>();
        //this.votos.addAll(filme.getVotos().stream().map(VotoDto::new).collect(Collectors.toList()));
	}



	public static void converterUnicoFilme(Filme filme) {
		// TODO Auto-generated method stub
		
	}

}
