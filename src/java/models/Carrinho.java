
package models;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

//@ManagedBean
//@ApplicationScoped
public class Carrinho {
    
    private Produto produto;
    private int quantidade = 0;

    public Carrinho() {
    }

    public Carrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
