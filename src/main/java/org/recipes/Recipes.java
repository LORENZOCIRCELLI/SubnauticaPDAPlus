/*
Copyright (C) 2025 Lorenzo Circelli

         This program is free software: you can redistribute it and/or modify
         it under the terms of the GNU General Public License as published by
         the Free Software Foundation, version 3 of the license.
         This program is distributed in the hope that it will be useful,
         but WITHOUT ANY WARRANTY; without even the implied warranty of
         MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
         GNU General Public License for more details.

         You should have received a copy of the GNU General Public License
         along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/


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
