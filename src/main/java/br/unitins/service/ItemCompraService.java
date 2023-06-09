package br.unitins.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import br.unitins.dto.ItemCompraDTO;
import br.unitins.model.Acessorios;
import br.unitins.model.ItemCompra;
import br.unitins.model.Produto;
import br.unitins.repository.ItemCompraRepository;

@ApplicationScoped
public class ItemCompraService {

    @Inject
    private ItemCompraRepository itemCompraRepository;

    // Método para criar um novo item de compra
    public void create(ItemCompraDTO itemCompraDTO) {
        ItemCompra itemCompra = new ItemCompra();
        itemCompra.setItemcompraId(itemCompraDTO.itemcompraId());
        itemCompra.setProduto(new Acessorios(itemCompraDTO.itemcompraId(),
        itemCompraDTO.nome(),null, itemCompraDTO.preco(),null, itemCompraDTO.quantidade(), null, null, null));
        itemCompra.setQuantidade(itemCompraDTO.quantidade());
        itemCompraRepository.create(itemCompra);
    }
    

    // Método para atualizar um item de compra
    public void update(ItemCompraDTO itemCompraDTO) {
        ItemCompra itemCompra = itemCompraRepository.findById(itemCompraDTO.itemcompraId());
        if (itemCompra != null) {
            itemCompra.setQuantidade(itemCompraDTO.quantidade());
            itemCompraRepository.update(itemCompra);
        }
    }

    // Método para deletar um item de compra
    public void delete(ItemCompraDTO itemCompraDTO) {
        ItemCompra itemCompra = itemCompraRepository.findById(itemCompraDTO.itemcompraId());
        if (itemCompra != null) {
            itemCompraRepository.delete(itemCompra);
        }
    }

    // Método para buscar todos os itens de compra
    public List<ItemCompraDTO> findAll() {
        List<ItemCompra> items = itemCompraRepository.findAll();
        return ItemCompraDTO.convertList(items);
    }

    // Método para buscar um item de compra por ID
    public ItemCompraDTO findById(long id) {
        ItemCompra itemCompra = itemCompraRepository.findById(id);
        if (itemCompra != null) {
            return new ItemCompraDTO(itemCompra.getItemcompraId(), 
            itemCompra.getProduto().getNome( ) ,itemCompra.getProduto().getPreco(), itemCompra.getQuantidade());
        }
        return null;
    }
}
