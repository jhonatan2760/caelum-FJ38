package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;

import java.util.List;

public class Cotuba {

    public void executa(ParametrosCotuba parametroCLI) {

        RenderizadorMDParaHTML renderizador = RenderizadorMDParaHTML.cria();
        List<Capitulo> capitulos = renderizador.renderiza(parametroCLI.getDiretorioDosMD());

        Ebook ebook = new Ebook();
        ebook.setFormato(parametroCLI.getFormato());
        ebook.setArquivoDeSaida(parametroCLI.getArquivoDeSaida());
        ebook.setCapitulos(capitulos);

        GeradorEbook.cria(parametroCLI.getFormato()).gera(ebook);


    }


}
