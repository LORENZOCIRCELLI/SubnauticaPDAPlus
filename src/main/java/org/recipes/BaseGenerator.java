package com.project.recipes;

import com.project.data.DataLoader;

import java.util.ArrayList;
import java.util.List;

public class BaseGenerator {
    private List<Base> bases;

    public BaseGenerator(DataLoader dataLoader) {
        this.bases = dataLoader.loadBases();
    }


    public List<Base> generateBaseByArea(String biome) {
        List<Base> result = new ArrayList<>();
        for (Base base : bases) {
            if (base.getBiome().equalsIgnoreCase(biome)) {
                result.add(base);
            }
        }
        return result;
    }



}