package cotuba.epub;

import cotuba.application.GeradorEbook;
import cotuba.domain.Ebook;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GeradorEpubEpublib implements GeradorEbook {

    @Override
    public void gera(Ebook ebook) {
        Book epub = new Book();
        Path arquivoDeSaida = ebook.getArquivoDeSaida();
        ebook.getCapitulos().forEach(capitulo -> {
            epub.addSection(capitulo.getTitulo(), new Resource(capitulo.getConteudoHtml().getBytes(), MediatypeService.XHTML));
        });
        EpubWriter epubWriter = new EpubWriter();
        try {
            epubWriter.write(epub, Files.newOutputStream(ebook.getArquivoDeSaida()));
        } catch (IOException ex) {
            throw new RuntimeException("Erro	ao	criar	arquivo	EPUB:	" + arquivoDeSaida.toAbsolutePath(), ex);
        }
    }
}
