package pk.GradeBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pk.GradeBook.model.MyUserDetails;
import pk.GradeBook.model.User;
import pk.GradeBook.repository.UserRepository;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
       Optional<User> user = repo.findByLogin(login);

       user.orElseThrow(() -> new UsernameNotFoundException("Not found login: " + login));

       return user.map(MyUserDetails::new).get();
    }
}
