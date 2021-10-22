package com.suitcase.market.modules;

import javax.persistence.*;

import java.util.Arrays;


public class Item {

    private String filenames = "";

    public Item() {
    }

    public String getIndexFilename(int index, String filenames) {
        String[] files = filenames.split("/");

        return files[index];

    }

//    public String getSalaryIdToString(int id, Integer salaryBig, Integer salaryAverage, Integer salarySmall) {
//        String finalSalary = "";
//        String salary = "";
//        int k = 0;
//        if (id == 0) {
//            salary = salaryBig.toString();
//        } else if (id == 1) {
//            salary = salaryAverage.toString();
//        } else if (id == 2) {
//            salary = salarySmall.toString();
//        }
//        for (int i = salary.length() - 1; i >= 0; i--) {
//            if (k != 3) {
//                finalSalary = salary.charAt(i) + finalSalary;
//                k++;
//            } else {
//                finalSalary = salary.charAt(i) + " " + finalSalary;
//                k = 0;
//            }
//        }
//
//        return finalSalary;
//    }

    public String getSalaryIdToString(Integer salaryInt) {
        String finalSalary = "";
        String salary = salaryInt.toString();
        int k = 0;

        for (int i = salary.length() - 1; i >= 0; i--) {

            if (k != 3) {
                finalSalary = salary.charAt(i) + finalSalary;
                k++;
            } else {
                finalSalary = salary.charAt(i) + " " + finalSalary;
                k = 0;
            }
        }

        return finalSalary;

    }

    public String descriptionToString(String description) {
        String finalDescript = "";
        String[] descrit = description.split("\r\n");

        for (int i = 0; i < descrit.length; i++) {
            finalDescript = finalDescript + descrit[i] + "<br>";
        }

        return finalDescript;
    }

    public String getFilenames() {
        return filenames;
    }

    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }


}



