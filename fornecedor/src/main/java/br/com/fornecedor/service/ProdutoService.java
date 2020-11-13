package br.com.fornecedor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import br.com.fornecedor.model.Produto;
import br.com.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(String estado) {
		return produtoRepository.findByEstado(estado);
	}
	
	public ResponseEntity<Produto> deletar(Long id) {
		
		Optional<Produto> produto = produtoRepository.findById(id);
		
		if(!produto.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			produtoRepository.deleteById(id);		
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	public ResponseEntity<Produto> atualizar (Produto produto) {
		
		Optional<Produto> produtoAtual = produtoRepository.findById(produto.getId());
		
		if(produtoAtual.isPresent()) {
			produtoAtual.get().setDescricao(produto.getDescricao());
			produtoAtual.get().setEstado(produto.getEstado());
			produtoAtual.get().setNome(produto.getNome());
			produtoAtual.get().setPreco(produto.getPreco());
			
			Produto produtoNovo = produtoRepository.save(produtoAtual.get());
			
			return new ResponseEntity<>(produtoNovo, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	
}
