package com.tree.questions;

import com.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InOrderTraversalItr {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Data>> verticalData = new HashMap<>();
        inOrder(root, verticalData, 1, 0);
        List<Integer> keys = new ArrayList<>(verticalData.keySet());
        Collections.sort(keys);
        List<Integer> orders;
        for (Integer key : keys) {
            List<Data> values = verticalData.get(key);
            Collections.sort(values, cmp);
            orders = new ArrayList<>();
            for (Data d : values) {
                orders.add(d.val);
            }
            result.add(orders);
        }
        return result;
    }

    void inOrder(TreeNode root, Map<Integer, List<Data>> verticalData, int level, int vertical) {
        if (root == null)
            return;
        List<Data> existed = verticalData.getOrDefault(vertical, new ArrayList<Data>());
        Data d = new Data(root.getVal(), level);
        existed.add(d);
        verticalData.put(vertical, existed);
        inOrder(root.getLeft(), verticalData, level + 1, vertical - 1);
        inOrder(root.getRight(), verticalData, level + 1, vertical + 1);
    }

    Comparator<Data> cmp = new Comparator<Data>() {
        @Override
        public int compare(Data o1, Data o2) {
            if (o1.level == o2.level)
                return o1.val - o2.val;
            else
                return o1.level - o2.level;
        }
    };
}


class Data {
    int val;
    int level;

    public Data(int val, int level) {
        this.val = val;
        this.level = level;
    }
}