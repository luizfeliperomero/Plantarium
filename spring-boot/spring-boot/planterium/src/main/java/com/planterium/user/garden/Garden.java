package com.planterium.user.garden;

import com.planterium.plant.Plant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "garden")
public class Garden {
    @Id
    private String id;
    private String latitude;
    private String longitude;
    private String name;
    private String photo;
    private List<Plant> plants;
}
