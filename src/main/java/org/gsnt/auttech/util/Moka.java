package org.gsnt.auttech.util;

import org.gsnt.auttech.model.entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Moka {

    public List<Cliente> dadosListaClientes(){

        List<Cliente> list = new ArrayList<>();

        list.add(new Cliente(false, 1, "teste1", "teste11"));
        list.add(new Cliente(true, 2, "teste2", "teste22"));
        list.add(new Cliente(false, 3, "teste3", "teste33"));
        list.add(new Cliente(true, 4, "teste4", "teste44"));

        return list;
    }




}
