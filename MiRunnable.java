package com.example.ejempohandler;

import android.os.Handler;
import android.os.Message;

public class MiRunnable implements Runnable {
    Handler h;
    MiRunnable(Handler h)
    {
        this.h=h;
    }
    @Override
    public void run() {

        for (int i=0; i<100; i++)
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message m=new Message();
            m.arg1=i;
            h.sendMessage(m);
        }
        Message m=new Message();
        m.obj="Fin de la cuenta";
        h.sendMessage(m);
    }
}
