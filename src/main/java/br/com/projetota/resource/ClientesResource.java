package br.com.projetota.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projetota.model.Clientes;
import br.com.projetota.service.ClientesService;

@RestController
@RequestMapping("/clientes")
public class ClientesResource {

	@GetMapping()
	public Page<Clientes>pesquisaClientes(@RequestParam
		(required=false, defaultValue="") String nome, Pageable pageable){
			return clientesService.pesquisaClientes(nome, pageable);
	}
	
	@Autowired
	private ClientesService clientesService;
	
	@GetMapping("/todos")
	public List<Clientes>listarTodosClientes() {
		return clientesService.listarTodosClientes();		
	}
	
	@GetMapping("/{id_cliente}")
	public ResponseEntity<Clientes>findClientes(@PathVariable Integer id_cliente) {
		Clientes clientes = clientesService.findClientes(id_cliente);
		return ResponseEntity.ok().body(clientes);
	}
	
	@PostMapping()
	public ResponseEntity<Void> insert(@RequestBody Clientes clientes){
		clientes = clientesService.insert(clientes);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id_cliente}").buildAndExpand(clientes.getId_cliente()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("{/id_cliente}")
	public ResponseEntity<Void> delete(@PathVariable Integer id_cliente) {
		clientesService.delete(id_cliente);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id_cliente}")
	public ResponseEntity<Void> update(@RequestBody Clientes clientes){
		clientes = clientesService.update(clientes);
		return ResponseEntity.noContent().build();
	}
}
