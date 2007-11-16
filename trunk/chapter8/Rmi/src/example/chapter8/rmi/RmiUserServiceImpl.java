package example.chapter8.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import example.chapter8.User;
import example.chapter8.UserService;
import example.chapter8.UserServiceImpl;

public class RmiUserServiceImpl extends UnicastRemoteObject implements RmiUserService {

    UserService service = new UserServiceImpl();

    public RmiUserServiceImpl() throws RemoteException {}

    public void create(String username, String password) throws RemoteException {
        service.create(username, password);
    }

    public User login(String username, String password) throws RemoteException {
        return service.login(username, password);
    }

    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.bind("rmi://localhost:1099/UserService", new RmiUserServiceImpl());
    }
}
