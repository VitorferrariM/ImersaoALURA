import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo {

    public <Conteudo> List<Conteudo> extraiConteudos(String json) {

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        return listaDeAtributos.stream()
            .map(atributos -> new Conteudo(atributos.get("title"), atributos.get("url")))
            .toList();

    }

    @Override
    public List<Content> extraiConteudos(String json) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extraiConteudos'");
    }

    @Override
    public List<Content> extraiConteudos(String json) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extraiConteudos'");
    }

}