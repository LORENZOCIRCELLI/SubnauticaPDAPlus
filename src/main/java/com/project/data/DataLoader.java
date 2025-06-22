package com.project.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.recipes.Recipe;
import com.project.recipes.Resource;
import com.project.recipes.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataLoader {
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Recipe> recipes;
    private List<Resource> resources;
    private List<Base> bases;

    public List<Recipe> loadRecipes() {
        try (InputStream is = getClass().getResourceAsStream("/recipes.json")) {
            if (is == null) {
                System.err.println("Erro: Arquivo /recipes.json não encontrado no classpath.");
                recipes = Collections.emptyList(); // Initialize to avoid null
                return recipes;
            }
            recipes = mapper.readValue(is, new TypeReference<List<Recipe>>() {});
            return recipes;
        } catch (Exception e) {
            System.err.println("Erro ao carregar receitas: " + e.getMessage());
            e.printStackTrace();
            recipes = Collections.emptyList();
            return recipes;
        }
    }

    public List<Resource> loadResources() {
        try (InputStream is = getClass().getResourceAsStream("/resources.json")) {
            if (is == null) {
                System.err.println("Erro: Arquivo /resources.json não encontrado no classpath.");
                resources = Collections.emptyList();
                return resources;
            }
            resources = mapper.readValue(is, new TypeReference<List<Resource>>() {});
            return resources;
        } catch (Exception e) {
            System.err.println("Erro ao carregar recursos: " + e.getMessage());
            e.printStackTrace();
            resources = Collections.emptyList();
            return resources;
        }
    }

    public List<Base> loadBases() {
        try (InputStream is = getClass().getResourceAsStream("/bases.json")) {
            if (is == null) {
                System.err.println("Erro: Arquivo /bases.json não encontrado no classpath.");
                bases = Collections.emptyList();
                return bases;
            }
            bases = mapper.readValue(is, new TypeReference<List<Base>>() {});
            return bases;
        } catch (Exception e) {
            System.err.println("Erro ao carregar bases: " + e.getMessage());
            e.printStackTrace();
            bases = Collections.emptyList();
            return bases;
        }
    }
}