package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;

public class ReviewHandler extends GeneralException {
    public ReviewHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
