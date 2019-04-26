package com.watson.observer.events.mouseevent;

public class MoustEventTest {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        MouseEventCallback callback = new MouseEventCallback();
        mouse.addLisenter(MouseEventType.ON_CLICK,callback);
        mouse.click();
    }
}
