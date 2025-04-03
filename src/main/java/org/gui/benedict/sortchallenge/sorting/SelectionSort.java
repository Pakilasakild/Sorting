package org.gui.benedict.sortchallenge.sorting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.gui.benedict.sortchallenge.SortController;

public class SelectionSort {

    public static ObservableList<Integer> onSelect (){
        ObservableList<Integer> data = FXCollections.observableArrayList(SortController.getData());
        for (int i = 0; i < data.size()-1; i++){
            for (int j = i+1; j < data.size(); j++){
                if (data.get(i) > data.get(j)){
                    int temp = data.get(i);
                    data.set(i, data.get(j));
                    data.set(j, temp);
                }
            }
        }
        return data;
    }
}
