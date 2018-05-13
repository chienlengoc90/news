package vn.chienlengoc.web.controller.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.chienlengoc.dto.NewsDTO;
import vn.chienlengoc.service.INewsService;

@RestController
@RequestMapping("/ajax/news")
public class NewsAPI {
	
	@Autowired
	private INewsService newsService;
	
	@PostMapping
	public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTO newsDTO) {
		return ResponseEntity.ok(newsService.insert(newsDTO));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<NewsDTO> updateNews(@PathVariable("id") long id, 
											  @RequestBody NewsDTO newsDTO) {
		return ResponseEntity.ok(newsService.update(id, newsDTO));
	}
}
