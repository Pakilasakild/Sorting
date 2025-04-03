package org.gui.benedict.sortchallenge;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.gui.benedict.sortchallenge.sorting.BinarySearch;
import org.gui.benedict.sortchallenge.sorting.BubbleSort;
import org.gui.benedict.sortchallenge.sorting.SelectionSort;

public class SortController {

    @FXML
    private static ObservableList<Integer> data = FXCollections.observableArrayList(5, 15, 4, 9, 47, 12, 13, 17, 89, 76, 2);
    @FXML
    private static ObservableList<Integer> updatedData = data;
    @FXML
    public TableView numbersTable;
    @FXML
    public TableColumn<Integer, Integer> numbersColumns;
    @FXML
    public Button applyButton;
    @FXML
    public RadioButton burbleSortSelection;
    @FXML
    public RadioButton selectionSortSelection;
    @FXML
    public RadioButton binarySearchSelection;
    @FXML
    public TextField searchField;
    @FXML
    public RadioButton scatterSortSelection;
    @FXML
    public Label binaryOutputField;
    @FXML
    public boolean isSorted = false;

    @FXML
    public static ObservableList<Integer> getData() {
        return updatedData;
    }

    @FXML
    public void initialize() {
        numbersTable.setItems(data);
        numbersColumns.setCellValueFactory(cellData -> new javafx.beans.property.SimpleObjectProperty<>(cellData.getValue()));
    }

    @FXML
    public void bubbleSort() {
        ObservableList<Integer> newData = FXCollections.observableArrayList(BubbleSort.onSelect());
        numbersTable.setItems(newData);
        numbersTable.refresh();
        isSorted = true;
        updatedData = newData;
    }

    @FXML
    public void selectionSort() {
        ObservableList<Integer> newData = FXCollections.observableArrayList(SelectionSort.onSelect());
        numbersTable.setItems(newData);
        numbersTable.refresh();
        isSorted = true;
        updatedData = newData;
    }

    @FXML
    public void onClickSearch() {
        if (isSorted) {
            if (binarySearchSelection.isSelected()) {
                binaryOutputField.setText(BinarySearch.searchForNumber(Integer.parseInt(searchField.getText().trim())));
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Select the binary search function");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Sort the table first");
            alert.showAndWait();
        }
    }

    @FXML
    public void scatterNumbers() {
        numbersTable.setItems(data);
        numbersTable.refresh();
        isSorted = false;
    }

}