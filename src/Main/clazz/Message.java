package Main.clazz;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.enumator.TypeMessageEnum;
import static Main.enumator.TypeMessageEnum.LOGIN;
import static Main.enumator.TypeMessageEnum.LOGOUT;
import static Main.enumator.TypeMessageEnum.PRIVATE;
import static Main.enumator.TypeMessageEnum.PUBLIC;

import java.io.Serializable;

/**
 * @author Nelson Henrique
 */
public class Message implements Serializable {

    private String sender, receiver, textMessage;
    private TypeMessageEnum typeMessageEnum;

    public TypeMessageEnum getTypeMessageEnum() {
        return typeMessageEnum;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public Message(String sender, String receiver, String textMessage, TypeMessageEnum typeMessageEnum) {
        String msg = "";
        this.sender = sender;
        this.receiver = receiver;
        this.typeMessageEnum = typeMessageEnum;

        switch (this.typeMessageEnum) {
            case LOGIN:
                msg = "(" + sender + ") entro.";
                break;
            case LOGOUT:
                msg = "(" + sender + ") escribio.";
                break;
            case PUBLIC:
                msg = "(" + sender + ") escribio: " + textMessage;
                break;
            case PRIVATE:
                msg = "(" + sender + ") para (" + receiver + ") escribio: " + textMessage;
                break;
        }
        this.textMessage = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", textMessage='" + textMessage + '\'' +
                ", typeMessageEnum=" + typeMessageEnum +
                '}';
    }
}
