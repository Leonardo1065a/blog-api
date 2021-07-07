package br.com.leonardo.blogui.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.leonardo.blogui.model.Post;
import br.com.leonardo.blogui.model.dto.PostDTO;
import br.com.leonardo.blogui.repository.PostRepository;
import br.com.leonardo.blogui.storage.Disc;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostRepository repository;
	
	@Autowired
	private Disc disc;
	
	@GetMapping
	public List<Post> listar() {
		return repository.findAll(); 
	}
	
	@GetMapping("{id}")
	public Post getById(@PathVariable("id") Long id) {
		return repository.findById(id).get(); 
	}
	
	@PostMapping
	public Post add(@RequestParam("form") String form, @RequestParam("file") MultipartFile file) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = form.toString();
		PostDTO post = mapper.readValue(jsonInString, PostDTO.class); 
		this.disc.salvarFoto(file);
		post.setUrlImg(this.disc.getPathFile(file).toString());
		post.setDtCriacao(new Date());
		return repository.save(post.toEntity()); 
	}
}
