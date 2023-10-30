package com.ufpr.apiweb.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ufpr.apiweb.model.Compras;

@CrossOrigin
@RestController
public class ComprasREST {
    public static List<Compras> compraList = new ArrayList<>();

    @GetMapping("/compras")
    public List<Compras> getCompras() {
        return compraList;
    }

    @PostMapping("/compras")
    public Compras createCompra(@RequestBody Compras compra) {
        Compras compras = null;
		compraList.add(compras);
        return compras;
    }
}
