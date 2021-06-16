package cotuba.application;

import cotuba.domain.Capitulo;
import cotuba.domain.Ebook;
import cotuba.epub.GeradorEpub;
import cotuba.pdf.GeradorPDF;
import cotuba.md.RenderizadorMDParaHTML;

import java.nio.file.Path;
import java.util.List;

public class Cotuba {

    public void executa(String formato, Path diretorioDosMD, Path arquivoDeSaida) {

        RenderizadorMDParaHTML	renderizador	=	new RenderizadorMDParaHTML();
        List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);

        Ebook ebook	=	new	Ebook();
        ebook.setFormato(formato);
        ebook.setArquivoDeSaida(arquivoDeSaida);
        ebook.setCapitulos(capitulos);


        if ("pdf".equals(formato)) {
            new GeradorPDF().gera(ebook);
        } else if ("epub".equals(formato)) {
            new GeradorEpub().gera(ebook);
        } else {
            throw new RuntimeException("Formato do ebook inválido: " + formato);
        }


    }


}
