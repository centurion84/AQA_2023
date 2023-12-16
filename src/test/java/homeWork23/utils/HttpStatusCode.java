package homeWork23.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor

public enum HttpStatusCode {
    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404);

    private final int code;
}
