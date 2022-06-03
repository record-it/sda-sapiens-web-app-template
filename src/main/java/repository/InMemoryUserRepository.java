package repository;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class InMemoryUserRepository implements UserRepository{
    private Map<String, String> users = new HashMap<>();

    public InMemoryUserRepository() {
        users.put("ada@sda.pl","Ada S");
        users.put("karol@sda.pl","Tomek Karolczak");
        users.put("ewa@sda.pl","Ewangelina T");
    }

    @Override
    public String findUserByEmail(String email) {
        return users.get(email);
    }

    @Override
    public List<String> findAllEmails() {
        return new ArrayList<>(users.keySet());
    }
}
