package br.com.fornecedor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fornecedor.model.Produto;
import br.com.fornecedor.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@ApiOperation(value = "getProdutosPorEstado")
	@GetMapping("/{estado}")
	public List<Produto> getProdutosPorEstado(@PathVariable("estado") String estado) {
		return produtoService.getProdutosPorEstado(estado);
	}
	
	@ApiOperation(value = "deletarProduto")
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deletarProduto (@PathVariable Long id) {		
		return produtoService.deletar(id);
	}
	
	@ApiOperation(value = "atualizarProduto")
	@PutMapping(value = "/id")
	public ResponseEntity<Produto> atualizarProduto (@RequestBody Produto produto) {
		
		return produtoService.atualizar(produto);
		
	}
	
	
}
