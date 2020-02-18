ALTER TABLE clientes  ADD CONSTRAINT fk_clientes_cidades
FOREIGN KEY(cidade_id) REFERENCES cidades(id_cidade);