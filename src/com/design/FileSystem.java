package com.design;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    FileDirectory dir;
    boolean isStart;

    public FileSystem() {
        dir = new FileDirectory(-1);
        isStart = true;
    }

    public boolean createPath(String path, int value) {
        String[] pathArr = path.split("/");
        FileDirectory currentDir = dir;
        for (int i = 0; i < pathArr.length; i++) {
            String data = pathArr[i];
            FileDirectory child = currentDir.child.get(data);
            if (!isStart && child == null)
                return false;
            else if (isStart && child == null){
                child = new FileDirectory(-1);
            }
        }
        return true;
    }

    public int get(String path) {
        return -1;
    }
}

class FileDirectory {
    Map<String, FileDirectory> child;
    boolean isEnd = false;
    int value;

    public FileDirectory(int value) {
        child = new HashMap<>();
        this.value = value;
    }
}
