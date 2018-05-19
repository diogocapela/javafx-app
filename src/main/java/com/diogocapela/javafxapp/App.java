package com.diogocapela.javafxapp;

import com.diogocapela.javafxapp.utils.FxPage;
import com.diogocapela.javafxapp.utils.FxPageSwitcher;
import com.diogocapela.javafxapp.utils.FxView;
import com.diogocapela.javafxapp.models.Empresa;

import com.diogocapela.javafxapp.utils.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Arrays;

public class App extends Application {

    // Static variable for the singleton pattern.
    private static App appInstance = null;

    // Static variables for the JavaFX main components..
    private BorderPane mainPane = new BorderPane();

    private FxPageSwitcher pageSwitcher;

    @Override
    public void start(Stage stage) {

        Logger.log("App: start()");

        getAppInstance().pageSwitcher = new FxPageSwitcher(node -> mainPane.setCenter(node), Arrays.asList(
                new FxPage("dashboard", "DashboardView"),
                new FxPage("areasRestritas", "AreasRestritasView"),
                new FxPage("cartoes", "CartoesView"),
                new FxPage("colaboradores", "ColaboradoresView"),
                new FxPage("equipamentos", "EquipamentosView"),
                new FxPage("periodosAutorizacao", "PeriodosAutorizacaoView"),
                new FxPage("registarPerfil", "RegistarPerfilView"),
                new FxPage("acederAreaRestrita", "AcederAreaRestritaView"),
                new FxPage("logger", "LoggerView")
        ));

        Empresa.getInstance();

        Parent mainMenu = new FxView("Menu").get();
        mainPane.setTop(mainMenu);

        Scene scene = new Scene(mainPane, 1000, 700);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("javafx-boiler");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();

        getAppInstance().pageSwitcher.showPage("dashboard");

    }


    private static void hack() {

        int i = 14;
        String cenas =  i + "1;Segunda;9:00;12:00;1\n" +
                i + 1 + "2;Segunda;13:00;18:00;1\n" +
                "3;Terça;9:00;12:00;1\n" +
                "4;Terça;13:00;18:00;1\n" +
                "5;Quarta;9:00;12:00;1\n" +
                "6;Quarta;13:00;18:00;1\n" +
                "7;Quinta;9:00;12:00;1\n" +
                "8;Quinta;13:00;18:00;1\n" +
                "9;Sexta;9:00;12:00;1\n" +
                "10;Sexta;13:00;18:00;1\n" +
                "11;Sábado;9:00;12:00;1\n" +
                "12;Sábado;13:00;18:00;1\n" +
                "13;Domingo;9:00;12:00;1\n" +
                "14;Domingo;13:00;18:00;1";
    }

    /**
     * Returns a signleton instance of App.
     * Do not allow more than one instance of this class.
     **/
    private static App getAppInstance() {
        if (appInstance == null) {
            appInstance = new App();
        }
        return appInstance;
    }

    /**
     * Switches the view page on the mainPane.
     */
    public static void showPage(String page) {
        getAppInstance().pageSwitcher.showPage(page);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Logger.log("App: main()");
        launch(args);
    }

}
