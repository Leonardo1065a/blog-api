package br.com.leonardo.blogui.model.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import br.com.leonardo.blogui.model.Post;
import br.com.leonardo.blogui.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostDTO {

	private Long id;
	
	private String title;
	
	private String description;
	
	private String urlImg;
	
	private Long userId;
	
	private Date dtCriacao;
	
	private MultipartFile file;
	
	public Post toEntity() {
		return new Post()
				.setTitle(title)
				.setId(id)
				.setDescription(description)
				.setUrlImagem(urlImg)
				.setDtCriacao(dtCriacao)
				.setUser(new User(userId));
				
	}
	

}
