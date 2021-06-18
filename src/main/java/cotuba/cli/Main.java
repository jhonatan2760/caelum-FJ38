package cotuba.cli;

import cotuba.application.Cotuba;
import cotuba.md.RenderizadorMDParaHTMLCommonMark;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        LeitorOpcoesCLI leitorOpcoesCLI = new LeitorOpcoesCLI(args);
        boolean modoVerboso = leitorOpcoesCLI.isModoVerboso();
        try {


            RenderizadorMDParaHTMLCommonMark renderizador = new RenderizadorMDParaHTMLCommonMark();

            Cotuba cotuba = new Cotuba();
            cotuba.executa(leitorOpcoesCLI);
            System.out.println("Arquivo gerado com sucesso: " + leitorOpcoesCLI.getArquivoDeSaida());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            if(leitorOpcoesCLI.isModoVerboso()){
                ex.printStackTrace();
            }
            System.exit(1);
        }
    }
}

