package hello.ngrest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.arnx.jsonic.JSON;
import users.MUser;

@RestController
public class NgRestUsers {

	@Autowired
    HttpSession session;

	@RequestMapping(value="/users", method=RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<MUser>> getUsers() {
		List<MUser> users = castToList(session.getAttribute("users"));
		if (users == null) {
			users = new ArrayList<MUser>();
			session.setAttribute("users", users);
		}

		HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache");

		System.out.println(JSON.encode(users));
		return new ResponseEntity<List<MUser>>(users, headers, HttpStatus.OK);
	}

	@RequestMapping(value="/users", method=RequestMethod.POST, produces = "application/json")
	public MUser setUserPOST(@RequestBody MUser user) {
		System.out.println(JSON.encode(user));
		List<MUser> users = castToList(session.getAttribute("users"));
		if (users == null) {
			users = new ArrayList<MUser>();
		}

		users.add(user);
		session.setAttribute("users", users);
		return user;
	}

	@SuppressWarnings("unchecked")
	private List<MUser> castToList(Object o) {
		return (List<MUser>)o;
	}
}
