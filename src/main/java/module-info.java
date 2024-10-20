module com.advaned_java.com_bptn_quiz_app {
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
    requires com.jfoenix;
    requires mysql.connector.j;
    requires com.google.gson;
    requires java.sql;
    requires annotations;


    opens com_bptn_quiz_app to javafx.fxml;
    exports com_bptn_quiz_app;
    exports com_bptn_quiz_app.controllers;
    opens com_bptn_quiz_app.controllers to javafx.fxml;
    opens  com_bptn_quiz_app.models to com.google.gson;

}

