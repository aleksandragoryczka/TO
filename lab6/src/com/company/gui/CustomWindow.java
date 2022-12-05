package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Objects;

public class CustomWindow extends JPanel {
    private String string;

    public CustomWindow(String string){
        this.string = string;
    }

    public void setString(String string) {
        this.string = string;
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;


        StringBuilder individuals = new StringBuilder(string);
        individuals.deleteCharAt(0);
        individuals.deleteCharAt(individuals.lastIndexOf("]"));
        String [] splitedIndividuals = new String(individuals).split(",");

        StringBuilder ills = new StringBuilder();
        StringBuilder healthy = new StringBuilder();

        for(String single : splitedIndividuals){
            String[] trimmedStrings = single.trim().split("-");
            if(trimmedStrings[0].trim().equals("symptoms") || trimmedStrings[0].trim().equals("noSymptoms")){
                ills.append(trimmedStrings[1]);
                ills.append("-");
            }else{
                healthy.append(trimmedStrings[1]);
                healthy.append("-");
            }
        }
        if(healthy.length() != 0){
            healthy.deleteCharAt(healthy.lastIndexOf("-"));
            String[] healthyCords = new String(healthy).split("-");
            printPoints(g2d, healthyCords, Color.blue);
        }

        if(ills.length() != 0){
            ills.deleteCharAt(ills.lastIndexOf("-"));
            String []illsCords = new String(ills).split("-");
            printPoints(g2d, illsCords, Color.red);
        }

    }

    private void printPoints(Graphics2D g2d, String[] tCords, Color color){
        g2d.setColor(color);
        int xSize = 10;
        int ySize = 10;
        if(color.equals(Color.blue)){
            xSize = 5;
            ySize = 5;
        }

        for(String tCord: tCords){
            StringBuilder tCordsBuilder = new StringBuilder(tCord);
            if(tCordsBuilder.lastIndexOf("E") != -1){
                tCordsBuilder.deleteCharAt(tCordsBuilder.lastIndexOf("E"));
            }

            tCord = new String(tCordsBuilder);
            String[] cords = tCord.split(";");

            double x = 0;
            if(!Objects.equals(cords[0], "")){
                x = Double.parseDouble(cords[0]);
            }
            double y = 0;
            if(cords.length == 2){
                y = Double.parseDouble(cords[1]);
            }
            Ellipse2D.Double shape = new Ellipse2D.Double(x*20, y*20, xSize, ySize);
            g2d.draw(shape);
        }


    }



}
