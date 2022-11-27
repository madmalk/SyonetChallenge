package malk.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import malk.challenge.domain.Noticias;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticias, Integer>{

}
