package umc.study.apiPayload.exception.handler;

import umc.study.apiPayload.code.BaseErrorCode;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode baseErrorCode) {
        super(baseErrorCode);
    }
}
