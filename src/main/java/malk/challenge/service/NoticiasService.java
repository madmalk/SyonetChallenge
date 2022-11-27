package malk.challenge.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import malk.challenge.domain.Noticias;
import malk.challenge.exceptions.ObjectNotFoundException;
import malk.challenge.repositories.NoticiasRepository;

@Service
public class NoticiasService {
	
	@Autowired
	private NoticiasRepository repo;

	public Noticias find(Integer id) {
		Optional<Noticias> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Noticias não encontrado! Id: " + id + ", Tipo: " + Noticias.class.getName()));
	}
	
	public Noticias insert(Noticias obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Noticias> findAll() {
	 return this.repo.findAll();
	}
	
}