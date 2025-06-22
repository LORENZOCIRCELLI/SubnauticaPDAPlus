package com.project.recipes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Resource {
    // Getters e Setters
    public String name;
    public List<String> biomes;
    public List<String> tools;
    public String tip;

}