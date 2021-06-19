package br.com.paradizo.tema;

import br.com.paradizo.tema.util.FileUtils;
import cotuba.plugin.Plugin;

public class TemaParadizo implements Plugin {

    @Override
    public String cssDoTema() {
        return FileUtils.getResourceContents("/tema.css");
    }

}
