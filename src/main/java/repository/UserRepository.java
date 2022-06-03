package repository;

import java.util.List;

public interface UserRepository {
    String findUserByEmail(String email);
    List<String> findAllEmails();
}
