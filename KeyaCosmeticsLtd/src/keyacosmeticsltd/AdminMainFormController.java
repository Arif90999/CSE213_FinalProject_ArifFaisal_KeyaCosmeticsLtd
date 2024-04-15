/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package keyacosmeticsltd;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author Azmary
 */
public class AdminMainFormController implements Initializable {

    // GIVE NAME OF ALL COMPONENTS
    @FXML
    private AnchorPane main_form;

    @FXML
    private Circle top_profile;

    @FXML
    private Label top_username;

    @FXML
    private Label date_time;

    @FXML
    private Label current_form;

    @FXML
    private Label nav_adminID;

    @FXML
    private Label nav_username;

    @FXML
    private Button dashboard_btn;

    @FXML
    private Button administrator_btn;

    @FXML
    private Button finance_accounts_btn;

    @FXML
    private Button appointments_btn;

    @FXML
    private Button payment_btn;

    @FXML
    private Button profile_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private AnchorPane dashboard_AD;

    @FXML
    private AnchorPane dashboard_TP;

    @FXML
    private AnchorPane dashboard_AP;

    @FXML
    private AnchorPane dashboard_tA;

    @FXML
    private AreaChart<?, ?> dashboad_chart_PD;

    @FXML
    private BarChart<?, ?> dashboad_chart_DD;

    @FXML
    private TableView<?> dashboad_tableView;

    @FXML
    private TableColumn<?, ?> dashboad_col_administratorID;

    @FXML
    private TableColumn<?, ?> dashboad_col_name;

    @FXML
    private TableColumn<?, ?> dashboad_col_specialized;

    @FXML
    private TableColumn<?, ?> dashboad_col_status;

    @FXML
    private AnchorPane administrators_form;

    @FXML
    private TableColumn<?, ?> administrators_col_administratorID;

    @FXML
    private TableColumn<?, ?> administrators_col_name;

    @FXML
    private TableColumn<?, ?> administrators_col_gender;

    @FXML
    private TableColumn<?, ?> administrators_col_contactNumber;

    @FXML
    private TableColumn<?, ?> administrators_col_email;

    @FXML
    private TableColumn<?, ?> administrators_col_specialization;

    @FXML
    private TableColumn<?, ?> administrators_col_address;

    @FXML
    private TableColumn<?, ?> administrators_col_status;

    @FXML
    private TableColumn<?, ?> administrators_col_action;

    @FXML
    private AnchorPane FA_form;

    @FXML
    private TableView<?> FA_tableView;

    @FXML
    private TableColumn<?, ?> FA_col_FAID;

    @FXML
    private TableColumn<?, ?> FA_col_name;

    @FXML
    private TableColumn<?, ?> FA_col_gender;

    @FXML
    private TableColumn<?, ?> FA_col_contactNumber;

    @FXML
    private TableColumn<?, ?> FA_col_description;

    @FXML
    private TableColumn<?, ?> FA_col_date;

    @FXML
    private TableColumn<?, ?> FA_col_dateModify;

    @FXML
    private TableColumn<?, ?> FA_col_dateDelete;

    @FXML
    private TableColumn<?, ?> FA_col_status;

    @FXML
    private TableColumn<?, ?> FA_col_action;

    @FXML
    private AnchorPane appointments_form;

    @FXML
    private TableView<?> appointments_tableView;

    @FXML
    private TableColumn<?, ?> appointments_appointmentID;

    @FXML
    private TableColumn<?, ?> appointments_name;

    @FXML
    private TableColumn<?, ?> appointments_gender;

    @FXML
    private TableColumn<?, ?> appointments_contactNumber;

    @FXML
    private TableColumn<?, ?> appointments_description;

    @FXML
    private TableColumn<?, ?> appointments_date;

    @FXML
    private TableColumn<?, ?> appointments_dateModify;

    @FXML
    private TableColumn<?, ?> appointments_dateDelete;

    @FXML
    private TableColumn<?, ?> appointments_status;

    @FXML
    private TableColumn<?, ?> appointments_action;
    
    
    //    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            administrators_form.setVisible(false);
            FA_form.setVisible(false);
            appointments_form.setVisible(false);

        } else if (event.getSource() == administrator_btn) {
            dashboard_form.setVisible(false);
            administrators_form.setVisible(true);
            FA_form.setVisible(false);
            appointments_form.setVisible(false);

        } else if (event.getSource() == finance_accounts_btn) {
            dashboard_form.setVisible(false);
            administrators_form.setVisible(false);
            FA_form.setVisible(true);
            appointments_form.setVisible(false);

        } else if (event.getSource() == appointments_btn) {
            dashboard_form.setVisible(false);
            administrators_form.setVisible(false);
            FA_form.setVisible(false);
            appointments_form.setVisible(true);
        }
    }
    
    
    public void displayAdminIDUsername() {

        String sql = "SELECT * FROM admin WHERE username = '"
                + Data.admin_username + "'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {
                nav_adminID.setText(result.getString("admin_id"));
                String tempUsername = result.getString("username");
                tempUsername = tempUsername.substring(0, 1).toUpperCase() + tempUsername.substring(1); // TO SET THE FIRST LETTER TO UPPER CASE
                nav_username.setText(tempUsername);
                top_username.setText(tempUsername);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    

    public void runTime() {

        new Thread() {

            public void run() {
                SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
                while (true) {
                    try {

                        Thread.sleep(1000); // 1000 ms = 1s

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Platform.runLater(() -> {
                        date_time.setText(format.format(new Date()));
                    });
                }
            }
        }.start();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        runTime();
        displayAdminIDUsername();

    }

}
