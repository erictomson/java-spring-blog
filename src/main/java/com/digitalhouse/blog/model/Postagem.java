package com.digitalhouse.blog.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

// Tornando a classe uma entidade gerenciavel
// Esta entidade se tornará uma tabela no database
@Entity
// Necessário serializar a classe para que os dados
// sejam trocadas de forma binária (e não objetos Java)
@Table(name="tb_blog_model")    // Definindo o nome da tabela
public class Postagem implements Serializable {

    // A cada instância, será gerado um identificador
    // único para a classe
    private static long serialVersionUID = 1L;

    // Definindo a chave primária (PK)
    @Id
    // Gerando a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="post_titulo")     // Determinando o nome da tabela
    @NotNull                        // Definindo como não nulo
    @Size (min=5,max=100)           // Limites mínimo e máximo de caracteres
    private String titulo;
    @Column(name="post_texto")      // Determinando o nome da tabela
    @NotNull                        // Definindo como não nulo
    @Size (min=5,max=500)           // Limites mínimo e máximo de caracteres
    private String texto;
    @Column(name="post_data")       // Determinando o nome da tabela
    @Temporal(TemporalType.TIMESTAMP)   // Insere a data atual
    private Date date = new java.sql.Date(System.currentTimeMillis());

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
