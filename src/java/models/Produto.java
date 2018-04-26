package models;

public class Produto {
    
    private Integer id;
    private String nome;
    private Double preco;
    private String descricao;
    private int estoque;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco, String descricao, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    /*
    public Produto(String nome, Double preco, String descricao, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.estoque = estoque;
    }
    */
    
    
    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void decrementaEstoque(int quantidade){
        if(this.estoque <= 0){
           System.err.println("Estoque insuficiente");
        }else{
            this.estoque = this.estoque - quantidade;
        }
    }
    
}
