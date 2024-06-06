package SpringTag;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="User_SpringTag")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String userName;
	
	private String passWord;
	
	 @Lob
	 private byte[] profileImage; 
	 
	 private String base64ProfileImage;
	
	public User(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
    

    public String getBase64ProfileImage() {
        return base64ProfileImage;
    }

    public void setBase64ProfileImage(String base64ProfileImage) {
        this.base64ProfileImage = base64ProfileImage;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord +"]";
	}
    
    
}
