package org.gsnt.auttech.util;

import javafx.collections.ObservableList;
import org.gsnt.auttech.model.entities.Estados;
import org.gsnt.auttech.model.entities.TipoEndereco;
import org.gsnt.auttech.model.entities.TipoTelefone;
import org.gsnt.auttech.model.entities.TiposEmail;
import org.gsnt.auttech.model.entities.PerfilFiscal;
import java.util.ArrayList;
import java.util.List;

public class DadosCombos {

    private ObservableList ObsMarca;



    public List perfilFiscal(){

        List<PerfilFiscal> list = new ArrayList<>();

        list.add(new PerfilFiscal(1,"Contribuinte"));
        list.add(new PerfilFiscal(2,"Não Contribuinte"));

        return list;

    }

    public List tipoEmail(){

        List<TiposEmail> list = new ArrayList<>();

        list.add(new TiposEmail(1,"Pessoal"));
        list.add(new TiposEmail(2,"Profissional"));
        list.add(new TiposEmail(3,"Compras"));
        list.add(new TiposEmail(4,"Comprador"));
        list.add(new TiposEmail(5,"Gestor"));
        list.add(new TiposEmail(6,"Orçamento"));
        list.add(new TiposEmail(7,"Vendas"));
        list.add(new TiposEmail(8,"Vendedor"));
        list.add(new TiposEmail(9,"NFe"));
        list.add(new TiposEmail(10,"Outros"));

        return list;

    }

    public List dadoEstados(){

        List<Estados> list = new ArrayList<>();

        list.add(new Estados(1, "AC - Acre"));
        list.add(new Estados(2, "AL - Alagoas"));
        list.add(new Estados(3, "AP - Amapá"));
        list.add(new Estados(4, "AM - Amazonas"));
        list.add(new Estados(5, "BA - Bahia"));
        list.add(new Estados(6, "CE - Ceará"));
        list.add(new Estados(7, "DF Dist. Federal"));
        list.add(new Estados(8, "ES - Esp. Santo"));
        list.add(new Estados(9, "GO - Goiás"));
        list.add(new Estados(10, "MA - Maranhão"));
        list.add(new Estados(11, "MT - Mato Grosso"));
        list.add(new Estados(12, "MS - Mato Grosso do Sul"));
        list.add(new Estados(13, "MG - Minas Gerais"));
        list.add(new Estados(14, "PA - Pará"));
        list.add(new Estados(15, "PB - Paraíba"));
        list.add(new Estados(16, "PR - Paraná"));
        list.add(new Estados(17, "PE - Pernambuco"));
        list.add(new Estados(18, "PI - Piauí"));
        list.add(new Estados(19, "RJ - Rio de Janeiro"));
        list.add(new Estados(20, "RN - Rio Grande do Norte"));
        list.add(new Estados(21, "RS - Rio Grande do Sul"));
        list.add(new Estados(22, "RO - Rondônia"));
        list.add(new Estados(23, "RR - Roraima"));
        list.add(new Estados(24, "SC - Santa Catarina"));
        list.add(new Estados(25, "SP - São Paulo"));
        list.add(new Estados(26, "SE - Sergipe"));
        list.add(new Estados(27, "TO - Tocantins"));

        return list;
    }

    public List tipoEndereco(){

        List<TipoEndereco> list = new ArrayList<>();

        list.add(new TipoEndereco(1,"Avenida"));
        list.add(new TipoEndereco(2,"Comunidade"));
        list.add(new TipoEndereco(3,"Corredor"));
        list.add(new TipoEndereco(4,"Distrito"));
        list.add(new TipoEndereco(5,"Estrada"));
        list.add(new TipoEndereco(6,"Parque"));
        list.add(new TipoEndereco(7,"Praça"));
        list.add(new TipoEndereco(8,"Rodovia"));
        list.add(new TipoEndereco(9,"Rua"));
        list.add(new TipoEndereco(10,"Servidão"));
        list.add(new TipoEndereco(11,"Travessa"));
        list.add(new TipoEndereco(12,"Viela"));

        return list;
    }

    public List tipoTelefone(){

        List<TipoTelefone> list = new ArrayList<>();

        list.add(new TipoTelefone(1, "Celular"));
        list.add(new TipoTelefone(2, "Residêncial(Fixo)"));
        list.add(new TipoTelefone(3, "Trabalho(Cel)"));
        list.add(new TipoTelefone(4, "Trabalho(Fixo)"));
        list.add(new TipoTelefone(5, "Esposa"));
        list.add(new TipoTelefone(6, "Filho(a)"));
        list.add(new TipoTelefone(7, "Parente"));

        return list;
    }

    public List tipoTelefoneJ(){

        List<TipoTelefone> list = new ArrayList<>();

        list.add(new TipoTelefone(1, "Empresa(Fixo)"));
        list.add(new TipoTelefone(2, "Setor Financeiro(Fixo)"));
        list.add(new TipoTelefone(3, "Gerente(Cel)"));
        list.add(new TipoTelefone(4, "Gerente(Fixo)"));
        list.add(new TipoTelefone(5, "Setor Orçamentos(Cel)"));
        list.add(new TipoTelefone(6, "Setor Orçamentos(Fixo)"));
        list.add(new TipoTelefone(7, "Condutor(Cel)"));
        list.add(new TipoTelefone(8, "Responsável(Cel)"));

        return list;
    }

}
