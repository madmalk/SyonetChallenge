package malk.challenge.dto;

import javax.validation.constraints.NotEmpty;

import malk.challenge.domain.Noticias;
import malk.challenge.mapper.ToEntity;

public class NoticiasDTO implements ToEntity<Noticias> {

	@NotEmpty
	private String titulo;
	@NotEmpty
	private String descrição;
	@NotEmpty
	private String link;

	public NoticiasDTO() {
	}

	public NoticiasDTO(Noticias obj) {
		titulo = this.titulo;
		descrição = this.descrição;
		link = this.link;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public Noticias to() {
		Noticias noticias = new Noticias();
		noticias.setTitulo(this.getTitulo());
		noticias.setDescrição(this.getDescrição());
		noticias.setLink(this.link);
		return noticias;
	}
}
