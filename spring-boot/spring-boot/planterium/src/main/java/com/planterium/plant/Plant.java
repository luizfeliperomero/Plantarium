package com.planterium.plant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "plant")
public class Plant {
    @Id
    private String id;
    private String name;
    private Timestamp last_time_watered;
    private Timestamp next_time_water;
    private DateOperators.Hour water_interval;
}
