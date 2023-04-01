import java.util.List;

import javax.swing.text.AbstractDocument.Content;

public interface ExtratorDeConteudo {

    List<Content> extraiConteudos(String json);

}
