package com.timulys.board_back.common;

public interface ResponseCode {
    
    // Http Status 200
    String SUCCESS = "SU";

    // Http Status 400
    String VALIDATION_FAILED = "VF";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DM";
    String DUPLICATE_TEL_NUMBER = "DT";
    String NOT_EXISTED_USER = "NU";
    String NOT_EXISTED_BOARD = "NB";

    // Http Status 401
    String SIGN_IN_FAIL = "SF";
    String AUTHORIZATION_FAIL = "AF";
    
    // Http Status 403
    String NO_PERMISSION = "NP";

    // Http Status 500
    String DATABASE_ERROR = "DBE";
    
}
