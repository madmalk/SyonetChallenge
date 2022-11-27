Release de um backend para cadastro e envio de e-mails de newsletters com programação de horário.

Requisitos:

Eclipse(ou um ide de sua escolha).
Postman(ou similar): para testes de cadastro;

Como utilizar:

Dar import do projeto no seu Eclipse.
Iniciar aplicação através do ChallengeSyonetApplication.java

ou inicaiando a aplicação:

Entrar na pasta do projeto;
./mvnw clean package
java -jar ./target/demo-0.0.1-SNAPSHOT.jar

A seguir no seu Postman pode cadastrar tanto noticias como novos usúarios através de:

Para clientes:
Dar um POST em http://localhost:8080/clientes com os seguintes componentes no body>raw/JSON:
{
    "nome" : "Malk",
    "email" : "teste@teste.com",
    "nascimento" : "28/11/1992"
}.
Deve obrigatóriamente conter nome e e-mail, nascimento é opcional.
Podendo também dar GET para ter a lista de usúarios cadastrados.
Dar um POST em http://localhost:8080/noticias com os seguintes componentes no body>raw/JSON:

Para notícias:

{
    "titulo" : "Teste",
    "descrição" : "Testando",
    "link" : "www.teste.com"
}
Sendo todos atributos obrigatórios.

Os e-mails são enviados todos os dias as 08:00horas para todos clientes cadastrados no seguinte formato:

Assunto: Notícias do dia!

Bom dia <nome do cliente> ?< Feliz aniversário >(caso seja aniversário do cliente)?

Seguem as notícias de hoje.

<Título clicável se fornecido link>
<Descrição>

<Título clicável se fornecido link>
<Descrição>++(todas noticias novas cadastradas)