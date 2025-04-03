package org.gui.benedict.sortchallenge.sorting;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.gui.benedict.sortchallenge.SortController;

public class BubbleSort {

    public static ObservableList<Integer> onSelect (){
        ObservableList<Integer> data = FXCollections.observableArrayList(SortController.getData());
        for (int i = 0; i < data.size()-1; i++){
            for (int j = 0; j < data.size()-1; j++){
                if (data.get(j) > data.get(j+1)){
                    int temp = data.get(j+1);
                    data.set(j+1, data.get(j));
                    data.set(j, temp);
                }
            }
        }
        return data;
    }
}
