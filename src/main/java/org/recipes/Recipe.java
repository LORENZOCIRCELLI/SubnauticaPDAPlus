package com.project.recipes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Recipe {
    // Getters e Setters
    public String name;
    public List<String> ingredients;
    public List<String> biomes;
    public String tip;

}