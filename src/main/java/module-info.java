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

    opens org.gsnt.auttech to javafx.fxml;
    exports org.gsnt.auttech;
    exports org.gsnt.auttech.controller;
    opens org.gsnt.auttech.controller to javafx.fxml;
}