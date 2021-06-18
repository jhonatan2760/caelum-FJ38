package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.md.RenderizadorMDParaHTMLCommonMark;

import java.nio.file.Path;
import java.util.List;

public interface RenderizadorMDParaHTML {

    List<Capitulo> renderiza(Path diretorioDosMD);

    static RenderizadorMDParaHTML cria() {
        return new RenderizadorMDParaHTMLCommonMark();
    }

}
