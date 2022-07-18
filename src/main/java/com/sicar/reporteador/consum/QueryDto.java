/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sicar.reporteador.consum;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.joda.time.LocalDateTime;


/**
 *
 * @author marcos
 */
public class QueryDto {

    private Long id_query;
    private String nombre;
    private String descripcion;
    private String query;
    
    private Date fecha;
    
    
    public QueryDto(Long id_query,String nombre, String descripcion, String query/*Date fecha*/) {
        this.id_query = id_query;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.query = query;
        //this.fecha = fecha;

    }

    public QueryDto() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Long getId_query() {
        return id_query;
    }

    public void setId_query(Long id_query) {
        this.id_query = id_query;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

    public void jsonSeparado(){
        System.out.println(String.format("este es el json"+ id_query,nombre,descripcion,query,fecha));
    }

    
    
    

    
}
