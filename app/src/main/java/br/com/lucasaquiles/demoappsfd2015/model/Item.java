package br.com.lucasaquiles.demoappsfd2015.model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by lucasaquiles on 9/14/15.
 */
public class Item implements Serializable{

    private Long id;
    private String nome;
    private String email;
    private String partido;
    private String uf;
    private String url_foto;
    private String total_despesas;
    private String total_votos;
    private String porcentagem_votos;
    private String situacao_candidatura;
    private Bitmap bitmap;

    public Bitmap getBitmap() {

       return this.bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public String getTotal_despesas() {
        return total_despesas;
    }

    public void setTotal_despesas(String total_despessas) {
        this.total_despesas = total_despessas;
    }

    public String getTotal_votos() {
        return total_votos;
    }

    public void setTotal_votos(String total_votos) {
        this.total_votos = total_votos;
    }

    public String getPorcentagem_votos() {
        return porcentagem_votos;
    }

    public void setPorcentagem_votos(String porcentagem_votos) {
        this.porcentagem_votos = porcentagem_votos;
    }

    public String getSituacao_candidatura() {
        return situacao_candidatura;
    }

    public void setSituacao_candidatura(String situacao_candidatura) {
        this.situacao_candidatura = situacao_candidatura;
    }

    public String getPartidoUFFormatado(){

        return getPartido() + " - "+getUf();
    }

    public String getSituacaoCandidaturaFormatado(){

        return getSituacao_candidatura() + "("+getPorcentagem_votos()+"% )";
    }

    @Override
    public String toString() {
        return this.nome;
    }


}
