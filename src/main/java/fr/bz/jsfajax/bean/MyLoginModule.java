package fr.bz.jsfajax.bean;


import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyLoginModule implements LoginModule {

    private CallbackHandler handler;
    private Subject subject;
    private UserPrincipal userPrincipal;
    private RolePrincipal rolePrincipal;
    private List<String> userGroups;
    private Map options;
    private Map sharedState;

    // Configurable option
    private boolean debug = false;

    // Logger used to output debug information
    private static final Logger logger = Logger.getLogger(MyLoginModule.class.getName());

    // User credentials
    private String username = null;
    private String password = null;

    private boolean isAuthenticated = false;
    private boolean commitSucceeded = false;

    /**
     * Constructor
     */
    public MyLoginModule() {
        super();
    }


    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {


        this.handler = callbackHandler;
        this.subject = subject;
        this.options = options;
        this.sharedState = sharedState;
        this.userGroups = new ArrayList<>();

       if ("true".equalsIgnoreCase((String) options.get("debug"))) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            logger.addHandler(consoleHandler);
            debug = true;
        }
    }

    /**
     * @return @throws LoginException
     */
    @Override
    public boolean login() throws LoginException {

        // If no handler is specified throw a error
        if (handler == null) {
            throw new LoginException("Error: no CallbackHandler available to recieve authentication information from the user");
        }
        // Declare the callbacks based on the JAAS spec
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("login");
        callbacks[1] = new PasswordCallback("password", true);
        try {
            //Handle the callback and recieve the sent inforamation
            handler.handle(callbacks);
            username = ((NameCallback) callbacks[0]).getName();
            password = String.valueOf(((PasswordCallback) callbacks[1]).getPassword());
            // Debug the username / password
            if (debug) {
                logger.log(Level.INFO, "Username: {0}", username);
                logger.log(Level.INFO, "Password: {0}", password);
            }
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                throw new LoginException("Data specified had null values");
            }

            if (username.equals("user") && password.equals("user")) {
                userGroups.add("user");
                isAuthenticated = true;
                return true;
            }
            if (username.equals("admin") && password.equals("admin")) {
                userGroups.add("user");
                userGroups.add("admin");
                isAuthenticated = true;
                return true;
            }

            throw new LoginException("Authentication failed");

        } catch (IOException | UnsupportedCallbackException e) {
            throw new LoginException(e.getMessage());
        }

    }

    /**
     * Adds the username / roles to the principal
     *
     * @return @throws LoginException
     */
    @Override
    public boolean commit() throws LoginException {

        if (!isAuthenticated) {
            return false;
        } else {

            userPrincipal = new UserPrincipal(username);
            subject.getPrincipals().add(userPrincipal);

            if (userGroups != null && userGroups.size() > 0) {
                for (String groupName : userGroups) {
                    rolePrincipal = new RolePrincipal(groupName);
                    subject.getPrincipals().add(rolePrincipal);
                }
            }

            commitSucceeded = true;

            return true;
        }
    }

    /**
     * Terminates the logged in session on error
     *
     * @return @throws LoginException
     */
    @Override
    public boolean abort() throws LoginException {
        if (!isAuthenticated)
            return false;
        if (isAuthenticated && !commitSucceeded) {
            isAuthenticated = false;
            username = null;
            password = null;
            userPrincipal = null;
        } else {
            logout();
        }
        return true;
    }

    /**
     * Logs the user out
     *
     * @return @throws LoginException
     */
    @Override
    public boolean logout() throws LoginException {
        isAuthenticated = false;
        isAuthenticated = commitSucceeded;
        subject.getPrincipals().clear();
        return true;
    }

}
