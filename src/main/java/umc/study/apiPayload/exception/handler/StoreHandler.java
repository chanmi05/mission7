package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
