package br.com.leonardo.blogui.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Disc {

	@Value("${contato.disco.raiz}")
	private String raiz;
	
	@Value("${contato.disco.diretorio-fotos}")
	private String diretorioFotos;
	
	public void salvarFoto(MultipartFile foto) {
		this.salvar(this.diretorioFotos, foto);
	}
	
	public Path getPathFile(MultipartFile arquivo) {
		Path diretorioPath = this.getPathDirectory();
		return diretorioPath.resolve(arquivo.getOriginalFilename());
	}
	
	public Path getPathDirectory() {
		return Paths.get(this.raiz, this.diretorioFotos);
	}
	
	public void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = this.getPathDirectory();
		Path arquivoPath = this.getPathFile(arquivo);
		
		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());			
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}		
	}
}
