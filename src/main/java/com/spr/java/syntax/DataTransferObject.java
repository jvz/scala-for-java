package com.spr.java.syntax;

import java.util.UUID;

import lombok.Data;

/**
 * Demonstrates a typical DTO using Lombok.
 */
@Data
public class DataTransferObject {
    private UUID id;
    private String name;
    private long version;
}
