package com.sicar.reporteador.consum;

import com.mashape.unirest.http.HttpResponse;
import java.io.IOException;
import java.net.URI;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.http.client.HttpClient;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;



@Entity
@Table (name = "query")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_query;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "query")
    private String query;
    @DateTimeFormat
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Date fecha = Date.from(Instant.now());

    public Query(Long id, String nombre, String descripcion, String query,Date fecha) {
        this.id_query = null;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.query = query;
        this.fecha = fecha;
    }

    public Query() {
        
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

    public void jsonSeparado(){
        System.out.println(String.format("este es el json"+ id_query,nombre,descripcion,query,fecha));
    }
    
    
}
