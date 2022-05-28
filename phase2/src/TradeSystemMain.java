/*
 * Author: David
 * Description: Test Code trying out Browse
 */
import Account.*;
import Item.Inventory;
import Serializer.*;
import Trade.*;
import User_Controls.*;
import Account.Admin;
import Item.ItemRequest;
import Item.*;

import java.io.IOException;

public class TradeSystemMain {

    public static void main(String[] args) {

        Account a1 = new DemoUser("asdf","adsf","adsefr");
        System.out.println(a1.getName());
    }
}