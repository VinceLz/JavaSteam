package in.dragonbra.javasteam.steam.handlers.steamfriends.callback;

import in.dragonbra.javasteam.protobufs.steamclient.SteammessagesClientserverFriends.CMsgClientFriendsList;
import in.dragonbra.javasteam.steam.handlers.steamfriends.Friend;
import in.dragonbra.javasteam.steam.steamclient.callbackmgr.CallbackMsg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This callback is fired when the client receives a list of friends.
 */
public class FriendsListCallback extends CallbackMsg {
    private boolean incremental;

    private List<Friend> friendList;

    public FriendsListCallback(CMsgClientFriendsList.Builder msg) {
        incremental = msg.getBincremental();

        List<Friend> list = new ArrayList<>();
        for (CMsgClientFriendsList.Friend friend : msg.getFriendsList()) {
            list.add(new Friend(friend));
        }

        friendList = Collections.unmodifiableList(list);
    }

    public boolean isIncremental() {
        return incremental;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }
}
