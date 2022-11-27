package malk.challenge.emailing;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.Message.RecipientType;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import malk.challenge.domain.Cliente;
import malk.challenge.domain.Noticias;
import malk.challenge.service.ClienteService;
import malk.challenge.service.NoticiasService;

@Configuration
@EnableScheduling
public class ClienteEmail {
	
	@Autowired
	private ClienteService service;

	@Autowired
	private NoticiasService noticias;

	@Autowired
	JavaMailSender javaMailSender;

	@Scheduled(cron = "0 */1 * * * *", zone = "America/Sao_Paulo")
	public void sendEmail() throws Exception {
		System.out.println("Enviando emails");
		List<Noticias> noticias = this.noticias.findAllUnprocessedNews();
		StringBuilder noticiasTemplate = new StringBuilder();
		for (Noticias noticia : noticias) {
			noticiasTemplate.append("<a href=\"%s\">%s</a> <br/> %s <br/><br/>"
					.formatted(noticia.getLink(), noticia.getTitulo(), noticia.getDescrição()));
		}
		for (Cliente cliente : this.service.findAll()) {
			String text = "Bom dia %s ? %s<br/><br/>Seguem as notícias de hoje.<br/><br/>	%s<br/>"
					.formatted(cliente.getNome(), cliente.isBirthday() ? "Feliz Aniversário!" : "", noticiasTemplate);
			MimeMessage message = javaMailSender.createMimeMessage();
			message.setFrom("challengesyonet2@gmail.com");
			message.setRecipients(RecipientType.TO, cliente.getEmail());
			message.setSubject("Notícias do dia!");
			message.setSentDate(new Date());
			message.setContent(text, "text/html");
			javaMailSender.send(message);
		}
		this.noticias.marcarComoProcessadas(noticias);
	}
}
