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
public class Base {
    public String biome;
    public String progression;
    public String size;
    public List<String> structures;
    public String tip;

}