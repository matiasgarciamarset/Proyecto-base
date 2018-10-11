package com.matias.api;

import com.matias.api.dto.ProductCreationRequestDto;
import com.matias.api.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.matias.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class productApi {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public Boolean ping() {
        return true;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(@RequestBody ProductCreationRequestDto productCreation) {
		return productService.create(productCreation.getName());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductDto read(@PathVariable("id") int id) {
		ProductDto response = Optional.ofNullable(productService.read(id))
				.map( v -> new ProductDto(v.getId(), v.getName())).get();
		return response;
	}

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDto> read() {
        return productService.read().stream()
                .map( v -> new ProductDto(v.getId(), v.getName()))
                .collect(Collectors.toList());
    }
}
