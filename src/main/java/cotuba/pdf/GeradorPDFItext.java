package cotuba.pdf;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.property.AreaBreakType;
import cotuba.application.GeradorEbook;
import cotuba.domain.Ebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GeradorPDFItext implements GeradorEbook {

    @Override
    public	void	gera(Ebook ebook) {
        Path arquivoDeSaida = ebook.getArquivoDeSaida();
        try(PdfWriter	writer	=	new	PdfWriter(Files.newOutputStream(arquivoDeSaida));
            PdfDocument	pdf	=	new	PdfDocument(writer);
            Document	pdfDocument	=	new	Document(pdf))	{
            ebook.getCapitulos().forEach(capitulo -> {
                String html = capitulo.getConteudoHtml();
                List<IElement>	convertToElements	= null;
                try {
                    convertToElements = HtmlConverter.convertToElements(html);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for	(IElement	element	:	convertToElements)	{
                    pdfDocument.add((IBlockElement)	element);
                }
                pdfDocument.add(new	AreaBreak(AreaBreakType.NEXT_PAGE));
            });
        }	catch	(Exception	ex)	{
            throw new	RuntimeException("Erro	ao	criar	arquivo	PDF:	"	+	arquivoDeSaida.toAbsolutePath(), ex);
        }
    }

}
