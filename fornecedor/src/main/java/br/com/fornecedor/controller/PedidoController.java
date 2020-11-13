package br.com.fornecedor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fornecedor.dto.ItemDoPedidoDTO;
import br.com.fornecedor.model.Pedido;
import br.com.fornecedor.service.PedidoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	private PedidoService pedidoService;
	
	@ApiOperation(value = "realizaPedido")
	@PostMapping()
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
		LOG.info("pedido recebido");
		return pedidoService.realizaPedido(produtos);
	}
	
	@ApiOperation(value = "getPedidoPorId")
	@GetMapping("/{id}")
	public Pedido getPedidoPorId(@PathVariable Long id) {
		return pedidoService.getPedidoPorId(id);
	}
}
