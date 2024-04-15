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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Azmary
 */
public class RecordPageFormController implements Initializable {

    @FXML
    private AnchorPane recordpage_mainForm;

    @FXML
    private TextField recordpage_search;

    @FXML
    private TableView<FinanceAccountsData> recordpage_tableView;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_faID;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_name;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_gender;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_mobileNumber;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_address;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_dateCreated;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_dateModified;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_dateDeleted;

    @FXML
    private TableColumn<FinanceAccountsData, String> recordpage_col_action;

//    DATABASE TOOLS
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;

    AlertMessage alert = new AlertMessage();

    public ObservableList<FinanceAccountsData> getFinanceAccountsRecordData() {

        ObservableList<FinanceAccountsData> listData = FXCollections.observableArrayList();
// RESTART RECORD PAGEFORM FXML IF YOU DIDNT SEE THE RECORDPAGEFORMCONTROLLER CLASS
        String selectData = "SELECT * FROM finance_accounts WHERE date_delete IS NULL AND administrator = '"
                + Data.administrator_id + "'";
        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(selectData);
            result = prepare.executeQuery();

            FinanceAccountsData pData;
//            PatientsData(Integer id, Integer patientID, String fullName, 
//            Long mobileNumber, String address, Date date
//            , Date dateModify, Date dateDelete)
            while (result.next()) {
                pData = new FinanceAccountsData(result.getInt("id"), result.getInt("finance_accounts_id"),
                        result.getString("full_name"), result.getString("gender"), result.getLong("mobile_number"),
                        result.getString("address"), result.getString("status"), result.getDate("date"),
                        result.getDate("date_modify"), result.getDate("date_delete"));
                listData.add(pData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<FinanceAccountsData> faRecordData;

    public void displayPatientsData() {
        faRecordData = getFinanceAccountsRecordData();

        recordpage_col_faID.setCellValueFactory(new PropertyValueFactory<>("faID"));
        recordpage_col_name.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        recordpage_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        recordpage_col_mobileNumber.setCellValueFactory(new PropertyValueFactory<>("mobileNumber"));
        recordpage_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        recordpage_col_dateCreated.setCellValueFactory(new PropertyValueFactory<>("date"));
        recordpage_col_dateModified.setCellValueFactory(new PropertyValueFactory<>("dateModify"));
        recordpage_col_dateDeleted.setCellValueFactory(new PropertyValueFactory<>("dateDelete"));

        recordpage_tableView.setItems(faRecordData);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayPatientsData();
    }

}
