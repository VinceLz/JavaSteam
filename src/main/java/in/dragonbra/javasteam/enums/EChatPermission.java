package in.dragonbra.javasteam.enums;

import java.util.Arrays;

public enum EChatPermission {

    Close(1),
    Invite(2),
    Talk(8),
    Kick(16),
    Mute(32),
    SetMetadata(64),
    ChangePermissions(128),
    Ban(256),
    ChangeAccess(512),
    EveryoneNotInClanDefault(Talk.code),
    EveryoneDefault(Talk.code | Invite.code),
    MemberDefault(Ban.code | Kick.code | Talk.code | Invite.code),
    OfficerDefault(Ban.code | Kick.code | Talk.code | Invite.code),
    OwnerDefault(ChangeAccess.code | Ban.code | SetMetadata.code | Mute.code | Kick.code | Talk.code | Invite.code | Close.code),
    Mask(1019),

    ;

    private final int code;

    EChatPermission(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public EChatPermission from(int code) {
        return Arrays.stream(EChatPermission.values()).filter(x -> x.code == code).findFirst().orElse(null);
    }
}