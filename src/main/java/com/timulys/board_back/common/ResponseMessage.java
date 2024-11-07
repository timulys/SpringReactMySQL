package com.timulys.board_back.common;

public interface ResponseMessage {
    // Http Status 200
    String SUCCESS = "Success.";

    // Http Status 400
    String VALIDATION_FAILED = "Vaildation failed.";
    String DUPLICATE_EMAIL = "Duplicate email.";
    String DUPLICATE_NICKNAME = "Duplicate Nickname";
    String DUPLICATE_TEL_NUMBER = "Dulicate tel number.";
    String NOT_EXISTED_USER = "Not existed user.";
    String NOT_EXISTED_BOARD = "Not existed board.";

    // Http Status 401
    String SIGN_IN_FAIL = "Login information missmatch.";
    String AUTHORIZATION_FAIL = "Authorization failed.";
    
    // Http Status 403
    String NO_PERMISSION = "Do not have permission.";

    // Http Status 500
    String DATABASE_ERROR = "Database error.";
}
