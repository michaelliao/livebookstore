package example.chapter8.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import example.chapter8.User;

public interface RmiUserService extends Remote {

    User login(String username, String password) throws RemoteException;

    void create(String username, String password) throws RemoteException;

}
