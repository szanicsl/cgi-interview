package com.cgi.boat.interview;

import lombok.Data;
import lombok.NonNull;

@Data
class Person {
    @NonNull
    private final String firstName;
    @NonNull
    private final String lastName;
}
