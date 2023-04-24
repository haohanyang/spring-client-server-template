package com.example.common;

import java.util.Date;

public record Todo(String thing, Date time, boolean finished) {
}
