package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    String id;
    String name;
    String apellidos;
    String fechaNacimiento;
    String correoElectronico;
    String contraseña;
    Double saldo;
    List<Articulo> listaComprados;

    public Cliente (String name, String apellidos, String fechaNacimiento, String correoElectronico, String contraseña){
        this.id= RandomUtils.getId();
        this.listaComprados = new ArrayList<>();
        this.saldo=50.0;
        this.name=name;
        this.apellidos=apellidos;
        this.fechaNacimiento=fechaNacimiento;
        this.correoElectronico=correoElectronico;
        this.contraseña=contraseña;
    }

    public String getNombre()
    {
        return this.name;
    }

    public void setNombre(String name)
    {
        this.name=name;

    }
    public String getApellidos()
    {
        return this.apellidos;
    }
    public void setApellidos(String apellidos)
    {
        this.apellidos=apellidos;

    }

    public void setFechaNacimiento(String fechaNacimiento)
    {
        this.fechaNacimiento=fechaNacimiento;

    }
    public String getFechaNacimiento()
    {
        return this.fechaNacimiento;
    }
    public void setCorreoElectronico(String correoElectronico)
    {
        this.correoElectronico=correoElectronico;

    }
    public String getCorreoElectronico()
    {
        return this.correoElectronico;
    }

    public void setContraseña(String contraseña)
    {
        this.contraseña=contraseña;

    }
    public String getContraseña()
    {
        return this.contraseña;
    }

    public void setSaldo(Double saldo)
    {
        this.saldo=saldo;

    }
    public Double getSaldo()
    {
        return this.saldo;
    }

    public void addArticuloLista (Articulo a)
    {
        this.listaComprados.add(a);
    }
    public List<Articulo> getListaComprados()
    {
        return listaComprados;
    }


}
