package com.nicolasmattar.demo.aop.core.model;

import java.util.Objects;

public class DemoObject {
    private Long id;
    private String nombre;

    public DemoObject(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DemoObject)) return false;
        DemoObject that = (DemoObject) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
