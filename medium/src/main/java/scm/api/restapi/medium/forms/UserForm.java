package scm.api.restapi.medium.forms;

import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scm.api.restapi.medium.persistence.entiry.Users;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class UserForm {

    final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    private Integer id;

    private String name;

    private String email;

    private String bio;

    private String password;
    
    private MultipartFile profile;

    String profileURL;

    private Date createdAt;

    private Date updatedAt;

    public UserForm(Users user) {
        this.id = user.getId();
        this.name = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.bio = user.getBio();
        this.profileURL = user.getProfile();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
    
    public String getPassword() {
        return passwordEncoder.encode(this.password);
    }
}
