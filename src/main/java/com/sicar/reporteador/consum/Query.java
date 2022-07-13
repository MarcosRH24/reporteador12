/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicar.reporteador.consum;

/**
 *
 * @author marcos
 */
public class Query {

    private int id_query;
    private String funcionquery;
    private String query;

    public Query(int id_query, String funcionquery, String query) {
        this.id_query = id_query;
        this.funcionquery = funcionquery;
        this.query = query;
    }

    public int getId_query() {
        return id_query;
    }

    public void setId_query(int id_query) {
        this.id_query = id_query;
    }

    public String getFuncionquery() {
        return funcionquery;
    }

    public void setFuncionquery(String funcionquery) {
        this.funcionquery = funcionquery;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void separarJson() {
        System.out.println(String.format("", id_query, funcionquery, query));
    }
}
