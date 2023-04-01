import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.swing.text.AbstractDocument.Content;

public class App {

    public static <Conteudo> void main(String[] args) throws Exception {

        API api = API.IMDB_TOP_SERIES;

        String url = api.getUrl();
        ExtratorDeConteudo extrator = api.getExtrator();

        Clientehttp http = new Clientehttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados 
        List<Conteudo> conteudos = (List<Conteudo>) extrator.extraiConteudos(json);

        GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(((Object) conteudo).urlImagem()).openStream();
            String nomeArquivo = "saida/" + ((Object) conteudo).titulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(((Object) conteudo).titulo());
            System.out.println();
        }
    }
}