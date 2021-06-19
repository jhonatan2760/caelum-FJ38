package cotuba.domain;

import cotuba.application.GeradorEbook;
import cotuba.epub.GeradorEpub;
import cotuba.pdf.GeradorPDF;

public enum FormatoEbook {

    PDF(new GeradorPDF()),
    EPUB(new GeradorEpub());

    GeradorEbook geradorEbook;

    FormatoEbook(GeradorEbook geradorEbook){
        this.geradorEbook = geradorEbook;
    }

    public GeradorEbook getGeradorEbook(){
        return geradorEbook;
    }
}
