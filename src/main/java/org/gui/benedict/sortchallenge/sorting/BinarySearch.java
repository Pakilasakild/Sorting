package org.gui.benedict.sortchallenge.sorting;

import javafx.collections.ObservableList;
import org.gui.benedict.sortchallenge.SortController;


public class BinarySearch {

    static ObservableList<Integer> data = SortController.getData();
    public static String searchForNumber(int target){
        int low = 0;
        int high = data.size()-1;

        while(low <= high){
            int ix = (low + high) / 2;
            if (target == data.get(ix)){
                return target + " Found at " + (ix+1);
            }
            else if (target < data.get(ix)){
                high = ix - 1;
            }
            else {
                low = ix + 1;
            } // data
        }
        return "Target not found";
    }
}
