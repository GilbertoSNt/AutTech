module org.gsnt.auttech {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires java.sql;
    requires com.fasterxml.jackson.annotation;
    requires java.naming;
    requires com.fasterxml.jackson.databind;
    requires de.mkammerer.argon2.nolibs;

    opens org.gsnt.auttech to javafx.fxml, javafx.base, javafx.graphics;
    opens org.gsnt.auttech.model.entities to javafx.base;

    exports org.gsnt.auttech;
    exports org.gsnt.auttech.controller;
    opens org.gsnt.auttech.controller to javafx.fxml;
    opens org.gsnt.auttech.entitiesgenerics to javafx.base;
    exports org.gsnt.auttech.agenda;
    opens org.gsnt.auttech.agenda to javafx.base, javafx.fxml;
    exports org.gsnt.auttech.cliente;
    opens org.gsnt.auttech.cliente to javafx.base, javafx.fxml;
    exports org.gsnt.auttech.funcionario;
    opens org.gsnt.auttech.config.seg to javafx.base;
    exports org.gsnt.auttech.veiculo;
    opens org.gsnt.auttech.veiculo to javafx.base, javafx.fxml;
    exports org.gsnt.auttech.os;
    opens org.gsnt.auttech.os to javafx.base, javafx.fxml;
    exports org.gsnt.auttech.direcionamento;
    opens org.gsnt.auttech.direcionamento to javafx.base, javafx.fxml;
    opens org.gsnt.auttech.funcionario to javafx.base, javafx.fxml;
    opens org.gsnt.auttech.orcamento to javafx.base;
    opens org.gsnt.auttech.email to javafx.base;
    opens org.gsnt.auttech.endereco to javafx.base;
    opens org.gsnt.auttech.marca to javafx.base;
    opens org.gsnt.auttech.modelo to javafx.base;
    opens org.gsnt.auttech.status to javafx.base;
    opens org.gsnt.auttech.telefone to javafx.base;
}