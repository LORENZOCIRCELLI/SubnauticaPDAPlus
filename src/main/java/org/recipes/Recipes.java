package org.recipes;
import org.materials.Resources;

import java.util.Map;

public class Recipes {

    private String name;
    private RecipeCategory category;
    private Map<Resources, Integer> resources;
    private String description;
    private String note;

    public Recipes(String name, RecipeCategory category, Map<Resources, Integer> resources, String description, String note) {

        this.name = name;
        this.category = category;
        this.resources = resources;
        this.description = description;
        this.note = note;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RecipeCategory getCategory() {
        return category;
    }

    public void setCategory(RecipeCategory category) {
        this.category = category;
    }

    public Map<Resources, Integer> getResources() {
        return resources;
    }

    public void setResources(Map<Resources, Integer> resources) {
        this.resources = resources;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
