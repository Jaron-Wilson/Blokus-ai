package io.github.jaron.blokus.blokus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ShapeGenerator {
//    {"name": "1I", "shape": [[0,0]]},

    @JsonProperty("name")
    private String name;

    @JsonProperty("shape")
    private int[][] shape;
}
