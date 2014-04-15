package com.example.CC;

/**
 * Created by Syomin Stas on 4/13/14.
 */
public interface ServerCall {

    //интерфейс обратного вызова для клиента
    void refresh(String s);

    void callServer(String command);
}
