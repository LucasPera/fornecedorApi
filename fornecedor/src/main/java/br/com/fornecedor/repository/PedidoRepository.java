package br.com.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.fornecedor.model.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long>{

}
