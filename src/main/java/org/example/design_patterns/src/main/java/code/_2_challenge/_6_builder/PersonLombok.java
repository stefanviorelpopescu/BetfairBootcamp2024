package org.example.design_patterns.src.main.java.code._2_challenge._6_builder;

import lombok.Builder;

@Builder
public class PersonLombok {
    private String name;
    private String job;
    private String university;
    private String drivingLicense;
    private boolean isMarried;

}
