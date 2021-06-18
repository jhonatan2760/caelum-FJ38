package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEpubEpublib;
import cotuba.pdf.GeradorPDFItext;

import java.util.List;

public class Cotuba {

    public void executa(ParametrosCotuba parametroCLI) {

        RenderizadorMDParaHTML renderizador = RenderizadorMDParaHTML.cria();
        List<Capitulo> capitulos = renderizador.renderiza(parametroCLI.getDiretorioDosMD());

        Ebook ebook = new Ebook();
        ebook.setFormato(parametroCLI.getFormato());
        ebook.setArquivoDeSaida(parametroCLI.getArquivoDeSaida());
        ebook.setCapitulos(capitulos);


        if ("pdf".equals(parametroCLI.getFormato())) {
            new GeradorPDFItext().gera(ebook);
        } else if ("epub".equals(parametroCLI.getFormato())) {
           new GeradorEpubEpublib().gera(ebook);
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + parametroCLI.getFormato());
        }


    }


}
