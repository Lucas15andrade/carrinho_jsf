package beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import models.Carrinho;
import models.Produto;

@ManagedBean
@ApplicationScoped
public class Loja {

    List<Produto> listaProdutos;
    List<Carrinho> carrinho;

    Produto produto;
    Carrinho objetoCarrinho;

    int quantidade = 0;

    public Loja() {
        Produto p1 = new Produto(1, "Café", 15.50, "Café em pó", 10);
        Produto p2 = new Produto(2, "Pipoca", 3.00, "Milho de pipoca", 5);
        Produto p3 = new Produto(3, "Arroz", 5.50, "Simplesmente Arroz", 5);
        Produto p4 = new Produto(4, "Feijão", 6.50, "Simplesmente feijão", 7);
        /*
        Carrinho c1 = new Carrinho(p1, 2);
        Carrinho c2 = new Carrinho(p2, 1);
         */

        produto = new Produto();
        objetoCarrinho = new Carrinho(produto, ++quantidade);
        listaProdutos = new ArrayList<>();
        carrinho = new ArrayList<>();

        /*
        carrinho.add(c1);
        carrinho.add(c2);
         */
        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);

    }

    public void finalizarCarrinho(List<Carrinho> c) {
        for (Carrinho car : c) {
            for (Produto p : listaProdutos) {
                if (p.getId() == car.getProduto().getId()) {
                    p.decrementaEstoque(car.getQuantidade());
                }
            }
        }

        carrinho.clear();
    }

    public List<Carrinho> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Carrinho> carrinho) {
        this.carrinho = carrinho;
    }

    public Carrinho getObjetoCarrinho() {
        return objetoCarrinho;
    }

    public void setObjetoCarrinho(Carrinho objetoCarrinho) {
        this.objetoCarrinho = objetoCarrinho;
    }

    public void adicionarCarrinho(Produto p) {

        Carrinho cArray = null;
        int qtdCarrinho;

        if (p.getEstoque() <= 0) {
            //Pensei em mudar o tipo de retorno do método, e caso essa condição fosse verdadeira
            //ela retornaria "false" e na chamada do método no .xhtml dependendo do tipo de retorno
            //ele mostraria alguma mensagem.
        } else {
            for (Carrinho c : carrinho) {
                if (c.getProduto().getId() == p.getId()) {
                    //System.out.println("Já existe um produto com esse id");
                    cArray = c;
                    break;
                }
            }

            if (cArray != null) {
                qtdCarrinho = cArray.getQuantidade();
                carrinho.remove(cArray);
                objetoCarrinho = new Carrinho(p, ++qtdCarrinho);
                this.carrinho.add(objetoCarrinho); 
            } else {
                objetoCarrinho = new Carrinho(p, quantidade);
                this.carrinho.add(objetoCarrinho);
            }
        }
    }

    //Implementar posteriormente
    public void removerProduto(List<Carrinho> c){
        /*
        Carrinho carro = null;
        
        for (Carrinho car : c) {
            
        }
        */
    }
    public void cadastraProduto() {
        //Código para posterior adição de incrementação automática de ID.
        /*
        produto = new Produto();
        int id = 0;
        for (Produto lp : listaProdutos) {
            id = lp.getId();
        }
        id++;
        */
        this.listaProdutos.add(produto);
        //Teste Pedro
        produto = new Produto();
    }

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
