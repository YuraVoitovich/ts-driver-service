package io.voitovich.yura.driverservice.dto.request;

import io.voitovich.yura.driverservice.validation.annotations.SortExclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

import java.util.UUID;


@Builder
public record DriverProfileUpdateRequest(
        @NotNull
        UUID id,

        @SortExclude
        @Pattern(regexp = "^\\+375(17|29|33|44)[0-9]{7}$")
        String phoneNumber,

        @NotBlank(message = "Name is mandatory")
        String name,

        @NotBlank(message = "Name is mandatory")
        String surname,

        @Min(0)
        int experience
) { }
