package com.suitcase.market.modules;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LeatherBags  extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, description, material, anons;

    private String filenames = "";

    private Integer count, salary;

    public LeatherBags(String name, String description, String material, String anons, Integer salary) {
        this.name = name;
        this.description = description;
        this.material = material;
        this.anons = anons;
        this.salary = salary;
    }

    public LeatherBags() {
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getFilenames() {
        return filenames;
    }

    @Override
    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }
}
