package org.gsnt.auttech.util;

import org.gsnt.auttech.model.entities.MarcaVeiculo;

import java.util.ArrayList;
import java.util.List;

public class DadosCombos2 {

    public List marcaVeiculo(){

        List<MarcaVeiculo> list = new ArrayList<>();
        List<MarcaVeiculo> listLimpa = new ArrayList<>();

        list.add(new MarcaVeiculo(1,"AGURA",false));
        list.add(new MarcaVeiculo(2,"AGRALE",false));
        list.add(new MarcaVeiculo(3,"ALFA ROMEO",false));
        list.add(new MarcaVeiculo(4,"ASIA Motors",false));
        list.add(new MarcaVeiculo(5,"AUDI",true));
        list.add(new MarcaVeiculo(6,"BMW",true));
        list.add(new MarcaVeiculo(7,"CADILLAC",false));
        list.add(new MarcaVeiculo(8,"CHANGAN",false));
        list.add(new MarcaVeiculo(9,"CHERY",true));
        list.add(new MarcaVeiculo(10,"CHEVROLET",true));
        list.add(new MarcaVeiculo(11,"CHRYSLER",false));
        list.add(new MarcaVeiculo(12,"CITROEN",false));
        list.add(new MarcaVeiculo(13,"DAEWOO",false));
        list.add(new MarcaVeiculo(14,"DAIHATSU",false));
        list.add(new MarcaVeiculo(15,"DODGE",false));
        list.add(new MarcaVeiculo(16,"EFFA Motors",false));
        list.add(new MarcaVeiculo(17,"FIAT",true));
        list.add(new MarcaVeiculo(18,"FORD",true));
        list.add(new MarcaVeiculo(19,"GURGEL",false));
        list.add(new MarcaVeiculo(20,"HAFEI",false));
        list.add(new MarcaVeiculo(21,"HONDA",true));
        list.add(new MarcaVeiculo(22,"HUMMER",false));
        list.add(new MarcaVeiculo(23,"HYUNDAI",true));
        list.add(new MarcaVeiculo(24,"ISUZU",false));
        list.add(new MarcaVeiculo(25,"IVECO",false));
        list.add(new MarcaVeiculo(26,"JAC",true));
        list.add(new MarcaVeiculo(27,"JAGUAR",true));
        list.add(new MarcaVeiculo(28,"JEEP",true));
        list.add(new MarcaVeiculo(29,"JINBEI",false));
        list.add(new MarcaVeiculo(30,"KIA",true));
        list.add(new MarcaVeiculo(31,"LADA",false));
        list.add(new MarcaVeiculo(32,"LAND ROVER",true));
        list.add(new MarcaVeiculo(33,"LEXUS",false));
        list.add(new MarcaVeiculo(34,"LIFAN",false));
        list.add(new MarcaVeiculo(35,"LINCOLN",false));
        list.add(new MarcaVeiculo(36,"MAHINDRA",false));
        list.add(new MarcaVeiculo(37,"MAZDA",false));
        list.add(new MarcaVeiculo(38,"MERCEDES BENZ",true));
        list.add(new MarcaVeiculo(39,"MINI",true));
        list.add(new MarcaVeiculo(40,"MITSUBISHI",true));
        list.add(new MarcaVeiculo(41,"NISSAN",true));
        list.add(new MarcaVeiculo(42,"PEUGEOT",true));
        list.add(new MarcaVeiculo(43,"PORSCHE",true));
        list.add(new MarcaVeiculo(44,"RAM",true));
        list.add(new MarcaVeiculo(45,"RENAULT",true));
        list.add(new MarcaVeiculo(46,"SEAT",false));
        list.add(new MarcaVeiculo(47,"SMART",false));
        list.add(new MarcaVeiculo(48,"SSANGYONG",false));
        list.add(new MarcaVeiculo(49,"SUBARU",true));
        list.add(new MarcaVeiculo(50,"SUZUKI",true));
        list.add(new MarcaVeiculo(51,"TAC",false));
        list.add(new MarcaVeiculo(52,"TESLA",false));
        list.add(new MarcaVeiculo(53,"TOYOTA",true));
        list.add(new MarcaVeiculo(54,"TROLLER",false));
        list.add(new MarcaVeiculo(55,"VOLKSWAGEN",true));
        list.add(new MarcaVeiculo(56,"VOLVO",true));

        for(int z =0; z<=(list.size()-1);z++){

            if(list.get(z).getAtivo()){
                listLimpa.add(new MarcaVeiculo(list.get(z).getCod(), list.get(z).getMarcaVeiculo().toString(), list.get(z).getAtivo()));
            }

        }

        return listLimpa;

    }

}
