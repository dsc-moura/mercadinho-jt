package br.com.mercadinhojt.mercado.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	
	@Autowired
	private HttpServletRequest request;

	//CONFIGURAMOS A PASTA DE ONDE SERA SALVO O ARQUIVO NO SERVIDOR
	public String write(String baseFolder, MultipartFile file) {
        try {            
        			//String realPath = request.getContextPath()+"/"+baseFolder;  			
        	        String path = "C:\\DEV\\PROJETOS\\mercadinho-jt\\src\\main\\webapp\\arquivos-produto" + "\\" + file.getOriginalFilename();
        	        file.transferTo(new File(path));
        	        return baseFolder + "\\" + file.getOriginalFilename();

        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
