package Minerals;

import Controllers.Controller;
import Windows.MainFrame;

public class Main {

    public static void main(String[] args){
        new Controller().execute(new MainFrame("Склад"));

    }
}