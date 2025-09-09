package com.example.event_managment_service.Model;

import com.example.event_managment_service.Exception.EventCancelledException;
import com.example.event_managment_service.Exception.NotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum EventStatus {
    PLANNED (0,true), ONGOING(1,true), COMPLETED(2,true), CANCELLED(-1,false);

    private final Integer identifyPermission;
    private final boolean allowChanges;

    public static EventStatus fromIdentifyPermission(int identifyPermission){
        return Arrays.stream(values()).filter(s -> s.identifyPermission == identifyPermission)
                .findFirst()
                .orElseThrow(() -> new EventCancelledException("This Event is cancelled!"));
    }

}
