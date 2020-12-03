package view;

import controller.Simulator;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        try {
            new Simulator();
        } catch (IOException ex) { }
    }
}
