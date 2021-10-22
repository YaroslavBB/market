package com.suitcase.market.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plastic extends Item{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, description;


    private String filenames = "";
    private String material, anons;

    private Integer count;
    private Integer salaryBig, salaryAverage, salarySmall;

    public Plastic() {

    }

    public Plastic(String name,
                   String description,
                   String material,
                   String anons,
                   Integer salaryBig,
                   Integer salaryAverage,
                   Integer salarySmall) {
        this.name = name;
        this.description = description;
        this.material = material;
        this.anons = anons;
        this.salaryBig = salaryBig;
        this.salaryAverage = salaryAverage;
        this.salarySmall = salarySmall;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getFilenames() {
        return filenames;
    }

    @Override
    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSalaryBig() {
        return salaryBig;
    }

    public void setSalaryBig(Integer salaryBig) {
        this.salaryBig = salaryBig;
    }

    public Integer getSalaryAverage() {
        return salaryAverage;
    }

    public void setSalaryAverage(Integer salaryAverage) {
        this.salaryAverage = salaryAverage;
    }

    public Integer getSalarySmall() {
        return salarySmall;
    }

    public void setSalarySmall(Integer salarySmall) {
        this.salarySmall = salarySmall;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }
}
