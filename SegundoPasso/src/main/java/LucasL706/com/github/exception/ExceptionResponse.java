package LucasL706.com.github.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {
}
