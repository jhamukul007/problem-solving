package com.design;

import java.util.Stack;

public class UndoRedoDesign {
    private Stack<String> undoStack;
    private Stack<String> redoStack;

    public UndoRedoDesign() {
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public void write(String s) {
        undoStack.push(s);
    }

    public String undo() {
        if (!undoStack.empty()) {
            String data = undoStack.pop();
            redoStack.push(data);
            return data;
        }
        return null;
    }

    public String redo() {
        if (!redoStack.empty()) {
            String data = redoStack.pop();
            undoStack.push(data);
            return data;
        }
        return null;
    }

    public static void main(String[] args) {
        UndoRedoDesign obj = new UndoRedoDesign();
        String s = "Mukul";
        obj.write(s);
        System.out.println(obj.undo());

        String s1 = "Mukul1";
        obj.write(s1);
        String s2 = "Mukul3";
        obj.write(s2);
        System.out.println(obj.undo());
        System.out.println(obj.undo());
        System.out.println(obj.redo());
        System.out.println(obj.redo());
        System.out.println(obj.redo());
        System.out.println(obj.redo());
        String s3 = "Mukul4";

    }
}
