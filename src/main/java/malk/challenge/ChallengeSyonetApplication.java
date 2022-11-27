package malk.challenge;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import malk.challenge.domain.Cliente;
import malk.challenge.domain.Noticias;
import malk.challenge.repositories.ClienteRepository;
import malk.challenge.repositories.NoticiasRepository;

@SpringBootApplication
public class ChallengeSyonetApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private NoticiasRepository noticiasRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSyonetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cli1 = new Cliente(1, "Molusco", "molusco@gmail.com", null);
		Cliente cli2 = new Cliente(2, "Bob Esponja", "bobesponja@gmail.com", LocalDate.of(1986, 07, 14));
		Cliente cli3 = new Cliente(3, "Isaias", "challengesyonet2@gmail.com", LocalDate.of(1988, 05, 30));


		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		
		Noticias not1 = new Noticias(1, "Lançamento de um novo livro!", "Novo Livro Java®: Como Programar", "https://arcus-www.amazon.com.br/Java%C2%AE-como-programar-Paul-Deitel/dp/8543004799");
		Noticias not2 = new Noticias(2, "Teclado Mecânico em promoção!", "Veja esse novo teclado mecânico perfeito para programar!", "https://www.dell.com/pt-br/shop/teclado-gamer-mec%C3%A2nico-alienware-low-profile-rgb-aw510k/apd/580-aimp/acess%C3%B3rios-para-computador");
	
		noticiasRepository.saveAll(Arrays.asList(not1,not2));
	}

}
